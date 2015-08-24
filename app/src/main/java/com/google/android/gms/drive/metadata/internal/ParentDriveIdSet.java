package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;

public class ParentDriveIdSet
  implements SafeParcelable
{
  public static final Parcelable.Creator<ParentDriveIdSet> CREATOR = new zzk();
  final int mVersionCode;
  final List<PartialDriveId> zzawE;

  public ParentDriveIdSet()
  {
    this(1, new ArrayList());
  }

  ParentDriveIdSet(int paramInt, List<PartialDriveId> paramList)
  {
    mVersionCode = paramInt;
    zzawE = paramList;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzk.zza(this, paramParcel, paramInt);
  }
}