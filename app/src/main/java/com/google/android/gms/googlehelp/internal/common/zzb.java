package com.google.android.gms.googlehelp.internal.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza.zza;
import com.google.android.gms.googlehelp.GoogleHelp;
import com.google.android.gms.googlehelp.GoogleHelpTogglingRegister;
import com.google.android.gms.googlehelp.zza;

public class zzb
  implements zza
{
  private static final Status zzaOG = new Status(13);

  public PendingResult<Status> zza(GoogleApiClient paramGoogleApiClient, final Activity paramActivity, final Intent paramIntent)
  {
    if (GoogleHelpTogglingRegister.isTogglingEnabled());
    for (final Bitmap localBitmap = zzd.zzr(paramActivity); ; localBitmap = null)
      return paramGoogleApiClient.zza(new zzb(paramGoogleApiClient)
      {
        protected void zza(Context paramAnonymousContext, zzf paramAnonymouszzf)
          throws RemoteException
        {
          try
          {
            paramAnonymouszzf.zza((GoogleHelp)paramIntent.getParcelableExtra("EXTRA_GOOGLE_HELP"), localBitmap, new SimpleGoogleHelpCallbacks()
            {
              public void onGoogleHelpProcessed(GoogleHelp paramAnonymous2GoogleHelp)
              {
                if (paramAnonymous2GoogleHelp.getTogglingData() != null)
                  paramAnonymous2GoogleHelp.getTogglingData().setPipTitle(zzd.zzt(zzaOI));
                zzaOw.putExtra("EXTRA_GOOGLE_HELP", paramAnonymous2GoogleHelp).putExtra("EXTRA_START_TICK", System.nanoTime());
                zzaOI.startActivityForResult(zzaOw, 123);
                setResult(Status.zzaii);
              }
            });
            return;
          }
          catch (Exception paramAnonymousContext)
          {
            Log.e("gH_GoogleHelpApiImpl", "Starting help failed!", paramAnonymousContext);
            zzI(zzb.zzxL());
          }
        }
      });
  }

  static abstract class zza<R extends Result> extends zza.zza<R, zzc>
  {
    public zza(GoogleApiClient paramGoogleApiClient)
    {
      super(paramGoogleApiClient);
    }

    protected abstract void zza(Context paramContext, zzf paramzzf)
      throws RemoteException;

    protected final void zza(zzc paramzzc)
      throws RemoteException
    {
      zza(paramzzc.getContext(), (zzf)paramzzc.zzpN());
    }
  }

  static abstract class zzb extends zzb.zza<Status>
  {
    public zzb(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }

    protected Status zze(Status paramStatus)
    {
      return paramStatus;
    }
  }
}