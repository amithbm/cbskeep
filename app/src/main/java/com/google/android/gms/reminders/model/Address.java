package com.google.android.gms.reminders.model;

import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;

public abstract interface Address extends Parcelable, Freezable<Address>
{
  public abstract String getCountry();

  public abstract String getLocality();

  public abstract String getName();

  public abstract String getPostalCode();

  public abstract String getRegion();

  public abstract String getStreetAddress();

  public abstract String getStreetName();

  public abstract String getStreetNumber();

  public static class Builder
  {
    private String mName;
    private String zzbko;
    private String zzbks;
    private String zzbnu;
    private String zzbnv;
    private String zzbnw;
    private String zzbnx;
    private String zzbny;

    public Address build()
    {
      return new AddressEntity(zzbnu, zzbnv, zzbnw, zzbks, zzbnx, zzbny, zzbko, mName, true);
    }

    public Builder setCountry(String paramString)
    {
      zzbnu = paramString;
      return this;
    }

    public Builder setLocality(String paramString)
    {
      zzbnv = paramString;
      return this;
    }

    public Builder setName(String paramString)
    {
      mName = paramString;
      return this;
    }

    public Builder setPostalCode(String paramString)
    {
      zzbko = paramString;
      return this;
    }

    public Builder setRegion(String paramString)
    {
      zzbnw = paramString;
      return this;
    }

    public Builder setStreetName(String paramString)
    {
      zzbny = paramString;
      return this;
    }

    public Builder setStreetNumber(String paramString)
    {
      zzbnx = paramString;
      return this;
    }
  }
}