package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult;
import java.util.ArrayList;
import java.util.List;

public final class zzax
  implements NodeApi
{
  public PendingResult<NodeApi.GetConnectedNodesResult> getConnectedNodes(GoogleApiClient paramGoogleApiClient)
  {
    return paramGoogleApiClient.zza(new zzf(paramGoogleApiClient)
    {
      protected void zza(zzbk paramAnonymouszzbk)
        throws RemoteException
      {
        paramAnonymouszzbk.zzF(this);
      }

      protected NodeApi.GetConnectedNodesResult zzdH(Status paramAnonymousStatus)
      {
        return new zzax.zzc(paramAnonymousStatus, new ArrayList());
      }
    });
  }

  public static class zzc
    implements NodeApi.GetConnectedNodesResult
  {
    private final Status zzOQ;
    private final List<Node> zzbIq;

    public zzc(Status paramStatus, List<Node> paramList)
    {
      zzOQ = paramStatus;
      zzbIq = paramList;
    }

    public List<Node> getNodes()
    {
      return zzbIq;
    }

    public Status getStatus()
    {
      return zzOQ;
    }
  }
}