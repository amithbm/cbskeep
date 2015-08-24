package com.google.android.gms.drive.realtime.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import java.util.concurrent.CountDownLatch;

public class zzad extends zzs.zza
  implements zzx
{
  private Status zzOQ;
  private int zzazD;
  private final zzak zzazw;
  private final CountDownLatch zzpi = new CountDownLatch(1);

  public zzad(zzak paramzzak)
  {
    zzazw = paramzzak;
    paramzzak.zza(this);
  }

  private void zza(Status paramStatus, int paramInt)
  {
    zzOQ = paramStatus;
    zzazD = paramInt;
    zzazw.zztP();
    zzpi.countDown();
  }

  public int await()
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
    int i = zzazD;
    return i;
  }

  public void zzQ(Status paramStatus)
  {
    zza(paramStatus, 0);
  }

  public void zzhL(int paramInt)
    throws RemoteException
  {
    zza(Status.zzaii, paramInt);
  }
}