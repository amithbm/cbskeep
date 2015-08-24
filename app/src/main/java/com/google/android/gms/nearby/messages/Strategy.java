package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzv;

public class Strategy
  implements SafeParcelable
{

  @Deprecated
  public static final Strategy BLE_BEACON = BLE_ONLY;
  public static final Strategy BLE_ONLY;
  public static final Parcelable.Creator<Strategy> CREATOR = new zzc();
  public static final Strategy DEFAULT = new zza().zzAu();
  final int versionCode;

  @Deprecated
  final int zzbaZ;
  final int zzbba;
  final int zzbbb;

  @Deprecated
  final boolean zzbbc;
  final int zzbbd;
  final int zzbbe;

  static
  {
    BLE_ONLY = new zza().zzmT(2).zzmU(2147483647).zzAu();
  }

  Strategy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5, int paramInt6)
  {
    versionCode = paramInt1;
    zzbaZ = paramInt2;
    if (paramInt2 == 0)
      zzbbe = paramInt6;
    while (true)
    {
      zzbbb = paramInt4;
      zzbbc = paramBoolean;
      if (!paramBoolean)
        break;
      zzbbd = 2;
      zzbba = 2147483647;
      return;
      switch (paramInt2)
      {
      default:
        zzbbe = 3;
        break;
      case 2:
        zzbbe = 1;
        break;
      case 3:
        zzbbe = 2;
      }
    }
    if (paramInt5 == 0)
    {
      zzbbd = 1;
      zzbba = paramInt3;
      return;
    }
    zzbbd = paramInt5;
    zzbba = paramInt3;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    do
    {
      return true;
      if (!(paramObject instanceof Strategy))
        return false;
      paramObject = (Strategy)paramObject;
    }
    while ((versionCode == paramObject.versionCode) && (zzbbe == paramObject.zzbbe) && (zzbba == paramObject.zzbba) && (zzbbb == paramObject.zzbbb) && (zzbbd == paramObject.zzbbd));
    return false;
  }

  public int hashCode()
  {
    return (((versionCode * 31 + zzbbe) * 31 + zzbba) * 31 + zzbbb) * 31 + zzbbd;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }

  public static class zza
  {
    private int zzbba = 300;
    private int zzbbb = 0;
    private int zzbbd = 1;
    private int zzbbe = 3;

    public Strategy zzAu()
    {
      if (zzbbd == 2)
      {
        if (zzbbe != 3)
          throw new IllegalStateException("Discovery mode must be DISCOVERY_MODE_DEFAULT.");
        if (zzbbb == 1)
          throw new IllegalStateException("Cannot set EARSHOT with BLE only mode.");
      }
      return new Strategy(2, 0, zzbba, zzbbb, false, zzbbd, zzbbe);
    }

    public zza zzmT(int paramInt)
    {
      zzbbd = paramInt;
      return this;
    }

    public zza zzmU(int paramInt)
    {
      if ((paramInt == 2147483647) || ((paramInt > 0) && (paramInt <= 86400)));
      for (boolean bool = true; ; bool = false)
      {
        zzv.zzb(bool, "ttlSeconds(%d) must either be TTL_SECONDS_INFINITE, or it must be between 1 and TTL_SECONDS_MAX(%d) inclusive", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(86400) });
        zzbba = paramInt;
        return this;
      }
    }
  }
}