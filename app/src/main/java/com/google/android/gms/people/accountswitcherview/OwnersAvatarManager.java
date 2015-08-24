package com.google.android.gms.people.accountswitcherview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.people.Images;
import com.google.android.gms.people.Images.LoadImageResult;
import com.google.android.gms.people.People;
import com.google.android.gms.people.model.Owner;

public class OwnersAvatarManager extends OwnersImageManager
{
  private OwnerWrapper sOwnerWrapper;

  public OwnersAvatarManager(Context paramContext, GoogleApiClient paramGoogleApiClient)
  {
    super(paramContext, paramGoogleApiClient, true);
  }

  public Bitmap getPlaceholder(Context paramContext, Owner paramOwner, int paramInt)
  {
    return ImageUtils.frameBitmapInCircle(BitmapFactory.decodeResource(paramContext.getResources(), R.drawable.avatar_placeholder));
  }

  public void loadOwnerAvatar(ImageView paramImageView, Owner paramOwner, int paramInt)
  {
    loadImageRequest(new OwnerAvatarRequest(paramImageView, paramOwner, paramInt));
  }

  @Deprecated
  public void loadOwnerAvatar(ImageView paramImageView, String paramString, int paramInt)
  {
    if (sOwnerWrapper == null)
      sOwnerWrapper = new OwnerWrapper(paramString);
    while (true)
    {
      loadImageRequest(new OwnerAvatarRequest(paramImageView, sOwnerWrapper, paramInt));
      return;
      sOwnerWrapper.mOwnerName = paramString;
    }
  }

  protected void setImageBitmap(OwnersImageManager.OwnerImageRequest paramOwnerImageRequest, Bitmap paramBitmap)
  {
    if (paramBitmap == null)
    {
      paramBitmap = paramOwnerImageRequest.view;
      paramOwnerImageRequest = (OwnerAvatarRequest)paramOwnerImageRequest;
      paramBitmap.setImageBitmap(getPlaceholder(mContext, paramOwnerImageRequest.owner, paramOwnerImageRequest.avatarSize));
      return;
    }
    super.setImageBitmap(paramOwnerImageRequest, paramBitmap);
  }

  private final class OwnerAvatarRequest extends OwnersImageManager.OwnerImageRequest
  {
    public final int avatarSize;
    public final Owner owner;
    public final String pageId;

    public OwnerAvatarRequest(ImageView paramOwner, Owner paramInt, int arg4)
    {
      super();
      view = paramOwner;
      owner = paramInt;
      accountName = paramInt.getAccountName();
      pageId = paramInt.getPlusPageId();
      int i;
      avatarSize = i;
    }

    public void load()
    {
      People.ImageApi.loadOwnerAvatar(mClient, accountName, pageId, avatarSize, 1).setResultCallback(new ResultCallback()
      {
        public void onResult(Images.LoadImageResult paramAnonymousLoadImageResult)
        {
          onImageLoaded(paramAnonymousLoadImageResult);
        }
      });
    }

    public void onImageLoaded(Images.LoadImageResult paramLoadImageResult)
    {
      OwnersAvatarManager.this.onImageLoaded(paramLoadImageResult.getStatus(), paramLoadImageResult.getParcelFileDescriptor(), this, 0);
    }
  }

  private static class OwnerWrapper
    implements Owner
  {
    public String mOwnerName;

    public OwnerWrapper(String paramString)
    {
      mOwnerName = paramString;
    }

    public String getAccountName()
    {
      return mOwnerName;
    }

    public String getAvatarUrl()
    {
      return null;
    }

    public String getCoverPhotoUrl()
    {
      return null;
    }

    public String getDisplayName()
    {
      return null;
    }

    public String getPlusPageId()
    {
      return null;
    }
  }
}