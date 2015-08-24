package com.google.android.gms.reminders;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.zztg.zza;
import com.google.android.gms.reminders.model.ReminderEvent;
import com.google.android.gms.reminders.model.ReminderEventBuffer;
import com.google.android.gms.reminders.model.ReminderEventEntity;
import com.google.android.gms.reminders.model.SnoozePresetChangedEventBuffer;
import com.google.android.gms.reminders.model.Task;
import com.google.android.gms.reminders.model.TaskEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class RemindersListenerService extends Service
{
  private String mPackageName;
  private List<DataHolder> zzblQ = Collections.synchronizedList(new ArrayList());
  private volatile int zzoG = -1;
  private Handler zzoH;
  private IBinder zzoI;
  private Object zzoJ = new Object();
  private boolean zzoK;

  private int zzag(DataHolder paramDataHolder)
  {
    synchronized (zzblQ)
    {
      int i = zzblQ.size();
      zzblQ.add(paramDataHolder);
      return i;
    }
  }

  private void zzbj()
    throws SecurityException
  {
    int i = Binder.getCallingUid();
    if (i == zzoG)
      return;
    if (GooglePlayServicesUtil.zze(this, i))
    {
      zzoG = i;
      return;
    }
    throw new SecurityException("Caller is not GooglePlayServices");
  }

  private void zzeo(String paramString)
  {
    if (Log.isLoggable("RemindersLS", 3))
      Log.d("RemindersLS", paramString);
  }

  private DataHolder zzoh(int paramInt)
  {
    List localList = zzblQ;
    if (paramInt >= 0);
    try
    {
      if (paramInt < zzblQ.size())
      {
        DataHolder localDataHolder = (DataHolder)zzblQ.get(paramInt);
        return localDataHolder;
      }
      return null;
    }
    finally
    {
    }
  }

  public final IBinder onBind(Intent paramIntent)
  {
    if ("com.google.android.gms.reminders.BIND_LISTENER".equals(paramIntent.getAction()))
      return zzoI;
    return null;
  }

  public void onCreate()
  {
    super.onCreate();
    zzeo("onCreate: " + getPackageName());
    mPackageName = getPackageName();
    GooglePlayServicesUtil.verifyPackageIsGoogleSigned(getPackageManager(), mPackageName);
    HandlerThread localHandlerThread = new HandlerThread("RemindersLS");
    localHandlerThread.start();
    zzoH = new zzb(localHandlerThread.getLooper());
    zzoI = new zza(null);
  }

  public void onDestroy()
  {
    zzeo("onDestroy");
    synchronized (zzoJ)
    {
      zzoK = true;
      zzoH.getLooper().quit();
      super.onDestroy();
      return;
    }
  }

  protected final void onHandleIntentInternal(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("api_id", 0);
    if (i == 1)
    {
      paramIntent = (ReminderEventEntity)paramIntent.getParcelableExtra("reminder_event");
      zzeo("onReminderFiredInternal Handling thread:" + paramIntent.getTask().getTitle());
      onReminderFired(paramIntent);
    }
    do
    {
      do
      {
        do
        {
          return;
          if (i != 2)
            break;
          i = paramIntent.getIntExtra("data_holder_id", -1);
        }
        while (zzoh(i) == null);
        paramIntent = new ReminderEventBuffer((DataHolder)zzblQ.get(i));
        zzeo("onRemindersChangedInternal Handling thread:" + paramIntent.getCount());
        try
        {
          onRemindersChanged(paramIntent);
          return;
        }
        finally
        {
          paramIntent.release();
        }
      }
      while (i != 3);
      i = paramIntent.getIntExtra("data_holder_id", -1);
    }
    while (zzoh(i) == null);
    paramIntent = new SnoozePresetChangedEventBuffer((DataHolder)zzblQ.get(i));
    zzeo("onRemindersChangedInternal Handling thread:" + paramIntent.getCount());
    try
    {
      onSnoozePresetChanged(paramIntent);
      return;
    }
    finally
    {
      paramIntent.release();
    }
  }

  protected abstract void onReminderFired(ReminderEvent paramReminderEvent);

  protected abstract void onRemindersChanged(ReminderEventBuffer paramReminderEventBuffer);

  protected abstract void onSnoozePresetChanged(SnoozePresetChangedEventBuffer paramSnoozePresetChangedEventBuffer);

  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    zzeo("onStartCommand:" + paramIntent + " flag:" + paramInt1 + " startId:" + paramInt2);
    Message localMessage = zzoH.obtainMessage();
    localMessage.arg1 = paramInt2;
    localMessage.obj = paramIntent;
    zzoH.sendMessage(localMessage);
    return 3;
  }

  private class zza extends zztg.zza
  {
    private zza()
    {
    }

    public void zza(TaskEntity paramTaskEntity)
      throws RemoteException
    {
    }

    public void zzah(DataHolder paramDataHolder)
      throws RemoteException
    {
      RemindersListenerService.zza(RemindersListenerService.this, "onReminderFired: " + RemindersListenerService.zza(RemindersListenerService.this));
      RemindersListenerService.zzb(RemindersListenerService.this);
      synchronized (RemindersListenerService.zzc(RemindersListenerService.this))
      {
        RemindersListenerService.zza(RemindersListenerService.this, "onReminderFired: " + RemindersListenerService.zza(RemindersListenerService.this) + ": shutdown? " + RemindersListenerService.zzd(RemindersListenerService.this));
        if (RemindersListenerService.zzd(RemindersListenerService.this))
        {
          if (paramDataHolder != null)
            paramDataHolder.close();
          return;
        }
        RemindersListenerService.zza(RemindersListenerService.this, "onReminderFired: " + RemindersListenerService.zza(RemindersListenerService.this) + ": " + paramDataHolder.getCount());
        paramDataHolder = new ReminderEventBuffer(paramDataHolder);
      }
      try
      {
        ReminderEventEntity localReminderEventEntity = new ReminderEventEntity(paramDataHolder.get(0));
        RemindersListenerService.zza(RemindersListenerService.this, "onReminderFired: Post to package handling thread");
        Intent localIntent = new Intent(RemindersListenerService.this, getClass());
        localIntent.putExtra("api_id", 1);
        localIntent.putExtra("reminder_event", localReminderEventEntity);
        startService(localIntent);
        paramDataHolder.release();
        return;
        paramDataHolder = finally;
        throw paramDataHolder;
      }
      finally
      {
        paramDataHolder.release();
      }
    }

    public void zzai(DataHolder paramDataHolder)
      throws RemoteException
    {
      RemindersListenerService.zza(RemindersListenerService.this, "onReminderChangeEvents: " + RemindersListenerService.zza(RemindersListenerService.this));
      RemindersListenerService.zzb(RemindersListenerService.this);
      synchronized (RemindersListenerService.zzc(RemindersListenerService.this))
      {
        RemindersListenerService.zza(RemindersListenerService.this, "onReminderChangeEvents: " + RemindersListenerService.zza(RemindersListenerService.this) + ": shutdown? " + RemindersListenerService.zzd(RemindersListenerService.this));
        if (RemindersListenerService.zzd(RemindersListenerService.this))
        {
          if (paramDataHolder != null)
            paramDataHolder.close();
          return;
        }
        RemindersListenerService.zza(RemindersListenerService.this, "onReminderChangeEvents: " + RemindersListenerService.zza(RemindersListenerService.this) + ": " + paramDataHolder.getCount());
        int i = RemindersListenerService.zza(RemindersListenerService.this, paramDataHolder);
        paramDataHolder = new Intent(RemindersListenerService.this, getClass());
        paramDataHolder.putExtra("api_id", 2);
        paramDataHolder.putExtra("data_holder_id", i);
        RemindersListenerService.zza(RemindersListenerService.this, "onReminderChangeEvents: Post to package handling thread");
        startService(paramDataHolder);
        return;
      }
    }

    public void zzaj(DataHolder paramDataHolder)
      throws RemoteException
    {
      RemindersListenerService.zza(RemindersListenerService.this, "onSnoozePresetChangedEvents: " + RemindersListenerService.zza(RemindersListenerService.this));
      RemindersListenerService.zzb(RemindersListenerService.this);
      synchronized (RemindersListenerService.zzc(RemindersListenerService.this))
      {
        RemindersListenerService.zza(RemindersListenerService.this, "onSnoozePresetChangedEvents: " + RemindersListenerService.zza(RemindersListenerService.this) + ": shutdown? " + RemindersListenerService.zzd(RemindersListenerService.this));
        if (RemindersListenerService.zzd(RemindersListenerService.this))
        {
          if (paramDataHolder != null)
            paramDataHolder.close();
          return;
        }
        RemindersListenerService.zza(RemindersListenerService.this, "onSnoozePresetChangedEvents: " + RemindersListenerService.zza(RemindersListenerService.this) + ": " + paramDataHolder.getCount());
        int i = RemindersListenerService.zza(RemindersListenerService.this, paramDataHolder);
        paramDataHolder = new Intent(RemindersListenerService.this, getClass());
        paramDataHolder.putExtra("api_id", 3);
        paramDataHolder.putExtra("data_holder_id", i);
        RemindersListenerService.zza(RemindersListenerService.this, "onReminderChangeEvents: Post to package handling thread");
        startService(paramDataHolder);
        return;
      }
    }
  }

  private final class zzb extends Handler
  {
    public zzb(Looper arg2)
    {
      super();
    }

    public void handleMessage(Message paramMessage)
    {
      onHandleIntentInternal((Intent)paramMessage.obj);
      stopSelf(paramMessage.arg1);
    }
  }
}