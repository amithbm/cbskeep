package com.google.android.gms.appindexing;

import com.google.android.gms.appdatasearch.AppDataSearch;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.internal.zzja;

public final class AppIndex
{
  public static final Api<Api.ApiOptions.NoOptions> API = AppDataSearch.LIGHTWEIGHT_API;
  public static final Api<Api.ApiOptions.NoOptions> APP_INDEX_API = AppDataSearch.LIGHTWEIGHT_API;
  public static final AppIndexApi AppIndexApi = new zzja();
}