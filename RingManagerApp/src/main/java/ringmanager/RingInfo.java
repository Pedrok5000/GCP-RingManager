package ringmanager;

import java.util.LinkedList;

public class RingInfo {

    private int nKvServers;

    private LinkedList<String> kvServersList;

    public RingInfo(int nKvServers) {
        this.nKvServers = nKvServers;
        this.kvServersList = new LinkedList<>();
    }

    public void addServerToList(String server) {
        kvServersList.add(server);
    }

    public int getNumberOfServers() {
        return kvServersList.size();
    }

    public LinkedList<String> getListOfServers() {
        return kvServersList;
    }

    public int getNkvServers() {
        return nKvServers;
    }

    public void decrementNkvServer() {
        --nKvServers;
    }

}
