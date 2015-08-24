package com.google.android.keep.model;

import android.content.Context;
import com.google.android.keep.binder.Binder;
import com.google.android.keep.p;
import com.google.android.keep.q.e;
import com.google.android.keep.q.f;
import com.google.android.keep.r;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class o
  implements q.e, q.f, r
{
  private Context mContext;
  private ModelEventDispatcher.b xG;
  private Set<ModelEventDispatcher> xH = new HashSet();

  public o(Context paramContext, ModelEventDispatcher.b paramb, p paramp)
  {
    mContext = paramContext;
    xG = paramb;
    paramp.b(this);
  }

  public <T> T e(Class<T> paramClass)
  {
    paramClass = Binder.a(mContext, paramClass);
    if ((paramClass instanceof ModelEventDispatcher))
      xH.add((ModelEventDispatcher)paramClass);
    return paramClass;
  }

  public boolean ih()
  {
    Iterator localIterator = xH.iterator();
    while (localIterator.hasNext())
      if (!((ModelEventDispatcher)localIterator.next()).isInitialized())
        return false;
    return true;
  }

  public void onPause()
  {
    Iterator localIterator = xH.iterator();
    while (localIterator.hasNext())
      ((ModelEventDispatcher)localIterator.next()).b(xG);
  }

  public void onResume()
  {
    Iterator localIterator = xH.iterator();
    while (localIterator.hasNext())
      ((ModelEventDispatcher)localIterator.next()).a(xG);
  }
}