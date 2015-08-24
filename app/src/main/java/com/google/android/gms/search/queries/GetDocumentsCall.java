package com.google.android.gms.search.queries;

import android.os.Parcel;
import com.google.android.gms.appdatasearch.DocumentResults;
import com.google.android.gms.appdatasearch.QuerySpecification;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetDocumentsCall
{
  public static class Request
    implements SafeParcelable
  {
    public static final zza CREATOR = new zza();
    public String corpusName;
    final int mVersionCode;
    public String packageName;
    public String[] zzbbC;
    public QuerySpecification zzbqu;

    public Request()
    {
      mVersionCode = 1;
    }

    Request(int paramInt, String paramString1, String paramString2, String[] paramArrayOfString, QuerySpecification paramQuerySpecification)
    {
      mVersionCode = paramInt;
      packageName = paramString1;
      corpusName = paramString2;
      zzbbC = paramArrayOfString;
      zzbqu = paramQuerySpecification;
    }

    public int describeContents()
    {
      zza localzza = CREATOR;
      return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      zza localzza = CREATOR;
      zza.zza(this, paramParcel, paramInt);
    }
  }

  public static class Response
    implements Result, SafeParcelable
  {
    public static final zzb CREATOR = new zzb();
    public DocumentResults documents;
    final int mVersionCode;
    public Status status;

    public Response()
    {
      mVersionCode = 1;
    }

    Response(int paramInt, Status paramStatus, DocumentResults paramDocumentResults)
    {
      mVersionCode = paramInt;
      status = paramStatus;
      documents = paramDocumentResults;
    }

    public int describeContents()
    {
      zzb localzzb = CREATOR;
      return 0;
    }

    public Status getStatus()
    {
      return status;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      zzb localzzb = CREATOR;
      zzb.zza(this, paramParcel, paramInt);
    }
  }
}