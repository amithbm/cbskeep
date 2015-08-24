package com.google.android.keep.notification;

import android.app.PendingIntent;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlaceBuffer;
import com.google.android.gms.location.places.personalized.PlaceAlias;
import com.google.android.gms.location.places.personalized.PlaceUserData;
import com.google.android.gms.location.places.personalized.PlaceUserDataBuffer;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.reminders.model.Location.Builder;
import com.google.android.gms.reminders.model.Task;
import com.google.android.gms.reminders.model.TaskId;
import com.google.android.keep.I;
import com.google.android.keep.location.f;
import com.google.android.keep.model.Alert;
import com.google.android.keep.provider.i.a;
import com.google.android.keep.util.Config;
import com.google.android.keep.util.x;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;

public class b
{
  private static com.google.android.gms.reminders.model.Location a(Context paramContext, String paramString, int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 2))
      return null;
    paramString = com.google.android.keep.util.j.k(paramContext, paramString).build();
    try
    {
      com.google.android.keep.util.j.f(paramString);
      Object localObject1 = a(paramContext, paramString, paramInt);
      if (localObject1 == null)
        return null;
      paramContext = (PlaceBuffer)new f(paramContext, paramString, Lists.newArrayList(new String[] { localObject1 })).og();
      if (paramContext != null)
      {
        boolean bool = paramContext.getStatus().isSuccess();
        if (bool);
      }
      else
      {
        return null;
      }
      try
      {
        if (paramContext.getCount() > 0)
        {
          localObject1 = paramContext.get(0);
          localObject1 = new Location.Builder().setLat(Double.valueOf(((Place)localObject1).getLatLng().latitude)).setLng(Double.valueOf(((Place)localObject1).getLatLng().longitude)).build();
          paramContext.release();
          return localObject1;
        }
        paramContext.release();
        return null;
      }
      finally
      {
        paramContext.release();
      }
    }
    finally
    {
      com.google.android.keep.util.j.e(paramString);
    }
    throw paramContext;
  }

  private static String a(Context paramContext, GoogleApiClient paramGoogleApiClient, int paramInt)
  {
    paramContext = (PlaceUserDataBuffer)new com.google.android.keep.location.b(paramContext, paramGoogleApiClient).og();
    if ((paramContext == null) || (!paramContext.getStatus().isSuccess()))
      return null;
    try
    {
      paramGoogleApiClient = bz(paramInt);
      Iterator localIterator = paramContext.iterator();
      while (localIterator.hasNext())
      {
        PlaceUserData localPlaceUserData = (PlaceUserData)localIterator.next();
        if (localPlaceUserData.getPlaceAliases().contains(paramGoogleApiClient))
        {
          paramGoogleApiClient = localPlaceUserData.getPlaceId();
          return paramGoogleApiClient;
        }
      }
      return null;
    }
    finally
    {
      paramContext.release();
    }
    throw paramGoogleApiClient;
  }

  public static void a(Context paramContext, com.google.android.keep.model.j paramj, a parama, d paramd, Task paramTask)
  {
    if (!com.google.android.keep.location.a.o(paramContext));
    label7: Object localObject2;
    Object localObject1;
    do
    {
      do
      {
        do
        {
          break label7;
          do
            return;
          while (x.o(paramTask));
          localObject2 = paramTask.getLocation();
        }
        while (localObject2 == null);
        localObject1 = localObject2;
        if (((com.google.android.gms.reminders.model.Location)localObject2).getLocationType() != null)
          localObject1 = a(paramContext, paramj.getName(), ((com.google.android.gms.reminders.model.Location)localObject2).getLocationType().intValue());
      }
      while ((localObject1 == null) || (((com.google.android.gms.reminders.model.Location)localObject1).getLat() == null) || (((com.google.android.gms.reminders.model.Location)localObject1).getLng() == null));
      localObject2 = paramTask.getTaskId().getClientAssignedId();
      paramTask = Alert.a(paramContext.getContentResolver(), (String)localObject2);
    }
    while (paramTask == null);
    while (true)
    {
      try
      {
        Alert localAlert = Alert.a(paramTask, true);
        paramTask.close();
        if (localAlert.gv())
        {
          localAlert.E((String)localObject2);
          localAlert.m(paramj.getId());
        }
        I.a(paramContext, localAlert, 0);
        double d1 = ((com.google.android.gms.reminders.model.Location)localObject1).getLat().doubleValue();
        double d2 = ((com.google.android.gms.reminders.model.Location)localObject1).getLng().doubleValue();
        if (((com.google.android.gms.reminders.model.Location)localObject1).getRadiusMeters() != null)
        {
          i = ((com.google.android.gms.reminders.model.Location)localObject1).getRadiusMeters().intValue();
          a(paramContext, paramj, parama, paramd, localAlert, d1, d2, i);
          return;
        }
      }
      finally
      {
        paramTask.close();
      }
      int i = Config.nN();
    }
  }

  private static void a(Context paramContext, com.google.android.keep.model.j paramj, a parama, d paramd, Alert paramAlert, double paramDouble1, double paramDouble2, int paramInt)
  {
    int i = parama.a(String.valueOf(paramAlert.getId()), paramDouble1, paramDouble2, paramInt, c(paramContext, paramj.getId()));
    if (i == 1001)
    {
      I.a(paramContext, paramAlert, 5);
      paramd.bA(0);
    }
    do
    {
      do
      {
        return;
        if (i == 1000)
        {
          paramd.bA(1);
          return;
        }
        paramj = b(paramContext, paramj.getName());
      }
      while (paramj == null);
      parama = new float[1];
      android.location.Location.distanceBetween(paramj.getLatitude(), paramj.getLongitude(), paramDouble1, paramDouble2, parama);
    }
    while (parama[0] >= paramInt);
    I.a(paramContext, paramAlert, 4);
  }

  private static android.location.Location b(Context paramContext, String paramString)
  {
    paramContext = com.google.android.keep.util.j.k(paramContext, paramString).build();
    if (!com.google.android.keep.util.j.f(paramContext))
      return null;
    try
    {
      paramString = LocationServices.FusedLocationApi.getLastLocation(paramContext);
      return paramString;
    }
    finally
    {
      com.google.android.keep.util.j.e(paramContext);
    }
    throw paramString;
  }

  private static PlaceAlias bz(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return null;
    case 1:
      return PlaceAlias.HOME;
    case 2:
    }
    return PlaceAlias.WORK;
  }

  static PendingIntent c(Context paramContext, long paramLong)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(paramContext, AlertReceiver.class);
    localIntent.setAction("com.google.android.keep.intent.action.POST_LOCATION_NOTIFICATION");
    localIntent.setData(ContentUris.withAppendedId(i.a.CONTENT_URI, paramLong));
    localIntent.putExtra("authAccountId", paramLong);
    return PendingIntent.getBroadcast(paramContext, 0, localIntent, 134217728);
  }
}