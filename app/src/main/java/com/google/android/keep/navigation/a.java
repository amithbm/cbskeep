package com.google.android.keep.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.google.android.keep.activities.KeepApplication;
import com.google.android.keep.ui.SearchFilterLayout;
import com.google.android.keep.util.e;
import com.google.android.keep.util.f;
import com.google.android.keep.util.f.a;

public class a
  implements f.a<String>
{
  private int AJ;
  private a AX;
  private NavigationManager.NavigationMode AY;
  private boolean AZ;
  private String Ba = null;
  private int Bb;
  private ColorDrawable Bc;
  private int Bd;
  private int Be;
  private int Bf;
  private int Bg;
  private int Bh;
  private ActionBarDrawerToggle cK;
  private SearchFilterLayout eH;
  protected final Context mContext;
  private Toolbar mToolbar;
  private final f<String> sx = new f(200, this);

  public a(Context paramContext, Toolbar paramToolbar)
  {
    this(paramContext, paramToolbar, null);
  }

  public a(Context paramContext, Toolbar paramToolbar, SearchFilterLayout paramSearchFilterLayout)
  {
    mContext = paramContext;
    mToolbar = paramToolbar;
    mToolbar.setNavigationOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (a.a(a.this) != null)
          a.a(a.this).bq();
      }
    });
    eH = paramSearchFilterLayout;
    if (eH != null)
      eH.b(this);
    Bd = mContext.getResources().getColor(2131296371);
    Be = mContext.getResources().getColor(2131296408);
    Bf = mContext.getResources().getColor(2131296407);
    Bg = mContext.getResources().getColor(2131296409);
    bx(Bf);
    Bh = mContext.getResources().getColor(2131296409);
  }

  private void kc()
  {
    mToolbar.setTitle(null);
    ke();
  }

  private void kd()
  {
    mToolbar.setTitle(mContext.getString(2131231287));
    bx(Bg);
    setStatusBarBackground(Bh);
    ke();
  }

  private void ke()
  {
    int i = 2130837668;
    boolean bool = KeepApplication.isLayoutRtl(mToolbar.getRootView());
    if (cK == null)
    {
      localObject = mToolbar;
      if (bool);
      while (true)
      {
        ((Toolbar)localObject).setNavigationIcon(i);
        mToolbar.setNavigationContentDescription(2131231293);
        return;
        i = 2130837666;
      }
    }
    Object localObject = cK;
    if (bool);
    while (true)
    {
      ((ActionBarDrawerToggle)localObject).setHomeAsUpIndicator(i);
      break;
      i = 2130837666;
    }
  }

  private void m(NavigationManager.NavigationMode paramNavigationMode)
  {
    mToolbar.setTitle(p(paramNavigationMode));
    if (cK == null)
    {
      mToolbar.setNavigationIcon(2130837708);
      mToolbar.setNavigationContentDescription(2131231132);
      MenuItem localMenuItem = mToolbar.getMenu().findItem(2131493415);
      if (localMenuItem != null)
        localMenuItem.setVisible(true);
      if (paramNavigationMode != NavigationManager.NavigationMode.AM)
        break label93;
    }
    label93: for (int i = Bd; ; i = Bf)
    {
      bx(i);
      return;
      cK.setHomeAsUpIndicator(2130837708);
      break;
    }
  }

  private void n(NavigationManager.NavigationMode paramNavigationMode)
  {
    mToolbar.setTitle(p(paramNavigationMode));
    if (cK == null)
      mToolbar.setNavigationIcon(2130837708);
    while (true)
    {
      mToolbar.setNavigationContentDescription(2131231132);
      bx(Bf);
      return;
      cK.setHomeAsUpIndicator(2130837708);
    }
  }

  private void o(NavigationManager.NavigationMode paramNavigationMode)
  {
    mToolbar.setTitle(p(paramNavigationMode));
    if (cK == null)
      mToolbar.setNavigationIcon(2130837708);
    while (true)
    {
      mToolbar.setNavigationContentDescription(2131231132);
      bx(Be);
      return;
      cK.setHomeAsUpIndicator(2130837708);
    }
  }

  public static int p(NavigationManager.NavigationMode paramNavigationMode)
  {
    switch (3.cP[paramNavigationMode.ordinal()])
    {
    default:
      return 2131231047;
    case 3:
      return 2131231126;
    case 4:
      return 2131231127;
    case 1:
      return 2131231130;
    case 2:
      return 2131231131;
    case 6:
      return 2131231128;
    case 5:
    }
    return 2131231129;
  }

  public void a(Activity paramActivity, NavigationManager.NavigationMode paramNavigationMode)
  {
    NavigationManager.NavigationMode localNavigationMode = AY;
    AY = paramNavigationMode;
    switch (3.cP[paramNavigationMode.ordinal()])
    {
    default:
      m(NavigationManager.NavigationMode.AM);
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    case 8:
    case 9:
    }
    while (true)
    {
      paramActivity.invalidateOptionsMenu();
      return;
      m(paramNavigationMode);
      if ((localNavigationMode == paramNavigationMode) && (AZ))
      {
        aj(true);
        if (AJ > 0)
        {
          bw(AJ);
          continue;
          n(paramNavigationMode);
          continue;
          o(paramNavigationMode);
          continue;
          kc();
          continue;
          kd();
        }
      }
    }
  }

  public void a(ActionBarDrawerToggle paramActionBarDrawerToggle)
  {
    if (paramActionBarDrawerToggle == null)
      return;
    cK = paramActionBarDrawerToggle;
    cK.setDrawerIndicatorEnabled(false);
    cK.setToolbarNavigationClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (a.a(a.this) != null)
          a.a(a.this).bq();
      }
    });
  }

  public void a(a parama)
  {
    AX = parama;
  }

  public void ai(boolean paramBoolean)
  {
    int i = 0;
    while (i < mToolbar.getChildCount())
    {
      View localView = mToolbar.getChildAt(i);
      if ((localView instanceof TextView))
      {
        localView.setFocusable(paramBoolean);
        localView.setFocusableInTouchMode(paramBoolean);
      }
      i += 1;
    }
  }

  public void aj(boolean paramBoolean)
  {
    if ((eH == null) || (eH.isShowing()))
      return;
    eH.show();
    if (!TextUtils.isEmpty(Ba))
    {
      eH.bt(Ba);
      Ba = null;
    }
    if (AX != null)
      AX.br();
    if (paramBoolean)
      eH.mz();
    com.google.android.keep.util.a.g(mToolbar, 4);
  }

  public void ax(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
      eH.bt(paramString);
    e.B(eH);
  }

  public void ay(String paramString)
  {
    mToolbar.setContentDescription(paramString);
  }

  public void bw(int paramInt)
  {
    if (!eH.isShowing())
      return;
    eH.bw(paramInt);
    AJ = paramInt;
  }

  public void bx(int paramInt)
  {
    Bb = Color.alpha(paramInt);
    Bc = new ColorDrawable(paramInt | 0xFF000000);
    Bc.setAlpha(Bb);
    mToolbar.setBackgroundDrawable(Bc);
  }

  public void by(int paramInt)
  {
    mToolbar.setBackgroundDrawable(mContext.getResources().getDrawable(paramInt));
  }

  public void d(Bundle paramBundle)
  {
    AZ = paramBundle.getBoolean("Keep_IsSearchViewOpened", false);
    Ba = paramBundle.getString("Keep_SearchQueryText", null);
  }

  public void e(Bundle paramBundle)
  {
    paramBundle.putBoolean("Keep_IsSearchViewOpened", kg());
    if (eH != null)
      paramBundle.putString("Keep_SearchQueryText", eH.getQuery());
  }

  public String jW()
  {
    if (eH == null)
      return null;
    return eH.getQuery();
  }

  public SearchFilterLayout kb()
  {
    return eH;
  }

  public void kf()
  {
    AZ = false;
    if ((eH == null) || (!eH.isShowing()))
      return;
    setStatusBarBackground(mContext.getResources().getColor(2131296371));
    eH.hide();
    eH.bt("");
    eH.mD();
    m(AY);
    if (AX != null)
      AX.bs();
    e.B(eH);
    com.google.android.keep.util.a.g(mToolbar, 0);
  }

  public boolean kg()
  {
    if (eH == null)
      return false;
    return eH.isShowing();
  }

  public void kh()
  {
    if (eH == null)
      return;
    eH.kh();
  }

  public Menu ki()
  {
    return mToolbar.getMenu();
  }

  public Toolbar kj()
  {
    return mToolbar;
  }

  public boolean onQueryTextChange(String paramString)
  {
    sx.i(paramString);
    return true;
  }

  public boolean onQueryTextSubmit(String paramString)
  {
    eH.kh();
    return true;
  }

  public void setStatusBarBackground(int paramInt)
  {
    if ((mContext instanceof com.google.android.keep.activities.a))
      ((com.google.android.keep.activities.a)mContext).q(paramInt);
  }

  public void setTitle(String paramString)
  {
    mToolbar.setTitle(paramString);
  }

  public void u(String paramString)
  {
    if (AX != null)
      AX.h(paramString);
  }

  public static abstract interface a
  {
    public abstract void bq();

    public abstract void br();

    public abstract void bs();

    public abstract void h(String paramString);
  }
}