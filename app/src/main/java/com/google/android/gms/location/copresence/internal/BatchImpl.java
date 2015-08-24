package com.google.android.gms.location.copresence.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;

public final class BatchImpl
  implements SafeParcelable
{
  public static final Parcelable.Creator<BatchImpl> CREATOR = new zza();
  private final int mVersionCode;
  public final ArrayList<Operation> zzaSq;

  public BatchImpl()
  {
    mVersionCode = 1;
    zzaSq = new ArrayList();
  }

  BatchImpl(int paramInt, ArrayList<Operation> paramArrayList)
  {
    mVersionCode = paramInt;
    zzaSq = paramArrayList;
  }

  public int describeContents()
  {
    return 0;
  }

  int getVersionCode()
  {
    return mVersionCode;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
}