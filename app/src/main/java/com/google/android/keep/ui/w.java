package com.google.android.keep.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public class w
{
  private final a MH;
  private final a MI;
  private final boolean MJ;
  private Interpolator mInterpolator;
  private int mMode;

  public w(Context paramContext)
  {
    this(paramContext, null);
  }

  public w(Context paramContext, Interpolator paramInterpolator)
  {
    this(paramContext, paramInterpolator, true);
  }

  public w(Context paramContext, Interpolator paramInterpolator, boolean paramBoolean)
  {
    mInterpolator = paramInterpolator;
    MJ = paramBoolean;
    MH = new a(paramContext);
    MI = new a(paramContext);
  }

  public void abortAnimation()
  {
    MH.finish();
    MI.finish();
  }

  public boolean computeScrollOffset()
  {
    if (isFinished())
      return false;
    switch (mMode)
    {
    default:
    case 0:
    case 1:
    }
    while (true)
    {
      return true;
      long l = AnimationUtils.currentAnimationTimeMillis() - a.e(MH);
      int i = a.d(MH);
      if (l < i)
      {
        float f = (float)l / i;
        if (mInterpolator == null);
        for (f = mInterpolator.getInterpolation(f); ; f = mInterpolator.getInterpolation(f))
        {
          MH.e(f);
          MI.e(f);
          break;
        }
      }
      abortAnimation();
      continue;
      if ((!a.a(MH)) && (!MH.mV()) && (!MH.mU()))
        MH.finish();
      if ((!a.a(MI)) && (!MI.mV()) && (!MI.mU()))
        MI.finish();
    }
  }

  public void fling(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    fling(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, 0, 0);
  }

  public void fling(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
  {
    int j = paramInt3;
    int i = paramInt4;
    if (MJ)
    {
      j = paramInt3;
      i = paramInt4;
      if (!isFinished())
      {
        float f1 = a.c(MH);
        float f2 = a.c(MI);
        j = paramInt3;
        i = paramInt4;
        if (Math.signum(paramInt3) == Math.signum(f1))
        {
          j = paramInt3;
          i = paramInt4;
          if (Math.signum(paramInt4) == Math.signum(f2))
          {
            j = (int)(paramInt3 + f1);
            i = (int)(paramInt4 + f2);
          }
        }
      }
    }
    mMode = 1;
    MH.b(paramInt1, j, paramInt5, paramInt6, paramInt9);
    MI.b(paramInt2, i, paramInt7, paramInt8, paramInt10);
  }

  public float getCurrVelocity()
  {
    return (float)Math.hypot(a.c(MH), a.c(MI));
  }

  public final int getCurrY()
  {
    return a.b(MI);
  }

  public final boolean isFinished()
  {
    return (a.a(MH)) && (a.a(MI));
  }

  public void notifyVerticalEdgeReached(int paramInt1, int paramInt2, int paramInt3)
  {
    MI.k(paramInt1, paramInt2, paramInt3);
  }

  public boolean springBack(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    mMode = 1;
    boolean bool1 = MH.g(paramInt1, paramInt3, paramInt4);
    boolean bool2 = MI.g(paramInt2, paramInt5, paramInt6);
    return (bool1) || (bool2);
  }

  static class a
  {
    private static float MT = (float)(Math.log(0.78D) / Math.log(0.9D));
    private static final float[] MU = new float[101];
    private static final float[] MV = new float[101];
    private int MK;
    private int ML;
    private float MM;
    private float MN;
    private int MO;
    private int MP;
    private int MQ;
    private float MR = ViewConfiguration.getScrollFriction();
    private final float MS;
    private int mCurrentPosition;
    private int mDuration;
    private boolean mFinished = true;
    private int mStart;
    private long mStartTime;
    private int mState = 0;

    static
    {
      float f1 = 0.0F;
      float f2 = 0.0F;
      int i = 0;
      if (i < 100)
      {
        float f5 = i / 100.0F;
        float f3 = 1.0F;
        label55: float f4 = f1 + (f3 - f1) / 2.0F;
        float f6 = 3.0F * f4 * (1.0F - f4);
        float f7 = ((1.0F - f4) * 0.175F + 0.35F * f4) * f6 + f4 * f4 * f4;
        if (Math.abs(f7 - f5) < 1.E-005D)
        {
          MU[i] = (((1.0F - f4) * 0.5F + f4) * f6 + f4 * f4 * f4);
          f3 = 1.0F;
        }
        while (true)
        {
          f4 = f2 + (f3 - f2) / 2.0F;
          f6 = 3.0F * f4 * (1.0F - f4);
          f7 = ((1.0F - f4) * 0.5F + f4) * f6 + f4 * f4 * f4;
          if (Math.abs(f7 - f5) < 1.E-005D)
          {
            MV[i] = (((1.0F - f4) * 0.175F + 0.35F * f4) * f6 + f4 * f4 * f4);
            i += 1;
            break;
            if (f7 > f5)
            {
              f3 = f4;
              break label55;
            }
            f1 = f4;
            break label55;
          }
          if (f7 > f5)
            f3 = f4;
          else
            f2 = f4;
        }
      }
      float[] arrayOfFloat = MU;
      MV[100] = 1.0F;
      arrayOfFloat[100] = 1.0F;
    }

    a(Context paramContext)
    {
      MS = (386.0878F * (paramContext.getResources().getDisplayMetrics().density * 160.0F) * 0.84F);
    }

    private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      int j = 1;
      if ((paramInt1 > paramInt2) && (paramInt1 < paramInt3))
      {
        Log.e("OverScroller", "startAfterEdge called from a valid position");
        mFinished = true;
        return;
      }
      int i;
      if (paramInt1 > paramInt3)
      {
        i = 1;
        if (i == 0)
          break label73;
        paramInt2 = paramInt3;
        label42: if ((paramInt1 - paramInt2) * paramInt4 < 0)
          break label76;
      }
      label73: label76: for (paramInt3 = j; ; paramInt3 = 0)
      {
        if (paramInt3 == 0)
          break label81;
        j(paramInt1, paramInt2, paramInt4);
        return;
        i = 0;
        break;
        break label42;
      }
      label81: cn(paramInt4);
      h(paramInt1, paramInt2, paramInt4);
    }

    private static float cl(int paramInt)
    {
      if (paramInt > 0)
        return -2000.0F;
      return 2000.0F;
    }

    private double cm(int paramInt)
    {
      return Math.log(0.35F * Math.abs(paramInt) / (MR * MS));
    }

    private double cn(int paramInt)
    {
      double d1 = cm(paramInt);
      double d2 = MT;
      return MR * MS * Math.exp(MT / (d2 - 1.0D) * d1);
    }

    private int co(int paramInt)
    {
      return (int)(1000.0D * Math.exp(cm(paramInt) / (MT - 1.0D)));
    }

    private void f(int paramInt1, int paramInt2, int paramInt3)
    {
      float f3 = Math.abs((paramInt3 - paramInt1) / (paramInt2 - paramInt1));
      paramInt1 = (int)(100.0F * f3);
      if (paramInt1 < 100)
      {
        float f4 = paramInt1 / 100.0F;
        float f5 = (paramInt1 + 1) / 100.0F;
        float f1 = MV[paramInt1];
        float f2 = MV[(paramInt1 + 1)];
        f3 = (f3 - f4) / (f5 - f4);
        mDuration = ((int)(mDuration * (f1 + f3 * (f2 - f1))));
      }
    }

    private void h(int paramInt1, int paramInt2, int paramInt3)
    {
      mFinished = false;
      mState = 1;
      mStart = paramInt1;
      MK = paramInt2;
      paramInt1 -= paramInt2;
      MN = cl(paramInt1);
      ML = (-paramInt1);
      MQ = Math.abs(paramInt1);
      mDuration = ((int)(1000.0D * Math.sqrt(-2.0D * paramInt1 / MN)));
    }

    private void i(int paramInt1, int paramInt2, int paramInt3)
    {
      float f1 = -paramInt3 / MN;
      float f2 = (float)Math.sqrt(2.0D * (paramInt3 * paramInt3 / 2.0F / Math.abs(MN) + Math.abs(paramInt2 - paramInt1)) / Math.abs(MN));
      mStartTime -= (int)(1000.0F * (f2 - f1));
      mStart = paramInt2;
      ML = ((int)(-MN * f2));
    }

    private void j(int paramInt1, int paramInt2, int paramInt3)
    {
      if (paramInt3 == 0);
      for (int i = paramInt1 - paramInt2; ; i = paramInt3)
      {
        MN = cl(i);
        i(paramInt1, paramInt2, paramInt3);
        mT();
        return;
      }
    }

    private void mT()
    {
      float f2 = ML * ML / (Math.abs(MN) * 2.0F);
      float f3 = Math.signum(ML);
      float f1 = f2;
      if (f2 > MQ)
      {
        MN = (-f3 * ML * ML / (MQ * 2.0F));
        f1 = MQ;
      }
      MQ = ((int)f1);
      mState = 2;
      int i = mStart;
      if (ML > 0);
      while (true)
      {
        MK = (i + (int)f1);
        mDuration = (-(int)(1000.0F * ML / MN));
        return;
        f1 = -f1;
      }
    }

    void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      MQ = paramInt5;
      mFinished = false;
      ML = paramInt2;
      MM = paramInt2;
      MO = 0;
      mDuration = 0;
      mStartTime = AnimationUtils.currentAnimationTimeMillis();
      mStart = paramInt1;
      mCurrentPosition = paramInt1;
      if ((paramInt1 > paramInt4) || (paramInt1 < paramInt3))
        a(paramInt1, paramInt3, paramInt4, paramInt2);
      do
      {
        return;
        mState = 0;
        double d = 0.0D;
        if (paramInt2 != 0)
        {
          paramInt5 = co(paramInt2);
          MO = paramInt5;
          mDuration = paramInt5;
          d = cn(paramInt2);
        }
        MP = ((int)(Math.signum(paramInt2) * d));
        MK = (MP + paramInt1);
        if (MK < paramInt3)
        {
          f(mStart, MK, paramInt3);
          MK = paramInt3;
        }
      }
      while (MK <= paramInt4);
      f(mStart, MK, paramInt4);
      MK = paramInt4;
    }

    void e(float paramFloat)
    {
      mCurrentPosition = (mStart + Math.round((MK - mStart) * paramFloat));
    }

    void finish()
    {
      mCurrentPosition = MK;
      mFinished = true;
    }

    boolean g(int paramInt1, int paramInt2, int paramInt3)
    {
      mFinished = true;
      MK = paramInt1;
      mStart = paramInt1;
      ML = 0;
      mStartTime = AnimationUtils.currentAnimationTimeMillis();
      mDuration = 0;
      if (paramInt1 < paramInt2)
        h(paramInt1, paramInt2, 0);
      while (!mFinished)
      {
        return true;
        if (paramInt1 > paramInt3)
          h(paramInt1, paramInt3, 0);
      }
      return false;
    }

    void k(int paramInt1, int paramInt2, int paramInt3)
    {
      if (mState == 0)
      {
        MQ = paramInt3;
        mStartTime = AnimationUtils.currentAnimationTimeMillis();
        a(paramInt1, paramInt2, paramInt2, (int)MM);
      }
    }

    boolean mU()
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      switch (mState)
      {
      default:
      case 1:
      case 0:
      case 2:
      }
      while (true)
      {
        mV();
        bool1 = true;
        do
        {
          return bool1;
          bool1 = bool2;
        }
        while (mDuration >= MO);
        mStart = MK;
        ML = ((int)MM);
        MN = cl(ML);
        mStartTime += mDuration;
        mT();
        continue;
        mStartTime += mDuration;
        h(MK, mStart, 0);
      }
    }

    boolean mV()
    {
      long l = AnimationUtils.currentAnimationTimeMillis() - mStartTime;
      if (l > mDuration)
        return false;
      double d = 0.0D;
      switch (mState)
      {
      default:
      case 0:
      case 2:
      case 1:
      }
      while (true)
      {
        mCurrentPosition = (mStart + (int)Math.round(d));
        return true;
        float f3 = (float)l / MO;
        int i = (int)(100.0F * f3);
        float f1 = 1.0F;
        float f2 = 0.0F;
        if (i < 100)
        {
          f1 = i / 100.0F;
          f2 = (i + 1) / 100.0F;
          float f4 = MU[i];
          f2 = (MU[(i + 1)] - f4) / (f2 - f1);
          f1 = f4 + (f3 - f1) * f2;
        }
        d = MP * f1;
        MM = (MP * f2 / MO * 1000.0F);
        continue;
        f1 = (float)l / 1000.0F;
        MM = (ML + MN * f1);
        d = ML * f1 + MN * f1 * f1 / 2.0F;
        continue;
        f1 = (float)l / mDuration;
        f2 = f1 * f1;
        f3 = Math.signum(ML);
        d = MQ * f3 * (3.0F * f2 - 2.0F * f1 * f2);
        MM = (MQ * f3 * 6.0F * (-f1 + f2));
      }
    }
  }
}