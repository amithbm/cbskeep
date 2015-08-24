package com.google.android.gms.people.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.people.model.ContactGaiaId;

public class zzd extends zzc
  implements ContactGaiaId
{
  public zzd(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
  }

  public String getGaiaId()
  {
    return getString("gaia_id");
  }
}