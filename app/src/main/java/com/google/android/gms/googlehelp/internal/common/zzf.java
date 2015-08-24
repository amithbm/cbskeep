package com.google.android.gms.googlehelp.internal.common;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.googlehelp.GoogleHelp;

public abstract interface zzf extends IInterface
{
  public abstract void zza(Bitmap paramBitmap, zze paramzze)
    throws RemoteException;

  public abstract void zza(GoogleHelp paramGoogleHelp, Bitmap paramBitmap, zze paramzze)
    throws RemoteException;

  public abstract void zza(GoogleHelp paramGoogleHelp, zze paramzze)
    throws RemoteException;

  public abstract void zza(zze paramzze)
    throws RemoteException;

  public abstract void zzb(zze paramzze)
    throws RemoteException;

  public abstract void zzc(zze paramzze)
    throws RemoteException;

  public static abstract class zza extends Binder
    implements zzf
  {
    public static zzf zzdB(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.googlehelp.internal.common.IGoogleHelpService");
      if ((localIInterface != null) && ((localIInterface instanceof zzf)))
        return (zzf)localIInterface;
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
        paramParcel2.writeString("com.google.android.gms.googlehelp.internal.common.IGoogleHelpService");
        return true;
      case 1:
        paramParcel1.enforceInterface("com.google.android.gms.googlehelp.internal.common.IGoogleHelpService");
        if (paramParcel1.readInt() != 0);
        for (localObject = (GoogleHelp)GoogleHelp.CREATOR.createFromParcel(paramParcel1); ; localObject = null)
        {
          zza((GoogleHelp)localObject, zze.zza.asInterface(paramParcel1.readStrongBinder()));
          paramParcel2.writeNoException();
          return true;
        }
      case 2:
        paramParcel1.enforceInterface("com.google.android.gms.googlehelp.internal.common.IGoogleHelpService");
        if (paramParcel1.readInt() != 0)
        {
          localObject = (GoogleHelp)GoogleHelp.CREATOR.createFromParcel(paramParcel1);
          if (paramParcel1.readInt() == 0)
            break label213;
        }
        for (Bitmap localBitmap = (Bitmap)Bitmap.CREATOR.createFromParcel(paramParcel1); ; localBitmap = null)
        {
          zza((GoogleHelp)localObject, localBitmap, zze.zza.asInterface(paramParcel1.readStrongBinder()));
          paramParcel2.writeNoException();
          return true;
          localObject = null;
          break;
        }
      case 3:
        paramParcel1.enforceInterface("com.google.android.gms.googlehelp.internal.common.IGoogleHelpService");
        if (paramParcel1.readInt() != 0);
        for (localObject = (Bitmap)Bitmap.CREATOR.createFromParcel(paramParcel1); ; localObject = null)
        {
          zza((Bitmap)localObject, zze.zza.asInterface(paramParcel1.readStrongBinder()));
          paramParcel2.writeNoException();
          return true;
        }
      case 4:
        paramParcel1.enforceInterface("com.google.android.gms.googlehelp.internal.common.IGoogleHelpService");
        zza(zze.zza.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 5:
        label213: paramParcel1.enforceInterface("com.google.android.gms.googlehelp.internal.common.IGoogleHelpService");
        zzb(zze.zza.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 6:
      }
      paramParcel1.enforceInterface("com.google.android.gms.googlehelp.internal.common.IGoogleHelpService");
      zzc(zze.zza.asInterface(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    }

    private static class zza
      implements zzf
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

      public void zza(Bitmap paramBitmap, zze paramzze)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.googlehelp.internal.common.IGoogleHelpService");
            if (paramBitmap != null)
            {
              localParcel1.writeInt(1);
              paramBitmap.writeToParcel(localParcel1, 0);
              if (paramzze != null)
              {
                paramBitmap = paramzze.asBinder();
                localParcel1.writeStrongBinder(paramBitmap);
                zznF.transact(3, localParcel1, localParcel2, 0);
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
          paramBitmap = null;
        }
      }

      public void zza(GoogleHelp paramGoogleHelp, Bitmap paramBitmap, zze paramzze)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.googlehelp.internal.common.IGoogleHelpService");
            if (paramGoogleHelp != null)
            {
              localParcel1.writeInt(1);
              paramGoogleHelp.writeToParcel(localParcel1, 0);
              if (paramBitmap != null)
              {
                localParcel1.writeInt(1);
                paramBitmap.writeToParcel(localParcel1, 0);
                if (paramzze == null)
                  break label131;
                paramGoogleHelp = paramzze.asBinder();
                localParcel1.writeStrongBinder(paramGoogleHelp);
                zznF.transact(2, localParcel1, localParcel2, 0);
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
          localParcel1.writeInt(0);
          continue;
          label131: paramGoogleHelp = null;
        }
      }

      public void zza(GoogleHelp paramGoogleHelp, zze paramzze)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.googlehelp.internal.common.IGoogleHelpService");
            if (paramGoogleHelp != null)
            {
              localParcel1.writeInt(1);
              paramGoogleHelp.writeToParcel(localParcel1, 0);
              if (paramzze != null)
              {
                paramGoogleHelp = paramzze.asBinder();
                localParcel1.writeStrongBinder(paramGoogleHelp);
                zznF.transact(1, localParcel1, localParcel2, 0);
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
          paramGoogleHelp = null;
        }
      }

      public void zza(zze paramzze)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.googlehelp.internal.common.IGoogleHelpService");
          if (paramzze != null);
          for (paramzze = paramzze.asBinder(); ; paramzze = null)
          {
            localParcel1.writeStrongBinder(paramzze);
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
        throw paramzze;
      }

      public void zzb(zze paramzze)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.googlehelp.internal.common.IGoogleHelpService");
          if (paramzze != null);
          for (paramzze = paramzze.asBinder(); ; paramzze = null)
          {
            localParcel1.writeStrongBinder(paramzze);
            zznF.transact(5, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzze;
      }

      public void zzc(zze paramzze)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.googlehelp.internal.common.IGoogleHelpService");
          if (paramzze != null);
          for (paramzze = paramzze.asBinder(); ; paramzze = null)
          {
            localParcel1.writeStrongBinder(paramzze);
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
        throw paramzze;
      }
    }
  }
}