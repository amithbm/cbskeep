package com.android.ex.photo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.android.ex.photo.fragments.PhotoViewFragment;

public class Intents
{
  public static PhotoViewIntentBuilder newPhotoViewFragmentIntentBuilder(Context paramContext, Class<? extends PhotoViewFragment> paramClass)
  {
    return new PhotoViewIntentBuilder(paramContext, paramClass, null);
  }

  public static PhotoViewIntentBuilder newPhotoViewIntentBuilder(Context paramContext, Class<? extends Activity> paramClass)
  {
    return new PhotoViewIntentBuilder(paramContext, paramClass, null);
  }

  public static class PhotoViewIntentBuilder
  {
    private boolean mActionBarHiddenInitially;
    private boolean mDisplayFullScreenThumbs;
    private String mInitialPhotoUri;
    private final Intent mIntent;
    private Float mMaxInitialScale;
    private Integer mPhotoIndex;
    private String mPhotosUri;
    private String[] mProjection;
    private String mResolvedPhotoUri;
    private boolean mScaleAnimation;
    private int mStartHeight;
    private int mStartWidth;
    private int mStartX;
    private int mStartY;
    private String mThumbnailUri;
    private boolean mWatchNetwork;

    private PhotoViewIntentBuilder(Context paramContext, Class<?> paramClass)
    {
      mIntent = new Intent(paramContext, paramClass);
      initialize();
    }

    private void initialize()
    {
      mScaleAnimation = false;
      mActionBarHiddenInitially = false;
      mDisplayFullScreenThumbs = false;
    }

    public Intent build()
    {
      mIntent.setAction("android.intent.action.VIEW");
      mIntent.setFlags(67633152);
      if (mPhotoIndex != null)
        mIntent.putExtra("photo_index", mPhotoIndex.intValue());
      if (mInitialPhotoUri != null)
        mIntent.putExtra("initial_photo_uri", mInitialPhotoUri);
      if ((mInitialPhotoUri != null) && (mPhotoIndex != null))
        throw new IllegalStateException("specified both photo index and photo uri");
      if (mPhotosUri != null)
      {
        mIntent.putExtra("photos_uri", mPhotosUri);
        mIntent.setData(Uri.parse(mPhotosUri));
      }
      if (mResolvedPhotoUri != null)
        mIntent.putExtra("resolved_photo_uri", mResolvedPhotoUri);
      if (mProjection != null)
        mIntent.putExtra("projection", mProjection);
      if (mThumbnailUri != null)
        mIntent.putExtra("thumbnail_uri", mThumbnailUri);
      if (mMaxInitialScale != null)
        mIntent.putExtra("max_scale", mMaxInitialScale);
      mIntent.putExtra("watch_network", mWatchNetwork);
      mIntent.putExtra("scale_up_animation", mScaleAnimation);
      if (mScaleAnimation)
      {
        mIntent.putExtra("start_x_extra", mStartX);
        mIntent.putExtra("start_y_extra", mStartY);
        mIntent.putExtra("start_width_extra", mStartWidth);
        mIntent.putExtra("start_height_extra", mStartHeight);
      }
      mIntent.putExtra("action_bar_hidden_initially", mActionBarHiddenInitially);
      mIntent.putExtra("display_thumbs_fullscreen", mDisplayFullScreenThumbs);
      return mIntent;
    }

    public PhotoViewIntentBuilder setDisplayThumbsFullScreen(boolean paramBoolean)
    {
      mDisplayFullScreenThumbs = paramBoolean;
      return this;
    }

    public PhotoViewIntentBuilder setInitialPhotoUri(String paramString)
    {
      mInitialPhotoUri = paramString;
      return this;
    }

    public PhotoViewIntentBuilder setMaxInitialScale(float paramFloat)
    {
      mMaxInitialScale = Float.valueOf(paramFloat);
      return this;
    }

    public PhotoViewIntentBuilder setPhotosUri(String paramString)
    {
      mPhotosUri = paramString;
      return this;
    }

    public PhotoViewIntentBuilder setProjection(String[] paramArrayOfString)
    {
      mProjection = paramArrayOfString;
      return this;
    }

    public PhotoViewIntentBuilder setResolvedPhotoUri(String paramString)
    {
      mResolvedPhotoUri = paramString;
      return this;
    }

    public PhotoViewIntentBuilder setThumbnailUri(String paramString)
    {
      mThumbnailUri = paramString;
      return this;
    }
  }
}