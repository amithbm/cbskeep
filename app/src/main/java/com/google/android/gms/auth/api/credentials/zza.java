package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zza
  implements Parcelable.Creator<Credential>
{
  static void zza(Credential paramCredential, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zza(paramParcel, 1001, paramCredential.zzkP(), false);
    zzb.zza(paramParcel, 1, paramCredential.getId(), false);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zza(paramParcel, 2, paramCredential.getName(), false);
    zzb.zza(paramParcel, 3, paramCredential.getProfilePictureUri(), paramInt, false);
    zzb.zza(paramParcel, 1002, paramCredential.zzkQ(), false);
    zzb.zzd(paramParcel, 4, paramCredential.getIdTokens(), false);
    zzb.zza(paramParcel, 5, paramCredential.getPassword(), false);
    zzb.zza(paramParcel, 6, paramCredential.getAccountType(), false);
    zzb.zzJ(paramParcel, i);
  }

  public Credential zzar(Parcel paramParcel)
  {
    String str1 = null;
    int j = com.google.android.gms.common.internal.safeparcel.zza.zzcQ(paramParcel);
    int i = 0;
    String str2 = null;
    ArrayList localArrayList = null;
    Uri localUri = null;
    String str3 = null;
    String str4 = null;
    String str5 = null;
    String str6 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = com.google.android.gms.common.internal.safeparcel.zza.zzcP(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.zza.zzeS(k))
      {
      default:
        com.google.android.gms.common.internal.safeparcel.zza.zzb(paramParcel, k);
        break;
      case 1001:
        str6 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, k);
        break;
      case 1:
        str4 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, k);
        break;
      case 1000:
        i = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, k);
        break;
      case 2:
        str3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, k);
        break;
      case 3:
        localUri = (Uri)com.google.android.gms.common.internal.safeparcel.zza.zza(paramParcel, k, Uri.CREATOR);
        break;
      case 1002:
        str5 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, k);
        break;
      case 4:
        localArrayList = com.google.android.gms.common.internal.safeparcel.zza.zzc(paramParcel, k, IdToken.CREATOR);
        break;
      case 5:
        str2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, k);
        break;
      case 6:
        str1 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new Credential(i, str6, str5, str4, str3, localUri, localArrayList, str2, str1);
  }

  public Credential[] zzbn(int paramInt)
  {
    return new Credential[paramInt];
  }
}