package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzaf
  implements Parcelable.Creator<SuggestionResults>
{
  static void zza(SuggestionResults paramSuggestionResults, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zza(paramParcel, 1, mErrorMessage, false);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zza(paramParcel, 2, zzOp, false);
    zzb.zza(paramParcel, 3, zzOq, false);
    zzb.zzJ(paramParcel, paramInt);
  }

  public SuggestionResults zzX(Parcel paramParcel)
  {
    String[] arrayOfString2 = null;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    String[] arrayOfString1 = null;
    String str = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzcP(paramParcel);
      switch (zza.zzeS(k))
      {
      default:
        zza.zzb(paramParcel, k);
        break;
      case 1:
        str = zza.zzp(paramParcel, k);
        break;
      case 1000:
        i = zza.zzg(paramParcel, k);
        break;
      case 2:
        arrayOfString1 = zza.zzB(paramParcel, k);
        break;
      case 3:
        arrayOfString2 = zza.zzB(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new SuggestionResults(i, str, arrayOfString1, arrayOfString2);
  }

  public SuggestionResults[] zzaN(int paramInt)
  {
    return new SuggestionResults[paramInt];
  }
}