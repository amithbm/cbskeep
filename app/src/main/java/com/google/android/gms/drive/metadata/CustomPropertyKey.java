package com.google.android.gms.drive.metadata;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzv;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomPropertyKey
  implements SafeParcelable
{
  public static final Parcelable.Creator<CustomPropertyKey> CREATOR = new zzc();
  private static final Pattern zzawx = Pattern.compile("[\\w.!@$%^&*()/-]+");
  final int mVersionCode;
  final int mVisibility;
  final String zzua;

  CustomPropertyKey(int paramInt1, String paramString, int paramInt2)
  {
    zzv.zzb(paramString, "key");
    zzv.zzb(zzawx.matcher(paramString).matches(), "key name characters must be alphanumeric or one of .!@$%^&*()-_/");
    boolean bool1 = bool2;
    if (paramInt2 != 0)
      if (paramInt2 != 1)
        break label69;
    label69: for (bool1 = bool2; ; bool1 = false)
    {
      zzv.zzb(bool1, "visibility must be either PUBLIC or PRIVATE");
      mVersionCode = paramInt1;
      zzua = paramString;
      mVisibility = paramInt2;
      return;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == null);
    do
    {
      return false;
      if (paramObject == this)
        return true;
    }
    while (!(paramObject instanceof CustomPropertyKey));
    paramObject = (CustomPropertyKey)paramObject;
    if ((paramObject.getKey().equals(zzua)) && (paramObject.getVisibility() == mVisibility));
    while (true)
    {
      return bool;
      bool = false;
    }
  }

  public String getKey()
  {
    return zzua;
  }

  public int getVisibility()
  {
    return mVisibility;
  }

  public int hashCode()
  {
    return (zzua + mVisibility).hashCode();
  }

  public String toString()
  {
    return "CustomPropertyKey(" + zzua + "," + mVisibility + ")";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
}