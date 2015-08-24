package com.google.android.keep.task;

import android.accounts.Account;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.google.android.keep.L;
import com.google.android.keep.model.ColorMap.ColorPair;
import com.google.android.keep.model.TreeEntity;
import com.google.android.keep.provider.i.e;
import com.google.android.keep.provider.i.o;
import com.google.android.keep.provider.i.v;
import com.google.android.keep.util.F;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskHelper
{
  public static void F(Context paramContext)
  {
    long l = System.currentTimeMillis();
    paramContext.getContentResolver().delete(i.o.Cv, "code=? AND time_created<?", new String[] { "WS", Long.valueOf(l - 86400000L).toString() });
  }

  public static void a(Context paramContext, long paramLong1, long paramLong2, a<Long> parama)
  {
    new d.c(paramContext, paramLong2, parama).execute(new Void[0]);
  }

  public static void a(Context paramContext, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (paramBoolean);
    for (Uri localUri = i.v.c(paramLong1, paramLong2); ; localUri = i.v.b(paramLong1, paramLong2))
    {
      new j(paramContext, localUri).execute(new Void[0]);
      return;
    }
  }

  public static void a(Context paramContext, long paramLong, a<Long> parama)
  {
    new j(paramContext, i.v.CD, paramLong)
    {
      protected void a(Void paramAnonymousVoid)
      {
        if (GG == null)
          return;
        long l = kp.getAsLong("_id").longValue();
        if (l == -1L)
        {
          GG.a(TaskHelper.ErrorCode.GJ);
          return;
        }
        GG.a(Long.valueOf(l));
      }
    }
    .execute(new Void[0]);
  }

  public static void a(Context paramContext, long paramLong, String paramString, a<String> parama)
  {
    new c(paramContext, parama, paramLong, paramString).execute(new Void[0]);
  }

  public static void a(Context paramContext, Account paramAccount, long paramLong)
  {
    new h(paramContext, paramAccount, paramLong).execute(new Void[0]);
  }

  public static void a(Context paramContext, com.google.android.keep.model.j paramj, String paramString)
  {
    new f(paramContext, paramj, paramString).execute(new Void[0]);
  }

  private static void a(Context paramContext, com.google.android.keep.model.j paramj, boolean paramBoolean)
  {
    List localList = F.b(paramContext, paramj.getId(), paramBoolean);
    Object localObject = new ArrayList(localList.size());
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
      ((List)localObject).add(Long.valueOf(((TreeEntity)localIterator.next()).getId()));
    if (!localList.isEmpty())
    {
      localObject = "_id IN ( " + TextUtils.join(",", (Iterable)localObject) + " )";
      paramContext.getContentResolver().update(i.v.CC, null, (String)localObject, null);
      L.c(paramContext, paramj, localList);
    }
  }

  public static void a(Context paramContext, List<Long> paramList)
  {
    new j(paramContext, i.v.CONTENT_URI, paramList).b("is_trashed", Integer.valueOf(1)).execute(new Void[0]);
  }

  public static void a(Context paramContext, List<Long> paramList, Account paramAccount)
  {
    a(paramContext, paramList);
    a(paramContext, paramAccount, -1L);
  }

  public static void a(Context paramContext, List<Long> paramList, ColorMap.ColorPair paramColorPair)
  {
    new j(paramContext, i.v.CONTENT_URI, paramList).l("color_name", paramColorPair.getKey()).execute(new Void[0]);
  }

  public static void a(Context paramContext, List<Long> paramList1, List<Long> paramList2, boolean paramBoolean)
  {
    new g(paramContext, paramList1, paramList2, paramBoolean).execute(new Void[0]);
  }

  public static void b(Context paramContext, long paramLong, a<Long> parama)
  {
    new d.d(paramContext, paramLong, parama).execute(new Void[0]);
  }

  public static void b(Context paramContext, List<Long> paramList)
  {
    new j(paramContext, i.v.CONTENT_URI, paramList).b("is_trashed", Integer.valueOf(0)).execute(new Void[0]);
  }

  public static void c(Context paramContext, long paramLong, a<Long> parama)
  {
    new d.b(paramContext, paramLong, parama).execute(new Void[0]);
  }

  public static void c(Context paramContext, List<Long> paramList)
  {
    new j(paramContext, i.v.Ck, paramList).execute(new Void[0]);
  }

  public static void d(Context paramContext, com.google.android.keep.model.j paramj, List<? extends TreeEntity> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
      localArrayList.add(Long.valueOf(((TreeEntity)localIterator.next()).getId()));
    new j(paramContext, i.v.Ce, localArrayList).execute(new Void[0]);
    L.b(paramContext, paramj, paramList);
  }

  public static void d(Context paramContext, List<Long> paramList)
  {
    new j(paramContext, i.v.CA, paramList).execute(new Void[0]);
  }

  public static void f(Context paramContext, final com.google.android.keep.model.j paramj)
  {
    new AsyncTask()
    {
      protected Void doInBackground(Void[] paramAnonymousArrayOfVoid)
      {
        TaskHelper.b(rh, paramj, false);
        return null;
      }
    }
    .execute(new Void[0]);
  }

  public static void g(Context paramContext, long paramLong)
  {
    new j(paramContext, i.e.Ce, paramLong).execute(new Void[0]);
  }

  public static void g(Context paramContext, com.google.android.keep.model.j paramj)
  {
    a(paramContext, paramj, true);
  }

  public static void h(Context paramContext, long paramLong)
  {
    new j(paramContext, i.v.Ck, paramLong).execute(new Void[0]);
  }

  public static enum ErrorCode
  {
  }

  public static abstract interface a<T>
  {
    public abstract void a(TaskHelper.ErrorCode paramErrorCode);

    public abstract void a(T paramT);
  }
}