package com.google.android.gms.internal;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza.zzb;
import com.google.android.gms.common.api.zzi;
import com.google.android.gms.common.api.zzi.zzb;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzv;
import com.google.android.gms.reminders.CreateReminderOptionsInternal;
import com.google.android.gms.reminders.LoadRemindersOptions;
import com.google.android.gms.reminders.RemindersApi.ReminderCreatedListener;
import com.google.android.gms.reminders.RemindersApi.RemindersChangeListener;
import com.google.android.gms.reminders.UpdateRecurrenceOptions;
import com.google.android.gms.reminders.model.ReminderEventBuffer;
import com.google.android.gms.reminders.model.SnoozePresetChangedEventBuffer;
import com.google.android.gms.reminders.model.Task;
import com.google.android.gms.reminders.model.TaskEntity;
import com.google.android.gms.reminders.model.TaskId;
import com.google.android.gms.reminders.model.TaskIdEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class zztj extends zzj<zzth>
{
  private final zzf zzahu;

  public zztj(Context paramContext, Looper paramLooper, zzf paramzzf, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 18, paramConnectionCallbacks, paramOnConnectionFailedListener, paramzzf);
    zzahu = paramzzf;
  }

  public void disconnect()
  {
    if (isConnected());
    try
    {
      ((zzth)zzpN()).zzBY();
      super.disconnect();
      return;
    }
    catch (DeadObjectException localDeadObjectException)
    {
      while (true)
        Log.e("Reminders", "Dead object exception when clearing listeners", localDeadObjectException);
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        Log.e("Reminders", "Remote exception when clearing listeners", localRemoteException);
    }
  }

  protected String getServiceDescriptor()
  {
    return "com.google.android.gms.reminders.internal.IRemindersService";
  }

  protected String getStartServiceAction()
  {
    return "com.google.android.gms.reminders.service.START";
  }

  public boolean requiresAccount()
  {
    return true;
  }

  public void zza(zza.zzb<Status> paramzzb, zzi<RemindersApi.RemindersChangeListener> paramzzi)
    throws RemoteException
  {
    ((zzth)zzpN()).zza(new zzc(paramzzb, paramzzi));
  }

  public void zza(zza.zzb<Status> paramzzb, Task paramTask)
    throws RemoteException
  {
    zzv.zzce(zzahu.getAccountName());
    zzv.zzz(paramTask);
    ((zzth)zzpN()).zzc(new zzd(paramzzb), new TaskEntity(paramTask));
  }

  public void zza(zza.zzb<Status> paramzzb, Task paramTask, zzi<RemindersApi.ReminderCreatedListener> paramzzi, CreateReminderOptionsInternal paramCreateReminderOptionsInternal)
    throws RemoteException
  {
    zzv.zzce(zzahu.getAccountName());
    zzv.zzz(paramTask);
    zzv.zzz(paramCreateReminderOptionsInternal);
    ((zzth)zzpN()).zza(new zzb(paramzzb, paramzzi), new TaskEntity(paramTask), paramCreateReminderOptionsInternal);
  }

  public void zza(zza.zzb<Status> paramzzb, TaskId paramTaskId)
    throws RemoteException
  {
    zzv.zzz(paramTaskId);
    zzv.zzce(zzahu.getAccountName());
    if ((paramTaskId.getServerAssignedId() != null) || (paramTaskId.getClientAssignedId() != null));
    for (boolean bool = true; ; bool = false)
    {
      zzv.zzS(bool);
      ((zzth)zzpN()).zza(new zzd(paramzzb), new TaskIdEntity(paramTaskId));
      return;
    }
  }

  public void zza(zza.zzb<Status> paramzzb, String paramString, UpdateRecurrenceOptions paramUpdateRecurrenceOptions)
    throws RemoteException
  {
    zzv.zzce(zzahu.getAccountName());
    ((zzth)zzpN()).zza(new zzd(paramzzb), paramString, paramUpdateRecurrenceOptions);
  }

  public void zza(zza.zzb<Status> paramzzb, String paramString, Task paramTask, UpdateRecurrenceOptions paramUpdateRecurrenceOptions)
    throws RemoteException
  {
    ((zzth)zzpN()).zza(new zzd(paramzzb), paramString, new TaskEntity(paramTask), paramUpdateRecurrenceOptions);
  }

  public void zza(zza.zzb<Status> paramzzb, List<Task> paramList)
    throws RemoteException
  {
    zzv.zzce(zzahu.getAccountName());
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      Task localTask = (Task)paramList.next();
      TaskId localTaskId = localTask.getTaskId();
      if ((localTaskId.getServerAssignedId() != null) || (localTaskId.getClientAssignedId() != null));
      for (boolean bool = true; ; bool = false)
      {
        zzv.zzS(bool);
        localArrayList.add(new TaskEntity(localTask));
        break;
      }
    }
    ((zzth)zzpN()).zza(new zzd(paramzzb), localArrayList);
  }

  public void zza(zztf paramzztf, LoadRemindersOptions paramLoadRemindersOptions)
    throws RemoteException
  {
    zzv.zzce(zzahu.getAccountName());
    ((zzth)zzpN()).zza(paramzztf, paramLoadRemindersOptions);
  }

  public void zzb(zza.zzb<Status> paramzzb, Task paramTask)
    throws RemoteException
  {
    zzv.zzce(zzahu.getAccountName());
    ((zzth)zzpN()).zzd(new zzd(paramzzb), new TaskEntity(paramTask));
  }

  public void zzb(zza.zzb<Status> paramzzb, String paramString, Task paramTask, UpdateRecurrenceOptions paramUpdateRecurrenceOptions)
    throws RemoteException
  {
    zzv.zzce(zzahu.getAccountName());
    ((zzth)zzpN()).zzb(new zzd(paramzzb), paramString, new TaskEntity(paramTask), paramUpdateRecurrenceOptions);
  }

  public void zzc(zza.zzb<Status> paramzzb, String paramString, Task paramTask, UpdateRecurrenceOptions paramUpdateRecurrenceOptions)
    throws RemoteException
  {
    zzv.zzce(zzahu.getAccountName());
    ((zzth)zzpN()).zzc(new zzd(paramzzb), paramString, new TaskEntity(paramTask), paramUpdateRecurrenceOptions);
  }

  protected zzth zzfX(IBinder paramIBinder)
  {
    return zzth.zza.zzfW(paramIBinder);
  }

  private static final class zzb extends zztj.zzd
  {
    private final zzi<RemindersApi.ReminderCreatedListener> zzauJ;

    public zzb(zza.zzb<Status> paramzzb, zzi<RemindersApi.ReminderCreatedListener> paramzzi)
    {
      super();
      zzauJ = paramzzi;
    }

    public void onReminderCreated(final String paramString1, final String paramString2)
    {
      if (zzauJ != null)
        zzauJ.zza(new zzi.zzb()
        {
          public void zza(RemindersApi.ReminderCreatedListener paramAnonymousReminderCreatedListener)
          {
            paramAnonymousReminderCreatedListener.onReminderCreated(paramString1, paramString2);
            zztj.zzb.zza(zztj.zzb.this).clear();
          }

          public void zzoy()
          {
            Log.e("Reminders", "Notify reminder created listener failed");
          }
        });
    }
  }

  private static final class zzc extends zztj.zzd
  {
    private final zzi<RemindersApi.RemindersChangeListener> zzauJ;

    public zzc(zza.zzb<Status> paramzzb, zzi<RemindersApi.RemindersChangeListener> paramzzi)
    {
      super();
      zzauJ = paramzzi;
    }

    public void zzai(final DataHolder paramDataHolder)
    {
      zzauJ.zza(new zzi.zzb()
      {
        public void zza(RemindersApi.RemindersChangeListener paramAnonymousRemindersChangeListener)
        {
          paramAnonymousRemindersChangeListener.onRemindersChanged(new ReminderEventBuffer(paramDataHolder));
        }

        public void zzoy()
        {
          Log.e("Reminders", "Notify listener failed");
          if (paramDataHolder != null)
            paramDataHolder.close();
        }
      });
    }

    public void zzaj(final DataHolder paramDataHolder)
    {
      if (zzauJ != null)
        zzauJ.zza(new zzi.zzb()
        {
          public void zza(RemindersApi.RemindersChangeListener paramAnonymousRemindersChangeListener)
          {
            paramAnonymousRemindersChangeListener.onSnoozePresetChanged(new SnoozePresetChangedEventBuffer(paramDataHolder));
          }

          public void zzoy()
          {
            Log.e("Reminders", "Notify listener failed");
            if (paramDataHolder != null)
              paramDataHolder.close();
          }
        });
    }
  }

  private static class zzd extends zzte
  {
    private final zza.zzb<Status> zzbmc;

    public zzd(zza.zzb<Status> paramzzb)
    {
      zzbmc = paramzzb;
    }

    public void zzb(Status paramStatus)
    {
      zzbmc.zzq(paramStatus);
    }
  }
}