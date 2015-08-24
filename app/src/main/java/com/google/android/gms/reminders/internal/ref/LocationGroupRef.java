package com.google.android.gms.reminders.internal.ref;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.reminders.model.CategoryInfo;
import com.google.android.gms.reminders.model.ChainInfo;
import com.google.android.gms.reminders.model.LocationGroup;
import com.google.android.gms.reminders.model.LocationGroupEntity;

public class LocationGroupRef extends zza
  implements LocationGroup
{
  private boolean zzbmC = false;
  private ChainInfoRef zzbmD;
  private boolean zzbmE = false;
  private CategoryInfoRef zzbmF;

  public LocationGroupRef(DataHolder paramDataHolder, int paramInt, String paramString)
  {
    super(paramDataHolder, paramInt, paramString);
  }

  public static boolean zza(DataHolder paramDataHolder, int paramInt1, int paramInt2, String paramString)
  {
    return (paramDataHolder.zzj(zzT(paramString, "location_query"), paramInt1, paramInt2)) && (paramDataHolder.zzj(zzT(paramString, "location_query_type"), paramInt1, paramInt2)) && (ChainInfoRef.zza(paramDataHolder, paramInt1, paramInt2, paramString)) && (CategoryInfoRef.zza(paramDataHolder, paramInt1, paramInt2, paramString));
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof LocationGroup))
      return false;
    if (this == paramObject)
      return true;
    return LocationGroupEntity.zza(this, (LocationGroup)paramObject);
  }

  public CategoryInfo getCategoryInfo()
  {
    if (!zzbmE)
    {
      zzbmE = true;
      if (!CategoryInfoRef.zza(mDataHolder, zzaiZ, zzaja, zzbne))
        break label44;
    }
    label44: for (zzbmF = null; ; zzbmF = new CategoryInfoRef(mDataHolder, zzaiZ, zzbne))
      return zzbmF;
  }

  public ChainInfo getChainInfo()
  {
    if (!zzbmC)
    {
      zzbmC = true;
      if (!ChainInfoRef.zza(mDataHolder, zzaiZ, zzaja, zzbne))
        break label44;
    }
    label44: for (zzbmD = null; ; zzbmD = new ChainInfoRef(mDataHolder, zzaiZ, zzbne))
      return zzbmD;
  }

  public String getLocationQuery()
  {
    return getString(zzer("location_query"));
  }

  public Integer getLocationQueryType()
  {
    return getAsInteger(zzer("location_query_type"));
  }

  public int hashCode()
  {
    return LocationGroupEntity.zza(this);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    new LocationGroupEntity(this).writeToParcel(paramParcel, paramInt);
  }

  public LocationGroup zzCi()
  {
    return new LocationGroupEntity(this);
  }
}