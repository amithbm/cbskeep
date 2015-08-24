package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class VerifyPinResponse
  implements SafeParcelable
{
  public static final zzam CREATOR = new zzam();
  public final String rapt;
  public final int status;
  final int version;

  VerifyPinResponse(int paramInt1, int paramInt2, String paramString)
  {
    version = paramInt1;
    status = paramInt2;
    rapt = paramString;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzam.zza(this, paramParcel, paramInt);
  }
}