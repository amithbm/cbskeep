package com.android.datetimepicker.date;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.widget.TextView;
import com.android.datetimepicker.R.color;
import com.android.datetimepicker.R.dimen;
import com.android.datetimepicker.R.string;

public class TextViewWithCircularIndicator extends TextView
{
  private final int mCircleColor;
  Paint mCirclePaint = new Paint();
  private boolean mDrawCircle;
  private final String mItemIsSelectedText;
  private final int mRadius;

  public TextViewWithCircularIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = paramContext.getResources();
    mCircleColor = paramAttributeSet.getColor(R.color.blue);
    mRadius = paramAttributeSet.getDimensionPixelOffset(R.dimen.month_select_circle_radius);
    mItemIsSelectedText = paramContext.getResources().getString(R.string.item_is_selected);
    init();
  }

  private void init()
  {
    mCirclePaint.setFakeBoldText(true);
    mCirclePaint.setAntiAlias(true);
    mCirclePaint.setColor(mCircleColor);
    mCirclePaint.setTextAlign(Paint.Align.CENTER);
    mCirclePaint.setStyle(Paint.Style.FILL);
    mCirclePaint.setAlpha(60);
  }

  public void drawIndicator(boolean paramBoolean)
  {
    mDrawCircle = paramBoolean;
  }

  public CharSequence getContentDescription()
  {
    CharSequence localCharSequence = getText();
    Object localObject = localCharSequence;
    if (mDrawCircle)
      localObject = String.format(mItemIsSelectedText, new Object[] { localCharSequence });
    return localObject;
  }

  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (mDrawCircle)
    {
      int i = getWidth();
      int j = getHeight();
      int k = Math.min(i, j) / 2;
      paramCanvas.drawCircle(i / 2, j / 2, k, mCirclePaint);
    }
  }
}