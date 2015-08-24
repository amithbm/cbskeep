package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Array;

public class zzadr<M extends zzadq<M>, T>
{
  public final int tag;
  protected final int type;
  protected final Class<T> zzbJN;
  protected final boolean zzbJO;

  void zza(Object paramObject, zzadp paramzzadp)
    throws IOException
  {
    if (zzbJO)
    {
      zzc(paramObject, paramzzadp);
      return;
    }
    zzb(paramObject, paramzzadp);
  }

  int zzab(Object paramObject)
  {
    if (zzbJO)
      return zzac(paramObject);
    return zzad(paramObject);
  }

  protected int zzac(Object paramObject)
  {
    int j = 0;
    int m = Array.getLength(paramObject);
    int i = 0;
    while (i < m)
    {
      int k = j;
      if (Array.get(paramObject, i) != null)
        k = j + zzad(Array.get(paramObject, i));
      i += 1;
      j = k;
    }
    return j;
  }

  protected int zzad(Object paramObject)
  {
    int i = zzaea.zzso(tag);
    switch (type)
    {
    default:
      throw new IllegalArgumentException("Unknown type " + type);
    case 10:
      return zzadp.zzb(i, (zzadx)paramObject);
    case 11:
    }
    return zzadp.zzc(i, (zzadx)paramObject);
  }

  protected void zzb(Object paramObject, zzadp paramzzadp)
  {
    while (true)
    {
      try
      {
        paramzzadp.zzsf(tag);
        switch (type)
        {
        case 10:
          throw new IllegalArgumentException("Unknown type " + type);
        case 11:
        }
      }
      catch (IOException paramObject)
      {
        throw new IllegalStateException(paramObject);
      }
      paramObject = (zzadx)paramObject;
      int i = zzaea.zzso(tag);
      paramzzadp.zzb(paramObject);
      paramzzadp.zzT(i, 4);
      return;
      paramzzadp.zzc((zzadx)paramObject);
      return;
    }
  }

  protected void zzc(Object paramObject, zzadp paramzzadp)
  {
    int j = Array.getLength(paramObject);
    int i = 0;
    while (i < j)
    {
      Object localObject = Array.get(paramObject, i);
      if (localObject != null)
        zzb(localObject, paramzzadp);
      i += 1;
    }
  }
}