package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ValuesAddedDetails
  implements SafeParcelable
{
  public static final Parcelable.Creator<ValuesAddedDetails> CREATOR = new zzj();
  final int mIndex;
  final int mVersionCode;
  final String zzaAG;
  final int zzaAH;
  final int zzaAq;
  final int zzaAr;

  ValuesAddedDetails(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, int paramInt5)
  {
    mVersionCode = paramInt1;
    mIndex = paramInt2;
    zzaAq = paramInt3;
    zzaAr = paramInt4;
    zzaAG = paramString;
    zzaAH = paramInt5;
  }

  public int describeContents()
  {
    return 0;
  }

  public int getIndex()
  {
    return mIndex;
  }

  public Integer getMovedFromIndex()
  {
    if (zzaAH == -1)
      return null;
    return Integer.valueOf(zzaAH);
  }

  public int getValueCount()
  {
    return zzaAr;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzj.zza(this, paramParcel, paramInt);
  }

  public int zztX()
  {
    return zzaAq;
  }

  public String zzum()
  {
    return zzaAG;
  }
}