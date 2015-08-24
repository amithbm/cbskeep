package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzk
  implements Parcelable.Creator<ParentDriveIdSet>
{
  static void zza(ParentDriveIdSet paramParentDriveIdSet, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zzd(paramParcel, 2, zzawE, false);
    zzb.zzJ(paramParcel, paramInt);
  }

  public ParentDriveIdSet zzeY(Parcel paramParcel)
  {
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    ArrayList localArrayList = null;
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
        localArrayList = zza.zzc(paramParcel, k, PartialDriveId.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new ParentDriveIdSet(i, localArrayList);
  }

  public ParentDriveIdSet[] zzhs(int paramInt)
  {
    return new ParentDriveIdSet[paramInt];
  }
}