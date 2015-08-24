package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class PartialDriveId
  implements SafeParcelable
{
  public static final Parcelable.Creator<PartialDriveId> CREATOR = new zzm();
  final int mVersionCode;
  final String zzasw;
  final long zzasx;
  final int zzasy;

  PartialDriveId(int paramInt1, String paramString, long paramLong, int paramInt2)
  {
    mVersionCode = paramInt1;
    zzasw = paramString;
    zzasx = paramLong;
    zzasy = paramInt2;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzm.zza(this, paramParcel, paramInt);
  }
}