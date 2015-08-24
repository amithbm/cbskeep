package com.android.datetimepicker.date;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.support.v4.widget.ExploreByTouchHelper;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import android.text.format.Time;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.View.MeasureSpec;
import android.view.accessibility.AccessibilityEvent;
import com.android.datetimepicker.R.color;
import com.android.datetimepicker.R.dimen;
import com.android.datetimepicker.R.string;
import com.android.datetimepicker.Utils;
import java.security.InvalidParameterException;
import java.util.Calendar;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public abstract class MonthView extends View
{
  protected static int DAY_SELECTED_CIRCLE_SIZE;
  protected static int DAY_SEPARATOR_WIDTH = 1;
  protected static int DEFAULT_HEIGHT = 32;
  protected static int MINI_DAY_NUMBER_TEXT_SIZE;
  protected static int MIN_HEIGHT = 10;
  protected static int MONTH_DAY_LABEL_TEXT_SIZE;
  protected static int MONTH_HEADER_SIZE;
  protected static int MONTH_LABEL_TEXT_SIZE;
  protected static float mScale = 0.0F;
  private final Calendar mCalendar;
  protected DatePickerController mController;
  protected final Calendar mDayLabelCalendar;
  private int mDayOfWeekStart = 0;
  private String mDayOfWeekTypeface;
  protected int mDayTextColor;
  protected int mDisabledDayTextColor;
  protected int mEdgePadding = 0;
  protected int mFirstJulianDay = -1;
  protected int mFirstMonth = -1;
  private final Formatter mFormatter;
  protected boolean mHasToday = false;
  protected int mLastMonth = -1;
  private boolean mLockAccessibilityDelegate;
  protected int mMonth;
  protected Paint mMonthDayLabelPaint;
  protected Paint mMonthNumPaint;
  protected int mMonthTitleBGColor;
  protected Paint mMonthTitleBGPaint;
  protected int mMonthTitleColor;
  protected Paint mMonthTitlePaint;
  private String mMonthTitleTypeface;
  protected int mNumCells = mNumDays;
  protected int mNumDays = 7;
  protected int mNumRows = 6;
  protected OnDayClickListener mOnDayClickListener;
  protected int mRowHeight = DEFAULT_HEIGHT;
  protected Paint mSelectedCirclePaint;
  protected int mSelectedDay = -1;
  protected int mSelectedLeft = -1;
  protected int mSelectedRight = -1;
  private final StringBuilder mStringBuilder;
  protected int mToday = -1;
  protected int mTodayNumberColor;
  private final MonthViewTouchHelper mTouchHelper;
  protected int mWeekStart = 1;
  protected int mWidth;
  protected int mYear;

  public MonthView(Context paramContext)
  {
    this(paramContext, null);
  }

  public MonthView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.getResources();
    mDayLabelCalendar = Calendar.getInstance();
    mCalendar = Calendar.getInstance();
    mDayOfWeekTypeface = paramContext.getString(R.string.day_of_week_label_typeface);
    mMonthTitleTypeface = paramContext.getString(R.string.sans_serif);
    mDayTextColor = paramContext.getColor(R.color.date_picker_text_normal);
    mTodayNumberColor = paramContext.getColor(R.color.blue);
    mDisabledDayTextColor = paramContext.getColor(R.color.date_picker_text_disabled);
    mMonthTitleColor = paramContext.getColor(R.color.white);
    mMonthTitleBGColor = paramContext.getColor(R.color.circle_background);
    mStringBuilder = new StringBuilder(50);
    mFormatter = new Formatter(mStringBuilder, Locale.getDefault());
    MINI_DAY_NUMBER_TEXT_SIZE = paramContext.getDimensionPixelSize(R.dimen.day_number_size);
    MONTH_LABEL_TEXT_SIZE = paramContext.getDimensionPixelSize(R.dimen.month_label_size);
    MONTH_DAY_LABEL_TEXT_SIZE = paramContext.getDimensionPixelSize(R.dimen.month_day_label_text_size);
    MONTH_HEADER_SIZE = paramContext.getDimensionPixelOffset(R.dimen.month_list_item_header_height);
    DAY_SELECTED_CIRCLE_SIZE = paramContext.getDimensionPixelSize(R.dimen.day_number_select_circle_radius);
    mRowHeight = ((paramContext.getDimensionPixelOffset(R.dimen.date_picker_view_animator_height) - getMonthHeaderSize()) / 6);
    mTouchHelper = getMonthViewTouchHelper();
    ViewCompat.setAccessibilityDelegate(this, mTouchHelper);
    ViewCompat.setImportantForAccessibility(this, 1);
    mLockAccessibilityDelegate = true;
    initView();
  }

  private int calculateNumRows()
  {
    int i = findDayOffset();
    int j = (mNumCells + i) / mNumDays;
    if ((mNumCells + i) % mNumDays > 0);
    for (i = 1; ; i = 0)
      return i + j;
  }

  private String getMonthAndYearString()
  {
    mStringBuilder.setLength(0);
    long l = mCalendar.getTimeInMillis();
    return DateUtils.formatDateRange(getContext(), mFormatter, l, l, 52, Time.getCurrentTimezone()).toString();
  }

  private boolean isAfterMax(int paramInt1, int paramInt2, int paramInt3)
  {
    if (mController == null);
    Calendar localCalendar;
    do
    {
      do
      {
        do
        {
          return false;
          localCalendar = mController.getMaxDate();
        }
        while (localCalendar == null);
        if (paramInt1 > localCalendar.get(1))
          return true;
      }
      while (paramInt1 < localCalendar.get(1));
      if (paramInt2 > localCalendar.get(2))
        return true;
    }
    while ((paramInt2 < localCalendar.get(2)) || (paramInt3 <= localCalendar.get(5)));
    return true;
  }

  private boolean isBeforeMin(int paramInt1, int paramInt2, int paramInt3)
  {
    if (mController == null);
    Calendar localCalendar;
    do
    {
      do
      {
        do
        {
          return false;
          localCalendar = mController.getMinDate();
        }
        while (localCalendar == null);
        if (paramInt1 < localCalendar.get(1))
          return true;
      }
      while (paramInt1 > localCalendar.get(1));
      if (paramInt2 < localCalendar.get(2))
        return true;
    }
    while ((paramInt2 > localCalendar.get(2)) || (paramInt3 >= localCalendar.get(5)));
    return true;
  }

  private void onDayClick(int paramInt)
  {
    if (isOutOfRange(mYear, mMonth, paramInt))
      return;
    if (mOnDayClickListener != null)
      mOnDayClickListener.onDayClick(this, new MonthAdapter.CalendarDay(mYear, mMonth, paramInt));
    mTouchHelper.sendEventForVirtualView(paramInt, 1);
  }

  private boolean sameDay(int paramInt, Time paramTime)
  {
    return (mYear == paramTime.year) && (mMonth == paramTime.month) && (paramInt == paramTime.monthDay);
  }

  public void clearAccessibilityFocus()
  {
    mTouchHelper.clearFocusedVirtualView();
  }

  public boolean dispatchHoverEvent(MotionEvent paramMotionEvent)
  {
    if (mTouchHelper.dispatchHoverEvent(paramMotionEvent))
      return true;
    return super.dispatchHoverEvent(paramMotionEvent);
  }

  public abstract void drawMonthDay(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9);

  protected void drawMonthDayLabels(Canvas paramCanvas)
  {
    int j = getMonthHeaderSize();
    int k = MONTH_DAY_LABEL_TEXT_SIZE / 2;
    int m = (mWidth - mEdgePadding * 2) / (mNumDays * 2);
    int i = 0;
    while (i < mNumDays)
    {
      int n = mWeekStart;
      int i1 = mNumDays;
      int i2 = mEdgePadding;
      mDayLabelCalendar.set(7, (n + i) % i1);
      paramCanvas.drawText(mDayLabelCalendar.getDisplayName(7, 1, Locale.getDefault()).toUpperCase(Locale.getDefault()), (i * 2 + 1) * m + i2, j - k, mMonthDayLabelPaint);
      i += 1;
    }
  }

  protected void drawMonthNums(Canvas paramCanvas)
  {
    int k = (mRowHeight + MINI_DAY_NUMBER_TEXT_SIZE) / 2 - DAY_SEPARATOR_WIDTH + getMonthHeaderSize();
    float f = (mWidth - mEdgePadding * 2) / (mNumDays * 2.0F);
    int i = findDayOffset();
    int j = 1;
    while (j <= mNumCells)
    {
      int m = (int)((i * 2 + 1) * f + mEdgePadding);
      int i2 = (mRowHeight + MINI_DAY_NUMBER_TEXT_SIZE) / 2;
      int i3 = DAY_SEPARATOR_WIDTH;
      int n = (int)(m - f);
      int i1 = (int)(m + f);
      i2 = k - (i2 - i3);
      i3 = mRowHeight;
      drawMonthDay(paramCanvas, mYear, mMonth, j, m, k, n, i1, i2, i2 + i3);
      n = i + 1;
      m = k;
      i = n;
      if (n == mNumDays)
      {
        i = 0;
        m = k + mRowHeight;
      }
      j += 1;
      k = m;
    }
  }

  protected void drawMonthTitle(Canvas paramCanvas)
  {
    int i = (mWidth + mEdgePadding * 2) / 2;
    int j = (getMonthHeaderSize() - MONTH_DAY_LABEL_TEXT_SIZE) / 2;
    int k = MONTH_LABEL_TEXT_SIZE / 3;
    paramCanvas.drawText(getMonthAndYearString(), i, j + k, mMonthTitlePaint);
  }

  protected int findDayOffset()
  {
    if (mDayOfWeekStart < mWeekStart);
    for (int i = mDayOfWeekStart + mNumDays; ; i = mDayOfWeekStart)
      return i - mWeekStart;
  }

  public MonthAdapter.CalendarDay getAccessibilityFocus()
  {
    int i = mTouchHelper.getFocusedVirtualView();
    if (i >= 0)
      return new MonthAdapter.CalendarDay(mYear, mMonth, i);
    return null;
  }

  public int getDayFromLocation(float paramFloat1, float paramFloat2)
  {
    int j = getInternalDayFromLocation(paramFloat1, paramFloat2);
    int i;
    if (j >= 1)
    {
      i = j;
      if (j <= mNumCells);
    }
    else
    {
      i = -1;
    }
    return i;
  }

  protected int getInternalDayFromLocation(float paramFloat1, float paramFloat2)
  {
    int i = mEdgePadding;
    if ((paramFloat1 < i) || (paramFloat1 > mWidth - mEdgePadding))
      return -1;
    int j = (int)(paramFloat2 - getMonthHeaderSize()) / mRowHeight;
    return (int)((paramFloat1 - i) * mNumDays / (mWidth - i - mEdgePadding)) - findDayOffset() + 1 + mNumDays * j;
  }

  protected int getMonthHeaderSize()
  {
    return MONTH_HEADER_SIZE;
  }

  protected MonthViewTouchHelper getMonthViewTouchHelper()
  {
    return new MonthViewTouchHelper(this);
  }

  protected void initView()
  {
    mMonthTitlePaint = new Paint();
    mMonthTitlePaint.setFakeBoldText(true);
    mMonthTitlePaint.setAntiAlias(true);
    mMonthTitlePaint.setTextSize(MONTH_LABEL_TEXT_SIZE);
    mMonthTitlePaint.setTypeface(Typeface.create(mMonthTitleTypeface, 1));
    mMonthTitlePaint.setColor(mDayTextColor);
    mMonthTitlePaint.setTextAlign(Paint.Align.CENTER);
    mMonthTitlePaint.setStyle(Paint.Style.FILL);
    mMonthTitleBGPaint = new Paint();
    mMonthTitleBGPaint.setFakeBoldText(true);
    mMonthTitleBGPaint.setAntiAlias(true);
    mMonthTitleBGPaint.setColor(mMonthTitleBGColor);
    mMonthTitleBGPaint.setTextAlign(Paint.Align.CENTER);
    mMonthTitleBGPaint.setStyle(Paint.Style.FILL);
    mSelectedCirclePaint = new Paint();
    mSelectedCirclePaint.setFakeBoldText(true);
    mSelectedCirclePaint.setAntiAlias(true);
    mSelectedCirclePaint.setColor(mTodayNumberColor);
    mSelectedCirclePaint.setTextAlign(Paint.Align.CENTER);
    mSelectedCirclePaint.setStyle(Paint.Style.FILL);
    mSelectedCirclePaint.setAlpha(60);
    mMonthDayLabelPaint = new Paint();
    mMonthDayLabelPaint.setAntiAlias(true);
    mMonthDayLabelPaint.setTextSize(MONTH_DAY_LABEL_TEXT_SIZE);
    mMonthDayLabelPaint.setColor(mDayTextColor);
    mMonthDayLabelPaint.setTypeface(Typeface.create(mDayOfWeekTypeface, 0));
    mMonthDayLabelPaint.setStyle(Paint.Style.FILL);
    mMonthDayLabelPaint.setTextAlign(Paint.Align.CENTER);
    mMonthDayLabelPaint.setFakeBoldText(true);
    mMonthNumPaint = new Paint();
    mMonthNumPaint.setAntiAlias(true);
    mMonthNumPaint.setTextSize(MINI_DAY_NUMBER_TEXT_SIZE);
    mMonthNumPaint.setStyle(Paint.Style.FILL);
    mMonthNumPaint.setTextAlign(Paint.Align.CENTER);
    mMonthNumPaint.setFakeBoldText(false);
  }

  protected boolean isOutOfRange(int paramInt1, int paramInt2, int paramInt3)
  {
    if (isBeforeMin(paramInt1, paramInt2, paramInt3));
    while (isAfterMax(paramInt1, paramInt2, paramInt3))
      return true;
    return false;
  }

  protected void onDraw(Canvas paramCanvas)
  {
    drawMonthTitle(paramCanvas);
    drawMonthDayLabels(paramCanvas);
    drawMonthNums(paramCanvas);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), mRowHeight * mNumRows + getMonthHeaderSize());
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    mWidth = paramInt1;
    mTouchHelper.invalidateRoot();
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    default:
    case 1:
    }
    while (true)
    {
      return true;
      int i = getDayFromLocation(paramMotionEvent.getX(), paramMotionEvent.getY());
      if (i >= 0)
        onDayClick(i);
    }
  }

  public boolean restoreAccessibilityFocus(MonthAdapter.CalendarDay paramCalendarDay)
  {
    if ((paramCalendarDay.year != mYear) || (paramCalendarDay.month != mMonth) || (paramCalendarDay.day > mNumCells))
      return false;
    mTouchHelper.setFocusedVirtualView(paramCalendarDay.day);
    return true;
  }

  public void reuse()
  {
    mNumRows = 6;
    requestLayout();
  }

  public void setAccessibilityDelegate(View.AccessibilityDelegate paramAccessibilityDelegate)
  {
    if (!mLockAccessibilityDelegate)
      super.setAccessibilityDelegate(paramAccessibilityDelegate);
  }

  public void setDatePickerController(DatePickerController paramDatePickerController)
  {
    mController = paramDatePickerController;
  }

  public void setMonthParams(HashMap<String, Integer> paramHashMap)
  {
    if ((!paramHashMap.containsKey("month")) && (!paramHashMap.containsKey("year")))
      throw new InvalidParameterException("You must specify month and year for this view");
    setTag(paramHashMap);
    if (paramHashMap.containsKey("height"))
    {
      mRowHeight = ((Integer)paramHashMap.get("height")).intValue();
      if (mRowHeight < MIN_HEIGHT)
        mRowHeight = MIN_HEIGHT;
    }
    if (paramHashMap.containsKey("selected_day"))
      mSelectedDay = ((Integer)paramHashMap.get("selected_day")).intValue();
    mMonth = ((Integer)paramHashMap.get("month")).intValue();
    mYear = ((Integer)paramHashMap.get("year")).intValue();
    Time localTime = new Time(Time.getCurrentTimezone());
    localTime.setToNow();
    mHasToday = false;
    mToday = -1;
    mCalendar.set(2, mMonth);
    mCalendar.set(1, mYear);
    mCalendar.set(5, 1);
    mDayOfWeekStart = mCalendar.get(7);
    if (paramHashMap.containsKey("week_start"));
    for (mWeekStart = ((Integer)paramHashMap.get("week_start")).intValue(); ; mWeekStart = mCalendar.getFirstDayOfWeek())
    {
      mNumCells = Utils.getDaysInMonth(mMonth, mYear);
      int i = 0;
      while (i < mNumCells)
      {
        int j = i + 1;
        if (sameDay(j, localTime))
        {
          mHasToday = true;
          mToday = j;
        }
        i += 1;
      }
    }
    mNumRows = calculateNumRows();
    mTouchHelper.invalidateRoot();
  }

  public void setOnDayClickListener(OnDayClickListener paramOnDayClickListener)
  {
    mOnDayClickListener = paramOnDayClickListener;
  }

  protected class MonthViewTouchHelper extends ExploreByTouchHelper
  {
    private final Calendar mTempCalendar = Calendar.getInstance();
    private final Rect mTempRect = new Rect();

    public MonthViewTouchHelper(View arg2)
    {
      super();
    }

    public void clearFocusedVirtualView()
    {
      int i = getFocusedVirtualView();
      if (i != -2147483648)
        getAccessibilityNodeProvider(MonthView.this).performAction(i, 128, null);
    }

    protected void getItemBounds(int paramInt, Rect paramRect)
    {
      int m = mEdgePadding;
      int k = getMonthHeaderSize();
      int i = mRowHeight;
      int j = (mWidth - mEdgePadding * 2) / mNumDays;
      int n = paramInt - 1 + findDayOffset();
      paramInt = n / mNumDays;
      m += n % mNumDays * j;
      paramInt = k + paramInt * i;
      paramRect.set(m, paramInt, m + j, paramInt + i);
    }

    protected CharSequence getItemDescription(int paramInt)
    {
      mTempCalendar.set(mYear, mMonth, paramInt);
      CharSequence localCharSequence = DateFormat.format("dd MMMM yyyy", mTempCalendar.getTimeInMillis());
      Object localObject = localCharSequence;
      if (paramInt == mSelectedDay)
        localObject = getContext().getString(R.string.item_is_selected, new Object[] { localCharSequence });
      return localObject;
    }

    protected int getVirtualViewAt(float paramFloat1, float paramFloat2)
    {
      int i = getDayFromLocation(paramFloat1, paramFloat2);
      if (i >= 0)
        return i;
      return -2147483648;
    }

    protected void getVisibleVirtualViews(List<Integer> paramList)
    {
      int i = 1;
      while (i <= mNumCells)
      {
        paramList.add(Integer.valueOf(i));
        i += 1;
      }
    }

    protected boolean onPerformActionForVirtualView(int paramInt1, int paramInt2, Bundle paramBundle)
    {
      switch (paramInt2)
      {
      default:
        return false;
      case 16:
      }
      MonthView.this.onDayClick(paramInt1);
      return true;
    }

    protected void onPopulateEventForVirtualView(int paramInt, AccessibilityEvent paramAccessibilityEvent)
    {
      paramAccessibilityEvent.setContentDescription(getItemDescription(paramInt));
    }

    protected void onPopulateNodeForVirtualView(int paramInt, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      getItemBounds(paramInt, mTempRect);
      paramAccessibilityNodeInfoCompat.setContentDescription(getItemDescription(paramInt));
      paramAccessibilityNodeInfoCompat.setBoundsInParent(mTempRect);
      paramAccessibilityNodeInfoCompat.addAction(16);
      if (paramInt == mSelectedDay)
        paramAccessibilityNodeInfoCompat.setSelected(true);
    }

    public void setFocusedVirtualView(int paramInt)
    {
      getAccessibilityNodeProvider(MonthView.this).performAction(paramInt, 64, null);
    }
  }

  public static abstract interface OnDayClickListener
  {
    public abstract void onDayClick(MonthView paramMonthView, MonthAdapter.CalendarDay paramCalendarDay);
  }
}