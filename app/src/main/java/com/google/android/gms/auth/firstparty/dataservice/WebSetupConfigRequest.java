package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzv;

public class WebSetupConfigRequest
  implements SafeParcelable
{
  public static final zzao CREATOR = new zzao();
  public final AppDescription callingAppDescription;
  final int version;

  WebSetupConfigRequest(int paramInt, AppDescription paramAppDescription)
  {
    version = paramInt;
    callingAppDescription = ((AppDescription)zzv.zzz(paramAppDescription));
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzao.zza(this, paramParcel, paramInt);
  }
}