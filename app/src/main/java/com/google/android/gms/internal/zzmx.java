package com.google.android.gms.internal;

import android.database.CursorWindow;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class zzmx<T>
{
  private final int numColumns;
  private final String[] zzaAm;

  protected zzmx(String[] paramArrayOfString)
  {
    zzaAm = paramArrayOfString;
    numColumns = paramArrayOfString.length;
  }

  private final DataHolder zza(CursorWindow[] paramArrayOfCursorWindow)
  {
    return new DataHolder(zzaAm, paramArrayOfCursorWindow, 0, null);
  }

  private final void zza(List<CursorWindow> paramList, T paramT, int paramInt)
  {
    int i = paramList.size();
    CursorWindow localCursorWindow1;
    if (i == 0)
    {
      localCursorWindow1 = zzhO(paramInt);
      paramList.add(localCursorWindow1);
    }
    CursorWindow localCursorWindow2;
    while (true)
    {
      localCursorWindow2 = localCursorWindow1;
      if (localCursorWindow1.allocRow())
        break;
      localCursorWindow1 = zzhO(paramInt);
      paramList.add(localCursorWindow1);
      localCursorWindow2 = localCursorWindow1;
      if (localCursorWindow1.allocRow())
        break;
      throw new IllegalStateException("Cannot allocate window space.");
      localCursorWindow1 = (CursorWindow)paramList.get(i - 1);
    }
    if (zza(localCursorWindow2, paramInt, paramT));
    do
    {
      return;
      localCursorWindow2.freeLastRow();
      localCursorWindow1 = zzhO(paramInt);
      paramList.add(localCursorWindow1);
      if (!localCursorWindow1.allocRow())
        throw new IllegalStateException("Cannot allocate window space.");
    }
    while (zza(localCursorWindow1, paramInt, paramT));
    throw new IllegalStateException("Single row exceeds window size: " + paramInt);
  }

  private final CursorWindow[] zzc(Iterable<? extends T> paramIterable)
  {
    int i = 0;
    if (!paramIterable.iterator().hasNext())
      return new CursorWindow[0];
    Object localObject = new ArrayList();
    try
    {
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext())
      {
        zza((List)localObject, paramIterable.next(), i);
        i += 1;
      }
    }
    catch (RuntimeException paramIterable)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
        ((CursorWindow)((Iterator)localObject).next()).close();
      throw paramIterable;
    }
    return (CursorWindow[])((List)localObject).toArray(new CursorWindow[((List)localObject).size()]);
  }

  private final CursorWindow zzhO(int paramInt)
  {
    CursorWindow localCursorWindow = new CursorWindow(false);
    localCursorWindow.setNumColumns(numColumns);
    localCursorWindow.setStartPosition(paramInt);
    return localCursorWindow;
  }

  public final DataHolder zzB(T paramT)
  {
    CursorWindow localCursorWindow = zzhO(0);
    try
    {
      if (!localCursorWindow.allocRow())
        throw new IllegalStateException("Cannot allocate window space.");
    }
    catch (RuntimeException paramT)
    {
      localCursorWindow.close();
      throw paramT;
    }
    if (!zza(localCursorWindow, 0, paramT))
      throw new IllegalStateException("Single row exceeds window size.");
    paramT = zza(new CursorWindow[] { localCursorWindow });
    return paramT;
  }

  protected abstract boolean zza(CursorWindow paramCursorWindow, int paramInt, T paramT);

  public final DataHolder zzb(Iterable<? extends T> paramIterable)
  {
    return zza(zzc(paramIterable));
  }
}