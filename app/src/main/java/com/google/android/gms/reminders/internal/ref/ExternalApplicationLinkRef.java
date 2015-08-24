package com.google.android.gms.reminders.internal.ref;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.reminders.model.ExternalApplicationLink;
import com.google.android.gms.reminders.model.ExternalApplicationLinkEntity;

public class ExternalApplicationLinkRef extends zza
  implements ExternalApplicationLink
{
  public ExternalApplicationLinkRef(DataHolder paramDataHolder, int paramInt, String paramString)
  {
    super(paramDataHolder, paramInt, paramString);
  }

  public static boolean zza(DataHolder paramDataHolder, int paramInt1, int paramInt2, String paramString)
  {
    return (paramDataHolder.zzj(zzT(paramString, "link_application"), paramInt1, paramInt2)) && (paramDataHolder.zzj(zzT(paramString, "link_id"), paramInt1, paramInt2));
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ExternalApplicationLink))
      return false;
    if (this == paramObject)
      return true;
    return ExternalApplicationLinkEntity.zza(this, (ExternalApplicationLink)paramObject);
  }

  public Integer getApplication()
  {
    return getAsInteger(zzer("link_application"));
  }

  public String getId()
  {
    return getString(zzer("link_id"));
  }

  public int hashCode()
  {
    return ExternalApplicationLinkEntity.zza(this);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    new ExternalApplicationLinkEntity(this).writeToParcel(paramParcel, paramInt);
  }

  public ExternalApplicationLink zzCg()
  {
    return new ExternalApplicationLinkEntity(this);
  }
}