// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: RingService.proto

package kvServerToKvServer;

public interface WriteRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ringservice.WriteRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string key = 1;</code>
   * @return The key.
   */
  java.lang.String getKey();
  /**
   * <code>string key = 1;</code>
   * @return The bytes for key.
   */
  com.google.protobuf.ByteString
      getKeyBytes();

  /**
   * <code>string value = 2;</code>
   * @return The value.
   */
  java.lang.String getValue();
  /**
   * <code>string value = 2;</code>
   * @return The bytes for value.
   */
  com.google.protobuf.ByteString
      getValueBytes();

  /**
   * <code>string originServer = 3;</code>
   * @return The originServer.
   */
  java.lang.String getOriginServer();
  /**
   * <code>string originServer = 3;</code>
   * @return The bytes for originServer.
   */
  com.google.protobuf.ByteString
      getOriginServerBytes();
}
