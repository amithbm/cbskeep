package com.google.android.keep.task;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import com.google.android.keep.provider.i.v;
import java.util.List;

public class g extends a
{
  private final List<Long> GE;
  private final List<Long> GF;
  private final boolean zT;

  public g(Context paramContext, List<Long> paramList1, List<Long> paramList2, boolean paramBoolean)
  {
    super(paramContext, i.v.CONTENT_URI);
    GE = paramList1;
    GF = paramList2;
    zT = paramBoolean;
  }

  public Void doInBackground(Void[] paramArrayOfVoid)
  {
    paramArrayOfVoid = mContext.getContentResolver();
    int i = 0;
    if (i < GE.size())
    {
      ContentValues localContentValues = new ContentValues();
      if (zT);
      for (int j = 1; ; j = 0)
      {
        localContentValues.put("is_archived", Integer.valueOf(j));
        localContentValues.put("order_in_parent", (Long)GF.get(i));
        paramArrayOfVoid.update(ContentUris.withAppendedId(i.v.CONTENT_URI, ((Long)GE.get(i)).longValue()), localContentValues, null, null);
        i += 1;
        break;
      }
    }
    return null;
  }
}