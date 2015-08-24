package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.Contents;

public class zzh
  implements Parcelable.Creator<CloseContentsRequest>
{
  static void zza(CloseContentsRequest paramCloseContentsRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, zzatE, paramInt, false);
    zzb.zza(paramParcel, 3, zzatI, false);
    zzb.zzc(paramParcel, 4, zzatG);
    zzb.zzJ(paramParcel, i);
  }

  public CloseContentsRequest zzec(Parcel paramParcel)
  {
    Object localObject2 = null;
    int i = 0;
    int k = zza.zzcQ(paramParcel);
    Object localObject1 = null;
    int j = 0;
    if (paramParcel.dataPosition() < k)
    {
      int m = zza.zzcP(paramParcel);
      Object localObject3;
      switch (zza.zzeS(m))
      {
      default:
        zza.zzb(paramParcel, m);
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
      case 1:
      case 2:
      case 3:
      case 4:
      }
      while (true)
      {
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
        break;
        j = zza.zzg(paramParcel, m);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        continue;
        localObject3 = (Contents)zza.zza(paramParcel, m, Contents.CREATOR);
        localObject1 = localObject2;
        localObject2 = localObject3;
        continue;
        localObject3 = zza.zzd(paramParcel, m);
        localObject2 = localObject1;
        localObject1 = localObject3;
        continue;
        i = zza.zzg(paramParcel, m);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
    }
    if (paramParcel.dataPosition() != k)
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    return new CloseContentsRequest(j, localObject1, localObject2, i);
  }

  public CloseContentsRequest[] zzgr(int paramInt)
  {
    return new CloseContentsRequest[paramInt];
  }
}