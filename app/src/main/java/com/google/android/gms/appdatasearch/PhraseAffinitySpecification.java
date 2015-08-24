package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class PhraseAffinitySpecification
  implements SafeParcelable
{
  public static final zzu CREATOR = new zzu();
  final int mVersionCode;
  final PhraseAffinityCorpusSpec[] zzNz;

  PhraseAffinitySpecification(int paramInt, PhraseAffinityCorpusSpec[] paramArrayOfPhraseAffinityCorpusSpec)
  {
    mVersionCode = paramInt;
    zzNz = paramArrayOfPhraseAffinityCorpusSpec;
  }

  public int describeContents()
  {
    zzu localzzu = CREATOR;
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzu localzzu = CREATOR;
    zzu.zza(this, paramParcel, paramInt);
  }
}