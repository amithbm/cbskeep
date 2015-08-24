package com.google.android.gms.drive.realtime.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import java.util.concurrent.CountDownLatch;

public class zzae extends zzu.zza
  implements zzx
{
  private Status zzOQ;
  private String zzazE;
  private final zzak zzazw;
  private final CountDownLatch zzpi = new CountDownLatch(1);

  public zzae(zzak paramzzak)
  {
    zzazw = paramzzak;
    paramzzak.zza(this);
  }

  private void zza(Status paramStatus, String paramString)
  {
    zzOQ = paramStatus;
    zzazE = paramString;
    zzazw.zztP();
    zzpi.countDown();
  }

  public void zzQ(Status paramStatus)
  {
    zza(paramStatus, null);
  }

  public void zzcF(String paramString)
    throws RemoteException
  {
    zza(Status.zzaii, paramString);
  }

  public String zztK()
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
    String str = zzazE;
    return str;
  }
}