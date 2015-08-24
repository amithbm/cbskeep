package com.google.android.gms.wearable;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import java.util.List;

public abstract interface NodeApi
{
  public abstract PendingResult<GetConnectedNodesResult> getConnectedNodes(GoogleApiClient paramGoogleApiClient);

  public static abstract interface ConnectedNodesListener
  {
    public abstract void onConnectedNodes(List<Node> paramList);
  }

  public static abstract interface GetConnectedNodesResult extends Result
  {
    public abstract List<Node> getNodes();
  }

  public static abstract interface NodeListener
  {
    public abstract void onPeerConnected(Node paramNode);

    public abstract void onPeerDisconnected(Node paramNode);
  }
}