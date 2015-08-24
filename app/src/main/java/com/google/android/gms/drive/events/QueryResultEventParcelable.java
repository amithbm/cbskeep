package com.google.android.gms.drive.events;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.WriteAwareParcelable;

public class QueryResultEventParcelable extends WriteAwareParcelable
  implements DriveEvent
{
  public static final zzh CREATOR = new zzh();
  final DataHolder mDataHolder;
  final int mVersionCode;
  final boolean zzatu;
  final int zzatv;

  QueryResultEventParcelable(int paramInt1, DataHolder paramDataHolder, boolean paramBoolean, int paramInt2)
  {
    mVersionCode = paramInt1;
    mDataHolder = paramDataHolder;
    zzatu = paramBoolean;
    zzatv = paramInt2;
  }

  public int describeContents()
  {
    return 0;
  }

  public void zzK(Parcel paramParcel, int paramInt)
  {
    zzh.zza(this, paramParcel, paramInt);
  }
}