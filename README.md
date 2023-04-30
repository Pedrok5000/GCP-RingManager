# ring manager project

This document aims to explain some of the decisions made during system architecture, as well as the steps needed to run the various applications and discuss the functionality of adding new kvServers to the ring.

**Note:** In the implementation it is assumed that there are only three kvServers without the possibility of increasing their number and only blocking stubs are used in order to simplify the implementation.

## Ring Manager:

The ring manager application always starts on port 8000 at a given IP address (depends on the VM on which the application runs) and implements two services: `RegisterServiceImpl` and `GetServerServiceImpl`.

The `RegisterServiceImpl` service concerns the communication between kvServer and the ring manager, that is, it implements the contract that has the operation of registering kvServer in the ring manager, the operation for kvServer to obtain its successor and the operation to inform the failure of kvServer successor to ring manager. All these operations need to access the ring's information and for that there is the `RingInfo` class that keeps a list with the kvServers as well as the number of kvServers that the ring supports (in this implementation N = 3).

The operations themselves have to ensure that there are no concurrency issues, for example when adding servers to the list. To this end, the operations have the keyword `synchronized` which guarantees that only one gRPC thread changes the list of servers at any given time.

The `GetServerServiceImpl` service implements the contract concerning the client and the ring manager. It only has one operation, obtaining a kvServer. As requested in the statement, the ring manager uses a Round Robin distribution to respond to the client who wants to obtain a kvServer. As previously mentioned, there is a list that is populated when kvServers are registered and each time a client makes a request to the ring manager, a server is returned that is found in an index that the ring manager maintains.

**Usage:** `java -jar RingManagerApp-1.0-SNAPSHOT-jar-with-dependencies.jar`

## kvServer:

When running the kvServer application, a registration request is made to the ring manager and a confirmation is received in response. After that, a new request is made to obtain a successor. If the ring is still not formed (less than 3 kvServers registered) it resends that same request every 10 seconds until it receives a response (meaning that the ring has been formed).
This is not the best way to fulfill the requirement that the manager only send the successor to the registered kvServer after the ring is formed, as it uses many unnecessary requests and is not a scalable solution. A more elegant way to fulfill this requirement would be through the use of java futures.

The kvServer application, like the ring manager, implements two services, `BaseServiceImpl` and `RingServiceImpl`. The first concerns the contract between the client and kvServer, implementing the writeUpdate and read operations that can be invoked by the client. The second service is related to the communication between the kvServers that make up the ring, implementing writeNext and readNext operations.
The code relating to these operations is extensive and could be factored into a future implementation. There are quite a few comments, but in short, writeUpdate writes the KeyValue pair locally and then tries to propagate the request to its successor. The successor will do the same. If it fails to get a response from the successor, kvServer informs the ring manager and gets a new successor as a response. The write is then propagated to the new successor.
The read operation follows the same logic, but instead of writing the KeyValue pair, it just tries to read the value corresponding to the key received in the request.

The previously mentioned read and write propagation is implemented in `RingServiceImpl` by readNext and writeNext operations. The server that receives a request from a client creates a request in which it puts its information (IP address and port) and sends this request to its successor. The successor verifies that the information of the server that initiated the request is its own and if not, it propagates the request forward. The reason why we do the check when receiving the order instead of before sending it to the successor relates to the need to check if the successor is active or not.
Successor failure is detected when trying to create a channel between a kvServer and its successor. If an exception is thrown, we resort to the failInform operation mentioned in the ring manager.

**Note:** When running the kvServer application it is assumed that there is a Docker container running a [REDIS](https://redis.io/) image on the same machine as the kvServer.

**Usage:** `java -jar KvServerApp-1.0-SNAPSHOT-jar-with-dependencies.jar <kvServer IP> <kvServer Port> <ring manager IP> <REDIS Port>`

## Client:

The client application is very simple, when running it connects to the ring manager and if the ring is formed, it makes a request to obtain a kvServer. Following the logic of kvServer registration in the ring manager, if the ring is not formed, the client makes a request every 10 seconds to obtain the kvServer. With a response to the previous request, the client connects to the kvServer and a menu is presented with options for writing a KeyValue pair, for reading a value or for terminating the application.
The write operation asks the user to insert a value in JSON format and a random hash is generated as a key. This value can be consulted later through the reading operation that receives the previously generated hash as a parameter.

In this implementation, the assumption is made that each client only communicates with one and only one kvServer, making it impossible to switch to another server without restarting the client application.

**Usage:** `java -jar ClientApp-1.0-SNAPSHOT-jar-with-dependencies.jar <ring manager IP>`
