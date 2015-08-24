package com.google.android.gms.people.accountswitcherview;

import android.graphics.drawable.ColorDrawable;

public class ScrimDrawable extends ColorDrawable
{
  private int mIntrinsicHeight;

  public ScrimDrawable()
  {
    this(855638016);
  }

  public ScrimDrawable(int paramInt)
  {
    super(paramInt);
  }

  public int getIntrinsicHeight()
  {
    return mIntrinsicHeight;
  }

  public void setIntrinsicHeight(int paramInt)
  {
    mIntrinsicHeight = paramInt;
  }
}