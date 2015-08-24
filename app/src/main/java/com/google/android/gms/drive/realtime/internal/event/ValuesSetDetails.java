package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ValuesSetDetails
  implements SafeParcelable
{
  public static final Parcelable.Creator<ValuesSetDetails> CREATOR = new zzl();
  final int mIndex;
  final int mVersionCode;
  final int zzaAq;
  final int zzaAr;

  ValuesSetDetails(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    mVersionCode = paramInt1;
    mIndex = paramInt2;
    zzaAq = paramInt3;
    zzaAr = paramInt4;
  }

  public int describeContents()
  {
    return 0;
  }

  public int getIndex()
  {
    return mIndex;
  }

  public int getValueCount()
  {
    return zzaAr;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzl.zza(this, paramParcel, paramInt);
  }

  public int zztV()
  {
    return zzaAq;
  }

  public int zztW()
  {
    return zzaAq + zzaAr;
  }
}