package android.support.v7.internal.widget;

public class RtlSpacingHelper
{
  private int mEnd = -2147483648;
  private int mExplicitLeft = 0;
  private int mExplicitRight = 0;
  private boolean mIsRelative = false;
  private boolean mIsRtl = false;
  private int mLeft = 0;
  private int mRight = 0;
  private int mStart = -2147483648;

  public int getEnd()
  {
    if (mIsRtl)
      return mLeft;
    return mRight;
  }

  public int getLeft()
  {
    return mLeft;
  }

  public int getRight()
  {
    return mRight;
  }

  public int getStart()
  {
    if (mIsRtl)
      return mRight;
    return mLeft;
  }

  public void setAbsolute(int paramInt1, int paramInt2)
  {
    mIsRelative = false;
    if (paramInt1 != -2147483648)
    {
      mExplicitLeft = paramInt1;
      mLeft = paramInt1;
    }
    if (paramInt2 != -2147483648)
    {
      mExplicitRight = paramInt2;
      mRight = paramInt2;
    }
  }

  public void setDirection(boolean paramBoolean)
  {
    if (paramBoolean == mIsRtl)
      return;
    mIsRtl = paramBoolean;
    if (mIsRelative)
    {
      if (paramBoolean)
      {
        if (mEnd != -2147483648)
        {
          i = mEnd;
          mLeft = i;
          if (mStart == -2147483648)
            break label72;
        }
        label72: for (i = mStart; ; i = mExplicitRight)
        {
          mRight = i;
          return;
          i = mExplicitLeft;
          break;
        }
      }
      if (mStart != -2147483648)
      {
        i = mStart;
        mLeft = i;
        if (mEnd == -2147483648)
          break label127;
      }
      label127: for (int i = mEnd; ; i = mExplicitRight)
      {
        mRight = i;
        return;
        i = mExplicitLeft;
        break;
      }
    }
    mLeft = mExplicitLeft;
    mRight = mExplicitRight;
  }

  public void setRelative(int paramInt1, int paramInt2)
  {
    mStart = paramInt1;
    mEnd = paramInt2;
    mIsRelative = true;
    if (mIsRtl)
    {
      if (paramInt2 != -2147483648)
        mLeft = paramInt2;
      if (paramInt1 != -2147483648)
        mRight = paramInt1;
    }
    do
    {
      return;
      if (paramInt1 != -2147483648)
        mLeft = paramInt1;
    }
    while (paramInt2 == -2147483648);
    mRight = paramInt2;
  }
}