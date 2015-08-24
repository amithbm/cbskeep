package com.google.android.keep.model;

import android.os.Bundle;
import com.google.android.keep.e;

public abstract class p extends e
  implements ModelEventDispatcher.b
{
  private o xI;

  protected <T> T e(Class<T> paramClass)
  {
    return xI.e(paramClass);
  }

  protected boolean ih()
  {
    return xI.ih();
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    xI = new o(getActivity(), this, se);
  }
}