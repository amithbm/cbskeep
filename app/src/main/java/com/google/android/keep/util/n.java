package com.google.android.keep.util;

public final class n
{
  public static void cG(int paramInt)
  {
    if ((paramInt == 0) || (paramInt == 1) || (paramInt == 2) || (paramInt == 3) || (paramInt == 4))
      return;
    throw new IllegalStateException("Invalid launch mode " + paramInt);
  }
}