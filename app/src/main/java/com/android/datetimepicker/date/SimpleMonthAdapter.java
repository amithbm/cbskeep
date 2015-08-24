package com.android.datetimepicker.date;

import android.content.Context;

public class SimpleMonthAdapter extends MonthAdapter
{
  public SimpleMonthAdapter(Context paramContext, DatePickerController paramDatePickerController)
  {
    super(paramContext, paramDatePickerController);
  }

  public MonthView createMonthView(Context paramContext)
  {
    paramContext = new SimpleMonthView(paramContext);
    paramContext.setDatePickerController(mController);
    return paramContext;
  }
}