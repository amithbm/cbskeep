package com.google.android.gms.nearby.sharing.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.nearby.sharing.AppContentReceivedResult;

public abstract interface zzb extends IInterface
{
  public abstract void onContentReceived(AppContentReceivedResult paramAppContentReceivedResult)
    throws RemoteException;

  public abstract String zzdQ(String paramString)
    throws RemoteException;

  public static abstract class zza extends Binder
    implements zzb
  {
    public static zzb zzfr(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.nearby.sharing.internal.IAppContentReceiver");
      if ((localIInterface != null) && ((localIInterface instanceof zzb)))
        return (zzb)localIInterface;
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
        paramParcel2.writeString("com.google.android.gms.nearby.sharing.internal.IAppContentReceiver");
        return true;
      case 1:
        paramParcel1.enforceInterface("com.google.android.gms.nearby.sharing.internal.IAppContentReceiver");
        paramParcel1 = zzdQ(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 2:
      }
      paramParcel1.enforceInterface("com.google.android.gms.nearby.sharing.internal.IAppContentReceiver");
      if (paramParcel1.readInt() != 0);
      for (paramParcel1 = (AppContentReceivedResult)AppContentReceivedResult.CREATOR.createFromParcel(paramParcel1); ; paramParcel1 = null)
      {
        onContentReceived(paramParcel1);
        return true;
      }
    }

    private static class zza
      implements zzb
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

      public void onContentReceived(AppContentReceivedResult paramAppContentReceivedResult)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.nearby.sharing.internal.IAppContentReceiver");
          if (paramAppContentReceivedResult != null)
          {
            localParcel.writeInt(1);
            paramAppContentReceivedResult.writeToParcel(localParcel, 0);
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
        throw paramAppContentReceivedResult;
      }

      public String zzdQ(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.nearby.sharing.internal.IAppContentReceiver");
          localParcel1.writeString(paramString);
          zznF.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramString = localParcel2.readString();
          return paramString;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramString;
      }
    }
  }
}