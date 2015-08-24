package com.google.android.keep.browse;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Rect;
import android.view.View;

public class d
{
  private static final a fR = new a();

  public static void a(View paramView, long paramLong)
  {
    paramView.setDrawingCacheEnabled(true);
    paramView.setPressed(false);
    paramView.refreshDrawableState();
    Object localObject = paramView.getDrawingCache();
    if (localObject == null)
    {
      fR.free();
      return;
    }
    fR.fT = paramView;
    fR.fS = ((Bitmap)localObject).copy(Bitmap.Config.ARGB_8888, false);
    fR.fU = paramLong;
    paramView.destroyDrawingCache();
    paramView.setDrawingCacheEnabled(false);
    localObject = new Rect();
    paramView.getDrawingRect((Rect)localObject);
    ((Rect)localObject).left += paramView.getPaddingLeft();
    ((Rect)localObject).top += paramView.getPaddingTop();
    ((Rect)localObject).bottom -= paramView.getPaddingBottom();
    ((Rect)localObject).right -= paramView.getPaddingRight();
    fR.fV = ((Rect)localObject);
  }

  public static void b(View paramView, long paramLong)
  {
    if (paramLong == fR.fU)
    {
      freeBitmap();
      a(paramView, paramLong);
    }
  }

  public static Bitmap bW()
  {
    return fR.fS;
  }

  public static Rect bX()
  {
    return fR.fV;
  }

  public static void freeBitmap()
  {
    fR.free();
  }

  public static class a
  {
    Bitmap fS;
    View fT;
    long fU;
    Rect fV;

    public void free()
    {
      if (fS != null)
        fS.recycle();
      fS = null;
      fT = null;
      fV = null;
      fU = -1L;
    }
  }
}