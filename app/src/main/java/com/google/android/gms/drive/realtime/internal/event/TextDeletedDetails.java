package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class TextDeletedDetails
  implements SafeParcelable
{
  public static final Parcelable.Creator<TextDeletedDetails> CREATOR = new zzg();
  final int mIndex;
  final int mVersionCode;
  final int zzaAF;

  TextDeletedDetails(int paramInt1, int paramInt2, int paramInt3)
  {
    mVersionCode = paramInt1;
    mIndex = paramInt2;
    zzaAF = paramInt3;
  }

  public int describeContents()
  {
    return 0;
  }

  public int getIndex()
  {
    return mIndex;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzg.zza(this, paramParcel, paramInt);
  }

  public int zzul()
  {
    return zzaAF;
  }
}