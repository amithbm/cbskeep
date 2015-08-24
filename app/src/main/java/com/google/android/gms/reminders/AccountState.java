package com.google.android.gms.reminders;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AccountState
  implements SafeParcelable
{
  public static final Parcelable.Creator<AccountState> CREATOR = new zza();
  public final int mVersionCode;
  private final boolean[] zzblu;
  private final boolean[] zzblv;

  AccountState(int paramInt, boolean[] paramArrayOfBoolean1, boolean[] paramArrayOfBoolean2)
  {
    mVersionCode = paramInt;
    zzblu = paramArrayOfBoolean1;
    zzblv = paramArrayOfBoolean2;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean[] getBits()
  {
    return zzblu;
  }

  public boolean[] getIsSetBits()
  {
    return zzblv;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
}