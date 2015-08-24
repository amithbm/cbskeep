package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.EmailSignInConfig;
import com.google.android.gms.auth.api.signin.FacebookSignInConfig;
import com.google.android.gms.auth.api.signin.GoogleSignInConfig;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;

public class zzb
  implements Parcelable.Creator<Configuration>
{
  static void zza(Configuration paramConfiguration, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.zzb.zzcR(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1, versionCode);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 2, paramConfiguration.zzkS(), false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 3, paramConfiguration.zzkT(), false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 4, paramConfiguration.zzkU(), paramInt, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 5, paramConfiguration.zzkV(), paramInt, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 6, paramConfiguration.zzkW(), paramInt, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzJ(paramParcel, i);
  }

  public Configuration zzaC(Parcel paramParcel)
  {
    FacebookSignInConfig localFacebookSignInConfig = null;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    GoogleSignInConfig localGoogleSignInConfig = null;
    EmailSignInConfig localEmailSignInConfig = null;
    String str1 = null;
    String str2 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzcP(paramParcel);
      switch (zza.zzeS(k))
      {
      default:
        zza.zzb(paramParcel, k);
        break;
      case 1:
        i = zza.zzg(paramParcel, k);
        break;
      case 2:
        str2 = zza.zzp(paramParcel, k);
        break;
      case 3:
        str1 = zza.zzp(paramParcel, k);
        break;
      case 4:
        localEmailSignInConfig = (EmailSignInConfig)zza.zza(paramParcel, k, EmailSignInConfig.CREATOR);
        break;
      case 5:
        localGoogleSignInConfig = (GoogleSignInConfig)zza.zza(paramParcel, k, GoogleSignInConfig.CREATOR);
        break;
      case 6:
        localFacebookSignInConfig = (FacebookSignInConfig)zza.zza(paramParcel, k, FacebookSignInConfig.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new Configuration(i, str2, str1, localEmailSignInConfig, localGoogleSignInConfig, localFacebookSignInConfig);
  }

  public Configuration[] zzby(int paramInt)
  {
    return new Configuration[paramInt];
  }
}