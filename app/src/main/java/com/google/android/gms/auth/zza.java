package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza
  implements Parcelable.Creator<AccountChangeEvent>
{
  static void zza(AccountChangeEvent paramAccountChangeEvent, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersion);
    zzb.zza(paramParcel, 2, mId);
    zzb.zza(paramParcel, 3, zzQt, false);
    zzb.zzc(paramParcel, 4, zzQu);
    zzb.zzc(paramParcel, 5, zzQv);
    zzb.zza(paramParcel, 6, zzQw, false);
    zzb.zzJ(paramParcel, paramInt);
  }

  public AccountChangeEvent zzaj(Parcel paramParcel)
  {
    String str1 = null;
    int i = 0;
    int m = com.google.android.gms.common.internal.safeparcel.zza.zzcQ(paramParcel);
    long l = 0L;
    int j = 0;
    String str2 = null;
    int k = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = com.google.android.gms.common.internal.safeparcel.zza.zzcP(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.zza.zzeS(n))
      {
      default:
        com.google.android.gms.common.internal.safeparcel.zza.zzb(paramParcel, n);
        break;
      case 1:
        k = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, n);
        break;
      case 2:
        l = com.google.android.gms.common.internal.safeparcel.zza.zzi(paramParcel, n);
        break;
      case 3:
        str2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, n);
        break;
      case 4:
        j = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, n);
        break;
      case 5:
        i = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, n);
        break;
      case 6:
        str1 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m)
      throw new zza.zza("Overread allowed size end=" + m, paramParcel);
    return new AccountChangeEvent(k, l, str2, j, i, str1);
  }

  public AccountChangeEvent[] zzbf(int paramInt)
  {
    return new AccountChangeEvent[paramInt];
  }
}