package com.google.android.gms.location.copresence.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class CopresenceApiOptions
  implements SafeParcelable
{
  public static final Parcelable.Creator<CopresenceApiOptions> CREATOR = new zzc();
  public static final CopresenceApiOptions zzaSv = new CopresenceApiOptions(true, null);
  final int mVersionCode;
  public final String zeroPartyPackageName;
  public final boolean zzaSw;

  CopresenceApiOptions(int paramInt, boolean paramBoolean, String paramString)
  {
    mVersionCode = paramInt;
    zzaSw = paramBoolean;
    zeroPartyPackageName = paramString;
  }

  public CopresenceApiOptions(boolean paramBoolean, String paramString)
  {
    this(1, paramBoolean, paramString);
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
}