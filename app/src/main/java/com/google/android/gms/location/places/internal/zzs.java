package com.google.android.gms.location.places.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.PlacePhotoMetadata;

public class zzs extends zzw
  implements PlacePhotoMetadata
{
  private final String zzaVN = getString("photo_fife_url");

  public zzs(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
  }

  public CharSequence getAttributions()
  {
    return zzJ("photo_attributions", null);
  }

  public int getMaxHeight()
  {
    return zzx("photo_max_height", 0);
  }

  public int getMaxWidth()
  {
    return zzx("photo_max_width", 0);
  }

  public PlacePhotoMetadata zzzh()
  {
    return new zzr(zzaVN, getMaxWidth(), getMaxHeight(), getAttributions(), zzaiZ);
  }
}