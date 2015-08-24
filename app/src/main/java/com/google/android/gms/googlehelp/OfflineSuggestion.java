package com.google.android.gms.googlehelp;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class OfflineSuggestion
  implements SafeParcelable
{
  public static final Parcelable.Creator<OfflineSuggestion> CREATOR = new zzd();
  final int mVersionCode;
  final String zzLf;
  final String zzaOF;
  final String zzasJ;
  final String zzvM;

  OfflineSuggestion(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    mVersionCode = paramInt;
    zzLf = paramString1;
    zzasJ = paramString2;
    zzvM = paramString3;
    zzaOF = paramString4;
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