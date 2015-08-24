package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza.zzb;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import com.google.android.gms.wearable.DataApi.DeleteDataItemsResult;
import com.google.android.gms.wearable.MessageApi.SendMessageResult;
import com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.FutureTask;

final class zzbj
{
  static abstract class zzb<T> extends zza
  {
    private zza.zzb<T> zzOF;

    public zzb(zza.zzb<T> paramzzb)
    {
      zzOF = paramzzb;
    }

    public void zzZ(T paramT)
    {
      zza.zzb localzzb = zzOF;
      if (localzzb != null)
      {
        localzzb.zzq(paramT);
        zzOF = null;
      }
    }
  }

  static final class zze extends zzbj.zzb<DataApi.DeleteDataItemsResult>
  {
    public zze(zza.zzb<DataApi.DeleteDataItemsResult> paramzzb)
    {
      super();
    }

    public void zza(DeleteDataItemsResponse paramDeleteDataItemsResponse)
    {
      zzZ(new zzu.zzc(zzbg.zzju(paramDeleteDataItemsResponse.statusCode), paramDeleteDataItemsResponse.zzbHV));
    }
  }

  static final class zzn extends zzbj.zzb<NodeApi.GetConnectedNodesResult>
  {
    public zzn(zza.zzb<NodeApi.GetConnectedNodesResult> paramzzb)
    {
      super();
    }

    public void zza(GetConnectedNodesResponse paramGetConnectedNodesResponse)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(paramGetConnectedNodesResponse.zzbIc);
      zzZ(new zzax.zzc(zzbg.zzju(paramGetConnectedNodesResponse.statusCode), localArrayList));
    }
  }

  static final class zzo extends zzbj.zzb<DataApi.DataItemResult>
  {
    public zzo(zza.zzb<DataApi.DataItemResult> paramzzb)
    {
      super();
    }

    public void zza(GetDataItemResponse paramGetDataItemResponse)
    {
      zzZ(new zzu.zzb(zzbg.zzju(paramGetDataItemResponse.statusCode), paramGetDataItemResponse.zzbId));
    }
  }

  static final class zzs extends zza
  {
    public void zzb(Status paramStatus)
    {
    }
  }

  static final class zzu extends zzbj.zzb<DataApi.DataItemResult>
  {
    private final List<FutureTask<Boolean>> zzxh;

    zzu(zza.zzb<DataApi.DataItemResult> paramzzb, List<FutureTask<Boolean>> paramList)
    {
      super();
      zzxh = paramList;
    }

    public void zza(PutDataResponse paramPutDataResponse)
    {
      zzZ(new zzu.zzb(zzbg.zzju(paramPutDataResponse.statusCode), paramPutDataResponse.zzbId));
      if (paramPutDataResponse.statusCode != 0)
      {
        paramPutDataResponse = zzxh.iterator();
        while (paramPutDataResponse.hasNext())
          ((FutureTask)paramPutDataResponse.next()).cancel(true);
      }
    }
  }

  static final class zzx extends zzbj.zzb<MessageApi.SendMessageResult>
  {
    public zzx(zza.zzb<MessageApi.SendMessageResult> paramzzb)
    {
      super();
    }

    public void zza(SendMessageResponse paramSendMessageResponse)
    {
      zzZ(new zzav.zzb(zzbg.zzju(paramSendMessageResponse.statusCode), paramSendMessageResponse.zzaQz));
    }
  }
}