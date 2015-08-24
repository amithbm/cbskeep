package com.google.android.gms.location.reporting;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza
  implements Parcelable.Creator<GmmSettings>
{
  static void zza(GmmSettings paramGmmSettings, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, paramGmmSettings.getVersionCode());
    zzb.zza(paramParcel, 2, paramGmmSettings.getReadMillis());
    zzb.zza(paramParcel, 3, paramGmmSettings.getAccount(), paramInt, false);
    zzb.zza(paramParcel, 4, paramGmmSettings.isReportingSelected());
    zzb.zzJ(paramParcel, i);
  }

  public GmmSettings zziM(Parcel paramParcel)
  {
    boolean bool = false;
    int j = com.google.android.gms.common.internal.safeparcel.zza.zzcQ(paramParcel);
    long l = 0L;
    Account localAccount = null;
    int i = 0;
    while (paramParcel.dataPosition() < j)
    {
      int k = com.google.android.gms.common.internal.safeparcel.zza.zzcP(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.zza.zzeS(k))
      {
      default:
        com.google.android.gms.common.internal.safeparcel.zza.zzb(paramParcel, k);
        break;
      case 1:
        i = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, k);
        break;
      case 2:
        l = com.google.android.gms.common.internal.safeparcel.zza.zzi(paramParcel, k);
        break;
      case 3:
        localAccount = (Account)com.google.android.gms.common.internal.safeparcel.zza.zza(paramParcel, k, Account.CREATOR);
        break;
      case 4:
        bool = com.google.android.gms.common.internal.safeparcel.zza.zzc(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new GmmSettings(i, l, localAccount, bool);
  }

  public GmmSettings[] zzlT(int paramInt)
  {
    return new GmmSettings[paramInt];
  }
}