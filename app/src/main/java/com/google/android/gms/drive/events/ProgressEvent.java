package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.drive.DriveId;

public final class ProgressEvent
  implements DriveEvent
{
  public static final Parcelable.Creator<ProgressEvent> CREATOR = new zzg();
  final int mVersionCode;
  final int zzOu;
  final DriveId zzasr;
  final long zzats;
  final long zzatt;
  final int zzxv;

  ProgressEvent(int paramInt1, DriveId paramDriveId, int paramInt2, long paramLong1, long paramLong2, int paramInt3)
  {
    mVersionCode = paramInt1;
    zzasr = paramDriveId;
    zzxv = paramInt2;
    zzats = paramLong1;
    zzatt = paramLong2;
    zzOu = paramInt3;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramObject == null) || (paramObject.getClass() != getClass()))
      bool1 = false;
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      }
      while (paramObject == this);
      paramObject = (ProgressEvent)paramObject;
      if ((!zzu.equal(zzasr, paramObject.zzasr)) || (zzxv != paramObject.zzxv) || (zzats != paramObject.zzats))
        break;
      bool1 = bool2;
    }
    while (zzatt == paramObject.zzatt);
    return false;
  }

  public int hashCode()
  {
    return zzu.hashCode(new Object[] { zzasr, Integer.valueOf(zzxv), Long.valueOf(zzats), Long.valueOf(zzatt) });
  }

  public String toString()
  {
    return String.format("ProgressEvent[DriveId: %s, status: %d, bytes transferred: %d, total bytes: %d]", new Object[] { zzasr, Integer.valueOf(zzxv), Long.valueOf(zzats), Long.valueOf(zzatt) });
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzg.zza(this, paramParcel, paramInt);
  }
}