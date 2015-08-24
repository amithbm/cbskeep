package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class PhraseAffinityResponse
  implements SafeParcelable
{
  public static final zzt CREATOR = new zzt();
  final String mErrorMessage;
  final int mVersionCode;
  final CorpusId[] zzNx;
  final int[] zzNy;

  PhraseAffinityResponse(int paramInt, String paramString, CorpusId[] paramArrayOfCorpusId, int[] paramArrayOfInt)
  {
    mVersionCode = paramInt;
    mErrorMessage = paramString;
    zzNx = paramArrayOfCorpusId;
    zzNy = paramArrayOfInt;
  }

  public int describeContents()
  {
    zzt localzzt = CREATOR;
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzt localzzt = CREATOR;
    zzt.zza(this, paramParcel, paramInt);
  }
}