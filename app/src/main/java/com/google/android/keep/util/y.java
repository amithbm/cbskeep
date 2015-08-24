package com.google.android.keep.util;

import android.text.Editable;
import android.text.TextWatcher;

public abstract class y
  implements TextWatcher
{
  private boolean Qb = false;
  private int mPosition;

  public abstract void a(Editable paramEditable, int paramInt);

  public void afterTextChanged(Editable paramEditable)
  {
    if (Qb)
    {
      Qb = false;
      a(paramEditable, mPosition);
    }
  }

  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
  }

  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt3 == 1) && (paramInt1 < paramCharSequence.length()) && (paramCharSequence.charAt(paramInt1) == '\n'))
    {
      Qb = true;
      mPosition = paramInt1;
    }
  }
}