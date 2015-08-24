package com.google.android.gms.auth.firstparty.dataservice;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzt
  implements Parcelable.Creator<GoogleAccountData>
{
  static void zza(GoogleAccountData paramGoogleAccountData, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, version);
    zzb.zza(paramParcel, 2, accountName, false);
    zzb.zza(paramParcel, 3, zzSu);
    zzb.zzc(paramParcel, 4, services, false);
    zzb.zza(paramParcel, 5, firstName, false);
    zzb.zza(paramParcel, 6, lastName, false);
    zzb.zza(paramParcel, 7, account, paramInt, false);
    zzb.zzJ(paramParcel, i);
  }

  public GoogleAccountData zzaX(Parcel paramParcel)
  {
    boolean bool = false;
    Account localAccount = null;
    int j = zza.zzcQ(paramParcel);
    String str1 = null;
    String str2 = null;
    ArrayList localArrayList = null;
    String str3 = null;
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
        i = zza.zzg(paramParcel, k);
        break;
      case 2:
        str3 = zza.zzp(paramParcel, k);
        break;
      case 3:
        bool = zza.zzc(paramParcel, k);
        break;
      case 4:
        localArrayList = zza.zzE(paramParcel, k);
        break;
      case 5:
        str2 = zza.zzp(paramParcel, k);
        break;
      case 6:
        str1 = zza.zzp(paramParcel, k);
        break;
      case 7:
        localAccount = (Account)zza.zza(paramParcel, k, Account.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new GoogleAccountData(i, str3, bool, localArrayList, str2, str1, localAccount);
  }

  public GoogleAccountData[] zzbT(int paramInt)
  {
    return new GoogleAccountData[paramInt];
  }
}