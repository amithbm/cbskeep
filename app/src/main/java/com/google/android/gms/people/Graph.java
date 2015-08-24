package com.google.android.gms.people;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.people.internal.zzl;
import com.google.android.gms.people.model.ContactGaiaIdBuffer;
import com.google.android.gms.people.model.OwnerBuffer;

public abstract interface Graph
{
  public abstract PendingResult<LoadContactsGaiaIdsResult> loadContactsGaiaIds(GoogleApiClient paramGoogleApiClient, LoadContactsGaiaIdsOptions paramLoadContactsGaiaIdsOptions);

  public abstract PendingResult<LoadOwnersResult> loadOwners(GoogleApiClient paramGoogleApiClient, LoadOwnersOptions paramLoadOwnersOptions);

  public static class LoadContactsGaiaIdsOptions
  {
    public static final LoadContactsGaiaIdsOptions DEFAULT = new LoadContactsGaiaIdsOptions();
    private String zzbcm;
    private int zzbcp = 3;
    private String zzbcv;

    public String getFilterContactInfo()
    {
      return zzbcv;
    }

    public int getFilterGaiaEdgeTypes()
    {
      return zzbcp;
    }

    public String getFilterGaiaId()
    {
      return zzbcm;
    }

    public LoadContactsGaiaIdsOptions setFilterContactInfo(String paramString)
    {
      zzbcv = paramString;
      return this;
    }

    public String toString()
    {
      return zzl.zzc(new Object[] { "mFilterContactInfo", zzbcv, "mFilterGaiaId", zzbcm, "mFilterGaiaEdgeTypes", Integer.valueOf(zzbcp) });
    }
  }

  public static abstract interface LoadContactsGaiaIdsResult extends People.ReleasableResult
  {
    public abstract ContactGaiaIdBuffer getContactsGaiaIds();
  }

  public static class LoadOwnersOptions
  {
    public static final LoadOwnersOptions DEFAULT = new LoadOwnersOptions();
    private int zzbcq = 0;
    private boolean zzbcw;

    public int getSortOrder()
    {
      return zzbcq;
    }

    public boolean isIncludePlusPages()
    {
      return zzbcw;
    }

    public LoadOwnersOptions setIncludePlusPages(boolean paramBoolean)
    {
      zzbcw = paramBoolean;
      return this;
    }

    public String toString()
    {
      return zzl.zzc(new Object[] { "mIncludePlusPages", Boolean.valueOf(zzbcw), "mSortOrder", Integer.valueOf(zzbcq) });
    }
  }

  public static abstract interface LoadOwnersResult extends People.ReleasableResult
  {
    public abstract OwnerBuffer getOwners();
  }
}