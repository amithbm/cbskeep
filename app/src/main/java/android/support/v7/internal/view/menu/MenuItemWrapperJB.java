package android.support.v7.internal.view.menu;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.internal.view.SupportMenuItem;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.View;

@TargetApi(16)
class MenuItemWrapperJB extends MenuItemWrapperICS
{
  MenuItemWrapperJB(Context paramContext, SupportMenuItem paramSupportMenuItem)
  {
    super(paramContext, paramSupportMenuItem);
  }

  MenuItemWrapperICS.ActionProviderWrapper createActionProviderWrapper(ActionProvider paramActionProvider)
  {
    return new ActionProviderWrapperJB(mContext, paramActionProvider);
  }

  class ActionProviderWrapperJB extends MenuItemWrapperICS.ActionProviderWrapper
    implements android.view.ActionProvider.VisibilityListener
  {
    android.support.v4.view.ActionProvider.VisibilityListener mListener;

    public ActionProviderWrapperJB(Context paramActionProvider, ActionProvider arg3)
    {
      super(paramActionProvider, localActionProvider);
    }

    public boolean isVisible()
    {
      return mInner.isVisible();
    }

    public void onActionProviderVisibilityChanged(boolean paramBoolean)
    {
      if (mListener != null)
        mListener.onActionProviderVisibilityChanged(paramBoolean);
    }

    public View onCreateActionView(MenuItem paramMenuItem)
    {
      return mInner.onCreateActionView(paramMenuItem);
    }

    public boolean overridesItemVisibility()
    {
      return mInner.overridesItemVisibility();
    }

    public void setVisibilityListener(android.support.v4.view.ActionProvider.VisibilityListener paramVisibilityListener)
    {
      mListener = paramVisibilityListener;
      ActionProvider localActionProvider = mInner;
      if (paramVisibilityListener != null);
      for (paramVisibilityListener = this; ; paramVisibilityListener = null)
      {
        localActionProvider.setVisibilityListener(paramVisibilityListener);
        return;
      }
    }
  }
}