package com.google.android.keep.location;

import com.google.android.keep.model.LocationReminder.LocationType;

public class g
  implements i.b
{
  private final String ja;
  private final LocationReminder.LocationType su;
  private final String sv;
  private final String sw;

  public g(LocationReminder.LocationType paramLocationType, String paramString1, String paramString2, String paramString3)
  {
    su = paramLocationType;
    ja = paramString1;
    sv = paramString2;
    sw = paramString3;
  }

  public LocationReminder.LocationType fS()
  {
    return su;
  }

  public String getPlaceId()
  {
    return sw;
  }

  public String getText()
  {
    return sv;
  }

  public String getTitle()
  {
    return ja;
  }

  public String toString()
  {
    return "PlaceSuggestion{mTitle='" + ja + '\'' + ", mText='" + sv + '\'' + ", mPlaceId='" + sw + '\'' + '}';
  }
}