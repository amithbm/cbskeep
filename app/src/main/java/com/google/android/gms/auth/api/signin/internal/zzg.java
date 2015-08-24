package com.google.android.gms.auth.api.signin.internal;

import android.app.Activity;
import com.google.android.gms.auth.api.signin.IdProvider;
import com.google.android.gms.internal.zzki;
import com.google.android.gms.internal.zzkk;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class zzg
{
  private final Map<IdProvider, zzki> zzRA;

  public zzg(Activity paramActivity, List<IdProvider> paramList, Map<IdProvider, List<String>> paramMap)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      IdProvider localIdProvider = (IdProvider)localIterator.next();
      List localList = (List)paramMap.get(localIdProvider);
      paramList = localList;
      if (localList == null)
        paramList = Collections.emptyList();
      paramList = zza(localIdProvider, paramActivity, paramList);
      if (paramList != null)
        localHashMap.put(localIdProvider, paramList);
    }
    zzRA = Collections.unmodifiableMap(localHashMap);
  }

  private zzki zza(IdProvider paramIdProvider, Activity paramActivity, List<String> paramList)
  {
    if (IdProvider.FACEBOOK.equals(paramIdProvider))
      return new zzkk(paramActivity, paramList);
    return null;
  }

  public zzki zza(IdProvider paramIdProvider)
  {
    return (zzki)zzRA.get(paramIdProvider);
  }

  public Collection<zzki> zzkY()
  {
    return zzRA.values();
  }
}