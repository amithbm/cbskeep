package com.android.ex.photo.adapters;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import java.util.HashMap;

public abstract class BaseCursorPagerAdapter extends BaseFragmentPagerAdapter
{
  protected Context mContext;
  protected Cursor mCursor;
  protected SparseIntArray mItemPosition;
  protected final HashMap<Object, Integer> mObjectRowMap = new HashMap();
  protected int mRowIDColumn;

  public BaseCursorPagerAdapter(Context paramContext, FragmentManager paramFragmentManager, Cursor paramCursor)
  {
    super(paramFragmentManager);
    init(paramContext, paramCursor);
  }

  private void init(Context paramContext, Cursor paramCursor)
  {
    if (paramCursor != null)
    {
      i = 1;
      mCursor = paramCursor;
      mContext = paramContext;
      if (i == 0)
        break label43;
    }
    label43: for (int i = mCursor.getColumnIndex("uri"); ; i = -1)
    {
      mRowIDColumn = i;
      return;
      i = 0;
      break;
    }
  }

  private boolean moveCursorTo(int paramInt)
  {
    if ((mCursor != null) && (!mCursor.isClosed()))
      return mCursor.moveToPosition(paramInt);
    return false;
  }

  private void setItemPosition()
  {
    if ((mCursor == null) || (mCursor.isClosed()))
    {
      mItemPosition = null;
      return;
    }
    SparseIntArray localSparseIntArray = new SparseIntArray(mCursor.getCount());
    mCursor.moveToPosition(-1);
    while (mCursor.moveToNext())
      localSparseIntArray.append(mCursor.getString(mRowIDColumn).hashCode(), mCursor.getPosition());
    mItemPosition = localSparseIntArray;
  }

  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    mObjectRowMap.remove(paramObject);
    super.destroyItem(paramView, paramInt, paramObject);
  }

  public int getCount()
  {
    if (mCursor != null)
      return mCursor.getCount();
    return 0;
  }

  public Cursor getCursor()
  {
    return mCursor;
  }

  public Fragment getItem(int paramInt)
  {
    if ((mCursor != null) && (moveCursorTo(paramInt)))
      return getItem(mContext, mCursor, paramInt);
    return null;
  }

  public abstract Fragment getItem(Context paramContext, Cursor paramCursor, int paramInt);

  public int getItemPosition(Object paramObject)
  {
    paramObject = (Integer)mObjectRowMap.get(paramObject);
    if ((paramObject == null) || (mItemPosition == null))
      return -2;
    return mItemPosition.get(paramObject.intValue(), -2);
  }

  public Object instantiateItem(View paramView, int paramInt)
  {
    if (mCursor == null)
      throw new IllegalStateException("this should only be called when the cursor is valid");
    if (moveCursorTo(paramInt));
    for (Integer localInteger = Integer.valueOf(mCursor.getString(mRowIDColumn).hashCode()); ; localInteger = null)
    {
      paramView = super.instantiateItem(paramView, paramInt);
      if (paramView != null)
        mObjectRowMap.put(paramView, localInteger);
      return paramView;
    }
  }

  protected String makeFragmentName(int paramInt1, int paramInt2)
  {
    if (moveCursorTo(paramInt2))
      return "android:pager:" + paramInt1 + ":" + mCursor.getString(mRowIDColumn).hashCode();
    return super.makeFragmentName(paramInt1, paramInt2);
  }

  public Cursor swapCursor(Cursor paramCursor)
  {
    if (Log.isLoggable("BaseCursorPagerAdapter", 2))
    {
      localObject = new StringBuilder().append("swapCursor old=");
      if (mCursor != null)
        break label72;
      i = -1;
      localObject = ((StringBuilder)localObject).append(i).append("; new=");
      if (paramCursor != null)
        break label85;
    }
    label72: label85: for (int i = -1; ; i = paramCursor.getCount())
    {
      Log.v("BaseCursorPagerAdapter", i);
      if (paramCursor != mCursor)
        break label95;
      return null;
      i = mCursor.getCount();
      break;
    }
    label95: Object localObject = mCursor;
    mCursor = paramCursor;
    if (paramCursor != null);
    for (mRowIDColumn = paramCursor.getColumnIndex("uri"); ; mRowIDColumn = -1)
    {
      setItemPosition();
      notifyDataSetChanged();
      return localObject;
    }
  }
}