package android.support.v4.view.accessibility;

import android.os.Build.VERSION;
import android.view.View;

public class AccessibilityRecordCompat
{
  private static final AccessibilityRecordImpl IMPL = new AccessibilityRecordStubImpl();
  private final Object mRecord;

  static
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      IMPL = new AccessibilityRecordJellyBeanImpl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 15)
    {
      IMPL = new AccessibilityRecordIcsMr1Impl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      IMPL = new AccessibilityRecordIcsImpl();
      return;
    }
  }

  public AccessibilityRecordCompat(Object paramObject)
  {
    mRecord = paramObject;
  }

  public static AccessibilityRecordCompat obtain()
  {
    return new AccessibilityRecordCompat(IMPL.obtain());
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    do
    {
      do
      {
        return true;
        if (paramObject == null)
          return false;
        if (getClass() != paramObject.getClass())
          return false;
        paramObject = (AccessibilityRecordCompat)paramObject;
        if (mRecord != null)
          break;
      }
      while (paramObject.mRecord == null);
      return false;
    }
    while (mRecord.equals(paramObject.mRecord));
    return false;
  }

  public int hashCode()
  {
    if (mRecord == null)
      return 0;
    return mRecord.hashCode();
  }

  public void setFromIndex(int paramInt)
  {
    IMPL.setFromIndex(mRecord, paramInt);
  }

  public void setItemCount(int paramInt)
  {
    IMPL.setItemCount(mRecord, paramInt);
  }

  public void setMaxScrollX(int paramInt)
  {
    IMPL.setMaxScrollX(mRecord, paramInt);
  }

  public void setMaxScrollY(int paramInt)
  {
    IMPL.setMaxScrollY(mRecord, paramInt);
  }

  public void setScrollX(int paramInt)
  {
    IMPL.setScrollX(mRecord, paramInt);
  }

  public void setScrollY(int paramInt)
  {
    IMPL.setScrollY(mRecord, paramInt);
  }

  public void setScrollable(boolean paramBoolean)
  {
    IMPL.setScrollable(mRecord, paramBoolean);
  }

  public void setSource(View paramView, int paramInt)
  {
    IMPL.setSource(mRecord, paramView, paramInt);
  }

  public void setToIndex(int paramInt)
  {
    IMPL.setToIndex(mRecord, paramInt);
  }

  static class AccessibilityRecordIcsImpl extends AccessibilityRecordCompat.AccessibilityRecordStubImpl
  {
    public Object obtain()
    {
      return AccessibilityRecordCompatIcs.obtain();
    }

    public void setFromIndex(Object paramObject, int paramInt)
    {
      AccessibilityRecordCompatIcs.setFromIndex(paramObject, paramInt);
    }

    public void setItemCount(Object paramObject, int paramInt)
    {
      AccessibilityRecordCompatIcs.setItemCount(paramObject, paramInt);
    }

    public void setScrollX(Object paramObject, int paramInt)
    {
      AccessibilityRecordCompatIcs.setScrollX(paramObject, paramInt);
    }

    public void setScrollY(Object paramObject, int paramInt)
    {
      AccessibilityRecordCompatIcs.setScrollY(paramObject, paramInt);
    }

    public void setScrollable(Object paramObject, boolean paramBoolean)
    {
      AccessibilityRecordCompatIcs.setScrollable(paramObject, paramBoolean);
    }

    public void setToIndex(Object paramObject, int paramInt)
    {
      AccessibilityRecordCompatIcs.setToIndex(paramObject, paramInt);
    }
  }

  static class AccessibilityRecordIcsMr1Impl extends AccessibilityRecordCompat.AccessibilityRecordIcsImpl
  {
    public void setMaxScrollX(Object paramObject, int paramInt)
    {
      AccessibilityRecordCompatIcsMr1.setMaxScrollX(paramObject, paramInt);
    }

    public void setMaxScrollY(Object paramObject, int paramInt)
    {
      AccessibilityRecordCompatIcsMr1.setMaxScrollY(paramObject, paramInt);
    }
  }

  static abstract interface AccessibilityRecordImpl
  {
    public abstract Object obtain();

    public abstract void setFromIndex(Object paramObject, int paramInt);

    public abstract void setItemCount(Object paramObject, int paramInt);

    public abstract void setMaxScrollX(Object paramObject, int paramInt);

    public abstract void setMaxScrollY(Object paramObject, int paramInt);

    public abstract void setScrollX(Object paramObject, int paramInt);

    public abstract void setScrollY(Object paramObject, int paramInt);

    public abstract void setScrollable(Object paramObject, boolean paramBoolean);

    public abstract void setSource(Object paramObject, View paramView, int paramInt);

    public abstract void setToIndex(Object paramObject, int paramInt);
  }

  static class AccessibilityRecordJellyBeanImpl extends AccessibilityRecordCompat.AccessibilityRecordIcsMr1Impl
  {
    public void setSource(Object paramObject, View paramView, int paramInt)
    {
      AccessibilityRecordCompatJellyBean.setSource(paramObject, paramView, paramInt);
    }
  }

  static class AccessibilityRecordStubImpl
    implements AccessibilityRecordCompat.AccessibilityRecordImpl
  {
    public Object obtain()
    {
      return null;
    }

    public void setFromIndex(Object paramObject, int paramInt)
    {
    }

    public void setItemCount(Object paramObject, int paramInt)
    {
    }

    public void setMaxScrollX(Object paramObject, int paramInt)
    {
    }

    public void setMaxScrollY(Object paramObject, int paramInt)
    {
    }

    public void setScrollX(Object paramObject, int paramInt)
    {
    }

    public void setScrollY(Object paramObject, int paramInt)
    {
    }

    public void setScrollable(Object paramObject, boolean paramBoolean)
    {
    }

    public void setSource(Object paramObject, View paramView, int paramInt)
    {
    }

    public void setToIndex(Object paramObject, int paramInt)
    {
    }
  }
}