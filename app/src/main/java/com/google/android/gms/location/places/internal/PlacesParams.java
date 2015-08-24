package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.common.internal.zzu.zza;
import java.util.Locale;

public class PlacesParams
  implements SafeParcelable
{
  public static final zzv CREATOR = new zzv();
  public static final PlacesParams zzaVW = new PlacesParams("com.google.android.gms", Locale.getDefault(), null);
  public final String accountName;
  public final String gCoreClientName;
  public final String localeString;
  public final int versionCode;
  public final String zzaVX;
  public final String zzaVY;
  public final int zzaVZ;

  public PlacesParams(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2)
  {
    versionCode = paramInt1;
    zzaVX = paramString1;
    localeString = paramString2;
    accountName = paramString3;
    gCoreClientName = paramString4;
    zzaVY = paramString5;
    zzaVZ = paramInt2;
  }

  public PlacesParams(String paramString1, Locale paramLocale, String paramString2)
  {
    this(1, paramString1, paramLocale.toString(), paramString2, null, null, GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE);
  }

  public PlacesParams(String paramString1, Locale paramLocale, String paramString2, String paramString3, String paramString4)
  {
    this(1, paramString1, paramLocale.toString(), paramString2, paramString3, paramString4, GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE);
  }

  public int describeContents()
  {
    zzv localzzv = CREATOR;
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    do
    {
      return true;
      if ((paramObject == null) || (!(paramObject instanceof PlacesParams)))
        return false;
      paramObject = (PlacesParams)paramObject;
    }
    while ((localeString.equals(paramObject.localeString)) && (zzaVX.equals(paramObject.zzaVX)) && (zzu.equal(accountName, paramObject.accountName)) && (zzu.equal(gCoreClientName, paramObject.gCoreClientName)) && (zzu.equal(zzaVY, paramObject.zzaVY)));
    return false;
  }

  public int hashCode()
  {
    return zzu.hashCode(new Object[] { zzaVX, localeString, accountName, gCoreClientName, zzaVY });
  }

  public String toString()
  {
    return zzu.zzy(this).zzc("clientPackageName", zzaVX).zzc("locale", localeString).zzc("accountName", accountName).zzc("gCoreClientName", gCoreClientName).zzc("chargedPackageName", zzaVY).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzv localzzv = CREATOR;
    zzv.zza(this, paramParcel, paramInt);
  }
}