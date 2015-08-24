package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.common.internal.zzu.zza;

public final class Status
  implements Result, SafeParcelable
{
  public static final Parcelable.Creator<Status> CREATOR = new zzk();
  public static final Status zzaii = new Status(0);
  public static final Status zzaij = new Status(14);
  public static final Status zzaik = new Status(8);
  public static final Status zzail = new Status(15);
  public static final Status zzaim = new Status(16);
  private final PendingIntent mPendingIntent;
  private final int mVersionCode;
  private final int zzacY;
  private final String zzain;

  public Status(int paramInt)
  {
    this(paramInt, null);
  }

  Status(int paramInt1, int paramInt2, String paramString, PendingIntent paramPendingIntent)
  {
    mVersionCode = paramInt1;
    zzacY = paramInt2;
    zzain = paramString;
    mPendingIntent = paramPendingIntent;
  }

  public Status(int paramInt, String paramString)
  {
    this(1, paramInt, paramString, null);
  }

  public Status(int paramInt, String paramString, PendingIntent paramPendingIntent)
  {
    this(1, paramInt, paramString, paramPendingIntent);
  }

  private String zzoV()
  {
    if (zzain != null)
      return zzain;
    return CommonStatusCodes.getStatusCodeString(zzacY);
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Status));
    do
    {
      return false;
      paramObject = (Status)paramObject;
    }
    while ((mVersionCode != paramObject.mVersionCode) || (zzacY != paramObject.zzacY) || (!zzu.equal(zzain, paramObject.zzain)) || (!zzu.equal(mPendingIntent, paramObject.mPendingIntent)));
    return true;
  }

  PendingIntent getPendingIntent()
  {
    return mPendingIntent;
  }

  public Status getStatus()
  {
    return this;
  }

  public int getStatusCode()
  {
    return zzacY;
  }

  public String getStatusMessage()
  {
    return zzain;
  }

  int getVersionCode()
  {
    return mVersionCode;
  }

  public int hashCode()
  {
    return zzu.hashCode(new Object[] { Integer.valueOf(mVersionCode), Integer.valueOf(zzacY), zzain, mPendingIntent });
  }

  public boolean isSuccess()
  {
    return zzacY <= 0;
  }

  public String toString()
  {
    return zzu.zzy(this).zzc("statusCode", zzoV()).zzc("resolution", mPendingIntent).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzk.zza(this, paramParcel, paramInt);
  }
}