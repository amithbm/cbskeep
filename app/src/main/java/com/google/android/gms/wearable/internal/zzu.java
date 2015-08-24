package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import com.google.android.gms.wearable.DataApi.DeleteDataItemsResult;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.PutDataRequest;

public final class zzu
  implements DataApi
{
  public PendingResult<DataApi.DeleteDataItemsResult> deleteDataItems(GoogleApiClient paramGoogleApiClient, Uri paramUri)
  {
    return deleteDataItems(paramGoogleApiClient, paramUri, 0);
  }

  public PendingResult<DataApi.DeleteDataItemsResult> deleteDataItems(GoogleApiClient paramGoogleApiClient, final Uri paramUri, final int paramInt)
  {
    return paramGoogleApiClient.zza(new zzf(paramGoogleApiClient)
    {
      protected void zza(zzbk paramAnonymouszzbk)
        throws RemoteException
      {
        paramAnonymouszzbk.zzb(this, paramUri, paramInt);
      }

      protected DataApi.DeleteDataItemsResult zzdC(Status paramAnonymousStatus)
      {
        return new zzu.zzc(paramAnonymousStatus, 0);
      }
    });
  }

  public PendingResult<DataApi.DataItemResult> getDataItem(GoogleApiClient paramGoogleApiClient, final Uri paramUri)
  {
    return paramGoogleApiClient.zza(new zzf(paramGoogleApiClient)
    {
      protected void zza(zzbk paramAnonymouszzbk)
        throws RemoteException
      {
        paramAnonymouszzbk.zza(this, paramUri);
      }

      protected DataApi.DataItemResult zzdA(Status paramAnonymousStatus)
      {
        return new zzu.zzb(paramAnonymousStatus, null);
      }
    });
  }

  public PendingResult<DataApi.DataItemResult> putDataItem(GoogleApiClient paramGoogleApiClient, final PutDataRequest paramPutDataRequest)
  {
    return paramGoogleApiClient.zza(new zzf(paramGoogleApiClient)
    {
      protected void zza(zzbk paramAnonymouszzbk)
        throws RemoteException
      {
        paramAnonymouszzbk.zza(this, paramPutDataRequest);
      }

      public DataApi.DataItemResult zzdA(Status paramAnonymousStatus)
      {
        return new zzu.zzb(paramAnonymousStatus, null);
      }
    });
  }

  public static class zzb
    implements DataApi.DataItemResult
  {
    private final Status zzOQ;
    private final DataItem zzbHQ;

    public zzb(Status paramStatus, DataItem paramDataItem)
    {
      zzOQ = paramStatus;
      zzbHQ = paramDataItem;
    }

    public DataItem getDataItem()
    {
      return zzbHQ;
    }

    public Status getStatus()
    {
      return zzOQ;
    }
  }

  public static class zzc
    implements DataApi.DeleteDataItemsResult
  {
    private final Status zzOQ;
    private final int zzbHR;

    public zzc(Status paramStatus, int paramInt)
    {
      zzOQ = paramStatus;
      zzbHR = paramInt;
    }

    public Status getStatus()
    {
      return zzOQ;
    }
  }
}