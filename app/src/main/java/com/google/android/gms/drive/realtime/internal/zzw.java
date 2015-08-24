package com.google.android.gms.drive.realtime.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import java.util.concurrent.CountDownLatch;

public class zzw extends zzj.zza
  implements zzx
{
  private Status zzOQ;
  private final zzak zzazw;
  private boolean zzazx;
  private final CountDownLatch zzpi = new CountDownLatch(1);

  public zzw(zzak paramzzak)
  {
    zzazw = paramzzak;
    paramzzak.zza(this);
  }

  private void zzb(Status paramStatus, boolean paramBoolean)
  {
    zzOQ = paramStatus;
    zzazx = paramBoolean;
    zzazw.zztP();
    zzpi.countDown();
  }

  public void zzQ(Status paramStatus)
  {
    zzb(paramStatus, false);
  }

  public void zzV(boolean paramBoolean)
    throws RemoteException
  {
    zzb(Status.zzaii, paramBoolean);
  }

  public boolean zztE()
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
    boolean bool = zzazx;
    return bool;
  }
}