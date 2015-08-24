package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzr
  implements Parcelable.Creator<PIMEUpdateResponse>
{
  static void zza(PIMEUpdateResponse paramPIMEUpdateResponse, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zza(paramParcel, 1, mErrorMessage, false);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zza(paramParcel, 2, nextIterToken, false);
    zzb.zza(paramParcel, 3, updates, paramInt, false);
    zzb.zzJ(paramParcel, i);
  }

  public PIMEUpdateResponse zzJ(Parcel paramParcel)
  {
    PIMEUpdate[] arrayOfPIMEUpdate = null;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    byte[] arrayOfByte = null;
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
        arrayOfByte = zza.zzs(paramParcel, k);
        break;
      case 3:
        arrayOfPIMEUpdate = (PIMEUpdate[])zza.zzb(paramParcel, k, PIMEUpdate.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new PIMEUpdateResponse(i, str, arrayOfByte, arrayOfPIMEUpdate);
  }

  public PIMEUpdateResponse[] zzav(int paramInt)
  {
    return new PIMEUpdateResponse[paramInt];
  }
}