package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface zzr extends IInterface
{
  public abstract void zzb(ResolveAccountResponse paramResolveAccountResponse)
    throws RemoteException;

  public static abstract class zza extends Binder
    implements zzr
  {
    public zza()
    {
      attachInterface(this, "com.google.android.gms.common.internal.IResolveAccountCallbacks");
    }

    public static zzr zzbZ(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.common.internal.IResolveAccountCallbacks");
      if ((localIInterface != null) && ((localIInterface instanceof zzr)))
        return (zzr)localIInterface;
      return new zza(paramIBinder);
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
        paramParcel2.writeString("com.google.android.gms.common.internal.IResolveAccountCallbacks");
        return true;
      case 2:
      }
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IResolveAccountCallbacks");
      if (paramParcel1.readInt() != 0);
      for (paramParcel1 = (ResolveAccountResponse)ResolveAccountResponse.CREATOR.createFromParcel(paramParcel1); ; paramParcel1 = null)
      {
        zzb(paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    }

    private static class zza
      implements zzr
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

      public void zzb(ResolveAccountResponse paramResolveAccountResponse)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.common.internal.IResolveAccountCallbacks");
          if (paramResolveAccountResponse != null)
          {
            localParcel1.writeInt(1);
            paramResolveAccountResponse.writeToParcel(localParcel1, 0);
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
        throw paramResolveAccountResponse;
      }
    }
  }
}