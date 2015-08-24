package com.google.android.gms.search.corpora;

import android.os.Parcel;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class RequestIndexingCall
{
  public static class Request
    implements SafeParcelable
  {
    public static final zzg CREATOR = new zzg();
    public String corpusName;
    final int mVersionCode;
    public String packageName;
    public long zzbqf;

    public Request()
    {
      mVersionCode = 1;
    }

    Request(int paramInt, String paramString1, String paramString2, long paramLong)
    {
      mVersionCode = paramInt;
      packageName = paramString1;
      corpusName = paramString2;
      zzbqf = paramLong;
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
    final int mVersionCode;
    public boolean scheduled;
    public Status status;

    public Response()
    {
      mVersionCode = 1;
    }

    Response(int paramInt, Status paramStatus, boolean paramBoolean)
    {
      mVersionCode = paramInt;
      status = paramStatus;
      scheduled = paramBoolean;
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