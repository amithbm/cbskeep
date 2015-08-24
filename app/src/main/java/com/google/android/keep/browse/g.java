package com.google.android.keep.browse;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import com.google.android.keep.model.c;
import com.google.android.keep.ui.h;

public abstract class g<E extends c> extends h
{
  protected final PositionMap<E> gZ;
  protected final Context mContext;
  protected final LayoutInflater mInflater;

  public g(Context paramContext, Cursor paramCursor, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    mContext = paramContext;
    mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    gZ = new PositionMap(paramInt1, paramInt2, paramInt3, paramBoolean)
    {
      protected E c(Cursor paramAnonymousCursor)
      {
        return g.this.c(paramAnonymousCursor);
      }
    };
    gZ.changeCursor(paramCursor);
  }

  public E F(int paramInt)
  {
    return gZ.F(paramInt);
  }

  protected abstract E c(Cursor paramCursor);

  public void changeCursor(Cursor paramCursor)
  {
    gZ.changeCursor(paramCursor);
    notifyDataSetChanged();
  }

  public int getCount()
  {
    return gZ.getCount();
  }

  public long getItemId(int paramInt)
  {
    return gZ.getItemId(paramInt);
  }
}