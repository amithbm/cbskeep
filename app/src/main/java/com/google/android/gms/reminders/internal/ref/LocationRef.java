package com.google.android.gms.reminders.internal.ref;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.reminders.model.Address;
import com.google.android.gms.reminders.model.FeatureIdProto;
import com.google.android.gms.reminders.model.Location;
import com.google.android.gms.reminders.model.LocationEntity;

public class LocationRef extends zza
  implements Location
{
  private boolean zzbmG = false;
  private FeatureIdProtoRef zzbmH;
  private boolean zzbmI = false;
  private AddressRef zzbmJ;

  public LocationRef(DataHolder paramDataHolder, int paramInt, String paramString)
  {
    super(paramDataHolder, paramInt, paramString);
  }

  public static boolean zza(DataHolder paramDataHolder, int paramInt1, int paramInt2, String paramString)
  {
    return (paramDataHolder.zzj(zzT(paramString, "lat"), paramInt1, paramInt2)) && (paramDataHolder.zzj(zzT(paramString, "lng"), paramInt1, paramInt2)) && (paramDataHolder.zzj(zzT(paramString, "name"), paramInt1, paramInt2)) && (paramDataHolder.zzj(zzT(paramString, "radius_meters"), paramInt1, paramInt2)) && (paramDataHolder.zzj(zzT(paramString, "location_type"), paramInt1, paramInt2)) && (FeatureIdProtoRef.zza(paramDataHolder, paramInt1, paramInt2, paramString + "location_")) && (paramDataHolder.zzj(zzT(paramString, "display_address"), paramInt1, paramInt2)) && (AddressRef.zza(paramDataHolder, paramInt1, paramInt2, paramString + "address_")) && (paramDataHolder.zzj(zzT(paramString, "location_alias_id"), paramInt1, paramInt2));
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Location))
      return false;
    if (this == paramObject)
      return true;
    return LocationEntity.zza(this, (Location)paramObject);
  }

  public Address getAddress()
  {
    if (!zzbmI)
    {
      zzbmI = true;
      if (!AddressRef.zza(mDataHolder, zzaiZ, zzaja, zzbne + "address_"))
        break label62;
    }
    label62: for (zzbmJ = null; ; zzbmJ = new AddressRef(mDataHolder, zzaiZ, zzbne + "address_"))
      return zzbmJ;
  }

  public String getDisplayAddress()
  {
    return getString(zzer("display_address"));
  }

  public FeatureIdProto getGeoFeatureId()
  {
    if (!zzbmG)
    {
      zzbmG = true;
      if (!FeatureIdProtoRef.zza(mDataHolder, zzaiZ, zzaja, zzbne + "location_"))
        break label62;
    }
    label62: for (zzbmH = null; ; zzbmH = new FeatureIdProtoRef(mDataHolder, zzaiZ, zzbne + "location_"))
      return zzbmH;
  }

  public Double getLat()
  {
    return getAsDouble(zzer("lat"));
  }

  public Double getLng()
  {
    return getAsDouble(zzer("lng"));
  }

  public String getLocationAliasId()
  {
    return getString(zzer("location_alias_id"));
  }

  public Integer getLocationType()
  {
    return getAsInteger(zzer("location_type"));
  }

  public String getName()
  {
    return getString(zzer("name"));
  }

  public Integer getRadiusMeters()
  {
    return getAsInteger(zzer("radius_meters"));
  }

  public int hashCode()
  {
    return LocationEntity.zzb(this);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    new LocationEntity(this).writeToParcel(paramParcel, paramInt);
  }

  public Location zzCj()
  {
    return new LocationEntity(this);
  }
}