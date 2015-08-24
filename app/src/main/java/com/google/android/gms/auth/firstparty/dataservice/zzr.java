package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.shared.AccountCredentials;
import com.google.android.gms.auth.firstparty.shared.CaptchaSolution;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzr
  implements Parcelable.Creator<ConfirmCredentialsRequest>
{
  static void zza(ConfirmCredentialsRequest paramConfirmCredentialsRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, version);
    zzb.zza(paramParcel, 2, zzSs, paramInt, false);
    zzb.zza(paramParcel, 3, zzRW, paramInt, false);
    zzb.zzJ(paramParcel, i);
  }

  public ConfirmCredentialsRequest zzaV(Parcel paramParcel)
  {
    CaptchaSolution localCaptchaSolution = null;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    AccountCredentials localAccountCredentials = null;
    if (paramParcel.dataPosition() < j)
    {
      int k = zza.zzcP(paramParcel);
      switch (zza.zzeS(k))
      {
      default:
        zza.zzb(paramParcel, k);
      case 1:
      case 2:
      case 3:
      }
      while (true)
      {
        break;
        i = zza.zzg(paramParcel, k);
        continue;
        localAccountCredentials = (AccountCredentials)zza.zza(paramParcel, k, AccountCredentials.CREATOR);
        continue;
        localCaptchaSolution = (CaptchaSolution)zza.zza(paramParcel, k, CaptchaSolution.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new ConfirmCredentialsRequest(i, localAccountCredentials, localCaptchaSolution);
  }

  public ConfirmCredentialsRequest[] zzbR(int paramInt)
  {
    return new ConfirmCredentialsRequest[paramInt];
  }
}