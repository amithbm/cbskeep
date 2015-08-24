package com.google.android.keep.task;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.keep.provider.i.e;
import com.google.android.keep.provider.i.j;
import com.google.android.keep.provider.i.m;
import com.google.android.keep.provider.i.v;
import com.google.android.keep.provider.i.y;
import com.google.android.keep.util.r;
import com.google.android.keep.util.z;
import java.util.ArrayList;

public abstract class e extends AsyncTask<Void, Void, Intent>
{
  private static final String TAG = e.class.getSimpleName();
  private final Context mContext;
  private final long uy;

  public e(Context paramContext, long paramLong)
  {
    mContext = paramContext;
    uy = paramLong;
  }

  private static void a(Context paramContext, long paramLong1, long paramLong2, String paramString, Intent paramIntent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (!TextUtils.isEmpty(paramString))
    {
      localStringBuilder.append(paramString);
      localStringBuilder.append("\n");
    }
    if (paramLong1 != -1L)
    {
      paramContext = paramContext.getContentResolver().query(i.m.CONTENT_URI, new String[] { "is_checked", "text" }, "list_parent_id=? AND is_deleted=0", new String[] { String.valueOf(paramLong1) }, "order_in_parent DESC, time_last_updated DESC");
      while (true)
      {
        try
        {
          if (!paramContext.moveToNext())
            break;
          if (paramLong2 == 1L)
          {
            if (paramContext.getInt(0) == 1)
              localStringBuilder.append("[x] ");
          }
          else
          {
            localStringBuilder.append(paramContext.getString(1));
            localStringBuilder.append("\n");
            continue;
          }
        }
        finally
        {
          paramContext.close();
        }
        localStringBuilder.append("[ ] ");
      }
      paramContext.close();
    }
    paramIntent.putExtra("android.intent.extra.TEXT", localStringBuilder.toString());
  }

  private static void a(Context paramContext, long paramLong, Intent paramIntent)
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    paramContext = paramContext.getContentResolver().query(i.e.CONTENT_URI, new String[] { "_id", "type" }, "tree_entity_id=? AND (type=? OR type=?)", new String[] { String.valueOf(paramLong), String.valueOf(0), String.valueOf(1) }, null);
    int j;
    try
    {
      while (true)
      {
        if (!paramContext.moveToNext())
          break label184;
        j = paramContext.getInt(1);
        if (j == 0)
        {
          localArrayList.add(z.w(ContentUris.withAppendedId(i.j.Cq, paramContext.getLong(0))));
          i = 1;
        }
        else
        {
          if (j != 1)
            break;
          localArrayList.add(z.w(ContentUris.withAppendedId(i.y.CK, paramContext.getLong(0))));
        }
      }
    }
    finally
    {
      paramContext.close();
    }
    throw new IllegalStateException("Unsupported blob type:" + j);
    label184: paramContext.close();
    if (localArrayList.size() == 0)
    {
      paramIntent.setAction("android.intent.action.SEND");
      paramIntent.setType("text/plain");
      return;
    }
    if (localArrayList.size() == 1)
    {
      paramIntent.setAction("android.intent.action.SEND");
      if (i != 0);
      for (paramContext = "image/*"; ; paramContext = "audio/*")
      {
        paramIntent.setType(paramContext);
        paramIntent.putExtra("android.intent.extra.STREAM", (Parcelable)localArrayList.get(0));
        return;
      }
    }
    paramIntent.setAction("android.intent.action.SEND_MULTIPLE");
    if (i != 0);
    for (paramContext = "image/*"; ; paramContext = "audio/*")
    {
      paramIntent.setType(paramContext);
      paramIntent.putParcelableArrayListExtra("android.intent.extra.STREAM", localArrayList);
      return;
    }
  }

  protected Intent c(Void[] paramArrayOfVoid)
  {
    paramArrayOfVoid = mContext.getContentResolver();
    Object localObject1 = i.v.CONTENT_URI;
    long l = uy;
    paramArrayOfVoid = paramArrayOfVoid.query((Uri)localObject1, new String[] { "title", "type" }, "_id=?", new String[] { String.valueOf(l) }, null);
    if (paramArrayOfVoid == null)
      return null;
    try
    {
      if (paramArrayOfVoid.moveToFirst())
      {
        localObject1 = paramArrayOfVoid.getString(0);
        int i = paramArrayOfVoid.getInt(1);
        paramArrayOfVoid.close();
        paramArrayOfVoid = new Intent();
        a(mContext, uy, paramArrayOfVoid);
        a(mContext, uy, i, (String)localObject1, paramArrayOfVoid);
        paramArrayOfVoid.putExtra("android.intent.extra.SUBJECT", (String)localObject1);
        paramArrayOfVoid.addFlags(524289);
        return Intent.createChooser(paramArrayOfVoid, mContext.getString(2131231202));
      }
      r.e(TAG, "Cannot find the note for send intent: " + uy, new Object[0]);
      return null;
    }
    finally
    {
      paramArrayOfVoid.close();
    }
  }

  protected abstract void e(Intent paramIntent);
}