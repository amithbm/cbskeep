package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import com.google.android.gms.auth.api.signin.IdProvider;
import com.google.android.gms.auth.api.signin.internal.IdpTokenType;
import com.google.android.gms.common.internal.zzv;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class zzkj
  implements zzki
{
  private String zzRF;
  protected final Activity zzRJ;
  protected final Set<String> zzRK;
  private zzki.zza zzRL;
  private String zzRo;

  protected zzkj(Activity paramActivity, List<String> paramList1, List<String> paramList2)
  {
    zzRJ = ((Activity)zzv.zzz(paramActivity));
    paramActivity = new HashSet((Collection)zzv.zzz(paramList1));
    paramActivity.addAll((Collection)zzv.zzz(paramList2));
    zzRK = Collections.unmodifiableSet(paramActivity);
  }

  protected Intent zza(IdpTokenType paramIdpTokenType, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent("com.google.android.gms.auth.VERIFY_ASSERTION");
    localIntent.putExtra("idpTokenType", paramIdpTokenType);
    localIntent.putExtra("idpToken", paramString1);
    localIntent.putExtra("pendingToken", paramString2);
    paramIdpTokenType = getIdProvider();
    if (paramIdpTokenType != null)
      localIntent.putExtra("idProvider", paramIdpTokenType.getProviderId());
    return localIntent;
  }

  protected void zzb(zzki.zza paramzza)
  {
    zzRL = paramzza;
  }

  protected void zzb(String paramString1, String paramString2, zzki.zza paramzza)
  {
    zzbh(paramString1);
    zzbi(paramString2);
    zzb(paramzza);
  }

  protected void zzbh(String paramString)
  {
    zzRo = paramString;
  }

  protected void zzbi(String paramString)
  {
    zzRF = paramString;
  }

  protected Set<String> zzld()
  {
    return zzRK;
  }

  protected zzki.zza zzle()
  {
    return zzRL;
  }

  protected String zzlf()
  {
    return zzRF;
  }
}