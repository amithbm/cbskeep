package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh
  implements Parcelable.Creator<QueryResultEventParcelable>
{
  static void zza(QueryResultEventParcelable paramQueryResultEventParcelable, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, mDataHolder, paramInt, false);
    zzb.zza(paramParcel, 3, zzatu);
    zzb.zzc(paramParcel, 4, zzatv);
    zzb.zzJ(paramParcel, i);
  }

  public QueryResultEventParcelable zzdV(Parcel paramParcel)
  {
    int i = 0;
    int k = zza.zzcQ(paramParcel);
    DataHolder localDataHolder = null;
    boolean bool = false;
    int j = 0;
    if (paramParcel.dataPosition() < k)
    {
      int m = zza.zzcP(paramParcel);
      switch (zza.zzeS(m))
      {
      default:
        zza.zzb(paramParcel, m);
      case 1:
      case 2:
      case 3:
      case 4:
      }
      while (true)
      {
        break;
        j = zza.zzg(paramParcel, m);
        continue;
        localDataHolder = (DataHolder)zza.zza(paramParcel, m, DataHolder.CREATOR);
        continue;
        bool = zza.zzc(paramParcel, m);
        continue;
        i = zza.zzg(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k)
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    return new QueryResultEventParcelable(j, localDataHolder, bool, i);
  }

  public QueryResultEventParcelable[] zzgk(int paramInt)
  {
    return new QueryResultEventParcelable[paramInt];
  }
}