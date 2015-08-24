package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.nearby.sharing.SharedContent;
import java.util.ArrayList;

public class zzi
  implements Parcelable.Creator<ProvideContentRequest>
{
  static void zza(ProvideContentRequest paramProvideContentRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, versionCode);
    zzb.zza(paramParcel, 2, zzbbF, false);
    zzb.zza(paramParcel, 3, paramProvideContentRequest.zzAx(), false);
    zzb.zzd(paramParcel, 4, zzbbH, false);
    zzb.zza(paramParcel, 5, zzbbI);
    zzb.zza(paramParcel, 6, paramProvideContentRequest.zzAv(), false);
    zzb.zzJ(paramParcel, paramInt);
  }

  public ProvideContentRequest zzjN(Parcel paramParcel)
  {
    IBinder localIBinder1 = null;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    long l = 0L;
    ArrayList localArrayList = null;
    IBinder localIBinder2 = null;
    IBinder localIBinder3 = null;
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
        localIBinder3 = zza.zzq(paramParcel, k);
        break;
      case 3:
        localIBinder2 = zza.zzq(paramParcel, k);
        break;
      case 4:
        localArrayList = zza.zzc(paramParcel, k, SharedContent.CREATOR);
        break;
      case 5:
        l = zza.zzi(paramParcel, k);
        break;
      case 6:
        localIBinder1 = zza.zzq(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new ProvideContentRequest(i, localIBinder3, localIBinder2, localArrayList, l, localIBinder1);
  }

  public ProvideContentRequest[] zzng(int paramInt)
  {
    return new ProvideContentRequest[paramInt];
  }
}