package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;

public class zza extends IAccountAccessor.zza
{
  private Context mContext;
  private Account zzMF;
  int zzoG;

  public static Account zza(IAccountAccessor paramIAccountAccessor)
  {
    Account localAccount = null;
    long l;
    if (paramIAccountAccessor != null)
      l = Binder.clearCallingIdentity();
    try
    {
      localAccount = paramIAccountAccessor.getAccount();
      return localAccount;
    }
    catch (RemoteException paramIAccountAccessor)
    {
      Log.w("AccountAccessor", "Remote account accessor probably died");
      return null;
    }
    finally
    {
      Binder.restoreCallingIdentity(l);
    }
    throw paramIAccountAccessor;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject)
      return true;
    if (!(paramObject instanceof zza))
      return false;
    return zzMF.equals(((zza)paramObject).zzMF);
  }

  public Account getAccount()
  {
    int i = Binder.getCallingUid();
    if (i == zzoG)
      return zzMF;
    if (GooglePlayServicesUtil.zze(mContext, i))
    {
      zzoG = i;
      return zzMF;
    }
    throw new SecurityException("Caller is not GooglePlayServices");
  }
}