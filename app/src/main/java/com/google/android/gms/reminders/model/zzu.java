package com.google.android.gms.reminders.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzu
  implements Parcelable.Creator<YearlyPatternEntity>
{
  static void zza(YearlyPatternEntity paramYearlyPatternEntity, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, paramYearlyPatternEntity.getMonthlyPattern(), paramInt, false);
    zzb.zza(paramParcel, 3, paramYearlyPatternEntity.getYearMonth(), false);
    zzb.zzJ(paramParcel, i);
  }

  public YearlyPatternEntity zzkZ(Parcel paramParcel)
  {
    ArrayList localArrayList = null;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    MonthlyPatternEntity localMonthlyPatternEntity = null;
    if (paramParcel.dataPosition() < j)
    {
      int k = zza.zzcP(paramParcel);
      switch (zza.zzeS(k))
      {
      default:
        zza.zzb(paramParcel, k);
      case 1:
      case 2:
      case 3:
      }
      while (true)
      {
        break;
        i = zza.zzg(paramParcel, k);
        continue;
        localMonthlyPatternEntity = (MonthlyPatternEntity)zza.zza(paramParcel, k, MonthlyPatternEntity.CREATOR);
        continue;
        localArrayList = zza.zzC(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new YearlyPatternEntity(i, localMonthlyPatternEntity, localArrayList);
  }

  public YearlyPatternEntity[] zzoD(int paramInt)
  {
    return new YearlyPatternEntity[paramInt];
  }
}