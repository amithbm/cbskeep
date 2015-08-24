package com.google.android.keep.browse;

import android.database.Cursor;
import android.support.v4.util.LongSparseArray;
import com.google.android.keep.model.c;
import com.google.common.collect.Maps;
import java.util.Map;

abstract class e<T extends c>
{
  private int a = 0;
  private long[] fW;
  private String[] fX;
  private boolean[] fY;
  private final LongSparseArray<T> fZ = new LongSparseArray();
  private final Map<String, Integer> ga = Maps.newHashMap();
  private final int gb;
  private final int gc;
  private final int gd;
  private final boolean ge;
  private Cursor mCursor = null;

  public e(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    gb = paramInt1;
    gc = paramInt2;
    gd = paramInt3;
    ge = paramBoolean;
  }

  private void initialize()
  {
    int i;
    if (mCursor == null)
    {
      i = 0;
      a = i;
      fW = new long[a];
      fX = new String[a];
      fY = new boolean[a];
      ga.clear();
      if (ge)
        fZ.clear();
      if (mCursor != null)
        break label89;
    }
    while (true)
    {
      return;
      i = mCursor.getCount();
      break;
      label89: i = 0;
      mCursor.moveToPosition(-1);
      while (mCursor.moveToNext())
      {
        fW[i] = mCursor.getLong(gb);
        fX[i] = mCursor.getString(gc);
        ga.put(mCursor.getString(gc), Integer.valueOf(i));
        i += 1;
      }
    }
  }

  public T F(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= a))
      throw new IndexOutOfBoundsException("Access " + paramInt + " but cursor count is " + a);
    long l1 = fW[paramInt];
    c localc = (c)fZ.get(l1);
    if (fY[paramInt] != 0)
      return localc;
    mCursor.moveToPosition(paramInt);
    long l2 = mCursor.getLong(gd);
    if ((localc != null) && (localc.gJ() == l2))
    {
      fY[paramInt] = true;
      return localc;
    }
    localc = c(mCursor);
    fZ.put(l1, localc);
    fY[paramInt] = true;
    return localc;
  }

  public String G(int paramInt)
  {
    return fX[paramInt];
  }

  LongSparseArray<T> bY()
  {
    return fZ;
  }

  protected abstract T c(Cursor paramCursor);

  public void changeCursor(Cursor paramCursor)
  {
    if (mCursor == paramCursor)
      return;
    if (mCursor != null)
      mCursor.close();
    mCursor = paramCursor;
    initialize();
  }

  public int getCount()
  {
    return a;
  }

  public long getItemId(int paramInt)
  {
    return fW[paramInt];
  }

  public int l(String paramString)
  {
    paramString = (Integer)ga.get(paramString);
    if (paramString == null)
      return -1;
    return paramString.intValue();
  }
}