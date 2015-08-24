package com.google.android.gms.feedback;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class LogOptions
  implements SafeParcelable
{
  public static final Parcelable.Creator<LogOptions> CREATOR = new zzd();
  public boolean mIncludeRadioLogs;
  public String mLogFilter;
  public final int mVersionCode;

  LogOptions(int paramInt, String paramString, boolean paramBoolean)
  {
    mVersionCode = paramInt;
    mLogFilter = paramString;
    mIncludeRadioLogs = paramBoolean;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzd.zza(this, paramParcel, paramInt);
  }
}