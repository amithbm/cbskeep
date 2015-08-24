package com.google.android.keep.ui;

import android.text.Editable;
import android.text.TextWatcher;

public class e
  implements TextWatcher
{
  private final int IF;
  private final a IG;

  public e(a parama, int paramInt)
  {
    IG = parama;
    IF = paramInt;
  }

  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable != null)
    {
      if (paramEditable.length() <= IF)
        break label59;
      paramEditable.replace(0, paramEditable.length(), paramEditable.subSequence(0, IF));
    }
    label59: for (boolean bool = true; ; bool = false)
    {
      IG.a(paramEditable.toString(), bool);
      return;
    }
  }

  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
  }

  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
  }

  public static abstract interface a
  {
    public abstract void a(String paramString, boolean paramBoolean);
  }
}