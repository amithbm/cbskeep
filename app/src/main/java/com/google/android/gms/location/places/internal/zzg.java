package com.google.android.gms.location.places.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.location.places.PlacePhotoMetadataResult;
import com.google.android.gms.location.places.PlacePhotoResult;

public abstract interface zzg extends IInterface
{
  public abstract void zza(PlacePhotoMetadataResult paramPlacePhotoMetadataResult)
    throws RemoteException;

  public abstract void zza(PlacePhotoResult paramPlacePhotoResult)
    throws RemoteException;

  public static abstract class zza extends Binder
    implements zzg
  {
    public static zzg zzef(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.location.places.internal.IPhotosCallbacks");
      if ((localIInterface != null) && ((localIInterface instanceof zzg)))
        return (zzg)localIInterface;
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
        paramParcel2.writeString("com.google.android.gms.location.places.internal.IPhotosCallbacks");
        return true;
      case 3:
        paramParcel1.enforceInterface("com.google.android.gms.location.places.internal.IPhotosCallbacks");
        paramParcel2 = localObject1;
        if (paramParcel1.readInt() != 0)
          paramParcel2 = (PlacePhotoMetadataResult)PlacePhotoMetadataResult.CREATOR.createFromParcel(paramParcel1);
        zza(paramParcel2);
        return true;
      case 2:
      }
      paramParcel1.enforceInterface("com.google.android.gms.location.places.internal.IPhotosCallbacks");
      paramParcel2 = localObject2;
      if (paramParcel1.readInt() != 0)
        paramParcel2 = (PlacePhotoResult)PlacePhotoResult.CREATOR.createFromParcel(paramParcel1);
      zza(paramParcel2);
      return true;
    }

    private static class zza
      implements zzg
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

      public void zza(PlacePhotoMetadataResult paramPlacePhotoMetadataResult)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IPhotosCallbacks");
          if (paramPlacePhotoMetadataResult != null)
          {
            localParcel.writeInt(1);
            paramPlacePhotoMetadataResult.writeToParcel(localParcel, 0);
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
        throw paramPlacePhotoMetadataResult;
      }

      public void zza(PlacePhotoResult paramPlacePhotoResult)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IPhotosCallbacks");
          if (paramPlacePhotoResult != null)
          {
            localParcel.writeInt(1);
            paramPlacePhotoResult.writeToParcel(localParcel, 0);
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
        throw paramPlacePhotoResult;
      }
    }
  }
}