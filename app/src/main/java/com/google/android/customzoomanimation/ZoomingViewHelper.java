package com.google.android.customzoomanimation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.Display;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import com.google.android.keep.activities.KeepApplication;

public class ZoomingViewHelper
{
  private static int sAnimationTime = -1;
  private static int sCloseAnimationTime = -1;
  private static int sShortAnimationTime = -1;
  private final FragmentActivity mActivity;
  private boolean mAnimatedIn;
  private final int mAnimationDirection;
  private float mAnimationHeightScaleFactor = 1.0F;
  private float mAnimationWidthScaleFactor = 1.0F;
  private Animator mCurrentAnimation;
  private final Interpolator mDecelerateQuadInterpolator;
  private boolean mFinished;
  private boolean mFinishing;
  private final Handler mHandler = new Handler();
  private final ImageView mImageView;
  private ZoomingViewListener mListener;
  private boolean mOpened;
  private int mStartHeight;
  private int mStartWidth;
  private int mStartX;
  private int mStartY;
  private final BitmapStorageInterface mStorage;
  private float mTargetStartScaleX;
  private float mTargetStartScaleY;
  private int mTargetStartX;
  private int mTargetStartY;
  private final View mTargetView;

  public ZoomingViewHelper(Bundle paramBundle, ImageView paramImageView, View paramView, FragmentActivity paramFragmentActivity, BitmapStorageInterface paramBitmapStorageInterface)
  {
    mStartX = paramBundle.getInt("startX", -1);
    mStartY = paramBundle.getInt("startY", -1);
    mAnimationDirection = paramBundle.getInt("animDirection");
    mStorage = paramBitmapStorageInterface;
    mImageView = paramImageView;
    mImageView.setVisibility(8);
    mTargetView = paramView;
    mTargetView.setVisibility(4);
    mActivity = paramFragmentActivity;
    mAnimatedIn = paramBundle.getBoolean("animationRunYet", false);
    mDecelerateQuadInterpolator = AnimationUtils.loadInterpolator(paramFragmentActivity, 17563649);
    if (sAnimationTime == -1)
    {
      sAnimationTime = mActivity.getResources().getInteger(2131361822);
      sCloseAnimationTime = mActivity.getResources().getInteger(2131361823);
      sShortAnimationTime = mActivity.getResources().getInteger(2131361824);
    }
  }

  private void animateClosed()
  {
    if (mCurrentAnimation != null)
      mCurrentAnimation.cancel();
    if (mAnimationDirection == 2);
    for (mCurrentAnimation = getFadeCloseAnimator(); ; mCurrentAnimation = getZoomCloseAnimator())
    {
      mCurrentAnimation.addListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          ZoomingViewHelper.access$202(ZoomingViewHelper.this, false);
          ZoomingViewHelper.access$102(ZoomingViewHelper.this, null);
          mTargetView.setVisibility(8);
          mTargetView.setLayerType(0, null);
          ZoomingViewHelper.this.reallyFinish();
        }

        public void onAnimationStart(Animator paramAnonymousAnimator)
        {
          mTargetView.setLayerType(2, null);
        }
      });
      mCurrentAnimation.start();
      mFinishing = true;
      return;
    }
  }

  private AnimatorSet getBitmapCloseAnimations()
  {
    Object localObject = getEndingBounds();
    int i;
    int j;
    float f1;
    float f2;
    ObjectAnimator localObjectAnimator1;
    ObjectAnimator localObjectAnimator2;
    ObjectAnimator localObjectAnimator3;
    AnimatorSet localAnimatorSet;
    if ((mStartX == -1) || (mStartY == -1))
    {
      i = ((Rect)localObject).centerX();
      j = ((Rect)localObject).centerY();
      f1 = 0.0F;
      f2 = 0.0F;
      float f3 = ((Rect)localObject).width();
      float f4 = (1.0F - mAnimationWidthScaleFactor) / 2.0F;
      localObjectAnimator1 = ObjectAnimator.ofFloat(mImageView, View.X, new float[] { f3 * f4, i });
      localObject = ObjectAnimator.ofFloat(mImageView, View.Y, new float[] { ((Rect)localObject).top, j });
      localObjectAnimator2 = ObjectAnimator.ofFloat(mImageView, View.SCALE_X, new float[] { getBitmapScaleFactorX(), f1 });
      localObjectAnimator3 = ObjectAnimator.ofFloat(mImageView, View.SCALE_Y, new float[] { getBitmapScaleFactorY(), f2 });
      localAnimatorSet = new AnimatorSet();
      switch (mAnimationDirection)
      {
      default:
        mImageView.setPivotX(0.0F);
        mImageView.setPivotY(0.0F);
        localAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObject, localObjectAnimator2, localObjectAnimator3 });
      case 1:
      }
    }
    while (true)
    {
      localAnimatorSet.setDuration(sCloseAnimationTime);
      return localAnimatorSet;
      i = mStartX;
      j = mStartY;
      f1 = 1.0F;
      f2 = 1.0F;
      break;
      mImageView.setPivotY(0.0F);
      if (mAnimationWidthScaleFactor < 1.0F)
        localAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2, localObject, localObjectAnimator3 });
      else
        localAnimatorSet.playTogether(new Animator[] { localObject, localObjectAnimator3 });
    }
  }

  private float getBitmapScaleFactorX()
  {
    Rect localRect3 = getEndingBounds();
    Rect localRect4 = getStartingBounds();
    Rect localRect2 = mStorage.getBitmapDrawingRect();
    Rect localRect1 = localRect2;
    if (localRect2 == null)
      localRect1 = new Rect(0, 0, 0, 0);
    int i = localRect4.width();
    if (i == 0)
      return 0.0F;
    return (localRect3.width() + localRect1.left) * mAnimationWidthScaleFactor / i;
  }

  private float getBitmapScaleFactorY()
  {
    Rect localRect3 = getEndingBounds();
    Rect localRect4 = getStartingBounds();
    Rect localRect2 = mStorage.getBitmapDrawingRect();
    Rect localRect1 = localRect2;
    if (localRect2 == null)
      localRect1 = new Rect(0, 0, 0, 0);
    int i = localRect4.height();
    if (i == 0)
      return 0.0F;
    return (localRect3.height() + localRect1.top) * mAnimationHeightScaleFactor / i;
  }

  private Animator getCircularRevealOpenAnimator()
  {
    View localView = mActivity.findViewById(2131493043);
    int i = Math.max(localView.getWidth(), localView.getHeight());
    return ViewAnimationUtils.createCircularReveal(localView, mStartX, mStartY, 0.0F, i);
  }

  private Rect getEndingBounds()
  {
    Display localDisplay = mActivity.getWindowManager().getDefaultDisplay();
    Point localPoint = new Point();
    localDisplay.getSize(localPoint);
    int i = localPoint.x;
    int j = localPoint.y;
    int k = mTargetView.getTop();
    return new Rect(0, k, i, k + j);
  }

  private Animator getFadeCloseAnimator()
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(mTargetView, View.ALPHA, new float[] { 1.0F, 0.0F });
    localObjectAnimator.setInterpolator(mDecelerateQuadInterpolator);
    localObjectAnimator.setDuration(sCloseAnimationTime);
    localObjectAnimator.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        mTargetView.setAlpha(1.0F);
      }
    });
    return localObjectAnimator;
  }

  private Animator getFadeOpenAnimator()
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(mTargetView, View.ALPHA, new float[] { 0.0F, 1.0F });
    localObjectAnimator.setInterpolator(mDecelerateQuadInterpolator);
    localObjectAnimator.setDuration(sAnimationTime);
    return localObjectAnimator;
  }

  private Rect getStartingBounds()
  {
    return new Rect(mStartX, mStartY, mStartX + mStartWidth, mStartY + mStartHeight);
  }

  private AnimatorSet getTargetCloseAnimations()
  {
    int i = mTargetStartX;
    int j = mTargetStartY;
    if ((mStartX == -1) || (mStartY == -1))
    {
      localObject = getEndingBounds();
      i = ((Rect)localObject).centerX();
      j = ((Rect)localObject).centerY();
    }
    Object localObject = ObjectAnimator.ofFloat(mTargetView, View.X, new float[] { i });
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(mTargetView, View.Y, new float[] { j });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(mTargetView, View.SCALE_X, new float[] { mTargetStartScaleX });
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(mTargetView, View.SCALE_Y, new float[] { mTargetStartScaleY });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    switch (mAnimationDirection)
    {
    default:
      mTargetView.setPivotX(0.0F);
      mTargetView.setPivotY(0.0F);
    case 1:
    }
    while (true)
    {
      localAnimatorSet.playTogether(new Animator[] { localObject, localObjectAnimator1, localObjectAnimator2, localObjectAnimator3 });
      localAnimatorSet.setDuration(sCloseAnimationTime);
      return localAnimatorSet;
      mTargetView.setPivotY(0.0F);
    }
  }

  private AnimatorSet getTargetOpenAnimations()
  {
    Object localObject4 = getStartingBounds();
    Object localObject3 = getEndingBounds();
    Object localObject2 = mStorage.getBitmapDrawingRect();
    Object localObject1 = localObject2;
    if (localObject2 == null)
      localObject1 = new Rect(0, 0, 0, 0);
    int i = ((Rect)localObject1).width();
    float f1 = i / ((Rect)localObject3).width();
    float f2 = (f1 * ((Rect)localObject3).width() - i) / 2.0F;
    ((Rect)localObject4).left = ((int)(((Rect)localObject4).left - f2));
    ((Rect)localObject4).right = ((int)(((Rect)localObject4).right + f2));
    i = ((Rect)localObject1).height();
    f2 = i / ((Rect)localObject3).height();
    float f3 = (f2 * ((Rect)localObject3).height() - i) / 2.0F;
    ((Rect)localObject4).top = ((int)(((Rect)localObject4).top - f3));
    ((Rect)localObject4).bottom = ((int)(((Rect)localObject4).bottom + f3));
    i = ((Rect)localObject4).left + ((Rect)localObject1).left;
    int j = ((Rect)localObject4).top + ((Rect)localObject1).top;
    localObject1 = ObjectAnimator.ofFloat(mTargetView, View.X, new float[] { i, ((Rect)localObject3).left });
    localObject2 = ObjectAnimator.ofFloat(mTargetView, View.Y, new float[] { j, ((Rect)localObject3).top });
    localObject3 = ObjectAnimator.ofFloat(mTargetView, View.SCALE_X, new float[] { f1, 1.0F });
    localObject4 = ObjectAnimator.ofFloat(mTargetView, View.SCALE_Y, new float[] { f2, 1.0F });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    switch (mAnimationDirection)
    {
    default:
      mTargetView.setPivotX(0.0F);
      mTargetView.setPivotY(0.0F);
    case 1:
    }
    while (true)
    {
      localAnimatorSet.playTogether(new Animator[] { localObject1, localObject2, localObject3, localObject4 });
      mTargetStartScaleX = f1;
      mTargetStartScaleY = f2;
      mTargetStartX = i;
      mTargetStartY = j;
      localAnimatorSet.setDuration(sAnimationTime);
      return localAnimatorSet;
      mTargetView.setPivotY(0.0F);
    }
  }

  private Animator getZoomCloseAnimator()
  {
    AnimatorSet localAnimatorSet1 = getBitmapCloseAnimations();
    AnimatorSet localAnimatorSet2 = getTargetCloseAnimations();
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(mImageView, View.ALPHA, new float[] { 0.0F, 1.0F });
    localObjectAnimator.setDuration(sCloseAnimationTime);
    AnimatorSet localAnimatorSet3 = new AnimatorSet();
    localAnimatorSet3.playTogether(new Animator[] { localAnimatorSet1, localAnimatorSet2, localObjectAnimator });
    localAnimatorSet3.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        mImageView.setVisibility(8);
        mImageView.setImageBitmap(null);
        paramAnonymousAnimator = ZoomingViewHelper.this.getEndingBounds();
        mTargetView.setX(paramAnonymousAnimator.left);
        mTargetView.setY(paramAnonymousAnimator.top);
        mTargetView.setScaleX(1.0F);
        mTargetView.setScaleY(1.0F);
      }

      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        mImageView.setVisibility(0);
        mImageView.setImageBitmap(mStorage.getBitmap());
        mImageView.setLayerType(2, null);
      }
    });
    localAnimatorSet3.setInterpolator(mDecelerateQuadInterpolator);
    return localAnimatorSet3;
  }

  private Animator getZoomOpenAnimator()
  {
    AnimatorSet localAnimatorSet1 = getTargetOpenAnimations();
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(mImageView, View.ALPHA, new float[] { 1.0F, 0.0F });
    localObjectAnimator.setDuration(sShortAnimationTime);
    localObjectAnimator.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        mImageView.setImageBitmap(null);
        mImageView.setVisibility(8);
        mImageView.setLayerType(0, null);
      }
    });
    AnimatorSet localAnimatorSet2 = new AnimatorSet();
    localAnimatorSet2.playTogether(new Animator[] { localAnimatorSet1, localObjectAnimator });
    localAnimatorSet2.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        mImageView.setImageBitmap(mStorage.getBitmap());
        mImageView.setAlpha(1.0F);
        mImageView.setX(mStartX);
        mImageView.setY(mStartY);
        mImageView.setLayerType(2, null);
        mTargetView.setX(mStartX);
        mTargetView.setY(mStartY);
        mTargetView.setScaleX(mTargetStartScaleX);
        mTargetView.setScaleY(mTargetStartScaleY);
      }
    });
    localAnimatorSet2.setInterpolator(mDecelerateQuadInterpolator);
    return localAnimatorSet2;
  }

  private void reallyFinish()
  {
    mStorage.freeBitmap();
    mFinished = true;
    if (mListener != null)
      mListener.onCloseComplete();
  }

  public void animateOpen()
  {
    if (mCurrentAnimation != null)
      mCurrentAnimation.cancel();
    if (mAnimationDirection == 2)
      if (KeepApplication.ap())
        mCurrentAnimation = getCircularRevealOpenAnimator();
    while (true)
    {
      mCurrentAnimation.addListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          ZoomingViewHelper.access$102(ZoomingViewHelper.this, null);
          ZoomingViewHelper.access$202(ZoomingViewHelper.this, true);
          mTargetView.setLayerType(0, null);
          if (mListener != null)
            mListener.onOpenComplete();
        }

        public void onAnimationStart(Animator paramAnonymousAnimator)
        {
          mTargetView.setVisibility(0);
          mTargetView.setLayerType(2, null);
        }
      });
      mCurrentAnimation.start();
      return;
      mCurrentAnimation = getFadeOpenAnimator();
      continue;
      mCurrentAnimation = getZoomOpenAnimator();
    }
  }

  public void finish()
  {
    if (!mFinishing)
      animateClosed();
  }

  public boolean isFinished()
  {
    return mFinished;
  }

  public void onPause()
  {
    if ((mCurrentAnimation != null) && (!mActivity.isFinishing()))
      mCurrentAnimation.end();
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    if ((mActivity.getChangingConfigurations() & 0x80) != 0)
    {
      paramBundle.putInt("startX", -1);
      paramBundle.putInt("startY", -1);
      resetAnimationProperties();
    }
    paramBundle.putBoolean("animationRunYet", mAnimatedIn);
  }

  public void openView()
  {
    Bitmap localBitmap = mStorage.getBitmap();
    if ((mAnimatedIn) || (localBitmap == null) || (mStartX == -1) || (mStartY == -1))
    {
      mTargetView.setVisibility(0);
      mTargetView.setAlpha(1.0F);
      mImageView.setVisibility(8);
      if (mListener != null)
        mListener.onOpenComplete();
    }
    while (mOpened)
      return;
    mOpened = true;
    mStartWidth = localBitmap.getWidth();
    mStartHeight = localBitmap.getHeight();
    mHandler.postDelayed(new Runnable()
    {
      public void run()
      {
        animateOpen();
      }
    }
    , 1L);
  }

  public void resetAnimationProperties()
  {
    mStartX = -1;
    mStartY = -1;
    mTargetStartScaleX = 0.0F;
    mTargetStartScaleY = 0.0F;
    mTargetStartX = 0;
    mTargetStartY = 0;
    mImageView.setImageBitmap(null);
    mStorage.freeBitmap();
  }

  public void setListener(ZoomingViewListener paramZoomingViewListener)
  {
    mListener = paramZoomingViewListener;
  }

  public void setWidthScaleFactor(int paramInt)
  {
    mAnimationWidthScaleFactor = (paramInt / 100.0F);
  }

  public static abstract interface ZoomingViewListener
  {
    public abstract void onCloseComplete();

    public abstract void onOpenComplete();
  }
}