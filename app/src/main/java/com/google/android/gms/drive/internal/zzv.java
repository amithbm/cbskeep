package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveFirstPartyApi;
import com.google.android.gms.drive.RealtimeDocumentSyncRequest;
import java.util.List;

public class zzv
  implements DriveFirstPartyApi
{
  public PendingResult<Status> requestRealtimeDocumentSync(GoogleApiClient paramGoogleApiClient, final List<String> paramList1, final List<String> paramList2)
  {
    return paramGoogleApiClient.zzb(new zzr.zza(paramGoogleApiClient)
    {
      protected void zza(zzs paramAnonymouszzs)
        throws RemoteException
      {
        paramAnonymouszzs.zzsS().zza(new RealtimeDocumentSyncRequest(paramList1, paramList2), new zzbq(this));
      }
    });
  }
}