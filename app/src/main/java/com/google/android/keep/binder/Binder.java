package com.google.android.keep.binder;

import android.content.Context;
import android.content.ContextWrapper;
import android.util.Log;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Binder
{
  private static final Object dQ = new Object();
  private Binder dR;
  private final Map<Object, Object> dS = new HashMap();
  private final Map<Object, List<?>> dT = new HashMap();
  private boolean dU;
  private Context mContext;
  private String mTag;

  public Binder()
  {
  }

  public Binder(Context paramContext)
  {
    this(paramContext, null);
  }

  public Binder(Context paramContext, Binder paramBinder)
  {
    mContext = paramContext;
    dR = paramBinder;
    mTag = paramContext.getClass().getName();
  }

  public static <T> T a(Context paramContext, Class<T> paramClass)
  {
    return g(paramContext).a(paramClass);
  }

  private void a(Object paramObject1, Object paramObject2)
  {
    try
    {
      aD();
      if (dT.containsKey(paramObject1))
        throw new IllegalStateException("Attempt to single-bind multibound object.");
    }
    finally
    {
    }
    Object localObject = dS.get(paramObject1);
    if (localObject != null)
    {
      if (localObject == dQ)
        throw new LateBindingException("Bind call too late - someone already tried to get: " + paramObject1);
      throw new DuplicateBindingException("Duplicate binding: " + paramObject1);
    }
    dS.put(paramObject1, paramObject2);
  }

  private void aD()
  {
    if (dU)
      throw new LateBindingException("This binder is sealed for modification");
  }

  private static Binder b(Object paramObject)
  {
    Binder localBinder1;
    if ((paramObject instanceof b))
    {
      Binder localBinder2 = ((b)paramObject).aw();
      localBinder1 = localBinder2;
      if (localBinder2 == null)
        throw new IllegalStateException("BinderContext must not return null Binder: " + paramObject);
    }
    else
    {
      localBinder1 = null;
    }
    return localBinder1;
  }

  private String b(Class paramClass)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unbound type: ").append(paramClass.getName()).append("\n").append("Searched binders:\n");
    paramClass = this;
    while (true)
    {
      localStringBuilder.append(paramClass.mTag);
      paramClass = paramClass.dR;
      if (paramClass == null)
        return localStringBuilder.toString();
      localStringBuilder.append(" ->\n");
    }
  }

  private <T> T d(Class<T> paramClass)
  {
    try
    {
      if (mContext == null)
        throw new IllegalStateException("Binder not initialized yet.");
    }
    finally
    {
    }
    Object localObject = dS.get(paramClass);
    if (localObject != null)
    {
      paramClass = dQ;
      if (localObject != paramClass)
        paramClass = localObject;
    }
    while (true)
    {
      return paramClass;
      paramClass = null;
      continue;
      localObject = dS.get(paramClass);
      if (localObject == null)
      {
        if (dT.containsKey(paramClass))
          throw new IllegalStateException("get() called for multibound object.");
        dS.put(paramClass, dQ);
      }
      paramClass = localObject;
    }
  }

  public static Binder g(Context paramContext)
  {
    Context localContext2 = paramContext.getApplicationContext();
    int i = 0;
    Context localContext1 = paramContext;
    paramContext = b(localContext1);
    if (paramContext != null)
      return paramContext;
    if (localContext1 == localContext2);
    for (int j = 1; ; j = 0)
    {
      i |= j;
      if (!(localContext1 instanceof ContextWrapper))
        break;
      localContext1 = ((ContextWrapper)localContext1).getBaseContext();
      paramContext = localContext1;
      if (localContext1 != null)
        break label76;
      throw new IllegalStateException("Invalid ContextWrapper -- If this is a Robolectric test, have you called ActivityController.create()?");
    }
    if (i == 0);
    for (paramContext = localContext2; ; paramContext = null)
    {
      label76: localContext1 = paramContext;
      if (paramContext != null)
        break;
      return null;
    }
  }

  public <T> Binder a(Class<T> paramClass, T paramT)
  {
    a(paramClass, paramT);
    return this;
  }

  public <T> T a(Class<T> paramClass)
  {
    Object localObject = c(paramClass);
    if (localObject != null)
      return localObject;
    paramClass = b(paramClass);
    localObject = new IllegalStateException(paramClass);
    Log.e("KeepBinder", paramClass, (Throwable)localObject);
    throw ((Throwable)localObject);
  }

  public void a(Binder paramBinder)
  {
    dR = paramBinder;
  }

  public void aC()
  {
    dU = true;
  }

  public <T> T c(Class<T> paramClass)
  {
    Object localObject1 = this;
    Object localObject2;
    do
    {
      localObject2 = ((Binder)localObject1).d(paramClass);
      if (localObject2 != null)
        return localObject2;
      localObject2 = ((Binder)localObject1).dR;
      localObject1 = localObject2;
    }
    while (localObject2 != null);
    return null;
  }

  public void f(Context paramContext)
  {
    mContext = paramContext;
    if (mTag == null)
      mTag = paramContext.getClass().getName();
  }

  static class DuplicateBindingException extends RuntimeException
  {
    public DuplicateBindingException(String paramString)
    {
      super();
    }
  }

  static class LateBindingException extends RuntimeException
  {
    public LateBindingException(String paramString)
    {
      super();
    }
  }
}