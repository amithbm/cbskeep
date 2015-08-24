package com.google.android.keep.location;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.AsyncTask;
import com.google.android.gms.reminders.model.Address;
import com.google.android.gms.reminders.model.Address.Builder;
import com.google.android.keep.model.LocationReminder.LocationType;
import com.google.android.keep.util.Config;
import com.google.android.keep.util.r;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class e extends AsyncTask<g, Integer, List<com.google.android.keep.model.Location>>
{
  private final Context mContext;

  public e(Context paramContext)
  {
    mContext = paramContext;
  }

  private Address a(JSONObject paramJSONObject)
    throws JSONException
  {
    JSONArray localJSONArray = paramJSONObject.getJSONArray("address_components");
    if (localJSONArray == null)
      return null;
    String str2 = paramJSONObject.getString("name");
    String str1 = str2;
    if (paramJSONObject.has("formatted_address"))
    {
      str1 = str2;
      if (paramJSONObject.getString("formatted_address").startsWith(str2))
        str1 = null;
    }
    return new Address.Builder().setName(str1).setStreetNumber(a(localJSONArray, "street_number")).setStreetName(a(localJSONArray, "route")).setPostalCode(a(localJSONArray, "postal_code")).setLocality(a(localJSONArray, "locality")).setRegion(a(localJSONArray, "administrative_area_level_1")).setCountry(a(localJSONArray, "country")).build();
  }

  private String a(JSONArray paramJSONArray, String paramString)
    throws JSONException
  {
    int k = paramJSONArray.length();
    int i = 0;
    while (i < k)
    {
      JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
      JSONArray localJSONArray = localJSONObject.getJSONArray("types");
      int m = localJSONArray.length();
      int j = 0;
      while (j < m)
      {
        if (localJSONArray.getString(j).equals(paramString))
          return localJSONObject.getString("short_name");
        j += 1;
      }
      i += 1;
    }
    return null;
  }

  static double[] a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    paramDouble4 = Math.toRadians(paramDouble4 - paramDouble2);
    paramDouble1 = Math.toRadians(paramDouble1);
    paramDouble3 = Math.toRadians(paramDouble3);
    paramDouble2 = Math.toRadians(paramDouble2);
    double d = Math.cos(paramDouble3) * Math.cos(paramDouble4);
    paramDouble4 = Math.cos(paramDouble3) * Math.sin(paramDouble4);
    paramDouble3 = Math.atan2(Math.sin(paramDouble1) + Math.sin(paramDouble3), Math.sqrt((Math.cos(paramDouble1) + d) * (Math.cos(paramDouble1) + d) + paramDouble4 * paramDouble4));
    paramDouble1 = Math.atan2(paramDouble4, Math.cos(paramDouble1) + d);
    return new double[] { Math.toDegrees(paramDouble3), (Math.toDegrees(paramDouble2 + paramDouble1) + 180.0D) % 360.0D - 180.0D };
  }

  private Uri s(String paramString)
  {
    Uri.Builder localBuilder = Uri.parse("https://maps.googleapis.com/maps/api/place/details/json").buildUpon();
    localBuilder.appendQueryParameter("key", Config.nL()).appendQueryParameter("language", Locale.getDefault().getLanguage()).appendQueryParameter("sensor", "true").appendQueryParameter("placeid", paramString);
    return localBuilder.build();
  }

  protected List<com.google.android.keep.model.Location> a(g[] paramArrayOfg)
  {
    ArrayList localArrayList = Lists.newArrayList();
    int k = paramArrayOfg.length;
    int i = 0;
    if (i < k)
    {
      Object localObject1 = paramArrayOfg[i];
      Object localObject3 = s(((g)localObject1).getPlaceId());
      localObject3 = com.google.android.keep.util.e.k(mContext, (Uri)localObject3);
      if (localObject3 == null)
        r.e("Keep", "getPlaceData result is null", new Object[0]);
      while (true)
      {
        i += 1;
        break;
        r.a("Keep", "getPlaceData result: %s", new Object[] { localObject3 });
        try
        {
          JSONObject localJSONObject = ((JSONObject)localObject3).getJSONObject("result");
          Object localObject5 = localJSONObject.getJSONObject("geometry");
          Object localObject4 = ((JSONObject)localObject5).optJSONObject("viewport");
          int j = Config.nN();
          double d1;
          double d2;
          if (localObject4 != null)
          {
            localObject5 = ((JSONObject)localObject4).getJSONObject("northeast");
            double d3 = ((JSONObject)localObject5).getDouble("lat");
            double d4 = ((JSONObject)localObject5).getDouble("lng");
            localObject4 = ((JSONObject)localObject4).getJSONObject("southwest");
            double d5 = ((JSONObject)localObject4).getDouble("lat");
            double d6 = ((JSONObject)localObject4).getDouble("lng");
            localObject4 = new float[1];
            localObject5 = a(d3, d4, d5, d6);
            d1 = localObject5[0];
            d2 = localObject5[1];
            android.location.Location.distanceBetween(d3, d4, d5, d6, (float[])localObject4);
            j = Math.max((int)localObject4[0] / 2, j);
          }
          while (true)
          {
            localObject4 = a(localJSONObject);
            localObject1 = new com.google.android.keep.model.Location(LocationReminder.LocationType.a(((g)localObject1).fS()), localJSONObject.getString("name"), Double.valueOf(d1), Double.valueOf(d2), Integer.valueOf(j), localJSONObject.optString("formatted_address"), localJSONObject.getString("place_id"), (Address)localObject4);
            if (localObject1 != null)
              localArrayList.add(localObject1);
            publishProgress(new Integer[] { Integer.valueOf(i * 100 / k) });
            break;
            localObject4 = ((JSONObject)localObject5).getJSONObject("location");
            d1 = ((JSONObject)localObject4).getDouble("lat");
            d2 = ((JSONObject)localObject4).getDouble("lng");
          }
        }
        catch (JSONException localJSONException)
        {
          while (true)
          {
            r.a("Keep", localJSONException, "Invalid Response: %s", new Object[] { ((JSONObject)localObject3).toString() });
            Object localObject2 = null;
          }
        }
      }
    }
    return localArrayList;
  }
}