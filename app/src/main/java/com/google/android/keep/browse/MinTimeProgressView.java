package com.google.android.keep.browse;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

public class MinTimeProgressView extends FrameLayout
{
  private static int ho = -1;
  private static int hp = -1;
  private static long hr = -1L;
  private final ProgressBar hq;
  private final Runnable hs = new Runnable()
  {
    public void run()
    {
      MinTimeProgressView.a(MinTimeProgressView.this);
    }
  };
  private final Runnable ht = new Runnable()
  {
    public void run()
    {
      if (!MinTimeProgressView.b(MinTimeProgressView.this))
      {
        MinTimeProgressView.a(MinTimeProgressView.this, System.currentTimeMillis());
        MinTimeProgressView.c(MinTimeProgressView.this).setVisibility(0);
      }
    }
  };
  private boolean mDismissed = false;
  private final Handler mHandler = new Handler();
  private long mStartTime = -1L;

  public MinTimeProgressView(Context paramContext)
  {
    this(paramContext, null);
  }

  public MinTimeProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    addView(LayoutInflater.from(paramContext).inflate(2130968624, null));
    hq = ((ProgressBar)findViewById(2131493099));
    if (hr == -1L)
    {
      paramContext = paramContext.getResources();
      hr = paramContext.getInteger(2131361820);
      ho = paramContext.getInteger(2131361819);
      hp = paramContext.getInteger(2131361818);
    }
  }

  private void ct()
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, View.ALPHA, new float[] { 1.0F, 0.0F });
    localObjectAnimator.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        MinTimeProgressView.c(MinTimeProgressView.this).setVisibility(8);
      }
    });
    localObjectAnimator.setDuration(hr);
    localObjectAnimator.start();
  }

  private void hide()
  {
    mDismissed = true;
    long l = System.currentTimeMillis() - mStartTime;
    if ((l >= ho) || (mStartTime == -1L))
    {
      ct();
      return;
    }
    mHandler.postDelayed(hs, ho - l);
  }

  private void show()
  {
    mDismissed = false;
    mStartTime = -1L;
    mHandler.postDelayed(ht, hp);
  }

  public void setVisibility(int paramInt)
  {
    switch (paramInt)
    {
    default:
      super.setVisibility(paramInt);
      return;
    case 0:
      show();
      return;
    case 8:
    }
    hide();
  }
}