package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzag
  implements Parcelable.Creator<UsageInfo>
{
  static void zza(UsageInfo paramUsageInfo, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zza(paramParcel, 1, zzOy, paramInt, false);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zza(paramParcel, 2, zzOz);
    zzb.zzc(paramParcel, 3, zzOA);
    zzb.zza(paramParcel, 4, query, false);
    zzb.zza(paramParcel, 5, zzOB, paramInt, false);
    zzb.zza(paramParcel, 6, zzOC);
    zzb.zzc(paramParcel, 7, zzOD);
    zzb.zzc(paramParcel, 8, zzOE);
    zzb.zzJ(paramParcel, i);
  }

  public UsageInfo zzY(Parcel paramParcel)
  {
    DocumentContents localDocumentContents = null;
    int i = 0;
    int n = zza.zzcQ(paramParcel);
    long l = 0L;
    int j = -1;
    boolean bool = false;
    String str = null;
    int k = 0;
    DocumentId localDocumentId = null;
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
        localDocumentId = (DocumentId)zza.zza(paramParcel, i1, DocumentId.CREATOR);
        break;
      case 1000:
        m = zza.zzg(paramParcel, i1);
        break;
      case 2:
        l = zza.zzi(paramParcel, i1);
        break;
      case 3:
        k = zza.zzg(paramParcel, i1);
        break;
      case 4:
        str = zza.zzp(paramParcel, i1);
        break;
      case 5:
        localDocumentContents = (DocumentContents)zza.zza(paramParcel, i1, DocumentContents.CREATOR);
        break;
      case 6:
        bool = zza.zzc(paramParcel, i1);
        break;
      case 7:
        j = zza.zzg(paramParcel, i1);
        break;
      case 8:
        i = zza.zzg(paramParcel, i1);
      }
    }
    if (paramParcel.dataPosition() != n)
      throw new zza.zza("Overread allowed size end=" + n, paramParcel);
    return new UsageInfo(m, localDocumentId, l, k, str, localDocumentContents, bool, j, i);
  }

  public UsageInfo[] zzaO(int paramInt)
  {
    return new UsageInfo[paramInt];
  }
}