package com.google.android.keep;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.util.Property;
import android.view.View;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.List;

public class f
{
  public static Animator.AnimatorListener a(View paramView)
  {
    return new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        val$view.setVisibility(0);
      }

      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        val$view.setVisibility(0);
      }
    };
  }

  private static Animator.AnimatorListener a(final EditText paramEditText)
  {
    return new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        if (dJ)
        {
          paramEditText.setFocusable(true);
          paramEditText.setFocusableInTouchMode(true);
          paramEditText.requestFocus();
        }
        paramEditText.setSelection(dL, dM);
      }

      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        if (dJ)
        {
          paramEditText.setFocusable(false);
          paramEditText.setFocusableInTouchMode(false);
        }
      }
    };
  }

  public static ObjectAnimator a(View paramView, float paramFloat, Animator.AnimatorListener paramAnimatorListener)
  {
    if (paramView.getTranslationY() >= paramFloat)
      return null;
    return c(paramView, paramFloat, paramAnimatorListener);
  }

  public static ObjectAnimator a(View paramView, Animator.AnimatorListener paramAnimatorListener)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, View.ALPHA, new float[] { paramView.getAlpha(), 1.0F });
    localObjectAnimator.setDuration(250L);
    if (paramAnimatorListener != null)
      localObjectAnimator.addListener(paramAnimatorListener);
    a(paramView, localObjectAnimator);
    return localObjectAnimator;
  }

  public static ObjectAnimator a(View paramView, Animator.AnimatorListener paramAnimatorListener, float paramFloat)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, View.ALPHA, new float[] { paramView.getAlpha(), paramFloat });
    localObjectAnimator.setDuration(250L);
    if (paramAnimatorListener != null)
      localObjectAnimator.addListener(paramAnimatorListener);
    a(paramView, localObjectAnimator);
    return localObjectAnimator;
  }

  public static ObjectAnimator a(View paramView, c paramc1, c paramc2)
  {
    if ((paramc1 == null) || (paramc2 == null) || (paramc1.equals(paramc2)))
      return null;
    paramc1 = ObjectAnimator.ofObject(paramView, new b(b.NAME), new a(), new c[] { paramc1, paramc2 });
    if ((paramView instanceof EditText))
      paramc1.addListener(a((EditText)paramView));
    paramc1.setDuration(250L);
    a(paramView, paramc1);
    return paramc1;
  }

  private static List<Animator> a(Animator[] paramArrayOfAnimator)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayOfAnimator == null);
    while (true)
    {
      return localArrayList;
      int i = 0;
      while (i < paramArrayOfAnimator.length)
      {
        if (paramArrayOfAnimator[i] != null)
          localArrayList.add(paramArrayOfAnimator[i]);
        i += 1;
      }
    }
  }

  private static void a(View paramView, ObjectAnimator paramObjectAnimator)
  {
    paramObjectAnimator.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        val$view.setLayerType(0, null);
      }

      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        val$view.setLayerType(2, null);
      }
    });
  }

  public static Animator.AnimatorListener b(View paramView)
  {
    return new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        val$view.setVisibility(8);
      }
    };
  }

  public static ObjectAnimator b(View paramView, float paramFloat, Animator.AnimatorListener paramAnimatorListener)
  {
    if (paramView.getTranslationY() <= paramFloat)
      return null;
    return c(paramView, paramFloat, paramAnimatorListener);
  }

  public static ObjectAnimator b(View paramView, Animator.AnimatorListener paramAnimatorListener)
  {
    return a(paramView, paramAnimatorListener, 0.0F);
  }

  public static ObjectAnimator c(View paramView)
  {
    return a(paramView, a(paramView));
  }

  public static ObjectAnimator c(View paramView, float paramFloat, Animator.AnimatorListener paramAnimatorListener)
  {
    if ((paramView == null) || (paramView.getTranslationY() == paramFloat))
      return null;
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, View.TRANSLATION_Y, new float[] { paramView.getTranslationY(), paramFloat });
    localObjectAnimator.setDuration(250L);
    if (paramAnimatorListener != null)
      localObjectAnimator.addListener(paramAnimatorListener);
    a(paramView, localObjectAnimator);
    return localObjectAnimator;
  }

  public static ObjectAnimator d(View paramView)
  {
    return b(paramView, b(paramView));
  }

  public static void playSequentially(Animator[] paramArrayOfAnimator)
  {
    paramArrayOfAnimator = a(paramArrayOfAnimator);
    if (paramArrayOfAnimator.size() > 0)
    {
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playSequentially(paramArrayOfAnimator);
      localAnimatorSet.start();
    }
  }

  public static void playTogether(Animator[] paramArrayOfAnimator)
  {
    paramArrayOfAnimator = a(paramArrayOfAnimator);
    if (paramArrayOfAnimator.size() > 0)
    {
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playTogether(paramArrayOfAnimator);
      localAnimatorSet.start();
    }
  }

  static class a
    implements TypeEvaluator<f.c>
  {
    private static int a(float paramFloat, int paramInt1, int paramInt2)
    {
      return (int)(paramInt2 * paramFloat + (1.0F - paramFloat) * paramInt1);
    }

    public f.c a(float paramFloat, f.c paramc1, f.c paramc2)
    {
      return new f.c(a(paramFloat, paramc1.left, paramc2.left), a(paramFloat, paramc1.top, paramc2.top), a(paramFloat, paramc1.right, paramc2.right), a(paramFloat, paramc1.bottom, paramc2.bottom));
    }
  }

  static class b extends Property<View, f.c>
  {
    public static final String NAME = b.class.getSimpleName();

    public b(String paramString)
    {
      super(paramString);
    }

    public void a(View paramView, f.c paramc)
    {
      paramView.setPadding(paramc.left, paramc.top, paramc.right, paramc.bottom);
    }

    public f.c e(View paramView)
    {
      return new f.c(paramView.getPaddingLeft(), paramView.getPaddingTop(), paramView.getPaddingRight(), paramView.getPaddingBottom());
    }
  }

  public static class c
  {
    public final int bottom;
    public int left;
    public int right;
    public final int top;

    public c(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      left = paramInt1;
      top = paramInt2;
      right = paramInt3;
      bottom = paramInt4;
    }

    public static c f(View paramView)
    {
      return new c(paramView.getPaddingLeft(), paramView.getPaddingTop(), paramView.getPaddingRight(), paramView.getPaddingBottom());
    }

    public boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (paramObject != null)
      {
        bool1 = bool2;
        if ((paramObject instanceof c))
        {
          paramObject = (c)paramObject;
          bool1 = bool2;
          if (left == paramObject.left)
          {
            bool1 = bool2;
            if (right == paramObject.right)
            {
              bool1 = bool2;
              if (top == paramObject.top)
              {
                bool1 = bool2;
                if (bottom == paramObject.bottom)
                  bool1 = true;
              }
            }
          }
        }
      }
      return bool1;
    }
  }
}