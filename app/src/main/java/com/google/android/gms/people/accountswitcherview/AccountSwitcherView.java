package com.google.android.gms.people.accountswitcherview;

import android.animation.ObjectAnimator;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import com.google.android.gms.people.model.Owner;
import java.util.List;

public class AccountSwitcherView extends FrameLayout
  implements View.OnClickListener, AdapterView.OnItemClickListener, SelectedAccountNavigationView.AccountChangeListener, SelectedAccountNavigationView.NavigationModeChangeListener
{
  private AccountSelectedListener mAccountSelectedListener;
  private ShrinkingItem mAccountShrinkingWrapper;
  private OwnersListAdapter mAccountsAdapter;
  private AddAccountListener mAddAccountListener;
  private int mCurrentHeaderTop;
  private boolean mDrawScrimInPadding;
  private View mDrawerView;
  private ManageAccountsListener mManageAccountsListener;
  private FrameLayout mNavContainer;
  private int mNavContainerTop;
  private NavigationModeChangeListener mNavigationModeListener;
  private List<Owner> mOwners;
  public ScrimDrawable mScrimDrawable;
  private boolean mScrollOff;
  private Owner mSelectedAccount;
  private SelectedAccountNavigationView mSelectedAccountView;
  private boolean mShowSignIn;
  private ViewGroup mSignIn;
  private SignInListener mSignInListener;
  private ExpanderView mSignInShowHideAccounts;

  private void animateAccountWrapper(boolean paramBoolean, Interpolator paramInterpolator)
  {
    int j;
    if (paramBoolean)
      j = 0;
    for (int i = 1; isAtLeastVersion(11); i = 0)
    {
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(mAccountShrinkingWrapper, "animatedHeightFraction", new float[] { j, i });
      localObjectAnimator.setDuration(200L);
      localObjectAnimator.setInterpolator(paramInterpolator);
      localObjectAnimator.start();
      return;
      j = 1;
    }
    mAccountShrinkingWrapper.setAnimatedHeightFraction(i);
  }

  private void applyTopInset(int paramInt)
  {
    mSignIn.setPadding(mSignIn.getPaddingLeft(), paramInt, mSignIn.getPaddingRight(), mSignIn.getPaddingBottom());
    mScrimDrawable.setIntrinsicHeight(paramInt);
    mSelectedAccountView.applyTopInset(paramInt);
  }

  public static boolean isAtLeastL()
  {
    return isAtLeastVersion(21);
  }

  public static boolean isAtLeastVersion(int paramInt)
  {
    return Build.VERSION.SDK_INT >= paramInt;
  }

  private void offsetHeader(View paramView, int paramInt)
  {
    paramView.offsetTopAndBottom(paramInt);
    mCurrentHeaderTop = paramView.getTop();
  }

  private void offsetNav(int paramInt)
  {
    mNavContainer.offsetTopAndBottom(paramInt);
    mNavContainerTop = mNavContainer.getTop();
  }

  private void setNavigationModeInternal(int paramInt)
  {
    mSelectedAccountView.setNavigationMode(paramInt);
  }

  private void setSelectedAccount(Owner paramOwner, boolean paramBoolean)
  {
    Owner localOwner = mSelectedAccount;
    mSelectedAccount = paramOwner;
    if (mOwners != null)
    {
      mOwners = OwnersListAdapter.removeSelectedAccount(mOwners, localOwner, mSelectedAccount);
      if (!paramBoolean)
        mSelectedAccountView.bind(mSelectedAccount);
      mAccountsAdapter.setOwners(mOwners);
      return;
    }
    mSelectedAccountView.bind(null);
  }

  private void updateVisibility(boolean paramBoolean)
  {
    AlphaAnimation localAlphaAnimation;
    switch (mSelectedAccountView.getNavigationMode())
    {
    default:
      return;
    case 0:
      if (paramBoolean)
      {
        localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
        localAlphaAnimation.setDuration(200L);
        mNavContainer.setAnimation(localAlphaAnimation);
        animateAccountWrapper(false, new AccelerateInterpolator(0.8F));
      }
      while (true)
      {
        mNavContainer.setVisibility(0);
        mAccountShrinkingWrapper.setVisibility(8);
        return;
        mNavContainer.setAnimation(null);
      }
    case 1:
    }
    if (paramBoolean)
    {
      localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setDuration(200L);
      localAlphaAnimation.setStartOffset(133L);
      animateAccountWrapper(true, new DecelerateInterpolator(0.8F));
    }
    while (true)
    {
      mNavContainer.setVisibility(8);
      mAccountShrinkingWrapper.setVisibility(0);
      return;
      mNavContainer.setAnimation(null);
    }
  }

  public int getNestedScrollAxes()
  {
    return 2;
  }

  public void onAccountChange(Owner paramOwner)
  {
    setSelectedAccount(paramOwner, true);
    if (mAccountSelectedListener != null)
      mAccountSelectedListener.onAccountSelected(mSelectedAccount);
  }

  public void onClick(View paramView)
  {
    boolean bool = true;
    if (paramView == mSignIn)
      if (mSignInListener != null)
        mSignInListener.onSignIn();
    while (paramView != mSignInShowHideAccounts)
      return;
    int i;
    if (mSelectedAccountView.getNavigationMode() == 1)
    {
      i = 0;
      setNavigationModeInternal(i);
      paramView = mSignInShowHideAccounts;
      if (mSelectedAccountView.getNavigationMode() != 1)
        break label88;
    }
    while (true)
    {
      paramView.setExpanded(bool);
      onNavigationModeChange(mSelectedAccountView);
      return;
      i = 1;
      break;
      label88: bool = false;
    }
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (mDrawerView != null)
    {
      mDrawerView.setOnApplyWindowInsetsListener(null);
      mDrawerView = null;
    }
  }

  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (mAccountsAdapter.getItemViewType(paramInt) == 0)
    {
      setSelectedAccount(mAccountsAdapter.getItem(paramInt), false);
      if (mAccountSelectedListener != null)
        mAccountSelectedListener.onAccountSelected(mSelectedAccount);
    }
    do
    {
      do
      {
        return;
        if (mAccountsAdapter.getItemViewType(paramInt) != 1)
          break;
      }
      while (mAddAccountListener == null);
      mAddAccountListener.onAddAccountSelected();
      return;
    }
    while ((mAccountsAdapter.getItemViewType(paramInt) != 2) || (mManageAccountsListener == null));
    mManageAccountsListener.onManageAccountsSelected();
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (mShowSignIn);
    for (Object localObject = mSignIn; ; localObject = mSelectedAccountView)
    {
      if (mCurrentHeaderTop != ((View)localObject).getTop())
        ((View)localObject).offsetTopAndBottom(mCurrentHeaderTop - ((View)localObject).getTop());
      if (mNavContainerTop != mNavContainer.getTop())
        mNavContainer.offsetTopAndBottom(mNavContainerTop - mNavContainer.getTop());
      return;
    }
  }

  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt2 = 0;
    while (true)
    {
      if (paramInt2 < getChildCount())
      {
        if (!getChildAt(paramInt2).equals(mNavContainer))
          break label119;
        if (!mShowSignIn)
          break label103;
        paramInt2 = mSignIn.getMeasuredHeight();
        mNavContainer.setPadding(mNavContainer.getPaddingLeft(), paramInt2, mNavContainer.getPaddingRight(), mNavContainer.getPaddingBottom());
        if (!mScrollOff)
          break label114;
      }
      while (true)
      {
        mNavContainer.measure(paramInt1, View.MeasureSpec.makeMeasureSpec(getHeight(), 1073741824) + paramInt2);
        return;
        label103: paramInt2 = mSelectedAccountView.getMeasuredHeight();
        break;
        label114: paramInt2 = 0;
      }
      label119: paramInt2 += 1;
    }
  }

  public void onNavigationModeChange(SelectedAccountNavigationView paramSelectedAccountNavigationView)
  {
    updateVisibility(true);
    if (mNavigationModeListener != null)
      mNavigationModeListener.onNavigationModeChange(mSelectedAccountView.getNavigationMode());
  }

  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (mShowSignIn);
    for (paramView = mSignIn; (!paramBoolean) && (paramFloat2 < 0.0F) && (paramView.getBottom() < 0); paramView = mSelectedAccountView)
    {
      offsetHeader(paramView, -paramView.getTop());
      offsetNav(-paramView.getTop());
      return true;
    }
    if ((paramBoolean) && (paramFloat2 > 0.0F))
    {
      if (paramView.getTop() > -paramView.getMeasuredHeight())
        offsetHeader(paramView, -paramView.getMeasuredHeight() - paramView.getTop());
      if (mNavContainer.getTop() > -paramView.getMeasuredHeight())
        offsetNav(-paramView.getMeasuredHeight() - mNavContainer.getTop());
    }
    return false;
  }

  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    if (mShowSignIn);
    for (paramView = mSignIn; mSelectedAccountView.getNavigationMode() == 1; paramView = mSelectedAccountView)
      return;
    int i = 0;
    paramInt1 = i;
    if (paramInt2 > 0)
    {
      paramInt1 = i;
      if (paramView.getBottom() > 0)
      {
        if (paramView.getBottom() <= paramInt2)
          break label141;
        paramInt1 = -paramInt2;
      }
    }
    label63: if (paramInt1 != 0)
    {
      if (paramView.getTop() + paramInt1 >= -paramView.getMeasuredHeight())
        break label150;
      offsetHeader(paramView, -paramView.getMeasuredHeight() - paramView.getTop());
      label96: if (mNavContainer.getTop() + paramInt1 >= -paramView.getMeasuredHeight())
        break label159;
      offsetNav(-paramView.getMeasuredHeight() - mNavContainer.getTop());
    }
    while (true)
    {
      paramArrayOfInt[0] = 0;
      paramArrayOfInt[1] = paramInt1;
      return;
      label141: paramInt1 = -paramView.getBottom();
      break label63;
      break;
      label150: offsetHeader(paramView, paramInt1);
      break label96;
      label159: offsetNav(paramInt1);
    }
  }

  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = 0;
    if (mShowSignIn)
    {
      paramView = mSignIn;
      paramInt1 = paramInt2;
      if (paramInt4 < 0)
      {
        paramInt1 = paramInt2;
        if (paramView.getTop() < 0)
        {
          if (paramInt4 > paramView.getTop())
            break label108;
          paramInt1 = paramView.getTop();
        }
      }
      label44: if (paramInt1 != 0)
      {
        if (paramView.getTop() - paramInt1 <= 0)
          break label114;
        offsetHeader(paramView, -paramView.getTop());
      }
    }
    while (true)
    {
      if (mNavContainer.getTop() - paramInt1 <= paramView.getMeasuredHeight())
        break label124;
      offsetNav(paramView.getMeasuredHeight() - mNavContainer.getTop());
      return;
      paramView = mSelectedAccountView;
      break;
      label108: paramInt1 = paramInt4;
      break label44;
      label114: offsetHeader(paramView, -paramInt1);
    }
    label124: offsetNav(-paramInt1);
  }

  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    return mScrollOff;
  }

  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = paramInt2;
    if (mDrawScrimInPadding)
    {
      applyTopInset(paramInt2);
      i = 0;
    }
    super.setPadding(paramInt1, i, paramInt3, paramInt4);
  }

  public void setPaddingRelative(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = paramInt2;
    if (mDrawScrimInPadding)
    {
      applyTopInset(paramInt2);
      i = 0;
    }
    super.setPaddingRelative(paramInt1, i, paramInt3, paramInt4);
  }

  public static abstract interface AccountSelectedListener
  {
    public abstract void onAccountSelected(Owner paramOwner);
  }

  public static abstract interface AddAccountListener
  {
    public abstract void onAddAccountSelected();
  }

  public static abstract interface ManageAccountsListener
  {
    public abstract void onManageAccountsSelected();
  }

  public static abstract interface NavigationModeChangeListener
  {
    public abstract void onNavigationModeChange(int paramInt);
  }

  public static abstract interface SignInListener
  {
    public abstract void onSignIn();
  }
}