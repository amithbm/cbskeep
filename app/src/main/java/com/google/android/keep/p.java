package com.google.android.keep;

import android.content.Intent;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class p
{
  private static final Bundle rV = new Bundle();
  List<r> rS = new ArrayList();
  List<a> rT = new ArrayList();
  private HashSet<String> rU = new HashSet();
  private a rW;
  private a rX;
  private a rY;
  private a rZ;

  private String d(r paramr)
  {
    String str = null;
    if ((paramr instanceof q.g))
    {
      if ((paramr instanceof s))
        str = ((s)paramr).fL();
    }
    else
      return str;
    return paramr.getClass().getName();
  }

  public Bundle a(r paramr, Bundle paramBundle)
  {
    Bundle localBundle = null;
    if (paramBundle != null)
    {
      paramr = d(paramr);
      if (paramr != null)
        localBundle = paramBundle.getBundle(paramr);
    }
    else
    {
      return localBundle;
    }
    return rV;
  }

  public a a(a parama)
  {
    int i = 0;
    while (i < rS.size())
    {
      parama.a((r)rS.get(i));
      i += 1;
    }
    rT.add(parama);
    return parama;
  }

  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
    while (i < rS.size())
    {
      r localr = (r)rS.get(i);
      if ((localr instanceof q.d))
        ((q.d)localr).a(paramInt1, paramInt2, paramIntent);
      i += 1;
    }
  }

  public <T extends r> T b(T paramT)
  {
    String str = d(paramT);
    if (str != null)
    {
      if (rU.contains(str))
        throw new IllegalStateException(String.format("Duplicate observer tag: '%s'. Implement LifecycleObserverTag to provide unique tags.", new Object[] { str }));
      rU.add(str);
    }
    rS.add(paramT);
    int i = 0;
    while (i < rT.size())
    {
      ((a)rT.get(i)).a(paramT);
      i += 1;
    }
    return paramT;
  }

  public void b(a parama)
  {
    int i = 0;
    while (i < rS.size())
    {
      parama.a((r)rS.get(i));
      i += 1;
    }
  }

  public void c(a parama)
  {
    rT.remove(parama);
  }

  public <T extends r> boolean c(T paramT)
  {
    return rS.remove(paramT);
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
    while (i < rS.size())
    {
      r localr = (r)rS.get(i);
      if ((localr instanceof q.a))
        ((q.a)localr).onActivityResult(paramInt1, paramInt2, paramIntent);
      i += 1;
    }
  }

  public void onCreate(final Bundle paramBundle)
  {
    rW = a(new a()
    {
      public void a(r paramAnonymousr)
      {
        if ((paramAnonymousr instanceof q.b))
        {
          Bundle localBundle = a(paramAnonymousr, paramBundle);
          ((q.b)paramAnonymousr).onCreate(localBundle);
        }
      }
    });
  }

  public void onDestroy()
  {
    c(rZ);
    c(rW);
    int i = 0;
    while (i < rS.size())
    {
      r localr = (r)rS.get(i);
      if ((localr instanceof q.c))
        ((q.c)localr).onDestroy();
      i += 1;
    }
  }

  public void onPause()
  {
    c(rY);
    int i = 0;
    while (i < rS.size())
    {
      r localr = (r)rS.get(i);
      if ((localr instanceof q.e))
        ((q.e)localr).onPause();
      i += 1;
    }
  }

  public void onResume()
  {
    rY = a(new a()
    {
      public void a(r paramAnonymousr)
      {
        if ((paramAnonymousr instanceof q.f))
          ((q.f)paramAnonymousr).onResume();
      }
    });
  }

  public void onSaveInstanceState(final Bundle paramBundle)
  {
    rZ = a(new a()
    {
      public void a(r paramAnonymousr)
      {
        if ((paramAnonymousr instanceof q.g))
        {
          Bundle localBundle = new Bundle();
          ((q.g)paramAnonymousr).onSaveInstanceState(localBundle);
          paramAnonymousr = p.a(p.this, paramAnonymousr);
          paramBundle.putBundle(paramAnonymousr, localBundle);
        }
      }
    });
  }

  public void onStart()
  {
    rX = a(new a()
    {
      public void a(r paramAnonymousr)
      {
        if ((paramAnonymousr instanceof q.h))
          ((q.h)paramAnonymousr).onStart();
      }
    });
  }

  public void onStop()
  {
    c(rX);
    int i = 0;
    while (i < rS.size())
    {
      r localr = (r)rS.get(i);
      if ((localr instanceof q.i))
        ((q.i)localr).onStop();
      i += 1;
    }
  }

  public static abstract interface a
  {
    public abstract void a(r paramr);
  }
}