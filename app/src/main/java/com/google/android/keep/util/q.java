package com.google.android.keep.util;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.database.Cursor;
import com.google.android.keep.model.ListItem;
import com.google.android.keep.provider.i.w;
import java.util.List;

public class q
{
  public static List<ListItem> d(ContentResolver paramContentResolver, long paramLong)
  {
    return h.a(paramContentResolver, ContentUris.withAppendedId(i.w.CONTENT_URI, paramLong), ListItem.COLUMNS, null, null, null, new h.a()
    {
      public ListItem p(Cursor paramAnonymousCursor, int paramAnonymousInt)
      {
        return new ListItem(paramAnonymousCursor);
      }
    });
  }
}