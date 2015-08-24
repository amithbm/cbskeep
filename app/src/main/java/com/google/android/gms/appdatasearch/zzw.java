package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzw
  implements Parcelable.Creator<RegisterCorpusIMEInfo>
{
  static void zza(RegisterCorpusIMEInfo paramRegisterCorpusIMEInfo, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, sourceClass);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zza(paramParcel, 2, sectionNames, false);
    zzb.zza(paramParcel, 3, userInputTag, false);
    zzb.zza(paramParcel, 4, userInputSectionName, false);
    zzb.zza(paramParcel, 6, toAddressesSectionName, false);
    zzb.zza(paramParcel, 7, userInputSectionValues, false);
    zzb.zzJ(paramParcel, paramInt);
  }

  public RegisterCorpusIMEInfo zzO(Parcel paramParcel)
  {
    int i = 0;
    String str1 = null;
    int k = zza.zzcQ(paramParcel);
    String[] arrayOfString1 = null;
    String str2 = null;
    String str3 = null;
    String[] arrayOfString2 = null;
    int j = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = zza.zzcP(paramParcel);
      switch (zza.zzeS(m))
      {
      default:
        zza.zzb(paramParcel, m);
        break;
      case 1:
        i = zza.zzg(paramParcel, m);
        break;
      case 1000:
        j = zza.zzg(paramParcel, m);
        break;
      case 2:
        arrayOfString2 = zza.zzB(paramParcel, m);
        break;
      case 3:
        str3 = zza.zzp(paramParcel, m);
        break;
      case 4:
        str2 = zza.zzp(paramParcel, m);
        break;
      case 6:
        str1 = zza.zzp(paramParcel, m);
        break;
      case 7:
        arrayOfString1 = zza.zzB(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k)
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    return new RegisterCorpusIMEInfo(j, i, arrayOfString2, str3, str2, arrayOfString1, str1);
  }

  public RegisterCorpusIMEInfo[] zzaA(int paramInt)
  {
    return new RegisterCorpusIMEInfo[paramInt];
  }
}