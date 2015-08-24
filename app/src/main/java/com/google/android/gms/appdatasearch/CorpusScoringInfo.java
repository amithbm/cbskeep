package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class CorpusScoringInfo
  implements SafeParcelable
{
  public static final zzb CREATOR = new zzb();
  public final CorpusId corpus;
  final int mVersionCode;
  public final int maxResults;
  public final int weight;

  CorpusScoringInfo(int paramInt1, CorpusId paramCorpusId, int paramInt2, int paramInt3)
  {
    mVersionCode = paramInt1;
    corpus = paramCorpusId;
    weight = paramInt2;
    maxResults = paramInt3;
  }

  public int describeContents()
  {
    zzb localzzb = CREATOR;
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb localzzb = CREATOR;
    zzb.zza(this, paramParcel, paramInt);
  }
}