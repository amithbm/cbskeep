package com.google.android.gms.people;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.people.internal.zzl;
import com.google.android.gms.people.model.AutocompleteBuffer;

public abstract interface Autocomplete
{
  public abstract PendingResult<AutocompleteResult> loadAutocompleteList(GoogleApiClient paramGoogleApiClient, String paramString, AutocompleteOptions paramAutocompleteOptions);

  public static final class AutocompleteOptions
  {
    public final String account;
    public final int autocompleteType;
    public final String directoryAccountType;
    public final boolean isDirectorySearch;
    public final int numberOfResults;
    public final String pageId;
    public final int searchOptions;
    public final boolean useAndroidContactFallback;

    private AutocompleteOptions(Builder paramBuilder)
    {
      isDirectorySearch = Builder.zza(paramBuilder);
      directoryAccountType = Builder.zzb(paramBuilder);
      account = Builder.zzc(paramBuilder);
      pageId = Builder.zzd(paramBuilder);
      autocompleteType = Builder.zze(paramBuilder);
      searchOptions = Builder.zzf(paramBuilder);
      numberOfResults = Builder.zzg(paramBuilder);
      useAndroidContactFallback = Builder.zzh(paramBuilder);
    }

    public String toString()
    {
      return zzl.zzc(new Object[] { "isDirectorySearch", Boolean.valueOf(isDirectorySearch), "directoryAccountType", directoryAccountType, "account", account, "pageId", pageId, "autocompleteType", Integer.valueOf(autocompleteType), "searchOptions", Integer.valueOf(searchOptions), "numberOfResults", Integer.valueOf(numberOfResults), "useAndroidContactFallback", Boolean.valueOf(useAndroidContactFallback) });
    }

    public static final class Builder
    {
      private String mAccount;
      private boolean zzbcb;
      private String zzbcc;
      private String zzbcd = "com.google";
      private int zzbce = 0;
      private int zzbcf;
      private int zzbcg = 10;
      private boolean zzbch = true;

      public Autocomplete.AutocompleteOptions build()
      {
        return new Autocomplete.AutocompleteOptions(this, null);
      }

      public Builder setAccount(String paramString)
      {
        mAccount = paramString;
        return this;
      }

      public Builder setAutocompleteType(int paramInt)
      {
        zzbce = paramInt;
        return this;
      }
    }
  }

  public static abstract interface AutocompleteResult extends People.ReleasableResult
  {
    public abstract AutocompleteBuffer getAutocompleteEntries();
  }
}