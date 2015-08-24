package com.google.android.keep.homescreenwidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.google.android.keep.activities.KeepApplication;
import com.google.android.keep.model.j;
import com.google.android.keep.provider.i.k;
import com.google.android.keep.util.A;
import com.google.android.keep.util.G;
import com.google.android.keep.util.h;
import com.google.android.keep.util.h.a;
import com.google.android.keep.util.o;
import com.google.android.keep.util.r;

public class MemoryAppWidgetProvider extends a
{
  private void a(final Context paramContext, final AppWidgetManager paramAppWidgetManager, final int paramInt, final String paramString, final RemoteViews paramRemoteViews)
  {
    new AsyncTask()
    {
      protected Void doInBackground(Void[] paramAnonymousArrayOfVoid)
      {
        paramAnonymousArrayOfVoid = null;
        int i = A.g(paramContext, paramInt);
        if (i == 2)
        {
          paramRemoteViews.setOnClickPendingIntent(2131493398, G.x(paramContext, paramString));
          paramAnonymousArrayOfVoid = paramContext.getResources().getString(2131231130);
        }
        while (true)
        {
          if (!TextUtils.isEmpty(paramAnonymousArrayOfVoid))
          {
            paramRemoteViews.setTextViewText(2131493398, paramAnonymousArrayOfVoid);
            paramAppWidgetManager.partiallyUpdateAppWidget(paramInt, paramRemoteViews);
          }
          return null;
          if (i == 3)
          {
            paramAnonymousArrayOfVoid = A.h(paramContext, paramInt);
            paramRemoteViews.setOnClickPendingIntent(2131493398, G.c(paramContext, paramString, paramAnonymousArrayOfVoid));
            ContentResolver localContentResolver = paramContext.getContentResolver();
            Uri localUri = i.k.CONTENT_URI;
            h.a local1 = new h.a()
            {
              public String a(Cursor paramAnonymous2Cursor, int paramAnonymous2Int)
              {
                return paramAnonymous2Cursor.getString(0);
              }
            };
            paramAnonymousArrayOfVoid = (String)h.a(localContentResolver, localUri, new String[] { "name" }, "uuid=?", new String[] { paramAnonymousArrayOfVoid }, local1);
          }
        }
      }
    }
    .execute(new Void[0]);
  }

  protected void a(Context paramContext, AppWidgetManager paramAppWidgetManager, int paramInt)
  {
    r.a("KeepWidget", "updateAppWidget appWidgetId=" + paramInt, new Object[0]);
    if (paramInt == 0)
      return;
    RemoteViews localRemoteViews = new RemoteViews(paramContext.getPackageName(), 2130968786);
    Object localObject2 = A.f(paramContext, paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = o.O(paramContext);
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        A.a(paramContext, paramInt, (j)localObject2);
        localObject1 = localObject2;
      }
    }
    if (a(paramContext, localObject1))
    {
      if (localObject1 != null)
        A.b(paramContext, new int[] { paramInt });
      localRemoteViews.setViewVisibility(2131493397, 8);
      localRemoteViews.setViewVisibility(2131493401, 8);
      localRemoteViews.setViewVisibility(2131493150, 8);
      localRemoteViews.setViewVisibility(2131493411, 8);
      localRemoteViews.setViewVisibility(2131493408, 0);
      localRemoteViews.setOnClickPendingIntent(2131493408, G.i(paramContext, paramInt));
      paramAppWidgetManager.updateAppWidget(paramInt, localRemoteViews);
      return;
    }
    boolean bool1 = b(paramContext, paramAppWidgetManager, paramInt);
    boolean bool2 = b(paramAppWidgetManager, paramInt);
    boolean bool3 = KeepApplication.a(paramAppWidgetManager, paramInt);
    boolean bool4 = l(paramContext);
    localRemoteViews.setViewVisibility(2131493408, 8);
    localRemoteViews.setEmptyView(2131493150, 2131493411);
    localRemoteViews.setOnClickPendingIntent(2131493411, G.a(paramContext, localObject1, bool3, "com.google.android.keep.intent.action.QUICK_EDIT", 0L));
    if (bool1)
    {
      localRemoteViews.setViewVisibility(2131493397, 0);
      localRemoteViews.setViewVisibility(2131493401, 8);
      localRemoteViews.setOnClickPendingIntent(2131493398, G.w(paramContext, localObject1.getName()));
      a(paramContext, paramAppWidgetManager, paramInt, localObject1.getName(), localRemoteViews);
      localObject2 = new Intent(paramContext, NoteTypePickerActivity.class);
      ((Intent)localObject2).setFlags(268468224);
      ((Intent)localObject2).putExtra("authAccount", localObject1.getName());
      ((Intent)localObject2).setData(Uri.parse(((Intent)localObject2).toUri(1)));
      localRemoteViews.setOnClickPendingIntent(2131493399, PendingIntent.getActivity(paramContext, 0, (Intent)localObject2, 134217728));
      if (bool4)
      {
        localRemoteViews.setViewVisibility(2131493400, 0);
        localRemoteViews.setTextViewText(2131493400, localObject1.getName());
        if (!bool2)
          break label561;
        localRemoteViews.setViewVisibility(2131493150, 8);
        localRemoteViews.setViewVisibility(2131493411, 8);
      }
    }
    while (true)
    {
      paramAppWidgetManager.updateAppWidget(paramInt, localRemoteViews);
      return;
      localRemoteViews.setViewVisibility(2131493400, 8);
      break;
      localRemoteViews.setViewVisibility(2131493397, 8);
      localRemoteViews.setViewVisibility(2131493401, 0);
      localRemoteViews.setOnClickPendingIntent(2131493402, G.a(paramContext, localObject1, bool3, "com.google.android.keep.intent.action.QUICK_EDIT", 0L));
      localRemoteViews.setOnClickPendingIntent(2131493299, G.a(paramContext, localObject1, bool3, "com.google.android.keep.intent.action.QUICK_LIST", 0L));
      localRemoteViews.setOnClickPendingIntent(2131493301, G.a(paramContext, localObject1, bool3, "com.google.android.keep.intent.action.QUICK_IMAGE", 0L));
      localRemoteViews.setOnClickPendingIntent(2131493300, G.a(paramContext, localObject1, bool3, "com.google.android.keep.intent.action.QUICK_VOICE", 0L));
      if (bool4)
      {
        localRemoteViews.setViewVisibility(2131493403, 0);
        localRemoteViews.setTextViewText(2131493403, localObject1.getName());
        break;
      }
      localRemoteViews.setViewVisibility(2131493403, 8);
      break;
      label561: localRemoteViews.setViewVisibility(2131493150, 0);
      localRemoteViews.setViewVisibility(2131493411, 0);
      localObject2 = new Intent(paramContext, MemoryWidgetService.class);
      ((Intent)localObject2).putExtra("appWidgetId", paramInt);
      ((Intent)localObject2).setData(Uri.parse(((Intent)localObject2).toUri(1)));
      ((Intent)localObject2).putExtra("com.google.android.keep.intent.extra.PARENT_TREE_ENTITY_ID", 0L);
      localRemoteViews.setRemoteAdapter(2131493150, (Intent)localObject2);
      Intent localIntent = new Intent(paramContext, WidgetIntentResolverActivity.class);
      localIntent.putExtra("appWidgetId", paramInt);
      localIntent.putExtra("authAccount", localObject1.getName());
      localIntent.setData(Uri.parse(((Intent)localObject2).toUri(1)));
      localRemoteViews.setPendingIntentTemplate(2131493150, PendingIntent.getActivity(paramContext, 0, localIntent, 134217728));
      paramAppWidgetManager.notifyAppWidgetViewDataChanged(paramInt, 2131493150);
    }
  }

  protected boolean b(AppWidgetManager paramAppWidgetManager, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (KeepApplication.ai())
    {
      paramInt = paramAppWidgetManager.getAppWidgetOptions(paramInt).getInt("appWidgetMaxHeight");
      bool1 = bool2;
      if (paramInt > 0)
      {
        bool1 = bool2;
        if (paramInt <= 100)
          bool1 = true;
      }
    }
    return bool1;
  }

  protected boolean b(Context paramContext, AppWidgetManager paramAppWidgetManager, int paramInt)
  {
    int i;
    if (A.g(paramContext, paramInt) == 1)
    {
      i = 1;
      if (KeepApplication.ai())
        break label33;
      if (i != 0)
        break label31;
    }
    label31: label33: 
    do
    {
      do
      {
        return true;
        i = 0;
        break;
        return false;
      }
      while (i == 0);
      paramInt = paramAppWidgetManager.getAppWidgetOptions(paramInt).getInt("appWidgetMaxWidth");
    }
    while ((paramInt > 0) && (paramInt < 192));
    return false;
  }
}