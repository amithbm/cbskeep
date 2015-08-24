package com.google.android.gms.location.places.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.AutocompletePrediction;
import java.util.Collections;
import java.util.List;

public class zzb extends zzw
  implements AutocompletePrediction
{
  public zzb(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
  }

  public String getDescription()
  {
    return zzJ("ap_description", "");
  }

  public List<AutocompletePredictionEntity.SubstringEntity> getMatchedSubstrings()
  {
    return zza("ap_matched_subscriptions", AutocompletePredictionEntity.SubstringEntity.CREATOR, Collections.emptyList());
  }

  public int getPersonalizationType()
  {
    return zzx("ap_personalization_type", 6);
  }

  public String getPlaceId()
  {
    return zzJ("ap_place_id", null);
  }

  public List<Integer> getPlaceTypes()
  {
    return zza("ap_place_types", Collections.emptyList());
  }

  public AutocompletePrediction zzyW()
  {
    return AutocompletePredictionEntity.zza(getDescription(), getPlaceId(), getPlaceTypes(), getMatchedSubstrings(), getPersonalizationType());
  }
}