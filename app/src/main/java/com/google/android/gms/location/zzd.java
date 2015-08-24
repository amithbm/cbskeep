package com.google.android.gms.location;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface zzd extends IInterface
{
  public abstract void onLocationAvailability(LocationAvailability paramLocationAvailability)
    throws RemoteException;

  public abstract void onLocationResult(LocationResult paramLocationResult)
    throws RemoteException;

  public static abstract class zza extends Binder
    implements zzd
  {
    public static zzd zzdS(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.location.ILocationCallback");
      if ((localIInterface != null) && ((localIInterface instanceof zzd)))
        return (zzd)localIInterface;
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
        paramParcel2.writeString("com.google.android.gms.location.ILocationCallback");
        return true;
      case 1:
        paramParcel1.enforceInterface("com.google.android.gms.location.ILocationCallback");
        paramParcel2 = localObject1;
        if (paramParcel1.readInt() != 0)
          paramParcel2 = (LocationResult)LocationResult.CREATOR.createFromParcel(paramParcel1);
        onLocationResult(paramParcel2);
        return true;
      case 2:
      }
      paramParcel1.enforceInterface("com.google.android.gms.location.ILocationCallback");
      paramParcel2 = localObject2;
      if (paramParcel1.readInt() != 0)
        paramParcel2 = LocationAvailability.CREATOR.createFromParcel(paramParcel1);
      onLocationAvailability(paramParcel2);
      return true;
    }

    private static class zza
      implements zzd
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

      public void onLocationAvailability(LocationAvailability paramLocationAvailability)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.location.ILocationCallback");
          if (paramLocationAvailability != null)
          {
            localParcel.writeInt(1);
            paramLocationAvailability.writeToParcel(localParcel, 0);
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
        throw paramLocationAvailability;
      }

      public void onLocationResult(LocationResult paramLocationResult)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.location.ILocationCallback");
          if (paramLocationResult != null)
          {
            localParcel.writeInt(1);
            paramLocationResult.writeToParcel(localParcel, 0);
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
        throw paramLocationResult;
      }
    }
  }
}