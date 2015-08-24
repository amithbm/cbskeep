package com.google.android.gms.reminders.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;

public class CategoryInfoEntity
  implements SafeParcelable, CategoryInfo
{
  public static final Parcelable.Creator<CategoryInfoEntity> CREATOR = new zzb();
  public final int mVersionCode;
  private final String zzPa;
  private final String zzbnz;

  CategoryInfoEntity(int paramInt, String paramString1, String paramString2)
  {
    zzbnz = paramString1;
    zzPa = paramString2;
    mVersionCode = paramInt;
  }

  public CategoryInfoEntity(CategoryInfo paramCategoryInfo)
  {
    this(paramCategoryInfo.getCategoryId(), paramCategoryInfo.getDisplayName(), false);
  }

  CategoryInfoEntity(String paramString1, String paramString2, boolean paramBoolean)
  {
    this(1, paramString1, paramString2);
  }

  public static int zza(CategoryInfo paramCategoryInfo)
  {
    return zzu.hashCode(new Object[] { paramCategoryInfo.getCategoryId(), paramCategoryInfo.getDisplayName() });
  }

  public static boolean zza(CategoryInfo paramCategoryInfo1, CategoryInfo paramCategoryInfo2)
  {
    return (zzu.equal(paramCategoryInfo1.getCategoryId(), paramCategoryInfo2.getCategoryId())) && (zzu.equal(paramCategoryInfo1.getDisplayName(), paramCategoryInfo2.getDisplayName()));
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof CategoryInfo))
      return false;
    if (this == paramObject)
      return true;
    return zza(this, (CategoryInfo)paramObject);
  }

  public String getCategoryId()
  {
    return zzbnz;
  }

  public String getDisplayName()
  {
    return zzPa;
  }

  public int hashCode()
  {
    return zza(this);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }

  public CategoryInfo zzCc()
  {
    return this;
  }
}