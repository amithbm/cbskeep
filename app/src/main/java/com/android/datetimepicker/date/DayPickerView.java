package com.android.datetimepicker.date;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.android.datetimepicker.Utils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public abstract class DayPickerView extends ListView
  implements AbsListView.OnScrollListener, DatePickerDialog.OnDateChangedListener
{
  public static int LIST_TOP_OFFSET = -1;
  private static SimpleDateFormat YEAR_FORMAT = new SimpleDateFormat("yyyy", Locale.getDefault());
  protected MonthAdapter mAdapter;
  protected Context mContext;
  private DatePickerController mController;
  protected int mCurrentMonthDisplayed;
  protected int mCurrentScrollState = 0;
  protected int mDaysPerWeek = 7;
  protected float mFriction = 1.0F;
  protected Handler mHandler;
  protected int mNumWeeks = 6;
  private boolean mPerformingScroll;
  protected long mPreviousScrollPosition;
  protected int mPreviousScrollState = 0;
  protected ScrollStateRunnable mScrollStateChangedRunnable = new ScrollStateRunnable();
  protected MonthAdapter.CalendarDay mSelectedDay = new MonthAdapter.CalendarDay();
  protected boolean mShowWeekNumber = false;
  protected MonthAdapter.CalendarDay mTempDay = new MonthAdapter.CalendarDay();

  public DayPickerView(Context paramContext, DatePickerController paramDatePickerController)
  {
    super(paramContext);
    init(paramContext);
    setController(paramDatePickerController);
  }

  private MonthAdapter.CalendarDay findAccessibilityFocus()
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if ((localView instanceof MonthView))
      {
        MonthAdapter.CalendarDay localCalendarDay = ((MonthView)localView).getAccessibilityFocus();
        if (localCalendarDay != null)
        {
          if (Build.VERSION.SDK_INT == 17)
            ((MonthView)localView).clearAccessibilityFocus();
          return localCalendarDay;
        }
      }
      i += 1;
    }
    return null;
  }

  private static String getMonthAndYearString(MonthAdapter.CalendarDay paramCalendarDay)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(year, month, day);
    paramCalendarDay = new StringBuffer();
    paramCalendarDay.append(localCalendar.getDisplayName(2, 2, Locale.getDefault()));
    paramCalendarDay.append(" ");
    paramCalendarDay.append(YEAR_FORMAT.format(localCalendar.getTime()));
    return paramCalendarDay.toString();
  }

  private boolean restoreAccessibilityFocus(MonthAdapter.CalendarDay paramCalendarDay)
  {
    if (paramCalendarDay == null);
    while (true)
    {
      return false;
      int j = getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView = getChildAt(i);
        if (((localView instanceof MonthView)) && (((MonthView)localView).restoreAccessibilityFocus(paramCalendarDay)))
          return true;
        i += 1;
      }
    }
  }

  public abstract MonthAdapter createMonthAdapter(Context paramContext, DatePickerController paramDatePickerController);

  public int getMostVisiblePosition()
  {
    int i2 = getFirstVisiblePosition();
    int i3 = getHeight();
    int j = 0;
    int k = 0;
    int i = 0;
    int n = 0;
    while (true)
    {
      View localView;
      if (n < i3)
      {
        localView = getChildAt(i);
        if (localView != null);
      }
      else
      {
        return i2 + k;
      }
      n = localView.getBottom();
      int i1 = Math.min(n, i3) - Math.max(0, localView.getTop());
      int m = j;
      if (i1 > j)
      {
        k = i;
        m = i1;
      }
      i += 1;
      j = m;
    }
  }

  public boolean goTo(MonthAdapter.CalendarDay paramCalendarDay, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean2)
      mSelectedDay.set(paramCalendarDay);
    mTempDay.set(paramCalendarDay);
    int k = (paramCalendarDay.year - mController.getMinYear()) * 12 + paramCalendarDay.month;
    int i = 0;
    int j = i + 1;
    paramCalendarDay = getChildAt(i);
    if (paramCalendarDay == null)
      label64: if (paramCalendarDay == null)
        break label233;
    label233: for (i = getPositionForView(paramCalendarDay); ; i = 0)
    {
      if (paramBoolean2)
        mAdapter.setSelectedDay(mSelectedDay);
      if (Log.isLoggable("MonthFragment", 3))
        Log.d("MonthFragment", "GoTo position " + k);
      if ((k == i) && (!paramBoolean3))
        break label247;
      setMonthDisplayed(mTempDay);
      mPreviousScrollState = 2;
      if (!paramBoolean1)
        break label239;
      smoothScrollToPositionFromTop(k, LIST_TOP_OFFSET, 250);
      return true;
      i = paramCalendarDay.getTop();
      if (Log.isLoggable("MonthFragment", 3))
        Log.d("MonthFragment", "child at " + (j - 1) + " has top " + i);
      if (i >= 0)
        break label64;
      i = j;
      break;
    }
    label239: postSetSelection(k);
    while (true)
    {
      return false;
      label247: if (paramBoolean2)
        setMonthDisplayed(mSelectedDay);
    }
  }

  public void init(Context paramContext)
  {
    mHandler = new Handler();
    setLayoutParams(new AbsListView.LayoutParams(-1, -1));
    setDrawSelectorOnTop(false);
    mContext = paramContext;
    setUpListView();
  }

  protected void layoutChildren()
  {
    MonthAdapter.CalendarDay localCalendarDay = findAccessibilityFocus();
    super.layoutChildren();
    if (mPerformingScroll)
    {
      mPerformingScroll = false;
      return;
    }
    restoreAccessibilityFocus(localCalendarDay);
  }

  public void onChange()
  {
    refreshAdapter();
  }

  public void onDateChanged()
  {
    goTo(mController.getSelectedDay(), false, true, true);
  }

  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setItemCount(-1);
  }

  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.addAction(4096);
    paramAccessibilityNodeInfo.addAction(8192);
  }

  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    MonthView localMonthView = (MonthView)paramAbsListView.getChildAt(0);
    if (localMonthView == null)
      return;
    mPreviousScrollPosition = (paramAbsListView.getFirstVisiblePosition() * localMonthView.getHeight() - localMonthView.getBottom());
    mPreviousScrollState = mCurrentScrollState;
  }

  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    mScrollStateChangedRunnable.doScrollStateChange(paramAbsListView, paramInt);
  }

  @SuppressLint({"NewApi"})
  public boolean performAccessibilityAction(int paramInt, Bundle paramBundle)
  {
    if ((paramInt != 4096) && (paramInt != 8192))
      return super.performAccessibilityAction(paramInt, paramBundle);
    int i = getFirstVisiblePosition();
    paramBundle = new MonthAdapter.CalendarDay(i / 12 + mController.getMinYear(), i % 12, 1);
    if (paramInt == 4096)
    {
      paramBundle.month += 1;
      if (paramBundle.month == 12)
      {
        paramBundle.month = 0;
        paramBundle.year += 1;
      }
    }
    while (true)
    {
      Utils.tryAccessibilityAnnounce(this, getMonthAndYearString(paramBundle));
      goTo(paramBundle, true, false, true);
      mPerformingScroll = true;
      return true;
      if (paramInt == 8192)
      {
        View localView = getChildAt(0);
        if ((localView != null) && (localView.getTop() >= -1))
        {
          paramBundle.month -= 1;
          if (paramBundle.month == -1)
          {
            paramBundle.month = 11;
            paramBundle.year -= 1;
          }
        }
      }
    }
  }

  public void postSetSelection(final int paramInt)
  {
    clearFocus();
    post(new Runnable()
    {
      public void run()
      {
        setSelection(paramInt);
      }
    });
    onScrollStateChanged(this, 0);
  }

  protected void refreshAdapter()
  {
    if (mAdapter == null)
      mAdapter = createMonthAdapter(getContext(), mController);
    while (true)
    {
      setAdapter(mAdapter);
      return;
      mAdapter.setSelectedDay(mSelectedDay);
    }
  }

  public void setController(DatePickerController paramDatePickerController)
  {
    mController = paramDatePickerController;
    mController.registerOnDateChangedListener(this);
    refreshAdapter();
    onDateChanged();
  }

  protected void setMonthDisplayed(MonthAdapter.CalendarDay paramCalendarDay)
  {
    mCurrentMonthDisplayed = paramCalendarDay.month;
    invalidateViews();
  }

  protected void setUpListView()
  {
    setCacheColorHint(0);
    setDivider(null);
    setItemsCanFocus(true);
    setFastScrollEnabled(false);
    setVerticalScrollBarEnabled(false);
    setOnScrollListener(this);
    setFadingEdgeLength(0);
    setFriction(ViewConfiguration.getScrollFriction() * mFriction);
  }

  protected class ScrollStateRunnable
    implements Runnable
  {
    private int mNewState;

    protected ScrollStateRunnable()
    {
    }

    public void doScrollStateChange(AbsListView paramAbsListView, int paramInt)
    {
      mHandler.removeCallbacks(this);
      mNewState = paramInt;
      mHandler.postDelayed(this, 40L);
    }

    public void run()
    {
      int j = 1;
      mCurrentScrollState = mNewState;
      if (Log.isLoggable("MonthFragment", 3))
        Log.d("MonthFragment", "new scroll state: " + mNewState + " old state: " + mPreviousScrollState);
      if ((mNewState == 0) && (mPreviousScrollState != 0) && (mPreviousScrollState != 1))
      {
        mPreviousScrollState = mNewState;
        int i = 0;
        for (Object localObject = getChildAt(0); (localObject != null) && (((View)localObject).getBottom() <= 0); localObject = ((DayPickerView)localObject).getChildAt(i))
        {
          localObject = DayPickerView.this;
          i += 1;
        }
        if (localObject == null)
          return;
        i = getFirstVisiblePosition();
        int k = getLastVisiblePosition();
        if ((i != 0) && (k != getCount() - 1));
        for (i = j; ; i = 0)
        {
          j = ((View)localObject).getTop();
          k = ((View)localObject).getBottom();
          int m = getHeight() / 2;
          if ((i == 0) || (j >= DayPickerView.LIST_TOP_OFFSET))
            break;
          if (k <= m)
            break label248;
          smoothScrollBy(j, 250);
          return;
        }
        label248: smoothScrollBy(k, 250);
        return;
      }
      mPreviousScrollState = mNewState;
    }
  }
}