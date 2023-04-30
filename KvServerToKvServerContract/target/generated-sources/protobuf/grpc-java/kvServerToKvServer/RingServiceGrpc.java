package kvServerToKvServer;

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
    comments = "Source: RingService.proto")
public final class RingServiceGrpc {

  private RingServiceGrpc() {}

  public static final String SERVICE_NAME = "ringservice.RingService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<kvServerToKvServer.WriteRequest,
      kvServerToKvServer.Reply> getWriteNextMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "writeNext",
      requestType = kvServerToKvServer.WriteRequest.class,
      responseType = kvServerToKvServer.Reply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<kvServerToKvServer.WriteRequest,
      kvServerToKvServer.Reply> getWriteNextMethod() {
    io.grpc.MethodDescriptor<kvServerToKvServer.WriteRequest, kvServerToKvServer.Reply> getWriteNextMethod;
    if ((getWriteNextMethod = RingServiceGrpc.getWriteNextMethod) == null) {
      synchronized (RingServiceGrpc.class) {
        if ((getWriteNextMethod = RingServiceGrpc.getWriteNextMethod) == null) {
          RingServiceGrpc.getWriteNextMethod = getWriteNextMethod =
              io.grpc.MethodDescriptor.<kvServerToKvServer.WriteRequest, kvServerToKvServer.Reply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "writeNext"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  kvServerToKvServer.WriteRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  kvServerToKvServer.Reply.getDefaultInstance()))
              .setSchemaDescriptor(new RingServiceMethodDescriptorSupplier("writeNext"))
              .build();
        }
      }
    }
    return getWriteNextMethod;
  }

  private static volatile io.grpc.MethodDescriptor<kvServerToKvServer.ReadRequest,
      kvServerToKvServer.Result> getReadNextMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "readNext",
      requestType = kvServerToKvServer.ReadRequest.class,
      responseType = kvServerToKvServer.Result.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<kvServerToKvServer.ReadRequest,
      kvServerToKvServer.Result> getReadNextMethod() {
    io.grpc.MethodDescriptor<kvServerToKvServer.ReadRequest, kvServerToKvServer.Result> getReadNextMethod;
    if ((getReadNextMethod = RingServiceGrpc.getReadNextMethod) == null) {
      synchronized (RingServiceGrpc.class) {
        if ((getReadNextMethod = RingServiceGrpc.getReadNextMethod) == null) {
          RingServiceGrpc.getReadNextMethod = getReadNextMethod =
              io.grpc.MethodDescriptor.<kvServerToKvServer.ReadRequest, kvServerToKvServer.Result>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "readNext"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  kvServerToKvServer.ReadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  kvServerToKvServer.Result.getDefaultInstance()))
              .setSchemaDescriptor(new RingServiceMethodDescriptorSupplier("readNext"))
              .build();
        }
      }
    }
    return getReadNextMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RingServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RingServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RingServiceStub>() {
        @java.lang.Override
        public RingServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RingServiceStub(channel, callOptions);
        }
      };
    return RingServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RingServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RingServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RingServiceBlockingStub>() {
        @java.lang.Override
        public RingServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RingServiceBlockingStub(channel, callOptions);
        }
      };
    return RingServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RingServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RingServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RingServiceFutureStub>() {
        @java.lang.Override
        public RingServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RingServiceFutureStub(channel, callOptions);
        }
      };
    return RingServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class RingServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void writeNext(kvServerToKvServer.WriteRequest request,
        io.grpc.stub.StreamObserver<kvServerToKvServer.Reply> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteNextMethod(), responseObserver);
    }

    /**
     */
    public void readNext(kvServerToKvServer.ReadRequest request,
        io.grpc.stub.StreamObserver<kvServerToKvServer.Result> responseObserver) {
      asyncUnimplementedUnaryCall(getReadNextMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getWriteNextMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                kvServerToKvServer.WriteRequest,
                kvServerToKvServer.Reply>(
                  this, METHODID_WRITE_NEXT)))
          .addMethod(
            getReadNextMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                kvServerToKvServer.ReadRequest,
                kvServerToKvServer.Result>(
                  this, METHODID_READ_NEXT)))
          .build();
    }
  }

  /**
   */
  public static final class RingServiceStub extends io.grpc.stub.AbstractAsyncStub<RingServiceStub> {
    private RingServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RingServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RingServiceStub(channel, callOptions);
    }

    /**
     */
    public void writeNext(kvServerToKvServer.WriteRequest request,
        io.grpc.stub.StreamObserver<kvServerToKvServer.Reply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteNextMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readNext(kvServerToKvServer.ReadRequest request,
        io.grpc.stub.StreamObserver<kvServerToKvServer.Result> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadNextMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class RingServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<RingServiceBlockingStub> {
    private RingServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RingServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RingServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public kvServerToKvServer.Reply writeNext(kvServerToKvServer.WriteRequest request) {
      return blockingUnaryCall(
          getChannel(), getWriteNextMethod(), getCallOptions(), request);
    }

    /**
     */
    public kvServerToKvServer.Result readNext(kvServerToKvServer.ReadRequest request) {
      return blockingUnaryCall(
          getChannel(), getReadNextMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RingServiceFutureStub extends io.grpc.stub.AbstractFutureStub<RingServiceFutureStub> {
    private RingServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RingServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RingServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<kvServerToKvServer.Reply> writeNext(
        kvServerToKvServer.WriteRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteNextMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<kvServerToKvServer.Result> readNext(
        kvServerToKvServer.ReadRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getReadNextMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_WRITE_NEXT = 0;
  private static final int METHODID_READ_NEXT = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RingServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RingServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_WRITE_NEXT:
          serviceImpl.writeNext((kvServerToKvServer.WriteRequest) request,
              (io.grpc.stub.StreamObserver<kvServerToKvServer.Reply>) responseObserver);
          break;
        case METHODID_READ_NEXT:
          serviceImpl.readNext((kvServerToKvServer.ReadRequest) request,
              (io.grpc.stub.StreamObserver<kvServerToKvServer.Result>) responseObserver);
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

  private static abstract class RingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RingServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return kvServerToKvServer.RingServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RingService");
    }
  }

  private static final class RingServiceFileDescriptorSupplier
      extends RingServiceBaseDescriptorSupplier {
    RingServiceFileDescriptorSupplier() {}
  }

  private static final class RingServiceMethodDescriptorSupplier
      extends RingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RingServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (RingServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RingServiceFileDescriptorSupplier())
              .addMethod(getWriteNextMethod())
              .addMethod(getReadNextMethod())
              .build();
        }
      }
    }
    return result;
  }
}
