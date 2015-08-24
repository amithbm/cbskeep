package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzv;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

public class zzn extends Fragment
  implements DialogInterface.OnCancelListener, LoaderManager.LoaderCallbacks<ConnectionResult>
{
  private boolean zzaio;
  private int zzaip = -1;
  private ConnectionResult zzaiq;
  private final Handler zzair = new Handler(Looper.getMainLooper());
  private final SparseArray<zzb> zzais = new SparseArray();

  private void zza(int paramInt, ConnectionResult paramConnectionResult)
  {
    Log.w("GmsSupportLoaderLifecycleFragment", "Unresolved error while connecting client. Stopping auto-manage.");
    Object localObject = (zzb)zzais.get(paramInt);
    if (localObject != null)
    {
      zzet(paramInt);
      localObject = ((zzb)localObject).zzaiv;
      if (localObject != null)
        ((GoogleApiClient.OnConnectionFailedListener)localObject).onConnectionFailed(paramConnectionResult);
    }
    zzoW();
  }

  public static zzn zzb(FragmentActivity paramFragmentActivity)
  {
    zzv.zzbT("Must be called from main thread of process");
    FragmentManager localFragmentManager = paramFragmentActivity.getSupportFragmentManager();
    try
    {
      zzn localzzn = (zzn)localFragmentManager.findFragmentByTag("GmsSupportLoaderLifecycleFragment");
      if (localzzn != null)
      {
        paramFragmentActivity = localzzn;
        if (!localzzn.isRemoving());
      }
      else
      {
        paramFragmentActivity = new zzn();
        localFragmentManager.beginTransaction().add(paramFragmentActivity, "GmsSupportLoaderLifecycleFragment").commit();
        localFragmentManager.executePendingTransactions();
      }
      return paramFragmentActivity;
    }
    catch (ClassCastException paramFragmentActivity)
    {
    }
    throw new IllegalStateException("Fragment with tag GmsSupportLoaderLifecycleFragment is not a SupportLoaderLifecycleFragment", paramFragmentActivity);
  }

  private void zzb(int paramInt, ConnectionResult paramConnectionResult)
  {
    if (!zzaio)
    {
      zzaio = true;
      zzaip = paramInt;
      zzaiq = paramConnectionResult;
      zzair.post(new zzc(paramInt, paramConnectionResult));
    }
  }

  private void zzoW()
  {
    int i = 0;
    zzaio = false;
    zzaip = -1;
    zzaiq = null;
    LoaderManager localLoaderManager = getLoaderManager();
    while (i < zzais.size())
    {
      int j = zzais.keyAt(i);
      zza localzza = zzev(j);
      if ((localzza != null) && (localzza.zzoY()))
      {
        localLoaderManager.destroyLoader(j);
        localLoaderManager.initLoader(j, null, this);
      }
      i += 1;
    }
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 1;
    switch (paramInt1)
    {
    default:
      paramInt1 = 0;
    case 2:
    case 1:
    }
    while (true)
    {
      if (paramInt1 == 0)
        break label66;
      zzoW();
      return;
      if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(getActivity()) != 0)
        break;
      paramInt1 = i;
      continue;
      if (paramInt2 != -1)
        break;
      paramInt1 = i;
    }
    label66: zza(zzaip, zzaiq);
  }

  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    int i = 0;
    if (i < zzais.size())
    {
      int j = zzais.keyAt(i);
      paramActivity = zzev(j);
      if ((paramActivity != null) && (((zzb)zzais.valueAt(i)).zzaiu != paramActivity.zzaiu))
        getLoaderManager().restartLoader(j, null, this);
      while (true)
      {
        i += 1;
        break;
        getLoaderManager().initLoader(j, null, this);
      }
    }
  }

  public void onCancel(DialogInterface paramDialogInterface)
  {
    zza(zzaip, new ConnectionResult(13, null));
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle != null)
    {
      zzaio = paramBundle.getBoolean("resolving_error", false);
      zzaip = paramBundle.getInt("failed_client_id", -1);
      if (zzaip >= 0)
        zzaiq = new ConnectionResult(paramBundle.getInt("failed_status"), (PendingIntent)paramBundle.getParcelable("failed_resolution"));
    }
  }

  public Loader<ConnectionResult> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    return new zza(getActivity(), ((zzb)zzais.get(paramInt)).zzaiu);
  }

  public void onLoaderReset(Loader<ConnectionResult> paramLoader)
  {
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("resolving_error", zzaio);
    if (zzaip >= 0)
    {
      paramBundle.putInt("failed_client_id", zzaip);
      paramBundle.putInt("failed_status", zzaiq.getErrorCode());
      paramBundle.putParcelable("failed_resolution", zzaiq.getResolution());
    }
  }

  public void onStart()
  {
    super.onStart();
    if (!zzaio)
    {
      int i = 0;
      while (i < zzais.size())
      {
        getLoaderManager().initLoader(zzais.keyAt(i), null, this);
        i += 1;
      }
    }
  }

  public void zza(int paramInt, GoogleApiClient paramGoogleApiClient, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    zzv.zzb(paramGoogleApiClient, "GoogleApiClient instance cannot be null");
    if (zzais.indexOfKey(paramInt) < 0);
    for (boolean bool = true; ; bool = false)
    {
      zzv.zza(bool, "Already managing a GoogleApiClient with id " + paramInt);
      paramGoogleApiClient = new zzb(paramGoogleApiClient, paramOnConnectionFailedListener, null);
      zzais.put(paramInt, paramGoogleApiClient);
      if (getActivity() != null)
      {
        LoaderManager.enableDebugLogging(false);
        getLoaderManager().initLoader(paramInt, null, this);
      }
      return;
    }
  }

  public void zza(Loader<ConnectionResult> paramLoader, ConnectionResult paramConnectionResult)
  {
    if (!paramConnectionResult.isSuccess())
      zzb(paramLoader.getId(), paramConnectionResult);
  }

  public void zzet(int paramInt)
  {
    zzais.remove(paramInt);
    getLoaderManager().destroyLoader(paramInt);
  }

  public GoogleApiClient zzeu(int paramInt)
  {
    if (getActivity() != null)
    {
      zza localzza = zzev(paramInt);
      if (localzza != null)
        return localzza.zzaiu;
    }
    return null;
  }

  zza zzev(int paramInt)
  {
    try
    {
      zza localzza = (zza)getLoaderManager().getLoader(paramInt);
      return localzza;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new IllegalStateException("Unknown loader in SupportLoaderLifecycleFragment", localClassCastException);
    }
  }

  static class zza extends Loader<ConnectionResult>
    implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener
  {
    private ConnectionResult zzaiA;
    public final GoogleApiClient zzaiu;
    private boolean zzaiz;

    public zza(Context paramContext, GoogleApiClient paramGoogleApiClient)
    {
      super();
      zzaiu = paramGoogleApiClient;
    }

    private void zzf(ConnectionResult paramConnectionResult)
    {
      zzaiA = paramConnectionResult;
      if ((isStarted()) && (!isAbandoned()))
        deliverResult(paramConnectionResult);
    }

    public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
    {
      super.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
      zzaiu.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }

    public void onConnected(Bundle paramBundle)
    {
      zzaiz = false;
      zzf(ConnectionResult.zzagb);
    }

    public void onConnectionFailed(ConnectionResult paramConnectionResult)
    {
      zzaiz = true;
      zzf(paramConnectionResult);
    }

    public void onConnectionSuspended(int paramInt)
    {
    }

    protected void onReset()
    {
      zzaiA = null;
      zzaiz = false;
      zzaiu.unregisterConnectionCallbacks(this);
      zzaiu.unregisterConnectionFailedListener(this);
      zzaiu.disconnect();
    }

    protected void onStartLoading()
    {
      super.onStartLoading();
      zzaiu.registerConnectionCallbacks(this);
      zzaiu.registerConnectionFailedListener(this);
      if (zzaiA != null)
        deliverResult(zzaiA);
      if ((!zzaiu.isConnected()) && (!zzaiu.isConnecting()) && (!zzaiz))
        zzaiu.connect();
    }

    protected void onStopLoading()
    {
      zzaiu.disconnect();
    }

    public boolean zzoY()
    {
      return zzaiz;
    }
  }

  private static class zzb
  {
    public final GoogleApiClient zzaiu;
    public final GoogleApiClient.OnConnectionFailedListener zzaiv;

    private zzb(GoogleApiClient paramGoogleApiClient, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      zzaiu = paramGoogleApiClient;
      zzaiv = paramOnConnectionFailedListener;
    }
  }

  private class zzc
    implements Runnable
  {
    private final int zzaix;
    private final ConnectionResult zzaiy;

    public zzc(int paramConnectionResult, ConnectionResult arg3)
    {
      zzaix = paramConnectionResult;
      Object localObject;
      zzaiy = localObject;
    }

    public void run()
    {
      if (zzaiy.hasResolution())
        try
        {
          int i = getActivity().getSupportFragmentManager().getFragments().indexOf(zzn.this);
          zzaiy.startResolutionForResult(getActivity(), (i + 1 << 16) + 1);
          return;
        }
        catch (IntentSender.SendIntentException localSendIntentException)
        {
          zzn.zza(zzn.this);
          return;
        }
      if (GooglePlayServicesUtil.isUserRecoverableError(zzaiy.getErrorCode()))
      {
        GooglePlayServicesUtil.showErrorDialogFragment(zzaiy.getErrorCode(), getActivity(), zzn.this, 2, zzn.this);
        return;
      }
      zzn.zza(zzn.this, zzaix, zzaiy);
    }
  }
}