package com.google.android.gms.people.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import com.google.android.gms.common.data.DataHolder;
import java.lang.reflect.Array;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public class zzp
{
  public static final Handler zzbdA = new Handler(Looper.getMainLooper());
  public static final String[] zzbdB = new String[0];
  public static final Pattern zzbdC = Pattern.compile("\\,");
  public static final Pattern zzbdD = Pattern.compile("[     ᠎             　\t\013\f\034\035\036\037\n\r]+");
  public static final Pattern zzbdE = Pattern.compile(Pattern.quote(String.valueOf('\001')));
  public static final Pattern zzbdF = Pattern.compile(Pattern.quote(String.valueOf('\002')));
  public static final String zzbdG = String.valueOf('\001');
  public static final String zzbdH = String.valueOf('\002');
  public static final SecureRandom zzbdI = new SecureRandom();
  private static final ThreadLocal<StringBuilder> zzbdJ = new ThreadLocal()
  {
    protected StringBuilder zzAO()
    {
      return new StringBuilder();
    }
  };
  private static final ThreadLocal<String[]> zzbdK = new ThreadLocal()
  {
    protected String[] zzAP()
    {
      return new String[1];
    }
  };
  private static final ThreadLocal<String[]> zzbdL = new ThreadLocal()
  {
    protected String[] zzAP()
    {
      return new String[2];
    }
  };
  private static final ThreadLocal<String[]> zzbdM = new ThreadLocal()
  {
    protected String[] zzAP()
    {
      return new String[3];
    }
  };
  private static final ThreadLocal<String[]> zzbdN = new ThreadLocal()
  {
    protected String[] zzAP()
    {
      return new String[4];
    }
  };
  private static final ThreadLocal<String[]> zzbdO = new ThreadLocal()
  {
    protected String[] zzAP()
    {
      return new String[5];
    }
  };
  public static final Map<String, Integer> zzbdy = new HashMap()
  {
  };
  public static Iterable<?> zzbdz = new zze();

  public static String zzI(Bundle paramBundle)
  {
    return zza(paramBundle, "", new StringBuilder()).toString();
  }

  private static StringBuilder zza(Object paramObject, String paramString, StringBuilder paramStringBuilder)
  {
    if (paramObject == null)
    {
      paramStringBuilder.append("[null]\n");
      return paramStringBuilder;
    }
    String str1 = paramString + "  ";
    paramStringBuilder.append("(").append(paramObject.getClass().getSimpleName()).append(") ");
    if ((paramObject instanceof Bundle))
    {
      paramObject = (Bundle)paramObject;
      if (paramObject.isEmpty())
      {
        paramStringBuilder.append("{ }").append("\n");
        return paramStringBuilder;
      }
      paramStringBuilder.append("{\n");
      Iterator localIterator = paramObject.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        paramStringBuilder.append(str1).append(str2).append(" : ");
        zza(paramObject.get(str2), str1, paramStringBuilder);
      }
      paramStringBuilder.append(paramString).append("}\n");
      return paramStringBuilder;
    }
    if ((paramObject instanceof DataHolder))
    {
      paramString = (DataHolder)paramObject;
      paramStringBuilder.append(" [");
      if (paramString.isClosed())
        paramStringBuilder.append("CLOSED");
      while (true)
      {
        paramStringBuilder.append("] ").append(paramObject).append("\n");
        return paramStringBuilder;
        paramStringBuilder.append(paramString.getCount());
      }
    }
    int i;
    if ((paramObject instanceof ArrayList))
    {
      paramObject = (ArrayList)paramObject;
      if (paramObject.isEmpty())
      {
        paramStringBuilder.append("[ ]\n");
        return paramStringBuilder;
      }
      paramStringBuilder.append("[\n");
      i = 0;
      while (i < paramObject.size())
      {
        paramStringBuilder.append(str1).append(i).append(" : ");
        zza(paramObject.get(i), str1, paramStringBuilder);
        i += 1;
      }
      paramStringBuilder.append(paramString).append("]\n");
      return paramStringBuilder;
    }
    if ((paramObject instanceof byte[]))
    {
      i = ((byte[])paramObject).length;
      paramStringBuilder.append(" [").append(i).append("] ");
      paramString = new byte[Math.min(i, 56)];
      System.arraycopy(paramObject, 0, paramString, 0, paramString.length);
      paramStringBuilder.append(Base64.encodeToString(paramString, 0));
      return paramStringBuilder;
    }
    if ((paramObject instanceof char[]))
    {
      paramStringBuilder.append("\"").append(new String((char[])paramObject)).append("\"\n");
      return paramStringBuilder;
    }
    if (paramObject.getClass().isArray())
    {
      if (Array.getLength(paramObject) == 0)
      {
        paramStringBuilder.append("[ ]\n");
        return paramStringBuilder;
      }
      paramStringBuilder.append("[ ");
      paramStringBuilder.append(Array.get(paramObject, 0));
      i = 1;
      while (i < Array.getLength(paramObject))
      {
        paramStringBuilder.append(", ").append(Array.get(paramObject, i));
        i += 1;
      }
      paramStringBuilder.append(" ]\n");
      return paramStringBuilder;
    }
    if ((paramObject instanceof String))
    {
      paramStringBuilder.append("\"").append(paramObject).append("\"\n");
      return paramStringBuilder;
    }
    paramStringBuilder.append(paramObject).append("\n");
    return paramStringBuilder;
  }
}