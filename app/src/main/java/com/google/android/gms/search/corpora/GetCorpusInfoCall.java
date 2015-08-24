package com.google.android.gms.search.corpora;

import android.os.Parcel;
import com.google.android.gms.appdatasearch.RegisterCorpusInfo;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetCorpusInfoCall
{
  public static class Request
    implements SafeParcelable
  {
    public static final zzc CREATOR = new zzc();
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
    public RegisterCorpusInfo info;
    final int mVersionCode;
    public Status status;

    public Response()
    {
      mVersionCode = 1;
    }

    Response(int paramInt, Status paramStatus, RegisterCorpusInfo paramRegisterCorpusInfo)
    {
      mVersionCode = paramInt;
      status = paramStatus;
      info = paramRegisterCorpusInfo;
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