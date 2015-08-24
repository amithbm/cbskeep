package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza.zza;
import com.google.android.gms.drive.Drive;

public abstract class zzr<R extends Result> extends zza.zza<R, zzs>
{
  public zzr(GoogleApiClient paramGoogleApiClient)
  {
    super(Drive.CLIENT_KEY, paramGoogleApiClient);
  }

  public static abstract class zza extends zzr<Status>
  {
    public zza(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }

    protected Status zze(Status paramStatus)
    {
      return paramStatus;
    }
  }
}