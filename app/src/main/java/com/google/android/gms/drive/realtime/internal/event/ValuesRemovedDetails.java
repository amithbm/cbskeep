package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ValuesRemovedDetails
  implements SafeParcelable
{
  public static final Parcelable.Creator<ValuesRemovedDetails> CREATOR = new zzk();
  final int mIndex;
  final int mVersionCode;
  final String zzaAI;
  final int zzaAJ;
  final int zzaAq;
  final int zzaAr;

  ValuesRemovedDetails(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, int paramInt5)
  {
    mVersionCode = paramInt1;
    mIndex = paramInt2;
    zzaAq = paramInt3;
    zzaAr = paramInt4;
    zzaAI = paramString;
    zzaAJ = paramInt5;
  }

  public int describeContents()
  {
    return 0;
  }

  public int getIndex()
  {
    return mIndex;
  }

  public Integer getMovedToIndex()
  {
    if (zzaAJ == -1)
      return null;
    return Integer.valueOf(zzaAJ);
  }

  public int getValueCount()
  {
    return zzaAr;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzk.zza(this, paramParcel, paramInt);
  }

  public int zztX()
  {
    return zzaAq;
  }

  public String zzun()
  {
    return zzaAI;
  }
}