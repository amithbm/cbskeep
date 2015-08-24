package com.google.common.math;

final class MathPreconditions
{
  static void checkNoOverflow(boolean paramBoolean)
  {
    if (!paramBoolean)
      throw new ArithmeticException("overflow");
  }
}