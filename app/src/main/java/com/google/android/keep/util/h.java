package com.google.android.keep.util;

import android.content.ContentResolver;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.MatrixCursor.RowBuilder;
import android.net.Uri;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class h
{
  public static int a(ContentResolver paramContentResolver, Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    paramContentResolver = paramContentResolver.query(paramUri, null, paramString, paramArrayOfString, null);
    if (paramContentResolver != null)
      try
      {
        int i = paramContentResolver.getCount();
        return i;
      }
      finally
      {
        paramContentResolver.close();
      }
    return 0;
  }

  public static Integer a(ContentResolver paramContentResolver, Uri paramUri, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    Object localObject = null;
    paramUri = paramContentResolver.query(paramUri, new String[] { paramString1 }, paramString2, paramArrayOfString, null);
    paramContentResolver = localObject;
    if (paramUri != null);
    try
    {
      if (paramUri.moveToFirst())
      {
        int i = paramUri.getInt(0);
        paramContentResolver = Integer.valueOf(i);
        return paramContentResolver;
      }
      return null;
    }
    finally
    {
      paramUri.close();
    }
    throw paramContentResolver;
  }

  public static <T> T a(ContentResolver paramContentResolver, Uri paramUri, String[] paramArrayOfString1, String paramString, String[] paramArrayOfString2, a<T> parama)
  {
    paramUri = paramContentResolver.query(paramUri, paramArrayOfString1, paramString, paramArrayOfString2, null);
    paramContentResolver = null;
    if (paramUri == null)
      return null;
    try
    {
      if (paramUri.moveToFirst())
        paramContentResolver = parama.b(paramUri, 0);
      return paramContentResolver;
    }
    finally
    {
      paramUri.close();
    }
    throw paramContentResolver;
  }

  public static List<Long> a(ContentResolver paramContentResolver, Uri paramUri, String paramString1, String paramString2, String[] paramArrayOfString, String paramString3)
  {
    ArrayList localArrayList = new ArrayList();
    paramContentResolver = paramContentResolver.query(paramUri, new String[] { paramString1 }, paramString2, paramArrayOfString, paramString3);
    if (paramContentResolver != null)
      try
      {
        if (paramContentResolver.moveToNext())
          localArrayList.add(Long.valueOf(paramContentResolver.getLong(0)));
      }
      finally
      {
        paramContentResolver.close();
      }
    return localArrayList;
  }

  public static <T> List<T> a(ContentResolver paramContentResolver, Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, a<T> parama)
  {
    return a(paramContentResolver.query(paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2), parama);
  }

  public static <T> List<T> a(Cursor paramCursor, a<T> parama)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramCursor == null)
      return localArrayList;
    int i = -1;
    try
    {
      while (paramCursor.moveToNext())
      {
        i += 1;
        localArrayList.add(parama.b(paramCursor, i));
      }
    }
    finally
    {
      paramCursor.close();
    }
    paramCursor.close();
    return localArrayList;
  }

  public static <K, V> Map<K, V> a(ContentResolver paramContentResolver, Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, b<K, V> paramb)
  {
    return a(paramContentResolver.query(paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2), paramb);
  }

  public static <K, V> Map<K, V> a(Cursor paramCursor, b<K, V> paramb)
  {
    HashMap localHashMap = new HashMap();
    if (paramCursor == null)
      return localHashMap;
    int i = -1;
    try
    {
      while (paramCursor.moveToNext())
      {
        i += 1;
        localHashMap.put(paramb.h(paramCursor, i), paramb.g(paramCursor, i));
      }
    }
    finally
    {
      paramCursor.close();
    }
    paramCursor.close();
    return localHashMap;
  }

  public static void a(Cursor paramCursor, MatrixCursor paramMatrixCursor)
  {
    int j = paramCursor.getColumnCount();
    paramMatrixCursor = paramMatrixCursor.newRow();
    int i = 0;
    while (i < j)
    {
      paramMatrixCursor.add(paramCursor.getString(i));
      i += 1;
    }
  }

  public static Integer k(Cursor paramCursor, int paramInt)
  {
    if (paramCursor.getString(paramInt) == null)
      return null;
    return Integer.valueOf(paramCursor.getInt(paramInt));
  }

  public static Long l(Cursor paramCursor, int paramInt)
  {
    if (paramCursor.getString(paramInt) == null)
      return null;
    return Long.valueOf(paramCursor.getLong(paramInt));
  }

  public static String p(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
      return paramString2;
    if (TextUtils.isEmpty(paramString2))
      return paramString1;
    return "(" + paramString1 + ") AND (" + paramString2 + ")";
  }

  public static String q(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
      return paramString2;
    if (TextUtils.isEmpty(paramString2))
      return paramString1;
    return "(" + paramString1 + ") OR (" + paramString2 + ")";
  }

  public static abstract interface a<T>
  {
    public abstract T b(Cursor paramCursor, int paramInt);
  }

  public static abstract interface b<K, V>
  {
    public abstract V g(Cursor paramCursor, int paramInt);

    public abstract K h(Cursor paramCursor, int paramInt);
  }
}