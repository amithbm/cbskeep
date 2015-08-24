package com.google.android.gms.internal;

class zzadt
  implements Cloneable
{
  private static final zzadu zzbJP = new zzadu();
  private int mSize;
  private boolean zzbJQ = false;
  private int[] zzbJR;
  private zzadu[] zzbJS;

  public zzadt()
  {
    this(10);
  }

  public zzadt(int paramInt)
  {
    paramInt = idealIntArraySize(paramInt);
    zzbJR = new int[paramInt];
    zzbJS = new zzadu[paramInt];
    mSize = 0;
  }

  private void gc()
  {
    int m = mSize;
    int[] arrayOfInt = zzbJR;
    zzadu[] arrayOfzzadu = zzbJS;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      zzadu localzzadu = arrayOfzzadu[i];
      k = j;
      if (localzzadu != zzbJP)
      {
        if (i != j)
        {
          arrayOfInt[j] = arrayOfInt[i];
          arrayOfzzadu[j] = localzzadu;
          arrayOfzzadu[i] = null;
        }
        k = j + 1;
      }
      i += 1;
    }
    zzbJQ = false;
    mSize = j;
  }

  private int idealByteArraySize(int paramInt)
  {
    int i = 4;
    while (true)
    {
      int j = paramInt;
      if (i < 32)
      {
        if (paramInt <= (1 << i) - 12)
          j = (1 << i) - 12;
      }
      else
        return j;
      i += 1;
    }
  }

  private int idealIntArraySize(int paramInt)
  {
    return idealByteArraySize(paramInt * 4) / 4;
  }

  private boolean zza(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      if (paramArrayOfInt1[i] != paramArrayOfInt2[i])
        return false;
      i += 1;
    }
    return true;
  }

  private boolean zza(zzadu[] paramArrayOfzzadu1, zzadu[] paramArrayOfzzadu2, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      if (!paramArrayOfzzadu1[i].equals(paramArrayOfzzadu2[i]))
        return false;
      i += 1;
    }
    return true;
  }

  private int zzsl(int paramInt)
  {
    int i = 0;
    int j = mSize - 1;
    while (i <= j)
    {
      int k = i + j >>> 1;
      int m = zzbJR[k];
      if (m < paramInt)
        i = k + 1;
      else if (m > paramInt)
        j = k - 1;
      else
        return k;
    }
    return i ^ 0xFFFFFFFF;
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this);
    do
    {
      return true;
      if (!(paramObject instanceof zzadt))
        return false;
      paramObject = (zzadt)paramObject;
      if (size() != paramObject.size())
        return false;
    }
    while ((zza(zzbJR, paramObject.zzbJR, mSize)) && (zza(zzbJS, paramObject.zzbJS, mSize)));
    return false;
  }

  public int hashCode()
  {
    if (zzbJQ)
      gc();
    int j = 17;
    int i = 0;
    while (i < mSize)
    {
      j = (j * 31 + zzbJR[i]) * 31 + zzbJS[i].hashCode();
      i += 1;
    }
    return j;
  }

  public boolean isEmpty()
  {
    return size() == 0;
  }

  public int size()
  {
    if (zzbJQ)
      gc();
    return mSize;
  }

  public final zzadt zzHG()
  {
    int i = 0;
    int j = size();
    zzadt localzzadt = new zzadt(j);
    System.arraycopy(zzbJR, 0, localzzadt.zzbJR, 0, j);
    while (i < j)
    {
      if (zzbJS[i] != null)
        localzzadt.zzbJS[i] = zzbJS[i].zzHH();
      i += 1;
    }
    localzzadt.mSize = j;
    return localzzadt;
  }

  public void zza(int paramInt, zzadu paramzzadu)
  {
    int i = zzsl(paramInt);
    if (i >= 0)
    {
      zzbJS[i] = paramzzadu;
      return;
    }
    int j = i ^ 0xFFFFFFFF;
    if ((j < mSize) && (zzbJS[j] == zzbJP))
    {
      zzbJR[j] = paramInt;
      zzbJS[j] = paramzzadu;
      return;
    }
    i = j;
    if (zzbJQ)
    {
      i = j;
      if (mSize >= zzbJR.length)
      {
        gc();
        i = zzsl(paramInt) ^ 0xFFFFFFFF;
      }
    }
    if (mSize >= zzbJR.length)
    {
      j = idealIntArraySize(mSize + 1);
      int[] arrayOfInt = new int[j];
      zzadu[] arrayOfzzadu = new zzadu[j];
      System.arraycopy(zzbJR, 0, arrayOfInt, 0, zzbJR.length);
      System.arraycopy(zzbJS, 0, arrayOfzzadu, 0, zzbJS.length);
      zzbJR = arrayOfInt;
      zzbJS = arrayOfzzadu;
    }
    if (mSize - i != 0)
    {
      System.arraycopy(zzbJR, i, zzbJR, i + 1, mSize - i);
      System.arraycopy(zzbJS, i, zzbJS, i + 1, mSize - i);
    }
    zzbJR[i] = paramInt;
    zzbJS[i] = paramzzadu;
    mSize += 1;
  }

  public zzadu zzsj(int paramInt)
  {
    paramInt = zzsl(paramInt);
    if ((paramInt < 0) || (zzbJS[paramInt] == zzbJP))
      return null;
    return zzbJS[paramInt];
  }

  public zzadu zzsk(int paramInt)
  {
    if (zzbJQ)
      gc();
    return zzbJS[paramInt];
  }
}