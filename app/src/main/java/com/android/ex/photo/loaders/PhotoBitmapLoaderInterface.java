package com.android.ex.photo.loaders;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

public abstract interface PhotoBitmapLoaderInterface
{
  public abstract void forceLoad();

  public abstract void setPhotoUri(String paramString);

  public static class BitmapResult
  {
    public Bitmap bitmap;
    public Drawable drawable;
    public int status;

    public Drawable getDrawable(Resources paramResources)
    {
      if (paramResources == null)
        throw new IllegalArgumentException("resources can not be null!");
      if (drawable != null)
        return drawable;
      if (bitmap == null)
        return null;
      return new BitmapDrawable(paramResources, bitmap);
    }
  }
}