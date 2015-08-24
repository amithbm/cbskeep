package com.google.android.keep.util;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gsf.GservicesValue;
import com.google.android.keep.model.Location;

public class v
{
  public static LatLngBounds g(Location paramLocation)
  {
    float f = ((Float)Config.OJ.get()).floatValue();
    return new LatLngBounds(new LatLng(paramLocation.hW().doubleValue() - f, paramLocation.hX().doubleValue() - f), new LatLng(paramLocation.hW().doubleValue() + f, paramLocation.hX().doubleValue() + f));
  }
}