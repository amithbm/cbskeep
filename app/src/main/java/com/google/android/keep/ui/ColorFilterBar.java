package com.google.android.keep.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TableRow;
import com.google.android.keep.colorpicker.ColorPickerPalette;
import com.google.android.keep.colorpicker.b;
import com.google.android.keep.colorpicker.b.a;
import com.google.android.keep.model.ColorMap;
import com.google.android.keep.model.ColorMap.ColorPair;
import com.google.android.keep.util.d;
import java.util.List;

public class ColorFilterBar extends ColorPickerPalette
  implements b.a
{
  private final int[] IP = d.H(getContext());
  private List<String> IQ;
  private a IR;
  private Resources mResources;

  public ColorFilterBar(Context paramContext)
  {
    super(paramContext);
  }

  public ColorFilterBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  private void e(int paramInt, boolean paramBoolean)
  {
    int i = 0;
    if (i < getChildCount())
    {
      TableRow localTableRow = (TableRow)getChildAt(i);
      int j = 0;
      while (true)
      {
        if (j < localTableRow.getChildCount())
        {
          Object localObject = localTableRow.getChildAt(j);
          if ((localObject instanceof b))
          {
            localObject = (b)localObject;
            if (((b)localObject).getColor() == paramInt)
              ((b)localObject).s(paramBoolean);
          }
        }
        else
        {
          i += 1;
          break;
        }
        j += 1;
      }
    }
  }

  private int ma()
  {
    if (IQ.isEmpty())
      return -1;
    return ColorMap.J((String)IQ.get(0)).getValue();
  }

  public void a(View paramView, List<String> paramList)
  {
    mResources = paramView.getResources();
    super.a(3, mResources.getInteger(2131361825), this);
    IQ = paramList;
    b(IP, ma());
  }

  public void a(a parama)
  {
    IR = parama;
  }

  public void bj(String paramString)
  {
    boolean bool = bk(paramString);
    a locala;
    if (bool)
    {
      IQ.remove(paramString);
      if (IR != null)
      {
        locala = IR;
        if (bool)
          break label71;
      }
    }
    label71: for (bool = true; ; bool = false)
    {
      locala.c(paramString, bool);
      return;
      IQ.clear();
      IQ.add(paramString);
      break;
    }
  }

  public boolean bk(String paramString)
  {
    if (IQ == null)
      return false;
    return IQ.contains(paramString);
  }

  public void clear()
  {
    IQ.clear();
    b(IP, -1);
  }

  public void hide()
  {
    setVisibility(8);
  }

  public boolean isVisible()
  {
    return getVisibility() == 0;
  }

  public List<String> lZ()
  {
    return IQ;
  }

  public void show()
  {
    setVisibility(0);
  }

  public void y(int paramInt)
  {
    String str = ColorMap.aM(paramInt).getKey();
    int i = ma();
    if (paramInt == i)
      e(paramInt, false);
    while (true)
    {
      bj(str);
      return;
      if (i != -1)
        e(i, false);
      e(paramInt, true);
    }
  }

  public static abstract interface a
  {
    public abstract void c(String paramString, boolean paramBoolean);
  }
}