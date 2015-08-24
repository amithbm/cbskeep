package com.google.android.keep.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.keep.util.u;

public class LocationReminder extends BaseReminder
{
  public static Parcelable.Creator<LocationReminder> CREATOR = new Parcelable.Creator()
  {
    public LocationReminder[] ba(int paramAnonymousInt)
    {
      return new LocationReminder[paramAnonymousInt];
    }

    public LocationReminder j(Parcel paramAnonymousParcel)
    {
      return new LocationReminder(paramAnonymousParcel, null);
    }
  };
  private Location ws;
  private double wt = -1.0D;

  public LocationReminder(long paramLong, Location paramLocation)
  {
    this(paramLong, null, paramLocation, false, 0L);
  }

  public LocationReminder(long paramLong1, String paramString, Location paramLocation, boolean paramBoolean, long paramLong2)
  {
    super(1, paramLong1, paramString, paramBoolean, paramLong2);
    ws = paramLocation;
  }

  private LocationReminder(Parcel paramParcel)
  {
    super(paramParcel);
    ws = ((Location)paramParcel.readParcelable(Location.class.getClassLoader()));
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof LocationReminder));
    do
    {
      return false;
      paramObject = (LocationReminder)paramObject;
    }
    while ((!super.equals(paramObject)) || (wt != paramObject.ia()) || (!u.equals(ws, paramObject.ws)));
    return true;
  }

  public String gu()
  {
    return toString();
  }

  public Location hZ()
  {
    return ws;
  }

  public double ia()
  {
    return wt;
  }

  public String s(Context paramContext)
  {
    return ws.r(paramContext);
  }

  public String toString()
  {
    return super.toString() + " LocationReminder(" + "mDistance=" + wt + "mLocation=" + ws.toString() + ")";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(ws, paramInt);
  }

  public static enum LocationType
  {
    public static int a(LocationType paramLocationType)
    {
      switch (LocationReminder.2.wu[paramLocationType.ordinal()])
      {
      default:
        throw new IllegalStateException("Unknown reminder type " + paramLocationType);
      case 1:
        return 1;
      case 2:
        return 2;
      case 3:
      }
      return 3;
    }

    public static LocationType bb(int paramInt)
    {
      switch (paramInt)
      {
      default:
        return wv;
      case 1:
        return ww;
      case 2:
      }
      return wx;
    }
  }
}