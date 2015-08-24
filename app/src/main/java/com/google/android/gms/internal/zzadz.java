package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

final class zzadz
{
  final int tag;
  final byte[] zzbJY;

  zzadz(int paramInt, byte[] paramArrayOfByte)
  {
    tag = paramInt;
    zzbJY = paramArrayOfByte;
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this);
    do
    {
      return true;
      if (!(paramObject instanceof zzadz))
        return false;
      paramObject = (zzadz)paramObject;
    }
    while ((tag == paramObject.tag) && (Arrays.equals(zzbJY, paramObject.zzbJY)));
    return false;
  }

  public int hashCode()
  {
    return (tag + 527) * 31 + Arrays.hashCode(zzbJY);
  }

  int zzB()
  {
    return 0 + zzadp.zzsg(tag) + zzbJY.length;
  }

  void zza(zzadp paramzzadp)
    throws IOException
  {
    paramzzadp.zzsf(tag);
    paramzzadp.zzU(zzbJY);
  }
}