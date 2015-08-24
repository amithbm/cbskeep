package com.google.android.keep.editor;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.text.TextUtils;
import android.view.animation.DecelerateInterpolator;
import com.google.android.keep.f.c;
import com.google.android.keep.ui.j;
import com.google.android.keep.ui.j.a;

public class f
  implements j.a
{
  private j lI;
  private f.c lJ;
  private f.c lK;

  public f(j paramj, f.c paramc1, f.c paramc2)
  {
    lI = paramj;
    lK = paramc1;
    lJ = paramc2;
  }

  private void a(Animator paramAnimator)
  {
    if (paramAnimator == null)
      return;
    paramAnimator.setDuration(200L);
    paramAnimator.setInterpolator(new DecelerateInterpolator());
  }

  public void dA()
  {
    if (lI.getAlpha() != 0.0F);
    ObjectAnimator localObjectAnimator;
    do
    {
      return;
      localObjectAnimator = com.google.android.keep.f.a(lI, new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          f.a(f.this).setAlpha(1.0F);
        }
      });
    }
    while (localObjectAnimator == null);
    a(localObjectAnimator);
    localObjectAnimator.start();
  }

  public void dB()
  {
    if (lI.getAlpha() != 1.0F)
      return;
    ObjectAnimator localObjectAnimator1 = com.google.android.keep.f.b(lI, new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        f.a(f.this).setAlpha(0.0F);
      }
    });
    ObjectAnimator localObjectAnimator2 = com.google.android.keep.f.a(lI, f.c.f(lI), lK);
    a(localObjectAnimator1);
    a(localObjectAnimator2);
    com.google.android.keep.f.playSequentially(new Animator[] { localObjectAnimator1, localObjectAnimator2 });
  }

  public void dC()
  {
    if (lI.getPaddingTop() == lJ.top);
    ObjectAnimator localObjectAnimator;
    do
    {
      return;
      localObjectAnimator = com.google.android.keep.f.a(lI, f.c.f(lI), lJ);
    }
    while (localObjectAnimator == null);
    a(localObjectAnimator);
    localObjectAnimator.start();
  }

  public void dD()
  {
    if (lI.getPaddingTop() == lK.top);
    ObjectAnimator localObjectAnimator;
    do
    {
      return;
      localObjectAnimator = com.google.android.keep.f.a(lI, f.c.f(lI), lK);
    }
    while (localObjectAnimator == null);
    a(localObjectAnimator);
    localObjectAnimator.start();
  }

  public void dz()
  {
    if ((!lI.hasFocus()) && (TextUtils.isEmpty(lI.getText().toString())))
      dB();
  }
}