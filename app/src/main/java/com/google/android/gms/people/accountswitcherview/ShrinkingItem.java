package com.google.android.gms.people.accountswitcherview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;

class ShrinkingItem extends FrameLayout
{
  private float mAnimatedHeightFraction = 1.0F;

  public ShrinkingItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public ShrinkingItem(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt2 = getMeasuredHeight();
    if (mAnimatedHeightFraction != 1.0F)
      paramInt2 = Math.round(mAnimatedHeightFraction * paramInt2);
    while (true)
    {
      setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), paramInt2);
      return;
    }
  }

  public void setAnimatedHeightFraction(float paramFloat)
  {
    mAnimatedHeightFraction = paramFloat;
    requestLayout();
  }
}