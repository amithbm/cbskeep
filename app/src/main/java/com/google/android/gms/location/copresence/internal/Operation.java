package com.google.android.gms.location.copresence.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class Operation
  implements SafeParcelable
{
  public static final Parcelable.Creator<Operation> CREATOR = new zzk();
  private final int mVersionCode;
  public final int zzaSM;
  public final PublishOperation zzaSN;
  public final UnpublishOperation zzaSO;
  public final SubscribeOperation zzaSP;
  public final UnsubscribeOperation zzaSQ;

  Operation(int paramInt1, int paramInt2, PublishOperation paramPublishOperation, UnpublishOperation paramUnpublishOperation, SubscribeOperation paramSubscribeOperation, UnsubscribeOperation paramUnsubscribeOperation)
  {
    mVersionCode = paramInt1;
    zzaSM = paramInt2;
    zzaSN = paramPublishOperation;
    zzaSO = paramUnpublishOperation;
    zzaSP = paramSubscribeOperation;
    zzaSQ = paramUnsubscribeOperation;
  }

  public int describeContents()
  {
    return 0;
  }

  int getVersionCode()
  {
    return mVersionCode;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzk.zza(this, paramParcel, paramInt);
  }
}