package com.google.api.client.repackaged.com.google.common.base;

public final class Preconditions
{
  public static void checkArgument(boolean paramBoolean)
  {
    if (!paramBoolean)
      throw new IllegalArgumentException();
  }

  public static void checkArgument(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean)
      throw new IllegalArgumentException(String.valueOf(paramObject));
  }

  public static void checkArgument(boolean paramBoolean, String paramString, Object[] paramArrayOfObject)
  {
    if (!paramBoolean)
      throw new IllegalArgumentException(format(paramString, paramArrayOfObject));
  }

  public static <T> T checkNotNull(T paramT)
  {
    if (paramT == null)
      throw new NullPointerException();
    return paramT;
  }

  public static <T> T checkNotNull(T paramT, Object paramObject)
  {
    if (paramT == null)
      throw new NullPointerException(String.valueOf(paramObject));
    return paramT;
  }

  public static <T> T checkNotNull(T paramT, String paramString, Object[] paramArrayOfObject)
  {
    if (paramT == null)
      throw new NullPointerException(format(paramString, paramArrayOfObject));
    return paramT;
  }

  public static void checkState(boolean paramBoolean)
  {
    if (!paramBoolean)
      throw new IllegalStateException();
  }

  public static void checkState(boolean paramBoolean, String paramString, Object[] paramArrayOfObject)
  {
    if (!paramBoolean)
      throw new IllegalStateException(format(paramString, paramArrayOfObject));
  }

  static String format(String paramString, Object[] paramArrayOfObject)
  {
    paramString = String.valueOf(paramString);
    StringBuilder localStringBuilder = new StringBuilder(paramString.length() + paramArrayOfObject.length * 16);
    int j = 0;
    int i = 0;
    while (true)
    {
      int k;
      if (i < paramArrayOfObject.length)
      {
        k = paramString.indexOf("%s", j);
        if (k != -1);
      }
      else
      {
        localStringBuilder.append(paramString.substring(j));
        if (i >= paramArrayOfObject.length)
          break label159;
        localStringBuilder.append(" [");
        localStringBuilder.append(paramArrayOfObject[i]);
        i += 1;
        while (i < paramArrayOfObject.length)
        {
          localStringBuilder.append(", ");
          localStringBuilder.append(paramArrayOfObject[i]);
          i += 1;
        }
      }
      localStringBuilder.append(paramString.substring(j, k));
      localStringBuilder.append(paramArrayOfObject[i]);
      j = k + 2;
      i += 1;
    }
    localStringBuilder.append(']');
    label159: return localStringBuilder.toString();
  }
}