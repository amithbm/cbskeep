package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzaw
  implements Parcelable.Creator<OnDownloadProgressResponse>
{
  static void zza(OnDownloadProgressResponse paramOnDownloadProgressResponse, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, zzawd);
    zzb.zza(paramParcel, 3, zzawe);
    zzb.zzJ(paramParcel, paramInt);
  }

  public OnDownloadProgressResponse zzew(Parcel paramParcel)
  {
    long l1 = 0L;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    long l2 = 0L;
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
        l2 = zza.zzi(paramParcel, k);
        break;
      case 3:
        l1 = zza.zzi(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new OnDownloadProgressResponse(i, l2, l1);
  }

  public OnDownloadProgressResponse[] zzgQ(int paramInt)
  {
    return new OnDownloadProgressResponse[paramInt];
  }
}