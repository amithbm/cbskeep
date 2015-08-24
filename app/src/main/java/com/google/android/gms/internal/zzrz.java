package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.people.Notifications;
import com.google.android.gms.people.Notifications.OnDataChanged;
import com.google.android.gms.people.People.zzb;
import com.google.android.gms.people.internal.zzl;
import com.google.android.gms.people.internal.zzn;

public class zzrz
  implements Notifications
{
  private PendingResult<Result> zzb(final GoogleApiClient paramGoogleApiClient, final Notifications.OnDataChanged paramOnDataChanged, final String paramString1, final String paramString2, final int paramInt)
  {
    return paramGoogleApiClient.zza(new People.zzb(paramGoogleApiClient)
    {
      protected void zza(zzn paramAnonymouszzn)
        throws RemoteException
      {
        paramAnonymouszzn.zza(paramGoogleApiClient, paramOnDataChanged, paramString1, paramString2, paramInt);
        setResult(Status.zzaii);
      }
    });
  }

  public PendingResult<Result> registerOnDataChangedListenerForAllOwners(GoogleApiClient paramGoogleApiClient, Notifications.OnDataChanged paramOnDataChanged, int paramInt)
  {
    if (zzl.isEnabled())
      zzl.zzh("registerOnDataChangedListenerForAllOwners", new Object[] { Integer.valueOf(paramInt) });
    return zzb(paramGoogleApiClient, paramOnDataChanged, null, null, paramInt);
  }
}