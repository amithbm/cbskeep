package com.google.android.keep.colorpicker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.keep.util.e;

public class b extends FrameLayout
  implements View.OnClickListener, View.OnLongClickListener
{
  private a kh;
  private ImageView km;
  private ImageView kn;
  private int mColor;

  public b(Context paramContext, int paramInt, boolean paramBoolean, a parama)
  {
    super(paramContext);
    mColor = paramInt;
    kh = parama;
    LayoutInflater.from(paramContext).inflate(2130968641, this);
    km = ((ImageView)findViewById(2131493129));
    kn = ((ImageView)findViewById(2131493130));
    s(paramBoolean);
    setOnClickListener(this);
    setOnLongClickListener(this);
  }

  public int getColor()
  {
    return mColor;
  }

  public void onClick(View paramView)
  {
    if (kh != null)
      kh.y(mColor);
  }

  public boolean onLongClick(View paramView)
  {
    return e.C(paramView);
  }

  public void s(boolean paramBoolean)
  {
    Resources localResources = getContext().getResources();
    int j = localResources.getColor(2131296466);
    int i;
    GradientDrawable localGradientDrawable;
    if (mColor == j)
    {
      i = localResources.getColor(2131296467);
      localGradientDrawable = (GradientDrawable)localResources.getDrawable(2130837579);
      localGradientDrawable.setStroke((int)localResources.getDimension(2131427505), i);
      if (!paramBoolean)
        break label127;
      if (mColor == j)
        break label115;
      localGradientDrawable.setColor(mColor);
      kn.setImageResource(2130837655);
      label89: kn.setVisibility(0);
    }
    while (true)
    {
      km.setImageDrawable(localGradientDrawable);
      return;
      i = mColor;
      break;
      label115: kn.setImageResource(2130837654);
      break label89;
      label127: localGradientDrawable.setColor(localResources.getColor(17170445));
      kn.setVisibility(8);
    }
  }

  public static abstract interface a
  {
    public abstract void y(int paramInt);
  }
}