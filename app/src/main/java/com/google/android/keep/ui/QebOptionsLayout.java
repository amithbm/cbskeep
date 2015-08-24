package com.google.android.keep.ui;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.google.android.keep.f;
import com.google.android.keep.util.e;

public class QebOptionsLayout extends LinearLayout
  implements View.OnClickListener, View.OnLongClickListener
{
  private ImageView LA;
  private ImageView LB;
  private ImageView LC;
  private ImageView LD;
  private ObjectAnimator LE = null;
  private QuickEditLayout.a Lz = null;

  public QebOptionsLayout(Context paramContext)
  {
    super(paramContext);
  }

  public QebOptionsLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public QebOptionsLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  private void a(ObjectAnimator paramObjectAnimator)
  {
    mw();
    LE = paramObjectAnimator;
    if (LE != null)
      LE.start();
  }

  private void mw()
  {
    if (LE != null)
    {
      LE.cancel();
      LE = null;
    }
  }

  public void a(QuickEditLayout.a parama)
  {
    Lz = parama;
  }

  public void f(View paramView, int paramInt)
  {
    if ((paramInt & 0x1) == 1)
    {
      LA = ((ImageView)paramView.findViewById(2131493402));
      LA.setVisibility(0);
      LA.setOnClickListener(this);
      LA.setOnLongClickListener(this);
    }
    if ((paramInt & 0x2) == 2)
    {
      LB = ((ImageView)paramView.findViewById(2131493299));
      LB.setVisibility(0);
      LB.setOnClickListener(this);
      LB.setOnLongClickListener(this);
    }
    if ((paramInt & 0x4) == 4)
    {
      LC = ((ImageView)paramView.findViewById(2131493300));
      LC.setVisibility(0);
      LC.setOnClickListener(this);
      LC.setOnLongClickListener(this);
    }
    if ((paramInt & 0x8) == 8)
    {
      LD = ((ImageView)paramView.findViewById(2131493301));
      LD.setVisibility(0);
      LD.setOnClickListener(this);
      LD.setOnLongClickListener(this);
    }
  }

  public void hide()
  {
    a(f.d(this));
  }

  public void onClick(View paramView)
  {
    int i;
    switch (paramView.getId())
    {
    default:
      throw new IllegalStateException("Unknown view");
    case 2131493402:
      i = 1;
    case 2131493299:
    case 2131493300:
    case 2131493301:
    }
    while (true)
    {
      if (Lz != null)
        Lz.C(i);
      return;
      i = 2;
      continue;
      i = 4;
      continue;
      i = 8;
    }
  }

  public boolean onLongClick(View paramView)
  {
    return e.C(paramView);
  }

  public void show()
  {
    a(f.c(this));
  }
}