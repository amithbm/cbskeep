package com.google.android.gms.playlog.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc
  implements Parcelable.Creator<LogEvent>
{
  static void zza(LogEvent paramLogEvent, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, versionCode);
    zzb.zza(paramParcel, 2, zzbir);
    zzb.zza(paramParcel, 3, tag, false);
    zzb.zza(paramParcel, 4, zzbis, false);
    zzb.zza(paramParcel, 5, zzbit, false);
    zzb.zzJ(paramParcel, paramInt);
  }

  public LogEvent zzkk(Parcel paramParcel)
  {
    Bundle localBundle = null;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    long l = 0L;
    byte[] arrayOfByte = null;
    String str = null;
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
        l = zza.zzi(paramParcel, k);
        break;
      case 3:
        str = zza.zzp(paramParcel, k);
        break;
      case 4:
        arrayOfByte = zza.zzs(paramParcel, k);
        break;
      case 5:
        localBundle = zza.zzr(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new LogEvent(i, l, str, arrayOfByte, localBundle);
  }

  public LogEvent[] zznM(int paramInt)
  {
    return new LogEvent[paramInt];
  }
}