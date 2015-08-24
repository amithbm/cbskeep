package com.google.android.gms.common.api;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.internal.zzv;
import java.util.concurrent.atomic.AtomicReference;

public class zza
{
  public static abstract class zza<R extends Result, A extends Api.Client> extends AbstractPendingResult<R>
    implements zza.zzb<R>, zzg.zze<A>
  {
    private final Api.ClientKey<A> zzaeA;
    private AtomicReference<zzg.zzc> zzagH = new AtomicReference();

    protected zza(Api.ClientKey<A> paramClientKey, GoogleApiClient paramGoogleApiClient)
    {
      super();
      zzaeA = ((Api.ClientKey)zzv.zzz(paramClientKey));
    }

    private void zzc(RemoteException paramRemoteException)
    {
      zzI(new Status(8, paramRemoteException.getLocalizedMessage(), null));
    }

    protected void onResultConsumed()
    {
      zzg.zzc localzzc = (zzg.zzc)zzagH.getAndSet(null);
      if (localzzc != null)
        localzzc.zzc(this);
    }

    public final void zzI(Status paramStatus)
    {
      if (!paramStatus.isSuccess());
      for (boolean bool = true; ; bool = false)
      {
        zzv.zzb(bool, "Failed result must not be success");
        setResult(createFailedResult(paramStatus));
        return;
      }
    }

    protected abstract void zza(A paramA)
      throws RemoteException;

    public void zza(zzg.zzc paramzzc)
    {
      zzagH.set(paramzzc);
    }

    public final void zzb(A paramA)
      throws DeadObjectException
    {
      try
      {
        zza(paramA);
        return;
      }
      catch (DeadObjectException paramA)
      {
        zzc(paramA);
        throw paramA;
      }
      catch (RemoteException paramA)
      {
        zzc(paramA);
      }
    }

    public final Api.ClientKey<A> zzou()
    {
      return zzaeA;
    }

    public int zzox()
    {
      return 0;
    }
  }

  public static abstract interface zzb<R>
  {
    public abstract void zzq(R paramR);
  }
}