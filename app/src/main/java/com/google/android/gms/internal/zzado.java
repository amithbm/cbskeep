package com.google.android.gms.internal;

import java.io.IOException;

public final class zzado
{
  private final byte[] buffer;
  private int zzbJC;
  private int zzbJD;
  private int zzbJE;
  private int zzbJF;
  private int zzbJG;
  private int zzbJH = 2147483647;
  private int zzbJI;
  private int zzbJJ = 64;
  private int zzbJK = 67108864;

  private zzado(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    buffer = paramArrayOfByte;
    zzbJC = paramInt1;
    zzbJD = (paramInt1 + paramInt2);
    zzbJF = paramInt1;
  }

  private void zzHx()
  {
    zzbJD += zzbJE;
    int i = zzbJD;
    if (i > zzbJH)
    {
      zzbJE = (i - zzbJH);
      zzbJD -= zzbJE;
      return;
    }
    zzbJE = 0;
  }

  public static zzado zza(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new zzado(paramArrayOfByte, paramInt1, paramInt2);
  }

  public static long zzaj(long paramLong)
  {
    return paramLong >>> 1 ^ -(1L & paramLong);
  }

  public static int zzrT(int paramInt)
  {
    return paramInt >>> 1 ^ -(paramInt & 0x1);
  }

  public int getPosition()
  {
    return zzbJF - zzbJC;
  }

  public byte[] readBytes()
    throws IOException
  {
    int i = zzHt();
    if ((i <= zzbJD - zzbJF) && (i > 0))
    {
      byte[] arrayOfByte = new byte[i];
      System.arraycopy(buffer, zzbJF, arrayOfByte, 0, i);
      zzbJF = (i + zzbJF);
      return arrayOfByte;
    }
    return zzrX(i);
  }

  public double readDouble()
    throws IOException
  {
    return Double.longBitsToDouble(zzHw());
  }

  public float readFloat()
    throws IOException
  {
    return Float.intBitsToFloat(zzHv());
  }

  public String readString()
    throws IOException
  {
    int i = zzHt();
    if ((i <= zzbJD - zzbJF) && (i > 0))
    {
      String str = new String(buffer, zzbJF, i, "UTF-8");
      zzbJF = (i + zzbJF);
      return str;
    }
    return new String(zzrX(i), "UTF-8");
  }

  public byte zzHA()
    throws IOException
  {
    if (zzbJF == zzbJD)
      throw zzadw.zzHI();
    byte[] arrayOfByte = buffer;
    int i = zzbJF;
    zzbJF = (i + 1);
    return arrayOfByte[i];
  }

  public int zzHl()
    throws IOException
  {
    if (zzHz())
    {
      zzbJG = 0;
      return 0;
    }
    zzbJG = zzHt();
    if (zzbJG == 0)
      throw zzadw.zzHL();
    return zzbJG;
  }

  public void zzHm()
    throws IOException
  {
    int i;
    do
      i = zzHl();
    while ((i != 0) && (zzrS(i)));
  }

  public long zzHn()
    throws IOException
  {
    return zzHu();
  }

  public int zzHo()
    throws IOException
  {
    return zzHt();
  }

  public boolean zzHq()
    throws IOException
  {
    return zzHt() != 0;
  }

  public int zzHr()
    throws IOException
  {
    return zzrT(zzHt());
  }

  public long zzHs()
    throws IOException
  {
    return zzaj(zzHu());
  }

  public int zzHt()
    throws IOException
  {
    int i = zzHA();
    if (i >= 0);
    int k;
    do
    {
      return i;
      i &= 127;
      j = zzHA();
      if (j >= 0)
        return i | j << 7;
      i |= (j & 0x7F) << 7;
      j = zzHA();
      if (j >= 0)
        return i | j << 14;
      i |= (j & 0x7F) << 14;
      k = zzHA();
      if (k >= 0)
        return i | k << 21;
      j = zzHA();
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
      if (zzHA() >= 0)
        break;
      j += 1;
    }
    label133: throw zzadw.zzHK();
  }

  public long zzHu()
    throws IOException
  {
    int i = 0;
    long l = 0L;
    while (i < 64)
    {
      int j = zzHA();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0)
        return l;
      i += 7;
    }
    throw zzadw.zzHK();
  }

  public int zzHv()
    throws IOException
  {
    return zzHA() & 0xFF | (zzHA() & 0xFF) << 8 | (zzHA() & 0xFF) << 16 | (zzHA() & 0xFF) << 24;
  }

  public long zzHw()
    throws IOException
  {
    int i = zzHA();
    int j = zzHA();
    int k = zzHA();
    int m = zzHA();
    int n = zzHA();
    int i1 = zzHA();
    int i2 = zzHA();
    int i3 = zzHA();
    long l = i;
    return (j & 0xFF) << 8 | l & 0xFF | (k & 0xFF) << 16 | (m & 0xFF) << 24 | (n & 0xFF) << 32 | (i1 & 0xFF) << 40 | (i2 & 0xFF) << 48 | (i3 & 0xFF) << 56;
  }

  public int zzHy()
  {
    if (zzbJH == 2147483647)
      return -1;
    int i = zzbJF;
    return zzbJH - i;
  }

  public boolean zzHz()
  {
    return zzbJF == zzbJD;
  }

  public byte[] zzO(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
      return zzaea.zzbKg;
    byte[] arrayOfByte = new byte[paramInt2];
    int i = zzbJC;
    System.arraycopy(buffer, i + paramInt1, arrayOfByte, 0, paramInt2);
    return arrayOfByte;
  }

  public void zza(zzadx paramzzadx)
    throws IOException
  {
    int i = zzHt();
    if (zzbJI >= zzbJJ)
      throw zzadw.zzHO();
    i = zzrU(i);
    zzbJI += 1;
    paramzzadx.zzb(this);
    zzrR(0);
    zzbJI -= 1;
    zzrV(i);
  }

  public void zzrR(int paramInt)
    throws zzadw
  {
    if (zzbJG != paramInt)
      throw zzadw.zzHM();
  }

  public boolean zzrS(int paramInt)
    throws IOException
  {
    switch (zzaea.zzsn(paramInt))
    {
    default:
      throw zzadw.zzHN();
    case 0:
      zzHo();
      return true;
    case 1:
      zzHw();
      return true;
    case 2:
      zzrY(zzHt());
      return true;
    case 3:
      zzHm();
      zzrR(zzaea.zzU(zzaea.zzso(paramInt), 4));
      return true;
    case 4:
      return false;
    case 5:
    }
    zzHv();
    return true;
  }

  public int zzrU(int paramInt)
    throws zzadw
  {
    if (paramInt < 0)
      throw zzadw.zzHJ();
    paramInt = zzbJF + paramInt;
    int i = zzbJH;
    if (paramInt > i)
      throw zzadw.zzHI();
    zzbJH = paramInt;
    zzHx();
    return i;
  }

  public void zzrV(int paramInt)
  {
    zzbJH = paramInt;
    zzHx();
  }

  public void zzrW(int paramInt)
  {
    if (paramInt > zzbJF - zzbJC)
      throw new IllegalArgumentException("Position " + paramInt + " is beyond current " + (zzbJF - zzbJC));
    if (paramInt < 0)
      throw new IllegalArgumentException("Bad position " + paramInt);
    zzbJF = (zzbJC + paramInt);
  }

  public byte[] zzrX(int paramInt)
    throws IOException
  {
    if (paramInt < 0)
      throw zzadw.zzHJ();
    if (zzbJF + paramInt > zzbJH)
    {
      zzrY(zzbJH - zzbJF);
      throw zzadw.zzHI();
    }
    if (paramInt <= zzbJD - zzbJF)
    {
      byte[] arrayOfByte = new byte[paramInt];
      System.arraycopy(buffer, zzbJF, arrayOfByte, 0, paramInt);
      zzbJF += paramInt;
      return arrayOfByte;
    }
    throw zzadw.zzHI();
  }

  public void zzrY(int paramInt)
    throws IOException
  {
    if (paramInt < 0)
      throw zzadw.zzHJ();
    if (zzbJF + paramInt > zzbJH)
    {
      zzrY(zzbJH - zzbJF);
      throw zzadw.zzHI();
    }
    if (paramInt <= zzbJD - zzbJF)
    {
      zzbJF += paramInt;
      return;
    }
    throw zzadw.zzHI();
  }
}