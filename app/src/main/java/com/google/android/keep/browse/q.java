package com.google.android.keep.browse;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;

public class q
  implements View.OnTouchListener
{
  private static int jt;
  private static int ju;
  private boolean gI;
  private final a jA;
  private final float jq = 0.2F;
  private final float jr = 1.0F;
  private final float js = 0.1F;
  private boolean jv;
  private float jw;
  private float jx;
  private float jy;
  private float jz;
  private final VelocityTracker mVelocityTracker;
  private final View mView;

  public q(Context paramContext, View paramView, a parama, VelocityTracker paramVelocityTracker, boolean paramBoolean)
  {
    mView = paramView;
    jA = parama;
    mVelocityTracker = paramVelocityTracker;
    jv = paramBoolean;
    if (jv);
    for (jy = 1.0F; ; jy = 0.1F)
    {
      jt = ViewConfiguration.get(paramContext).getScaledMinimumFlingVelocity() * 10;
      ju = ViewConfiguration.get(paramContext).getScaledTouchSlop() * 2;
      return;
    }
  }

  private boolean a(View paramView, float paramFloat1, float paramFloat2)
  {
    boolean bool = false;
    int i;
    if (paramFloat2 > paramView.getWidth() * 0.4F)
    {
      i = 1;
      if (Math.abs(paramFloat1) <= jt)
        break label56;
    }
    label56: for (int j = 1; ; j = 0)
    {
      if ((i != 0) || (j != 0))
        bool = true;
      return bool;
      i = 0;
      break;
    }
  }

  private void i(View paramView)
  {
    paramView = paramView.animate().translationX(0.0F).alpha(1.0F).setListener(l(paramView)).setInterpolator(new b()).setDuration(600L);
    paramView.start();
    jA.a(paramView);
  }

  private void j(View paramView)
  {
    paramView = paramView.animate().translationX(0.0F).alpha(1.0F).setListener(l(paramView));
    paramView.start();
    jA.a(paramView);
  }

  private void k(View paramView)
  {
    ViewPropertyAnimator localViewPropertyAnimator = paramView.animate();
    if (paramView.getTranslationX() > 0.0F);
    for (float f = paramView.getWidth(); ; f = -paramView.getWidth())
    {
      paramView = localViewPropertyAnimator.translationX(f).alpha(0.0F).setListener(m(paramView));
      paramView.start();
      jA.a(paramView);
      return;
    }
  }

  private AnimatorListenerAdapter l(final View paramView)
  {
    return new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        paramView.setTranslationX(0.0F);
        paramView.setAlpha(1.0F);
      }
    };
  }

  private AnimatorListenerAdapter m(final View paramView)
  {
    return new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        paramView.setTranslationX(0.0F);
        paramView.setAlpha(1.0F);
        paramView.setVisibility(4);
        q.b(q.this).h(q.a(q.this));
        q.b(q.this).bU();
      }
    };
  }

  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (!jA.bV());
    label194: 
    do
    {
      do
      {
        return false;
        switch (paramMotionEvent.getAction())
        {
        default:
          return false;
        case 0:
          jA.l(true);
          mVelocityTracker.clear();
          mVelocityTracker.addMovement(paramMotionEvent);
          gI = false;
          jw = paramMotionEvent.getX();
          if (jv)
          {
            jz = (2.0F / paramView.getWidth());
            return false;
          }
          jz = 0.0F;
          return false;
        case 2:
          mVelocityTracker.addMovement(paramMotionEvent);
          if (gI)
            break label194;
        case 3:
        case 1:
        }
      }
      while (Math.abs(paramMotionEvent.getX() - jw) <= ju);
      gI = true;
      paramView.getParent().requestDisallowInterceptTouchEvent(true);
      jA.l(false);
      jA.bP();
      jx = paramMotionEvent.getX();
      return true;
      if (paramView.isActivated())
        paramView.setActivated(false);
      if (paramView.isPressed())
        paramView.setPressed(false);
      float f = (paramView.getTranslationX() + paramMotionEvent.getX() - jx) * jy;
      paramView.setAlpha(Math.max(0.2F, 1.0F - Math.abs(f) * jz));
      paramView.setTranslationX(f);
      return true;
      paramView.setActivated(false);
      j(paramView);
      return false;
      paramView.setActivated(false);
    }
    while (!gI);
    gI = false;
    mVelocityTracker.addMovement(paramMotionEvent);
    mVelocityTracker.computeCurrentVelocity(1000);
    if (a(paramView, mVelocityTracker.getXVelocity(), Math.abs(paramView.getTranslationX())))
    {
      if (jv)
      {
        jA.bT();
        k(paramView);
        jA.l(false);
        return true;
      }
      i(paramView);
      return false;
    }
    j(paramView);
    return false;
  }

  public static abstract interface a
  {
    public abstract void a(ViewPropertyAnimator paramViewPropertyAnimator);

    public abstract void bP();

    public abstract void bT();

    public abstract void bU();

    public abstract boolean bV();

    public abstract void h(View paramView);

    public abstract void l(boolean paramBoolean);
  }

  private class b
    implements Interpolator
  {
    private final float jC = 8.0F;
    private final float jD = 0.2F;
    private final float jE = (float)Math.sqrt(0.125D);
    private final float jF = jE * 2.0F;
    private final float jG = (jE + jF) / 2.0F;

    public b()
    {
    }

    private float a(float paramFloat)
    {
      return paramFloat * paramFloat * 8.0F;
    }

    public float getInterpolation(float paramFloat)
    {
      paramFloat *= jF;
      if (paramFloat < jE)
        return a(paramFloat);
      return a(paramFloat - jG) + 0.8F;
    }
  }
}