package com.google.android.gms.internal;

import android.database.CursorWindow;
import java.util.Map.Entry;

public class zzna extends zzmx<Map.Entry<String, Object>>
{
  public static final zzna zzaAo = new zzna();

  private zzna()
  {
    super(zzmw.zzaAl);
  }

  protected boolean zza(CursorWindow paramCursorWindow, int paramInt, Map.Entry<String, Object> paramEntry)
  {
    boolean bool = zzmy.zza(paramCursorWindow, paramInt, paramEntry.getValue(), true);
    return paramCursorWindow.putString((String)paramEntry.getKey(), paramInt, 3) | bool;
  }
}