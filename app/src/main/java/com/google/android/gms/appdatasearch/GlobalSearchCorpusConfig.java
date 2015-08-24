package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GlobalSearchCorpusConfig
  implements SafeParcelable
{
  public static final zzn CREATOR = new zzn();
  public final Feature[] features;
  public final int[] globalSearchSectionMappings;
  final int mVersionCode;

  GlobalSearchCorpusConfig(int paramInt, int[] paramArrayOfInt, Feature[] paramArrayOfFeature)
  {
    mVersionCode = paramInt;
    globalSearchSectionMappings = paramArrayOfInt;
    features = paramArrayOfFeature;
  }

  public int describeContents()
  {
    zzn localzzn = CREATOR;
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzn localzzn = CREATOR;
    zzn.zza(this, paramParcel, paramInt);
  }
}