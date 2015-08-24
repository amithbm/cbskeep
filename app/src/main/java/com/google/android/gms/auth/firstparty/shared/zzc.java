package com.google.android.gms.auth.firstparty.shared;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc
  implements Parcelable.Creator<CaptchaChallenge>
{
  static void zza(CaptchaChallenge paramCaptchaChallenge, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, version);
    zzb.zza(paramParcel, 2, zzRY, false);
    zzb.zza(paramParcel, 3, zzSt, false);
    zzb.zza(paramParcel, 4, zzTY, paramInt, false);
    zzb.zzJ(paramParcel, i);
  }

  public CaptchaChallenge zzbC(Parcel paramParcel)
  {
    Bitmap localBitmap = null;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    String str2 = null;
    String str1 = null;
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
        str1 = zza.zzp(paramParcel, k);
        break;
      case 3:
        str2 = zza.zzp(paramParcel, k);
        break;
      case 4:
        localBitmap = (Bitmap)zza.zza(paramParcel, k, Bitmap.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new CaptchaChallenge(i, str1, str2, localBitmap);
  }

  public CaptchaChallenge[] zzcy(int paramInt)
  {
    return new CaptchaChallenge[paramInt];
  }
}