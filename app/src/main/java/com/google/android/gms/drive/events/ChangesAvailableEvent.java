package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import java.util.Locale;

public final class ChangesAvailableEvent
  implements SafeParcelable, DriveEvent
{
  public static final Parcelable.Creator<ChangesAvailableEvent> CREATOR = new zzb();
  final int mVersionCode;
  final String zzQt;
  final ChangesAvailableOptions zzatb;

  ChangesAvailableEvent(int paramInt, String paramString, ChangesAvailableOptions paramChangesAvailableOptions)
  {
    mVersionCode = paramInt;
    zzQt = paramString;
    zzatb = paramChangesAvailableOptions;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramObject == null) || (paramObject.getClass() != getClass()))
      bool1 = false;
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      }
      while (paramObject == this);
      paramObject = (ChangesAvailableEvent)paramObject;
      if (!zzu.equal(zzatb, paramObject.zzatb))
        break;
      bool1 = bool2;
    }
    while (zzu.equal(zzQt, paramObject.zzQt));
    return false;
  }

  public int hashCode()
  {
    return zzu.hashCode(new Object[] { zzatb, zzQt });
  }

  public String toString()
  {
    return String.format(Locale.US, "ChangesAvailableEvent [changesAvailableOptions=%s]", new Object[] { zzatb });
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
}