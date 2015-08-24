package android.support.design.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.support.design.R.anim;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

class FloatingActionButtonEclairMr1 extends FloatingActionButtonImpl
{
  private int mAnimationDuration;
  private Drawable mBorderDrawable;
  private float mElevation;
  private boolean mIsHiding;
  private float mPressedTranslationZ;
  private Drawable mRippleDrawable;
  ShadowDrawableWrapper mShadowDrawable;
  private Drawable mShapeDrawable;
  private StateListAnimator mStateListAnimator;

  FloatingActionButtonEclairMr1(View paramView, ShadowViewDelegate paramShadowViewDelegate)
  {
    super(paramView, paramShadowViewDelegate);
    mAnimationDuration = paramView.getResources().getInteger(17694720);
    mStateListAnimator = new StateListAnimator();
    mStateListAnimator.setTarget(paramView);
    mStateListAnimator.addState(PRESSED_ENABLED_STATE_SET, setupAnimation(new ElevateToTranslationZAnimation(null)));
    mStateListAnimator.addState(FOCUSED_ENABLED_STATE_SET, setupAnimation(new ElevateToTranslationZAnimation(null)));
    mStateListAnimator.addState(EMPTY_STATE_SET, setupAnimation(new ResetElevationAnimation(null)));
  }

  private static ColorStateList createColorStateList(int paramInt)
  {
    int[][] arrayOfInt = new int[3][];
    int[] arrayOfInt1 = new int[3];
    arrayOfInt[0] = FOCUSED_ENABLED_STATE_SET;
    arrayOfInt1[0] = paramInt;
    int i = 0 + 1;
    arrayOfInt[i] = PRESSED_ENABLED_STATE_SET;
    arrayOfInt1[i] = paramInt;
    paramInt = i + 1;
    arrayOfInt[paramInt] = new int[0];
    arrayOfInt1[paramInt] = 0;
    return new ColorStateList(arrayOfInt, arrayOfInt1);
  }

  private Animation setupAnimation(Animation paramAnimation)
  {
    paramAnimation.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
    paramAnimation.setDuration(mAnimationDuration);
    return paramAnimation;
  }

  private void updatePadding()
  {
    Rect localRect = new Rect();
    mShadowDrawable.getPadding(localRect);
    mShadowViewDelegate.setShadowPadding(localRect.left, localRect.top, localRect.right, localRect.bottom);
  }

  void hide()
  {
    if (mIsHiding)
      return;
    Animation localAnimation = android.view.animation.AnimationUtils.loadAnimation(mView.getContext(), R.anim.fab_out);
    localAnimation.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
    localAnimation.setDuration(200L);
    localAnimation.setAnimationListener(new AnimationUtils.AnimationListenerAdapter()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        FloatingActionButtonEclairMr1.access$202(FloatingActionButtonEclairMr1.this, false);
        mView.setVisibility(8);
      }

      public void onAnimationStart(Animation paramAnonymousAnimation)
      {
        FloatingActionButtonEclairMr1.access$202(FloatingActionButtonEclairMr1.this, true);
      }
    });
    mView.startAnimation(localAnimation);
  }

  void jumpDrawableToCurrentState()
  {
    mStateListAnimator.jumpToCurrentState();
  }

  void onDrawableStateChanged(int[] paramArrayOfInt)
  {
    mStateListAnimator.setState(paramArrayOfInt);
  }

  void setBackgroundDrawable(Drawable paramDrawable, ColorStateList paramColorStateList, PorterDuff.Mode paramMode, int paramInt1, int paramInt2)
  {
    mShapeDrawable = DrawableCompat.wrap(paramDrawable);
    DrawableCompat.setTintList(mShapeDrawable, paramColorStateList);
    if (paramMode != null)
      DrawableCompat.setTintMode(mShapeDrawable, paramMode);
    paramDrawable = new GradientDrawable();
    paramDrawable.setShape(1);
    paramDrawable.setColor(-1);
    paramDrawable.setCornerRadius(mShadowViewDelegate.getRadius());
    mRippleDrawable = DrawableCompat.wrap(paramDrawable);
    DrawableCompat.setTintList(mRippleDrawable, createColorStateList(paramInt1));
    DrawableCompat.setTintMode(mRippleDrawable, PorterDuff.Mode.MULTIPLY);
    if (paramInt2 > 0)
    {
      mBorderDrawable = createBorderDrawable(paramInt2, paramColorStateList);
      paramDrawable = new Drawable[3];
      paramDrawable[0] = mBorderDrawable;
      paramDrawable[1] = mShapeDrawable;
      paramDrawable[2] = mRippleDrawable;
    }
    while (true)
    {
      mShadowDrawable = new ShadowDrawableWrapper(mView.getResources(), new LayerDrawable(paramDrawable), mShadowViewDelegate.getRadius(), mElevation, mElevation + mPressedTranslationZ);
      mShadowDrawable.setAddPaddingForCorners(false);
      mShadowViewDelegate.setBackgroundDrawable(mShadowDrawable);
      updatePadding();
      return;
      mBorderDrawable = null;
      paramDrawable = new Drawable[2];
      paramDrawable[0] = mShapeDrawable;
      paramDrawable[1] = mRippleDrawable;
    }
  }

  void setBackgroundTintList(ColorStateList paramColorStateList)
  {
    DrawableCompat.setTintList(mShapeDrawable, paramColorStateList);
    if (mBorderDrawable != null)
      DrawableCompat.setTintList(mBorderDrawable, paramColorStateList);
  }

  void setBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    DrawableCompat.setTintMode(mShapeDrawable, paramMode);
  }

  void setElevation(float paramFloat)
  {
    if ((mElevation != paramFloat) && (mShadowDrawable != null))
    {
      mShadowDrawable.setShadowSize(paramFloat, mPressedTranslationZ + paramFloat);
      mElevation = paramFloat;
      updatePadding();
    }
  }

  void setPressedTranslationZ(float paramFloat)
  {
    if ((mPressedTranslationZ != paramFloat) && (mShadowDrawable != null))
    {
      mPressedTranslationZ = paramFloat;
      mShadowDrawable.setMaxShadowSize(mElevation + paramFloat);
      updatePadding();
    }
  }

  void show()
  {
    Animation localAnimation = android.view.animation.AnimationUtils.loadAnimation(mView.getContext(), R.anim.fab_in);
    localAnimation.setDuration(200L);
    localAnimation.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
    mView.startAnimation(localAnimation);
  }

  private abstract class BaseShadowAnimation extends Animation
  {
    private float mShadowSizeDiff;
    private float mShadowSizeStart;

    private BaseShadowAnimation()
    {
    }

    protected void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      mShadowDrawable.setShadowSize(mShadowSizeStart + mShadowSizeDiff * paramFloat);
    }

    protected abstract float getTargetShadowSize();

    public void reset()
    {
      super.reset();
      mShadowSizeStart = mShadowDrawable.getShadowSize();
      mShadowSizeDiff = (getTargetShadowSize() - mShadowSizeStart);
    }
  }

  private class ElevateToTranslationZAnimation extends FloatingActionButtonEclairMr1.BaseShadowAnimation
  {
    private ElevateToTranslationZAnimation()
    {
      super(null);
    }

    protected float getTargetShadowSize()
    {
      return mElevation + mPressedTranslationZ;
    }
  }

  private class ResetElevationAnimation extends FloatingActionButtonEclairMr1.BaseShadowAnimation
  {
    private ResetElevationAnimation()
    {
      super(null);
    }

    protected float getTargetShadowSize()
    {
      return mElevation;
    }
  }
}