package com.google.common.collect;

final class Hashing
{
  static int smear(int paramInt)
  {
    paramInt ^= paramInt >>> 20 ^ paramInt >>> 12;
    return paramInt >>> 7 ^ paramInt ^ paramInt >>> 4;
  }
}