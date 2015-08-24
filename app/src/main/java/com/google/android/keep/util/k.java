package com.google.android.keep.util;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public abstract class k<R extends Result> extends AsyncTaskLoader<R>
{
  private R PB;
  private long PC = -1L;
  private final GoogleApiClient cV;

  public k(Context paramContext, GoogleApiClient paramGoogleApiClient)
  {
    super(paramContext);
    cV = paramGoogleApiClient;
  }

  protected abstract PendingResult<R> a(GoogleApiClient paramGoogleApiClient);

  public void a(long paramLong, TimeUnit paramTimeUnit)
  {
    if (!isReset())
      throw new IllegalStateException("Can only setTimeout while loader is reset");
    PC = paramTimeUnit.toMillis(paramLong);
  }

  public void a(R paramR)
  {
    PB = paramR;
    if (isStarted())
      super.deliverResult(paramR);
  }

  protected abstract R createFailedResult(Status paramStatus);

  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    super.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    if (PC >= 0L)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mTimeout=");
      paramPrintWriter.print(PC);
      paramPrintWriter.println("ms");
    }
  }

  public R og()
  {
    if (PC < 0L);
    for (Object localObject = cV.blockingConnect(); !((ConnectionResult)localObject).isSuccess(); localObject = cV.blockingConnect(PC, TimeUnit.MILLISECONDS))
      return createFailedResult(new Status(16));
    localObject = a(cV);
    if (PC < 0L)
      return ((PendingResult)localObject).await();
    return ((PendingResult)localObject).await(PC, TimeUnit.MILLISECONDS);
  }

  protected void onReset()
  {
    super.onReset();
    onStopLoading();
    PB = null;
    j.e(cV);
  }

  protected void onStartLoading()
  {
    if (PB != null)
      a(PB);
    if ((takeContentChanged()) || (PB == null))
      forceLoad();
  }

  protected void onStopLoading()
  {
    cancelLoad();
  }
}