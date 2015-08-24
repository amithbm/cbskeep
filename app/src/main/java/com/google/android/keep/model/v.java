package com.google.android.keep.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.text.TextUtils;
import com.google.android.keep.db.DbOperation;
import com.google.android.keep.p;
import com.google.android.keep.provider.i.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class v extends b<u>
{
  private HashMap<String, HashSet<Long>> yK = new HashMap();
  private HashMap<Long, HashSet<String>> yL = new HashMap();

  public v(FragmentActivity paramFragmentActivity, p paramp)
  {
    super(paramFragmentActivity, paramp, BaseModel.LoaderCreation.uA);
  }

  private void c(String paramString, long paramLong)
  {
    HashSet localHashSet = (HashSet)yK.get(paramString);
    if (localHashSet != null)
      localHashSet.remove(Long.valueOf(paramLong));
    localHashSet = (HashSet)yL.get(Long.valueOf(paramLong));
    if (localHashSet != null)
      localHashSet.remove(paramString);
  }

  public HashSet<String> G(long paramLong)
  {
    return (HashSet)yL.get(Long.valueOf(paramLong));
  }

  public void a(u paramu)
  {
    if ((paramu == null) || (mItems.contains(paramu)))
      return;
    String str = paramu.iN();
    long l = paramu.it().longValue();
    HashSet localHashSet2 = (HashSet)yK.get(str);
    HashSet localHashSet1 = localHashSet2;
    if (localHashSet2 == null)
    {
      localHashSet1 = new HashSet();
      yK.put(str, localHashSet1);
    }
    localHashSet1.add(Long.valueOf(l));
    localHashSet2 = (HashSet)yL.get(Long.valueOf(l));
    localHashSet1 = localHashSet2;
    if (localHashSet2 == null)
    {
      localHashSet1 = new HashSet();
      yL.put(Long.valueOf(l), localHashSet1);
    }
    localHashSet1.add(str);
    super.c(paramu);
  }

  public boolean b(u paramu)
  {
    if (paramu == null)
      return false;
    c(paramu.iN(), paramu.it().longValue());
    return super.d(paramu);
  }

  public u bg(int paramInt)
  {
    u localu = (u)mItems.get(paramInt);
    if (localu == null)
      return null;
    c(localu.iN(), localu.it().longValue());
    return (u)super.aK(paramInt);
  }

  public u d(long paramLong, String paramString)
  {
    if ((!yK.containsKey(paramString)) || (!yL.containsKey(Long.valueOf(paramLong))))
      return null;
    Iterator localIterator = mItems.iterator();
    while (localIterator.hasNext())
    {
      u localu = (u)localIterator.next();
      if ((paramLong == localu.it().longValue()) && (TextUtils.equals(paramString, localu.iN())))
        return localu;
    }
    return null;
  }

  public void gH()
  {
    b(ModelEventDispatcher.EventType.wZ);
  }

  public void gI()
  {
    b(ModelEventDispatcher.EventType.wY);
  }

  protected Loader<Cursor> gy()
  {
    long l = gA().getId();
    return new CursorLoader(getActivity(), i.p.CONTENT_URI, u.COLUMNS, "account_id=?", new String[] { Long.valueOf(l).toString() }, null);
  }

  protected void gz()
  {
    yL.clear();
    yK.clear();
    super.gz();
  }

  public void j(List<DbOperation> paramList)
  {
    Iterator localIterator = mItems.iterator();
    u localu;
    ContentValues localContentValues;
    while (localIterator.hasNext())
    {
      localu = (u)localIterator.next();
      if (localu.gv())
      {
        localContentValues = new ContentValues();
        localContentValues.put("label_id", localu.iN());
        localContentValues.put("tree_entity_id", localu.it());
        localContentValues.put("account_id", Long.valueOf(gA().getId()));
        paramList.add(DbOperation.cY().b(i.p.CONTENT_URI).a(localContentValues));
      }
    }
    localIterator = gG().iterator();
    while (localIterator.hasNext())
    {
      localu = (u)localIterator.next();
      localContentValues = new ContentValues();
      localContentValues.put("is_dirty", Integer.valueOf(1));
      localContentValues.put("is_deleted", Integer.valueOf(1));
      localContentValues.put("deleted_timestamp", Long.valueOf(System.currentTimeMillis()));
      paramList.add(DbOperation.cZ().b(i.p.CONTENT_URI).a("_id = " + localu.iO(), null).a(localContentValues));
    }
  }

  u t(Cursor paramCursor)
  {
    return u.s(paramCursor);
  }
}