package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import java.util.List;

public class LoadRealtimeRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<LoadRealtimeRequest> CREATOR = new zzap();
  final int mVersionCode;
  final DriveId zzasr;
  final List<String> zzauO;
  final boolean zzavR;
  final boolean zzavS;
  final DataHolder zzavT;

  LoadRealtimeRequest(int paramInt, DriveId paramDriveId, boolean paramBoolean1, List<String> paramList, boolean paramBoolean2, DataHolder paramDataHolder)
  {
    mVersionCode = paramInt;
    zzasr = paramDriveId;
    zzavR = paramBoolean1;
    zzauO = paramList;
    zzavS = paramBoolean2;
    zzavT = paramDataHolder;
  }

  public LoadRealtimeRequest(DriveId paramDriveId, boolean paramBoolean1, List<String> paramList, boolean paramBoolean2, DataHolder paramDataHolder)
  {
    this(2, paramDriveId, paramBoolean1, paramList, paramBoolean2, paramDataHolder);
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzap.zza(this, paramParcel, paramInt);
  }
}