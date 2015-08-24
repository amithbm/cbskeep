package com.google.android.gms.internal;

import java.io.IOException;

public abstract class zzadq<M extends zzadq<M>> extends zzadx
{
  protected zzadt zzbJM;

  protected int zzB()
  {
    int j = 0;
    if (zzbJM != null)
    {
      int i = 0;
      while (true)
      {
        k = i;
        if (j >= zzbJM.size())
          break;
        i += zzbJM.zzsk(j).zzB();
        j += 1;
      }
    }
    int k = 0;
    return k;
  }

  protected final int zzHD()
  {
    if ((zzbJM == null) || (zzbJM.isEmpty()))
      return 0;
    return zzbJM.hashCode();
  }

  public M zzHE()
    throws CloneNotSupportedException
  {
    zzadq localzzadq = (zzadq)super.zzHF();
    zzadv.zza(this, localzzadq);
    return localzzadq;
  }

  public void zza(zzadp paramzzadp)
    throws IOException
  {
    if (zzbJM == null);
    while (true)
    {
      return;
      int i = 0;
      while (i < zzbJM.size())
      {
        zzbJM.zzsk(i).zza(paramzzadp);
        i += 1;
      }
    }
  }

  protected final boolean zza(zzado paramzzado, int paramInt)
    throws IOException
  {
    int i = paramzzado.getPosition();
    if (!paramzzado.zzrS(paramInt))
      return false;
    int j = zzaea.zzso(paramInt);
    zzadz localzzadz = new zzadz(paramInt, paramzzado.zzO(i, paramzzado.getPosition() - i));
    paramzzado = null;
    if (zzbJM == null)
      zzbJM = new zzadt();
    while (true)
    {
      Object localObject = paramzzado;
      if (paramzzado == null)
      {
        localObject = new zzadu();
        zzbJM.zza(j, (zzadu)localObject);
      }
      ((zzadu)localObject).zza(localzzadz);
      return true;
      paramzzado = zzbJM.zzsj(j);
    }
  }

  protected final boolean zza(M paramM)
  {
    if ((zzbJM == null) || (zzbJM.isEmpty()))
      return (paramM.zzbJM == null) || (paramM.zzbJM.isEmpty());
    return zzbJM.equals(paramM.zzbJM);
  }
}