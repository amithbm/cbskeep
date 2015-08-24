package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzak
  implements Parcelable.Creator<ValidateAccountCredentialsResponse>
{
  static void zza(ValidateAccountCredentialsResponse paramValidateAccountCredentialsResponse, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, version);
    zzb.zzc(paramParcel, 2, status);
    zzb.zza(paramParcel, 3, accountId, false);
    zzb.zzJ(paramParcel, paramInt);
  }

  public ValidateAccountCredentialsResponse zzbn(Parcel paramParcel)
  {
    int j = 0;
    int k = zza.zzcQ(paramParcel);
    String str = null;
    int i = 0;
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
      case 2:
        j = zza.zzg(paramParcel, m);
        break;
      case 3:
        str = zza.zzp(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k)
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    return new ValidateAccountCredentialsResponse(i, j, str);
  }

  public ValidateAccountCredentialsResponse[] zzcj(int paramInt)
  {
    return new ValidateAccountCredentialsResponse[paramInt];
  }
}