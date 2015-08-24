package com.google.android.gms.people.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AccountMetadata
  implements SafeParcelable
{
  public static final zza CREATOR = new zza();
  public boolean isPagePeriodicSyncEnabled;
  public boolean isPageTickleSyncEnabled;
  public boolean isPlusEnabled;
  public boolean isSyncEnabled;
  final int mVersionCode;

  public AccountMetadata()
  {
    mVersionCode = 2;
  }

  AccountMetadata(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    mVersionCode = paramInt;
    isPlusEnabled = paramBoolean1;
    isSyncEnabled = paramBoolean2;
    isPagePeriodicSyncEnabled = paramBoolean3;
    isPageTickleSyncEnabled = paramBoolean4;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
}