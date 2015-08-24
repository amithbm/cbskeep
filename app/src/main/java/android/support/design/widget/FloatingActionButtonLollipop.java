package android.support.design.widget;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

@TargetApi(21)
class FloatingActionButtonLollipop extends FloatingActionButtonHoneycombMr1
{
  private Drawable mBorderDrawable;
  private Interpolator mInterpolator;
  private RippleDrawable mRippleDrawable;
  private Drawable mShapeDrawable;

  FloatingActionButtonLollipop(View paramView, ShadowViewDelegate paramShadowViewDelegate)
  {
    super(paramView, paramShadowViewDelegate);
    if (!paramView.isInEditMode())
      mInterpolator = AnimationUtils.loadInterpolator(mView.getContext(), 17563661);
  }

  private Animator setupAnimator(Animator paramAnimator)
  {
    paramAnimator.setInterpolator(mInterpolator);
    return paramAnimator;
  }

  void jumpDrawableToCurrentState()
  {
  }

  CircularBorderDrawable newCircularDrawable()
  {
    return new CircularBorderDrawableLollipop();
  }

  void onDrawableStateChanged(int[] paramArrayOfInt)
  {
  }

  void setBackgroundDrawable(Drawable paramDrawable, ColorStateList paramColorStateList, PorterDuff.Mode paramMode, int paramInt1, int paramInt2)
  {
    mShapeDrawable = DrawableCompat.wrap(paramDrawable);
    DrawableCompat.setTintList(mShapeDrawable, paramColorStateList);
    if (paramMode != null)
      DrawableCompat.setTintMode(mShapeDrawable, paramMode);
    if (paramInt2 > 0)
      mBorderDrawable = createBorderDrawable(paramInt2, paramColorStateList);
    for (paramDrawable = new LayerDrawable(new Drawable[] { mBorderDrawable, mShapeDrawable }); ; paramDrawable = mShapeDrawable)
    {
      mRippleDrawable = new RippleDrawable(ColorStateList.valueOf(paramInt1), paramDrawable, null);
      mShadowViewDelegate.setBackgroundDrawable(mRippleDrawable);
      mShadowViewDelegate.setShadowPadding(0, 0, 0, 0);
      return;
      mBorderDrawable = null;
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

  public void setElevation(float paramFloat)
  {
    ViewCompat.setElevation(mView, paramFloat);
  }

  void setPressedTranslationZ(float paramFloat)
  {
    StateListAnimator localStateListAnimator = new StateListAnimator();
    localStateListAnimator.addState(PRESSED_ENABLED_STATE_SET, setupAnimator(ObjectAnimator.ofFloat(mView, "translationZ", new float[] { paramFloat })));
    localStateListAnimator.addState(FOCUSED_ENABLED_STATE_SET, setupAnimator(ObjectAnimator.ofFloat(mView, "translationZ", new float[] { paramFloat })));
    localStateListAnimator.addState(EMPTY_STATE_SET, setupAnimator(ObjectAnimator.ofFloat(mView, "translationZ", new float[] { 0.0F })));
    mView.setStateListAnimator(localStateListAnimator);
  }
}