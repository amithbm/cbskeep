package com.google.android.keep.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckedTextView;
import com.google.android.keep.util.e;

public class KeepCheckedTextView extends CheckedTextView
{
  public KeepCheckedTextView(Context paramContext)
  {
    this(paramContext, null);
  }

  public KeepCheckedTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramContext, paramAttributeSet);
  }

  public KeepCheckedTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b(paramContext, paramAttributeSet);
  }

  private void b(Context paramContext, AttributeSet paramAttributeSet)
  {
    setTypeface(e.d(paramContext, paramAttributeSet));
  }
}