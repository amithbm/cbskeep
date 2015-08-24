package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzm
  implements Parcelable.Creator<GlobalSearchApplicationInfo>
{
  static void zza(GlobalSearchApplicationInfo paramGlobalSearchApplicationInfo, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zza(paramParcel, 1, packageName, false);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zzc(paramParcel, 2, labelId);
    zzb.zzc(paramParcel, 3, settingsDescriptionId);
    zzb.zzc(paramParcel, 4, iconId);
    zzb.zza(paramParcel, 5, defaultIntentAction, false);
    zzb.zza(paramParcel, 6, defaultIntentData, false);
    zzb.zza(paramParcel, 7, defaultIntentActivity, false);
    zzb.zzJ(paramParcel, paramInt);
  }

  public GlobalSearchApplicationInfo zzE(Parcel paramParcel)
  {
    String str1 = null;
    int i = 0;
    int n = zza.zzcQ(paramParcel);
    String str2 = null;
    String str3 = null;
    int j = 0;
    int k = 0;
    String str4 = null;
    int m = 0;
    while (paramParcel.dataPosition() < n)
    {
      int i1 = zza.zzcP(paramParcel);
      switch (zza.zzeS(i1))
      {
      default:
        zza.zzb(paramParcel, i1);
        break;
      case 1:
        str4 = zza.zzp(paramParcel, i1);
        break;
      case 1000:
        m = zza.zzg(paramParcel, i1);
        break;
      case 2:
        k = zza.zzg(paramParcel, i1);
        break;
      case 3:
        j = zza.zzg(paramParcel, i1);
        break;
      case 4:
        i = zza.zzg(paramParcel, i1);
        break;
      case 5:
        str3 = zza.zzp(paramParcel, i1);
        break;
      case 6:
        str2 = zza.zzp(paramParcel, i1);
        break;
      case 7:
        str1 = zza.zzp(paramParcel, i1);
      }
    }
    if (paramParcel.dataPosition() != n)
      throw new zza.zza("Overread allowed size end=" + n, paramParcel);
    return new GlobalSearchApplicationInfo(m, str4, k, j, i, str3, str2, str1);
  }

  public GlobalSearchApplicationInfo[] zzaq(int paramInt)
  {
    return new GlobalSearchApplicationInfo[paramInt];
  }
}