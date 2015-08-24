package com.google.android.gms.auth.firstparty.dataservice;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzae
  implements Parcelable.Creator<PostSignInData>
{
  static void zza(PostSignInData paramPostSignInData, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, version);
    zzb.zza(paramParcel, 2, postSignInForeignIntent, paramInt, false);
    zzb.zza(paramParcel, 3, accountInstallationCompletionAction, paramInt, false);
    zzb.zzJ(paramParcel, i);
  }

  public PostSignInData zzbh(Parcel paramParcel)
  {
    PendingIntent localPendingIntent = null;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    Intent localIntent = null;
    if (paramParcel.dataPosition() < j)
    {
      int k = zza.zzcP(paramParcel);
      switch (zza.zzeS(k))
      {
      default:
        zza.zzb(paramParcel, k);
      case 1:
      case 2:
      case 3:
      }
      while (true)
      {
        break;
        i = zza.zzg(paramParcel, k);
        continue;
        localIntent = (Intent)zza.zza(paramParcel, k, Intent.CREATOR);
        continue;
        localPendingIntent = (PendingIntent)zza.zza(paramParcel, k, PendingIntent.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new PostSignInData(i, localIntent, localPendingIntent);
  }

  public PostSignInData[] zzcd(int paramInt)
  {
    return new PostSignInData[paramInt];
  }
}