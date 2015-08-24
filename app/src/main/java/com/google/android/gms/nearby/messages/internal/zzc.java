package com.google.android.gms.nearby.messages.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface zzc extends IInterface
{
  public abstract void zza(PublishRequest paramPublishRequest)
    throws RemoteException;

  public abstract void zza(SubscribeRequest paramSubscribeRequest)
    throws RemoteException;

  public abstract void zza(UnpublishRequest paramUnpublishRequest)
    throws RemoteException;

  public abstract void zza(UnsubscribeRequest paramUnsubscribeRequest)
    throws RemoteException;

  public abstract void zzdP(String paramString)
    throws RemoteException;

  public static abstract class zza extends Binder
    implements zzc
  {
    public static zzc zzfp(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
      if ((localIInterface != null) && ((localIInterface instanceof zzc)))
        return (zzc)localIInterface;
      return new zza(paramIBinder);
    }

    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      Object localObject2 = null;
      Object localObject3 = null;
      Object localObject4 = null;
      Object localObject1 = null;
      switch (paramInt1)
      {
      default:
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902:
        paramParcel2.writeString("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
        return true;
      case 1:
        paramParcel1.enforceInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
        paramParcel2 = localObject1;
        if (paramParcel1.readInt() != 0)
          paramParcel2 = (PublishRequest)PublishRequest.CREATOR.createFromParcel(paramParcel1);
        zza(paramParcel2);
        return true;
      case 2:
        paramParcel1.enforceInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
        paramParcel2 = localObject2;
        if (paramParcel1.readInt() != 0)
          paramParcel2 = (UnpublishRequest)UnpublishRequest.CREATOR.createFromParcel(paramParcel1);
        zza(paramParcel2);
        return true;
      case 3:
        paramParcel1.enforceInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
        paramParcel2 = localObject3;
        if (paramParcel1.readInt() != 0)
          paramParcel2 = (SubscribeRequest)SubscribeRequest.CREATOR.createFromParcel(paramParcel1);
        zza(paramParcel2);
        return true;
      case 4:
        paramParcel1.enforceInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
        paramParcel2 = localObject4;
        if (paramParcel1.readInt() != 0)
          paramParcel2 = (UnsubscribeRequest)UnsubscribeRequest.CREATOR.createFromParcel(paramParcel1);
        zza(paramParcel2);
        return true;
      case 6:
      }
      paramParcel1.enforceInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
      zzdP(paramParcel1.readString());
      return true;
    }

    private static class zza
      implements zzc
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

      public void zza(PublishRequest paramPublishRequest)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
          if (paramPublishRequest != null)
          {
            localParcel.writeInt(1);
            paramPublishRequest.writeToParcel(localParcel, 0);
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
        throw paramPublishRequest;
      }

      public void zza(SubscribeRequest paramSubscribeRequest)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
          if (paramSubscribeRequest != null)
          {
            localParcel.writeInt(1);
            paramSubscribeRequest.writeToParcel(localParcel, 0);
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
        throw paramSubscribeRequest;
      }

      public void zza(UnpublishRequest paramUnpublishRequest)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
          if (paramUnpublishRequest != null)
          {
            localParcel.writeInt(1);
            paramUnpublishRequest.writeToParcel(localParcel, 0);
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
        throw paramUnpublishRequest;
      }

      public void zza(UnsubscribeRequest paramUnsubscribeRequest)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
          if (paramUnsubscribeRequest != null)
          {
            localParcel.writeInt(1);
            paramUnsubscribeRequest.writeToParcel(localParcel, 0);
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
        throw paramUnsubscribeRequest;
      }

      public void zzdP(String paramString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
          localParcel.writeString(paramString);
          zznF.transact(6, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
        throw paramString;
      }
    }
  }
}