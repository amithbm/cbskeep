package com.android.ex.photo.loaders;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v4.content.AsyncTaskLoader;
import com.android.ex.photo.PhotoViewController;
import com.android.ex.photo.util.ImageUtils;

public class PhotoBitmapLoader extends AsyncTaskLoader<PhotoBitmapLoaderInterface.BitmapResult>
  implements PhotoBitmapLoaderInterface
{
  private Bitmap mBitmap;
  private String mPhotoUri;

  public PhotoBitmapLoader(Context paramContext, String paramString)
  {
    super(paramContext);
    mPhotoUri = paramString;
  }

  public void deliverResult(PhotoBitmapLoaderInterface.BitmapResult paramBitmapResult)
  {
    Bitmap localBitmap1;
    if (paramBitmapResult != null)
    {
      localBitmap1 = paramBitmapResult.bitmap;
      if (!isReset())
        break label31;
      if (localBitmap1 != null)
        onReleaseResources(localBitmap1);
    }
    label31: Bitmap localBitmap2;
    do
    {
      return;
      localBitmap1 = null;
      break;
      localBitmap2 = mBitmap;
      mBitmap = localBitmap1;
      if (isStarted())
        super.deliverResult(paramBitmapResult);
    }
    while ((localBitmap2 == null) || (localBitmap2 == localBitmap1) || (localBitmap2.isRecycled()));
    onReleaseResources(localBitmap2);
  }

  public PhotoBitmapLoaderInterface.BitmapResult loadInBackground()
  {
    Object localObject2 = new PhotoBitmapLoaderInterface.BitmapResult();
    Object localObject3 = getContext();
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject1 = localObject2;
      if (mPhotoUri != null)
        localObject1 = ((Context)localObject3).getContentResolver();
    }
    try
    {
      localObject3 = ImageUtils.createLocalBitmap((ContentResolver)localObject1, Uri.parse(mPhotoUri), PhotoViewController.sMaxPhotoSize);
      localObject1 = localObject3;
      localObject2 = localObject3;
      if (((PhotoBitmapLoaderInterface.BitmapResult)localObject3).bitmap != null)
      {
        localObject2 = localObject3;
        ((PhotoBitmapLoaderInterface.BitmapResult)localObject3).bitmap.setDensity(160);
        localObject1 = localObject3;
      }
      return localObject1;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      ((PhotoBitmapLoaderInterface.BitmapResult)localObject2).status = 1;
    }
    return localObject2;
  }

  public void onCanceled(PhotoBitmapLoaderInterface.BitmapResult paramBitmapResult)
  {
    super.onCanceled(paramBitmapResult);
    if (paramBitmapResult != null)
      onReleaseResources(paramBitmapResult.bitmap);
  }

  protected void onReleaseResources(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
      paramBitmap.recycle();
  }

  protected void onReset()
  {
    super.onReset();
    onStopLoading();
    if (mBitmap != null)
    {
      onReleaseResources(mBitmap);
      mBitmap = null;
    }
  }

  protected void onStartLoading()
  {
    if (mBitmap != null)
    {
      PhotoBitmapLoaderInterface.BitmapResult localBitmapResult = new PhotoBitmapLoaderInterface.BitmapResult();
      localBitmapResult.status = 0;
      localBitmapResult.bitmap = mBitmap;
      deliverResult(localBitmapResult);
    }
    if ((takeContentChanged()) || (mBitmap == null))
      forceLoad();
  }

  protected void onStopLoading()
  {
    cancelLoad();
  }

  public void setPhotoUri(String paramString)
  {
    mPhotoUri = paramString;
  }
}