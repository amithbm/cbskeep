package com.google.android.gms.people.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;

public class zzb
  implements Parcelable.Creator<AvatarReference>
{
  static void zza(AvatarReference paramAvatarReference, Parcel paramParcel, int paramInt)
  {
    paramInt = com.google.android.gms.common.internal.safeparcel.zzb.zzcR(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1, paramAvatarReference.getSource());
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1000, paramAvatarReference.getVersionCode());
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 2, paramAvatarReference.getLocation(), false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzJ(paramParcel, paramInt);
  }

  public AvatarReference zzjX(Parcel paramParcel)
  {
    int j = 0;
    int k = zza.zzcQ(paramParcel);
    String str = null;
    int i = 0;
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
      case 1000:
        i = zza.zzg(paramParcel, m);
        break;
      case 2:
        str = zza.zzp(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k)
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    return new AvatarReference(i, j, str);
  }

  public AvatarReference[] zznu(int paramInt)
  {
    return new AvatarReference[paramInt];
  }
}