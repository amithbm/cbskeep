package com.android.ex.photo;

import android.graphics.drawable.Drawable;

public abstract interface ActionBarInterface
{
  public abstract void addOnMenuVisibilityListener(OnMenuVisibilityListener paramOnMenuVisibilityListener);

  public abstract void hide();

  public abstract void setDisplayHomeAsUpEnabled(boolean paramBoolean);

  public abstract void setDisplayOptionsShowTitle();

  public abstract void setLogo(Drawable paramDrawable);

  public abstract void setSubtitle(CharSequence paramCharSequence);

  public abstract void setTitle(CharSequence paramCharSequence);

  public abstract void show();

  public static abstract interface OnMenuVisibilityListener
  {
    public abstract void onMenuVisibilityChanged(boolean paramBoolean);
  }
}