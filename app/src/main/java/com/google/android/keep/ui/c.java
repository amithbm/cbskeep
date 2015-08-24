package com.google.android.keep.ui;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.LruCache;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.people.Autocomplete;
import com.google.android.gms.people.Autocomplete.AutocompleteOptions.Builder;
import com.google.android.gms.people.Autocomplete.AutocompleteResult;
import com.google.android.gms.people.Images;
import com.google.android.gms.people.Images.LoadImageOptions;
import com.google.android.gms.people.Images.LoadImageOptions.Builder;
import com.google.android.gms.people.Images.LoadImageResult;
import com.google.android.gms.people.People;
import com.google.android.gms.people.People.PeopleOptions1p.Builder;
import com.google.android.gms.people.PeopleClientUtil;
import com.google.android.gms.people.accountswitcherview.OwnersAvatarManager;
import com.google.android.gms.people.model.AutocompleteBuffer;
import com.google.android.gms.people.model.AutocompleteEntry;
import com.google.android.keep.p;
import com.google.android.keep.q.c;
import com.google.android.keep.q.h;
import com.google.android.keep.q.i;
import com.google.android.keep.util.e;
import com.google.android.keep.util.j;

public class c
  implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, q.c, q.h, q.i, com.google.android.keep.r
{
  private static final Object Iv = new Object();
  private static volatile LruCache<String, Bitmap> Iw;
  private static final String TAG = c.class.getSimpleName();
  private boolean Bj = true;
  private final OwnersAvatarManager Ix;
  private final GoogleApiClient gh;

  public c(Context paramContext, p paramp)
  {
    if (Iw == null);
    synchronized (Iv)
    {
      if (Iw == null)
        Iw = new LruCache(1048576 * ((ActivityManager)paramContext.getSystemService("activity")).getMemoryClass() / 16)
        {
          protected int b(String paramAnonymousString, Bitmap paramAnonymousBitmap)
          {
            return paramAnonymousBitmap.getByteCount();
          }
        };
      ??? = new People.PeopleOptions1p.Builder().setClientApplicationId(131).build();
      gh = new GoogleApiClient.Builder(paramContext).addApi(People.API_1P, (Api.ApiOptions.HasOptions)???).addConnectionCallbacks(this).addOnConnectionFailedListener(this).build();
      Ix = new OwnersAvatarManager(paramContext, gh);
      if (paramp != null)
        paramp.b(this);
      return;
    }
  }

  private void a(ImageView paramImageView, Bitmap paramBitmap)
  {
    if (paramImageView != null)
    {
      paramImageView.setImageBitmap(paramBitmap);
      paramImageView.setBackgroundColor(0);
      paramImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }
  }

  private void a(String paramString, Bitmap paramBitmap)
  {
    synchronized (Iw)
    {
      if ((Iw.get(paramString) == null) && (paramBitmap != null))
        Iw.put(paramString, paramBitmap);
      return;
    }
  }

  private Bitmap n(String paramString1, String paramString2)
  {
    if ((gh == null) || (!gh.isConnected()));
    do
    {
      do
      {
        return null;
        paramString2 = new Autocomplete.AutocompleteOptions.Builder().setAccount(paramString2).setAutocompleteType(1).build();
        localObject = (Autocomplete.AutocompleteResult)j.b(People.AutocompleteApi.loadAutocompleteList(gh, paramString1, paramString2));
        if ((localObject == null) || (((Autocomplete.AutocompleteResult)localObject).getAutocompleteEntries() == null) || (((Autocomplete.AutocompleteResult)localObject).getAutocompleteEntries().getCount() <= 0))
        {
          e.a((Releasable)localObject);
          return null;
        }
        paramString2 = ((Autocomplete.AutocompleteResult)localObject).getAutocompleteEntries().get(0).getAvatarReference();
        e.a((Releasable)localObject);
      }
      while (paramString2 == null);
      localObject = new Images.LoadImageOptions.Builder().setImageSize(1).setAvatarOptions(1).build();
      paramString2 = (Images.LoadImageResult)j.b(People.ImageApi.loadByReference(gh, paramString2, (Images.LoadImageOptions)localObject));
    }
    while (!paramString2.getStatus().isSuccess());
    Object localObject = PeopleClientUtil.decodeFileDescriptor(paramString2.getParcelFileDescriptor());
    a(paramString1, (Bitmap)localObject);
    e.a(paramString2);
    return localObject;
  }

  public void a(final String paramString1, final String paramString2, final ImageView paramImageView)
  {
    if (TextUtils.isEmpty(paramString1));
    do
    {
      return;
      paramImageView.setTag(paramString1);
      Bitmap localBitmap = (Bitmap)Iw.get(paramString1);
      if (localBitmap != null)
      {
        a(paramImageView, localBitmap);
        return;
      }
      paramImageView.setImageResource(2130837727);
    }
    while (!gh.isConnected());
    if (TextUtils.equals(paramString1, paramString2))
      Ix.loadOwnerAvatar(paramImageView, paramString2, 1);
    new AsyncTask()
    {
      protected Bitmap doInBackground(Void[] paramAnonymousArrayOfVoid)
      {
        return c.a(c.this, paramString1, paramString2);
      }

      protected void onPostExecute(Bitmap paramAnonymousBitmap)
      {
        if (paramAnonymousBitmap != null)
        {
          Object localObject = paramImageView.getTag();
          if (((localObject instanceof String)) && (TextUtils.equals(paramString1, (String)localObject)))
            c.a(c.this, paramImageView, paramAnonymousBitmap);
        }
      }
    }
    .execute(new Void[0]);
  }

  public void close()
  {
    Ix.close();
  }

  public void kk()
  {
    j.d(gh);
  }

  public void kl()
  {
    j.e(gh);
  }

  public void lX()
  {
    j.f(gh);
  }

  public Bitmap m(String paramString1, String paramString2)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString1))
      localObject = null;
    Bitmap localBitmap;
    do
    {
      return localObject;
      localBitmap = (Bitmap)Iw.get(paramString1);
      localObject = localBitmap;
    }
    while (localBitmap != null);
    return n(paramString1, paramString2);
  }

  public void onConnected(Bundle paramBundle)
  {
    com.google.android.keep.util.r.a(TAG, "Client connection success", new Object[0]);
  }

  public void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    com.google.android.keep.util.r.d(TAG, "Client connection failure: " + paramConnectionResult, new Object[0]);
    if (Bj)
    {
      kk();
      Bj = false;
    }
  }

  public void onConnectionSuspended(int paramInt)
  {
    com.google.android.keep.util.r.d(TAG, "Client connection suspended with cause: " + paramInt, new Object[0]);
  }

  public void onDestroy()
  {
    close();
  }

  public void onStart()
  {
    kk();
  }

  public void onStop()
  {
    kl();
  }
}