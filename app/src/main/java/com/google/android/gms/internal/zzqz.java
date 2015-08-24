package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.nearby.connection.AppMetadata;

public abstract interface zzqz extends IInterface
{
  public abstract void onConnectionRequest(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte)
    throws RemoteException;

  public abstract void onDisconnected(String paramString)
    throws RemoteException;

  public abstract void onEndpointFound(String paramString1, String paramString2, String paramString3, String paramString4)
    throws RemoteException;

  public abstract void onEndpointLost(String paramString)
    throws RemoteException;

  public abstract void onMessageReceived(String paramString, byte[] paramArrayOfByte, boolean paramBoolean)
    throws RemoteException;

  public abstract void zza(String paramString, int paramInt, byte[] paramArrayOfByte)
    throws RemoteException;

  public abstract void zza(String paramString1, String paramString2, String paramString3, String paramString4, AppMetadata paramAppMetadata)
    throws RemoteException;

  public abstract void zzdM(String paramString)
    throws RemoteException;

  public abstract void zzl(int paramInt, String paramString)
    throws RemoteException;

  public abstract void zzmM(int paramInt)
    throws RemoteException;

  public abstract void zzmN(int paramInt)
    throws RemoteException;

  public abstract void zzmO(int paramInt)
    throws RemoteException;

  public abstract void zzmP(int paramInt)
    throws RemoteException;

  public abstract void zzmQ(int paramInt)
    throws RemoteException;

  public static abstract class zza extends Binder
    implements zzqz
  {
    public static zzqz zzfl(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
      if ((localIInterface != null) && ((localIInterface instanceof zzqz)))
        return (zzqz)localIInterface;
      return new zza(paramIBinder);
    }

    public IBinder asBinder()
    {
      return this;
    }

    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      String str1;
      Object localObject;
      switch (paramInt1)
      {
      default:
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902:
        paramParcel2.writeString("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
        return true;
      case 1001:
        paramParcel1.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
        onConnectionRequest(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.createByteArray());
        paramParcel2.writeNoException();
        return true;
      case 1002:
        paramParcel1.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
        onEndpointFound(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 1003:
        paramParcel1.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
        onEndpointLost(paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 1004:
        paramParcel1.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
        str1 = paramParcel1.readString();
        localObject = paramParcel1.readString();
        String str2 = paramParcel1.readString();
        String str3 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0);
        for (paramParcel1 = (AppMetadata)AppMetadata.CREATOR.createFromParcel(paramParcel1); ; paramParcel1 = null)
        {
          zza(str1, (String)localObject, str2, str3, paramParcel1);
          paramParcel2.writeNoException();
          return true;
        }
      case 1005:
        paramParcel1.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
        zzdM(paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 1006:
        paramParcel1.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
        zza(paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.createByteArray());
        paramParcel2.writeNoException();
        return true;
      case 1007:
        paramParcel1.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
        str1 = paramParcel1.readString();
        localObject = paramParcel1.createByteArray();
        if (paramParcel1.readInt() != 0);
        for (boolean bool = true; ; bool = false)
        {
          onMessageReceived(str1, (byte[])localObject, bool);
          paramParcel2.writeNoException();
          return true;
        }
      case 1008:
        paramParcel1.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
        onDisconnected(paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 1009:
        paramParcel1.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
        zzl(paramParcel1.readInt(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 1010:
        paramParcel1.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
        zzmM(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 1011:
        paramParcel1.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
        zzmN(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 1012:
        paramParcel1.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
        zzmO(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 1013:
        paramParcel1.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
        zzmP(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 1014:
      }
      paramParcel1.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
      zzmQ(paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    }

    private static class zza
      implements zzqz
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

      public void onConnectionRequest(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          localParcel1.writeString(paramString3);
          localParcel1.writeByteArray(paramArrayOfByte);
          zznF.transact(1001, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramString1;
      }

      public void onDisconnected(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
          localParcel1.writeString(paramString);
          zznF.transact(1008, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramString;
      }

      public void onEndpointFound(String paramString1, String paramString2, String paramString3, String paramString4)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          localParcel1.writeString(paramString3);
          localParcel1.writeString(paramString4);
          zznF.transact(1002, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramString1;
      }

      public void onEndpointLost(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
          localParcel1.writeString(paramString);
          zznF.transact(1003, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramString;
      }

      public void onMessageReceived(String paramString, byte[] paramArrayOfByte, boolean paramBoolean)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
          localParcel1.writeString(paramString);
          localParcel1.writeByteArray(paramArrayOfByte);
          if (paramBoolean)
            i = 1;
          localParcel1.writeInt(i);
          zznF.transact(1007, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramString;
      }

      public void zza(String paramString, int paramInt, byte[] paramArrayOfByte)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
          localParcel1.writeString(paramString);
          localParcel1.writeInt(paramInt);
          localParcel1.writeByteArray(paramArrayOfByte);
          zznF.transact(1006, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramString;
      }

      public void zza(String paramString1, String paramString2, String paramString3, String paramString4, AppMetadata paramAppMetadata)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          localParcel1.writeString(paramString3);
          localParcel1.writeString(paramString4);
          if (paramAppMetadata != null)
          {
            localParcel1.writeInt(1);
            paramAppMetadata.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            zznF.transact(1004, localParcel1, localParcel2, 0);
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
        throw paramString1;
      }

      public void zzdM(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
          localParcel1.writeString(paramString);
          zznF.transact(1005, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramString;
      }

      public void zzl(int paramInt, String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
          localParcel1.writeInt(paramInt);
          localParcel1.writeString(paramString);
          zznF.transact(1009, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramString;
      }

      public void zzmM(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
          localParcel1.writeInt(paramInt);
          zznF.transact(1010, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void zzmN(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
          localParcel1.writeInt(paramInt);
          zznF.transact(1011, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void zzmO(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
          localParcel1.writeInt(paramInt);
          zznF.transact(1012, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void zzmP(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
          localParcel1.writeInt(paramInt);
          zznF.transact(1013, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void zzmQ(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
          localParcel1.writeInt(paramInt);
          zznF.transact(1014, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
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