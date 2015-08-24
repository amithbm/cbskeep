package com.google.android.gms.reminders.model;

import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.common.internal.zzv;

public abstract interface Location extends Parcelable, Freezable<Location>
{
  public abstract Address getAddress();

  public abstract String getDisplayAddress();

  public abstract FeatureIdProto getGeoFeatureId();

  public abstract Double getLat();

  public abstract Double getLng();

  public abstract String getLocationAliasId();

  public abstract Integer getLocationType();

  public abstract String getName();

  public abstract Integer getRadiusMeters();

  public static class Builder
  {
    private String mName;
    private Double zzbnZ;
    private Double zzboa;
    private Integer zzbob;
    private Integer zzboc;
    private FeatureIdProto zzbod;
    private String zzboe;
    private Address zzbof;
    private String zzbog;

    public Location build()
    {
      return new LocationEntity(zzbnZ, zzboa, mName, zzbob, zzboc, zzbod, zzboe, zzbof, zzbog, true);
    }

    public Builder setAddress(Address paramAddress)
    {
      if (paramAddress != null);
      for (paramAddress = (Address)paramAddress.freeze(); ; paramAddress = null)
      {
        zzbof = paramAddress;
        return this;
      }
    }

    public Builder setDisplayAddress(String paramString)
    {
      zzboe = paramString;
      return this;
    }

    public Builder setGeoFeatureId(FeatureIdProto paramFeatureIdProto)
    {
      if (paramFeatureIdProto != null);
      for (paramFeatureIdProto = (FeatureIdProto)paramFeatureIdProto.freeze(); ; paramFeatureIdProto = null)
      {
        zzbod = paramFeatureIdProto;
        return this;
      }
    }

    public Builder setLat(Double paramDouble)
    {
      zzbnZ = paramDouble;
      return this;
    }

    public Builder setLng(Double paramDouble)
    {
      zzboa = paramDouble;
      return this;
    }

    public Builder setLocationType(Integer paramInteger)
    {
      boolean bool2 = true;
      boolean bool1 = bool2;
      if (paramInteger != null)
      {
        bool1 = bool2;
        if (paramInteger.intValue() != 1)
        {
          bool1 = bool2;
          if (paramInteger.intValue() != 2)
            if (paramInteger.intValue() != 3)
              break label51;
        }
      }
      label51: for (bool1 = bool2; ; bool1 = false)
      {
        zzv.zzb(bool1, "Invalid constant for LocationType. Use value in ModelConstants");
        zzboc = paramInteger;
        return this;
      }
    }

    public Builder setName(String paramString)
    {
      mName = paramString;
      return this;
    }

    public Builder setRadiusMeters(Integer paramInteger)
    {
      zzbob = paramInteger;
      return this;
    }
  }
}