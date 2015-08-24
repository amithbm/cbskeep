package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd
  implements Parcelable.Creator<SignInInfo>
{
  static void zza(SignInInfo paramSignInInfo, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, versionCode);
    zzb.zza(paramParcel, 2, paramSignInInfo.getProviderId(), false);
    zzb.zza(paramParcel, 3, paramSignInInfo.getIdToken(), false);
    zzb.zza(paramParcel, 4, paramSignInInfo.getEmail(), false);
    zzb.zza(paramParcel, 5, paramSignInInfo.getDisplayName(), false);
    zzb.zza(paramParcel, 6, paramSignInInfo.getPhotoUrl(), paramInt, false);
    zzb.zzJ(paramParcel, i);
  }

  public SignInInfo zzaB(Parcel paramParcel)
  {
    Uri localUri = null;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    String str1 = null;
    String str2 = null;
    String str3 = null;
    String str4 = null;
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
        str4 = zza.zzp(paramParcel, k);
        break;
      case 3:
        str3 = zza.zzp(paramParcel, k);
        break;
      case 4:
        str2 = zza.zzp(paramParcel, k);
        break;
      case 5:
        str1 = zza.zzp(paramParcel, k);
        break;
      case 6:
        localUri = (Uri)zza.zza(paramParcel, k, Uri.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new SignInInfo(i, str4, str3, str2, str1, localUri);
  }

  public SignInInfo[] zzbx(int paramInt)
  {
    return new SignInInfo[paramInt];
  }
}