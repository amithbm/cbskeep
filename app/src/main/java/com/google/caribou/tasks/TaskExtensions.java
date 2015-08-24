package com.google.caribou.tasks;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

public final class TaskExtensions extends ExtendableMessageNano<TaskExtensions>
{
  public KeepExtension keepExtension;

  public TaskExtensions()
  {
    clear();
  }

  public static TaskExtensions parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferNanoException
  {
    return (TaskExtensions)MessageNano.mergeFrom(new TaskExtensions(), paramArrayOfByte);
  }

  public TaskExtensions clear()
  {
    keepExtension = null;
    unknownFieldData = null;
    cachedSize = -1;
    return this;
  }

  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (keepExtension != null)
      i = j + CodedOutputByteBufferNano.computeMessageSize(1, keepExtension);
    return i;
  }

  public TaskExtensions mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
    throws IOException
  {
    while (true)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      switch (i)
      {
      default:
        if (storeUnknownField(paramCodedInputByteBufferNano, i))
          continue;
      case 0:
        return this;
      case 10:
      }
      if (keepExtension == null)
        keepExtension = new KeepExtension();
      paramCodedInputByteBufferNano.readMessage(keepExtension);
    }
  }

  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
    throws IOException
  {
    if (keepExtension != null)
      paramCodedOutputByteBufferNano.writeMessage(1, keepExtension);
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}