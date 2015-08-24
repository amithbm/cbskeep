package com.google.android.gms.location.places.personalized;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzd;
import com.google.android.gms.common.internal.zzv;
import com.google.android.gms.location.places.PlacesStatusCodes;

public final class PlaceUserDataBuffer extends zzd<PlaceUserData>
  implements Result
{
  private final Status zzOQ;

  public PlaceUserDataBuffer(DataHolder paramDataHolder)
  {
    this(paramDataHolder, PlacesStatusCodes.zzlE(paramDataHolder.getStatusCode()));
  }

  private PlaceUserDataBuffer(DataHolder paramDataHolder, Status paramStatus)
  {
    super(paramDataHolder, PlaceUserData.CREATOR);
    if ((paramDataHolder == null) || (paramDataHolder.getStatusCode() == paramStatus.getStatusCode()));
    for (boolean bool = true; ; bool = false)
    {
      zzv.zzS(bool);
      zzOQ = paramStatus;
      return;
    }
  }

  public static PlaceUserDataBuffer empty(Status paramStatus)
  {
    return new PlaceUserDataBuffer(null, paramStatus);
  }

  public Status getStatus()
  {
    return zzOQ;
  }
}