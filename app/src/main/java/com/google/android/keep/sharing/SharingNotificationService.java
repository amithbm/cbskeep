package com.google.android.keep.sharing;

import android.app.IntentService;
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
import com.google.android.keep.model.Note;
import com.google.android.keep.provider.i.f;
import com.google.android.keep.provider.i.v;
import com.google.android.keep.util.e;
import com.google.android.keep.util.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SharingNotificationService extends IntentService
{
  private NotificationManagerCompat Fn;
  private com.google.android.keep.ui.c eF;

  public SharingNotificationService()
  {
    super("SNNService");
  }

  public static Intent B(Context paramContext)
  {
    paramContext = new Intent(paramContext, SharingNotificationService.class);
    paramContext.setAction("action_repost_notification");
    return paramContext;
  }

  public static Intent a(Context paramContext, long[] paramArrayOfLong)
  {
    paramContext = new Intent(paramContext, SharingNotificationService.class);
    paramContext.setAction("action_shared_note_changed");
    paramContext.putExtra("extra_changed_ids", paramArrayOfLong);
    return paramContext;
  }

  public static void a(NotificationManagerCompat paramNotificationManagerCompat, long paramLong)
  {
    paramNotificationManagerCompat.cancel("shared_note" + paramLong, (int)paramLong);
  }

  public static void a(NotificationManagerCompat paramNotificationManagerCompat, long paramLong, Notification paramNotification)
  {
    paramNotificationManagerCompat.notify("shared_note" + paramLong, (int)paramLong, paramNotification);
  }

  private void a(Set<Long> paramSet)
  {
    Object localObject = paramSet.iterator();
    while (((Iterator)localObject).hasNext())
    {
      long l = ((Long)((Iterator)localObject).next()).longValue();
      a(Fn, l);
    }
    localObject = new ContentValues();
    ((ContentValues)localObject).put("notification_state", Integer.valueOf(2));
    getContentResolver().update(i.v.BX, (ContentValues)localObject, "_id IN (" + TextUtils.join(",", paramSet) + ")", null);
  }

  private void a(long[] paramArrayOfLong, Collection<Long> paramCollection1, Collection<Long> paramCollection2, Collection<Long> paramCollection3)
  {
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      paramCollection3.add(Long.valueOf(paramArrayOfLong[i]));
      i += 1;
    }
    ContentResolver localContentResolver = getContentResolver();
    Uri localUri = i.v.CONTENT_URI;
    paramArrayOfLong = "_id IN (" + e.a(",", paramArrayOfLong) + ")";
    paramArrayOfLong = localContentResolver.query(localUri, new String[] { "_id", "has_read", "notification_state" }, paramArrayOfLong, null, null);
    if (paramArrayOfLong == null)
      return;
    while (true)
    {
      long l;
      try
      {
        if (!paramArrayOfLong.moveToNext())
          break;
        l = paramArrayOfLong.getLong(0);
        paramCollection3.remove(Long.valueOf(l));
        if (paramArrayOfLong.getInt(1) == 1)
        {
          i = 1;
          j = paramArrayOfLong.getInt(2);
          if ((i == 0) || (j == 2))
            break label209;
          paramCollection2.add(Long.valueOf(l));
          continue;
        }
      }
      finally
      {
        paramArrayOfLong.close();
      }
      i = 0;
      continue;
      label209: if ((i == 0) && (j == 0))
        paramCollection1.add(Long.valueOf(l));
    }
    paramArrayOfLong.close();
  }

  private List<Long> b(Collection<Long> paramCollection)
  {
    ArrayList localArrayList = new ArrayList();
    paramCollection = getContentResolver().query(i.f.Cm, Note.COLUMNS, "tree_entity._id IN (" + TextUtils.join(",", paramCollection) + ")", null, null);
    if (paramCollection == null)
      return localArrayList;
    while (true)
    {
      try
      {
        if (!paramCollection.moveToNext())
          break;
        long l = paramCollection.getLong(Note.tu);
        if (paramCollection.getInt(Note.yb) == 1)
        {
          i = 1;
          if (i != 0)
            continue;
          Object localObject = Note.p(paramCollection);
          if (!((Note)localObject).ip())
            continue;
          localObject = com.google.android.keep.notification.c.a(this, (Note)localObject, eF);
          if (localObject == null)
            continue;
          a(Fn, l, (Notification)localObject);
          localArrayList.add(Long.valueOf(l));
          continue;
        }
      }
      finally
      {
        paramCollection.close();
      }
      int i = 0;
    }
    paramCollection.close();
    paramCollection = new ContentValues();
    paramCollection.put("notification_state", Integer.valueOf(1));
    getContentResolver().update(i.v.BX, paramCollection, "_id IN (" + TextUtils.join(",", localIterable) + ")", null);
    return localIterable;
  }

  public static Intent f(Context paramContext, long paramLong)
  {
    paramContext = new Intent(paramContext, SharingNotificationService.class);
    paramContext.setAction("action_dismiss_notification");
    paramContext.setData(ContentUris.withAppendedId(i.v.CONTENT_URI, paramLong));
    paramContext.putExtra("treeEntityId", paramLong);
    return paramContext;
  }

  private void h(Intent paramIntent)
  {
    String str = paramIntent.getAction();
    eF = new com.google.android.keep.ui.c(this, null);
    eF.lX();
    Fn = NotificationManagerCompat.from(this);
    if ("action_shared_note_changed".equals(str))
      k(paramIntent);
    while (true)
    {
      eF.kl();
      return;
      if ("action_repost_notification".equals(str))
        lh();
      else if ("action_dismiss_notification".equals(str))
        l(paramIntent);
    }
  }

  private void k(Intent paramIntent)
  {
    paramIntent = paramIntent.getLongArrayExtra("extra_changed_ids");
    if ((paramIntent == null) || (paramIntent.length == 0))
      return;
    HashSet localHashSet1 = new HashSet();
    HashSet localHashSet2 = new HashSet();
    HashSet localHashSet3 = new HashSet();
    a(paramIntent, localHashSet1, localHashSet2, localHashSet3);
    localHashSet1.removeAll(b(localHashSet1));
    localHashSet2.addAll(localHashSet1);
    localHashSet2.addAll(localHashSet3);
    a(localHashSet2);
  }

  private void l(Intent paramIntent)
  {
    long l = paramIntent.getLongExtra("treeEntityId", -1L);
    if (l == -1L)
      return;
    paramIntent = new ContentValues();
    paramIntent.put("notification_state", Integer.valueOf(2));
    getContentResolver().update(ContentUris.withAppendedId(i.v.BX, l), paramIntent, null, null);
  }

  private void lh()
  {
    b(h.a(getContentResolver(), i.v.CONTENT_URI, "_id", "notification_state=1", null, null));
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
      SharingNotificationReceiver.completeWakefulIntent(paramIntent);
    }
  }
}