package com.google.android.gms.location.places.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zze;

public abstract interface zzh extends IInterface
{
  public abstract void zzaa(DataHolder paramDataHolder)
    throws RemoteException;

  public abstract void zzab(DataHolder paramDataHolder)
    throws RemoteException;

  public abstract void zzac(DataHolder paramDataHolder)
    throws RemoteException;

  public abstract void zzad(DataHolder paramDataHolder)
    throws RemoteException;

  public abstract void zzbu(Status paramStatus)
    throws RemoteException;

  public static abstract class zza extends Binder
    implements zzh
  {
    public zza()
    {
      attachInterface(this, "com.google.android.gms.location.places.internal.IPlacesCallbacks");
    }

    public static zzh zzeg(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.location.places.internal.IPlacesCallbacks");
      if ((localIInterface != null) && ((localIInterface instanceof zzh)))
        return (zzh)localIInterface;
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
      Object localObject1 = null;
      switch (paramInt1)
      {
      default:
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902:
        paramParcel2.writeString("com.google.android.gms.location.places.internal.IPlacesCallbacks");
        return true;
      case 1:
        paramParcel1.enforceInterface("com.google.android.gms.location.places.internal.IPlacesCallbacks");
        paramParcel2 = localObject1;
        if (paramParcel1.readInt() != 0)
          paramParcel2 = DataHolder.CREATOR.zzcH(paramParcel1);
        zzaa(paramParcel2);
        return true;
      case 2:
        paramParcel1.enforceInterface("com.google.android.gms.location.places.internal.IPlacesCallbacks");
        paramParcel2 = localObject2;
        if (paramParcel1.readInt() != 0)
          paramParcel2 = DataHolder.CREATOR.zzcH(paramParcel1);
        zzab(paramParcel2);
        return true;
      case 3:
        paramParcel1.enforceInterface("com.google.android.gms.location.places.internal.IPlacesCallbacks");
        paramParcel2 = localObject3;
        if (paramParcel1.readInt() != 0)
          paramParcel2 = DataHolder.CREATOR.zzcH(paramParcel1);
        zzac(paramParcel2);
        return true;
      case 4:
        paramParcel1.enforceInterface("com.google.android.gms.location.places.internal.IPlacesCallbacks");
        paramParcel2 = localObject4;
        if (paramParcel1.readInt() != 0)
          paramParcel2 = (Status)Status.CREATOR.createFromParcel(paramParcel1);
        zzbu(paramParcel2);
        return true;
      case 5:
      }
      paramParcel1.enforceInterface("com.google.android.gms.location.places.internal.IPlacesCallbacks");
      paramParcel2 = localObject5;
      if (paramParcel1.readInt() != 0)
        paramParcel2 = DataHolder.CREATOR.zzcH(paramParcel1);
      zzad(paramParcel2);
      return true;
    }

    private static class zza
      implements zzh
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

      public void zzaa(DataHolder paramDataHolder)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IPlacesCallbacks");
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

      public void zzab(DataHolder paramDataHolder)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IPlacesCallbacks");
          if (paramDataHolder != null)
          {
            localParcel.writeInt(1);
            paramDataHolder.writeToParcel(localParcel, 0);
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
        throw paramDataHolder;
      }

      public void zzac(DataHolder paramDataHolder)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IPlacesCallbacks");
          if (paramDataHolder != null)
          {
            localParcel.writeInt(1);
            paramDataHolder.writeToParcel(localParcel, 0);
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
        throw paramDataHolder;
      }

      public void zzad(DataHolder paramDataHolder)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IPlacesCallbacks");
          if (paramDataHolder != null)
          {
            localParcel.writeInt(1);
            paramDataHolder.writeToParcel(localParcel, 0);
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
        throw paramDataHolder;
      }

      public void zzbu(Status paramStatus)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IPlacesCallbacks");
          if (paramStatus != null)
          {
            localParcel.writeInt(1);
            paramStatus.writeToParcel(localParcel, 0);
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
        throw paramStatus;
      }
    }
  }
}