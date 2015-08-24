package com.google.android.keep.binder;

import android.os.Bundle;
import com.google.android.keep.k;
import com.google.android.keep.m;
import com.google.android.keep.p.a;
import com.google.android.keep.r;
import com.google.android.keep.t;

public class a extends t
  implements b, k
{
  private final p.a dV = new p.a()
  {
    public void a(r paramAnonymousr)
    {
      if ((paramAnonymousr instanceof k))
        ((k)paramAnonymousr).aE();
    }
  };
  protected final Binder dm = new Binder();

  protected void a(Bundle paramBundle)
  {
  }

  public void aE()
  {
    sc.b(dV);
  }

  public Binder aw()
  {
    return dm;
  }

  protected void onCreate(Bundle paramBundle)
  {
    Binder localBinder = Binder.g(getApplicationContext());
    dm.f(this);
    dm.a(localBinder);
    a(paramBundle);
    dm.aC();
    super.onCreate(paramBundle);
  }
}