package com.google.android.keep.model;

import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.text.TextUtils;
import com.google.android.keep.db.DbOperation;
import com.google.android.keep.db.a;
import com.google.android.keep.p;
import com.google.android.keep.provider.i.k;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class k extends b<Label>
{
  public k(FragmentActivity paramFragmentActivity, p paramp)
  {
    super(paramFragmentActivity, paramp, BaseModel.LoaderCreation.uA);
  }

  public Label P(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return null;
    Iterator localIterator = mItems.iterator();
    while (localIterator.hasNext())
    {
      Label localLabel = (Label)localIterator.next();
      if (localLabel.getName().equalsIgnoreCase(paramString))
        return localLabel;
    }
    return null;
  }

  public Label Q(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return null;
    Iterator localIterator = mItems.iterator();
    while (localIterator.hasNext())
    {
      Label localLabel = (Label)localIterator.next();
      if (TextUtils.equals(localLabel.gu(), paramString))
        return localLabel;
    }
    return null;
  }

  public Label R(String paramString)
  {
    if (P(paramString) == null)
    {
      paramString = new Label(paramString);
      c(paramString);
      return paramString;
    }
    return null;
  }

  public ArrayList<Label> a(HashSet<String> paramHashSet)
  {
    ArrayList localArrayList = Lists.newArrayList();
    if (paramHashSet == null);
    while (true)
    {
      return localArrayList;
      paramHashSet = paramHashSet.iterator();
      while (paramHashSet.hasNext())
      {
        Label localLabel = Q((String)paramHashSet.next());
        if (localLabel != null)
          localArrayList.add(localLabel);
      }
    }
  }

  public void c(ModelEventDispatcher.a parama)
  {
    super.c(parama);
    if ((parama.jdMethod_if() instanceof Label))
      gP().a(this);
  }

  public void gH()
  {
    b(ModelEventDispatcher.EventType.wX);
  }

  public void gI()
  {
    b(ModelEventDispatcher.EventType.wU);
  }

  protected Loader<Cursor> gy()
  {
    long l = gA().getId();
    return new CursorLoader(getActivity(), i.k.CONTENT_URI, Label.COLUMNS, "account_id=?", new String[] { Long.valueOf(l).toString() }, null);
  }

  public ArrayList<Label> ho()
  {
    return mItems;
  }

  public void j(List<DbOperation> paramList)
  {
    Iterator localIterator = mItems.iterator();
    Label localLabel;
    ContentValues localContentValues;
    while (localIterator.hasNext())
    {
      localLabel = (Label)localIterator.next();
      if (localLabel.gw())
      {
        if (localLabel.gv())
        {
          localContentValues = localLabel.gQ();
          localContentValues.put("account_id", Long.valueOf(gA().getId()));
          paramList.add(DbOperation.cY().b(i.k.CONTENT_URI).a(localContentValues));
        }
        while (true)
        {
          localLabel.gR();
          break;
          paramList.add(DbOperation.cZ().b(ContentUris.withAppendedId(i.k.CONTENT_URI, localLabel.getId())).a(localLabel.gQ()));
        }
      }
    }
    localIterator = gG().iterator();
    while (localIterator.hasNext())
    {
      localLabel = (Label)localIterator.next();
      localContentValues = new ContentValues();
      localContentValues.put("is_deleted", Integer.valueOf(1));
      localContentValues.put("deleted_timestamp", Long.valueOf(System.currentTimeMillis()));
      paramList.add(DbOperation.cZ().b(i.k.CONTENT_URI).a("_id=?", new String[] { String.valueOf(localLabel.getId()) }).a(localContentValues));
    }
  }

  Label n(Cursor paramCursor)
  {
    return Label.m(paramCursor);
  }
}