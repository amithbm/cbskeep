package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.Contents;

public class zzau
  implements Parcelable.Creator<OnContentsResponse>
{
  static void zza(OnContentsResponse paramOnContentsResponse, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, zzauA, paramInt, false);
    zzb.zza(paramParcel, 3, zzawb);
    zzb.zzJ(paramParcel, i);
  }

  public OnContentsResponse zzeu(Parcel paramParcel)
  {
    boolean bool = false;
    int j = zza.zzcQ(paramParcel);
    Contents localContents = null;
    int i = 0;
    if (paramParcel.dataPosition() < j)
    {
      int k = zza.zzcP(paramParcel);
      switch (zza.zzeS(k))
      {
      default:
        zza.zzb(paramParcel, k);
      case 1:
      case 2:
      case 3:
      }
      while (true)
      {
        break;
        i = zza.zzg(paramParcel, k);
        continue;
        localContents = (Contents)zza.zza(paramParcel, k, Contents.CREATOR);
        continue;
        bool = zza.zzc(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new OnContentsResponse(i, localContents, bool);
  }

  public OnContentsResponse[] zzgO(int paramInt)
  {
    return new OnContentsResponse[paramInt];
  }
}