package com.google.android.gms.location.copresence.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;

public class UnpublishOperation
  implements SafeParcelable
{
  public static final Parcelable.Creator<UnpublishOperation> CREATOR = new zzp();
  private final int mVersionCode;
  public final int type;
  public final String zzaTb;

  UnpublishOperation(int paramInt1, int paramInt2, String paramString)
  {
    mVersionCode = paramInt1;
    type = paramInt2;
    zzaTb = paramString;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    do
    {
      return true;
      if (paramObject == null)
        return false;
      if (getClass() != paramObject.getClass())
        return false;
      paramObject = (UnpublishOperation)paramObject;
    }
    while ((type == paramObject.type) && (TextUtils.equals(zzaTb, paramObject.zzaTb)));
    return false;
  }

  int getVersionCode()
  {
    return mVersionCode;
  }

  public int hashCode()
  {
    return zzu.hashCode(new Object[] { Integer.valueOf(type), zzaTb });
  }

  public String toString()
  {
    switch (type)
    {
    default:
      return null;
    case 1:
      return "Unpublish(id=" + zzaTb + ")";
    case 2:
    }
    return "UnpublishAll";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzp.zza(this, paramParcel, paramInt);
  }
}