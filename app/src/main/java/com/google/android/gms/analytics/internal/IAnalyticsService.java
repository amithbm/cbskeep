package com.google.android.gms.analytics.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;
import java.util.Map;

public abstract interface IAnalyticsService extends IInterface
{
  public abstract void clearHits()
    throws RemoteException;

  public abstract void sendHit(Map paramMap, long paramLong, String paramString, List<Command> paramList)
    throws RemoteException;

  public static abstract class Stub extends Binder
    implements IAnalyticsService
  {
    public static IAnalyticsService asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
      if ((localIInterface != null) && ((localIInterface instanceof IAnalyticsService)))
        return (IAnalyticsService)localIInterface;
      return new Proxy(paramIBinder);
    }

    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      switch (paramInt1)
      {
      default:
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902:
        paramParcel2.writeString("com.google.android.gms.analytics.internal.IAnalyticsService");
        return true;
      case 1:
        paramParcel1.enforceInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
        sendHit(paramParcel1.readHashMap(getClass().getClassLoader()), paramParcel1.readLong(), paramParcel1.readString(), paramParcel1.createTypedArrayList(Command.CREATOR));
        paramParcel2.writeNoException();
        return true;
      case 2:
      }
      paramParcel1.enforceInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
      clearHits();
      paramParcel2.writeNoException();
      return true;
    }

    private static class Proxy
      implements IAnalyticsService
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

      public void clearHits()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.analytics.internal.IAnalyticsService");
          mRemote.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void sendHit(Map paramMap, long paramLong, String paramString, List<Command> paramList)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.analytics.internal.IAnalyticsService");
          localParcel1.writeMap(paramMap);
          localParcel1.writeLong(paramLong);
          localParcel1.writeString(paramString);
          localParcel1.writeTypedList(paramList);
          mRemote.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramMap;
      }
    }
  }
}