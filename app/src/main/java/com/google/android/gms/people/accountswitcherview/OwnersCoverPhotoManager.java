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

public class OwnersCoverPhotoManager extends OwnersImageManager
{
  private Bitmap sCoverPlaceholderBitmap;

  public OwnersCoverPhotoManager(Context paramContext, GoogleApiClient paramGoogleApiClient)
  {
    super(paramContext, paramGoogleApiClient, false);
  }

  public Bitmap getPlaceholder(Context paramContext)
  {
    if (sCoverPlaceholderBitmap == null)
      sCoverPlaceholderBitmap = BitmapFactory.decodeResource(paramContext.getResources(), R.drawable.account_switcher_blue);
    return sCoverPlaceholderBitmap;
  }

  public void loadOwnerCoverPhoto(ImageView paramImageView, Owner paramOwner, int paramInt)
  {
    loadImageRequest(new OwnerCoverPhotoRequest(paramImageView, paramOwner.getAccountName(), paramOwner.getPlusPageId(), paramInt));
  }

  protected void setImageBitmap(OwnersImageManager.OwnerImageRequest paramOwnerImageRequest, Bitmap paramBitmap)
  {
    if (paramBitmap == null)
    {
      paramOwnerImageRequest.view.setImageBitmap(getPlaceholder(mContext));
      return;
    }
    super.setImageBitmap(paramOwnerImageRequest, paramBitmap);
  }

  private final class OwnerCoverPhotoRequest extends OwnersImageManager.OwnerImageRequest
  {
    public final String pageId;
    public final int width;

    public OwnerCoverPhotoRequest(ImageView paramString1, String paramString2, String paramInt, int arg5)
    {
      super();
      view = paramString1;
      accountName = paramString2;
      pageId = paramInt;
      int i;
      width = i;
    }

    public void load()
    {
      People.ImageApi.loadOwnerCoverPhoto(mClient, accountName, pageId, width).setResultCallback(new ResultCallback()
      {
        public void onResult(Images.LoadImageResult paramAnonymousLoadImageResult)
        {
          onImageLoaded(paramAnonymousLoadImageResult);
        }
      });
    }

    public void onImageLoaded(Images.LoadImageResult paramLoadImageResult)
    {
      onImageLoaded(paramLoadImageResult.getStatus(), paramLoadImageResult.getParcelFileDescriptor(), paramLoadImageResult.getWidth(), paramLoadImageResult.getHeight(), width, this);
    }
  }
}