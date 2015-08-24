package com.google.android.keep.notification;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.MessageApi.SendMessageResult;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult;
import com.google.android.gms.wearable.Wearable;
import com.google.android.keep.G;
import com.google.android.keep.V;
import com.google.android.keep.microapp.e;
import com.google.android.keep.util.r;
import com.google.protobuf.nano.MessageNano;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WearableNotificationOpenService extends IntentService
{
  public WearableNotificationOpenService()
  {
    super(WearableNotificationOpenService.class.getSimpleName());
  }

  protected void onHandleIntent(Intent paramIntent)
  {
    long l = paramIntent.getLongExtra("treeEntityId", -1L);
    if (l == -1L)
    {
      r.e("KeepMicroApp", "Invalid id", new Object[0]);
      return;
    }
    paramIntent = V.A(this);
    paramIntent.blockingConnect(5000L, TimeUnit.MILLISECONDS);
    if (!paramIntent.isConnected())
    {
      Log.e("KeepMicroApp", "GoogleApiClient failed to connect");
      return;
    }
    try
    {
      Object localObject1 = (NodeApi.GetConnectedNodesResult)Wearable.NodeApi.getConnectedNodes(paramIntent).await(5000L, TimeUnit.MILLISECONDS);
      if (!((NodeApi.GetConnectedNodesResult)localObject1).getStatus().isSuccess())
      {
        Log.w("KeepMicroApp", "Failed to get connected nodes, status=" + ((NodeApi.GetConnectedNodesResult)localObject1).getStatus());
        return;
      }
      Object localObject3 = ((NodeApi.GetConnectedNodesResult)localObject1).getNodes();
      localObject1 = e.a(this, l);
      if (localObject1 != null)
      {
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          Object localObject4 = (Node)((Iterator)localObject3).next();
          localObject4 = (MessageApi.SendMessageResult)Wearable.MessageApi.sendMessage(paramIntent, ((Node)localObject4).getId(), "/keep/open_editor", G.toByteArray((MessageNano)localObject1)).await(5000L, TimeUnit.MILLISECONDS);
          if (!((MessageApi.SendMessageResult)localObject4).getStatus().isSuccess())
            Log.e("KeepMicroApp", "Failed to send message to open note on watch=" + ((MessageApi.SendMessageResult)localObject4).getStatus());
        }
      }
    }
    finally
    {
      paramIntent.disconnect();
    }
    paramIntent.disconnect();
  }
}