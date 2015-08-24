package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.view.View;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzvh;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class zzf
{
  private final Account zzMF;
  private final String zzOY;
  private final String zzOZ;
  private final Set<Scope> zzagP;
  private final int zzagQ;
  private final View zzagR;
  private final Set<Scope> zzakY;
  private final Map<Api<?>, zza> zzakZ;
  private final zzvh zzala;
  private Integer zzalb;

  public zzf(Account paramAccount, Collection<Scope> paramCollection, Map<Api<?>, zza> paramMap, int paramInt, View paramView, String paramString1, String paramString2, zzvh paramzzvh)
  {
    zzMF = paramAccount;
    if (paramCollection == null);
    for (paramAccount = Collections.EMPTY_SET; ; paramAccount = Collections.unmodifiableSet(new HashSet(paramCollection)))
    {
      zzagP = paramAccount;
      paramAccount = paramMap;
      if (paramMap == null)
        paramAccount = Collections.EMPTY_MAP;
      zzakZ = paramAccount;
      zzagR = paramView;
      zzagQ = paramInt;
      zzOZ = paramString1;
      zzOY = paramString2;
      zzala = paramzzvh;
      paramAccount = new HashSet(zzagP);
      paramCollection = zzakZ.values().iterator();
      while (paramCollection.hasNext())
        paramAccount.addAll(((zza)paramCollection.next()).zzahd);
    }
    zzakY = Collections.unmodifiableSet(paramAccount);
  }

  public Account getAccount()
  {
    return zzMF;
  }

  @Deprecated
  public String getAccountName()
  {
    if (zzMF != null)
      return zzMF.name;
    return null;
  }

  public void zzb(Integer paramInteger)
  {
    zzalb = paramInteger;
  }

  public String zzpA()
  {
    return zzOZ;
  }

  public String zzpB()
  {
    return zzOY;
  }

  public zzvh zzpD()
  {
    return zzala;
  }

  public Integer zzpE()
  {
    return zzalb;
  }

  public Account zzpv()
  {
    if (zzMF != null)
      return zzMF;
    return new Account("<<default account>>", "com.google");
  }

  public Set<Scope> zzpx()
  {
    return zzagP;
  }

  public Set<Scope> zzpy()
  {
    return zzakY;
  }

  public Map<Api<?>, zza> zzpz()
  {
    return zzakZ;
  }

  public static final class zza
  {
    public final Set<Scope> zzahd;
    public final boolean zzalc;
  }
}