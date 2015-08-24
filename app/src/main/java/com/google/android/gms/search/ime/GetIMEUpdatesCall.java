package com.google.android.gms.search.ime;

import android.os.Parcel;
import com.google.android.gms.appdatasearch.PIMEUpdateResponse;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetIMEUpdatesCall
{
  public static class Request
    implements SafeParcelable
  {
    public static final zzc CREATOR = new zzc();
    public byte[] iterToken;
    final int mVersionCode;
    public int maxNumUpdates;

    public Request()
    {
      mVersionCode = 1;
    }

    Request(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
    {
      mVersionCode = paramInt1;
      maxNumUpdates = paramInt2;
      iterToken = paramArrayOfByte;
    }

    public int describeContents()
    {
      zzc localzzc = CREATOR;
      return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      zzc localzzc = CREATOR;
      zzc.zza(this, paramParcel, paramInt);
    }
  }

  public static class Response
    implements Result, SafeParcelable
  {
    public static final zzd CREATOR = new zzd();
    final int mVersionCode;
    public PIMEUpdateResponse pimeUpdateResponse;
    public Status status;

    public Response()
    {
      mVersionCode = 1;
    }

    Response(int paramInt, Status paramStatus, PIMEUpdateResponse paramPIMEUpdateResponse)
    {
      mVersionCode = paramInt;
      status = paramStatus;
      pimeUpdateResponse = paramPIMEUpdateResponse;
    }

    public int describeContents()
    {
      zzd localzzd = CREATOR;
      return 0;
    }

    public Status getStatus()
    {
      return status;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      zzd localzzd = CREATOR;
      zzd.zza(this, paramParcel, paramInt);
    }
  }
}