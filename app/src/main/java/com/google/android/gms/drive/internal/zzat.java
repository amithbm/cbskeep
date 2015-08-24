package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.ChangeSequenceNumber;
import com.google.android.gms.drive.DriveId;
import java.util.ArrayList;

public class zzat
  implements Parcelable.Creator<OnChangesResponse>
{
  static void zza(OnChangesResponse paramOnChangesResponse, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, zzawa, paramInt, false);
    zzb.zzd(paramParcel, 3, zzaug, false);
    zzb.zza(paramParcel, 4, zzauh, paramInt, false);
    zzb.zza(paramParcel, 5, zzaui);
    zzb.zzJ(paramParcel, i);
  }

  public OnChangesResponse zzet(Parcel paramParcel)
  {
    boolean bool = false;
    ChangeSequenceNumber localChangeSequenceNumber = null;
    int j = zza.zzcQ(paramParcel);
    ArrayList localArrayList = null;
    DataHolder localDataHolder = null;
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
        localDataHolder = (DataHolder)zza.zza(paramParcel, k, DataHolder.CREATOR);
        break;
      case 3:
        localArrayList = zza.zzc(paramParcel, k, DriveId.CREATOR);
        break;
      case 4:
        localChangeSequenceNumber = (ChangeSequenceNumber)zza.zza(paramParcel, k, ChangeSequenceNumber.CREATOR);
        break;
      case 5:
        bool = zza.zzc(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new OnChangesResponse(i, localDataHolder, localArrayList, localChangeSequenceNumber, bool);
  }

  public OnChangesResponse[] zzgN(int paramInt)
  {
    return new OnChangesResponse[paramInt];
  }
}