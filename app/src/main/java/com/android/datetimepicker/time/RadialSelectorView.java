package com.android.datetimepicker.time;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;
import com.android.datetimepicker.R.color;
import com.android.datetimepicker.R.string;

public class RadialSelectorView extends View
{
  private float mAmPmCircleRadiusMultiplier;
  private float mAnimationRadiusMultiplier;
  private int mCircleRadius;
  private float mCircleRadiusMultiplier;
  private boolean mDrawValuesReady;
  private boolean mForceDrawDot;
  private boolean mHasInnerCircle;
  private float mInnerNumbersRadiusMultiplier;
  private InvalidateUpdateListener mInvalidateUpdateListener;
  private boolean mIs24HourMode;
  private boolean mIsInitialized = false;
  private int mLineLength;
  private float mNumbersRadiusMultiplier;
  private float mOuterNumbersRadiusMultiplier;
  private final Paint mPaint = new Paint();
  private int mSelectionAlpha;
  private int mSelectionDegrees;
  private double mSelectionRadians;
  private int mSelectionRadius;
  private float mSelectionRadiusMultiplier;
  private float mTransitionEndRadiusMultiplier;
  private float mTransitionMidRadiusMultiplier;
  private int mXCenter;
  private int mYCenter;

  public RadialSelectorView(Context paramContext)
  {
    super(paramContext);
  }

  public int getDegreesFromCoords(float paramFloat1, float paramFloat2, boolean paramBoolean, Boolean[] paramArrayOfBoolean)
  {
    int j;
    if (!mDrawValuesReady)
      j = -1;
    label112: int m;
    label153: int k;
    label345: label351: label357: 
    do
    {
      int i;
      do
      {
        return j;
        double d = Math.sqrt((paramFloat2 - mYCenter) * (paramFloat2 - mYCenter) + (paramFloat1 - mXCenter) * (paramFloat1 - mXCenter));
        if (mHasInnerCircle)
          if (paramBoolean)
            if ((int)Math.abs(d - (int)(mCircleRadius * mInnerNumbersRadiusMultiplier)) <= (int)Math.abs(d - (int)(mCircleRadius * mOuterNumbersRadiusMultiplier)))
            {
              paramBoolean = true;
              paramArrayOfBoolean[0] = Boolean.valueOf(paramBoolean);
              m = (int)(180.0D * Math.asin(Math.abs(paramFloat2 - mYCenter) / d) / 3.141592653589793D);
              if (paramFloat1 <= mXCenter)
                break label345;
              i = 1;
              if (paramFloat2 >= mYCenter)
                break label351;
            }
        for (k = 1; ; k = 0)
        {
          if ((i == 0) || (k == 0))
            break label357;
          return 90 - m;
          paramBoolean = false;
          break;
          i = (int)(mCircleRadius * mInnerNumbersRadiusMultiplier);
          j = mSelectionRadius;
          k = (int)(mCircleRadius * mOuterNumbersRadiusMultiplier);
          m = mSelectionRadius;
          int n = (int)(mCircleRadius * ((mOuterNumbersRadiusMultiplier + mInnerNumbersRadiusMultiplier) / 2.0F));
          if ((d >= i - j) && (d <= n))
          {
            paramArrayOfBoolean[0] = Boolean.valueOf(true);
            break label112;
          }
          if ((d <= k + m) && (d >= n))
          {
            paramArrayOfBoolean[0] = Boolean.valueOf(false);
            break label112;
          }
          return -1;
          if ((paramBoolean) || ((int)Math.abs(d - mLineLength) <= (int)(mCircleRadius * (1.0F - mNumbersRadiusMultiplier))))
            break label112;
          return -1;
          i = 0;
          break label153;
        }
        if ((i != 0) && (k == 0))
          return m + 90;
        if ((i == 0) && (k == 0))
          return 270 - m;
        j = m;
      }
      while (i != 0);
      j = m;
    }
    while (k == 0);
    return m + 270;
  }

  public ObjectAnimator getDisappearAnimator()
  {
    if ((!mIsInitialized) || (!mDrawValuesReady))
    {
      Log.e("RadialSelectorView", "RadialSelectorView was not ready for animation.");
      return null;
    }
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe("animationRadiusMultiplier", new Keyframe[] { Keyframe.ofFloat(0.0F, 1.0F), Keyframe.ofFloat(0.2F, mTransitionMidRadiusMultiplier), Keyframe.ofFloat(1.0F, mTransitionEndRadiusMultiplier) }), PropertyValuesHolder.ofKeyframe("alpha", new Keyframe[] { Keyframe.ofFloat(0.0F, 1.0F), Keyframe.ofFloat(1.0F, 0.0F) }) }).setDuration(500);
    localObjectAnimator.addUpdateListener(mInvalidateUpdateListener);
    return localObjectAnimator;
  }

  public ObjectAnimator getReappearAnimator()
  {
    if ((!mIsInitialized) || (!mDrawValuesReady))
    {
      Log.e("RadialSelectorView", "RadialSelectorView was not ready for animation.");
      return null;
    }
    int i = (int)(500 * (1.0F + 0.25F));
    float f = 500 * 0.25F / i;
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe("animationRadiusMultiplier", new Keyframe[] { Keyframe.ofFloat(0.0F, mTransitionEndRadiusMultiplier), Keyframe.ofFloat(f, mTransitionEndRadiusMultiplier), Keyframe.ofFloat(1.0F - (1.0F - f) * 0.2F, mTransitionMidRadiusMultiplier), Keyframe.ofFloat(1.0F, 1.0F) }), PropertyValuesHolder.ofKeyframe("alpha", new Keyframe[] { Keyframe.ofFloat(0.0F, 0.0F), Keyframe.ofFloat(f, 0.0F), Keyframe.ofFloat(1.0F, 1.0F) }) }).setDuration(i);
    localObjectAnimator.addUpdateListener(mInvalidateUpdateListener);
    return localObjectAnimator;
  }

  public boolean hasOverlappingRendering()
  {
    return false;
  }

  public void initialize(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt, boolean paramBoolean4)
  {
    int j = -1;
    if (mIsInitialized)
    {
      Log.e("RadialSelectorView", "This RadialSelectorView may only be initialized once.");
      return;
    }
    paramContext = paramContext.getResources();
    int i = paramContext.getColor(R.color.blue);
    mPaint.setColor(i);
    mPaint.setAntiAlias(true);
    mSelectionAlpha = 51;
    mIs24HourMode = paramBoolean1;
    if (paramBoolean1)
    {
      mCircleRadiusMultiplier = Float.parseFloat(paramContext.getString(R.string.circle_radius_multiplier_24HourMode));
      mHasInnerCircle = paramBoolean2;
      if (!paramBoolean2)
        break label238;
      mInnerNumbersRadiusMultiplier = Float.parseFloat(paramContext.getString(R.string.numbers_radius_multiplier_inner));
      mOuterNumbersRadiusMultiplier = Float.parseFloat(paramContext.getString(R.string.numbers_radius_multiplier_outer));
      label116: mSelectionRadiusMultiplier = Float.parseFloat(paramContext.getString(R.string.selection_radius_multiplier));
      mAnimationRadiusMultiplier = 1.0F;
      if (!paramBoolean3)
        break label255;
    }
    label238: label255: for (i = -1; ; i = 1)
    {
      mTransitionMidRadiusMultiplier = (i * 0.05F + 1.0F);
      i = j;
      if (paramBoolean3)
        i = 1;
      mTransitionEndRadiusMultiplier = (0.3F * i + 1.0F);
      mInvalidateUpdateListener = new InvalidateUpdateListener(null);
      setSelection(paramInt, paramBoolean4, false);
      mIsInitialized = true;
      return;
      mCircleRadiusMultiplier = Float.parseFloat(paramContext.getString(R.string.circle_radius_multiplier));
      mAmPmCircleRadiusMultiplier = Float.parseFloat(paramContext.getString(R.string.ampm_circle_radius_multiplier));
      break;
      mNumbersRadiusMultiplier = Float.parseFloat(paramContext.getString(R.string.numbers_radius_multiplier_normal));
      break label116;
    }
  }

  public void onDraw(Canvas paramCanvas)
  {
    int i = 1;
    if ((getWidth() == 0) || (!mIsInitialized))
      return;
    if (!mDrawValuesReady)
    {
      mXCenter = (getWidth() / 2);
      mYCenter = (getHeight() / 2);
      mCircleRadius = ((int)(Math.min(mXCenter, mYCenter) * mCircleRadiusMultiplier));
      if (!mIs24HourMode)
      {
        j = (int)(mCircleRadius * mAmPmCircleRadiusMultiplier);
        mYCenter -= j / 2;
      }
      mSelectionRadius = ((int)(mCircleRadius * mSelectionRadiusMultiplier));
      mDrawValuesReady = true;
    }
    mLineLength = ((int)(mCircleRadius * mNumbersRadiusMultiplier * mAnimationRadiusMultiplier));
    int k = mXCenter + (int)(mLineLength * Math.sin(mSelectionRadians));
    int j = mYCenter - (int)(mLineLength * Math.cos(mSelectionRadians));
    mPaint.setAlpha(mSelectionAlpha);
    paramCanvas.drawCircle(k, j, mSelectionRadius, mPaint);
    int m = mForceDrawDot;
    if (mSelectionDegrees % 30 != 0)
    {
      if ((i | m) == 0)
        break label312;
      mPaint.setAlpha(255);
      paramCanvas.drawCircle(k, j, mSelectionRadius * 2 / 7, mPaint);
      i = k;
    }
    while (true)
    {
      mPaint.setAlpha(255);
      mPaint.setStrokeWidth(1.0F);
      paramCanvas.drawLine(mXCenter, mYCenter, i, j, mPaint);
      return;
      i = 0;
      break;
      label312: j = mLineLength - mSelectionRadius;
      i = mXCenter + (int)(j * Math.sin(mSelectionRadians));
      j = mYCenter - (int)(j * Math.cos(mSelectionRadians));
    }
  }

  public void setAnimationRadiusMultiplier(float paramFloat)
  {
    mAnimationRadiusMultiplier = paramFloat;
  }

  public void setSelection(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    mSelectionDegrees = paramInt;
    mSelectionRadians = (paramInt * 3.141592653589793D / 180.0D);
    mForceDrawDot = paramBoolean2;
    if (mHasInnerCircle)
    {
      if (paramBoolean1)
        mNumbersRadiusMultiplier = mInnerNumbersRadiusMultiplier;
    }
    else
      return;
    mNumbersRadiusMultiplier = mOuterNumbersRadiusMultiplier;
  }

  private class InvalidateUpdateListener
    implements ValueAnimator.AnimatorUpdateListener
  {
    private InvalidateUpdateListener()
    {
    }

    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      invalidate();
    }
  }
}