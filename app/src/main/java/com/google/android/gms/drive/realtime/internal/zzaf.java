package com.google.android.gms.drive.realtime.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import java.util.concurrent.CountDownLatch;

public class zzaf extends zzv.zza
  implements zzx
{
  private Status zzOQ;
  private final zzak zzazw;
  private final CountDownLatch zzpi = new CountDownLatch(1);

  public zzaf(zzak paramzzak)
  {
    zzazw = paramzzak;
    paramzzak.zza(this);
  }

  private void zzag(Status paramStatus)
  {
    zzOQ = paramStatus;
    zzazw.zztP();
    zzpi.countDown();
  }

  public void await()
  {
    try
    {
      zzpi.await();
      if ((zzOQ != null) && (!zzOQ.isSuccess()))
        throw new RuntimeException(zzOQ.toString());
    }
    catch (InterruptedException localInterruptedException)
    {
      throw new IllegalStateException();
    }
  }

  public void onSuccess()
    throws RemoteException
  {
    zzag(Status.zzaii);
  }

  public void zzQ(Status paramStatus)
  {
    zzag(paramStatus);
  }
}