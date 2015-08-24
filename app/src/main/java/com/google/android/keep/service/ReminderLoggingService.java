package com.google.android.keep.service;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Intent;
import com.google.android.gms.reminders.LoadRemindersOptions;
import com.google.android.gms.reminders.LoadRemindersOptions.Builder;
import com.google.android.gms.reminders.model.Task;
import com.google.android.keep.I;
import com.google.android.keep.c;
import com.google.android.keep.d;
import com.google.android.keep.model.j;
import com.google.android.keep.util.o;
import com.google.android.keep.util.r;
import com.google.android.keep.util.w;
import com.google.android.keep.util.x;
import java.util.List;
import java.util.Map;

public class ReminderLoggingService extends IntentService
{
  private static final String TAG = ReminderLoggingService.class.getSimpleName();

  public ReminderLoggingService()
  {
    super(TAG);
  }

  private LoadRemindersOptions aa(long paramLong)
  {
    return new LoadRemindersOptions.Builder().setLoadReminderType(new int[] { 1 }).setCollapseMode(0).setDueDateBefore(Long.valueOf(System.currentTimeMillis())).setDueDateAfter(Long.valueOf(paramLong)).build();
  }

  private void kH()
  {
    Object localObject = new Intent(this, ReminderLoggingService.class);
    ((Intent)localObject).setAction("com.google.android.keep.intent.action.LOG_REMINDERS");
    localObject = PendingIntent.getService(this, 0, (Intent)localObject, 134217728);
    AlarmManager localAlarmManager = (AlarmManager)getSystemService("alarm");
    localAlarmManager.cancel((PendingIntent)localObject);
    localAlarmManager.setInexactRepeating(0, System.currentTimeMillis(), 86400000L, (PendingIntent)localObject);
  }

  protected void onHandleIntent(Intent paramIntent)
  {
    if (paramIntent == null);
    do
    {
      return;
      paramIntent = paramIntent.getAction();
      if ("com.google.android.keep.intent.action.SCHEDULE_REMINDER_LOGGING".equals(paramIntent))
      {
        kH();
        return;
      }
    }
    while (!"com.google.android.keep.intent.action.LOG_REMINDERS".equals(paramIntent));
    long l1 = com.google.android.keep.util.A.aq(this);
    if (l1 <= 0L)
    {
      com.google.android.keep.util.A.n(this, System.currentTimeMillis());
      return;
    }
    paramIntent = aa(l1);
    Map localMap = I.t(this);
    com.google.android.keep.model.A localA = new com.google.android.keep.model.A();
    List localList1 = o.R(this);
    l1 = 0L;
    long l2 = 0L;
    int i = 0;
    while (i < localList1.size())
    {
      localA.a(this, (j)localList1.get(i), paramIntent);
      List localList2 = localA.jb();
      int j = 0;
      if (j < localList2.size())
      {
        Task localTask = (Task)localList2.get(j);
        Long localLong = (Long)localMap.get(w.k(localTask));
        long l3;
        long l4;
        if (localLong != null)
        {
          l3 = l2;
          l4 = l1;
          if (!x.a(localTask, localLong.longValue()))
          {
            l4 = l1 + 1L;
            l3 = l2;
          }
        }
        while (true)
        {
          j += 1;
          l2 = l3;
          l1 = l4;
          break;
          l3 = l2 + 1L;
          l4 = l1;
        }
      }
      i += 1;
    }
    if (l1 > 0L)
    {
      r.e(TAG, "Reminders fired at wrong time: " + l1, new Object[0]);
      d.e(this).a(2131230867, 2131231004, 2131231029, Long.valueOf(l1));
    }
    if (l2 > 0L)
    {
      r.e(TAG, "Reminders didn't fire: " + l2, new Object[0]);
      d.e(this).a(2131230867, 2131231003, 2131231029, Long.valueOf(l2));
    }
    com.google.android.keep.util.A.n(this, System.currentTimeMillis());
  }
}