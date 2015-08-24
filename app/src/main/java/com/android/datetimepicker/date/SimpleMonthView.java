package com.android.datetimepicker.date;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

public class SimpleMonthView extends MonthView
{
  public SimpleMonthView(Context paramContext)
  {
    super(paramContext);
  }

  public void drawMonthDay(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
  {
    if (mSelectedDay == paramInt3)
      paramCanvas.drawCircle(paramInt4, paramInt5 - MINI_DAY_NUMBER_TEXT_SIZE / 3, DAY_SELECTED_CIRCLE_SIZE, mSelectedCirclePaint);
    if (isOutOfRange(paramInt1, paramInt2, paramInt3))
      mMonthNumPaint.setColor(mDisabledDayTextColor);
    while (true)
    {
      paramCanvas.drawText(String.format("%d", new Object[] { Integer.valueOf(paramInt3) }), paramInt4, paramInt5, mMonthNumPaint);
      return;
      if ((mHasToday) && (mToday == paramInt3))
        mMonthNumPaint.setColor(mTodayNumberColor);
      else
        mMonthNumPaint.setColor(mDayTextColor);
    }
  }
}