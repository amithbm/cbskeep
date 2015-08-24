package com.google.android.keep.syncadapter;

import android.content.Context;
import com.google.android.keep.util.A;
import com.google.android.keep.util.r;

public class g
{
  private static int Gs = lq();
  private static a Gt;

  public static void E(Context paramContext)
  {
    int j = A.Y(paramContext);
    int i = j;
    if (j != 0)
    {
      i = j;
      if (j != -1)
        i = lq();
    }
    Gs = i;
  }

  public static void a(Context paramContext, boolean paramBoolean)
  {
    int i = 0;
    r.a("KeepSync", "Updating last sync status. Successful? " + paramBoolean, new Object[0]);
    if (paramBoolean);
    while (true)
    {
      Gs = i;
      if (Gt != null)
        Gt.bS();
      A.d(paramContext, Gs);
      return;
      i = -1;
    }
  }

  public static void a(a parama)
  {
    Gt = parama;
  }

  public static int lq()
  {
    return 0;
  }

  public static abstract interface a
  {
    public abstract void bS();
  }
}