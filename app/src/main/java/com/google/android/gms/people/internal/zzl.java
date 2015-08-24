package com.google.android.gms.people.internal;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.internal.zzv;

public class zzl
{
  public static boolean isEnabled()
  {
    return Log.isLoggable("PeopleClientCall", 3);
  }

  public static String zzc(Object[] paramArrayOfObject)
  {
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramArrayOfObject.length % 2 == 0);
    for (boolean bool = true; ; bool = false)
    {
      zzv.zzS(bool);
      String str = "";
      while (i < paramArrayOfObject.length)
      {
        localStringBuilder.append(str);
        localStringBuilder.append(paramArrayOfObject[i]);
        localStringBuilder.append("=");
        localStringBuilder.append(paramArrayOfObject[(i + 1)]);
        str = ", ";
        i += 2;
      }
    }
    return localStringBuilder.toString();
  }

  public static void zzh(String paramString, Object[] paramArrayOfObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("(");
    int j = paramArrayOfObject.length;
    paramString = "";
    int i = 0;
    if (i < j)
    {
      Object localObject = paramArrayOfObject[i];
      localStringBuilder.append(paramString);
      if ((localObject instanceof Bundle))
        localStringBuilder.append(zzp.zzI((Bundle)localObject));
      while (true)
      {
        paramString = ", ";
        i += 1;
        break;
        localStringBuilder.append(localObject);
      }
    }
    localStringBuilder.append(")");
    if (Log.isLoggable("PeopleClientCall", 2));
    for (paramString = new Throwable("STACK TRACE (It's not crash!)"); ; paramString = null)
    {
      Log.d("PeopleClientCall", localStringBuilder.toString(), paramString);
      return;
    }
  }
}