package com.google.android.keep.task;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import java.util.List;

public class j extends a
{
  private static final String TAG = a.class.getSimpleName();
  protected boolean Hl = true;
  protected final String mSelection;
  protected final String[] mSelectionArgs;

  public j(Context paramContext, Uri paramUri)
  {
    this(paramContext, paramUri, null, null);
  }

  public j(Context paramContext, Uri paramUri, long paramLong)
  {
    this(paramContext, ContentUris.withAppendedId(paramUri, paramLong), null, null);
    if (paramLong == -1L)
    {
      Hl = false;
      Log.w(TAG, "Invalid for update");
    }
  }

  public j(Context paramContext, Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    super(paramContext, paramUri);
    mSelection = paramString;
    mSelectionArgs = paramArrayOfString;
  }

  public j(Context paramContext, Uri paramUri, List<Long> paramList)
  {
    this(paramContext, paramUri, "_id IN ( " + TextUtils.join(",", paramList) + " )", null);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      Hl = false;
      Log.w(TAG, "Bulk operation requires non null/empty id list.");
    }
  }

  protected Void doInBackground(Void[] paramArrayOfVoid)
  {
    if ((mContext != null) && (Hl))
      mContext.getContentResolver().update(mUri, kp, mSelection, mSelectionArgs);
    return null;
  }
}