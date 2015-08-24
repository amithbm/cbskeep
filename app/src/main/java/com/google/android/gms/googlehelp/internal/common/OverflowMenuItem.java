package com.google.android.gms.googlehelp.internal.common;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class OverflowMenuItem
  implements SafeParcelable
{
  public static final Parcelable.Creator<OverflowMenuItem> CREATOR = new zzh();
  final int mId;
  final Intent mIntent;
  final int mVersionCode;
  final String zzasJ;

  OverflowMenuItem(int paramInt1, int paramInt2, String paramString, Intent paramIntent)
  {
    mVersionCode = paramInt1;
    mId = paramInt2;
    zzasJ = paramString;
    mIntent = paramIntent;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzh.zza(this, paramParcel, paramInt);
  }
}