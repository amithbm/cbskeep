package com.google.android.keep.util;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import com.google.android.keep.model.ImageBlob;
import com.google.android.keep.provider.i.e;
import java.util.List;

public class l
{
  public static List<ImageBlob> c(ContentResolver paramContentResolver, long paramLong)
  {
    Uri localUri = i.e.CONTENT_URI;
    String[] arrayOfString = ImageBlob.COLUMNS;
    h.a local1 = new h.a()
    {
      public ImageBlob m(Cursor paramAnonymousCursor, int paramAnonymousInt)
      {
        return (ImageBlob)ImageBlob.k(paramAnonymousCursor);
      }
    };
    return h.a(paramContentResolver, localUri, arrayOfString, "tree_entity_id=? AND type=0", new String[] { String.valueOf(paramLong) }, "time_created DESC ", local1);
  }
}