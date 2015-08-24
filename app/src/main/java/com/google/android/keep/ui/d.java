package com.google.android.keep.ui;

import android.support.v4.app.FragmentActivity;
import android.text.InputFilter;
import android.text.Spanned;
import com.google.android.keep.util.Config;
import com.google.android.keep.util.e;

public class d
  implements InputFilter
{
  private static final int vD = Config.nB();
  private final FragmentActivity IE;

  public d(FragmentActivity paramFragmentActivity)
  {
    IE = paramFragmentActivity;
  }

  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    paramInt3 = vD - (paramSpanned.length() - (paramInt4 - paramInt3));
    if ((paramInt3 > 0) && (paramInt3 >= paramInt2 - paramInt1))
      return null;
    e.b(IE, 2131231198);
    if (paramInt3 <= 0)
      return "";
    e.b(IE, 2131231198);
    paramInt3 += paramInt1;
    paramInt2 = paramInt3;
    if (Character.isHighSurrogate(paramCharSequence.charAt(paramInt3 - 1)))
    {
      paramInt3 -= 1;
      paramInt2 = paramInt3;
      if (paramInt3 == paramInt1)
        return "";
    }
    return paramCharSequence.subSequence(paramInt1, paramInt2);
  }
}