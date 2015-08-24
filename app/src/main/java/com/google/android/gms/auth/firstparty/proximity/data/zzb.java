package com.google.android.gms.auth.firstparty.proximity.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;

public class zzb
  implements Parcelable.Creator<AuthorizationRequest>
{
  static void zza(AuthorizationRequest paramAuthorizationRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = com.google.android.gms.common.internal.safeparcel.zzb.zzcR(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1, mVersion);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 2, mPermitId, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 3, mPermitAccessId, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 4, mData, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzJ(paramParcel, paramInt);
  }

  public AuthorizationRequest zzbx(Parcel paramParcel)
  {
    byte[] arrayOfByte = null;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    String str2 = null;
    String str1 = null;
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
        str1 = zza.zzp(paramParcel, k);
        break;
      case 3:
        str2 = zza.zzp(paramParcel, k);
        break;
      case 4:
        arrayOfByte = zza.zzs(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new AuthorizationRequest(i, str1, str2, arrayOfByte);
  }

  public AuthorizationRequest[] zzct(int paramInt)
  {
    return new AuthorizationRequest[paramInt];
  }
}