package com.google.android.gms.location;

import android.location.Location;
import com.google.android.gms.common.api.GoogleApiClient;

public abstract interface FusedLocationProviderApi
{
  public abstract Location getLastLocation(GoogleApiClient paramGoogleApiClient);
}