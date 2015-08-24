package com.google.android.keep.task;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import com.google.android.keep.provider.i.v;

public class d
{
  private static abstract class a extends j
  {
    private final TaskHelper.a<Long> GC;
    private final long uy;

    a(Context paramContext, Uri paramUri, long paramLong, TaskHelper.a<Long> parama)
    {
      super(paramUri, paramLong);
      uy = paramLong;
      GC = parama;
    }

    protected void a(Void paramVoid)
    {
      ad(uy);
    }

    protected void ad(long paramLong)
    {
      if (GC == null)
        return;
      if (paramLong == -1L)
      {
        GC.a(TaskHelper.ErrorCode.GJ);
        return;
      }
      GC.a(Long.valueOf(paramLong));
    }
  }

  static class b extends d.a
  {
    public b(Context paramContext, long paramLong, TaskHelper.a<Long> parama)
    {
      super(i.v.CH, paramLong, parama);
    }

    protected void a(Void paramVoid)
    {
      ad(kp.getAsLong("_id").longValue());
    }
  }

  static class c extends d.a
  {
    c(Context paramContext, long paramLong, TaskHelper.a<Long> parama)
    {
      super(i.v.CF, paramLong, parama);
    }
  }

  static class d extends d.a
  {
    d(Context paramContext, long paramLong, TaskHelper.a<Long> parama)
    {
      super(i.v.CG, paramLong, parama);
    }
  }
}