package clientToKvServer;

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
    comments = "Source: BaseService.proto")
public final class BaseServiceGrpc {

  private BaseServiceGrpc() {}

  public static final String SERVICE_NAME = "baseservice.BaseService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<clientToKvServer.KeyValue,
      clientToKvServer.Reply> getWriteUpdateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "writeUpdate",
      requestType = clientToKvServer.KeyValue.class,
      responseType = clientToKvServer.Reply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<clientToKvServer.KeyValue,
      clientToKvServer.Reply> getWriteUpdateMethod() {
    io.grpc.MethodDescriptor<clientToKvServer.KeyValue, clientToKvServer.Reply> getWriteUpdateMethod;
    if ((getWriteUpdateMethod = BaseServiceGrpc.getWriteUpdateMethod) == null) {
      synchronized (BaseServiceGrpc.class) {
        if ((getWriteUpdateMethod = BaseServiceGrpc.getWriteUpdateMethod) == null) {
          BaseServiceGrpc.getWriteUpdateMethod = getWriteUpdateMethod =
              io.grpc.MethodDescriptor.<clientToKvServer.KeyValue, clientToKvServer.Reply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "writeUpdate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  clientToKvServer.KeyValue.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  clientToKvServer.Reply.getDefaultInstance()))
              .setSchemaDescriptor(new BaseServiceMethodDescriptorSupplier("writeUpdate"))
              .build();
        }
      }
    }
    return getWriteUpdateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<clientToKvServer.Key,
      clientToKvServer.Value> getReadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "read",
      requestType = clientToKvServer.Key.class,
      responseType = clientToKvServer.Value.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<clientToKvServer.Key,
      clientToKvServer.Value> getReadMethod() {
    io.grpc.MethodDescriptor<clientToKvServer.Key, clientToKvServer.Value> getReadMethod;
    if ((getReadMethod = BaseServiceGrpc.getReadMethod) == null) {
      synchronized (BaseServiceGrpc.class) {
        if ((getReadMethod = BaseServiceGrpc.getReadMethod) == null) {
          BaseServiceGrpc.getReadMethod = getReadMethod =
              io.grpc.MethodDescriptor.<clientToKvServer.Key, clientToKvServer.Value>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "read"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  clientToKvServer.Key.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  clientToKvServer.Value.getDefaultInstance()))
              .setSchemaDescriptor(new BaseServiceMethodDescriptorSupplier("read"))
              .build();
        }
      }
    }
    return getReadMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BaseServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BaseServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BaseServiceStub>() {
        @java.lang.Override
        public BaseServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BaseServiceStub(channel, callOptions);
        }
      };
    return BaseServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BaseServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BaseServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BaseServiceBlockingStub>() {
        @java.lang.Override
        public BaseServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BaseServiceBlockingStub(channel, callOptions);
        }
      };
    return BaseServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BaseServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BaseServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BaseServiceFutureStub>() {
        @java.lang.Override
        public BaseServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BaseServiceFutureStub(channel, callOptions);
        }
      };
    return BaseServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class BaseServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void writeUpdate(clientToKvServer.KeyValue request,
        io.grpc.stub.StreamObserver<clientToKvServer.Reply> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteUpdateMethod(), responseObserver);
    }

    /**
     */
    public void read(clientToKvServer.Key request,
        io.grpc.stub.StreamObserver<clientToKvServer.Value> responseObserver) {
      asyncUnimplementedUnaryCall(getReadMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getWriteUpdateMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                clientToKvServer.KeyValue,
                clientToKvServer.Reply>(
                  this, METHODID_WRITE_UPDATE)))
          .addMethod(
            getReadMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                clientToKvServer.Key,
                clientToKvServer.Value>(
                  this, METHODID_READ)))
          .build();
    }
  }

  /**
   */
  public static final class BaseServiceStub extends io.grpc.stub.AbstractAsyncStub<BaseServiceStub> {
    private BaseServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BaseServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BaseServiceStub(channel, callOptions);
    }

    /**
     */
    public void writeUpdate(clientToKvServer.KeyValue request,
        io.grpc.stub.StreamObserver<clientToKvServer.Reply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteUpdateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void read(clientToKvServer.Key request,
        io.grpc.stub.StreamObserver<clientToKvServer.Value> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class BaseServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<BaseServiceBlockingStub> {
    private BaseServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BaseServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BaseServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public clientToKvServer.Reply writeUpdate(clientToKvServer.KeyValue request) {
      return blockingUnaryCall(
          getChannel(), getWriteUpdateMethod(), getCallOptions(), request);
    }

    /**
     */
    public clientToKvServer.Value read(clientToKvServer.Key request) {
      return blockingUnaryCall(
          getChannel(), getReadMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class BaseServiceFutureStub extends io.grpc.stub.AbstractFutureStub<BaseServiceFutureStub> {
    private BaseServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BaseServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BaseServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<clientToKvServer.Reply> writeUpdate(
        clientToKvServer.KeyValue request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteUpdateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<clientToKvServer.Value> read(
        clientToKvServer.Key request) {
      return futureUnaryCall(
          getChannel().newCall(getReadMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_WRITE_UPDATE = 0;
  private static final int METHODID_READ = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BaseServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BaseServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_WRITE_UPDATE:
          serviceImpl.writeUpdate((clientToKvServer.KeyValue) request,
              (io.grpc.stub.StreamObserver<clientToKvServer.Reply>) responseObserver);
          break;
        case METHODID_READ:
          serviceImpl.read((clientToKvServer.Key) request,
              (io.grpc.stub.StreamObserver<clientToKvServer.Value>) responseObserver);
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

  private static abstract class BaseServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BaseServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return clientToKvServer.BaseServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BaseService");
    }
  }

  private static final class BaseServiceFileDescriptorSupplier
      extends BaseServiceBaseDescriptorSupplier {
    BaseServiceFileDescriptorSupplier() {}
  }

  private static final class BaseServiceMethodDescriptorSupplier
      extends BaseServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BaseServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (BaseServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BaseServiceFileDescriptorSupplier())
              .addMethod(getWriteUpdateMethod())
              .addMethod(getReadMethod())
              .build();
        }
      }
    }
    return result;
  }
}
