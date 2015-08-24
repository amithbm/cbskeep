package com.google.android.gms.search.global;

import android.os.Parcel;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class SetExperimentIdsCall
{
  public static class Request
    implements SafeParcelable
  {
    public static final zzi CREATOR = new zzi();
    public boolean emergency;
    final int mVersionCode;
    public byte[] serializedExperimentConfig;

    public Request()
    {
      mVersionCode = 1;
    }

    Request(int paramInt, byte[] paramArrayOfByte, boolean paramBoolean)
    {
      mVersionCode = paramInt;
      serializedExperimentConfig = paramArrayOfByte;
      emergency = paramBoolean;
    }

    public int describeContents()
    {
      zzi localzzi = CREATOR;
      return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      zzi localzzi = CREATOR;
      zzi.zza(this, paramParcel, paramInt);
    }
  }

  public static class Response
    implements Result, SafeParcelable
  {
    public static final zzj CREATOR = new zzj();
    final int mVersionCode;
    public Status status;

    public Response()
    {
      mVersionCode = 1;
    }

    Response(int paramInt, Status paramStatus)
    {
      mVersionCode = paramInt;
      status = paramStatus;
    }

    public int describeContents()
    {
      zzj localzzj = CREATOR;
      return 0;
    }

    public Status getStatus()
    {
      return status;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      zzj localzzj = CREATOR;
      zzj.zza(this, paramParcel, paramInt);
    }
  }
}