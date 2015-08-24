package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GlobalSearchAppCorpusFeatures
  implements SafeParcelable
{
  public static final zzk CREATOR = new zzk();
  final String corpusName;
  final Feature[] features;
  final int mVersionCode;

  GlobalSearchAppCorpusFeatures(int paramInt, String paramString, Feature[] paramArrayOfFeature)
  {
    mVersionCode = paramInt;
    corpusName = paramString;
    features = paramArrayOfFeature;
  }

  public int describeContents()
  {
    zzk localzzk = CREATOR;
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzk localzzk = CREATOR;
    zzk.zza(this, paramParcel, paramInt);
  }
}