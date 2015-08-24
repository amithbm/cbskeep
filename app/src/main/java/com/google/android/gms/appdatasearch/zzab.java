package com.google.android.gms.appdatasearch;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzab
  implements Parcelable.Creator<SearchResults>
{
  static void zza(SearchResults paramSearchResults, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zza(paramParcel, 1, mErrorMessage, false);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zza(paramParcel, 2, zzNV, false);
    zzb.zza(paramParcel, 3, zzNW, false);
    zzb.zza(paramParcel, 4, zzNX, paramInt, false);
    zzb.zza(paramParcel, 5, zzNY, paramInt, false);
    zzb.zza(paramParcel, 6, zzNZ, paramInt, false);
    zzb.zzc(paramParcel, 7, zzOa);
    zzb.zza(paramParcel, 8, zzOb, false);
    zzb.zza(paramParcel, 9, zzOc, false);
    zzb.zza(paramParcel, 10, zzOd, false);
    zzb.zza(paramParcel, 11, zzOe, false);
    zzb.zza(paramParcel, 12, zzOf, false);
    zzb.zzc(paramParcel, 13, zzOg);
    zzb.zzJ(paramParcel, i);
  }

  public SearchResults zzT(Parcel paramParcel)
  {
    int m = zza.zzcQ(paramParcel);
    int k = 0;
    String str = null;
    int[] arrayOfInt2 = null;
    byte[] arrayOfByte2 = null;
    Bundle[] arrayOfBundle3 = null;
    Bundle[] arrayOfBundle2 = null;
    Bundle[] arrayOfBundle1 = null;
    int j = 0;
    int[] arrayOfInt1 = null;
    String[] arrayOfString = null;
    byte[] arrayOfByte1 = null;
    double[] arrayOfDouble = null;
    Bundle localBundle = null;
    int i = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = zza.zzcP(paramParcel);
      switch (zza.zzeS(n))
      {
      default:
        zza.zzb(paramParcel, n);
        break;
      case 1:
        str = zza.zzp(paramParcel, n);
        break;
      case 1000:
        k = zza.zzg(paramParcel, n);
        break;
      case 2:
        arrayOfInt2 = zza.zzv(paramParcel, n);
        break;
      case 3:
        arrayOfByte2 = zza.zzs(paramParcel, n);
        break;
      case 4:
        arrayOfBundle3 = (Bundle[])zza.zzb(paramParcel, n, Bundle.CREATOR);
        break;
      case 5:
        arrayOfBundle2 = (Bundle[])zza.zzb(paramParcel, n, Bundle.CREATOR);
        break;
      case 6:
        arrayOfBundle1 = (Bundle[])zza.zzb(paramParcel, n, Bundle.CREATOR);
        break;
      case 7:
        j = zza.zzg(paramParcel, n);
        break;
      case 8:
        arrayOfInt1 = zza.zzv(paramParcel, n);
        break;
      case 9:
        arrayOfString = zza.zzB(paramParcel, n);
        break;
      case 10:
        arrayOfByte1 = zza.zzs(paramParcel, n);
        break;
      case 11:
        arrayOfDouble = zza.zzz(paramParcel, n);
        break;
      case 12:
        localBundle = zza.zzr(paramParcel, n);
        break;
      case 13:
        i = zza.zzg(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m)
      throw new zza.zza("Overread allowed size end=" + m, paramParcel);
    return new SearchResults(k, str, arrayOfInt2, arrayOfByte2, arrayOfBundle3, arrayOfBundle2, arrayOfBundle1, j, arrayOfInt1, arrayOfString, arrayOfByte1, arrayOfDouble, localBundle, i);
  }

  public SearchResults[] zzaJ(int paramInt)
  {
    return new SearchResults[paramInt];
  }
}