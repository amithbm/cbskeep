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
import android.graphics.Paint.Align;
import android.graphics.Typeface;
import android.util.Log;
import android.view.View;
import com.android.datetimepicker.R.color;
import com.android.datetimepicker.R.string;

public class RadialTextsView extends View
{
  private float mAmPmCircleRadiusMultiplier;
  private float mAnimationRadiusMultiplier;
  private float mCircleRadius;
  private float mCircleRadiusMultiplier;
  ObjectAnimator mDisappearAnimator;
  private boolean mDrawValuesReady;
  private boolean mHasInnerCircle;
  private float mInnerNumbersRadiusMultiplier;
  private float[] mInnerTextGridHeights;
  private float[] mInnerTextGridWidths;
  private float mInnerTextSize;
  private float mInnerTextSizeMultiplier;
  private String[] mInnerTexts;
  private InvalidateUpdateListener mInvalidateUpdateListener;
  private boolean mIs24HourMode;
  private boolean mIsInitialized = false;
  private float mNumbersRadiusMultiplier;
  private final Paint mPaint = new Paint();
  ObjectAnimator mReappearAnimator;
  private float[] mTextGridHeights;
  private boolean mTextGridValuesDirty;
  private float[] mTextGridWidths;
  private float mTextSize;
  private float mTextSizeMultiplier;
  private String[] mTexts;
  private float mTransitionEndRadiusMultiplier;
  private float mTransitionMidRadiusMultiplier;
  private Typeface mTypefaceLight;
  private Typeface mTypefaceRegular;
  private int mXCenter;
  private int mYCenter;

  public RadialTextsView(Context paramContext)
  {
    super(paramContext);
  }

  private void calculateGridSizes(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    float f1 = (float)Math.sqrt(3.0D) * paramFloat1 / 2.0F;
    float f2 = paramFloat1 / 2.0F;
    mPaint.setTextSize(paramFloat4);
    paramFloat3 -= (mPaint.descent() + mPaint.ascent()) / 2.0F;
    paramArrayOfFloat1[0] = (paramFloat3 - paramFloat1);
    paramArrayOfFloat2[0] = (paramFloat2 - paramFloat1);
    paramArrayOfFloat1[1] = (paramFloat3 - f1);
    paramArrayOfFloat2[1] = (paramFloat2 - f1);
    paramArrayOfFloat1[2] = (paramFloat3 - f2);
    paramArrayOfFloat2[2] = (paramFloat2 - f2);
    paramArrayOfFloat1[3] = paramFloat3;
    paramArrayOfFloat2[3] = paramFloat2;
    paramArrayOfFloat1[4] = (paramFloat3 + f2);
    paramArrayOfFloat2[4] = (paramFloat2 + f2);
    paramArrayOfFloat1[5] = (paramFloat3 + f1);
    paramArrayOfFloat2[5] = (paramFloat2 + f1);
    paramArrayOfFloat1[6] = (paramFloat3 + paramFloat1);
    paramArrayOfFloat2[6] = (paramFloat2 + paramFloat1);
  }

  private void drawTexts(Canvas paramCanvas, float paramFloat, Typeface paramTypeface, String[] paramArrayOfString, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    mPaint.setTextSize(paramFloat);
    mPaint.setTypeface(paramTypeface);
    paramCanvas.drawText(paramArrayOfString[0], paramArrayOfFloat1[3], paramArrayOfFloat2[0], mPaint);
    paramCanvas.drawText(paramArrayOfString[1], paramArrayOfFloat1[4], paramArrayOfFloat2[1], mPaint);
    paramCanvas.drawText(paramArrayOfString[2], paramArrayOfFloat1[5], paramArrayOfFloat2[2], mPaint);
    paramCanvas.drawText(paramArrayOfString[3], paramArrayOfFloat1[6], paramArrayOfFloat2[3], mPaint);
    paramCanvas.drawText(paramArrayOfString[4], paramArrayOfFloat1[5], paramArrayOfFloat2[4], mPaint);
    paramCanvas.drawText(paramArrayOfString[5], paramArrayOfFloat1[4], paramArrayOfFloat2[5], mPaint);
    paramCanvas.drawText(paramArrayOfString[6], paramArrayOfFloat1[3], paramArrayOfFloat2[6], mPaint);
    paramCanvas.drawText(paramArrayOfString[7], paramArrayOfFloat1[2], paramArrayOfFloat2[5], mPaint);
    paramCanvas.drawText(paramArrayOfString[8], paramArrayOfFloat1[1], paramArrayOfFloat2[4], mPaint);
    paramCanvas.drawText(paramArrayOfString[9], paramArrayOfFloat1[0], paramArrayOfFloat2[3], mPaint);
    paramCanvas.drawText(paramArrayOfString[10], paramArrayOfFloat1[1], paramArrayOfFloat2[2], mPaint);
    paramCanvas.drawText(paramArrayOfString[11], paramArrayOfFloat1[2], paramArrayOfFloat2[1], mPaint);
  }

  private void renderAnimations()
  {
    mDisappearAnimator = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe("animationRadiusMultiplier", new Keyframe[] { Keyframe.ofFloat(0.0F, 1.0F), Keyframe.ofFloat(0.2F, mTransitionMidRadiusMultiplier), Keyframe.ofFloat(1.0F, mTransitionEndRadiusMultiplier) }), PropertyValuesHolder.ofKeyframe("alpha", new Keyframe[] { Keyframe.ofFloat(0.0F, 1.0F), Keyframe.ofFloat(1.0F, 0.0F) }) }).setDuration(500);
    mDisappearAnimator.addUpdateListener(mInvalidateUpdateListener);
    int i = (int)(500 * (1.0F + 0.25F));
    float f = 500 * 0.25F / i;
    mReappearAnimator = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe("animationRadiusMultiplier", new Keyframe[] { Keyframe.ofFloat(0.0F, mTransitionEndRadiusMultiplier), Keyframe.ofFloat(f, mTransitionEndRadiusMultiplier), Keyframe.ofFloat(1.0F - (1.0F - f) * 0.2F, mTransitionMidRadiusMultiplier), Keyframe.ofFloat(1.0F, 1.0F) }), PropertyValuesHolder.ofKeyframe("alpha", new Keyframe[] { Keyframe.ofFloat(0.0F, 0.0F), Keyframe.ofFloat(f, 0.0F), Keyframe.ofFloat(1.0F, 1.0F) }) }).setDuration(i);
    mReappearAnimator.addUpdateListener(mInvalidateUpdateListener);
  }

  public ObjectAnimator getDisappearAnimator()
  {
    if ((!mIsInitialized) || (!mDrawValuesReady) || (mDisappearAnimator == null))
    {
      Log.e("RadialTextsView", "RadialTextView was not ready for animation.");
      return null;
    }
    return mDisappearAnimator;
  }

  public ObjectAnimator getReappearAnimator()
  {
    if ((!mIsInitialized) || (!mDrawValuesReady) || (mReappearAnimator == null))
    {
      Log.e("RadialTextsView", "RadialTextView was not ready for animation.");
      return null;
    }
    return mReappearAnimator;
  }

  public boolean hasOverlappingRendering()
  {
    return false;
  }

  public void initialize(Resources paramResources, String[] paramArrayOfString1, String[] paramArrayOfString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = -1;
    boolean bool = false;
    if (mIsInitialized)
    {
      Log.e("RadialTextsView", "This RadialTextsView may only be initialized once.");
      return;
    }
    int i = paramResources.getColor(R.color.numbers_text_color);
    mPaint.setColor(i);
    mTypefaceLight = Typeface.create(paramResources.getString(R.string.radial_numbers_typeface), 0);
    mTypefaceRegular = Typeface.create(paramResources.getString(R.string.sans_serif), 0);
    mPaint.setAntiAlias(true);
    mPaint.setTextAlign(Paint.Align.CENTER);
    mTexts = paramArrayOfString1;
    mInnerTexts = paramArrayOfString2;
    mIs24HourMode = paramBoolean1;
    if (paramArrayOfString2 != null)
      bool = true;
    mHasInnerCircle = bool;
    if (paramBoolean1)
    {
      mCircleRadiusMultiplier = Float.parseFloat(paramResources.getString(R.string.circle_radius_multiplier_24HourMode));
      mTextGridHeights = new float[7];
      mTextGridWidths = new float[7];
      if (!mHasInnerCircle)
        break label337;
      mNumbersRadiusMultiplier = Float.parseFloat(paramResources.getString(R.string.numbers_radius_multiplier_outer));
      mTextSizeMultiplier = Float.parseFloat(paramResources.getString(R.string.text_size_multiplier_outer));
      mInnerNumbersRadiusMultiplier = Float.parseFloat(paramResources.getString(R.string.numbers_radius_multiplier_inner));
      mInnerTextSizeMultiplier = Float.parseFloat(paramResources.getString(R.string.text_size_multiplier_inner));
      mInnerTextGridHeights = new float[7];
      mInnerTextGridWidths = new float[7];
      label231: mAnimationRadiusMultiplier = 1.0F;
      if (!paramBoolean2)
        break label368;
    }
    label337: label368: for (i = -1; ; i = 1)
    {
      mTransitionMidRadiusMultiplier = (i * 0.05F + 1.0F);
      i = j;
      if (paramBoolean2)
        i = 1;
      mTransitionEndRadiusMultiplier = (0.3F * i + 1.0F);
      mInvalidateUpdateListener = new InvalidateUpdateListener(null);
      mTextGridValuesDirty = true;
      mIsInitialized = true;
      return;
      mCircleRadiusMultiplier = Float.parseFloat(paramResources.getString(R.string.circle_radius_multiplier));
      mAmPmCircleRadiusMultiplier = Float.parseFloat(paramResources.getString(R.string.ampm_circle_radius_multiplier));
      break;
      mNumbersRadiusMultiplier = Float.parseFloat(paramResources.getString(R.string.numbers_radius_multiplier_normal));
      mTextSizeMultiplier = Float.parseFloat(paramResources.getString(R.string.text_size_multiplier_normal));
      break label231;
    }
  }

  public void onDraw(Canvas paramCanvas)
  {
    if ((getWidth() == 0) || (!mIsInitialized));
    do
    {
      return;
      if (!mDrawValuesReady)
      {
        mXCenter = (getWidth() / 2);
        mYCenter = (getHeight() / 2);
        mCircleRadius = (Math.min(mXCenter, mYCenter) * mCircleRadiusMultiplier);
        if (!mIs24HourMode)
        {
          float f1 = mCircleRadius;
          float f2 = mAmPmCircleRadiusMultiplier;
          mYCenter = ((int)(mYCenter - f1 * f2 / 2.0F));
        }
        mTextSize = (mCircleRadius * mTextSizeMultiplier);
        if (mHasInnerCircle)
          mInnerTextSize = (mCircleRadius * mInnerTextSizeMultiplier);
        renderAnimations();
        mTextGridValuesDirty = true;
        mDrawValuesReady = true;
      }
      if (mTextGridValuesDirty)
      {
        calculateGridSizes(mCircleRadius * mNumbersRadiusMultiplier * mAnimationRadiusMultiplier, mXCenter, mYCenter, mTextSize, mTextGridHeights, mTextGridWidths);
        if (mHasInnerCircle)
          calculateGridSizes(mCircleRadius * mInnerNumbersRadiusMultiplier * mAnimationRadiusMultiplier, mXCenter, mYCenter, mInnerTextSize, mInnerTextGridHeights, mInnerTextGridWidths);
        mTextGridValuesDirty = false;
      }
      drawTexts(paramCanvas, mTextSize, mTypefaceLight, mTexts, mTextGridWidths, mTextGridHeights);
    }
    while (!mHasInnerCircle);
    drawTexts(paramCanvas, mInnerTextSize, mTypefaceRegular, mInnerTexts, mInnerTextGridWidths, mInnerTextGridHeights);
  }

  public void setAnimationRadiusMultiplier(float paramFloat)
  {
    mAnimationRadiusMultiplier = paramFloat;
    mTextGridValuesDirty = true;
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