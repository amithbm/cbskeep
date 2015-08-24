package com.google.android.gms.nearby.sharing;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;

public class AppContentReceivedResult
  implements SafeParcelable
{
  public static final Parcelable.Creator<AppContentReceivedResult> CREATOR = new zza();
  private int statusCode;
  private final int versionCode;
  private Uri zzbbv;

  private AppContentReceivedResult()
  {
    versionCode = 1;
  }

  AppContentReceivedResult(int paramInt1, Uri paramUri, int paramInt2)
  {
    versionCode = paramInt1;
    zzbbv = paramUri;
    statusCode = paramInt2;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this);
    do
    {
      return true;
      if (!(paramObject instanceof AppContentReceivedResult))
        return false;
      paramObject = (AppContentReceivedResult)paramObject;
    }
    while ((zzu.equal(zzbbv, paramObject.zzbbv)) && (zzu.equal(Integer.valueOf(statusCode), Integer.valueOf(paramObject.statusCode))));
    return false;
  }

  public Uri getDestinationUri()
  {
    return zzbbv;
  }

  public int getStatusCode()
  {
    return statusCode;
  }

  int getVersionCode()
  {
    return versionCode;
  }

  public int hashCode()
  {
    return zzu.hashCode(new Object[] { zzbbv, Integer.valueOf(statusCode) });
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
}