package com.google.android.keep.browse;

import android.database.Cursor;
import android.text.TextUtils;
import com.google.android.keep.model.c;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public abstract class PositionMap<T extends c>
{
  private int a = 0;
  private final e<T> ik;
  private List<a<T>> il = Lists.newArrayList();
  private ArrayList<Integer> im = Lists.newArrayList();
  private ArrayList<Boolean> in = Lists.newArrayList();

  public PositionMap(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    ik = new e(paramInt1, paramInt2, paramInt3, paramBoolean)
    {
      protected T c(Cursor paramAnonymousCursor)
      {
        return PositionMap.this.c(paramAnonymousCursor);
      }
    };
    ik.changeCursor(null);
  }

  private String G(int paramInt)
  {
    int i = ((Integer)im.get(paramInt)).intValue();
    if (((Boolean)in.get(paramInt)).booleanValue())
      return a.a((a)il.get(i)).gu();
    return ik.G(i);
  }

  private int U(int paramInt)
  {
    a locala = (a)il.get(paramInt);
    int i;
    String str;
    int j;
    if (a.b(locala) == LinkDirection.ip)
    {
      i = 1;
      str = a.c(locala);
      j = im.size();
      if (a.d(locala) >= j)
        break label70;
      j = a.d(locala);
      label58: if (str != null)
        break label73;
    }
    while (true)
    {
      return j;
      i = 0;
      break;
      label70: break label58;
      label73: int m = ik.l(str);
      int k;
      if (m >= 0)
      {
        k = 0;
        while (k <= paramInt)
        {
          int n = m + k;
          if ((n < im.size()) && (TextUtils.equals(str, G(n))))
            return n + i;
          k += 1;
        }
      }
      else
      {
        k = 0;
        while (k < paramInt)
        {
          locala = (a)il.get(k);
          if (a.a(locala).gu().equals(str))
            return a.d(locala) + i;
          k += 1;
        }
      }
    }
  }

  private void cy()
  {
    Iterator localIterator = il.iterator();
    while (localIterator.hasNext())
    {
      c localc = a.a((a)localIterator.next());
      if (ik.l(localc.gu()) >= 0)
        localIterator.remove();
    }
  }

  private void cz()
  {
    int i = 0;
    while (i < il.size())
    {
      int j = U(i);
      im.add(j, Integer.valueOf(i));
      in.add(j, Boolean.valueOf(true));
      a.a((a)il.get(i), j);
      i += 1;
    }
  }

  private void initialize()
  {
    cy();
    a = (ik.getCount() + il.size());
    im.clear();
    in.clear();
    im.ensureCapacity(a);
    in.ensureCapacity(a);
    int i = 0;
    while (i < ik.getCount())
    {
      im.add(Integer.valueOf(i));
      in.add(Boolean.valueOf(false));
      i += 1;
    }
    cz();
  }

  public T F(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= a))
      throw new IndexOutOfBoundsException("Access " + paramInt + " but count is " + a);
    int i = ((Integer)im.get(paramInt)).intValue();
    if (((Boolean)in.get(paramInt)).booleanValue())
      return a.a((a)il.get(i));
    return ik.F(i);
  }

  public void a(T paramT, int paramInt, LinkDirection paramLinkDirection)
  {
    if (paramLinkDirection == LinkDirection.ip)
    {
      if (paramInt <= 0);
      for (str = null; ; str = G(paramInt - 1))
      {
        il.add(new a(paramT, paramLinkDirection, str, paramInt, null));
        int i = il.size();
        im.add(paramInt, Integer.valueOf(i - 1));
        in.add(paramInt, Boolean.valueOf(true));
        a += 1;
        return;
      }
    }
    if (paramInt >= a);
    for (String str = null; ; str = G(paramInt))
      break;
  }

  protected abstract T c(Cursor paramCursor);

  public void changeCursor(Cursor paramCursor)
  {
    ik.changeCursor(paramCursor);
    initialize();
  }

  public void e(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt == null)
      return;
    Arrays.sort(paramArrayOfInt);
    int j = 0;
    int i = 0;
    if (i < a)
    {
      int k;
      if ((j < paramArrayOfInt.length) && (paramArrayOfInt[j] == i))
        k = j + 1;
      while (true)
      {
        i += 1;
        j = k;
        break;
        k = j;
        if (j > 0)
        {
          k = i - j;
          im.set(k, im.get(i));
          in.set(k, in.get(i));
          k = j;
        }
      }
    }
    a -= j;
  }

  public int getCount()
  {
    return a;
  }

  public long getItemId(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= a))
      throw new IndexOutOfBoundsException("Access " + paramInt + " but count is " + a);
    int i = ((Integer)im.get(paramInt)).intValue();
    if (((Boolean)in.get(paramInt)).booleanValue())
      return a.e((a)il.get(i));
    return ik.getItemId(i);
  }

  public void j(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 >= a) || (paramInt2 < 0) || (paramInt2 >= a) || (paramInt1 == paramInt2))
      return;
    if (paramInt1 < paramInt2);
    int j;
    for (int i = 1; ; i = -1)
    {
      j = ((Integer)im.get(paramInt1)).intValue();
      while (paramInt1 != paramInt2)
      {
        im.set(paramInt1, im.get(paramInt1 + i));
        paramInt1 += i;
      }
    }
    im.set(paramInt2, Integer.valueOf(j));
  }

  public static enum LinkDirection
  {
  }

  private static final class a<T extends c>
  {
    private static volatile long is = 0L;
    private final T it;
    private final PositionMap.LinkDirection iu;
    private final String iv;
    private final long mId;
    private int mPosition;

    private a(T paramT, PositionMap.LinkDirection paramLinkDirection, String paramString, int paramInt)
    {
      is -= 1L;
      mId = is;
      it = paramT;
      iu = paramLinkDirection;
      iv = paramString;
      mPosition = paramInt;
    }
  }
}