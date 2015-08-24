package com.google.android.gms.appdatasearch;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class PhraseAffinityCorpusSpec
  implements SafeParcelable
{
  public static final zzs CREATOR = new zzs();
  public final CorpusId corpus;
  final int mVersionCode;
  final Bundle zzNv;

  PhraseAffinityCorpusSpec(int paramInt, CorpusId paramCorpusId, Bundle paramBundle)
  {
    mVersionCode = paramInt;
    corpus = paramCorpusId;
    zzNv = paramBundle;
  }

  public int describeContents()
  {
    zzs localzzs = CREATOR;
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzs localzzs = CREATOR;
    zzs.zza(this, paramParcel, paramInt);
  }
}