package com.google.android.gms.location.places;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.common.internal.zzu.zza;
import com.google.android.gms.location.places.internal.zzb;

public class AutocompletePredictionBuffer extends AbstractDataBuffer<AutocompletePrediction>
  implements Result
{
  public AutocompletePredictionBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }

  public AutocompletePrediction get(int paramInt)
  {
    return new zzb(mDataHolder, paramInt);
  }

  public Status getStatus()
  {
    return PlacesStatusCodes.zzlE(mDataHolder.getStatusCode());
  }

  public String toString()
  {
    return zzu.zzy(this).zzc("status", getStatus()).toString();
  }
}