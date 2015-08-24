package com.google.android.keep.quickaddwidget;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import com.google.analytics.tracking.android.EasyTracker;
import com.google.analytics.tracking.android.MapBuilder;
import com.google.android.keep.activities.BrowseActivity;
import com.google.android.keep.util.Config;

public class QuickAddWidgetService extends IntentService
{
  public QuickAddWidgetService()
  {
    super(QuickAddWidgetService.class.getSimpleName());
  }

  private static void a(Context paramContext, int paramInt1, int paramInt2)
  {
    if (!Config.nJ())
      return;
    EasyTracker.getInstance(paramContext).send(MapBuilder.createEvent(paramContext.getString(paramInt1), paramContext.getString(2131230873), paramContext.getString(paramInt2), null).build());
  }

  public static void a(Context paramContext, Intent paramIntent)
  {
    String str1 = paramIntent.getAction();
    String str2 = paramIntent.getStringExtra("authAccount");
    boolean bool = paramIntent.getBooleanExtra("isKeyguard", false);
    int i;
    if (bool)
    {
      i = 2131231013;
      paramIntent = new Intent(paramContext, BrowseActivity.class);
      paramIntent.putExtra("authAccount", str2);
      paramIntent.setAction("android.intent.action.INSERT");
      paramIntent.putExtra("treeEntityType", 0);
      paramIntent.putExtra("isKeyguard", bool);
      if (!"com.google.android.keep.intent.action.QUICK_EDIT".equals(str1))
        break label108;
      a(paramContext, 2131230863, i);
    }
    while (true)
    {
      paramIntent.setFlags(268468224);
      paramContext.startActivity(paramIntent);
      return;
      i = 2131231012;
      break;
      label108: if ("com.google.android.keep.intent.action.QUICK_LIST".equals(str1))
      {
        a(paramContext, 2131230864, i);
        paramIntent.putExtra("treeEntityType", 1);
      }
      else if ("com.google.android.keep.intent.action.QUICK_IMAGE".equals(str1))
      {
        a(paramContext, 2131230866, i);
        paramIntent.putExtra("launchImmediately", 1);
      }
      else
      {
        if (!"com.google.android.keep.intent.action.QUICK_VOICE".equals(str1))
          break label192;
        a(paramContext, 2131230865, i);
        paramIntent.putExtra("launchImmediately", 2);
      }
    }
    label192: throw new IllegalStateException("Invalid quick edit action:" + str1);
  }

  protected void onHandleIntent(Intent paramIntent)
  {
    a(this, paramIntent);
  }
}