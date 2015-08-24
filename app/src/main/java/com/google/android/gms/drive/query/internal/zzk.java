package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzk
  implements Parcelable.Creator<LogicalFilter>
{
  static void zza(LogicalFilter paramLogicalFilter, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zza(paramParcel, 1, zzaxL, paramInt, false);
    zzb.zzd(paramParcel, 2, zzaya, false);
    zzb.zzJ(paramParcel, i);
  }

  public LogicalFilter zzfj(Parcel paramParcel)
  {
    ArrayList localArrayList = null;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    Operator localOperator = null;
    if (paramParcel.dataPosition() < j)
    {
      int k = zza.zzcP(paramParcel);
      switch (zza.zzeS(k))
      {
      default:
        zza.zzb(paramParcel, k);
      case 1000:
      case 1:
      case 2:
      }
      while (true)
      {
        break;
        i = zza.zzg(paramParcel, k);
        continue;
        localOperator = (Operator)zza.zza(paramParcel, k, Operator.CREATOR);
        continue;
        localArrayList = zza.zzc(paramParcel, k, FilterHolder.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new LogicalFilter(i, localOperator, localArrayList);
  }

  public LogicalFilter[] zzhD(int paramInt)
  {
    return new LogicalFilter[paramInt];
  }
}