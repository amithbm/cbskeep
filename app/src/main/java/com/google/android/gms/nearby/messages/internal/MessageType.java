package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;

public class MessageType
  implements SafeParcelable
{
  public static final Parcelable.Creator<MessageType> CREATOR = new zzd();
  public final String type;
  final int versionCode;
  public final String zzamK;

  MessageType(int paramInt, String paramString1, String paramString2)
  {
    versionCode = paramInt;
    zzamK = paramString1;
    type = paramString2;
  }

  public MessageType(String paramString1, String paramString2)
  {
    this(1, paramString1, paramString2);
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
      if (!(paramObject instanceof MessageType))
        return false;
      paramObject = (MessageType)paramObject;
    }
    while ((zzu.equal(zzamK, paramObject.zzamK)) && (zzu.equal(type, paramObject.type)));
    return false;
  }

  public int hashCode()
  {
    return zzu.hashCode(new Object[] { zzamK, type });
  }

  public String toString()
  {
    return "namespace=" + zzamK + ", type=" + type;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzd.zza(this, paramParcel, paramInt);
  }
}