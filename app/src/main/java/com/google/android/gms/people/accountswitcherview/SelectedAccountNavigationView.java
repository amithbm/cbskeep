package com.google.android.gms.people.accountswitcherview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.people.model.Owner;
import java.util.ArrayList;
import java.util.List;

public class SelectedAccountNavigationView extends FrameLayout
{
  private AccountChangeListener mAccountChangeListener;
  private int mActivePointerId;
  private Interpolator mAnimationInterpolator;
  private OwnersAvatarManager mAvatarLoader;
  private int mAvatarMarginTop;
  private GoogleApiClient mClient;
  private DrawerCloseListener mCloseDrawerListener;
  private OwnersCoverPhotoManager mCoverLoader;
  private AnimatorSet mCurrentAnimation;
  private ViewDecorator mDecorator;
  private int mDefaultHeight;
  private boolean mForceFullHeight;
  private boolean mIsRtl;
  private int mLayoutResId = -1;
  private NavigationModeChangeListener mListener;
  private int mMinVelocity;
  private int mNavigationMode = 0;
  private int mOffscreenAvatarStart;
  private int mOffscreenTextTranslationStart;
  private Owner mPendingBind;
  private Owner mPendingRecent1;
  private Owner mPendingRecent2;
  private Owner mPendingSelectedAccount;
  private float mRecentAvatarSize;
  private ArrayList<Owner> mRecents = new ArrayList(2);
  private float mRecents1Left;
  private int mRecents2Left;
  private Owner mSelectedAccount;
  private int mSelectedAvatarLeft;
  private float mSelectedAvatarSize;
  private int mSelectedAvatarWidth;
  private boolean mShowRecents = AccountSwitcherView.isAtLeastL();
  private float mStartX;
  private float mStartY;
  private boolean mSwiping;
  private int mTouchSlop;
  private VelocityTracker mVelocityTracker;
  private ViewHolderItem mViewHolder;
  private ViewHolderItemCreator mViewHolderItemCreator;

  public SelectedAccountNavigationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    mVelocityTracker = VelocityTracker.obtain();
    mMinVelocity = ViewConfiguration.getMinimumFlingVelocity();
    paramAttributeSet = paramContext.getResources();
    mSelectedAvatarSize = paramAttributeSet.getDimensionPixelSize(R.dimen.selected_account_avatar_size);
    int i;
    if (Build.VERSION.SDK_INT >= 17)
    {
      if (getResources().getConfiguration().getLayoutDirection() == 1)
        mIsRtl = bool;
    }
    else
    {
      if (!AccountSwitcherView.isAtLeastL())
        break label162;
      i = 17563661;
      label117: if (i == -1)
        break label167;
    }
    label162: label167: for (paramContext = AnimationUtils.loadInterpolator(paramContext, i); ; paramContext = new DecelerateInterpolator())
    {
      mAnimationInterpolator = paramContext;
      mDefaultHeight = paramAttributeSet.getDimensionPixelSize(R.dimen.selected_account_height);
      mAvatarMarginTop = paramAttributeSet.getDimensionPixelSize(R.dimen.avatar_margin_top);
      return;
      bool = false;
      break;
      i = -1;
      break label117;
    }
  }

  private void accountChanged()
  {
    if (mAccountChangeListener != null)
      mAccountChangeListener.onAccountChange(mSelectedAccount);
  }

  private void animateAccountSwipeChange()
  {
    AnimatorSet localAnimatorSet = new AnimatorSet();
    Object localObject1 = (ViewGroup.MarginLayoutParams)mViewHolder.recentsAvatar1Image.getLayoutParams();
    Object localObject2 = (ViewGroup.MarginLayoutParams)mViewHolder.recentsAvatar2Image.getLayoutParams();
    int i;
    int j;
    label67: float f2;
    label138: ObjectAnimator localObjectAnimator1;
    if (mIsRtl)
    {
      i = ((ViewGroup.MarginLayoutParams)localObject1).getMarginStart();
      if (!mIsRtl)
        break label623;
      j = ((ViewGroup.MarginLayoutParams)localObject2).getMarginStart();
      if (mRecentAvatarSize == 0.0F)
        mRecentAvatarSize = mViewHolder.recentsAvatar1Image.getWidth();
      f1 = mRecentAvatarSize / mSelectedAvatarSize;
      float f3 = mRecentAvatarSize;
      float f4 = mSelectedAvatarSize;
      if (mRecents.size() <= 1)
        break label633;
      i = mViewHolder.recentsAvatar2.getLeft() + j;
      f2 = i - mViewHolder.selectedAvatar.getLeft() + (mRecentAvatarSize - mSelectedAvatarSize) * 0.5F;
      localObject1 = ObjectAnimator.ofFloat(mViewHolder.selectedAvatar, "translationX", new float[] { f2 });
      localObject2 = ObjectAnimator.ofFloat(mViewHolder.selectedAvatar, "translationY", new float[] { (f3 - f4) * 0.5F });
      localObjectAnimator1 = ObjectAnimator.ofFloat(mViewHolder.selectedAvatar, "scaleY", new float[] { f1 });
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(mViewHolder.selectedAvatar, "scaleX", new float[] { f1 });
      localObject1 = localAnimatorSet.play((Animator)localObject1).with((Animator)localObject2).with(localObjectAnimator2).with(localObjectAnimator1);
      if ((mShowRecents) && (mRecents.size() > 0))
      {
        if (mRecents.size() > 1)
        {
          f1 = mViewHolder.recentsAvatar1.getLeft() - mViewHolder.recentsAvatar2.getLeft();
          ((AnimatorSet.Builder)localObject1).with(ObjectAnimator.ofFloat(mViewHolder.recentsAvatar2, "translationX", new float[] { f1 }));
        }
        if (!mIsRtl)
          break label651;
      }
    }
    label651: for (float f1 = getLeft() - (mViewHolder.recentsAvatar1.getWidth() + mRecents1Left); ; f1 = getWidth() - mViewHolder.recentsAvatar1.getLeft())
    {
      localObject2 = ObjectAnimator.ofFloat(mViewHolder.recentsAvatar1, "translationX", new float[] { f1 });
      localObjectAnimator1 = ObjectAnimator.ofFloat(mViewHolder.recentsAvatar1, "alpha", new float[] { 0.0F });
      ((AnimatorSet.Builder)localObject1).with((Animator)localObject2).with(localObjectAnimator1);
      if (mViewHolder.offscreenAvatar != null)
        ((AnimatorSet.Builder)localObject1).with(ObjectAnimator.ofFloat(mViewHolder.offscreenAvatar, "translationX", new float[] { 0.0F }));
      if (mViewHolder.offscreenText != null)
        animateChangeText((Owner)mRecents.get(0), (AnimatorSet.Builder)localObject1, 0, 0);
      localAnimatorSet.addListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          SelectedAccountNavigationView.this.accountChanged();
          SelectedAccountNavigationView.this.runPendingBinds();
          SelectedAccountNavigationView.this.bindViews();
          SelectedAccountNavigationView.access$302(SelectedAccountNavigationView.this, null);
        }
      });
      localObject1 = mSelectedAccount;
      mSelectedAccount = ((Owner)mRecents.remove(0));
      mRecents.add(localObject1);
      closeDrawer(100);
      localAnimatorSet.setDuration(()(450.0F * (1.0F - mViewHolder.selectedAvatar.getTranslationX() / f2)));
      localAnimatorSet.setInterpolator(mAnimationInterpolator);
      mCurrentAnimation = localAnimatorSet;
      mCurrentAnimation.start();
      return;
      i = ((ViewGroup.MarginLayoutParams)localObject1).leftMargin;
      break;
      label623: j = ((ViewGroup.MarginLayoutParams)localObject2).leftMargin;
      break label67;
      label633: i = mViewHolder.recentsAvatar1.getLeft() + i;
      break label138;
    }
  }

  private void animateAccountTapChange(int paramInt)
  {
    if ((mRecents == null) || (mRecents.size() == 0))
      return;
    AnimatorSet localAnimatorSet = new AnimatorSet();
    Object localObject1;
    label53: Owner localOwner;
    Object localObject3;
    int i;
    label145: ObjectAnimator localObjectAnimator1;
    if (paramInt == 0)
    {
      localObject1 = mViewHolder.recentsAvatar1;
      if (paramInt != 0)
        break label795;
      localObject2 = mViewHolder.recentsAvatar1Image;
      ((View)localObject1).bringToFront();
      localOwner = (Owner)mRecents.get(paramInt);
      if (mRecentAvatarSize == 0.0F)
        mRecentAvatarSize = mViewHolder.recentsAvatar1Image.getWidth();
      localObject2 = (ViewGroup.MarginLayoutParams)((View)localObject2).getLayoutParams();
      localObject3 = ObjectAnimator.ofFloat(mViewHolder.selectedAvatar, "alpha", new float[] { 1.0F, 0.0F });
      if (!mIsRtl)
        break label807;
      i = ((ViewGroup.MarginLayoutParams)localObject2).getMarginStart();
      float f1 = mSelectedAvatarSize / mRecentAvatarSize;
      float f2 = mSelectedAvatarSize;
      float f3 = mRecentAvatarSize;
      float f4 = ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin;
      float f5 = mViewHolder.selectedAvatar.getLeft() - (((View)localObject1).getLeft() + i);
      float f6 = mRecentAvatarSize;
      float f7 = mSelectedAvatarSize;
      localObject3 = localAnimatorSet.play((Animator)localObject3);
      localObject2 = ObjectAnimator.ofFloat(localObject1, "translationX", new float[] { f5 - (f6 - f7) * 0.5F });
      ((ObjectAnimator)localObject2).setDuration(450L);
      localObjectAnimator1 = ObjectAnimator.ofFloat(localObject1, "translationY", new float[] { (f2 - (f3 - f4)) * 0.5F });
      localObjectAnimator1.setDuration(450L);
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(localObject1, "scaleY", new float[] { f1 });
      localObjectAnimator2.setDuration(300L);
      localObject1 = ObjectAnimator.ofFloat(localObject1, "scaleX", new float[] { f1 });
      ((ObjectAnimator)localObject1).setDuration(300L);
      ((AnimatorSet.Builder)localObject3).with((Animator)localObject2).with(localObjectAnimator1).with(localObjectAnimator2).with((Animator)localObject1);
      if (paramInt != 0)
        break label817;
      localObject1 = mViewHolder.crossfadeRecents1;
      label378: if (paramInt != 0)
        break label829;
    }
    label795: label807: label817: label829: for (Object localObject2 = mViewHolder.crossfadeRecents1Image; ; localObject2 = mViewHolder.crossfadeRecents2Image)
    {
      if (localObject2 != null)
        ((ImageView)localObject2).setImageDrawable(mViewHolder.selectedAvatarImage.getDrawable());
      if (localObject1 != null)
      {
        ((View)localObject1).setVisibility(0);
        localObject2 = ObjectAnimator.ofFloat(localObject1, "alpha", new float[] { 1.0F });
        ((ObjectAnimator)localObject2).setDuration(450L);
        localObjectAnimator1 = ObjectAnimator.ofFloat(localObject1, "scaleY", new float[] { 1.0F });
        localObjectAnimator1.setDuration(450L);
        localObject1 = ObjectAnimator.ofFloat(localObject1, "scaleX", new float[] { 1.0F });
        ((ObjectAnimator)localObject1).setDuration(450L);
        ((AnimatorSet.Builder)localObject3).with((Animator)localObject2).with((Animator)localObject1).with(localObjectAnimator1);
      }
      if ((mViewHolder.offscreenText != null) && (mViewHolder.accountText != null))
      {
        mViewHolder.offscreenText.setAlpha(0.0F);
        mViewHolder.offscreenText.setTranslationX(0.0F);
        animateChangeText(localOwner, (AnimatorSet.Builder)localObject3, 150, 0);
      }
      if (mViewHolder.coverPhoto != null)
      {
        localObject1 = ObjectAnimator.ofFloat(mViewHolder.coverPhoto, "alpha", new float[] { 0.0F });
        ((ObjectAnimator)localObject1).setDuration(300L);
        ((AnimatorSet.Builder)localObject3).with((Animator)localObject1);
      }
      if (mViewHolder.offscreenCoverPhoto != null)
      {
        setCoverPhoto(mViewHolder, mViewHolder.offscreenCoverPhoto, localOwner);
        mViewHolder.offscreenCoverPhoto.setVisibility(0);
        localObject1 = ObjectAnimator.ofFloat(mViewHolder.offscreenCoverPhoto, "alpha", new float[] { 1.0F });
        ((ObjectAnimator)localObject1).setDuration(300L);
        ((AnimatorSet.Builder)localObject3).with((Animator)localObject1);
      }
      localAnimatorSet.addListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          SelectedAccountNavigationView.this.accountChanged();
          SelectedAccountNavigationView.this.runPendingBinds();
          SelectedAccountNavigationView.this.bindViews();
          SelectedAccountNavigationView.access$302(SelectedAccountNavigationView.this, null);
        }
      });
      localObject1 = mSelectedAccount;
      mSelectedAccount = ((Owner)mRecents.get(paramInt));
      mRecents.add(paramInt, localObject1);
      mRecents.remove(paramInt + 1);
      closeDrawer(300);
      localAnimatorSet.setInterpolator(mAnimationInterpolator);
      mCurrentAnimation = localAnimatorSet;
      mCurrentAnimation.start();
      return;
      localObject1 = mViewHolder.recentsAvatar2;
      break;
      localObject2 = mViewHolder.recentsAvatar2Image;
      break label53;
      i = ((ViewGroup.MarginLayoutParams)localObject2).leftMargin;
      break label145;
      localObject1 = mViewHolder.crossfadeRecents2;
      break label378;
    }
  }

  private void animateChangeText(Owner paramOwner, AnimatorSet.Builder paramBuilder, int paramInt1, int paramInt2)
  {
    setAccountDisplayName(mViewHolder.offscreenAccountDisplayName, mViewHolder.offscreenAddress, paramOwner);
    mViewHolder.offscreenText.setVisibility(0);
    paramOwner = ObjectAnimator.ofFloat(mViewHolder.offscreenText, "alpha", new float[] { 1.0F });
    paramOwner.setStartDelay(paramInt1);
    paramOwner.setDuration(150L);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(mViewHolder.accountText, "alpha", new float[] { 0.0F });
    localObjectAnimator.setStartDelay(paramInt2);
    localObjectAnimator.setDuration(150L);
    paramBuilder.with(paramOwner).with(localObjectAnimator);
  }

  private void bindRecent(ImageView paramImageView, Owner paramOwner)
  {
    if ((paramImageView != null) && (mAvatarLoader != null))
    {
      paramImageView.setImageBitmap(mAvatarLoader.getPlaceholder(paramImageView.getContext(), paramOwner, 1));
      if (TextUtils.isEmpty(paramOwner.getAvatarUrl()))
        break label91;
      mAvatarLoader.removePendingRequest(paramImageView);
      mAvatarLoader.loadOwnerAvatar(paramImageView, paramOwner, 2);
    }
    while (true)
    {
      paramImageView.setVisibility(0);
      paramImageView.setContentDescription(getContext().getString(R.string.account_item, new Object[] { paramOwner.getAccountName() }));
      return;
      label91: mAvatarLoader.removePendingRequest(paramImageView);
    }
  }

  private void bindRecents()
  {
    if (!mShowRecents)
      return;
    if (mViewHolder == null)
      createViewHolder();
    if ((mViewHolder.coverPhoto != null) && (mViewHolder.coverPhoto.getMeasuredWidth() == 0))
    {
      forceLayout();
      return;
    }
    if (mRecents.size() > 0)
    {
      Owner localOwner = (Owner)mRecents.get(0);
      ViewHolderItem localViewHolderItem = mViewHolder;
      mViewHolder.recentsAvatar1.setVisibility(0);
      bindRecent(mViewHolder.recentsAvatar1Image, localOwner);
      setCoverPhoto(localViewHolderItem, localViewHolderItem.offscreenCoverPhoto, localOwner);
      if (mRecents.size() <= 1)
        break label174;
      mViewHolder.recentsAvatar2.setVisibility(0);
      bindRecent(mViewHolder.recentsAvatar2Image, (Owner)mRecents.get(1));
    }
    while (true)
    {
      mRecents1Left = -1.0F;
      return;
      mViewHolder.recentsAvatar1.setVisibility(8);
      break;
      label174: mViewHolder.recentsAvatar2.setVisibility(8);
    }
  }

  private void bindSelectedView()
  {
    ViewHolderItem localViewHolderItem = mViewHolder;
    Owner localOwner = mSelectedAccount;
    if (localViewHolderItem.root != null)
      localViewHolderItem.root.setContentDescription(getContext().getResources().getString(R.string.selected_account, new Object[] { mSelectedAccount.getAccountName() }));
    if (localViewHolderItem.selectedAvatarImage != null)
    {
      localViewHolderItem.selectedAvatarImage.setImageBitmap(mAvatarLoader.getPlaceholder(getContext(), localOwner, 2));
      if (TextUtils.isEmpty(localOwner.getAvatarUrl()))
        break label140;
      mAvatarLoader.removePendingRequest(localViewHolderItem.selectedAvatarImage);
      mAvatarLoader.loadOwnerAvatar(localViewHolderItem.selectedAvatarImage, localOwner, 2);
    }
    while (true)
    {
      setAccountDisplayName(localViewHolderItem.selectedAccountDisplayName, localViewHolderItem.selectedAddress, localOwner);
      setCoverPhoto(localViewHolderItem, localViewHolderItem.coverPhoto, localOwner);
      return;
      label140: mAvatarLoader.removePendingRequest(localViewHolderItem.selectedAvatarImage);
    }
  }

  private void bindViews()
  {
    if (mViewHolder == null)
      createViewHolder();
    resetViews();
    bindSelectedView();
    bindRecents();
    if (mDecorator != null)
      mDecorator.decorateView(mViewHolder, mSelectedAccount, mRecents);
    if (mShowRecents)
    {
      mRecentAvatarSize = mViewHolder.recentsAvatar1Image.getWidth();
      if (mViewHolder.offscreenAvatar != null)
        mViewHolder.offscreenAvatar.setVisibility(8);
      if (mViewHolder.offscreenCoverPhoto != null)
        mViewHolder.offscreenCoverPhoto.setVisibility(8);
      if (mViewHolder.offscreenText != null)
        mViewHolder.offscreenText.setVisibility(8);
      if (mViewHolder.crossfadeRecents1 != null)
      {
        ViewCompat.setAlpha(mViewHolder.crossfadeRecents1, 0.0F);
        ViewCompat.setScaleX(mViewHolder.crossfadeRecents1, 0.8F);
        ViewCompat.setScaleY(mViewHolder.crossfadeRecents1, 0.8F);
        mViewHolder.crossfadeRecents1.setVisibility(8);
      }
      if (mViewHolder.crossfadeRecents2 != null)
      {
        ViewCompat.setAlpha(mViewHolder.crossfadeRecents2, 0.0F);
        ViewCompat.setScaleX(mViewHolder.crossfadeRecents2, 0.8F);
        ViewCompat.setScaleY(mViewHolder.crossfadeRecents2, 0.8F);
        mViewHolder.crossfadeRecents2.setVisibility(8);
      }
    }
  }

  private void changeNavigationMode()
  {
    boolean bool = true;
    int i;
    ExpanderView localExpanderView;
    if (mNavigationMode == 1)
    {
      i = 0;
      setNavigationMode(i);
      if (mListener != null)
        mListener.onNavigationModeChange(this);
      localExpanderView = mViewHolder.accountListButton;
      if (mNavigationMode != 1)
        break label61;
    }
    while (true)
    {
      localExpanderView.setExpanded(bool);
      return;
      i = 1;
      break;
      label61: bool = false;
    }
  }

  private void closeDrawer(int paramInt)
  {
    if (mCloseDrawerListener != null)
      getHandler().postDelayed(new Runnable()
      {
        public void run()
        {
          mCloseDrawerListener.pleaseCloseDrawer();
        }
      }
      , paramInt);
  }

  private void createViewHolder()
  {
    Context localContext = getContext();
    int i;
    if (mLayoutResId == -1)
    {
      if (!mForceFullHeight)
        break label148;
      i = R.layout.selected_account;
    }
    while (true)
    {
      mLayoutResId = i;
      if (mViewHolderItemCreator == null)
        mViewHolderItemCreator = new DefaultViewHolderItemCreator(null);
      LayoutInflater.from(localContext).inflate(mLayoutResId, this);
      mViewHolder = mViewHolderItemCreator.createViewHolderItem(this);
      if (mShowRecents)
      {
        mViewHolder.recentsAvatar1.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            SelectedAccountNavigationView.this.animateAccountTapChange(0);
          }
        });
        mViewHolder.recentsAvatar2.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            SelectedAccountNavigationView.this.animateAccountTapChange(1);
          }
        });
      }
      if (mViewHolder.accountListButton != null)
        mViewHolder.accountListButton.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            SelectedAccountNavigationView.this.changeNavigationMode();
          }
        });
      return;
      label148: if (AccountSwitcherView.isAtLeastL())
        i = R.layout.selected_account;
      else
        i = R.layout.selected_account_short;
    }
  }

  private void follow(float paramFloat)
  {
    Object localObject;
    ViewGroup.MarginLayoutParams localMarginLayoutParams;
    int i;
    int j;
    label69: float f1;
    if (mRecents1Left == -1.0F)
    {
      localObject = (ViewGroup.MarginLayoutParams)mViewHolder.recentsAvatar1Image.getLayoutParams();
      localMarginLayoutParams = (ViewGroup.MarginLayoutParams)mViewHolder.recentsAvatar2Image.getLayoutParams();
      if (mIsRtl)
      {
        i = ((ViewGroup.MarginLayoutParams)localObject).getMarginStart();
        if (!mIsRtl)
          break label772;
        j = localMarginLayoutParams.getMarginStart();
        mRecents1Left = (mViewHolder.recentsAvatar1.getLeft() + i);
        mRecents2Left = (mViewHolder.recentsAvatar2.getLeft() + j);
        mSelectedAvatarLeft = (mViewHolder.selectedAvatar.getLeft() + mViewHolder.selectedAvatar.getPaddingLeft());
        mSelectedAvatarWidth = mViewHolder.selectedAvatar.getWidth();
      }
    }
    else
    {
      if (!mIsRtl)
        break label782;
      paramFloat = Math.min(paramFloat, 0.0F);
      label156: if (mRecentAvatarSize == 0.0F)
        mRecentAvatarSize = mViewHolder.recentsAvatar1Image.getWidth();
      float f3 = mRecentAvatarSize / mSelectedAvatarSize;
      float f2 = mRecentAvatarSize;
      float f4 = mSelectedAvatarSize;
      if (mRecents.size() <= 1)
        break label791;
      f1 = mRecents2Left;
      label219: float f5 = f1 - mSelectedAvatarLeft + (mRecentAvatarSize - mSelectedAvatarSize) * 0.5F;
      f1 = Math.min(1.0F, paramFloat / f5);
      paramFloat = Math.abs((f2 - f4) * 0.5F);
      f2 = Math.max(0.0F, 1.0F - f1);
      mViewHolder.selectedAvatar.setTranslationX(f5 * f1);
      mViewHolder.selectedAvatar.setTranslationY(-1.0F * Math.abs(f1 * paramFloat));
      paramFloat = Math.min(1.0F, Math.max(f3, 1.0F - f1 * f3));
      mViewHolder.selectedAvatar.setScaleX(paramFloat);
      mViewHolder.selectedAvatar.setScaleY(paramFloat);
      if (mViewHolder.offscreenAvatar != null)
      {
        if (mViewHolder.offscreenAvatar.getVisibility() == 0)
          break label814;
        if (!mIsRtl)
          break label799;
        i = getWidth() - mSelectedAvatarLeft;
        label384: mOffscreenAvatarStart = i;
        mViewHolder.offscreenAvatar.setTranslationX(mOffscreenAvatarStart);
        mViewHolder.offscreenAvatarImage.setImageDrawable(mViewHolder.recentsAvatar1Image.getDrawable());
        mViewHolder.offscreenAvatar.setVisibility(0);
      }
      label436: if (mRecents.size() > 1)
      {
        paramFloat = mRecents1Left;
        f3 = mRecents2Left;
        mViewHolder.recentsAvatar2.setTranslationX(f1 * (paramFloat - f3));
      }
      if (mRecents.size() > 0)
      {
        if (mViewHolder.offscreenCoverPhoto != null)
        {
          if (mViewHolder.offscreenCoverPhoto.getVisibility() == 0)
            break label843;
          mViewHolder.offscreenCoverPhoto.setAlpha(0.0F);
          mViewHolder.offscreenCoverPhoto.setVisibility(0);
        }
        label530: if (mViewHolder.coverPhoto != null)
          mViewHolder.coverPhoto.setAlpha(1.0F - f1);
        if (!mIsRtl)
          break label857;
        paramFloat = getLeft() - (mViewHolder.recentsAvatar1.getWidth() + mRecents1Left);
        label583: mViewHolder.recentsAvatar1.setTranslationX(paramFloat * f1);
        mViewHolder.recentsAvatar1.setAlpha(f2);
        if (mViewHolder.offscreenText != null)
        {
          if (mViewHolder.offscreenText.getVisibility() == 0)
            break label871;
          localObject = (Owner)mRecents.get(0);
          mOffscreenTextTranslationStart = mOffscreenAvatarStart;
          mViewHolder.offscreenText.setTranslationX(mOffscreenTextTranslationStart);
          setAccountDisplayName(mViewHolder.offscreenAccountDisplayName, mViewHolder.offscreenAddress, (Owner)localObject);
          mViewHolder.offscreenText.setAlpha(0.0F);
          mViewHolder.offscreenText.setVisibility(0);
        }
      }
    }
    while (true)
    {
      if (mViewHolder.accountText != null)
      {
        mViewHolder.accountText.setTranslationX(mViewHolder.selectedAvatar.getTranslationX());
        paramFloat = Math.max(0.0F, 1.0F - 3.0F * f1);
        mViewHolder.accountText.setAlpha(paramFloat);
      }
      return;
      i = ((ViewGroup.MarginLayoutParams)localObject).leftMargin;
      break;
      label772: j = localMarginLayoutParams.leftMargin;
      break label69;
      label782: paramFloat = Math.max(paramFloat, 0.0F);
      break label156;
      label791: f1 = mRecents1Left;
      break label219;
      label799: i = -mSelectedAvatarWidth - mSelectedAvatarLeft;
      break label384;
      label814: paramFloat = -mOffscreenAvatarStart;
      mViewHolder.offscreenAvatar.setTranslationX(mOffscreenAvatarStart + paramFloat * f1);
      break label436;
      label843: mViewHolder.offscreenCoverPhoto.setAlpha(f1);
      break label530;
      label857: paramFloat = getWidth() - mRecents1Left;
      break label583;
      label871: if (f1 > 0.3333333F)
      {
        paramFloat = Math.min(1.0F, (f1 - 0.3333333F) * 3.0F);
        mViewHolder.offscreenText.setAlpha(paramFloat);
      }
      mViewHolder.offscreenText.setTranslationX(mOffscreenTextTranslationStart + -mOffscreenTextTranslationStart * f1);
    }
  }

  private void onSecondaryPointerUp(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i) == mActivePointerId)
      if (i != 0)
        break label33;
    label33: for (i = 1; ; i = 0)
    {
      mActivePointerId = paramMotionEvent.getPointerId(i);
      return;
    }
  }

  private void resetView(View paramView)
  {
    if (paramView != null)
    {
      ViewCompat.setTranslationX(paramView, 0.0F);
      ViewCompat.setTranslationY(paramView, 0.0F);
      ViewCompat.setScaleX(paramView, 1.0F);
      ViewCompat.setScaleY(paramView, 1.0F);
      ViewCompat.setAlpha(paramView, 1.0F);
    }
  }

  private void resetViews()
  {
    if (mShowRecents)
    {
      resetView(mViewHolder.selectedAvatar);
      resetView(mViewHolder.recentsAvatar1);
      resetView(mViewHolder.recentsAvatar2);
      resetView(mViewHolder.accountText);
      resetView(mViewHolder.coverPhoto);
      resetView(mViewHolder.offscreenCoverPhoto);
      resetView(mViewHolder.offscreenAvatar);
    }
  }

  private void runPendingBinds()
  {
    if (mPendingSelectedAccount != null)
    {
      mSelectedAccount = mPendingSelectedAccount;
      mPendingSelectedAccount = null;
    }
    if ((mPendingRecent1 != null) || (mPendingRecent2 != null))
    {
      mRecents.clear();
      if (mPendingRecent1 != null)
        mRecents.add(mPendingRecent1);
      if (mPendingRecent2 != null)
        mRecents.add(mPendingRecent2);
      mPendingRecent1 = null;
      mPendingRecent2 = null;
    }
  }

  private void setAccountDisplayName(TextView paramTextView1, TextView paramTextView2, Owner paramOwner)
  {
    int j = 0;
    int i = j;
    if (paramTextView1 != null)
    {
      if (!TextUtils.isEmpty(paramOwner.getDisplayName()))
        break label62;
      paramTextView1.setText(paramOwner.getAccountName());
      i = j;
    }
    while (true)
    {
      if (paramTextView2 != null)
      {
        if (i == 0)
          break;
        paramTextView2.setVisibility(0);
        paramTextView2.setText(paramOwner.getAccountName());
      }
      return;
      label62: i = 1;
      paramTextView1.setText(paramOwner.getDisplayName());
    }
    paramTextView2.setVisibility(8);
  }

  private void setCoverPhoto(ViewHolderItem paramViewHolderItem, ImageView paramImageView, Owner paramOwner)
  {
    if (paramImageView == null)
      return;
    if (!TextUtils.isEmpty(paramOwner.getCoverPhotoUrl()))
    {
      mCoverLoader.removePendingRequest(paramImageView);
      mCoverLoader.loadOwnerCoverPhoto(paramImageView, paramOwner, paramViewHolderItem.coverPhoto.getMeasuredWidth());
      return;
    }
    mCoverLoader.removePendingRequest(paramImageView);
    paramImageView.setImageBitmap(mCoverLoader.getPlaceholder(getContext()));
  }

  private void snapBack()
  {
    AnimatorSet localAnimatorSet = new AnimatorSet();
    AnimatorSet.Builder localBuilder = localAnimatorSet.play(ObjectAnimator.ofFloat(mViewHolder.selectedAvatar, "alpha", new float[] { 1.0F }));
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(mViewHolder.selectedAvatar, "translationX", new float[] { 0.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(mViewHolder.selectedAvatar, "translationY", new float[] { 0.0F });
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(mViewHolder.selectedAvatar, "scaleX", new float[] { 1.0F });
    ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(mViewHolder.selectedAvatar, "scaleY", new float[] { 1.0F });
    localBuilder.with(localObjectAnimator1).with(localObjectAnimator2).with(localObjectAnimator3).with(localObjectAnimator4);
    localBuilder.with(ObjectAnimator.ofFloat(mViewHolder.offscreenAvatar, "translationX", new float[] { mOffscreenAvatarStart }));
    if (mViewHolder.offscreenCoverPhoto != null)
      localBuilder.with(ObjectAnimator.ofFloat(mViewHolder.offscreenCoverPhoto, "alpha", new float[] { 0.0F }));
    if (mViewHolder.coverPhoto != null)
      localBuilder.with(ObjectAnimator.ofFloat(mViewHolder.coverPhoto, "alpha", new float[] { 1.0F }));
    localBuilder.with(ObjectAnimator.ofFloat(mViewHolder.recentsAvatar2, "translationX", new float[] { 0.0F }));
    localObjectAnimator3 = ObjectAnimator.ofFloat(mViewHolder.recentsAvatar1, "translationX", new float[] { 0.0F });
    localObjectAnimator1 = ObjectAnimator.ofFloat(mViewHolder.offscreenText, "translationX", new float[] { -getWidth() });
    localObjectAnimator4 = ObjectAnimator.ofFloat(mViewHolder.recentsAvatar1, "alpha", new float[] { 1.0F });
    localObjectAnimator2 = ObjectAnimator.ofFloat(mViewHolder.accountText, "translationX", new float[] { 0.0F });
    localBuilder.with(localObjectAnimator3).with(localObjectAnimator4);
    localObjectAnimator3 = ObjectAnimator.ofFloat(mViewHolder.offscreenText, "alpha", new float[] { 0.0F });
    localObjectAnimator4 = ObjectAnimator.ofFloat(mViewHolder.accountText, "alpha", new float[] { 1.0F });
    localBuilder.with(localObjectAnimator1).with(localObjectAnimator3).with(localObjectAnimator2).with(localObjectAnimator4);
    localAnimatorSet.setDuration(100L);
    localAnimatorSet.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        mViewHolder.offscreenAvatar.setVisibility(8);
        mViewHolder.offscreenText.setVisibility(8);
        if (mViewHolder.offscreenCoverPhoto != null)
          mViewHolder.offscreenCoverPhoto.setVisibility(8);
        SelectedAccountNavigationView.this.runPendingBinds();
        SelectedAccountNavigationView.this.bindViews();
        SelectedAccountNavigationView.access$302(SelectedAccountNavigationView.this, null);
      }
    });
    localAnimatorSet.setInterpolator(mAnimationInterpolator);
    mCurrentAnimation = localAnimatorSet;
    mCurrentAnimation.start();
  }

  private void updateAvatarMargin(View paramView, int paramInt)
  {
    if (paramView != null)
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
      localMarginLayoutParams.topMargin = (mAvatarMarginTop + paramInt);
      paramView.setLayoutParams(localMarginLayoutParams);
    }
  }

  public void applyTopInset(int paramInt)
  {
    if (mViewHolder == null)
      createViewHolder();
    int i = mDefaultHeight + paramInt;
    setMinimumHeight(i);
    ViewGroup.LayoutParams localLayoutParams = mViewHolder.wrapper.getLayoutParams();
    if (localLayoutParams == null)
      localLayoutParams = new ViewGroup.LayoutParams(-1, i);
    while (true)
    {
      mViewHolder.wrapper.setLayoutParams(localLayoutParams);
      updateAvatarMargin(mViewHolder.selectedAvatar, paramInt);
      updateAvatarMargin(mViewHolder.offscreenAvatar, paramInt);
      updateAvatarMargin(mViewHolder.recentsAvatar1, paramInt);
      updateAvatarMargin(mViewHolder.recentsAvatar2, paramInt);
      updateAvatarMargin(mViewHolder.crossfadeRecents1, paramInt);
      updateAvatarMargin(mViewHolder.crossfadeRecents2, paramInt);
      return;
      localLayoutParams.height = i;
    }
  }

  public void bind(Owner paramOwner)
  {
    if (mViewHolder == null)
      createViewHolder();
    if (paramOwner == null)
    {
      mSelectedAccount = null;
      return;
    }
    if ((mCurrentAnimation != null) && (mCurrentAnimation.isRunning()))
    {
      mPendingSelectedAccount = paramOwner;
      return;
    }
    if ((mViewHolder.coverPhoto != null) && (mViewHolder.coverPhoto.getMeasuredWidth() == 0))
    {
      mPendingBind = paramOwner;
      forceLayout();
      return;
    }
    if ((mSelectedAccount == null) || (!mSelectedAccount.getAccountName().equals(paramOwner.getAccountName())))
    {
      Owner localOwner = mSelectedAccount;
      mSelectedAccount = paramOwner;
      paramOwner = mSelectedAccount.getAccountName();
      int k = -1;
      int i = 0;
      while (true)
      {
        int j = k;
        if (i < mRecents.size())
        {
          if ((((Owner)mRecents.get(i)).getAccountName() != null) && (((Owner)mRecents.get(i)).getAccountName().equals(paramOwner)))
            j = i;
        }
        else
        {
          if (j >= 0)
            mRecents.remove(j);
          if (localOwner == null)
            break;
          mRecents.add(0, localOwner);
          while (mRecents.size() > 2)
            mRecents.remove(mRecents.size() - 1);
        }
        i += 1;
      }
      bindViews();
      return;
    }
    mSelectedAccount = paramOwner;
    bindViews();
  }

  public int getNavigationMode()
  {
    return mNavigationMode;
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    default:
    case 0:
    case 6:
    }
    while (true)
    {
      return mSwiping;
      mSwiping = false;
      mActivePointerId = paramMotionEvent.getPointerId(0);
      mSwiping = false;
      continue;
      onSecondaryPointerUp(paramMotionEvent);
      mActivePointerId = -1;
      mSwiping = false;
    }
  }

  public void onMeasure(int paramInt1, int paramInt2)
  {
    if (mViewHolder == null)
      createViewHolder();
    if (mViewHolder.coverPhoto != null)
      mViewHolder.coverPhoto.measure(paramInt1, paramInt2);
    if (mViewHolder.scrim != null)
      mViewHolder.scrim.measure(paramInt1, paramInt2);
    if (mPendingBind != null)
    {
      bind(mPendingBind);
      mPendingBind = null;
    }
    super.onMeasure(paramInt1, paramInt2);
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    ViewParent localViewParent = getParent();
    switch (i)
    {
    case 4:
    default:
    case 0:
    case 2:
    case 1:
    case 3:
    case 5:
    case 6:
    }
    while (true)
    {
      return true;
      mStartX = paramMotionEvent.getX();
      mStartY = paramMotionEvent.getY();
      continue;
      i = paramMotionEvent.findPointerIndex(mActivePointerId);
      if (i < 0)
      {
        Log.e("SelectedAccountNavigationView", "Got ACTION_MOVE event but have an invalid active pointer id.");
        return false;
      }
      float f1 = paramMotionEvent.getX(i);
      float f3 = paramMotionEvent.getY(i);
      float f2 = f1 - mStartX;
      f3 -= mStartY;
      if ((mShowRecents) && (mRecents.size() > 0) && (!mSwiping) && (f2 * f2 + f3 * f3 > mTouchSlop * mTouchSlop) && (Math.abs(f2) > Math.abs(f3)))
      {
        mSwiping = true;
        if (localViewParent != null)
          localViewParent.requestDisallowInterceptTouchEvent(true);
      }
      if (mSwiping)
      {
        follow(f1 - mStartX);
        mVelocityTracker.addMovement(paramMotionEvent);
        continue;
        if (mActivePointerId < 0)
        {
          Log.e("SelectedAccountNavigationView", "Got ACTION_UP event but have an invalid active pointer id.");
          return false;
        }
        label325: int j;
        if (mSwiping)
          if (mRecents.size() > 1)
          {
            f1 = mRecents2Left;
            f3 = mViewHolder.selectedAvatar.getTranslationX();
            f2 = f3;
            if (mIsRtl)
              f2 = Math.abs(f3);
            if (f2 < 0.5F * f1)
              break label436;
            i = 1;
            j = i;
            if (i == 0)
            {
              j = i;
              if (paramMotionEvent.getX(mActivePointerId) - mStartX > mTouchSlop)
              {
                mVelocityTracker.computeCurrentVelocity(1000);
                if (Math.abs(mVelocityTracker.getXVelocity()) <= mMinVelocity)
                  break label442;
                j = 1;
              }
            }
            label392: if (j == 0)
              break label448;
            animateAccountSwipeChange();
          }
        while (true)
        {
          mSwiping = false;
          if (localViewParent != null)
            localViewParent.requestDisallowInterceptTouchEvent(false);
          mVelocityTracker.clear();
          return false;
          f1 = mRecents1Left;
          break;
          label436: i = 0;
          break label325;
          label442: j = 0;
          break label392;
          label448: snapBack();
          continue;
          changeNavigationMode();
        }
        if (localViewParent != null)
          localViewParent.requestDisallowInterceptTouchEvent(false);
        return false;
        mActivePointerId = paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex());
        continue;
        onSecondaryPointerUp(paramMotionEvent);
      }
    }
  }

  public void setAvatarManager(OwnersAvatarManager paramOwnersAvatarManager)
  {
    mAvatarLoader = paramOwnersAvatarManager;
  }

  public void setClient(GoogleApiClient paramGoogleApiClient)
  {
    mClient = paramGoogleApiClient;
    if (mClient != null)
      setOwnersCoverPhotoManager(new OwnersCoverPhotoManager(getContext(), mClient));
  }

  public void setForceFullHeight(boolean paramBoolean)
  {
    if ((paramBoolean) && (AccountSwitcherView.isAtLeastVersion(11)));
    for (paramBoolean = true; ; paramBoolean = false)
    {
      mForceFullHeight = paramBoolean;
      mShowRecents = mForceFullHeight;
      return;
    }
  }

  public void setNavigationMode(int paramInt)
  {
    boolean bool = true;
    if (mNavigationMode != paramInt)
    {
      mNavigationMode = paramInt;
      if (mViewHolder == null)
        createViewHolder();
      if (mNavigationMode != 1)
        break label46;
    }
    while (true)
    {
      mViewHolder.accountListButton.setExpanded(bool);
      return;
      label46: bool = false;
    }
  }

  public void setOnAccountChangeListener(AccountChangeListener paramAccountChangeListener)
  {
    mAccountChangeListener = paramAccountChangeListener;
  }

  public void setOnNavigationModeChange(NavigationModeChangeListener paramNavigationModeChangeListener)
  {
    mListener = paramNavigationModeChangeListener;
  }

  public void setOwnersCoverPhotoManager(OwnersCoverPhotoManager paramOwnersCoverPhotoManager)
  {
    mCoverLoader = paramOwnersCoverPhotoManager;
  }

  public void setRecents(Owner paramOwner1, Owner paramOwner2)
  {
    if ((mCurrentAnimation != null) && (mCurrentAnimation.isRunning()))
    {
      mPendingRecent1 = paramOwner1;
      mPendingRecent2 = paramOwner2;
      return;
    }
    if (mRecents == null)
      mRecents = new ArrayList();
    while (true)
    {
      if (paramOwner1 != null)
        mRecents.add(paramOwner1);
      if (paramOwner2 != null)
        mRecents.add(paramOwner2);
      bindRecents();
      return;
      mRecents.clear();
    }
  }

  public static abstract interface AccountChangeListener
  {
    public abstract void onAccountChange(Owner paramOwner);
  }

  private class DefaultViewHolderItemCreator
    implements SelectedAccountNavigationView.ViewHolderItemCreator
  {
    private DefaultViewHolderItemCreator()
    {
    }

    public SelectedAccountNavigationView.ViewHolderItem createViewHolderItem(View paramView)
    {
      SelectedAccountNavigationView.ViewHolderItem localViewHolderItem = new SelectedAccountNavigationView.ViewHolderItem();
      localViewHolderItem.root = paramView;
      localViewHolderItem.accountText = paramView.findViewById(R.id.account_text);
      localViewHolderItem.selectedAvatar = paramView.findViewById(R.id.avatar);
      localViewHolderItem.selectedAvatarImage = ((ImageView)localViewHolderItem.selectedAvatar);
      localViewHolderItem.selectedAccountDisplayName = ((TextView)paramView.findViewById(R.id.account_display_name));
      localViewHolderItem.selectedAddress = ((TextView)paramView.findViewById(R.id.account_address));
      localViewHolderItem.coverPhoto = ((ImageView)paramView.findViewById(R.id.cover_photo));
      localViewHolderItem.accountListButton = ((ExpanderView)paramView.findViewById(R.id.account_list_button));
      localViewHolderItem.accountListWrapper = paramView.findViewById(R.id.account_list_wrapper);
      localViewHolderItem.scrim = paramView.findViewById(R.id.scrim);
      localViewHolderItem.wrapper = findViewById(R.id.account_switcher_lib_view_wrapper);
      if (mShowRecents)
      {
        localViewHolderItem.recentsAvatar1 = paramView.findViewById(R.id.avatar_recents_one);
        localViewHolderItem.recentsAvatar1Image = ((ImageView)paramView.findViewById(R.id.avatar_recents_one_image));
        localViewHolderItem.recentsAvatar2 = paramView.findViewById(R.id.avatar_recents_two);
        localViewHolderItem.recentsAvatar2Image = ((ImageView)paramView.findViewById(R.id.avatar_recents_two_image));
        if ((localViewHolderItem.recentsAvatar1Image == null) && ((localViewHolderItem.recentsAvatar1 instanceof ImageView)))
          localViewHolderItem.recentsAvatar1Image = ((ImageView)localViewHolderItem.recentsAvatar1);
        if ((localViewHolderItem.recentsAvatar2Image == null) && ((localViewHolderItem.recentsAvatar2 instanceof ImageView)))
          localViewHolderItem.recentsAvatar2Image = ((ImageView)localViewHolderItem.recentsAvatar2);
        localViewHolderItem.offscreenAvatar = paramView.findViewById(R.id.offscreen_avatar);
        localViewHolderItem.offscreenAvatarImage = ((ImageView)localViewHolderItem.offscreenAvatar);
        localViewHolderItem.offscreenCoverPhoto = ((ImageView)paramView.findViewById(R.id.offscreen_cover_photo));
        localViewHolderItem.offscreenText = paramView.findViewById(R.id.offscreen_text);
        localViewHolderItem.offscreenAccountDisplayName = ((TextView)paramView.findViewById(R.id.offscreen_account_display_name));
        localViewHolderItem.offscreenAddress = ((TextView)paramView.findViewById(R.id.offscreen_account_address));
        localViewHolderItem.crossfadeRecents1 = paramView.findViewById(R.id.crossfade_avatar_recents_one);
        localViewHolderItem.crossfadeRecents1Image = ((ImageView)localViewHolderItem.crossfadeRecents1);
        localViewHolderItem.crossfadeRecents2 = paramView.findViewById(R.id.crossfade_avatar_recents_two);
        localViewHolderItem.crossfadeRecents2Image = ((ImageView)localViewHolderItem.crossfadeRecents2);
      }
      return localViewHolderItem;
    }
  }

  public static abstract interface DrawerCloseListener
  {
    public abstract void pleaseCloseDrawer();
  }

  public static abstract interface NavigationModeChangeListener
  {
    public abstract void onNavigationModeChange(SelectedAccountNavigationView paramSelectedAccountNavigationView);
  }

  public static abstract interface ViewDecorator
  {
    public abstract void decorateView(SelectedAccountNavigationView.ViewHolderItem paramViewHolderItem, Owner paramOwner, List<Owner> paramList);
  }

  public static class ViewHolderItem
  {
    public ExpanderView accountListButton;
    public View accountListWrapper;
    public View accountText;
    public ImageView coverPhoto;
    public View crossfadeRecents1;
    public ImageView crossfadeRecents1Image;
    public View crossfadeRecents2;
    public ImageView crossfadeRecents2Image;
    public TextView offscreenAccountDisplayName;
    public TextView offscreenAddress;
    public View offscreenAvatar;
    public ImageView offscreenAvatarImage;
    public ImageView offscreenCoverPhoto;
    public View offscreenText;
    public View recentsAvatar1;
    public ImageView recentsAvatar1Image;
    public View recentsAvatar2;
    public ImageView recentsAvatar2Image;
    public View root;
    public View scrim;
    public TextView selectedAccountDisplayName;
    public TextView selectedAddress;
    public View selectedAvatar;
    public ImageView selectedAvatarImage;
    public View wrapper;
  }

  public static abstract interface ViewHolderItemCreator
  {
    public abstract SelectedAccountNavigationView.ViewHolderItem createViewHolderItem(View paramView);
  }
}