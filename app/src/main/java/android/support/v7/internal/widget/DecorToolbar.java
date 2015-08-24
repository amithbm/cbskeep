package android.support.v7.internal.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.internal.view.menu.MenuBuilder.Callback;
import android.support.v7.internal.view.menu.MenuPresenter.Callback;
import android.view.Menu;
import android.view.ViewGroup;
import android.view.Window.Callback;

public abstract interface DecorToolbar
{
  public abstract void animateToVisibility(int paramInt);

  public abstract boolean canShowOverflowMenu();

  public abstract void collapseActionView();

  public abstract void dismissPopupMenus();

  public abstract Context getContext();

  public abstract int getDisplayOptions();

  public abstract Menu getMenu();

  public abstract int getNavigationMode();

  public abstract ViewGroup getViewGroup();

  public abstract boolean hasExpandedActionView();

  public abstract boolean hideOverflowMenu();

  public abstract void initIndeterminateProgress();

  public abstract void initProgress();

  public abstract boolean isOverflowMenuShowPending();

  public abstract boolean isOverflowMenuShowing();

  public abstract boolean isSplit();

  public abstract void setCollapsible(boolean paramBoolean);

  public abstract void setDisplayOptions(int paramInt);

  public abstract void setEmbeddedTabView(ScrollingTabContainerView paramScrollingTabContainerView);

  public abstract void setHomeButtonEnabled(boolean paramBoolean);

  public abstract void setLogo(Drawable paramDrawable);

  public abstract void setMenu(Menu paramMenu, MenuPresenter.Callback paramCallback);

  public abstract void setMenuCallbacks(MenuPresenter.Callback paramCallback, MenuBuilder.Callback paramCallback1);

  public abstract void setMenuPrepared();

  public abstract void setNavigationContentDescription(int paramInt);

  public abstract void setNavigationIcon(Drawable paramDrawable);

  public abstract void setSubtitle(CharSequence paramCharSequence);

  public abstract void setTitle(CharSequence paramCharSequence);

  public abstract void setVisibility(int paramInt);

  public abstract void setWindowCallback(Window.Callback paramCallback);

  public abstract void setWindowTitle(CharSequence paramCharSequence);

  public abstract boolean showOverflowMenu();
}