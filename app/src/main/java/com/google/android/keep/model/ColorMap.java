package com.google.android.keep.model;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.keep.provider.i.g;
import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class ColorMap
{
  private static final Map<String, Integer> vg = new LinkedHashMap();
  private static final Map<String, Integer> vh = new LinkedHashMap();
  private static final Map<String, Integer> vi = new LinkedHashMap();

  public static ColorPair I(String paramString)
  {
    Integer localInteger = (Integer)vg.get(i.g.Co);
    if (vg.containsKey(paramString))
      localInteger = (Integer)vg.get(paramString);
    return new ColorPair(paramString, localInteger.intValue(), null);
  }

  public static ColorPair J(String paramString)
  {
    Iterator localIterator = vg.keySet().iterator();
    while (localIterator.hasNext())
      if (TextUtils.equals((String)localIterator.next(), paramString))
        return new ColorPair(paramString, ((Integer)vg.get(paramString)).intValue(), null);
    return null;
  }

  public static Integer K(String paramString)
  {
    return (Integer)vh.get(paramString);
  }

  public static Integer L(String paramString)
  {
    return (Integer)vi.get(paramString);
  }

  public static ColorPair aM(int paramInt)
  {
    Iterator localIterator = vg.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (((Integer)vg.get(str)).intValue() == paramInt)
        return new ColorPair(str, paramInt, null);
    }
    return null;
  }

  public static ColorPair aN(int paramInt)
  {
    ColorPair localColorPair2 = aM(paramInt);
    ColorPair localColorPair1 = localColorPair2;
    if (localColorPair2 == null)
      localColorPair1 = gO();
    return localColorPair1;
  }

  public static ColorPair gO()
  {
    return new ColorPair(i.g.Co, ((Integer)vg.get(i.g.Co)).intValue(), null);
  }

  public static ColorPair[] getAllColors()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = vg.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(new ColorPair(str, ((Integer)vg.get(str)).intValue(), null));
    }
    return (ColorPair[])localArrayList.toArray(new ColorPair[localArrayList.size()]);
  }

  public static void init(Context paramContext)
  {
    paramContext = paramContext.getResources();
    vg.put(i.g.Co, Integer.valueOf(paramContext.getColor(2131296441)));
    vg.put("RED", Integer.valueOf(paramContext.getColor(2131296363)));
    vg.put("ORANGE", Integer.valueOf(paramContext.getColor(2131296442)));
    vg.put("YELLOW", Integer.valueOf(paramContext.getColor(2131296443)));
    vg.put("GREEN", Integer.valueOf(paramContext.getColor(2131296444)));
    vg.put("TEAL", Integer.valueOf(paramContext.getColor(2131296445)));
    vg.put("BLUE", Integer.valueOf(paramContext.getColor(2131296354)));
    vg.put("GRAY", Integer.valueOf(paramContext.getColor(2131296446)));
    vh.put(i.g.Co, Integer.valueOf(paramContext.getColor(2131296447)));
    vh.put("RED", Integer.valueOf(paramContext.getColor(2131296448)));
    vh.put("ORANGE", Integer.valueOf(paramContext.getColor(2131296449)));
    vh.put("YELLOW", Integer.valueOf(paramContext.getColor(2131296450)));
    vh.put("GREEN", Integer.valueOf(paramContext.getColor(2131296451)));
    vh.put("TEAL", Integer.valueOf(paramContext.getColor(2131296452)));
    vh.put("BLUE", Integer.valueOf(paramContext.getColor(2131296453)));
    vh.put("GRAY", Integer.valueOf(paramContext.getColor(2131296454)));
    vi.put(i.g.Co, Integer.valueOf(paramContext.getColor(2131296455)));
    vi.put("RED", Integer.valueOf(paramContext.getColor(2131296456)));
    vi.put("ORANGE", Integer.valueOf(paramContext.getColor(2131296457)));
    vi.put("YELLOW", Integer.valueOf(paramContext.getColor(2131296458)));
    vi.put("GREEN", Integer.valueOf(paramContext.getColor(2131296459)));
    vi.put("TEAL", Integer.valueOf(paramContext.getColor(2131296460)));
    vi.put("BLUE", Integer.valueOf(paramContext.getColor(2131296461)));
    vi.put("GRAY", Integer.valueOf(paramContext.getColor(2131296462)));
  }

  public static class ColorPair
    implements Parcelable
  {
    public static Parcelable.Creator<ColorPair> CREATOR = new Parcelable.Creator()
    {
      public ColorMap.ColorPair[] aO(int paramAnonymousInt)
      {
        return new ColorMap.ColorPair[paramAnonymousInt];
      }

      public ColorMap.ColorPair e(Parcel paramAnonymousParcel)
      {
        return new ColorMap.ColorPair(paramAnonymousParcel.readString(), paramAnonymousParcel.readInt(), null);
      }
    };
    private final String mKey;
    private final int vj;

    private ColorPair(String paramString, int paramInt)
    {
      mKey = paramString;
      vj = paramInt;
    }

    public int describeContents()
    {
      return 0;
    }

    public boolean equals(Object paramObject)
    {
      if (this == paramObject);
      do
      {
        return true;
        if (!(paramObject instanceof ColorPair))
          return false;
        paramObject = (ColorPair)paramObject;
      }
      while ((Objects.equal(mKey, paramObject.getKey())) && (vj == paramObject.getValue()));
      return false;
    }

    public String getKey()
    {
      return mKey;
    }

    public int getValue()
    {
      return vj;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(mKey);
      paramParcel.writeInt(vj);
    }
  }
}