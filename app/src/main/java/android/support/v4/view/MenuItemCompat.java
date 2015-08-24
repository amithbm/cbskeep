package android.support.v4.view;

import android.os.Build.VERSION;
import android.support.v4.internal.view.SupportMenuItem;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

public class MenuItemCompat
{
  static final MenuVersionImpl IMPL = new BaseMenuVersionImpl();

  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 14)
    {
      IMPL = new IcsMenuVersionImpl();
      return;
    }
    if (i >= 11)
    {
      IMPL = new HoneycombMenuVersionImpl();
      return;
    }
  }

  public static boolean expandActionView(MenuItem paramMenuItem)
  {
    if ((paramMenuItem instanceof SupportMenuItem))
      return ((SupportMenuItem)paramMenuItem).expandActionView();
    return IMPL.expandActionView(paramMenuItem);
  }

  public static View getActionView(MenuItem paramMenuItem)
  {
    if ((paramMenuItem instanceof SupportMenuItem))
      return ((SupportMenuItem)paramMenuItem).getActionView();
    return IMPL.getActionView(paramMenuItem);
  }

  public static boolean isActionViewExpanded(MenuItem paramMenuItem)
  {
    if ((paramMenuItem instanceof SupportMenuItem))
      return ((SupportMenuItem)paramMenuItem).isActionViewExpanded();
    return IMPL.isActionViewExpanded(paramMenuItem);
  }

  public static MenuItem setActionProvider(MenuItem paramMenuItem, ActionProvider paramActionProvider)
  {
    if ((paramMenuItem instanceof SupportMenuItem))
      return ((SupportMenuItem)paramMenuItem).setSupportActionProvider(paramActionProvider);
    Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
    return paramMenuItem;
  }

  public static MenuItem setActionView(MenuItem paramMenuItem, int paramInt)
  {
    if ((paramMenuItem instanceof SupportMenuItem))
      return ((SupportMenuItem)paramMenuItem).setActionView(paramInt);
    return IMPL.setActionView(paramMenuItem, paramInt);
  }

  public static MenuItem setActionView(MenuItem paramMenuItem, View paramView)
  {
    if ((paramMenuItem instanceof SupportMenuItem))
      return ((SupportMenuItem)paramMenuItem).setActionView(paramView);
    return IMPL.setActionView(paramMenuItem, paramView);
  }

  public static void setShowAsAction(MenuItem paramMenuItem, int paramInt)
  {
    if ((paramMenuItem instanceof SupportMenuItem))
    {
      ((SupportMenuItem)paramMenuItem).setShowAsAction(paramInt);
      return;
    }
    IMPL.setShowAsAction(paramMenuItem, paramInt);
  }

  static class BaseMenuVersionImpl
    implements MenuItemCompat.MenuVersionImpl
  {
    public boolean expandActionView(MenuItem paramMenuItem)
    {
      return false;
    }

    public View getActionView(MenuItem paramMenuItem)
    {
      return null;
    }

    public boolean isActionViewExpanded(MenuItem paramMenuItem)
    {
      return false;
    }

    public MenuItem setActionView(MenuItem paramMenuItem, int paramInt)
    {
      return paramMenuItem;
    }

    public MenuItem setActionView(MenuItem paramMenuItem, View paramView)
    {
      return paramMenuItem;
    }

    public void setShowAsAction(MenuItem paramMenuItem, int paramInt)
    {
    }
  }

  static class HoneycombMenuVersionImpl
    implements MenuItemCompat.MenuVersionImpl
  {
    public boolean expandActionView(MenuItem paramMenuItem)
    {
      return false;
    }

    public View getActionView(MenuItem paramMenuItem)
    {
      return MenuItemCompatHoneycomb.getActionView(paramMenuItem);
    }

    public boolean isActionViewExpanded(MenuItem paramMenuItem)
    {
      return false;
    }

    public MenuItem setActionView(MenuItem paramMenuItem, int paramInt)
    {
      return MenuItemCompatHoneycomb.setActionView(paramMenuItem, paramInt);
    }

    public MenuItem setActionView(MenuItem paramMenuItem, View paramView)
    {
      return MenuItemCompatHoneycomb.setActionView(paramMenuItem, paramView);
    }

    public void setShowAsAction(MenuItem paramMenuItem, int paramInt)
    {
      MenuItemCompatHoneycomb.setShowAsAction(paramMenuItem, paramInt);
    }
  }

  static class IcsMenuVersionImpl extends MenuItemCompat.HoneycombMenuVersionImpl
  {
    public boolean expandActionView(MenuItem paramMenuItem)
    {
      return MenuItemCompatIcs.expandActionView(paramMenuItem);
    }

    public boolean isActionViewExpanded(MenuItem paramMenuItem)
    {
      return MenuItemCompatIcs.isActionViewExpanded(paramMenuItem);
    }
  }

  static abstract interface MenuVersionImpl
  {
    public abstract boolean expandActionView(MenuItem paramMenuItem);

    public abstract View getActionView(MenuItem paramMenuItem);

    public abstract boolean isActionViewExpanded(MenuItem paramMenuItem);

    public abstract MenuItem setActionView(MenuItem paramMenuItem, int paramInt);

    public abstract MenuItem setActionView(MenuItem paramMenuItem, View paramView);

    public abstract void setShowAsAction(MenuItem paramMenuItem, int paramInt);
  }

  public static abstract interface OnActionExpandListener
  {
    public abstract boolean onMenuItemActionCollapse(MenuItem paramMenuItem);

    public abstract boolean onMenuItemActionExpand(MenuItem paramMenuItem);
  }
}