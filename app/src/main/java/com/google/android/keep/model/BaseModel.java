package com.google.android.keep.model;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import com.google.android.keep.editor.e.b;
import com.google.android.keep.editor.e.d;
import com.google.android.keep.k;
import com.google.android.keep.p;
import com.google.android.keep.q.b;
import com.google.android.keep.q.g;
import com.google.android.keep.r;
import com.google.android.keep.util.o;

public abstract class BaseModel<T> extends ModelEventDispatcher
  implements e.b, e.d, k, q.b, q.g, r
{
  private final LoaderManager.LoaderCallbacks<T> dA = new LoaderManager.LoaderCallbacks()
  {
    public Loader<T> onCreateLoader(int paramAnonymousInt, Bundle paramAnonymousBundle)
    {
      return gy();
    }

    public void onLoadFinished(Loader<T> paramAnonymousLoader, T paramAnonymousT)
    {
      e(paramAnonymousT);
    }

    public void onLoaderReset(Loader<T> paramAnonymousLoader)
    {
      ib();
      gz();
    }
  };
  private j fr = null;
  private final FragmentActivity mActivity;
  protected final LoaderCreation uw;
  protected final int ux = getClass().getName().hashCode();
  private long uy = -1L;

  BaseModel(FragmentActivity paramFragmentActivity, p paramp, LoaderCreation paramLoaderCreation)
  {
    mActivity = paramFragmentActivity;
    uw = paramLoaderCreation;
    paramp.b(this);
  }

  public void aE()
  {
    fr = o.O(getActivity());
    if (uw == LoaderCreation.uA)
    {
      ib();
      getActivity().getSupportLoaderManager().restartLoader(ux, null, dA);
    }
  }

  public long dP()
  {
    return uy;
  }

  public void dy()
  {
    uy = -1L;
    if (uw != LoaderCreation.uB)
      return;
    ib();
    mActivity.getSupportLoaderManager().destroyLoader(ux);
  }

  protected abstract void e(T paramT);

  public j gA()
  {
    return fr;
  }

  abstract void gB();

  public FragmentActivity getActivity()
  {
    return mActivity;
  }

  protected abstract Loader<T> gy();

  protected abstract void gz();

  public void j(long paramLong)
  {
    int i;
    if ((uy == -1L) && (paramLong != -1L))
    {
      i = 1;
      if (uy == paramLong)
        break label62;
    }
    label62: for (int j = 1; ; j = 0)
    {
      uy = paramLong;
      if (i != 0)
        gB();
      if (uw == LoaderCreation.uB)
        break label68;
      return;
      i = 0;
      break;
    }
    label68: if (paramLong == -1L)
    {
      dy();
      return;
    }
    if (j != 0)
    {
      mActivity.getSupportLoaderManager().restartLoader(ux, null, dA);
      return;
    }
    mActivity.getSupportLoaderManager().initLoader(ux, null, dA);
  }

  public void onCreate(Bundle paramBundle)
  {
    fr = o.O(getActivity());
    if (fr == null);
    do
    {
      return;
      if (paramBundle != null)
        uy = paramBundle.getLong("BaseModel.mTreeEntityId");
    }
    while (uw != LoaderCreation.uA);
    getActivity().getSupportLoaderManager().initLoader(ux, null, dA);
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putLong("BaseModel.mTreeEntityId", uy);
  }

  public static enum LoaderCreation
  {
  }
}