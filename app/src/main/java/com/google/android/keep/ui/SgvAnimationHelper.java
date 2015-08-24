package com.google.android.keep.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import java.util.List;

public class SgvAnimationHelper
{
  private static Interpolator Mc;
  private static int Md = 450;
  private static final TypeEvaluator<Rect> Me = new TypeEvaluator()
  {
    private int a(int paramAnonymousInt1, int paramAnonymousInt2, float paramAnonymousFloat)
    {
      return (int)(paramAnonymousInt1 + (paramAnonymousInt2 - paramAnonymousInt1) * paramAnonymousFloat);
    }

    public Rect evaluate(float paramAnonymousFloat, Rect paramAnonymousRect1, Rect paramAnonymousRect2)
    {
      return new Rect(a(paramAnonymousRect1.left, paramAnonymousRect2.left, paramAnonymousFloat), a(paramAnonymousRect1.top, paramAnonymousRect2.top, paramAnonymousFloat), a(paramAnonymousRect1.right, paramAnonymousRect2.right, paramAnonymousFloat), a(paramAnonymousRect1.bottom, paramAnonymousRect2.bottom, paramAnonymousFloat));
    }
  };

  public static void E(Context paramContext)
  {
    Mc = AnimationUtils.loadInterpolator(paramContext, 17563653);
    Point localPoint = new Point();
    ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getSize(localPoint);
    int i = localPoint.y;
    if (i >= 1600)
    {
      Md = 500;
      return;
    }
    if (i >= 1200)
    {
      Md = 450;
      return;
    }
    Md = 400;
  }

  public static void a(List<Animator> paramList, View paramView)
  {
    b(paramList, paramView, 0);
  }

  public static void a(List<Animator> paramList, View paramView, float paramFloat1, float paramFloat2)
  {
    a(paramList, paramView, paramFloat1, paramFloat2, 0);
  }

  public static void a(List<Animator> paramList, View paramView, float paramFloat1, final float paramFloat2, int paramInt)
  {
    if (paramFloat1 == paramFloat2)
      return;
    paramView.setLayerType(2, null);
    paramView.setAlpha(paramFloat1);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, View.ALPHA, new float[] { paramView.getAlpha(), paramFloat2 });
    localObjectAnimator.setInterpolator(Mc);
    localObjectAnimator.setDuration(Md);
    localObjectAnimator.setStartDelay(paramInt);
    localObjectAnimator.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        val$view.setAlpha(paramFloat2);
        val$view.setLayerType(0, null);
      }
    });
    paramList.add(localObjectAnimator);
  }

  public static void a(List<Animator> paramList, View paramView, int paramInt)
  {
    paramView.setLayerType(2, null);
    paramView.setScaleY(0.0F);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, View.SCALE_Y, new float[] { paramView.getScaleY(), 1.0F });
    localObjectAnimator.setInterpolator(Mc);
    localObjectAnimator.setDuration(Md);
    localObjectAnimator.setStartDelay(paramInt);
    localObjectAnimator.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        val$view.setScaleY(1.0F);
        val$view.setLayerType(0, null);
      }
    });
    paramList.add(localObjectAnimator);
  }

  public static void a(List<Animator> paramList, View paramView, int paramInt1, int paramInt2)
  {
    b(paramList, paramView, paramInt1, paramInt2, 0);
  }

  public static void a(List<Animator> paramList, View paramView, int paramInt1, int paramInt2, float paramFloat, int paramInt3)
  {
    a(paramList, paramView, paramInt1, paramInt2, paramInt3);
    paramView.setLayerType(2, null);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, View.ROTATION, new float[] { paramFloat, 0.0F });
    localObjectAnimator.setInterpolator(Mc);
    localObjectAnimator.setDuration(Md);
    localObjectAnimator.setStartDelay(paramInt3);
    localObjectAnimator.addListener(new AnimatorListenerAdapter()
    {
      private boolean Mf = false;

      public void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        Mf = true;
      }

      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        if (!Mf)
          val$view.setRotation(0.0F);
        val$view.setLayerType(0, null);
      }
    });
    paramList.add(localObjectAnimator);
  }

  public static void a(List<Animator> paramList, View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramList, paramView, paramInt1, 0, paramInt3, null);
    b(paramList, paramView, paramInt2, 0, paramInt3, null);
  }

  private static void a(List<Animator> paramList, View paramView, int paramInt1, int paramInt2, int paramInt3, Animator.AnimatorListener paramAnimatorListener)
  {
    paramView.setTranslationX(paramInt1);
    paramView = ObjectAnimator.ofFloat(paramView, View.TRANSLATION_X, new float[] { paramInt1, paramInt2 });
    paramView.setInterpolator(Mc);
    paramView.setDuration(Md);
    paramView.setStartDelay(paramInt3);
    if (paramAnimatorListener != null)
      paramView.addListener(paramAnimatorListener);
    paramList.add(paramView);
  }

  public static void b(List<Animator> paramList, View paramView, int paramInt)
  {
    paramView.setLayerType(2, null);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, View.SCALE_Y, new float[] { paramView.getScaleY(), 0.0F });
    localObjectAnimator.setInterpolator(Mc);
    localObjectAnimator.setDuration(Md);
    localObjectAnimator.setStartDelay(paramInt);
    localObjectAnimator.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        val$view.setScaleY(0.0F);
        val$view.setLayerType(0, null);
      }
    });
    paramList.add(localObjectAnimator);
  }

  public static void b(List<Animator> paramList, View paramView, int paramInt1, int paramInt2)
  {
    a(paramList, paramView, paramInt1, 0, paramInt2, null);
    a(paramList, paramView, 0.0F, 1.0F, paramInt2);
  }

  public static void b(List<Animator> paramList, View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    b(paramList, paramView, paramInt1, paramInt2, paramInt3, null);
  }

  private static void b(List<Animator> paramList, View paramView, int paramInt1, int paramInt2, int paramInt3, Animator.AnimatorListener paramAnimatorListener)
  {
    paramView.setTranslationY(paramInt1);
    paramView = ObjectAnimator.ofFloat(paramView, View.TRANSLATION_Y, new float[] { paramInt1, paramInt2 });
    paramView.setInterpolator(Mc);
    paramView.setDuration(Md);
    paramView.setStartDelay(paramInt3);
    if (paramAnimatorListener != null)
      paramView.addListener(paramAnimatorListener);
    paramList.add(paramView);
  }

  public static void c(List<Animator> paramList, View paramView, int paramInt1, int paramInt2)
  {
    c(paramList, paramView, paramInt1, paramInt2, 0);
  }

  public static void c(List<Animator> paramList, View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramList, paramView, paramView.getAlpha(), 0.0F, paramInt3);
    a(paramList, paramView, paramInt1, paramInt2, paramInt3, null);
  }

  public static TypeEvaluator<Rect> mH()
  {
    return Me;
  }

  public static int mI()
  {
    return Md;
  }

  public static enum AnimationIn
  {
  }

  public static enum AnimationOut
  {
  }

  public static enum TranslationAnimationType
  {
  }
}