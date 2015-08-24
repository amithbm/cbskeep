package com.google.android.gms.reminders.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzr
  implements Parcelable.Creator<TaskIdEntity>
{
  static void zza(TaskIdEntity paramTaskIdEntity, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, paramTaskIdEntity.getServerAssignedId(), false);
    zzb.zza(paramParcel, 3, paramTaskIdEntity.getClientAssignedId(), false);
    zzb.zza(paramParcel, 4, paramTaskIdEntity.getClientAssignedThreadId(), false);
    zzb.zzJ(paramParcel, paramInt);
  }

  public TaskIdEntity zzkW(Parcel paramParcel)
  {
    String str2 = null;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    String str1 = null;
    Long localLong = null;
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
        localLong = zza.zzj(paramParcel, k);
        break;
      case 3:
        str1 = zza.zzp(paramParcel, k);
        break;
      case 4:
        str2 = zza.zzp(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new TaskIdEntity(i, localLong, str1, str2);
  }

  public TaskIdEntity[] zzoA(int paramInt)
  {
    return new TaskIdEntity[paramInt];
  }
}