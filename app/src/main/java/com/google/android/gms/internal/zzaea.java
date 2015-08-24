package com.google.android.gms.internal;

import java.io.IOException;

public final class zzaea
{
  public static final int[] zzbJZ = new int[0];
  public static final long[] zzbKa = new long[0];
  public static final float[] zzbKb = new float[0];
  public static final double[] zzbKc = new double[0];
  public static final boolean[] zzbKd = new boolean[0];
  public static final String[] zzbKe = new String[0];
  public static final byte[][] zzbKf = new byte[0][];
  public static final byte[] zzbKg = new byte[0];

  static int zzU(int paramInt1, int paramInt2)
  {
    return paramInt1 << 3 | paramInt2;
  }

  public static final int zzc(zzado paramzzado, int paramInt)
    throws IOException
  {
    int i = 1;
    int j = paramzzado.getPosition();
    paramzzado.zzrS(paramInt);
    while (paramzzado.zzHl() == paramInt)
    {
      paramzzado.zzrS(paramInt);
      i += 1;
    }
    paramzzado.zzrW(j);
    return i;
  }

  static int zzsn(int paramInt)
  {
    return paramInt & 0x7;
  }

  public static int zzso(int paramInt)
  {
    return paramInt >>> 3;
  }
}