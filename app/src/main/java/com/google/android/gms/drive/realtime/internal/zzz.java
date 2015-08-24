package com.google.android.gms.drive.realtime.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import java.util.concurrent.CountDownLatch;

public class zzz extends zzm.zza
  implements zzx
{
  private Status zzOQ;
  private final zzak zzazw;
  private DataHolder zzazz;
  private final CountDownLatch zzpi = new CountDownLatch(1);

  public zzz(zzak paramzzak)
  {
    zzazw = paramzzak;
    paramzzak.zza(this);
  }

  private void zzb(Status paramStatus, DataHolder paramDataHolder)
  {
    zzOQ = paramStatus;
    zzazz = paramDataHolder;
    zzazw.zztP();
    zzpi.countDown();
  }

  public void zzQ(Status paramStatus)
  {
    zzb(paramStatus, null);
  }

  public void zzg(DataHolder paramDataHolder)
    throws RemoteException
  {
    zzb(Status.zzaii, paramDataHolder);
  }

  public DataHolder zztG()
  {
    try
    {
      zzpi.await();
      if (!zzOQ.isSuccess())
        throw new RuntimeException(zzOQ.toString());
    }
    catch (InterruptedException localInterruptedException)
    {
      throw new IllegalStateException();
    }
    DataHolder localDataHolder = zzazz;
    return localDataHolder;
  }
}