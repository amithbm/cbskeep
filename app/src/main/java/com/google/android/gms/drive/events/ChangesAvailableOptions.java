package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.drive.DriveSpace;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public final class ChangesAvailableOptions
  implements SafeParcelable
{
  public static final Parcelable.Creator<ChangesAvailableOptions> CREATOR = new zzc();
  final int mVersionCode;
  final int zzatc;
  final boolean zzatd;
  final List<DriveSpace> zzate;
  private final Set<DriveSpace> zzatf;

  ChangesAvailableOptions(int paramInt1, int paramInt2, boolean paramBoolean, List<DriveSpace> paramList)
  {
  }

  private ChangesAvailableOptions(int paramInt1, int paramInt2, boolean paramBoolean, List<DriveSpace> paramList, Set<DriveSpace> paramSet)
  {
    mVersionCode = paramInt1;
    zzatc = paramInt2;
    zzatd = paramBoolean;
    zzate = paramList;
    zzatf = paramSet;
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
      paramObject = (ChangesAvailableOptions)paramObject;
      if ((!zzu.equal(zzatf, paramObject.zzatf)) || (zzatc != paramObject.zzatc))
        break;
      bool1 = bool2;
    }
    while (zzatd == paramObject.zzatd);
    return false;
  }

  public int hashCode()
  {
    return zzu.hashCode(new Object[] { zzatf, Integer.valueOf(zzatc), Boolean.valueOf(zzatd) });
  }

  public String toString()
  {
    return String.format(Locale.US, "ChangesAvailableOptions[ChangesSizeLimit=%d, Repeats=%s, Spaces=%s]", new Object[] { Integer.valueOf(zzatc), Boolean.valueOf(zzatd), zzate });
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
}