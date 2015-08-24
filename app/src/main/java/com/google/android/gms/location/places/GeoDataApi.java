package com.google.android.gms.location.places;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.location.places.personalized.PlaceUserDataBuffer;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.List;

public abstract interface GeoDataApi
{
  public abstract PendingResult<PlaceBuffer> getPlaceById(GoogleApiClient paramGoogleApiClient, String[] paramArrayOfString);

  public abstract PendingResult<PlaceUserDataBuffer> getPlaceUserData(GoogleApiClient paramGoogleApiClient, UserDataType paramUserDataType, LatLngBounds paramLatLngBounds, List<String> paramList);
}