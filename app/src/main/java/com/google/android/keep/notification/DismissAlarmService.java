package com.google.android.keep.notification;

import android.app.IntentService;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.TaskStackBuilder;
import android.text.TextUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.reminders.Reminders;
import com.google.android.gms.reminders.RemindersApi;
import com.google.android.gms.reminders.model.Task;
import com.google.android.gms.reminders.model.Task.Builder;
import com.google.android.keep.L;
import com.google.android.keep.N;
import com.google.android.keep.activities.BrowseActivity;
import com.google.android.keep.activities.RecentRemindersActivity;
import com.google.android.keep.provider.i.c;
import com.google.android.keep.util.e;
import com.google.android.keep.util.h;
import com.google.android.keep.util.h.a;
import com.google.android.keep.util.j;
import com.google.android.keep.util.r;
import com.google.android.keep.util.w;
import java.util.concurrent.TimeUnit;

public class DismissAlarmService extends IntentService
{
  private static final String Bl = DismissAlarmService.class.getSimpleName();
  private static int Bo = -1;

  public DismissAlarmService()
  {
    super(Bl);
  }

  private void a(final String paramString, long[] paramArrayOfLong)
  {
    paramString = j.j(this, paramString).build();
    if (!paramString.blockingConnect(5L, TimeUnit.SECONDS).isSuccess())
      return;
    paramArrayOfLong = "_id IN (" + e.a(",", paramArrayOfLong) + ")";
    Object localObject = new ContentValues();
    ((ContentValues)localObject).put("state", Integer.valueOf(3));
    getContentResolver().update(i.c.CONTENT_URI, (ContentValues)localObject, paramArrayOfLong, null);
    try
    {
      localObject = getContentResolver();
      Uri localUri = i.c.CONTENT_URI;
      h.a local1 = new h.a()
      {
        public Void d(Cursor paramAnonymousCursor, int paramAnonymousInt)
        {
          DismissAlarmService.a(DismissAlarmService.this, paramString, paramAnonymousCursor.getString(0));
          return null;
        }
      };
      h.a((ContentResolver)localObject, localUri, new String[] { "reminder_id" }, paramArrayOfLong, null, null, local1);
      return;
    }
    finally
    {
      paramString.disconnect();
    }
    throw paramArrayOfLong;
  }

  private void d(GoogleApiClient paramGoogleApiClient, String paramString)
  {
    paramString = L.c(paramGoogleApiClient, paramString);
    if (paramString == null);
    Task localTask;
    do
    {
      return;
      localTask = N.a(new Task.Builder(paramString), System.currentTimeMillis()).build();
    }
    while (((Status)Reminders.RemindersApi.updateReminder(paramGoogleApiClient, localTask).await(5L, TimeUnit.SECONDS)).isSuccess());
    r.d("Keep", "Couldn't dismiss reminder id " + w.k(paramString), new Object[0]);
  }

  protected void onHandleIntent(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("com.google.android.keep.intent.extra.notification_id", Bo);
    Object localObject = NotificationManagerCompat.from(this);
    if (i == Bo);
    long[] arrayOfLong;
    do
    {
      do
      {
        do
        {
          return;
          ((NotificationManagerCompat)localObject).cancel(i);
          localObject = paramIntent.getStringExtra("authAccount");
        }
        while (TextUtils.isEmpty((CharSequence)localObject));
        arrayOfLong = paramIntent.getLongArrayExtra("com.google.android.keep.intent.extra.alert_ids");
      }
      while ((arrayOfLong == null) || (arrayOfLong.length == 0));
      a((String)localObject, arrayOfLong);
      arrayOfLong = paramIntent.getLongArrayExtra("com.google.android.keep.intent.extra.recent_reminder_ids");
    }
    while ((!"com.google.android.keep.intent.action.CLICK_NOTIFICATION".equals(paramIntent.getAction())) || (arrayOfLong == null) || (arrayOfLong.length == 0));
    paramIntent = new Intent(this, BrowseActivity.class);
    paramIntent.putExtra("authAccount", (String)localObject);
    if (arrayOfLong.length == 1)
    {
      paramIntent.setAction("android.intent.action.VIEW");
      paramIntent.putExtra("authAccount", (String)localObject);
      paramIntent.putExtra("treeEntityId", arrayOfLong[0]);
      TaskStackBuilder.create(this).addNextIntent(paramIntent).startActivities();
      return;
    }
    Intent localIntent = new Intent(this, RecentRemindersActivity.class);
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.putExtra("com.google.android.keep.intent.extra.recent_reminder_ids", arrayOfLong);
    localIntent.putExtra("authAccount", (String)localObject);
    TaskStackBuilder.create(this).addNextIntent(paramIntent).addNextIntent(localIntent).startActivities();
  }
}