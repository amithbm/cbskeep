package com.google.common.primitives;

public final class Ints
{
  public static int saturatedCast(long paramLong)
  {
    if (paramLong > 2147483647L)
      return 2147483647;
    if (paramLong < -2147483648L)
      return -2147483648;
    return (int)paramLong;
  }
}