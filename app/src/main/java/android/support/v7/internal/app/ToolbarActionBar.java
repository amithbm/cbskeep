package android.support.v7.internal.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.OnMenuVisibilityListener;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.layout;
import android.support.v7.appcompat.R.style;
import android.support.v7.internal.view.WindowCallbackWrapper;
import android.support.v7.internal.view.menu.ListMenuPresenter;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuBuilder.Callback;
import android.support.v7.internal.view.menu.MenuPresenter.Callback;
import android.support.v7.internal.widget.DecorToolbar;
import android.support.v7.internal.widget.ToolbarWidgetWrapper;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.Toolbar.OnMenuItemClickListener;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window.Callback;
import android.widget.ListAdapter;
import java.util.ArrayList;

public class ToolbarActionBar extends ActionBar
{
  private DecorToolbar mDecorToolbar;
  private boolean mLastMenuVisibility;
  private ListMenuPresenter mListMenuPresenter;
  private boolean mMenuCallbackSet;
  private final Toolbar.OnMenuItemClickListener mMenuClicker = new Toolbar.OnMenuItemClickListener()
  {
    public boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
    {
      return mWindowCallback.onMenuItemSelected(0, paramAnonymousMenuItem);
    }
  };
  private final Runnable mMenuInvalidator = new Runnable()
  {
    public void run()
    {
      populateOptionsMenu();
    }
  };
  private ArrayList<ActionBar.OnMenuVisibilityListener> mMenuVisibilityListeners = new ArrayList();
  private boolean mToolbarMenuPrepared;
  private Window.Callback mWindowCallback;

  public ToolbarActionBar(Toolbar paramToolbar, CharSequence paramCharSequence, Window.Callback paramCallback)
  {
    mDecorToolbar = new ToolbarWidgetWrapper(paramToolbar, false);
    mWindowCallback = new ToolbarCallbackWrapper(paramCallback);
    mDecorToolbar.setWindowCallback(mWindowCallback);
    paramToolbar.setOnMenuItemClickListener(mMenuClicker);
    mDecorToolbar.setWindowTitle(paramCharSequence);
  }

  private void ensureListMenuPresenter(Menu paramMenu)
  {
    Object localObject;
    Resources.Theme localTheme;
    if ((mListMenuPresenter == null) && ((paramMenu instanceof MenuBuilder)))
    {
      paramMenu = (MenuBuilder)paramMenu;
      localObject = mDecorToolbar.getContext();
      TypedValue localTypedValue = new TypedValue();
      localTheme = ((Context)localObject).getResources().newTheme();
      localTheme.setTo(((Context)localObject).getTheme());
      localTheme.resolveAttribute(R.attr.actionBarPopupTheme, localTypedValue, true);
      if (localTypedValue.resourceId != 0)
        localTheme.applyStyle(localTypedValue.resourceId, true);
      localTheme.resolveAttribute(R.attr.panelMenuListTheme, localTypedValue, true);
      if (localTypedValue.resourceId == 0)
        break label170;
      localTheme.applyStyle(localTypedValue.resourceId, true);
    }
    while (true)
    {
      localObject = new ContextThemeWrapper((Context)localObject, 0);
      ((Context)localObject).getTheme().setTo(localTheme);
      mListMenuPresenter = new ListMenuPresenter((Context)localObject, R.layout.abc_list_menu_item_layout);
      mListMenuPresenter.setCallback(new PanelMenuPresenterCallback(null));
      paramMenu.addMenuPresenter(mListMenuPresenter);
      return;
      label170: localTheme.applyStyle(R.style.Theme_AppCompat_CompactMenu, true);
    }
  }

  private View getListMenuView(Menu paramMenu)
  {
    ensureListMenuPresenter(paramMenu);
    if ((paramMenu == null) || (mListMenuPresenter == null));
    while (mListMenuPresenter.getAdapter().getCount() <= 0)
      return null;
    return (View)mListMenuPresenter.getMenuView(mDecorToolbar.getViewGroup());
  }

  private Menu getMenu()
  {
    if (!mMenuCallbackSet)
    {
      mDecorToolbar.setMenuCallbacks(new ActionMenuPresenterCallback(null), new MenuBuilderCallback(null));
      mMenuCallbackSet = true;
    }
    return mDecorToolbar.getMenu();
  }

  public void addOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener paramOnMenuVisibilityListener)
  {
    mMenuVisibilityListeners.add(paramOnMenuVisibilityListener);
  }

  public boolean collapseActionView()
  {
    if (mDecorToolbar.hasExpandedActionView())
    {
      mDecorToolbar.collapseActionView();
      return true;
    }
    return false;
  }

  public void dispatchMenuVisibilityChanged(boolean paramBoolean)
  {
    if (paramBoolean == mLastMenuVisibility);
    while (true)
    {
      return;
      mLastMenuVisibility = paramBoolean;
      int j = mMenuVisibilityListeners.size();
      int i = 0;
      while (i < j)
      {
        ((ActionBar.OnMenuVisibilityListener)mMenuVisibilityListeners.get(i)).onMenuVisibilityChanged(paramBoolean);
        i += 1;
      }
    }
  }

  public int getDisplayOptions()
  {
    return mDecorToolbar.getDisplayOptions();
  }

  public Context getThemedContext()
  {
    return mDecorToolbar.getContext();
  }

  public Window.Callback getWrappedWindowCallback()
  {
    return mWindowCallback;
  }

  public void hide()
  {
    mDecorToolbar.setVisibility(8);
  }

  public boolean invalidateOptionsMenu()
  {
    mDecorToolbar.getViewGroup().removeCallbacks(mMenuInvalidator);
    ViewCompat.postOnAnimation(mDecorToolbar.getViewGroup(), mMenuInvalidator);
    return true;
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
  }

  public boolean onKeyShortcut(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    Menu localMenu = getMenu();
    if (localMenu != null)
      bool = localMenu.performShortcut(paramInt, paramKeyEvent, 0);
    return bool;
  }

  void populateOptionsMenu()
  {
    MenuBuilder localMenuBuilder = null;
    Menu localMenu = getMenu();
    if ((localMenu instanceof MenuBuilder))
      localMenuBuilder = (MenuBuilder)localMenu;
    if (localMenuBuilder != null)
      localMenuBuilder.stopDispatchingItemsChanged();
    try
    {
      localMenu.clear();
      if ((!mWindowCallback.onCreatePanelMenu(0, localMenu)) || (!mWindowCallback.onPreparePanel(0, null, localMenu)))
        localMenu.clear();
      return;
    }
    finally
    {
      if (localMenuBuilder != null)
        localMenuBuilder.startDispatchingItemsChanged();
    }
  }

  public void setDefaultDisplayHomeAsUpEnabled(boolean paramBoolean)
  {
  }

  public void setDisplayHomeAsUpEnabled(boolean paramBoolean)
  {
    if (paramBoolean);
    for (int i = 4; ; i = 0)
    {
      setDisplayOptions(i, 4);
      return;
    }
  }

  public void setDisplayOptions(int paramInt1, int paramInt2)
  {
    int i = mDecorToolbar.getDisplayOptions();
    mDecorToolbar.setDisplayOptions(paramInt1 & paramInt2 | (paramInt2 ^ 0xFFFFFFFF) & i);
  }

  public void setElevation(float paramFloat)
  {
    ViewCompat.setElevation(mDecorToolbar.getViewGroup(), paramFloat);
  }

  public void setHomeActionContentDescription(int paramInt)
  {
    mDecorToolbar.setNavigationContentDescription(paramInt);
  }

  public void setHomeAsUpIndicator(Drawable paramDrawable)
  {
    mDecorToolbar.setNavigationIcon(paramDrawable);
  }

  public void setHomeButtonEnabled(boolean paramBoolean)
  {
  }

  public void setLogo(Drawable paramDrawable)
  {
    mDecorToolbar.setLogo(paramDrawable);
  }

  public void setShowHideAnimationEnabled(boolean paramBoolean)
  {
  }

  public void setSubtitle(CharSequence paramCharSequence)
  {
    mDecorToolbar.setSubtitle(paramCharSequence);
  }

  public void setTitle(CharSequence paramCharSequence)
  {
    mDecorToolbar.setTitle(paramCharSequence);
  }

  public void setWindowTitle(CharSequence paramCharSequence)
  {
    mDecorToolbar.setWindowTitle(paramCharSequence);
  }

  public void show()
  {
    mDecorToolbar.setVisibility(0);
  }

  private final class ActionMenuPresenterCallback
    implements MenuPresenter.Callback
  {
    private boolean mClosingActionMenu;

    private ActionMenuPresenterCallback()
    {
    }

    public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
    {
      if (mClosingActionMenu)
        return;
      mClosingActionMenu = true;
      mDecorToolbar.dismissPopupMenus();
      if (mWindowCallback != null)
        mWindowCallback.onPanelClosed(8, paramMenuBuilder);
      mClosingActionMenu = false;
    }

    public boolean onOpenSubMenu(MenuBuilder paramMenuBuilder)
    {
      if (mWindowCallback != null)
      {
        mWindowCallback.onMenuOpened(8, paramMenuBuilder);
        return true;
      }
      return false;
    }
  }

  private final class MenuBuilderCallback
    implements MenuBuilder.Callback
  {
    private MenuBuilderCallback()
    {
    }

    public boolean onMenuItemSelected(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem)
    {
      return false;
    }

    public void onMenuModeChange(MenuBuilder paramMenuBuilder)
    {
      if (mWindowCallback != null)
      {
        if (!mDecorToolbar.isOverflowMenuShowing())
          break label41;
        mWindowCallback.onPanelClosed(8, paramMenuBuilder);
      }
      label41: 
      while (!mWindowCallback.onPreparePanel(0, null, paramMenuBuilder))
        return;
      mWindowCallback.onMenuOpened(8, paramMenuBuilder);
    }
  }

  private final class PanelMenuPresenterCallback
    implements MenuPresenter.Callback
  {
    private PanelMenuPresenterCallback()
    {
    }

    public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
    {
      if (mWindowCallback != null)
        mWindowCallback.onPanelClosed(0, paramMenuBuilder);
    }

    public boolean onOpenSubMenu(MenuBuilder paramMenuBuilder)
    {
      if ((paramMenuBuilder == null) && (mWindowCallback != null))
        mWindowCallback.onMenuOpened(0, paramMenuBuilder);
      return true;
    }
  }

  private class ToolbarCallbackWrapper extends WindowCallbackWrapper
  {
    public ToolbarCallbackWrapper(Window.Callback arg2)
    {
      super();
    }

    public View onCreatePanelView(int paramInt)
    {
      switch (paramInt)
      {
      default:
      case 0:
      }
      Menu localMenu;
      do
      {
        return super.onCreatePanelView(paramInt);
        localMenu = mDecorToolbar.getMenu();
      }
      while ((!onPreparePanel(paramInt, null, localMenu)) || (!onMenuOpened(paramInt, localMenu)));
      return ToolbarActionBar.this.getListMenuView(localMenu);
    }

    public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
    {
      boolean bool = super.onPreparePanel(paramInt, paramView, paramMenu);
      if ((bool) && (!mToolbarMenuPrepared))
      {
        mDecorToolbar.setMenuPrepared();
        ToolbarActionBar.access$202(ToolbarActionBar.this, true);
      }
      return bool;
    }
  }
}