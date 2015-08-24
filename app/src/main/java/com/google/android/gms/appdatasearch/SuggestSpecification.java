package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class SuggestSpecification
  implements SafeParcelable
{
  public static final zzae CREATOR = new zzae();
  final int mVersionCode;

  public SuggestSpecification()
  {
    this(2);
  }

  SuggestSpecification(int paramInt)
  {
    mVersionCode = paramInt;
  }

  public int describeContents()
  {
    zzae localzzae = CREATOR;
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzae localzzae = CREATOR;
    zzae.zza(this, paramParcel, paramInt);
  }
}