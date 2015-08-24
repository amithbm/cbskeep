package com.google.android.keep;

import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.android.ex.photo.PhotoViewController;
import com.android.ex.photo.PhotoViewController.ActivityInterface;
import com.google.android.keep.model.ImageBlob;
import com.google.android.keep.ui.b.a;
import com.google.android.keep.util.e;

public class z extends PhotoViewController
{
  protected final a sW;

  public z(a parama)
  {
    super(parama);
    sW = parama;
  }

  private void fX()
  {
    Object localObject = fZ();
    if (localObject == null);
    for (localObject = null; ; localObject = ((String)localObject).trim())
    {
      int j = ga();
      int i = j;
      if (j == 0)
      {
        i = j;
        if (localObject != null)
          i = 4;
      }
      switch (i)
      {
      default:
        e.b(sW.getContext(), 2131231300);
        return;
      case 1:
      case 2:
      case 3:
      case 4:
      }
    }
    localObject = new Intent();
    ((Intent)localObject).putExtra("com.google.android.keep.intent.extra.INTENT_EXTRA_EXTRACTION_BUSY_BLOB_ID", ContentUris.parseId(gb()));
    sW.setResult(-1, (Intent)localObject);
    sW.finish();
    return;
    e.b(sW.getContext(), 2131231295);
    return;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("com.google.android.keep.intent.extra.EXTRACTED_TEXT", (String)localObject);
      sW.setResult(-1, localIntent);
      sW.finish();
      return;
    }
    e.b(sW.getContext(), 2131231300);
  }

  private void fY()
  {
    Uri localUri = gb();
    if (localUri == null)
      return;
    new b.a((FragmentActivity)sW, 1).bO(2131231177).a(localUri).bP(2131231075).show();
  }

  private String fZ()
  {
    Cursor localCursor = getCursorAtProperPosition();
    if (!g(localCursor))
      return null;
    return localCursor.getString(localCursor.getColumnIndex("extracted_text"));
  }

  private boolean g(Cursor paramCursor)
  {
    return (paramCursor != null) && (!paramCursor.isClosed());
  }

  private int ga()
  {
    Cursor localCursor = getCursorAtProperPosition();
    if (!g(localCursor))
      return 0;
    return localCursor.getInt(localCursor.getColumnIndex("extraction_status"));
  }

  private Uri gb()
  {
    Cursor localCursor = getCursorAtProperPosition();
    if (!g(localCursor))
      return null;
    return Uri.parse(localCursor.getString(localCursor.getColumnIndex("contentUri")));
  }

  public boolean a(Menu paramMenu, boolean paramBoolean)
  {
    sW.getMenuInflater().inflate(2131820546, paramMenu);
    paramMenu = paramMenu.findItem(2131493428);
    if (!paramBoolean);
    for (paramBoolean = true; ; paramBoolean = false)
    {
      paramMenu.setVisible(paramBoolean);
      return true;
    }
  }

  public boolean b(Menu paramMenu, boolean paramBoolean)
  {
    String str = fZ();
    if (str == null)
    {
      str = null;
      boolean bool = ImageBlob.c(str, ga());
      paramMenu = paramMenu.findItem(2131493431);
      if ((!bool) || (paramBoolean))
        break label63;
    }
    label63: for (paramBoolean = true; ; paramBoolean = false)
    {
      paramMenu.setVisible(paramBoolean);
      return true;
      str = str.trim();
      break;
    }
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    case 2131493429:
    default:
      return super.onOptionsItemSelected(paramMenuItem);
    case 2131493428:
      fY();
      return true;
    case 2131493431:
      fX();
      return true;
    case 2131493430:
    }
    paramMenuItem = new Intent("android.intent.action.SEND");
    paramMenuItem.setType("image/*");
    paramMenuItem.putExtra("android.intent.extra.STREAM", com.google.android.keep.util.z.w(gb()));
    paramMenuItem.addFlags(524289);
    sW.getContext().startActivity(paramMenuItem);
    return true;
  }

  public static abstract interface a extends PhotoViewController.ActivityInterface
  {
    public abstract MenuInflater getMenuInflater();

    public abstract void setResult(int paramInt, Intent paramIntent);
  }
}