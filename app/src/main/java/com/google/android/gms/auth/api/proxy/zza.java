package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza
  implements Parcelable.Creator<ProxyRequest>
{
  static void zza(ProxyRequest paramProxyRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zza(paramParcel, 1, url, false);
    zzb.zzc(paramParcel, 1000, versionCode);
    zzb.zzc(paramParcel, 2, httpMethod);
    zzb.zza(paramParcel, 3, timeoutMillis);
    zzb.zza(paramParcel, 4, body, false);
    zzb.zza(paramParcel, 5, zzQX, false);
    zzb.zzJ(paramParcel, paramInt);
  }

  public ProxyRequest zzaw(Parcel paramParcel)
  {
    int i = 0;
    Bundle localBundle = null;
    int k = com.google.android.gms.common.internal.safeparcel.zza.zzcQ(paramParcel);
    long l = 0L;
    byte[] arrayOfByte = null;
    String str = null;
    int j = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = com.google.android.gms.common.internal.safeparcel.zza.zzcP(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.zza.zzeS(m))
      {
      default:
        com.google.android.gms.common.internal.safeparcel.zza.zzb(paramParcel, m);
        break;
      case 1:
        str = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, m);
        break;
      case 1000:
        j = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, m);
        break;
      case 2:
        i = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, m);
        break;
      case 3:
        l = com.google.android.gms.common.internal.safeparcel.zza.zzi(paramParcel, m);
        break;
      case 4:
        arrayOfByte = com.google.android.gms.common.internal.safeparcel.zza.zzs(paramParcel, m);
        break;
      case 5:
        localBundle = com.google.android.gms.common.internal.safeparcel.zza.zzr(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k)
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    return new ProxyRequest(j, str, i, l, arrayOfByte, localBundle);
  }

  public ProxyRequest[] zzbs(int paramInt)
  {
    return new ProxyRequest[paramInt];
  }
}