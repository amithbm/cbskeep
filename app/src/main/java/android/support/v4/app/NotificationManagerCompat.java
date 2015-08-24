package android.support.v4.app;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings.Secure;
import android.util.Log;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class NotificationManagerCompat
{
  private static final Impl IMPL;
  private static final int SIDE_CHANNEL_BIND_FLAGS;
  private static Set<String> sEnabledNotificationListenerPackages;
  private static String sEnabledNotificationListeners;
  private static final Object sEnabledNotificationListenersLock = new Object();
  private static final Object sLock;
  private static SideChannelManager sSideChannelManager;
  private final Context mContext;
  private final NotificationManager mNotificationManager;

  static
  {
    sEnabledNotificationListenerPackages = new HashSet();
    sLock = new Object();
    if (Build.VERSION.SDK_INT >= 14)
      IMPL = new ImplIceCreamSandwich();
    while (true)
    {
      SIDE_CHANNEL_BIND_FLAGS = IMPL.getSideChannelBindFlags();
      return;
      if (Build.VERSION.SDK_INT >= 5)
        IMPL = new ImplEclair();
      else
        IMPL = new ImplBase();
    }
  }

  private NotificationManagerCompat(Context paramContext)
  {
    mContext = paramContext;
    mNotificationManager = ((NotificationManager)mContext.getSystemService("notification"));
  }

  public static NotificationManagerCompat from(Context paramContext)
  {
    return new NotificationManagerCompat(paramContext);
  }

  public static Set<String> getEnabledListenerPackages(Context paramContext)
  {
    paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "enabled_notification_listeners");
    HashSet localHashSet;
    if ((paramContext != null) && (!paramContext.equals(sEnabledNotificationListeners)))
    {
      ??? = paramContext.split(":");
      localHashSet = new HashSet(???.length);
      int j = ???.length;
      int i = 0;
      while (i < j)
      {
        ComponentName localComponentName = ComponentName.unflattenFromString(???[i]);
        if (localComponentName != null)
          localHashSet.add(localComponentName.getPackageName());
        i += 1;
      }
    }
    synchronized (sEnabledNotificationListenersLock)
    {
      sEnabledNotificationListenerPackages = localHashSet;
      sEnabledNotificationListeners = paramContext;
      return sEnabledNotificationListenerPackages;
    }
  }

  private void pushSideChannelQueue(Task paramTask)
  {
    synchronized (sLock)
    {
      if (sSideChannelManager == null)
        sSideChannelManager = new SideChannelManager(mContext.getApplicationContext());
      sSideChannelManager.queueTask(paramTask);
      return;
    }
  }

  private static boolean useSideChannelForNotification(Notification paramNotification)
  {
    paramNotification = NotificationCompat.getExtras(paramNotification);
    return (paramNotification != null) && (paramNotification.getBoolean("android.support.useSideChannel"));
  }

  public void cancel(int paramInt)
  {
    cancel(null, paramInt);
  }

  public void cancel(String paramString, int paramInt)
  {
    IMPL.cancelNotification(mNotificationManager, paramString, paramInt);
    if (Build.VERSION.SDK_INT <= 19)
      pushSideChannelQueue(new CancelTask(mContext.getPackageName(), paramInt, paramString));
  }

  public void cancelAll()
  {
    mNotificationManager.cancelAll();
    if (Build.VERSION.SDK_INT <= 19)
      pushSideChannelQueue(new CancelTask(mContext.getPackageName()));
  }

  public void notify(int paramInt, Notification paramNotification)
  {
    notify(null, paramInt, paramNotification);
  }

  public void notify(String paramString, int paramInt, Notification paramNotification)
  {
    if (useSideChannelForNotification(paramNotification))
    {
      pushSideChannelQueue(new NotifyTask(mContext.getPackageName(), paramInt, paramString, paramNotification));
      IMPL.cancelNotification(mNotificationManager, paramString, paramInt);
      return;
    }
    IMPL.postNotification(mNotificationManager, paramString, paramInt, paramNotification);
  }

  private static class CancelTask
    implements NotificationManagerCompat.Task
  {
    final boolean all;
    final int id;
    final String packageName;
    final String tag;

    public CancelTask(String paramString)
    {
      packageName = paramString;
      id = 0;
      tag = null;
      all = true;
    }

    public CancelTask(String paramString1, int paramInt, String paramString2)
    {
      packageName = paramString1;
      id = paramInt;
      tag = paramString2;
      all = false;
    }

    public void send(INotificationSideChannel paramINotificationSideChannel)
      throws RemoteException
    {
      if (all)
      {
        paramINotificationSideChannel.cancelAll(packageName);
        return;
      }
      paramINotificationSideChannel.cancel(packageName, id, tag);
    }

    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("CancelTask[");
      localStringBuilder.append("packageName:").append(packageName);
      localStringBuilder.append(", id:").append(id);
      localStringBuilder.append(", tag:").append(tag);
      localStringBuilder.append(", all:").append(all);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
  }

  static abstract interface Impl
  {
    public abstract void cancelNotification(NotificationManager paramNotificationManager, String paramString, int paramInt);

    public abstract int getSideChannelBindFlags();

    public abstract void postNotification(NotificationManager paramNotificationManager, String paramString, int paramInt, Notification paramNotification);
  }

  static class ImplBase
    implements NotificationManagerCompat.Impl
  {
    public void cancelNotification(NotificationManager paramNotificationManager, String paramString, int paramInt)
    {
      paramNotificationManager.cancel(paramInt);
    }

    public int getSideChannelBindFlags()
    {
      return 1;
    }

    public void postNotification(NotificationManager paramNotificationManager, String paramString, int paramInt, Notification paramNotification)
    {
      paramNotificationManager.notify(paramInt, paramNotification);
    }
  }

  static class ImplEclair extends NotificationManagerCompat.ImplBase
  {
    public void cancelNotification(NotificationManager paramNotificationManager, String paramString, int paramInt)
    {
      NotificationManagerCompatEclair.cancelNotification(paramNotificationManager, paramString, paramInt);
    }

    public void postNotification(NotificationManager paramNotificationManager, String paramString, int paramInt, Notification paramNotification)
    {
      NotificationManagerCompatEclair.postNotification(paramNotificationManager, paramString, paramInt, paramNotification);
    }
  }

  static class ImplIceCreamSandwich extends NotificationManagerCompat.ImplEclair
  {
    public int getSideChannelBindFlags()
    {
      return 33;
    }
  }

  private static class NotifyTask
    implements NotificationManagerCompat.Task
  {
    final int id;
    final Notification notif;
    final String packageName;
    final String tag;

    public NotifyTask(String paramString1, int paramInt, String paramString2, Notification paramNotification)
    {
      packageName = paramString1;
      id = paramInt;
      tag = paramString2;
      notif = paramNotification;
    }

    public void send(INotificationSideChannel paramINotificationSideChannel)
      throws RemoteException
    {
      paramINotificationSideChannel.notify(packageName, id, tag, notif);
    }

    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("NotifyTask[");
      localStringBuilder.append("packageName:").append(packageName);
      localStringBuilder.append(", id:").append(id);
      localStringBuilder.append(", tag:").append(tag);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
  }

  private static class ServiceConnectedEvent
  {
    final ComponentName componentName;
    final IBinder iBinder;

    public ServiceConnectedEvent(ComponentName paramComponentName, IBinder paramIBinder)
    {
      componentName = paramComponentName;
      iBinder = paramIBinder;
    }
  }

  private static class SideChannelManager
    implements ServiceConnection, Handler.Callback
  {
    private Set<String> mCachedEnabledPackages = new HashSet();
    private final Context mContext;
    private final Handler mHandler;
    private final HandlerThread mHandlerThread;
    private final Map<ComponentName, ListenerRecord> mRecordMap = new HashMap();

    public SideChannelManager(Context paramContext)
    {
      mContext = paramContext;
      mHandlerThread = new HandlerThread("NotificationManagerCompat");
      mHandlerThread.start();
      mHandler = new Handler(mHandlerThread.getLooper(), this);
    }

    private boolean ensureServiceBound(ListenerRecord paramListenerRecord)
    {
      if (paramListenerRecord.bound)
        return true;
      Intent localIntent = new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(paramListenerRecord.componentName);
      paramListenerRecord.bound = mContext.bindService(localIntent, this, NotificationManagerCompat.SIDE_CHANNEL_BIND_FLAGS);
      if (paramListenerRecord.bound)
        paramListenerRecord.retryCount = 0;
      while (true)
      {
        return paramListenerRecord.bound;
        Log.w("NotifManCompat", "Unable to bind to listener " + paramListenerRecord.componentName);
        mContext.unbindService(this);
      }
    }

    private void ensureServiceUnbound(ListenerRecord paramListenerRecord)
    {
      if (paramListenerRecord.bound)
      {
        mContext.unbindService(this);
        paramListenerRecord.bound = false;
      }
      paramListenerRecord.service = null;
    }

    private void handleQueueTask(NotificationManagerCompat.Task paramTask)
    {
      updateListenerMap();
      Iterator localIterator = mRecordMap.values().iterator();
      while (localIterator.hasNext())
      {
        ListenerRecord localListenerRecord = (ListenerRecord)localIterator.next();
        localListenerRecord.taskQueue.add(paramTask);
        processListenerQueue(localListenerRecord);
      }
    }

    private void handleRetryListenerQueue(ComponentName paramComponentName)
    {
      paramComponentName = (ListenerRecord)mRecordMap.get(paramComponentName);
      if (paramComponentName != null)
        processListenerQueue(paramComponentName);
    }

    private void handleServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      paramComponentName = (ListenerRecord)mRecordMap.get(paramComponentName);
      if (paramComponentName != null)
      {
        paramComponentName.service = INotificationSideChannel.Stub.asInterface(paramIBinder);
        paramComponentName.retryCount = 0;
        processListenerQueue(paramComponentName);
      }
    }

    private void handleServiceDisconnected(ComponentName paramComponentName)
    {
      paramComponentName = (ListenerRecord)mRecordMap.get(paramComponentName);
      if (paramComponentName != null)
        ensureServiceUnbound(paramComponentName);
    }

    private void processListenerQueue(ListenerRecord paramListenerRecord)
    {
      if (Log.isLoggable("NotifManCompat", 3))
        Log.d("NotifManCompat", "Processing component " + paramListenerRecord.componentName + ", " + paramListenerRecord.taskQueue.size() + " queued tasks");
      if (paramListenerRecord.taskQueue.isEmpty());
      while (true)
      {
        return;
        if ((!ensureServiceBound(paramListenerRecord)) || (paramListenerRecord.service == null))
        {
          scheduleListenerRetry(paramListenerRecord);
          return;
        }
        try
        {
          Object localObject;
          do
          {
            if (Log.isLoggable("NotifManCompat", 3))
              Log.d("NotifManCompat", "Sending task " + localObject);
            ((NotificationManagerCompat.Task)localObject).send(paramListenerRecord.service);
            paramListenerRecord.taskQueue.remove();
            localObject = (NotificationManagerCompat.Task)paramListenerRecord.taskQueue.peek();
          }
          while (localObject != null);
          if (paramListenerRecord.taskQueue.isEmpty())
            continue;
          scheduleListenerRetry(paramListenerRecord);
          return;
        }
        catch (DeadObjectException localDeadObjectException)
        {
          while (true)
            if (Log.isLoggable("NotifManCompat", 3))
              Log.d("NotifManCompat", "Remote service has died: " + paramListenerRecord.componentName);
        }
        catch (RemoteException localRemoteException)
        {
          while (true)
            Log.w("NotifManCompat", "RemoteException communicating with " + paramListenerRecord.componentName, localRemoteException);
        }
      }
    }

    private void scheduleListenerRetry(ListenerRecord paramListenerRecord)
    {
      if (mHandler.hasMessages(3, paramListenerRecord.componentName))
        return;
      paramListenerRecord.retryCount += 1;
      if (paramListenerRecord.retryCount > 6)
      {
        Log.w("NotifManCompat", "Giving up on delivering " + paramListenerRecord.taskQueue.size() + " tasks to " + paramListenerRecord.componentName + " after " + paramListenerRecord.retryCount + " retries");
        paramListenerRecord.taskQueue.clear();
        return;
      }
      int i = (1 << paramListenerRecord.retryCount - 1) * 1000;
      if (Log.isLoggable("NotifManCompat", 3))
        Log.d("NotifManCompat", "Scheduling retry for " + i + " ms");
      paramListenerRecord = mHandler.obtainMessage(3, paramListenerRecord.componentName);
      mHandler.sendMessageDelayed(paramListenerRecord, i);
    }

    private void updateListenerMap()
    {
      Object localObject1 = NotificationManagerCompat.getEnabledListenerPackages(mContext);
      if (((Set)localObject1).equals(mCachedEnabledPackages));
      while (true)
      {
        return;
        mCachedEnabledPackages = ((Set)localObject1);
        Object localObject2 = mContext.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 4);
        HashSet localHashSet = new HashSet();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          ResolveInfo localResolveInfo = (ResolveInfo)((Iterator)localObject2).next();
          if (((Set)localObject1).contains(localResolveInfo.serviceInfo.packageName))
          {
            ComponentName localComponentName = new ComponentName(localResolveInfo.serviceInfo.packageName, localResolveInfo.serviceInfo.name);
            if (localResolveInfo.serviceInfo.permission != null)
              Log.w("NotifManCompat", "Permission present on component " + localComponentName + ", not adding listener record.");
            else
              localHashSet.add(localComponentName);
          }
        }
        localObject1 = localHashSet.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ComponentName)((Iterator)localObject1).next();
          if (!mRecordMap.containsKey(localObject2))
          {
            if (Log.isLoggable("NotifManCompat", 3))
              Log.d("NotifManCompat", "Adding listener record for " + localObject2);
            mRecordMap.put(localObject2, new ListenerRecord((ComponentName)localObject2));
          }
        }
        localObject1 = mRecordMap.entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Map.Entry)((Iterator)localObject1).next();
          if (!localHashSet.contains(((Map.Entry)localObject2).getKey()))
          {
            if (Log.isLoggable("NotifManCompat", 3))
              Log.d("NotifManCompat", "Removing listener record for " + ((Map.Entry)localObject2).getKey());
            ensureServiceUnbound((ListenerRecord)((Map.Entry)localObject2).getValue());
            ((Iterator)localObject1).remove();
          }
        }
      }
    }

    public boolean handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default:
        return false;
      case 0:
        handleQueueTask((NotificationManagerCompat.Task)paramMessage.obj);
        return true;
      case 1:
        paramMessage = (NotificationManagerCompat.ServiceConnectedEvent)paramMessage.obj;
        handleServiceConnected(paramMessage.componentName, paramMessage.iBinder);
        return true;
      case 2:
        handleServiceDisconnected((ComponentName)paramMessage.obj);
        return true;
      case 3:
      }
      handleRetryListenerQueue((ComponentName)paramMessage.obj);
      return true;
    }

    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      if (Log.isLoggable("NotifManCompat", 3))
        Log.d("NotifManCompat", "Connected to service " + paramComponentName);
      mHandler.obtainMessage(1, new NotificationManagerCompat.ServiceConnectedEvent(paramComponentName, paramIBinder)).sendToTarget();
    }

    public void onServiceDisconnected(ComponentName paramComponentName)
    {
      if (Log.isLoggable("NotifManCompat", 3))
        Log.d("NotifManCompat", "Disconnected from service " + paramComponentName);
      mHandler.obtainMessage(2, paramComponentName).sendToTarget();
    }

    public void queueTask(NotificationManagerCompat.Task paramTask)
    {
      mHandler.obtainMessage(0, paramTask).sendToTarget();
    }

    private static class ListenerRecord
    {
      public boolean bound = false;
      public final ComponentName componentName;
      public int retryCount = 0;
      public INotificationSideChannel service;
      public LinkedList<NotificationManagerCompat.Task> taskQueue = new LinkedList();

      public ListenerRecord(ComponentName paramComponentName)
      {
        componentName = paramComponentName;
      }
    }
  }

  private static abstract interface Task
  {
    public abstract void send(INotificationSideChannel paramINotificationSideChannel)
      throws RemoteException;
  }
}