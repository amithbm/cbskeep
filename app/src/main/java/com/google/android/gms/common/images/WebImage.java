package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;

public final class WebImage
  implements SafeParcelable
{
  public static final Parcelable.Creator<WebImage> CREATOR = new zzb();
  private final int mVersionCode;
  private final Uri zzajZ;
  private final int zzof;
  private final int zzog;

  WebImage(int paramInt1, Uri paramUri, int paramInt2, int paramInt3)
  {
    mVersionCode = paramInt1;
    zzajZ = paramUri;
    zzof = paramInt2;
    zzog = paramInt3;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    do
    {
      return true;
      if ((paramObject == null) || (!(paramObject instanceof WebImage)))
        return false;
      paramObject = (WebImage)paramObject;
    }
    while ((zzu.equal(zzajZ, paramObject.zzajZ)) && (zzof == paramObject.zzof) && (zzog == paramObject.zzog));
    return false;
  }

  public int getHeight()
  {
    return zzog;
  }

  public Uri getUrl()
  {
    return zzajZ;
  }

  int getVersionCode()
  {
    return mVersionCode;
  }

  public int getWidth()
  {
    return zzof;
  }

  public int hashCode()
  {
    return zzu.hashCode(new Object[] { zzajZ, Integer.valueOf(zzof), Integer.valueOf(zzog) });
  }

  public String toString()
  {
    return String.format("Image %dx%d %s", new Object[] { Integer.valueOf(zzof), Integer.valueOf(zzog), zzajZ.toString() });
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
}