package com.google.android.keep.task;

import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentResolver;
import android.content.Context;
import android.content.OperationApplicationException;
import android.os.AsyncTask;
import android.os.RemoteException;
import com.google.android.keep.model.j;
import com.google.android.keep.provider.i.o;
import com.google.android.keep.util.r;
import com.google.api.client.repackaged.com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.List;

public class i extends AsyncTask<Void, Void, Void>
{
  private static final String TAG = i.class.getSimpleName();
  private long Hi = -1L;
  private String Hj = null;
  private long Hk = -1L;
  private long cU = -1L;
  private final Context mContext;
  private final ContentResolver mResolver;

  public i(Context paramContext)
  {
    mContext = paramContext;
    mResolver = paramContext.getContentResolver();
  }

  private void a(List<ContentProviderOperation> paramList, String paramString, String[] paramArrayOfString)
  {
    paramList.add(ContentProviderOperation.newDelete(i.o.Cv).withSelection(paramString, paramArrayOfString).build());
  }

  protected Void doInBackground(Void[] paramArrayOfVoid)
  {
    paramArrayOfVoid = new ArrayList();
    if (Hi != -1L)
      a(paramArrayOfVoid, "tree_entity_id=?", new String[] { String.valueOf(Hi) });
    if ((Hj != null) && (j.u(cU)))
      a(paramArrayOfVoid, "code=? AND account_id=?", new String[] { Hj, String.valueOf(cU) });
    while (true)
    {
      if (Hk >= 0L)
      {
        long l = Hk;
        paramArrayOfVoid.add(ContentProviderOperation.newUpdate(i.o.Cv).withSelection("_id =?", new String[] { String.valueOf(l) }).withValue("dismissed", Integer.valueOf(1)).build());
      }
      if (paramArrayOfVoid.size() > 0);
      try
      {
        mResolver.applyBatch("com.google.android.keep", paramArrayOfVoid);
        return null;
        if (Hj == null)
          continue;
        a(paramArrayOfVoid, "code=?", new String[] { Hj });
      }
      catch (OperationApplicationException paramArrayOfVoid)
      {
        while (true)
          r.e(TAG, "OperationApplicationException while deleting note errors", new Object[] { paramArrayOfVoid });
      }
      catch (RemoteException paramArrayOfVoid)
      {
        while (true)
          r.e(TAG, "RemoteException while deleting note errors", new Object[] { paramArrayOfVoid });
      }
    }
  }

  public i e(String paramString, long paramLong)
  {
    Preconditions.checkArgument(j.u(paramLong));
    Hj = paramString;
    cU = paramLong;
    return this;
  }
}