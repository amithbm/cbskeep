package com.google.android.gms.auth;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze
  implements Parcelable.Creator<RecoveryDecision>
{
  static void zza(RecoveryDecision paramRecoveryDecision, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, recoveryIntent, paramInt, false);
    zzb.zza(paramParcel, 3, showRecoveryInterstitial);
    zzb.zza(paramParcel, 4, isRecoveryInfoNeeded);
    zzb.zza(paramParcel, 5, isRecoveryInterstitialAllowed);
    zzb.zza(paramParcel, 6, recoveryIntentWithoutIntro, paramInt, false);
    zzb.zzJ(paramParcel, i);
  }

  public RecoveryDecision zzan(Parcel paramParcel)
  {
    PendingIntent localPendingIntent1 = null;
    boolean bool1 = false;
    int j = zza.zzcQ(paramParcel);
    boolean bool2 = false;
    boolean bool3 = false;
    PendingIntent localPendingIntent2 = null;
    int i = 0;
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
        localPendingIntent2 = (PendingIntent)zza.zza(paramParcel, k, PendingIntent.CREATOR);
        break;
      case 3:
        bool3 = zza.zzc(paramParcel, k);
        break;
      case 4:
        bool2 = zza.zzc(paramParcel, k);
        break;
      case 5:
        bool1 = zza.zzc(paramParcel, k);
        break;
      case 6:
        localPendingIntent1 = (PendingIntent)zza.zza(paramParcel, k, PendingIntent.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new RecoveryDecision(i, localPendingIntent2, bool3, bool2, bool1, localPendingIntent1);
  }

  public RecoveryDecision[] zzbj(int paramInt)
  {
    return new RecoveryDecision[paramInt];
  }
}