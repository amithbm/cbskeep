package com.google.android.gms.drive.realtime.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.realtime.internal.event.ParcelableEventList;
import java.util.concurrent.CountDownLatch;

public class zzab extends zzq.zza
  implements zzx
{
  private Status zzOQ;
  private ParcelableEventList zzazB;
  private final zzak zzazw;
  private final CountDownLatch zzpi = new CountDownLatch(1);

  public zzab(zzak paramzzak)
  {
    zzazw = paramzzak;
    paramzzak.zza(this);
  }

  private void zza(Status paramStatus, ParcelableEventList paramParcelableEventList)
  {
    zzOQ = paramStatus;
    zzazB = paramParcelableEventList;
    zzazw.zztP();
    zzpi.countDown();
  }

  public void zzQ(Status paramStatus)
  {
    zza(paramStatus, null);
  }

  public void zza(ParcelableEventList paramParcelableEventList)
    throws RemoteException
  {
    zza(Status.zzaii, paramParcelableEventList);
  }

  public ParcelableEventList zztI()
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
    ParcelableEventList localParcelableEventList = zzazB;
    return localParcelableEventList;
  }
}