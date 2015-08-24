package com.google.android.keep.ui;

import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;

public final class v
{
  private a MA;
  private long MB = -1L;
  private final StaggeredGridView MC;
  private boolean MD = true;
  private Rect ME;
  private final StaggeredGridView.g My;
  private a Mz;

  public v(StaggeredGridView.g paramg, StaggeredGridView paramStaggeredGridView)
  {
    My = paramg;
    MC = paramStaggeredGridView;
    if (paramg == null)
      throw new IllegalArgumentException("ReorderListener cannot be null");
    if (paramStaggeredGridView == null)
      throw new IllegalArgumentException("ParentView cannot be null");
  }

  private void v(View paramView)
  {
    ME = new Rect(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
  }

  private void y(View paramView)
  {
    StaggeredGridView.b localb = (StaggeredGridView.b)paramView.getLayoutParams();
    Mz = new a(paramView, localb.position, localb.id);
  }

  public void a(Point paramPoint)
  {
    if ((paramPoint == null) || ((paramPoint.y < 0) && (paramPoint.y > MC.getHeight())))
      mJ();
    label139: 
    while (true)
    {
      return;
      if (MD)
      {
        View localView = null;
        if (Mz != null)
          localView = b(paramPoint);
        while (true)
        {
          if (localView == null)
            break label139;
          StaggeredGridView.b localb = (StaggeredGridView.b)localView.getLayoutParams();
          if ((localb.id == Mz.id) && ((ME == null) || (ME.contains(paramPoint.x, paramPoint.y))))
            break;
          y(localView);
          v(localView);
          My.b(localView, localb.position);
          return;
          Log.w("Keep", "Current dragged over child does not exist");
        }
      }
    }
  }

  public void a(View paramView, int paramInt, long paramLong)
  {
    MA = new a(paramView, paramInt, paramLong);
    MB = paramLong;
    Mz = new a(paramView, paramInt, paramLong);
    v(paramView);
    My.c(MA.MF, paramInt);
  }

  public void aL(boolean paramBoolean)
  {
    MD = paramBoolean;
  }

  public View b(Point paramPoint)
  {
    if ((paramPoint == null) || (paramPoint.y < 0))
      return null;
    int j = MC.getChildCount();
    int i = 0;
    if (i < j)
    {
      if (!MC.cs(i));
      View localView;
      do
      {
        i += 1;
        break;
        localView = MC.getChildAt(i);
      }
      while ((paramPoint.x < localView.getLeft()) || (paramPoint.x >= localView.getRight()) || (paramPoint.y < localView.getTop()) || (paramPoint.y >= localView.getBottom()));
      return localView;
    }
    return null;
  }

  public boolean mJ()
  {
    if ((Mz != null) && (MA.position != Mz.position))
      return My.a(MA.MF, MA.id, MA.position, Mz.position);
    My.a(MA.MF, MA.position, Mz.position);
    return false;
  }

  public View mK()
  {
    if (Mz != null)
      return Mz.MF;
    return null;
  }

  public void mL()
  {
    Mz = null;
  }

  public boolean mM()
  {
    return Mz != null;
  }

  public long mN()
  {
    return MB;
  }

  public View mO()
  {
    if (MA != null)
      return MA.MF;
    return null;
  }

  public void mP()
  {
    MA = null;
  }

  public void mQ()
  {
    MB = -1L;
  }

  public int mR()
  {
    if (MA != null)
      return MA.position;
    return -2;
  }

  public boolean mS()
  {
    return My != null;
  }

  public void u(View paramView)
  {
    My.g(paramView);
  }

  public void w(View paramView)
  {
    if ((MA != null) && (paramView != MA.MF))
      MA.MF = paramView;
  }

  public void x(View paramView)
  {
    if ((Mz != null) && (paramView != Mz.MF))
      Mz.MF = paramView;
  }

  private class a
  {
    View MF;
    final long id;
    final int position;

    public a(View paramInt, int paramLong, long arg4)
    {
      MF = paramInt;
      position = paramLong;
      Object localObject;
      id = localObject;
    }
  }
}