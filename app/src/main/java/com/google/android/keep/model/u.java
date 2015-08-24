package com.google.android.keep.model;

import android.database.Cursor;
import com.google.android.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.List;

public class u
  implements d
{
  public static final String[] COLUMNS = (String[])uo.toArray(new String[uo.size()]);
  public static final int tu;
  private static final List<String> uo = Lists.newArrayList();
  public static final int vy = F("_id");
  public static final int yJ = F("label_id");
  private long mId;
  private final String rt;
  private final long uy;

  static
  {
    tu = F("tree_entity_id");
  }

  private u(long paramLong1, String paramString, long paramLong2)
  {
    mId = paramLong1;
    rt = paramString;
    uy = paramLong2;
  }

  public u(String paramString, long paramLong)
  {
    this(-1L, paramString, paramLong);
  }

  private static int F(String paramString)
  {
    uo.add(paramString);
    return uo.size() - 1;
  }

  public static u s(Cursor paramCursor)
  {
    return new u(paramCursor.getLong(vy), paramCursor.getString(yJ), paramCursor.getLong(tu));
  }

  public void d(Object paramObject)
  {
    Preconditions.checkArgument(equals(paramObject));
    mId = ((u)paramObject).mId;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof u));
    do
    {
      return false;
      paramObject = (u)paramObject;
    }
    while ((!rt.equals(paramObject.rt)) || (uy != paramObject.uy));
    return true;
  }

  public String gu()
  {
    return rt + ":" + uy;
  }

  public boolean gv()
  {
    return mId == -1L;
  }

  public String iN()
  {
    return rt;
  }

  public Long iO()
  {
    return Long.valueOf(mId);
  }

  public Long it()
  {
    return Long.valueOf(uy);
  }
}