package com.google.android.gallery3d.exif;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class f
{
  private static Charset US_ASCII = Charset.forName("US-ASCII");
  private static final int[] cr = new int[11];
  private static final SimpleDateFormat cy = new SimpleDateFormat("yyyy:MM:dd kk:mm:ss");
  private final short cs;
  private final short ct;
  private boolean cu;
  private int cv;
  private int cw;
  private Object cx;
  private int mOffset;

  static
  {
    cr[1] = 1;
    cr[2] = 1;
    cr[3] = 2;
    cr[4] = 4;
    cr[5] = 8;
    cr[7] = 1;
    cr[9] = 4;
    cr[10] = 8;
  }

  f(short paramShort1, short paramShort2, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    cs = paramShort1;
    ct = paramShort2;
    cv = paramInt1;
    cu = paramBoolean;
    cw = paramInt2;
    cx = null;
  }

  private boolean b(long[] paramArrayOfLong)
  {
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      long l = paramArrayOfLong[i];
      if ((l < 0L) || (l > 4294967295L))
        return true;
      i += 1;
    }
    return false;
  }

  private boolean b(i[] paramArrayOfi)
  {
    int j = paramArrayOfi.length;
    int i = 0;
    while (i < j)
    {
      i locali = paramArrayOfi[i];
      if ((locali.D() < 0L) || (locali.E() < 0L) || (locali.D() > 4294967295L) || (locali.E() > 4294967295L))
        return true;
      i += 1;
    }
    return false;
  }

  public static boolean c(short paramShort)
  {
    return (paramShort == 1) || (paramShort == 2) || (paramShort == 3) || (paramShort == 4) || (paramShort == 5) || (paramShort == 7) || (paramShort == 9) || (paramShort == 10);
  }

  private boolean c(int[] paramArrayOfInt)
  {
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      if ((k > 65535) || (k < 0))
        return true;
      i += 1;
    }
    return false;
  }

  private boolean c(i[] paramArrayOfi)
  {
    int j = paramArrayOfi.length;
    int i = 0;
    while (i < j)
    {
      i locali = paramArrayOfi[i];
      if ((locali.D() < -2147483648L) || (locali.E() < -2147483648L) || (locali.D() > 2147483647L) || (locali.E() > 2147483647L))
        return true;
      i += 1;
    }
    return false;
  }

  public static int d(short paramShort)
  {
    return cr[paramShort];
  }

  private boolean d(int[] paramArrayOfInt)
  {
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      if (paramArrayOfInt[i] < 0)
        return true;
      i += 1;
    }
    return false;
  }

  private static String e(short paramShort)
  {
    switch (paramShort)
    {
    case 6:
    case 8:
    default:
      return "";
    case 1:
      return "UNSIGNED_BYTE";
    case 2:
      return "ASCII";
    case 3:
      return "UNSIGNED_SHORT";
    case 4:
      return "UNSIGNED_LONG";
    case 5:
      return "UNSIGNED_RATIONAL";
    case 7:
      return "UNDEFINED";
    case 9:
      return "LONG";
    case 10:
    }
    return "RATIONAL";
  }

  public static boolean k(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1) || (paramInt == 2) || (paramInt == 3) || (paramInt == 4);
  }

  private boolean p(int paramInt)
  {
    return (cu) && (cv != paramInt);
  }

  protected void a(boolean paramBoolean)
  {
    cu = paramBoolean;
  }

  public boolean a(long[] paramArrayOfLong)
  {
    if ((p(paramArrayOfLong.length)) || (ct != 4));
    while (b(paramArrayOfLong))
      return false;
    cx = paramArrayOfLong;
    cv = paramArrayOfLong.length;
    return true;
  }

  public boolean a(i[] paramArrayOfi)
  {
    if (p(paramArrayOfi.length));
    while (((ct != 5) && (ct != 10)) || ((ct == 5) && (b(paramArrayOfi))) || ((ct == 10) && (c(paramArrayOfi))))
      return false;
    cx = paramArrayOfi;
    cv = paramArrayOfi.length;
    return true;
  }

  public boolean b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (p(paramInt2));
    while ((ct != 1) && (ct != 7))
      return false;
    cx = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, cx, 0, paramInt2);
    cv = paramInt2;
    return true;
  }

  public boolean b(int[] paramArrayOfInt)
  {
    if (p(paramArrayOfInt.length));
    while (((ct != 3) && (ct != 9) && (ct != 4)) || ((ct == 3) && (c(paramArrayOfInt))) || ((ct == 4) && (d(paramArrayOfInt))))
      return false;
    long[] arrayOfLong = new long[paramArrayOfInt.length];
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      arrayOfLong[i] = paramArrayOfInt[i];
      i += 1;
    }
    cx = arrayOfLong;
    cv = paramArrayOfInt.length;
    return true;
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == null);
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                  return false;
                while (!(paramObject instanceof f));
                paramObject = (f)paramObject;
              }
              while ((paramObject.cs != cs) || (paramObject.cv != cv) || (paramObject.ct != ct));
              if (cx == null)
                break;
            }
            while (paramObject.cx == null);
            if (!(cx instanceof long[]))
              break;
          }
          while (!(paramObject.cx instanceof long[]));
          return Arrays.equals((long[])cx, (long[])paramObject.cx);
          if (!(cx instanceof i[]))
            break;
        }
        while (!(paramObject.cx instanceof i[]));
        return Arrays.equals((i[])cx, (i[])paramObject.cx);
        if (!(cx instanceof byte[]))
          break;
      }
      while (!(paramObject.cx instanceof byte[]));
      return Arrays.equals((byte[])cx, (byte[])paramObject.cx);
      return cx.equals(paramObject.cx);
    }
    while (paramObject.cx != null);
    return true;
  }

  public int getDataSize()
  {
    return w() * d(v());
  }

  protected int getOffset()
  {
    return mOffset;
  }

  public boolean hasValue()
  {
    return cx != null;
  }

  protected void l(int paramInt)
  {
    cw = paramInt;
  }

  protected void m(int paramInt)
  {
    cv = paramInt;
  }

  public int n(int paramInt)
  {
    int[] arrayOfInt = x();
    if ((arrayOfInt == null) || (arrayOfInt.length < 1))
      return paramInt;
    return arrayOfInt[0];
  }

  protected long o(int paramInt)
  {
    if ((cx instanceof long[]))
      return ((long[])(long[])cx)[paramInt];
    if ((cx instanceof byte[]))
      return ((byte[])(byte[])cx)[paramInt];
    throw new IllegalArgumentException("Cannot get integer value from " + e(ct));
  }

  protected void setOffset(int paramInt)
  {
    mOffset = paramInt;
  }

  public boolean setValue(String paramString)
  {
    if ((ct != 2) && (ct != 7))
      return false;
    paramString = paramString.getBytes(US_ASCII);
    String str = paramString;
    if (paramString.length > 0)
      if ((paramString[(paramString.length - 1)] != 0) && (ct != 7));
    while (true)
    {
      int i = paramString.length;
      if (p(i))
        break;
      cv = i;
      cx = paramString;
      return true;
      paramString = Arrays.copyOf(paramString, paramString.length + 1);
      continue;
      paramString = str;
      if (ct == 2)
      {
        paramString = str;
        if (cv == 1)
        {
          paramString = new byte[1];
          paramString[0] = 0;
        }
      }
    }
  }

  public boolean setValue(byte[] paramArrayOfByte)
  {
    return b(paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  public int t()
  {
    return cw;
  }

  public String toString()
  {
    return String.format("tag id: %04X\n", new Object[] { Short.valueOf(cs) }) + "ifd id: " + cw + "\ntype: " + e(ct) + "\ncount: " + cv + "\noffset: " + mOffset + "\nvalue: " + y() + "\n";
  }

  public short u()
  {
    return cs;
  }

  public short v()
  {
    return ct;
  }

  public int w()
  {
    return cv;
  }

  public int[] x()
  {
    Object localObject = null;
    if (cx == null);
    while (!(cx instanceof long[]))
      return localObject;
    long[] arrayOfLong = (long[])cx;
    int[] arrayOfInt = new int[arrayOfLong.length];
    int i = 0;
    while (true)
    {
      localObject = arrayOfInt;
      if (i >= arrayOfLong.length)
        break;
      arrayOfInt[i] = ((int)arrayOfLong[i]);
      i += 1;
    }
  }

  public String y()
  {
    if (cx == null)
      return "";
    if ((cx instanceof byte[]))
    {
      if (ct == 2)
        return new String((byte[])cx, US_ASCII);
      return Arrays.toString((byte[])cx);
    }
    if ((cx instanceof long[]))
    {
      if (((long[])cx).length == 1)
        return String.valueOf(((long[])(long[])cx)[0]);
      return Arrays.toString((long[])cx);
    }
    if ((cx instanceof Object[]))
    {
      if (((Object[])cx).length == 1)
      {
        Object localObject = ((Object[])(Object[])cx)[0];
        if (localObject == null)
          return "";
        return localObject.toString();
      }
      return Arrays.toString((Object[])cx);
    }
    return cx.toString();
  }

  protected boolean z()
  {
    return cu;
  }
}