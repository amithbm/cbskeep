package com.google.android.gms.search.queries;

import android.os.Parcel;
import com.google.android.gms.appdatasearch.GlobalSearchQuerySpecification;
import com.google.android.gms.appdatasearch.SearchResults;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GlobalQueryCall
{
  public static class Request
    implements SafeParcelable
  {
    public static final zze CREATOR = new zze();
    final int mVersionCode;
    public String query;
    public int start;
    public GlobalSearchQuerySpecification zzbqA;
    public int zzbqz;

    public Request()
    {
      mVersionCode = 1;
    }

    Request(int paramInt1, String paramString, int paramInt2, int paramInt3, GlobalSearchQuerySpecification paramGlobalSearchQuerySpecification)
    {
      mVersionCode = paramInt1;
      query = paramString;
      start = paramInt2;
      zzbqz = paramInt3;
      zzbqA = paramGlobalSearchQuerySpecification;
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