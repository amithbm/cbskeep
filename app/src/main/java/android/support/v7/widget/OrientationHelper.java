package android.support.v7.widget;

import android.view.View;

public abstract class OrientationHelper
{
  private int mLastTotalSpace = -2147483648;
  protected final RecyclerView.LayoutManager mLayoutManager;

  private OrientationHelper(RecyclerView.LayoutManager paramLayoutManager)
  {
    mLayoutManager = paramLayoutManager;
  }

  public static OrientationHelper createHorizontalHelper(RecyclerView.LayoutManager paramLayoutManager)
  {
    // Byte code:
    //   0: new 6	android/support/v7/widget/OrientationHelper$1
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 29	android/support/v7/widget/OrientationHelper$1:<init>	(Landroid/support/v7/widget/RecyclerView$LayoutManager;)V
    //   8: areturn
  }

  public static OrientationHelper createOrientationHelper(RecyclerView.LayoutManager paramLayoutManager, int paramInt)
  {
    switch (paramInt)
    {
    default:
      throw new IllegalArgumentException("invalid orientation");
    case 0:
      return createHorizontalHelper(paramLayoutManager);
    case 1:
    }
    return createVerticalHelper(paramLayoutManager);
  }

  public static OrientationHelper createVerticalHelper(RecyclerView.LayoutManager paramLayoutManager)
  {
    // Byte code:
    //   0: new 8	android/support/v7/widget/OrientationHelper$2
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 44	android/support/v7/widget/OrientationHelper$2:<init>	(Landroid/support/v7/widget/RecyclerView$LayoutManager;)V
    //   8: areturn
  }

  public abstract int getDecoratedEnd(View paramView);

  public abstract int getDecoratedMeasurement(View paramView);

  public abstract int getDecoratedMeasurementInOther(View paramView);

  public abstract int getDecoratedStart(View paramView);

  public abstract int getEnd();

  public abstract int getEndAfterPadding();

  public abstract int getEndPadding();

  public abstract int getStartAfterPadding();

  public abstract int getTotalSpace();

  public int getTotalSpaceChange()
  {
    if (-2147483648 == mLastTotalSpace)
      return 0;
    return getTotalSpace() - mLastTotalSpace;
  }

  public abstract void offsetChildren(int paramInt);

  public void onLayoutComplete()
  {
    mLastTotalSpace = getTotalSpace();
  }
}