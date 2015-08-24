package com.google.android.keep.model;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import com.google.android.keep.db.DbOperation;
import com.google.android.keep.provider.i.c;
import com.google.common.collect.Lists;
import java.util.List;

public class Alert
  implements Parcelable, d
{
  public static final String[] COLUMNS = (String[])uo.toArray(new String[uo.size()]);
  public static final Parcelable.Creator<Alert> CREATOR = new Parcelable.Creator()
  {
    public Alert[] aJ(int paramAnonymousInt)
    {
      return new Alert[paramAnonymousInt];
    }

    public Alert d(Parcel paramAnonymousParcel)
    {
      return new Alert(paramAnonymousParcel.readLong(), paramAnonymousParcel.readLong(), paramAnonymousParcel.readString(), paramAnonymousParcel.readLong(), paramAnonymousParcel.readLong(), paramAnonymousParcel.readLong(), paramAnonymousParcel.readInt());
    }
  };
  private static final List<String> uo = Lists.newArrayList();
  public static final int up = F("_id");
  public static final int uq = F("account_id");
  public static final int ur = F("reminder_id");
  public static final int us = F("scheduled_time");
  public static final int ut = F("fired_time");
  public static final int uu = F("trigger_condition");
  public static final int uv = F("state");
  private long cU;
  private long mId = -1L;
  private int mState;
  private String op;
  private long uk;
  private long ul;
  private long um;
  private ContentValues un = new ContentValues();

  public Alert(long paramLong1, long paramLong2, String paramString, long paramLong3, long paramLong4, long paramLong5, int paramInt)
  {
    mId = paramLong1;
    cU = paramLong2;
    op = paramString;
    uk = paramLong3;
    ul = paramLong4;
    um = paramLong5;
    mState = paramInt;
  }

  private static int F(String paramString)
  {
    uo.add(paramString);
    return uo.size() - 1;
  }

  public static Cursor a(ContentResolver paramContentResolver, long paramLong)
  {
    return paramContentResolver.query(i.c.CONTENT_URI, COLUMNS, "_id=?", new String[] { String.valueOf(paramLong) }, null);
  }

  public static Cursor a(ContentResolver paramContentResolver, String paramString)
  {
    return paramContentResolver.query(i.c.CONTENT_URI, COLUMNS, "reminder_id=?", new String[] { paramString }, null);
  }

  public static Alert a(Cursor paramCursor, boolean paramBoolean)
  {
    if ((paramCursor == null) || ((paramBoolean) && (!paramCursor.moveToFirst())))
      return new Alert(-1L, 0L, null, 0L, 0L, 0L, 0);
    return new Alert(paramCursor.getLong(up), paramCursor.getLong(uq), paramCursor.getString(ur), paramCursor.getLong(us), paramCursor.getLong(ut), paramCursor.getLong(uu), paramCursor.getInt(uv));
  }

  public static Loader<Cursor> q(Context paramContext)
  {
    return new CursorLoader(paramContext, i.c.CONTENT_URI, COLUMNS, null, null, null);
  }

  public void E(String paramString)
  {
    op = paramString;
    un.put("reminder_id", paramString);
  }

  public void b(ContentResolver paramContentResolver)
  {
    if (!gw())
      return;
    if (gv())
      mId = ContentUris.parseId(paramContentResolver.insert(i.c.CONTENT_URI, un));
    while (true)
    {
      un.clear();
      return;
      paramContentResolver.update(ContentUris.withAppendedId(i.c.CONTENT_URI, mId), un, null, null);
    }
  }

  public void d(Object paramObject)
  {
    paramObject = (Alert)paramObject;
    ul = paramObject.ul;
    mState = paramObject.mState;
  }

  public int describeContents()
  {
    return 0;
  }

  public long getId()
  {
    return mId;
  }

  public int getState()
  {
    return mState;
  }

  public long gp()
  {
    return cU;
  }

  public String gq()
  {
    return op;
  }

  public long gr()
  {
    return uk;
  }

  public long gs()
  {
    return ul;
  }

  public long gt()
  {
    return um;
  }

  public String gu()
  {
    return String.valueOf(op);
  }

  public boolean gv()
  {
    return mId == -1L;
  }

  public boolean gw()
  {
    return un.size() > 0;
  }

  public DbOperation gx()
  {
    if (gv());
    for (DbOperation localDbOperation = DbOperation.cY().b(i.c.CONTENT_URI).a(un); ; localDbOperation = DbOperation.cZ().a(i.c.CONTENT_URI, getId()).a(un))
    {
      un.clear();
      return localDbOperation;
    }
  }

  public void m(long paramLong)
  {
    un.put("account_id", Long.valueOf(paramLong));
  }

  public void n(long paramLong)
  {
    um = paramLong;
    un.put("trigger_condition", Long.valueOf(paramLong));
  }

  public void setState(int paramInt)
  {
    mState = paramInt;
    un.put("state", Integer.valueOf(paramInt));
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(mId);
    paramParcel.writeLong(cU);
    paramParcel.writeString(op);
    paramParcel.writeLong(uk);
    paramParcel.writeLong(ul);
    paramParcel.writeLong(um);
    paramParcel.writeInt(mState);
  }
}