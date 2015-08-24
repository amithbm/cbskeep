package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public abstract class zze
{
  public static final zze zzakC = zza("\t\n\013\f\r     　 ᠎ ").zza(zza(' ', ' '));
  public static final zze zzakD = zza("\t\n\013\f\r     　").zza(zza(' ', ' ')).zza(zza(' ', ' '));
  public static final zze zzakE = zza('\000', '');
  public static final zze zzakF = localzze;
  public static final zze zzakG = zza('\t', '\r').zza(zza('\034', ' ')).zza(zzb(' ')).zza(zzb('᠎')).zza(zza(' ', ' ')).zza(zza(' ', '​')).zza(zza(' ', ' ')).zza(zzb(' ')).zza(zzb('　'));
  public static final zze zzakH = new zze()
  {
    public boolean zzc(char paramAnonymousChar)
    {
      return Character.isDigit(paramAnonymousChar);
    }
  };
  public static final zze zzakI = new zze()
  {
    public boolean zzc(char paramAnonymousChar)
    {
      return Character.isLetter(paramAnonymousChar);
    }
  };
  public static final zze zzakJ = new zze()
  {
    public boolean zzc(char paramAnonymousChar)
    {
      return Character.isLetterOrDigit(paramAnonymousChar);
    }
  };
  public static final zze zzakK = new zze()
  {
    public boolean zzc(char paramAnonymousChar)
    {
      return Character.isUpperCase(paramAnonymousChar);
    }
  };
  public static final zze zzakL = new zze()
  {
    public boolean zzc(char paramAnonymousChar)
    {
      return Character.isLowerCase(paramAnonymousChar);
    }
  };
  public static final zze zzakM = zza('\000', '\037').zza(zza('', ''));
  public static final zze zzakN = zza('\000', ' ').zza(zza('', ' ')).zza(zzb('­')).zza(zza('؀', '؃')).zza(zza("۝܏ ឴឵᠎")).zza(zza(' ', '‏')).zza(zza(' ', ' ')).zza(zza(' ', '⁤')).zza(zza('⁪', '⁯')).zza(zzb('　')).zza(zza(55296, 63743)).zza(zza("﻿￹￺￻"));
  public static final zze zzakO = zza('\000', 'ӹ').zza(zzb('־')).zza(zza('א', 'ת')).zza(zzb('׳')).zza(zzb('״')).zza(zza('؀', 'ۿ')).zza(zza('ݐ', 'ݿ')).zza(zza('฀', '๿')).zza(zza('Ḁ', '₯')).zza(zza('℀', '℺')).zza(zza(64336, 65023)).zza(zza(65136, 65279)).zza(zza(65377, 65500));
  public static final zze zzakP = new zze()
  {
    public zze zza(zze paramAnonymouszze)
    {
      zzv.zzz(paramAnonymouszze);
      return this;
    }

    public boolean zzb(CharSequence paramAnonymousCharSequence)
    {
      zzv.zzz(paramAnonymousCharSequence);
      return true;
    }

    public boolean zzc(char paramAnonymousChar)
    {
      return true;
    }
  };
  public static final zze zzakQ = new zze()
  {
    public zze zza(zze paramAnonymouszze)
    {
      return (zze)zzv.zzz(paramAnonymouszze);
    }

    public boolean zzb(CharSequence paramAnonymousCharSequence)
    {
      return paramAnonymousCharSequence.length() == 0;
    }

    public boolean zzc(char paramAnonymousChar)
    {
      return false;
    }
  };

  static
  {
    zze localzze = zza('0', '9');
    char[] arrayOfChar = "٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".toCharArray();
    int j = arrayOfChar.length;
    int i = 0;
    while (i < j)
    {
      char c = arrayOfChar[i];
      localzze = localzze.zza(zza(c, (char)(c + '\t')));
      i += 1;
    }
  }

  public static zze zza(char paramChar1, final char paramChar2)
  {
    if (paramChar2 >= paramChar1);
    for (boolean bool = true; ; bool = false)
    {
      zzv.zzS(bool);
      return new zze()
      {
        public boolean zzc(char paramAnonymousChar)
        {
          return (zzakU <= paramAnonymousChar) && (paramAnonymousChar <= paramChar2);
        }
      };
    }
  }

  public static zze zza(CharSequence paramCharSequence)
  {
    switch (paramCharSequence.length())
    {
    default:
      paramCharSequence = paramCharSequence.toString().toCharArray();
      Arrays.sort(paramCharSequence);
      return new zze()
      {
        public boolean zzc(char paramAnonymousChar)
        {
          return Arrays.binarySearch(zzakT, paramAnonymousChar) >= 0;
        }
      };
    case 0:
      return zzakQ;
    case 1:
      return zzb(paramCharSequence.charAt(0));
    case 2:
    }
    return new zze()
    {
      public boolean zzc(char paramAnonymousChar)
      {
        return (paramAnonymousChar == zzakR) || (paramAnonymousChar == zzakS);
      }
    };
  }

  public static zze zzb(char paramChar)
  {
    return new zze()
    {
      public zze zza(zze paramAnonymouszze)
      {
        if (paramAnonymouszze.zzc(zzakW))
          return paramAnonymouszze;
        return super.zza(paramAnonymouszze);
      }

      public boolean zzc(char paramAnonymousChar)
      {
        return paramAnonymousChar == zzakW;
      }
    };
  }

  public zze zza(zze paramzze)
  {
    return new zza(Arrays.asList(new zze[] { this, (zze)zzv.zzz(paramzze) }));
  }

  public boolean zzb(CharSequence paramCharSequence)
  {
    int i = paramCharSequence.length() - 1;
    while (i >= 0)
    {
      if (!zzc(paramCharSequence.charAt(i)))
        return false;
      i -= 1;
    }
    return true;
  }

  public abstract boolean zzc(char paramChar);

  private static class zza extends zze
  {
    List<zze> zzakX;

    zza(List<zze> paramList)
    {
      zzakX = paramList;
    }

    public zze zza(zze paramzze)
    {
      ArrayList localArrayList = new ArrayList(zzakX);
      localArrayList.add(zzv.zzz(paramzze));
      return new zza(localArrayList);
    }

    public boolean zzc(char paramChar)
    {
      Iterator localIterator = zzakX.iterator();
      while (localIterator.hasNext())
        if (((zze)localIterator.next()).zzc(paramChar))
          return true;
      return false;
    }
  }
}