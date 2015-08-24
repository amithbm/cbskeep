package com.google.android.keep.location;

import android.content.Context;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.GeoDataApi;
import com.google.android.gms.location.places.PlaceBuffer;
import com.google.android.gms.location.places.Places;
import com.google.android.keep.util.k;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

public class f extends k<PlaceBuffer>
{
  private final Collection<String> st;

  public f(Context paramContext, GoogleApiClient paramGoogleApiClient, Collection<String> paramCollection)
  {
    super(paramContext, paramGoogleApiClient);
    st = paramCollection;
    a(5L, TimeUnit.SECONDS);
  }

  protected PendingResult<PlaceBuffer> a(GoogleApiClient paramGoogleApiClient)
  {
    if (st.isEmpty())
      return null;
    return Places.GeoDataApi.getPlaceById(paramGoogleApiClient, (String[])st.toArray(new String[st.size()]));
  }

  protected PlaceBuffer c(Status paramStatus)
  {
    return null;
  }
}