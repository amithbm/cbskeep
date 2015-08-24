package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;

public class zzb
  implements Parcelable.Creator<AppDescription>
{
  static void zza(AppDescription paramAppDescription, Parcel paramParcel, int paramInt)
  {
    paramInt = com.google.android.gms.common.internal.safeparcel.zzb.zzcR(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1, version);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 2, zzTV);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 3, zzCQ, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 4, zzTW, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 5, zzTX, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 6, zzSr);
    com.google.android.gms.common.internal.safeparcel.zzb.zzJ(paramParcel, paramInt);
  }

  public AppDescription zzbB(Parcel paramParcel)
  {
    String str1 = null;
    boolean bool = false;
    int k = zza.zzcQ(paramParcel);
    String str2 = null;
    String str3 = null;
    int i = 0;
    int j = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = zza.zzcP(paramParcel);
      switch (zza.zzeS(m))
      {
      default:
        zza.zzb(paramParcel, m);
        break;
      case 1:
        j = zza.zzg(paramParcel, m);
        break;
      case 2:
        i = zza.zzg(paramParcel, m);
        break;
      case 3:
        str3 = zza.zzp(paramParcel, m);
        break;
      case 4:
        str2 = zza.zzp(paramParcel, m);
        break;
      case 5:
        str1 = zza.zzp(paramParcel, m);
        break;
      case 6:
        bool = zza.zzc(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k)
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    return new AppDescription(j, i, str3, str2, str1, bool);
  }

  public AppDescription[] zzcx(int paramInt)
  {
    return new AppDescription[paramInt];
  }
}