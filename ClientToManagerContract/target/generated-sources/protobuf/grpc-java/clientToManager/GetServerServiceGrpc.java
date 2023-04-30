package clientToManager;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.28.1)",
    comments = "Source: GetServerService.proto")
public final class GetServerServiceGrpc {

  private GetServerServiceGrpc() {}

  public static final String SERVICE_NAME = "getserverservice.GetServerService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<clientToManager.Void,
      clientToManager.ServerInfo> getGetKvServerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getKvServer",
      requestType = clientToManager.Void.class,
      responseType = clientToManager.ServerInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<clientToManager.Void,
      clientToManager.ServerInfo> getGetKvServerMethod() {
    io.grpc.MethodDescriptor<clientToManager.Void, clientToManager.ServerInfo> getGetKvServerMethod;
    if ((getGetKvServerMethod = GetServerServiceGrpc.getGetKvServerMethod) == null) {
      synchronized (GetServerServiceGrpc.class) {
        if ((getGetKvServerMethod = GetServerServiceGrpc.getGetKvServerMethod) == null) {
          GetServerServiceGrpc.getGetKvServerMethod = getGetKvServerMethod =
              io.grpc.MethodDescriptor.<clientToManager.Void, clientToManager.ServerInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getKvServer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  clientToManager.Void.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  clientToManager.ServerInfo.getDefaultInstance()))
              .setSchemaDescriptor(new GetServerServiceMethodDescriptorSupplier("getKvServer"))
              .build();
        }
      }
    }
    return getGetKvServerMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GetServerServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GetServerServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GetServerServiceStub>() {
        @java.lang.Override
        public GetServerServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GetServerServiceStub(channel, callOptions);
        }
      };
    return GetServerServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GetServerServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GetServerServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GetServerServiceBlockingStub>() {
        @java.lang.Override
        public GetServerServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GetServerServiceBlockingStub(channel, callOptions);
        }
      };
    return GetServerServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GetServerServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GetServerServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GetServerServiceFutureStub>() {
        @java.lang.Override
        public GetServerServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GetServerServiceFutureStub(channel, callOptions);
        }
      };
    return GetServerServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class GetServerServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getKvServer(clientToManager.Void request,
        io.grpc.stub.StreamObserver<clientToManager.ServerInfo> responseObserver) {
      asyncUnimplementedUnaryCall(getGetKvServerMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetKvServerMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                clientToManager.Void,
                clientToManager.ServerInfo>(
                  this, METHODID_GET_KV_SERVER)))
          .build();
    }
  }

  /**
   */
  public static final class GetServerServiceStub extends io.grpc.stub.AbstractAsyncStub<GetServerServiceStub> {
    private GetServerServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GetServerServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GetServerServiceStub(channel, callOptions);
    }

    /**
     */
    public void getKvServer(clientToManager.Void request,
        io.grpc.stub.StreamObserver<clientToManager.ServerInfo> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetKvServerMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class GetServerServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<GetServerServiceBlockingStub> {
    private GetServerServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GetServerServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GetServerServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public clientToManager.ServerInfo getKvServer(clientToManager.Void request) {
      return blockingUnaryCall(
          getChannel(), getGetKvServerMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class GetServerServiceFutureStub extends io.grpc.stub.AbstractFutureStub<GetServerServiceFutureStub> {
    private GetServerServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GetServerServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GetServerServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<clientToManager.ServerInfo> getKvServer(
        clientToManager.Void request) {
      return futureUnaryCall(
          getChannel().newCall(getGetKvServerMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_KV_SERVER = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GetServerServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GetServerServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_KV_SERVER:
          serviceImpl.getKvServer((clientToManager.Void) request,
              (io.grpc.stub.StreamObserver<clientToManager.ServerInfo>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class GetServerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GetServerServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return clientToManager.GetServerServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GetServerService");
    }
  }

  private static final class GetServerServiceFileDescriptorSupplier
      extends GetServerServiceBaseDescriptorSupplier {
    GetServerServiceFileDescriptorSupplier() {}
  }

  private static final class GetServerServiceMethodDescriptorSupplier
      extends GetServerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    GetServerServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (GetServerServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GetServerServiceFileDescriptorSupplier())
              .addMethod(getGetKvServerMethod())
              .build();
        }
      }
    }
    return result;
  }
}
