package com.google.android.keep.activities;

import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import com.android.ex.photo.Intents;
import com.android.ex.photo.Intents.PhotoViewIntentBuilder;
import com.android.ex.photo.PhotoViewActivity;
import com.android.ex.photo.PhotoViewController;
import com.google.android.keep.provider.i.i;
import com.google.android.keep.provider.i.j;
import com.google.android.keep.task.TaskHelper;
import com.google.android.keep.ui.b.b;
import com.google.android.keep.z;
import com.google.android.keep.z.a;

public class GalleryActivity extends PhotoViewActivity
  implements b.b, z.a
{
  public static final String df = "'" + i.j.Cq + "/'";
  public static final String[] dg = { "(" + df + " || " + "_id" + ") AS " + "contentUri", "file_name AS _display_name", "(" + df + " || " + "blob_id" + ") AS " + "uri", "mime_type AS contentType", "(" + df + " || " + "_id" + ") AS " + "thumbnailUri", "NULL AS loadingIndicator", "_id", "account_id", "extracted_text", "extraction_status" };
  private boolean de;

  public static Intent a(Context paramContext, long paramLong, Uri paramUri)
  {
    Uri localUri = ContentUris.withAppendedId(i.i.Cp, paramLong);
    return Intents.newPhotoViewIntentBuilder(paramContext, GalleryActivity.class).setProjection(dg).setPhotosUri(localUri.toString()).setResolvedPhotoUri(paramUri.toString()).setInitialPhotoUri(paramUri.toString()).build();
  }

  public z X()
  {
    return (z)super.getController();
  }

  public void a(int paramInt1, int paramInt2, Parcelable paramParcelable)
  {
    if ((paramInt1 == 1) && (paramInt2 == 1) && ((paramParcelable instanceof Uri)))
    {
      TaskHelper.g(this, ContentUris.parseId((Uri)paramParcelable));
      finish();
    }
  }

  public PhotoViewController createController()
  {
    return new z(this);
  }

  protected void onCreate(Bundle paramBundle)
  {
    requestWindowFeature(2);
    super.onCreate(paramBundle);
    de = getIntent().getBooleanExtra("isReadonly", false);
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    return X().a(paramMenu, de);
  }

  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    X().b(paramMenu, de);
    return true;
  }
}