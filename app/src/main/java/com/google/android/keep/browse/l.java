package com.google.android.keep.browse;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.MergeCursor;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.content.Loader.ForceLoadContentObserver;
import android.text.TextUtils;
import com.google.android.gms.reminders.model.DateTime;
import com.google.android.gms.reminders.model.Task;
import com.google.android.keep.binder.Binder;
import com.google.android.keep.model.A;
import com.google.android.keep.model.ModelEventDispatcher.EventType;
import com.google.android.keep.model.ModelEventDispatcher.a;
import com.google.android.keep.model.ModelEventDispatcher.b;
import com.google.android.keep.model.Note;
import com.google.android.keep.provider.d;
import com.google.android.keep.provider.i;
import com.google.android.keep.provider.i.f;
import com.google.android.keep.util.Config;
import com.google.android.keep.util.KeepTime;
import com.google.android.keep.util.h;
import com.google.android.keep.util.w;
import com.google.android.keep.util.w.a;
import com.google.android.keep.util.x;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class l extends CursorLoader
  implements ModelEventDispatcher.b
{
  public static o[] hl = { iw, ix };
  private static final o iw = new o("key_soon_and_nearby");
  private static final o ix = new o("key_others");
  private final long cU;
  private final A fi;
  private final Set<w.a> iy = new HashSet();
  private final ContentResolver mContentResolver;
  private final Loader<Cursor>.ForceLoadContentObserver mObserver;

  public l(Context paramContext, long paramLong)
  {
    super(paramContext);
    mContentResolver = paramContext.getContentResolver();
    cU = paramLong;
    mObserver = new Loader.ForceLoadContentObserver(this);
    fi = ((A)Binder.a(paramContext, A.class));
    fi.a(this);
  }

  private void a(List<w.a> paramList, MatrixCursor paramMatrixCursor)
  {
    if (paramList.isEmpty());
    Cursor localCursor;
    do
    {
      return;
      localCursor = e(paramList);
    }
    while (localCursor == null);
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    try
    {
      while (localCursor.moveToNext())
      {
        if (!localCursor.isNull(Note.tw))
          localHashMap1.put(localCursor.getString(Note.tw), Integer.valueOf(localCursor.getPosition()));
        localHashMap2.put(localCursor.getString(Note.tv), Integer.valueOf(localCursor.getPosition()));
      }
    }
    finally
    {
      localCursor.close();
    }
    int i = 0;
    while (true)
    {
      Integer localInteger;
      if (i < paramList.size())
      {
        w.a locala = (w.a)paramList.get(i);
        localInteger = null;
        if (!TextUtils.isEmpty(locala.iF))
          localInteger = (Integer)localHashMap1.get(locala.iF);
        else if (!TextUtils.isEmpty(locala.uK))
          localInteger = (Integer)localHashMap2.get(locala.uK);
      }
      while (localInteger != null)
      {
        localCursor.moveToPosition(localInteger.intValue());
        h.a(localCursor, paramMatrixCursor);
        break;
        localCursor.close();
        return;
      }
      i += 1;
    }
  }

  private void a(MatrixCursor[] paramArrayOfMatrixCursor)
  {
    iy.clear();
    b(paramArrayOfMatrixCursor);
    c(paramArrayOfMatrixCursor);
  }

  private void b(MatrixCursor[] paramArrayOfMatrixCursor)
  {
    List localList = cA();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    KeepTime localKeepTime = new KeepTime();
    int j = localKeepTime.jm();
    int i = 0;
    if (i < localList.size())
    {
      Object localObject = (Task)localList.get(i);
      w.a locala = w.l((Task)localList.get(i));
      if (locala == null);
      while (true)
      {
        i += 1;
        break;
        if (!iy.contains(locala))
        {
          iy.add(locala);
          localObject = x.n((Task)localObject);
          if (localObject != null)
          {
            localKeepTime.set(((DateTime)localObject).getDay().intValue(), ((DateTime)localObject).getMonth().intValue() - 1, ((DateTime)localObject).getYear().intValue());
            if (localKeepTime.jm() <= j + 1)
              localArrayList1.add(locala);
            else
              localArrayList2.add(locala);
          }
        }
      }
    }
    a(localArrayList1, paramArrayOfMatrixCursor[0]);
    a(localArrayList2, paramArrayOfMatrixCursor[1]);
  }

  private void c(MatrixCursor[] paramArrayOfMatrixCursor)
  {
    List localList = cB();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = Lists.newArrayList();
    Object localObject1 = ((LocationManager)getContext().getSystemService("location")).getLastKnownLocation("passive");
    Object localObject2 = new float[1];
    int i = 0;
    if (i < localList.size())
    {
      Object localObject3 = (Task)localList.get(i);
      float f;
      if (((Task)localObject3).getLocation() == null)
        f = 3.4028235E+38F;
      while (true)
      {
        localArrayList3.add(new a(i, f));
        i += 1;
        break;
        Double localDouble = ((Task)localObject3).getLocation().getLat();
        localObject3 = ((Task)localObject3).getLocation().getLng();
        if ((localDouble != null) && (localObject3 != null) && (localObject1 != null))
        {
          android.location.Location.distanceBetween(localDouble.doubleValue(), ((Double)localObject3).doubleValue(), ((android.location.Location)localObject1).getLatitude(), ((android.location.Location)localObject1).getLongitude(), (float[])localObject2);
          f = localObject2[0];
        }
        else
        {
          f = 3.4028235E+38F;
        }
      }
    }
    Collections.sort(localArrayList3, new Comparator()
    {
      public int a(l.a paramAnonymousa1, l.a paramAnonymousa2)
      {
        return Float.compare(l.a.a(paramAnonymousa1), l.a.a(paramAnonymousa2));
      }
    });
    int j = 0;
    int m = Config.nP();
    double d3 = Config.nO();
    double d1 = 0.0D;
    i = 0;
    if (i < localArrayList3.size())
    {
      localObject1 = (a)localArrayList3.get(i);
      localObject2 = w.l((Task)localList.get(a.b((a)localObject1)));
      int k;
      double d2;
      if (localObject2 == null)
      {
        k = j;
        d2 = d1;
      }
      while (true)
      {
        i += 1;
        d1 = d2;
        j = k;
        break;
        d2 = d1;
        k = j;
        if (!iy.contains(localObject2))
        {
          iy.add(localObject2);
          if ((a.a((a)localObject1) > d3) || ((j >= m) && (a.a((a)localObject1) > d1)))
          {
            localArrayList2.add(localObject2);
            d2 = d1;
            k = j;
          }
          else
          {
            localArrayList1.add(localObject2);
            k = j + 1;
            d2 = a.a((a)localObject1);
          }
        }
      }
    }
    a(localArrayList1, paramArrayOfMatrixCursor[0]);
    a(localArrayList2, paramArrayOfMatrixCursor[1]);
  }

  private List<Task> cA()
  {
    long l = System.currentTimeMillis();
    Object localObject = fi.jb();
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Task localTask = (Task)((Iterator)localObject).next();
      if ((localTask.getLocation() == null) && (!x.o(localTask)))
      {
        DateTime localDateTime = x.n(localTask);
        if ((localDateTime != null) && (!Boolean.TRUE.equals(localDateTime.getUnspecifiedFutureTime())) && (x.a(localDateTime) > l))
          localArrayList.add(localTask);
      }
    }
    Collections.sort(localArrayList, new Comparator()
    {
      public int a(Task paramAnonymousTask1, Task paramAnonymousTask2)
      {
        paramAnonymousTask1 = x.n(paramAnonymousTask1);
        paramAnonymousTask2 = x.n(paramAnonymousTask2);
        if ((paramAnonymousTask1 != null) && (paramAnonymousTask2 != null))
        {
          l1 = x.a(paramAnonymousTask1);
          l2 = x.a(paramAnonymousTask2);
          if (l1 >= l2);
        }
        while (paramAnonymousTask1 != null)
        {
          long l1;
          long l2;
          return -1;
          if (l1 > l2)
            return 1;
          return 0;
        }
        return 1;
      }
    });
    return localArrayList;
  }

  private List<Task> cB()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = fi.jb().iterator();
    while (localIterator.hasNext())
    {
      Task localTask = (Task)localIterator.next();
      if ((localTask.getLocation() != null) && (!x.o(localTask)))
        localArrayList.add(localTask);
    }
    return localArrayList;
  }

  private Cursor e(List<w.a> paramList)
  {
    Object localObject = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      w.a locala = (w.a)paramList.next();
      if (!TextUtils.isEmpty(locala.iF))
        ((List)localObject).add("\"" + locala.iF + "\"");
      if (!TextUtils.isEmpty(locala.uK))
        localArrayList.add("\"" + locala.uK + "\"");
    }
    paramList = null;
    if (!((List)localObject).isEmpty())
      paramList = "tree_entity.server_id IN (" + TextUtils.join(",", (Iterable)localObject) + ")";
    localObject = null;
    if (!localArrayList.isEmpty())
      localObject = "tree_entity.uuid IN (" + TextUtils.join(",", localArrayList) + ")";
    paramList = h.q(paramList, (String)localObject);
    return mContentResolver.query(i.f.c(i.f.Cm, cU), Note.COLUMNS, h.p(paramList, "is_trashed=0"), null, null);
  }

  public void a(ModelEventDispatcher.a parama)
  {
    mObserver.onChange(false);
  }

  public List<ModelEventDispatcher.EventType> bI()
  {
    return ImmutableList.of(ModelEventDispatcher.EventType.wF, ModelEventDispatcher.EventType.wI, ModelEventDispatcher.EventType.wJ);
  }

  public final Cursor loadInBackground()
  {
    int j = hl.length;
    Object localObject = new MatrixCursor[j];
    int i = 0;
    while (i < j)
    {
      localObject[i] = new MatrixCursor(Note.COLUMNS);
      i += 1;
    }
    a((MatrixCursor[])localObject);
    Bundle localBundle = new Bundle();
    i = localObject[0].getCount();
    j = localObject[1].getCount();
    if (i > 0)
    {
      localBundle.putString(iw.cC(), getContext().getString(2131231316));
      localBundle.putInt(iw.cD(), 0);
    }
    if ((j > 0) && (i > 0))
    {
      localBundle.putString(ix.cC(), getContext().getString(2131231317));
      localBundle.putInt(ix.cD(), i);
    }
    android.location.Location localLocation = ((LocationManager)getContext().getSystemService("location")).getLastKnownLocation("passive");
    if (localLocation != null)
    {
      localBundle.putDouble("latitude", localLocation.getLatitude());
      localBundle.putDouble("longitude", localLocation.getLongitude());
    }
    localBundle.putBoolean("hasDataReady", true);
    localObject[0].setNotificationUri(mContentResolver, i.AUTHORITY_URI);
    localObject = new d(new MergeCursor((Cursor[])localObject), localBundle);
    ((d)localObject).registerContentObserver(mObserver);
    return localObject;
  }

  protected void onReset()
  {
    super.onReset();
    fi.b(this);
  }

  private static final class a
  {
    private final float iA;
    private final int mPosition;

    public a(int paramInt, float paramFloat)
    {
      mPosition = paramInt;
      iA = paramFloat;
    }
  }
}