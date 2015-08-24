package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

class FloatingActionButtonHoneycombMr1 extends FloatingActionButtonEclairMr1
{
  private boolean mIsHiding;

  FloatingActionButtonHoneycombMr1(View paramView, ShadowViewDelegate paramShadowViewDelegate)
  {
    super(paramView, paramShadowViewDelegate);
  }

  void hide()
  {
    if (mIsHiding)
      return;
    mView.animate().scaleX(0.0F).scaleY(0.0F).alpha(0.0F).setDuration(200L).setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR).setListener(new AnimatorListenerAdapter()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        FloatingActionButtonHoneycombMr1.access$002(FloatingActionButtonHoneycombMr1.this, false);
      }

      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        FloatingActionButtonHoneycombMr1.access$002(FloatingActionButtonHoneycombMr1.this, false);
        mView.setVisibility(8);
      }

      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        FloatingActionButtonHoneycombMr1.access$002(FloatingActionButtonHoneycombMr1.this, true);
      }
    });
  }

  void show()
  {
    mView.animate().scaleX(1.0F).scaleY(1.0F).alpha(1.0F).setDuration(200L).setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR).setListener(null);
  }
}