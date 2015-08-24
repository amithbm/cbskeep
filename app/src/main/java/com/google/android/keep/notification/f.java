package com.google.android.keep.notification;

import android.app.PendingIntent;
import android.content.Context;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.Geofence.Builder;
import com.google.android.gms.location.GeofencingApi;
import com.google.android.gms.location.GeofencingRequest.Builder;
import com.google.android.gms.location.LocationServices;
import com.google.android.keep.location.c;
import com.google.android.keep.util.j;
import com.google.android.keep.util.r;
import com.google.common.collect.Lists;

class f extends a
{
  private final GoogleApiClient gh;
  private final Context mContext;

  public f(Context paramContext)
  {
    mContext = paramContext;
    paramContext = new c();
    gh = new GoogleApiClient.Builder(mContext).addApi(LocationServices.API).addOnConnectionFailedListener(paramContext).build();
  }

  public int a(PendingIntent paramPendingIntent)
  {
    if (!j.f(gh))
    {
      r.e("KeepAlert", "Failed to connect to Location services", new Object[0]);
      return 15;
    }
    try
    {
      Status localStatus = (Status)j.b(LocationServices.GeofencingApi.removeGeofences(gh, paramPendingIntent));
      r.a("KeepAlert", "Remove geo fence result with intent:" + paramPendingIntent + " statusCode:" + localStatus.getStatusCode(), new Object[0]);
      int i = localStatus.getStatusCode();
      return i;
    }
    finally
    {
      j.e(gh);
    }
    throw paramPendingIntent;
  }

  public int a(String paramString, double paramDouble1, double paramDouble2, float paramFloat, PendingIntent paramPendingIntent)
  {
    if (!j.f(gh))
    {
      r.e("KeepAlert", "Failed to connect to Location services", new Object[0]);
      return 15;
    }
    try
    {
      paramString = new Geofence.Builder().setRequestId(paramString).setCircularRegion(paramDouble1, paramDouble2, paramFloat).setTransitionTypes(1).setExpirationDuration(-1L).build();
      paramString = new GeofencingRequest.Builder().addGeofence(paramString).setInitialTrigger(0).build();
      paramString = (Status)j.b(LocationServices.GeofencingApi.addGeofences(gh, paramString, paramPendingIntent));
      r.a("KeepAlert", "Add geo fence result:" + paramString.getStatusCode(), new Object[0]);
      if (!paramString.isSuccess())
        r.e("KeepAlert", "Failed to add geofence. status: " + paramString.getStatusCode(), new Object[0]);
      int i = paramString.getStatusCode();
      return i;
    }
    finally
    {
      j.e(gh);
    }
    throw paramString;
  }

  public int az(String paramString)
  {
    if (!j.f(gh))
    {
      r.e("KeepAlert", "Failed to connect to Location services", new Object[0]);
      return 15;
    }
    try
    {
      Status localStatus = (Status)j.b(LocationServices.GeofencingApi.removeGeofences(gh, Lists.newArrayList(new String[] { paramString })));
      r.a("KeepAlert", "Remove geo fence result with id:" + paramString + " statusCode:" + localStatus.getStatusCode(), new Object[0]);
      int i = localStatus.getStatusCode();
      return i;
    }
    finally
    {
      j.e(gh);
    }
    throw paramString;
  }
}