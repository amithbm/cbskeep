package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.AncsApi.AncsListener;
import com.google.android.gms.wearable.CapabilityApi.CapabilityListener;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.NodeApi.ConnectedNodesListener;
import com.google.android.gms.wearable.NodeApi.NodeListener;
import java.util.List;

final class zzbl<T> extends zzas.zza
{
  private final IntentFilter[] zzbHP;
  private final String zzbHc;
  private AncsApi.AncsListener zzbIH;
  private DataApi.DataListener zzbII;
  private MessageApi.MessageListener zzbIJ;
  private NodeApi.NodeListener zzbIK;
  private NodeApi.ConnectedNodesListener zzbIL;
  private ChannelApi.ChannelListener zzbIM;
  private CapabilityApi.CapabilityListener zzbIN;
  private final String zzbIO;

  public void clear()
  {
    zzbIH = null;
    zzbII = null;
    zzbIJ = null;
    zzbIK = null;
    zzbIL = null;
    zzbIM = null;
    zzbIN = null;
  }

  public void onConnectedNodes(List<NodeParcelable> paramList)
  {
    if (zzbIL != null)
      zzbIL.onConnectedNodes(paramList);
  }

  public IntentFilter[] zzGY()
  {
    return zzbHP;
  }

  public String zzGZ()
  {
    return zzbIO;
  }

  public String zzHa()
  {
    return zzbHc;
  }

  public void zza(AncsNotificationParcelable paramAncsNotificationParcelable)
  {
    if (zzbIH != null)
      zzbIH.onNotificationReceived(paramAncsNotificationParcelable);
  }

  public void zza(CapabilityInfoParcelable paramCapabilityInfoParcelable)
  {
    if (zzbIN != null)
      zzbIN.onCapabilityChanged(paramCapabilityInfoParcelable);
  }

  public void zza(ChannelEventParcelable paramChannelEventParcelable)
  {
    if (zzbIM != null)
      paramChannelEventParcelable.zza(zzbIM);
  }

  public void zza(MessageEventParcelable paramMessageEventParcelable)
  {
    if (zzbIJ != null)
      zzbIJ.onMessageReceived(paramMessageEventParcelable);
  }

  public void zza(NodeParcelable paramNodeParcelable)
  {
    if (zzbIK != null)
      zzbIK.onPeerConnected(paramNodeParcelable);
  }

  public void zzam(DataHolder paramDataHolder)
  {
    if (zzbII != null)
      try
      {
        zzbII.onDataChanged(new DataEventBuffer(paramDataHolder));
        return;
      }
      finally
      {
        paramDataHolder.close();
      }
    paramDataHolder.close();
  }

  public void zzb(NodeParcelable paramNodeParcelable)
  {
    if (zzbIK != null)
      zzbIK.onPeerDisconnected(paramNodeParcelable);
  }
}