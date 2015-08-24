package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;

public class zzb
  implements Parcelable.Creator<CredentialRequest>
{
  static void zza(CredentialRequest paramCredentialRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = com.google.android.gms.common.internal.safeparcel.zzb.zzcR(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 1, paramCredentialRequest.getSupportsPasswordLogin());
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1000, mVersionCode);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 2, paramCredentialRequest.getAccountTypes(), false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzJ(paramParcel, paramInt);
  }

  public CredentialRequest zzas(Parcel paramParcel)
  {
    boolean bool = false;
    int j = zza.zzcQ(paramParcel);
    String[] arrayOfString = null;
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
        bool = zza.zzc(paramParcel, k);
        break;
      case 1000:
        i = zza.zzg(paramParcel, k);
        break;
      case 2:
        arrayOfString = zza.zzB(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new CredentialRequest(i, bool, arrayOfString);
  }

  public CredentialRequest[] zzbo(int paramInt)
  {
    return new CredentialRequest[paramInt];
  }
}