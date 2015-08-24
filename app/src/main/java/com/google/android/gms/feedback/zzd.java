package com.google.android.gms.feedback;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd
  implements Parcelable.Creator<LogOptions>
{
  static void zza(LogOptions paramLogOptions, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, mLogFilter, false);
    zzb.zza(paramParcel, 3, mIncludeRadioLogs);
    zzb.zzJ(paramParcel, paramInt);
  }

  public LogOptions zzfG(Parcel paramParcel)
  {
    boolean bool = false;
    int j = zza.zzcQ(paramParcel);
    String str = null;
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
        str = zza.zzp(paramParcel, k);
        break;
      case 3:
        bool = zza.zzc(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new LogOptions(i, str, bool);
  }

  public LogOptions[] zzif(int paramInt)
  {
    return new LogOptions[paramInt];
  }
}