package com.google.protobuf.nano;

import java.io.IOException;
import java.lang.reflect.Array;

public class Extension<M extends ExtendableMessageNano<M>, T>
{
  protected final Class<T> clazz;
  protected final boolean repeated;
  protected final int tag;
  protected final int type;

  protected int computeRepeatedSerializedSize(Object paramObject)
  {
    int j = 0;
    int m = Array.getLength(paramObject);
    int i = 0;
    while (i < m)
    {
      int k = j;
      if (Array.get(paramObject, i) != null)
        k = j + computeSingularSerializedSize(Array.get(paramObject, i));
      i += 1;
      j = k;
    }
    return j;
  }

  int computeSerializedSize(Object paramObject)
  {
    if (repeated)
      return computeRepeatedSerializedSize(paramObject);
    return computeSingularSerializedSize(paramObject);
  }

  protected int computeSingularSerializedSize(Object paramObject)
  {
    int i = WireFormatNano.getTagFieldNumber(tag);
    switch (type)
    {
    default:
      throw new IllegalArgumentException("Unknown type " + type);
    case 10:
      return CodedOutputByteBufferNano.computeGroupSize(i, (MessageNano)paramObject);
    case 11:
    }
    return CodedOutputByteBufferNano.computeMessageSize(i, (MessageNano)paramObject);
  }

  protected void writeRepeatedData(Object paramObject, CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int j = Array.getLength(paramObject);
    int i = 0;
    while (i < j)
    {
      Object localObject = Array.get(paramObject, i);
      if (localObject != null)
        writeSingularData(localObject, paramCodedOutputByteBufferNano);
      i += 1;
    }
  }

  protected void writeSingularData(Object paramObject, CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    while (true)
    {
      try
      {
        paramCodedOutputByteBufferNano.writeRawVarint32(tag);
        switch (type)
        {
        case 10:
          throw new IllegalArgumentException("Unknown type " + type);
        case 11:
        }
      }
      catch (IOException paramObject)
      {
        throw new IllegalStateException(paramObject);
      }
      paramObject = (MessageNano)paramObject;
      int i = WireFormatNano.getTagFieldNumber(tag);
      paramCodedOutputByteBufferNano.writeGroupNoTag(paramObject);
      paramCodedOutputByteBufferNano.writeTag(i, 4);
      return;
      paramCodedOutputByteBufferNano.writeMessageNoTag((MessageNano)paramObject);
      return;
    }
  }

  void writeTo(Object paramObject, CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
    throws IOException
  {
    if (repeated)
    {
      writeRepeatedData(paramObject, paramCodedOutputByteBufferNano);
      return;
    }
    writeSingularData(paramObject, paramCodedOutputByteBufferNano);
  }
}