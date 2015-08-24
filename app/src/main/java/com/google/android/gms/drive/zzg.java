package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzg
  implements Parcelable.Creator<RealtimeDocumentSyncRequest>
{
  static void zza(RealtimeDocumentSyncRequest paramRealtimeDocumentSyncRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zzc(paramParcel, 2, zzasT, false);
    zzb.zzc(paramParcel, 3, zzasU, false);
    zzb.zzJ(paramParcel, paramInt);
  }

  public RealtimeDocumentSyncRequest zzdO(Parcel paramParcel)
  {
    ArrayList localArrayList2 = null;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    ArrayList localArrayList1 = null;
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
        localArrayList1 = zza.zzE(paramParcel, k);
        break;
      case 3:
        localArrayList2 = zza.zzE(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new RealtimeDocumentSyncRequest(i, localArrayList1, localArrayList2);
  }

  public RealtimeDocumentSyncRequest[] zzgd(int paramInt)
  {
    return new RealtimeDocumentSyncRequest[paramInt];
  }
}