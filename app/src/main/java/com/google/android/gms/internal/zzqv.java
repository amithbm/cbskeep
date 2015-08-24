package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.nearby.bootstrap.Device;

public abstract interface zzqv extends IInterface
{
  public abstract void onError(int paramInt)
    throws RemoteException;

  public abstract void onScanStopped()
    throws RemoteException;

  public abstract void zza(Device paramDevice)
    throws RemoteException;

  public static abstract class zza extends Binder
    implements zzqv
  {
    public static zzqv zzfj(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.nearby.bootstrap.internal.IScanListener");
      if ((localIInterface != null) && ((localIInterface instanceof zzqv)))
        return (zzqv)localIInterface;
      return new zza(paramIBinder);
    }

    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      switch (paramInt1)
      {
      default:
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902:
        paramParcel2.writeString("com.google.android.gms.nearby.bootstrap.internal.IScanListener");
        return true;
      case 1:
        paramParcel1.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.IScanListener");
        if (paramParcel1.readInt() != 0);
        for (paramParcel1 = (Device)Device.CREATOR.createFromParcel(paramParcel1); ; paramParcel1 = null)
        {
          zza(paramParcel1);
          paramParcel2.writeNoException();
          return true;
        }
      case 2:
        paramParcel1.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.IScanListener");
        onScanStopped();
        paramParcel2.writeNoException();
        return true;
      case 3:
      }
      paramParcel1.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.IScanListener");
      onError(paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    }

    private static class zza
      implements zzqv
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

      public void onError(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.IScanListener");
          localParcel1.writeInt(paramInt);
          zznF.transact(3, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void onScanStopped()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.IScanListener");
          zznF.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void zza(Device paramDevice)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.IScanListener");
          if (paramDevice != null)
          {
            localParcel1.writeInt(1);
            paramDevice.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            zznF.transact(1, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
            localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramDevice;
      }
    }
  }
}