package com.google.android.gms.location.copresence;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;

public final class SubscribedMessage
  implements SafeParcelable
{
  public static final Parcelable.Creator<SubscribedMessage> CREATOR = new zzl();
  private final int mVersionCode;
  private final Message zzaSn;

  SubscribedMessage(int paramInt, Message paramMessage)
  {
    mVersionCode = paramInt;
    zzaSn = paramMessage;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this == paramObject)
      bool1 = true;
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      }
      while (paramObject == null);
      bool1 = bool2;
    }
    while (getClass() != paramObject.getClass());
    paramObject = (SubscribedMessage)paramObject;
    return zzu.equal(zzaSn, paramObject.zzaSn);
  }

  public Message getMessage()
  {
    return zzaSn;
  }

  int getVersionCode()
  {
    return mVersionCode;
  }

  public int hashCode()
  {
    return zzu.hashCode(new Object[] { zzaSn });
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzl.zza(this, paramParcel, paramInt);
  }
}