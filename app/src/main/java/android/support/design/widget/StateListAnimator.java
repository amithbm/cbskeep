package android.support.design.widget;

import android.util.StateSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

final class StateListAnimator
{
  private Animation.AnimationListener mAnimationListener = new Animation.AnimationListener()
  {
    public void onAnimationEnd(Animation paramAnonymousAnimation)
    {
      if (mRunningAnimation == paramAnonymousAnimation)
        StateListAnimator.access$002(StateListAnimator.this, null);
    }

    public void onAnimationRepeat(Animation paramAnonymousAnimation)
    {
    }

    public void onAnimationStart(Animation paramAnonymousAnimation)
    {
    }
  };
  private Tuple mLastMatch = null;
  private Animation mRunningAnimation = null;
  private final ArrayList<Tuple> mTuples = new ArrayList();
  private WeakReference<View> mViewRef;

  private void cancel()
  {
    if (mRunningAnimation != null)
    {
      View localView = getTarget();
      if ((localView != null) && (localView.getAnimation() == mRunningAnimation))
        localView.clearAnimation();
      mRunningAnimation = null;
    }
  }

  private void clearTarget()
  {
    View localView = getTarget();
    int j = mTuples.size();
    int i = 0;
    while (i < j)
    {
      Animation localAnimation = ((Tuple)mTuples.get(i)).mAnimation;
      if (localView.getAnimation() == localAnimation)
        localView.clearAnimation();
      i += 1;
    }
    mViewRef = null;
    mLastMatch = null;
    mRunningAnimation = null;
  }

  private void start(Tuple paramTuple)
  {
    mRunningAnimation = paramTuple.mAnimation;
    paramTuple = getTarget();
    if (paramTuple != null)
      paramTuple.startAnimation(mRunningAnimation);
  }

  public void addState(int[] paramArrayOfInt, Animation paramAnimation)
  {
    paramArrayOfInt = new Tuple(paramArrayOfInt, paramAnimation, null);
    paramAnimation.setAnimationListener(mAnimationListener);
    mTuples.add(paramArrayOfInt);
  }

  View getTarget()
  {
    if (mViewRef == null)
      return null;
    return (View)mViewRef.get();
  }

  public void jumpToCurrentState()
  {
    if (mRunningAnimation != null)
    {
      View localView = getTarget();
      if ((localView != null) && (localView.getAnimation() == mRunningAnimation))
        localView.clearAnimation();
    }
  }

  void setState(int[] paramArrayOfInt)
  {
    Object localObject2 = null;
    int j = mTuples.size();
    int i = 0;
    Object localObject1 = localObject2;
    if (i < j)
    {
      localObject1 = (Tuple)mTuples.get(i);
      if (!StateSet.stateSetMatches(((Tuple)localObject1).mSpecs, paramArrayOfInt));
    }
    else
    {
      if (localObject1 != mLastMatch)
        break label64;
    }
    label64: 
    do
    {
      return;
      i += 1;
      break;
      if (mLastMatch != null)
        cancel();
      mLastMatch = ((Tuple)localObject1);
    }
    while (localObject1 == null);
    start((Tuple)localObject1);
  }

  void setTarget(View paramView)
  {
    View localView = getTarget();
    if (localView == paramView);
    do
    {
      return;
      if (localView != null)
        clearTarget();
    }
    while (paramView == null);
    mViewRef = new WeakReference(paramView);
  }

  static class Tuple
  {
    final Animation mAnimation;
    final int[] mSpecs;

    private Tuple(int[] paramArrayOfInt, Animation paramAnimation)
    {
      mSpecs = paramArrayOfInt;
      mAnimation = paramAnimation;
    }
  }
}