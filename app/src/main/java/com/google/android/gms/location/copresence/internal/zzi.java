package com.google.android.gms.location.copresence.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.location.copresence.SubscribedMessage;
import java.util.List;

public abstract interface zzi extends IInterface
{
  public abstract void onMessagesReceived(List<SubscribedMessage> paramList)
    throws RemoteException;

  public abstract void onStatusReceived(int paramInt)
    throws RemoteException;

  public abstract void zza(SubscribedMessage paramSubscribedMessage)
    throws RemoteException;

  public abstract void zza(SubscribedMessage paramSubscribedMessage, int paramInt)
    throws RemoteException;

  public static abstract class zza extends Binder
    implements zzi
  {
    public static zzi zzdX(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.location.copresence.internal.IMessageListener");
      if ((localIInterface != null) && ((localIInterface instanceof zzi)))
        return (zzi)localIInterface;
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
      Object localObject1 = null;
      switch (paramInt1)
      {
      default:
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902:
        paramParcel2.writeString("com.google.android.gms.location.copresence.internal.IMessageListener");
        return true;
      case 2:
        paramParcel1.enforceInterface("com.google.android.gms.location.copresence.internal.IMessageListener");
        onMessagesReceived(paramParcel1.createTypedArrayList(SubscribedMessage.CREATOR));
        paramParcel2.writeNoException();
        return true;
      case 3:
        paramParcel1.enforceInterface("com.google.android.gms.location.copresence.internal.IMessageListener");
        onStatusReceived(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 4:
        paramParcel1.enforceInterface("com.google.android.gms.location.copresence.internal.IMessageListener");
        if (paramParcel1.readInt() != 0)
          localObject1 = (SubscribedMessage)SubscribedMessage.CREATOR.createFromParcel(paramParcel1);
        zza((SubscribedMessage)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 5:
      }
      paramParcel1.enforceInterface("com.google.android.gms.location.copresence.internal.IMessageListener");
      localObject1 = localObject2;
      if (paramParcel1.readInt() != 0)
        localObject1 = (SubscribedMessage)SubscribedMessage.CREATOR.createFromParcel(paramParcel1);
      zza((SubscribedMessage)localObject1, paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    }

    private static class zza
      implements zzi
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

      public void onMessagesReceived(List<SubscribedMessage> paramList)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.location.copresence.internal.IMessageListener");
          localParcel1.writeTypedList(paramList);
          zznF.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramList;
      }

      public void onStatusReceived(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.location.copresence.internal.IMessageListener");
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

      public void zza(SubscribedMessage paramSubscribedMessage)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.location.copresence.internal.IMessageListener");
          if (paramSubscribedMessage != null)
          {
            localParcel1.writeInt(1);
            paramSubscribedMessage.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            zznF.transact(4, localParcel1, localParcel2, 0);
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
        throw paramSubscribedMessage;
      }

      public void zza(SubscribedMessage paramSubscribedMessage, int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.location.copresence.internal.IMessageListener");
          if (paramSubscribedMessage != null)
          {
            localParcel1.writeInt(1);
            paramSubscribedMessage.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            localParcel1.writeInt(paramInt);
            zznF.transact(5, localParcel1, localParcel2, 0);
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
        throw paramSubscribedMessage;
      }
    }
  }
}