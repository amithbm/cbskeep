package com.google.android.gms.location.places;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.maps.model.LatLng;
import java.util.Map;

public abstract interface Place extends Freezable<Place>
{
  public abstract CharSequence getAddress();

  public abstract Map<Integer, String> getAddressComponents();

  public abstract String getId();

  public abstract LatLng getLatLng();

  public abstract CharSequence getName();
}