package com.google.protobuf.nano;

class FieldArray
{
  private static final FieldData DELETED = new FieldData();
  private FieldData[] mData;
  private int[] mFieldNumbers;
  private boolean mGarbage = false;
  private int mSize;

  public FieldArray()
  {
    this(10);
  }

  public FieldArray(int paramInt)
  {
    paramInt = idealIntArraySize(paramInt);
    mFieldNumbers = new int[paramInt];
    mData = new FieldData[paramInt];
    mSize = 0;
  }

  private boolean arrayEquals(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      if (paramArrayOfInt1[i] != paramArrayOfInt2[i])
        return false;
      i += 1;
    }
    return true;
  }

  private boolean arrayEquals(FieldData[] paramArrayOfFieldData1, FieldData[] paramArrayOfFieldData2, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      if (!paramArrayOfFieldData1[i].equals(paramArrayOfFieldData2[i]))
        return false;
      i += 1;
    }
    return true;
  }

  private int binarySearch(int paramInt)
  {
    int i = 0;
    int j = mSize - 1;
    while (i <= j)
    {
      int k = i + j >>> 1;
      int m = mFieldNumbers[k];
      if (m < paramInt)
      {
        i = k + 1;
      }
      else
      {
        j = k;
        if (m <= paramInt)
          break label65;
        j = k - 1;
      }
    }
    j = i ^ 0xFFFFFFFF;
    label65: return j;
  }

  private void gc()
  {
    int m = mSize;
    int j = 0;
    int[] arrayOfInt = mFieldNumbers;
    FieldData[] arrayOfFieldData = mData;
    int i = 0;
    while (i < m)
    {
      FieldData localFieldData = arrayOfFieldData[i];
      int k = j;
      if (localFieldData != DELETED)
      {
        if (i != j)
        {
          arrayOfInt[j] = arrayOfInt[i];
          arrayOfFieldData[j] = localFieldData;
          arrayOfFieldData[i] = null;
        }
        k = j + 1;
      }
      i += 1;
      j = k;
    }
    mGarbage = false;
    mSize = j;
  }

  private int idealByteArraySize(int paramInt)
  {
    int i = 4;
    while (true)
    {
      int j = paramInt;
      if (i < 32)
      {
        if (paramInt <= (1 << i) - 12)
          j = (1 << i) - 12;
      }
      else
        return j;
      i += 1;
    }
  }

  private int idealIntArraySize(int paramInt)
  {
    return idealByteArraySize(paramInt * 4) / 4;
  }

  public FieldData dataAt(int paramInt)
  {
    if (mGarbage)
      gc();
    return mData[paramInt];
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this);
    do
    {
      return true;
      if (!(paramObject instanceof FieldArray))
        return false;
      paramObject = (FieldArray)paramObject;
      if (size() != paramObject.size())
        return false;
    }
    while ((arrayEquals(mFieldNumbers, paramObject.mFieldNumbers, mSize)) && (arrayEquals(mData, paramObject.mData, mSize)));
    return false;
  }

  public FieldData get(int paramInt)
  {
    paramInt = binarySearch(paramInt);
    if ((paramInt < 0) || (mData[paramInt] == DELETED))
      return null;
    return mData[paramInt];
  }

  public int hashCode()
  {
    if (mGarbage)
      gc();
    int j = 17;
    int i = 0;
    while (i < mSize)
    {
      j = (j * 31 + mFieldNumbers[i]) * 31 + mData[i].hashCode();
      i += 1;
    }
    return j;
  }

  public void put(int paramInt, FieldData paramFieldData)
  {
    int i = binarySearch(paramInt);
    if (i >= 0)
    {
      mData[i] = paramFieldData;
      return;
    }
    int j = i ^ 0xFFFFFFFF;
    if ((j < mSize) && (mData[j] == DELETED))
    {
      mFieldNumbers[j] = paramInt;
      mData[j] = paramFieldData;
      return;
    }
    i = j;
    if (mGarbage)
    {
      i = j;
      if (mSize >= mFieldNumbers.length)
      {
        gc();
        i = binarySearch(paramInt) ^ 0xFFFFFFFF;
      }
    }
    if (mSize >= mFieldNumbers.length)
    {
      j = idealIntArraySize(mSize + 1);
      int[] arrayOfInt = new int[j];
      FieldData[] arrayOfFieldData = new FieldData[j];
      System.arraycopy(mFieldNumbers, 0, arrayOfInt, 0, mFieldNumbers.length);
      System.arraycopy(mData, 0, arrayOfFieldData, 0, mData.length);
      mFieldNumbers = arrayOfInt;
      mData = arrayOfFieldData;
    }
    if (mSize - i != 0)
    {
      System.arraycopy(mFieldNumbers, i, mFieldNumbers, i + 1, mSize - i);
      System.arraycopy(mData, i, mData, i + 1, mSize - i);
    }
    mFieldNumbers[i] = paramInt;
    mData[i] = paramFieldData;
    mSize += 1;
  }

  public int size()
  {
    if (mGarbage)
      gc();
    return mSize;
  }
}