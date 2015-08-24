package com.google.android.keep.util;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.support.v4.app.Fragment;
import com.google.android.common.base.Preconditions;
import com.google.android.keep.colorpicker.a;
import com.google.android.keep.model.e;

public class d
{
  private static final String Om = a.class.getSimpleName();
  private static int On = -1;
  private static int Oo = -1;

  public static int[] H(Context paramContext)
  {
    TypedArray localTypedArray = paramContext.getResources().obtainTypedArray(2131689487);
    if (localTypedArray == null)
      return null;
    int[] arrayOfInt = new int[localTypedArray.length()];
    int i = 0;
    while (i < localTypedArray.length())
    {
      arrayOfInt[i] = localTypedArray.getColor(i, J(paramContext));
      i += 1;
    }
    localTypedArray.recycle();
    return arrayOfInt;
  }

  public static String[] I(Context paramContext)
  {
    return paramContext.getResources().getStringArray(2131689490);
  }

  public static int J(Context paramContext)
  {
    if (On == -1)
      On = paramContext.getResources().getColor(2131296466);
    return On;
  }

  public static String a(Context paramContext, int paramInt)
  {
    int[] arrayOfInt = H(paramContext);
    paramContext = I(paramContext);
    boolean bool;
    int i;
    if (arrayOfInt.length == paramContext.length)
    {
      bool = true;
      Preconditions.checkArgument(bool);
      i = 0;
    }
    while (true)
    {
      if (i >= arrayOfInt.length)
        break label58;
      if (paramInt == arrayOfInt[i])
      {
        return paramContext[i];
        bool = false;
        break;
      }
      i += 1;
    }
    label58: return null;
  }

  public static void a(int paramInt, Fragment paramFragment)
  {
    a locala = a.a(2131231135, H(paramFragment.getActivity()), paramInt, 4, 2);
    locala.setTargetFragment(paramFragment, 0);
    locala.show(paramFragment.getFragmentManager(), Om);
  }

  public static GradientDrawable bu(String paramString)
  {
    return new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, e.H(paramString));
  }
}