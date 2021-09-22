// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Building.proto

package autogeneratedProto;

/**
 * Protobuf type {@code autogeneratedProto.Building}
 */
public final class Building extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:autogeneratedProto.Building)
    BuildingOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Building.newBuilder() to construct.
  private Building(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Building() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new Building();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Building(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
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
            bitField0_ |= 0x00000001;
            buildingCode_ = input.readInt32();
            break;
          }
          case 16: {
            bitField0_ |= 0x00000002;
            totalFloor_ = input.readInt32();
            break;
          }
          case 24: {
            bitField0_ |= 0x00000004;
            numberOfCompanies_ = input.readInt32();
            break;
          }
          case 32: {
            bitField0_ |= 0x00000008;
            cafeteriaCode_ = input.readInt32();
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
    return autogeneratedProto.BuildingOuterClass.internal_static_autogeneratedProto_Building_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return autogeneratedProto.BuildingOuterClass.internal_static_autogeneratedProto_Building_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            autogeneratedProto.Building.class, autogeneratedProto.Building.Builder.class);
  }

  private int bitField0_;
  public static final int BUILDING_CODE_FIELD_NUMBER = 1;
  private int buildingCode_;
  /**
   * <code>optional int32 building_code = 1;</code>
   * @return Whether the buildingCode field is set.
   */
  @java.lang.Override
  public boolean hasBuildingCode() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <code>optional int32 building_code = 1;</code>
   * @return The buildingCode.
   */
  @java.lang.Override
  public int getBuildingCode() {
    return buildingCode_;
  }

  public static final int TOTAL_FLOOR_FIELD_NUMBER = 2;
  private int totalFloor_;
  /**
   * <code>optional int32 total_floor = 2;</code>
   * @return Whether the totalFloor field is set.
   */
  @java.lang.Override
  public boolean hasTotalFloor() {
    return ((bitField0_ & 0x00000002) != 0);
  }
  /**
   * <code>optional int32 total_floor = 2;</code>
   * @return The totalFloor.
   */
  @java.lang.Override
  public int getTotalFloor() {
    return totalFloor_;
  }

  public static final int NUMBER_OF_COMPANIES_FIELD_NUMBER = 3;
  private int numberOfCompanies_;
  /**
   * <code>optional int32 number_of_companies = 3;</code>
   * @return Whether the numberOfCompanies field is set.
   */
  @java.lang.Override
  public boolean hasNumberOfCompanies() {
    return ((bitField0_ & 0x00000004) != 0);
  }
  /**
   * <code>optional int32 number_of_companies = 3;</code>
   * @return The numberOfCompanies.
   */
  @java.lang.Override
  public int getNumberOfCompanies() {
    return numberOfCompanies_;
  }

  public static final int CAFETERIA_CODE_FIELD_NUMBER = 4;
  private int cafeteriaCode_;
  /**
   * <code>optional int32 cafeteria_code = 4;</code>
   * @return Whether the cafeteriaCode field is set.
   */
  @java.lang.Override
  public boolean hasCafeteriaCode() {
    return ((bitField0_ & 0x00000008) != 0);
  }
  /**
   * <code>optional int32 cafeteria_code = 4;</code>
   * @return The cafeteriaCode.
   */
  @java.lang.Override
  public int getCafeteriaCode() {
    return cafeteriaCode_;
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
    if (((bitField0_ & 0x00000001) != 0)) {
      output.writeInt32(1, buildingCode_);
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      output.writeInt32(2, totalFloor_);
    }
    if (((bitField0_ & 0x00000004) != 0)) {
      output.writeInt32(3, numberOfCompanies_);
    }
    if (((bitField0_ & 0x00000008) != 0)) {
      output.writeInt32(4, cafeteriaCode_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, buildingCode_);
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, totalFloor_);
    }
    if (((bitField0_ & 0x00000004) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, numberOfCompanies_);
    }
    if (((bitField0_ & 0x00000008) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(4, cafeteriaCode_);
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
    if (!(obj instanceof autogeneratedProto.Building)) {
      return super.equals(obj);
    }
    autogeneratedProto.Building other = (autogeneratedProto.Building) obj;

    if (hasBuildingCode() != other.hasBuildingCode()) return false;
    if (hasBuildingCode()) {
      if (getBuildingCode()
          != other.getBuildingCode()) return false;
    }
    if (hasTotalFloor() != other.hasTotalFloor()) return false;
    if (hasTotalFloor()) {
      if (getTotalFloor()
          != other.getTotalFloor()) return false;
    }
    if (hasNumberOfCompanies() != other.hasNumberOfCompanies()) return false;
    if (hasNumberOfCompanies()) {
      if (getNumberOfCompanies()
          != other.getNumberOfCompanies()) return false;
    }
    if (hasCafeteriaCode() != other.hasCafeteriaCode()) return false;
    if (hasCafeteriaCode()) {
      if (getCafeteriaCode()
          != other.getCafeteriaCode()) return false;
    }
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
    if (hasBuildingCode()) {
      hash = (37 * hash) + BUILDING_CODE_FIELD_NUMBER;
      hash = (53 * hash) + getBuildingCode();
    }
    if (hasTotalFloor()) {
      hash = (37 * hash) + TOTAL_FLOOR_FIELD_NUMBER;
      hash = (53 * hash) + getTotalFloor();
    }
    if (hasNumberOfCompanies()) {
      hash = (37 * hash) + NUMBER_OF_COMPANIES_FIELD_NUMBER;
      hash = (53 * hash) + getNumberOfCompanies();
    }
    if (hasCafeteriaCode()) {
      hash = (37 * hash) + CAFETERIA_CODE_FIELD_NUMBER;
      hash = (53 * hash) + getCafeteriaCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static autogeneratedProto.Building parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static autogeneratedProto.Building parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static autogeneratedProto.Building parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static autogeneratedProto.Building parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static autogeneratedProto.Building parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static autogeneratedProto.Building parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static autogeneratedProto.Building parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static autogeneratedProto.Building parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static autogeneratedProto.Building parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static autogeneratedProto.Building parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static autogeneratedProto.Building parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static autogeneratedProto.Building parseFrom(
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
  public static Builder newBuilder(autogeneratedProto.Building prototype) {
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
   * Protobuf type {@code autogeneratedProto.Building}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:autogeneratedProto.Building)
      autogeneratedProto.BuildingOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return autogeneratedProto.BuildingOuterClass.internal_static_autogeneratedProto_Building_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return autogeneratedProto.BuildingOuterClass.internal_static_autogeneratedProto_Building_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              autogeneratedProto.Building.class, autogeneratedProto.Building.Builder.class);
    }

    // Construct using autogeneratedProto.Building.newBuilder()
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
      buildingCode_ = 0;
      bitField0_ = (bitField0_ & ~0x00000001);
      totalFloor_ = 0;
      bitField0_ = (bitField0_ & ~0x00000002);
      numberOfCompanies_ = 0;
      bitField0_ = (bitField0_ & ~0x00000004);
      cafeteriaCode_ = 0;
      bitField0_ = (bitField0_ & ~0x00000008);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return autogeneratedProto.BuildingOuterClass.internal_static_autogeneratedProto_Building_descriptor;
    }

    @java.lang.Override
    public autogeneratedProto.Building getDefaultInstanceForType() {
      return autogeneratedProto.Building.getDefaultInstance();
    }

    @java.lang.Override
    public autogeneratedProto.Building build() {
      autogeneratedProto.Building result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public autogeneratedProto.Building buildPartial() {
      autogeneratedProto.Building result = new autogeneratedProto.Building(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.buildingCode_ = buildingCode_;
        to_bitField0_ |= 0x00000001;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.totalFloor_ = totalFloor_;
        to_bitField0_ |= 0x00000002;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.numberOfCompanies_ = numberOfCompanies_;
        to_bitField0_ |= 0x00000004;
      }
      if (((from_bitField0_ & 0x00000008) != 0)) {
        result.cafeteriaCode_ = cafeteriaCode_;
        to_bitField0_ |= 0x00000008;
      }
      result.bitField0_ = to_bitField0_;
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
      if (other instanceof autogeneratedProto.Building) {
        return mergeFrom((autogeneratedProto.Building)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(autogeneratedProto.Building other) {
      if (other == autogeneratedProto.Building.getDefaultInstance()) return this;
      if (other.hasBuildingCode()) {
        setBuildingCode(other.getBuildingCode());
      }
      if (other.hasTotalFloor()) {
        setTotalFloor(other.getTotalFloor());
      }
      if (other.hasNumberOfCompanies()) {
        setNumberOfCompanies(other.getNumberOfCompanies());
      }
      if (other.hasCafeteriaCode()) {
        setCafeteriaCode(other.getCafeteriaCode());
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
      autogeneratedProto.Building parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (autogeneratedProto.Building) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private int buildingCode_ ;
    /**
     * <code>optional int32 building_code = 1;</code>
     * @return Whether the buildingCode field is set.
     */
    @java.lang.Override
    public boolean hasBuildingCode() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>optional int32 building_code = 1;</code>
     * @return The buildingCode.
     */
    @java.lang.Override
    public int getBuildingCode() {
      return buildingCode_;
    }
    /**
     * <code>optional int32 building_code = 1;</code>
     * @param value The buildingCode to set.
     * @return This builder for chaining.
     */
    public Builder setBuildingCode(int value) {
      bitField0_ |= 0x00000001;
      buildingCode_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int32 building_code = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearBuildingCode() {
      bitField0_ = (bitField0_ & ~0x00000001);
      buildingCode_ = 0;
      onChanged();
      return this;
    }

    private int totalFloor_ ;
    /**
     * <code>optional int32 total_floor = 2;</code>
     * @return Whether the totalFloor field is set.
     */
    @java.lang.Override
    public boolean hasTotalFloor() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <code>optional int32 total_floor = 2;</code>
     * @return The totalFloor.
     */
    @java.lang.Override
    public int getTotalFloor() {
      return totalFloor_;
    }
    /**
     * <code>optional int32 total_floor = 2;</code>
     * @param value The totalFloor to set.
     * @return This builder for chaining.
     */
    public Builder setTotalFloor(int value) {
      bitField0_ |= 0x00000002;
      totalFloor_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int32 total_floor = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearTotalFloor() {
      bitField0_ = (bitField0_ & ~0x00000002);
      totalFloor_ = 0;
      onChanged();
      return this;
    }

    private int numberOfCompanies_ ;
    /**
     * <code>optional int32 number_of_companies = 3;</code>
     * @return Whether the numberOfCompanies field is set.
     */
    @java.lang.Override
    public boolean hasNumberOfCompanies() {
      return ((bitField0_ & 0x00000004) != 0);
    }
    /**
     * <code>optional int32 number_of_companies = 3;</code>
     * @return The numberOfCompanies.
     */
    @java.lang.Override
    public int getNumberOfCompanies() {
      return numberOfCompanies_;
    }
    /**
     * <code>optional int32 number_of_companies = 3;</code>
     * @param value The numberOfCompanies to set.
     * @return This builder for chaining.
     */
    public Builder setNumberOfCompanies(int value) {
      bitField0_ |= 0x00000004;
      numberOfCompanies_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int32 number_of_companies = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearNumberOfCompanies() {
      bitField0_ = (bitField0_ & ~0x00000004);
      numberOfCompanies_ = 0;
      onChanged();
      return this;
    }

    private int cafeteriaCode_ ;
    /**
     * <code>optional int32 cafeteria_code = 4;</code>
     * @return Whether the cafeteriaCode field is set.
     */
    @java.lang.Override
    public boolean hasCafeteriaCode() {
      return ((bitField0_ & 0x00000008) != 0);
    }
    /**
     * <code>optional int32 cafeteria_code = 4;</code>
     * @return The cafeteriaCode.
     */
    @java.lang.Override
    public int getCafeteriaCode() {
      return cafeteriaCode_;
    }
    /**
     * <code>optional int32 cafeteria_code = 4;</code>
     * @param value The cafeteriaCode to set.
     * @return This builder for chaining.
     */
    public Builder setCafeteriaCode(int value) {
      bitField0_ |= 0x00000008;
      cafeteriaCode_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int32 cafeteria_code = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearCafeteriaCode() {
      bitField0_ = (bitField0_ & ~0x00000008);
      cafeteriaCode_ = 0;
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


    // @@protoc_insertion_point(builder_scope:autogeneratedProto.Building)
  }

  // @@protoc_insertion_point(class_scope:autogeneratedProto.Building)
  private static final autogeneratedProto.Building DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new autogeneratedProto.Building();
  }

  public static autogeneratedProto.Building getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<Building>
      PARSER = new com.google.protobuf.AbstractParser<Building>() {
    @java.lang.Override
    public Building parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new Building(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Building> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Building> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public autogeneratedProto.Building getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

