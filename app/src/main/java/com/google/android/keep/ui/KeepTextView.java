package com.google.android.keep.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.google.android.keep.util.e;

public class KeepTextView extends TextView
{
  public KeepTextView(Context paramContext)
  {
    this(paramContext, null);
  }

  public KeepTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramContext, paramAttributeSet);
  }

  public KeepTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b(paramContext, paramAttributeSet);
  }

  private void b(Context paramContext, AttributeSet paramAttributeSet)
  {
    setTypeface(e.d(paramContext, paramAttributeSet));
  }
}