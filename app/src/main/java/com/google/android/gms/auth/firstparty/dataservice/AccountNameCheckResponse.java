package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import com.google.android.gms.auth.firstparty.shared.CaptchaChallenge;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class AccountNameCheckResponse
  implements SafeParcelable
{
  public static final zzb CREATOR = new zzb();
  final int version;
  String zzRY;
  List<String> zzRZ;
  String zzSa;
  CaptchaChallenge zzSb;

  AccountNameCheckResponse(int paramInt, String paramString1, List<String> paramList, String paramString2, CaptchaChallenge paramCaptchaChallenge)
  {
    version = paramInt;
    zzRY = paramString1;
    zzRZ = paramList;
    zzSa = paramString2;
    zzSb = paramCaptchaChallenge;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
}