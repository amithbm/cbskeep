package com.google.android.gms.reminders.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;

public class LocationGroupEntity
  implements SafeParcelable, LocationGroup
{
  public static final Parcelable.Creator<LocationGroupEntity> CREATOR = new zzj();
  public final int mVersionCode;
  private final String zzboj;
  private final Integer zzbok;
  private final ChainInfoEntity zzbon;
  private final CategoryInfoEntity zzboo;

  LocationGroupEntity(int paramInt, String paramString, Integer paramInteger, ChainInfoEntity paramChainInfoEntity, CategoryInfoEntity paramCategoryInfoEntity)
  {
    zzboj = paramString;
    zzbok = paramInteger;
    zzbon = paramChainInfoEntity;
    zzboo = paramCategoryInfoEntity;
    mVersionCode = paramInt;
  }

  public LocationGroupEntity(LocationGroup paramLocationGroup)
  {
    this(paramLocationGroup.getLocationQuery(), paramLocationGroup.getLocationQueryType(), paramLocationGroup.getChainInfo(), paramLocationGroup.getCategoryInfo(), false);
  }

  LocationGroupEntity(String paramString, Integer paramInteger, ChainInfo paramChainInfo, CategoryInfo paramCategoryInfo, boolean paramBoolean)
  {
    mVersionCode = 2;
    zzboj = paramString;
    zzbok = paramInteger;
    if (paramBoolean)
    {
      zzbon = ((ChainInfoEntity)paramChainInfo);
      zzboo = ((CategoryInfoEntity)paramCategoryInfo);
      return;
    }
    if (paramChainInfo == null)
    {
      paramString = null;
      zzbon = paramString;
      if (paramCategoryInfo != null)
        break label82;
    }
    label82: for (paramString = localObject; ; paramString = new CategoryInfoEntity(paramCategoryInfo))
    {
      zzboo = paramString;
      return;
      paramString = new ChainInfoEntity(paramChainInfo);
      break;
    }
  }

  public static int zza(LocationGroup paramLocationGroup)
  {
    return zzu.hashCode(new Object[] { paramLocationGroup.getLocationQuery(), paramLocationGroup.getLocationQueryType(), paramLocationGroup.getChainInfo(), paramLocationGroup.getCategoryInfo() });
  }

  public static boolean zza(LocationGroup paramLocationGroup1, LocationGroup paramLocationGroup2)
  {
    return (zzu.equal(paramLocationGroup1.getLocationQuery(), paramLocationGroup2.getLocationQuery())) && (zzu.equal(paramLocationGroup1.getLocationQueryType(), paramLocationGroup2.getLocationQueryType())) && (zzu.equal(paramLocationGroup1.getChainInfo(), paramLocationGroup2.getChainInfo())) && (zzu.equal(paramLocationGroup1.getCategoryInfo(), paramLocationGroup2.getCategoryInfo()));
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
    return zza(this, (LocationGroup)paramObject);
  }

  public CategoryInfo getCategoryInfo()
  {
    return zzboo;
  }

  public ChainInfo getChainInfo()
  {
    return zzbon;
  }

  public String getLocationQuery()
  {
    return zzboj;
  }

  public Integer getLocationQueryType()
  {
    return zzbok;
  }

  public int hashCode()
  {
    return zza(this);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzj.zza(this, paramParcel, paramInt);
  }

  public LocationGroup zzCi()
  {
    return this;
  }
}