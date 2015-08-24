package com.google.android.keep.syncadapter;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.keep.util.A;
import com.google.android.keep.util.Config;

public class RefreshSyncReceiver extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramIntent = Config.nW();
    if (paramIntent.equals(A.V(paramContext)))
      return;
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("refresh_sync", true);
    Account[] arrayOfAccount = AccountManager.get(paramContext).getAccountsByType("com.google");
    if (arrayOfAccount != null)
    {
      int j = arrayOfAccount.length;
      int i = 0;
      while (i < j)
      {
        ContentResolver.requestSync(arrayOfAccount[i], "com.google.android.keep", localBundle);
        i += 1;
      }
    }
    A.p(paramContext, paramIntent);
  }
}