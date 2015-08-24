package com.google.android.gms.location.reporting;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc
  implements Parcelable.Creator<ReportingState>
{
  static void zza(ReportingState paramReportingState, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, paramReportingState.getVersionCode());
    zzb.zzc(paramParcel, 2, paramReportingState.getReportingEnabled());
    zzb.zzc(paramParcel, 3, paramReportingState.getHistoryEnabled());
    zzb.zza(paramParcel, 4, paramReportingState.isAllowed());
    zzb.zza(paramParcel, 5, paramReportingState.isActive());
    zzb.zza(paramParcel, 6, paramReportingState.isDeferringToMaps());
    zzb.zzc(paramParcel, 7, paramReportingState.getExpectedOptInResult());
    zzb.zza(paramParcel, 8, paramReportingState.zzzj(), false);
    zzb.zzc(paramParcel, 9, paramReportingState.zzzi());
    zzb.zzJ(paramParcel, paramInt);
  }

  public ReportingState zziN(Parcel paramParcel)
  {
    int i = 0;
    int i1 = zza.zzcQ(paramParcel);
    Integer localInteger = null;
    int j = 0;
    boolean bool1 = false;
    boolean bool2 = false;
    boolean bool3 = false;
    int k = 0;
    int m = 0;
    int n = 0;
    while (paramParcel.dataPosition() < i1)
    {
      int i2 = zza.zzcP(paramParcel);
      switch (zza.zzeS(i2))
      {
      default:
        zza.zzb(paramParcel, i2);
        break;
      case 1:
        n = zza.zzg(paramParcel, i2);
        break;
      case 2:
        m = zza.zzg(paramParcel, i2);
        break;
      case 3:
        k = zza.zzg(paramParcel, i2);
        break;
      case 4:
        bool3 = zza.zzc(paramParcel, i2);
        break;
      case 5:
        bool2 = zza.zzc(paramParcel, i2);
        break;
      case 6:
        bool1 = zza.zzc(paramParcel, i2);
        break;
      case 7:
        j = zza.zzg(paramParcel, i2);
        break;
      case 8:
        localInteger = zza.zzh(paramParcel, i2);
        break;
      case 9:
        i = zza.zzg(paramParcel, i2);
      }
    }
    if (paramParcel.dataPosition() != i1)
      throw new zza.zza("Overread allowed size end=" + i1, paramParcel);
    return new ReportingState(n, m, k, bool3, bool2, bool1, j, i, localInteger);
  }

  public ReportingState[] zzlU(int paramInt)
  {
    return new ReportingState[paramInt];
  }
}