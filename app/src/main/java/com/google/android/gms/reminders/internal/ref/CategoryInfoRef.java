package com.google.android.gms.reminders.internal.ref;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.reminders.model.CategoryInfo;
import com.google.android.gms.reminders.model.CategoryInfoEntity;

public class CategoryInfoRef extends zza
  implements CategoryInfo
{
  public CategoryInfoRef(DataHolder paramDataHolder, int paramInt, String paramString)
  {
    super(paramDataHolder, paramInt, paramString);
  }

  public static boolean zza(DataHolder paramDataHolder, int paramInt1, int paramInt2, String paramString)
  {
    return (paramDataHolder.zzj(zzT(paramString, "category_id"), paramInt1, paramInt2)) && (paramDataHolder.zzj(zzT(paramString, "display_name"), paramInt1, paramInt2));
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
    return CategoryInfoEntity.zza(this, (CategoryInfo)paramObject);
  }

  public String getCategoryId()
  {
    return getString(zzer("category_id"));
  }

  public String getDisplayName()
  {
    return getString(zzer("display_name"));
  }

  public int hashCode()
  {
    return CategoryInfoEntity.zza(this);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    new CategoryInfoEntity(this).writeToParcel(paramParcel, paramInt);
  }

  public CategoryInfo zzCc()
  {
    return new CategoryInfoEntity(this);
  }
}