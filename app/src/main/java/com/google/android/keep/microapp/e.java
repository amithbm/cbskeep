package com.google.android.keep.microapp;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.google.android.keep.F;
import com.google.android.keep.G;
import com.google.android.keep.model.A;
import com.google.android.keep.model.BaseReminder;
import com.google.android.keep.model.ColorMap;
import com.google.android.keep.model.ColorMap.ColorPair;
import com.google.android.keep.model.TimeReminder;
import com.google.android.keep.model.j;
import com.google.android.keep.provider.h;
import com.google.android.keep.provider.i.f;
import com.google.android.keep.provider.i.m;
import com.google.android.keep.util.o;
import com.google.android.keep.util.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class e
{
  private static final int tA = y("images");
  private static final int tB = y("is_graveyard_off");
  private static final int tC = y("is_new_list_item_from_top");
  private static final String[] tD = (String[])tt.toArray(new String[tt.size()]);
  private static final List<String> tE = new ArrayList();
  private static final int tF = z("_id");
  private static final int tG = z("uuid");
  private static final int tH = z("text");
  private static final int tI = z("is_checked");
  private static final String[] tJ = (String[])tE.toArray(new String[tE.size()]);
  private static final String[] tK = { "_id", "is_checked", "time_last_updated" };
  private static final List<String> tt = new ArrayList();
  private static final int tu = y("tree_entity._id");
  private static final int tv = y("uuid");
  private static final int tw = y("server_id");
  private static final int tx = y("type");
  private static final int ty = y("title");
  private static final int tz = y("color_name");

  private static int a(List<String> paramList, String paramString)
  {
    paramList.add(paramString);
    return paramList.size() - 1;
  }

  public static G a(Context paramContext, long paramLong)
  {
    Object localObject = o.O(paramContext);
    if (localObject == null);
    A localA;
    do
    {
      return null;
      localA = new A();
      localA.d(paramContext, (j)localObject);
      localObject = paramContext.getContentResolver().query(ContentUris.withAppendedId(i.f.Cm, paramLong), tD, null, null, null);
    }
    while (localObject == null);
    try
    {
      if (((Cursor)localObject).moveToFirst())
      {
        paramContext = a(paramContext, (Cursor)localObject, localA);
        return paramContext;
      }
      return null;
    }
    finally
    {
      ((Cursor)localObject).close();
    }
    throw paramContext;
  }

  private static G a(Context paramContext, Cursor paramCursor, A paramA)
  {
    if (paramCursor == null)
      return null;
    G localG = new G();
    localG.id = paramCursor.getLong(tu);
    localG.type = paramCursor.getInt(tx);
    localG.title = paramCursor.getString(ty);
    localG.color = ColorMap.I(paramCursor.getString(tz)).getValue();
    boolean bool;
    if (paramCursor.getInt(tC) == 1)
    {
      bool = true;
      localG.uc = bool;
      if (paramCursor.getInt(tB) != 0)
        break label310;
      bool = true;
      label112: Object localObject = a(paramContext, localG.id, bool);
      localG.ud = ((F[])((List)localObject).toArray(new F[((List)localObject).size()]));
      localObject = paramCursor.getString(tA);
      if (!TextUtils.isEmpty((CharSequence)localObject))
        localG.ue = h.aG((String)localObject);
      localObject = paramCursor.getString(tw);
      if (localObject != null)
        localG.serverId = ((String)localObject);
      paramCursor = paramCursor.getString(tv);
      if (paramCursor != null)
        localG.mT = paramCursor;
      paramCursor = paramA.a((String)localObject, paramCursor, localG.id);
      if (paramCursor == null)
        break label327;
      if (paramCursor.gq() != null)
        localG.uf = paramCursor.gq();
      paramContext = x.b(paramContext, paramCursor);
      if (paramContext != null)
        localG.tZ = paramContext;
      if ((paramCursor.getType() != 0) || (((TimeReminder)paramCursor).getRecurrence() == null))
        break label315;
    }
    label310: label315: for (localG.ua = 2; ; localG.ua = paramCursor.getType())
    {
      localG.ub = paramCursor.gK();
      return localG;
      bool = false;
      break;
      bool = false;
      break label112;
    }
    label327: localG.ua = -1;
    return localG;
  }

  private static List<F> a(Context paramContext, long paramLong, boolean paramBoolean)
  {
    paramContext = paramContext.getContentResolver();
    Object localObject = new StringBuilder();
    if (paramBoolean)
      ((StringBuilder)localObject).append("is_checked ASC").append(",");
    ((StringBuilder)localObject).append("order_in_parent DESC").append(",");
    ((StringBuilder)localObject).append("time_last_updated DESC");
    paramContext = paramContext.query(i.m.CONTENT_URI, tJ, "list_parent_id=" + paramLong, null, ((StringBuilder)localObject).toString());
    localObject = new ArrayList();
    if (paramContext == null)
      return localObject;
    while (true)
    {
      try
      {
        if (!paramContext.moveToNext())
          break;
        F localF = new F();
        localF.id = paramContext.getLong(tF);
        localF.mT = paramContext.getString(tG);
        localF.text = paramContext.getString(tH);
        if (paramContext.getInt(tI) != 0)
        {
          paramBoolean = true;
          localF.tU = paramBoolean;
          ((List)localObject).add(localF);
          continue;
        }
      }
      finally
      {
        paramContext.close();
      }
      paramBoolean = false;
    }
    paramContext.close();
    return localList;
  }

  public static F b(Context paramContext, long paramLong)
  {
    paramContext = paramContext.getContentResolver().query(i.m.CONTENT_URI, tK, "_id=" + paramLong, null, null);
    if (paramContext == null)
      return null;
    try
    {
      if (paramContext.moveToNext())
      {
        int i = paramContext.getColumnIndex("time_last_updated");
        int j = paramContext.getInt(paramContext.getColumnIndex("is_checked"));
        F localF = new F();
        localF.id = paramLong;
        if (j != 0);
        for (boolean bool = true; ; bool = false)
        {
          localF.tU = bool;
          localF.tX = paramContext.getLong(i);
          return localF;
        }
      }
      return null;
    }
    finally
    {
      paramContext.close();
    }
  }

  public static List<G> b(Context paramContext, j paramj)
  {
    if (paramj == null)
      return Collections.emptyList();
    A localA = new A();
    localA.d(paramContext, paramj);
    paramj = paramContext.getContentResolver().query(i.f.c(i.f.Ch, paramj.getId()), tD, null, null, null);
    if (paramj == null)
      return Collections.emptyList();
    ArrayList localArrayList = new ArrayList();
    try
    {
      while (paramj.moveToNext())
      {
        G localG = a(paramContext, paramj, localA);
        if (localG != null)
          localArrayList.add(localG);
      }
    }
    finally
    {
      paramj.close();
    }
    paramj.close();
    return localArrayList;
  }

  private static int y(String paramString)
  {
    return a(tt, paramString);
  }

  private static int z(String paramString)
  {
    return a(tE, paramString);
  }
}