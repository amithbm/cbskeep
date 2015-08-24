package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze
  implements Parcelable.Creator<EnableTargetRequest>
{
  static void zza(EnableTargetRequest paramEnableTargetRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zza(paramParcel, 1, paramEnableTargetRequest.getName(), false);
    zzb.zzc(paramParcel, 1000, versionCode);
    zzb.zza(paramParcel, 2, paramEnableTargetRequest.getDescription(), false);
    zzb.zza(paramParcel, 3, paramEnableTargetRequest.zzAj(), false);
    zzb.zza(paramParcel, 4, paramEnableTargetRequest.zzAk(), false);
    zzb.zza(paramParcel, 5, paramEnableTargetRequest.getCallbackBinder(), false);
    zzb.zza(paramParcel, 6, paramEnableTargetRequest.getDeviceType());
    zzb.zzJ(paramParcel, paramInt);
  }

  public EnableTargetRequest zzju(Parcel paramParcel)
  {
    byte b = 0;
    IBinder localIBinder1 = null;
    int j = zza.zzcQ(paramParcel);
    IBinder localIBinder2 = null;
    IBinder localIBinder3 = null;
    String str1 = null;
    String str2 = null;
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
        str2 = zza.zzp(paramParcel, k);
        break;
      case 1000:
        i = zza.zzg(paramParcel, k);
        break;
      case 2:
        str1 = zza.zzp(paramParcel, k);
        break;
      case 3:
        localIBinder3 = zza.zzq(paramParcel, k);
        break;
      case 4:
        localIBinder2 = zza.zzq(paramParcel, k);
        break;
      case 5:
        localIBinder1 = zza.zzq(paramParcel, k);
        break;
      case 6:
        b = zza.zze(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new EnableTargetRequest(i, str2, str1, b, localIBinder3, localIBinder2, localIBinder1);
  }

  public EnableTargetRequest[] zzmG(int paramInt)
  {
    return new EnableTargetRequest[paramInt];
  }
}