// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Employee.proto

package autogeneratedProto;

/**
 * Protobuf type {@code autogeneratedProto.EmployeeList}
 */
public final class EmployeeList extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:autogeneratedProto.EmployeeList)
    EmployeeListOrBuilder {
private static final long serialVersionUID = 0L;
  // Use EmployeeList.newBuilder() to construct.
  private EmployeeList(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private EmployeeList() {
    employees_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new EmployeeList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private EmployeeList(
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
          case 10: {
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              employees_ = new java.util.ArrayList<autogeneratedProto.Employee>();
              mutable_bitField0_ |= 0x00000001;
            }
            employees_.add(
                input.readMessage(autogeneratedProto.Employee.PARSER, extensionRegistry));
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
      if (((mutable_bitField0_ & 0x00000001) != 0)) {
        employees_ = java.util.Collections.unmodifiableList(employees_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return autogeneratedProto.EmployeeOuterClass.internal_static_autogeneratedProto_EmployeeList_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return autogeneratedProto.EmployeeOuterClass.internal_static_autogeneratedProto_EmployeeList_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            autogeneratedProto.EmployeeList.class, autogeneratedProto.EmployeeList.Builder.class);
  }

  public static final int EMPLOYEES_FIELD_NUMBER = 1;
  private java.util.List<autogeneratedProto.Employee> employees_;
  /**
   * <code>repeated .autogeneratedProto.Employee employees = 1;</code>
   */
  @java.lang.Override
  public java.util.List<autogeneratedProto.Employee> getEmployeesList() {
    return employees_;
  }
  /**
   * <code>repeated .autogeneratedProto.Employee employees = 1;</code>
   */
  @java.lang.Override
  public java.util.List<? extends autogeneratedProto.EmployeeOrBuilder> 
      getEmployeesOrBuilderList() {
    return employees_;
  }
  /**
   * <code>repeated .autogeneratedProto.Employee employees = 1;</code>
   */
  @java.lang.Override
  public int getEmployeesCount() {
    return employees_.size();
  }
  /**
   * <code>repeated .autogeneratedProto.Employee employees = 1;</code>
   */
  @java.lang.Override
  public autogeneratedProto.Employee getEmployees(int index) {
    return employees_.get(index);
  }
  /**
   * <code>repeated .autogeneratedProto.Employee employees = 1;</code>
   */
  @java.lang.Override
  public autogeneratedProto.EmployeeOrBuilder getEmployeesOrBuilder(
      int index) {
    return employees_.get(index);
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    for (int i = 0; i < getEmployeesCount(); i++) {
      if (!getEmployees(i).isInitialized()) {
        memoizedIsInitialized = 0;
        return false;
      }
    }
    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    for (int i = 0; i < employees_.size(); i++) {
      output.writeMessage(1, employees_.get(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < employees_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, employees_.get(i));
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
    if (!(obj instanceof autogeneratedProto.EmployeeList)) {
      return super.equals(obj);
    }
    autogeneratedProto.EmployeeList other = (autogeneratedProto.EmployeeList) obj;

    if (!getEmployeesList()
        .equals(other.getEmployeesList())) return false;
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
    if (getEmployeesCount() > 0) {
      hash = (37 * hash) + EMPLOYEES_FIELD_NUMBER;
      hash = (53 * hash) + getEmployeesList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static autogeneratedProto.EmployeeList parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static autogeneratedProto.EmployeeList parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static autogeneratedProto.EmployeeList parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static autogeneratedProto.EmployeeList parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static autogeneratedProto.EmployeeList parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static autogeneratedProto.EmployeeList parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static autogeneratedProto.EmployeeList parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static autogeneratedProto.EmployeeList parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static autogeneratedProto.EmployeeList parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static autogeneratedProto.EmployeeList parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static autogeneratedProto.EmployeeList parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static autogeneratedProto.EmployeeList parseFrom(
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
  public static Builder newBuilder(autogeneratedProto.EmployeeList prototype) {
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
   * Protobuf type {@code autogeneratedProto.EmployeeList}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:autogeneratedProto.EmployeeList)
      autogeneratedProto.EmployeeListOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return autogeneratedProto.EmployeeOuterClass.internal_static_autogeneratedProto_EmployeeList_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return autogeneratedProto.EmployeeOuterClass.internal_static_autogeneratedProto_EmployeeList_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              autogeneratedProto.EmployeeList.class, autogeneratedProto.EmployeeList.Builder.class);
    }

    // Construct using autogeneratedProto.EmployeeList.newBuilder()
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
        getEmployeesFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (employeesBuilder_ == null) {
        employees_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        employeesBuilder_.clear();
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return autogeneratedProto.EmployeeOuterClass.internal_static_autogeneratedProto_EmployeeList_descriptor;
    }

    @java.lang.Override
    public autogeneratedProto.EmployeeList getDefaultInstanceForType() {
      return autogeneratedProto.EmployeeList.getDefaultInstance();
    }

    @java.lang.Override
    public autogeneratedProto.EmployeeList build() {
      autogeneratedProto.EmployeeList result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public autogeneratedProto.EmployeeList buildPartial() {
      autogeneratedProto.EmployeeList result = new autogeneratedProto.EmployeeList(this);
      int from_bitField0_ = bitField0_;
      if (employeesBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          employees_ = java.util.Collections.unmodifiableList(employees_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.employees_ = employees_;
      } else {
        result.employees_ = employeesBuilder_.build();
      }
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
      if (other instanceof autogeneratedProto.EmployeeList) {
        return mergeFrom((autogeneratedProto.EmployeeList)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(autogeneratedProto.EmployeeList other) {
      if (other == autogeneratedProto.EmployeeList.getDefaultInstance()) return this;
      if (employeesBuilder_ == null) {
        if (!other.employees_.isEmpty()) {
          if (employees_.isEmpty()) {
            employees_ = other.employees_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureEmployeesIsMutable();
            employees_.addAll(other.employees_);
          }
          onChanged();
        }
      } else {
        if (!other.employees_.isEmpty()) {
          if (employeesBuilder_.isEmpty()) {
            employeesBuilder_.dispose();
            employeesBuilder_ = null;
            employees_ = other.employees_;
            bitField0_ = (bitField0_ & ~0x00000001);
            employeesBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getEmployeesFieldBuilder() : null;
          } else {
            employeesBuilder_.addAllMessages(other.employees_);
          }
        }
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      for (int i = 0; i < getEmployeesCount(); i++) {
        if (!getEmployees(i).isInitialized()) {
          return false;
        }
      }
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      autogeneratedProto.EmployeeList parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (autogeneratedProto.EmployeeList) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<autogeneratedProto.Employee> employees_ =
      java.util.Collections.emptyList();
    private void ensureEmployeesIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        employees_ = new java.util.ArrayList<autogeneratedProto.Employee>(employees_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        autogeneratedProto.Employee, autogeneratedProto.Employee.Builder, autogeneratedProto.EmployeeOrBuilder> employeesBuilder_;

    /**
     * <code>repeated .autogeneratedProto.Employee employees = 1;</code>
     */
    public java.util.List<autogeneratedProto.Employee> getEmployeesList() {
      if (employeesBuilder_ == null) {
        return java.util.Collections.unmodifiableList(employees_);
      } else {
        return employeesBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .autogeneratedProto.Employee employees = 1;</code>
     */
    public int getEmployeesCount() {
      if (employeesBuilder_ == null) {
        return employees_.size();
      } else {
        return employeesBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .autogeneratedProto.Employee employees = 1;</code>
     */
    public autogeneratedProto.Employee getEmployees(int index) {
      if (employeesBuilder_ == null) {
        return employees_.get(index);
      } else {
        return employeesBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .autogeneratedProto.Employee employees = 1;</code>
     */
    public Builder setEmployees(
        int index, autogeneratedProto.Employee value) {
      if (employeesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureEmployeesIsMutable();
        employees_.set(index, value);
        onChanged();
      } else {
        employeesBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .autogeneratedProto.Employee employees = 1;</code>
     */
    public Builder setEmployees(
        int index, autogeneratedProto.Employee.Builder builderForValue) {
      if (employeesBuilder_ == null) {
        ensureEmployeesIsMutable();
        employees_.set(index, builderForValue.build());
        onChanged();
      } else {
        employeesBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .autogeneratedProto.Employee employees = 1;</code>
     */
    public Builder addEmployees(autogeneratedProto.Employee value) {
      if (employeesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureEmployeesIsMutable();
        employees_.add(value);
        onChanged();
      } else {
        employeesBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .autogeneratedProto.Employee employees = 1;</code>
     */
    public Builder addEmployees(
        int index, autogeneratedProto.Employee value) {
      if (employeesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureEmployeesIsMutable();
        employees_.add(index, value);
        onChanged();
      } else {
        employeesBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .autogeneratedProto.Employee employees = 1;</code>
     */
    public Builder addEmployees(
        autogeneratedProto.Employee.Builder builderForValue) {
      if (employeesBuilder_ == null) {
        ensureEmployeesIsMutable();
        employees_.add(builderForValue.build());
        onChanged();
      } else {
        employeesBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .autogeneratedProto.Employee employees = 1;</code>
     */
    public Builder addEmployees(
        int index, autogeneratedProto.Employee.Builder builderForValue) {
      if (employeesBuilder_ == null) {
        ensureEmployeesIsMutable();
        employees_.add(index, builderForValue.build());
        onChanged();
      } else {
        employeesBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .autogeneratedProto.Employee employees = 1;</code>
     */
    public Builder addAllEmployees(
        java.lang.Iterable<? extends autogeneratedProto.Employee> values) {
      if (employeesBuilder_ == null) {
        ensureEmployeesIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, employees_);
        onChanged();
      } else {
        employeesBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .autogeneratedProto.Employee employees = 1;</code>
     */
    public Builder clearEmployees() {
      if (employeesBuilder_ == null) {
        employees_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        employeesBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .autogeneratedProto.Employee employees = 1;</code>
     */
    public Builder removeEmployees(int index) {
      if (employeesBuilder_ == null) {
        ensureEmployeesIsMutable();
        employees_.remove(index);
        onChanged();
      } else {
        employeesBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .autogeneratedProto.Employee employees = 1;</code>
     */
    public autogeneratedProto.Employee.Builder getEmployeesBuilder(
        int index) {
      return getEmployeesFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .autogeneratedProto.Employee employees = 1;</code>
     */
    public autogeneratedProto.EmployeeOrBuilder getEmployeesOrBuilder(
        int index) {
      if (employeesBuilder_ == null) {
        return employees_.get(index);  } else {
        return employeesBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .autogeneratedProto.Employee employees = 1;</code>
     */
    public java.util.List<? extends autogeneratedProto.EmployeeOrBuilder> 
         getEmployeesOrBuilderList() {
      if (employeesBuilder_ != null) {
        return employeesBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(employees_);
      }
    }
    /**
     * <code>repeated .autogeneratedProto.Employee employees = 1;</code>
     */
    public autogeneratedProto.Employee.Builder addEmployeesBuilder() {
      return getEmployeesFieldBuilder().addBuilder(
          autogeneratedProto.Employee.getDefaultInstance());
    }
    /**
     * <code>repeated .autogeneratedProto.Employee employees = 1;</code>
     */
    public autogeneratedProto.Employee.Builder addEmployeesBuilder(
        int index) {
      return getEmployeesFieldBuilder().addBuilder(
          index, autogeneratedProto.Employee.getDefaultInstance());
    }
    /**
     * <code>repeated .autogeneratedProto.Employee employees = 1;</code>
     */
    public java.util.List<autogeneratedProto.Employee.Builder> 
         getEmployeesBuilderList() {
      return getEmployeesFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        autogeneratedProto.Employee, autogeneratedProto.Employee.Builder, autogeneratedProto.EmployeeOrBuilder> 
        getEmployeesFieldBuilder() {
      if (employeesBuilder_ == null) {
        employeesBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            autogeneratedProto.Employee, autogeneratedProto.Employee.Builder, autogeneratedProto.EmployeeOrBuilder>(
                employees_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        employees_ = null;
      }
      return employeesBuilder_;
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


    // @@protoc_insertion_point(builder_scope:autogeneratedProto.EmployeeList)
  }

  // @@protoc_insertion_point(class_scope:autogeneratedProto.EmployeeList)
  private static final autogeneratedProto.EmployeeList DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new autogeneratedProto.EmployeeList();
  }

  public static autogeneratedProto.EmployeeList getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<EmployeeList>
      PARSER = new com.google.protobuf.AbstractParser<EmployeeList>() {
    @java.lang.Override
    public EmployeeList parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new EmployeeList(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<EmployeeList> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<EmployeeList> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public autogeneratedProto.EmployeeList getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

