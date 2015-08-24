package com.google.android.keep.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.TaskStackBuilder;
import android.util.Patterns;
import com.google.android.keep.util.e;
import com.google.android.keep.util.m;
import com.google.android.keep.util.r;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IntentResolverActivity extends FragmentActivity
{
  private void Y()
  {
    Object localObject1 = getIntent();
    if ((localObject1 == null) || (((Intent)localObject1).getData() == null));
    do
    {
      return;
      localObject2 = ((Intent)localObject1).getData().toString();
      r.a("Keep", "Received intent with the url " + (String)localObject2, new Object[0]);
    }
    while (!Patterns.WEB_URL.matcher((CharSequence)localObject2).matches());
    Object localObject2 = m.b(this, (Intent)localObject1);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      e.b(this, 2131231247);
      localObject1 = new Intent(this, BrowseActivity.class);
    }
    TaskStackBuilder.create(this).addNextIntent((Intent)localObject1).startActivities();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Y();
    finish();
  }
}