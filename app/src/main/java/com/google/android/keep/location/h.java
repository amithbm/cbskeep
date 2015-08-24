package com.google.android.keep.location;

import android.content.Context;
import android.location.Location;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Handler;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationServices;
import com.google.android.keep.model.LocationReminder.LocationType;
import com.google.android.keep.util.Config;
import com.google.android.keep.util.e;
import com.google.android.keep.util.f;
import com.google.android.keep.util.f.a;
import com.google.android.keep.util.r;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class h extends j<g>
  implements f.a<String>
{
  private final GoogleApiClient gh;
  private final Context mContext;
  private final Handler mHandler = new Handler();
  private final f<String> sx = new f(200, this);

  public h(j.a<g> parama, Context paramContext, GoogleApiClient paramGoogleApiClient)
  {
    super(parama);
    mContext = paramContext;
    gh = paramGoogleApiClient;
  }

  private List<g> b(JSONObject paramJSONObject)
  {
    ArrayList localArrayList = Lists.newArrayList();
    if (paramJSONObject == null);
    while (true)
    {
      return localArrayList;
      try
      {
        JSONArray localJSONArray = paramJSONObject.getJSONArray("predictions");
        r.b("Keep", "getPlaceData %d results", new Object[] { Integer.valueOf(localJSONArray.length()) });
        int i = 0;
        while (true)
        {
          int j = localJSONArray.length();
          if (i >= j)
            break;
          try
          {
            JSONObject localJSONObject = localJSONArray.getJSONObject(i);
            Object localObject3 = localJSONObject.getJSONArray("terms");
            Object localObject2 = localJSONObject.getString("description");
            if (((JSONArray)localObject3).length() > 1)
            {
              localObject1 = ((JSONArray)localObject3).getJSONObject(0);
              localObject3 = ((JSONArray)localObject3).getJSONObject(1);
              localObject1 = ((JSONObject)localObject1).getString("value");
              localObject3 = ((String)localObject2).substring(((JSONObject)localObject3).getInt("offset"));
              localObject2 = localObject1;
            }
            for (Object localObject1 = localObject3; ; localObject1 = null)
            {
              localObject1 = new g(LocationReminder.LocationType.wv, (String)localObject2, (String)localObject1, localJSONObject.getString("place_id"));
              localArrayList.add(localObject1);
              r.a("Keep", "  " + ((g)localObject1).getTitle(), new Object[0]);
              i += 1;
              break;
            }
          }
          catch (JSONException localJSONException1)
          {
            while (true)
              r.e("Keep", "Invalid Response: %s", new Object[] { localJSONException1, localJSONArray.toString() });
          }
        }
      }
      catch (JSONException localJSONException2)
      {
        r.e("Keep", "Invalid Response: %s", new Object[] { localJSONException2, paramJSONObject.toString() });
      }
    }
    return localArrayList;
  }

  private void x(String paramString)
  {
    r.a("Keep", "Fetch Places Suggestions: " + paramString, new Object[0]);
    final Uri.Builder localBuilder = Uri.parse("https://maps.googleapis.com/maps/api/place/autocomplete/json").buildUpon();
    localBuilder.appendQueryParameter("key", Config.nL()).appendQueryParameter("language", Locale.getDefault().getLanguage()).appendQueryParameter("sensor", "true").appendQueryParameter("input", paramString);
    if ((gh.isConnected()) && (a.o(mContext)))
    {
      paramString = LocationServices.FusedLocationApi.getLastLocation(gh);
      if (paramString != null)
        localBuilder.appendQueryParameter("location", String.format(Locale.getDefault(), "%f,%f", new Object[] { Double.valueOf(paramString.getLatitude()), Double.valueOf(paramString.getLongitude()) })).appendQueryParameter("radius", Integer.toString(Config.nK()));
    }
    new Thread()
    {
      public void run()
      {
        final List localList = h.a(h.this, e.k(h.a(h.this), localBuilder.build()));
        h.b(h.this).post(new Runnable()
        {
          public void run()
          {
            h(localList);
          }
        });
      }
    }
    .start();
  }

  public void t(String paramString)
  {
    sx.i(paramString);
  }

  public void u(String paramString)
  {
    x(paramString);
  }
}