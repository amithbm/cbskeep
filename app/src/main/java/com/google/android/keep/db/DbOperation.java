package com.google.android.keep.db;

import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentUris;
import android.content.ContentValues;
import android.net.Uri;
import java.util.Iterator;
import java.util.Set;

public class DbOperation
{
  private final Type ko;
  private final ContentValues kp = new ContentValues();
  private String mSelection = null;
  private String[] mSelectionArgs = null;
  private Uri mUri;

  public DbOperation(Type paramType)
  {
    ko = paramType;
  }

  public static DbOperation cY()
  {
    return new DbOperation(Type.ks);
  }

  public static DbOperation cZ()
  {
    return new DbOperation(Type.kr);
  }

  public static DbOperation da()
  {
    return new DbOperation(Type.kt);
  }

  private ContentProviderOperation.Builder db()
  {
    switch (1.kq[ko.ordinal()])
    {
    default:
      throw new IllegalArgumentException("No valid type defined");
    case 1:
      return ContentProviderOperation.newUpdate(mUri);
    case 2:
      return ContentProviderOperation.newInsert(mUri);
    case 3:
    }
    return ContentProviderOperation.newDelete(mUri);
  }

  public DbOperation a(ContentValues paramContentValues)
  {
    kp.putAll(paramContentValues);
    return this;
  }

  public DbOperation a(Uri paramUri, long paramLong)
  {
    mUri = ContentUris.withAppendedId(paramUri, paramLong);
    return this;
  }

  public DbOperation a(String paramString, Integer paramInteger)
  {
    kp.put(paramString, paramInteger);
    return this;
  }

  public DbOperation a(String paramString, String[] paramArrayOfString)
  {
    mSelection = paramString;
    mSelectionArgs = paramArrayOfString;
    return this;
  }

  public DbOperation b(Uri paramUri)
  {
    mUri = paramUri;
    return this;
  }

  public ContentProviderOperation dc()
  {
    ContentProviderOperation.Builder localBuilder = db();
    if (kp.size() > 0)
      localBuilder.withValues(kp);
    if (mSelection != null)
      localBuilder.withSelection(mSelection, mSelectionArgs);
    return localBuilder.build();
  }

  public String toString()
  {
    Object localObject2 = mUri.toString();
    Object localObject1 = localObject2;
    if (((String)localObject2).startsWith("content://com.google.android.keep/"))
      localObject1 = ((String)localObject2).substring("content://com.google.android.keep/".length());
    localObject1 = new StringBuilder(ko.toString()).append(" ").append((String)localObject1).append("\n");
    if (mSelection != null)
    {
      ((StringBuilder)localObject1).append("  WHERE ").append(mSelection);
      if ((mSelectionArgs != null) && (mSelectionArgs.length > 0))
      {
        if (mSelectionArgs.length != 1)
          break label218;
        ((StringBuilder)localObject1).append(mSelectionArgs[0]).append("\n");
      }
    }
    while (kp.size() > 0)
    {
      ((StringBuilder)localObject1).append("  SET (");
      int i = 0;
      localObject2 = kp.keySet().iterator();
      while (true)
        if (((Iterator)localObject2).hasNext())
        {
          String str = (String)((Iterator)localObject2).next();
          if (i > 0)
            ((StringBuilder)localObject1).append(", ");
          ((StringBuilder)localObject1).append(str).append(" = '").append(kp.get(str)).append("'");
          i += 1;
          continue;
          label218: ((StringBuilder)localObject1).append("[");
          i = 0;
          while (i < mSelectionArgs.length)
          {
            if (i > 0)
              ((StringBuilder)localObject1).append(", ");
            ((StringBuilder)localObject1).append("'").append(mSelectionArgs[i]).append("'");
            i += 1;
          }
          ((StringBuilder)localObject1).append("]\n");
          break;
        }
      ((StringBuilder)localObject1).append(")\n");
    }
    return ((StringBuilder)localObject1).toString();
  }

  public static enum Type
  {
  }
}