package com.google.android.gms.internal;

import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataMap;
import java.util.ArrayList;
import java.util.List;

public final class zzadi
{
  private static int zza(String paramString, zzadj.zza.zza[] paramArrayOfzza)
  {
    int m = paramArrayOfzza.length;
    int i = 0;
    int j = 14;
    if (i < m)
    {
      zzadj.zza.zza localzza = paramArrayOfzza[i];
      int k;
      if (j == 14)
        if ((localzza.type == 9) || (localzza.type == 2) || (localzza.type == 6))
          k = localzza.type;
      do
      {
        do
        {
          i += 1;
          j = k;
          break;
          k = j;
        }
        while (localzza.type == 14);
        throw new IllegalArgumentException("Unexpected TypedValue type: " + localzza.type + " for key " + paramString);
        k = j;
      }
      while (localzza.type == j);
      throw new IllegalArgumentException("The ArrayList elements should all be the same type, but ArrayList with key " + paramString + " contains items of type " + j + " and " + localzza.type);
    }
    return j;
  }

  public static DataMap zza(zza paramzza)
  {
    DataMap localDataMap = new DataMap();
    zzadj.zza[] arrayOfzza = zzbIQ.zzbIS;
    int j = arrayOfzza.length;
    int i = 0;
    while (i < j)
    {
      zzadj.zza localzza = arrayOfzza[i];
      zza(zzbIR, localDataMap, localzza.name, localzza.zzbIU);
      i += 1;
    }
    return localDataMap;
  }

  private static ArrayList zza(List<Asset> paramList, zzadj.zza.zza.zza paramzza, int paramInt)
  {
    ArrayList localArrayList = new ArrayList(paramzza.zzbJg.length);
    paramzza = paramzza.zzbJg;
    int k = paramzza.length;
    int i = 0;
    if (i < k)
    {
      zzadj.zza[] arrayOfzza = paramzza[i];
      if (arrayOfzza.type == 14)
        localArrayList.add(null);
      while (true)
      {
        i += 1;
        break;
        if (paramInt == 9)
        {
          DataMap localDataMap = new DataMap();
          arrayOfzza = arrayOfzza.zzbIW.zzbJf;
          int m = arrayOfzza.length;
          int j = 0;
          while (j < m)
          {
            zzadj.zza localzza = arrayOfzza[j];
            zza(paramList, localDataMap, localzza.name, localzza.zzbIU);
            j += 1;
          }
          localArrayList.add(localDataMap);
        }
        else if (paramInt == 2)
        {
          localArrayList.add(arrayOfzza.zzbIW.zzbIY);
        }
        else
        {
          if (paramInt != 6)
            break label191;
          localArrayList.add(Integer.valueOf(arrayOfzza.zzbIW.zzbJc));
        }
      }
      label191: throw new IllegalArgumentException("Unexpected typeOfArrayList: " + paramInt);
    }
    return localArrayList;
  }

  private static void zza(List<Asset> paramList, DataMap paramDataMap, String paramString, zzadj.zza.zza paramzza)
  {
    int i = paramzza.type;
    if (i == 14)
    {
      paramDataMap.putString(paramString, null);
      return;
    }
    Object localObject1 = paramzza.zzbIW;
    if (i == 1)
    {
      paramDataMap.putByteArray(paramString, ((zzadj.zza.zza.zza)localObject1).zzbIX);
      return;
    }
    if (i == 11)
    {
      paramDataMap.putStringArray(paramString, ((zzadj.zza.zza.zza)localObject1).zzbJh);
      return;
    }
    if (i == 12)
    {
      paramDataMap.putLongArray(paramString, ((zzadj.zza.zza.zza)localObject1).zzbJi);
      return;
    }
    if (i == 15)
    {
      paramDataMap.putFloatArray(paramString, ((zzadj.zza.zza.zza)localObject1).zzbJj);
      return;
    }
    if (i == 2)
    {
      paramDataMap.putString(paramString, ((zzadj.zza.zza.zza)localObject1).zzbIY);
      return;
    }
    if (i == 3)
    {
      paramDataMap.putDouble(paramString, ((zzadj.zza.zza.zza)localObject1).zzbIZ);
      return;
    }
    if (i == 4)
    {
      paramDataMap.putFloat(paramString, ((zzadj.zza.zza.zza)localObject1).zzbJa);
      return;
    }
    if (i == 5)
    {
      paramDataMap.putLong(paramString, ((zzadj.zza.zza.zza)localObject1).zzbJb);
      return;
    }
    if (i == 6)
    {
      paramDataMap.putInt(paramString, ((zzadj.zza.zza.zza)localObject1).zzbJc);
      return;
    }
    if (i == 7)
    {
      paramDataMap.putByte(paramString, (byte)((zzadj.zza.zza.zza)localObject1).zzbJd);
      return;
    }
    if (i == 8)
    {
      paramDataMap.putBoolean(paramString, ((zzadj.zza.zza.zza)localObject1).zzbJe);
      return;
    }
    if (i == 13)
    {
      if (paramList == null)
        throw new RuntimeException("populateBundle: unexpected type for: " + paramString);
      paramDataMap.putAsset(paramString, (Asset)paramList.get((int)((zzadj.zza.zza.zza)localObject1).zzbJk));
      return;
    }
    if (i == 9)
    {
      paramzza = new DataMap();
      localObject1 = ((zzadj.zza.zza.zza)localObject1).zzbJf;
      int j = localObject1.length;
      i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        zza(paramList, paramzza, localObject2.name, localObject2.zzbIU);
        i += 1;
      }
      paramDataMap.putDataMap(paramString, paramzza);
      return;
    }
    if (i == 10)
    {
      i = zza(paramString, ((zzadj.zza.zza.zza)localObject1).zzbJg);
      paramList = zza(paramList, (zzadj.zza.zza.zza)localObject1, i);
      if (i == 14)
      {
        paramDataMap.putStringArrayList(paramString, paramList);
        return;
      }
      if (i == 9)
      {
        paramDataMap.putDataMapArrayList(paramString, paramList);
        return;
      }
      if (i == 2)
      {
        paramDataMap.putStringArrayList(paramString, paramList);
        return;
      }
      if (i == 6)
      {
        paramDataMap.putIntegerArrayList(paramString, paramList);
        return;
      }
      throw new IllegalStateException("Unexpected typeOfArrayList: " + i);
    }
    throw new RuntimeException("populateBundle: unexpected type " + i);
  }

  public static class zza
  {
    public final zzadj zzbIQ;
    public final List<Asset> zzbIR;

    public zza(zzadj paramzzadj, List<Asset> paramList)
    {
      zzbIQ = paramzzadj;
      zzbIR = paramList;
    }
  }
}