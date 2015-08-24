package com.google.android.gallery3d.exif;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

class g
{
  private static final int[] cC = { 0, 1, 2, 3, 4 };
  private final Map<Short, f> cA = new HashMap();
  private int cB = 0;
  private final int cz;

  g(int paramInt)
  {
    cz = paramInt;
  }

  protected static int[] A()
  {
    return cC;
  }

  protected f[] B()
  {
    return (f[])cA.values().toArray(new f[cA.size()]);
  }

  protected int C()
  {
    return cA.size();
  }

  protected f d(f paramf)
  {
    paramf.l(cz);
    return (f)cA.put(Short.valueOf(paramf.u()), paramf);
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject)
      return true;
    if (paramObject == null)
      return false;
    if ((paramObject instanceof g))
    {
      paramObject = (g)paramObject;
      if ((paramObject.getId() == cz) && (paramObject.C() == C()))
      {
        paramObject = paramObject.B();
        int j = paramObject.length;
        int i = 0;
        label57: Object localObject;
        if (i < j)
        {
          localObject = paramObject[i];
          if (!c.a(localObject.u()))
            break label85;
        }
        label85: 
        while (localObject.equals((f)cA.get(Short.valueOf(localObject.u()))))
        {
          i += 1;
          break label57;
          break;
        }
        return false;
      }
    }
    return false;
  }

  protected f f(short paramShort)
  {
    return (f)cA.get(Short.valueOf(paramShort));
  }

  protected int getId()
  {
    return cz;
  }
}