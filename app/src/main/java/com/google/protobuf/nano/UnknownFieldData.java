package com.google.protobuf.nano;

import java.io.IOException;
import java.util.Arrays;

final class UnknownFieldData
{
  final byte[] bytes;
  final int tag;

  UnknownFieldData(int paramInt, byte[] paramArrayOfByte)
  {
    tag = paramInt;
    bytes = paramArrayOfByte;
  }

  int computeSerializedSize()
  {
    return 0 + CodedOutputByteBufferNano.computeRawVarint32Size(tag) + bytes.length;
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this);
    do
    {
      return true;
      if (!(paramObject instanceof UnknownFieldData))
        return false;
      paramObject = (UnknownFieldData)paramObject;
    }
    while ((tag == paramObject.tag) && (Arrays.equals(bytes, paramObject.bytes)));
    return false;
  }

  public int hashCode()
  {
    return (tag + 527) * 31 + Arrays.hashCode(bytes);
  }

  void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
    throws IOException
  {
    paramCodedOutputByteBufferNano.writeRawVarint32(tag);
    paramCodedOutputByteBufferNano.writeRawBytes(bytes);
  }
}