package com.google.protobuf.nano;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class FieldData
{
  private Extension<?, ?> cachedExtension;
  private List<UnknownFieldData> unknownFieldData = new ArrayList();
  private Object value;

  private byte[] toByteArray()
    throws IOException
  {
    byte[] arrayOfByte = new byte[computeSerializedSize()];
    writeTo(CodedOutputByteBufferNano.newInstance(arrayOfByte));
    return arrayOfByte;
  }

  void addUnknownField(UnknownFieldData paramUnknownFieldData)
  {
    unknownFieldData.add(paramUnknownFieldData);
  }

  int computeSerializedSize()
  {
    int i = 0;
    int j;
    if (value != null)
    {
      j = cachedExtension.computeSerializedSize(value);
      return j;
    }
    Iterator localIterator = unknownFieldData.iterator();
    while (true)
    {
      j = i;
      if (!localIterator.hasNext())
        break;
      i += ((UnknownFieldData)localIterator.next()).computeSerializedSize();
    }
  }

  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramObject == this)
      bool1 = true;
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      }
      while (!(paramObject instanceof FieldData));
      paramObject = (FieldData)paramObject;
      if ((value == null) || (paramObject.value == null))
        break;
      bool1 = bool2;
    }
    while (cachedExtension != paramObject.cachedExtension);
    if (!cachedExtension.clazz.isArray())
      return value.equals(paramObject.value);
    if ((value instanceof byte[]))
      return Arrays.equals((byte[])value, (byte[])paramObject.value);
    if ((value instanceof int[]))
      return Arrays.equals((int[])value, (int[])paramObject.value);
    if ((value instanceof long[]))
      return Arrays.equals((long[])value, (long[])paramObject.value);
    if ((value instanceof float[]))
      return Arrays.equals((float[])value, (float[])paramObject.value);
    if ((value instanceof double[]))
      return Arrays.equals((double[])value, (double[])paramObject.value);
    if ((value instanceof boolean[]))
      return Arrays.equals((boolean[])value, (boolean[])paramObject.value);
    return Arrays.deepEquals((Object[])value, (Object[])paramObject.value);
    if ((unknownFieldData != null) && (paramObject.unknownFieldData != null))
      return unknownFieldData.equals(paramObject.unknownFieldData);
    try
    {
      bool1 = Arrays.equals(toByteArray(), paramObject.toByteArray());
      return bool1;
    }
    catch (IOException paramObject)
    {
    }
    throw new IllegalStateException(paramObject);
  }

  public int hashCode()
  {
    try
    {
      int i = Arrays.hashCode(toByteArray());
      return i + 527;
    }
    catch (IOException localIOException)
    {
      throw new IllegalStateException(localIOException);
    }
  }

  void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
    throws IOException
  {
    if (value != null)
      cachedExtension.writeTo(value, paramCodedOutputByteBufferNano);
    while (true)
    {
      return;
      Iterator localIterator = unknownFieldData.iterator();
      while (localIterator.hasNext())
        ((UnknownFieldData)localIterator.next()).writeTo(paramCodedOutputByteBufferNano);
    }
  }
}