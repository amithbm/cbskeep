package com.google.android.keep.activities;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.TaskStackBuilder;
import com.google.android.keep.model.j;
import com.google.android.keep.util.o;

public class ShareReceiverActivity extends Activity
{
  private void ax()
  {
    Intent localIntent = getIntent();
    localIntent.setClass(this, BrowseActivity.class);
    TaskStackBuilder.create(this).addNextIntent(localIntent).startActivities();
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1)
    {
      if ((paramInt2 == -1) && (paramIntent != null) && (paramIntent.getExtras() != null))
      {
        o.b(this, new Account(paramIntent.getExtras().getString("authAccount"), paramIntent.getExtras().getString("accountType")));
        ax();
      }
      finish();
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = AccountManager.get(this).getAccountsByType("com.google");
    if ((paramBundle == null) || (paramBundle.length <= 1))
    {
      ax();
      finish();
      return;
    }
    paramBundle = o.O(this);
    if (paramBundle == null);
    for (paramBundle = null; ; paramBundle = paramBundle.hl())
    {
      startActivityForResult(o.c(paramBundle), 1);
      return;
    }
  }
}