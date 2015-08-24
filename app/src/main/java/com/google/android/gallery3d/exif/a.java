package com.google.android.gallery3d.exif;

import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

class a extends FilterInputStream
{
  private int a = 0;
  private final byte[] c = new byte[8];
  private final ByteBuffer d = ByteBuffer.wrap(c);

  static
  {
    if (!a.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }

  protected a(InputStream paramInputStream)
  {
    super(paramInputStream);
  }

  public int a()
  {
    return a;
  }

  public String a(int paramInt, Charset paramCharset)
    throws IOException
  {
    byte[] arrayOfByte = new byte[paramInt];
    a(arrayOfByte);
    return new String(arrayOfByte, paramCharset);
  }

  public void a(long paramLong)
    throws IOException
  {
    if (skip(paramLong) != paramLong)
      throw new EOFException();
  }

  public void a(ByteOrder paramByteOrder)
  {
    d.order(paramByteOrder);
  }

  public void a(byte[] paramArrayOfByte)
    throws IOException
  {
    a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (read(paramArrayOfByte, paramInt1, paramInt2) != paramInt2)
      throw new EOFException();
  }

  public ByteOrder b()
  {
    return d.order();
  }

  public void b(long paramLong)
    throws IOException
  {
    paramLong -= a;
    assert (paramLong >= 0L);
    a(paramLong);
  }

  public long c()
    throws IOException
  {
    return readInt() & 0xFFFFFFFF;
  }

  public int read()
    throws IOException
  {
    int j = in.read();
    int k = a;
    if (j >= 0);
    for (int i = 1; ; i = 0)
    {
      a = (i + k);
      return j;
    }
  }

  public int read(byte[] paramArrayOfByte)
    throws IOException
  {
    int j = in.read(paramArrayOfByte);
    int k = a;
    if (j >= 0);
    for (int i = j; ; i = 0)
    {
      a = (i + k);
      return j;
    }
  }

  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    paramInt2 = in.read(paramArrayOfByte, paramInt1, paramInt2);
    int i = a;
    if (paramInt2 >= 0);
    for (paramInt1 = paramInt2; ; paramInt1 = 0)
    {
      a = (paramInt1 + i);
      return paramInt2;
    }
  }

  public int readInt()
    throws IOException
  {
    a(c, 0, 4);
    d.rewind();
    return d.getInt();
  }

  public short readShort()
    throws IOException
  {
    a(c, 0, 2);
    d.rewind();
    return d.getShort();
  }

  public int readUnsignedShort()
    throws IOException
  {
    return readShort() & 0xFFFF;
  }

  public long skip(long paramLong)
    throws IOException
  {
    paramLong = in.skip(paramLong);
    a = ((int)(a + paramLong));
    return paramLong;
  }
}