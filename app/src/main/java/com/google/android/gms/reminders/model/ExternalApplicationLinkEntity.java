package com.google.android.gms.reminders.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;

public class ExternalApplicationLinkEntity
  implements SafeParcelable, ExternalApplicationLink
{
  public static final Parcelable.Creator<ExternalApplicationLinkEntity> CREATOR = new zzg();
  public final int mVersionCode;
  private final String zzLf;
  private final Integer zzbnW;

  ExternalApplicationLinkEntity(int paramInt, Integer paramInteger, String paramString)
  {
    zzbnW = paramInteger;
    zzLf = paramString;
    mVersionCode = paramInt;
  }

  public ExternalApplicationLinkEntity(ExternalApplicationLink paramExternalApplicationLink)
  {
    this(paramExternalApplicationLink.getApplication(), paramExternalApplicationLink.getId(), false);
  }

  ExternalApplicationLinkEntity(Integer paramInteger, String paramString, boolean paramBoolean)
  {
    this(1, paramInteger, paramString);
  }

  public static int zza(ExternalApplicationLink paramExternalApplicationLink)
  {
    return zzu.hashCode(new Object[] { paramExternalApplicationLink.getApplication(), paramExternalApplicationLink.getId() });
  }

  public static boolean zza(ExternalApplicationLink paramExternalApplicationLink1, ExternalApplicationLink paramExternalApplicationLink2)
  {
    return (zzu.equal(paramExternalApplicationLink1.getApplication(), paramExternalApplicationLink2.getApplication())) && (zzu.equal(paramExternalApplicationLink1.getId(), paramExternalApplicationLink2.getId()));
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
    return zza(this, (ExternalApplicationLink)paramObject);
  }

  public Integer getApplication()
  {
    return zzbnW;
  }

  public String getId()
  {
    return zzLf;
  }

  public int hashCode()
  {
    return zza(this);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzg.zza(this, paramParcel, paramInt);
  }

  public ExternalApplicationLink zzCg()
  {
    return this;
  }
}