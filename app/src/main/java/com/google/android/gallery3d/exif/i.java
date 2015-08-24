package com.google.android.gallery3d.exif;

public class i
{
  private final long cD;
  private final long cE;

  public i(long paramLong1, long paramLong2)
  {
    cD = paramLong1;
    cE = paramLong2;
  }

  public long D()
  {
    return cD;
  }

  public long E()
  {
    return cE;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == null);
    do
    {
      return false;
      if (this == paramObject)
        return true;
    }
    while (!(paramObject instanceof i));
    paramObject = (i)paramObject;
    if ((cD == paramObject.cD) && (cE == paramObject.cE));
    while (true)
    {
      return bool;
      bool = false;
    }
  }

  public String toString()
  {
    return cD + "/" + cE;
  }
}