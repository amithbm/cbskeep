package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;

public class zzb
  implements Parcelable.Creator<ConnectionConfiguration>
{
  static void zza(ConnectionConfiguration paramConnectionConfiguration, Parcel paramParcel, int paramInt)
  {
    paramInt = com.google.android.gms.common.internal.safeparcel.zzb.zzcR(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1, mVersionCode);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 2, paramConnectionConfiguration.getName(), false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 3, paramConnectionConfiguration.getAddress(), false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 4, paramConnectionConfiguration.getType());
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 5, paramConnectionConfiguration.getRole());
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 6, paramConnectionConfiguration.isEnabled());
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 7, paramConnectionConfiguration.isConnected());
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 8, paramConnectionConfiguration.getPeerNodeId(), false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 9, paramConnectionConfiguration.getBtlePriority());
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 10, paramConnectionConfiguration.getNodeId(), false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzJ(paramParcel, paramInt);
  }

  public ConnectionConfiguration zznd(Parcel paramParcel)
  {
    String str1 = null;
    boolean bool1 = false;
    int m = zza.zzcQ(paramParcel);
    String str2 = null;
    boolean bool2 = false;
    boolean bool3 = false;
    int i = 0;
    int j = 0;
    String str3 = null;
    String str4 = null;
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
        k = zza.zzg(paramParcel, n);
        break;
      case 2:
        str4 = zza.zzp(paramParcel, n);
        break;
      case 3:
        str3 = zza.zzp(paramParcel, n);
        break;
      case 4:
        j = zza.zzg(paramParcel, n);
        break;
      case 5:
        i = zza.zzg(paramParcel, n);
        break;
      case 6:
        bool3 = zza.zzc(paramParcel, n);
        break;
      case 7:
        bool2 = zza.zzc(paramParcel, n);
        break;
      case 8:
        str2 = zza.zzp(paramParcel, n);
        break;
      case 9:
        bool1 = zza.zzc(paramParcel, n);
        break;
      case 10:
        str1 = zza.zzp(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m)
      throw new zza.zza("Overread allowed size end=" + m, paramParcel);
    return new ConnectionConfiguration(k, str4, str3, j, i, bool3, bool2, str2, bool1, str1);
  }

  public ConnectionConfiguration[] zzrf(int paramInt)
  {
    return new ConnectionConfiguration[paramInt];
  }
}