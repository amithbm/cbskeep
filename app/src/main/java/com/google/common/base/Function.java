package com.google.common.base;

public abstract interface Function<F, T>
{
  public abstract T apply(F paramF);
}