// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: BaseService.proto

package clientToKvServer;

public final class BaseServiceOuterClass {
  private BaseServiceOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_baseservice_KeyValue_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_baseservice_KeyValue_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_baseservice_Key_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_baseservice_Key_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_baseservice_Value_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_baseservice_Value_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_baseservice_Reply_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_baseservice_Reply_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\021BaseService.proto\022\013baseservice\"&\n\010KeyV" +
      "alue\022\013\n\003key\030\001 \001(\t\022\r\n\005value\030\002 \001(\t\"\022\n\003Key\022" +
      "\013\n\003key\030\001 \001(\t\"\026\n\005Value\022\r\n\005value\030\001 \001(\t\"\026\n\005" +
      "Reply\022\r\n\005reply\030\001 \001(\t2u\n\013BaseService\0228\n\013w" +
      "riteUpdate\022\025.baseservice.KeyValue\032\022.base" +
      "service.Reply\022,\n\004read\022\020.baseservice.Key\032" +
      "\022.baseservice.ValueB\024\n\020clientToKvServerP" +
      "\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_baseservice_KeyValue_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_baseservice_KeyValue_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_baseservice_KeyValue_descriptor,
        new java.lang.String[] { "Key", "Value", });
    internal_static_baseservice_Key_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_baseservice_Key_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_baseservice_Key_descriptor,
        new java.lang.String[] { "Key", });
    internal_static_baseservice_Value_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_baseservice_Value_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_baseservice_Value_descriptor,
        new java.lang.String[] { "Value", });
    internal_static_baseservice_Reply_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_baseservice_Reply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_baseservice_Reply_descriptor,
        new java.lang.String[] { "Reply", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
