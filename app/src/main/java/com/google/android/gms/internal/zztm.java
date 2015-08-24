package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.zza.zza;
import com.google.android.gms.reminders.Reminders;

public abstract class zztm<R extends Result> extends zza.zza<R, zztj>
{
  public zztm(GoogleApiClient paramGoogleApiClient)
  {
    super(Reminders.CLIENT_KEY, paramGoogleApiClient);
  }
}