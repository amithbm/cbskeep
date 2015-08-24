package com.google.android.keep.colorpicker;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import com.google.android.keep.util.d;

public class ColorPickerPalette extends TableLayout
{
  protected final String[] kg = d.I(getContext());
  public b.a kh;
  protected String ki;
  protected int kj;
  protected int kk;
  protected int kl;
  protected String mDescription;

  public ColorPickerPalette(Context paramContext)
  {
    super(paramContext);
  }

  public ColorPickerPalette(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public void a(int paramInt1, int paramInt2, b.a parama)
  {
    kl = paramInt2;
    Resources localResources = getResources();
    if (paramInt1 == 2)
      kj = localResources.getDimensionPixelSize(2131427490);
    for (kk = localResources.getDimensionPixelSize(2131427492); ; kk = localResources.getDimensionPixelSize(2131427508))
    {
      kh = parama;
      mDescription = localResources.getString(2131231137);
      ki = localResources.getString(2131231138);
      return;
      kj = localResources.getDimensionPixelSize(2131427506);
    }
  }

  protected void a(int paramInt, boolean paramBoolean, View paramView)
  {
    if (paramBoolean);
    for (String str = String.format(ki, new Object[] { kg[paramInt] }); ; str = String.format(mDescription, new Object[] { kg[paramInt] }))
    {
      paramView.setContentDescription(str);
      return;
    }
  }

  protected void a(TableRow paramTableRow, View paramView, int paramInt)
  {
    if (paramInt % 2 == 0)
    {
      paramTableRow.addView(paramView);
      return;
    }
    paramTableRow.addView(paramView, 0);
  }

  public void b(int[] paramArrayOfInt, int paramInt)
  {
    if (paramArrayOfInt == null);
    int i;
    int j;
    Object localObject1;
    label52: 
    do
    {
      return;
      removeAllViews();
      int m = 0;
      i = 0;
      j = 0;
      localObject1 = cW();
      int i2 = paramArrayOfInt.length;
      int k = 0;
      if (k < i2)
      {
        int n = paramArrayOfInt[k];
        Object localObject2;
        if (n == paramInt)
        {
          bool = true;
          localObject2 = c(n, bool);
          if (n != paramInt)
            break label169;
        }
        for (boolean bool = true; ; bool = false)
        {
          a(m, bool, (View)localObject2);
          a((TableRow)localObject1, (View)localObject2, j);
          n = m + 1;
          int i1 = i + 1;
          localObject2 = localObject1;
          i = i1;
          m = j;
          if (i1 == kl)
          {
            addView((View)localObject1);
            localObject2 = cW();
            i = 0;
            m = j + 1;
          }
          k += 1;
          localObject1 = localObject2;
          j = m;
          m = n;
          break;
          bool = false;
          break label52;
        }
      }
    }
    while (i <= 0);
    label169: 
    while (i != kl)
    {
      a((TableRow)localObject1, cX(), j);
      i += 1;
    }
    addView((View)localObject1);
  }

  protected View c(int paramInt, boolean paramBoolean)
  {
    b localb = new b(getContext(), paramInt, paramBoolean, kh);
    TableRow.LayoutParams localLayoutParams = new TableRow.LayoutParams(kj, kj);
    localLayoutParams.setMargins(kk, kk, kk, kk);
    localb.setLayoutParams(localLayoutParams);
    return localb;
  }

  protected TableRow cW()
  {
    TableRow localTableRow = new TableRow(getContext());
    localTableRow.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    return localTableRow;
  }

  protected ImageView cX()
  {
    ImageView localImageView = new ImageView(getContext());
    TableRow.LayoutParams localLayoutParams = new TableRow.LayoutParams(kj, kj);
    localLayoutParams.setMargins(kk, kk, kk, kk);
    localImageView.setLayoutParams(localLayoutParams);
    return localImageView;
  }
}