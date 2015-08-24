package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzy
  implements Parcelable.Creator<OtpRequest>
{
  static void zza(OtpRequest paramOtpRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersion);
    zzb.zza(paramParcel, 2, accountName, false);
    zzb.zza(paramParcel, 3, callerDescription, paramInt, false);
    zzb.zza(paramParcel, 4, challenge, false);
    zzb.zza(paramParcel, 5, isLegacyRequest);
    zzb.zzJ(paramParcel, i);
  }

  public OtpRequest[] zzbX(int paramInt)
  {
    return new OtpRequest[paramInt];
  }

  public OtpRequest zzbb(Parcel paramParcel)
  {
    boolean bool = false;
    byte[] arrayOfByte = null;
    int j = zza.zzcQ(paramParcel);
    AppDescription localAppDescription = null;
    String str = null;
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
        i = zza.zzg(paramParcel, k);
        break;
      case 2:
        str = zza.zzp(paramParcel, k);
        break;
      case 3:
        localAppDescription = (AppDescription)zza.zza(paramParcel, k, AppDescription.CREATOR);
        break;
      case 4:
        arrayOfByte = zza.zzs(paramParcel, k);
        break;
      case 5:
        bool = zza.zzc(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new OtpRequest(i, str, localAppDescription, arrayOfByte, bool);
  }
}