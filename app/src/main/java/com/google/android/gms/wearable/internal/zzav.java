package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.MessageApi.SendMessageResult;

public final class zzav
  implements MessageApi
{
  public PendingResult<MessageApi.SendMessageResult> sendMessage(GoogleApiClient paramGoogleApiClient, final String paramString1, final String paramString2, final byte[] paramArrayOfByte)
  {
    return paramGoogleApiClient.zza(new zzf(paramGoogleApiClient)
    {
      protected void zza(zzbk paramAnonymouszzbk)
        throws RemoteException
      {
        paramAnonymouszzbk.zza(this, paramString1, paramString2, paramArrayOfByte);
      }

      protected MessageApi.SendMessageResult zzdF(Status paramAnonymousStatus)
      {
        return new zzav.zzb(paramAnonymousStatus, -1);
      }
    });
  }

  public static class zzb
    implements MessageApi.SendMessageResult
  {
    private final Status zzOQ;
    private final int zzasp;

    public zzb(Status paramStatus, int paramInt)
    {
      zzOQ = paramStatus;
      zzasp = paramInt;
    }

    public Status getStatus()
    {
      return zzOQ;
    }
  }
}