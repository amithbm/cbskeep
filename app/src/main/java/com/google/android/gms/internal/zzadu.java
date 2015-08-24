package com.google.android.gms.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class zzadu
  implements Cloneable
{
  private zzadr<?, ?> zzbJT;
  private Object zzbJU;
  private List<zzadz> zzbJV = new ArrayList();

  private byte[] toByteArray()
    throws IOException
  {
    byte[] arrayOfByte = new byte[zzB()];
    zza(zzadp.zzR(arrayOfByte));
    return arrayOfByte;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramObject == this)
      bool1 = true;
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      }
      while (!(paramObject instanceof zzadu));
      paramObject = (zzadu)paramObject;
      if ((zzbJU == null) || (paramObject.zzbJU == null))
        break;
      bool1 = bool2;
    }
    while (zzbJT != paramObject.zzbJT);
    if (!zzbJT.zzbJN.isArray())
      return zzbJU.equals(paramObject.zzbJU);
    if ((zzbJU instanceof byte[]))
      return Arrays.equals((byte[])zzbJU, (byte[])paramObject.zzbJU);
    if ((zzbJU instanceof int[]))
      return Arrays.equals((int[])zzbJU, (int[])paramObject.zzbJU);
    if ((zzbJU instanceof long[]))
      return Arrays.equals((long[])zzbJU, (long[])paramObject.zzbJU);
    if ((zzbJU instanceof float[]))
      return Arrays.equals((float[])zzbJU, (float[])paramObject.zzbJU);
    if ((zzbJU instanceof double[]))
      return Arrays.equals((double[])zzbJU, (double[])paramObject.zzbJU);
    if ((zzbJU instanceof boolean[]))
      return Arrays.equals((boolean[])zzbJU, (boolean[])paramObject.zzbJU);
    return Arrays.deepEquals((Object[])zzbJU, (Object[])paramObject.zzbJU);
    if ((zzbJV != null) && (paramObject.zzbJV != null))
      return zzbJV.equals(paramObject.zzbJV);
    try
    {
      bool1 = Arrays.equals(toByteArray(), paramObject.toByteArray());
      return bool1;
    }
    catch (IOException paramObject)
    {
    }
    throw new IllegalStateException(paramObject);
  }

  public int hashCode()
  {
    try
    {
      int i = Arrays.hashCode(toByteArray());
      return i + 527;
    }
    catch (IOException localIOException)
    {
      throw new IllegalStateException(localIOException);
    }
  }

  int zzB()
  {
    int j;
    if (zzbJU != null)
    {
      j = zzbJT.zzab(zzbJU);
      return j;
    }
    Iterator localIterator = zzbJV.iterator();
    for (int i = 0; ; i = ((zzadz)localIterator.next()).zzB() + i)
    {
      j = i;
      if (!localIterator.hasNext())
        break;
    }
  }

  public final zzadu zzHH()
  {
    int i = 0;
    zzadu localzzadu = new zzadu();
    try
    {
      localzzadu.zzbJT = zzbJT;
      if (zzbJV == null)
        localzzadu.zzbJV = null;
      while (zzbJU == null)
      {
        return localzzadu;
        localzzadu.zzbJV.addAll(zzbJV);
      }
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError(localCloneNotSupportedException);
    }
    if ((zzbJU instanceof zzadx))
    {
      localCloneNotSupportedException.zzbJU = ((zzadx)zzbJU).zzHF();
      return localCloneNotSupportedException;
    }
    if ((zzbJU instanceof byte[]))
    {
      localCloneNotSupportedException.zzbJU = ((byte[])zzbJU).clone();
      return localCloneNotSupportedException;
    }
    Object localObject1;
    Object localObject2;
    if ((zzbJU instanceof byte[][]))
    {
      localObject1 = (byte[][])zzbJU;
      localObject2 = new byte[localObject1.length][];
      localCloneNotSupportedException.zzbJU = localObject2;
      i = 0;
      while (i < localObject1.length)
      {
        localObject2[i] = ((byte[])localObject1[i].clone());
        i += 1;
      }
    }
    if ((zzbJU instanceof boolean[]))
    {
      localCloneNotSupportedException.zzbJU = ((boolean[])zzbJU).clone();
      return localCloneNotSupportedException;
    }
    if ((zzbJU instanceof int[]))
    {
      localCloneNotSupportedException.zzbJU = ((int[])zzbJU).clone();
      return localCloneNotSupportedException;
    }
    if ((zzbJU instanceof long[]))
    {
      localCloneNotSupportedException.zzbJU = ((long[])zzbJU).clone();
      return localCloneNotSupportedException;
    }
    if ((zzbJU instanceof float[]))
    {
      localCloneNotSupportedException.zzbJU = ((float[])zzbJU).clone();
      return localCloneNotSupportedException;
    }
    if ((zzbJU instanceof double[]))
    {
      localCloneNotSupportedException.zzbJU = ((double[])zzbJU).clone();
      return localCloneNotSupportedException;
    }
    if ((zzbJU instanceof zzadx[]))
    {
      localObject1 = (zzadx[])zzbJU;
      localObject2 = new zzadx[localObject1.length];
      localCloneNotSupportedException.zzbJU = localObject2;
      while (i < localObject1.length)
      {
        localObject2[i] = localObject1[i].zzHF();
        i += 1;
      }
    }
    return localCloneNotSupportedException;
  }

  void zza(zzadp paramzzadp)
    throws IOException
  {
    if (zzbJU != null)
      zzbJT.zza(zzbJU, paramzzadp);
    while (true)
    {
      return;
      Iterator localIterator = zzbJV.iterator();
      while (localIterator.hasNext())
        ((zzadz)localIterator.next()).zza(paramzzadp);
    }
  }

  void zza(zzadz paramzzadz)
  {
    zzbJV.add(paramzzadz);
  }
}