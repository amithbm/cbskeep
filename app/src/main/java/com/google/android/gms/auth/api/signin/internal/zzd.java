package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.auth.api.signin.FacebookSignInConfig;
import com.google.android.gms.auth.api.signin.GoogleSignInConfig;
import com.google.android.gms.auth.api.signin.IdProvider;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class zzd
{
  public static void zza(Configuration paramConfiguration, List<IdProvider> paramList, Map<IdProvider, List<String>> paramMap)
  {
    Object localObject = paramConfiguration.zzkV();
    if (localObject != null)
    {
      paramList.add(IdProvider.GOOGLE);
      LinkedList localLinkedList = new LinkedList();
      localObject = ((GoogleSignInConfig)localObject).getScopes().iterator();
      while (((Iterator)localObject).hasNext())
        localLinkedList.add(((Scope)((Iterator)localObject).next()).zzoU());
      paramMap.put(IdProvider.GOOGLE, localLinkedList);
    }
    paramConfiguration = paramConfiguration.zzkW();
    if (paramConfiguration != null)
    {
      paramList.add(IdProvider.FACEBOOK);
      paramList = new LinkedList();
      paramConfiguration = paramConfiguration.getScopes().iterator();
      while (paramConfiguration.hasNext())
        paramList.add((String)paramConfiguration.next());
      paramMap.put(IdProvider.FACEBOOK, paramList);
    }
  }
}