package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzm
  implements Parcelable.Creator<CheckFactoryResetPolicyComplianceResponse>
{
  static void zza(CheckFactoryResetPolicyComplianceResponse paramCheckFactoryResetPolicyComplianceResponse, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, version);
    zzb.zza(paramParcel, 2, isCompliant);
    zzb.zzJ(paramParcel, paramInt);
  }

  public CheckFactoryResetPolicyComplianceResponse zzaQ(Parcel paramParcel)
  {
    boolean bool = false;
    int j = zza.zzcQ(paramParcel);
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
        bool = zza.zzc(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new CheckFactoryResetPolicyComplianceResponse(i, bool);
  }

  public CheckFactoryResetPolicyComplianceResponse[] zzbM(int paramInt)
  {
    return new CheckFactoryResetPolicyComplianceResponse[paramInt];
  }
}