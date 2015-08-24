package com.google.android.gms.search.nativeapi;

import android.os.Parcel;
import com.google.android.gms.appdatasearch.NativeApiInfo;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetNativeApiInfoCall
{
  public static class Request
    implements SafeParcelable
  {
    public static final zzb CREATOR = new zzb();
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
      zzb localzzb = CREATOR;
      return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      zzb localzzb = CREATOR;
      zzb.zza(this, paramParcel, paramInt);
    }
  }

  public static class Response
    implements Result, SafeParcelable
  {
    public static final zza CREATOR = new zza();
    final int mVersionCode;
    public NativeApiInfo nativeApiInfo;
    public Status status;

    public Response()
    {
      mVersionCode = 1;
    }

    Response(int paramInt, Status paramStatus, NativeApiInfo paramNativeApiInfo)
    {
      mVersionCode = paramInt;
      status = paramStatus;
      nativeApiInfo = paramNativeApiInfo;
    }

    public int describeContents()
    {
      zza localzza = CREATOR;
      return 0;
    }

    public Status getStatus()
    {
      return status;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      zza localzza = CREATOR;
      zza.zza(this, paramParcel, paramInt);
    }
  }
}