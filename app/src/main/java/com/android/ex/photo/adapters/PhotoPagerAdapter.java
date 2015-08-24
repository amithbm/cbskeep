package com.android.ex.photo.adapters;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.util.SimpleArrayMap;
import com.android.ex.photo.Intents;
import com.android.ex.photo.Intents.PhotoViewIntentBuilder;
import com.android.ex.photo.fragments.PhotoViewFragment;
import com.android.ex.photo.provider.PhotoContract.PhotoQuery;

public class PhotoPagerAdapter extends BaseCursorPagerAdapter
{
  protected SimpleArrayMap<String, Integer> mColumnIndices = new SimpleArrayMap(PhotoContract.PhotoQuery.PROJECTION.length);
  protected boolean mDisplayThumbsFullScreen;
  protected final float mMaxScale;

  public PhotoPagerAdapter(Context paramContext, FragmentManager paramFragmentManager, Cursor paramCursor, float paramFloat, boolean paramBoolean)
  {
    super(paramContext, paramFragmentManager, paramCursor);
    mMaxScale = paramFloat;
    mDisplayThumbsFullScreen = paramBoolean;
  }

  private String getString(Cursor paramCursor, String paramString)
  {
    if (mColumnIndices.containsKey(paramString))
      return paramCursor.getString(((Integer)mColumnIndices.get(paramString)).intValue());
    return null;
  }

  protected PhotoViewFragment createPhotoViewFragment(Intent paramIntent, int paramInt, boolean paramBoolean)
  {
    return PhotoViewFragment.newInstance(paramIntent, paramInt, paramBoolean);
  }

  public Fragment getItem(Context paramContext, Cursor paramCursor, int paramInt)
  {
    paramContext = getPhotoUri(paramCursor);
    String str = getThumbnailUri(paramCursor);
    boolean bool3 = shouldShowLoadingIndicator(paramCursor);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramContext == null)
    {
      bool1 = bool2;
      if (bool3)
        bool1 = true;
    }
    paramCursor = Intents.newPhotoViewFragmentIntentBuilder(mContext, getPhotoViewFragmentClass());
    paramCursor.setResolvedPhotoUri(paramContext).setThumbnailUri(str).setDisplayThumbsFullScreen(mDisplayThumbsFullScreen).setMaxInitialScale(mMaxScale);
    return createPhotoViewFragment(paramCursor.build(), paramInt, bool1);
  }

  public String getPhotoUri(Cursor paramCursor)
  {
    return getString(paramCursor, "contentUri");
  }

  protected Class<? extends PhotoViewFragment> getPhotoViewFragmentClass()
  {
    return PhotoViewFragment.class;
  }

  public String getThumbnailUri(Cursor paramCursor)
  {
    return getString(paramCursor, "thumbnailUri");
  }

  public boolean shouldShowLoadingIndicator(Cursor paramCursor)
  {
    paramCursor = getString(paramCursor, "loadingIndicator");
    if (paramCursor == null)
      return false;
    return Boolean.valueOf(paramCursor).booleanValue();
  }

  public Cursor swapCursor(Cursor paramCursor)
  {
    mColumnIndices.clear();
    if (paramCursor != null)
    {
      String[] arrayOfString = PhotoContract.PhotoQuery.PROJECTION;
      int j = arrayOfString.length;
      int i = 0;
      String str;
      while (i < j)
      {
        str = arrayOfString[i];
        mColumnIndices.put(str, Integer.valueOf(paramCursor.getColumnIndexOrThrow(str)));
        i += 1;
      }
      arrayOfString = PhotoContract.PhotoQuery.OPTIONAL_COLUMNS;
      j = arrayOfString.length;
      i = 0;
      while (i < j)
      {
        str = arrayOfString[i];
        int k = paramCursor.getColumnIndex(str);
        if (k != -1)
          mColumnIndices.put(str, Integer.valueOf(k));
        i += 1;
      }
    }
    return super.swapCursor(paramCursor);
  }
}