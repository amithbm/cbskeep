package com.google.android.keep.homescreenwidget;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.TaskStackBuilder;
import com.google.android.keep.activities.BrowseActivity;

public class WidgetIntentResolverActivity extends FragmentActivity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    String str1 = paramBundle.getAction();
    String str2 = paramBundle.getStringExtra("authAccount");
    Intent localIntent = new Intent(this, BrowseActivity.class);
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.putExtra("authAccount", str2);
    if (("com.google.android.keep.intent.action.WIDGET_VIEW_NOTE".equals(str1)) || ("com.google.android.keep.intent.action.WIDGET_VIEW_LIST".equals(str1)))
    {
      long l = paramBundle.getLongExtra("treeEntityId", -1L);
      if (l != -1L)
      {
        localIntent.putExtra("com.google.android.keep.intent.extra.HAS_CONFLICT", paramBundle.getBooleanExtra("com.google.android.keep.intent.extra.HAS_CONFLICT", false));
        localIntent.putExtra("treeEntityId", l);
      }
    }
    TaskStackBuilder.create(this).addNextIntent(localIntent).startActivities();
    finish();
  }
}