package com.google.android.gms.location.places;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza.zza;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzv;
import com.google.android.gms.common.util.zzp;
import com.google.android.gms.location.places.internal.zzh.zza;
import com.google.android.gms.location.places.personalized.PlaceUserDataBuffer;

public class zzk extends zzh.zza
{
  private static final String TAG = zzk.class.getSimpleName();
  private final Context mContext;
  private final zzd zzaUD = null;
  private final zza zzaUE = null;
  private final zze zzaUF;
  private final zzf zzaUG;
  private final zzc zzaUH;

  public zzk(zzc paramzzc, Context paramContext)
  {
    zzaUF = null;
    zzaUG = null;
    zzaUH = paramzzc;
    mContext = paramContext;
  }

  public zzk(zze paramzze)
  {
    zzaUF = paramzze;
    zzaUG = null;
    zzaUH = null;
    mContext = null;
  }

  public void zzaa(DataHolder paramDataHolder)
    throws RemoteException
  {
    if (zzaUD != null);
    for (boolean bool = true; ; bool = false)
    {
      zzv.zza(bool, "placeEstimator cannot be null");
      if (paramDataHolder != null)
        break;
      if (Log.isLoggable(TAG, 6))
        Log.e(TAG, "onPlaceEstimated received null DataHolder: " + zzp.zzqV());
      zzaUD.zzI(Status.zzaik);
      return;
    }
    paramDataHolder = new PlaceLikelihoodBuffer(paramDataHolder, 100, mContext);
    zzaUD.setResult(paramDataHolder);
  }

  public void zzab(DataHolder paramDataHolder)
    throws RemoteException
  {
    if (paramDataHolder == null)
    {
      if (Log.isLoggable(TAG, 6))
        Log.e(TAG, "onAutocompletePrediction received null DataHolder: " + zzp.zzqV());
      zzaUE.zzI(Status.zzaik);
      return;
    }
    zzaUE.setResult(new AutocompletePredictionBuffer(paramDataHolder));
  }

  public void zzac(DataHolder paramDataHolder)
    throws RemoteException
  {
    if (paramDataHolder == null)
    {
      if (Log.isLoggable(TAG, 6))
        Log.e(TAG, "onPlaceUserDataFetched received null DataHolder: " + zzp.zzqV());
      zzaUF.zzI(Status.zzaik);
      return;
    }
    zzaUF.setResult(new PlaceUserDataBuffer(paramDataHolder));
  }

  public void zzad(DataHolder paramDataHolder)
    throws RemoteException
  {
    paramDataHolder = new PlaceBuffer(paramDataHolder, mContext);
    zzaUH.setResult(paramDataHolder);
  }

  public void zzbu(Status paramStatus)
    throws RemoteException
  {
    zzaUG.setResult(paramStatus);
  }

  public static abstract class zza<A extends Api.Client> extends zzk.zzb<AutocompletePredictionBuffer, A>
  {
    protected AutocompletePredictionBuffer zzbv(Status paramStatus)
    {
      return new AutocompletePredictionBuffer(DataHolder.zzeA(paramStatus.getStatusCode()));
    }
  }

  public static abstract class zzb<R extends Result, A extends Api.Client> extends zza.zza<R, A>
  {
    public zzb(Api.ClientKey<A> paramClientKey, GoogleApiClient paramGoogleApiClient)
    {
      super(paramGoogleApiClient);
    }
  }

  public static abstract class zzc<A extends Api.Client> extends zzk.zzb<PlaceBuffer, A>
  {
    public zzc(Api.ClientKey<A> paramClientKey, GoogleApiClient paramGoogleApiClient)
    {
      super(paramGoogleApiClient);
    }

    protected PlaceBuffer zzbw(Status paramStatus)
    {
      return new PlaceBuffer(DataHolder.zzeA(paramStatus.getStatusCode()), null);
    }
  }

  public static abstract class zzd<A extends Api.Client> extends zzk.zzb<PlaceLikelihoodBuffer, A>
  {
    protected PlaceLikelihoodBuffer zzbx(Status paramStatus)
    {
      return new PlaceLikelihoodBuffer(DataHolder.zzeA(paramStatus.getStatusCode()), 100, null);
    }
  }

  public static abstract class zze<A extends Api.Client> extends zzk.zzb<PlaceUserDataBuffer, A>
  {
    public zze(Api.ClientKey<A> paramClientKey, GoogleApiClient paramGoogleApiClient)
    {
      super(paramGoogleApiClient);
    }

    protected PlaceUserDataBuffer zzby(Status paramStatus)
    {
      return PlaceUserDataBuffer.empty(paramStatus);
    }
  }

  public static abstract class zzf<A extends Api.Client> extends zzk.zzb<Status, A>
  {
    protected Status zze(Status paramStatus)
    {
      return paramStatus;
    }
  }
}