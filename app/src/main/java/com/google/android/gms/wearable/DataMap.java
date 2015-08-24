package com.google.android.gms.wearable;

import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class DataMap
{
  private final HashMap<String, Object> zznY = new HashMap();

  private void zza(String paramString1, Object paramObject, String paramString2, ClassCastException paramClassCastException)
  {
    zza(paramString1, paramObject, paramString2, "<null>", paramClassCastException);
  }

  private void zza(String paramString1, Object paramObject1, String paramString2, Object paramObject2, ClassCastException paramClassCastException)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Key ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" expected ");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(" but value was a ");
    localStringBuilder.append(paramObject1.getClass().getName());
    localStringBuilder.append(".  The default value ");
    localStringBuilder.append(paramObject2);
    localStringBuilder.append(" was returned.");
    Log.w("DataMap", localStringBuilder.toString());
    Log.w("DataMap", "Attempt to cast generated internal exception:", paramClassCastException);
  }

  private static boolean zza(Asset paramAsset1, Asset paramAsset2)
  {
    if ((paramAsset1 == null) || (paramAsset2 == null))
      return paramAsset1 == paramAsset2;
    if (!TextUtils.isEmpty(paramAsset1.getDigest()))
      return paramAsset1.getDigest().equals(paramAsset2.getDigest());
    return Arrays.equals(paramAsset1.getData(), paramAsset2.getData());
  }

  private static boolean zza(DataMap paramDataMap1, DataMap paramDataMap2)
  {
    if (paramDataMap1.size() != paramDataMap2.size())
      return false;
    Iterator localIterator = paramDataMap1.keySet().iterator();
    while (true)
      if (localIterator.hasNext())
      {
        Object localObject2 = (String)localIterator.next();
        Object localObject1 = paramDataMap1.get((String)localObject2);
        localObject2 = paramDataMap2.get((String)localObject2);
        if ((localObject1 instanceof Asset))
        {
          if (!(localObject2 instanceof Asset))
            break;
          if (zza((Asset)localObject1, (Asset)localObject2))
            continue;
          return false;
        }
        if ((localObject1 instanceof String[]))
        {
          if (!(localObject2 instanceof String[]))
            break;
          if (Arrays.equals((String[])localObject1, (String[])localObject2))
            continue;
          return false;
        }
        if ((localObject1 instanceof long[]))
        {
          if (!(localObject2 instanceof long[]))
            break;
          if (Arrays.equals((long[])localObject1, (long[])localObject2))
            continue;
          return false;
        }
        if ((localObject1 instanceof float[]))
        {
          if (!(localObject2 instanceof float[]))
            break;
          if (Arrays.equals((float[])localObject1, (float[])localObject2))
            continue;
          return false;
        }
        if ((localObject1 instanceof byte[]))
        {
          if (!(localObject2 instanceof byte[]))
            break;
          if (Arrays.equals((byte[])localObject1, (byte[])localObject2))
            continue;
          return false;
        }
        if ((localObject1 == null) || (localObject2 == null))
        {
          if (localObject1 == localObject2);
          for (boolean bool = true; ; bool = false)
            return bool;
        }
        if (!localObject1.equals(localObject2))
          return false;
      }
    return true;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof DataMap))
      return false;
    return zza(this, (DataMap)paramObject);
  }

  public <T> T get(String paramString)
  {
    return zznY.get(paramString);
  }

  public int getInt(String paramString, int paramInt)
  {
    Object localObject = zznY.get(paramString);
    if (localObject == null)
      return paramInt;
    try
    {
      int i = ((Integer)localObject).intValue();
      return i;
    }
    catch (ClassCastException localClassCastException)
    {
      zza(paramString, localObject, "Integer", localClassCastException);
    }
    return paramInt;
  }

  public int hashCode()
  {
    return zznY.hashCode() * 29;
  }

  public Set<String> keySet()
  {
    return zznY.keySet();
  }

  public void putAsset(String paramString, Asset paramAsset)
  {
    zznY.put(paramString, paramAsset);
  }

  public void putBoolean(String paramString, boolean paramBoolean)
  {
    zznY.put(paramString, Boolean.valueOf(paramBoolean));
  }

  public void putByte(String paramString, byte paramByte)
  {
    zznY.put(paramString, Byte.valueOf(paramByte));
  }

  public void putByteArray(String paramString, byte[] paramArrayOfByte)
  {
    zznY.put(paramString, paramArrayOfByte);
  }

  public void putDataMap(String paramString, DataMap paramDataMap)
  {
    zznY.put(paramString, paramDataMap);
  }

  public void putDataMapArrayList(String paramString, ArrayList<DataMap> paramArrayList)
  {
    zznY.put(paramString, paramArrayList);
  }

  public void putDouble(String paramString, double paramDouble)
  {
    zznY.put(paramString, Double.valueOf(paramDouble));
  }

  public void putFloat(String paramString, float paramFloat)
  {
    zznY.put(paramString, Float.valueOf(paramFloat));
  }

  public void putFloatArray(String paramString, float[] paramArrayOfFloat)
  {
    zznY.put(paramString, paramArrayOfFloat);
  }

  public void putInt(String paramString, int paramInt)
  {
    zznY.put(paramString, Integer.valueOf(paramInt));
  }

  public void putIntegerArrayList(String paramString, ArrayList<Integer> paramArrayList)
  {
    zznY.put(paramString, paramArrayList);
  }

  public void putLong(String paramString, long paramLong)
  {
    zznY.put(paramString, Long.valueOf(paramLong));
  }

  public void putLongArray(String paramString, long[] paramArrayOfLong)
  {
    zznY.put(paramString, paramArrayOfLong);
  }

  public void putString(String paramString1, String paramString2)
  {
    zznY.put(paramString1, paramString2);
  }

  public void putStringArray(String paramString, String[] paramArrayOfString)
  {
    zznY.put(paramString, paramArrayOfString);
  }

  public void putStringArrayList(String paramString, ArrayList<String> paramArrayList)
  {
    zznY.put(paramString, paramArrayList);
  }

  public int size()
  {
    return zznY.size();
  }

  public String toString()
  {
    return zznY.toString();
  }
}