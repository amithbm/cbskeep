package com.google.android.gms.location.places;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.internal.zzt;

public class PlaceBuffer extends AbstractDataBuffer<Place>
  implements Result
{
  private final Context mContext;
  private final Status zzOQ;
  private final String zzaUl;

  public PlaceBuffer(DataHolder paramDataHolder, Context paramContext)
  {
    super(paramDataHolder);
    mContext = paramContext;
    zzOQ = PlacesStatusCodes.zzlE(paramDataHolder.getStatusCode());
    if ((paramDataHolder != null) && (paramDataHolder.getMetadata() != null))
    {
      zzaUl = paramDataHolder.getMetadata().getString("com.google.android.gms.location.places.PlaceBuffer.ATTRIBUTIONS_EXTRA_KEY");
      return;
    }
    zzaUl = null;
  }

  public Place get(int paramInt)
  {
    return new zzt(mDataHolder, paramInt, mContext);
  }

  public Status getStatus()
  {
    return zzOQ;
  }
}