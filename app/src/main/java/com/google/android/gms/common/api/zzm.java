package com.google.android.gms.common.api;

import android.app.PendingIntent;
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
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzv;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

public class zzm extends Fragment
  implements DialogInterface.OnCancelListener
{
  private boolean mStarted;
  private boolean zzaio;
  private int zzaip = -1;
  private ConnectionResult zzaiq;
  private final Handler zzair = new Handler(Looper.getMainLooper());
  private final SparseArray<zza> zzais = new SparseArray();

  public static zzm zza(FragmentActivity paramFragmentActivity)
  {
    zzv.zzbT("Must be called from main thread of process");
    FragmentManager localFragmentManager = paramFragmentActivity.getSupportFragmentManager();
    try
    {
      zzm localzzm = (zzm)localFragmentManager.findFragmentByTag("GmsSupportLifecycleFragment");
      if (localzzm != null)
      {
        paramFragmentActivity = localzzm;
        if (!localzzm.isRemoving());
      }
      else
      {
        paramFragmentActivity = new zzm();
        localFragmentManager.beginTransaction().add(paramFragmentActivity, "GmsSupportLifecycleFragment").commit();
        localFragmentManager.executePendingTransactions();
      }
      return paramFragmentActivity;
    }
    catch (ClassCastException paramFragmentActivity)
    {
    }
    throw new IllegalStateException("Fragment with tag GmsSupportLifecycleFragment is not a SupportLifecycleFragment", paramFragmentActivity);
  }

  private void zza(int paramInt, ConnectionResult paramConnectionResult)
  {
    Log.w("GmsSupportLifecycleFragment", "Unresolved error while connecting client. Stopping auto-manage.");
    Object localObject = (zza)zzais.get(paramInt);
    if (localObject != null)
    {
      zzet(paramInt);
      localObject = ((zza)localObject).zzaiv;
      if (localObject != null)
        ((GoogleApiClient.OnConnectionFailedListener)localObject).onConnectionFailed(paramConnectionResult);
    }
    zzoW();
  }

  private void zzoW()
  {
    zzaio = false;
    zzaip = -1;
    zzaiq = null;
    int i = 0;
    while (i < zzais.size())
    {
      ((zza)zzais.valueAt(i)).zzaiu.connect();
      i += 1;
    }
  }

  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    super.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    int i = 0;
    while (i < zzais.size())
    {
      ((zza)zzais.valueAt(i)).dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
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
    mStarted = true;
    if (!zzaio)
    {
      int i = 0;
      while (i < zzais.size())
      {
        ((zza)zzais.valueAt(i)).zzaiu.connect();
        i += 1;
      }
    }
  }

  public void onStop()
  {
    super.onStop();
    mStarted = false;
    int i = 0;
    while (i < zzais.size())
    {
      ((zza)zzais.valueAt(i)).zzaiu.disconnect();
      i += 1;
    }
  }

  public void zza(int paramInt, GoogleApiClient paramGoogleApiClient, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    zzv.zzb(paramGoogleApiClient, "GoogleApiClient instance cannot be null");
    if (zzais.indexOfKey(paramInt) < 0);
    for (boolean bool = true; ; bool = false)
    {
      zzv.zza(bool, "Already managing a GoogleApiClient with id " + paramInt);
      paramOnConnectionFailedListener = new zza(paramInt, paramGoogleApiClient, paramOnConnectionFailedListener);
      zzais.put(paramInt, paramOnConnectionFailedListener);
      if ((mStarted) && (!zzaio))
        paramGoogleApiClient.connect();
      return;
    }
  }

  public void zzet(int paramInt)
  {
    zza localzza = (zza)zzais.get(paramInt);
    zzais.remove(paramInt);
    if (localzza != null)
      localzza.zzoX();
  }

  private class zza
    implements GoogleApiClient.OnConnectionFailedListener
  {
    public final int zzait;
    public final GoogleApiClient zzaiu;
    public final GoogleApiClient.OnConnectionFailedListener zzaiv;

    public zza(int paramGoogleApiClient, GoogleApiClient paramOnConnectionFailedListener, GoogleApiClient.OnConnectionFailedListener arg4)
    {
      zzait = paramGoogleApiClient;
      zzaiu = paramOnConnectionFailedListener;
      Object localObject;
      zzaiv = localObject;
      paramOnConnectionFailedListener.registerConnectionFailedListener(this);
    }

    public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
    {
      paramPrintWriter.append(paramString).append("GoogleApiClient #").print(zzait);
      paramPrintWriter.println(":");
      zzaiu.dump(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }

    public void onConnectionFailed(ConnectionResult paramConnectionResult)
    {
      zzm.zzd(zzm.this).post(new zzm.zzb(zzm.this, zzait, paramConnectionResult));
    }

    public void zzoX()
    {
      zzaiu.unregisterConnectionFailedListener(this);
      zzaiu.disconnect();
    }
  }

  private class zzb
    implements Runnable
  {
    private final int zzaix;
    private final ConnectionResult zzaiy;

    public zzb(int paramConnectionResult, ConnectionResult arg3)
    {
      zzaix = paramConnectionResult;
      Object localObject;
      zzaiy = localObject;
    }

    public void run()
    {
      if ((!zzm.zza(zzm.this)) || (zzm.zzb(zzm.this)))
        return;
      zzm.zza(zzm.this, true);
      zzm.zza(zzm.this, zzaix);
      zzm.zza(zzm.this, zzaiy);
      if (zzaiy.hasResolution())
        try
        {
          int i = getActivity().getSupportFragmentManager().getFragments().indexOf(zzm.this);
          zzaiy.startResolutionForResult(getActivity(), (i + 1 << 16) + 1);
          return;
        }
        catch (IntentSender.SendIntentException localSendIntentException)
        {
          zzm.zzc(zzm.this);
          return;
        }
      if (GooglePlayServicesUtil.isUserRecoverableError(zzaiy.getErrorCode()))
      {
        GooglePlayServicesUtil.showErrorDialogFragment(zzaiy.getErrorCode(), getActivity(), zzm.this, 2, zzm.this);
        return;
      }
      zzm.zza(zzm.this, zzaix, zzaiy);
    }
  }
}