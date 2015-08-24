package com.google.android.keep.editor;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.keep.ui.EditorRecyclerView.b;

public class g extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private View lW;
  private View lX;
  private final RecyclerView.Adapter lY;
  private final RecyclerView.AdapterDataObserver lZ;

  public g(View paramView1, View paramView2, RecyclerView.Adapter paramAdapter)
  {
    lW = paramView1;
    lX = paramView2;
    lY = paramAdapter;
    lZ = new b(null);
    lY.registerAdapterDataObserver(lZ);
  }

  private int am(int paramInt)
  {
    return paramInt - getHeadersCount();
  }

  private int getHeadersCount()
  {
    if (lW == null)
      return 0;
    return 1;
  }

  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    if ((paramViewHolder.getAdapterPosition() >= getHeadersCount()) && ((lY instanceof EditorRecyclerView.b)))
      ((EditorRecyclerView.b)lY).a(paramViewHolder);
  }

  public boolean an(int paramInt)
  {
    if ((lY instanceof EditorRecyclerView.b))
      return ((EditorRecyclerView.b)lY).an(am(paramInt));
    return false;
  }

  public boolean dQ()
  {
    return lW != null;
  }

  public boolean dR()
  {
    return lX != null;
  }

  public void dS()
  {
    if ((lY instanceof EditorRecyclerView.b))
      ((EditorRecyclerView.b)lY).dS();
  }

  public int getItemCount()
  {
    int j = 1;
    int k = 0;
    int i;
    if (dQ())
    {
      i = 1;
      if (!dR())
        break label38;
      label20: if (!isEmpty())
        break label43;
    }
    while (true)
    {
      return i + j + k;
      i = 0;
      break;
      label38: j = 0;
      break label20;
      label43: k = lY.getItemCount();
    }
  }

  public long getItemId(int paramInt)
  {
    long l;
    switch (getItemViewType(paramInt))
    {
    default:
      l = lY.getItemId(am(paramInt));
      paramInt = 2;
    case 0:
    case 1:
    }
    while (true)
    {
      return 3L * l + paramInt;
      l = -100L;
      paramInt = 0;
      continue;
      l = -101L;
      paramInt = 1;
    }
  }

  public int getItemViewType(int paramInt)
  {
    if (paramInt < getHeadersCount())
      return 0;
    int i = am(paramInt);
    if (isEmpty());
    for (paramInt = 0; i < paramInt; paramInt = lY.getItemCount())
      return lY.getItemViewType(i) + 3;
    if (i == paramInt)
      return 1;
    throw new IndexOutOfBoundsException();
  }

  public boolean isEmpty()
  {
    return (lY == null) || (lY.getItemCount() == 0);
  }

  public void l(int paramInt1, int paramInt2)
  {
    if ((lY instanceof EditorRecyclerView.b))
      ((EditorRecyclerView.b)lY).l(am(paramInt1), am(paramInt2));
  }

  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    int i = getHeadersCount();
    int j = lY.getItemCount();
    if ((paramInt >= i) && (paramInt < i + j))
      lY.onBindViewHolder(paramViewHolder, am(paramInt));
  }

  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 0)
      return new a(lW);
    if (paramInt == 1)
      return new a(lX);
    return lY.onCreateViewHolder(paramViewGroup, paramInt - 3);
  }

  public void onViewRecycled(RecyclerView.ViewHolder paramViewHolder)
  {
    lY.onViewRecycled(paramViewHolder);
    super.onViewRecycled(paramViewHolder);
  }

  private static class a extends RecyclerView.ViewHolder
  {
    public a(View paramView)
    {
      super();
    }
  }

  private class b extends RecyclerView.AdapterDataObserver
  {
    private b()
    {
    }

    public void onChanged()
    {
      notifyDataSetChanged();
    }

    public void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
    {
      notifyDataSetChanged();
    }
  }
}