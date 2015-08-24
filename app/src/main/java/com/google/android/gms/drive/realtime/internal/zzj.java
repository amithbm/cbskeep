package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

public abstract interface zzj extends IInterface
{
  public abstract void zzQ(Status paramStatus)
    throws RemoteException;

  public abstract void zzV(boolean paramBoolean)
    throws RemoteException;

  public static abstract class zza extends Binder
    implements zzj
  {
    public zza()
    {
      attachInterface(this, "com.google.android.gms.drive.realtime.internal.IBooleanCallback");
    }

    public static zzj zzcx(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IBooleanCallback");
      if ((localIInterface != null) && ((localIInterface instanceof zzj)))
        return (zzj)localIInterface;
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
        paramParcel2.writeString("com.google.android.gms.drive.realtime.internal.IBooleanCallback");
        return true;
      case 1:
        paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IBooleanCallback");
        if (paramParcel1.readInt() != 0);
        for (boolean bool = true; ; bool = false)
        {
          zzV(bool);
          paramParcel2.writeNoException();
          return true;
        }
      case 2:
      }
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IBooleanCallback");
      if (paramParcel1.readInt() != 0);
      for (paramParcel1 = (Status)Status.CREATOR.createFromParcel(paramParcel1); ; paramParcel1 = null)
      {
        zzQ(paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    }

    private static class zza
      implements zzj
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

      public void zzQ(Status paramStatus)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IBooleanCallback");
          if (paramStatus != null)
          {
            localParcel1.writeInt(1);
            paramStatus.writeToParcel(localParcel1, 0);
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
        throw paramStatus;
      }

      public void zzV(boolean paramBoolean)
        throws RemoteException
      {
        int i = 1;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IBooleanCallback");
          if (paramBoolean);
          while (true)
          {
            localParcel1.writeInt(i);
            zznF.transact(1, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
            i = 0;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
    }
  }
}