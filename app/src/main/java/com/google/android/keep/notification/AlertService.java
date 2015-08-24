package com.google.android.keep.notification;

import android.app.IntentService;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingEvent;
import com.google.android.gms.reminders.Reminders;
import com.google.android.gms.reminders.RemindersApi;
import com.google.android.gms.reminders.RemindersApi.LoadRemindersResult;
import com.google.android.gms.reminders.model.RemindersBuffer;
import com.google.android.gms.reminders.model.Task;
import com.google.android.gms.reminders.model.TaskId;
import com.google.android.keep.I;
import com.google.android.keep.L;
import com.google.android.keep.activities.KeepApplication;
import com.google.android.keep.model.Alert;
import com.google.android.keep.util.Config;
import com.google.android.keep.util.KeepTime;
import com.google.android.keep.util.o;
import com.google.android.keep.util.r;
import com.google.android.keep.util.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AlertService extends IntentService
{
  private static final String Bl = AlertService.class.getSimpleName();
  private a Bm;
  private d Bn;
  private ContentResolver mContentResolver;
  private Context mContext;

  public AlertService()
  {
    super(Bl);
    mContext = this;
  }

  AlertService(Context paramContext, a parama, d paramd, ContentResolver paramContentResolver)
  {
    super(Bl);
    mContext = paramContext;
    Bm = parama;
    Bn = paramd;
    mContentResolver = paramContentResolver;
  }

  private void J(long paramLong)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(mContext, AlertReceiver.class);
    localIntent.setAction("com.google.android.keep.intent.action.REFRESH_NOTIFICATION");
    localIntent.putExtra("com.google.android.keep.intent.extra.start_timestamp", paramLong);
    new e(mContext).a(0, paramLong, localIntent);
  }

  private static List<String> a(GeofencingEvent paramGeofencingEvent)
  {
    List localList = paramGeofencingEvent.getTriggeringGeofences();
    ArrayList localArrayList = new ArrayList(localList.size());
    if ((localList == null) || (localList.size() == 0))
      r.e("KeepAlert", "Geofence intent has no geofences: " + paramGeofencingEvent.getErrorCode(), new Object[0]);
    while (true)
    {
      return localArrayList;
      paramGeofencingEvent = localList.iterator();
      while (paramGeofencingEvent.hasNext())
        localArrayList.add(((Geofence)paramGeofencingEvent.next()).getRequestId());
    }
  }

  private void h(Intent paramIntent)
  {
    String str = paramIntent.getAction();
    if (str == null);
    do
    {
      return;
      r.a("KeepAlert", "Action " + str, new Object[0]);
      long l2 = KeepTime.or();
      long l1 = l2 + 86400000L;
      if ("android.intent.action.BOOT_COMPLETED".equals(str))
      {
        ko();
        Bn.refresh();
        J(l1);
        return;
      }
      if ("com.google.android.location.internal.server.ACTION_RESTARTED".equals(str))
      {
        ko();
        Bn.bB(1);
        return;
      }
      if ("android.intent.action.TIME_SET".equals(str))
      {
        Bn.refresh();
        J(l1);
        return;
      }
      if ("android.intent.action.LOCALE_CHANGED".equals(str))
      {
        Bn.refresh();
        return;
      }
      if ("android.intent.action.MY_PACKAGE_REPLACED".equals(str))
      {
        ko();
        Bn.refresh();
        J(l1);
        return;
      }
      if ("com.google.android.keep.intent.action.POST_LOCATION_NOTIFICATION".equals(str))
      {
        i(paramIntent);
        return;
      }
      if ("android.net.wifi.WIFI_STATE_CHANGED".equals(str))
      {
        j(paramIntent);
        return;
      }
      if ("com.google.android.gsf.settings.GoogleLocationSettings.UPDATE_LOCATION_SETTINGS".equals(str))
      {
        kr();
        return;
      }
      if ("com.google.android.keep.intent.action.REFRESH_NOTIFICATION".equals(str))
      {
        long l3 = paramIntent.getLongExtra("com.google.android.keep.intent.extra.start_timestamp", l2);
        l1 = l3;
        if (l3 < l2)
          l1 = l2;
        Bn.refresh();
        J(l1 + 86400000L);
        return;
      }
    }
    while (!"com.google.android.keep.intent.action.PROVIDER_CHANGED".equals(str));
    Bn.refresh();
  }

  // ERROR //
  private void i(Intent paramIntent)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 214	com/google/android/gms/location/GeofencingEvent:fromIntent	(Landroid/content/Intent;)Lcom/google/android/gms/location/GeofencingEvent;
    //   4: astore 4
    //   6: aload 4
    //   8: invokevirtual 217	com/google/android/gms/location/GeofencingEvent:hasError	()Z
    //   11: ifeq +25 -> 36
    //   14: aload 4
    //   16: invokevirtual 103	com/google/android/gms/location/GeofencingEvent:getErrorCode	()I
    //   19: sipush 1000
    //   22: if_icmpne +14 -> 36
    //   25: aload_0
    //   26: getfield 36	com/google/android/keep/notification/AlertService:Bn	Lcom/google/android/keep/notification/d;
    //   29: iconst_1
    //   30: invokeinterface 220 2 0
    //   35: return
    //   36: aload 4
    //   38: invokestatic 222	com/google/android/keep/notification/AlertService:a	(Lcom/google/android/gms/location/GeofencingEvent;)Ljava/util/List;
    //   41: astore 4
    //   43: aload 4
    //   45: ifnonnull +16 -> 61
    //   48: ldc 91
    //   50: ldc 224
    //   52: iconst_0
    //   53: anewarray 111	java/lang/Object
    //   56: invokestatic 227	com/google/android/keep/util/r:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   59: pop
    //   60: return
    //   61: aload 4
    //   63: invokeinterface 121 1 0
    //   68: astore 4
    //   70: aload 4
    //   72: invokeinterface 127 1 0
    //   77: ifeq -42 -> 35
    //   80: aload 4
    //   82: invokeinterface 131 1 0
    //   87: checkcast 163	java/lang/String
    //   90: astore 5
    //   92: aload 5
    //   94: invokestatic 233	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   97: invokevirtual 236	java/lang/Long:longValue	()J
    //   100: lstore_2
    //   101: aload_0
    //   102: getfield 38	com/google/android/keep/notification/AlertService:mContentResolver	Landroid/content/ContentResolver;
    //   105: lload_2
    //   106: invokestatic 241	com/google/android/keep/model/Alert:a	(Landroid/content/ContentResolver;J)Landroid/database/Cursor;
    //   109: astore 7
    //   111: aload 7
    //   113: ifnull -43 -> 70
    //   116: aload 7
    //   118: iconst_1
    //   119: invokestatic 244	com/google/android/keep/model/Alert:a	(Landroid/database/Cursor;Z)Lcom/google/android/keep/model/Alert;
    //   122: astore 6
    //   124: aload 7
    //   126: invokeinterface 249 1 0
    //   131: aload 6
    //   133: invokevirtual 252	com/google/android/keep/model/Alert:gq	()Ljava/lang/String;
    //   136: astore 7
    //   138: aload 7
    //   140: invokestatic 258	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   143: ifeq +57 -> 200
    //   146: ldc 91
    //   148: ldc_w 260
    //   151: iconst_0
    //   152: anewarray 111	java/lang/Object
    //   155: invokestatic 227	com/google/android/keep/util/r:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   158: pop
    //   159: aload_0
    //   160: getfield 34	com/google/android/keep/notification/AlertService:Bm	Lcom/google/android/keep/notification/a;
    //   163: aload 5
    //   165: invokevirtual 266	com/google/android/keep/notification/a:az	(Ljava/lang/String;)I
    //   168: pop
    //   169: goto -99 -> 70
    //   172: astore 5
    //   174: ldc 91
    //   176: ldc_w 268
    //   179: iconst_0
    //   180: anewarray 111	java/lang/Object
    //   183: invokestatic 227	com/google/android/keep/util/r:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   186: pop
    //   187: goto -117 -> 70
    //   190: astore_1
    //   191: aload 7
    //   193: invokeinterface 249 1 0
    //   198: aload_1
    //   199: athrow
    //   200: aload_1
    //   201: ldc_w 270
    //   204: ldc2_w 271
    //   207: invokevirtual 206	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   210: lstore_2
    //   211: lload_2
    //   212: ldc2_w 271
    //   215: lcmp
    //   216: ifne +19 -> 235
    //   219: ldc 91
    //   221: ldc_w 274
    //   224: iconst_0
    //   225: anewarray 111	java/lang/Object
    //   228: invokestatic 227	com/google/android/keep/util/r:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   231: pop
    //   232: goto -162 -> 70
    //   235: aload 7
    //   237: invokestatic 280	com/google/android/keep/util/w:bF	(Ljava/lang/String;)Lcom/google/android/keep/util/w$a;
    //   240: astore 7
    //   242: aload_0
    //   243: invokevirtual 284	com/google/android/keep/notification/AlertService:getApplicationContext	()Landroid/content/Context;
    //   246: lload_2
    //   247: aload 7
    //   249: invokestatic 289	com/google/android/keep/util/F:a	(Landroid/content/Context;JLcom/google/android/keep/util/w$a;)Lcom/google/android/keep/model/TreeEntity;
    //   252: astore 7
    //   254: aload 7
    //   256: ifnonnull +29 -> 285
    //   259: ldc 91
    //   261: ldc_w 291
    //   264: iconst_0
    //   265: anewarray 111	java/lang/Object
    //   268: invokestatic 227	com/google/android/keep/util/r:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   271: pop
    //   272: aload_0
    //   273: getfield 34	com/google/android/keep/notification/AlertService:Bm	Lcom/google/android/keep/notification/a;
    //   276: aload 5
    //   278: invokevirtual 266	com/google/android/keep/notification/a:az	(Ljava/lang/String;)I
    //   281: pop
    //   282: goto -212 -> 70
    //   285: aload 6
    //   287: invokevirtual 294	com/google/android/keep/model/Alert:getState	()I
    //   290: iconst_4
    //   291: if_icmpne +42 -> 333
    //   294: aload_0
    //   295: aload 6
    //   297: iconst_0
    //   298: invokestatic 299	com/google/android/keep/I:a	(Landroid/content/Context;Lcom/google/android/keep/model/Alert;I)V
    //   301: invokestatic 304	java/lang/System:currentTimeMillis	()J
    //   304: aload 6
    //   306: invokevirtual 307	com/google/android/keep/model/Alert:gr	()J
    //   309: lsub
    //   310: ldc2_w 308
    //   313: lcmp
    //   314: ifge +19 -> 333
    //   317: ldc 91
    //   319: ldc_w 311
    //   322: iconst_0
    //   323: anewarray 111	java/lang/Object
    //   326: invokestatic 151	com/google/android/keep/util/r:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   329: pop
    //   330: goto -260 -> 70
    //   333: aload_0
    //   334: getfield 31	com/google/android/keep/notification/AlertService:mContext	Landroid/content/Context;
    //   337: aload 7
    //   339: invokeinterface 316 1 0
    //   344: invokestatic 322	com/google/android/keep/util/o:k	(Landroid/content/Context;J)Lcom/google/android/keep/model/j;
    //   347: astore 6
    //   349: new 324	com/google/android/keep/model/A
    //   352: dup
    //   353: invokespecial 325	com/google/android/keep/model/A:<init>	()V
    //   356: astore 8
    //   358: aload 8
    //   360: aload_0
    //   361: getfield 31	com/google/android/keep/notification/AlertService:mContext	Landroid/content/Context;
    //   364: aload 6
    //   366: invokevirtual 328	com/google/android/keep/model/A:d	(Landroid/content/Context;Lcom/google/android/keep/model/j;)V
    //   369: aload 8
    //   371: aload 7
    //   373: invokevirtual 332	com/google/android/keep/model/A:b	(Lcom/google/android/keep/model/TreeEntity;)Lcom/google/android/gms/reminders/model/Task;
    //   376: astore 7
    //   378: aload 7
    //   380: ifnull +19 -> 399
    //   383: aload_0
    //   384: getfield 36	com/google/android/keep/notification/AlertService:Bn	Lcom/google/android/keep/notification/d;
    //   387: aload 6
    //   389: invokevirtual 337	com/google/android/keep/model/j:getId	()J
    //   392: aload 7
    //   394: invokeinterface 340 4 0
    //   399: aload_0
    //   400: getfield 34	com/google/android/keep/notification/AlertService:Bm	Lcom/google/android/keep/notification/a;
    //   403: aload 5
    //   405: invokevirtual 266	com/google/android/keep/notification/a:az	(Ljava/lang/String;)I
    //   408: pop
    //   409: goto -339 -> 70
    //
    // Exception table:
    //   from	to	target	type
    //   92	101	172	java/lang/NumberFormatException
    //   116	124	190	finally
  }

  private void j(Intent paramIntent)
  {
    if ((KeepApplication.a(mContext)) || (KeepApplication.a(mContentResolver)))
      Bn.bB(3);
    int i;
    do
    {
      do
      {
        return;
        i = paramIntent.getIntExtra("wifi_state", -1);
        if ((i != 1) || (com.google.android.keep.util.A.Z(mContext) >= Config.nQ()) || (com.google.android.keep.util.A.aa(mContext)))
          break;
      }
      while (!kp());
      Bn.bA(3);
      return;
    }
    while (i != 3);
    Bn.bB(3);
  }

  private boolean kp()
  {
    Iterator localIterator = o.R(this).iterator();
    while (localIterator.hasNext())
    {
      GoogleApiClient localGoogleApiClient = com.google.android.keep.util.j.j(this, ((com.google.android.keep.model.j)localIterator.next()).getName()).build();
      if (com.google.android.keep.util.j.f(localGoogleApiClient))
        try
        {
          localObject3 = (RemindersApi.LoadRemindersResult)com.google.android.keep.util.j.b(Reminders.RemindersApi.loadReminders(localGoogleApiClient, L.jG()));
          if (((RemindersApi.LoadRemindersResult)localObject3).getStatus().isSuccess())
            localObject3 = ((RemindersApi.LoadRemindersResult)localObject3).getRemindersBuffer();
        }
        finally
        {
          try
          {
            int i = ((RemindersBuffer)localObject3).getCount();
            if (i > 0)
            {
              ((RemindersBuffer)localObject3).release();
              return true;
            }
            ((RemindersBuffer)localObject3).release();
            com.google.android.keep.util.j.e(localGoogleApiClient);
          }
          finally
          {
            Object localObject3;
            ((RemindersBuffer)localObject3).release();
          }
          com.google.android.keep.util.j.e(localGoogleApiClient);
        }
    }
    return false;
  }

  private void kq()
  {
    if (KeepApplication.a(mContentResolver))
    {
      Bn.bB(1);
      Bn.bB(2);
      Bn.bB(3);
    }
    do
    {
      return;
      if ((!((WifiManager)getSystemService("wifi")).isWifiEnabled()) && (!KeepApplication.a(mContext)) && (!com.google.android.keep.util.A.aa(mContext)))
        Bn.bA(3);
    }
    while (com.google.android.keep.location.a.o(mContext));
    Bn.bA(2);
  }

  private void kr()
  {
    if (com.google.android.keep.location.a.o(mContext))
    {
      ko();
      Bn.bB(2);
    }
    do
    {
      return;
      Iterator localIterator = o.R(mContext).iterator();
      while (localIterator.hasNext())
      {
        com.google.android.keep.model.j localj = (com.google.android.keep.model.j)localIterator.next();
        Bm.a(b.c(mContext, localj.getId()));
      }
    }
    while (!kp());
    Bn.bA(2);
  }

  void ko()
  {
    Iterator localIterator = o.R(mContext).iterator();
    while (localIterator.hasNext())
    {
      com.google.android.keep.model.j localj = (com.google.android.keep.model.j)localIterator.next();
      Object localObject = new com.google.android.keep.model.A();
      ((com.google.android.keep.model.A)localObject).a(mContext, localj, L.jG());
      localObject = ((com.google.android.keep.model.A)localObject).jb().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Task localTask = (Task)((Iterator)localObject).next();
        if ((w.m(localTask)) && (I.a(mContext, localTask.getTaskId().getClientAssignedId()).getState() != 1))
        {
          b.a(mContext, localj, Bm, Bn, localTask);
          kq();
        }
      }
    }
  }

  public void onCreate()
  {
    super.onCreate();
    mContext = this;
    Bm = new f(this);
    Bn = new g(this);
    mContentResolver = getContentResolver();
  }

  protected void onHandleIntent(Intent paramIntent)
  {
    try
    {
      h(paramIntent);
      return;
    }
    finally
    {
      AlertReceiver.completeWakefulIntent(paramIntent);
    }
  }
}