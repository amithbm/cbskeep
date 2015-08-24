package com.google.android.keep.toasts;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import com.google.android.keep.a.a;
import com.google.android.keep.activities.KeepApplication;
import com.google.api.client.util.Lists;
import java.util.Iterator;
import java.util.List;

public class ToastLayout extends FrameLayout
{
  private a Hq;
  private final TimeInterpolator Hr = lJ();
  private final long Hs = getResources().getInteger(2131361805);
  private final long Ht = getResources().getInteger(2131361806);
  protected boolean Hu;
  private boolean Hv;
  private List<View> Hw = Lists.newArrayList();
  protected boolean mAnimating = false;
  private final int mAnimationDuration = getResources().getInteger(2131361804);
  private final Handler mHandler;
  private boolean mHidden = true;

  public ToastLayout(Context paramContext)
  {
    this(paramContext, null);
  }

  public ToastLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public ToastLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, Looper.myLooper());
  }

  ToastLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt, Looper paramLooper)
  {
    super(paramContext, paramAttributeSet, paramInt);
    mHandler = new Handler(paramLooper)
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        switch (paramAnonymousMessage.what)
        {
        default:
        case 2:
        case 1:
        case 3:
        }
        do
        {
          return;
          au(true);
          return;
          Hu = true;
          return;
          if (ToastLayout.a(ToastLayout.this))
          {
            ToastLayout.a(ToastLayout.this, false);
            lK();
          }
          lH();
        }
        while (ToastLayout.b(ToastLayout.this));
        Hu = false;
        ToastLayout.d(ToastLayout.this).sendEmptyMessageDelayed(1, ToastLayout.c(ToastLayout.this));
        ToastLayout.d(ToastLayout.this).sendEmptyMessageDelayed(2, ToastLayout.e(ToastLayout.this));
      }
    };
    a(paramContext, paramAttributeSet);
  }

  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.ToastLayout);
    Hv = paramContext.getBoolean(0, false);
    paramContext.recycle();
  }

  private void a(View paramView, float paramFloat, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    if (paramView == null)
      return;
    paramView.animate().setDuration(mAnimationDuration).setInterpolator(Hr).translationYBy(paramFloat).setListener(paramAnimatorListenerAdapter);
  }

  private TimeInterpolator lJ()
  {
    if (KeepApplication.ap())
      return new PathInterpolator(0.4F, 0.0F, 0.2F, 1.0F);
    return new LinearInterpolator();
  }

  private int lL()
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)getLayoutParams();
    return getHeight() + localMarginLayoutParams.bottomMargin;
  }

  public void a(a parama)
  {
    Hq = parama;
  }

  public void au(boolean paramBoolean)
  {
    if ((mHidden) || (!Hu))
      return;
    mHidden = true;
    mHandler.removeMessages(2);
    aw(paramBoolean);
    lI();
  }

  public void av(boolean paramBoolean)
  {
    Hu = true;
    au(paramBoolean);
  }

  protected void aw(boolean paramBoolean)
  {
    float f = lL();
    Iterator localIterator;
    if (!paramBoolean)
    {
      setTranslationY(f);
      setVisibility(8);
      localIterator = Hw.iterator();
      while (localIterator.hasNext())
        ((View)localIterator.next()).setTranslationY(f);
      if (Hq != null)
        Hq.r(this);
    }
    while (true)
    {
      return;
      a(this, f, new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          mAnimating = false;
          setVisibility(8);
          if (ToastLayout.f(ToastLayout.this) != null)
            ToastLayout.f(ToastLayout.this).r(ToastLayout.this);
        }

        public void onAnimationStart(Animator paramAnonymousAnimator)
        {
          mAnimating = true;
        }
      });
      localIterator = Hw.iterator();
      while (localIterator.hasNext())
        a((View)localIterator.next(), f, null);
    }
  }

  protected void lH()
  {
  }

  protected void lI()
  {
  }

  protected void lK()
  {
    float f = lL();
    setTranslationY(f);
    a(this, -f, new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        mAnimating = false;
        if (ToastLayout.f(ToastLayout.this) != null)
          ToastLayout.f(ToastLayout.this).q(ToastLayout.this);
      }

      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        mAnimating = true;
        setVisibility(0);
      }
    });
    Iterator localIterator = Hw.iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      localView.setTranslationY(0.0F);
      a(localView, -f, null);
    }
  }

  public void onDetachedFromWindow()
  {
    mHandler.removeMessages(2);
    super.onDetachedFromWindow();
  }

  public void p(View paramView)
  {
    if (paramView != null)
      Hw.add(paramView);
  }

  public void show()
  {
    mHandler.removeMessages(1);
    mHandler.removeMessages(2);
    mHandler.sendEmptyMessage(3);
  }

  public static abstract interface a
  {
    public abstract void q(View paramView);

    public abstract void r(View paramView);
  }
}