package com.google.android.gms.appdatasearch;

import android.accounts.Account;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzq
  implements Parcelable.Creator<PIMEUpdate>
{
  static void zza(PIMEUpdate paramPIMEUpdate, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zza(paramParcel, 1, zzNm, false);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zza(paramParcel, 2, zzNn, false);
    zzb.zzc(paramParcel, 3, sourceClass);
    zzb.zza(paramParcel, 4, sourcePackageName, false);
    zzb.zza(paramParcel, 5, sourceCorpusHandle, false);
    zzb.zza(paramParcel, 6, inputByUser);
    zzb.zza(paramParcel, 8, zzNo, false);
    zzb.zza(paramParcel, 9, score);
    zzb.zza(paramParcel, 10, createdTimestamp);
    zzb.zza(paramParcel, 11, account, paramInt, false);
    zzb.zzJ(paramParcel, i);
  }

  public PIMEUpdate zzI(Parcel paramParcel)
  {
    int k = zza.zzcQ(paramParcel);
    int j = 0;
    byte[] arrayOfByte2 = null;
    byte[] arrayOfByte1 = null;
    int i = 0;
    String str2 = null;
    String str1 = null;
    boolean bool = false;
    Bundle localBundle = null;
    long l2 = 0L;
    long l1 = 0L;
    Account localAccount = null;
    while (paramParcel.dataPosition() < k)
    {
      int m = zza.zzcP(paramParcel);
      switch (zza.zzeS(m))
      {
      default:
        zza.zzb(paramParcel, m);
        break;
      case 1:
        arrayOfByte2 = zza.zzs(paramParcel, m);
        break;
      case 1000:
        j = zza.zzg(paramParcel, m);
        break;
      case 2:
        arrayOfByte1 = zza.zzs(paramParcel, m);
        break;
      case 3:
        i = zza.zzg(paramParcel, m);
        break;
      case 4:
        str2 = zza.zzp(paramParcel, m);
        break;
      case 5:
        str1 = zza.zzp(paramParcel, m);
        break;
      case 6:
        bool = zza.zzc(paramParcel, m);
        break;
      case 8:
        localBundle = zza.zzr(paramParcel, m);
        break;
      case 9:
        l2 = zza.zzi(paramParcel, m);
        break;
      case 10:
        l1 = zza.zzi(paramParcel, m);
        break;
      case 11:
        localAccount = (Account)zza.zza(paramParcel, m, Account.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != k)
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    return new PIMEUpdate(j, arrayOfByte2, arrayOfByte1, i, str2, str1, bool, localBundle, l2, l1, localAccount);
  }

  public PIMEUpdate[] zzau(int paramInt)
  {
    return new PIMEUpdate[paramInt];
  }
}