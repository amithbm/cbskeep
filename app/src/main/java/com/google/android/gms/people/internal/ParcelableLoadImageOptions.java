package com.google.android.gms.people.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.common.internal.zzu.zza;
import com.google.android.gms.people.Images.LoadImageOptions;

public class ParcelableLoadImageOptions
  implements SafeParcelable
{
  public static final zzk CREATOR = new zzk();
  private final boolean mUseLargePictureForCp2Images;
  private final int mVersionCode;
  private final int zzbcA;
  private final int zzbcz;

  ParcelableLoadImageOptions(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    mVersionCode = paramInt1;
    zzbcz = paramInt2;
    zzbcA = paramInt3;
    mUseLargePictureForCp2Images = paramBoolean;
  }

  public static ParcelableLoadImageOptions zza(Images.LoadImageOptions paramLoadImageOptions)
  {
    Images.LoadImageOptions localLoadImageOptions = paramLoadImageOptions;
    if (paramLoadImageOptions == null)
      localLoadImageOptions = Images.LoadImageOptions.DEFAULT;
    return new ParcelableLoadImageOptions(1, localLoadImageOptions.imageSize, localLoadImageOptions.avatarOptions, localLoadImageOptions.useLargePictureForCp2Images);
  }

  public int describeContents()
  {
    return 0;
  }

  public int getVersionCode()
  {
    return mVersionCode;
  }

  public String toString()
  {
    return zzu.zzy(this).zzc("imageSize", Integer.valueOf(zzbcz)).zzc("avatarOptions", Integer.valueOf(zzbcA)).zzc("useLargePictureForCp2Images", Boolean.valueOf(mUseLargePictureForCp2Images)).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzk.zza(this, paramParcel, paramInt);
  }

  public int zzAE()
  {
    return zzbcz;
  }

  public int zzAF()
  {
    return zzbcA;
  }

  public boolean zzAG()
  {
    return mUseLargePictureForCp2Images;
  }
}