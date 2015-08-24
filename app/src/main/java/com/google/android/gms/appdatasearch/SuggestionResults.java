package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Iterator;

public class SuggestionResults
  implements SafeParcelable, Iterable<Result>
{
  public static final zzaf CREATOR = new zzaf();
  final String mErrorMessage;
  final int mVersionCode;
  final String[] zzOp;
  final String[] zzOq;

  SuggestionResults(int paramInt, String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    mVersionCode = paramInt;
    mErrorMessage = paramString;
    zzOp = paramArrayOfString1;
    zzOq = paramArrayOfString2;
  }

  public int describeContents()
  {
    zzaf localzzaf = CREATOR;
    return 0;
  }

  public boolean hasError()
  {
    return mErrorMessage != null;
  }

  public Iterator<Result> iterator()
  {
    if (hasError())
      return null;
    return new ResultIterator();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzaf localzzaf = CREATOR;
    zzaf.zza(this, paramParcel, paramInt);
  }

  public class Result
  {
    private final int zzOl;

    Result(int arg2)
    {
      int i;
      zzOl = i;
    }
  }

  public final class ResultIterator
    implements Iterator<SuggestionResults.Result>
  {
    private int mCurIdx = 0;

    public ResultIterator()
    {
    }

    public boolean hasNext()
    {
      return mCurIdx < zzOp.length;
    }

    public SuggestionResults.Result next()
    {
      SuggestionResults localSuggestionResults = SuggestionResults.this;
      int i = mCurIdx;
      mCurIdx = (i + 1);
      return new SuggestionResults.Result(localSuggestionResults, i);
    }

    public void remove()
    {
      throw new IllegalStateException("remove not supported");
    }
  }
}