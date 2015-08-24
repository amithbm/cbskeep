package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.GoogleApiClient.ServerAuthCodeCallbacks;

public final class zzvh
  implements Api.ApiOptions.Optional
{
  public static final zzvh zzbqK = new zza().zzCA();
  private final String zzRr;
  private final boolean zzbqL;
  private final boolean zzbqM;
  private final GoogleApiClient.ServerAuthCodeCallbacks zzbqN;

  private zzvh(boolean paramBoolean1, boolean paramBoolean2, String paramString, GoogleApiClient.ServerAuthCodeCallbacks paramServerAuthCodeCallbacks)
  {
    zzbqL = paramBoolean1;
    zzbqM = paramBoolean2;
    zzRr = paramString;
    zzbqN = paramServerAuthCodeCallbacks;
  }

  public boolean zzCx()
  {
    return zzbqL;
  }

  public boolean zzCy()
  {
    return zzbqM;
  }

  public GoogleApiClient.ServerAuthCodeCallbacks zzCz()
  {
    return zzbqN;
  }

  public String zzkT()
  {
    return zzRr;
  }

  public static final class zza
  {
    private String zzbiM;
    private boolean zzbqO;
    private boolean zzbqP;
    private GoogleApiClient.ServerAuthCodeCallbacks zzbqQ;

    public zzvh zzCA()
    {
      return new zzvh(zzbqO, zzbqP, zzbiM, zzbqQ, null);
    }
  }
}