package android.support.design.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;

class CircularBorderDrawableLollipop extends CircularBorderDrawable
{
  private ColorStateList mTint;
  private PorterDuffColorFilter mTintFilter;
  private PorterDuff.Mode mTintMode = PorterDuff.Mode.SRC_IN;

  private PorterDuffColorFilter updateTintFilter(ColorStateList paramColorStateList, PorterDuff.Mode paramMode)
  {
    if ((paramColorStateList == null) || (paramMode == null))
      return null;
    return new PorterDuffColorFilter(paramColorStateList.getColorForState(getState(), 0), paramMode);
  }

  public void draw(Canvas paramCanvas)
  {
    if ((mTintFilter != null) && (mPaint.getColorFilter() == null))
      mPaint.setColorFilter(mTintFilter);
    for (int i = 1; ; i = 0)
    {
      super.draw(paramCanvas);
      if (i != 0)
        mPaint.setColorFilter(null);
      return;
    }
  }

  public void getOutline(Outline paramOutline)
  {
    copyBounds(mRect);
    paramOutline.setOval(mRect);
  }

  public void setTintList(ColorStateList paramColorStateList)
  {
    mTint = paramColorStateList;
    mTintFilter = updateTintFilter(paramColorStateList, mTintMode);
    invalidateSelf();
  }

  public void setTintMode(PorterDuff.Mode paramMode)
  {
    mTintMode = paramMode;
    mTintFilter = updateTintFilter(mTint, paramMode);
    invalidateSelf();
  }
}