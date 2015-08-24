package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.ChangeSequenceNumber;
import com.google.android.gms.drive.DriveSpace;
import java.util.ArrayList;

public class zzaf
  implements Parcelable.Creator<GetChangesRequest>
{
  static void zza(GetChangesRequest paramGetChangesRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, zzavL, paramInt, false);
    zzb.zzc(paramParcel, 3, zzavM);
    zzb.zzd(paramParcel, 4, zzate, false);
    zzb.zzJ(paramParcel, i);
  }

  public GetChangesRequest zzem(Parcel paramParcel)
  {
    ArrayList localArrayList = null;
    int j = 0;
    int m = zza.zzcQ(paramParcel);
    ChangeSequenceNumber localChangeSequenceNumber = null;
    int i = 0;
    if (paramParcel.dataPosition() < m)
    {
      int k = zza.zzcP(paramParcel);
      switch (zza.zzeS(k))
      {
      default:
        zza.zzb(paramParcel, k);
        k = j;
        j = i;
        i = k;
      case 1:
      case 2:
      case 3:
      case 4:
      }
      while (true)
      {
        k = j;
        j = i;
        i = k;
        break;
        k = zza.zzg(paramParcel, k);
        i = j;
        j = k;
        continue;
        localChangeSequenceNumber = (ChangeSequenceNumber)zza.zza(paramParcel, k, ChangeSequenceNumber.CREATOR);
        k = i;
        i = j;
        j = k;
        continue;
        k = zza.zzg(paramParcel, k);
        j = i;
        i = k;
        continue;
        localArrayList = zza.zzc(paramParcel, k, DriveSpace.CREATOR);
        k = i;
        i = j;
        j = k;
      }
    }
    if (paramParcel.dataPosition() != m)
      throw new zza.zza("Overread allowed size end=" + m, paramParcel);
    return new GetChangesRequest(i, localChangeSequenceNumber, j, localArrayList);
  }

  public GetChangesRequest[] zzgG(int paramInt)
  {
    return new GetChangesRequest[paramInt];
  }
}