package com.google.android.gms.people.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzv;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class zzm
{
  public static final zzm zzbcV = new zzm();
  private Pattern[] zzbcW = new Pattern[0];
  private String[] zzbcX = new String[0];

  public void zzF(Bundle paramBundle)
  {
    zza(paramBundle.getStringArray("config.url_uncompress.patterns"), paramBundle.getStringArray("config.url_uncompress.replacements"));
  }

  public void zza(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    int i = 0;
    try
    {
      if (paramArrayOfString1.length == paramArrayOfString2.length);
      for (boolean bool = true; ; bool = false)
      {
        zzv.zzS(bool);
        zzbcW = new Pattern[paramArrayOfString1.length];
        zzbcX = paramArrayOfString2;
        while (i < paramArrayOfString1.length)
        {
          zzbcW[i] = Pattern.compile(paramArrayOfString1[i]);
          i += 1;
        }
      }
      return;
    }
    finally
    {
    }
    throw paramArrayOfString1;
  }

  public String zzdR(String paramString)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(paramString);
      String str;
      if (bool)
      {
        str = null;
        return str;
      }
      int i = 0;
      while (true)
      {
        str = paramString;
        if (i >= zzbcW.length)
          break;
        paramString = zzbcW[i].matcher(paramString).replaceAll(zzbcX[i]);
        i += 1;
      }
    }
    finally
    {
    }
    throw paramString;
  }
}