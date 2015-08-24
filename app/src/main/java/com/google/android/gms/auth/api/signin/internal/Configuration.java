package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.EmailSignInConfig;
import com.google.android.gms.auth.api.signin.FacebookSignInConfig;
import com.google.android.gms.auth.api.signin.GoogleSignInConfig;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class Configuration
  implements SafeParcelable
{
  public static final Parcelable.Creator<Configuration> CREATOR = new zzb();
  final int versionCode;
  private final String zzRq;
  private String zzRr;
  private EmailSignInConfig zzRs;
  private GoogleSignInConfig zzRt;
  private FacebookSignInConfig zzRu;

  Configuration(int paramInt, String paramString1, String paramString2, EmailSignInConfig paramEmailSignInConfig, GoogleSignInConfig paramGoogleSignInConfig, FacebookSignInConfig paramFacebookSignInConfig)
  {
    versionCode = paramInt;
    zzRq = paramString1;
    zzRr = paramString2;
    zzRs = paramEmailSignInConfig;
    zzRt = paramGoogleSignInConfig;
    zzRu = paramFacebookSignInConfig;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }

  public String zzkS()
  {
    return zzRq;
  }

  public String zzkT()
  {
    return zzRr;
  }

  public EmailSignInConfig zzkU()
  {
    return zzRs;
  }

  public GoogleSignInConfig zzkV()
  {
    return zzRt;
  }

  public FacebookSignInConfig zzkW()
  {
    return zzRu;
  }
}