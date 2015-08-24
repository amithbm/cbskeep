package com.google.android.gms.reminders.internal.ref;

import android.text.TextUtils;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.internal.zztk;
import java.util.ArrayList;
import java.util.List;

public class zza extends zzc
{
  protected int zzaja;
  protected final String zzbne;
  private final boolean zzbnf;

  public zza(DataHolder paramDataHolder, int paramInt)
  {
    this(paramDataHolder, paramInt, "");
  }

  public zza(DataHolder paramDataHolder, int paramInt, String paramString)
  {
    super(paramDataHolder, paramInt);
    if (paramString == null);
    for (paramDataHolder = ""; ; paramDataHolder = paramString)
    {
      zzbne = paramDataHolder;
      zzbnf = TextUtils.isEmpty(paramString);
      return;
    }
  }

  protected static String zzT(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
      return paramString2;
    return paramString1 + paramString2;
  }

  protected Double getAsDouble(String paramString)
  {
    if (zzbS(paramString))
      return null;
    return Double.valueOf(getDouble(paramString));
  }

  protected Integer getAsInteger(String paramString)
  {
    if (zzbS(paramString))
      return null;
    return Integer.valueOf(getInteger(paramString));
  }

  protected Long getAsLong(String paramString)
  {
    if (zzbS(paramString))
      return null;
    return Long.valueOf(getLong(paramString));
  }

  @Deprecated
  protected double getDouble(String paramString)
  {
    return super.getDouble(paramString);
  }

  @Deprecated
  protected float getFloat(String paramString)
  {
    return super.getFloat(paramString);
  }

  @Deprecated
  protected int getInteger(String paramString)
  {
    return super.getInteger(paramString);
  }

  @Deprecated
  protected long getLong(String paramString)
  {
    return super.getLong(paramString);
  }

  protected String zzer(String paramString)
  {
    if (zzbnf)
      return paramString;
    return zzbne + paramString;
  }

  protected List<Integer> zzes(String paramString)
  {
    if (zzbS(paramString))
      return new ArrayList(0);
    return zztk.zzep(getString(paramString));
  }

  protected void zzey(int paramInt)
  {
    super.zzey(paramInt);
    zzaja = mDataHolder.zzez(zzaiZ);
  }
}