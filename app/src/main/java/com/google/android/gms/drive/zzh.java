package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh
  implements Parcelable.Creator<UserMetadata>
{
  static void zza(UserMetadata paramUserMetadata, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, zzasV, false);
    zzb.zza(paramParcel, 3, zzPa, false);
    zzb.zza(paramParcel, 4, zzasW, false);
    zzb.zza(paramParcel, 5, zzasX);
    zzb.zza(paramParcel, 6, zzasY, false);
    zzb.zzJ(paramParcel, paramInt);
  }

  public UserMetadata zzdP(Parcel paramParcel)
  {
    boolean bool = false;
    String str1 = null;
    int j = zza.zzcQ(paramParcel);
    String str2 = null;
    String str3 = null;
    String str4 = null;
    int i = 0;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzcP(paramParcel);
      switch (zza.zzeS(k))
      {
      default:
        zza.zzb(paramParcel, k);
        break;
      case 1:
        i = zza.zzg(paramParcel, k);
        break;
      case 2:
        str4 = zza.zzp(paramParcel, k);
        break;
      case 3:
        str3 = zza.zzp(paramParcel, k);
        break;
      case 4:
        str2 = zza.zzp(paramParcel, k);
        break;
      case 5:
        bool = zza.zzc(paramParcel, k);
        break;
      case 6:
        str1 = zza.zzp(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new UserMetadata(i, str4, str3, str2, bool, str1);
  }

  public UserMetadata[] zzge(int paramInt)
  {
    return new UserMetadata[paramInt];
  }
}