package com.google.android.keep.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.reminders.model.Address;
import com.google.android.gms.reminders.model.Address.Builder;
import com.google.android.keep.util.Config;
import java.util.Map;

public class Location
  implements Parcelable
{
  public static Parcelable.Creator<Location> CREATOR = new Parcelable.Creator()
  {
    public Location[] aZ(int paramAnonymousInt)
    {
      return new Location[paramAnonymousInt];
    }

    public Location i(Parcel paramAnonymousParcel)
    {
      return new Location(paramAnonymousParcel, null);
    }
  };
  private final String mName;
  private final int mType;
  private final String sw;
  private final Double wn;
  private final Double wo;
  private final String wp;
  private final Integer wq;
  private final Address wr;

  public Location(int paramInt, String paramString)
  {
    this(paramInt, paramString, Double.valueOf(0.0D), Double.valueOf(0.0D), Integer.valueOf(Config.nN()), null, null, null);
  }

  public Location(int paramInt, String paramString1, Double paramDouble1, Double paramDouble2, Integer paramInteger, String paramString2, String paramString3, Address paramAddress)
  {
    mType = paramInt;
    mName = paramString1;
    wn = paramDouble1;
    wo = paramDouble2;
    wq = paramInteger;
    wp = paramString2;
    sw = paramString3;
    wr = paramAddress;
  }

  private Location(Parcel paramParcel)
  {
    this(paramParcel.readInt(), paramParcel.readString(), Double.valueOf(paramParcel.readDouble()), Double.valueOf(paramParcel.readDouble()), Integer.valueOf(paramParcel.readInt()), paramParcel.readString(), paramParcel.readString(), null);
  }

  public Location(Place paramPlace)
  {
    mType = 3;
    mName = paramPlace.getName().toString();
    Object localObject = paramPlace.getLatLng();
    wn = Double.valueOf(((LatLng)localObject).latitude);
    wo = Double.valueOf(((LatLng)localObject).longitude);
    wp = paramPlace.getAddress().toString();
    sw = paramPlace.getId();
    wq = Integer.valueOf(Config.nN());
    localObject = paramPlace.getAddressComponents();
    wr = new Address.Builder().setName(paramPlace.getName().toString()).setStreetName((String)((Map)localObject).get(Integer.valueOf(1021))).setPostalCode((String)((Map)localObject).get(Integer.valueOf(1015))).setLocality((String)((Map)localObject).get(Integer.valueOf(1009))).setRegion((String)((Map)localObject).get(Integer.valueOf(1001))).setCountry((String)((Map)localObject).get(Integer.valueOf(1005))).build();
  }

  public Location(String paramString1, Double paramDouble1, Double paramDouble2, Integer paramInteger, String paramString2, String paramString3, Address paramAddress)
  {
    this(3, paramString1, paramDouble1, paramDouble2, paramInteger, paramString2, paramString3, paramAddress);
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (getClass() != paramObject.getClass()));
    label15: label96: 
    do
    {
      break label96;
      do
      {
        do
          do
          {
            return false;
            paramObject = (Location)paramObject;
            if (wq == null)
              break;
          }
          while (!wq.equals(paramObject.wq));
        while (mType != paramObject.mType);
        if (wn == null)
          break label135;
      }
      while (!wn.equals(paramObject.wn));
      while (true)
        if (wo != null)
        {
          if (!wo.equals(paramObject.wo))
            break label15;
          if ((!mName.equals(paramObject.mName)) || (!sw.equals(paramObject.sw)))
            break label15;
          return true;
          if (paramObject.wq == null)
            break;
          return false;
          if (paramObject.wn != null)
            return false;
        }
    }
    while (paramObject.wo == null);
    label135: return false;
  }

  public Address getAddress()
  {
    return wr;
  }

  public String getPlaceId()
  {
    return sw;
  }

  public Integer getRadius()
  {
    return wq;
  }

  public int getType()
  {
    return mType;
  }

  public Double hW()
  {
    return wn;
  }

  public Double hX()
  {
    return wo;
  }

  public String hY()
  {
    return wp;
  }

  public int hashCode()
  {
    int k = 0;
    int m = mType;
    int n = mName.hashCode();
    int i;
    if (wn != null)
    {
      i = wn.hashCode();
      if (wo == null)
        break label106;
    }
    label106: for (int j = wo.hashCode(); ; j = 0)
    {
      int i1 = wq.intValue();
      if (sw != null)
        k = sw.hashCode();
      return ((((m * 31 + n) * 31 + i) * 31 + j) * 31 + i1) * 31 + k;
      i = 0;
      break;
    }
  }

  public String r(Context paramContext)
  {
    LocationReminder.LocationType localLocationType = LocationReminder.LocationType.bb(mType);
    if (localLocationType == LocationReminder.LocationType.ww)
      return paramContext.getString(2131231233);
    if (localLocationType == LocationReminder.LocationType.wx)
      return paramContext.getString(2131231234);
    return mName;
  }

  public String toString()
  {
    return "Location{mType=" + mType + ", mName='" + mName + '\'' + ", mLatitude=" + wn + ", mLongitude=" + wo + ", mFormattedAddress='" + wp + '\'' + ", mPlaceId='" + sw + '\'' + ", mRadius=" + wq + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(mType);
    paramParcel.writeString(mName);
    paramParcel.writeDouble(wn.doubleValue());
    paramParcel.writeDouble(wo.doubleValue());
    paramParcel.writeInt(wq.intValue());
    paramParcel.writeString(wp);
    paramParcel.writeString(sw);
  }
}