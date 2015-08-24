package com.google.android.gms.common;

import android.content.Context;

public class GoogleApiAvailability
{
  public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE;
  private static final GoogleApiAvailability zzagd = new GoogleApiAvailability();

  public static GoogleApiAvailability getInstance()
  {
    return zzagd;
  }

  public void zzad(Context paramContext)
    throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException
  {
    GooglePlayServicesUtil.zzY(paramContext);
  }
}