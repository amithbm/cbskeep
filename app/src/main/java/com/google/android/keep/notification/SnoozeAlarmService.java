package com.google.android.keep.notification;

import android.app.IntentService;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.reminders.Reminders;
import com.google.android.gms.reminders.RemindersApi;
import com.google.android.gms.reminders.RemindersStatusCodes;
import com.google.android.gms.reminders.model.DateTime.Builder;
import com.google.android.gms.reminders.model.Task;
import com.google.android.gms.reminders.model.Task.Builder;
import com.google.android.keep.L;
import com.google.android.keep.N;
import com.google.android.keep.util.KeepTime;
import com.google.android.keep.util.j;
import com.google.android.keep.util.r;
import com.google.android.keep.util.w;
import com.google.android.keep.util.w.a;
import com.google.android.keep.util.x;
import java.util.concurrent.TimeUnit;

public class SnoozeAlarmService extends IntentService
{
  private static final String Bl = SnoozeAlarmService.class.getSimpleName();

  public SnoozeAlarmService()
  {
    super(Bl);
  }

  private static void a(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = d(paramContext, paramString1);
    if (paramContext == null)
      return;
    try
    {
      paramString1 = L.c(paramContext, paramString2);
      if (paramString1 != null)
      {
        localObject = paramString1.getLocation();
        if (localObject != null);
      }
      else
      {
        return;
      }
      Object localObject = aA(paramString2);
      boolean bool = TextUtils.isEmpty((CharSequence)localObject);
      if (bool)
        return;
      b(paramContext, paramString2, N.i(paramString1).setTaskId(w.bG((String)localObject)).build());
      return;
    }
    finally
    {
      j.e(paramContext);
    }
    throw paramString1;
  }

  public static void a(Context paramContext, final String paramString1, final String paramString2, final long paramLong)
  {
    new AsyncTask()
    {
      protected Void doInBackground(Void[] paramAnonymousArrayOfVoid)
      {
        SnoozeAlarmService.c(rh, paramString1, paramString2, paramLong);
        return null;
      }
    }
    .execute(new Void[0]);
  }

  private static String aA(String paramString)
  {
    paramString = w.bF(paramString);
    if (paramString == null)
      return null;
    if (!TextUtils.isEmpty(iF))
      return w.bD(iF);
    return w.bE(uK);
  }

  private static void b(Context paramContext, String paramString1, String paramString2, long paramLong)
  {
    paramContext = d(paramContext, paramString1);
    if (paramContext == null)
      return;
    try
    {
      paramString1 = L.c(paramContext, paramString2);
      if (paramString1 == null)
        return;
      String str = aA(paramString2);
      boolean bool = TextUtils.isEmpty(str);
      if (bool)
        return;
      b(paramContext, paramString2, N.a(paramString1, x.b(new KeepTime(paramLong)).build()).setTaskId(w.bG(str)).build());
      return;
    }
    finally
    {
      j.e(paramContext);
    }
    throw paramString1;
  }

  private static void b(GoogleApiClient paramGoogleApiClient, String paramString, Task paramTask)
  {
    Status localStatus = (Status)j.b(Reminders.RemindersApi.deleteReminder(paramGoogleApiClient, w.bG(paramString)));
    if (!localStatus.isSuccess())
      r.d(Bl, "Unable to delete reminder id " + paramString + " because of " + RemindersStatusCodes.getStatusCodeString(localStatus.getStatusCode()), new Object[0]);
    paramGoogleApiClient = (Status)j.b(Reminders.RemindersApi.createReminder(paramGoogleApiClient, paramTask));
    if (!paramGoogleApiClient.isSuccess())
      r.d(Bl, "Unable to create reminder id " + w.k(paramTask) + " because of " + RemindersStatusCodes.getStatusCodeString(paramGoogleApiClient.getStatusCode()), new Object[0]);
  }

  private static GoogleApiClient d(Context paramContext, String paramString)
  {
    paramString = j.j(paramContext, paramString).build();
    paramContext = paramString;
    if (!paramString.blockingConnect(5L, TimeUnit.SECONDS).isSuccess())
      paramContext = null;
    return paramContext;
  }

  protected void onHandleIntent(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("com.google.android.keep.intent.extra.notification_id", -1);
    Object localObject = (NotificationManager)getSystemService("notification");
    if (i != -1)
      ((NotificationManager)localObject).cancel(i);
    String str = paramIntent.getStringExtra("authAccount");
    if (str == null);
    do
    {
      return;
      localObject = paramIntent.getStringExtra("com.google.android.keep.intent.extra.reminder_id");
    }
    while (localObject == null);
    i = paramIntent.getIntExtra("action_mode", -1);
    if (i == 0)
      b(this, str, (String)localObject, System.currentTimeMillis() + 3600000L);
    while (true)
    {
      paramIntent = new Intent("com.google.android.keep.intent.action.NOTIFICATION_RESCHEDULED");
      paramIntent.putExtra("com.google.android.keep.intent.extra.reminder_id", (String)localObject);
      LocalBroadcastManager.getInstance(this).sendBroadcast(paramIntent);
      return;
      if (i != 1)
        break;
      a(this, str, (String)localObject);
    }
    throw new IllegalStateException("INVALID ACTION " + i);
  }
}