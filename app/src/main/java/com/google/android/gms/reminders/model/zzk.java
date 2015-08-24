package com.google.android.gms.reminders.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzk
  implements Parcelable.Creator<MonthlyPatternEntity>
{
  static void zza(MonthlyPatternEntity paramMonthlyPatternEntity, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, paramMonthlyPatternEntity.getMonthDay(), false);
    zzb.zza(paramParcel, 4, paramMonthlyPatternEntity.getWeekDay(), false);
    zzb.zza(paramParcel, 5, paramMonthlyPatternEntity.getWeekDayNumber(), false);
    zzb.zzJ(paramParcel, paramInt);
  }

  public MonthlyPatternEntity zzkP(Parcel paramParcel)
  {
    Integer localInteger2 = null;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    Integer localInteger1 = null;
    ArrayList localArrayList = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzcP(paramParcel);
      switch (zza.zzeS(k))
      {
      case 3:
      default:
        zza.zzb(paramParcel, k);
        break;
      case 1:
        i = zza.zzg(paramParcel, k);
        break;
      case 2:
        localArrayList = zza.zzC(paramParcel, k);
        break;
      case 4:
        localInteger1 = zza.zzh(paramParcel, k);
        break;
      case 5:
        localInteger2 = zza.zzh(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new MonthlyPatternEntity(i, localArrayList, localInteger1, localInteger2);
  }

  public MonthlyPatternEntity[] zzot(int paramInt)
  {
    return new MonthlyPatternEntity[paramInt];
  }
}