package com.google.android.gms.location.copresence.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.copresence.AccessPolicy;
import com.google.android.gms.location.copresence.Message;

public final class PublishOperation
  implements SafeParcelable
{
  public static final Parcelable.Creator<PublishOperation> CREATOR = new zzl();
  private final int mVersionCode;
  private final String zzLf;
  private final StrategyImpl zzaSR;
  private final AccessPolicy zzaSS;
  private final Message zzaSn;

  PublishOperation(int paramInt, String paramString, StrategyImpl paramStrategyImpl, Message paramMessage, AccessPolicy paramAccessPolicy)
  {
    mVersionCode = paramInt;
    zzLf = paramString;
    zzaSR = paramStrategyImpl;
    zzaSn = paramMessage;
    zzaSS = paramAccessPolicy;
  }

  public int describeContents()
  {
    return 0;
  }

  public String getId()
  {
    return zzLf;
  }

  public Message getMessage()
  {
    return zzaSn;
  }

  int getVersionCode()
  {
    return mVersionCode;
  }

  public String toString()
  {
    return "PublishOperation: " + zzaSn.toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzl.zza(this, paramParcel, paramInt);
  }

  StrategyImpl zzyF()
  {
    return zzaSR;
  }

  public AccessPolicy zzyG()
  {
    return zzaSS;
  }
}