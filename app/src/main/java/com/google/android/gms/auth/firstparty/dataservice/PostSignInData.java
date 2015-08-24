package com.google.android.gms.auth.firstparty.dataservice;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class PostSignInData
  implements SafeParcelable
{
  public static final zzae CREATOR = new zzae();
  public final PendingIntent accountInstallationCompletionAction;
  public final Intent postSignInForeignIntent;
  final int version;

  PostSignInData(int paramInt, Intent paramIntent, PendingIntent paramPendingIntent)
  {
    version = paramInt;
    postSignInForeignIntent = paramIntent;
    accountInstallationCompletionAction = paramPendingIntent;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzae.zza(this, paramParcel, paramInt);
  }
}