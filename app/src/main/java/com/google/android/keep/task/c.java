package com.google.android.keep.task;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.google.android.keep.model.TreeEntity.TreeEntityType;
import com.google.android.keep.provider.i.v;

public class c extends AsyncTask<Void, Void, String>
{
  private final TaskHelper.a<String> GC;
  private TaskHelper.ErrorCode GD = TaskHelper.ErrorCode.GH;
  private final long cU;
  private final String ja;
  private final Context mContext;

  public c(Context paramContext, TaskHelper.a<String> parama, long paramLong, String paramString)
  {
    mContext = paramContext.getApplicationContext();
    GC = parama;
    cU = paramLong;
    ja = paramString;
  }

  private String lt()
  {
    if (TextUtils.isEmpty(ja));
    Object localObject3;
    do
    {
      return null;
      localObject1 = mContext.getContentResolver();
      localObject3 = i.v.CONTENT_URI;
      String str1 = Long.toString(cU);
      String str2 = ja + "%";
      String str3 = Integer.toString(TreeEntity.TreeEntityType.e(TreeEntity.TreeEntityType.zP));
      localObject3 = ((ContentResolver)localObject1).query((Uri)localObject3, new String[] { "uuid" }, "account_id=? AND title LIKE ? COLLATE NOCASE AND type=?", new String[] { str1, str2, str3 }, "time_last_updated DESC");
    }
    while (localObject3 == null);
    Object localObject1 = null;
    try
    {
      if (((Cursor)localObject3).moveToFirst())
        localObject1 = ((Cursor)localObject3).getString(0);
      return localObject1;
    }
    finally
    {
      ((Cursor)localObject3).close();
    }
  }

  protected String b(Void[] paramArrayOfVoid)
  {
    return lt();
  }

  protected void bc(String paramString)
  {
    if (GC == null)
      return;
    if (GD == TaskHelper.ErrorCode.GH)
    {
      GC.a(paramString);
      return;
    }
    GC.a(GD);
  }

  protected void bd(String paramString)
  {
    if (GC == null)
      return;
    GC.a(TaskHelper.ErrorCode.GL);
  }
}