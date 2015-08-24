package com.android.datetimepicker.time;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Typeface;
import android.util.Log;
import android.view.View;
import com.android.datetimepicker.R.color;
import com.android.datetimepicker.R.string;
import java.text.DateFormatSymbols;

public class AmPmCirclesView extends View
{
  private int mAmOrPm;
  private int mAmOrPmPressed;
  private int mAmPmCircleRadius;
  private float mAmPmCircleRadiusMultiplier;
  private int mAmPmTextColor;
  private int mAmPmYCenter;
  private String mAmText;
  private int mAmXCenter;
  private float mCircleRadiusMultiplier;
  private boolean mDrawValuesReady;
  private boolean mIsInitialized = false;
  private final Paint mPaint = new Paint();
  private String mPmText;
  private int mPmXCenter;
  private int mSelectedAlpha;
  private int mSelectedColor;
  private int mUnselectedColor;

  public AmPmCirclesView(Context paramContext)
  {
    super(paramContext);
  }

  public int getIsTouchingAmOrPm(float paramFloat1, float paramFloat2)
  {
    if (!mDrawValuesReady);
    int i;
    do
    {
      return -1;
      i = (int)((paramFloat2 - mAmPmYCenter) * (paramFloat2 - mAmPmYCenter));
      if ((int)Math.sqrt((paramFloat1 - mAmXCenter) * (paramFloat1 - mAmXCenter) + i) <= mAmPmCircleRadius)
        return 0;
    }
    while ((int)Math.sqrt((paramFloat1 - mPmXCenter) * (paramFloat1 - mPmXCenter) + i) > mAmPmCircleRadius);
    return 1;
  }

  public void initialize(Context paramContext, int paramInt)
  {
    if (mIsInitialized)
    {
      Log.e("AmPmCirclesView", "AmPmCirclesView may only be initialized once.");
      return;
    }
    paramContext = paramContext.getResources();
    mUnselectedColor = paramContext.getColor(R.color.white);
    mSelectedColor = paramContext.getColor(R.color.blue);
    mAmPmTextColor = paramContext.getColor(R.color.ampm_text_color);
    mSelectedAlpha = 51;
    Typeface localTypeface = Typeface.create(paramContext.getString(R.string.sans_serif), 0);
    mPaint.setTypeface(localTypeface);
    mPaint.setAntiAlias(true);
    mPaint.setTextAlign(Paint.Align.CENTER);
    mCircleRadiusMultiplier = Float.parseFloat(paramContext.getString(R.string.circle_radius_multiplier));
    mAmPmCircleRadiusMultiplier = Float.parseFloat(paramContext.getString(R.string.ampm_circle_radius_multiplier));
    paramContext = new DateFormatSymbols().getAmPmStrings();
    mAmText = paramContext[0];
    mPmText = paramContext[1];
    setAmOrPm(paramInt);
    mAmOrPmPressed = -1;
    mIsInitialized = true;
  }

  public void onDraw(Canvas paramCanvas)
  {
    if ((getWidth() == 0) || (!mIsInitialized))
      return;
    int i;
    int j;
    if (!mDrawValuesReady)
    {
      i = getWidth() / 2;
      j = getHeight() / 2;
      k = (int)(Math.min(i, j) * mCircleRadiusMultiplier);
      mAmPmCircleRadius = ((int)(k * mAmPmCircleRadiusMultiplier));
      m = mAmPmCircleRadius * 3 / 4;
      mPaint.setTextSize(m);
      mAmPmYCenter = (j - mAmPmCircleRadius / 2 + k);
      mAmXCenter = (i - k + mAmPmCircleRadius);
      mPmXCenter = (i + k - mAmPmCircleRadius);
      mDrawValuesReady = true;
    }
    int n = mUnselectedColor;
    int i1 = 255;
    int m = mUnselectedColor;
    int k = 255;
    if (mAmOrPm == 0)
    {
      i = mSelectedColor;
      j = mSelectedAlpha;
      if (mAmOrPmPressed != 0)
        break label378;
      n = mSelectedColor;
      i1 = mSelectedAlpha;
    }
    while (true)
    {
      mPaint.setColor(n);
      mPaint.setAlpha(i1);
      paramCanvas.drawCircle(mAmXCenter, mAmPmYCenter, mAmPmCircleRadius, mPaint);
      mPaint.setColor(m);
      mPaint.setAlpha(k);
      paramCanvas.drawCircle(mPmXCenter, mAmPmYCenter, mAmPmCircleRadius, mPaint);
      mPaint.setColor(mAmPmTextColor);
      i = mAmPmYCenter - (int)(mPaint.descent() + mPaint.ascent()) / 2;
      paramCanvas.drawText(mAmText, mAmXCenter, i, mPaint);
      paramCanvas.drawText(mPmText, mPmXCenter, i, mPaint);
      return;
      j = i1;
      i = n;
      if (mAmOrPm != 1)
        break;
      m = mSelectedColor;
      k = mSelectedAlpha;
      j = i1;
      i = n;
      break;
      label378: i1 = j;
      n = i;
      if (mAmOrPmPressed == 1)
      {
        m = mSelectedColor;
        k = mSelectedAlpha;
        i1 = j;
        n = i;
      }
    }
  }

  public void setAmOrPm(int paramInt)
  {
    mAmOrPm = paramInt;
  }

  public void setAmOrPmPressed(int paramInt)
  {
    mAmOrPmPressed = paramInt;
  }
}