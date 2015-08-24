package com.android.datetimepicker.date;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import java.util.Calendar;
import java.util.HashMap;

public abstract class MonthAdapter extends BaseAdapter
  implements MonthView.OnDayClickListener
{
  protected static int WEEK_7_OVERHANG_HEIGHT = 7;
  private final Context mContext;
  protected final DatePickerController mController;
  private CalendarDay mSelectedDay;

  public MonthAdapter(Context paramContext, DatePickerController paramDatePickerController)
  {
    mContext = paramContext;
    mController = paramDatePickerController;
    init();
    setSelectedDay(mController.getSelectedDay());
  }

  private boolean isSelectedDayInMonth(int paramInt1, int paramInt2)
  {
    return (mSelectedDay.year == paramInt1) && (mSelectedDay.month == paramInt2);
  }

  public abstract MonthView createMonthView(Context paramContext);

  public int getCount()
  {
    return (mController.getMaxYear() - mController.getMinYear() + 1) * 12;
  }

  public Object getItem(int paramInt)
  {
    return null;
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  @SuppressLint({"NewApi"})
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = null;
    if (paramView != null)
    {
      paramViewGroup = (MonthView)paramView;
      paramView = (HashMap)paramViewGroup.getTag();
    }
    while (true)
    {
      Object localObject = paramView;
      if (paramView == null)
        localObject = new HashMap();
      ((HashMap)localObject).clear();
      int i = paramInt % 12;
      int j = paramInt / 12 + mController.getMinYear();
      paramInt = -1;
      if (isSelectedDayInMonth(j, i))
        paramInt = mSelectedDay.day;
      paramViewGroup.reuse();
      ((HashMap)localObject).put("selected_day", Integer.valueOf(paramInt));
      ((HashMap)localObject).put("year", Integer.valueOf(j));
      ((HashMap)localObject).put("month", Integer.valueOf(i));
      ((HashMap)localObject).put("week_start", Integer.valueOf(mController.getFirstDayOfWeek()));
      paramViewGroup.setMonthParams((HashMap)localObject);
      paramViewGroup.invalidate();
      return paramViewGroup;
      localObject = createMonthView(mContext);
      ((MonthView)localObject).setLayoutParams(new AbsListView.LayoutParams(-1, -1));
      ((MonthView)localObject).setClickable(true);
      ((MonthView)localObject).setOnDayClickListener(this);
      paramView = paramViewGroup;
      paramViewGroup = (ViewGroup)localObject;
    }
  }

  public boolean hasStableIds()
  {
    return true;
  }

  protected void init()
  {
    mSelectedDay = new CalendarDay(System.currentTimeMillis());
  }

  public void onDayClick(MonthView paramMonthView, CalendarDay paramCalendarDay)
  {
    if (paramCalendarDay != null)
      onDayTapped(paramCalendarDay);
  }

  protected void onDayTapped(CalendarDay paramCalendarDay)
  {
    mController.tryVibrate();
    mController.onDayOfMonthSelected(paramCalendarDay.year, paramCalendarDay.month, paramCalendarDay.day);
    setSelectedDay(paramCalendarDay);
  }

  public void setSelectedDay(CalendarDay paramCalendarDay)
  {
    mSelectedDay = paramCalendarDay;
    notifyDataSetChanged();
  }

  public static class CalendarDay
  {
    private Calendar calendar;
    int day;
    int month;
    int year;

    public CalendarDay()
    {
      setTime(System.currentTimeMillis());
    }

    public CalendarDay(int paramInt1, int paramInt2, int paramInt3)
    {
      setDay(paramInt1, paramInt2, paramInt3);
    }

    public CalendarDay(long paramLong)
    {
      setTime(paramLong);
    }

    public CalendarDay(Calendar paramCalendar)
    {
      year = paramCalendar.get(1);
      month = paramCalendar.get(2);
      day = paramCalendar.get(5);
    }

    private void setTime(long paramLong)
    {
      if (calendar == null)
        calendar = Calendar.getInstance();
      calendar.setTimeInMillis(paramLong);
      month = calendar.get(2);
      year = calendar.get(1);
      day = calendar.get(5);
    }

    public void set(CalendarDay paramCalendarDay)
    {
      year = paramCalendarDay.year;
      month = paramCalendarDay.month;
      day = paramCalendarDay.day;
    }

    public void setDay(int paramInt1, int paramInt2, int paramInt3)
    {
      year = paramInt1;
      month = paramInt2;
      day = paramInt3;
    }
  }
}