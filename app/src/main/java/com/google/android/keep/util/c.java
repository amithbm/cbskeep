package com.google.android.keep.util;

import android.util.Log;
import com.google.android.common.base.Preconditions;
import com.google.android.gsf.GservicesValue;
import java.util.List;

public class c
{
  private static String E(int paramInt1, int paramInt2)
  {
    for (String str = String.valueOf(paramInt1); str.length() < paramInt2; str = str + " ");
    return str;
  }

  public static <T> void a(String paramString1, String paramString2, List<T> paramList)
  {
    if (!((Boolean)Config.Pf.get()).booleanValue())
      return;
    paramString2 = new StringBuilder(paramString2).append(":\n");
    int i = 0;
    while (i < paramList.size())
    {
      paramString2.append("  ").append(E(i, 3)).append(paramList.get(i).toString()).append("\n");
      i += 1;
    }
    Log.w(paramString1, paramString2.toString());
  }

  public static <T> boolean a(List<T> paramList, T paramT, int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < paramList.size()));
    int i;
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      i = paramList.indexOf(paramT);
      if (i != paramInt)
        break;
      return false;
    }
    if (i >= 0)
      paramList.remove(i);
    if (paramInt >= paramList.size())
      paramList.add(paramT);
    while (true)
    {
      return true;
      paramList.add(paramInt, paramT);
    }
  }
}