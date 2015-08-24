package com.google.android.gallery3d.exif;

import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;

class b
{
  private static final byte[] e = { 65, 83, 67, 73, 73, 0, 0, 0 };
  private static final byte[] f = { 74, 73, 83, 0, 0, 0, 0, 0 };
  private static final byte[] g = { 85, 78, 73, 67, 79, 68, 69, 0 };
  private final g[] h = new g[5];
  private byte[] i;
  private ArrayList<byte[]> j = new ArrayList();
  private final ByteOrder k;

  b(ByteOrder paramByteOrder)
  {
    k = paramByteOrder;
  }

  protected f a(short paramShort, int paramInt)
  {
    g localg = h[paramInt];
    if (localg == null)
      return null;
    return localg.f(paramShort);
  }

  protected g a(int paramInt)
  {
    if (f.k(paramInt))
      return h[paramInt];
    return null;
  }

  protected void a(int paramInt, byte[] paramArrayOfByte)
  {
    if (paramInt < j.size())
    {
      j.set(paramInt, paramArrayOfByte);
      return;
    }
    int m = j.size();
    while (m < paramInt)
    {
      j.add(null);
      m += 1;
    }
    j.add(paramArrayOfByte);
  }

  protected void a(g paramg)
  {
    h[paramg.getId()] = paramg;
  }

  protected void b(byte[] paramArrayOfByte)
  {
    i = paramArrayOfByte;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject)
      return true;
    if (paramObject == null)
      return false;
    if ((paramObject instanceof b))
    {
      paramObject = (b)paramObject;
      if ((paramObject.k != k) || (paramObject.j.size() != j.size()) || (!Arrays.equals(paramObject.i, i)))
        return false;
      int m = 0;
      while (m < j.size())
      {
        if (!Arrays.equals((byte[])paramObject.j.get(m), (byte[])j.get(m)))
          return false;
        m += 1;
      }
      m = 0;
      while (m < 5)
      {
        g localg1 = paramObject.a(m);
        g localg2 = a(m);
        if ((localg1 != localg2) && (localg1 != null) && (!localg1.equals(localg2)))
          return false;
        m += 1;
      }
      return true;
    }
    return false;
  }
}