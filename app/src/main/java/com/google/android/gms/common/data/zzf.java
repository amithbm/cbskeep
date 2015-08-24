package com.google.android.gms.common.data;

import java.util.ArrayList;

public abstract class zzf<T> extends AbstractDataBuffer<T>
{
  private boolean zzajr = false;
  private ArrayList<Integer> zzajs;

  protected zzf(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }

  private void zzpl()
  {
    while (true)
    {
      int i;
      String str2;
      try
      {
        if (zzajr)
          break label193;
        int j = mDataHolder.getCount();
        zzajs = new ArrayList();
        if (j <= 0)
          break label188;
        zzajs.add(Integer.valueOf(0));
        String str3 = zzpk();
        i = mDataHolder.zzez(0);
        String str1 = mDataHolder.zzd(str3, 0, i);
        i = 1;
        if (i >= j)
          break label188;
        int k = mDataHolder.zzez(i);
        str2 = mDataHolder.zzd(str3, i, k);
        if (str2 == null)
          throw new NullPointerException("Missing value for markerColumn: " + str3 + ", at row: " + i + ", for window: " + k);
      }
      finally
      {
      }
      if (!str2.equals(localObject1))
      {
        zzajs.add(Integer.valueOf(i));
        Object localObject2 = str2;
        break label196;
        label188: zzajr = true;
        label193: return;
      }
      label196: i += 1;
    }
  }

  public final T get(int paramInt)
  {
    zzpl();
    return zzv(zzeC(paramInt), zzeD(paramInt));
  }

  public int getCount()
  {
    zzpl();
    return zzajs.size();
  }

  int zzeC(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= zzajs.size()))
      throw new IllegalArgumentException("Position " + paramInt + " is out of bounds for this buffer");
    return ((Integer)zzajs.get(paramInt)).intValue();
  }

  protected int zzeD(int paramInt)
  {
    int j;
    if ((paramInt < 0) || (paramInt == zzajs.size()))
    {
      j = 0;
      return j;
    }
    if (paramInt == zzajs.size() - 1);
    for (int i = mDataHolder.getCount() - ((Integer)zzajs.get(paramInt)).intValue(); ; i = ((Integer)zzajs.get(paramInt + 1)).intValue() - ((Integer)zzajs.get(paramInt)).intValue())
    {
      j = i;
      if (i != 1)
        break;
      paramInt = zzeC(paramInt);
      int k = mDataHolder.zzez(paramInt);
      String str = zzpm();
      j = i;
      if (str == null)
        break;
      j = i;
      if (mDataHolder.zzd(str, paramInt, k) != null)
        break;
      return 0;
    }
  }

  protected abstract String zzpk();

  protected String zzpm()
  {
    return null;
  }

  protected abstract T zzv(int paramInt1, int paramInt2);
}