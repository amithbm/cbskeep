package com.google.android.gms.appdatasearch;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class DocumentResults
  implements SafeParcelable
{
  public static final zzf CREATOR = new zzf();
  final String mErrorMessage;
  final int mVersionCode;
  final Bundle zzMI;
  final Bundle zzMJ;
  final Bundle zzMK;

  DocumentResults(int paramInt, String paramString, Bundle paramBundle1, Bundle paramBundle2, Bundle paramBundle3)
  {
    mVersionCode = paramInt;
    mErrorMessage = paramString;
    zzMI = paramBundle1;
    zzMJ = paramBundle2;
    zzMK = paramBundle3;
  }

  public int describeContents()
  {
    zzf localzzf = CREATOR;
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzf localzzf = CREATOR;
    zzf.zza(this, paramParcel, paramInt);
  }
}