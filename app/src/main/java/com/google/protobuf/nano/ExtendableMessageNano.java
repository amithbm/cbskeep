package com.google.protobuf.nano;

import java.io.IOException;

public abstract class ExtendableMessageNano<M extends ExtendableMessageNano<M>> extends MessageNano
{
  protected FieldArray unknownFieldData;

  protected int computeSerializedSize()
  {
    int k = 0;
    int i = 0;
    if (unknownFieldData != null)
    {
      int j = 0;
      while (true)
      {
        k = i;
        if (j >= unknownFieldData.size())
          break;
        i += unknownFieldData.dataAt(j).computeSerializedSize();
        j += 1;
      }
    }
    return k;
  }

  protected final boolean storeUnknownField(CodedInputByteBufferNano paramCodedInputByteBufferNano, int paramInt)
    throws IOException
  {
    int i = paramCodedInputByteBufferNano.getPosition();
    if (!paramCodedInputByteBufferNano.skipField(paramInt))
      return false;
    int j = WireFormatNano.getTagFieldNumber(paramInt);
    UnknownFieldData localUnknownFieldData = new UnknownFieldData(paramInt, paramCodedInputByteBufferNano.getData(i, paramCodedInputByteBufferNano.getPosition() - i));
    paramCodedInputByteBufferNano = null;
    if (unknownFieldData == null)
      unknownFieldData = new FieldArray();
    while (true)
    {
      Object localObject = paramCodedInputByteBufferNano;
      if (paramCodedInputByteBufferNano == null)
      {
        localObject = new FieldData();
        unknownFieldData.put(j, (FieldData)localObject);
      }
      ((FieldData)localObject).addUnknownField(localUnknownFieldData);
      return true;
      paramCodedInputByteBufferNano = unknownFieldData.get(j);
    }
  }

  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
    throws IOException
  {
    if (unknownFieldData == null);
    while (true)
    {
      return;
      int i = 0;
      while (i < unknownFieldData.size())
      {
        unknownFieldData.dataAt(i).writeTo(paramCodedOutputByteBufferNano);
        i += 1;
      }
    }
  }
}