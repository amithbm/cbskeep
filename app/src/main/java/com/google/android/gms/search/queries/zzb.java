package com.google.android.gms.search.queries;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.appdatasearch.DocumentResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;

public class zzb
  implements Parcelable.Creator<GetDocumentsCall.Response>
{
  static void zza(GetDocumentsCall.Response paramResponse, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.zzb.zzcR(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1000, mVersionCode);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 1, status, paramInt, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 2, documents, paramInt, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzJ(paramParcel, i);
  }

  public GetDocumentsCall.Response zzlH(Parcel paramParcel)
  {
    DocumentResults localDocumentResults = null;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    Status localStatus = null;
    if (paramParcel.dataPosition() < j)
    {
      int k = zza.zzcP(paramParcel);
      switch (zza.zzeS(k))
      {
      default:
        zza.zzb(paramParcel, k);
      case 1000:
      case 1:
      case 2:
      }
      while (true)
      {
        break;
        i = zza.zzg(paramParcel, k);
        continue;
        localStatus = (Status)zza.zza(paramParcel, k, Status.CREATOR);
        continue;
        localDocumentResults = (DocumentResults)zza.zza(paramParcel, k, DocumentResults.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new GetDocumentsCall.Response(i, localStatus, localDocumentResults);
  }

  public GetDocumentsCall.Response[] zzpl(int paramInt)
  {
    return new GetDocumentsCall.Response[paramInt];
  }
}