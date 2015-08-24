package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;

public class zzb
  implements Parcelable.Creator<GestureEvent>
{
  static void zza(GestureEvent paramGestureEvent, Parcel paramParcel, int paramInt)
  {
    paramInt = com.google.android.gms.common.internal.safeparcel.zzb.zzcR(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1, paramGestureEvent.getType());
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1000, paramGestureEvent.getVersionCode());
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 2, paramGestureEvent.getTimeMillis());
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 3, paramGestureEvent.getElapsedRealtimeMillis());
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 4, paramGestureEvent.getCount());
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 5, paramGestureEvent.isStart());
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 6, paramGestureEvent.isEnd());
    com.google.android.gms.common.internal.safeparcel.zzb.zzJ(paramParcel, paramInt);
  }

  public GestureEvent zzhL(Parcel paramParcel)
  {
    long l1 = 0L;
    boolean bool1 = false;
    int m = zza.zzcQ(paramParcel);
    boolean bool2 = false;
    int i = 0;
    long l2 = 0L;
    int j = 0;
    int k = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = zza.zzcP(paramParcel);
      switch (zza.zzeS(n))
      {
      default:
        zza.zzb(paramParcel, n);
        break;
      case 1:
        j = zza.zzg(paramParcel, n);
        break;
      case 1000:
        k = zza.zzg(paramParcel, n);
        break;
      case 2:
        l2 = zza.zzi(paramParcel, n);
        break;
      case 3:
        l1 = zza.zzi(paramParcel, n);
        break;
      case 4:
        i = zza.zzg(paramParcel, n);
        break;
      case 5:
        bool2 = zza.zzc(paramParcel, n);
        break;
      case 6:
        bool1 = zza.zzc(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m)
      throw new zza.zza("Overread allowed size end=" + m, paramParcel);
    return new GestureEvent(k, j, l2, l1, i, bool2, bool1);
  }

  public GestureEvent[] zzkI(int paramInt)
  {
    return new GestureEvent[paramInt];
  }
}