package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class FileUploadPreferencesImpl
  implements SafeParcelable
{
  public static final Parcelable.Creator<FileUploadPreferencesImpl> CREATOR = new zzae();
  final int mVersionCode;
  int zzavI;
  int zzavJ;
  boolean zzavK;

  FileUploadPreferencesImpl(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    mVersionCode = paramInt1;
    zzavI = paramInt2;
    zzavJ = paramInt3;
    zzavK = paramBoolean;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzae.zza(this, paramParcel, paramInt);
  }
}