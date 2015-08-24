package com.google.android.gms.reminders.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;

public class LocationEntity
  implements SafeParcelable, Location
{
  public static final Parcelable.Creator<LocationEntity> CREATOR = new zzi();
  private final String mName;
  public final int mVersionCode;
  private final Double zzbnZ;
  private final Double zzboa;
  private final Integer zzbob;
  private final Integer zzboc;
  private final String zzboe;
  private final String zzbog;
  private final FeatureIdProtoEntity zzboh;
  private final AddressEntity zzboi;

  LocationEntity(int paramInt, Double paramDouble1, Double paramDouble2, String paramString1, Integer paramInteger1, Integer paramInteger2, FeatureIdProtoEntity paramFeatureIdProtoEntity, String paramString2, AddressEntity paramAddressEntity, String paramString3)
  {
    zzbnZ = paramDouble1;
    zzboa = paramDouble2;
    mName = paramString1;
    zzbob = paramInteger1;
    zzboc = paramInteger2;
    zzboh = paramFeatureIdProtoEntity;
    zzboe = paramString2;
    zzboi = paramAddressEntity;
    zzbog = paramString3;
    mVersionCode = paramInt;
  }

  public LocationEntity(Location paramLocation)
  {
    this(paramLocation.getLat(), paramLocation.getLng(), paramLocation.getName(), paramLocation.getRadiusMeters(), paramLocation.getLocationType(), paramLocation.getGeoFeatureId(), paramLocation.getDisplayAddress(), paramLocation.getAddress(), paramLocation.getLocationAliasId(), false);
  }

  LocationEntity(Double paramDouble1, Double paramDouble2, String paramString1, Integer paramInteger1, Integer paramInteger2, FeatureIdProto paramFeatureIdProto, String paramString2, Address paramAddress, String paramString3, boolean paramBoolean)
  {
    mVersionCode = 2;
    zzbnZ = paramDouble1;
    zzboa = paramDouble2;
    mName = paramString1;
    zzbob = paramInteger1;
    zzboc = paramInteger2;
    zzboe = paramString2;
    zzbog = paramString3;
    if (paramBoolean)
    {
      zzboh = ((FeatureIdProtoEntity)paramFeatureIdProto);
      zzboi = ((AddressEntity)paramAddress);
      return;
    }
    if (paramFeatureIdProto == null)
    {
      paramDouble1 = null;
      zzboh = paramDouble1;
      if (paramAddress != null)
        break label114;
    }
    label114: for (paramDouble1 = localObject; ; paramDouble1 = new AddressEntity(paramAddress))
    {
      zzboi = paramDouble1;
      return;
      paramDouble1 = new FeatureIdProtoEntity(paramFeatureIdProto);
      break;
    }
  }

  public static boolean zza(Location paramLocation1, Location paramLocation2)
  {
    return (zzu.equal(paramLocation1.getLat(), paramLocation2.getLat())) && (zzu.equal(paramLocation1.getLng(), paramLocation2.getLng())) && (zzu.equal(paramLocation1.getName(), paramLocation2.getName())) && (zzu.equal(paramLocation1.getRadiusMeters(), paramLocation2.getRadiusMeters())) && (zzu.equal(paramLocation1.getLocationType(), paramLocation2.getLocationType())) && (zzu.equal(paramLocation1.getGeoFeatureId(), paramLocation2.getGeoFeatureId())) && (zzu.equal(paramLocation1.getDisplayAddress(), paramLocation2.getDisplayAddress())) && (zzu.equal(paramLocation1.getAddress(), paramLocation2.getAddress())) && (zzu.equal(paramLocation1.getLocationAliasId(), paramLocation2.getLocationAliasId()));
  }

  public static int zzb(Location paramLocation)
  {
    return zzu.hashCode(new Object[] { paramLocation.getLat(), paramLocation.getLng(), paramLocation.getName(), paramLocation.getRadiusMeters(), paramLocation.getLocationType(), paramLocation.getGeoFeatureId(), paramLocation.getDisplayAddress(), paramLocation.getAddress(), paramLocation.getLocationAliasId() });
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
    return zza(this, (Location)paramObject);
  }

  public Address getAddress()
  {
    return zzboi;
  }

  public String getDisplayAddress()
  {
    return zzboe;
  }

  public FeatureIdProto getGeoFeatureId()
  {
    return zzboh;
  }

  public Double getLat()
  {
    return zzbnZ;
  }

  public Double getLng()
  {
    return zzboa;
  }

  public String getLocationAliasId()
  {
    return zzbog;
  }

  public Integer getLocationType()
  {
    return zzboc;
  }

  public String getName()
  {
    return mName;
  }

  public Integer getRadiusMeters()
  {
    return zzbob;
  }

  public int hashCode()
  {
    return zzb(this);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzi.zza(this, paramParcel, paramInt);
  }

  public Location zzCj()
  {
    return this;
  }
}