package com.google.android.keep.model;

import android.app.Activity;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import com.google.android.common.base.Preconditions;
import com.google.android.keep.provider.KeepProvider;
import com.google.android.keep.provider.i.e;
import com.google.android.keep.provider.i.y;
import com.google.android.keep.util.E;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public final class VoiceBlob extends Blob
{
  public static final Collection<String> Ak = Collections.unmodifiableCollection(Arrays.asList(new String[] { "audio/3gpp", "audio/amr-wb" }));
  private static String Al = "tree_entity_id=? AND type=1";
  public static final Parcelable.Creator<VoiceBlob> CREATOR = new Parcelable.Creator()
  {
    public VoiceBlob[] bq(int paramAnonymousInt)
    {
      return new VoiceBlob[paramAnonymousInt];
    }

    public VoiceBlob r(Parcel paramAnonymousParcel)
    {
      return new VoiceBlob(paramAnonymousParcel, null);
    }
  };
  private final int mDuration;

  private VoiceBlob(long paramLong1, String paramString1, String paramString2, String paramString3, long paramLong2, int paramInt, long paramLong3)
  {
    super(paramLong1, paramString1, paramString2, 1, paramString3, paramLong2, paramLong3);
    mDuration = paramInt;
  }

  public VoiceBlob(Cursor paramCursor)
  {
    super(paramCursor);
    mDuration = Integer.valueOf(paramCursor.getString(uS)).intValue();
  }

  private VoiceBlob(Parcel paramParcel)
  {
    super(paramParcel);
    mDuration = paramParcel.readInt();
  }

  public VoiceBlob(String paramString, int paramInt)
  {
    this(-1L, KeepProvider.kw(), null, paramString, System.currentTimeMillis(), paramInt, 0L);
  }

  public static Loader<Cursor> a(Activity paramActivity, long paramLong)
  {
    return new CursorLoader(paramActivity, i.e.CONTENT_URI, COLUMNS, Al, new String[] { String.valueOf(paramLong) }, "time_created DESC ");
  }

  public static Uri s(long paramLong)
  {
    if (paramLong == -1L)
      return null;
    return ContentUris.withAppendedId(i.y.CK, paramLong);
  }

  public ContentValues b(Long paramLong)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("tree_entity_id", paramLong);
    localContentValues.put("type", Integer.valueOf(1));
    localContentValues.put("file_name", getFileName());
    localContentValues.put("data1", Integer.valueOf(mDuration));
    localContentValues.put("uuid", uK);
    localContentValues.put("time_created", Long.valueOf(uM));
    return localContentValues;
  }

  public void d(Object paramObject)
  {
    paramObject = (VoiceBlob)paramObject;
    mId = paramObject.mId;
    mMediaId = paramObject.mMediaId;
    uL = paramObject.uL;
    Preconditions.checkArgument(equals(paramObject), paramObject.toString() + " vs\n " + toString());
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof VoiceBlob));
    do
    {
      return false;
      paramObject = (VoiceBlob)paramObject;
    }
    while ((!super.equals(paramObject)) || (mDuration != paramObject.mDuration));
    return true;
  }

  public Uri getContentUri()
  {
    return s(getId());
  }

  public int getDuration()
  {
    return mDuration;
  }

  public boolean gv()
  {
    return getId() == -1L;
  }

  public String toString()
  {
    return gL().a("duration", Integer.valueOf(mDuration)).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(mDuration);
  }
}