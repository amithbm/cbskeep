package com.google.android.gms.appindexing;

import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

public abstract interface AppIndexApi
{
  public abstract PendingResult<Status> end(GoogleApiClient paramGoogleApiClient, Action paramAction);

  @Deprecated
  public static final class AppIndexingLink
  {
    public final Uri appIndexingUrl;
    public final int viewId;
    public final Uri webUrl;
  }
}