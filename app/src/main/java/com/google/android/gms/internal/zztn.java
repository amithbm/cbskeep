package com.google.android.gms.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzi;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzv;
import com.google.android.gms.common.util.zzr;
import com.google.android.gms.reminders.CreateReminderOptions;
import com.google.android.gms.reminders.CreateReminderOptionsInternal;
import com.google.android.gms.reminders.LoadRemindersOptions;
import com.google.android.gms.reminders.RemindersApi;
import com.google.android.gms.reminders.RemindersApi.LoadRemindersResult;
import com.google.android.gms.reminders.RemindersApi.RemindersChangeListener;
import com.google.android.gms.reminders.UpdateRecurrenceOptions;
import com.google.android.gms.reminders.model.DateTime;
import com.google.android.gms.reminders.model.Location;
import com.google.android.gms.reminders.model.Recurrence;
import com.google.android.gms.reminders.model.RecurrenceEnd;
import com.google.android.gms.reminders.model.RecurrenceInfo.Builder;
import com.google.android.gms.reminders.model.RecurrenceStart;
import com.google.android.gms.reminders.model.RemindersBuffer;
import com.google.android.gms.reminders.model.Task;
import com.google.android.gms.reminders.model.Task.Builder;
import com.google.android.gms.reminders.model.TaskId;
import com.google.android.gms.reminders.model.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class zztn
  implements RemindersApi
{
  private static final String[] zzbme = { "/", " ", "(", ")", "{", "}", "&", "|", "\"", "\t", "\r", "\n", "", ".", "-" };

  private static void zza(DateTime paramDateTime)
  {
    boolean bool2 = false;
    int i;
    if ((paramDateTime.getYear() != null) && (paramDateTime.getMonth() != null) && (paramDateTime.getDay() != null))
    {
      i = 1;
      if ((i == 0) && ((paramDateTime.getYear() != null) || (paramDateTime.getMonth() != null) || (paramDateTime.getDay() != null)))
        break label275;
      bool1 = true;
      label64: zzv.zzb(bool1, "Invalid DateTime, year/month/day must all be set or unset together.");
      if (i != 0)
      {
        if ((paramDateTime.getMonth().intValue() < 1) || (paramDateTime.getMonth().intValue() > 12))
          break label280;
        bool1 = true;
        label103: zzv.zzb(bool1, "Invalid month " + paramDateTime.getMonth() + ", should be in range [1, 12]");
        if (paramDateTime.getDay().intValue() < 1)
          break label285;
        bool1 = true;
        label151: zzv.zzb(bool1, "Invalid day " + paramDateTime.getDay() + ", should be >=1");
      }
      if ((paramDateTime.getAbsoluteTimeMs() == null) && (!Boolean.TRUE.equals(paramDateTime.getUnspecifiedFutureTime())) && (i == 0))
        break label290;
    }
    label275: label280: label285: label290: for (boolean bool1 = true; ; bool1 = false)
    {
      zzv.zzb(bool1, "Invalid DateTime, must either contain an absolute time, a year/month/day, or be set to an unspecified future time.");
      if (Boolean.TRUE.equals(paramDateTime.getUnspecifiedFutureTime()))
      {
        bool1 = bool2;
        if (paramDateTime.getAbsoluteTimeMs() == null)
        {
          bool1 = bool2;
          if (i != 0);
        }
      }
      else
      {
        bool1 = true;
      }
      zzv.zzb(bool1, "Invalid DateTime, unspecified_future_time cannot be set together with absolute_time or year/month/day");
      zzb(paramDateTime.getTime());
      return;
      i = 0;
      break;
      bool1 = false;
      break label64;
      bool1 = false;
      break label103;
      bool1 = false;
      break label151;
    }
  }

  private static void zza(Location paramLocation)
  {
    if (paramLocation == null);
    while (paramLocation.getLocationType() == null)
      return;
    if ((paramLocation.getLat() == null) && (paramLocation.getLng() == null) && (paramLocation.getDisplayAddress() == null) && (paramLocation.getGeoFeatureId() == null));
    for (boolean bool = true; ; bool = false)
    {
      zzv.zzb(bool, "If providing a locationType you cannot provide lat/lng, address, or any other location identifying attributes.");
      return;
    }
  }

  private static void zza(Recurrence paramRecurrence)
  {
    boolean bool2 = true;
    zzv.zzb(paramRecurrence.getFrequency(), "Must provide Recurrence.frequency on create");
    zzv.zzb(paramRecurrence.getRecurrenceStart(), "Must provide Recurrence.recurrence_start on create");
    zzv.zzb(paramRecurrence.getRecurrenceStart().getStartDateTime(), "Must provide RecurrenceStart.start_date_time on create");
    zza(paramRecurrence.getRecurrenceStart().getStartDateTime());
    boolean bool1;
    if (paramRecurrence.getRecurrenceEnd() != null)
    {
      paramRecurrence = paramRecurrence.getRecurrenceEnd();
      if (paramRecurrence.getAutoRenew() != null)
        break label140;
      bool1 = true;
      zzv.zzb(bool1, "RecurrenceEnd.auto_renew is readonly");
      if (paramRecurrence.getAutoRenewUntil() != null)
        break label145;
      bool1 = true;
      label101: zzv.zzb(bool1, "RecurrenceEnd.auto_renew_until is readonly");
      if (paramRecurrence.getNumOccurrences() == null)
        break label155;
      if (paramRecurrence.getNumOccurrences().intValue() > 1000)
        break label150;
      bool1 = bool2;
      zzv.zzb(bool1, "RecurrenceEnd.num_occurrences must be <= 1000");
    }
    label140: label145: label150: label155: 
    while (paramRecurrence.getEndDateTime() == null)
      while (true)
      {
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label101;
        bool1 = false;
      }
    zza(paramRecurrence.getEndDateTime());
  }

  private static void zza(Task paramTask)
  {
    boolean bool2 = true;
    if (paramTask.getDueDate() == null)
    {
      bool1 = true;
      zzv.zzb(bool1, "task.due_date is determined by recurrence and should not be set");
      if (paramTask.getTaskId() != null)
        break label76;
      bool1 = true;
      label30: zzv.zzb(bool1, "task.task_id field is readonly");
      if (paramTask.getRecurrenceInfo() != null)
        break label81;
      bool1 = true;
      label47: zzv.zzb(bool1, "task.recurrence_info field is readonly");
      if (paramTask.getLocation() != null)
        break label86;
    }
    label76: label81: label86: for (boolean bool1 = bool2; ; bool1 = false)
    {
      zzv.zzb(bool1, "task.location not supported for recurrences.");
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label30;
      bool1 = false;
      break label47;
    }
  }

  private static <T> zzi<T> zzb(GoogleApiClient paramGoogleApiClient, T paramT)
  {
    if (paramT == null)
      return null;
    return paramGoogleApiClient.zzs(paramT);
  }

  private static Task zzb(Task paramTask)
  {
    Task localTask;
    if (!Boolean.TRUE.equals(paramTask.getSnoozed()))
    {
      localTask = paramTask;
      if (!Boolean.TRUE.equals(paramTask.getPinned()));
    }
    else if (!Boolean.TRUE.equals(paramTask.getArchived()))
    {
      localTask = paramTask;
      if (!Boolean.TRUE.equals(paramTask.getDeleted()));
    }
    else
    {
      paramTask = new Task.Builder(paramTask);
      paramTask.setArchived(Boolean.valueOf(false));
      paramTask.setDeleted(Boolean.valueOf(false));
      localTask = paramTask.build();
    }
    return localTask;
  }

  private static void zzb(Time paramTime)
  {
    boolean bool2 = true;
    if (paramTime == null)
      return;
    if ((paramTime.getHour().intValue() >= 0) && (paramTime.getHour().intValue() < 24))
    {
      bool1 = true;
      zzv.zzb(bool1, "Invalid hour:" + paramTime.getHour());
      if ((paramTime.getMinute().intValue() < 0) || (paramTime.getMinute().intValue() >= 60))
        break label184;
      bool1 = true;
      label92: zzv.zzb(bool1, "Invalid minute:" + paramTime.getMinute());
      if ((paramTime.getSecond().intValue() < 0) || (paramTime.getSecond().intValue() >= 60))
        break label189;
    }
    label184: label189: for (boolean bool1 = bool2; ; bool1 = false)
    {
      zzv.zzb(bool1, "Invalid second:" + paramTime.getSecond());
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label92;
    }
  }

  private static void zzeq(String paramString)
  {
    int i;
    label27: String str;
    if (!TextUtils.isEmpty(paramString))
    {
      bool = true;
      zzv.zzb(bool, "empty recurrence id");
      String[] arrayOfString = zzbme;
      int j = arrayOfString.length;
      i = 0;
      if (i >= j)
        return;
      str = arrayOfString[i];
      if (paramString.contains(str))
        break label77;
    }
    label77: for (boolean bool = true; ; bool = false)
    {
      zzv.zzb(bool, "recurrence id must not contain %s", new Object[] { str });
      i += 1;
      break label27;
      bool = false;
      break;
    }
  }

  public PendingResult<Status> addListener(final GoogleApiClient paramGoogleApiClient, final RemindersApi.RemindersChangeListener paramRemindersChangeListener)
  {
    zzv.zzb(paramRemindersChangeListener, "Listener could not be null");
    return paramGoogleApiClient.zza(new zztm(paramGoogleApiClient)
    {
      protected void zza(zztj paramAnonymouszztj)
        throws RemoteException
      {
        paramAnonymouszztj.zza(this, zztn.zzc(paramGoogleApiClient, paramRemindersChangeListener));
      }

      public Status zze(Status paramAnonymousStatus)
      {
        return paramAnonymousStatus;
      }
    });
  }

  public PendingResult<Status> batchUpdateReminder(GoogleApiClient paramGoogleApiClient, List<Task> paramList)
  {
    zzv.zzb(paramList, "New tasks required on update.");
    final ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      Task localTask = (Task)paramList.next();
      zzv.zzb(localTask, "New task required on update.");
      zzv.zzb(localTask.getTaskId(), "Task id required on update.");
      if (localTask.getLocation() != null)
        zza(localTask.getLocation());
      if (localTask.getDueDate() != null)
      {
        zza(localTask.getDueDate());
        if ((localTask.getLocation() != null) || (localTask.getLocationGroup() != null))
          break label152;
      }
      label152: for (boolean bool = true; ; bool = false)
      {
        zzv.zzb(bool, "Cannot snooze to both location and time.");
        localArrayList.add(zzb(localTask));
        break;
      }
    }
    return paramGoogleApiClient.zza(new zztm(paramGoogleApiClient)
    {
      protected void zza(zztj paramAnonymouszztj)
        throws RemoteException
      {
        paramAnonymouszztj.zza(this, localArrayList);
      }

      public Status zze(Status paramAnonymousStatus)
      {
        return paramAnonymousStatus;
      }
    });
  }

  public PendingResult<Status> changeRecurrence(GoogleApiClient paramGoogleApiClient, final String paramString1, String paramString2, Recurrence paramRecurrence, Task paramTask, final UpdateRecurrenceOptions paramUpdateRecurrenceOptions)
  {
    boolean bool2 = true;
    zzv.zzb(paramRecurrence, "new_recurrence required");
    zzv.zzb(paramTask, "task required");
    if ((paramTask.getDeleted() == null) || (!paramTask.getDeleted().booleanValue()))
    {
      bool1 = true;
      zzv.zzb(bool1, "task.deleted field is readonly");
      if (TextUtils.equals(paramString1, paramString2))
        break label178;
    }
    label178: for (boolean bool1 = bool2; ; bool1 = false)
    {
      zzv.zzb(bool1, "new recurrenceId must be different than existing recurrenceId");
      zzv.zzb(paramTask.getTaskList(), "Must set task list");
      zzv.zzb(paramUpdateRecurrenceOptions, "updateRecurrenceOption required");
      zzeq(paramString1);
      zzeq(paramString2);
      zza(paramRecurrence);
      zza(paramTask);
      return paramGoogleApiClient.zza(new zztm(paramGoogleApiClient)
      {
        protected void zza(zztj paramAnonymouszztj)
          throws RemoteException
        {
          paramAnonymouszztj.zzb(this, paramString1, zzbmk, paramUpdateRecurrenceOptions);
        }

        public Status zze(Status paramAnonymousStatus)
        {
          return paramAnonymousStatus;
        }
      });
      bool1 = false;
      break;
    }
  }

  public PendingResult<Status> createRecurrence(GoogleApiClient paramGoogleApiClient, String paramString, Recurrence paramRecurrence, Task paramTask)
  {
    boolean bool2 = true;
    if (!zzr.zzcn(paramString))
    {
      bool1 = true;
      zzv.zzb(bool1, "Must provide recurrenceId on create");
      zzv.zzb(paramRecurrence, "Must provide recurrence rule on create.");
      zzv.zzb(paramTask, "Must provide reminder template on create.");
      zzv.zzb(paramTask.getTaskList(), "Must provide task list on create");
      if (Boolean.TRUE.equals(paramTask.getDeleted()))
        break label193;
      bool1 = true;
      label71: zzv.zzb(bool1, "Task.deleted field is readonly.");
      if (paramTask.getDueDate() != null)
        break label199;
      bool1 = true;
      label92: zzv.zzb(bool1, "Cannot set due_date on recurring reminder");
      if (paramTask.getLocation() != null)
        break label205;
    }
    label193: label199: label205: for (boolean bool1 = bool2; ; bool1 = false)
    {
      zzv.zzb(bool1, "Cannot set location on recurring reminder");
      zzeq(paramString);
      zza(paramRecurrence);
      zza(paramTask);
      return paramGoogleApiClient.zza(new zztm(paramGoogleApiClient)
      {
        protected void zza(zztj paramAnonymouszztj)
          throws RemoteException
        {
          paramAnonymouszztj.zza(this, zzbmk);
        }

        public Status zze(Status paramAnonymousStatus)
        {
          return paramAnonymousStatus;
        }
      });
      bool1 = false;
      break;
      bool1 = false;
      break label71;
      bool1 = false;
      break label92;
    }
  }

  public PendingResult<Status> createReminder(GoogleApiClient paramGoogleApiClient, Task paramTask)
  {
    return createReminder(paramGoogleApiClient, paramTask, null);
  }

  public PendingResult<Status> createReminder(final GoogleApiClient paramGoogleApiClient, Task paramTask, final CreateReminderOptions paramCreateReminderOptions)
  {
    boolean bool2 = true;
    zzv.zzb(paramTask, "Must provide task on create.");
    zzv.zzb(paramTask.getTaskList(), "Must provide task list on create");
    if (!Boolean.TRUE.equals(paramTask.getDeleted()))
    {
      bool1 = true;
      zzv.zzb(bool1, "Task.deleted field is readonly.");
      if (paramTask.getRecurrenceInfo() != null)
        break label155;
      bool1 = true;
      label62: zzv.zzb(bool1, "Task recurrence info field is readonly.");
      if (paramTask.getDueDate() != null)
      {
        zza(paramTask.getDueDate());
        if ((paramTask.getLocation() != null) || (paramTask.getLocationGroup() != null))
          break label161;
      }
    }
    label155: label161: for (boolean bool1 = bool2; ; bool1 = false)
    {
      zzv.zzb(bool1, "Cannot snooze to both location and time.");
      zza(paramTask.getLocation());
      return paramGoogleApiClient.zza(new zztm(paramGoogleApiClient)
      {
        protected void zza(zztj paramAnonymouszztj)
          throws RemoteException
        {
          if (paramCreateReminderOptions == null)
          {
            paramAnonymouszztj.zza(this, zzbmk, null, CreateReminderOptionsInternal.zzblC);
            return;
          }
          paramAnonymouszztj.zza(this, zzbmk, zztn.zzc(paramGoogleApiClient, paramCreateReminderOptions.getListener()), paramCreateReminderOptions.getInternalOptions());
        }

        public Status zze(Status paramAnonymousStatus)
        {
          return paramAnonymousStatus;
        }
      });
      bool1 = false;
      break;
      bool1 = false;
      break label62;
    }
  }

  public PendingResult<Status> deleteRecurrence(GoogleApiClient paramGoogleApiClient, final String paramString, final UpdateRecurrenceOptions paramUpdateRecurrenceOptions)
  {
    zzv.zzb(paramString, "Must provide client-assigned recurrence id.");
    zzv.zzb(paramUpdateRecurrenceOptions, "updateRecurrenceOption required");
    return paramGoogleApiClient.zza(new zztm(paramGoogleApiClient)
    {
      protected void zza(zztj paramAnonymouszztj)
        throws RemoteException
      {
        paramAnonymouszztj.zza(this, paramString, paramUpdateRecurrenceOptions);
      }

      public Status zze(Status paramAnonymousStatus)
      {
        return paramAnonymousStatus;
      }
    });
  }

  public PendingResult<Status> deleteReminder(GoogleApiClient paramGoogleApiClient, final TaskId paramTaskId)
  {
    zzv.zzb(paramTaskId, "Task id required on delete.");
    return paramGoogleApiClient.zza(new zztm(paramGoogleApiClient)
    {
      protected void zza(zztj paramAnonymouszztj)
        throws RemoteException
      {
        paramAnonymouszztj.zza(this, paramTaskId);
      }

      public Status zze(Status paramAnonymousStatus)
      {
        return paramAnonymousStatus;
      }
    });
  }

  public PendingResult<RemindersApi.LoadRemindersResult> loadReminders(GoogleApiClient paramGoogleApiClient, final LoadRemindersOptions paramLoadRemindersOptions)
  {
    return paramGoogleApiClient.zza(new zztm(paramGoogleApiClient)
    {
      protected void zza(zztj paramAnonymouszztj)
        throws RemoteException
      {
        zzte local1 = new zzte()
        {
          public void zza(DataHolder paramAnonymous2DataHolder, Status paramAnonymous2Status)
          {
            if (paramAnonymous2DataHolder == null);
            for (paramAnonymous2DataHolder = null; ; paramAnonymous2DataHolder = new RemindersBuffer(paramAnonymous2DataHolder))
            {
              setResult(new zztn.zzb(paramAnonymous2DataHolder, paramAnonymous2Status));
              return;
            }
          }
        };
        if (paramLoadRemindersOptions == null);
        for (LoadRemindersOptions localLoadRemindersOptions = LoadRemindersOptions.DEFAULT_OPTION; ; localLoadRemindersOptions = paramLoadRemindersOptions)
        {
          paramAnonymouszztj.zza(local1, localLoadRemindersOptions);
          return;
        }
      }

      protected RemindersApi.LoadRemindersResult zzcr(Status paramAnonymousStatus)
      {
        return new zztn.zzb(null, paramAnonymousStatus);
      }
    });
  }

  public PendingResult<Status> makeRecurrenceSingleInstance(GoogleApiClient paramGoogleApiClient, final String paramString, Task paramTask, final UpdateRecurrenceOptions paramUpdateRecurrenceOptions)
  {
    zzv.zzb(paramTask, "task_id required");
    zzv.zzb(paramTask.getTaskId(), "task_id required");
    zzeq(paramString);
    zzv.zzb(paramTask.getTaskList(), "Must set task list");
    zzv.zzb(paramUpdateRecurrenceOptions, "updateRecurrenceOption required");
    return paramGoogleApiClient.zza(new zztm(paramGoogleApiClient)
    {
      protected void zza(zztj paramAnonymouszztj)
        throws RemoteException
      {
        paramAnonymouszztj.zzc(this, paramString, zzbmk, paramUpdateRecurrenceOptions);
      }

      public Status zze(Status paramAnonymousStatus)
      {
        return paramAnonymousStatus;
      }
    });
  }

  public PendingResult<Status> makeTaskRecurring(GoogleApiClient paramGoogleApiClient, TaskId paramTaskId, String paramString, Recurrence paramRecurrence, Task paramTask)
  {
    zzv.zzb(paramTaskId, "task_id required");
    zzv.zzb(paramRecurrence, "recurrence required");
    zzv.zzb(paramTask, "task required");
    if (!Boolean.TRUE.equals(paramTask.getDeleted()));
    for (boolean bool = true; ; bool = false)
    {
      zzv.zzb(bool, "Task.deleted field is readonly.");
      zzv.zzb(paramTask.getTaskList(), "Must set task list");
      zzeq(paramString);
      zza(paramRecurrence);
      zza(paramTask);
      return paramGoogleApiClient.zza(new zztm(paramGoogleApiClient)
      {
        protected void zza(zztj paramAnonymouszztj)
          throws RemoteException
        {
          paramAnonymouszztj.zzb(this, zzbmk);
        }

        public Status zze(Status paramAnonymousStatus)
        {
          return paramAnonymousStatus;
        }
      });
    }
  }

  public PendingResult<Status> updateRecurrence(GoogleApiClient paramGoogleApiClient, final String paramString, Task paramTask, final UpdateRecurrenceOptions paramUpdateRecurrenceOptions)
  {
    zzv.zzb(paramString, "Must provide client-assigned recurrence id.");
    zzv.zzb(paramTask, "Must provide new task template");
    zzv.zzb(paramUpdateRecurrenceOptions, "updateRecurrenceOption required");
    return paramGoogleApiClient.zza(new zztm(paramGoogleApiClient)
    {
      protected void zza(zztj paramAnonymouszztj)
        throws RemoteException
      {
        paramAnonymouszztj.zza(this, paramString, zzbmk, paramUpdateRecurrenceOptions);
      }

      public Status zze(Status paramAnonymousStatus)
      {
        return paramAnonymousStatus;
      }
    });
  }

  public PendingResult<Status> updateReminder(GoogleApiClient paramGoogleApiClient, Task paramTask)
  {
    return batchUpdateReminder(paramGoogleApiClient, Arrays.asList(new Task[] { paramTask }));
  }

  static class zzb
    implements RemindersApi.LoadRemindersResult
  {
    private final Status zzOQ;
    private final RemindersBuffer zzbmu;

    zzb(RemindersBuffer paramRemindersBuffer, Status paramStatus)
    {
      zzbmu = paramRemindersBuffer;
      zzOQ = paramStatus;
    }

    public RemindersBuffer getRemindersBuffer()
    {
      return zzbmu;
    }

    public Status getStatus()
    {
      return zzOQ;
    }
  }
}