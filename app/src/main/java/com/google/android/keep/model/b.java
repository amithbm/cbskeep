package com.google.android.keep.model;

import android.database.Cursor;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.google.android.common.base.Preconditions;
import com.google.android.keep.db.a;
import com.google.android.keep.p;
import com.google.api.client.util.Lists;
import com.google.api.client.util.Sets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public abstract class b<T extends d> extends f
  implements w, Iterable<T>
{
  protected final ArrayList<T> mItems = Lists.newArrayList();
  private final Set<T> uD = Sets.newHashSet();
  protected boolean uE = false;

  b(FragmentActivity paramFragmentActivity, p paramp, BaseModel.LoaderCreation paramLoaderCreation)
  {
    super(paramFragmentActivity, paramp, paramLoaderCreation);
  }

  private T e(T paramT)
  {
    if (paramT == null)
      return null;
    if ((paramT instanceof ModelEventDispatcher))
      ((ModelEventDispatcher)paramT).a(null);
    Preconditions.checkArgument(isInitialized());
    if (!paramT.gv())
    {
      uD.add(paramT);
      gP().a(this);
    }
    gH();
    return paramT;
  }

  private void gD()
  {
    mItems.clear();
    uD.clear();
  }

  public T G(String paramString)
  {
    Iterator localIterator = mItems.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if (TextUtils.equals(locald.gu(), paramString))
        return locald;
    }
    return null;
  }

  protected boolean a(T paramT)
  {
    return d(paramT);
  }

  public void aE()
  {
    gD();
    super.aE();
  }

  public T aK(int paramInt)
  {
    return e((d)mItems.remove(paramInt));
  }

  public T aL(int paramInt)
  {
    return (d)mItems.get(paramInt);
  }

  protected void b(T paramT)
  {
    if (f(paramT))
      return;
    d locald = G(paramT.gu());
    if (locald == null)
    {
      c(paramT);
      return;
    }
    locald.d(paramT);
  }

  public void c(T paramT)
  {
    mItems.add(paramT);
    if ((paramT instanceof ModelEventDispatcher))
      ((ModelEventDispatcher)paramT).a(this);
    if (paramT.gv())
      gP().a(this);
    uD.remove(paramT);
    gI();
  }

  public boolean d(T paramT)
  {
    if (mItems.remove(paramT))
    {
      e(paramT);
      return true;
    }
    return false;
  }

  public void dy()
  {
    if (uw == BaseModel.LoaderCreation.uB)
      gD();
    super.dy();
  }

  public boolean f(T paramT)
  {
    paramT = paramT.gu();
    Iterator localIterator = uD.iterator();
    while (localIterator.hasNext())
      if (TextUtils.equals(((d)localIterator.next()).gu(), paramT))
        return true;
    return false;
  }

  protected void gB()
  {
    if (mItems.size() > 0)
      gP().a(this);
  }

  public boolean gC()
  {
    return uE;
  }

  public T gE()
  {
    if (size() > 0)
      return aL(0);
    return null;
  }

  public T gF()
  {
    if (size() > 0)
      return aL(size() - 1);
    return null;
  }

  public Set<T> gG()
  {
    HashSet localHashSet = Sets.newHashSet();
    localHashSet.addAll(uD);
    uD.clear();
    return localHashSet;
  }

  protected void gH()
  {
    b(ModelEventDispatcher.EventType.wL);
  }

  protected void gI()
  {
    b(ModelEventDispatcher.EventType.wK);
  }

  protected void gz()
  {
    gD();
  }

  abstract T i(Cursor paramCursor);

  public boolean isEmpty()
  {
    return size() == 0;
  }

  public Iterator<T> iterator()
  {
    return mItems.iterator();
  }

  protected void j(Cursor paramCursor)
  {
    HashSet localHashSet = Sets.newHashSet();
    uE = true;
    if (paramCursor != null)
    {
      paramCursor.moveToPosition(-1);
      while (paramCursor.moveToNext())
      {
        d locald = i(paramCursor);
        localHashSet.add(locald.gu());
        b(locald);
      }
    }
    int i = mItems.size() - 1;
    while (i >= 0)
    {
      paramCursor = (d)mItems.get(i);
      if ((!localHashSet.contains(paramCursor.gu())) && (!paramCursor.gv()))
        a(paramCursor);
      i -= 1;
    }
    uE = false;
    c(ModelEventDispatcher.EventType.wH);
  }

  public void k(List<T> paramList)
  {
    ic();
    paramList = paramList.iterator();
    while (paramList.hasNext())
      c((d)paramList.next());
    id();
    gI();
  }

  public boolean removeAll(Collection<T> paramCollection)
  {
    if (paramCollection == mItems)
      removeAll(new ArrayList(mItems));
    ic();
    ArrayList localArrayList = Lists.newArrayList();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      d locald = (d)paramCollection.next();
      if (d(locald))
        localArrayList.add(locald);
    }
    id();
    if (!localArrayList.isEmpty())
      gH();
    return !localArrayList.isEmpty();
  }

  public int size()
  {
    return mItems.size();
  }
}