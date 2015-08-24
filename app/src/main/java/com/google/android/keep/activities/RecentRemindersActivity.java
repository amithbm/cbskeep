package com.google.android.keep.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.android.keep.navigation.NavigationManager.NavigationMode;

public class RecentRemindersActivity extends BrowseActivity
{
  public void a(NavigationManager.NavigationMode paramNavigationMode)
  {
    super.a(paramNavigationMode);
    Intent localIntent = new Intent(this, BrowseActivity.class);
    localIntent.setAction("com.google.android.keep.intent.action.NAVIGATION");
    localIntent.putExtra("com.google.android.keep.intent.extra.NAVIGATION_MODE", paramNavigationMode.ordinal());
    localIntent.setFlags(268468224);
    startActivity(localIntent);
    finish();
  }

  public void onDrawerClosed(View paramView)
  {
    super.onDrawerClosed(paramView);
  }

  protected void onPostCreate(Bundle paramBundle)
  {
    super.onPostCreate(paramBundle);
  }
}