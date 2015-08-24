package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.zzado;
import com.google.android.gms.internal.zzadp;
import com.google.android.gms.internal.zzadq;
import java.io.IOException;

public final class zzar extends zzadq<zzar>
{
  public int versionCode;
  public long zzavV;
  public String zzavX;
  public long zzavY;
  public int zzavZ;

  public zzar()
  {
    zzsY();
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
          return bool1;
          bool1 = bool2;
        }
        while (!(paramObject instanceof zzar));
        paramObject = (zzar)paramObject;
        bool1 = bool2;
      }
      while (versionCode != paramObject.versionCode);
      if (zzavX != null)
        break;
      bool1 = bool2;
    }
    while (paramObject.zzavX != null);
    while (zzavX.equals(paramObject.zzavX))
    {
      bool1 = bool2;
      if (zzavY != paramObject.zzavY)
        break;
      bool1 = bool2;
      if (zzavV != paramObject.zzavV)
        break;
      bool1 = bool2;
      if (zzavZ != paramObject.zzavZ)
        break;
      return zza(paramObject);
    }
    return false;
  }

  public int hashCode()
  {
    int j = versionCode;
    if (zzavX == null);
    for (int i = 0; ; i = zzavX.hashCode())
      return ((((i + (j + 527) * 31) * 31 + (int)(zzavY ^ zzavY >>> 32)) * 31 + (int)(zzavV ^ zzavV >>> 32)) * 31 + zzavZ) * 31 + zzHD();
  }

  protected int zzB()
  {
    int j = super.zzB() + zzadp.zzR(1, versionCode) + zzadp.zzm(2, zzavX) + zzadp.zzk(3, zzavY) + zzadp.zzk(4, zzavV);
    int i = j;
    if (zzavZ != -1)
      i = j + zzadp.zzR(5, zzavZ);
    return i;
  }

  public zzar zzG(zzado paramzzado)
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
      case 18:
        zzavX = paramzzado.readString();
        break;
      case 24:
        zzavY = paramzzado.zzHs();
        break;
      case 32:
        zzavV = paramzzado.zzHs();
        break;
      case 40:
      }
      zzavZ = paramzzado.zzHo();
    }
  }

  public void zza(zzadp paramzzadp)
    throws IOException
  {
    paramzzadp.zzP(1, versionCode);
    paramzzadp.zzb(2, zzavX);
    paramzzadp.zzh(3, zzavY);
    paramzzadp.zzh(4, zzavV);
    if (zzavZ != -1)
      paramzzadp.zzP(5, zzavZ);
    super.zza(paramzzadp);
  }

  public zzar zzsY()
  {
    versionCode = 1;
    zzavX = "";
    zzavY = -1L;
    zzavV = -1L;
    zzavZ = -1;
    zzbJM = null;
    zzbJX = -1;
    return this;
  }
}