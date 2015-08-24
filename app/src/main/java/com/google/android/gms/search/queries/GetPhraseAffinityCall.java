package com.google.android.gms.search.queries;

import android.os.Parcel;
import com.google.android.gms.appdatasearch.PhraseAffinityCorpusSpec;
import com.google.android.gms.appdatasearch.PhraseAffinityResponse;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetPhraseAffinityCall
{
  public static class Request
    implements SafeParcelable
  {
    public static final zzc CREATOR = new zzc();
    final int mVersionCode;
    public String[] zzbqw;
    public PhraseAffinityCorpusSpec[] zzbqx;

    public Request()
    {
      mVersionCode = 1;
    }

    Request(int paramInt, String[] paramArrayOfString, PhraseAffinityCorpusSpec[] paramArrayOfPhraseAffinityCorpusSpec)
    {
      mVersionCode = paramInt;
      zzbqw = paramArrayOfString;
      zzbqx = paramArrayOfPhraseAffinityCorpusSpec;
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
    public PhraseAffinityResponse affinity;
    final int mVersionCode;
    public Status status;

    public Response()
    {
      mVersionCode = 1;
    }

    Response(int paramInt, Status paramStatus, PhraseAffinityResponse paramPhraseAffinityResponse)
    {
      mVersionCode = paramInt;
      status = paramStatus;
      affinity = paramPhraseAffinityResponse;
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