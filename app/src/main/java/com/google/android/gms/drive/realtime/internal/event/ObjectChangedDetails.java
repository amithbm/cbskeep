package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ObjectChangedDetails
  implements SafeParcelable
{
  public static final Parcelable.Creator<ObjectChangedDetails> CREATOR = new zzb();
  final int mVersionCode;
  final int zzaAq;
  final int zzaAr;

  ObjectChangedDetails(int paramInt1, int paramInt2, int paramInt3)
  {
    mVersionCode = paramInt1;
    zzaAq = paramInt2;
    zzaAr = paramInt3;
  }

  public int describeContents()
  {
    return 0;
  }

  public int getValueCount()
  {
    return zzaAr;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }

  public int zztX()
  {
    return zzaAq;
  }
}