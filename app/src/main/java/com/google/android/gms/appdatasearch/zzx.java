package com.google.android.gms.appdatasearch;

import android.accounts.Account;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzx
  implements Parcelable.Creator<RegisterCorpusInfo>
{
  static void zza(RegisterCorpusInfo paramRegisterCorpusInfo, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zza(paramParcel, 1, name, false);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zza(paramParcel, 2, version, false);
    zzb.zza(paramParcel, 3, contentProviderUri, paramInt, false);
    zzb.zza(paramParcel, 4, sections, paramInt, false);
    zzb.zza(paramParcel, 7, globalSearchConfig, paramInt, false);
    zzb.zza(paramParcel, 8, trimmable);
    zzb.zza(paramParcel, 9, account, paramInt, false);
    zzb.zza(paramParcel, 10, imeConfig, paramInt, false);
    zzb.zza(paramParcel, 11, schemaOrgType, false);
    zzb.zza(paramParcel, 12, semanticallySearchable);
    zzb.zzJ(paramParcel, i);
  }

  public RegisterCorpusInfo zzP(Parcel paramParcel)
  {
    boolean bool1 = false;
    String str1 = null;
    int j = zza.zzcQ(paramParcel);
    String str2 = "0";
    boolean bool2 = true;
    RegisterCorpusIMEInfo localRegisterCorpusIMEInfo = null;
    Account localAccount = null;
    GlobalSearchCorpusConfig localGlobalSearchCorpusConfig = null;
    RegisterSectionInfo[] arrayOfRegisterSectionInfo = null;
    Uri localUri = null;
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
        str3 = zza.zzp(paramParcel, k);
        break;
      case 1000:
        i = zza.zzg(paramParcel, k);
        break;
      case 2:
        str2 = zza.zzp(paramParcel, k);
        break;
      case 3:
        localUri = (Uri)zza.zza(paramParcel, k, Uri.CREATOR);
        break;
      case 4:
        arrayOfRegisterSectionInfo = (RegisterSectionInfo[])zza.zzb(paramParcel, k, RegisterSectionInfo.CREATOR);
        break;
      case 7:
        localGlobalSearchCorpusConfig = (GlobalSearchCorpusConfig)zza.zza(paramParcel, k, GlobalSearchCorpusConfig.CREATOR);
        break;
      case 8:
        bool2 = zza.zzc(paramParcel, k);
        break;
      case 9:
        localAccount = (Account)zza.zza(paramParcel, k, Account.CREATOR);
        break;
      case 10:
        localRegisterCorpusIMEInfo = (RegisterCorpusIMEInfo)zza.zza(paramParcel, k, RegisterCorpusIMEInfo.CREATOR);
        break;
      case 11:
        str1 = zza.zzp(paramParcel, k);
        break;
      case 12:
        bool1 = zza.zzc(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new RegisterCorpusInfo(i, str3, str2, localUri, arrayOfRegisterSectionInfo, localGlobalSearchCorpusConfig, bool2, localAccount, localRegisterCorpusIMEInfo, str1, bool1);
  }

  public RegisterCorpusInfo[] zzaB(int paramInt)
  {
    return new RegisterCorpusInfo[paramInt];
  }
}