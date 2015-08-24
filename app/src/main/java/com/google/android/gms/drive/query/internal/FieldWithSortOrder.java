package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Locale;

public class FieldWithSortOrder
  implements SafeParcelable
{
  public static final zzc CREATOR = new zzc();
  final int mVersionCode;
  final String zzawt;
  final boolean zzaxO;

  FieldWithSortOrder(int paramInt, String paramString, boolean paramBoolean)
  {
    mVersionCode = paramInt;
    zzawt = paramString;
    zzaxO = paramBoolean;
  }

  public int describeContents()
  {
    return 0;
  }

  public String toString()
  {
    Locale localLocale = Locale.US;
    String str2 = zzawt;
    if (zzaxO);
    for (String str1 = "ASC"; ; str1 = "DESC")
      return String.format(localLocale, "FieldWithSortOrder[%s %s]", new Object[] { str2, str1 });
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
}