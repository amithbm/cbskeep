package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.nearby.bootstrap.request.ConnectRequest;
import com.google.android.gms.nearby.bootstrap.request.ContinueConnectRequest;
import com.google.android.gms.nearby.bootstrap.request.DisableTargetRequest;
import com.google.android.gms.nearby.bootstrap.request.DisconnectRequest;
import com.google.android.gms.nearby.bootstrap.request.EnableTargetRequest;
import com.google.android.gms.nearby.bootstrap.request.SendDataRequest;
import com.google.android.gms.nearby.bootstrap.request.StartScanRequest;
import com.google.android.gms.nearby.bootstrap.request.StopScanRequest;
import com.google.android.gms.nearby.bootstrap.request.zza;
import com.google.android.gms.nearby.bootstrap.request.zzb;
import com.google.android.gms.nearby.bootstrap.request.zzc;
import com.google.android.gms.nearby.bootstrap.request.zzd;
import com.google.android.gms.nearby.bootstrap.request.zze;
import com.google.android.gms.nearby.bootstrap.request.zzf;
import com.google.android.gms.nearby.bootstrap.request.zzg;
import com.google.android.gms.nearby.bootstrap.request.zzh;

public abstract interface zzqu extends IInterface
{
  public abstract String getToken()
    throws RemoteException;

  public abstract void zza(ConnectRequest paramConnectRequest)
    throws RemoteException;

  public abstract void zza(ContinueConnectRequest paramContinueConnectRequest)
    throws RemoteException;

  public abstract void zza(DisableTargetRequest paramDisableTargetRequest)
    throws RemoteException;

  public abstract void zza(DisconnectRequest paramDisconnectRequest)
    throws RemoteException;

  public abstract void zza(EnableTargetRequest paramEnableTargetRequest)
    throws RemoteException;

  public abstract void zza(SendDataRequest paramSendDataRequest)
    throws RemoteException;

  public abstract void zza(StartScanRequest paramStartScanRequest)
    throws RemoteException;

  public abstract void zza(StopScanRequest paramStopScanRequest)
    throws RemoteException;

  public static abstract class zza extends Binder
    implements zzqu
  {
    public static zzqu zzfi(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
      if ((localIInterface != null) && ((localIInterface instanceof zzqu)))
        return (zzqu)localIInterface;
      return new zza(paramIBinder);
    }

    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      Object localObject2 = null;
      Object localObject3 = null;
      Object localObject4 = null;
      Object localObject5 = null;
      Object localObject6 = null;
      Object localObject7 = null;
      Object localObject8 = null;
      Object localObject1 = null;
      switch (paramInt1)
      {
      default:
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902:
        paramParcel2.writeString("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
        return true;
      case 1:
        paramParcel1.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
        paramParcel2 = localObject1;
        if (paramParcel1.readInt() != 0)
          paramParcel2 = StartScanRequest.CREATOR.zzjw(paramParcel1);
        zza(paramParcel2);
        return true;
      case 2:
        paramParcel1.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
        paramParcel2 = localObject2;
        if (paramParcel1.readInt() != 0)
          paramParcel2 = StopScanRequest.CREATOR.zzjx(paramParcel1);
        zza(paramParcel2);
        return true;
      case 3:
        paramParcel1.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
        paramParcel2 = localObject3;
        if (paramParcel1.readInt() != 0)
          paramParcel2 = EnableTargetRequest.CREATOR.zzju(paramParcel1);
        zza(paramParcel2);
        return true;
      case 4:
        paramParcel1.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
        paramParcel2 = localObject4;
        if (paramParcel1.readInt() != 0)
          paramParcel2 = DisableTargetRequest.CREATOR.zzjs(paramParcel1);
        zza(paramParcel2);
        return true;
      case 5:
        paramParcel1.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
        paramParcel2 = localObject5;
        if (paramParcel1.readInt() != 0)
          paramParcel2 = ConnectRequest.CREATOR.zzjq(paramParcel1);
        zza(paramParcel2);
        return true;
      case 6:
        paramParcel1.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
        paramParcel2 = localObject6;
        if (paramParcel1.readInt() != 0)
          paramParcel2 = DisconnectRequest.CREATOR.zzjt(paramParcel1);
        zza(paramParcel2);
        return true;
      case 7:
        paramParcel1.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
        paramParcel2 = localObject7;
        if (paramParcel1.readInt() != 0)
          paramParcel2 = SendDataRequest.CREATOR.zzjv(paramParcel1);
        zza(paramParcel2);
        return true;
      case 8:
        paramParcel1.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
        paramParcel2 = localObject8;
        if (paramParcel1.readInt() != 0)
          paramParcel2 = ContinueConnectRequest.CREATOR.zzjr(paramParcel1);
        zza(paramParcel2);
        return true;
      case 9:
      }
      paramParcel1.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
      paramParcel1 = getToken();
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    }

    private static class zza
      implements zzqu
    {
      private IBinder zznF;

      zza(IBinder paramIBinder)
      {
        zznF = paramIBinder;
      }

      public IBinder asBinder()
      {
        return zznF;
      }

      public String getToken()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
          zznF.transact(9, localParcel1, localParcel2, 0);
          localParcel2.readException();
          String str = localParcel2.readString();
          return str;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void zza(ConnectRequest paramConnectRequest)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
          if (paramConnectRequest != null)
          {
            localParcel.writeInt(1);
            paramConnectRequest.writeToParcel(localParcel, 0);
          }
          while (true)
          {
            zznF.transact(5, localParcel, null, 1);
            return;
            localParcel.writeInt(0);
          }
        }
        finally
        {
          localParcel.recycle();
        }
        throw paramConnectRequest;
      }

      public void zza(ContinueConnectRequest paramContinueConnectRequest)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
          if (paramContinueConnectRequest != null)
          {
            localParcel.writeInt(1);
            paramContinueConnectRequest.writeToParcel(localParcel, 0);
          }
          while (true)
          {
            zznF.transact(8, localParcel, null, 1);
            return;
            localParcel.writeInt(0);
          }
        }
        finally
        {
          localParcel.recycle();
        }
        throw paramContinueConnectRequest;
      }

      public void zza(DisableTargetRequest paramDisableTargetRequest)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
          if (paramDisableTargetRequest != null)
          {
            localParcel.writeInt(1);
            paramDisableTargetRequest.writeToParcel(localParcel, 0);
          }
          while (true)
          {
            zznF.transact(4, localParcel, null, 1);
            return;
            localParcel.writeInt(0);
          }
        }
        finally
        {
          localParcel.recycle();
        }
        throw paramDisableTargetRequest;
      }

      public void zza(DisconnectRequest paramDisconnectRequest)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
          if (paramDisconnectRequest != null)
          {
            localParcel.writeInt(1);
            paramDisconnectRequest.writeToParcel(localParcel, 0);
          }
          while (true)
          {
            zznF.transact(6, localParcel, null, 1);
            return;
            localParcel.writeInt(0);
          }
        }
        finally
        {
          localParcel.recycle();
        }
        throw paramDisconnectRequest;
      }

      public void zza(EnableTargetRequest paramEnableTargetRequest)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
          if (paramEnableTargetRequest != null)
          {
            localParcel.writeInt(1);
            paramEnableTargetRequest.writeToParcel(localParcel, 0);
          }
          while (true)
          {
            zznF.transact(3, localParcel, null, 1);
            return;
            localParcel.writeInt(0);
          }
        }
        finally
        {
          localParcel.recycle();
        }
        throw paramEnableTargetRequest;
      }

      public void zza(SendDataRequest paramSendDataRequest)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
          if (paramSendDataRequest != null)
          {
            localParcel.writeInt(1);
            paramSendDataRequest.writeToParcel(localParcel, 0);
          }
          while (true)
          {
            zznF.transact(7, localParcel, null, 1);
            return;
            localParcel.writeInt(0);
          }
        }
        finally
        {
          localParcel.recycle();
        }
        throw paramSendDataRequest;
      }

      public void zza(StartScanRequest paramStartScanRequest)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
          if (paramStartScanRequest != null)
          {
            localParcel.writeInt(1);
            paramStartScanRequest.writeToParcel(localParcel, 0);
          }
          while (true)
          {
            zznF.transact(1, localParcel, null, 1);
            return;
            localParcel.writeInt(0);
          }
        }
        finally
        {
          localParcel.recycle();
        }
        throw paramStartScanRequest;
      }

      public void zza(StopScanRequest paramStopScanRequest)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
          if (paramStopScanRequest != null)
          {
            localParcel.writeInt(1);
            paramStopScanRequest.writeToParcel(localParcel, 0);
          }
          while (true)
          {
            zznF.transact(2, localParcel, null, 1);
            return;
            localParcel.writeInt(0);
          }
        }
        finally
        {
          localParcel.recycle();
        }
        throw paramStopScanRequest;
      }
    }
  }
}