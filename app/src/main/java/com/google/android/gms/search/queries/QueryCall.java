package com.google.android.gms.search.queries;

import android.os.Parcel;
import com.google.android.gms.appdatasearch.QuerySpecification;
import com.google.android.gms.appdatasearch.SearchResults;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class QueryCall
{
  public static class Request
    implements SafeParcelable
  {
    public static final zzg CREATOR = new zzg();
    final int mVersionCode;
    public String packageName;
    public String query;
    public int start;
    public String[] zzbqC;
    public QuerySpecification zzbqu;
    public int zzbqz;

    public Request()
    {
      mVersionCode = 1;
    }

    Request(int paramInt1, String paramString1, String paramString2, String[] paramArrayOfString, int paramInt2, int paramInt3, QuerySpecification paramQuerySpecification)
    {
      mVersionCode = paramInt1;
      query = paramString1;
      packageName = paramString2;
      zzbqC = paramArrayOfString;
      start = paramInt2;
      zzbqz = paramInt3;
      zzbqu = paramQuerySpecification;
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
    public SearchResults documents;
    final int mVersionCode;
    public Status status;

    public Response()
    {
      mVersionCode = 1;
    }

    Response(int paramInt, Status paramStatus, SearchResults paramSearchResults)
    {
      mVersionCode = paramInt;
      status = paramStatus;
      documents = paramSearchResults;
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