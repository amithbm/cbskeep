package com.google.android.keep.model;

import android.database.Cursor;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.Loader;
import com.google.android.keep.db.DbOperation;
import com.google.android.keep.p;
import com.google.android.keep.provider.i.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class a extends b<Alert>
{
  public a(FragmentActivity paramFragmentActivity, p paramp)
  {
    super(paramFragmentActivity, paramp, BaseModel.LoaderCreation.uA);
  }

  protected Loader<Cursor> gy()
  {
    return Alert.q(getActivity());
  }

  Alert h(Cursor paramCursor)
  {
    return Alert.a(paramCursor, false);
  }

  public void j(List<DbOperation> paramList)
  {
    Iterator localIterator = mItems.iterator();
    Alert localAlert;
    while (localIterator.hasNext())
    {
      localAlert = (Alert)localIterator.next();
      if (localAlert.gw())
        paramList.add(localAlert.gx());
    }
    localIterator = gG().iterator();
    while (localIterator.hasNext())
    {
      localAlert = (Alert)localIterator.next();
      paramList.add(DbOperation.da().b(i.c.CONTENT_URI).a("_id = " + localAlert.getId(), null));
    }
  }
}