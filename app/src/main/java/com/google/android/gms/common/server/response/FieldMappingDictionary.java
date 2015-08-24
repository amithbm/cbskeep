package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzv;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class FieldMappingDictionary
  implements SafeParcelable
{
  public static final zzc CREATOR = new zzc();
  private final int mVersionCode;
  private final HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> zzans;
  private final ArrayList<Entry> zzant;
  private final String zzanu;

  FieldMappingDictionary(int paramInt, ArrayList<Entry> paramArrayList, String paramString)
  {
    mVersionCode = paramInt;
    zzant = null;
    zzans = zzc(paramArrayList);
    zzanu = ((String)zzv.zzz(paramString));
    linkFields();
  }

  private static HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> zzc(ArrayList<Entry> paramArrayList)
  {
    HashMap localHashMap = new HashMap();
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      Entry localEntry = (Entry)paramArrayList.get(i);
      localHashMap.put(localEntry.className, localEntry.zzqp());
      i += 1;
    }
    return localHashMap;
  }

  public int describeContents()
  {
    zzc localzzc = CREATOR;
    return 0;
  }

  public Map<String, FastJsonResponse.Field<?, ?>> getFieldMapping(String paramString)
  {
    return (Map)zzans.get(paramString);
  }

  public String getRootClassName()
  {
    return zzanu;
  }

  int getVersionCode()
  {
    return mVersionCode;
  }

  public void linkFields()
  {
    Iterator localIterator1 = zzans.keySet().iterator();
    while (localIterator1.hasNext())
    {
      Object localObject = (String)localIterator1.next();
      localObject = (Map)zzans.get(localObject);
      Iterator localIterator2 = ((Map)localObject).keySet().iterator();
      while (localIterator2.hasNext())
        ((FastJsonResponse.Field)((Map)localObject).get((String)localIterator2.next())).setFieldMappingDictionary(this);
    }
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator1 = zzans.keySet().iterator();
    while (localIterator1.hasNext())
    {
      Object localObject = (String)localIterator1.next();
      localStringBuilder.append((String)localObject).append(":\n");
      localObject = (Map)zzans.get(localObject);
      Iterator localIterator2 = ((Map)localObject).keySet().iterator();
      while (localIterator2.hasNext())
      {
        String str = (String)localIterator2.next();
        localStringBuilder.append("  ").append(str).append(": ");
        localStringBuilder.append(((Map)localObject).get(str));
      }
    }
    return localStringBuilder.toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc localzzc = CREATOR;
    zzc.zza(this, paramParcel, paramInt);
  }

  ArrayList<Entry> zzqo()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = zzans.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(new Entry(str, (Map)zzans.get(str)));
    }
    return localArrayList;
  }

  public static class Entry
    implements SafeParcelable
  {
    public static final zzd CREATOR = new zzd();
    final String className;
    final int versionCode;
    final ArrayList<FieldMappingDictionary.FieldMapPair> zzanv;

    Entry(int paramInt, String paramString, ArrayList<FieldMappingDictionary.FieldMapPair> paramArrayList)
    {
      versionCode = paramInt;
      className = paramString;
      zzanv = paramArrayList;
    }

    Entry(String paramString, Map<String, FastJsonResponse.Field<?, ?>> paramMap)
    {
      versionCode = 1;
      className = paramString;
      zzanv = zzD(paramMap);
    }

    private static ArrayList<FieldMappingDictionary.FieldMapPair> zzD(Map<String, FastJsonResponse.Field<?, ?>> paramMap)
    {
      if (paramMap == null)
        return null;
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localArrayList.add(new FieldMappingDictionary.FieldMapPair(str, (FastJsonResponse.Field)paramMap.get(str)));
      }
      return localArrayList;
    }

    public int describeContents()
    {
      zzd localzzd = CREATOR;
      return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      zzd localzzd = CREATOR;
      zzd.zza(this, paramParcel, paramInt);
    }

    HashMap<String, FastJsonResponse.Field<?, ?>> zzqp()
    {
      HashMap localHashMap = new HashMap();
      int j = zzanv.size();
      int i = 0;
      while (i < j)
      {
        FieldMappingDictionary.FieldMapPair localFieldMapPair = (FieldMappingDictionary.FieldMapPair)zzanv.get(i);
        localHashMap.put(localFieldMapPair.zzaC, localFieldMapPair.zzanw);
        i += 1;
      }
      return localHashMap;
    }
  }

  public static class FieldMapPair
    implements SafeParcelable
  {
    public static final zzb CREATOR = new zzb();
    final int versionCode;
    final String zzaC;
    final FastJsonResponse.Field<?, ?> zzanw;

    FieldMapPair(int paramInt, String paramString, FastJsonResponse.Field<?, ?> paramField)
    {
      versionCode = paramInt;
      zzaC = paramString;
      zzanw = paramField;
    }

    FieldMapPair(String paramString, FastJsonResponse.Field<?, ?> paramField)
    {
      versionCode = 1;
      zzaC = paramString;
      zzanw = paramField;
    }

    public int describeContents()
    {
      zzb localzzb = CREATOR;
      return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      zzb localzzb = CREATOR;
      zzb.zza(this, paramParcel, paramInt);
    }
  }
}