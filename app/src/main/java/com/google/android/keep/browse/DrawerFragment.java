package com.google.android.keep.browse;

import android.accounts.Account;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import android.widget.ListView;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.people.Graph;
import com.google.android.gms.people.Graph.LoadOwnersOptions;
import com.google.android.gms.people.Graph.LoadOwnersResult;
import com.google.android.gms.people.Notifications;
import com.google.android.gms.people.Notifications.OnDataChanged;
import com.google.android.gms.people.People;
import com.google.android.gms.people.accountswitcherview.OwnersAvatarManager;
import com.google.android.gms.people.accountswitcherview.OwnersListAdapter;
import com.google.android.gms.people.accountswitcherview.ScrimDrawable;
import com.google.android.gms.people.accountswitcherview.SelectedAccountNavigationView;
import com.google.android.gms.people.accountswitcherview.SelectedAccountNavigationView.AccountChangeListener;
import com.google.android.gms.people.accountswitcherview.SelectedAccountNavigationView.NavigationModeChangeListener;
import com.google.android.gms.people.model.Owner;
import com.google.android.gms.people.model.OwnerBuffer;
import com.google.android.keep.activities.KeepApplication;
import com.google.android.keep.activities.a;
import com.google.android.keep.e;
import com.google.android.keep.model.Label;
import com.google.android.keep.navigation.NavigationManager.NavigationMode;
import com.google.android.keep.ui.g;
import com.google.android.keep.ui.g.h;
import com.google.android.keep.util.o;
import com.google.android.keep.util.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DrawerFragment extends e
  implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, Notifications.OnDataChanged, SelectedAccountNavigationView.AccountChangeListener, SelectedAccountNavigationView.NavigationModeChangeListener
{
  private static final String TAG = DrawerFragment.class.getSimpleName();
  private static final String gf = TAG + "_navigationMode";
  private static final String gg = TAG + "selected_label";
  private NavigationManager.NavigationMode cM = NavigationManager.NavigationMode.AL;
  private GoogleApiClient gh;
  private OwnersAvatarManager gi;
  private g gj;
  private b gk;
  private ListView gl;
  private SelectedAccountNavigationView gm;
  private OwnerBuffer gn;
  private a go = null;
  private Dialog gp;
  private com.google.android.keep.model.j gq;
  private final g.h gr = new g.h()
  {
    public void H(int paramAnonymousInt)
    {
      NavigationManager.NavigationMode localNavigationMode;
      switch (paramAnonymousInt)
      {
      case 2131492878:
      default:
        throw new IllegalStateException("Unknown landing page id " + paramAnonymousInt);
      case 2131492876:
        localNavigationMode = NavigationManager.NavigationMode.AM;
      case 2131492879:
      case 2131492877:
      case 2131492880:
      }
      while (true)
      {
        DrawerFragment.a(DrawerFragment.this, localNavigationMode);
        return;
        localNavigationMode = NavigationManager.NavigationMode.AP;
        continue;
        localNavigationMode = NavigationManager.NavigationMode.AN;
        continue;
        localNavigationMode = NavigationManager.NavigationMode.AQ;
      }
    }

    public void I(int paramAnonymousInt)
    {
      if (DrawerFragment.b(DrawerFragment.this) == null)
        return;
      switch (paramAnonymousInt)
      {
      default:
        throw new IllegalStateException("Unknown link page id " + paramAnonymousInt);
      case 2131493153:
      }
      DrawerFragment.b(DrawerFragment.this).M();
    }

    public void J(int paramAnonymousInt)
    {
      DrawerFragment.b(DrawerFragment.this).r(paramAnonymousInt);
    }

    public void K(int paramAnonymousInt)
    {
      DrawerFragment.b(DrawerFragment.this).N();
    }

    public void a(int paramAnonymousInt, Label paramAnonymousLabel)
    {
      switch (paramAnonymousInt)
      {
      default:
        throw new IllegalStateException("Unknown label entry id " + paramAnonymousInt);
      case 2131492878:
      }
      NavigationManager.NavigationMode localNavigationMode = NavigationManager.NavigationMode.AO;
      DrawerFragment.a(DrawerFragment.this, localNavigationMode, paramAnonymousLabel);
    }
  };
  private ScrimDrawable mScrimDrawable;

  private void a(OwnerBuffer paramOwnerBuffer)
  {
    if (!isAdded())
      return;
    ArrayList localArrayList = new ArrayList();
    Object localObject = paramOwnerBuffer.iterator();
    while (((Iterator)localObject).hasNext())
      localArrayList.add((Owner)((Iterator)localObject).next());
    localObject = d(localArrayList);
    Owner[] arrayOfOwner = a(localArrayList, (Owner)localObject);
    gm.setRecents(arrayOfOwner[0], arrayOfOwner[1]);
    if (localObject != null)
      gm.bind((Owner)localObject);
    if (gk == null)
    {
      gk = new b(getActivity(), null);
      gk.setAvatarManager(gi);
    }
    gk.setOwners(localArrayList);
    if (gn != null)
      gn.close();
    gn = paramOwnerBuffer;
  }

  private Owner[] a(List<Owner> paramList, Owner paramOwner)
  {
    Owner[] arrayOfOwner = new Owner[2];
    int i = 0;
    paramList = paramList.iterator();
    int j;
    do
    {
      Owner localOwner;
      do
      {
        if (!paramList.hasNext())
          break;
        localOwner = (Owner)paramList.next();
      }
      while (localOwner == paramOwner);
      j = i;
      if (i < 2)
      {
        arrayOfOwner[i] = localOwner;
        j = i + 1;
      }
      i = j;
    }
    while (j != 2);
    return arrayOfOwner;
  }

  private void b(NavigationManager.NavigationMode paramNavigationMode, Label paramLabel)
  {
    h(paramNavigationMode);
    if (go != null)
    {
      if ((paramNavigationMode == NavigationManager.NavigationMode.AO) && (paramLabel != null))
        go.a(paramNavigationMode, paramLabel);
    }
    else
      return;
    go.a(cM);
  }

  private void ca()
  {
    if (!gh.isConnected())
      return;
    Graph.LoadOwnersOptions localLoadOwnersOptions = new Graph.LoadOwnersOptions().setIncludePlusPages(false);
    People.GraphApi.loadOwners(gh, localLoadOwnersOptions).setResultCallback(new ResultCallback()
    {
      public void a(Graph.LoadOwnersResult paramAnonymousLoadOwnersResult)
      {
        if (paramAnonymousLoadOwnersResult.getStatus().isSuccess())
        {
          DrawerFragment.a(DrawerFragment.this, paramAnonymousLoadOwnersResult.getOwners());
          return;
        }
        r.b(DrawerFragment.cb(), "Failed to load accounts for account switcher.", new Object[0]);
      }
    });
  }

  private Owner d(List<Owner> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Owner localOwner = (Owner)localIterator.next();
      if ((gq != null) && (TextUtils.equals(localOwner.getAccountName(), gq.getName())))
        return localOwner;
    }
    if (!paramList.isEmpty())
      return (Owner)paramList.get(0);
    return null;
  }

  private void i(NavigationManager.NavigationMode paramNavigationMode)
  {
    b(paramNavigationMode, null);
  }

  protected String S()
  {
    return getString(2131230852);
  }

  public void bZ()
  {
    gm.setNavigationMode(0);
    onNavigationModeChange(gm);
  }

  public void h(NavigationManager.NavigationMode paramNavigationMode)
  {
    cM = paramNavigationMode;
    if (gj != null)
      gj.q(paramNavigationMode);
  }

  public void onAccountChange(Owner paramOwner)
  {
    gk.setSelectedOwner(paramOwner);
    gm.bind(paramOwner);
    gq = o.m(getActivity(), paramOwner.getAccountName());
    bZ();
    if (go != null)
      go.a(new Account(paramOwner.getAccountName(), "com.google"));
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if (paramBundle != null)
      h(NavigationManager.NavigationMode.values()[paramBundle.getInt(gf)]);
  }

  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if ((paramActivity instanceof a))
      go = ((a)paramActivity);
    if ((paramActivity instanceof a))
      ((a)paramActivity).a(this);
    gq = o.O(paramActivity);
  }

  public void onConnected(Bundle paramBundle)
  {
    ca();
    People.NotificationApi.registerOnDataChangedListenerForAllOwners(gh, this, 1);
  }

  public void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity == null);
    do
    {
      return;
      r.d(TAG, "Client connection failure: " + paramConnectionResult, new Object[0]);
      gp = GooglePlayServicesUtil.getErrorDialog(paramConnectionResult.getErrorCode(), localFragmentActivity, 0, new DialogInterface.OnCancelListener()
      {
        public void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
        }
      });
      if (gp != null)
      {
        gp.show();
        return;
      }
    }
    while (!paramConnectionResult.hasResolution());
    try
    {
      paramConnectionResult.startResolutionForResult(localFragmentActivity, 1);
      return;
    }
    catch (IntentSender.SendIntentException paramConnectionResult)
    {
      gh.connect();
    }
  }

  public void onConnectionSuspended(int paramInt)
  {
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getActivity();
    gh = com.google.android.keep.util.j.M(paramBundle).addConnectionCallbacks(this).addOnConnectionFailedListener(this).build();
    gi = new OwnersAvatarManager(paramBundle, gh);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130968659, null);
    gl = ((ListView)paramLayoutInflater.findViewById(2131493150));
    paramViewGroup = paramLayoutInflater.findViewById(2131493149);
    if (KeepApplication.ap())
    {
      FrameLayout localFrameLayout = (FrameLayout)paramViewGroup;
      localFrameLayout.setFitsSystemWindows(true);
      localFrameLayout.setOnApplyWindowInsetsListener(new c(null));
      localFrameLayout.setForegroundGravity(55);
      mScrimDrawable = new ScrimDrawable();
      localFrameLayout.setForeground(mScrimDrawable);
    }
    paramViewGroup.setFitsSystemWindows(true);
    gm = new SelectedAccountNavigationView(getActivity(), null);
    gm.setForceFullHeight(true);
    gm.setClient(gh);
    gm.setAvatarManager(gi);
    gm.setOnAccountChangeListener(this);
    gm.setOnNavigationModeChange(this);
    gm.setNavigationMode(0);
    gj = new g(getActivity(), se);
    gj.q(cM);
    gj.a(gr);
    if (paramBundle != null)
    {
      paramViewGroup = (Label)paramBundle.getParcelable(gg);
      gj.d(paramViewGroup);
    }
    gl.addHeaderView(gm);
    gl.setAdapter(gj);
    return paramLayoutInflater;
  }

  public void onDataChanged(String paramString1, String paramString2, int paramInt)
  {
    ca();
  }

  public void onDestroy()
  {
    if (gi != null)
    {
      gi.close();
      gi = null;
    }
    if (gk != null)
    {
      gk.disconnect();
      gk.setBuffer(null);
    }
    super.onDestroy();
    if (gn != null)
    {
      gn.close();
      gn = null;
    }
  }

  public void onDetach()
  {
    super.onDetach();
    go = null;
  }

  public void onNavigationModeChange(SelectedAccountNavigationView paramSelectedAccountNavigationView)
  {
    int i = paramSelectedAccountNavigationView.getNavigationMode();
    if (i == 0)
      gl.setAdapter(gj);
    while (i != 1)
      return;
    gl.setAdapter(gk);
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putInt(gf, cM.ordinal());
    paramBundle.putParcelable(gg, gj.md());
  }

  public void onStart()
  {
    super.onStart();
    com.google.android.keep.util.j.d(gh);
  }

  public void onStop()
  {
    com.google.android.keep.util.j.e(gh);
    gm.bind(null);
    super.onStop();
  }

  public static abstract interface a
  {
    public abstract void M();

    public abstract void N();

    public abstract void a(Account paramAccount);

    public abstract void a(NavigationManager.NavigationMode paramNavigationMode);

    public abstract void a(NavigationManager.NavigationMode paramNavigationMode, Label paramLabel);

    public abstract void r(int paramInt);
  }

  private class b extends OwnersListAdapter
  {
    private b(Context arg2)
    {
      super();
    }

    public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      paramView = super.getView(paramInt, paramView, paramViewGroup);
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          switch (getItemViewType(paramInt))
          {
          default:
            return;
          case 0:
            onAccountChange(getItem(paramInt));
            return;
          case 2:
            startActivity(new Intent("android.settings.SYNC_SETTINGS"));
            return;
          case 1:
          }
          startActivity(new Intent("android.settings.ADD_ACCOUNT_SETTINGS"));
        }
      });
      return paramView;
    }
  }

  @TargetApi(20)
  private class c
    implements View.OnApplyWindowInsetsListener
  {
    private c()
    {
    }

    public WindowInsets onApplyWindowInsets(View paramView, WindowInsets paramWindowInsets)
    {
      int i = paramWindowInsets.getSystemWindowInsetTop();
      DrawerFragment.c(DrawerFragment.this).setIntrinsicHeight(i);
      DrawerFragment.d(DrawerFragment.this).applyTopInset(i);
      return paramWindowInsets;
    }
  }
}