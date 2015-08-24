package com.google.android.location.proto.support;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

public final class FeatureIdProto extends ExtendableMessageNano<FeatureIdProto>
{
  public long cellId;
  public long fprint;

  public FeatureIdProto()
  {
    clear();
  }

  public FeatureIdProto clear()
  {
    cellId = 0L;
    fprint = 0L;
    unknownFieldData = null;
    cachedSize = -1;
    return this;
  }

  protected int computeSerializedSize()
  {
    return super.computeSerializedSize() + CodedOutputByteBufferNano.computeFixed64Size(1, cellId) + CodedOutputByteBufferNano.computeFixed64Size(2, fprint);
  }

  public FeatureIdProto mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
      case 9:
        cellId = paramCodedInputByteBufferNano.readFixed64();
        break;
      case 17:
      }
      fprint = paramCodedInputByteBufferNano.readFixed64();
    }
  }

  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
    throws IOException
  {
    paramCodedOutputByteBufferNano.writeFixed64(1, cellId);
    paramCodedOutputByteBufferNano.writeFixed64(2, fprint);
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}