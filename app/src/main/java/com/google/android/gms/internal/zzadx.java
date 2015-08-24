package com.google.android.gms.internal;

import java.io.IOException;

public abstract class zzadx
{
  protected volatile int zzbJX = -1;

  public static final <T extends zzadx> T zza(T paramT, byte[] paramArrayOfByte)
    throws zzadw
  {
    return zzb(paramT, paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  public static final void zza(zzadx paramzzadx, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      paramArrayOfByte = zzadp.zzb(paramArrayOfByte, paramInt1, paramInt2);
      paramzzadx.zza(paramArrayOfByte);
      paramArrayOfByte.zzHC();
      return;
    }
    catch (IOException paramzzadx)
    {
    }
    throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", paramzzadx);
  }

  public static final <T extends zzadx> T zzb(T paramT, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws zzadw
  {
    try
    {
      paramArrayOfByte = zzado.zza(paramArrayOfByte, paramInt1, paramInt2);
      paramT.zzb(paramArrayOfByte);
      paramArrayOfByte.zzrR(0);
      return paramT;
    }
    catch (zzadw paramT)
    {
      throw paramT;
    }
    catch (IOException paramT)
    {
    }
    throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
  }

  public static final byte[] zzf(zzadx paramzzadx)
  {
    byte[] arrayOfByte = new byte[paramzzadx.zzHQ()];
    zza(paramzzadx, arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }

  public String toString()
  {
    return zzady.zzg(this);
  }

  protected int zzB()
  {
    return 0;
  }

  public zzadx zzHF()
    throws CloneNotSupportedException
  {
    return (zzadx)super.clone();
  }

  public int zzHP()
  {
    if (zzbJX < 0)
      zzHQ();
    return zzbJX;
  }

  public int zzHQ()
  {
    int i = zzB();
    zzbJX = i;
    return i;
  }

  public void zza(zzadp paramzzadp)
    throws IOException
  {
  }

  public abstract zzadx zzb(zzado paramzzado)
    throws IOException;
}