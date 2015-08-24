package com.google.android.keep.model;

import android.database.Cursor;
import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.Loader;
import android.text.TextUtils;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.keep.db.DbOperation;
import com.google.android.keep.db.a;
import com.google.android.keep.p;
import com.google.android.keep.provider.i.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class C extends b<Sharee>
{
  private int zA = 0;

  public C(FragmentActivity paramFragmentActivity, p paramp)
  {
    super(paramFragmentActivity, paramp, BaseModel.LoaderCreation.uB);
  }

  private void o(final List<Sharee> paramList)
  {
    if (paramList.size() == 0)
      return;
    new AsyncTask()
    {
      protected Void doInBackground(Void[] paramAnonymousArrayOfVoid)
      {
        paramAnonymousArrayOfVoid = com.google.android.keep.util.j.M(getActivity()).build();
        paramAnonymousArrayOfVoid.blockingConnect(5L, TimeUnit.SECONDS);
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          Sharee localSharee = (Sharee)localIterator.next();
          localSharee.ap(com.google.android.keep.util.j.e(paramAnonymousArrayOfVoid, localSharee.getEmail()));
        }
        paramAnonymousArrayOfVoid.disconnect();
        gP().a(C.this);
        return null;
      }
    }
    .execute(new Void[0]);
  }

  public Loader<Cursor> gy()
  {
    return Sharee.a(getActivity(), dP());
  }

  public boolean ip()
  {
    return jl() > 0;
  }

  protected void j(Cursor paramCursor)
  {
    boolean bool = a(ModelEventDispatcher.EventType.wF);
    super.j(paramCursor);
    int i = jl();
    if (bool)
    {
      if ((zA != 0) || (i <= 0))
        break label46;
      b(ModelEventDispatcher.EventType.xq);
    }
    while (true)
    {
      zA = i;
      return;
      label46: if ((zA > 0) && (i == 0))
        b(ModelEventDispatcher.EventType.xr);
    }
  }

  public void j(List<DbOperation> paramList)
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = mItems.iterator();
    if (((Iterator)localObject2).hasNext())
    {
      Sharee localSharee = (Sharee)((Iterator)localObject2).next();
      if (localSharee.gv())
      {
        paramList.add(DbOperation.cY().b(i.t.CONTENT_URI).a(localSharee.jh()));
        if (TextUtils.isEmpty(localSharee.getGaiaId()))
          ((List)localObject1).add(localSharee);
      }
      while (true)
      {
        localSharee.gR();
        break;
        if (localSharee.gw())
          paramList.add(DbOperation.cZ().a(i.t.CONTENT_URI, localSharee.jf()).a(localSharee.gQ()));
      }
    }
    o((List)localObject1);
    localObject1 = gG().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Sharee)((Iterator)localObject1).next();
      paramList.add(DbOperation.cZ().b(i.t.CONTENT_URI).a("_id = " + ((Sharee)localObject2).jf(), null).a("is_deleted", Integer.valueOf(1)));
    }
  }

  public List<Sharee> ji()
  {
    Sharee localSharee = jk();
    ArrayList localArrayList = new ArrayList(mItems);
    if (localSharee != null)
    {
      localArrayList.remove(localSharee);
      localArrayList.add(0, localSharee);
    }
    return localArrayList;
  }

  public List<Sharee> jj()
  {
    ArrayList localArrayList = new ArrayList(mItems);
    j localj = gA();
    if (localj == null);
    Sharee localSharee;
    do
    {
      Iterator localIterator;
      while (!localIterator.hasNext())
      {
        return localArrayList;
        localIterator = localArrayList.iterator();
      }
      localSharee = (Sharee)localIterator.next();
    }
    while (!localj.getName().equalsIgnoreCase(localSharee.getEmail()));
    localArrayList.remove(localSharee);
    return localArrayList;
  }

  public Sharee jk()
  {
    if (mItems != null)
    {
      localObject = mItems.iterator();
      while (((Iterator)localObject).hasNext())
      {
        Sharee localSharee = (Sharee)((Iterator)localObject).next();
        if (localSharee.iD())
          return localSharee;
      }
    }
    Object localObject = gA();
    if (localObject != null)
      return new Sharee(dP(), ((j)localObject).getName(), Sharee.Role.zy);
    return null;
  }

  public int jl()
  {
    List localList = jj();
    if (localList != null)
      return localList.size();
    return 0;
  }

  Sharee v(Cursor paramCursor)
  {
    return Sharee.u(paramCursor);
  }
}