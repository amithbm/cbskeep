package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzf
  implements Parcelable.Creator<Permission>
{
  static void zza(Permission paramPermission, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, paramPermission.getAccountIdentifier(), false);
    zzb.zzc(paramParcel, 3, paramPermission.getAccountType());
    zzb.zza(paramParcel, 4, paramPermission.getAccountDisplayName(), false);
    zzb.zza(paramParcel, 5, paramPermission.getPhotoLink(), false);
    zzb.zzc(paramParcel, 6, paramPermission.getRole());
    zzb.zza(paramParcel, 7, paramPermission.isLinkRequiredForAccess());
    zzb.zzJ(paramParcel, paramInt);
  }

  public Permission zzdN(Parcel paramParcel)
  {
    String str1 = null;
    boolean bool = false;
    int m = zza.zzcQ(paramParcel);
    int i = 0;
    String str2 = null;
    int j = 0;
    String str3 = null;
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
        k = zza.zzg(paramParcel, n);
        break;
      case 2:
        str3 = zza.zzp(paramParcel, n);
        break;
      case 3:
        j = zza.zzg(paramParcel, n);
        break;
      case 4:
        str2 = zza.zzp(paramParcel, n);
        break;
      case 5:
        str1 = zza.zzp(paramParcel, n);
        break;
      case 6:
        i = zza.zzg(paramParcel, n);
        break;
      case 7:
        bool = zza.zzc(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m)
      throw new zza.zza("Overread allowed size end=" + m, paramParcel);
    return new Permission(k, str3, j, str2, str1, i, bool);
  }

  public Permission[] zzgc(int paramInt)
  {
    return new Permission[paramInt];
  }
}