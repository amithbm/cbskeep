package com.google.android.keep.browse;

import android.database.DataSetObserver;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.WrapperListAdapter;
import com.google.android.keep.ui.SgvAnimationHelper.TranslationAnimationType;
import com.google.android.keep.ui.h;
import com.google.common.collect.Lists;
import java.util.ArrayList;

public abstract class f<T extends h> extends h
  implements WrapperListAdapter
{
  protected T gQ;
  private final ArrayList<a> gR;
  private final ArrayList<a> gS;
  private final int gT;
  private final int gU;
  private final int gV;
  private boolean gW = false;
  private final DataSetObserver mObserver = new DataSetObserver()
  {
    public void onChanged()
    {
      notifyDataSetChanged();
    }
  };

  public f(T paramT)
  {
    gQ = paramT;
    gR = Lists.newArrayList();
    gS = Lists.newArrayList();
    if (gQ == null);
    while (true)
    {
      gT = i;
      gU = (i + 1);
      gV = (i + 2);
      gQ.registerDataSetObserver(mObserver);
      return;
      i = gQ.getViewTypeCount();
    }
  }

  public SgvAnimationHelper.TranslationAnimationType L(int paramInt)
  {
    return gQ.L(O(paramInt));
  }

  protected boolean M(int paramInt)
  {
    return paramInt < gR.size();
  }

  protected boolean N(int paramInt)
  {
    return (paramInt >= gR.size()) && (paramInt < gR.size() + gQ.getCount());
  }

  protected int O(int paramInt)
  {
    return paramInt - gR.size();
  }

  protected int P(int paramInt)
  {
    return paramInt - gR.size() - gQ.getCount();
  }

  public int Q(int paramInt)
  {
    if (M(paramInt))
      return a.c((a)gR.get(paramInt));
    if (N(paramInt))
      return gQ.Q(O(paramInt));
    return a.c((a)gS.get(P(paramInt)));
  }

  public boolean R(int paramInt)
  {
    if (M(paramInt));
    while (!N(paramInt))
      return false;
    return gQ.R(O(paramInt));
  }

  public boolean S(int paramInt)
  {
    if (M(paramInt));
    while (!N(paramInt))
      return false;
    return gQ.S(O(paramInt));
  }

  public int a(int paramInt, boolean paramBoolean)
  {
    if (M(paramInt));
    while (!N(paramInt))
      return 0;
    return gQ.a(O(paramInt), paramBoolean);
  }

  public BitmapDrawable a(int paramInt, View paramView)
  {
    if (M(paramInt));
    while (!N(paramInt))
      return null;
    return gQ.a(O(paramInt), paramView);
  }

  public View a(int paramInt1, View paramView, ViewGroup paramViewGroup, int paramInt2)
  {
    if (M(paramInt1))
      return a.a((a)gR.get(paramInt1));
    if (N(paramInt1))
      return gQ.a(O(paramInt1), paramView, paramViewGroup, paramInt2);
    return a.a((a)gS.get(P(paramInt1)));
  }

  public void a(View paramView, Object paramObject, int paramInt)
  {
    paramView = new a(paramView, paramObject, paramInt);
    gR.add(paramView);
    gW = true;
  }

  public void addHeaderView(View paramView)
  {
    a(paramView, null, 1);
  }

  public void cn()
  {
    gR.clear();
  }

  public void co()
  {
    gS.clear();
  }

  public int cp()
  {
    if (gW)
    {
      gW = false;
      return 0;
    }
    return gR.size() + gQ.cp();
  }

  public int cq()
  {
    return gQ.cq();
  }

  public T cr()
  {
    return gQ;
  }

  public int getCount()
  {
    if (gQ == null);
    for (int i = 0; ; i = gQ.getCount())
      return getFootersCount() + getHeadersCount() + i;
  }

  public int getFootersCount()
  {
    return gS.size();
  }

  public int getHeadersCount()
  {
    return gR.size();
  }

  public Object getItem(int paramInt)
  {
    if (M(paramInt))
      return a.b((a)gR.get(paramInt));
    if (N(paramInt))
      return gQ.getItem(O(paramInt));
    return a.b((a)gS.get(P(paramInt)));
  }

  public long getItemId(int paramInt)
  {
    if (M(paramInt))
      return -100 - paramInt;
    if (N(paramInt))
      return gQ.getItemId(O(paramInt));
    return -200 - P(paramInt);
  }

  public int getItemViewType(int paramInt)
  {
    if (M(paramInt))
      return gT;
    if (N(paramInt))
      return gQ.getItemViewType(O(paramInt));
    return gU;
  }

  public int getViewTypeCount()
  {
    return gV;
  }

  public boolean hasStableIds()
  {
    if (gQ != null)
      return gQ.hasStableIds();
    return true;
  }

  public boolean removeHeaderView(View paramView)
  {
    int i = 0;
    while (i < gR.size())
    {
      if (a.a((a)gR.get(i)) == paramView)
      {
        gR.remove(i);
        return true;
      }
      i += 1;
    }
    return false;
  }

  public static class a
  {
    private final int gY;
    private final Object mData;
    private final View mView;

    public a(View paramView, Object paramObject, int paramInt)
    {
      mView = paramView;
      mData = paramObject;
      gY = paramInt;
    }
  }
}