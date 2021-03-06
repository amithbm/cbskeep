package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzak
  implements Parcelable.Creator<ValidateAccountRequest>
{
  static void zza(ValidateAccountRequest paramValidateAccountRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zzc(paramParcel, 2, paramValidateAccountRequest.zzqe());
    zzb.zza(paramParcel, 3, zzakz, false);
    zzb.zza(paramParcel, 4, paramValidateAccountRequest.zzqf(), paramInt, false);
    zzb.zza(paramParcel, 5, paramValidateAccountRequest.zzqg(), false);
    zzb.zza(paramParcel, 6, paramValidateAccountRequest.getCallingPackage(), false);
    zzb.zzJ(paramParcel, i);
  }

  public ValidateAccountRequest zzcO(Parcel paramParcel)
  {
    int i = 0;
    String str = null;
    int k = zza.zzcQ(paramParcel);
    Bundle localBundle = null;
    Scope[] arrayOfScope = null;
    IBinder localIBinder = null;
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
        j = zza.zzg(paramParcel, m);
        break;
      case 2:
        i = zza.zzg(paramParcel, m);
        break;
      case 3:
        localIBinder = zza.zzq(paramParcel, m);
        break;
      case 4:
        arrayOfScope = (Scope[])zza.zzb(paramParcel, m, Scope.CREATOR);
        break;
      case 5:
        localBundle = zza.zzr(paramParcel, m);
        break;
      case 6:
        str = zza.zzp(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k)
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    return new ValidateAccountRequest(j, i, localIBinder, arrayOfScope, localBundle, str);
  }

  public ValidateAccountRequest[] zzeR(int paramInt)
  {
    return new ValidateAccountRequest[paramInt];
  }
}