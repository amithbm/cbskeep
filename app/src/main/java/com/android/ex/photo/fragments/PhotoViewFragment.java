package com.android.ex.photo.fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.android.ex.photo.PhotoViewCallbacks;
import com.android.ex.photo.PhotoViewCallbacks.CursorChangedListener;
import com.android.ex.photo.PhotoViewCallbacks.OnScreenListener;
import com.android.ex.photo.PhotoViewController.ActivityInterface;
import com.android.ex.photo.R.bool;
import com.android.ex.photo.R.drawable;
import com.android.ex.photo.R.id;
import com.android.ex.photo.R.layout;
import com.android.ex.photo.R.string;
import com.android.ex.photo.adapters.PhotoPagerAdapter;
import com.android.ex.photo.loaders.PhotoBitmapLoaderInterface;
import com.android.ex.photo.loaders.PhotoBitmapLoaderInterface.BitmapResult;
import com.android.ex.photo.views.PhotoView;
import com.android.ex.photo.views.ProgressBarWrapper;

public class PhotoViewFragment extends Fragment
  implements LoaderManager.LoaderCallbacks<PhotoBitmapLoaderInterface.BitmapResult>, View.OnClickListener, PhotoViewCallbacks.CursorChangedListener, PhotoViewCallbacks.OnScreenListener
{
  protected PhotoPagerAdapter mAdapter;
  protected PhotoViewCallbacks mCallback;
  protected boolean mConnected;
  protected boolean mDisplayThumbsFullScreen;
  protected TextView mEmptyText;
  protected boolean mFullScreen;
  protected Intent mIntent;
  protected BroadcastReceiver mInternetStateReceiver;
  protected boolean mOnlyShowSpinner;
  protected View mPhotoPreviewAndProgress;
  protected ImageView mPhotoPreviewImage;
  protected ProgressBarWrapper mPhotoProgressBar;
  protected PhotoView mPhotoView;
  protected int mPosition;
  protected boolean mProgressBarNeeded = true;
  protected String mResolvedPhotoUri;
  protected ImageView mRetryButton;
  protected boolean mThumbnailShown;
  protected String mThumbnailUri;
  protected boolean mWatchNetworkState;

  private void bindPhoto(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      if (mPhotoView != null)
        mPhotoView.bindDrawable(paramDrawable);
      enableImageTransforms(true);
      mPhotoPreviewAndProgress.setVisibility(8);
      mProgressBarNeeded = false;
    }
  }

  private void displayPhoto(PhotoBitmapLoaderInterface.BitmapResult paramBitmapResult)
  {
    if (paramBitmapResult.status == 1)
    {
      mProgressBarNeeded = false;
      mEmptyText.setText(R.string.failed);
      mEmptyText.setVisibility(0);
      mCallback.onFragmentPhotoLoadComplete(this, false);
      return;
    }
    bindPhoto(paramBitmapResult.getDrawable(getResources()));
    mCallback.onFragmentPhotoLoadComplete(this, true);
  }

  public static void initializeArguments(Intent paramIntent, int paramInt, boolean paramBoolean, PhotoViewFragment paramPhotoViewFragment)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("arg-intent", paramIntent);
    localBundle.putInt("arg-position", paramInt);
    localBundle.putBoolean("arg-show-spinner", paramBoolean);
    paramPhotoViewFragment.setArguments(localBundle);
  }

  public static PhotoViewFragment newInstance(Intent paramIntent, int paramInt, boolean paramBoolean)
  {
    PhotoViewFragment localPhotoViewFragment = new PhotoViewFragment();
    initializeArguments(paramIntent, paramInt, paramBoolean, localPhotoViewFragment);
    return localPhotoViewFragment;
  }

  private void resetPhotoView()
  {
    if (mPhotoView != null)
      mPhotoView.bindPhoto(null);
  }

  private void setViewVisibility()
  {
    if (mCallback == null);
    for (boolean bool = false; ; bool = mCallback.isFragmentFullScreen(this))
    {
      setFullScreen(bool);
      return;
    }
  }

  public void enableImageTransforms(boolean paramBoolean)
  {
    mPhotoView.enableImageTransforms(paramBoolean);
  }

  protected PhotoViewCallbacks getCallbacks()
  {
    return ((PhotoViewController.ActivityInterface)getActivity()).getController();
  }

  public String getPhotoUri()
  {
    return mResolvedPhotoUri;
  }

  protected void initializeView(View paramView)
  {
    mPhotoView = ((PhotoView)paramView.findViewById(R.id.photo_view));
    mPhotoView.setMaxInitialScale(mIntent.getFloatExtra("max_scale", 1.0F));
    mPhotoView.setOnClickListener(this);
    mPhotoView.setFullScreen(mFullScreen, false);
    mPhotoView.enableImageTransforms(false);
    mPhotoPreviewAndProgress = paramView.findViewById(R.id.photo_preview);
    mPhotoPreviewImage = ((ImageView)paramView.findViewById(R.id.photo_preview_image));
    mThumbnailShown = false;
    ProgressBar localProgressBar = (ProgressBar)paramView.findViewById(R.id.indeterminate_progress);
    mPhotoProgressBar = new ProgressBarWrapper((ProgressBar)paramView.findViewById(R.id.determinate_progress), localProgressBar, true);
    mEmptyText = ((TextView)paramView.findViewById(R.id.empty_text));
    mRetryButton = ((ImageView)paramView.findViewById(R.id.retry_button));
    setViewVisibility();
  }

  public boolean isPhotoBound()
  {
    return (mPhotoView != null) && (mPhotoView.isPhotoBound());
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    mCallback = getCallbacks();
    if (mCallback == null)
      throw new IllegalArgumentException("Activity must be a derived class of PhotoViewActivity");
    mAdapter = mCallback.getAdapter();
    if (mAdapter == null)
      throw new IllegalStateException("Callback reported null adapter");
    setViewVisibility();
  }

  public void onClick(View paramView)
  {
    mCallback.toggleFullScreen();
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Bundle localBundle = getArguments();
    if (localBundle == null);
    do
    {
      return;
      mIntent = ((Intent)localBundle.getParcelable("arg-intent"));
      mDisplayThumbsFullScreen = mIntent.getBooleanExtra("display_thumbs_fullscreen", false);
      mPosition = localBundle.getInt("arg-position");
      mOnlyShowSpinner = localBundle.getBoolean("arg-show-spinner");
      mProgressBarNeeded = true;
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getBundle("com.android.mail.photo.fragments.PhotoViewFragment.INTENT");
        if (paramBundle != null)
          mIntent = new Intent().putExtras(paramBundle);
      }
    }
    while (mIntent == null);
    mResolvedPhotoUri = mIntent.getStringExtra("resolved_photo_uri");
    mThumbnailUri = mIntent.getStringExtra("thumbnail_uri");
    mWatchNetworkState = mIntent.getBooleanExtra("watch_network", false);
  }

  public Loader<PhotoBitmapLoaderInterface.BitmapResult> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    if (mOnlyShowSpinner)
      return null;
    String str = null;
    switch (paramInt)
    {
    default:
    case 2:
    case 3:
    }
    while (true)
    {
      return mCallback.onCreateBitmapLoader(paramInt, paramBundle, str);
      str = mThumbnailUri;
      continue;
      str = mResolvedPhotoUri;
    }
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.photo_fragment_view, paramViewGroup, false);
    initializeView(paramLayoutInflater);
    return paramLayoutInflater;
  }

  public void onCursorChanged(Cursor paramCursor)
  {
    if (mAdapter == null);
    do
    {
      do
      {
        do
          return;
        while ((!paramCursor.moveToPosition(mPosition)) || (isPhotoBound()));
        mCallback.onCursorChanged(this, paramCursor);
        localObject1 = getLoaderManager();
        Object localObject2 = ((LoaderManager)localObject1).getLoader(3);
        if (localObject2 != null)
        {
          localObject2 = (PhotoBitmapLoaderInterface)localObject2;
          mResolvedPhotoUri = mAdapter.getPhotoUri(paramCursor);
          ((PhotoBitmapLoaderInterface)localObject2).setPhotoUri(mResolvedPhotoUri);
          ((PhotoBitmapLoaderInterface)localObject2).forceLoad();
        }
      }
      while (mThumbnailShown);
      localObject1 = ((LoaderManager)localObject1).getLoader(2);
    }
    while (localObject1 == null);
    Object localObject1 = (PhotoBitmapLoaderInterface)localObject1;
    mThumbnailUri = mAdapter.getThumbnailUri(paramCursor);
    ((PhotoBitmapLoaderInterface)localObject1).setPhotoUri(mThumbnailUri);
    ((PhotoBitmapLoaderInterface)localObject1).forceLoad();
  }

  public void onDestroyView()
  {
    if (mPhotoView != null)
    {
      mPhotoView.clear();
      mPhotoView = null;
    }
    super.onDestroyView();
  }

  public void onDetach()
  {
    mCallback = null;
    super.onDetach();
  }

  public void onFullScreenChanged(boolean paramBoolean)
  {
    setViewVisibility();
  }

  public boolean onInterceptMoveLeft(float paramFloat1, float paramFloat2)
  {
    if (!mCallback.isFragmentActive(this));
    while ((mPhotoView == null) || (!mPhotoView.interceptMoveLeft(paramFloat1, paramFloat2)))
      return false;
    return true;
  }

  public boolean onInterceptMoveRight(float paramFloat1, float paramFloat2)
  {
    if (!mCallback.isFragmentActive(this));
    while ((mPhotoView == null) || (!mPhotoView.interceptMoveRight(paramFloat1, paramFloat2)))
      return false;
    return true;
  }

  public void onLoadFinished(Loader<PhotoBitmapLoaderInterface.BitmapResult> paramLoader, PhotoBitmapLoaderInterface.BitmapResult paramBitmapResult)
  {
    if ((getView() == null) || (!isAdded()))
      return;
    Drawable localDrawable = paramBitmapResult.getDrawable(getResources());
    switch (paramLoader.getId())
    {
    default:
    case 2:
    case 3:
    }
    while (true)
    {
      if (!mProgressBarNeeded)
        mPhotoProgressBar.setVisibility(8);
      if (localDrawable != null)
        mCallback.onNewPhotoLoaded(mPosition);
      setViewVisibility();
      return;
      if (mDisplayThumbsFullScreen)
      {
        displayPhoto(paramBitmapResult);
      }
      else
      {
        if (isPhotoBound())
          break;
        if (localDrawable == null)
          mPhotoPreviewImage.setImageResource(R.drawable.default_image);
        for (mThumbnailShown = false; ; mThumbnailShown = true)
        {
          mPhotoPreviewImage.setVisibility(0);
          if (getResources().getBoolean(R.bool.force_thumbnail_no_scaling))
            mPhotoPreviewImage.setScaleType(ImageView.ScaleType.CENTER);
          enableImageTransforms(false);
          break;
          mPhotoPreviewImage.setImageDrawable(localDrawable);
        }
        displayPhoto(paramBitmapResult);
      }
    }
  }

  public void onLoaderReset(Loader<PhotoBitmapLoaderInterface.BitmapResult> paramLoader)
  {
  }

  public void onPause()
  {
    if (mWatchNetworkState)
      getActivity().unregisterReceiver(mInternetStateReceiver);
    mCallback.removeCursorListener(this);
    mCallback.removeScreenListener(mPosition);
    resetPhotoView();
    super.onPause();
  }

  public void onResume()
  {
    super.onResume();
    mCallback.addScreenListener(mPosition, this);
    mCallback.addCursorListener(this);
    NetworkInfo localNetworkInfo;
    if (mWatchNetworkState)
    {
      if (mInternetStateReceiver == null)
        mInternetStateReceiver = new InternetStateBroadcastReceiver(null);
      getActivity().registerReceiver(mInternetStateReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
      localNetworkInfo = ((ConnectivityManager)getActivity().getSystemService("connectivity")).getActiveNetworkInfo();
      if (localNetworkInfo == null)
        break label149;
    }
    label149: for (mConnected = localNetworkInfo.isConnected(); ; mConnected = false)
    {
      if (!isPhotoBound())
      {
        mProgressBarNeeded = true;
        mPhotoPreviewAndProgress.setVisibility(0);
        getLoaderManager().initLoader(2, null, this);
        getLoaderManager().initLoader(3, null, this);
      }
      return;
    }
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (mIntent != null)
      paramBundle.putParcelable("com.android.mail.photo.fragments.PhotoViewFragment.INTENT", mIntent.getExtras());
  }

  public void onViewActivated()
  {
    if (!mCallback.isFragmentActive(this))
    {
      resetViews();
      return;
    }
    if (!isPhotoBound())
      getLoaderManager().restartLoader(2, null, this);
    mCallback.onFragmentVisible(this);
  }

  public void onViewUpNext()
  {
    resetViews();
  }

  public void resetViews()
  {
    if (mPhotoView != null)
      mPhotoView.resetTransformations();
  }

  public void setFullScreen(boolean paramBoolean)
  {
    mFullScreen = paramBoolean;
  }

  private class InternetStateBroadcastReceiver extends BroadcastReceiver
  {
    private InternetStateBroadcastReceiver()
    {
    }

    public void onReceive(Context paramContext, Intent paramIntent)
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if ((paramContext == null) || (!paramContext.isConnected()))
        mConnected = false;
      while ((mConnected) || (isPhotoBound()))
        return;
      if (!mThumbnailShown)
        getLoaderManager().restartLoader(2, null, PhotoViewFragment.this);
      getLoaderManager().restartLoader(3, null, PhotoViewFragment.this);
      mConnected = true;
      mPhotoProgressBar.setVisibility(0);
    }
  }
}