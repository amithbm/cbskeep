package com.google.android.gms.common.people.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;

public class zzb
  implements Parcelable.Creator<AudienceMember>
{
  static void zza(AudienceMember paramAudienceMember, Parcel paramParcel, int paramInt)
  {
    paramInt = com.google.android.gms.common.internal.safeparcel.zzb.zzcR(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1, paramAudienceMember.getType());
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1000, paramAudienceMember.getVersionCode());
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 2, paramAudienceMember.getCircleType());
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 3, paramAudienceMember.getCircleId(), false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 4, paramAudienceMember.getPeopleQualifiedId(), false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 5, paramAudienceMember.getDisplayName(), false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 6, paramAudienceMember.getAvatarUrl(), false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 7, paramAudienceMember.getMetadata(), false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzJ(paramParcel, paramInt);
  }

  public AudienceMember zzcT(Parcel paramParcel)
  {
    int i = 0;
    Bundle localBundle = null;
    int m = zza.zzcQ(paramParcel);
    String str1 = null;
    String str2 = null;
    String str3 = null;
    String str4 = null;
    int j = 0;
    int k = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = zza.zzcP(paramParcel);
      switch (zza.zzeS(n))
      {
      default:
        zza.zzb(paramParcel, n);
        break;
      case 1:
        j = zza.zzg(paramParcel, n);
        break;
      case 1000:
        k = zza.zzg(paramParcel, n);
        break;
      case 2:
        i = zza.zzg(paramParcel, n);
        break;
      case 3:
        str4 = zza.zzp(paramParcel, n);
        break;
      case 4:
        str3 = zza.zzp(paramParcel, n);
        break;
      case 5:
        str2 = zza.zzp(paramParcel, n);
        break;
      case 6:
        str1 = zza.zzp(paramParcel, n);
        break;
      case 7:
        localBundle = zza.zzr(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m)
      throw new zza.zza("Overread allowed size end=" + m, paramParcel);
    return new AudienceMember(k, j, i, str4, str3, str2, str1, localBundle);
  }

  public AudienceMember[] zzeX(int paramInt)
  {
    return new AudienceMember[paramInt];
  }
}