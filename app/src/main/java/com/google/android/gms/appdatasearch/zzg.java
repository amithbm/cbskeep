package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzg
  implements Parcelable.Creator<DocumentSection>
{
  static void zza(DocumentSection paramDocumentSection, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zza(paramParcel, 1, content, false);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zza(paramParcel, 3, zzMM, paramInt, false);
    zzb.zzc(paramParcel, 4, globalSearchSectionType);
    zzb.zza(paramParcel, 5, blobContent, false);
    zzb.zzJ(paramParcel, i);
  }

  public DocumentSection[] zzak(int paramInt)
  {
    return new DocumentSection[paramInt];
  }

  public DocumentSection zzy(Parcel paramParcel)
  {
    byte[] arrayOfByte = null;
    int k = zza.zzcQ(paramParcel);
    int j = 0;
    int i = -1;
    RegisterSectionInfo localRegisterSectionInfo = null;
    String str = null;
    while (paramParcel.dataPosition() < k)
    {
      int m = zza.zzcP(paramParcel);
      switch (zza.zzeS(m))
      {
      default:
        zza.zzb(paramParcel, m);
        break;
      case 1:
        str = zza.zzp(paramParcel, m);
        break;
      case 1000:
        j = zza.zzg(paramParcel, m);
        break;
      case 3:
        localRegisterSectionInfo = (RegisterSectionInfo)zza.zza(paramParcel, m, RegisterSectionInfo.CREATOR);
        break;
      case 4:
        i = zza.zzg(paramParcel, m);
        break;
      case 5:
        arrayOfByte = zza.zzs(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k)
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    return new DocumentSection(j, str, localRegisterSectionInfo, i, arrayOfByte);
  }
}