package com.google.android.keep.location;

import android.content.Context;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.GeoDataApi;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.UserDataType;
import com.google.android.gms.location.places.personalized.PlaceUserDataBuffer;
import com.google.android.keep.util.k;
import java.util.concurrent.TimeUnit;

public class b extends k<PlaceUserDataBuffer>
{
  public b(Context paramContext, GoogleApiClient paramGoogleApiClient)
  {
    super(paramContext, paramGoogleApiClient);
    a(5L, TimeUnit.SECONDS);
  }

  protected PendingResult<PlaceUserDataBuffer> a(GoogleApiClient paramGoogleApiClient)
  {
    return Places.GeoDataApi.getPlaceUserData(paramGoogleApiClient, UserDataType.ALIASES, null, null);
  }

  protected PlaceUserDataBuffer b(Status paramStatus)
  {
    return null;
  }
}