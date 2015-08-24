package com.google.android.keep.notification;

import android.app.IntentService;
import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Intent;
import android.content.OperationApplicationException;
import android.os.RemoteException;
import android.support.v4.app.NotificationManagerCompat;
import com.google.android.keep.provider.i.c;
import com.google.android.keep.provider.i.v;
import com.google.android.keep.util.r;
import java.util.ArrayList;

public class WearableArchiveService extends IntentService
{
  private static int Bo = -1;

  public WearableArchiveService()
  {
    super("WearableArchiveService");
  }

  protected void onHandleIntent(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("com.google.android.keep.intent.extra.notification_id", Bo);
    NotificationManagerCompat localNotificationManagerCompat = NotificationManagerCompat.from(this);
    if (i == Bo);
    long l;
    ArrayList localArrayList;
    do
    {
      do
      {
        return;
        l = paramIntent.getLongExtra("com.google.android.keep.intent.extra.alert_id", -1L);
      }
      while (l == -1L);
      localArrayList = new ArrayList();
      localArrayList.add(ContentProviderOperation.newUpdate(ContentUris.withAppendedId(i.c.CONTENT_URI, l)).withValue("state", Integer.valueOf(3)).build());
      localNotificationManagerCompat.cancel(i);
      l = paramIntent.getLongExtra("treeEntityId", -1L);
    }
    while (l == -1L);
    localArrayList.add(ContentProviderOperation.newUpdate(ContentUris.withAppendedId(i.v.Ck, l)).withValue("is_archived", Integer.valueOf(1)).build());
    try
    {
      getContentResolver().applyBatch("com.google.android.keep", localArrayList);
      return;
    }
    catch (RemoteException paramIntent)
    {
      r.e("Keep", "RemoteException error while updating dismiss state in db", new Object[] { paramIntent });
      return;
    }
    catch (OperationApplicationException paramIntent)
    {
      r.e("Keep", "OperationApplicationException error while updating dismiss state in db", new Object[] { paramIntent });
    }
  }
}