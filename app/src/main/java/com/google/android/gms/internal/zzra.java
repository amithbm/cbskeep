package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.nearby.connection.AppMetadata;

public abstract interface zzra extends IInterface
{
  public abstract String zzAn()
    throws RemoteException;

  public abstract void zzO(long paramLong)
    throws RemoteException;

  public abstract void zzZ(long paramLong)
    throws RemoteException;

  public abstract void zza(zzqz paramzzqz, int paramInt, long paramLong1, long paramLong2)
    throws RemoteException;

  public abstract void zza(zzqz paramzzqz, String paramString, long paramLong)
    throws RemoteException;

  public abstract void zza(zzqz paramzzqz, String paramString, long paramLong1, long paramLong2)
    throws RemoteException;

  public abstract void zza(zzqz paramzzqz, String paramString, AppMetadata paramAppMetadata, long paramLong1, long paramLong2)
    throws RemoteException;

  public abstract void zza(zzqz paramzzqz, String paramString1, String paramString2, byte[] paramArrayOfByte, long paramLong)
    throws RemoteException;

  public abstract void zza(zzqz paramzzqz, String paramString, byte[] paramArrayOfByte, long paramLong)
    throws RemoteException;

  public abstract void zza(String[] paramArrayOfString, byte[] paramArrayOfByte, long paramLong)
    throws RemoteException;

  public abstract void zzaa(long paramLong)
    throws RemoteException;

  public abstract void zzab(long paramLong)
    throws RemoteException;

  public abstract String zzac(long paramLong)
    throws RemoteException;

  public abstract void zzb(String[] paramArrayOfString, byte[] paramArrayOfByte, long paramLong)
    throws RemoteException;

  public abstract void zzf(String paramString, long paramLong)
    throws RemoteException;

  public abstract void zzg(String paramString, long paramLong)
    throws RemoteException;

  public static abstract class zza extends Binder
    implements zzra
  {
    public static zzra zzfm(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
      if ((localIInterface != null) && ((localIInterface instanceof zzra)))
        return (zzra)localIInterface;
      return new zza(paramIBinder);
    }

    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      switch (paramInt1)
      {
      default:
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902:
        paramParcel2.writeString("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
        return true;
      case 1001:
        paramParcel1.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
        zzqz localzzqz = zzqz.zza.zzfl(paramParcel1.readStrongBinder());
        String str = paramParcel1.readString();
        if (paramParcel1.readInt() != 0);
        for (AppMetadata localAppMetadata = (AppMetadata)AppMetadata.CREATOR.createFromParcel(paramParcel1); ; localAppMetadata = null)
        {
          zza(localzzqz, str, localAppMetadata, paramParcel1.readLong(), paramParcel1.readLong());
          paramParcel2.writeNoException();
          return true;
        }
      case 1002:
        paramParcel1.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
        zzZ(paramParcel1.readLong());
        paramParcel2.writeNoException();
        return true;
      case 1003:
        paramParcel1.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
        zza(zzqz.zza.zzfl(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readLong(), paramParcel1.readLong());
        paramParcel2.writeNoException();
        return true;
      case 1004:
        paramParcel1.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
        zzf(paramParcel1.readString(), paramParcel1.readLong());
        paramParcel2.writeNoException();
        return true;
      case 1005:
        paramParcel1.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
        zza(zzqz.zza.zzfl(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readLong(), paramParcel1.readLong());
        paramParcel2.writeNoException();
        return true;
      case 1006:
        paramParcel1.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
        zzaa(paramParcel1.readLong());
        paramParcel2.writeNoException();
        return true;
      case 1007:
        paramParcel1.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
        zza(zzqz.zza.zzfl(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.createByteArray(), paramParcel1.readLong());
        paramParcel2.writeNoException();
        return true;
      case 1008:
        paramParcel1.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
        zza(zzqz.zza.zzfl(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.createByteArray(), paramParcel1.readLong());
        paramParcel2.writeNoException();
        return true;
      case 1009:
        paramParcel1.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
        zza(zzqz.zza.zzfl(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readLong());
        paramParcel2.writeNoException();
        return true;
      case 1010:
        paramParcel1.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
        zza(paramParcel1.createStringArray(), paramParcel1.createByteArray(), paramParcel1.readLong());
        paramParcel2.writeNoException();
        return true;
      case 1011:
        paramParcel1.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
        zzb(paramParcel1.createStringArray(), paramParcel1.createByteArray(), paramParcel1.readLong());
        paramParcel2.writeNoException();
        return true;
      case 1012:
        paramParcel1.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
        zzg(paramParcel1.readString(), paramParcel1.readLong());
        paramParcel2.writeNoException();
        return true;
      case 1013:
        paramParcel1.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
        zzab(paramParcel1.readLong());
        paramParcel2.writeNoException();
        return true;
      case 1014:
        paramParcel1.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
        zzO(paramParcel1.readLong());
        paramParcel2.writeNoException();
        return true;
      case 1015:
        paramParcel1.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
        paramParcel1 = zzac(paramParcel1.readLong());
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 1016:
      }
      paramParcel1.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
      paramParcel1 = zzAn();
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    }

    private static class zza
      implements zzra
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

      public String zzAn()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
          zznF.transact(1016, localParcel1, localParcel2, 0);
          localParcel2.readException();
          String str = localParcel2.readString();
          return str;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void zzO(long paramLong)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
          localParcel1.writeLong(paramLong);
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

      public void zzZ(long paramLong)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
          localParcel1.writeLong(paramLong);
          zznF.transact(1002, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void zza(zzqz paramzzqz, int paramInt, long paramLong1, long paramLong2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
          if (paramzzqz != null);
          for (paramzzqz = paramzzqz.asBinder(); ; paramzzqz = null)
          {
            localParcel1.writeStrongBinder(paramzzqz);
            localParcel1.writeInt(paramInt);
            localParcel1.writeLong(paramLong1);
            localParcel1.writeLong(paramLong2);
            zznF.transact(1005, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzqz;
      }

      public void zza(zzqz paramzzqz, String paramString, long paramLong)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
          if (paramzzqz != null);
          for (paramzzqz = paramzzqz.asBinder(); ; paramzzqz = null)
          {
            localParcel1.writeStrongBinder(paramzzqz);
            localParcel1.writeString(paramString);
            localParcel1.writeLong(paramLong);
            zznF.transact(1009, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzqz;
      }

      public void zza(zzqz paramzzqz, String paramString, long paramLong1, long paramLong2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
          if (paramzzqz != null);
          for (paramzzqz = paramzzqz.asBinder(); ; paramzzqz = null)
          {
            localParcel1.writeStrongBinder(paramzzqz);
            localParcel1.writeString(paramString);
            localParcel1.writeLong(paramLong1);
            localParcel1.writeLong(paramLong2);
            zznF.transact(1003, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzqz;
      }

      public void zza(zzqz paramzzqz, String paramString, AppMetadata paramAppMetadata, long paramLong1, long paramLong2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
          if (paramzzqz != null)
          {
            paramzzqz = paramzzqz.asBinder();
            localParcel1.writeStrongBinder(paramzzqz);
            localParcel1.writeString(paramString);
            if (paramAppMetadata == null)
              break label110;
            localParcel1.writeInt(1);
            paramAppMetadata.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            localParcel1.writeLong(paramLong1);
            localParcel1.writeLong(paramLong2);
            zznF.transact(1001, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
            paramzzqz = null;
            break;
            label110: localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzqz;
      }

      public void zza(zzqz paramzzqz, String paramString1, String paramString2, byte[] paramArrayOfByte, long paramLong)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
          if (paramzzqz != null);
          for (paramzzqz = paramzzqz.asBinder(); ; paramzzqz = null)
          {
            localParcel1.writeStrongBinder(paramzzqz);
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            localParcel1.writeByteArray(paramArrayOfByte);
            localParcel1.writeLong(paramLong);
            zznF.transact(1007, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzqz;
      }

      public void zza(zzqz paramzzqz, String paramString, byte[] paramArrayOfByte, long paramLong)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
          if (paramzzqz != null);
          for (paramzzqz = paramzzqz.asBinder(); ; paramzzqz = null)
          {
            localParcel1.writeStrongBinder(paramzzqz);
            localParcel1.writeString(paramString);
            localParcel1.writeByteArray(paramArrayOfByte);
            localParcel1.writeLong(paramLong);
            zznF.transact(1008, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzqz;
      }

      public void zza(String[] paramArrayOfString, byte[] paramArrayOfByte, long paramLong)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
          localParcel1.writeStringArray(paramArrayOfString);
          localParcel1.writeByteArray(paramArrayOfByte);
          localParcel1.writeLong(paramLong);
          zznF.transact(1010, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramArrayOfString;
      }

      public void zzaa(long paramLong)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
          localParcel1.writeLong(paramLong);
          zznF.transact(1006, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void zzab(long paramLong)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
          localParcel1.writeLong(paramLong);
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

      public String zzac(long paramLong)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
          localParcel1.writeLong(paramLong);
          zznF.transact(1015, localParcel1, localParcel2, 0);
          localParcel2.readException();
          String str = localParcel2.readString();
          return str;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void zzb(String[] paramArrayOfString, byte[] paramArrayOfByte, long paramLong)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
          localParcel1.writeStringArray(paramArrayOfString);
          localParcel1.writeByteArray(paramArrayOfByte);
          localParcel1.writeLong(paramLong);
          zznF.transact(1011, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramArrayOfString;
      }

      public void zzf(String paramString, long paramLong)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
          localParcel1.writeString(paramString);
          localParcel1.writeLong(paramLong);
          zznF.transact(1004, localParcel1, localParcel2, 0);
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

      public void zzg(String paramString, long paramLong)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
          localParcel1.writeString(paramString);
          localParcel1.writeLong(paramLong);
          zznF.transact(1012, localParcel1, localParcel2, 0);
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
    }
  }
}