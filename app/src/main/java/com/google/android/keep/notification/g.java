package com.google.android.keep.notification;

import android.app.Notification;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.app.NotificationManagerCompat;
import android.text.TextUtils;
import com.google.android.gms.reminders.LoadRemindersOptions;
import com.google.android.gms.reminders.LoadRemindersOptions.Builder;
import com.google.android.gms.reminders.model.Task;
import com.google.android.gms.reminders.model.TaskId;
import com.google.android.keep.I;
import com.google.android.keep.activities.BrowseActivity;
import com.google.android.keep.activities.KeepApplication;
import com.google.android.keep.model.A;
import com.google.android.keep.model.Alert;
import com.google.android.keep.model.BaseReminder;
import com.google.android.keep.model.Note;
import com.google.android.keep.model.TreeEntity;
import com.google.android.keep.model.j;
import com.google.android.keep.provider.i.c;
import com.google.android.keep.provider.i.f;
import com.google.android.keep.provider.i.v;
import com.google.android.keep.util.F;
import com.google.android.keep.util.KeepTime;
import com.google.android.keep.util.h;
import com.google.android.keep.util.o;
import com.google.android.keep.util.r;
import com.google.android.keep.util.w;
import com.google.android.keep.util.w.a;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class g
  implements d
{
  static int BC = 4;
  private final NotificationManagerCompat BA;
  private final c BB;
  private final A fi;
  private final Context mContext;

  public g(Context paramContext)
  {
    this(paramContext, NotificationManagerCompat.from(paramContext), c.ks(), new A());
  }

  g(Context paramContext, NotificationManagerCompat paramNotificationManagerCompat, c paramc, A paramA)
  {
    mContext = paramContext;
    BA = paramNotificationManagerCompat;
    BB = paramc;
    fi = paramA;
  }

  static int L(long paramLong)
  {
    return (int)paramLong * 20;
  }

  private void a(ContentResolver paramContentResolver, long paramLong, int paramInt)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("state", Integer.valueOf(paramInt));
    paramContentResolver.update(ContentUris.withAppendedId(i.c.CONTENT_URI, paramLong), localContentValues, null, null);
  }

  private void a(ContentResolver paramContentResolver, Map<Long, a> paramMap, long paramLong1, long paramLong2, String paramString, long paramLong3, boolean paramBoolean)
  {
    paramMap = (a)paramMap.put(Long.valueOf(paramLong1), new a(paramLong2, paramString, paramLong3, paramBoolean));
    if ((paramMap != null) && (paramMap.BF != paramLong2))
      a(paramContentResolver, paramMap.BF, 3);
  }

  private void a(List<Note> paramList, Map<Long, a> paramMap, long paramLong1, long paramLong2)
  {
    Object localObject1 = o.k(mContext, paramLong1);
    if (localObject1 == null);
    while (true)
    {
      return;
      int n = paramList.size();
      if (n > BC)
        i = n;
      int k;
      int j;
      label195: 
      while (true)
      {
        k = L(paramLong1);
        if (i <= 0)
          break label369;
        localObject2 = Lists.newArrayList();
        bool = true;
        j = 0;
        while (j < i)
        {
          locala = (a)paramMap.get(Long.valueOf(((Note)paramList.get(j)).getId()));
          ((List)localObject2).add(Long.valueOf(locala.BF));
          if (locala.BH)
            bool = false;
          j += 1;
        }
        i = 0;
        while (true)
        {
          if ((i >= n) || (paramLong2 <= ((a)paramMap.get(Long.valueOf(((Note)paramList.get(i)).getId()))).BG))
          {
            if (i != 1)
              break label195;
            i = 0;
            break;
          }
          i += 1;
        }
      }
      paramLong2 = ((a)paramMap.get(Long.valueOf(((Note)paramList.get(i - 1)).getId()))).BG;
      Object localObject2 = BB.a(mContext, k, paramList.subList(0, i), (List)localObject2, paramLong2, bool);
      BA.notify(k, (Notification)localObject2);
      int i1;
      while (true)
      {
        k = b(paramLong1, 1);
        i1 = BC;
        j = k;
        if (i >= n)
          break label606;
        localObject2 = new ArrayList(n - i);
        j = i;
        while (j < n)
        {
          ((List)localObject2).add(w.bG(((a)paramMap.get(Long.valueOf(((Note)paramList.get(j)).getId()))).op));
          j += 1;
        }
        label369: BA.cancel(k);
      }
      localObject2 = new LoadRemindersOptions.Builder().setTaskIds((TaskId[])((List)localObject2).toArray(new TaskId[((List)localObject2).size()])).build();
      fi.a(mContext, (j)localObject1, (LoadRemindersOptions)localObject2);
      int m = i;
      for (int i = k; ; i = j)
      {
        j = i;
        if (m >= n)
          break label606;
        localObject1 = (Note)paramList.get(m);
        localObject2 = fi.c((Note)localObject1);
        if (localObject2 != null)
          break;
        j = i;
        m += 1;
      }
      a locala = (a)paramMap.get(Long.valueOf(((Note)localObject1).getId()));
      c localc = BB;
      Context localContext = mContext;
      paramLong1 = locala.BF;
      paramLong2 = locala.BG;
      if (!locala.BH);
      for (boolean bool = true; ; bool = false)
      {
        localObject1 = localc.a(localContext, i, (Note)localObject1, (BaseReminder)localObject2, paramLong1, paramLong2, bool);
        j = i;
        if (localObject1 == null)
          break;
        BA.notify(i, (Notification)localObject1);
        j = i + 1;
        break;
      }
      label606: 
      while (j < k + i1)
      {
        BA.cancel(j);
        j += 1;
      }
    }
  }

  private void a(final Map<Long, a> paramMap)
  {
    Object localObject = TextUtils.join(",", paramMap.keySet());
    localObject = mContext.getContentResolver().query(i.f.Cm, Note.COLUMNS, "tree_entity._id IN (" + (String)localObject + ")" + " AND " + "is_trashed" + "=0", null, null);
    while (true)
    {
      int j;
      try
      {
        List localList = Note.q((Cursor)localObject);
        ((Cursor)localObject).close();
        Collections.sort(localList, new Comparator()
        {
          public int a(Note paramAnonymousNote1, Note paramAnonymousNote2)
          {
            if (paramAnonymousNote1.getId() == paramAnonymousNote2.getId())
              return 0;
            if (paramAnonymousNote1.gp() != paramAnonymousNote2.gp())
              return Long.signum(paramAnonymousNote1.gp() - paramAnonymousNote2.gp());
            return Long.signum(((g.a)paramMap.get(Long.valueOf(paramAnonymousNote1.getId()))).BG - ((g.a)paramMap.get(Long.valueOf(paramAnonymousNote2.getId()))).BG);
          }
        });
        long l1 = KeepTime.or();
        int k = localList.size();
        int i = 0;
        localObject = o.R(mContext).iterator();
        if (!((Iterator)localObject).hasNext())
          break;
        long l2 = ((j)((Iterator)localObject).next()).getId();
        j = i;
        if ((j >= k) || (((Note)localList.get(j)).gp() != l2))
        {
          a(localList.subList(i, j), paramMap, l2, l1);
          i = j;
        }
      }
      finally
      {
        ((Cursor)localObject).close();
      }
    }
  }

  static int b(long paramLong, int paramInt)
  {
    return (int)paramLong * 20 + paramInt;
  }

  private Map<Long, a> c(ContentResolver paramContentResolver)
  {
    HashMap localHashMap = Maps.newHashMap();
    Cursor localCursor = paramContentResolver.query(i.c.CONTENT_URI, Alert.COLUMNS, "state=1", null, "fired_time ASC");
    if (localCursor == null)
      return localHashMap;
    try
    {
      if (localCursor.moveToNext())
      {
        Alert localAlert = Alert.a(localCursor, false);
        a(paramContentResolver, localHashMap, e(localAlert.gp(), localAlert.gq()), localAlert.getId(), localAlert.gq(), localAlert.gs(), false);
      }
    }
    finally
    {
      localCursor.close();
    }
    return localHashMap;
  }

  private long e(long paramLong, String paramString)
  {
    Object localObject2 = w.bF(paramString);
    if (localObject2 == null);
    do
    {
      return -1L;
      paramString = mContext.getContentResolver();
      Uri localUri = i.v.CONTENT_URI;
      String str = w.c((w.a)localObject2);
      localObject2 = w.a(paramLong, (w.a)localObject2);
      paramString = paramString.query(localUri, new String[] { "_id" }, str, (String[])localObject2, null);
    }
    while (paramString == null);
    paramLong = -1L;
    try
    {
      if (paramString.moveToFirst())
        paramLong = paramString.getLong(0);
      return paramLong;
    }
    finally
    {
      paramString.close();
    }
  }

  public void b(long paramLong, Task paramTask)
  {
    ContentResolver localContentResolver = mContext.getContentResolver();
    TreeEntity localTreeEntity = F.b(mContext, paramLong, paramTask);
    if (localTreeEntity == null)
    {
      r.e("Keep", "The task is not associated with a note", new Object[0]);
      return;
    }
    if (localTreeEntity.js())
    {
      r.a("Keep", "Skip trashed note " + localTreeEntity.getTitle(), new Object[0]);
      return;
    }
    Map localMap = c(localContentResolver);
    a locala = (a)localMap.get(Long.valueOf(localTreeEntity.getId()));
    if ((locala != null) && (paramTask.getDueDate() != null) && (paramTask.getTaskId().getClientAssignedId().equals(locala.op)))
    {
      r.e("Keep", locala.op + " is triggered again. Skip it now.", new Object[0]);
      com.google.android.keep.d.e(mContext).a(2131230867, 2131231006, 2131231029, null);
      return;
    }
    paramTask = I.a(mContext, localTreeEntity.gp(), paramTask);
    if (localTreeEntity.jr())
      localContentResolver.update(ContentUris.withAppendedId(i.v.CA, localTreeEntity.getId()), null, null, null);
    while (true)
    {
      a(localContentResolver, localMap, localTreeEntity.getId(), paramTask.getId(), paramTask.gq(), System.currentTimeMillis(), true);
      a(localMap);
      return;
      localContentResolver.update(ContentUris.withAppendedId(i.v.CJ, localTreeEntity.getId()), null, null, null);
    }
  }

  public void bA(int paramInt)
  {
    Notification localNotification;
    switch (paramInt)
    {
    default:
      return;
    case 0:
      localNotification = c.a(mContext, c.a(mContext, BrowseActivity.class, "android.intent.action.MAIN"), 2131231272, 2131231273, true);
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      BA.notify("error", paramInt, localNotification);
      return;
      if (KeepApplication.at());
      for (int i = 2131231276; ; i = 2131231275)
      {
        localNotification = c.a(mContext, new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 2131231274, i, false);
        break;
      }
      localNotification = c.a(mContext, new Intent("com.google.android.gms.location.settings.GOOGLE_LOCATION_SETTINGS"), 2131231277, 2131231278, false);
      continue;
      localNotification = c.u(mContext);
    }
  }

  public void bB(int paramInt)
  {
    BA.cancel("error", paramInt);
  }

  public void p(List<Task> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()));
    int i;
    do
    {
      return;
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("state", Integer.valueOf(3));
      i = 0;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (Task)paramList.next();
        String[] arrayOfString = new String[1];
        arrayOfString[0] = ((Task)localObject).getTaskId().getClientAssignedId();
        localObject = h.a(mContext.getContentResolver(), i.c.CONTENT_URI, "state", "reminder_id=?", arrayOfString);
        if ((localObject != null) && (((Integer)localObject).intValue() != 3))
        {
          i = 1;
          mContext.getContentResolver().update(i.c.CONTENT_URI, localContentValues, "reminder_id=?", arrayOfString);
        }
      }
    }
    while (i == 0);
    refresh();
  }

  public void refresh()
  {
    a(c(mContext.getContentResolver()));
  }

  private static final class a
  {
    public final long BF;
    public final long BG;
    public final boolean BH;
    public final String op;

    public a(long paramLong1, String paramString, long paramLong2, boolean paramBoolean)
    {
      BF = paramLong1;
      op = paramString;
      BG = paramLong2;
      BH = paramBoolean;
    }
  }
}