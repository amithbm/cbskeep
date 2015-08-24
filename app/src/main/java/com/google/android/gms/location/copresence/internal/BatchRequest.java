package com.google.android.gms.location.copresence.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class BatchRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<BatchRequest> CREATOR = new zzb();
  public final String accountName;
  final int mVersionCode;
  public final String packageName;
  public final IBinder zzaSr;
  public final String zzaSs;
  public final BatchImpl zzaSt;
  public final CopresenceApiOptions zzaSu;

  BatchRequest(int paramInt, IBinder paramIBinder, String paramString1, String paramString2, String paramString3, BatchImpl paramBatchImpl, CopresenceApiOptions paramCopresenceApiOptions)
  {
    mVersionCode = paramInt;
    zzaSr = paramIBinder;
    packageName = paramString1;
    accountName = paramString2;
    zzaSs = paramString3;
    zzaSt = paramBatchImpl;
    zzaSu = paramCopresenceApiOptions;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
}