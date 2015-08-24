package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzv;

public class EmailSignInConfig
  implements SafeParcelable
{
  public static final Parcelable.Creator<EmailSignInConfig> CREATOR = new zza();
  final int versionCode;
  private final Uri zzRh;
  private String zzRi;
  private Uri zzRj;

  EmailSignInConfig(int paramInt, Uri paramUri1, String paramString, Uri paramUri2)
  {
    zzv.zzb(paramUri1, "Server widget url cannot be null in order to use email/password sign in.");
    zzv.zzd(paramUri1.toString(), "Server widget url cannot be null in order to use email/password sign in.");
    versionCode = paramInt;
    zzRh = paramUri1;
    zzRi = paramString;
    zzRj = paramUri2;
  }

  public int describeContents()
  {
    return 0;
  }

  public String getModeQueryName()
  {
    return zzRi;
  }

  public Uri getServerWidgetUrl()
  {
    return zzRh;
  }

  public Uri getTermsOfServiceUrl()
  {
    return zzRj;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
}