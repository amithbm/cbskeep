package com.google.android.keep.db;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.Context;
import android.content.OperationApplicationException;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gsf.GservicesValue;
import com.google.android.keep.model.j;
import com.google.android.keep.model.w;
import com.google.android.keep.task.h;
import com.google.android.keep.util.Config;
import com.google.android.keep.util.o;
import com.google.api.client.util.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class a
  implements Runnable
{
  private final Set<w> kv = new LinkedHashSet();
  private final Context mContext;
  private final Handler mHandler = new Handler();

  public a(Context paramContext)
  {
    mContext = paramContext;
  }

  private ArrayList<ContentProviderOperation> a(ArrayList<DbOperation> paramArrayList)
  {
    ArrayList localArrayList = Lists.newArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
      localArrayList.add(((DbOperation)paramArrayList.next()).dc());
    return localArrayList;
  }

  private void a(String paramString, ArrayList<DbOperation> paramArrayList, int paramInt)
  {
    if ((paramArrayList.size() == paramInt) || (!((Boolean)Config.Pe.get()).booleanValue()))
      return;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("From ").append(paramString).append(".onSave()\n");
    while (paramInt < paramArrayList.size())
    {
      localStringBuilder.append("    ").append(((DbOperation)paramArrayList.get(paramInt)).toString()).append("\n");
      paramInt += 1;
    }
    Log.w("DbOperationScheduler", localStringBuilder.toString());
  }

  private void a(ArrayList<ContentProviderOperation> paramArrayList, ContentResolver paramContentResolver, a parama)
  {
    try
    {
      paramContentResolver.applyBatch("com.google.android.keep", paramArrayList);
      if (parama.dd())
        new h(mContext, o.O(mContext).hl(), -1L).execute(new Void[0]);
      return;
    }
    catch (OperationApplicationException paramArrayList)
    {
      while (true)
        Log.e("DbOperationScheduler", "Error in committing list item to database job: ", paramArrayList);
    }
    catch (RemoteException paramArrayList)
    {
      label49: break label49;
    }
  }

  public void a(final a parama)
  {
    if (parama == null)
      parama = new a();
    final ContentResolver localContentResolver;
    final ArrayList localArrayList;
    while (true)
    {
      localContentResolver = mContext.getContentResolver();
      localArrayList = Lists.newArrayList();
      Iterator localIterator = kv.iterator();
      while (localIterator.hasNext())
      {
        w localw = (w)localIterator.next();
        int i = localArrayList.size();
        localw.j(localArrayList);
        a(localw.getClass().getSimpleName(), localArrayList, i);
      }
    }
    kv.clear();
    if (localArrayList.size() > 0)
    {
      localArrayList = a(localArrayList);
      if (parama.de())
        new AsyncTask()
        {
          protected Void doInBackground(Void[] paramAnonymousArrayOfVoid)
          {
            a.a(a.this, localArrayList, localContentResolver, parama);
            return null;
          }
        }
        .execute(new Void[0]);
    }
    else
    {
      return;
    }
    a(localArrayList, localContentResolver, parama);
  }

  public void a(w paramw)
  {
    kv.add(paramw);
    mHandler.removeCallbacks(this);
    mHandler.postDelayed(this, Config.nG());
  }

  public void a(w paramw, a parama)
  {
    a(paramw);
    a(parama);
  }

  public void flush()
  {
    a(null);
  }

  public void run()
  {
    flush();
  }

  public static class a
  {
    private boolean kA = true;
    private boolean kB = false;

    public boolean dd()
    {
      return kB;
    }

    public boolean de()
    {
      return kA;
    }

    public a t(boolean paramBoolean)
    {
      kB = paramBoolean;
      return this;
    }

    public a u(boolean paramBoolean)
    {
      kA = paramBoolean;
      return this;
    }
  }
}