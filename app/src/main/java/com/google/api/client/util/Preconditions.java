package com.google.api.client.util;

public final class Preconditions
{
  public static void checkArgument(boolean paramBoolean)
  {
    com.google.api.client.repackaged.com.google.common.base.Preconditions.checkArgument(paramBoolean);
  }

  public static void checkArgument(boolean paramBoolean, Object paramObject)
  {
    com.google.api.client.repackaged.com.google.common.base.Preconditions.checkArgument(paramBoolean, paramObject);
  }

  public static void checkArgument(boolean paramBoolean, String paramString, Object[] paramArrayOfObject)
  {
    com.google.api.client.repackaged.com.google.common.base.Preconditions.checkArgument(paramBoolean, paramString, paramArrayOfObject);
  }

  public static <T> T checkNotNull(T paramT)
  {
    return com.google.api.client.repackaged.com.google.common.base.Preconditions.checkNotNull(paramT);
  }

  public static <T> T checkNotNull(T paramT, Object paramObject)
  {
    return com.google.api.client.repackaged.com.google.common.base.Preconditions.checkNotNull(paramT, paramObject);
  }

  public static <T> T checkNotNull(T paramT, String paramString, Object[] paramArrayOfObject)
  {
    return com.google.api.client.repackaged.com.google.common.base.Preconditions.checkNotNull(paramT, paramString, paramArrayOfObject);
  }

  public static void checkState(boolean paramBoolean)
  {
    com.google.api.client.repackaged.com.google.common.base.Preconditions.checkState(paramBoolean);
  }

  public static void checkState(boolean paramBoolean, String paramString, Object[] paramArrayOfObject)
  {
    com.google.api.client.repackaged.com.google.common.base.Preconditions.checkState(paramBoolean, paramString, paramArrayOfObject);
  }
}