package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionProgressReportCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class zzj<T extends IInterface>
  implements Api.Client, zzk.zza
{
  public static final String[] GOOGLE_PLUS_REQUIRED_FEATURES = { "service_esmobile", "service_googleme" };
  private final Context mContext;
  final Handler mHandler;
  private final Account zzMF;
  private final Set<Scope> zzahd;
  private final zzf zzahu;
  protected AtomicInteger zzalA = new AtomicInteger(0);
  private final zzl zzalq;
  private zzq zzalr;
  private GoogleApiClient.ConnectionProgressReportCallbacks zzals;
  private T zzalt;
  private final ArrayList<zzj<T>.zzc<?>> zzalu = new ArrayList();
  private zzj<T>.zze zzalv;
  private int zzalw = 1;
  private GoogleApiClient.ConnectionCallbacks zzalx;
  private GoogleApiClient.OnConnectionFailedListener zzaly;
  private final int zzalz;
  private final Looper zznW;
  private final Object zzqY = new Object();

  @Deprecated
  protected zzj(Context paramContext, Looper paramLooper, int paramInt, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    mContext = ((Context)zzv.zzz(paramContext));
    zznW = ((Looper)zzv.zzb(paramLooper, "Looper must not be null"));
    zzalq = zzl.zzal(paramContext);
    mHandler = new zzb(paramLooper);
    zzalz = paramInt;
    zzMF = null;
    zzahd = Collections.emptySet();
    zzahu = new GoogleApiClient.Builder(paramContext).zzoz();
    zzalx = ((GoogleApiClient.ConnectionCallbacks)zzv.zzz(paramConnectionCallbacks));
    zzaly = ((GoogleApiClient.OnConnectionFailedListener)zzv.zzz(paramOnConnectionFailedListener));
  }

  protected zzj(Context paramContext, Looper paramLooper, int paramInt, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, zzf paramzzf)
  {
    this(paramContext, paramLooper, zzl.zzal(paramContext), paramInt, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }

  protected zzj(Context paramContext, Looper paramLooper, zzl paramzzl, int paramInt, zzf paramzzf)
  {
    mContext = ((Context)zzv.zzb(paramContext, "Context must not be null"));
    zznW = ((Looper)zzv.zzb(paramLooper, "Looper must not be null"));
    zzalq = ((zzl)zzv.zzb(paramzzl, "Supervisor must not be null"));
    mHandler = new zzb(paramLooper);
    zzalz = paramInt;
    zzahu = ((zzf)zzv.zzz(paramzzf));
    zzMF = paramzzf.getAccount();
    zzahd = zzb(paramzzf.zzpy());
  }

  protected zzj(Context paramContext, Looper paramLooper, zzl paramzzl, int paramInt, zzf paramzzf, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this(paramContext, paramLooper, paramzzl, paramInt, paramzzf);
    zzalx = ((GoogleApiClient.ConnectionCallbacks)zzv.zzz(paramConnectionCallbacks));
    zzaly = ((GoogleApiClient.OnConnectionFailedListener)zzv.zzz(paramOnConnectionFailedListener));
  }

  private void zza(int paramInt, T paramT)
  {
    boolean bool = true;
    int i;
    int j;
    if (paramInt == 3)
    {
      i = 1;
      if (paramT == null)
        break label115;
      j = 1;
      label17: if (i != j)
        break label121;
    }
    while (true)
    {
      zzv.zzS(bool);
      while (true)
      {
        synchronized (zzqY)
        {
          zzalw = paramInt;
          zzalt = paramT;
          switch (paramInt)
          {
          case 2:
            return;
            zzpI();
          case 3:
          case 1:
          }
        }
        zzlM();
        continue;
        zzpJ();
      }
      i = 0;
      break;
      label115: j = 0;
      break label17;
      label121: bool = false;
    }
  }

  private void zza(GoogleApiClient.ConnectionProgressReportCallbacks paramConnectionProgressReportCallbacks)
  {
    zzals = ((GoogleApiClient.ConnectionProgressReportCallbacks)zzv.zzb(paramConnectionProgressReportCallbacks, "Connection progress callbacks cannot be null."));
  }

  private boolean zza(int paramInt1, int paramInt2, T paramT)
  {
    synchronized (zzqY)
    {
      if (zzalw != paramInt1)
        return false;
      zza(paramInt2, paramT);
      return true;
    }
  }

  private Set<Scope> zzb(Set<Scope> paramSet)
  {
    Set localSet = zza(paramSet);
    if (localSet == null)
      return localSet;
    Iterator localIterator = localSet.iterator();
    while (localIterator.hasNext())
      if (!paramSet.contains((Scope)localIterator.next()))
        throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
    return localSet;
  }

  private void zzpI()
  {
    if (zzalv != null)
    {
      Log.e("GmsClient", "Calling connect() while still connected, missing disconnect() for " + getStartServiceAction());
      zzalq.zzb(getStartServiceAction(), zzalv, zzkF());
      zzalA.incrementAndGet();
    }
    zzalv = new zze(zzalA.get());
    if (!zzalq.zza(getStartServiceAction(), zzalv, zzkF()))
    {
      Log.e("GmsClient", "unable to connect to service: " + getStartServiceAction());
      mHandler.sendMessage(mHandler.obtainMessage(3, zzalA.get(), 9));
    }
  }

  private void zzpJ()
  {
    if (zzalv != null)
    {
      zzalq.zzb(getStartServiceAction(), zzalv, zzkF());
      zzalv = null;
    }
  }

  public void connect(GoogleApiClient.ConnectionProgressReportCallbacks paramConnectionProgressReportCallbacks)
  {
    zza(paramConnectionProgressReportCallbacks);
    zza(2, null);
  }

  public void disconnect()
  {
    zzalA.incrementAndGet();
    synchronized (zzalu)
    {
      int j = zzalu.size();
      int i = 0;
      while (i < j)
      {
        ((zzc)zzalu.get(i)).zzpS();
        i += 1;
      }
      zzalu.clear();
      zza(1, null);
      return;
    }
  }

  public void dump(String paramString, FileDescriptor arg2, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    while (true)
    {
      synchronized (zzqY)
      {
        int i = zzalw;
        paramArrayOfString = zzalt;
        paramPrintWriter.append(paramString).append("mConnectState=");
        switch (i)
        {
        default:
          paramPrintWriter.print("UNKNOWN");
          paramPrintWriter.append(" mService=");
          if (paramArrayOfString != null)
            break label137;
          paramPrintWriter.println("null");
          return;
        case 2:
        case 3:
        case 4:
        case 1:
        }
      }
      paramPrintWriter.print("CONNECTING");
      continue;
      paramPrintWriter.print("CONNECTED");
      continue;
      paramPrintWriter.print("DISCONNECTING");
      continue;
      paramPrintWriter.print("DISCONNECTED");
    }
    label137: paramPrintWriter.append(getServiceDescriptor()).append("@").println(Integer.toHexString(System.identityHashCode(paramArrayOfString.asBinder())));
  }

  public final Context getContext()
  {
    return mContext;
  }

  public final Looper getLooper()
  {
    return zznW;
  }

  public void getRemoteService(IAccountAccessor paramIAccountAccessor, Set<Scope> paramSet)
  {
    try
    {
      Object localObject = zzkG();
      localObject = new GetServiceRequest(zzalz).zzbW(mContext.getPackageName()).zzk((Bundle)localObject);
      if (paramSet != null)
        ((GetServiceRequest)localObject).zzb(paramSet);
      if (requiresSignIn())
        ((GetServiceRequest)localObject).zza(zzpv()).zzb(paramIAccountAccessor);
      while (true)
      {
        zzalr.zza(new zzd(this, zzalA.get()), (GetServiceRequest)localObject);
        return;
        if (requiresAccount())
          ((GetServiceRequest)localObject).zza(zzMF);
      }
    }
    catch (DeadObjectException paramIAccountAccessor)
    {
      Log.w("GmsClient", "service died");
      zzeK(1);
      return;
    }
    catch (RemoteException paramIAccountAccessor)
    {
      Log.w("GmsClient", "Remote exception occurred", paramIAccountAccessor);
    }
  }

  protected abstract String getServiceDescriptor();

  protected abstract String getStartServiceAction();

  public boolean isConnected()
  {
    while (true)
    {
      synchronized (zzqY)
      {
        if (zzalw == 3)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }

  public boolean isConnecting()
  {
    while (true)
    {
      synchronized (zzqY)
      {
        if (zzalw == 2)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }

  protected void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
  }

  protected void onConnectionSuspended(int paramInt)
  {
  }

  public boolean requiresAccount()
  {
    return false;
  }

  public boolean requiresSignIn()
  {
    return false;
  }

  public void validateAccount(IAccountAccessor paramIAccountAccessor)
  {
    Bundle localBundle = zzpO();
    paramIAccountAccessor = new ValidateAccountRequest(paramIAccountAccessor, (Scope[])zzahd.toArray(new Scope[zzahd.size()]), mContext.getPackageName(), localBundle);
    try
    {
      zzalr.zza(new zzd(this, zzalA.get()), paramIAccountAccessor);
      return;
    }
    catch (DeadObjectException paramIAccountAccessor)
    {
      Log.w("GmsClient", "service died");
      zzeK(1);
      return;
    }
    catch (RemoteException paramIAccountAccessor)
    {
      Log.w("GmsClient", "Remote exception occurred", paramIAccountAccessor);
    }
  }

  protected abstract T zzX(IBinder paramIBinder);

  protected Set<Scope> zza(Set<Scope> paramSet)
  {
    return paramSet;
  }

  protected void zza(int paramInt1, Bundle paramBundle, int paramInt2)
  {
    mHandler.sendMessage(mHandler.obtainMessage(5, paramInt2, -1, new zzi(paramInt1, paramBundle)));
  }

  protected void zza(int paramInt1, IBinder paramIBinder, Bundle paramBundle, int paramInt2)
  {
    mHandler.sendMessage(mHandler.obtainMessage(1, paramInt2, -1, new zzg(paramInt1, paramIBinder, paramBundle)));
  }

  @Deprecated
  public final void zza(zzj<T>.zzc<?> paramzzj)
  {
    synchronized (zzalu)
    {
      zzalu.add(paramzzj);
      mHandler.sendMessage(mHandler.obtainMessage(2, zzalA.get(), -1, paramzzj));
      return;
    }
  }

  public void zzeK(int paramInt)
  {
    mHandler.sendMessage(mHandler.obtainMessage(4, zzalA.get(), paramInt));
  }

  protected void zzeL(int paramInt)
  {
    mHandler.sendMessage(mHandler.obtainMessage(6, paramInt, -1, new zzh()));
  }

  protected String zzkF()
  {
    return zzahu.zzpB();
  }

  protected Bundle zzkG()
  {
    return new Bundle();
  }

  protected void zzlM()
  {
  }

  public Bundle zznK()
  {
    return null;
  }

  protected final zzf zzpL()
  {
    return zzahu;
  }

  protected final void zzpM()
  {
    if (!isConnected())
      throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
  }

  public final T zzpN()
    throws DeadObjectException
  {
    synchronized (zzqY)
    {
      if (zzalw == 4)
        throw new DeadObjectException();
    }
    zzpM();
    if (zzalt != null);
    for (boolean bool = true; ; bool = false)
    {
      zzv.zza(bool, "Client is connected but service is null");
      IInterface localIInterface = zzalt;
      return localIInterface;
    }
  }

  protected Bundle zzpO()
  {
    return null;
  }

  public final Account zzpv()
  {
    if (zzMF != null)
      return zzMF;
    return new Account("<<default account>>", "com.google");
  }

  private abstract class zza extends zzj<T>.zzc<Boolean>
  {
    public final int statusCode;
    public final Bundle zzalB;

    protected zza(int paramBundle, Bundle arg3)
    {
      super(Boolean.valueOf(true));
      statusCode = paramBundle;
      Object localObject;
      zzalB = localObject;
    }

    protected void zzc(Boolean paramBoolean)
    {
      Object localObject = null;
      if (paramBoolean == null)
        zzj.zza(zzj.this, 1, null);
      do
      {
        return;
        switch (statusCode)
        {
        default:
          zzj.zza(zzj.this, 1, null);
          paramBoolean = localObject;
          if (zzalB != null)
            paramBoolean = (PendingIntent)zzalB.getParcelable("pendingIntent");
          zzg(new ConnectionResult(statusCode, paramBoolean));
          return;
        case 0:
        case 10:
        }
      }
      while (zzpP());
      zzj.zza(zzj.this, 1, null);
      zzg(new ConnectionResult(8, null));
      return;
      zzj.zza(zzj.this, 1, null);
      throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
    }

    protected abstract void zzg(ConnectionResult paramConnectionResult);

    protected abstract boolean zzpP();

    protected void zzpQ()
    {
    }
  }

  final class zzb extends Handler
  {
    public zzb(Looper arg2)
    {
      super();
    }

    private void zza(Message paramMessage)
    {
      paramMessage = (zzj.zzc)paramMessage.obj;
      paramMessage.zzpQ();
      paramMessage.unregister();
    }

    private boolean zzb(Message paramMessage)
    {
      return (paramMessage.what == 2) || (paramMessage.what == 1) || (paramMessage.what == 5) || (paramMessage.what == 6);
    }

    public void handleMessage(Message paramMessage)
    {
      if (zzalA.get() != paramMessage.arg1)
      {
        if (zzb(paramMessage))
          zza(paramMessage);
        return;
      }
      if (((paramMessage.what == 1) || (paramMessage.what == 5) || (paramMessage.what == 6)) && (!isConnecting()))
      {
        zza(paramMessage);
        return;
      }
      if (paramMessage.what == 3)
      {
        paramMessage = new ConnectionResult(paramMessage.arg2, null);
        zzj.zza(zzj.this).onReportServiceBinding(paramMessage);
        onConnectionFailed(paramMessage);
        return;
      }
      if (paramMessage.what == 4)
      {
        zzj.zza(zzj.this, 4, null);
        if (zzj.zzb(zzj.this) != null)
          zzj.zzb(zzj.this).onConnectionSuspended(paramMessage.arg2);
        onConnectionSuspended(paramMessage.arg2);
        zzj.zza(zzj.this, 4, 1, null);
        return;
      }
      if ((paramMessage.what == 2) && (!isConnected()))
      {
        zza(paramMessage);
        return;
      }
      if (zzb(paramMessage))
      {
        ((zzj.zzc)paramMessage.obj).zzpR();
        return;
      }
      Log.wtf("GmsClient", "Don't know how to handle this message.");
    }
  }

  protected abstract class zzc<TListener>
  {
    private TListener mListener;
    private boolean zzalD;

    public zzc()
    {
      Object localObject;
      mListener = localObject;
      zzalD = false;
    }

    public void unregister()
    {
      zzpS();
      synchronized (zzj.zzc(zzj.this))
      {
        zzj.zzc(zzj.this).remove(this);
        return;
      }
    }

    protected abstract void zzpQ();

    // ERROR //
    public void zzpR()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 24	com/google/android/gms/common/internal/zzj$zzc:mListener	Ljava/lang/Object;
      //   6: astore_1
      //   7: aload_0
      //   8: getfield 26	com/google/android/gms/common/internal/zzj$zzc:zzalD	Z
      //   11: ifeq +33 -> 44
      //   14: ldc 48
      //   16: new 50	java/lang/StringBuilder
      //   19: dup
      //   20: invokespecial 51	java/lang/StringBuilder:<init>	()V
      //   23: ldc 53
      //   25: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   28: aload_0
      //   29: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   32: ldc 62
      //   34: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   37: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   40: invokestatic 72	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
      //   43: pop
      //   44: aload_0
      //   45: monitorexit
      //   46: aload_1
      //   47: ifnull +34 -> 81
      //   50: aload_0
      //   51: aload_1
      //   52: invokevirtual 76	com/google/android/gms/common/internal/zzj$zzc:zzw	(Ljava/lang/Object;)V
      //   55: aload_0
      //   56: monitorenter
      //   57: aload_0
      //   58: iconst_1
      //   59: putfield 26	com/google/android/gms/common/internal/zzj$zzc:zzalD	Z
      //   62: aload_0
      //   63: monitorexit
      //   64: aload_0
      //   65: invokevirtual 78	com/google/android/gms/common/internal/zzj$zzc:unregister	()V
      //   68: return
      //   69: astore_1
      //   70: aload_0
      //   71: monitorexit
      //   72: aload_1
      //   73: athrow
      //   74: astore_1
      //   75: aload_0
      //   76: invokevirtual 80	com/google/android/gms/common/internal/zzj$zzc:zzpQ	()V
      //   79: aload_1
      //   80: athrow
      //   81: aload_0
      //   82: invokevirtual 80	com/google/android/gms/common/internal/zzj$zzc:zzpQ	()V
      //   85: goto -30 -> 55
      //   88: astore_1
      //   89: aload_0
      //   90: monitorexit
      //   91: aload_1
      //   92: athrow
      //
      // Exception table:
      //   from	to	target	type
      //   2	44	69	finally
      //   44	46	69	finally
      //   70	72	69	finally
      //   50	55	74	java/lang/RuntimeException
      //   57	64	88	finally
      //   89	91	88	finally
    }

    public void zzpS()
    {
      try
      {
        mListener = null;
        return;
      }
      finally
      {
      }
    }

    protected abstract void zzw(TListener paramTListener);
  }

  public static final class zzd extends zzp.zza
  {
    private zzj zzalE;
    private final int zzalF;

    public zzd(zzj paramzzj, int paramInt)
    {
      zzalE = paramzzj;
      zzalF = paramInt;
    }

    private void zzpT()
    {
      zzalE = null;
    }

    public void zza(int paramInt, IBinder paramIBinder, Bundle paramBundle)
    {
      zzv.zzb(zzalE, "onPostInitComplete can be called only once per call to getRemoteService");
      zzalE.zza(paramInt, paramIBinder, paramBundle, zzalF);
      zzpT();
    }

    public void zzc(int paramInt, Bundle paramBundle)
    {
      zzv.zzb(zzalE, "onAccountValidationComplete can be called only once per call to validateAccount");
      zzalE.zza(paramInt, paramBundle, zzalF);
      zzpT();
    }
  }

  public final class zze
    implements ServiceConnection
  {
    private final int zzalF;

    public zze(int arg2)
    {
      int i;
      zzalF = i;
    }

    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      zzv.zzb(paramIBinder, "Expecting a valid IBinder");
      zzj.zza(zzj.this, zzq.zza.zzbY(paramIBinder));
      zzeL(zzalF);
    }

    public void onServiceDisconnected(ComponentName paramComponentName)
    {
      mHandler.sendMessage(mHandler.obtainMessage(4, zzalF, 1));
    }
  }

  protected class zzf
    implements GoogleApiClient.ConnectionProgressReportCallbacks
  {
    public zzf()
    {
    }

    public void onReportAccountValidation(ConnectionResult paramConnectionResult)
    {
      throw new IllegalStateException("Legacy GmsClient received onReportAccountValidation callback.");
    }

    public void onReportServiceBinding(ConnectionResult paramConnectionResult)
    {
      if (paramConnectionResult.isSuccess())
        getRemoteService(null, zzj.zzd(zzj.this));
      while (zzj.zze(zzj.this) == null)
        return;
      zzj.zze(zzj.this).onConnectionFailed(paramConnectionResult);
    }
  }

  protected final class zzg extends zzj<T>.zza
  {
    public final IBinder zzalG;

    public zzg(int paramIBinder, IBinder paramBundle, Bundle arg4)
    {
      super(paramIBinder, localBundle);
      zzalG = paramBundle;
    }

    protected void zzg(ConnectionResult paramConnectionResult)
    {
      if (zzj.zze(zzj.this) != null)
        zzj.zze(zzj.this).onConnectionFailed(paramConnectionResult);
      onConnectionFailed(paramConnectionResult);
    }

    protected boolean zzpP()
    {
      do
      {
        try
        {
          String str = zzalG.getInterfaceDescriptor();
          if (!getServiceDescriptor().equals(str))
          {
            Log.e("GmsClient", "service descriptor mismatch: " + getServiceDescriptor() + " vs. " + str);
            return false;
          }
        }
        catch (RemoteException localRemoteException)
        {
          Log.w("GmsClient", "service probably died");
          return false;
        }
        localObject = zzX(zzalG);
      }
      while ((localObject == null) || (!zzj.zza(zzj.this, 2, 3, (IInterface)localObject)));
      Object localObject = zznK();
      if (zzj.zzb(zzj.this) != null)
        zzj.zzb(zzj.this).onConnected((Bundle)localObject);
      GooglePlayServicesUtil.zzag(zzj.zzf(zzj.this));
      return true;
    }
  }

  protected final class zzh extends zzj<T>.zza
  {
    public zzh()
    {
      super(0, null);
    }

    protected void zzg(ConnectionResult paramConnectionResult)
    {
      zzj.zza(zzj.this).onReportServiceBinding(paramConnectionResult);
      onConnectionFailed(paramConnectionResult);
    }

    protected boolean zzpP()
    {
      zzj.zza(zzj.this).onReportServiceBinding(ConnectionResult.zzagb);
      return true;
    }
  }

  protected final class zzi extends zzj<T>.zza
  {
    public zzi(int paramBundle, Bundle arg3)
    {
      super(paramBundle, localBundle);
    }

    protected void zzg(ConnectionResult paramConnectionResult)
    {
      zzj.zza(zzj.this).onReportAccountValidation(paramConnectionResult);
      onConnectionFailed(paramConnectionResult);
    }

    protected boolean zzpP()
    {
      zzj.zza(zzj.this).onReportAccountValidation(ConnectionResult.zzagb);
      return true;
    }
  }
}