package com.google.android.keep.microapp;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.SystemClock;
import android.support.v4.app.TaskStackBuilder;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveFile.InitializeRealtimeDocumentListener;
import com.google.android.gms.drive.DriveFile.RealtimeLoadResult;
import com.google.android.gms.drive.realtime.Model;
import com.google.android.gms.drive.realtime.RealtimeDocument;
import com.google.android.gms.reminders.model.DateTime;
import com.google.android.gms.reminders.model.DateTime.Builder;
import com.google.android.gms.reminders.model.Task;
import com.google.android.gms.reminders.model.Task.Builder;
import com.google.android.gms.reminders.model.TaskId;
import com.google.android.gms.reminders.model.TaskId.Builder;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataMap;
import com.google.android.gms.wearable.DataMapItem;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.MessageApi.SendMessageResult;
import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.Wearable;
import com.google.android.gms.wearable.WearableListenerService;
import com.google.android.keep.D;
import com.google.android.keep.E;
import com.google.android.keep.F;
import com.google.android.keep.G;
import com.google.android.keep.H;
import com.google.android.keep.J;
import com.google.android.keep.L;
import com.google.android.keep.N;
import com.google.android.keep.R;
import com.google.android.keep.V;
import com.google.android.keep.activities.BrowseActivity;
import com.google.android.keep.activities.KeepApplication;
import com.google.android.keep.model.TreeEntity.TreeEntityType;
import com.google.android.keep.model.m;
import com.google.android.keep.provider.KeepProvider;
import com.google.android.keep.provider.i.m;
import com.google.android.keep.provider.i.v;
import com.google.android.keep.task.TaskHelper;
import com.google.android.keep.task.TreeEntityTask;
import com.google.android.keep.task.TreeEntityTask.a;
import com.google.android.keep.util.A;
import com.google.android.keep.util.KeepTime;
import com.google.android.keep.util.o;
import com.google.android.keep.util.r;
import com.google.android.keep.util.w;
import com.google.android.keep.util.x;
import com.google.caribou.tasks.KeepExtension;
import com.google.caribou.tasks.TaskExtensions;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class WearableService extends WearableListenerService
{
  public static int tL = 320;
  public static int tM = 320;
  private final DriveFile.InitializeRealtimeDocumentListener tN = new DriveFile.InitializeRealtimeDocumentListener()
  {
    public void onInitialize(Model paramAnonymousModel)
    {
    }
  };

  private void A(String paramString)
  {
    GoogleApiClient localGoogleApiClient = V.A(this);
    ConnectionResult localConnectionResult = localGoogleApiClient.blockingConnect(5000L, TimeUnit.MILLISECONDS);
    if (!localGoogleApiClient.isConnected())
    {
      Log.w("KeepWearable", "Failed to connect to google api client " + localConnectionResult.getErrorCode());
      return;
    }
    try
    {
      paramString = (DataApi.DataItemResult)Wearable.DataApi.getDataItem(localGoogleApiClient, R.i(paramString, "/keep/watch_params")).await(5000L, TimeUnit.MILLISECONDS);
      if ((!paramString.getStatus().isSuccess()) || (paramString.getDataItem() == null))
      {
        Log.w("KeepWearable", "Failed to get watch parameters: " + paramString.getStatus().getStatusCode());
        return;
      }
      a(DataMapItem.fromDataItem(paramString.getDataItem()).getDataMap());
      return;
    }
    finally
    {
      localGoogleApiClient.disconnect();
    }
    throw paramString;
  }

  private void B(String paramString)
  {
    long l = D(paramString);
    if (l == -1L)
      return;
    TaskHelper.h(this, l);
  }

  private void C(String paramString)
  {
    long l = D(paramString);
    if (l == -1L);
    do
    {
      return;
      paramString = b("tree_entity._id=?", new String[] { String.valueOf(l) });
      if (TextUtils.isEmpty(paramString))
        break;
      paramString = KeepApplication.d(paramString);
    }
    while (KeepApplication.av().get(paramString) != null);
    paramString = new Intent(this, BrowseActivity.class);
    paramString.setAction("android.intent.action.VIEW");
    paramString.putExtra("treeEntityId", l);
    TaskStackBuilder.create(this).addNextIntent(paramString).startActivities();
  }

  private long D(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return -1L;
    paramString = paramString.split("/");
    return Long.parseLong(paramString[(paramString.length - 1)]);
  }

  private long a(String paramString, byte[] paramArrayOfByte)
  {
    long l = D(paramString);
    if ((l == -1L) || (paramArrayOfByte == null))
      return -1L;
    Object localObject = b("tree_entity._id=?", new String[] { String.valueOf(l) });
    paramString = KeepProvider.kw();
    paramArrayOfByte = new String(paramArrayOfByte);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      com.google.android.keep.model.j localj = o.O(this);
      if (localj == null)
        return -1L;
      a(new a(this, localj, paramString, paramArrayOfByte, false), (String)localObject);
    }
    localObject = new ContentValues();
    ((ContentValues)localObject).put("list_parent_id", Long.valueOf(l));
    ((ContentValues)localObject).put("text", paramArrayOfByte);
    ((ContentValues)localObject).put("is_checked", Integer.valueOf(0));
    ((ContentValues)localObject).put("uuid", paramString);
    getContentResolver().insert(i.m.CONTENT_URI, (ContentValues)localObject);
    return l;
  }

  private DateTime a(H paramH)
  {
    KeepTime localKeepTime = new KeepTime();
    DateTime.Builder localBuilder = new DateTime.Builder();
    if ((paramH.ui >= 1) && (paramH.ui <= 4))
      localBuilder.setPeriod(Integer.valueOf(paramH.ui));
    localBuilder.setDay(Integer.valueOf(localKeepTime.monthDay + paramH.uh));
    localBuilder.setYear(Integer.valueOf(localKeepTime.year));
    localBuilder.setMonth(Integer.valueOf(localKeepTime.month + 1));
    return localBuilder.build();
  }

  // ERROR //
  private void a(Uri paramUri, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokestatic 354	com/google/android/keep/D:c	([B)Lcom/google/android/keep/D;
    //   4: astore_3
    //   5: aload_3
    //   6: getfield 358	com/google/android/keep/D:tT	J
    //   9: ldc2_w 151
    //   12: lcmp
    //   13: ifne +53 -> 66
    //   16: ldc 55
    //   18: new 57	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   25: ldc_w 360
    //   28: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: aload_3
    //   32: invokevirtual 363	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: iconst_0
    //   39: anewarray 365	java/lang/Object
    //   42: invokestatic 371	com/google/android/keep/util/r:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   45: pop
    //   46: return
    //   47: astore_1
    //   48: ldc 55
    //   50: ldc_w 373
    //   53: iconst_1
    //   54: anewarray 365	java/lang/Object
    //   57: dup
    //   58: iconst_0
    //   59: aload_1
    //   60: aastore
    //   61: invokestatic 371	com/google/android/keep/util/r:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   64: pop
    //   65: return
    //   66: aload_0
    //   67: invokestatic 35	com/google/android/keep/V:A	(Landroid/content/Context;)Lcom/google/android/gms/common/api/GoogleApiClient;
    //   70: astore_2
    //   71: aload_2
    //   72: ldc2_w 36
    //   75: getstatic 43	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   78: invokeinterface 49 4 0
    //   83: astore 4
    //   85: aload_2
    //   86: invokeinterface 53 1 0
    //   91: ifne +34 -> 125
    //   94: ldc 55
    //   96: new 57	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   103: ldc_w 375
    //   106: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload 4
    //   111: invokevirtual 70	com/google/android/gms/common/ConnectionResult:getErrorCode	()I
    //   114: invokevirtual 73	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   117: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 83	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   123: pop
    //   124: return
    //   125: aload_0
    //   126: aload_3
    //   127: invokespecial 378	com/google/android/keep/microapp/WearableService:a	(Lcom/google/android/keep/D;)V
    //   130: getstatic 89	com/google/android/gms/wearable/Wearable:DataApi	Lcom/google/android/gms/wearable/DataApi;
    //   133: aload_2
    //   134: aload_1
    //   135: invokeinterface 381 3 0
    //   140: pop
    //   141: aload_2
    //   142: invokeinterface 131 1 0
    //   147: return
    //   148: astore_3
    //   149: getstatic 89	com/google/android/gms/wearable/Wearable:DataApi	Lcom/google/android/gms/wearable/DataApi;
    //   152: aload_2
    //   153: aload_1
    //   154: invokeinterface 381 3 0
    //   159: pop
    //   160: aload_3
    //   161: athrow
    //   162: astore_1
    //   163: aload_2
    //   164: invokeinterface 131 1 0
    //   169: aload_1
    //   170: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   0	5	47	com/google/protobuf/nano/InvalidProtocolBufferNanoException
    //   125	130	148	finally
    //   130	141	162	finally
    //   149	162	162	finally
  }

  private void a(GoogleApiClient paramGoogleApiClient, long paramLong)
  {
    G localG = e.a(this, paramLong);
    if (localG != null)
    {
      PutDataRequest localPutDataRequest = PutDataRequest.create("/keep/load_single_note");
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(localG);
      d.a(this, localPutDataRequest, localArrayList);
      localPutDataRequest.setData(G.toByteArray(localG));
      if (!((DataApi.DataItemResult)Wearable.DataApi.putDataItem(paramGoogleApiClient, localPutDataRequest).await(5000L, TimeUnit.MILLISECONDS)).getStatus().isSuccess())
        r.e("KeepWearable", "Failed to put data item for /keep/load_single_note", new Object[0]);
    }
  }

  private void a(GoogleApiClient paramGoogleApiClient, MessageEvent paramMessageEvent)
  {
    com.google.android.keep.model.j localj = o.O(this);
    if (localj == null)
    {
      a(paramGoogleApiClient, paramMessageEvent.getSourceNodeId());
      return;
    }
    try
    {
      paramMessageEvent = E.d(paramMessageEvent.getData());
      if ((TextUtils.isEmpty(paramMessageEvent.text)) && (TextUtils.isEmpty(paramMessageEvent.tV)))
      {
        Log.w("KeepWearable", "No text for the new note");
        return;
      }
    }
    catch (InvalidProtocolBufferNanoException paramGoogleApiClient)
    {
      r.e("KeepWearable", "Invalid data for creating note", new Object[0]);
      return;
    }
    if (!TextUtils.isEmpty(paramMessageEvent.text))
    {
      paramGoogleApiClient = TreeEntity.TreeEntityType.zO;
      if (paramGoogleApiClient != TreeEntity.TreeEntityType.zP)
        break label157;
    }
    label157: for (paramMessageEvent = paramMessageEvent.tV; ; paramMessageEvent = paramMessageEvent.text)
    {
      new TreeEntityTask.a(this).o(Long.valueOf(localj.getId())).i(paramGoogleApiClient).a(new m(paramMessageEvent, false, KeepProvider.kw())).lG().execute(new Void[0]);
      return;
      paramGoogleApiClient = TreeEntity.TreeEntityType.zP;
      break;
    }
  }

  private void a(GoogleApiClient paramGoogleApiClient, H paramH)
  {
    r.c("KeepWearable", "Adding reminder", new Object[0]);
    if (!TextUtils.isEmpty(paramH.serverId));
    TaskExtensions localTaskExtensions;
    Object localObject2;
    for (Object localObject1 = w.bD(paramH.serverId); ; localObject1 = w.bE(paramH.mT))
    {
      localObject1 = new TaskId.Builder().setClientAssignedId((String)localObject1).build();
      localTaskExtensions = new TaskExtensions();
      localTaskExtensions.keepExtension = new KeepExtension();
      localTaskExtensions.keepExtension.serverNoteId = com.google.android.keep.util.e.bv(paramH.serverId);
      localTaskExtensions.keepExtension.clientNoteId = com.google.android.keep.util.e.bv(paramH.mT);
      localObject2 = new m[paramH.uj.ud.length];
      int i = 0;
      while (i < localObject2.length)
      {
        localObject3 = paramH.uj.ud[i];
        localObject2[i] = new m(((F)localObject3).text, ((F)localObject3).tU, ((F)localObject3).mT);
        i += 1;
      }
    }
    Object localObject3 = paramH.uj.title;
    TreeEntity.TreeEntityType localTreeEntityType = TreeEntity.TreeEntityType.bn(paramH.uj.type);
    if (paramH.uj.ue.length > 0);
    for (boolean bool = true; ; bool = false)
    {
      localObject2 = x.a(this, (String)localObject3, localTreeEntityType, (m[])localObject2, bool, false);
      J.a(paramGoogleApiClient, N.jH().setTaskId((TaskId)localObject1).setExtensions(TaskExtensions.toByteArray(localTaskExtensions)).setTitle((String)localObject2).setDueDate(a(paramH)).build(), null);
      return;
    }
  }

  private static void a(GoogleApiClient paramGoogleApiClient, String paramString)
  {
    if (!((MessageApi.SendMessageResult)Wearable.MessageApi.sendMessage(paramGoogleApiClient, paramString, "/keep/no_account_set_warning", null).await(5000L, TimeUnit.MILLISECONDS)).getStatus().isSuccess())
      Log.e("KeepWearable", "Failed to send no account set warning");
  }

  private void a(GoogleApiClient paramGoogleApiClient, byte[] paramArrayOfByte)
  {
    int i = 1;
    try
    {
      paramArrayOfByte = H.e(paramArrayOfByte);
      r.c("KeepWearable", "Setting reminder serverId=%s, reminderId=%s, op=%d, dayOffset=%d, timePeriod=%d", new Object[] { paramArrayOfByte.serverId, paramArrayOfByte.uf, Integer.valueOf(paramArrayOfByte.ug), Integer.valueOf(paramArrayOfByte.uh), Integer.valueOf(paramArrayOfByte.ui) });
      localObject = o.O(this);
      if (localObject == null)
      {
        Log.w("KeepWearable", "No account");
        return;
      }
    }
    catch (InvalidProtocolBufferNanoException paramGoogleApiClient)
    {
      Log.w("KeepWearable", "Failed parsing SetReminderOp");
      return;
    }
    Object localObject = ((com.google.android.keep.model.j)localObject).getName();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      Log.w("KeepWearable", "Not setting reminder - no account name");
      return;
    }
    localObject = com.google.android.keep.util.j.j(this, (String)localObject).build();
    if (!com.google.android.keep.util.j.f((GoogleApiClient)localObject))
    {
      Log.w("KeepWearable", "Not setting reminder - can't connect");
      return;
    }
    while (true)
    {
      try
      {
        if (paramArrayOfByte.uj.ua != -1);
        switch (paramArrayOfByte.ug)
        {
        case 2:
          Log.w("KeepWearable", "Unknown reminder operation: " + paramArrayOfByte);
          return;
          i = 0;
          continue;
          if (i != 0)
          {
            c((GoogleApiClient)localObject, paramArrayOfByte);
            continue;
          }
          break;
        case 1:
        }
      }
      finally
      {
        com.google.android.keep.util.j.e((GoogleApiClient)localObject);
      }
      Log.w("KeepWearable", "No reminder so delete skipped");
      continue;
      if (i != 0)
        b((GoogleApiClient)localObject, paramArrayOfByte);
      while (true)
      {
        a(paramGoogleApiClient, paramArrayOfByte.uj.id);
        break;
        a((GoogleApiClient)localObject, paramArrayOfByte);
      }
    }
  }

  private void a(DataMap paramDataMap)
  {
    tL = paramDataMap.getInt("display_width_px", 320);
    tM = paramDataMap.getInt("display_height_px", 320);
  }

  private void a(D paramD)
  {
    int i = 1;
    Object localObject = e.b(this, paramD.tT);
    if ((localObject != null) && (a((F)localObject, paramD)))
    {
      long l = Binder.clearCallingIdentity();
      localObject = b("tree_entity._id IN (SELECT DISTINCT list_item.list_parent_id FROM list_item WHERE list_item._id=?)", new String[] { String.valueOf(paramD.tT) });
      try
      {
        if (!TextUtils.isEmpty((CharSequence)localObject))
          a(new c(paramD.mT, paramD.tU), (String)localObject);
        localObject = new ContentValues();
        if (paramD.tU);
        while (true)
        {
          ((ContentValues)localObject).put("is_checked", Integer.valueOf(i));
          getContentResolver().update(ContentUris.withAppendedId(i.m.CONTENT_URI, paramD.tT), (ContentValues)localObject, null, null);
          return;
          i = 0;
        }
      }
      finally
      {
        Binder.restoreCallingIdentity(l);
      }
    }
    Log.w("KeepWearable", String.format("CheckListItemOp is dropped=%d,%s,%d", new Object[] { Long.valueOf(paramD.tT), Boolean.valueOf(paramD.tU), Long.valueOf(paramD.timestamp) }));
  }

  private void a(final b paramb, final String paramString)
  {
    if (paramb == null)
      throw new IllegalArgumentException("Invalid arguments specified.");
    Object localObject1 = o.O(this);
    if (localObject1 == null)
      return;
    localObject1 = V.e(this, ((com.google.android.keep.model.j)localObject1).getName());
    Object localObject2 = ((GoogleApiClient)localObject1).blockingConnect(5000L, TimeUnit.MILLISECONDS);
    if (!((GoogleApiClient)localObject1).isConnected())
    {
      r.a("KeepWearable", "Connection failed: " + ((ConnectionResult)localObject2).getErrorCode(), new Object[0]);
      return;
    }
    try
    {
      localObject2 = new CountDownLatch(1);
      Drive.DriveApi.loadRealtimeDocumentFromResourceId((GoogleApiClient)localObject1, paramString, tN, null).setResultCallback(new ResultCallback()
      {
        public void a(DriveFile.RealtimeLoadResult paramAnonymousRealtimeLoadResult)
        {
          try
          {
            Status localStatus = paramAnonymousRealtimeLoadResult.getStatus();
            if (!localStatus.isSuccess())
            {
              r.a("KeepWearable", "Loading shared document failed: " + localStatus.getStatusCode(), new Object[0]);
              paramAnonymousRealtimeLoadResult = KeepApplication.d(paramString);
              paramAnonymousRealtimeLoadResult = (RealtimeDocument)KeepApplication.av().get(paramAnonymousRealtimeLoadResult);
              if (paramAnonymousRealtimeLoadResult == null)
                return;
            }
            for (int i = 0; ; i = 1)
            {
              paramb.a(paramAnonymousRealtimeLoadResult.getModel());
              if (i != 0)
                paramAnonymousRealtimeLoadResult.close();
              return;
              paramAnonymousRealtimeLoadResult = paramAnonymousRealtimeLoadResult.getRealtimeDocument();
            }
          }
          catch (Exception paramAnonymousRealtimeLoadResult)
          {
            throw new RuntimeException(paramAnonymousRealtimeLoadResult);
          }
          finally
          {
            tR.countDown();
          }
          throw paramAnonymousRealtimeLoadResult;
        }
      });
      try
      {
        ((CountDownLatch)localObject2).await(5000L, TimeUnit.MILLISECONDS);
        return;
      }
      catch (Exception paramb)
      {
        while (true)
          r.d("KeepWearable", "latch.await() threw exception. " + paramb.getMessage(), new Object[0]);
      }
    }
    finally
    {
      SystemClock.sleep(5000L);
      ((GoogleApiClient)localObject1).disconnect();
    }
    throw paramb;
  }

  private boolean a(F paramF, D paramD)
  {
    if (paramF.tU == paramD.tU);
    while (paramF.tX >= paramD.timestamp)
      return false;
    return true;
  }

  private String b(String paramString, String[] paramArrayOfString)
  {
    paramString = getContentResolver().query(i.v.CONTENT_URI, new String[] { "server_id", "realtime_data_server_version" }, paramString, paramArrayOfString, null);
    if (paramString == null)
      return null;
    try
    {
      boolean bool = paramString.moveToFirst();
      if (!bool)
        return null;
      paramArrayOfString = paramString.getString(0);
      if (!TextUtils.isEmpty(paramString.getString(1)))
      {
        bool = TextUtils.isEmpty(paramArrayOfString);
        if (!bool)
          return paramArrayOfString;
      }
      return null;
    }
    finally
    {
      paramString.close();
    }
    throw paramArrayOfString;
  }

  private void b(GoogleApiClient paramGoogleApiClient, H paramH)
  {
    r.c("KeepWearable", "Updating reminder", new Object[0]);
    Task localTask = L.c(paramGoogleApiClient, paramH.uf);
    if (localTask == null)
    {
      Log.w("KeepWearable", "Can't load reminder");
      return;
    }
    J.a(paramGoogleApiClient, N.a(localTask, a(paramH)).setRecurrenceInfo(null).build(), localTask);
  }

  private void c(GoogleApiClient paramGoogleApiClient, H paramH)
  {
    r.c("KeepWearable", "Deleting reminder", new Object[0]);
    paramH = L.c(paramGoogleApiClient, paramH.uf);
    if (paramH == null)
    {
      Log.w("KeepWearable", "Can't load reminder");
      return;
    }
    J.a(paramGoogleApiClient, paramH);
  }

  private void gg()
  {
    startActivity(new Intent(this, BrowseActivity.class).addFlags(268435456));
  }

  public void onDataChanged(DataEventBuffer paramDataEventBuffer)
  {
    paramDataEventBuffer = paramDataEventBuffer.iterator();
    while (paramDataEventBuffer.hasNext())
    {
      Object localObject = (DataEvent)paramDataEventBuffer.next();
      if (((DataEvent)localObject).getType() == 1)
      {
        localObject = ((DataEvent)localObject).getDataItem();
        String str = ((DataItem)localObject).getUri().getPath();
        if ("/keep/watch_params".equals(str))
          a(DataMapItem.fromDataItem((DataItem)localObject).getDataMap());
        else if (str.startsWith("/keep/check_list_item"))
          a(((DataItem)localObject).getUri(), ((DataItem)localObject).getData());
      }
    }
  }

  public void onMessageReceived(MessageEvent paramMessageEvent)
  {
    GoogleApiClient localGoogleApiClient = V.A(this);
    Object localObject = localGoogleApiClient.blockingConnect(5000L, TimeUnit.MILLISECONDS);
    if (!localGoogleApiClient.isConnected())
    {
      Log.w("KeepWearable", "GoogleApiClient failed to connect: " + ((ConnectionResult)localObject).getErrorCode());
      return;
    }
    long l1 = Binder.clearCallingIdentity();
    while (true)
    {
      try
      {
        localObject = paramMessageEvent.getPath();
        if (((String)localObject).equals("/keep/browse_notes"))
        {
          d.a(this, localGoogleApiClient);
          return;
        }
        if (((String)localObject).equals("/keep/create"))
        {
          a(localGoogleApiClient, paramMessageEvent);
          continue;
        }
      }
      finally
      {
        Binder.restoreCallingIdentity(l1);
        localGoogleApiClient.disconnect();
      }
      if (((String)localObject).startsWith("/keep/set_reminder"))
      {
        a(localGoogleApiClient, paramMessageEvent.getData());
      }
      else if (((String)localObject).startsWith("/keep/archive_note"))
      {
        B((String)localObject);
      }
      else if (((String)localObject).startsWith("/keep/add_list_item"))
      {
        long l2 = a((String)localObject, paramMessageEvent.getData());
        if (l2 != -1L)
          a(localGoogleApiClient, l2);
        else
          r.e("KeepWearable", "Invalid ID for loading tree entity!", new Object[0]);
      }
      else if (((String)localObject).startsWith("/keep/open_on_phone"))
      {
        C((String)localObject);
      }
      else if (((String)localObject).equals("/keep/open_app"))
      {
        gg();
      }
      else if ((((String)localObject).equals("/keep/load_notes")) && (A.ap(this)))
      {
        A.h(this, false);
        d.a(this, localGoogleApiClient);
      }
    }
  }

  public void onPeerConnected(Node paramNode)
  {
    A(paramNode.getId());
  }
}