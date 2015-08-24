package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class PlusProfileCreationResponse
  implements SafeParcelable
{
  public static final zzi CREATOR = new zzi();
  final int version;
  String zzUn;

  PlusProfileCreationResponse(int paramInt, String paramString)
  {
    version = paramInt;
    zzUn = paramString;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzi.zza(this, paramParcel, paramInt);
  }
}