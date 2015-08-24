package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.nearby.bootstrap.Device;

public abstract interface zzqr extends IInterface
{
  public abstract void onDisconnected()
    throws RemoteException;

  public abstract void onError(int paramInt)
    throws RemoteException;

  public abstract void zzAg()
    throws RemoteException;

  public abstract void zza(Device paramDevice, byte[] paramArrayOfByte)
    throws RemoteException;

  public abstract void zzdL(String paramString)
    throws RemoteException;

  public static abstract class zza extends Binder
    implements zzqr
  {
    public static zzqr zzff(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
      if ((localIInterface != null) && ((localIInterface instanceof zzqr)))
        return (zzqr)localIInterface;
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
        paramParcel2.writeString("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
        return true;
      case 1:
        paramParcel1.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
        if (paramParcel1.readInt() != 0);
        for (Device localDevice = (Device)Device.CREATOR.createFromParcel(paramParcel1); ; localDevice = null)
        {
          zza(localDevice, paramParcel1.createByteArray());
          paramParcel2.writeNoException();
          return true;
        }
      case 2:
        paramParcel1.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
        onDisconnected();
        paramParcel2.writeNoException();
        return true;
      case 3:
        paramParcel1.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
        onError(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 4:
        paramParcel1.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
        zzdL(paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 5:
      }
      paramParcel1.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
      zzAg();
      paramParcel2.writeNoException();
      return true;
    }

    private static class zza
      implements zzqr
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

      public void onDisconnected()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
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

      public void onError(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
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

      public void zzAg()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
          zznF.transact(5, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void zza(Device paramDevice, byte[] paramArrayOfByte)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
          if (paramDevice != null)
          {
            localParcel1.writeInt(1);
            paramDevice.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            localParcel1.writeByteArray(paramArrayOfByte);
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

      public void zzdL(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
          localParcel1.writeString(paramString);
          zznF.transact(4, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramString;
      }
    }
  }
}