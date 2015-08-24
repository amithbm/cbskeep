package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzv;

public abstract class WriteAwareParcelable
  implements Parcelable
{
  private volatile transient boolean zzasZ = false;

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (!zzsL());
    for (boolean bool = true; ; bool = false)
    {
      zzv.zzR(bool);
      zzasZ = true;
      zzK(paramParcel, paramInt);
      return;
    }
  }

  protected abstract void zzK(Parcel paramParcel, int paramInt);

  public final boolean zzsL()
  {
    return zzasZ;
  }
}