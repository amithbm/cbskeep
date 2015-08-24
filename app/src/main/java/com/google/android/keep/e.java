package com.google.android.keep;

import com.google.android.common.base.Preconditions;

public abstract class e extends u
{
  protected c dI;

  protected String S()
  {
    return null;
  }

  protected void a(int paramInt1, int paramInt2, int paramInt3, Long paramLong)
  {
    if (dI != null)
      dI.a(paramInt1, paramInt2, paramInt3, paramLong);
  }

  protected boolean aB()
  {
    return true;
  }

  public void onStart()
  {
    super.onStart();
    if (((getActivity() instanceof c)) && (aB()))
    {
      Preconditions.checkNotNull(S());
      dI = ((c)getActivity());
      dI.g(S());
    }
  }
}