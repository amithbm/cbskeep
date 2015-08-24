package com.google.android.gms.reminders.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;

public class AddressEntity
  implements SafeParcelable, Address
{
  public static final Parcelable.Creator<AddressEntity> CREATOR = new zza();
  private final String mName;
  public final int mVersionCode;
  private final String zzbko;
  private final String zzbks;
  private final String zzbnu;
  private final String zzbnv;
  private final String zzbnw;
  private final String zzbnx;
  private final String zzbny;

  AddressEntity(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    zzbnu = paramString1;
    zzbnv = paramString2;
    zzbnw = paramString3;
    zzbks = paramString4;
    zzbnx = paramString5;
    zzbny = paramString6;
    zzbko = paramString7;
    mName = paramString8;
    mVersionCode = paramInt;
  }

  public AddressEntity(Address paramAddress)
  {
    this(paramAddress.getCountry(), paramAddress.getLocality(), paramAddress.getRegion(), paramAddress.getStreetAddress(), paramAddress.getStreetNumber(), paramAddress.getStreetName(), paramAddress.getPostalCode(), paramAddress.getName(), false);
  }

  AddressEntity(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, boolean paramBoolean)
  {
    this(1, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8);
  }

  public static int zza(Address paramAddress)
  {
    return zzu.hashCode(new Object[] { paramAddress.getCountry(), paramAddress.getLocality(), paramAddress.getRegion(), paramAddress.getStreetAddress(), paramAddress.getStreetNumber(), paramAddress.getStreetName(), paramAddress.getPostalCode(), paramAddress.getName() });
  }

  public static boolean zza(Address paramAddress1, Address paramAddress2)
  {
    return (zzu.equal(paramAddress1.getCountry(), paramAddress2.getCountry())) && (zzu.equal(paramAddress1.getLocality(), paramAddress2.getLocality())) && (zzu.equal(paramAddress1.getRegion(), paramAddress2.getRegion())) && (zzu.equal(paramAddress1.getStreetAddress(), paramAddress2.getStreetAddress())) && (zzu.equal(paramAddress1.getStreetNumber(), paramAddress2.getStreetNumber())) && (zzu.equal(paramAddress1.getStreetName(), paramAddress2.getStreetName())) && (zzu.equal(paramAddress1.getPostalCode(), paramAddress2.getPostalCode())) && (zzu.equal(paramAddress1.getName(), paramAddress2.getName()));
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Address))
      return false;
    if (this == paramObject)
      return true;
    return zza(this, (Address)paramObject);
  }

  public String getCountry()
  {
    return zzbnu;
  }

  public String getLocality()
  {
    return zzbnv;
  }

  public String getName()
  {
    return mName;
  }

  public String getPostalCode()
  {
    return zzbko;
  }

  public String getRegion()
  {
    return zzbnw;
  }

  public String getStreetAddress()
  {
    return zzbks;
  }

  public String getStreetName()
  {
    return zzbny;
  }

  public String getStreetNumber()
  {
    return zzbnx;
  }

  public int hashCode()
  {
    return zza(this);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }

  public Address zzCb()
  {
    return this;
  }
}