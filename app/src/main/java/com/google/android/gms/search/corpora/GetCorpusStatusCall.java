package com.google.android.gms.search.corpora;

import android.os.Parcel;
import com.google.android.gms.appdatasearch.CorpusStatus;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetCorpusStatusCall
{
  public static class Request
    implements SafeParcelable
  {
    public static final zze CREATOR = new zze();
    public String corpusName;
    final int mVersionCode;
    public String packageName;

    public Request()
    {
      mVersionCode = 1;
    }

    Request(int paramInt, String paramString1, String paramString2)
    {
      mVersionCode = paramInt;
      packageName = paramString1;
      corpusName = paramString2;
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

  public static class Response
    implements Result, SafeParcelable
  {
    public static final zzf CREATOR = new zzf();
    public CorpusStatus corpusStatus;
    final int mVersionCode;
    public Status status;

    public Response()
    {
      mVersionCode = 1;
    }

    Response(int paramInt, Status paramStatus, CorpusStatus paramCorpusStatus)
    {
      mVersionCode = paramInt;
      status = paramStatus;
      corpusStatus = paramCorpusStatus;
    }

    public int describeContents()
    {
      zzf localzzf = CREATOR;
      return 0;
    }

    public Status getStatus()
    {
      return status;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      zzf localzzf = CREATOR;
      zzf.zza(this, paramParcel, paramInt);
    }
  }
}