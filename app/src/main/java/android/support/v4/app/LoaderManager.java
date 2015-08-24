package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.content.Loader;

public abstract class LoaderManager
{
  public static void enableDebugLogging(boolean paramBoolean)
  {
    LoaderManagerImpl.DEBUG = paramBoolean;
  }

  public abstract void destroyLoader(int paramInt);

  public abstract <D> Loader<D> getLoader(int paramInt);

  public boolean hasRunningLoaders()
  {
    return false;
  }

  public abstract <D> Loader<D> initLoader(int paramInt, Bundle paramBundle, LoaderCallbacks<D> paramLoaderCallbacks);

  public abstract <D> Loader<D> restartLoader(int paramInt, Bundle paramBundle, LoaderCallbacks<D> paramLoaderCallbacks);

  public static abstract interface LoaderCallbacks<D>
  {
    public abstract Loader<D> onCreateLoader(int paramInt, Bundle paramBundle);

    public abstract void onLoadFinished(Loader<D> paramLoader, D paramD);

    public abstract void onLoaderReset(Loader<D> paramLoader);
  }
}