package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse.FieldConverter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class StringToIntConverter
  implements SafeParcelable, FastJsonResponse.FieldConverter<String, Integer>
{
  public static final zzb CREATOR = new zzb();
  private final int mVersionCode;
  private final HashMap<String, Integer> zzamN;
  private final HashMap<Integer, String> zzamO;
  private final ArrayList<Entry> zzamP;

  public StringToIntConverter()
  {
    mVersionCode = 1;
    zzamN = new HashMap();
    zzamO = new HashMap();
    zzamP = null;
  }

  StringToIntConverter(int paramInt, ArrayList<Entry> paramArrayList)
  {
    mVersionCode = paramInt;
    zzamN = new HashMap();
    zzamO = new HashMap();
    zzamP = null;
    zzb(paramArrayList);
  }

  private void zzb(ArrayList<Entry> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Entry localEntry = (Entry)paramArrayList.next();
      zzj(localEntry.zzamQ, localEntry.zzamR);
    }
  }

  public int describeContents()
  {
    zzb localzzb = CREATOR;
    return 0;
  }

  int getVersionCode()
  {
    return mVersionCode;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb localzzb = CREATOR;
    zzb.zza(this, paramParcel, paramInt);
  }

  public String zzc(Integer paramInteger)
  {
    String str = (String)zzamO.get(paramInteger);
    paramInteger = str;
    if (str == null)
    {
      paramInteger = str;
      if (zzamN.containsKey("gms_unknown"))
        paramInteger = "gms_unknown";
    }
    return paramInteger;
  }

  public StringToIntConverter zzj(String paramString, int paramInt)
  {
    zzamN.put(paramString, Integer.valueOf(paramInt));
    zzamO.put(Integer.valueOf(paramInt), paramString);
    return this;
  }

  ArrayList<Entry> zzql()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = zzamN.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(new Entry(str, ((Integer)zzamN.get(str)).intValue()));
    }
    return localArrayList;
  }

  public static final class Entry
    implements SafeParcelable
  {
    public static final zzc CREATOR = new zzc();
    final int versionCode;
    final String zzamQ;
    final int zzamR;

    Entry(int paramInt1, String paramString, int paramInt2)
    {
      versionCode = paramInt1;
      zzamQ = paramString;
      zzamR = paramInt2;
    }

    Entry(String paramString, int paramInt)
    {
      versionCode = 1;
      zzamQ = paramString;
      zzamR = paramInt;
    }

    public int describeContents()
    {
      zzc localzzc = CREATOR;
      return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      zzc localzzc = CREATOR;
      zzc.zza(this, paramParcel, paramInt);
    }
  }
}