package com.google.android.keep.model;

import android.util.Log;
import com.google.android.common.base.Preconditions;
import com.google.android.gsf.GservicesValue;
import com.google.android.keep.util.Config;
import com.google.android.keep.util.r;
import com.google.api.client.util.Sets;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ModelEventDispatcher
{
  private static final String TAG = ModelEventDispatcher.class.getSimpleName();
  private final Set<EventType> wA = Sets.newHashSet();
  private ModelEventDispatcher wB;
  private int wC = 0;
  private Map<EventType, LinkedHashSet<b>> wz = new HashMap();

  private void a(b paramb, a parama)
  {
    if (((Boolean)Config.Pf.get()).booleanValue())
      Log.i(TAG, getClass().getSimpleName() + " -> " + paramb.getClass().getSimpleName() + "." + parama.ig().toString());
  }

  private boolean f(a parama)
  {
    return (parama.ig() == EventType.wF) && (parama.jdMethod_if() == this);
  }

  public ModelEventDispatcher a(ModelEventDispatcher paramModelEventDispatcher)
  {
    wB = paramModelEventDispatcher;
    return this;
  }

  public void a(b paramb)
  {
    if (paramb == null);
    do
    {
      return;
      Iterator localIterator = paramb.bI().iterator();
      while (localIterator.hasNext())
      {
        EventType localEventType = (EventType)localIterator.next();
        LinkedHashSet localLinkedHashSet = (LinkedHashSet)wz.get(localEventType);
        localObject = localLinkedHashSet;
        if (localLinkedHashSet == null)
        {
          localObject = new LinkedHashSet();
          wz.put(localEventType, localObject);
        }
        ((LinkedHashSet)localObject).add(paramb);
      }
    }
    while ((!a(EventType.wF)) || (!paramb.bI().contains(EventType.wF)));
    Object localObject = new a(this, EventType.wF);
    a(paramb, (a)localObject);
    paramb.a((a)localObject);
  }

  public boolean a(EventType paramEventType)
  {
    return wA.contains(paramEventType);
  }

  public void b(EventType paramEventType)
  {
    c(new a(this, paramEventType));
  }

  public void b(b paramb)
  {
    if (paramb == null);
    while (true)
    {
      return;
      Iterator localIterator = paramb.bI().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (EventType)localIterator.next();
        localObject = (LinkedHashSet)wz.get(localObject);
        if (localObject != null)
          ((LinkedHashSet)localObject).remove(paramb);
      }
    }
  }

  public void c(EventType paramEventType)
  {
    if (!a(EventType.wF))
    {
      b(EventType.wF);
      return;
    }
    b(paramEventType);
  }

  public void c(a parama)
  {
    if (ie());
    do
    {
      do
      {
        return;
        if ((isInitialized()) || (f(parama)))
          break;
      }
      while (!((Boolean)Config.Pf.get()).booleanValue());
      r.c(TAG, "Not firing on change, not initialized yet. " + parama.jdMethod_if().getClass().getSimpleName(), new Object[0]);
      return;
      Object localObject = parama.ig();
      wA.add(localObject);
      if (wz.get(localObject) != null)
      {
        localObject = new LinkedHashSet((Collection)wz.get(localObject)).iterator();
        while (((Iterator)localObject).hasNext())
        {
          b localb = (b)((Iterator)localObject).next();
          a(localb, parama);
          localb.a(parama);
        }
      }
    }
    while (wB == null);
    wB.c(parama);
  }

  public void ib()
  {
    wA.clear();
  }

  public void ic()
  {
    wC += 1;
  }

  public void id()
  {
    if (wC > 0);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      wC -= 1;
      return;
    }
  }

  public boolean ie()
  {
    return wC > 0;
  }

  public boolean isInitialized()
  {
    return a(EventType.wF);
  }

  public static enum EventType
  {
  }

  public static class a
  {
    private final Object wD;
    private final ModelEventDispatcher.EventType wE;

    public a(Object paramObject, ModelEventDispatcher.EventType paramEventType)
    {
      if (paramObject != null);
      for (boolean bool = true; ; bool = false)
      {
        Preconditions.checkArgument(bool);
        wD = paramObject;
        wE = paramEventType;
        return;
      }
    }

    public boolean a(ModelEventDispatcher.EventType[] paramArrayOfEventType)
    {
      int j = paramArrayOfEventType.length;
      int i = 0;
      while (i < j)
      {
        if (paramArrayOfEventType[i] == wE)
          return true;
        i += 1;
      }
      return false;
    }

    public Object jdMethod_if()
    {
      return wD;
    }

    public ModelEventDispatcher.EventType ig()
    {
      return wE;
    }

    public String toString()
    {
      return jdMethod_if().getClass().getSimpleName() + "(" + wE.toString() + ")";
    }
  }

  public static abstract interface b
  {
    public abstract void a(ModelEventDispatcher.a parama);

    public abstract List<ModelEventDispatcher.EventType> bI();
  }
}