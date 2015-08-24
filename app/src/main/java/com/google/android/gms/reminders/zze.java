package com.google.android.gms.reminders;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze
  implements Parcelable.Creator<UpdateRecurrenceOptions>
{
  static void zza(UpdateRecurrenceOptions paramUpdateRecurrenceOptions, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zzc(paramParcel, 2, paramUpdateRecurrenceOptions.getUpdateMode());
    zzb.zza(paramParcel, 3, paramUpdateRecurrenceOptions.getExcludeExceptions());
    zzb.zza(paramParcel, 4, paramUpdateRecurrenceOptions.getReferenceTimeMillis(), false);
    zzb.zzJ(paramParcel, paramInt);
  }

  public UpdateRecurrenceOptions zzkE(Parcel paramParcel)
  {
    boolean bool = false;
    int k = zza.zzcQ(paramParcel);
    Long localLong = null;
    int j = 0;
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
        i = zza.zzg(paramParcel, m);
        break;
      case 2:
        j = zza.zzg(paramParcel, m);
        break;
      case 3:
        bool = zza.zzc(paramParcel, m);
        break;
      case 4:
        localLong = zza.zzj(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k)
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    return new UpdateRecurrenceOptions(i, Integer.valueOf(j), Boolean.valueOf(bool), localLong);
  }

  public UpdateRecurrenceOptions[] zzoi(int paramInt)
  {
    return new UpdateRecurrenceOptions[paramInt];
  }
}