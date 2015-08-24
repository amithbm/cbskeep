package com.google.android.keep;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import java.util.List;

public class m extends p
{
  private p.a rH;
  private p.a rI;
  private p.a rJ;

  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    int i = 0;
    while (i < rS.size())
    {
      r localr = (r)rS.get(i);
      if (((localr instanceof l.a)) && (((l.a)localr).dispatchKeyEvent(paramKeyEvent)))
        return true;
      i += 1;
    }
    return false;
  }

  public void fJ()
  {
    int i = 0;
    while (i < rS.size())
    {
      r localr = (r)rS.get(i);
      if ((localr instanceof l.c))
        ((l.c)localr).fJ();
      i += 1;
    }
  }

  public void fK()
  {
    int i = 0;
    while (i < rS.size())
    {
      r localr = (r)rS.get(i);
      if ((localr instanceof l.d))
        ((l.d)localr).fK();
      i += 1;
    }
  }

  public void finish()
  {
    int i = 0;
    while (i < rS.size())
    {
      r localr = (r)rS.get(i);
      if ((localr instanceof l.b))
        ((l.b)localr).finish();
      i += 1;
    }
  }

  public boolean onBackPressed()
  {
    int i = 0;
    while (i < rS.size())
    {
      r localr = (r)rS.get(i);
      if (((localr instanceof l.e)) && (((l.e)localr).onBackPressed()))
        return true;
      i += 1;
    }
    return false;
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    int i = 0;
    while (i < rS.size())
    {
      r localr = (r)rS.get(i);
      if (((localr instanceof l.f)) && (((l.f)localr).onCreateOptionsMenu(paramMenu)))
        return true;
      i += 1;
    }
    return false;
  }

  public void onDestroy()
  {
    c(rI);
    c(rH);
    super.onDestroy();
  }

  public void onNewIntent(Intent paramIntent)
  {
    int i = 0;
    while (i < rS.size())
    {
      r localr = (r)rS.get(i);
      if ((localr instanceof l.g))
        ((l.g)localr).onNewIntent(paramIntent);
      i += 1;
    }
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    int i = 0;
    while (i < rS.size())
    {
      r localr = (r)rS.get(i);
      if (((localr instanceof l.h)) && (((l.h)localr).onOptionsItemSelected(paramMenuItem)))
        return true;
      i += 1;
    }
    return false;
  }

  public void onPause()
  {
    c(rJ);
    super.onPause();
  }

  public void onPostCreate(final Bundle paramBundle)
  {
    rH = a(new p.a()
    {
      public void a(r paramAnonymousr)
      {
        if ((paramAnonymousr instanceof l.i))
        {
          Bundle localBundle = a(paramAnonymousr, paramBundle);
          ((l.i)paramAnonymousr).onPostCreate(localBundle);
        }
      }
    });
  }

  public void onPostResume()
  {
    rJ = a(new p.a()
    {
      public void a(r paramAnonymousr)
      {
        if ((paramAnonymousr instanceof l.j))
          ((l.j)paramAnonymousr).onPostResume();
      }
    });
  }

  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    int i = 0;
    while (i < rS.size())
    {
      r localr = (r)rS.get(i);
      if (((localr instanceof l.k)) && (((l.k)localr).onPrepareOptionsMenu(paramMenu)))
        return true;
      i += 1;
    }
    return false;
  }

  public void onRestoreInstanceState(final Bundle paramBundle)
  {
    rI = a(new p.a()
    {
      public void a(r paramAnonymousr)
      {
        if ((paramAnonymousr instanceof l.l))
        {
          Bundle localBundle = a(paramAnonymousr, paramBundle);
          ((l.l)paramAnonymousr).onRestoreInstanceState(localBundle);
        }
      }
    });
  }

  public void onUserLeaveHint()
  {
    int i = 0;
    while (i < rS.size())
    {
      r localr = (r)rS.get(i);
      if ((localr instanceof l.m))
        ((l.m)localr).onUserLeaveHint();
      i += 1;
    }
  }

  public void onWindowFocusChanged(boolean paramBoolean)
  {
    int i = 0;
    while (i < rS.size())
    {
      r localr = (r)rS.get(i);
      if ((localr instanceof l.n))
        ((l.n)localr).onWindowFocusChanged(paramBoolean);
      i += 1;
    }
  }

  public void startActivity(Intent paramIntent)
  {
    int i = 0;
    while (i < rS.size())
    {
      r localr = (r)rS.get(i);
      if ((localr instanceof l.o))
        ((l.o)localr).startActivity(paramIntent);
      i += 1;
    }
  }
}