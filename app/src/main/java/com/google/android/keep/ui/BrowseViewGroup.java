package com.google.android.keep.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;

public class BrowseViewGroup extends FrameLayout
{
  private float IC;
  private final double ID;

  public BrowseViewGroup(Context paramContext)
  {
    this(paramContext, null);
  }

  public BrowseViewGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public BrowseViewGroup(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    ID = ViewConfiguration.get(paramContext).getScaledTouchSlop();
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    int i = paramMotionEvent.getAction();
    if (i == 0)
      IC = paramMotionEvent.getX();
    boolean bool1 = bool2;
    if (i == 2)
    {
      bool1 = bool2;
      if (Math.abs(paramMotionEvent.getX() - IC) > ID)
        bool1 = true;
    }
    return bool1;
  }
}