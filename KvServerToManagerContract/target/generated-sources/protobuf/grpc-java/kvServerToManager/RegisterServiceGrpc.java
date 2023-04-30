package kvServerToManager;

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
    comments = "Source: RegisterService.proto")
public final class RegisterServiceGrpc {

  private RegisterServiceGrpc() {}

  public static final String SERVICE_NAME = "registerservice.RegisterService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<kvServerToManager.KvServerInfo,
      kvServerToManager.Reply> getRegisterServerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "registerServer",
      requestType = kvServerToManager.KvServerInfo.class,
      responseType = kvServerToManager.Reply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<kvServerToManager.KvServerInfo,
      kvServerToManager.Reply> getRegisterServerMethod() {
    io.grpc.MethodDescriptor<kvServerToManager.KvServerInfo, kvServerToManager.Reply> getRegisterServerMethod;
    if ((getRegisterServerMethod = RegisterServiceGrpc.getRegisterServerMethod) == null) {
      synchronized (RegisterServiceGrpc.class) {
        if ((getRegisterServerMethod = RegisterServiceGrpc.getRegisterServerMethod) == null) {
          RegisterServiceGrpc.getRegisterServerMethod = getRegisterServerMethod =
              io.grpc.MethodDescriptor.<kvServerToManager.KvServerInfo, kvServerToManager.Reply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "registerServer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  kvServerToManager.KvServerInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  kvServerToManager.Reply.getDefaultInstance()))
              .setSchemaDescriptor(new RegisterServiceMethodDescriptorSupplier("registerServer"))
              .build();
        }
      }
    }
    return getRegisterServerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<kvServerToManager.KvServerInfo,
      kvServerToManager.NextServer> getGetNextServerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getNextServer",
      requestType = kvServerToManager.KvServerInfo.class,
      responseType = kvServerToManager.NextServer.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<kvServerToManager.KvServerInfo,
      kvServerToManager.NextServer> getGetNextServerMethod() {
    io.grpc.MethodDescriptor<kvServerToManager.KvServerInfo, kvServerToManager.NextServer> getGetNextServerMethod;
    if ((getGetNextServerMethod = RegisterServiceGrpc.getGetNextServerMethod) == null) {
      synchronized (RegisterServiceGrpc.class) {
        if ((getGetNextServerMethod = RegisterServiceGrpc.getGetNextServerMethod) == null) {
          RegisterServiceGrpc.getGetNextServerMethod = getGetNextServerMethod =
              io.grpc.MethodDescriptor.<kvServerToManager.KvServerInfo, kvServerToManager.NextServer>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getNextServer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  kvServerToManager.KvServerInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  kvServerToManager.NextServer.getDefaultInstance()))
              .setSchemaDescriptor(new RegisterServiceMethodDescriptorSupplier("getNextServer"))
              .build();
        }
      }
    }
    return getGetNextServerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<kvServerToManager.KvServerInfo,
      kvServerToManager.NextServer> getFailInformMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "failInform",
      requestType = kvServerToManager.KvServerInfo.class,
      responseType = kvServerToManager.NextServer.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<kvServerToManager.KvServerInfo,
      kvServerToManager.NextServer> getFailInformMethod() {
    io.grpc.MethodDescriptor<kvServerToManager.KvServerInfo, kvServerToManager.NextServer> getFailInformMethod;
    if ((getFailInformMethod = RegisterServiceGrpc.getFailInformMethod) == null) {
      synchronized (RegisterServiceGrpc.class) {
        if ((getFailInformMethod = RegisterServiceGrpc.getFailInformMethod) == null) {
          RegisterServiceGrpc.getFailInformMethod = getFailInformMethod =
              io.grpc.MethodDescriptor.<kvServerToManager.KvServerInfo, kvServerToManager.NextServer>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "failInform"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  kvServerToManager.KvServerInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  kvServerToManager.NextServer.getDefaultInstance()))
              .setSchemaDescriptor(new RegisterServiceMethodDescriptorSupplier("failInform"))
              .build();
        }
      }
    }
    return getFailInformMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RegisterServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RegisterServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RegisterServiceStub>() {
        @java.lang.Override
        public RegisterServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RegisterServiceStub(channel, callOptions);
        }
      };
    return RegisterServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RegisterServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RegisterServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RegisterServiceBlockingStub>() {
        @java.lang.Override
        public RegisterServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RegisterServiceBlockingStub(channel, callOptions);
        }
      };
    return RegisterServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RegisterServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RegisterServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RegisterServiceFutureStub>() {
        @java.lang.Override
        public RegisterServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RegisterServiceFutureStub(channel, callOptions);
        }
      };
    return RegisterServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class RegisterServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void registerServer(kvServerToManager.KvServerInfo request,
        io.grpc.stub.StreamObserver<kvServerToManager.Reply> responseObserver) {
      asyncUnimplementedUnaryCall(getRegisterServerMethod(), responseObserver);
    }

    /**
     */
    public void getNextServer(kvServerToManager.KvServerInfo request,
        io.grpc.stub.StreamObserver<kvServerToManager.NextServer> responseObserver) {
      asyncUnimplementedUnaryCall(getGetNextServerMethod(), responseObserver);
    }

    /**
     */
    public void failInform(kvServerToManager.KvServerInfo request,
        io.grpc.stub.StreamObserver<kvServerToManager.NextServer> responseObserver) {
      asyncUnimplementedUnaryCall(getFailInformMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRegisterServerMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                kvServerToManager.KvServerInfo,
                kvServerToManager.Reply>(
                  this, METHODID_REGISTER_SERVER)))
          .addMethod(
            getGetNextServerMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                kvServerToManager.KvServerInfo,
                kvServerToManager.NextServer>(
                  this, METHODID_GET_NEXT_SERVER)))
          .addMethod(
            getFailInformMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                kvServerToManager.KvServerInfo,
                kvServerToManager.NextServer>(
                  this, METHODID_FAIL_INFORM)))
          .build();
    }
  }

  /**
   */
  public static final class RegisterServiceStub extends io.grpc.stub.AbstractAsyncStub<RegisterServiceStub> {
    private RegisterServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegisterServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RegisterServiceStub(channel, callOptions);
    }

    /**
     */
    public void registerServer(kvServerToManager.KvServerInfo request,
        io.grpc.stub.StreamObserver<kvServerToManager.Reply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRegisterServerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getNextServer(kvServerToManager.KvServerInfo request,
        io.grpc.stub.StreamObserver<kvServerToManager.NextServer> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetNextServerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void failInform(kvServerToManager.KvServerInfo request,
        io.grpc.stub.StreamObserver<kvServerToManager.NextServer> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getFailInformMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class RegisterServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<RegisterServiceBlockingStub> {
    private RegisterServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegisterServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RegisterServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public kvServerToManager.Reply registerServer(kvServerToManager.KvServerInfo request) {
      return blockingUnaryCall(
          getChannel(), getRegisterServerMethod(), getCallOptions(), request);
    }

    /**
     */
    public kvServerToManager.NextServer getNextServer(kvServerToManager.KvServerInfo request) {
      return blockingUnaryCall(
          getChannel(), getGetNextServerMethod(), getCallOptions(), request);
    }

    /**
     */
    public kvServerToManager.NextServer failInform(kvServerToManager.KvServerInfo request) {
      return blockingUnaryCall(
          getChannel(), getFailInformMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RegisterServiceFutureStub extends io.grpc.stub.AbstractFutureStub<RegisterServiceFutureStub> {
    private RegisterServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegisterServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RegisterServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<kvServerToManager.Reply> registerServer(
        kvServerToManager.KvServerInfo request) {
      return futureUnaryCall(
          getChannel().newCall(getRegisterServerMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<kvServerToManager.NextServer> getNextServer(
        kvServerToManager.KvServerInfo request) {
      return futureUnaryCall(
          getChannel().newCall(getGetNextServerMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<kvServerToManager.NextServer> failInform(
        kvServerToManager.KvServerInfo request) {
      return futureUnaryCall(
          getChannel().newCall(getFailInformMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REGISTER_SERVER = 0;
  private static final int METHODID_GET_NEXT_SERVER = 1;
  private static final int METHODID_FAIL_INFORM = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RegisterServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RegisterServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REGISTER_SERVER:
          serviceImpl.registerServer((kvServerToManager.KvServerInfo) request,
              (io.grpc.stub.StreamObserver<kvServerToManager.Reply>) responseObserver);
          break;
        case METHODID_GET_NEXT_SERVER:
          serviceImpl.getNextServer((kvServerToManager.KvServerInfo) request,
              (io.grpc.stub.StreamObserver<kvServerToManager.NextServer>) responseObserver);
          break;
        case METHODID_FAIL_INFORM:
          serviceImpl.failInform((kvServerToManager.KvServerInfo) request,
              (io.grpc.stub.StreamObserver<kvServerToManager.NextServer>) responseObserver);
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

  private static abstract class RegisterServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RegisterServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return kvServerToManager.RegisterServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RegisterService");
    }
  }

  private static final class RegisterServiceFileDescriptorSupplier
      extends RegisterServiceBaseDescriptorSupplier {
    RegisterServiceFileDescriptorSupplier() {}
  }

  private static final class RegisterServiceMethodDescriptorSupplier
      extends RegisterServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RegisterServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (RegisterServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RegisterServiceFileDescriptorSupplier())
              .addMethod(getRegisterServerMethod())
              .addMethod(getGetNextServerMethod())
              .addMethod(getFailInformMethod())
              .build();
        }
      }
    }
    return result;
  }
}
