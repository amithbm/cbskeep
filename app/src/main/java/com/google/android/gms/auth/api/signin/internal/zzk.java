package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.google.android.gms.auth.api.signin.SignInInfo;
import com.google.android.gms.common.internal.zzv;

public class zzk
{
  private final SharedPreferences zzRI;

  public zzk(Context paramContext)
  {
    zzRI = paramContext.getSharedPreferences("signin", 0);
  }

  public void zza(SignInInfo paramSignInInfo)
  {
    zzRI.edit().putString("storage.signinInfo", (String)zzv.zzz(paramSignInInfo.toJson())).apply();
  }

  public SignInInfo zzlb()
  {
    String str = zzRI.getString("storage.signinInfo", null);
    if (str == null)
      return null;
    return SignInInfo.fromJsonString(str);
  }
}