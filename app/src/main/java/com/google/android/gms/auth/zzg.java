package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzg
  implements Parcelable.Creator<RecoveryWriteRequest>
{
  static void zza(RecoveryWriteRequest paramRecoveryWriteRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, mAccount, false);
    zzb.zza(paramParcel, 3, mSecondaryEmail, false);
    zzb.zza(paramParcel, 4, mPhoneNumber, false);
    zzb.zza(paramParcel, 5, mPhoneCountryCode, false);
    zzb.zza(paramParcel, 6, mIsBroadUse);
    zzb.zzJ(paramParcel, paramInt);
  }

  public RecoveryWriteRequest zzap(Parcel paramParcel)
  {
    boolean bool = false;
    String str1 = null;
    int j = zza.zzcQ(paramParcel);
    String str2 = null;
    String str3 = null;
    String str4 = null;
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
        str4 = zza.zzp(paramParcel, k);
        break;
      case 3:
        str3 = zza.zzp(paramParcel, k);
        break;
      case 4:
        str2 = zza.zzp(paramParcel, k);
        break;
      case 5:
        str1 = zza.zzp(paramParcel, k);
        break;
      case 6:
        bool = zza.zzc(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new RecoveryWriteRequest(i, str4, str3, str2, str1, bool);
  }

  public RecoveryWriteRequest[] zzbl(int paramInt)
  {
    return new RecoveryWriteRequest[paramInt];
  }
}