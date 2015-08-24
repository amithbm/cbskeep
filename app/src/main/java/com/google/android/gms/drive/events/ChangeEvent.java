package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import java.util.Locale;

public final class ChangeEvent
  implements SafeParcelable, ResourceEvent
{
  public static final Parcelable.Creator<ChangeEvent> CREATOR = new zza();
  final int mVersionCode;
  final DriveId zzasr;
  final int zzata;

  ChangeEvent(int paramInt1, DriveId paramDriveId, int paramInt2)
  {
    mVersionCode = paramInt1;
    zzasr = paramDriveId;
    zzata = paramInt2;
  }

  public int describeContents()
  {
    return 0;
  }

  public String toString()
  {
    return String.format(Locale.US, "ChangeEvent [id=%s,changeFlags=%x]", new Object[] { zzasr, Integer.valueOf(zzata) });
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
}