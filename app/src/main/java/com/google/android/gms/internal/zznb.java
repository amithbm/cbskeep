package com.google.android.gms.internal;

import com.google.android.gms.drive.internal.zzx;
import com.google.android.gms.drive.realtime.CollaborativeObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Set<Ljava.lang.Object;>;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

class zznb
{
  private static Object zzD(Object paramObject)
    throws JSONException
  {
    Object localObject;
    if ((paramObject instanceof JSONObject))
    {
      paramObject = (JSONObject)paramObject;
      localObject = new HashMap();
      Iterator localIterator = paramObject.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ((Map)localObject).put(str, zzD(paramObject.get(str)));
      }
      localObject = Collections.unmodifiableMap((Map)localObject);
    }
    do
    {
      do
      {
        do
        {
          return localObject;
          if ((paramObject instanceof JSONArray))
          {
            paramObject = (JSONArray)paramObject;
            localObject = new ArrayList(paramObject.length());
            int i = 0;
            while (i < paramObject.length())
            {
              ((List)localObject).add(zzD(paramObject.get(i)));
              i += 1;
            }
            return Collections.unmodifiableList((List)localObject);
          }
          localObject = paramObject;
        }
        while ((paramObject instanceof String));
        localObject = paramObject;
      }
      while ((paramObject instanceof Number));
      localObject = paramObject;
    }
    while ((paramObject instanceof Boolean));
    if (JSONObject.NULL.equals(paramObject))
      return null;
    throw new JSONException("Unknown JSON node type: " + paramObject.getClass().getName());
  }

  static String zzE(Object paramObject)
  {
    try
    {
      paramObject = zza(paramObject, Collections.newSetFromMap(new IdentityHashMap()), true).toString();
      return paramObject;
    }
    catch (JSONException paramObject)
    {
    }
    throw new AssertionError(paramObject);
  }

  private static Object zza(Object paramObject, Set<Object> paramSet, boolean paramBoolean)
    throws JSONException
  {
    if ((paramObject instanceof CollaborativeObject))
      throw new IllegalArgumentException("Value " + paramObject + " contains an invalid Realtime " + "object. Realtime objects must be placed directly in other Realtime objects, " + "not in Java objects in Realtime objects.");
    if (((paramObject instanceof Map)) || ((paramObject instanceof List)))
    {
      if (paramSet.contains(paramObject))
        throw new IllegalArgumentException("Value " + paramObject + " contains an invalid cycle. In " + "a Realtime data model, cycles can only include other Realtime objects.");
      paramSet.add(paramObject);
    }
    Object localObject;
    if ((paramObject instanceof Map))
    {
      localObject = new JSONObject();
      Iterator localIterator = ((Map)paramObject).entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((localEntry.getKey() instanceof String))
          ((JSONObject)localObject).put((String)localEntry.getKey(), zza(localEntry.getValue(), paramSet, false));
        else
          throw new IllegalArgumentException("Value " + paramObject + " contains an invalid Map." + "Only Map instances with String keys are allowed as Realtime " + "values.");
      }
      paramSet = (Set<Object>)localObject;
    }
    do
    {
      do
      {
        do
        {
          return paramSet;
          if ((paramObject instanceof List))
          {
            localObject = new JSONArray();
            paramObject = ((List)paramObject).iterator();
            while (paramObject.hasNext())
              ((JSONArray)localObject).put(zza(paramObject.next(), paramSet, false));
            return localObject;
          }
          if (!(paramObject instanceof String))
            break;
          paramSet = paramObject;
        }
        while (!paramBoolean);
        return JSONObject.quote((String)paramObject);
        paramSet = paramObject;
      }
      while ((paramObject instanceof Boolean));
      if (!(paramObject instanceof Number))
        break;
      paramSet = (Number)paramObject;
      if ((paramSet instanceof Long))
      {
        long l = paramSet.longValue();
        if ((l < -9007199254740991L) || (l > 9007199254740991L))
          throw new IllegalArgumentException("Realtime value " + l + " is invalid " + "because it cannot be represented as a JSON Number.");
      }
      if ((((paramSet instanceof Float)) && (((Float)paramSet).isInfinite())) || (((paramSet instanceof Double)) && (((Double)paramSet).isInfinite())))
        throw new IllegalArgumentException("Infinite values are not supported.");
      if ((((paramSet instanceof Float)) && (((Float)paramSet).isNaN())) || (((paramSet instanceof Double)) && (((Double)paramSet).isNaN())))
        throw new IllegalArgumentException("NaN values are not supported.");
      paramSet = paramObject;
    }
    while (!paramBoolean);
    return JSONObject.numberToString((Number)paramObject);
    if (paramObject == null)
      return JSONObject.NULL;
    throw new IllegalArgumentException("Value " + paramObject + " is invalid because it is of " + "unsupported type: " + paramObject.toString());
  }

  static Object zzcH(String paramString)
  {
    try
    {
      Object localObject = zzD(new JSONTokener(paramString).nextValue());
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      zzx.zza("ExternalDataHolders", localJSONException, "Invalid JSON in Realtime data model: " + paramString);
    }
    return null;
  }
}