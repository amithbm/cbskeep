package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.zzado;
import com.google.android.gms.internal.zzadp;
import com.google.android.gms.internal.zzadq;
import java.io.IOException;

public final class zzaq extends zzadq<zzaq>
{
  public int versionCode;
  public long zzavU;
  public long zzavV;
  public long zzavW;

  public zzaq()
  {
    zzsX();
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
            do
            {
              return bool1;
              bool1 = bool2;
            }
            while (!(paramObject instanceof zzaq));
            paramObject = (zzaq)paramObject;
            bool1 = bool2;
          }
          while (versionCode != paramObject.versionCode);
          bool1 = bool2;
        }
        while (zzavU != paramObject.zzavU);
        bool1 = bool2;
      }
      while (zzavV != paramObject.zzavV);
      bool1 = bool2;
    }
    while (zzavW != paramObject.zzavW);
    return zza(paramObject);
  }

  public int hashCode()
  {
    return ((((versionCode + 527) * 31 + (int)(zzavU ^ zzavU >>> 32)) * 31 + (int)(zzavV ^ zzavV >>> 32)) * 31 + (int)(zzavW ^ zzavW >>> 32)) * 31 + zzHD();
  }

  protected int zzB()
  {
    return super.zzB() + zzadp.zzR(1, versionCode) + zzadp.zzk(2, zzavU) + zzadp.zzk(3, zzavV) + zzadp.zzk(4, zzavW);
  }

  public zzaq zzF(zzado paramzzado)
    throws IOException
  {
    while (true)
    {
      int i = paramzzado.zzHl();
      switch (i)
      {
      default:
        if (zza(paramzzado, i))
          continue;
      case 0:
        return this;
      case 8:
        versionCode = paramzzado.zzHo();
        break;
      case 16:
        zzavU = paramzzado.zzHs();
        break;
      case 24:
        zzavV = paramzzado.zzHs();
        break;
      case 32:
      }
      zzavW = paramzzado.zzHs();
    }
  }

  public void zza(zzadp paramzzadp)
    throws IOException
  {
    paramzzadp.zzP(1, versionCode);
    paramzzadp.zzh(2, zzavU);
    paramzzadp.zzh(3, zzavV);
    paramzzadp.zzh(4, zzavW);
    super.zza(paramzzadp);
  }

  public zzaq zzsX()
  {
    versionCode = 1;
    zzavU = -1L;
    zzavV = -1L;
    zzavW = -1L;
    zzbJM = null;
    zzbJX = -1;
    return this;
  }
}