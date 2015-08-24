package com.google.android.gms.location.places;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.internal.zzs;

public class PlacePhotoMetadataBuffer extends AbstractDataBuffer<PlacePhotoMetadata>
{
  public PlacePhotoMetadataBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }

  public PlacePhotoMetadata get(int paramInt)
  {
    return new zzs(mDataHolder, paramInt);
  }
}