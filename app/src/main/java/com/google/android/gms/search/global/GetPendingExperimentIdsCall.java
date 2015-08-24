package com.google.android.gms.search.global;

import android.os.Parcel;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetPendingExperimentIdsCall
{
  public static class Request
    implements SafeParcelable
  {
    public static final zzg CREATOR = new zzg();
    final int mVersionCode;

    public Request()
    {
      mVersionCode = 1;
    }

    Request(int paramInt)
    {
      mVersionCode = paramInt;
    }

    public int describeContents()
    {
      zzg localzzg = CREATOR;
      return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      zzg localzzg = CREATOR;
      zzg.zza(this, paramParcel, paramInt);
    }
  }

  public static class Response
    implements Result, SafeParcelable
  {
    public static final zzh CREATOR = new zzh();
    public int[] experimentIds;
    final int mVersionCode;
    public Status status;

    public Response()
    {
      mVersionCode = 1;
    }

    Response(int paramInt, Status paramStatus, int[] paramArrayOfInt)
    {
      mVersionCode = paramInt;
      status = paramStatus;
      experimentIds = paramArrayOfInt;
    }

    public int describeContents()
    {
      zzh localzzh = CREATOR;
      return 0;
    }

    public Status getStatus()
    {
      return status;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      zzh localzzh = CREATOR;
      zzh.zza(this, paramParcel, paramInt);
    }
  }
}