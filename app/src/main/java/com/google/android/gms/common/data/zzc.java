package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.common.internal.zzv;

public abstract class zzc
{
  protected final DataHolder mDataHolder;
  protected int zzaiZ;
  private int zzaja;

  public zzc(DataHolder paramDataHolder, int paramInt)
  {
    mDataHolder = ((DataHolder)zzv.zzz(paramDataHolder));
    zzey(paramInt);
  }

  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof zzc))
    {
      paramObject = (zzc)paramObject;
      bool1 = bool2;
      if (zzu.equal(Integer.valueOf(paramObject.zzaiZ), Integer.valueOf(zzaiZ)))
      {
        bool1 = bool2;
        if (zzu.equal(Integer.valueOf(paramObject.zzaja), Integer.valueOf(zzaja)))
        {
          bool1 = bool2;
          if (paramObject.mDataHolder == mDataHolder)
            bool1 = true;
        }
      }
    }
    return bool1;
  }

  protected boolean getBoolean(String paramString)
  {
    return mDataHolder.zze(paramString, zzaiZ, zzaja);
  }

  protected byte[] getByteArray(String paramString)
  {
    return mDataHolder.zzh(paramString, zzaiZ, zzaja);
  }

  protected double getDouble(String paramString)
  {
    return mDataHolder.zzg(paramString, zzaiZ, zzaja);
  }

  protected float getFloat(String paramString)
  {
    return mDataHolder.zzf(paramString, zzaiZ, zzaja);
  }

  protected int getInteger(String paramString)
  {
    return mDataHolder.zzc(paramString, zzaiZ, zzaja);
  }

  protected long getLong(String paramString)
  {
    return mDataHolder.zzb(paramString, zzaiZ, zzaja);
  }

  protected String getString(String paramString)
  {
    return mDataHolder.zzd(paramString, zzaiZ, zzaja);
  }

  public int hashCode()
  {
    return zzu.hashCode(new Object[] { Integer.valueOf(zzaiZ), Integer.valueOf(zzaja), mDataHolder });
  }

  public boolean zzbQ(String paramString)
  {
    return mDataHolder.zzbQ(paramString);
  }

  protected boolean zzbS(String paramString)
  {
    return mDataHolder.zzj(paramString, zzaiZ, zzaja);
  }

  protected void zzey(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < mDataHolder.getCount()));
    for (boolean bool = true; ; bool = false)
    {
      zzv.zzR(bool);
      zzaiZ = paramInt;
      zzaja = mDataHolder.zzez(zzaiZ);
      return;
    }
  }
}