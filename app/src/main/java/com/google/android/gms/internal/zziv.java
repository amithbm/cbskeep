package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.appdatasearch.GetRecentContextCall.Request;
import com.google.android.gms.appdatasearch.UsageInfo;
import com.google.android.gms.appdatasearch.zzi;

public abstract interface zziv extends IInterface
{
  public abstract void zza(GetRecentContextCall.Request paramRequest, zziw paramzziw)
    throws RemoteException;

  public abstract void zza(zziw paramzziw)
    throws RemoteException;

  public abstract void zza(zziw paramzziw, String paramString1, String paramString2)
    throws RemoteException;

  public abstract void zza(zziw paramzziw, String paramString, UsageInfo[] paramArrayOfUsageInfo)
    throws RemoteException;

  public abstract void zza(zziw paramzziw, boolean paramBoolean)
    throws RemoteException;

  public abstract void zzb(zziw paramzziw)
    throws RemoteException;

  public static abstract class zza extends Binder
    implements zziv
  {
    public static zziv zzah(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
      if ((localIInterface != null) && ((localIInterface instanceof zziv)))
        return (zziv)localIInterface;
      return new zza(paramIBinder);
    }

    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      Object localObject;
      switch (paramInt1)
      {
      default:
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902:
        paramParcel2.writeString("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
        return true;
      case 1:
        paramParcel1.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
        zza(zziw.zza.zzai(paramParcel1.readStrongBinder()), paramParcel1.readString(), (UsageInfo[])paramParcel1.createTypedArray(UsageInfo.CREATOR));
        paramParcel2.writeNoException();
        return true;
      case 2:
        paramParcel1.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
        zza(zziw.zza.zzai(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 3:
        paramParcel1.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
        zzb(zziw.zza.zzai(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 4:
        paramParcel1.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
        localObject = zziw.zza.zzai(paramParcel1.readStrongBinder());
        if (paramParcel1.readInt() != 0);
        for (boolean bool = true; ; bool = false)
        {
          zza((zziw)localObject, bool);
          paramParcel2.writeNoException();
          return true;
        }
      case 5:
        paramParcel1.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
        if (paramParcel1.readInt() != 0);
        for (localObject = GetRecentContextCall.Request.CREATOR.zzA(paramParcel1); ; localObject = null)
        {
          zza((GetRecentContextCall.Request)localObject, zziw.zza.zzai(paramParcel1.readStrongBinder()));
          paramParcel2.writeNoException();
          return true;
        }
      case 6:
      }
      paramParcel1.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
      zza(zziw.zza.zzai(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    }

    private static class zza
      implements zziv
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

      public void zza(GetRecentContextCall.Request paramRequest, zziw paramzziw)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
            if (paramRequest != null)
            {
              localParcel1.writeInt(1);
              paramRequest.writeToParcel(localParcel1, 0);
              if (paramzziw != null)
              {
                paramRequest = paramzziw.asBinder();
                localParcel1.writeStrongBinder(paramRequest);
                zznF.transact(5, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
          paramRequest = null;
        }
      }

      public void zza(zziw paramzziw)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
          if (paramzziw != null);
          for (paramzziw = paramzziw.asBinder(); ; paramzziw = null)
          {
            localParcel1.writeStrongBinder(paramzziw);
            zznF.transact(2, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzziw;
      }

      public void zza(zziw paramzziw, String paramString1, String paramString2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
          if (paramzziw != null);
          for (paramzziw = paramzziw.asBinder(); ; paramzziw = null)
          {
            localParcel1.writeStrongBinder(paramzziw);
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            zznF.transact(6, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzziw;
      }

      public void zza(zziw paramzziw, String paramString, UsageInfo[] paramArrayOfUsageInfo)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
          if (paramzziw != null);
          for (paramzziw = paramzziw.asBinder(); ; paramzziw = null)
          {
            localParcel1.writeStrongBinder(paramzziw);
            localParcel1.writeString(paramString);
            localParcel1.writeTypedArray(paramArrayOfUsageInfo, 0);
            zznF.transact(1, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzziw;
      }

      public void zza(zziw paramzziw, boolean paramBoolean)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
          if (paramzziw != null);
          for (paramzziw = paramzziw.asBinder(); ; paramzziw = null)
          {
            localParcel1.writeStrongBinder(paramzziw);
            if (paramBoolean)
              i = 1;
            localParcel1.writeInt(i);
            zznF.transact(4, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzziw;
      }

      public void zzb(zziw paramzziw)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
          if (paramzziw != null);
          for (paramzziw = paramzziw.asBinder(); ; paramzziw = null)
          {
            localParcel1.writeStrongBinder(paramzziw);
            zznF.transact(3, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzziw;
      }
    }
  }
}