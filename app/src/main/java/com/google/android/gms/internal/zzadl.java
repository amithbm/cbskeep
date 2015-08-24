package com.google.android.gms.internal;

import java.io.IOException;

public final class zzadl extends zzadq<zzadl>
{
  public String[] zzbJu;
  public int[] zzbJv;
  public byte[][] zzbJw;

  public zzadl()
  {
    zzHj();
  }

  public static zzadl zzO(byte[] paramArrayOfByte)
    throws zzadw
  {
    return (zzadl)zzadx.zza(new zzadl(), paramArrayOfByte);
  }

  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramObject == this)
      bool1 = true;
    do
    {
      do
      {
        do
        {
          do
          {
            return bool1;
            bool1 = bool2;
          }
          while (!(paramObject instanceof zzadl));
          paramObject = (zzadl)paramObject;
          bool1 = bool2;
        }
        while (!zzadv.equals(zzbJu, paramObject.zzbJu));
        bool1 = bool2;
      }
      while (!zzadv.equals(zzbJv, paramObject.zzbJv));
      bool1 = bool2;
    }
    while (!zzadv.zza(zzbJw, paramObject.zzbJw));
    return zza(paramObject);
  }

  public int hashCode()
  {
    return (((zzadv.hashCode(zzbJu) + 527) * 31 + zzadv.hashCode(zzbJv)) * 31 + zzadv.zzb(zzbJw)) * 31 + zzHD();
  }

  protected int zzB()
  {
    int i1 = 0;
    int i2 = super.zzB();
    int i;
    int k;
    Object localObject;
    int n;
    int m;
    if ((zzbJu != null) && (zzbJu.length > 0))
    {
      i = 0;
      j = 0;
      for (k = 0; i < zzbJu.length; k = m)
      {
        localObject = zzbJu[i];
        n = j;
        m = k;
        if (localObject != null)
        {
          m = k + 1;
          n = j + zzadp.zzgf((String)localObject);
        }
        i += 1;
        j = n;
      }
    }
    for (int j = i2 + j + k * 1; ; j = i2)
    {
      i = j;
      if (zzbJv != null)
      {
        i = j;
        if (zzbJv.length > 0)
        {
          i = 0;
          k = 0;
          while (i < zzbJv.length)
          {
            k += zzadp.zzsb(zzbJv[i]);
            i += 1;
          }
          i = j + k + zzbJv.length * 1;
        }
      }
      j = i;
      if (zzbJw != null)
      {
        j = i;
        if (zzbJw.length > 0)
        {
          k = 0;
          m = 0;
          j = i1;
          while (j < zzbJw.length)
          {
            localObject = zzbJw[j];
            i1 = k;
            n = m;
            if (localObject != null)
            {
              n = m + 1;
              i1 = k + zzadp.zzT((byte[])localObject);
            }
            j += 1;
            k = i1;
            m = n;
          }
          j = i + k + m * 1;
        }
      }
      return j;
    }
  }

  public zzadl zzHj()
  {
    zzbJu = zzaea.zzbKe;
    zzbJv = zzaea.zzbJZ;
    zzbJw = zzaea.zzbKf;
    zzbJM = null;
    zzbJX = -1;
    return this;
  }

  public void zza(zzadp paramzzadp)
    throws IOException
  {
    int j = 0;
    int i;
    Object localObject;
    if ((zzbJu != null) && (zzbJu.length > 0))
    {
      i = 0;
      while (i < zzbJu.length)
      {
        localObject = zzbJu[i];
        if (localObject != null)
          paramzzadp.zzb(1, (String)localObject);
        i += 1;
      }
    }
    if ((zzbJv != null) && (zzbJv.length > 0))
    {
      i = 0;
      while (i < zzbJv.length)
      {
        paramzzadp.zzP(2, zzbJv[i]);
        i += 1;
      }
    }
    if ((zzbJw != null) && (zzbJw.length > 0))
    {
      i = j;
      while (i < zzbJw.length)
      {
        localObject = zzbJw[i];
        if (localObject != null)
          paramzzadp.zza(3, (byte[])localObject);
        i += 1;
      }
    }
    super.zza(paramzzadp);
  }

  public zzadl zzas(zzado paramzzado)
    throws IOException
  {
    while (true)
    {
      int i = paramzzado.zzHl();
      Object localObject;
      switch (i)
      {
      default:
        if (zza(paramzzado, i))
          continue;
      case 0:
        return this;
      case 10:
        j = zzaea.zzc(paramzzado, 10);
        if (zzbJu == null);
        for (i = 0; ; i = zzbJu.length)
        {
          localObject = new String[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(zzbJu, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length - 1)
          {
            localObject[j] = paramzzado.readString();
            paramzzado.zzHl();
            j += 1;
          }
        }
        localObject[j] = paramzzado.readString();
        zzbJu = ((String[])localObject);
        break;
      case 16:
        j = zzaea.zzc(paramzzado, 16);
        if (zzbJv == null);
        for (i = 0; ; i = zzbJv.length)
        {
          localObject = new int[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(zzbJv, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length - 1)
          {
            localObject[j] = paramzzado.zzHo();
            paramzzado.zzHl();
            j += 1;
          }
        }
        localObject[j] = paramzzado.zzHo();
        zzbJv = ((int[])localObject);
        break;
      case 18:
        int k = paramzzado.zzrU(paramzzado.zzHt());
        i = paramzzado.getPosition();
        j = 0;
        while (paramzzado.zzHy() > 0)
        {
          paramzzado.zzHo();
          j += 1;
        }
        paramzzado.zzrW(i);
        if (zzbJv == null);
        for (i = 0; ; i = zzbJv.length)
        {
          localObject = new int[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(zzbJv, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length)
          {
            localObject[j] = paramzzado.zzHo();
            j += 1;
          }
        }
        zzbJv = ((int[])localObject);
        paramzzado.zzrV(k);
        break;
      case 26:
      }
      int j = zzaea.zzc(paramzzado, 26);
      if (zzbJw == null);
      for (i = 0; ; i = zzbJw.length)
      {
        localObject = new byte[j + i][];
        j = i;
        if (i != 0)
        {
          System.arraycopy(zzbJw, 0, localObject, 0, i);
          j = i;
        }
        while (j < localObject.length - 1)
        {
          localObject[j] = paramzzado.readBytes();
          paramzzado.zzHl();
          j += 1;
        }
      }
      localObject[j] = paramzzado.readBytes();
      zzbJw = ((byte[][])localObject);
    }
  }
}