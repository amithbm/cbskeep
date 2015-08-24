package com.google.android.keep.task;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;

public abstract class a extends AsyncTask<Void, Void, Void>
{
  protected final ContentValues kp = new ContentValues();
  protected final Context mContext;
  protected final Uri mUri;

  public a(Context paramContext, Uri paramUri)
  {
    mContext = paramContext;
    mUri = paramUri;
  }

  public a b(String paramString, Integer paramInteger)
  {
    kp.put(paramString, paramInteger);
    return this;
  }

  public a l(String paramString1, String paramString2)
  {
    kp.put(paramString1, paramString2);
    return this;
  }
}