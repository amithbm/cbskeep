package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.internal.view.ViewPropertyAnimatorCompatSet;
import android.support.v7.widget.ActionMenuPresenter;
import android.support.v7.widget.ActionMenuView;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

abstract class AbsActionBarView extends ViewGroup
{
  private static final Interpolator sAlphaInterpolator = new DecelerateInterpolator();
  protected ActionMenuPresenter mActionMenuPresenter;
  protected int mContentHeight;
  protected ActionMenuView mMenuView;
  protected final Context mPopupContext;
  protected boolean mSplitActionBar;
  protected ViewGroup mSplitView;
  protected final VisibilityAnimListener mVisAnimListener = new VisibilityAnimListener();
  protected ViewPropertyAnimatorCompat mVisibilityAnim;

  AbsActionBarView(Context paramContext)
  {
    this(paramContext, null);
  }

  AbsActionBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  AbsActionBarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = new TypedValue();
    if ((paramContext.getTheme().resolveAttribute(R.attr.actionBarPopupTheme, paramAttributeSet, true)) && (paramAttributeSet.resourceId != 0))
    {
      mPopupContext = new ContextThemeWrapper(paramContext, paramAttributeSet.resourceId);
      return;
    }
    mPopupContext = paramContext;
  }

  protected static int next(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramBoolean)
      return paramInt1 - paramInt2;
    return paramInt1 + paramInt2;
  }

  public void animateToVisibility(int paramInt)
  {
    if (mVisibilityAnim != null)
      mVisibilityAnim.cancel();
    ViewPropertyAnimatorCompatSet localViewPropertyAnimatorCompatSet;
    ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat2;
    if (paramInt == 0)
    {
      if (getVisibility() != 0)
      {
        ViewCompat.setAlpha(this, 0.0F);
        if ((mSplitView != null) && (mMenuView != null))
          ViewCompat.setAlpha(mMenuView, 0.0F);
      }
      localViewPropertyAnimatorCompat1 = ViewCompat.animate(this).alpha(1.0F);
      localViewPropertyAnimatorCompat1.setDuration(200L);
      localViewPropertyAnimatorCompat1.setInterpolator(sAlphaInterpolator);
      if ((mSplitView != null) && (mMenuView != null))
      {
        localViewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
        localViewPropertyAnimatorCompat2 = ViewCompat.animate(mMenuView).alpha(1.0F);
        localViewPropertyAnimatorCompat2.setDuration(200L);
        localViewPropertyAnimatorCompatSet.setListener(mVisAnimListener.withFinalVisibility(localViewPropertyAnimatorCompat1, paramInt));
        localViewPropertyAnimatorCompatSet.play(localViewPropertyAnimatorCompat1).play(localViewPropertyAnimatorCompat2);
        localViewPropertyAnimatorCompatSet.start();
        return;
      }
      localViewPropertyAnimatorCompat1.setListener(mVisAnimListener.withFinalVisibility(localViewPropertyAnimatorCompat1, paramInt));
      localViewPropertyAnimatorCompat1.start();
      return;
    }
    ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat1 = ViewCompat.animate(this).alpha(0.0F);
    localViewPropertyAnimatorCompat1.setDuration(200L);
    localViewPropertyAnimatorCompat1.setInterpolator(sAlphaInterpolator);
    if ((mSplitView != null) && (mMenuView != null))
    {
      localViewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
      localViewPropertyAnimatorCompat2 = ViewCompat.animate(mMenuView).alpha(0.0F);
      localViewPropertyAnimatorCompat2.setDuration(200L);
      localViewPropertyAnimatorCompatSet.setListener(mVisAnimListener.withFinalVisibility(localViewPropertyAnimatorCompat1, paramInt));
      localViewPropertyAnimatorCompatSet.play(localViewPropertyAnimatorCompat1).play(localViewPropertyAnimatorCompat2);
      localViewPropertyAnimatorCompatSet.start();
      return;
    }
    localViewPropertyAnimatorCompat1.setListener(mVisAnimListener.withFinalVisibility(localViewPropertyAnimatorCompat1, paramInt));
    localViewPropertyAnimatorCompat1.start();
  }

  protected int measureChildView(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt1, -2147483648), paramInt2);
    return Math.max(0, paramInt1 - paramView.getMeasuredWidth() - paramInt3);
  }

  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (Build.VERSION.SDK_INT >= 8)
      super.onConfigurationChanged(paramConfiguration);
    TypedArray localTypedArray = getContext().obtainStyledAttributes(null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
    setContentHeight(localTypedArray.getLayoutDimension(R.styleable.ActionBar_height, 0));
    localTypedArray.recycle();
    if (mActionMenuPresenter != null)
      mActionMenuPresenter.onConfigurationChanged(paramConfiguration);
  }

  protected int positionChild(View paramView, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    int i = paramView.getMeasuredWidth();
    int j = paramView.getMeasuredHeight();
    paramInt2 += (paramInt3 - j) / 2;
    if (paramBoolean)
      paramView.layout(paramInt1 - i, paramInt2, paramInt1, paramInt2 + j);
    while (true)
    {
      paramInt1 = i;
      if (paramBoolean)
        paramInt1 = -i;
      return paramInt1;
      paramView.layout(paramInt1, paramInt2, paramInt1 + i, paramInt2 + j);
    }
  }

  public void setContentHeight(int paramInt)
  {
    mContentHeight = paramInt;
    requestLayout();
  }

  public boolean showOverflowMenu()
  {
    if (mActionMenuPresenter != null)
      return mActionMenuPresenter.showOverflowMenu();
    return false;
  }

  protected class VisibilityAnimListener
    implements ViewPropertyAnimatorListener
  {
    private boolean mCanceled = false;
    int mFinalVisibility;

    protected VisibilityAnimListener()
    {
    }

    public void onAnimationCancel(View paramView)
    {
      mCanceled = true;
    }

    public void onAnimationEnd(View paramView)
    {
      if (mCanceled);
      do
      {
        return;
        mVisibilityAnim = null;
        setVisibility(mFinalVisibility);
      }
      while ((mSplitView == null) || (mMenuView == null));
      mMenuView.setVisibility(mFinalVisibility);
    }

    public void onAnimationStart(View paramView)
    {
      setVisibility(0);
      mCanceled = false;
    }

    public VisibilityAnimListener withFinalVisibility(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, int paramInt)
    {
      mVisibilityAnim = paramViewPropertyAnimatorCompat;
      mFinalVisibility = paramInt;
      return this;
    }
  }
}