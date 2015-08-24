package com.google.android.gms.nearby.sharing;

import android.app.Activity;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

public abstract interface Sharing
{
  public abstract PendingResult<Status> registerShareCallback(GoogleApiClient paramGoogleApiClient, Activity paramActivity, ShareCallback paramShareCallback);

  public abstract PendingResult<Status> unregisterShareCallback(GoogleApiClient paramGoogleApiClient, Activity paramActivity);
}