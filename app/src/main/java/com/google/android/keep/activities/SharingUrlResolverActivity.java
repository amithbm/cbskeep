package com.google.android.keep.activities;

import android.accounts.Account;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.text.TextUtils;
import com.google.android.keep.model.j;
import com.google.android.keep.provider.i.v;
import com.google.android.keep.ui.u;
import com.google.android.keep.util.e;
import com.google.android.keep.util.o;

public class SharingUrlResolverActivity extends FragmentActivity
{
  private final LoaderManager.LoaderCallbacks<Cursor> dA = new LoaderManager.LoaderCallbacks()
  {
    private Cursor mCursor;

    private void a(Cursor paramAnonymousCursor)
    {
      if (mCursor == paramAnonymousCursor)
        return;
      if (mCursor != null)
        mCursor.close();
      mCursor = paramAnonymousCursor;
    }

    public Loader<Cursor> onCreateLoader(int paramAnonymousInt, Bundle paramAnonymousBundle)
    {
      paramAnonymousBundle = SharingUrlResolverActivity.this;
      Uri localUri = i.v.CONTENT_URI;
      String str1 = SharingUrlResolverActivity.a(SharingUrlResolverActivity.this);
      String str2 = Long.toString(SharingUrlResolverActivity.b(SharingUrlResolverActivity.this).getId());
      return new CursorLoader(paramAnonymousBundle, localUri, new String[] { "_id" }, "server_id=? AND account_id=?", new String[] { str1, str2 }, null);
    }

    public void onLoadFinished(Loader<Cursor> paramAnonymousLoader, Cursor paramAnonymousCursor)
    {
      a(paramAnonymousCursor);
      if (paramAnonymousCursor == null)
        return;
      if (paramAnonymousCursor.moveToFirst())
      {
        SharingUrlResolverActivity.a(SharingUrlResolverActivity.this, paramAnonymousCursor.getLong(0));
        return;
      }
      SharingUrlResolverActivity.c(SharingUrlResolverActivity.this);
    }

    public void onLoaderReset(Loader<Cursor> paramAnonymousLoader)
    {
      a(null);
    }
  };
  private final Runnable dB = new Runnable()
  {
    public void run()
    {
      SharingUrlResolverActivity.d(SharingUrlResolverActivity.this);
    }
  };
  private u dC;
  private String dw;
  private j dx;
  private String dy;
  private String dz;
  private Handler mHandler = new Handler();

  public static Intent a(Context paramContext, Uri paramUri)
  {
    Intent localIntent = new Intent(paramContext, SharingUrlResolverActivity.class);
    String str1 = paramUri.getQueryParameter("note");
    String str2 = paramUri.getQueryParameter("email");
    paramContext = paramUri.getQueryParameter("proposedEmailToAdd");
    if ((TextUtils.isEmpty(str1)) && (TextUtils.isEmpty(str2)))
      paramContext = null;
    do
    {
      return paramContext;
      localIntent.putExtra("note_server_id", str1);
      localIntent.putExtra("authAccount", str2);
      paramUri = paramUri.getQueryParameter("invite");
      if (!TextUtils.isEmpty(paramContext))
        localIntent.putExtra("com.google.android.keep.intent.action.PROPOSED_EMAIL_TO_ADD", paramContext);
      paramContext = localIntent;
    }
    while (TextUtils.isEmpty(paramUri));
    localIntent.putExtra("invitation_token", paramUri);
    return localIntent;
  }

  private void ay()
  {
    mHandler.removeCallbacks(dB);
    Intent localIntent = new Intent(this, BrowseActivity.class);
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.putExtra("authAccount", dx.getName());
    localIntent.putExtra("com.google.android.keep.intent.extra.SHOW_REQUEST_ACCESS", dw);
    TaskStackBuilder.create(this).addNextIntent(localIntent).startActivities();
    finish();
  }

  private void az()
  {
    if (dC != null)
      dC.dismiss();
    Intent localIntent = new Intent(this, BrowseActivity.class);
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.putExtra("authAccount", dx.getName());
    TaskStackBuilder.create(this).addNextIntent(localIntent).startActivities();
    e.b(this, 2131231247);
    finish();
  }

  private void d(long paramLong)
  {
    mHandler.removeCallbacks(dB);
    Intent localIntent = new Intent(this, BrowseActivity.class);
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.putExtra("authAccount", dx.getName());
    localIntent.putExtra("treeEntityId", paramLong);
    localIntent.putExtra("com.google.android.keep.intent.action.PROPOSED_EMAIL_TO_ADD", dz);
    TaskStackBuilder.create(this).addNextIntent(localIntent).startActivities();
    finish();
  }

  private void startLoading()
  {
    dC.show(getSupportFragmentManager(), u.class.getSimpleName());
    mHandler.postDelayed(dB, 10000L);
    getSupportLoaderManager().initLoader(0, null, dA);
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1)
    {
      if ((paramInt2 == -1) && (paramIntent != null) && (paramIntent.getExtras() != null))
      {
        paramIntent = paramIntent.getExtras().getString("authAccount");
        dx = o.m(this, paramIntent);
        if ((dx == null) || (!TextUtils.equals(paramIntent, dx.getName())))
        {
          e.g(this, getResources().getString(2131231348, new Object[] { paramIntent }));
          finish();
          return;
        }
        paramIntent = new Bundle();
        paramIntent.putBoolean("expedited", true);
        paramIntent.putString("note_server_id", dw);
        paramIntent.putString("invitation_token", dy);
        paramIntent.putString("com.google.android.keep.intent.action.PROPOSED_EMAIL_TO_ADD", dz);
        ContentResolver.requestSync(dx.hl(), "com.google.android.keep", paramIntent);
        startLoading();
        return;
      }
      finish();
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    dC = u.g(getString(2131231292), getResources().getColor(2131296430));
    paramBundle = getIntent();
    dw = paramBundle.getStringExtra("note_server_id");
    String str = paramBundle.getStringExtra("authAccount");
    if (paramBundle.hasExtra("com.google.android.keep.intent.action.PROPOSED_EMAIL_TO_ADD"))
      dz = paramBundle.getStringExtra("com.google.android.keep.intent.action.PROPOSED_EMAIL_TO_ADD");
    if (paramBundle.hasExtra("invitation_token"))
    {
      dy = paramBundle.getStringExtra("invitation_token");
      startActivityForResult(o.c(null), 1);
      return;
    }
    dx = o.c(this, new Account(str, "com.google"));
    if (dx == null)
    {
      e.g(this, getResources().getString(2131231348, new Object[] { str }));
      finish();
      return;
    }
    o.m(this, str);
    paramBundle = new Bundle();
    paramBundle.putBoolean("expedited", true);
    ContentResolver.requestSync(dx.hl(), "com.google.android.keep", paramBundle);
    startLoading();
  }
}