package com.google.android.keep.browse;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.keep.model.Note;
import com.google.android.keep.ui.c;
import com.google.common.collect.Maps;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class n extends k
{
  private static int iI = -1;
  private final o[] iJ;
  private final HashMap<Integer, a> iK = Maps.newHashMap();

  public n(Context paramContext, com.google.android.keep.p paramp, Cursor paramCursor, p paramp1, c paramc, o[] paramArrayOfo)
  {
    super(paramContext, paramp, paramCursor, paramp1, paramc);
    if (iI == -1)
      iI = paramContext.getResources().getInteger(2131361811);
    iJ = paramArrayOfo;
    e(paramCursor);
  }

  private boolean X(int paramInt)
  {
    return iK.containsKey(Integer.valueOf(paramInt));
  }

  private View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = mInflater.inflate(2130968617, paramViewGroup, false);
      localView.setTag(new r.b(localView));
    }
    ((r.b)localView.getTag()).jK.setText(((a)iK.get(Integer.valueOf(paramInt))).iL);
    return localView;
  }

  private void e(Cursor paramCursor)
  {
    iK.clear();
    if (paramCursor == null);
    while (true)
    {
      return;
      paramCursor = paramCursor.getExtras();
      int j = 0;
      int i = 0;
      while (i < iJ.length)
      {
        o localo = iJ[i];
        int m = paramCursor.getInt(localo.cD(), -1);
        int k = j;
        if (m >= 0)
        {
          iK.put(Integer.valueOf(m + j), new a(-100L - i, paramCursor.getString(localo.cC()), null));
          k = j + 1;
        }
        i += 1;
        j = k;
      }
    }
  }

  public int Q(int paramInt)
  {
    if (X(paramInt))
      return iI;
    return super.Q(paramInt);
  }

  public boolean R(int paramInt)
  {
    return false;
  }

  public Note V(int paramInt)
  {
    if (X(paramInt))
      return null;
    return (Note)super.F(W(paramInt));
  }

  protected int W(int paramInt)
  {
    int i = paramInt;
    Iterator localIterator = iK.keySet().iterator();
    while (localIterator.hasNext())
      if (paramInt > ((Integer)localIterator.next()).intValue())
        i -= 1;
    return i;
  }

  public View a(int paramInt1, View paramView, ViewGroup paramViewGroup, int paramInt2)
  {
    if (getItemViewType(paramInt1) == 4)
      return a(paramInt1, paramView, paramViewGroup);
    return super.a(paramInt1, paramView, paramViewGroup, paramInt2);
  }

  public void changeCursor(Cursor paramCursor)
  {
    if (fg.ih())
      e(paramCursor);
    super.changeCursor(paramCursor);
  }

  public int getCount()
  {
    return super.getCount() + iK.size();
  }

  public long getItemId(int paramInt)
  {
    if (X(paramInt))
      return ((a)iK.get(Integer.valueOf(paramInt))).mId;
    return super.getItemId(W(paramInt));
  }

  public int getItemViewType(int paramInt)
  {
    if (X(paramInt))
      return 4;
    return super.getItemViewType(paramInt);
  }

  public boolean isEnabled(int paramInt)
  {
    return getItemViewType(paramInt) != 4;
  }

  private final class a
  {
    public final String iL;
    public final long mId;

    private a(long arg2, String arg4)
    {
      mId = ???;
      Object localObject;
      iL = localObject;
    }
  }
}