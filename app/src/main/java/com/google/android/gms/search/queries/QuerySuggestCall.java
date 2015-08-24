package com.google.android.gms.search.queries;

import android.os.Parcel;
import com.google.android.gms.appdatasearch.SuggestSpecification;
import com.google.android.gms.appdatasearch.SuggestionResults;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class QuerySuggestCall
{
  public static class Request
    implements SafeParcelable
  {
    public static final zzi CREATOR = new zzi();
    final int mVersionCode;
    public String packageName;
    public String query;
    public String[] zzbqC;
    public int zzbqE;
    public SuggestSpecification zzbqF;

    public Request()
    {
      mVersionCode = 1;
    }

    Request(int paramInt1, String paramString1, String paramString2, String[] paramArrayOfString, int paramInt2, SuggestSpecification paramSuggestSpecification)
    {
      mVersionCode = paramInt1;
      query = paramString1;
      packageName = paramString2;
      zzbqC = paramArrayOfString;
      zzbqE = paramInt2;
      zzbqF = paramSuggestSpecification;
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
    public SuggestionResults querySuggestions;
    public Status status;

    public Response()
    {
      mVersionCode = 1;
    }

    Response(int paramInt, Status paramStatus, SuggestionResults paramSuggestionResults)
    {
      mVersionCode = paramInt;
      status = paramStatus;
      querySuggestions = paramSuggestionResults;
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