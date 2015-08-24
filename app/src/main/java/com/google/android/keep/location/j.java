package com.google.android.keep.location;

import java.util.List;

public abstract class j<T>
{
  private a<T> sI;

  protected j(a<T> parama)
  {
    sI = parama;
  }

  public void h(List<T> paramList)
  {
    if (sI != null)
      sI.g(paramList);
  }

  public abstract void t(String paramString);

  public static abstract interface a<T>
  {
    public abstract void g(List<T> paramList);
  }
}