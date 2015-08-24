package com.android.ex.photo.util;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class InputStreamBuffer
{
  private boolean mAutoAdvance;
  private byte[] mBuffer;
  private int mFilled = 0;
  private InputStream mInputStream;
  private int mOffset = 0;

  public InputStreamBuffer(InputStream paramInputStream, int paramInt, boolean paramBoolean)
  {
    mInputStream = paramInputStream;
    if (paramInt <= 0)
      throw new IllegalArgumentException(String.format("Buffer size %d must be positive.", new Object[] { Integer.valueOf(paramInt) }));
    mBuffer = new byte[leastPowerOf2(paramInt)];
    mAutoAdvance = paramBoolean;
  }

  private boolean fill(int paramInt)
  {
    boolean bool = true;
    Trace.beginSection("fill");
    if (paramInt < mOffset)
    {
      Trace.endSection();
      throw new IllegalStateException(String.format("Index %d is before buffer %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(mOffset) }));
    }
    int j = paramInt - mOffset;
    if (mInputStream == null)
    {
      Trace.endSection();
      return false;
    }
    int k = j + 1;
    int i = j;
    if (k > mBuffer.length)
    {
      if (!mAutoAdvance)
        break label202;
      advanceTo(paramInt);
      i = paramInt - mOffset;
    }
    while (true)
    {
      paramInt = -1;
      try
      {
        j = mInputStream.read(mBuffer, mFilled, mBuffer.length - mFilled);
        paramInt = j;
        label138: if (paramInt != -1)
        {
          mFilled += paramInt;
          label153: if (Log.isLoggable("InputStreamBuffer", 3))
            Log.d("InputStreamBuffer", String.format("fill %d      buffer: %s", new Object[] { Integer.valueOf(i), this }));
          Trace.endSection();
          if (i >= mFilled)
            break label266;
        }
        while (true)
        {
          return bool;
          label202: paramInt = leastPowerOf2(k);
          Log.w("InputStreamBuffer", String.format("Increasing buffer length from %d to %d. Bad buffer size chosen, or advanceTo() not called.", new Object[] { Integer.valueOf(mBuffer.length), Integer.valueOf(paramInt) }));
          mBuffer = Arrays.copyOf(mBuffer, paramInt);
          i = j;
          break;
          mInputStream = null;
          break label153;
          label266: bool = false;
        }
      }
      catch (IOException localIOException)
      {
        break label138;
      }
    }
  }

  private static int leastPowerOf2(int paramInt)
  {
    paramInt -= 1;
    paramInt |= paramInt >> 1;
    paramInt |= paramInt >> 2;
    paramInt |= paramInt >> 4;
    paramInt |= paramInt >> 8;
    return (paramInt | paramInt >> 16) + 1;
  }

  private void shiftToBeginning(int paramInt)
  {
    if (paramInt >= mBuffer.length)
      throw new IndexOutOfBoundsException(String.format("Index %d out of bounds. Length %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(mBuffer.length) }));
    int i = 0;
    while (i + paramInt < mFilled)
    {
      mBuffer[i] = mBuffer[(i + paramInt)];
      i += 1;
    }
  }

  public void advanceTo(int paramInt)
    throws IllegalStateException, IndexOutOfBoundsException
  {
    Trace.beginSection("advance to");
    int i1 = paramInt - mOffset;
    if (i1 <= 0)
    {
      Trace.endSection();
      return;
    }
    if (i1 < mFilled)
    {
      shiftToBeginning(i1);
      mOffset = paramInt;
    }
    for (mFilled -= i1; ; mFilled = 0)
    {
      while (true)
      {
        if (Log.isLoggable("InputStreamBuffer", 3))
          Log.d("InputStreamBuffer", String.format("advanceTo %d buffer: %s", new Object[] { Integer.valueOf(i1), this }));
        Trace.endSection();
        return;
        if (mInputStream != null)
        {
          int i = i1 - mFilled;
          int n = 0;
          int m = 0;
          label114: int j = i;
          int k = n;
          if (i > 0);
          try
          {
            long l = mInputStream.skip(i);
            if (l <= 0L)
            {
              k = m + 1;
              j = i;
            }
            while (true)
            {
              i = j;
              m = k;
              if (k < 5)
                break label114;
              k = 1;
              if (k != 0)
                mInputStream = null;
              mOffset = (paramInt - j);
              mFilled = 0;
              break;
              j = (int)(i - l);
              k = m;
            }
          }
          catch (IOException localIOException)
          {
            while (true)
            {
              k = 1;
              j = i;
            }
          }
        }
      }
      mOffset = paramInt;
    }
  }

  public byte get(int paramInt)
    throws IllegalStateException, IndexOutOfBoundsException
  {
    Trace.beginSection("get");
    if (has(paramInt))
    {
      int i = mOffset;
      Trace.endSection();
      return mBuffer[(paramInt - i)];
    }
    Trace.endSection();
    throw new IndexOutOfBoundsException(String.format("Index %d beyond length.", new Object[] { Integer.valueOf(paramInt) }));
  }

  public boolean has(int paramInt)
    throws IllegalStateException, IndexOutOfBoundsException
  {
    Trace.beginSection("has");
    if (paramInt < mOffset)
    {
      Trace.endSection();
      throw new IllegalStateException(String.format("Index %d is before buffer %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(mOffset) }));
    }
    int i = paramInt - mOffset;
    if ((i >= mFilled) || (i >= mBuffer.length))
    {
      Trace.endSection();
      return fill(paramInt);
    }
    Trace.endSection();
    return true;
  }

  public String toString()
  {
    return String.format("+%d+%d [%d]", new Object[] { Integer.valueOf(mOffset), Integer.valueOf(mBuffer.length), Integer.valueOf(mFilled) });
  }
}