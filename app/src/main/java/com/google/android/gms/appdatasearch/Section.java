package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class Section
  implements SafeParcelable
{
  public static final zzac CREATOR = new zzac();
  final int mVersionCode;
  public final String name;
  public final int snippetLength;
  public final boolean snippeted;

  Section(int paramInt1, String paramString, boolean paramBoolean, int paramInt2)
  {
    mVersionCode = paramInt1;
    name = paramString;
    snippeted = paramBoolean;
    snippetLength = paramInt2;
  }

  public int describeContents()
  {
    zzac localzzac = CREATOR;
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzac localzzac = CREATOR;
    zzac.zza(this, paramParcel, paramInt);
  }
}