package com.google.android.keep.notification;

import android.content.Context;
import android.content.Intent;
import android.text.format.DateUtils;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.reminders.LoadRemindersOptions.Builder;
import com.google.android.gms.reminders.Reminders;
import com.google.android.gms.reminders.RemindersApi;
import com.google.android.gms.reminders.RemindersApi.LoadRemindersResult;
import com.google.android.gms.reminders.UpdateRecurrenceOptions;
import com.google.android.gms.reminders.model.RecurrenceInfo;
import com.google.android.gms.reminders.model.ReminderEvent;
import com.google.android.gms.reminders.model.ReminderEventBuffer;
import com.google.android.gms.reminders.model.RemindersBuffer;
import com.google.android.gms.reminders.model.SnoozePresetChangedEventBuffer;
import com.google.android.gms.reminders.model.Task;
import com.google.android.gms.reminders.model.TaskId;
import com.google.android.keep.I;
import com.google.android.keep.c;
import com.google.android.keep.model.Alert;
import com.google.android.keep.util.F;
import com.google.android.keep.util.o;
import com.google.android.keep.util.r;
import com.google.android.keep.util.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class RemindersListenerService extends com.google.android.gms.reminders.RemindersListenerService
{
  private a Bm;
  private d Bn;

  private String K(long paramLong)
  {
    return DateUtils.formatDateTime(this, paramLong, 17);
  }

  private void e(String paramString1, String paramString2)
  {
    paramString1 = com.google.android.keep.util.j.j(this, paramString1).build();
    if (!com.google.android.keep.util.j.f(paramString1))
      return;
    try
    {
      RemindersApi.LoadRemindersResult localLoadRemindersResult = (RemindersApi.LoadRemindersResult)com.google.android.keep.util.j.b(Reminders.RemindersApi.loadReminders(paramString1, new LoadRemindersOptions.Builder().addTaskListId(4).setIncludeArchived(true).setRecurrenceIds(Collections.singletonList(paramString2)).setCollapseMode(0).build()));
      boolean bool = localLoadRemindersResult.getStatus().isSuccess();
      if (!bool)
        return;
      if (localLoadRemindersResult.getRemindersBuffer().getCount() > 0)
        com.google.android.keep.util.j.b(Reminders.RemindersApi.deleteRecurrence(paramString1, paramString2, UpdateRecurrenceOptions.ALL_INSTANCES_OPTION));
      return;
    }
    finally
    {
      com.google.android.keep.util.j.e(paramString1);
    }
    throw paramString2;
  }

  private void j(Task paramTask)
  {
    if (!Log.isLoggable("RemindersListener", 6));
    long l;
    do
    {
      return;
      l = System.currentTimeMillis();
    }
    while (x.a(paramTask, l));
    String str = K(l);
    paramTask = K(x.a(paramTask.getDueDate()));
    Log.e("RemindersListener", "Reminder scheduled " + paramTask + " but fired " + str);
    paramTask = Integer.toString(GooglePlayServicesUtil.getApkVersion(this));
    com.google.android.keep.d.e(this).a(getString(2131230867), getString(2131231005), paramTask, null);
  }

  public void onCreate()
  {
    super.onCreate();
    Bn = new g(this);
    Bm = new f(this);
  }

  protected void onReminderFired(ReminderEvent paramReminderEvent)
  {
    r.a("RemindersListener", "onReminderFired", new Object[0]);
    Task localTask = paramReminderEvent.getTask();
    if ((localTask.getRecurrenceInfo() != null) && (localTask.getRecurrenceInfo().getMaster().booleanValue()))
      r.e("RemindersListener", "Skip reminder master.", new Object[0]);
    do
    {
      return;
      if (localTask.getLocation() != null)
      {
        r.a("RemindersListener", "Skip reminder triggering event from GmsCore", new Object[0]);
        return;
      }
      paramReminderEvent = o.n(this, paramReminderEvent.getAccountName());
    }
    while (paramReminderEvent == null);
    Bn.b(paramReminderEvent.longValue(), localTask);
    j(localTask);
  }

  protected void onRemindersChanged(ReminderEventBuffer paramReminderEventBuffer)
  {
    r.a("RemindersListener", "onRemindersChanged", new Object[0]);
    Context localContext1 = getApplicationContext();
    Object localObject2;
    Object localObject3;
    Object localObject4;
    try
    {
      int i = paramReminderEventBuffer.getCount();
      if (i <= 0)
        return;
      localContext1.sendBroadcast(new Intent("com.google.android.keep.intent.action.PROVIDER_CHANGED"));
      localObject1 = new ArrayList();
      localObject2 = paramReminderEventBuffer.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (ReminderEvent)((Iterator)localObject2).next();
        localObject4 = ((ReminderEvent)localObject3).getTask();
        if ((((ReminderEvent)localObject3).getType() == 2) || (Boolean.TRUE.equals(((Task)localObject4).getArchived())))
          ((List)localObject1).add(((Task)localObject4).freeze());
        if ((((ReminderEvent)localObject3).getType() == 1) && (((Task)localObject4).getDueDate() != null) && (Boolean.TRUE.equals(((Task)localObject4).getSnoozed())))
          ((List)localObject1).add(((Task)localObject4).freeze());
      }
    }
    finally
    {
      paramReminderEventBuffer.release();
    }
    Bn.p((List)localObject1);
    Object localObject1 = paramReminderEventBuffer.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject4 = (ReminderEvent)((Iterator)localObject1).next();
      localObject2 = ((ReminderEvent)localObject4).getTask();
      localObject3 = ((ReminderEvent)localObject4).getAccountName();
      if ((((ReminderEvent)localObject4).getType() == 2) && (((Task)localObject2).getRecurrenceInfo() != null) && (Boolean.TRUE.equals(((Task)localObject2).getRecurrenceInfo().getMaster())))
        e((String)localObject3, ((Task)localObject2).getRecurrenceInfo().getRecurrenceId());
      Alert localAlert = I.a(localContext2, ((Task)localObject2).getTaskId().getClientAssignedId());
      if ((((ReminderEvent)localObject4).getType() == 2) || (((Task)localObject2).getLocation() == null) || (Boolean.TRUE.equals(((Task)localObject2).getArchived())))
      {
        if (localAlert.getId() != -1L)
        {
          Bm.az(String.valueOf(localAlert.getId()));
          if (((ReminderEvent)localObject4).getType() == 2)
            I.a(this, localAlert);
        }
      }
      else
      {
        long l = I.e((Task)localObject2);
        if ((localAlert.getState() == 1) && (l == localAlert.gt()))
        {
          r.a("RemindersListener", "Skip reminder whose trigger condition is not changed.", new Object[0]);
        }
        else
        {
          localObject4 = o.n(localContext2, (String)localObject3);
          if ((localObject4 != null) && (F.b(localContext2, ((Long)localObject4).longValue(), (Task)localObject2) != null))
            b.a(this, new com.google.android.keep.model.j(((Long)localObject4).longValue(), (String)localObject3), Bm, Bn, (Task)localObject2);
        }
      }
    }
    paramReminderEventBuffer.release();
  }

  public void onSnoozePresetChanged(SnoozePresetChangedEventBuffer paramSnoozePresetChangedEventBuffer)
  {
  }
}