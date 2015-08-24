package com.google.android.gms.internal;

public abstract class zzlk<T>
{
  private static zza zzaiP = null;
  private static int zzaiQ = 0;
  private static String zzaiR = "com.google.android.providers.gsf.permission.READ_GSERVICES";
  private static final Object zzpB = new Object();
  private T zzLy = null;
  protected final String zzua;
  protected final T zzub;

  protected zzlk(String paramString, T paramT)
  {
    zzua = paramString;
    zzub = paramT;
  }

  public static boolean isInitialized()
  {
    return zzaiP != null;
  }

  public static zzlk<Integer> zza(String paramString, Integer paramInteger)
  {
    return new zzlk(paramString, paramInteger)
    {
      protected Integer zzbN(String paramAnonymousString)
      {
        return zzlk.zzpd().zzb(zzua, (Integer)zzub);
      }
    };
  }

  public static zzlk<Long> zza(String paramString, Long paramLong)
  {
    return new zzlk(paramString, paramLong)
    {
      protected Long zzbM(String paramAnonymousString)
      {
        return zzlk.zzpd().getLong(zzua, (Long)zzub);
      }
    };
  }

  public static zzlk<Boolean> zzi(String paramString, boolean paramBoolean)
  {
    return new zzlk(paramString, Boolean.valueOf(paramBoolean))
    {
      protected Boolean zzbL(String paramAnonymousString)
      {
        return zzlk.zzpd().zzb(zzua, (Boolean)zzub);
      }
    };
  }

  public static int zzpa()
  {
    return zzaiQ;
  }

  public static zzlk<String> zzz(String paramString1, String paramString2)
  {
    return new zzlk(paramString1, paramString2)
    {
      protected String zzbP(String paramAnonymousString)
      {
        return zzlk.zzpd().getString(zzua, (String)zzub);
      }
    };
  }

  public final T get()
  {
    if (zzLy != null)
      return zzLy;
    return zzbK(zzua);
  }

  protected abstract T zzbK(String paramString);

  private static abstract interface zza
  {
    public abstract Long getLong(String paramString, Long paramLong);

    public abstract String getString(String paramString1, String paramString2);

    public abstract Boolean zzb(String paramString, Boolean paramBoolean);

    public abstract Integer zzb(String paramString, Integer paramInteger);
  }
}