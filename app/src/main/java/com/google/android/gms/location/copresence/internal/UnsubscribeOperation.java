package com.google.android.gms.location.copresence.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;

public class UnsubscribeOperation
  implements SafeParcelable
{
  public static final Parcelable.Creator<UnsubscribeOperation> CREATOR = new zzq();
  private final int mVersionCode;
  public final zzi messageListener;
  public final int type;
  public final PendingIntent zzaSZ;

  UnsubscribeOperation(int paramInt1, int paramInt2, IBinder paramIBinder, PendingIntent paramPendingIntent)
  {
    mVersionCode = paramInt1;
    type = paramInt2;
    if (paramIBinder == null);
    for (messageListener = null; ; messageListener = zzi.zza.zzdX(paramIBinder))
    {
      zzaSZ = paramPendingIntent;
      return;
    }
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
      if (paramObject == null)
        return false;
      if (getClass() != paramObject.getClass())
        return false;
      paramObject = (UnsubscribeOperation)paramObject;
    }
    while ((type == paramObject.type) && (zzu.equal(messageListener, paramObject.messageListener)));
    return false;
  }

  int getVersionCode()
  {
    return mVersionCode;
  }

  public int hashCode()
  {
    return zzu.hashCode(new Object[] { Integer.valueOf(type), messageListener });
  }

  public String toString()
  {
    switch (type)
    {
    default:
      return "UnsubscribeOperation[unknown type=" + type + "]";
    case 1:
      return "UnsubscribeOperation[listener=" + zzyC() + "]";
    case 2:
    }
    return "UnsubscribeOperation[pendingIntent=" + zzaSZ + "]";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzq.zza(this, paramParcel, paramInt);
  }

  IBinder zzyC()
  {
    if (messageListener == null)
      return null;
    return messageListener.asBinder();
  }
}