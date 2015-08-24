package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class NativeApiInfo
  implements SafeParcelable
{
  public static final zzp CREATOR = new zzp();
  public final String downloadManagerFilename;
  final int mVersionCode;
  public final String sharedLibAbsoluteFilename;
  public final String sharedLibExtensionAbsoluteFilename;

  NativeApiInfo(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    mVersionCode = paramInt;
    sharedLibAbsoluteFilename = paramString1;
    sharedLibExtensionAbsoluteFilename = paramString2;
    downloadManagerFilename = paramString3;
  }

  public int describeContents()
  {
    zzp localzzp = CREATOR;
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzp localzzp = CREATOR;
    zzp.zza(this, paramParcel, paramInt);
  }
}