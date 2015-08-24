package com.google.android.gms.appdatasearch;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzi
  implements Parcelable.Creator<GetRecentContextCall.Request>
{
  static void zza(GetRecentContextCall.Request paramRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zza(paramParcel, 1, filterAccount, paramInt, false);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zza(paramParcel, 2, includeDeviceOnlyData);
    zzb.zza(paramParcel, 3, includeThirdPartyContext);
    zzb.zza(paramParcel, 4, includeUsageEnded);
    zzb.zzJ(paramParcel, i);
  }

  public GetRecentContextCall.Request zzA(Parcel paramParcel)
  {
    boolean bool1 = false;
    int j = zza.zzcQ(paramParcel);
    Account localAccount = null;
    boolean bool2 = false;
    boolean bool3 = false;
    int i = 0;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzcP(paramParcel);
      switch (zza.zzeS(k))
      {
      default:
        zza.zzb(paramParcel, k);
        break;
      case 1:
        localAccount = (Account)zza.zza(paramParcel, k, Account.CREATOR);
        break;
      case 1000:
        i = zza.zzg(paramParcel, k);
        break;
      case 2:
        bool3 = zza.zzc(paramParcel, k);
        break;
      case 3:
        bool2 = zza.zzc(paramParcel, k);
        break;
      case 4:
        bool1 = zza.zzc(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new GetRecentContextCall.Request(i, localAccount, bool3, bool2, bool1);
  }

  public GetRecentContextCall.Request[] zzam(int paramInt)
  {
    return new GetRecentContextCall.Request[paramInt];
  }
}