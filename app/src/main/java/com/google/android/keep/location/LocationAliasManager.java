package com.google.android.keep.location;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlaceBuffer;
import com.google.android.gms.location.places.PlacesStatusCodes;
import com.google.android.gms.location.places.personalized.PlaceAlias;
import com.google.android.gms.location.places.personalized.PlaceUserData;
import com.google.android.gms.location.places.personalized.PlaceUserDataBuffer;
import com.google.android.keep.model.LocationReminder.LocationType;
import com.google.android.keep.util.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LocationAliasManager
{
  private static final String TAG = LocationAliasManager.class.getSimpleName();
  private final GoogleApiClient gh;
  private final Context mContext;
  private final LocationAlias[] si = { LocationAlias.sn, LocationAlias.so };
  private final LoaderManager sj;
  private a sk;
  private final LoaderManager.LoaderCallbacks<PlaceUserDataBuffer> sl = new LoaderManager.LoaderCallbacks()
  {
    public void a(Loader<PlaceUserDataBuffer> paramAnonymousLoader, PlaceUserDataBuffer paramAnonymousPlaceUserDataBuffer)
    {
      if ((paramAnonymousPlaceUserDataBuffer == null) || (!paramAnonymousPlaceUserDataBuffer.getStatus().isSuccess()));
      do
      {
        return;
        paramAnonymousLoader = new ArrayMap();
        while (true)
        {
          int i;
          try
          {
            LocationAliasManager.LocationAlias[] arrayOfLocationAlias = LocationAliasManager.c(LocationAliasManager.this);
            int j = arrayOfLocationAlias.length;
            i = 0;
            if (i >= j)
              break;
            LocationAliasManager.LocationAlias localLocationAlias = arrayOfLocationAlias[i];
            Iterator localIterator = paramAnonymousPlaceUserDataBuffer.iterator();
            if (localIterator.hasNext())
            {
              PlaceUserData localPlaceUserData = (PlaceUserData)localIterator.next();
              if (!localPlaceUserData.getPlaceAliases().contains(localLocationAlias.mPlaceAlias))
                continue;
              paramAnonymousLoader.put(localPlaceUserData.getPlaceId(), localLocationAlias);
              continue;
            }
          }
          finally
          {
            paramAnonymousPlaceUserDataBuffer.release();
          }
          i += 1;
        }
        paramAnonymousPlaceUserDataBuffer.release();
      }
      while (paramAnonymousLoader.isEmpty());
      LocationAliasManager.d(LocationAliasManager.this).restartLoader(2, null, new LocationAliasManager.b(LocationAliasManager.this, paramAnonymousLoader));
    }

    public Loader<PlaceUserDataBuffer> onCreateLoader(int paramAnonymousInt, Bundle paramAnonymousBundle)
    {
      return new b(LocationAliasManager.a(LocationAliasManager.this), LocationAliasManager.b(LocationAliasManager.this));
    }

    public void onLoaderReset(Loader<PlaceUserDataBuffer> paramAnonymousLoader)
    {
      LocationAliasManager.e(LocationAliasManager.this).f(new ArrayList());
    }
  };

  public LocationAliasManager(Context paramContext, LoaderManager paramLoaderManager, GoogleApiClient paramGoogleApiClient)
  {
    mContext = paramContext;
    sj = paramLoaderManager;
    gh = paramGoogleApiClient;
  }

  public void a(a parama)
  {
    sk = parama;
  }

  public void fQ()
  {
    sj.restartLoader(1, null, sl);
  }

  private static enum LocationAlias
  {
    final int mLocationNameResourceId;
    final LocationReminder.LocationType mLocationType;
    final PlaceAlias mPlaceAlias;

    private LocationAlias(PlaceAlias paramPlaceAlias, LocationReminder.LocationType paramLocationType, int paramInt)
    {
      mPlaceAlias = paramPlaceAlias;
      mLocationType = paramLocationType;
      mLocationNameResourceId = paramInt;
    }
  }

  public static abstract interface a
  {
    public abstract void f(List<g> paramList);
  }

  private class b
    implements LoaderManager.LoaderCallbacks<PlaceBuffer>
  {
    private final Map<String, LocationAliasManager.LocationAlias> sq;

    b()
    {
      Object localObject;
      sq = localObject;
    }

    public void a(Loader<PlaceBuffer> paramLoader, PlaceBuffer paramPlaceBuffer)
    {
      if (paramPlaceBuffer == null)
      {
        r.a(LocationAliasManager.cb(), "No location aliases to load.", new Object[0]);
        return;
      }
      if (!paramPlaceBuffer.getStatus().isSuccess())
      {
        r.b(LocationAliasManager.cb(), "Couldn't load location aliases because " + PlacesStatusCodes.getStatusCodeString(paramPlaceBuffer.getStatus().getStatusCode()), new Object[0]);
        return;
      }
      while (true)
      {
        int i;
        try
        {
          paramLoader = new ArrayList(paramPlaceBuffer.getCount());
          i = 0;
          if (i < paramPlaceBuffer.getCount())
          {
            Place localPlace = paramPlaceBuffer.get(i);
            if (localPlace != null)
            {
              LocationAliasManager.LocationAlias localLocationAlias = (LocationAliasManager.LocationAlias)sq.get(localPlace.getId());
              paramLoader.add(new g(localLocationAlias.mLocationType, LocationAliasManager.a(LocationAliasManager.this).getString(localLocationAlias.mLocationNameResourceId), localPlace.getAddress().toString(), localPlace.getId()));
            }
          }
          else
          {
            LocationAliasManager.e(LocationAliasManager.this).f(paramLoader);
            return;
          }
        }
        finally
        {
          paramPlaceBuffer.release();
        }
        i += 1;
      }
    }

    public Loader<PlaceBuffer> onCreateLoader(int paramInt, Bundle paramBundle)
    {
      return new f(LocationAliasManager.a(LocationAliasManager.this), LocationAliasManager.b(LocationAliasManager.this), sq.keySet());
    }

    public void onLoaderReset(Loader<PlaceBuffer> paramLoader)
    {
      LocationAliasManager.e(LocationAliasManager.this).f(new ArrayList());
    }
  }
}