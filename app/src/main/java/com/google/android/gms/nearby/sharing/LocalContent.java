package com.google.android.gms.nearby.sharing;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;

public class LocalContent
  implements SafeParcelable
{
  public static final Parcelable.Creator<LocalContent> CREATOR = new zzb();
  private int type;
  private final int versionCode;
  private String zzbbw;

  private LocalContent()
  {
    versionCode = 1;
  }

  LocalContent(int paramInt1, int paramInt2, String paramString)
  {
    versionCode = paramInt1;
    type = paramInt2;
    zzbbw = paramString;
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
      if (!(paramObject instanceof LocalContent))
        return false;
      paramObject = (LocalContent)paramObject;
    }
    while ((zzu.equal(Integer.valueOf(type), Integer.valueOf(paramObject.type))) && (zzu.equal(zzbbw, paramObject.zzbbw)));
    return false;
  }

  public String getContentUri()
  {
    return zzbbw;
  }

  public int getType()
  {
    return type;
  }

  int getVersionCode()
  {
    return versionCode;
  }

  public int hashCode()
  {
    return zzu.hashCode(new Object[] { Integer.valueOf(type), zzbbw });
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("LocalContent[contentUri=").append(zzbbw).append(", type=");
    if (type == 1);
    for (String str = "PUBLIC_CONTENT"; ; str = "APP_CONTENT")
      return str + "]";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
}