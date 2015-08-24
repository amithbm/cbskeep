package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzg
  implements Parcelable.Creator<WakeLockEvent>
{
  static void zza(WakeLockEvent paramWakeLockEvent, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, paramWakeLockEvent.getTimeMillis());
    zzb.zza(paramParcel, 4, paramWakeLockEvent.zzqB(), false);
    zzb.zzc(paramParcel, 5, paramWakeLockEvent.zzqD());
    zzb.zzc(paramParcel, 6, paramWakeLockEvent.zzqE(), false);
    zzb.zza(paramParcel, 8, paramWakeLockEvent.zzqz());
    zzb.zza(paramParcel, 9, paramWakeLockEvent.zzqF());
    zzb.zza(paramParcel, 10, paramWakeLockEvent.zzqC(), false);
    zzb.zzc(paramParcel, 11, paramWakeLockEvent.getEventType());
    zzb.zza(paramParcel, 12, paramWakeLockEvent.zzqx(), false);
    zzb.zza(paramParcel, 13, paramWakeLockEvent.zzqG(), false);
    zzb.zzJ(paramParcel, paramInt);
  }

  public WakeLockEvent zzde(Parcel paramParcel)
  {
    int m = zza.zzcQ(paramParcel);
    int k = 0;
    long l2 = 0L;
    int j = 0;
    String str4 = null;
    int i = 0;
    ArrayList localArrayList = null;
    String str3 = null;
    long l1 = 0L;
    boolean bool = false;
    String str2 = null;
    String str1 = null;
    while (paramParcel.dataPosition() < m)
    {
      int n = zza.zzcP(paramParcel);
      switch (zza.zzeS(n))
      {
      case 3:
      case 7:
      default:
        zza.zzb(paramParcel, n);
        break;
      case 1:
        k = zza.zzg(paramParcel, n);
        break;
      case 2:
        l2 = zza.zzi(paramParcel, n);
        break;
      case 4:
        str4 = zza.zzp(paramParcel, n);
        break;
      case 5:
        i = zza.zzg(paramParcel, n);
        break;
      case 6:
        localArrayList = zza.zzE(paramParcel, n);
        break;
      case 8:
        l1 = zza.zzi(paramParcel, n);
        break;
      case 9:
        bool = zza.zzc(paramParcel, n);
        break;
      case 10:
        str2 = zza.zzp(paramParcel, n);
        break;
      case 11:
        j = zza.zzg(paramParcel, n);
        break;
      case 12:
        str3 = zza.zzp(paramParcel, n);
        break;
      case 13:
        str1 = zza.zzp(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m)
      throw new zza.zza("Overread allowed size end=" + m, paramParcel);
    return new WakeLockEvent(k, l2, j, str4, i, localArrayList, str3, l1, bool, str2, str1);
  }

  public WakeLockEvent[] zzfj(int paramInt)
  {
    return new WakeLockEvent[paramInt];
  }
}