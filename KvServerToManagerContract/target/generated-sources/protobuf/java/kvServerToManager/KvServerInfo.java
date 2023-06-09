// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: RegisterService.proto

package kvServerToManager;

/**
 * Protobuf type {@code registerservice.KvServerInfo}
 */
public  final class KvServerInfo extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:registerservice.KvServerInfo)
    KvServerInfoOrBuilder {
private static final long serialVersionUID = 0L;
  // Use KvServerInfo.newBuilder() to construct.
  private KvServerInfo(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private KvServerInfo() {
    serverIP_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new KvServerInfo();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private KvServerInfo(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 8: {

            serverPort_ = input.readInt32();
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            serverIP_ = s;
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return kvServerToManager.RegisterServiceOuterClass.internal_static_registerservice_KvServerInfo_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return kvServerToManager.RegisterServiceOuterClass.internal_static_registerservice_KvServerInfo_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            kvServerToManager.KvServerInfo.class, kvServerToManager.KvServerInfo.Builder.class);
  }

  public static final int SERVERPORT_FIELD_NUMBER = 1;
  private int serverPort_;
  /**
   * <code>int32 serverPort = 1;</code>
   * @return The serverPort.
   */
  public int getServerPort() {
    return serverPort_;
  }

  public static final int SERVERIP_FIELD_NUMBER = 2;
  private volatile java.lang.Object serverIP_;
  /**
   * <code>string serverIP = 2;</code>
   * @return The serverIP.
   */
  public java.lang.String getServerIP() {
    java.lang.Object ref = serverIP_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      serverIP_ = s;
      return s;
    }
  }
  /**
   * <code>string serverIP = 2;</code>
   * @return The bytes for serverIP.
   */
  public com.google.protobuf.ByteString
      getServerIPBytes() {
    java.lang.Object ref = serverIP_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      serverIP_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (serverPort_ != 0) {
      output.writeInt32(1, serverPort_);
    }
    if (!getServerIPBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, serverIP_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (serverPort_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, serverPort_);
    }
    if (!getServerIPBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, serverIP_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof kvServerToManager.KvServerInfo)) {
      return super.equals(obj);
    }
    kvServerToManager.KvServerInfo other = (kvServerToManager.KvServerInfo) obj;

    if (getServerPort()
        != other.getServerPort()) return false;
    if (!getServerIP()
        .equals(other.getServerIP())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + SERVERPORT_FIELD_NUMBER;
    hash = (53 * hash) + getServerPort();
    hash = (37 * hash) + SERVERIP_FIELD_NUMBER;
    hash = (53 * hash) + getServerIP().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static kvServerToManager.KvServerInfo parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static kvServerToManager.KvServerInfo parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static kvServerToManager.KvServerInfo parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static kvServerToManager.KvServerInfo parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static kvServerToManager.KvServerInfo parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static kvServerToManager.KvServerInfo parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static kvServerToManager.KvServerInfo parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static kvServerToManager.KvServerInfo parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static kvServerToManager.KvServerInfo parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static kvServerToManager.KvServerInfo parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static kvServerToManager.KvServerInfo parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static kvServerToManager.KvServerInfo parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(kvServerToManager.KvServerInfo prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code registerservice.KvServerInfo}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:registerservice.KvServerInfo)
      kvServerToManager.KvServerInfoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return kvServerToManager.RegisterServiceOuterClass.internal_static_registerservice_KvServerInfo_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return kvServerToManager.RegisterServiceOuterClass.internal_static_registerservice_KvServerInfo_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              kvServerToManager.KvServerInfo.class, kvServerToManager.KvServerInfo.Builder.class);
    }

    // Construct using kvServerToManager.KvServerInfo.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      serverPort_ = 0;

      serverIP_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return kvServerToManager.RegisterServiceOuterClass.internal_static_registerservice_KvServerInfo_descriptor;
    }

    @java.lang.Override
    public kvServerToManager.KvServerInfo getDefaultInstanceForType() {
      return kvServerToManager.KvServerInfo.getDefaultInstance();
    }

    @java.lang.Override
    public kvServerToManager.KvServerInfo build() {
      kvServerToManager.KvServerInfo result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public kvServerToManager.KvServerInfo buildPartial() {
      kvServerToManager.KvServerInfo result = new kvServerToManager.KvServerInfo(this);
      result.serverPort_ = serverPort_;
      result.serverIP_ = serverIP_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof kvServerToManager.KvServerInfo) {
        return mergeFrom((kvServerToManager.KvServerInfo)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(kvServerToManager.KvServerInfo other) {
      if (other == kvServerToManager.KvServerInfo.getDefaultInstance()) return this;
      if (other.getServerPort() != 0) {
        setServerPort(other.getServerPort());
      }
      if (!other.getServerIP().isEmpty()) {
        serverIP_ = other.serverIP_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      kvServerToManager.KvServerInfo parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (kvServerToManager.KvServerInfo) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int serverPort_ ;
    /**
     * <code>int32 serverPort = 1;</code>
     * @return The serverPort.
     */
    public int getServerPort() {
      return serverPort_;
    }
    /**
     * <code>int32 serverPort = 1;</code>
     * @param value The serverPort to set.
     * @return This builder for chaining.
     */
    public Builder setServerPort(int value) {
      
      serverPort_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 serverPort = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearServerPort() {
      
      serverPort_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object serverIP_ = "";
    /**
     * <code>string serverIP = 2;</code>
     * @return The serverIP.
     */
    public java.lang.String getServerIP() {
      java.lang.Object ref = serverIP_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        serverIP_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string serverIP = 2;</code>
     * @return The bytes for serverIP.
     */
    public com.google.protobuf.ByteString
        getServerIPBytes() {
      java.lang.Object ref = serverIP_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        serverIP_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string serverIP = 2;</code>
     * @param value The serverIP to set.
     * @return This builder for chaining.
     */
    public Builder setServerIP(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      serverIP_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string serverIP = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearServerIP() {
      
      serverIP_ = getDefaultInstance().getServerIP();
      onChanged();
      return this;
    }
    /**
     * <code>string serverIP = 2;</code>
     * @param value The bytes for serverIP to set.
     * @return This builder for chaining.
     */
    public Builder setServerIPBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      serverIP_ = value;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:registerservice.KvServerInfo)
  }

  // @@protoc_insertion_point(class_scope:registerservice.KvServerInfo)
  private static final kvServerToManager.KvServerInfo DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new kvServerToManager.KvServerInfo();
  }

  public static kvServerToManager.KvServerInfo getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<KvServerInfo>
      PARSER = new com.google.protobuf.AbstractParser<KvServerInfo>() {
    @java.lang.Override
    public KvServerInfo parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new KvServerInfo(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<KvServerInfo> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<KvServerInfo> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public kvServerToManager.KvServerInfo getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

