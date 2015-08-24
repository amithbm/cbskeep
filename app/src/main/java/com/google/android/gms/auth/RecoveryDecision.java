package com.google.android.gms.auth;

import android.app.PendingIntent;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class RecoveryDecision
  implements SafeParcelable
{
  public static final zze CREATOR = new zze();
  public boolean isRecoveryInfoNeeded;
  public boolean isRecoveryInterstitialAllowed;
  final int mVersionCode;
  public PendingIntent recoveryIntent;
  public PendingIntent recoveryIntentWithoutIntro;
  public boolean showRecoveryInterstitial;

  public RecoveryDecision()
  {
    mVersionCode = 1;
  }

  RecoveryDecision(int paramInt, PendingIntent paramPendingIntent1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, PendingIntent paramPendingIntent2)
  {
    mVersionCode = paramInt;
    recoveryIntent = paramPendingIntent1;
    showRecoveryInterstitial = paramBoolean1;
    isRecoveryInfoNeeded = paramBoolean2;
    isRecoveryInterstitialAllowed = paramBoolean3;
    recoveryIntentWithoutIntro = paramPendingIntent2;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zze.zza(this, paramParcel, paramInt);
  }
}