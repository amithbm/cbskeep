package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.common.internal.zzu.zza;

public class PlaceReport
  implements SafeParcelable
{
  public static final Parcelable.Creator<PlaceReport> CREATOR = new zzi();
  private final String mTag;
  final int mVersionCode;
  private final String zzaUw;
  private final String zzaUx;

  PlaceReport(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    mVersionCode = paramInt;
    zzaUw = paramString1;
    mTag = paramString2;
    zzaUx = paramString3;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof PlaceReport));
    do
    {
      return false;
      paramObject = (PlaceReport)paramObject;
    }
    while ((!zzu.equal(zzaUw, paramObject.zzaUw)) || (!zzu.equal(mTag, paramObject.mTag)) || (!zzu.equal(zzaUx, paramObject.zzaUx)));
    return true;
  }

  public String getPlaceId()
  {
    return zzaUw;
  }

  public String getSource()
  {
    return zzaUx;
  }

  public String getTag()
  {
    return mTag;
  }

  public int hashCode()
  {
    return zzu.hashCode(new Object[] { zzaUw, mTag, zzaUx });
  }

  public String toString()
  {
    zzu.zza localzza = zzu.zzy(this);
    localzza.zzc("placeId", zzaUw);
    localzza.zzc("tag", mTag);
    if (!"unknown".equals(zzaUx))
      localzza.zzc("source", zzaUx);
    return localzza.toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzi.zza(this, paramParcel, paramInt);
  }
}