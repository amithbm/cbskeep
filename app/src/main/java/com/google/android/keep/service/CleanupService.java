package com.google.android.keep.service;

import android.app.IntentService;
import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.reminders.LoadRemindersOptions.Builder;
import com.google.android.gms.reminders.Reminders;
import com.google.android.gms.reminders.RemindersApi;
import com.google.android.gms.reminders.RemindersApi.LoadRemindersResult;
import com.google.android.gms.reminders.UpdateRecurrenceOptions;
import com.google.android.gms.reminders.model.RecurrenceInfo;
import com.google.android.gms.reminders.model.RemindersBuffer;
import com.google.android.gms.reminders.model.Task;
import com.google.android.gms.reminders.model.TaskId;
import com.google.android.keep.J;
import com.google.android.keep.L;
import com.google.android.keep.P;
import com.google.android.keep.task.TaskHelper;
import com.google.android.keep.util.o;
import com.google.android.keep.util.r;
import com.google.android.keep.util.w;
import com.google.android.keep.util.w.a;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CleanupService extends IntentService
{
  public CleanupService()
  {
    super(CleanupService.class.getSimpleName());
  }

  private void a(GoogleApiClient paramGoogleApiClient, RemindersBuffer paramRemindersBuffer)
  {
    P localP = new P();
    while (true)
    {
      Task localTask;
      try
      {
        Iterator localIterator = paramRemindersBuffer.iterator();
        if (!localIterator.hasNext())
          break;
        localTask = (Task)localIterator.next();
        localObject = w.l(localTask);
        if (localObject == null)
        {
          r.a("Keep", "Skipped invalid reminder id " + w.k(localTask), new Object[0]);
          continue;
        }
      }
      finally
      {
        paramRemindersBuffer.release();
      }
      Object localObject = localP.a((w.a)localObject, (Task)localTask.freeze());
      if (localObject != null)
      {
        r.a("Keep", "Delete duplicate reminders:" + ((Task)localObject).getTaskId().getClientAssignedId(), new Object[0]);
        J.a(paramGoogleApiClient, localTask);
      }
    }
    paramRemindersBuffer.release();
  }

  private void b(GoogleApiClient paramGoogleApiClient)
  {
    RemindersApi.LoadRemindersResult localLoadRemindersResult = (RemindersApi.LoadRemindersResult)com.google.android.keep.util.j.b(Reminders.RemindersApi.loadReminders(paramGoogleApiClient, L.jF()));
    if (!localLoadRemindersResult.getStatus().isSuccess())
      return;
    a(paramGoogleApiClient, localLoadRemindersResult.getRemindersBuffer());
  }

  private void c(GoogleApiClient paramGoogleApiClient)
  {
    Object localObject3 = (RemindersApi.LoadRemindersResult)com.google.android.keep.util.j.b(Reminders.RemindersApi.loadReminders(paramGoogleApiClient, new LoadRemindersOptions.Builder().addTaskListId(4).setIncludeArchived(true).setCollapseMode(2).build()));
    if (!((RemindersApi.LoadRemindersResult)localObject3).getStatus().isSuccess());
    while (true)
    {
      return;
      Object localObject1 = new HashSet();
      Object localObject2 = ((RemindersApi.LoadRemindersResult)localObject3).getRemindersBuffer().iterator();
      Object localObject4;
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (Task)((Iterator)localObject2).next();
        if ((((Task)localObject4).getRecurrenceInfo() != null) && (Boolean.TRUE.equals(((Task)localObject4).getRecurrenceInfo().getMaster())))
          ((Set)localObject1).add(((Task)localObject4).getRecurrenceInfo().getRecurrenceId());
      }
      localObject2 = new HashSet();
      localObject3 = ((RemindersApi.LoadRemindersResult)localObject3).getRemindersBuffer().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (Task)((Iterator)localObject3).next();
        if (((Task)localObject4).getRecurrenceInfo() != null)
        {
          localObject4 = ((Task)localObject4).getRecurrenceInfo();
          if ((!Boolean.TRUE.equals(((RecurrenceInfo)localObject4).getMaster())) && (!((Set)localObject1).contains(((RecurrenceInfo)localObject4).getRecurrenceId())))
            ((Set)localObject2).add(((RecurrenceInfo)localObject4).getRecurrenceId());
        }
      }
      localObject1 = ((Set)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        com.google.android.keep.util.j.b(Reminders.RemindersApi.deleteRecurrence(paramGoogleApiClient, (String)localObject2, UpdateRecurrenceOptions.ALL_INSTANCES_OPTION));
      }
    }
  }

  protected void onHandleIntent(Intent paramIntent)
  {
    paramIntent = o.R(this).iterator();
    while (true)
    {
      Object localObject;
      if (paramIntent.hasNext())
      {
        localObject = (com.google.android.keep.model.j)paramIntent.next();
        TaskHelper.g(this, (com.google.android.keep.model.j)localObject);
        localObject = com.google.android.keep.util.j.j(this, ((com.google.android.keep.model.j)localObject).getName()).build();
        if (!com.google.android.keep.util.j.f((GoogleApiClient)localObject));
      }
      else
      {
        try
        {
          b((GoogleApiClient)localObject);
          c((GoogleApiClient)localObject);
          com.google.android.keep.util.j.e((GoogleApiClient)localObject);
        }
        finally
        {
          com.google.android.keep.util.j.e((GoogleApiClient)localObject);
        }
      }
    }
  }
}