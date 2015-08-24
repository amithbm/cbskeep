package com.google.android.gms.internal;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ReadOnlyBufferException;

public final class zzadp
{
  private final ByteBuffer zzbJL;

  private zzadp(ByteBuffer paramByteBuffer)
  {
    zzbJL = paramByteBuffer;
  }

  private zzadp(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this(ByteBuffer.wrap(paramArrayOfByte, paramInt1, paramInt2));
  }

  public static int zzR(int paramInt1, int paramInt2)
  {
    return zzse(paramInt1) + zzsb(paramInt2);
  }

  public static zzadp zzR(byte[] paramArrayOfByte)
  {
    return zzb(paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  public static int zzS(int paramInt1, int paramInt2)
  {
    return zzse(paramInt1) + zzsc(paramInt2);
  }

  public static int zzT(byte[] paramArrayOfByte)
  {
    return zzsg(paramArrayOfByte.length) + paramArrayOfByte.length;
  }

  private static int zza(CharSequence paramCharSequence, int paramInt)
  {
    int m = paramCharSequence.length();
    int i = 0;
    if (paramInt < m)
    {
      int n = paramCharSequence.charAt(paramInt);
      int j;
      if (n < 2048)
      {
        i += (127 - n >>> 31);
        j = paramInt;
      }
      while (true)
      {
        paramInt = j + 1;
        break;
        int k = i + 2;
        j = paramInt;
        i = k;
        if (55296 <= n)
        {
          j = paramInt;
          i = k;
          if (n <= 57343)
          {
            if (Character.codePointAt(paramCharSequence, paramInt) < 65536)
              throw new IllegalArgumentException("Unpaired surrogate at index " + paramInt);
            j = paramInt + 1;
            i = k;
          }
        }
      }
    }
    return i;
  }

  private static int zza(CharSequence paramCharSequence, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int k = paramCharSequence.length();
    int j = 0;
    int m = paramInt1 + paramInt2;
    paramInt2 = j;
    while ((paramInt2 < k) && (paramInt2 + paramInt1 < m))
    {
      j = paramCharSequence.charAt(paramInt2);
      if (j >= 128)
        break;
      paramArrayOfByte[(paramInt1 + paramInt2)] = ((byte)j);
      paramInt2 += 1;
    }
    if (paramInt2 == k)
      return paramInt1 + k;
    paramInt1 += paramInt2;
    if (paramInt2 < k)
    {
      int i = paramCharSequence.charAt(paramInt2);
      if ((i < 128) && (paramInt1 < m))
      {
        j = paramInt1 + 1;
        paramArrayOfByte[paramInt1] = ((byte)i);
        paramInt1 = j;
      }
      while (true)
      {
        paramInt2 += 1;
        break;
        if ((i < 2048) && (paramInt1 <= m - 2))
        {
          j = paramInt1 + 1;
          paramArrayOfByte[paramInt1] = ((byte)(i >>> 6 | 0x3C0));
          paramInt1 = j + 1;
          paramArrayOfByte[j] = ((byte)(i & 0x3F | 0x80));
        }
        else
        {
          int n;
          if (((i < 55296) || (57343 < i)) && (paramInt1 <= m - 3))
          {
            j = paramInt1 + 1;
            paramArrayOfByte[paramInt1] = ((byte)(i >>> 12 | 0x1E0));
            n = j + 1;
            paramArrayOfByte[j] = ((byte)(i >>> 6 & 0x3F | 0x80));
            paramInt1 = n + 1;
            paramArrayOfByte[n] = ((byte)(i & 0x3F | 0x80));
          }
          else
          {
            if (paramInt1 > m - 4)
              break label442;
            j = paramInt2;
            char c;
            if (paramInt2 + 1 != paramCharSequence.length())
            {
              paramInt2 += 1;
              c = paramCharSequence.charAt(paramInt2);
              if (!Character.isSurrogatePair(i, c))
                j = paramInt2;
            }
            else
            {
              throw new IllegalArgumentException("Unpaired surrogate at index " + (j - 1));
            }
            j = Character.toCodePoint(i, c);
            n = paramInt1 + 1;
            paramArrayOfByte[paramInt1] = ((byte)(j >>> 18 | 0xF0));
            paramInt1 = n + 1;
            paramArrayOfByte[n] = ((byte)(j >>> 12 & 0x3F | 0x80));
            n = paramInt1 + 1;
            paramArrayOfByte[paramInt1] = ((byte)(j >>> 6 & 0x3F | 0x80));
            paramInt1 = n + 1;
            paramArrayOfByte[n] = ((byte)(j & 0x3F | 0x80));
          }
        }
      }
      label442: throw new ArrayIndexOutOfBoundsException("Failed writing " + i + " at index " + paramInt1);
    }
    return paramInt1;
  }

  private static void zza(CharSequence paramCharSequence, ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer.isReadOnly())
      throw new ReadOnlyBufferException();
    if (paramByteBuffer.hasArray())
      try
      {
        paramByteBuffer.position(zza(paramCharSequence, paramByteBuffer.array(), paramByteBuffer.arrayOffset() + paramByteBuffer.position(), paramByteBuffer.remaining()) - paramByteBuffer.arrayOffset());
        return;
      }
      catch (ArrayIndexOutOfBoundsException paramCharSequence)
      {
        paramByteBuffer = new BufferOverflowException();
        paramByteBuffer.initCause(paramCharSequence);
        throw paramByteBuffer;
      }
    zzb(paramCharSequence, paramByteBuffer);
  }

  public static int zzan(long paramLong)
  {
    return zzar(paramLong);
  }

  public static int zzap(long paramLong)
  {
    return zzar(zzat(paramLong));
  }

  public static int zzar(long paramLong)
  {
    if ((0xFFFFFF80 & paramLong) == 0L)
      return 1;
    if ((0xFFFFC000 & paramLong) == 0L)
      return 2;
    if ((0xFFE00000 & paramLong) == 0L)
      return 3;
    if ((0xF0000000 & paramLong) == 0L)
      return 4;
    if ((0x0 & paramLong) == 0L)
      return 5;
    if ((0x0 & paramLong) == 0L)
      return 6;
    if ((0x0 & paramLong) == 0L)
      return 7;
    if ((0x0 & paramLong) == 0L)
      return 8;
    if ((0x0 & paramLong) == 0L)
      return 9;
    return 10;
  }

  public static int zzat(boolean paramBoolean)
  {
    return 1;
  }

  public static long zzat(long paramLong)
  {
    return paramLong << 1 ^ paramLong >> 63;
  }

  public static int zzb(int paramInt, double paramDouble)
  {
    return zzse(paramInt) + zzi(paramDouble);
  }

  public static int zzb(int paramInt, zzadx paramzzadx)
  {
    return zzse(paramInt) * 2 + zzd(paramzzadx);
  }

  public static int zzb(int paramInt, byte[] paramArrayOfByte)
  {
    return zzse(paramInt) + zzT(paramArrayOfByte);
  }

  public static zzadp zzb(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new zzadp(paramArrayOfByte, paramInt1, paramInt2);
  }

  private static void zzb(CharSequence paramCharSequence, ByteBuffer paramByteBuffer)
  {
    int m = paramCharSequence.length();
    int j = 0;
    if (j < m)
    {
      int i = paramCharSequence.charAt(j);
      if (i < 128)
        paramByteBuffer.put((byte)i);
      while (true)
      {
        j += 1;
        break;
        if (i < 2048)
        {
          paramByteBuffer.put((byte)(i >>> 6 | 0x3C0));
          paramByteBuffer.put((byte)(i & 0x3F | 0x80));
        }
        else if ((i < 55296) || (57343 < i))
        {
          paramByteBuffer.put((byte)(i >>> 12 | 0x1E0));
          paramByteBuffer.put((byte)(i >>> 6 & 0x3F | 0x80));
          paramByteBuffer.put((byte)(i & 0x3F | 0x80));
        }
        else
        {
          int k = j;
          char c;
          if (j + 1 != paramCharSequence.length())
          {
            j += 1;
            c = paramCharSequence.charAt(j);
            if (!Character.isSurrogatePair(i, c))
              k = j;
          }
          else
          {
            throw new IllegalArgumentException("Unpaired surrogate at index " + (k - 1));
          }
          k = Character.toCodePoint(i, c);
          paramByteBuffer.put((byte)(k >>> 18 | 0xF0));
          paramByteBuffer.put((byte)(k >>> 12 & 0x3F | 0x80));
          paramByteBuffer.put((byte)(k >>> 6 & 0x3F | 0x80));
          paramByteBuffer.put((byte)(k & 0x3F | 0x80));
        }
      }
    }
  }

  public static int zzc(int paramInt, float paramFloat)
  {
    return zzse(paramInt) + zzj(paramFloat);
  }

  public static int zzc(int paramInt, zzadx paramzzadx)
  {
    return zzse(paramInt) + zze(paramzzadx);
  }

  private static int zzc(CharSequence paramCharSequence)
  {
    int m = paramCharSequence.length();
    int i = 0;
    while ((i < m) && (paramCharSequence.charAt(i) < ''))
      i += 1;
    while (true)
    {
      int k = i;
      int j;
      if (j < m)
      {
        k = paramCharSequence.charAt(j);
        if (k < 2048)
        {
          j += 1;
          i = (127 - k >>> 31) + i;
        }
        else
        {
          k = i + zza(paramCharSequence, j);
        }
      }
      else
      {
        if (k < m)
          throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (k + 4294967296L));
        return k;
        j = i;
        i = m;
      }
    }
  }

  public static int zzd(zzadx paramzzadx)
  {
    return paramzzadx.zzHQ();
  }

  public static int zze(int paramInt, boolean paramBoolean)
  {
    return zzse(paramInt) + zzat(paramBoolean);
  }

  public static int zze(zzadx paramzzadx)
  {
    int i = paramzzadx.zzHQ();
    return i + zzsg(i);
  }

  public static int zzgf(String paramString)
  {
    int i = zzc(paramString);
    return i + zzsg(i);
  }

  public static int zzi(double paramDouble)
  {
    return 8;
  }

  public static int zzi(int paramInt, long paramLong)
  {
    return zzse(paramInt) + zzan(paramLong);
  }

  public static int zzj(float paramFloat)
  {
    return 4;
  }

  public static int zzk(int paramInt, long paramLong)
  {
    return zzse(paramInt) + zzap(paramLong);
  }

  public static int zzm(int paramInt, String paramString)
  {
    return zzse(paramInt) + zzgf(paramString);
  }

  public static int zzsb(int paramInt)
  {
    if (paramInt >= 0)
      return zzsg(paramInt);
    return 10;
  }

  public static int zzsc(int paramInt)
  {
    return zzsg(zzsi(paramInt));
  }

  public static int zzse(int paramInt)
  {
    return zzsg(zzaea.zzU(paramInt, 0));
  }

  public static int zzsg(int paramInt)
  {
    if ((paramInt & 0xFFFFFF80) == 0)
      return 1;
    if ((paramInt & 0xFFFFC000) == 0)
      return 2;
    if ((0xFFE00000 & paramInt) == 0)
      return 3;
    if ((0xF0000000 & paramInt) == 0)
      return 4;
    return 5;
  }

  public static int zzsi(int paramInt)
  {
    return paramInt << 1 ^ paramInt >> 31;
  }

  public int zzHB()
  {
    return zzbJL.remaining();
  }

  public void zzHC()
  {
    if (zzHB() != 0)
      throw new IllegalStateException("Did not write as much data as expected.");
  }

  public void zzP(int paramInt1, int paramInt2)
    throws IOException
  {
    zzT(paramInt1, 0);
    zzrZ(paramInt2);
  }

  public void zzQ(int paramInt1, int paramInt2)
    throws IOException
  {
    zzT(paramInt1, 0);
    zzsa(paramInt2);
  }

  public void zzS(byte[] paramArrayOfByte)
    throws IOException
  {
    zzsf(paramArrayOfByte.length);
    zzU(paramArrayOfByte);
  }

  public void zzT(int paramInt1, int paramInt2)
    throws IOException
  {
    zzsf(zzaea.zzU(paramInt1, paramInt2));
  }

  public void zzU(byte[] paramArrayOfByte)
    throws IOException
  {
    zzc(paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  public void zza(int paramInt, double paramDouble)
    throws IOException
  {
    zzT(paramInt, 1);
    zzh(paramDouble);
  }

  public void zza(int paramInt, zzadx paramzzadx)
    throws IOException
  {
    zzT(paramInt, 2);
    zzc(paramzzadx);
  }

  public void zza(int paramInt, byte[] paramArrayOfByte)
    throws IOException
  {
    zzT(paramInt, 2);
    zzS(paramArrayOfByte);
  }

  public void zzak(long paramLong)
    throws IOException
  {
    zzaq(paramLong);
  }

  public void zzam(long paramLong)
    throws IOException
  {
    zzaq(zzat(paramLong));
  }

  public void zzaq(long paramLong)
    throws IOException
  {
    while (true)
    {
      if ((0xFFFFFF80 & paramLong) == 0L)
      {
        zzsd((int)paramLong);
        return;
      }
      zzsd((int)paramLong & 0x7F | 0x80);
      paramLong >>>= 7;
    }
  }

  public void zzas(long paramLong)
    throws IOException
  {
    zzsd((int)paramLong & 0xFF);
    zzsd((int)(paramLong >> 8) & 0xFF);
    zzsd((int)(paramLong >> 16) & 0xFF);
    zzsd((int)(paramLong >> 24) & 0xFF);
    zzsd((int)(paramLong >> 32) & 0xFF);
    zzsd((int)(paramLong >> 40) & 0xFF);
    zzsd((int)(paramLong >> 48) & 0xFF);
    zzsd((int)(paramLong >> 56) & 0xFF);
  }

  public void zzas(boolean paramBoolean)
    throws IOException
  {
    if (paramBoolean);
    for (int i = 1; ; i = 0)
    {
      zzsd(i);
      return;
    }
  }

  public void zzb(byte paramByte)
    throws IOException
  {
    if (!zzbJL.hasRemaining())
      throw new zza(zzbJL.position(), zzbJL.limit());
    zzbJL.put(paramByte);
  }

  public void zzb(int paramInt, float paramFloat)
    throws IOException
  {
    zzT(paramInt, 5);
    zzi(paramFloat);
  }

  public void zzb(int paramInt, long paramLong)
    throws IOException
  {
    zzT(paramInt, 0);
    zzak(paramLong);
  }

  public void zzb(int paramInt, String paramString)
    throws IOException
  {
    zzT(paramInt, 2);
    zzge(paramString);
  }

  public void zzb(zzadx paramzzadx)
    throws IOException
  {
    paramzzadx.zza(this);
  }

  public void zzc(zzadx paramzzadx)
    throws IOException
  {
    zzsf(paramzzadx.zzHP());
    paramzzadx.zza(this);
  }

  public void zzc(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (zzbJL.remaining() >= paramInt2)
    {
      zzbJL.put(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    throw new zza(zzbJL.position(), zzbJL.limit());
  }

  public void zzd(int paramInt, boolean paramBoolean)
    throws IOException
  {
    zzT(paramInt, 0);
    zzas(paramBoolean);
  }

  public void zzge(String paramString)
    throws IOException
  {
    try
    {
      int i = zzsg(paramString.length());
      if (i == zzsg(paramString.length() * 3))
      {
        int j = zzbJL.position();
        zzbJL.position(j + i);
        zza(paramString, zzbJL);
        int k = zzbJL.position();
        zzbJL.position(j);
        zzsf(k - j - i);
        zzbJL.position(k);
        return;
      }
      zzsf(zzc(paramString));
      zza(paramString, zzbJL);
      return;
    }
    catch (BufferOverflowException paramString)
    {
    }
    throw new zza(zzbJL.position(), zzbJL.limit());
  }

  public void zzh(double paramDouble)
    throws IOException
  {
    zzas(Double.doubleToLongBits(paramDouble));
  }

  public void zzh(int paramInt, long paramLong)
    throws IOException
  {
    zzT(paramInt, 0);
    zzam(paramLong);
  }

  public void zzi(float paramFloat)
    throws IOException
  {
    zzsh(Float.floatToIntBits(paramFloat));
  }

  public void zzrZ(int paramInt)
    throws IOException
  {
    if (paramInt >= 0)
    {
      zzsf(paramInt);
      return;
    }
    zzaq(paramInt);
  }

  public void zzsa(int paramInt)
    throws IOException
  {
    zzsf(zzsi(paramInt));
  }

  public void zzsd(int paramInt)
    throws IOException
  {
    zzb((byte)paramInt);
  }

  public void zzsf(int paramInt)
    throws IOException
  {
    while (true)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        zzsd(paramInt);
        return;
      }
      zzsd(paramInt & 0x7F | 0x80);
      paramInt >>>= 7;
    }
  }

  public void zzsh(int paramInt)
    throws IOException
  {
    zzsd(paramInt & 0xFF);
    zzsd(paramInt >> 8 & 0xFF);
    zzsd(paramInt >> 16 & 0xFF);
    zzsd(paramInt >> 24 & 0xFF);
  }

  public static class zza extends IOException
  {
    zza(int paramInt1, int paramInt2)
    {
      super();
    }
  }
}