package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzv;
import com.google.android.gms.nearby.messages.Message;

public class MessageWrapper
  implements SafeParcelable
{
  public static final zze CREATOR = new zze();
  final int versionCode;
  public final Message zzbbf;

  MessageWrapper(int paramInt, Message paramMessage)
  {
    versionCode = paramInt;
    zzbbf = ((Message)zzv.zzz(paramMessage));
  }

  public int describeContents()
  {
    zze localzze = CREATOR;
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zze localzze = CREATOR;
    zze.zza(this, paramParcel, paramInt);
  }
}