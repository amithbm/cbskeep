package com.google.android.gms.internal;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.people.Images;
import com.google.android.gms.people.Images.LoadImageOptions;
import com.google.android.gms.people.Images.LoadImageResult;
import com.google.android.gms.people.Images.SetAvatarResult;
import com.google.android.gms.people.People.zza;
import com.google.android.gms.people.internal.zzl;
import com.google.android.gms.people.internal.zzn;
import com.google.android.gms.people.model.AvatarReference;

public class zzrw
  implements Images
{
  public PendingResult<Images.LoadImageResult> loadByReference(GoogleApiClient paramGoogleApiClient, final AvatarReference paramAvatarReference, final Images.LoadImageOptions paramLoadImageOptions)
  {
    if (zzl.isEnabled())
      zzl.zzh("loadByReference", new Object[] { paramAvatarReference, paramLoadImageOptions });
    return paramGoogleApiClient.zza(new zza(paramGoogleApiClient, paramAvatarReference)
    {
      protected void zza(zzn paramAnonymouszzn)
      {
        setCancelToken(paramAnonymouszzn.zza(this, paramAvatarReference, paramLoadImageOptions));
      }
    });
  }

  public PendingResult<Images.LoadImageResult> loadOwnerAvatar(GoogleApiClient paramGoogleApiClient, final String paramString1, final String paramString2, final int paramInt1, final int paramInt2)
  {
    if (zzl.isEnabled())
      zzl.zzh("loadOwnerAvatar", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    return paramGoogleApiClient.zza(new zza(paramGoogleApiClient, paramString1)
    {
      protected void zza(zzn paramAnonymouszzn)
      {
        setCancelToken(paramAnonymouszzn.zzb(this, paramString1, paramString2, paramInt1, paramInt2));
      }
    });
  }

  public PendingResult<Images.LoadImageResult> loadOwnerCoverPhoto(GoogleApiClient paramGoogleApiClient, final String paramString1, final String paramString2)
  {
    if (zzl.isEnabled())
      zzl.zzh("loadOwnerCoverPhoto", new Object[] { paramString1, paramString2 });
    return paramGoogleApiClient.zza(new zza(paramGoogleApiClient, paramString1)
    {
      protected void zza(zzn paramAnonymouszzn)
      {
        setCancelToken(paramAnonymouszzn.zza(this, paramString1, paramString2, 0));
      }
    });
  }

  public PendingResult<Images.LoadImageResult> loadOwnerCoverPhoto(GoogleApiClient paramGoogleApiClient, String paramString1, String paramString2, int paramInt)
  {
    return loadOwnerCoverPhoto(paramGoogleApiClient, paramString1, paramString2);
  }

  private static abstract class zza extends People.zza<Images.LoadImageResult>
  {
    private zza(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }

    public final Images.LoadImageResult zzbT(final Status paramStatus)
    {
      return new Images.LoadImageResult()
      {
        public int getHeight()
        {
          return 0;
        }

        public ParcelFileDescriptor getParcelFileDescriptor()
        {
          return null;
        }

        public Status getStatus()
        {
          return paramStatus;
        }

        public int getWidth()
        {
          return 0;
        }

        public void release()
        {
        }
      };
    }
  }
}