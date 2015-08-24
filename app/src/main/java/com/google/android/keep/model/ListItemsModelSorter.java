package com.google.android.keep.model;

import android.app.Activity;
import android.util.Log;
import com.google.android.common.base.Preconditions;
import com.google.android.keep.binder.Binder;
import com.google.android.keep.util.c;
import com.google.api.client.util.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ListItemsModelSorter
{
  private static final long wk = ()Math.pow(2.0D, 20.0D);
  private final x lm;
  private final n wl;
  private final a wm;

  ListItemsModelSorter(Activity paramActivity, n paramn)
  {
    wm = new a(paramActivity);
    wl = paramn;
    lm = ((x)Binder.a(paramActivity, x.class));
  }

  private boolean a(ListItemFilter paramListItemFilter)
    throws ListItemsModelSorter.InsufficientSortOrderSpace
  {
    Long localLong = null;
    ArrayList localArrayList = Lists.newArrayList();
    boolean bool = false;
    Iterator localIterator = hP().iterator();
    while (localIterator.hasNext())
    {
      ListItem localListItem = (ListItem)localIterator.next();
      if (paramListItemFilter.g(localListItem))
        if (!a(localLong, localListItem.hu()))
        {
          localArrayList.add(localListItem);
        }
        else
        {
          bool |= a(localArrayList, localLong, localListItem.hu());
          localLong = localListItem.hu();
        }
    }
    return bool | a(localArrayList, localLong, null);
  }

  private boolean a(Long paramLong1, Long paramLong2)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramLong2 == null)
      bool1 = false;
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      }
      while (paramLong1 == null);
      bool1 = bool2;
    }
    while (paramLong1.longValue() > paramLong2.longValue());
    return false;
  }

  private boolean a(List<ListItem> paramList, Long paramLong1, Long paramLong2)
    throws ListItemsModelSorter.InsufficientSortOrderSpace
  {
    if (paramList.isEmpty())
      return false;
    long l2 = wk;
    long l1 = 0L;
    if ((paramLong1 == null) && (paramLong2 == null));
    while (true)
    {
      paramLong1 = paramList.iterator();
      while (paramLong1.hasNext())
      {
        ((ListItem)paramLong1.next()).f(Long.valueOf(l1));
        l1 -= l2;
      }
      if (paramLong1 == null)
      {
        l1 = paramLong2.longValue() + paramList.size() * l2;
      }
      else if (paramLong2 == null)
      {
        l1 = paramLong1.longValue() - l2;
      }
      else
      {
        l1 = paramLong1.longValue() - paramLong2.longValue();
        if (l1 >= 0L);
        for (boolean bool = true; ; bool = false)
        {
          Preconditions.checkArgument(bool);
          l2 = l1 / (paramList.size() + 1);
          if (l2 != 0L)
            break;
          throw new InsufficientSortOrderSpace(null);
        }
        l1 = paramLong1.longValue() - l2;
      }
    }
    paramList.clear();
    return true;
  }

  private void ae(String paramString)
  {
    c.a("ListItemsModelSorter", paramString, hP());
  }

  private void b(ListItemFilter paramListItemFilter)
  {
    long l = 0L;
    int i = hP().size() - 1;
    if (i >= 0)
    {
      ListItem localListItem = (ListItem)hP().get(i);
      if (!paramListItemFilter.g(localListItem));
      while (true)
      {
        i -= 1;
        break;
        localListItem.f(Long.valueOf(l));
        l += wk;
      }
    }
  }

  private List<ListItem> hP()
  {
    return wl.mItems;
  }

  private h hQ()
  {
    return wl.hB();
  }

  private h hR()
  {
    return wl.hA();
  }

  private void hT()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      boolean bool3;
      if (wl.hL())
      {
        bool1 = bool2;
        bool2 = a(ListItemFilter.vZ);
        bool1 = bool2;
        bool3 = a(ListItemFilter.wa);
      }
      for (bool1 = bool2 | bool3; ; bool1 = bool2)
      {
        if (bool1)
          ae("fixSortOrders");
        return;
        bool1 = bool2;
        bool2 = a(ListItemFilter.vY);
      }
    }
    catch (InsufficientSortOrderSpace localInsufficientSortOrderSpace)
    {
      while (true)
        hU();
    }
  }

  private void hU()
  {
    Log.e("ListItemsModelSorter", "Rebasing all sort orders!");
    if (wl.ei())
      b(ListItemFilter.vY);
    while (true)
    {
      ae("rebaseSortOrders");
      return;
      b(ListItemFilter.vZ);
      b(ListItemFilter.wa);
    }
  }

  private void n(ListItem paramListItem)
  {
    if ((wl.gC()) || (wl.ei()))
      return;
    if (paramListItem.isChecked())
      paramListItem.f(Long.valueOf(a(hQ())));
    while (true)
    {
      hS();
      ae("onItemChecked");
      return;
      paramListItem.f(Long.valueOf(b(hR())));
    }
  }

  public long a(h paramh)
  {
    if (paramh.isEmpty())
      return 0L;
    return paramh.gT().hu().longValue() + wk;
  }

  void a(ModelEventDispatcher.a parama, ListItem paramListItem)
  {
    if (parama.a(new ModelEventDispatcher.EventType[] { ModelEventDispatcher.EventType.wO }))
      n(paramListItem);
    do
    {
      return;
      if (parama.a(new ModelEventDispatcher.EventType[] { ModelEventDispatcher.EventType.wR }))
      {
        hU();
        return;
      }
    }
    while (!parama.a(new ModelEventDispatcher.EventType[] { ModelEventDispatcher.EventType.xC }));
    hS();
  }

  public long b(h paramh)
  {
    if (paramh.isEmpty())
      return 0L;
    return paramh.gU().hu().longValue() - wk;
  }

  void b(ListItem paramListItem1, ListItem paramListItem2, ListItem paramListItem3)
  {
    if ((paramListItem2 == null) && (paramListItem3 == null))
    {
      paramListItem1.f(Long.valueOf(0L));
      return;
    }
    long l1;
    label44: long l2;
    if (paramListItem3 != paramListItem2)
    {
      bool = true;
      Preconditions.checkArgument(bool);
      if (paramListItem2 == null)
        break label105;
      l1 = paramListItem2.hu().longValue();
      if (paramListItem3 == null)
        break label125;
      l2 = paramListItem3.hu().longValue();
      label57: if (l1 < l2)
        break label145;
    }
    label145: for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      l1 -= l2;
      if (l1 > 1L)
        break label151;
      hU();
      b(paramListItem1, paramListItem2, paramListItem3);
      return;
      bool = false;
      break;
      label105: l1 = paramListItem3.hu().longValue() + 2L * wk;
      break label44;
      label125: l2 = paramListItem2.hu().longValue() - 2L * wk;
      break label57;
    }
    label151: paramListItem1.f(Long.valueOf(l1 / 2L + l2));
    hS();
  }

  void d(ModelEventDispatcher.a parama)
  {
    if ((!parama.a(new ModelEventDispatcher.EventType[] { ModelEventDispatcher.EventType.wH })) || (lm.isActive()))
      if (!parama.a(new ModelEventDispatcher.EventType[] { ModelEventDispatcher.EventType.wG }))
        break label50;
    label50: 
    do
    {
      hS();
      do
        return;
      while (wl.gC());
    }
    while (!parama.a(new ModelEventDispatcher.EventType[] { ModelEventDispatcher.EventType.wK, ModelEventDispatcher.EventType.wL }));
    hT();
  }

  protected boolean hS()
  {
    boolean bool2 = false;
    long l = 9223372036854775807L;
    Iterator localIterator = hP().iterator();
    while (true)
    {
      boolean bool1 = bool2;
      ListItem localListItem;
      if (localIterator.hasNext())
      {
        localListItem = (ListItem)localIterator.next();
        if (localListItem.hu().longValue() > l)
          bool1 = true;
      }
      else
      {
        if (bool1)
        {
          Collections.sort(hP(), wm);
          wl.b(ModelEventDispatcher.EventType.wQ);
        }
        return bool1;
      }
      l = localListItem.hu().longValue();
    }
  }

  void hV()
  {
    Log.w("ListItemsModelSorter", "Disabling graveyard");
    long l = a(hQ());
    int i = hR().size() - 1;
    while (i >= 0)
    {
      hR().aT(i).f(Long.valueOf(l));
      l += wk;
      i -= 1;
    }
    hS();
    ae("onGraveyardDisabled");
  }

  private static class InsufficientSortOrderSpace extends Exception
  {
  }

  public static class a
    implements Comparator<ListItem>
  {
    private final TreeEntityModel me;

    public a(Activity paramActivity)
    {
      me = ((TreeEntityModel)Binder.a(paramActivity, TreeEntityModel.class));
    }

    public int a(ListItem paramListItem1, ListItem paramListItem2)
    {
      long l = paramListItem1.hu().longValue() - paramListItem2.hu().longValue();
      if (l == 0L)
        return 0;
      if (l > 0L)
        return -1;
      return 1;
    }
  }
}