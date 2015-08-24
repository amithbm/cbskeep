package com.google.android.keep.microapp;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult;
import com.google.android.gms.wearable.Wearable;
import com.google.android.keep.V;
import com.google.android.keep.util.A;
import com.google.android.keep.util.j;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WearableDataChangedService extends IntentService
{
  public WearableDataChangedService()
  {
    super(WearableDataChangedService.class.getSimpleName());
  }

  protected void onHandleIntent(Intent paramIntent)
  {
    if (paramIntent == null)
      return;
    paramIntent = V.A(this);
    paramIntent.blockingConnect(5000L, TimeUnit.MILLISECONDS);
    if (!paramIntent.isConnected())
    {
      Log.w("KeepMicroApp", "GoogleApiClient failed to connect");
      return;
    }
    while (true)
    {
      int i;
      boolean bool;
      try
      {
        List localList = ((NodeApi.GetConnectedNodesResult)j.b(Wearable.NodeApi.getConnectedNodes(paramIntent))).getNodes();
        if ((localList != null) && (!localList.isEmpty()))
        {
          i = 1;
          break label125;
          A.h(this, bool);
          if (i != 0)
            d.a(this, paramIntent);
        }
        else
        {
          i = 0;
          break label125;
          bool = false;
          continue;
        }
      }
      finally
      {
        paramIntent.disconnect();
      }
      label125: if (i == 0)
        bool = true;
    }
  }
}