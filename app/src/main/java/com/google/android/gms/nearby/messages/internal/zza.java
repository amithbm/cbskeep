package com.google.android.gms.nearby.messages.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface zza extends IInterface
{
  public abstract void zza(MessageWrapper paramMessageWrapper)
    throws RemoteException;

  public abstract void zza(MessageWrapper paramMessageWrapper, int paramInt)
    throws RemoteException;

  public abstract void zzb(MessageWrapper paramMessageWrapper)
    throws RemoteException;

  public static abstract class zza extends Binder
    implements zza
  {
    public static zza zzfn(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.IMessageListener");
      if ((localIInterface != null) && ((localIInterface instanceof zza)))
        return (zza)localIInterface;
      return new zza(paramIBinder);
    }

    public IBinder asBinder()
    {
      return this;
    }

    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      Object localObject2 = null;
      Object localObject3 = null;
      Object localObject1 = null;
      switch (paramInt1)
      {
      default:
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902:
        paramParcel2.writeString("com.google.android.gms.nearby.messages.internal.IMessageListener");
        return true;
      case 1:
        paramParcel1.enforceInterface("com.google.android.gms.nearby.messages.internal.IMessageListener");
        if (paramParcel1.readInt() != 0)
          localObject1 = MessageWrapper.CREATOR.zzjE(paramParcel1);
        zza((MessageWrapper)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 2:
        paramParcel1.enforceInterface("com.google.android.gms.nearby.messages.internal.IMessageListener");
        localObject1 = localObject2;
        if (paramParcel1.readInt() != 0)
          localObject1 = MessageWrapper.CREATOR.zzjE(paramParcel1);
        zzb((MessageWrapper)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 3:
      }
      paramParcel1.enforceInterface("com.google.android.gms.nearby.messages.internal.IMessageListener");
      localObject1 = localObject3;
      if (paramParcel1.readInt() != 0)
        localObject1 = MessageWrapper.CREATOR.zzjE(paramParcel1);
      zza((MessageWrapper)localObject1, paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    }

    private static class zza
      implements zza
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

      public void zza(MessageWrapper paramMessageWrapper)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.IMessageListener");
          if (paramMessageWrapper != null)
          {
            localParcel1.writeInt(1);
            paramMessageWrapper.writeToParcel(localParcel1, 0);
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
        throw paramMessageWrapper;
      }

      public void zza(MessageWrapper paramMessageWrapper, int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.IMessageListener");
          if (paramMessageWrapper != null)
          {
            localParcel1.writeInt(1);
            paramMessageWrapper.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            localParcel1.writeInt(paramInt);
            zznF.transact(3, localParcel1, localParcel2, 0);
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
        throw paramMessageWrapper;
      }

      public void zzb(MessageWrapper paramMessageWrapper)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.IMessageListener");
          if (paramMessageWrapper != null)
          {
            localParcel1.writeInt(1);
            paramMessageWrapper.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            zznF.transact(2, localParcel1, localParcel2, 0);
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
        throw paramMessageWrapper;
      }
    }
  }
}