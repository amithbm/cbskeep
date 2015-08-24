package com.google.android.keep.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnFocusChangeListener;

public class EditorRecyclerView extends RecyclerView
{
  private a Jh;

  public EditorRecyclerView(Context paramContext)
  {
    this(paramContext, null, 0);
  }

  public EditorRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public EditorRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public void a(a parama)
  {
    Jh = parama;
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (Jh != null)
      Jh.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }

  public void requestChildFocus(View paramView1, View paramView2)
  {
    super.requestChildFocus(paramView1, paramView2);
    getOnFocusChangeListener().onFocusChange(paramView1, false);
    getOnFocusChangeListener().onFocusChange(paramView2, true);
  }

  public static abstract interface a
  {
    public abstract void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }

  public static abstract interface b
  {
    public abstract void a(RecyclerView.ViewHolder paramViewHolder);

    public abstract boolean an(int paramInt);

    public abstract void dS();

    public abstract void l(int paramInt1, int paramInt2);
  }
}