package com.google.android.keep.browse;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;

public class BrowseSwipeRefreshLayout extends SwipeRefreshLayout
{
  public BrowseSwipeRefreshLayout(Context paramContext)
  {
    super(paramContext, null);
  }

  public BrowseSwipeRefreshLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public boolean canChildScrollUp()
  {
    return true;
  }
}