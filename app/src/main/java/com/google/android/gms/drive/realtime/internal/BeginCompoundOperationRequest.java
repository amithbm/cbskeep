package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class BeginCompoundOperationRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<BeginCompoundOperationRequest> CREATOR = new zza();
  final String mName;
  final int mVersionCode;
  final boolean zzazb;
  final boolean zzazc;

  BeginCompoundOperationRequest(int paramInt, boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    mVersionCode = paramInt;
    zzazb = paramBoolean1;
    mName = paramString;
    zzazc = paramBoolean2;
  }

  public BeginCompoundOperationRequest(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    this(2, paramBoolean1, paramString, paramBoolean2);
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
}