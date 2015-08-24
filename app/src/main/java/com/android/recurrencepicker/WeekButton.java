package com.android.recurrencepicker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ToggleButton;

public class WeekButton extends ToggleButton
{
  private static int mWidth;

  public WeekButton(Context paramContext)
  {
    super(paramContext);
  }

  public WeekButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public WeekButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public static void setSuggestedWidth(int paramInt)
  {
    mWidth = paramInt;
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = getMeasuredHeight();
    paramInt2 = getMeasuredWidth();
    int i = paramInt1;
    int j = paramInt2;
    if (paramInt1 > 0)
    {
      i = paramInt1;
      j = paramInt2;
      if (paramInt2 > 0)
      {
        if (paramInt2 >= paramInt1)
          break label69;
        i = paramInt1;
        j = paramInt2;
        if (View.MeasureSpec.getMode(getMeasuredHeightAndState()) != 1073741824)
        {
          i = paramInt2;
          j = paramInt2;
        }
      }
    }
    while (true)
    {
      setMeasuredDimension(j, i);
      return;
      label69: i = paramInt1;
      j = paramInt2;
      if (paramInt1 < paramInt2)
      {
        i = paramInt1;
        j = paramInt2;
        if (View.MeasureSpec.getMode(getMeasuredWidthAndState()) != 1073741824)
        {
          j = paramInt1;
          i = paramInt1;
        }
      }
    }
  }
}