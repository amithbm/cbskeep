package com.google.android.keep;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import java.util.List;

public class o extends p
{
  private p.a rM;
  private p.a rN;
  private p.a rO;
  private p.a rP;

  public void I(boolean paramBoolean)
  {
    int i = 0;
    while (i < rS.size())
    {
      r localr = (r)rS.get(i);
      if ((localr instanceof n.e))
        ((n.e)localr).I(paramBoolean);
      i += 1;
    }
  }

  public void i(final Bundle paramBundle)
  {
    rP = a(new p.a()
    {
      public void a(r paramAnonymousr)
      {
        if ((paramAnonymousr instanceof n.d))
        {
          Bundle localBundle = a(paramAnonymousr, paramBundle);
          ((n.d)paramAnonymousr).i(localBundle);
        }
      }
    });
  }

  public void onActivityCreated(final Bundle paramBundle)
  {
    rN = a(new p.a()
    {
      public void a(r paramAnonymousr)
      {
        if ((paramAnonymousr instanceof n.a))
        {
          Bundle localBundle = a(paramAnonymousr, paramBundle);
          ((n.a)paramAnonymousr).onActivityCreated(localBundle);
        }
      }
    });
  }

  public void onAttach(final Activity paramActivity)
  {
    rM = a(new p.a()
    {
      public void a(r paramAnonymousr)
      {
        if ((paramAnonymousr instanceof n.b))
          ((n.b)paramAnonymousr).onAttach(paramActivity);
      }
    });
  }

  public void onDestroy()
  {
    super.onDestroy();
    c(rN);
    c(rP);
  }

  public void onDestroyView()
  {
    c(rO);
    int i = 0;
    while (i < rS.size())
    {
      r localr = (r)rS.get(i);
      if ((localr instanceof n.c))
        ((n.c)localr).onDestroyView();
      i += 1;
    }
  }

  public void onDetach()
  {
    c(rM);
  }

  public void onViewCreated(final View paramView, final Bundle paramBundle)
  {
    rO = a(new p.a()
    {
      public void a(r paramAnonymousr)
      {
        if ((paramAnonymousr instanceof n.f))
        {
          Bundle localBundle = a(paramAnonymousr, paramBundle);
          ((n.f)paramAnonymousr).onViewCreated(paramView, localBundle);
        }
      }
    });
  }
}