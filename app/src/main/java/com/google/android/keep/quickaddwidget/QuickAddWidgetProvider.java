package com.google.android.keep.quickaddwidget;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import com.google.android.keep.homescreenwidget.MemoryAppWidgetProvider;

public class QuickAddWidgetProvider extends MemoryAppWidgetProvider
{
  protected boolean b(AppWidgetManager paramAppWidgetManager, int paramInt)
  {
    return true;
  }

  protected boolean b(Context paramContext, AppWidgetManager paramAppWidgetManager, int paramInt)
  {
    return false;
  }
}