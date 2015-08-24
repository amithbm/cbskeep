package com.google.android.keep.sharing;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveFile.InitializeRealtimeDocumentListener;
import com.google.android.gms.drive.DriveFile.RealtimeLoadResult;
import com.google.android.gms.drive.DriveFirstPartyApi;
import com.google.android.gms.drive.realtime.Model;
import com.google.android.keep.activities.KeepApplication;
import com.google.android.keep.binder.Binder;
import com.google.android.keep.model.ModelEventDispatcher;
import com.google.android.keep.model.s;
import com.google.android.keep.model.x;
import com.google.android.keep.p;
import com.google.android.keep.q.i;
import com.google.android.keep.util.e;
import com.google.android.keep.util.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class d extends ModelEventDispatcher
  implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, DriveFile.InitializeRealtimeDocumentListener, q.i, com.google.android.keep.r
{
  private String EL;
  private boolean EM;
  private x EN;
  private boolean EO = true;
  private final ResultCallback<DriveFile.RealtimeLoadResult> EP = new ResultCallback()
  {
    public void a(DriveFile.RealtimeLoadResult paramAnonymousRealtimeLoadResult)
    {
      Status localStatus = paramAnonymousRealtimeLoadResult.getStatus();
      if (localStatus.isSuccess())
      {
        com.google.android.keep.util.r.a("RealtimeDocumentLoader", "loading shared note succeeded: " + System.currentTimeMillis(), new Object[0]);
        if (!e.isFragmentActive(d.a(d.this)))
        {
          d.b(d.this);
          return;
        }
        paramAnonymousRealtimeLoadResult = paramAnonymousRealtimeLoadResult.getRealtimeDocument();
        try
        {
          d.c(d.this).a(paramAnonymousRealtimeLoadResult);
          KeepApplication.av().put(KeepApplication.d(d.d(d.this)), paramAnonymousRealtimeLoadResult);
          return;
        }
        catch (IllegalStateException paramAnonymousRealtimeLoadResult)
        {
          com.google.android.keep.util.r.e("RealtimeDocumentLoader", "IllegalStateException: " + paramAnonymousRealtimeLoadResult.getMessage(), new Object[0]);
          if (d.e(d.this))
          {
            d.f(d.this);
            d.g(d.this);
            d.a(d.this, false);
          }
          d.h(d.this).a(2131230867, 2131230981, 2131231022, null);
          return;
        }
      }
      com.google.android.keep.util.r.e("RealtimeDocumentLoader", "loading shared note failed: " + localStatus.getStatusCode() + ", message: " + localStatus.getStatusMessage(), new Object[0]);
      d.h(d.this).a(2131230867, 2131230980, 2131231022, null);
    }
  };
  private com.google.android.keep.model.j fr;
  private GoogleApiClient gh;
  private s hb;
  private final Activity mActivity;
  private final Fragment mParentFragment;

  public d(Fragment paramFragment, p paramp)
  {
    mParentFragment = paramFragment;
    mActivity = paramFragment.getActivity();
    fr = o.O(mActivity);
    EN = ((x)Binder.a(mActivity, x.class));
    hb = ((s)Binder.a(mActivity, s.class));
    paramp.b(this);
  }

  private void kR()
  {
    kV();
    gh = com.google.android.keep.util.j.i(mActivity, fr.getName()).addConnectionCallbacks(this).addOnConnectionFailedListener(this).build();
  }

  private void kS()
  {
    if (gh == null)
      kR();
    com.google.android.keep.util.r.a("RealtimeDocumentLoader", "GoogleApiClient starts to connect: " + System.currentTimeMillis(), new Object[0]);
    com.google.android.keep.util.j.d(gh);
  }

  private void kU()
  {
    com.google.android.keep.util.j.e(gh);
    com.google.android.keep.util.r.a("RealtimeDocumentLoader", "GoogleApiClient disconnected in RealtimeDocumentLoader", new Object[0]);
  }

  private void kV()
  {
    if (gh != null)
    {
      kU();
      gh.unregisterConnectionCallbacks(this);
      gh.unregisterConnectionFailedListener(this);
      gh = null;
    }
  }

  public void b(String paramString, boolean paramBoolean)
  {
    EL = paramString;
    EM = paramBoolean;
  }

  public boolean kP()
  {
    return !TextUtils.isEmpty(EL);
  }

  public void kQ()
  {
    EN.ac(EM);
    kS();
  }

  public void kT()
  {
    KeepApplication.av().remove(KeepApplication.d(EL));
    EN.iZ();
    if (!EN.iT())
      kV();
  }

  public void onConnected(Bundle paramBundle)
  {
    com.google.android.keep.util.r.a("RealtimeDocumentLoader", "GoogleApiClient connected: " + System.currentTimeMillis(), new Object[0]);
    Drive.DriveApi.loadRealtimeDocumentFromResourceId(gh, EL, this, null).setResultCallback(EP);
  }

  public void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    com.google.android.keep.util.r.e("RealtimeDocumentLoader", "GoogleApiClient failed: " + paramConnectionResult.getErrorCode(), new Object[0]);
    if (!paramConnectionResult.hasResolution())
      GooglePlayServicesUtil.showErrorDialogFragment(paramConnectionResult.getErrorCode(), mActivity, 0);
  }

  public void onConnectionSuspended(int paramInt)
  {
    com.google.android.keep.util.r.a("RealtimeDocumentLoader", "GoogleApiClient connections suspended: " + paramInt, new Object[0]);
  }

  public void onInitialize(Model paramModel)
  {
    if ((mActivity == null) || (!e.isFragmentActive(mParentFragment)))
    {
      if (gh != null)
      {
        Drive.DriveFirstPartyApi.requestRealtimeDocumentSync(gh, new ArrayList(), Collections.singletonList(EL));
        kV();
      }
      return;
    }
    EN.a(paramModel, true);
  }

  public void onStop()
  {
    kT();
  }
}