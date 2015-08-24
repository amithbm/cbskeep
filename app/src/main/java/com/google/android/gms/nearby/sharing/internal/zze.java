package com.google.android.gms.nearby.sharing.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface zze extends IInterface
{
  public abstract void zza(ProvideContentRequest paramProvideContentRequest)
    throws RemoteException;

  public abstract void zza(ReceiveContentRequest paramReceiveContentRequest)
    throws RemoteException;

  public abstract void zza(StopProvidingContentRequest paramStopProvidingContentRequest)
    throws RemoteException;

  public abstract void zza(TrustedDevicesRequest paramTrustedDevicesRequest)
    throws RemoteException;

  public abstract void zza(zzd paramzzd)
    throws RemoteException;

  public static abstract class zza extends Binder
    implements zze
  {
    public static zze zzfu(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.nearby.sharing.internal.INearbySharingService");
      if ((localIInterface != null) && ((localIInterface instanceof zze)))
        return (zze)localIInterface;
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
        paramParcel2.writeString("com.google.android.gms.nearby.sharing.internal.INearbySharingService");
        return true;
      case 1:
        paramParcel1.enforceInterface("com.google.android.gms.nearby.sharing.internal.INearbySharingService");
        paramParcel2 = localObject1;
        if (paramParcel1.readInt() != 0)
          paramParcel2 = (ProvideContentRequest)ProvideContentRequest.CREATOR.createFromParcel(paramParcel1);
        zza(paramParcel2);
        return true;
      case 2:
        paramParcel1.enforceInterface("com.google.android.gms.nearby.sharing.internal.INearbySharingService");
        paramParcel2 = localObject2;
        if (paramParcel1.readInt() != 0)
          paramParcel2 = (StopProvidingContentRequest)StopProvidingContentRequest.CREATOR.createFromParcel(paramParcel1);
        zza(paramParcel2);
        return true;
      case 3:
        paramParcel1.enforceInterface("com.google.android.gms.nearby.sharing.internal.INearbySharingService");
        paramParcel2 = localObject3;
        if (paramParcel1.readInt() != 0)
          paramParcel2 = (TrustedDevicesRequest)TrustedDevicesRequest.CREATOR.createFromParcel(paramParcel1);
        zza(paramParcel2);
        return true;
      case 4:
        paramParcel1.enforceInterface("com.google.android.gms.nearby.sharing.internal.INearbySharingService");
        paramParcel2 = localObject4;
        if (paramParcel1.readInt() != 0)
          paramParcel2 = (ReceiveContentRequest)ReceiveContentRequest.CREATOR.createFromParcel(paramParcel1);
        zza(paramParcel2);
        return true;
      case 5:
      }
      paramParcel1.enforceInterface("com.google.android.gms.nearby.sharing.internal.INearbySharingService");
      zza(zzd.zza.zzft(paramParcel1.readStrongBinder()));
      return true;
    }

    private static class zza
      implements zze
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

      public void zza(ProvideContentRequest paramProvideContentRequest)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.nearby.sharing.internal.INearbySharingService");
          if (paramProvideContentRequest != null)
          {
            localParcel.writeInt(1);
            paramProvideContentRequest.writeToParcel(localParcel, 0);
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
        throw paramProvideContentRequest;
      }

      public void zza(ReceiveContentRequest paramReceiveContentRequest)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.nearby.sharing.internal.INearbySharingService");
          if (paramReceiveContentRequest != null)
          {
            localParcel.writeInt(1);
            paramReceiveContentRequest.writeToParcel(localParcel, 0);
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
        throw paramReceiveContentRequest;
      }

      public void zza(StopProvidingContentRequest paramStopProvidingContentRequest)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.nearby.sharing.internal.INearbySharingService");
          if (paramStopProvidingContentRequest != null)
          {
            localParcel.writeInt(1);
            paramStopProvidingContentRequest.writeToParcel(localParcel, 0);
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
        throw paramStopProvidingContentRequest;
      }

      public void zza(TrustedDevicesRequest paramTrustedDevicesRequest)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.nearby.sharing.internal.INearbySharingService");
          if (paramTrustedDevicesRequest != null)
          {
            localParcel.writeInt(1);
            paramTrustedDevicesRequest.writeToParcel(localParcel, 0);
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
        throw paramTrustedDevicesRequest;
      }

      public void zza(zzd paramzzd)
        throws RemoteException
      {
        IBinder localIBinder = null;
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.nearby.sharing.internal.INearbySharingService");
          if (paramzzd != null)
            localIBinder = paramzzd.asBinder();
          localParcel.writeStrongBinder(localIBinder);
          zznF.transact(5, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
        throw paramzzd;
      }
    }
  }
}