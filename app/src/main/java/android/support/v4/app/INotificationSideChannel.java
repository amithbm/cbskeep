package android.support.v4.app;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface INotificationSideChannel extends IInterface
{
  public abstract void cancel(String paramString1, int paramInt, String paramString2)
    throws RemoteException;

  public abstract void cancelAll(String paramString)
    throws RemoteException;

  public abstract void notify(String paramString1, int paramInt, String paramString2, Notification paramNotification)
    throws RemoteException;

  public static abstract class Stub extends Binder
    implements INotificationSideChannel
  {
    public static INotificationSideChannel asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("android.support.v4.app.INotificationSideChannel");
      if ((localIInterface != null) && ((localIInterface instanceof INotificationSideChannel)))
        return (INotificationSideChannel)localIInterface;
      return new Proxy(paramIBinder);
    }

    public IBinder asBinder()
    {
      return this;
    }

    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      switch (paramInt1)
      {
      default:
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902:
        paramParcel2.writeString("android.support.v4.app.INotificationSideChannel");
        return true;
      case 1:
        paramParcel1.enforceInterface("android.support.v4.app.INotificationSideChannel");
        paramParcel2 = paramParcel1.readString();
        paramInt1 = paramParcel1.readInt();
        String str = paramParcel1.readString();
        if (paramParcel1.readInt() != 0);
        for (paramParcel1 = (Notification)Notification.CREATOR.createFromParcel(paramParcel1); ; paramParcel1 = null)
        {
          notify(paramParcel2, paramInt1, str, paramParcel1);
          return true;
        }
      case 2:
        paramParcel1.enforceInterface("android.support.v4.app.INotificationSideChannel");
        cancel(paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readString());
        return true;
      case 3:
      }
      paramParcel1.enforceInterface("android.support.v4.app.INotificationSideChannel");
      cancelAll(paramParcel1.readString());
      return true;
    }

    private static class Proxy
      implements INotificationSideChannel
    {
      private IBinder mRemote;

      Proxy(IBinder paramIBinder)
      {
        mRemote = paramIBinder;
      }

      public IBinder asBinder()
      {
        return mRemote;
      }

      public void cancel(String paramString1, int paramInt, String paramString2)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
          localParcel.writeString(paramString1);
          localParcel.writeInt(paramInt);
          localParcel.writeString(paramString2);
          mRemote.transact(2, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
        throw paramString1;
      }

      public void cancelAll(String paramString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
          localParcel.writeString(paramString);
          mRemote.transact(3, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
        throw paramString;
      }

      public void notify(String paramString1, int paramInt, String paramString2, Notification paramNotification)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
          localParcel.writeString(paramString1);
          localParcel.writeInt(paramInt);
          localParcel.writeString(paramString2);
          if (paramNotification != null)
          {
            localParcel.writeInt(1);
            paramNotification.writeToParcel(localParcel, 0);
          }
          while (true)
          {
            mRemote.transact(1, localParcel, null, 1);
            return;
            localParcel.writeInt(0);
          }
        }
        finally
        {
          localParcel.recycle();
        }
        throw paramString1;
      }
    }
  }
}