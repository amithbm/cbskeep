package com.google.android.gms.people;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.people.model.AvatarReference;

public abstract interface Images
{
  public abstract PendingResult<LoadImageResult> loadByReference(GoogleApiClient paramGoogleApiClient, AvatarReference paramAvatarReference, LoadImageOptions paramLoadImageOptions);

  public abstract PendingResult<LoadImageResult> loadOwnerAvatar(GoogleApiClient paramGoogleApiClient, String paramString1, String paramString2, int paramInt1, int paramInt2);

  public abstract PendingResult<LoadImageResult> loadOwnerCoverPhoto(GoogleApiClient paramGoogleApiClient, String paramString1, String paramString2, int paramInt);

  public static class LoadImageOptions
  {
    public static final LoadImageOptions DEFAULT = new Builder().build();
    public final int avatarOptions;
    public final int imageSize;
    public final boolean useLargePictureForCp2Images;

    private LoadImageOptions(Builder paramBuilder)
    {
      imageSize = Builder.zza(paramBuilder);
      avatarOptions = Builder.zzb(paramBuilder);
      useLargePictureForCp2Images = paramBuilder.mUseLargePictureForCp2Images;
    }

    public static class Builder
    {
      public boolean mUseLargePictureForCp2Images;
      private int zzbcA = 0;
      private int zzbcz = 1;

      public final Images.LoadImageOptions build()
      {
        return new Images.LoadImageOptions(this, null);
      }

      public Builder setAvatarOptions(int paramInt)
      {
        zzbcA = paramInt;
        return this;
      }

      public Builder setImageSize(int paramInt)
      {
        zzbcz = paramInt;
        return this;
      }
    }
  }

  public static abstract interface LoadImageResult extends People.ReleasableResult
  {
    public abstract int getHeight();

    public abstract ParcelFileDescriptor getParcelFileDescriptor();

    public abstract int getWidth();
  }

  public static abstract interface SetAvatarResult extends Result
  {
  }
}