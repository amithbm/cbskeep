package android.support.design.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.design.R.dimen;
import android.support.design.R.style;
import android.support.design.R.styleable;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import java.util.List;

@CoordinatorLayout.DefaultBehavior(Behavior.class)
public class FloatingActionButton extends ImageView
{
  private ColorStateList mBackgroundTint;
  private PorterDuff.Mode mBackgroundTintMode;
  private int mBorderWidth;
  private int mContentPadding;
  private final FloatingActionButtonImpl mImpl;
  private int mRippleColor;
  private final Rect mShadowPadding = new Rect();
  private int mSize;

  public FloatingActionButton(Context paramContext)
  {
    this(paramContext, null);
  }

  public FloatingActionButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public FloatingActionButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FloatingActionButton, paramInt, R.style.Widget_Design_FloatingActionButton);
    paramContext = paramAttributeSet.getDrawable(R.styleable.FloatingActionButton_android_background);
    mBackgroundTint = paramAttributeSet.getColorStateList(R.styleable.FloatingActionButton_backgroundTint);
    mBackgroundTintMode = parseTintMode(paramAttributeSet.getInt(R.styleable.FloatingActionButton_backgroundTintMode, -1), null);
    mRippleColor = paramAttributeSet.getColor(R.styleable.FloatingActionButton_rippleColor, 0);
    mSize = paramAttributeSet.getInt(R.styleable.FloatingActionButton_fabSize, 0);
    mBorderWidth = paramAttributeSet.getDimensionPixelSize(R.styleable.FloatingActionButton_borderWidth, 0);
    float f1 = paramAttributeSet.getDimension(R.styleable.FloatingActionButton_elevation, 0.0F);
    float f2 = paramAttributeSet.getDimension(R.styleable.FloatingActionButton_pressedTranslationZ, 0.0F);
    paramAttributeSet.recycle();
    paramAttributeSet = new ShadowViewDelegate()
    {
      public float getRadius()
      {
        return getSizeDimension() / 2.0F;
      }

      public void setBackgroundDrawable(Drawable paramAnonymousDrawable)
      {
        FloatingActionButton.this.setBackgroundDrawable(paramAnonymousDrawable);
      }

      public void setShadowPadding(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        mShadowPadding.set(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4);
        setPadding(mContentPadding + paramAnonymousInt1, mContentPadding + paramAnonymousInt2, mContentPadding + paramAnonymousInt3, mContentPadding + paramAnonymousInt4);
      }
    };
    paramInt = Build.VERSION.SDK_INT;
    if (paramInt >= 21)
      mImpl = new FloatingActionButtonLollipop(this, paramAttributeSet);
    while (true)
    {
      paramInt = (int)getResources().getDimension(R.dimen.fab_content_size);
      mContentPadding = ((getSizeDimension() - paramInt) / 2);
      mImpl.setBackgroundDrawable(paramContext, mBackgroundTint, mBackgroundTintMode, mRippleColor, mBorderWidth);
      mImpl.setElevation(f1);
      mImpl.setPressedTranslationZ(f2);
      setClickable(true);
      return;
      if (paramInt >= 12)
        mImpl = new FloatingActionButtonHoneycombMr1(this, paramAttributeSet);
      else
        mImpl = new FloatingActionButtonEclairMr1(this, paramAttributeSet);
    }
  }

  static PorterDuff.Mode parseTintMode(int paramInt, PorterDuff.Mode paramMode)
  {
    switch (paramInt)
    {
    default:
      return paramMode;
    case 3:
      return PorterDuff.Mode.SRC_OVER;
    case 5:
      return PorterDuff.Mode.SRC_IN;
    case 9:
      return PorterDuff.Mode.SRC_ATOP;
    case 14:
      return PorterDuff.Mode.MULTIPLY;
    case 15:
    }
    return PorterDuff.Mode.SCREEN;
  }

  private static int resolveAdjustedSize(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    switch (i)
    {
    default:
      return paramInt1;
    case 0:
      return paramInt1;
    case -2147483648:
      return Math.min(paramInt1, paramInt2);
    case 1073741824:
    }
    return paramInt2;
  }

  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    mImpl.onDrawableStateChanged(getDrawableState());
  }

  public ColorStateList getBackgroundTintList()
  {
    return mBackgroundTint;
  }

  public PorterDuff.Mode getBackgroundTintMode()
  {
    return mBackgroundTintMode;
  }

  final int getSizeDimension()
  {
    switch (mSize)
    {
    default:
      return getResources().getDimensionPixelSize(R.dimen.fab_size_normal);
    case 1:
    }
    return getResources().getDimensionPixelSize(R.dimen.fab_size_mini);
  }

  public void hide()
  {
    if (getVisibility() != 0)
      return;
    if ((ViewCompat.isLaidOut(this)) && (!isInEditMode()))
    {
      mImpl.hide();
      return;
    }
    setVisibility(8);
  }

  @TargetApi(11)
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    mImpl.jumpDrawableToCurrentState();
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = getSizeDimension();
    paramInt1 = Math.min(resolveAdjustedSize(i, paramInt1), resolveAdjustedSize(i, paramInt2));
    setMeasuredDimension(mShadowPadding.left + paramInt1 + mShadowPadding.right, mShadowPadding.top + paramInt1 + mShadowPadding.bottom);
  }

  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    if (mImpl != null)
      mImpl.setBackgroundDrawable(paramDrawable, mBackgroundTint, mBackgroundTintMode, mRippleColor, mBorderWidth);
  }

  public void setBackgroundTintList(ColorStateList paramColorStateList)
  {
    mImpl.setBackgroundTintList(paramColorStateList);
  }

  public void setBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    mImpl.setBackgroundTintMode(paramMode);
  }

  public void show()
  {
    if (getVisibility() == 0);
    do
    {
      return;
      setVisibility(0);
    }
    while (!ViewCompat.isLaidOut(this));
    mImpl.show();
  }

  public static class Behavior extends CoordinatorLayout.Behavior<FloatingActionButton>
  {
    private static final boolean SNACKBAR_BEHAVIOR_ENABLED;
    private Rect mTmpRect;
    private float mTranslationY;

    static
    {
      if (Build.VERSION.SDK_INT >= 11);
      for (boolean bool = true; ; bool = false)
      {
        SNACKBAR_BEHAVIOR_ENABLED = bool;
        return;
      }
    }

    private float getFabTranslationYForSnackbar(CoordinatorLayout paramCoordinatorLayout, FloatingActionButton paramFloatingActionButton)
    {
      float f1 = 0.0F;
      List localList = paramCoordinatorLayout.getDependencies(paramFloatingActionButton);
      int i = 0;
      int j = localList.size();
      while (i < j)
      {
        View localView = (View)localList.get(i);
        float f2 = f1;
        if ((localView instanceof Snackbar.SnackbarLayout))
        {
          f2 = f1;
          if (paramCoordinatorLayout.doViewsOverlap(paramFloatingActionButton, localView))
            f2 = Math.min(f1, ViewCompat.getTranslationY(localView) - localView.getHeight());
        }
        i += 1;
        f1 = f2;
      }
      return f1;
    }

    private void offsetIfNeeded(CoordinatorLayout paramCoordinatorLayout, FloatingActionButton paramFloatingActionButton)
    {
      Rect localRect = paramFloatingActionButton.mShadowPadding;
      CoordinatorLayout.LayoutParams localLayoutParams;
      int j;
      int i;
      if ((localRect != null) && (localRect.centerX() > 0) && (localRect.centerY() > 0))
      {
        localLayoutParams = (CoordinatorLayout.LayoutParams)paramFloatingActionButton.getLayoutParams();
        j = 0;
        i = 0;
        if (paramFloatingActionButton.getRight() < paramCoordinatorLayout.getWidth() - localLayoutParams.rightMargin)
          break label100;
        i = localRect.right;
        if (paramFloatingActionButton.getBottom() < paramCoordinatorLayout.getBottom() - localLayoutParams.bottomMargin)
          break label122;
        j = localRect.bottom;
      }
      while (true)
      {
        paramFloatingActionButton.offsetTopAndBottom(j);
        paramFloatingActionButton.offsetLeftAndRight(i);
        return;
        label100: if (paramFloatingActionButton.getLeft() > localLayoutParams.leftMargin)
          break;
        i = -localRect.left;
        break;
        label122: if (paramFloatingActionButton.getTop() <= localLayoutParams.topMargin)
          j = -localRect.top;
      }
    }

    private void updateFabTranslationForSnackbar(CoordinatorLayout paramCoordinatorLayout, FloatingActionButton paramFloatingActionButton, View paramView)
    {
      if (paramFloatingActionButton.getVisibility() != 0);
      float f;
      do
      {
        return;
        f = getFabTranslationYForSnackbar(paramCoordinatorLayout, paramFloatingActionButton);
      }
      while (f == mTranslationY);
      ViewCompat.animate(paramFloatingActionButton).cancel();
      ViewCompat.setTranslationY(paramFloatingActionButton, f);
      mTranslationY = f;
    }

    private boolean updateFabVisibility(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, FloatingActionButton paramFloatingActionButton)
    {
      if (((CoordinatorLayout.LayoutParams)paramFloatingActionButton.getLayoutParams()).getAnchorId() != paramAppBarLayout.getId())
        return false;
      if (mTmpRect == null)
        mTmpRect = new Rect();
      Rect localRect = mTmpRect;
      ViewGroupUtils.getDescendantRect(paramCoordinatorLayout, paramAppBarLayout, localRect);
      if (localRect.bottom <= paramAppBarLayout.getMinimumHeightForVisibleOverlappingContent())
        paramFloatingActionButton.hide();
      while (true)
      {
        return true;
        paramFloatingActionButton.show();
      }
    }

    public boolean layoutDependsOn(CoordinatorLayout paramCoordinatorLayout, FloatingActionButton paramFloatingActionButton, View paramView)
    {
      return (SNACKBAR_BEHAVIOR_ENABLED) && ((paramView instanceof Snackbar.SnackbarLayout));
    }

    public boolean onDependentViewChanged(CoordinatorLayout paramCoordinatorLayout, FloatingActionButton paramFloatingActionButton, View paramView)
    {
      if ((paramView instanceof Snackbar.SnackbarLayout))
        updateFabTranslationForSnackbar(paramCoordinatorLayout, paramFloatingActionButton, paramView);
      while (true)
      {
        return false;
        if ((paramView instanceof AppBarLayout))
          updateFabVisibility(paramCoordinatorLayout, (AppBarLayout)paramView, paramFloatingActionButton);
      }
    }

    public boolean onLayoutChild(CoordinatorLayout paramCoordinatorLayout, FloatingActionButton paramFloatingActionButton, int paramInt)
    {
      List localList = paramCoordinatorLayout.getDependencies(paramFloatingActionButton);
      int i = 0;
      int j = localList.size();
      while (true)
      {
        if (i < j)
        {
          View localView = (View)localList.get(i);
          if ((!(localView instanceof AppBarLayout)) || (!updateFabVisibility(paramCoordinatorLayout, (AppBarLayout)localView, paramFloatingActionButton)));
        }
        else
        {
          paramCoordinatorLayout.onLayoutChild(paramFloatingActionButton, paramInt);
          offsetIfNeeded(paramCoordinatorLayout, paramFloatingActionButton);
          return true;
        }
        i += 1;
      }
    }
  }
}