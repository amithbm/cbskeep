package com.google.android.keep.task;

import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.os.AsyncTask;
import android.os.RemoteException;
import com.google.android.keep.provider.i.m;
import com.google.android.keep.util.r;
import java.util.ArrayList;

public class b extends AsyncTask<Void, Void, Void>
{
  private long[] GB;
  private final long cU;
  private String[] fX;
  private Context mContext;

  public b(Context paramContext, long paramLong, String[] paramArrayOfString, long[] paramArrayOfLong)
  {
    mContext = paramContext;
    cU = paramLong;
    fX = paramArrayOfString;
    GB = paramArrayOfLong;
  }

  protected Void doInBackground(Void[] paramArrayOfVoid)
  {
    if ((fX == null) || (GB == null) || (fX.length != GB.length) || (cU == -1L))
      return null;
    paramArrayOfVoid = mContext.getContentResolver();
    ArrayList localArrayList = new ArrayList();
    long l = cU;
    int i = 0;
    while (i < fX.length)
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("order_in_parent", Long.valueOf(GB[i]));
      String str = fX[i];
      localArrayList.add(ContentProviderOperation.newUpdate(i.m.CONTENT_URI).withSelection("uuid=? AND account_id=?", new String[] { str, String.valueOf(l) }).withValues(localContentValues).build());
      i += 1;
    }
    if (localArrayList.size() > 0);
    try
    {
      paramArrayOfVoid.applyBatch("com.google.android.keep", localArrayList);
      return null;
    }
    catch (OperationApplicationException paramArrayOfVoid)
    {
      while (true)
        r.e("Keep", "Error in caching realtime document job: ", new Object[] { paramArrayOfVoid });
    }
    catch (RemoteException paramArrayOfVoid)
    {
      while (true)
        r.e("Keep", "Error in caching realtime document job: ", new Object[] { paramArrayOfVoid });
    }
  }
}