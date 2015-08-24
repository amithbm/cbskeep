package com.google.android.gms.drive.realtime.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.realtime.internal.event.ParcelableEventList;
import java.util.concurrent.CountDownLatch;

public class zzaa extends zzn.zza
  implements zzx
{
  private Status zzOQ;
  private ParcelableEventList zzazA;
  private final zzak zzazw;
  private DataHolder zzazz;
  private final CountDownLatch zzpi = new CountDownLatch(1);

  public zzaa(zzak paramzzak)
  {
    zzazw = paramzzak;
    paramzzak.zza(this);
  }

  private void zza(Status paramStatus, DataHolder paramDataHolder, ParcelableEventList paramParcelableEventList)
  {
    zzOQ = paramStatus;
    zzazz = paramDataHolder;
    zzazA = paramParcelableEventList;
    zzazw.zztP();
    zzpi.countDown();
  }

  public void zzQ(Status paramStatus)
  {
    zza(paramStatus, null, null);
  }

  public void zza(DataHolder paramDataHolder, ParcelableEventList paramParcelableEventList)
    throws RemoteException
  {
    zza(Status.zzaii, paramDataHolder, paramParcelableEventList);
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

  public ParcelableEventList zztH()
  {
    if (zzpi.getCount() != 0L)
      throw new IllegalStateException("await() must be called first");
    return zzazA;
  }
}