package com.android.datetimepicker.time;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;
import com.android.datetimepicker.R.color;
import com.android.datetimepicker.R.string;

public class CircleView extends View
{
  private float mAmPmCircleRadiusMultiplier;
  private int mCircleColor;
  private int mCircleRadius;
  private float mCircleRadiusMultiplier;
  private int mDotColor;
  private boolean mDrawValuesReady;
  private boolean mIs24HourMode;
  private boolean mIsInitialized;
  private final Paint mPaint = new Paint();
  private int mXCenter;
  private int mYCenter;

  public CircleView(Context paramContext)
  {
    super(paramContext);
    paramContext = paramContext.getResources();
    mCircleColor = paramContext.getColor(R.color.white);
    mDotColor = paramContext.getColor(R.color.numbers_text_color);
    mPaint.setAntiAlias(true);
    mIsInitialized = false;
  }

  public void initialize(Context paramContext, boolean paramBoolean)
  {
    if (mIsInitialized)
    {
      Log.e("CircleView", "CircleView may only be initialized once.");
      return;
    }
    paramContext = paramContext.getResources();
    mIs24HourMode = paramBoolean;
    if (paramBoolean)
      mCircleRadiusMultiplier = Float.parseFloat(paramContext.getString(R.string.circle_radius_multiplier_24HourMode));
    while (true)
    {
      mIsInitialized = true;
      return;
      mCircleRadiusMultiplier = Float.parseFloat(paramContext.getString(R.string.circle_radius_multiplier));
      mAmPmCircleRadiusMultiplier = Float.parseFloat(paramContext.getString(R.string.ampm_circle_radius_multiplier));
    }
  }

  public void onDraw(Canvas paramCanvas)
  {
    if ((getWidth() == 0) || (!mIsInitialized))
      return;
    if (!mDrawValuesReady)
    {
      mXCenter = (getWidth() / 2);
      mYCenter = (getHeight() / 2);
      mCircleRadius = ((int)(Math.min(mXCenter, mYCenter) * mCircleRadiusMultiplier));
      if (!mIs24HourMode)
      {
        int i = (int)(mCircleRadius * mAmPmCircleRadiusMultiplier);
        mYCenter -= i / 2;
      }
      mDrawValuesReady = true;
    }
    mPaint.setColor(mCircleColor);
    paramCanvas.drawCircle(mXCenter, mYCenter, mCircleRadius, mPaint);
    mPaint.setColor(mDotColor);
    paramCanvas.drawCircle(mXCenter, mYCenter, 2.0F, mPaint);
  }
}