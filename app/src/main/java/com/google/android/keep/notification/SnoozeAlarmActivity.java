package com.google.android.keep.notification;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.location.places.Place;
import com.google.android.keep.L;
import com.google.android.keep.b;
import com.google.android.keep.location.e;
import com.google.android.keep.location.g;
import com.google.android.keep.model.z;
import com.google.android.keep.ui.a;
import com.google.android.keep.ui.a.a;
import com.google.android.keep.util.KeepTime;
import com.google.android.keep.util.j;
import com.google.android.keep.util.r;
import java.util.List;

public class SnoozeAlarmActivity extends b
  implements a.a
{
  private static final String Bs = a.class.getSimpleName();
  private static final int[] fA = { 1, 2, 3, 4 };
  private int Bt;
  private BroadcastReceiver Bu = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if ("com.google.android.keep.intent.action.NOTIFICATION_RESCHEDULED".equals(paramAnonymousIntent.getAction()))
      {
        paramAnonymousContext = paramAnonymousIntent.getStringExtra("com.google.android.keep.intent.extra.reminder_id");
        if (TextUtils.equals(SnoozeAlarmActivity.a(SnoozeAlarmActivity.this), paramAnonymousContext))
          finish();
      }
    }
  };
  private String mAccountName;
  private String op;
  private long uy;

  private void f(final com.google.android.keep.model.Location paramLocation)
  {
    if (paramLocation == null)
      return;
    new AsyncTask()
    {
      protected Void doInBackground(Void[] paramAnonymousArrayOfVoid)
      {
        paramAnonymousArrayOfVoid = j.j(SnoozeAlarmActivity.this, SnoozeAlarmActivity.b(SnoozeAlarmActivity.this)).build();
        if (!j.f(paramAnonymousArrayOfVoid))
          return null;
        try
        {
          com.google.android.gms.reminders.model.Location localLocation = z.a(SnoozeAlarmActivity.this, paramLocation);
          L.a(paramAnonymousArrayOfVoid, SnoozeAlarmActivity.a(SnoozeAlarmActivity.this), localLocation);
          return null;
        }
        finally
        {
          j.e(paramAnonymousArrayOfVoid);
        }
      }
    }
    .execute(new Void[0]);
  }

  private void kt()
  {
    NotificationManager localNotificationManager = (NotificationManager)getSystemService("notification");
    if (Bt != -1)
      localNotificationManager.cancel(Bt);
  }

  protected String S()
  {
    return getString(2131230850);
  }

  public void a(Place paramPlace)
  {
    f(new com.google.android.keep.model.Location(paramPlace));
    kt();
    finish();
  }

  public void b(final g paramg)
  {
    new e(this)
    {
      protected void c(List<com.google.android.keep.model.Location> paramAnonymousList)
      {
        if ((paramAnonymousList == null) || (paramAnonymousList.size() <= 0))
        {
          r.e("Keep", "Unexpected results from PlaceDetailsTask for " + paramg, new Object[0]);
          return;
        }
        SnoozeAlarmActivity.a(SnoozeAlarmActivity.this, (com.google.android.keep.model.Location)paramAnonymousList.get(0));
      }
    }
    .execute(new g[] { paramg });
    kt();
    finish();
  }

  public void c(KeepTime paramKeepTime)
  {
    SnoozeAlarmService.a(this, mAccountName, op, paramKeepTime.op());
    kt();
    finish();
  }

  public void ku()
  {
    finish();
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    mAccountName = paramBundle.getStringExtra("authAccount");
    op = paramBundle.getStringExtra("com.google.android.keep.intent.extra.reminder_id");
    uy = paramBundle.getLongExtra("treeEntityId", -1L);
    if ((mAccountName == null) || (op == null) || (uy == -1L))
    {
      finish();
      return;
    }
    Bt = paramBundle.getIntExtra("com.google.android.keep.intent.extra.notification_id", -1);
    sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
    paramBundle = getSupportFragmentManager();
    if (paramBundle.findFragmentByTag(Bs) == null)
    {
      a locala = a.a(2131231270, fA);
      paramBundle.beginTransaction().replace(16908290, locala, Bs).commit();
      paramBundle.executePendingTransactions();
    }
    LocalBroadcastManager.getInstance(this).registerReceiver(Bu, new IntentFilter("com.google.android.keep.intent.action.NOTIFICATION_RESCHEDULED"));
  }

  public void onDestroy()
  {
    super.onDestroy();
    LocalBroadcastManager.getInstance(this).unregisterReceiver(Bu);
  }
}