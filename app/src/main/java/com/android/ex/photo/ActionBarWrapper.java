package com.android.ex.photo;

import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.OnMenuVisibilityListener;

public class ActionBarWrapper
  implements ActionBarInterface
{
  private final ActionBar mActionBar;

  public ActionBarWrapper(ActionBar paramActionBar)
  {
    mActionBar = paramActionBar;
  }

  public void addOnMenuVisibilityListener(ActionBarInterface.OnMenuVisibilityListener paramOnMenuVisibilityListener)
  {
    mActionBar.addOnMenuVisibilityListener(new MenuVisiblityListenerWrapper(paramOnMenuVisibilityListener));
  }

  public void hide()
  {
    mActionBar.hide();
  }

  public void setDisplayHomeAsUpEnabled(boolean paramBoolean)
  {
    mActionBar.setDisplayHomeAsUpEnabled(paramBoolean);
  }

  public void setDisplayOptionsShowTitle()
  {
    mActionBar.setDisplayOptions(8, 8);
  }

  public void setLogo(Drawable paramDrawable)
  {
    mActionBar.setLogo(paramDrawable);
  }

  public void setSubtitle(CharSequence paramCharSequence)
  {
    mActionBar.setSubtitle(paramCharSequence);
  }

  public void setTitle(CharSequence paramCharSequence)
  {
    mActionBar.setTitle(paramCharSequence);
  }

  public void show()
  {
    mActionBar.show();
  }

  private class MenuVisiblityListenerWrapper
    implements ActionBar.OnMenuVisibilityListener
  {
    private final ActionBarInterface.OnMenuVisibilityListener mWrapped;

    public MenuVisiblityListenerWrapper(ActionBarInterface.OnMenuVisibilityListener arg2)
    {
      Object localObject;
      mWrapped = localObject;
    }

    public void onMenuVisibilityChanged(boolean paramBoolean)
    {
      mWrapped.onMenuVisibilityChanged(paramBoolean);
    }
  }
}