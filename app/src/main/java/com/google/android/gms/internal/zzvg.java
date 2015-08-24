package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.signin.internal.zze;
import java.util.Set;

public abstract interface zzvg extends Api.Client
{
  public abstract void connect();

  public abstract void zzCw();

  public abstract void zza(IAccountAccessor paramIAccountAccessor, Set<Scope> paramSet, zze paramzze);

  public abstract void zza(IAccountAccessor paramIAccountAccessor, boolean paramBoolean);

  public abstract void zza(zzr paramzzr);
}