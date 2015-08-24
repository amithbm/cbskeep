package com.google.android.gms.auth.api.signin;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import com.google.android.gms.R.string;

public enum IdProvider
{
  private final String zzRl;
  private final int zzRm;

  private IdProvider(String paramString, int paramInt)
  {
    zzRl = paramString;
    zzRm = paramInt;
  }

  public static IdProvider fromProviderId(String paramString)
  {
    if (paramString != null)
    {
      IdProvider[] arrayOfIdProvider = values();
      int j = arrayOfIdProvider.length;
      int i = 0;
      while (i < j)
      {
        IdProvider localIdProvider = arrayOfIdProvider[i];
        if (localIdProvider.getProviderId().equals(paramString))
          return localIdProvider;
        i += 1;
      }
      Log.w("IdProvider", "Unrecognized providerId: " + paramString);
    }
    return null;
  }

  public CharSequence getDisplayName(Context paramContext)
  {
    return paramContext.getResources().getString(zzRm);
  }

  public String getProviderId()
  {
    return zzRl;
  }

  public String toString()
  {
    return zzRl;
  }
}