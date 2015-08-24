package com.google.android.gms.search.global;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.appdatasearch.Feature;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetGlobalSearchSourcesCall
{
  public static class CorpusInfo
    implements SafeParcelable
  {
    public static final zzc CREATOR = new zzc();
    public String corpusName;
    public Feature[] features;
    public boolean isAppHistoryCorpus;
    final int mVersionCode;
    public Bundle userHandle;

    public CorpusInfo()
    {
      mVersionCode = 1;
    }

    CorpusInfo(int paramInt, String paramString, Feature[] paramArrayOfFeature, boolean paramBoolean, Bundle paramBundle)
    {
      mVersionCode = paramInt;
      corpusName = paramString;
      features = paramArrayOfFeature;
      isAppHistoryCorpus = paramBoolean;
      userHandle = paramBundle;
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

  public static class GlobalSearchSource
    implements SafeParcelable
  {
    public static final zzd CREATOR = new zzd();
    public GetGlobalSearchSourcesCall.CorpusInfo[] corpora;
    public String defaultIntentAction;
    public String defaultIntentActivity;
    public String defaultIntentData;
    public boolean enabled;
    public int iconId;
    public int labelId;
    final int mVersionCode;
    public String packageName;
    public int settingsDescriptionId;

    public GlobalSearchSource()
    {
      mVersionCode = 1;
    }

    GlobalSearchSource(int paramInt1, String paramString1, int paramInt2, int paramInt3, int paramInt4, String paramString2, String paramString3, String paramString4, GetGlobalSearchSourcesCall.CorpusInfo[] paramArrayOfCorpusInfo, boolean paramBoolean)
    {
      mVersionCode = paramInt1;
      packageName = paramString1;
      labelId = paramInt2;
      settingsDescriptionId = paramInt3;
      iconId = paramInt4;
      defaultIntentAction = paramString2;
      defaultIntentData = paramString3;
      defaultIntentActivity = paramString4;
      corpora = paramArrayOfCorpusInfo;
      enabled = paramBoolean;
    }

    public int describeContents()
    {
      zzd localzzd = CREATOR;
      return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      zzd localzzd = CREATOR;
      zzd.zza(this, paramParcel, paramInt);
    }
  }

  public static class Request
    implements SafeParcelable
  {
    public static final zze CREATOR = new zze();
    final int mVersionCode;
    public boolean wantDisabledSources;

    public Request()
    {
      mVersionCode = 1;
    }

    Request(int paramInt, boolean paramBoolean)
    {
      mVersionCode = paramInt;
      wantDisabledSources = paramBoolean;
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
    final int mVersionCode;
    public GetGlobalSearchSourcesCall.GlobalSearchSource[] sources;
    public Status status;

    public Response()
    {
      mVersionCode = 1;
    }

    Response(int paramInt, Status paramStatus, GetGlobalSearchSourcesCall.GlobalSearchSource[] paramArrayOfGlobalSearchSource)
    {
      mVersionCode = paramInt;
      status = paramStatus;
      sources = paramArrayOfGlobalSearchSource;
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