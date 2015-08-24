package com.google.android.gms.location.places.internal;

import android.content.Context;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlaceLikelihood;

public class zzo extends zzw
  implements PlaceLikelihood
{
  private final Context mContext;

  public zzo(DataHolder paramDataHolder, int paramInt, Context paramContext)
  {
    super(paramDataHolder, paramInt);
    mContext = paramContext;
  }

  public float getLikelihood()
  {
    return zzb("place_likelihood", -1.0F);
  }

  public Place getPlace()
  {
    return new zzt(mDataHolder, zzaiZ, mContext);
  }

  public PlaceLikelihood zzzg()
  {
    return PlaceLikelihoodEntity.zza((PlaceImpl)getPlace().freeze(), getLikelihood());
  }
}