package com.google.android.keep.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class GraveyardHeaderView extends LinearLayout
{
  private ImageView Jq;
  private boolean Jr;
  private a Js;
  private final View.OnClickListener Jt = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if (GraveyardHeaderView.c(GraveyardHeaderView.this))
      {
        expand();
        return;
      }
      GraveyardHeaderView.d(GraveyardHeaderView.this);
    }
  };
  private boolean de;
  private View lf;

  public GraveyardHeaderView(Context paramContext)
  {
    super(paramContext);
  }

  public GraveyardHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public GraveyardHeaderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  private void cf()
  {
    Jq.setImageResource(2130837675);
    if (!Jr)
    {
      if (Js != null)
        Js.a(this);
      Jr = true;
    }
    lf.setContentDescription(getContext().getResources().getString(2131231165));
  }

  public void B(boolean paramBoolean)
  {
    View localView;
    if (de != paramBoolean)
    {
      de = paramBoolean;
      localView = lf;
      if (de)
        break label33;
    }
    label33: for (paramBoolean = true; ; paramBoolean = false)
    {
      localView.setEnabled(paramBoolean);
      return;
    }
  }

  public void a(a parama)
  {
    Js = parama;
  }

  public void expand()
  {
    Jq.setImageResource(2130837674);
    if (Jr)
    {
      if (Js != null)
        Js.b(this);
      Jr = false;
    }
    lf.setContentDescription(getContext().getResources().getString(2131231166));
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    lf = findViewById(2131493116);
    Jq = ((ImageView)findViewById(2131493177));
    lf.setOnClickListener(Jt);
    expand();
  }

  public void setExpanded(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      expand();
      return;
    }
    cf();
  }

  public static abstract interface a
  {
    public abstract void a(GraveyardHeaderView paramGraveyardHeaderView);

    public abstract void b(GraveyardHeaderView paramGraveyardHeaderView);
  }
}