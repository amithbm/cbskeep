package com.google.android.gms.wearable.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zze;
import java.util.List;

public abstract interface zzas extends IInterface
{
  public abstract void onConnectedNodes(List<NodeParcelable> paramList)
    throws RemoteException;

  public abstract void zza(AncsNotificationParcelable paramAncsNotificationParcelable)
    throws RemoteException;

  public abstract void zza(CapabilityInfoParcelable paramCapabilityInfoParcelable)
    throws RemoteException;

  public abstract void zza(ChannelEventParcelable paramChannelEventParcelable)
    throws RemoteException;

  public abstract void zza(MessageEventParcelable paramMessageEventParcelable)
    throws RemoteException;

  public abstract void zza(NodeParcelable paramNodeParcelable)
    throws RemoteException;

  public abstract void zzam(DataHolder paramDataHolder)
    throws RemoteException;

  public abstract void zzb(NodeParcelable paramNodeParcelable)
    throws RemoteException;

  public static abstract class zza extends Binder
    implements zzas
  {
    public zza()
    {
      attachInterface(this, "com.google.android.gms.wearable.internal.IWearableListener");
    }

    public static zzas zzhw(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableListener");
      if ((localIInterface != null) && ((localIInterface instanceof zzas)))
        return (zzas)localIInterface;
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
      Object localObject4 = null;
      Object localObject5 = null;
      Object localObject6 = null;
      Object localObject7 = null;
      Object localObject1 = null;
      switch (paramInt1)
      {
      default:
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902:
        paramParcel2.writeString("com.google.android.gms.wearable.internal.IWearableListener");
        return true;
      case 1:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
        paramParcel2 = localObject1;
        if (paramParcel1.readInt() != 0)
          paramParcel2 = DataHolder.CREATOR.zzcH(paramParcel1);
        zzam(paramParcel2);
        return true;
      case 2:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
        paramParcel2 = localObject2;
        if (paramParcel1.readInt() != 0)
          paramParcel2 = (MessageEventParcelable)MessageEventParcelable.CREATOR.createFromParcel(paramParcel1);
        zza(paramParcel2);
        return true;
      case 3:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
        paramParcel2 = localObject3;
        if (paramParcel1.readInt() != 0)
          paramParcel2 = (NodeParcelable)NodeParcelable.CREATOR.createFromParcel(paramParcel1);
        zza(paramParcel2);
        return true;
      case 4:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
        paramParcel2 = localObject4;
        if (paramParcel1.readInt() != 0)
          paramParcel2 = (NodeParcelable)NodeParcelable.CREATOR.createFromParcel(paramParcel1);
        zzb(paramParcel2);
        return true;
      case 5:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
        onConnectedNodes(paramParcel1.createTypedArrayList(NodeParcelable.CREATOR));
        return true;
      case 6:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
        paramParcel2 = localObject5;
        if (paramParcel1.readInt() != 0)
          paramParcel2 = (AncsNotificationParcelable)AncsNotificationParcelable.CREATOR.createFromParcel(paramParcel1);
        zza(paramParcel2);
        return true;
      case 7:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
        paramParcel2 = localObject6;
        if (paramParcel1.readInt() != 0)
          paramParcel2 = (ChannelEventParcelable)ChannelEventParcelable.CREATOR.createFromParcel(paramParcel1);
        zza(paramParcel2);
        return true;
      case 8:
      }
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
      paramParcel2 = localObject7;
      if (paramParcel1.readInt() != 0)
        paramParcel2 = (CapabilityInfoParcelable)CapabilityInfoParcelable.CREATOR.createFromParcel(paramParcel1);
      zza(paramParcel2);
      return true;
    }

    private static class zza
      implements zzas
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

      public void onConnectedNodes(List<NodeParcelable> paramList)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
          localParcel.writeTypedList(paramList);
          zznF.transact(5, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
        throw paramList;
      }

      public void zza(AncsNotificationParcelable paramAncsNotificationParcelable)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
          if (paramAncsNotificationParcelable != null)
          {
            localParcel.writeInt(1);
            paramAncsNotificationParcelable.writeToParcel(localParcel, 0);
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
        throw paramAncsNotificationParcelable;
      }

      public void zza(CapabilityInfoParcelable paramCapabilityInfoParcelable)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
          if (paramCapabilityInfoParcelable != null)
          {
            localParcel.writeInt(1);
            paramCapabilityInfoParcelable.writeToParcel(localParcel, 0);
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
        throw paramCapabilityInfoParcelable;
      }

      public void zza(ChannelEventParcelable paramChannelEventParcelable)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
          if (paramChannelEventParcelable != null)
          {
            localParcel.writeInt(1);
            paramChannelEventParcelable.writeToParcel(localParcel, 0);
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
        throw paramChannelEventParcelable;
      }

      public void zza(MessageEventParcelable paramMessageEventParcelable)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
          if (paramMessageEventParcelable != null)
          {
            localParcel.writeInt(1);
            paramMessageEventParcelable.writeToParcel(localParcel, 0);
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
        throw paramMessageEventParcelable;
      }

      public void zza(NodeParcelable paramNodeParcelable)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
          if (paramNodeParcelable != null)
          {
            localParcel.writeInt(1);
            paramNodeParcelable.writeToParcel(localParcel, 0);
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
        throw paramNodeParcelable;
      }

      public void zzam(DataHolder paramDataHolder)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
          if (paramDataHolder != null)
          {
            localParcel.writeInt(1);
            paramDataHolder.writeToParcel(localParcel, 0);
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
        throw paramDataHolder;
      }

      public void zzb(NodeParcelable paramNodeParcelable)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
          if (paramNodeParcelable != null)
          {
            localParcel.writeInt(1);
            paramNodeParcelable.writeToParcel(localParcel, 0);
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
        throw paramNodeParcelable;
      }
    }
  }
}