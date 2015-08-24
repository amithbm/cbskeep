package com.google.android.keep.model;

import com.google.api.client.util.Lists;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class h
  implements ModelEventDispatcher.b, Collection<ListItem>
{
  private static final List<ModelEventDispatcher.EventType> fD = ImmutableList.of(ModelEventDispatcher.EventType.wF, ModelEventDispatcher.EventType.wK, ModelEventDispatcher.EventType.wL, ModelEventDispatcher.EventType.wO, ModelEventDispatcher.EventType.wQ, ModelEventDispatcher.EventType.wP, ModelEventDispatcher.EventType.wH);
  private final ListItemFilter vl;
  private ArrayList<ListItem> vm = null;
  private final n vn;

  public h(n paramn, ListItemFilter paramListItemFilter)
  {
    vn = paramn;
    vn.a(this);
    vl = paramListItemFilter;
  }

  private ArrayList<ListItem> gS()
  {
    if (vm == null)
    {
      vm = Lists.newArrayList();
      Iterator localIterator = vn.iterator();
      while (localIterator.hasNext())
      {
        ListItem localListItem = (ListItem)localIterator.next();
        if (vl.g(localListItem))
          vm.add(localListItem);
      }
    }
    return vm;
  }

  public void a(ModelEventDispatcher.a parama)
  {
    invalidate();
  }

  public ListItem aT(int paramInt)
  {
    return (ListItem)gS().get(paramInt);
  }

  public boolean addAll(Collection<? extends ListItem> paramCollection)
  {
    return gS().addAll(paramCollection);
  }

  public List<ModelEventDispatcher.EventType> bI()
  {
    return fD;
  }

  public void clear()
  {
    gS().clear();
  }

  public boolean contains(Object paramObject)
  {
    return gS().contains(paramObject);
  }

  public boolean containsAll(Collection<?> paramCollection)
  {
    return gS().containsAll(paramCollection);
  }

  public boolean d(ListItem paramListItem)
  {
    return gS().add(paramListItem);
  }

  public ListItem gT()
  {
    if (gS().isEmpty())
      return null;
    return (ListItem)gS().get(0);
  }

  public ListItem gU()
  {
    if (gS().isEmpty())
      return null;
    return (ListItem)gS().get(gS().size() - 1);
  }

  public void invalidate()
  {
    vm = null;
  }

  public boolean isEmpty()
  {
    return gS().isEmpty();
  }

  public Iterator<ListItem> iterator()
  {
    return gS().iterator();
  }

  public boolean remove(Object paramObject)
  {
    return gS().remove(paramObject);
  }

  public boolean removeAll(Collection<?> paramCollection)
  {
    return gS().removeAll(paramCollection);
  }

  public boolean retainAll(Collection<?> paramCollection)
  {
    return gS().retainAll(paramCollection);
  }

  public int size()
  {
    return gS().size();
  }

  public Object[] toArray()
  {
    return gS().toArray();
  }

  public <T> T[] toArray(T[] paramArrayOfT)
  {
    return gS().toArray(paramArrayOfT);
  }
}