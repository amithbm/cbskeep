package com.google.android.gms.googlehelp.internal.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.googlehelp.GoogleHelp;

public abstract interface zze extends IInterface
{
  public abstract void onGoogleHelpProcessed(GoogleHelp paramGoogleHelp)
    throws RemoteException;

  public abstract void onPipClick()
    throws RemoteException;

  public abstract void onPipInCallingAppDisabled()
    throws RemoteException;

  public abstract void onPipInCallingAppHidden()
    throws RemoteException;

  public abstract void onPipShown()
    throws RemoteException;

  public abstract void onTogglingPipProcessed(TogglingData paramTogglingData)
    throws RemoteException;

  public static abstract class zza extends Binder
    implements zze
  {
    public zza()
    {
      attachInterface(this, "com.google.android.gms.googlehelp.internal.common.IGoogleHelpCallbacks");
    }

    public static zze asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.googlehelp.internal.common.IGoogleHelpCallbacks");
      if ((localIInterface != null) && ((localIInterface instanceof zze)))
        return (zze)localIInterface;
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
        paramParcel2.writeString("com.google.android.gms.googlehelp.internal.common.IGoogleHelpCallbacks");
        return true;
      case 1:
        paramParcel1.enforceInterface("com.google.android.gms.googlehelp.internal.common.IGoogleHelpCallbacks");
        if (paramParcel1.readInt() != 0)
          localObject1 = (GoogleHelp)GoogleHelp.CREATOR.createFromParcel(paramParcel1);
        onGoogleHelpProcessed((GoogleHelp)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 2:
        paramParcel1.enforceInterface("com.google.android.gms.googlehelp.internal.common.IGoogleHelpCallbacks");
        localObject1 = localObject2;
        if (paramParcel1.readInt() != 0)
          localObject1 = (TogglingData)TogglingData.CREATOR.createFromParcel(paramParcel1);
        onTogglingPipProcessed((TogglingData)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 3:
        paramParcel1.enforceInterface("com.google.android.gms.googlehelp.internal.common.IGoogleHelpCallbacks");
        onPipShown();
        paramParcel2.writeNoException();
        return true;
      case 4:
        paramParcel1.enforceInterface("com.google.android.gms.googlehelp.internal.common.IGoogleHelpCallbacks");
        onPipClick();
        paramParcel2.writeNoException();
        return true;
      case 5:
        paramParcel1.enforceInterface("com.google.android.gms.googlehelp.internal.common.IGoogleHelpCallbacks");
        onPipInCallingAppHidden();
        paramParcel2.writeNoException();
        return true;
      case 6:
      }
      paramParcel1.enforceInterface("com.google.android.gms.googlehelp.internal.common.IGoogleHelpCallbacks");
      onPipInCallingAppDisabled();
      paramParcel2.writeNoException();
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

      public void onGoogleHelpProcessed(GoogleHelp paramGoogleHelp)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.googlehelp.internal.common.IGoogleHelpCallbacks");
          if (paramGoogleHelp != null)
          {
            localParcel1.writeInt(1);
            paramGoogleHelp.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            zznF.transact(1, localParcel1, localParcel2, 0);
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
        throw paramGoogleHelp;
      }

      public void onPipClick()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.googlehelp.internal.common.IGoogleHelpCallbacks");
          zznF.transact(4, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void onPipInCallingAppDisabled()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.googlehelp.internal.common.IGoogleHelpCallbacks");
          zznF.transact(6, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void onPipInCallingAppHidden()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.googlehelp.internal.common.IGoogleHelpCallbacks");
          zznF.transact(5, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void onPipShown()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.googlehelp.internal.common.IGoogleHelpCallbacks");
          zznF.transact(3, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void onTogglingPipProcessed(TogglingData paramTogglingData)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.googlehelp.internal.common.IGoogleHelpCallbacks");
          if (paramTogglingData != null)
          {
            localParcel1.writeInt(1);
            paramTogglingData.writeToParcel(localParcel1, 0);
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
        throw paramTogglingData;
      }
    }
  }
}