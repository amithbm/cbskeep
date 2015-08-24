package com.google.android.gms.people;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;

public abstract interface Notifications
{
  public abstract PendingResult<Result> registerOnDataChangedListenerForAllOwners(GoogleApiClient paramGoogleApiClient, OnDataChanged paramOnDataChanged, int paramInt);

  public static abstract interface OnDataChanged
  {
    public abstract void onDataChanged(String paramString1, String paramString2, int paramInt);
  }
}