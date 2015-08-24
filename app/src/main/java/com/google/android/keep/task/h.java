package com.google.android.keep.task;

import android.accounts.Account;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import com.google.android.keep.provider.i.v;
import com.google.android.keep.util.u;
import com.google.common.base.Preconditions;

public class h extends AsyncTask<Void, Void, Void>
{
  private final Account mAccount;
  protected final Context mContext;
  private final long uy;

  public h(Context paramContext, Account paramAccount, long paramLong)
  {
    Preconditions.checkNotNull(paramContext);
    Preconditions.checkNotNull(paramAccount);
    mContext = paramContext;
    mAccount = paramAccount;
    uy = paramLong;
  }

  private boolean lu()
  {
    if (uy == -1L);
    Object localObject;
    do
    {
      return true;
      localObject = ContentUris.withAppendedId(i.v.CONTENT_URI, uy);
      localObject = com.google.android.keep.util.h.a(mContext.getContentResolver(), (Uri)localObject, "is_dirty", null, null);
    }
    while ((localObject != null) && (((Integer)localObject).intValue() == 1));
    return false;
  }

  protected Void doInBackground(Void[] paramArrayOfVoid)
  {
    if (!lu())
      return null;
    paramArrayOfVoid = new Bundle();
    paramArrayOfVoid.putBoolean("expedited", true);
    ContentResolver.requestSync(mAccount, "com.google.android.keep", paramArrayOfVoid);
    return null;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof h));
    do
    {
      return false;
      paramObject = (h)paramObject;
    }
    while ((!u.equals(paramObject.mAccount, mAccount)) || (paramObject.uy != uy));
    return true;
  }
}