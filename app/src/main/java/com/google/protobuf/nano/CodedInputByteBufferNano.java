package com.google.protobuf.nano;

import java.io.IOException;

public final class CodedInputByteBufferNano
{
  private final byte[] buffer;
  private int bufferPos;
  private int bufferSize;
  private int bufferSizeAfterLimit;
  private int bufferStart;
  private int currentLimit = 2147483647;
  private int lastTag;
  private int recursionDepth;
  private int recursionLimit = 64;
  private int sizeLimit = 67108864;

  private CodedInputByteBufferNano(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    buffer = paramArrayOfByte;
    bufferStart = paramInt1;
    bufferSize = (paramInt1 + paramInt2);
    bufferPos = paramInt1;
  }

  public static CodedInputByteBufferNano newInstance(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new CodedInputByteBufferNano(paramArrayOfByte, paramInt1, paramInt2);
  }

  private void recomputeBufferSizeAfterLimit()
  {
    bufferSize += bufferSizeAfterLimit;
    int i = bufferSize;
    if (i > currentLimit)
    {
      bufferSizeAfterLimit = (i - currentLimit);
      bufferSize -= bufferSizeAfterLimit;
      return;
    }
    bufferSizeAfterLimit = 0;
  }

  public void checkLastTagWas(int paramInt)
    throws InvalidProtocolBufferNanoException
  {
    if (lastTag != paramInt)
      throw InvalidProtocolBufferNanoException.invalidEndTag();
  }

  public int getBytesUntilLimit()
  {
    if (currentLimit == 2147483647)
      return -1;
    int i = bufferPos;
    return currentLimit - i;
  }

  public byte[] getData(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
      return WireFormatNano.EMPTY_BYTES;
    byte[] arrayOfByte = new byte[paramInt2];
    int i = bufferStart;
    System.arraycopy(buffer, i + paramInt1, arrayOfByte, 0, paramInt2);
    return arrayOfByte;
  }

  public int getPosition()
  {
    return bufferPos - bufferStart;
  }

  public boolean isAtEnd()
  {
    return bufferPos == bufferSize;
  }

  public void popLimit(int paramInt)
  {
    currentLimit = paramInt;
    recomputeBufferSizeAfterLimit();
  }

  public int pushLimit(int paramInt)
    throws InvalidProtocolBufferNanoException
  {
    if (paramInt < 0)
      throw InvalidProtocolBufferNanoException.negativeSize();
    paramInt += bufferPos;
    int i = currentLimit;
    if (paramInt > i)
      throw InvalidProtocolBufferNanoException.truncatedMessage();
    currentLimit = paramInt;
    recomputeBufferSizeAfterLimit();
    return i;
  }

  public boolean readBool()
    throws IOException
  {
    return readRawVarint32() != 0;
  }

  public long readFixed64()
    throws IOException
  {
    return readRawLittleEndian64();
  }

  public int readInt32()
    throws IOException
  {
    return readRawVarint32();
  }

  public long readInt64()
    throws IOException
  {
    return readRawVarint64();
  }

  public void readMessage(MessageNano paramMessageNano)
    throws IOException
  {
    int i = readRawVarint32();
    if (recursionDepth >= recursionLimit)
      throw InvalidProtocolBufferNanoException.recursionLimitExceeded();
    i = pushLimit(i);
    recursionDepth += 1;
    paramMessageNano.mergeFrom(this);
    checkLastTagWas(0);
    recursionDepth -= 1;
    popLimit(i);
  }

  public byte readRawByte()
    throws IOException
  {
    if (bufferPos == bufferSize)
      throw InvalidProtocolBufferNanoException.truncatedMessage();
    byte[] arrayOfByte = buffer;
    int i = bufferPos;
    bufferPos = (i + 1);
    return arrayOfByte[i];
  }

  public byte[] readRawBytes(int paramInt)
    throws IOException
  {
    if (paramInt < 0)
      throw InvalidProtocolBufferNanoException.negativeSize();
    if (bufferPos + paramInt > currentLimit)
    {
      skipRawBytes(currentLimit - bufferPos);
      throw InvalidProtocolBufferNanoException.truncatedMessage();
    }
    if (paramInt <= bufferSize - bufferPos)
    {
      byte[] arrayOfByte = new byte[paramInt];
      System.arraycopy(buffer, bufferPos, arrayOfByte, 0, paramInt);
      bufferPos += paramInt;
      return arrayOfByte;
    }
    throw InvalidProtocolBufferNanoException.truncatedMessage();
  }

  public int readRawLittleEndian32()
    throws IOException
  {
    return readRawByte() & 0xFF | (readRawByte() & 0xFF) << 8 | (readRawByte() & 0xFF) << 16 | (readRawByte() & 0xFF) << 24;
  }

  public long readRawLittleEndian64()
    throws IOException
  {
    int i = readRawByte();
    int j = readRawByte();
    int k = readRawByte();
    int m = readRawByte();
    int n = readRawByte();
    int i1 = readRawByte();
    int i2 = readRawByte();
    int i3 = readRawByte();
    return i & 0xFF | (j & 0xFF) << 8 | (k & 0xFF) << 16 | (m & 0xFF) << 24 | (n & 0xFF) << 32 | (i1 & 0xFF) << 40 | (i2 & 0xFF) << 48 | (i3 & 0xFF) << 56;
  }

  public int readRawVarint32()
    throws IOException
  {
    int i = readRawByte();
    if (i >= 0);
    int k;
    do
    {
      return i;
      i &= 127;
      j = readRawByte();
      if (j >= 0)
        return i | j << 7;
      i |= (j & 0x7F) << 7;
      j = readRawByte();
      if (j >= 0)
        return i | j << 14;
      i |= (j & 0x7F) << 14;
      k = readRawByte();
      if (k >= 0)
        return i | k << 21;
      j = readRawByte();
      k = i | (k & 0x7F) << 21 | j << 28;
      i = k;
    }
    while (j >= 0);
    int j = 0;
    while (true)
    {
      if (j >= 5)
        break label133;
      i = k;
      if (readRawByte() >= 0)
        break;
      j += 1;
    }
    label133: throw InvalidProtocolBufferNanoException.malformedVarint();
  }

  public long readRawVarint64()
    throws IOException
  {
    int i = 0;
    long l = 0L;
    while (i < 64)
    {
      int j = readRawByte();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0)
        return l;
      i += 7;
    }
    throw InvalidProtocolBufferNanoException.malformedVarint();
  }

  public String readString()
    throws IOException
  {
    int i = readRawVarint32();
    if ((i <= bufferSize - bufferPos) && (i > 0))
    {
      String str = new String(buffer, bufferPos, i, "UTF-8");
      bufferPos += i;
      return str;
    }
    return new String(readRawBytes(i), "UTF-8");
  }

  public int readTag()
    throws IOException
  {
    if (isAtEnd())
    {
      lastTag = 0;
      return 0;
    }
    lastTag = readRawVarint32();
    if (lastTag == 0)
      throw InvalidProtocolBufferNanoException.invalidTag();
    return lastTag;
  }

  public void rewindToPosition(int paramInt)
  {
    if (paramInt > bufferPos - bufferStart)
      throw new IllegalArgumentException("Position " + paramInt + " is beyond current " + (bufferPos - bufferStart));
    if (paramInt < 0)
      throw new IllegalArgumentException("Bad position " + paramInt);
    bufferPos = (bufferStart + paramInt);
  }

  public boolean skipField(int paramInt)
    throws IOException
  {
    switch (WireFormatNano.getTagWireType(paramInt))
    {
    default:
      throw InvalidProtocolBufferNanoException.invalidWireType();
    case 0:
      readInt32();
      return true;
    case 1:
      readRawLittleEndian64();
      return true;
    case 2:
      skipRawBytes(readRawVarint32());
      return true;
    case 3:
      skipMessage();
      checkLastTagWas(WireFormatNano.makeTag(WireFormatNano.getTagFieldNumber(paramInt), 4));
      return true;
    case 4:
      return false;
    case 5:
    }
    readRawLittleEndian32();
    return true;
  }

  public void skipMessage()
    throws IOException
  {
    int i;
    do
      i = readTag();
    while ((i != 0) && (skipField(i)));
  }

  public void skipRawBytes(int paramInt)
    throws IOException
  {
    if (paramInt < 0)
      throw InvalidProtocolBufferNanoException.negativeSize();
    if (bufferPos + paramInt > currentLimit)
    {
      skipRawBytes(currentLimit - bufferPos);
      throw InvalidProtocolBufferNanoException.truncatedMessage();
    }
    if (paramInt <= bufferSize - bufferPos)
    {
      bufferPos += paramInt;
      return;
    }
    throw InvalidProtocolBufferNanoException.truncatedMessage();
  }
}