package com.google.android.keep.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class IndexListItem extends LinearLayout
  implements Checkable
{
  protected KeepCheckedTextView Jv;
  protected ImageView Jw;
  private boolean Jx = false;

  public IndexListItem(Context paramContext)
  {
    this(paramContext, null);
  }

  public IndexListItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public IndexListItem(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public void f(String paramString, int paramInt)
  {
    if (Jv == null)
      Jv = ((KeepCheckedTextView)findViewById(2131493075));
    if (Jv != null)
    {
      Jv.setText(paramString);
      Jv.setTextSize(paramInt);
    }
  }

  public boolean hasOverlappingRendering()
  {
    return false;
  }

  public boolean isChecked()
  {
    return Jx;
  }

  public void setChecked(boolean paramBoolean)
  {
    if (Jx != paramBoolean)
      Jx = paramBoolean;
    if (Jv == null)
      Jv = ((KeepCheckedTextView)findViewById(2131493075));
    if (Jw == null)
      Jw = ((ImageView)findViewById(2131492998));
    if (Jv != null)
    {
      if (!Jx)
        break label113;
      Jv.setPaintFlags(Jv.getPaintFlags() | 0x10);
    }
    while (true)
    {
      Jv.setChecked(paramBoolean);
      if (Jw != null)
      {
        if (!paramBoolean)
          break;
        Jw.setImageResource(2130837669);
      }
      return;
      label113: Jv.setPaintFlags(Jv.getPaintFlags() & 0xFFFFFFEF);
    }
    Jw.setImageResource(2130837671);
  }

  public void toggle()
  {
    if (!Jx);
    for (boolean bool = true; ; bool = false)
    {
      setChecked(bool);
      return;
    }
  }
}