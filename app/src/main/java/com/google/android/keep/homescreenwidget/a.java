package com.google.android.keep.homescreenwidget;

import android.accounts.AccountManager;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.keep.model.j;
import com.google.android.keep.util.A;
import com.google.android.keep.util.o;

public abstract class a extends AppWidgetProvider
{
  protected abstract void a(Context paramContext, AppWidgetManager paramAppWidgetManager, int paramInt);

  protected boolean a(Context paramContext, j paramj)
  {
    return (paramj == null) || (!o.o(paramContext, paramj.getName()));
  }

  protected boolean l(Context paramContext)
  {
    paramContext = AccountManager.get(paramContext).getAccountsByType("com.google");
    return (paramContext != null) && (paramContext.length > 1);
  }

  public void onAppWidgetOptionsChanged(Context paramContext, AppWidgetManager paramAppWidgetManager, int paramInt, Bundle paramBundle)
  {
    a(paramContext, paramAppWidgetManager, paramInt);
  }

  public void onDeleted(Context paramContext, int[] paramArrayOfInt)
  {
    super.onDeleted(paramContext, paramArrayOfInt);
    A.b(paramContext, paramArrayOfInt);
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    AppWidgetManager localAppWidgetManager = AppWidgetManager.getInstance(paramContext);
    int j;
    int i;
    if (("com.google.android.keep.intent.action.PROVIDER_CHANGED".equals(str)) || ("com.google.android.keep.intent.action.WIDGET_CONFIGURED".equals(str)))
    {
      paramIntent = localAppWidgetManager.getAppWidgetIds(paramIntent.getComponent());
      j = paramIntent.length;
      i = 0;
    }
    while (i < j)
    {
      a(paramContext, localAppWidgetManager, paramIntent[i]);
      i += 1;
      continue;
      super.onReceive(paramContext, paramIntent);
    }
  }

  public void onUpdate(Context paramContext, AppWidgetManager paramAppWidgetManager, int[] paramArrayOfInt)
  {
    super.onUpdate(paramContext, paramAppWidgetManager, paramArrayOfInt);
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      a(paramContext, paramAppWidgetManager, paramArrayOfInt[i]);
      i += 1;
    }
  }
}