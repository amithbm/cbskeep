package com.google.android.gms.appdatasearch;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzf
  implements Parcelable.Creator<DocumentResults>
{
  static void zza(DocumentResults paramDocumentResults, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zza(paramParcel, 1, mErrorMessage, false);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zza(paramParcel, 2, zzMI, false);
    zzb.zza(paramParcel, 3, zzMJ, false);
    zzb.zza(paramParcel, 4, zzMK, false);
    zzb.zzJ(paramParcel, paramInt);
  }

  public DocumentResults[] zzaj(int paramInt)
  {
    return new DocumentResults[paramInt];
  }

  public DocumentResults zzx(Parcel paramParcel)
  {
    Bundle localBundle1 = null;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    Bundle localBundle2 = null;
    Bundle localBundle3 = null;
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
        localBundle3 = zza.zzr(paramParcel, k);
        break;
      case 3:
        localBundle2 = zza.zzr(paramParcel, k);
        break;
      case 4:
        localBundle1 = zza.zzr(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new DocumentResults(i, str, localBundle3, localBundle2, localBundle1);
  }
}