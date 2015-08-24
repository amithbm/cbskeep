package com.google.android.customzoomanimation;

import android.graphics.Bitmap;
import android.graphics.Rect;

public abstract interface BitmapStorageInterface
{
  public abstract void freeBitmap();

  public abstract Bitmap getBitmap();

  public abstract Rect getBitmapDrawingRect();
}