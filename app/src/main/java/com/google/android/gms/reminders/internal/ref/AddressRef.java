package com.google.android.gms.reminders.internal.ref;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.reminders.model.Address;
import com.google.android.gms.reminders.model.AddressEntity;

public class AddressRef extends zza
  implements Address
{
  public AddressRef(DataHolder paramDataHolder, int paramInt, String paramString)
  {
    super(paramDataHolder, paramInt, paramString);
  }

  public static boolean zza(DataHolder paramDataHolder, int paramInt1, int paramInt2, String paramString)
  {
    return (paramDataHolder.zzj(zzT(paramString, "country"), paramInt1, paramInt2)) && (paramDataHolder.zzj(zzT(paramString, "locality"), paramInt1, paramInt2)) && (paramDataHolder.zzj(zzT(paramString, "region"), paramInt1, paramInt2)) && (paramDataHolder.zzj(zzT(paramString, "street_address"), paramInt1, paramInt2)) && (paramDataHolder.zzj(zzT(paramString, "street_number"), paramInt1, paramInt2)) && (paramDataHolder.zzj(zzT(paramString, "street_name"), paramInt1, paramInt2)) && (paramDataHolder.zzj(zzT(paramString, "postal_code"), paramInt1, paramInt2)) && (paramDataHolder.zzj(zzT(paramString, "name"), paramInt1, paramInt2));
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
    return AddressEntity.zza(this, (Address)paramObject);
  }

  public String getCountry()
  {
    return getString(zzer("country"));
  }

  public String getLocality()
  {
    return getString(zzer("locality"));
  }

  public String getName()
  {
    return getString(zzer("name"));
  }

  public String getPostalCode()
  {
    return getString(zzer("postal_code"));
  }

  public String getRegion()
  {
    return getString(zzer("region"));
  }

  public String getStreetAddress()
  {
    return getString(zzer("street_address"));
  }

  public String getStreetName()
  {
    return getString(zzer("street_name"));
  }

  public String getStreetNumber()
  {
    return getString(zzer("street_number"));
  }

  public int hashCode()
  {
    return AddressEntity.zza(this);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    new AddressEntity(this).writeToParcel(paramParcel, paramInt);
  }

  public Address zzCb()
  {
    return new AddressEntity(this);
  }
}