package com.google.android.keep.activities;

import android.accounts.Account;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.support.v7.app.ActionBarDrawerToggle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.googlehelp.GoogleHelp;
import com.google.android.gms.googlehelp.GoogleHelpLauncher;
import com.google.android.keep.b;
import com.google.android.keep.browse.DrawerFragment;
import com.google.android.keep.browse.DrawerFragment.a;
import com.google.android.keep.model.Label;
import com.google.android.keep.model.j;
import com.google.android.keep.navigation.NavigationManager.NavigationMode;
import com.google.android.keep.util.e;
import com.google.android.keep.util.o;

public abstract class a extends b
  implements DrawerLayout.DrawerListener, DrawerFragment.a
{
  private boolean cF = false;
  private boolean cG = false;
  private boolean cH = true;
  private DrawerFragment cI;
  private View cJ;
  private ActionBarDrawerToggle cK;
  protected j cL;
  private NavigationManager.NavigationMode cM = NavigationManager.NavigationMode.AL;
  private final BroadcastReceiver cN = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if ("android.intent.action.SCREEN_OFF".equals(paramAnonymousIntent.getAction()))
        finish();
    }
  };
  private DrawerLayout mDrawerLayout;
  private Handler mHandler = new Handler();

  private void b(String paramString)
  {
    paramString = GoogleHelp.newInstance(paramString);
    if (cL != null)
      paramString.setGoogleAccount(cL.hl());
    paramString.setScreenshot(GoogleHelp.getScreenshot(this));
    paramString = paramString.buildHelpIntent(this);
    new GoogleHelpLauncher(this).launch(paramString);
  }

  private boolean b(boolean paramBoolean)
  {
    int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
    if (i == 0)
      return true;
    if (paramBoolean)
    {
      FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
      f(i, 2).show(localFragmentTransaction, "gmscore dialog");
      cG = true;
    }
    return false;
  }

  private boolean c(boolean paramBoolean)
  {
    if (o.O(this) != null)
      return true;
    if ((paramBoolean) && (!cF))
    {
      cF = true;
      startActivityForResult(o.c(null), 1);
    }
    return false;
  }

  private void d(NavigationManager.NavigationMode paramNavigationMode)
  {
    int i = 2131231020;
    switch (3.cP[paramNavigationMode.ordinal()])
    {
    default:
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    }
    while (true)
    {
      if (i != 2131231020)
        a(2131230867, i, 2131231019, null);
      return;
      i = 2131230904;
      continue;
      i = 2131230905;
      continue;
      i = 2131230906;
      continue;
      i = 2131230907;
      continue;
      i = 2131230908;
    }
  }

  private a f(int paramInt1, int paramInt2)
  {
    a locala = new a();
    Bundle localBundle = new Bundle();
    localBundle.putInt("errorCode", paramInt1);
    localBundle.putInt("requestCode", paramInt2);
    locala.setArguments(localBundle);
    return locala;
  }

  protected boolean F()
  {
    boolean bool = false;
    if (b(false))
      bool = c(false);
    return bool;
  }

  protected boolean G()
  {
    if (b(true))
      return c(true);
    return false;
  }

  public ActionBarDrawerToggle H()
  {
    return cK;
  }

  void I()
  {
    mDrawerLayout = ((DrawerLayout)findViewById(2131493038));
    mDrawerLayout.setDrawerListener(this);
    mDrawerLayout.setStatusBarBackground(17170445);
    mDrawerLayout.setDrawerShadow(2130837613, 3);
    cJ = findViewById(2131493049);
    cK = new ActionBarDrawerToggle(this, mDrawerLayout, 2131231132, 2131231133);
    cK.syncState();
  }

  protected void J()
  {
    Intent localIntent = getIntent();
    if (localIntent.hasExtra("authAccount"))
      o.m(this, localIntent.getStringExtra("authAccount"));
  }

  protected abstract void K();

  protected abstract String L();

  public void M()
  {
    mDrawerLayout.closeDrawer(cJ);
    mHandler.postDelayed(new Runnable()
    {
      public void run()
      {
        a.a(a.this, L());
        a(2131230867, 2131230915, 2131231019, null);
      }
    }
    , 250L);
  }

  public void N()
  {
    mDrawerLayout.closeDrawer(cJ);
  }

  public boolean O()
  {
    return mDrawerLayout.isDrawerOpen(cJ);
  }

  public void P()
  {
    mDrawerLayout.openDrawer(cJ);
  }

  protected void Q()
  {
    mDrawerLayout.closeDrawer(cJ);
  }

  protected NavigationManager.NavigationMode R()
  {
    return cM;
  }

  public void a(Account paramAccount)
  {
    if (b(paramAccount))
    {
      cL = o.b(this, paramAccount);
      mDrawerLayout.closeDrawer(cJ);
      a(2131230867, 2131230913, 2131231019, null);
    }
  }

  public void a(DrawerFragment paramDrawerFragment)
  {
    cI = paramDrawerFragment;
  }

  public void a(NavigationManager.NavigationMode paramNavigationMode)
  {
    if (b(paramNavigationMode))
    {
      cM = paramNavigationMode;
      d(paramNavigationMode);
    }
    mDrawerLayout.closeDrawer(cJ);
  }

  public void a(NavigationManager.NavigationMode paramNavigationMode, Label paramLabel)
  {
    a(paramNavigationMode);
  }

  protected boolean b(Account paramAccount)
  {
    return !paramAccount.name.equals(cL.getName());
  }

  protected boolean b(NavigationManager.NavigationMode paramNavigationMode)
  {
    return cM != paramNavigationMode;
  }

  public void c(NavigationManager.NavigationMode paramNavigationMode)
  {
    cM = paramNavigationMode;
    if (cI != null)
      cI.h(cM);
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1)
    {
      cF = false;
      if ((paramInt2 == -1) && (paramIntent != null) && (paramIntent.getExtras() != null))
      {
        String str = paramIntent.getExtras().getString("authAccount");
        paramIntent = paramIntent.getExtras().getString("accountType");
        if ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty(paramIntent)))
        {
          finish();
          return;
        }
        o.a(this, new Account(str, paramIntent));
        K();
        return;
      }
      finish();
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (cH)
      cK.onConfigurationChanged(paramConfiguration);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle == null)
      J();
    onSetContentView();
    if (!cH);
    do
    {
      return;
      if (F())
        I();
    }
    while (!getIntent().getBooleanExtra("isKeyguard", false));
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.intent.action.SCREEN_OFF");
    registerReceiver(cN, paramBundle);
    getWindow().addFlags(524288);
  }

  protected void onDestroy()
  {
    super.onDestroy();
    if (getIntent().getBooleanExtra("isKeyguard", false))
      unregisterReceiver(cN);
  }

  public void onDrawerClosed(View paramView)
  {
    cK.onDrawerClosed(paramView);
    cI.bZ();
    a(2131230867, 2131230922, 2131231019, null);
  }

  public void onDrawerOpened(View paramView)
  {
    cK.onDrawerOpened(paramView);
    a(2131230867, 2131230921, 2131231019, null);
    e.B(getCurrentFocus());
  }

  public void onDrawerSlide(View paramView, float paramFloat)
  {
    cK.onDrawerSlide(paramView, paramFloat);
  }

  public void onDrawerStateChanged(int paramInt)
  {
    cK.onDrawerStateChanged(paramInt);
  }

  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default:
    case 41:
    case 76:
    }
    do
    {
      do
        return super.onKeyUp(paramInt, paramKeyEvent);
      while (!paramKeyEvent.isCtrlPressed());
      if (O())
      {
        Q();
        return true;
      }
      P();
      return true;
    }
    while (!paramKeyEvent.isCtrlPressed());
    M();
    return true;
  }

  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    if (paramBundle != null)
    {
      cF = paramBundle.getBoolean("Keep_launchedAccountPicker", false);
      cM = NavigationManager.NavigationMode.values()[paramBundle.getInt("Keep_navMode", 0)];
    }
  }

  protected void onResume()
  {
    super.onResume();
    if ((G()) && (cG))
    {
      cG = false;
      K();
    }
    cL = o.O(this);
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("Keep_launchedAccountPicker", cF);
    paramBundle.putInt("Keep_navMode", cM.ordinal());
  }

  protected abstract void onSetContentView();

  public void q(int paramInt)
  {
    if (mDrawerLayout != null)
    {
      mDrawerLayout.setStatusBarBackgroundColor(paramInt);
      mDrawerLayout.invalidate();
      return;
    }
    e.a(this, paramInt);
  }

  public void r(int paramInt)
  {
    mDrawerLayout.closeDrawer(cJ);
  }

  public static final class a extends DialogFragment
  {
    public void onCancel(DialogInterface paramDialogInterface)
    {
      getActivity().finish();
    }

    public Dialog onCreateDialog(Bundle paramBundle)
    {
      paramBundle = getArguments();
      if (paramBundle == null)
        return null;
      return GooglePlayServicesUtil.getErrorDialog(paramBundle.getInt("errorCode"), getActivity(), paramBundle.getInt("requestCode"));
    }
  }
}