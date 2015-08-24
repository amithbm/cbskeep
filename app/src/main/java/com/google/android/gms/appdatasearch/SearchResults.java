package com.google.android.gms.appdatasearch;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

public class SearchResults
  implements SafeParcelable, Iterable<Result>
{
  public static final zzab CREATOR = new zzab();
  final String mErrorMessage;
  final int mVersionCode;
  final int[] zzNV;
  final byte[] zzNW;
  final Bundle[] zzNX;
  final Bundle[] zzNY;
  final Bundle[] zzNZ;
  final int zzOa;
  final int[] zzOb;
  final String[] zzOc;
  final byte[] zzOd;
  final double[] zzOe;
  final Bundle zzOf;
  final int zzOg;

  SearchResults(int paramInt1, String paramString, int[] paramArrayOfInt1, byte[] paramArrayOfByte1, Bundle[] paramArrayOfBundle1, Bundle[] paramArrayOfBundle2, Bundle[] paramArrayOfBundle3, int paramInt2, int[] paramArrayOfInt2, String[] paramArrayOfString, byte[] paramArrayOfByte2, double[] paramArrayOfDouble, Bundle paramBundle, int paramInt3)
  {
    mVersionCode = paramInt1;
    mErrorMessage = paramString;
    zzNV = paramArrayOfInt1;
    zzNW = paramArrayOfByte1;
    zzNX = paramArrayOfBundle1;
    zzNY = paramArrayOfBundle2;
    zzNZ = paramArrayOfBundle3;
    zzOa = paramInt2;
    zzOb = paramArrayOfInt2;
    zzOc = paramArrayOfString;
    zzOd = paramArrayOfByte2;
    zzOe = paramArrayOfDouble;
    zzOf = paramBundle;
    zzOg = paramInt3;
  }

  public int describeContents()
  {
    zzab localzzab = CREATOR;
    return 0;
  }

  public int getNumResults()
  {
    return zzOa;
  }

  public boolean hasError()
  {
    return mErrorMessage != null;
  }

  public ResultIterator iterator()
  {
    return new ResultIterator();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzab localzzab = CREATOR;
    zzab.zza(this, paramParcel, paramInt);
  }

  public class Result
  {
    private final SearchResults.ResultIterator zzOk;
    private final int zzOl;

    Result(int paramResultIterator, SearchResults.ResultIterator arg3)
    {
      Object localObject;
      zzOk = localObject;
      zzOl = paramResultIterator;
    }
  }

  public class ResultIterator
    implements Iterator<SearchResults.Result>
  {
    protected int mCurIdx;
    private final Map<String, Object>[] zzOo;

    ResultIterator()
    {
      if (hasError());
      for (this$1 = null; ; this$1 = new Map[zzOc.length])
      {
        zzOo = SearchResults.this;
        return;
      }
    }

    public boolean hasNext()
    {
      return (!hasError()) && (mCurIdx < getNumResults());
    }

    protected void moveToNext()
    {
      mCurIdx += 1;
    }

    public SearchResults.Result next()
    {
      if (!hasNext())
        throw new NoSuchElementException("No more results.");
      SearchResults.Result localResult = new SearchResults.Result(SearchResults.this, mCurIdx, this);
      moveToNext();
      return localResult;
    }

    public void remove()
    {
      throw new IllegalStateException("remove not supported");
    }
  }
}