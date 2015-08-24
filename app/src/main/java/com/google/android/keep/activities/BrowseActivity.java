package com.google.android.keep.activities;

import android.accounts.Account;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.view.ActionMode;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import com.google.android.gsf.GservicesValue;
import com.google.android.keep.O;
import com.google.android.keep.binder.Binder;
import com.google.android.keep.browse.m;
import com.google.android.keep.model.A;
import com.google.android.keep.model.C;
import com.google.android.keep.model.D;
import com.google.android.keep.model.Label;
import com.google.android.keep.model.TreeEntity.TreeEntityType;
import com.google.android.keep.model.TreeEntityModel;
import com.google.android.keep.model.i;
import com.google.android.keep.model.l;
import com.google.android.keep.model.n;
import com.google.android.keep.model.s;
import com.google.android.keep.model.t;
import com.google.android.keep.model.x;
import com.google.android.keep.navigation.BrowseNavigationRequest;
import com.google.android.keep.navigation.EditorNavigationRequest;
import com.google.android.keep.navigation.EditorNavigationRequest.a;
import com.google.android.keep.navigation.FilterBrowseNavigationRequest;
import com.google.android.keep.navigation.NavigationManager;
import com.google.android.keep.navigation.NavigationManager.NavigationMode;
import com.google.android.keep.navigation.NavigationRequest;
import com.google.android.keep.service.InitializationService;
import com.google.android.keep.ui.b.b;
import com.google.android.keep.ui.c;
import com.google.android.keep.util.Config;
import com.google.android.keep.util.e;
import com.google.android.keep.util.o;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;

public class BrowseActivity extends a
  implements b.b
{
  private NavigationManager cQ;
  private com.google.android.keep.browse.a cR;
  private com.google.android.keep.service.a cS;

  private void a(Intent paramIntent)
  {
    cR.d(paramIntent.getBooleanExtra("isKeyguard", false));
    if (paramIntent.hasExtra("authAccount"))
      o.m(this, paramIntent.getStringExtra("authAccount"));
    if (paramIntent.hasExtra("com.google.android.keep.intent.extra.SHOW_REQUEST_ACCESS"))
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("server_node_id", paramIntent.getStringExtra("com.google.android.keep.intent.extra.SHOW_REQUEST_ACCESS"));
      m localm = new m();
      localm.setArguments((Bundle)localObject);
      localm.show(getSupportFragmentManager(), m.class.getSimpleName());
    }
    Object localObject = b(paramIntent);
    if (localObject != null)
    {
      if ((R() == ((NavigationRequest)localObject).ka()) && (!(localObject instanceof FilterBrowseNavigationRequest)) && (!(localObject instanceof EditorNavigationRequest)))
        return;
      c(((NavigationRequest)localObject).ka());
      if ((localObject instanceof EditorNavigationRequest))
      {
        cQ.a(this, NavigationRequest.l(NavigationManager.NavigationMode.AM));
        cR.b((EditorNavigationRequest)localObject);
        return;
      }
      cQ.a(this, (NavigationRequest)localObject);
      return;
    }
    c(NavigationManager.NavigationMode.AM);
    com.google.android.keep.util.r.e("Keep", "Null request for intent " + paramIntent, new Object[0]);
  }

  private void a(Uri paramUri, EditorNavigationRequest.a parama)
  {
    if (paramUri == null)
      try
      {
        throw new FileNotFoundException("Uri is null.");
      }
      catch (FileNotFoundException parama)
      {
        com.google.android.keep.util.r.e("Keep", "File not found for " + paramUri, new Object[0]);
        e.b(this, 2131231197);
        return;
      }
    String str = e.e(getContentResolver(), paramUri);
    if (str.startsWith("image/"))
    {
      parama.j(paramUri);
      return;
    }
    if (str.startsWith("audio/"))
    {
      parama.k(paramUri);
      return;
    }
    e.b(this, 2131231197);
  }

  private NavigationRequest b(Intent paramIntent)
  {
    if (paramIntent == null)
      throw new IllegalArgumentException("Can't have null intent");
    Object localObject = paramIntent.getAction();
    if ("android.intent.action.SEARCH".equals(localObject))
    {
      com.google.android.keep.util.r.a("Keep", "This is a search intent", new Object[0]);
      localObject = paramIntent.getStringExtra("search_filter_type");
      paramIntent = paramIntent.getStringExtra("android.intent.extra.SUBJECT");
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals(Integer.toString(1))))
      {
        localObject = new FilterBrowseNavigationRequest(NavigationManager.NavigationMode.AM, 1);
        if (!TextUtils.isEmpty(paramIntent))
          ((FilterBrowseNavigationRequest)localObject).ax(paramIntent);
        return localObject;
      }
      return new BrowseNavigationRequest(NavigationManager.NavigationMode.AM);
    }
    if ("com.google.android.keep.intent.action.NAVIGATION".equals(localObject))
    {
      com.google.android.keep.util.r.a("Keep", "This is a navigation intent", new Object[0]);
      return NavigationRequest.l(NavigationManager.NavigationMode.values()[paramIntent.getIntExtra("com.google.android.keep.intent.extra.NAVIGATION_MODE", 0)]);
    }
    if (("android.intent.action.INSERT".equals(localObject)) || ("android.intent.action.SEND".equals(localObject)) || ("android.intent.action.SEND_MULTIPLE".equals(localObject)))
      return c(paramIntent);
    if ("android.intent.action.VIEW".equals(localObject))
      return c(paramIntent.getExtras());
    return NavigationRequest.l(NavigationManager.NavigationMode.AM);
  }

  private void b(Bundle paramBundle)
  {
    if (!F())
      return;
    if (paramBundle != null)
    {
      cQ.d(paramBundle);
      cR.d(paramBundle);
      return;
    }
    a(getIntent());
  }

  private NavigationRequest c(Intent paramIntent)
  {
    if (paramIntent == null)
      return null;
    EditorNavigationRequest.a locala = new EditorNavigationRequest.a().g(Long.valueOf(-1L)).ah(true);
    Bundle localBundle = paramIntent.getExtras();
    if (localBundle == null)
      locala.h(TreeEntity.TreeEntityType.zO);
    while (true)
    {
      return locala.jU();
      int i = localBundle.getInt("treeEntityType", -1);
      Object localObject;
      if (i != -1)
      {
        localObject = TreeEntity.TreeEntityType.bn(i);
        label74: locala.h((TreeEntity.TreeEntityType)localObject);
        i = localBundle.getInt("launchImmediately", -1);
        if (i != -1)
          locala.bt(i);
        if (paramIntent.hasExtra("android.intent.extra.SUBJECT"))
          locala.av(paramIntent.getStringExtra("android.intent.extra.SUBJECT"));
        if (paramIntent.hasExtra("android.intent.extra.TEXT"))
          locala.aw(paramIntent.getStringExtra("android.intent.extra.TEXT"));
        if (paramIntent.hasExtra("android.intent.extra.STREAM"))
        {
          localObject = paramIntent.getAction();
          if (!"android.intent.action.SEND".equals(localObject))
            break label223;
          a((Uri)paramIntent.getParcelableExtra("android.intent.extra.STREAM"), locala);
        }
      }
      while (true)
      {
        if (!paramIntent.hasExtra("share_screenshot_as_stream"))
          break label270;
        locala.j((Uri)paramIntent.getParcelableExtra("share_screenshot_as_stream"));
        break;
        localObject = TreeEntity.TreeEntityType.zO;
        break label74;
        label223: if ("android.intent.action.SEND_MULTIPLE".equals(localObject))
        {
          localObject = paramIntent.getParcelableArrayListExtra("android.intent.extra.STREAM").iterator();
          while (((Iterator)localObject).hasNext())
            a((Uri)((Iterator)localObject).next(), locala);
        }
      }
      label270: if (paramIntent.hasExtra("share_screenshot"))
      {
        paramIntent = paramIntent.getParcelableExtra("share_screenshot");
        if ((paramIntent instanceof Bitmap))
          locala.d((Bitmap)paramIntent);
        else
          com.google.android.keep.util.r.e("Keep", "Intent data is not bitmap" + paramIntent.toString(), new Object[0]);
      }
    }
  }

  private NavigationRequest c(Bundle paramBundle)
  {
    if (paramBundle == null)
      return NavigationRequest.l(NavigationManager.NavigationMode.AM);
    long l = paramBundle.getLong("treeEntityId", -1L);
    if (l != -1L)
    {
      com.google.android.keep.util.r.a("Keep", "Intent contains tree entity ID " + l, new Object[0]);
      EditorNavigationRequest.a locala = new EditorNavigationRequest.a().g(Long.valueOf(l)).ag(paramBundle.getBoolean("com.google.android.keep.intent.extra.HAS_CONFLICT", false));
      paramBundle = paramBundle.getString("com.google.android.keep.intent.action.PROPOSED_EMAIL_TO_ADD");
      if (!TextUtils.isEmpty(paramBundle))
      {
        locala.at(paramBundle);
        locala.bt(4);
      }
      return locala.jU();
    }
    paramBundle = paramBundle.getLongArray("com.google.android.keep.intent.extra.recent_reminder_ids");
    if ((paramBundle != null) && (paramBundle.length > 0))
      return NavigationRequest.a(NavigationManager.NavigationMode.AR, paramBundle);
    return NavigationRequest.l(NavigationManager.NavigationMode.AM);
  }

  protected void K()
  {
    I();
    a(getIntent());
  }

  protected String L()
  {
    return cR.L();
  }

  public void N()
  {
    super.N();
    a(2131230867, 2131230996, 2131231024, null);
    cR.e(true);
  }

  protected String S()
  {
    return getString(2131230841);
  }

  public void a(int paramInt1, int paramInt2, Parcelable paramParcelable)
  {
  }

  public void a(Account paramAccount)
  {
    if (b(paramAccount))
    {
      cR.aW();
      c(NavigationManager.NavigationMode.AM);
    }
    super.a(paramAccount);
    if (cS != null)
      cS.c(cL);
  }

  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    cQ = new NavigationManager(getSupportFragmentManager());
    cR = new com.google.android.keep.browse.a(this, cQ);
    dm.a(s.class, new t(this, sc));
    dm.a(com.google.android.keep.browse.a.class, cR);
    dm.a(com.google.android.keep.db.a.class, new com.google.android.keep.db.a(this));
    dm.a(x.class, new x(this, sc));
    dm.a(com.google.android.keep.model.r.class, new com.google.android.keep.model.r(this, sc));
    dm.a(C.class, new C(this, sc));
    dm.a(TreeEntityModel.class, new TreeEntityModel(this, sc));
    dm.a(n.class, new n(this, sc));
    dm.a(i.class, new i(this, sc));
    dm.a(D.class, new D(this, sc));
    dm.a(com.google.android.keep.model.a.class, new com.google.android.keep.model.a(this, sc));
    dm.a(A.class, new A(this, sc));
    dm.a(l.class, new l(this, sc));
    dm.a(c.class, new c(this, sc));
    dm.a(O.class, new O(this, sc, cQ));
  }

  public void a(NavigationManager.NavigationMode paramNavigationMode)
  {
    if (b(paramNavigationMode))
      cR.aU();
    super.a(paramNavigationMode);
  }

  public void a(NavigationManager.NavigationMode paramNavigationMode, Label paramLabel)
  {
    if (!paramLabel.equals(cR.aV()));
    for (int i = 1; ; i = 0)
    {
      if ((b(paramNavigationMode)) || (i != 0))
      {
        cR.aU();
        if (i != 0)
        {
          cR.a(paramLabel);
          a(2131230867, 2131230909, 2131231019, null);
        }
      }
      super.a(paramNavigationMode);
      return;
    }
  }

  public void onBackPressed()
  {
    if (!cR.onBackPressed())
      super.onBackPressed();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    b(paramBundle);
    InitializationService.z(this);
    if (KeepApplication.ar())
      getDelegate().setHandleNativeActionModesEnabled(false);
  }

  public void onDrawerClosed(View paramView)
  {
    super.onDrawerClosed(paramView);
    cR.e(R());
  }

  public void onDrawerOpened(View paramView)
  {
    super.onDrawerOpened(paramView);
    cR.onDrawerOpened();
  }

  public void onDrawerStateChanged(int paramInt)
  {
    super.onDrawerStateChanged(paramInt);
    cR.aT();
  }

  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool2 = cR.onKeyUp(paramInt, paramKeyEvent);
    boolean bool1 = bool2;
    if (!bool2)
      bool1 = super.onKeyUp(paramInt, paramKeyEvent);
    return bool1;
  }

  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if ("android.intent.action.MAIN".equals(paramIntent.getAction()))
      return;
    a(paramIntent);
  }

  protected void onPause()
  {
    super.onPause();
    if (cS != null)
      LocalBroadcastManager.getInstance(this).unregisterReceiver(cS);
  }

  protected void onResume()
  {
    super.onResume();
    if (((Boolean)Config.Po.get()).booleanValue())
    {
      cS = new com.google.android.keep.service.a(this, cL);
      LocalBroadcastManager.getInstance(this).registerReceiver(cS, new IntentFilter("com.google.android.keep.intent.action.NOTE_TO_GOOGLE_DOC"));
    }
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    cQ.e(paramBundle);
    cR.e(paramBundle);
  }

  protected void onSetContentView()
  {
    setContentView(2130968607);
  }

  @TargetApi(21)
  public void onSupportActionModeFinished(ActionMode paramActionMode)
  {
    super.onSupportActionModeFinished(paramActionMode);
    e.a(this, getResources().getColor(17170445));
  }

  @TargetApi(21)
  public void onSupportActionModeStarted(ActionMode paramActionMode)
  {
    super.onSupportActionModeStarted(paramActionMode);
    e.a(this, getResources().getColor(2131296395));
  }

  public void r(int paramInt)
  {
    super.r(paramInt);
    switch (paramInt)
    {
    default:
      throw new IllegalStateException("Unknown header button clicked " + paramInt);
    case 2131493152:
    }
    a(2131230867, 2131230995, 2131231024, null);
    cR.e(false);
  }
}