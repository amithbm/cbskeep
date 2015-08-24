package com.google.android.gms.reminders;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza
  implements Parcelable.Creator<AccountState>
{
  static void zza(AccountState paramAccountState, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, paramAccountState.getBits(), false);
    zzb.zza(paramParcel, 3, paramAccountState.getIsSetBits(), false);
    zzb.zzJ(paramParcel, paramInt);
  }

  public AccountState zzkB(Parcel paramParcel)
  {
    boolean[] arrayOfBoolean2 = null;
    int j = com.google.android.gms.common.internal.safeparcel.zza.zzcQ(paramParcel);
    int i = 0;
    boolean[] arrayOfBoolean1 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = com.google.android.gms.common.internal.safeparcel.zza.zzcP(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.zza.zzeS(k))
      {
      default:
        com.google.android.gms.common.internal.safeparcel.zza.zzb(paramParcel, k);
        break;
      case 1:
        i = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, k);
        break;
      case 2:
        arrayOfBoolean1 = com.google.android.gms.common.internal.safeparcel.zza.zzu(paramParcel, k);
        break;
      case 3:
        arrayOfBoolean2 = com.google.android.gms.common.internal.safeparcel.zza.zzu(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new AccountState(i, arrayOfBoolean1, arrayOfBoolean2);
  }

  public AccountState[] zzoe(int paramInt)
  {
    return new AccountState[paramInt];
  }
}