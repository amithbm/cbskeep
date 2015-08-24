package com.android.datetimepicker.date;

import java.util.Calendar;

public abstract interface DatePickerController
{
  public abstract int getFirstDayOfWeek();

  public abstract Calendar getMaxDate();

  public abstract int getMaxYear();

  public abstract Calendar getMinDate();

  public abstract int getMinYear();

  public abstract MonthAdapter.CalendarDay getSelectedDay();

  public abstract void onDayOfMonthSelected(int paramInt1, int paramInt2, int paramInt3);

  public abstract void onYearSelected(int paramInt);

  public abstract void registerOnDateChangedListener(DatePickerDialog.OnDateChangedListener paramOnDateChangedListener);

  public abstract void tryVibrate();
}