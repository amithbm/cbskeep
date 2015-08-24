package com.google.android.keep.location;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.keep.util.Config;
import com.google.android.keep.util.r;

public class c
  implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener
{
  public void onConnected(Bundle paramBundle)
  {
    r.a("Keep", "GoogleApiClient connected: " + paramBundle, new Object[0]);
  }

  public void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    r.e("Keep", "GoogleApiClient failed to connect: " + paramConnectionResult, new Object[0]);
    if ((!GooglePlayServicesUtil.isUserRecoverableError(paramConnectionResult.getErrorCode())) && (Config.oe()))
      throw new RuntimeException("Failed to add geofence. status: " + paramConnectionResult);
  }

  public void onConnectionSuspended(int paramInt)
  {
    r.a("Keep", "GoogleApiClient connections suspended: " + paramInt, new Object[0]);
  }
}