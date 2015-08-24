package com.google.android.keep.editor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuBuilder.Callback;
import android.support.v7.internal.view.menu.MenuPresenter.Callback;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.Toolbar.OnMenuItemClickListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.common.base.Preconditions;
import com.google.android.gsf.GservicesValue;
import com.google.android.keep.binder.Binder;
import com.google.android.keep.browse.SingleSelectDialogFragment.OptionItem;
import com.google.android.keep.browse.SingleSelectDialogFragment.a;
import com.google.android.keep.browse.SingleSelectDialogFragment.b;
import com.google.android.keep.model.C;
import com.google.android.keep.model.ColorMap;
import com.google.android.keep.model.ColorMap.ColorPair;
import com.google.android.keep.model.ListItem;
import com.google.android.keep.model.ModelEventDispatcher.EventType;
import com.google.android.keep.model.ModelEventDispatcher.a;
import com.google.android.keep.model.ModelEventDispatcher.b;
import com.google.android.keep.model.TreeEntity.TreeEntityType;
import com.google.android.keep.model.TreeEntityModel;
import com.google.android.keep.model.h;
import com.google.android.keep.model.j;
import com.google.android.keep.model.l;
import com.google.android.keep.model.n;
import com.google.android.keep.model.p;
import com.google.android.keep.model.s;
import com.google.android.keep.navigation.EditorNavigationRequest;
import com.google.android.keep.navigation.EditorNavigationRequest.a;
import com.google.android.keep.navigation.NavigationManager.NavigationMode;
import com.google.android.keep.provider.MediaStore.FileValidationException;
import com.google.android.keep.provider.g;
import com.google.android.keep.service.DocsExportService;
import com.google.android.keep.task.TaskHelper;
import com.google.android.keep.task.TaskHelper.ErrorCode;
import com.google.android.keep.task.TaskHelper.a;
import com.google.android.keep.toasts.ToastListener.b;
import com.google.android.keep.toasts.ToastListener.f;
import com.google.android.keep.toasts.ToastsFragment;
import com.google.android.keep.ui.b.b;
import com.google.android.keep.util.Config;
import com.google.android.keep.util.d;
import com.google.android.keep.util.o;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class EditorToolbarFragment extends p
  implements MenuBuilder.Callback, MenuPresenter.Callback, Toolbar.OnMenuItemClickListener, SingleSelectDialogFragment.b, com.google.android.keep.colorpicker.b.a, ModelEventDispatcher.b, com.google.android.keep.navigation.a.a, b.b
{
  private static final String TAG = EditorToolbarFragment.class.getSimpleName();
  private static final List<ModelEventDispatcher.EventType> fD = Arrays.asList(new ModelEventDispatcher.EventType[] { ModelEventDispatcher.EventType.wF, ModelEventDispatcher.EventType.xe, ModelEventDispatcher.EventType.xd, ModelEventDispatcher.EventType.xh, ModelEventDispatcher.EventType.xf, ModelEventDispatcher.EventType.xo, ModelEventDispatcher.EventType.xn, ModelEventDispatcher.EventType.xg, ModelEventDispatcher.EventType.wL, ModelEventDispatcher.EventType.wK, ModelEventDispatcher.EventType.wO });
  private static final String lR = TAG + ".mLastRequestImageUri";
  private com.google.android.keep.browse.a cR;
  private com.google.android.keep.navigation.a et;
  private final TaskHelper.a<Long> fE = new TaskHelper.a()
  {
    public void a(TaskHelper.ErrorCode paramAnonymousErrorCode)
    {
      if ((getActivity() == null) || (!isAdded()))
        return;
      com.google.android.keep.util.e.b(getActivity(), 2131231200);
    }

    public void a(Long paramAnonymousLong)
    {
      if ((getActivity() == null) || (!isAdded()))
        return;
      paramAnonymousLong = new EditorNavigationRequest.a().g(paramAnonymousLong).jU();
      EditorToolbarFragment.b(EditorToolbarFragment.this).a(paramAnonymousLong, 2131231064);
    }
  };
  private l fh;
  private j fr;
  private boolean fu;
  private s hb;
  private TreeEntityModel kJ;
  private com.google.android.keep.model.i lM;
  private com.google.android.keep.model.r lN;
  private com.google.android.keep.db.a lO;
  private SingleSelectDialogFragment.OptionItem[] lP;
  private Uri lQ;
  private n la;
  private C ly;
  private Toolbar mToolbar;

  private void a(int paramInt, Parcelable paramParcelable)
  {
    switch (paramInt)
    {
    default:
      return;
    case 4:
      z(true);
      com.google.android.keep.util.a.b(mToolbar, getResources().getString(2131231087));
      return;
    case 2:
      dK();
      return;
    case 3:
    }
    dL();
  }

  private void a(Uri paramUri, ImageSource paramImageSource)
  {
    if (paramUri == null)
      com.google.android.keep.util.r.e(TAG, "No URI provided for adding an image.", new Object[0]);
    while (true)
    {
      return;
      try
      {
        if (paramImageSource == ImageSource.lT)
        {
          paramUri = g.d(getActivity(), fr.getId(), paramUri);
          if (paramUri == null)
            continue;
          lM.c(paramUri);
          return;
        }
      }
      catch (IOException paramUri)
      {
        while (true)
        {
          com.google.android.keep.util.r.e(TAG, "Failed to add image", new Object[] { paramUri });
          return;
          paramUri = g.c(getActivity(), fr.getId(), paramUri);
        }
      }
      catch (MediaStore.FileValidationException paramUri)
      {
        label55: break label55;
      }
    }
  }

  private void a(ColorMap.ColorPair paramColorPair, boolean paramBoolean)
  {
    if (paramBoolean)
      et.by(2130837620);
    while (true)
    {
      cR.aI();
      return;
      et.bx(ColorMap.K(paramColorPair.getKey()).intValue());
    }
  }

  private void al(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return;
    case 4:
    }
    z(false);
    com.google.android.keep.util.a.b(mToolbar, getResources().getString(2131231086));
  }

  private void b(Menu paramMenu, int paramInt, boolean paramBoolean)
  {
    paramMenu = paramMenu.findItem(paramInt);
    if (paramMenu != null)
      paramMenu.setVisible(paramBoolean);
  }

  private void d(Bundle paramBundle)
  {
    lQ = ((Uri)paramBundle.getParcelable(lR));
  }

  private void dE()
  {
    com.google.android.keep.util.e.a(mToolbar.getMenu());
  }

  private void dF()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (!com.google.android.keep.util.e.a(localFragmentActivity))
    {
      com.google.android.keep.util.e.b(localFragmentActivity, 2131231307);
      return;
    }
    hb.n(2131230891, 2131231008);
    com.google.android.keep.util.e.c(getActivity(), 2131231309);
    ((com.google.android.keep.db.a)Binder.a(localFragmentActivity, com.google.android.keep.db.a.class)).a(new com.google.android.keep.db.a.a().u(false));
    Intent localIntent = new Intent(localFragmentActivity, DocsExportService.class);
    localIntent.putExtra("authAccount", fr.getName());
    localIntent.putExtra("treeEntityIds", new long[] { dP() });
    localFragmentActivity.startService(localIntent);
  }

  private void dH()
  {
    la.hH();
    kJ.g(TreeEntity.TreeEntityType.zP);
    hb.n(2131230910, 2131231008);
  }

  private ToastsFragment dI()
  {
    return (ToastsFragment)com.google.android.keep.util.e.a(getActivity(), 2131493048);
  }

  private void dJ()
  {
    hb.n(2131230883, 2131231008);
    cR.a(com.google.android.keep.util.e.h(Long.valueOf(dP())));
  }

  private void dK()
  {
    hb.n(2131230882, 2131231008);
    cR.a(fr, com.google.android.keep.util.e.h(kJ));
  }

  private void dL()
  {
    hb.n(2131230989, 2131231008);
    cR.a(Arrays.asList(new Long[] { Long.valueOf(dP()) }), fr.hl());
  }

  private void dM()
  {
    hb.n(2131230886, 2131231008);
    cR.a(com.google.android.keep.util.e.h(kJ), true);
  }

  private void dN()
  {
    hb.n(2131230885, 2131231008);
    cR.a(com.google.android.keep.util.e.h(kJ), false);
  }

  private void dO()
  {
    hb.n(2131230884, 2131231008);
    ToastListener.f localf = new ToastListener.f(getActivity(), com.google.android.keep.util.e.h(Long.valueOf(dP())), null);
    dI().a(localf);
  }

  private long dP()
  {
    return kJ.dP();
  }

  private void delete()
  {
    if (kJ.js())
    {
      new com.google.android.keep.ui.b.a(this, 2).bO(2131231179).bP(2131231075).show();
      return;
    }
    if (ly.ip())
    {
      if (kJ.iD());
      for (int i = 2131231185; ; i = 2131231183)
      {
        new com.google.android.keep.ui.b.a(this, 3).bN(2131231181).bO(i).bP(2131231075).show();
        return;
      }
    }
    dJ();
  }

  private void z(boolean paramBoolean)
  {
    la.b(paramBoolean, false);
    kJ.g(TreeEntity.TreeEntityType.zO);
    hb.n(2131230911, 2131231008);
  }

  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    default:
    case 4:
    case 5:
    }
    do
    {
      do
        return;
      while (paramInt2 != -1);
      a(lQ, ImageSource.lT);
      return;
    }
    while (paramInt2 != -1);
    a(paramIntent.getData(), ImageSource.lU);
  }

  public void a(int paramInt1, int paramInt2, Parcelable paramParcelable)
  {
    if (paramInt2 == 1)
      a(paramInt1, paramParcelable);
    while (paramInt2 != 2)
      return;
    al(paramInt1);
  }

  public void a(long paramLong, String paramString, boolean paramBoolean)
  {
    cR.a(paramLong, true, paramString, paramBoolean);
  }

  public void a(ModelEventDispatcher.a parama)
  {
    if (!ih())
      return;
    dG();
  }

  protected boolean aB()
  {
    return false;
  }

  public List<ModelEventDispatcher.EventType> bI()
  {
    return fD;
  }

  public void bq()
  {
    getActivity().onBackPressed();
  }

  public void br()
  {
    throw new UnsupportedOperationException();
  }

  public void bs()
  {
    throw new UnsupportedOperationException();
  }

  public void dG()
  {
    ColorMap.ColorPair localColorPair = kJ.iz();
    if (!lM.isEmpty());
    for (boolean bool = true; ; bool = false)
    {
      a(localColorPair, bool);
      invalidateOptionsMenu();
      return;
    }
  }

  public void g(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 5);
    switch (lP[paramInt2].icon)
    {
    default:
      return;
    case 2130837672:
      hb.n(2131230898, 2131231008);
      lQ = cR.t(4);
      return;
    case 2130837683:
    }
    hb.n(2131230899, 2131231008);
    cR.u(5);
  }

  public void h(String paramString)
  {
    throw new UnsupportedOperationException();
  }

  public void invalidateOptionsMenu()
  {
    Menu localMenu = et.ki();
    if (!ih())
    {
      com.google.android.keep.util.e.a(localMenu);
      return;
    }
    boolean bool4 = kJ.iP();
    boolean bool1 = lN.iL();
    boolean bool3 = cR.aK();
    boolean bool5 = kJ.js();
    label94: label120: int i;
    if ((!kJ.jx()) && (!bool5) && (!bool1))
    {
      bool1 = true;
      if ((!bool1) || (kJ.jr()))
        break label505;
      bool2 = true;
      b(localMenu, 2131493425, bool2);
      if ((!bool1) || (!kJ.jr()))
        break label510;
      bool2 = true;
      b(localMenu, 2131493426, bool2);
      b(localMenu, 2131493427, bool5);
      MenuItem localMenuItem = localMenu.findItem(2131493423);
      if (localMenuItem != null)
      {
        localMenuItem.setVisible(bool1);
        if (fh.v(kJ.getId()).size() <= 0)
          break label515;
        i = 2131231368;
        label191: localMenuItem.setTitle(i);
      }
      b(localMenu, 2131493128, bool1);
      b(localMenu, 2131493429, bool1);
      if ((!bool1) || (!lM.hb()))
        break label522;
      bool2 = true;
      label236: b(localMenu, 2131493431, bool2);
      if ((!bool1) || (bool5) || (bool3))
        break label527;
      bool2 = true;
      label262: b(localMenu, 2131493430, bool2);
      if ((!((Boolean)Config.Po.get()).booleanValue()) || (!bool1))
        break label532;
      bool2 = true;
      label293: b(localMenu, 2131493437, bool2);
      localMenuItem = localMenu.findItem(2131493428);
      if (localMenuItem != null)
      {
        b(localMenu, 2131493428, bool1);
        if (!bool5)
          break label537;
        i = 2131231078;
        label339: localMenuItem.setTitle(i);
        if (!bool5)
          break label544;
        i = 0;
        label355: localMenuItem.setShowAsAction(i);
      }
      if (!bool3)
        break label549;
      b(localMenu, 2131493438, bool1);
      label378: if ((!bool1) || (!bool4))
        break label562;
      bool2 = true;
      label389: if (la.hB().size() <= 0)
        break label567;
      i = 1;
      label404: b(localMenu, 2131493436, bool2);
      if ((!bool2) || (i == 0))
        break label572;
      bool3 = true;
      label425: b(localMenu, 2131493432, bool3);
      b(localMenu, 2131493435, bool2);
      if ((!bool1) || (bool4))
        break label578;
      bool3 = true;
      label458: b(localMenu, 2131493434, bool3);
      if ((!bool2) || (i == 0))
        break label584;
    }
    label515: label522: label527: label532: label537: label544: label549: label562: label567: label572: label578: label584: for (boolean bool2 = true; ; bool2 = false)
    {
      b(localMenu, 2131493433, bool2);
      b(localMenu, 2131493422, bool1);
      return;
      bool1 = false;
      break;
      label505: bool2 = false;
      break label94;
      label510: bool2 = false;
      break label120;
      i = 2131231369;
      break label191;
      bool2 = false;
      break label236;
      bool2 = false;
      break label262;
      bool2 = false;
      break label293;
      i = 2131231075;
      break label339;
      i = 1;
      break label355;
      b(localMenu, 2131493424, bool1);
      break label378;
      bool2 = false;
      break label389;
      i = 0;
      break label404;
      bool3 = false;
      break label425;
      bool3 = false;
      break label458;
    }
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    boolean bool = true;
    super.onActivityCreated(paramBundle);
    lP = new SingleSelectDialogFragment.OptionItem[] { new SingleSelectDialogFragment.OptionItem(getResources().getString(2131231053), 2130837672), new SingleSelectDialogFragment.OptionItem(getResources().getString(2131231054), 2130837683) };
    et = new com.google.android.keep.navigation.a(getActivity(), mToolbar);
    et.a(this);
    et.a(getActivity(), NavigationManager.NavigationMode.AS);
    Binder localBinder = Binder.g(getActivity());
    hb = ((s)localBinder.a(s.class));
    lO = ((com.google.android.keep.db.a)localBinder.a(com.google.android.keep.db.a.class));
    dE();
    lM = ((com.google.android.keep.model.i)e(com.google.android.keep.model.i.class));
    la = ((n)e(n.class));
    lN = ((com.google.android.keep.model.r)e(com.google.android.keep.model.r.class));
    kJ = ((TreeEntityModel)e(TreeEntityModel.class));
    ly = ((C)e(C.class));
    fh = ((l)e(l.class));
    if (paramBundle != null)
      d(paramBundle);
    if (kJ.isInitialized())
    {
      if ((lM.isInitialized()) && (!lM.isEmpty()));
      while (true)
      {
        a(kJ.iz(), bool);
        return;
        bool = false;
      }
    }
    a(cR.aM().iz(), false);
  }

  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    if (fu)
    {
      fu = false;
      hb.a(2131230867, 2131230920, 2131231008, null);
    }
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    mToolbar = ((Toolbar)paramLayoutInflater.inflate(2130968701, paramViewGroup, false));
    fr = o.O(getActivity());
    cR = ((com.google.android.keep.browse.a)Binder.a(getActivity(), com.google.android.keep.browse.a.class));
    mToolbar.setMenuCallbacks(this, this);
    mToolbar.setOnMenuItemClickListener(this);
    paramLayoutInflater = mToolbar;
    if (cR.aK());
    for (int i = 2131820547; ; i = 2131820545)
    {
      paramLayoutInflater.inflateMenu(i);
      return mToolbar;
    }
  }

  public boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default:
      return false;
    case 2131493422:
      hb.a(2131230867, 2131230979, 2131231008, null);
      a(kJ.dP(), null, true);
      return true;
    case 2131493128:
      hb.n(2131230900, 2131231008);
      d.a(kJ.iz().getValue(), this);
      return true;
    case 2131493424:
      hb.n(2131230897, 2131231008);
      new SingleSelectDialogFragment.a(this, 5).o(getResources().getString(2131231055)).a(lP).Y(2130968657).Z(2131493145).aa(2131492985).show();
      return true;
    case 2131493438:
      hb.n(2131230898, 2131231008);
      lQ = cR.t(4);
      return true;
    case 2131493425:
      dM();
      return true;
    case 2131493426:
      dN();
      return true;
    case 2131493428:
      delete();
      return true;
    case 2131493423:
      hb.n(2131230993, 2131231008);
      cR.c(new long[] { kJ.dP() });
      return true;
    case 2131493429:
      hb.n(2131230953, 2131231008);
      lO.a(new com.google.android.keep.db.a.a().u(false));
      TaskHelper.a(getActivity(), dP(), fE);
      return true;
    case 2131493434:
      dH();
      com.google.android.keep.util.a.b(mToolbar, getResources().getString(2131231083));
      return true;
    case 2131493435:
      Preconditions.checkArgument(kJ.iP());
      if (la.hE())
      {
        new com.google.android.keep.ui.b.a(this, 4).bO(2131231159).bP(2131231161).bQ(2131231160).show();
        return true;
      }
      z(true);
      com.google.android.keep.util.a.b(mToolbar, getResources().getString(2131231085));
      return true;
    case 2131493433:
      paramMenuItem = new ToastListener.b(getActivity(), la.hB());
      la.removeAll(la.hB());
      dI().a(paramMenuItem);
      return true;
    case 2131493432:
      paramMenuItem = la.hB().iterator();
      while (paramMenuItem.hasNext())
        ((ListItem)paramMenuItem.next()).R(false);
      hb.n(2131230912, 2131231008);
      return true;
    case 2131493431:
      lM.fX();
      return true;
    case 2131493430:
      new com.google.android.keep.task.e(getActivity(), dP())
      {
        protected void e(Intent paramAnonymousIntent)
        {
          if (paramAnonymousIntent != null)
          {
            startActivity(paramAnonymousIntent);
            EditorToolbarFragment.a(EditorToolbarFragment.this).n(2131230890, 2131231008);
          }
        }
      }
      .execute(new Void[0]);
      return true;
    case 2131493436:
      if (!kJ.iP())
        throw new IllegalStateException("Invalid TreeEntityType to call list settings " + kJ.ir());
      new i().show(getFragmentManager(), i.class.getName());
      hb.n(2131230914, 2131231008);
      return true;
    case 2131493427:
      dO();
      return true;
    case 2131493437:
    }
    dF();
    return true;
  }

  public boolean onMenuItemSelected(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem)
  {
    return false;
  }

  public void onMenuModeChange(MenuBuilder paramMenuBuilder)
  {
  }

  public boolean onOpenSubMenu(MenuBuilder paramMenuBuilder)
  {
    if (!fu)
    {
      fu = true;
      hb.a(2131230867, 2131230919, 2131231008, null);
    }
    return false;
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putParcelable(lR, lQ);
  }

  public void s(int paramInt)
  {
  }

  public void y(int paramInt)
  {
    kJ.a(ColorMap.aN(paramInt));
  }

  static enum ImageSource
  {
  }
}