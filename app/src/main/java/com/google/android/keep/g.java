package com.google.android.keep;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import com.google.android.keep.browse.d;

public class g
{
  private final int dN;
  private final int dO;
  private final int dP;

  public g(View paramView, Activity paramActivity, int paramInt, long paramLong)
  {
    if (paramView == null)
    {
      dN = -1;
      dO = -1;
      dP = -1;
      return;
    }
    paramActivity = a(paramView, paramActivity);
    d.a(paramView, paramLong);
    dN = paramActivity.x;
    dO = paramActivity.y;
    dP = paramInt;
  }

  private static Point a(View paramView, Activity paramActivity)
  {
    Rect localRect1 = new Rect();
    Rect localRect2 = new Rect();
    Point localPoint = new Point();
    paramActivity.findViewById(2131493039).getGlobalVisibleRect(localRect1, localPoint);
    paramView.getGlobalVisibleRect(localRect2);
    return new Point(localRect2.left - localPoint.x, localRect2.top - localPoint.y);
  }

  public void d(Intent paramIntent)
  {
    paramIntent.putExtra("startX", dN);
    paramIntent.putExtra("startY", dO);
    paramIntent.putExtra("animDirection", dP);
  }
}