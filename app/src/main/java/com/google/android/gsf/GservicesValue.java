package com.google.android.gsf;

import android.content.ContentResolver;
import android.content.Context;

public abstract class GservicesValue<T>
{
  private static ContentResolver sContentResolver = null;
  protected final T mDefaultValue;
  protected final String mKey;

  protected GservicesValue(String paramString, T paramT)
  {
    mKey = paramString;
    mDefaultValue = paramT;
  }

  public static void init(Context paramContext)
  {
    sContentResolver = paramContext.getContentResolver();
  }

  public static GservicesValue<Float> value(String paramString, Float paramFloat)
  {
    return new GservicesValue(paramString, paramFloat)
    {
      protected Float retrieve(String paramAnonymousString)
      {
        return Float.valueOf(Gservices.getFloat(GservicesValue.sContentResolver, mKey, ((Float)mDefaultValue).floatValue()));
      }
    };
  }

  public static GservicesValue<Integer> value(String paramString, Integer paramInteger)
  {
    return new GservicesValue(paramString, paramInteger)
    {
      protected Integer retrieve(String paramAnonymousString)
      {
        return Integer.valueOf(Gservices.getInt(GservicesValue.sContentResolver, mKey, ((Integer)mDefaultValue).intValue()));
      }
    };
  }

  public static GservicesValue<Long> value(String paramString, Long paramLong)
  {
    return new GservicesValue(paramString, paramLong)
    {
      protected Long retrieve(String paramAnonymousString)
      {
        return Long.valueOf(Gservices.getLong(GservicesValue.sContentResolver, mKey, ((Long)mDefaultValue).longValue()));
      }
    };
  }

  public static GservicesValue<String> value(String paramString1, String paramString2)
  {
    return new GservicesValue(paramString1, paramString2)
    {
      protected String retrieve(String paramAnonymousString)
      {
        return Gservices.getString(GservicesValue.sContentResolver, mKey, (String)mDefaultValue);
      }
    };
  }

  public static GservicesValue<Boolean> value(String paramString, boolean paramBoolean)
  {
    return new GservicesValue(paramString, Boolean.valueOf(paramBoolean))
    {
      protected Boolean retrieve(String paramAnonymousString)
      {
        return Boolean.valueOf(Gservices.getBoolean(GservicesValue.sContentResolver, mKey, ((Boolean)mDefaultValue).booleanValue()));
      }
    };
  }

  public final T get()
  {
    return retrieve(mKey);
  }

  protected abstract T retrieve(String paramString);
}