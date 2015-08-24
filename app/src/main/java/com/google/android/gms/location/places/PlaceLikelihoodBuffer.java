package com.google.android.gms.location.places;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.common.internal.zzu.zza;
import com.google.android.gms.location.places.internal.zzo;

public class PlaceLikelihoodBuffer extends AbstractDataBuffer<PlaceLikelihood>
  implements Result
{
  private final Context mContext;
  private final Status zzOQ;
  private final String zzaUl;
  private final int zzaUs;

  public PlaceLikelihoodBuffer(DataHolder paramDataHolder, int paramInt, Context paramContext)
  {
    super(paramDataHolder);
    mContext = paramContext;
    zzOQ = PlacesStatusCodes.zzlE(paramDataHolder.getStatusCode());
    zzaUs = Source.zzly(paramInt);
    if ((paramDataHolder != null) && (paramDataHolder.getMetadata() != null))
    {
      zzaUl = paramDataHolder.getMetadata().getString("com.google.android.gms.location.places.PlaceLikelihoodBuffer.ATTRIBUTIONS_EXTRA_KEY");
      return;
    }
    zzaUl = null;
  }

  public PlaceLikelihood get(int paramInt)
  {
    return new zzo(mDataHolder, paramInt, mContext);
  }

  public Status getStatus()
  {
    return zzOQ;
  }

  public String toString()
  {
    return zzu.zzy(this).zzc("status", getStatus()).zzc("attributions", zzaUl).toString();
  }

  public static class Source
  {
    static int zzly(int paramInt)
    {
      switch (paramInt)
      {
      default:
        throw new IllegalArgumentException("invalid source: " + paramInt);
      case 100:
      case 101:
      case 102:
      case 103:
      case 104:
      case 105:
      }
      return paramInt;
    }
  }
}