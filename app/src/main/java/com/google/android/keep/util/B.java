package com.google.android.keep.util;

import android.util.Patterns;
import com.google.android.gsf.GservicesValue;
import com.google.android.keep.model.Sharee;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class B
{
  public static boolean bL(String paramString)
  {
    return !Patterns.EMAIL_ADDRESS.matcher(paramString).matches();
  }

  public static List<Sharee> c(Collection<Sharee> paramCollection)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramCollection != null)
    {
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        Sharee localSharee = (Sharee)paramCollection.next();
        if (bL(localSharee.getEmail()))
          localArrayList.add(localSharee);
      }
    }
    return localArrayList;
  }

  public static boolean k(long paramLong1, long paramLong2)
  {
    return (paramLong1 > paramLong2) && (System.currentTimeMillis() - paramLong2 > ((Long)Config.Pa.get()).longValue());
  }
}