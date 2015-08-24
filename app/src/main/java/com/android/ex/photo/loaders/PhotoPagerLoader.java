package com.android.ex.photo.loaders;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.support.v4.content.CursorLoader;
import com.android.ex.photo.provider.PhotoContract.PhotoQuery;

public class PhotoPagerLoader extends CursorLoader
{
  private final Uri mPhotosUri;
  private final String[] mProjection;

  public PhotoPagerLoader(Context paramContext, Uri paramUri, String[] paramArrayOfString)
  {
    super(paramContext);
    mPhotosUri = paramUri;
    if (paramArrayOfString != null);
    while (true)
    {
      mProjection = paramArrayOfString;
      return;
      paramArrayOfString = PhotoContract.PhotoQuery.PROJECTION;
    }
  }

  public Cursor loadInBackground()
  {
    setUri(mPhotosUri.buildUpon().appendQueryParameter("contentType", "image/").build());
    setProjection(mProjection);
    return super.loadInBackground();
  }
}