package com.google.android.keep.syncadapter;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

public class KeepSyncAdapterService extends Service
{
  private static KeepSyncAdapter Gi = null;
  private static final Object Gj = new Object();

  public static KeepSyncAdapter D(Context paramContext)
  {
    synchronized (Gj)
    {
      if (Gi == null)
        Gi = new KeepSyncAdapter(paramContext);
      paramContext = Gi;
      return paramContext;
    }
  }

  public IBinder onBind(Intent paramIntent)
  {
    return D(getApplicationContext()).getSyncAdapterBinder();
  }

  public void onCreate()
  {
    D(getApplicationContext());
  }
}