package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.ConnectionConfiguration;
import com.google.android.gms.wearable.PutDataRequest;

public abstract interface zzat extends IInterface
{
  public abstract void zza(zzar paramzzar)
    throws RemoteException;

  public abstract void zza(zzar paramzzar, int paramInt)
    throws RemoteException;

  public abstract void zza(zzar paramzzar, Uri paramUri)
    throws RemoteException;

  public abstract void zza(zzar paramzzar, Uri paramUri, int paramInt)
    throws RemoteException;

  public abstract void zza(zzar paramzzar, Asset paramAsset)
    throws RemoteException;

  public abstract void zza(zzar paramzzar, ConnectionConfiguration paramConnectionConfiguration)
    throws RemoteException;

  public abstract void zza(zzar paramzzar, PutDataRequest paramPutDataRequest)
    throws RemoteException;

  public abstract void zza(zzar paramzzar, AddListenerRequest paramAddListenerRequest)
    throws RemoteException;

  public abstract void zza(zzar paramzzar, AncsNotificationParcelable paramAncsNotificationParcelable)
    throws RemoteException;

  public abstract void zza(zzar paramzzar, RemoveListenerRequest paramRemoveListenerRequest)
    throws RemoteException;

  public abstract void zza(zzar paramzzar, zzaq paramzzaq, String paramString)
    throws RemoteException;

  public abstract void zza(zzar paramzzar, String paramString)
    throws RemoteException;

  public abstract void zza(zzar paramzzar, String paramString, int paramInt)
    throws RemoteException;

  public abstract void zza(zzar paramzzar, String paramString, ParcelFileDescriptor paramParcelFileDescriptor)
    throws RemoteException;

  public abstract void zza(zzar paramzzar, String paramString, ParcelFileDescriptor paramParcelFileDescriptor, long paramLong1, long paramLong2)
    throws RemoteException;

  public abstract void zza(zzar paramzzar, String paramString1, String paramString2)
    throws RemoteException;

  public abstract void zza(zzar paramzzar, String paramString1, String paramString2, byte[] paramArrayOfByte)
    throws RemoteException;

  public abstract void zza(zzar paramzzar, boolean paramBoolean)
    throws RemoteException;

  public abstract void zzb(zzar paramzzar)
    throws RemoteException;

  public abstract void zzb(zzar paramzzar, int paramInt)
    throws RemoteException;

  public abstract void zzb(zzar paramzzar, Uri paramUri)
    throws RemoteException;

  public abstract void zzb(zzar paramzzar, Uri paramUri, int paramInt)
    throws RemoteException;

  public abstract void zzb(zzar paramzzar, ConnectionConfiguration paramConnectionConfiguration)
    throws RemoteException;

  public abstract void zzb(zzar paramzzar, zzaq paramzzaq, String paramString)
    throws RemoteException;

  public abstract void zzb(zzar paramzzar, String paramString)
    throws RemoteException;

  public abstract void zzb(zzar paramzzar, String paramString, int paramInt)
    throws RemoteException;

  public abstract void zzb(zzar paramzzar, boolean paramBoolean)
    throws RemoteException;

  public abstract void zzc(zzar paramzzar)
    throws RemoteException;

  public abstract void zzc(zzar paramzzar, int paramInt)
    throws RemoteException;

  public abstract void zzc(zzar paramzzar, Uri paramUri)
    throws RemoteException;

  public abstract void zzc(zzar paramzzar, String paramString)
    throws RemoteException;

  public abstract void zzd(zzar paramzzar)
    throws RemoteException;

  public abstract void zzd(zzar paramzzar, String paramString)
    throws RemoteException;

  public abstract void zze(zzar paramzzar)
    throws RemoteException;

  public abstract void zze(zzar paramzzar, String paramString)
    throws RemoteException;

  public abstract void zzf(zzar paramzzar)
    throws RemoteException;

  public abstract void zzf(zzar paramzzar, String paramString)
    throws RemoteException;

  public abstract void zzg(zzar paramzzar)
    throws RemoteException;

  public abstract void zzh(zzar paramzzar)
    throws RemoteException;

  public abstract void zzi(zzar paramzzar)
    throws RemoteException;

  public abstract void zzj(zzar paramzzar)
    throws RemoteException;

  public abstract void zzk(zzar paramzzar)
    throws RemoteException;

  public abstract void zzl(zzar paramzzar)
    throws RemoteException;

  public abstract void zzm(zzar paramzzar)
    throws RemoteException;

  public abstract void zzn(zzar paramzzar)
    throws RemoteException;

  public abstract void zzo(zzar paramzzar)
    throws RemoteException;

  public static abstract class zza extends Binder
    implements zzat
  {
    public static zzat zzhx(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableService");
      if ((localIInterface != null) && ((localIInterface instanceof zzat)))
        return (zzat)localIInterface;
      return new zza(paramIBinder);
    }

    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      boolean bool = false;
      Object localObject2 = null;
      Object localObject3 = null;
      Object localObject4 = null;
      Object localObject5 = null;
      Object localObject6 = null;
      Object localObject7 = null;
      Object localObject8 = null;
      Object localObject9 = null;
      Object localObject10 = null;
      Object localObject11 = null;
      Object localObject1 = null;
      Object localObject12 = null;
      zzar localzzar = null;
      switch (paramInt1)
      {
      default:
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902:
        paramParcel2.writeString("com.google.android.gms.wearable.internal.IWearableService");
        return true;
      case 20:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
        localObject2 = zzar.zza.zzhv(paramParcel1.readStrongBinder());
        localObject1 = localzzar;
        if (paramParcel1.readInt() != 0)
          localObject1 = (ConnectionConfiguration)ConnectionConfiguration.CREATOR.createFromParcel(paramParcel1);
        zza((zzar)localObject2, (ConnectionConfiguration)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 21:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
        zza(zzar.zza.zzhv(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 22:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
        zza(zzar.zza.zzhv(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 23:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
        zzb(zzar.zza.zzhv(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 24:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
        zzc(zzar.zza.zzhv(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 6:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
        localzzar = zzar.zza.zzhv(paramParcel1.readStrongBinder());
        localObject1 = localObject2;
        if (paramParcel1.readInt() != 0)
          localObject1 = (PutDataRequest)PutDataRequest.CREATOR.createFromParcel(paramParcel1);
        zza(localzzar, (PutDataRequest)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 7:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
        localzzar = zzar.zza.zzhv(paramParcel1.readStrongBinder());
        localObject1 = localObject3;
        if (paramParcel1.readInt() != 0)
          localObject1 = (Uri)Uri.CREATOR.createFromParcel(paramParcel1);
        zza(localzzar, (Uri)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 8:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
        zzb(zzar.zza.zzhv(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 9:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
        localzzar = zzar.zza.zzhv(paramParcel1.readStrongBinder());
        localObject1 = localObject4;
        if (paramParcel1.readInt() != 0)
          localObject1 = (Uri)Uri.CREATOR.createFromParcel(paramParcel1);
        zzb(localzzar, (Uri)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 40:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
        localzzar = zzar.zza.zzhv(paramParcel1.readStrongBinder());
        localObject1 = localObject5;
        if (paramParcel1.readInt() != 0)
          localObject1 = (Uri)Uri.CREATOR.createFromParcel(paramParcel1);
        zza(localzzar, (Uri)localObject1, paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 11:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
        localzzar = zzar.zza.zzhv(paramParcel1.readStrongBinder());
        localObject1 = localObject6;
        if (paramParcel1.readInt() != 0)
          localObject1 = (Uri)Uri.CREATOR.createFromParcel(paramParcel1);
        zzc(localzzar, (Uri)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 41:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
        localzzar = zzar.zza.zzhv(paramParcel1.readStrongBinder());
        localObject1 = localObject7;
        if (paramParcel1.readInt() != 0)
          localObject1 = (Uri)Uri.CREATOR.createFromParcel(paramParcel1);
        zzb(localzzar, (Uri)localObject1, paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 12:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
        zza(zzar.zza.zzhv(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.createByteArray());
        paramParcel2.writeNoException();
        return true;
      case 13:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
        localzzar = zzar.zza.zzhv(paramParcel1.readStrongBinder());
        localObject1 = localObject8;
        if (paramParcel1.readInt() != 0)
          localObject1 = (Asset)Asset.CREATOR.createFromParcel(paramParcel1);
        zza(localzzar, (Asset)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 14:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
        zzc(zzar.zza.zzhv(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 15:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
        zzd(zzar.zza.zzhv(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 42:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
        zza(zzar.zza.zzhv(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 43:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
        zza(zzar.zza.zzhv(paramParcel1.readStrongBinder()), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 46:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
        zzd(zzar.zza.zzhv(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 47:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
        zze(zzar.zza.zzhv(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 16:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
        localzzar = zzar.zza.zzhv(paramParcel1.readStrongBinder());
        localObject1 = localObject9;
        if (paramParcel1.readInt() != 0)
          localObject1 = (AddListenerRequest)AddListenerRequest.CREATOR.createFromParcel(paramParcel1);
        zza(localzzar, (AddListenerRequest)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 17:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
        localzzar = zzar.zza.zzhv(paramParcel1.readStrongBinder());
        localObject1 = localObject10;
        if (paramParcel1.readInt() != 0)
          localObject1 = (RemoveListenerRequest)RemoveListenerRequest.CREATOR.createFromParcel(paramParcel1);
        zza(localzzar, (RemoveListenerRequest)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 18:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
        zze(zzar.zza.zzhv(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 19:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
        zzf(zzar.zza.zzhv(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 25:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
        zzg(zzar.zza.zzhv(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 26:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
        zzh(zzar.zza.zzhv(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 27:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
        localzzar = zzar.zza.zzhv(paramParcel1.readStrongBinder());
        localObject1 = localObject11;
        if (paramParcel1.readInt() != 0)
          localObject1 = (AncsNotificationParcelable)AncsNotificationParcelable.CREATOR.createFromParcel(paramParcel1);
        zza(localzzar, (AncsNotificationParcelable)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 28:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
        zzb(zzar.zza.zzhv(paramParcel1.readStrongBinder()), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 29:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
        zzc(zzar.zza.zzhv(paramParcel1.readStrongBinder()), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 30:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
        zzi(zzar.zza.zzhv(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 31:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
        zza(zzar.zza.zzhv(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 32:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
        zzf(zzar.zza.zzhv(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 33:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
        zzb(zzar.zza.zzhv(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 34:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
        zza(zzar.zza.zzhv(paramParcel1.readStrongBinder()), zzaq.zza.zzhu(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 35:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
        zzb(zzar.zza.zzhv(paramParcel1.readStrongBinder()), zzaq.zza.zzhu(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 38:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
        localzzar = zzar.zza.zzhv(paramParcel1.readStrongBinder());
        localObject2 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0)
          localObject1 = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.createFromParcel(paramParcel1);
        zza(localzzar, (String)localObject2, (ParcelFileDescriptor)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 39:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
        localzzar = zzar.zza.zzhv(paramParcel1.readStrongBinder());
        localObject2 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0);
        for (localObject1 = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.createFromParcel(paramParcel1); ; localObject1 = null)
        {
          zza(localzzar, (String)localObject2, (ParcelFileDescriptor)localObject1, paramParcel1.readLong(), paramParcel1.readLong());
          paramParcel2.writeNoException();
          return true;
        }
      case 37:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
        zzj(zzar.zza.zzhv(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 48:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
        localObject1 = zzar.zza.zzhv(paramParcel1.readStrongBinder());
        if (paramParcel1.readInt() != 0);
        for (bool = true; ; bool = false)
        {
          zza((zzar)localObject1, bool);
          paramParcel2.writeNoException();
          return true;
        }
      case 49:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
        zzk(zzar.zza.zzhv(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 50:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
        localObject1 = zzar.zza.zzhv(paramParcel1.readStrongBinder());
        if (paramParcel1.readInt() != 0)
          bool = true;
        zzb((zzar)localObject1, bool);
        paramParcel2.writeNoException();
        return true;
      case 51:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
        zzl(zzar.zza.zzhv(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 2:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
        localzzar = zzar.zza.zzhv(paramParcel1.readStrongBinder());
        localObject1 = localObject12;
        if (paramParcel1.readInt() != 0)
          localObject1 = (ConnectionConfiguration)ConnectionConfiguration.CREATOR.createFromParcel(paramParcel1);
        zzb(localzzar, (ConnectionConfiguration)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 3:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
        zzm(zzar.zza.zzhv(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 4:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
        zzn(zzar.zza.zzhv(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 5:
      }
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
      zzo(zzar.zza.zzhv(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    }

    private static class zza
      implements zzat
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

      public void zza(zzar paramzzar)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
          if (paramzzar != null);
          for (paramzzar = paramzzar.asBinder(); ; paramzzar = null)
          {
            localParcel1.writeStrongBinder(paramzzar);
            zznF.transact(22, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzar;
      }

      public void zza(zzar paramzzar, int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
          if (paramzzar != null);
          for (paramzzar = paramzzar.asBinder(); ; paramzzar = null)
          {
            localParcel1.writeStrongBinder(paramzzar);
            localParcel1.writeInt(paramInt);
            zznF.transact(43, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzar;
      }

      public void zza(zzar paramzzar, Uri paramUri)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
          if (paramzzar != null)
          {
            paramzzar = paramzzar.asBinder();
            localParcel1.writeStrongBinder(paramzzar);
            if (paramUri == null)
              break label82;
            localParcel1.writeInt(1);
            paramUri.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            zznF.transact(7, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
            paramzzar = null;
            break;
            label82: localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzar;
      }

      public void zza(zzar paramzzar, Uri paramUri, int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
          if (paramzzar != null)
          {
            paramzzar = paramzzar.asBinder();
            localParcel1.writeStrongBinder(paramzzar);
            if (paramUri == null)
              break label95;
            localParcel1.writeInt(1);
            paramUri.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            localParcel1.writeInt(paramInt);
            zznF.transact(40, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
            paramzzar = null;
            break;
            label95: localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzar;
      }

      public void zza(zzar paramzzar, Asset paramAsset)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
          if (paramzzar != null)
          {
            paramzzar = paramzzar.asBinder();
            localParcel1.writeStrongBinder(paramzzar);
            if (paramAsset == null)
              break label82;
            localParcel1.writeInt(1);
            paramAsset.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            zznF.transact(13, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
            paramzzar = null;
            break;
            label82: localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzar;
      }

      public void zza(zzar paramzzar, ConnectionConfiguration paramConnectionConfiguration)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
          if (paramzzar != null)
          {
            paramzzar = paramzzar.asBinder();
            localParcel1.writeStrongBinder(paramzzar);
            if (paramConnectionConfiguration == null)
              break label82;
            localParcel1.writeInt(1);
            paramConnectionConfiguration.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            zznF.transact(20, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
            paramzzar = null;
            break;
            label82: localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzar;
      }

      public void zza(zzar paramzzar, PutDataRequest paramPutDataRequest)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
          if (paramzzar != null)
          {
            paramzzar = paramzzar.asBinder();
            localParcel1.writeStrongBinder(paramzzar);
            if (paramPutDataRequest == null)
              break label82;
            localParcel1.writeInt(1);
            paramPutDataRequest.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            zznF.transact(6, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
            paramzzar = null;
            break;
            label82: localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzar;
      }

      public void zza(zzar paramzzar, AddListenerRequest paramAddListenerRequest)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
          if (paramzzar != null)
          {
            paramzzar = paramzzar.asBinder();
            localParcel1.writeStrongBinder(paramzzar);
            if (paramAddListenerRequest == null)
              break label82;
            localParcel1.writeInt(1);
            paramAddListenerRequest.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            zznF.transact(16, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
            paramzzar = null;
            break;
            label82: localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzar;
      }

      public void zza(zzar paramzzar, AncsNotificationParcelable paramAncsNotificationParcelable)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
          if (paramzzar != null)
          {
            paramzzar = paramzzar.asBinder();
            localParcel1.writeStrongBinder(paramzzar);
            if (paramAncsNotificationParcelable == null)
              break label82;
            localParcel1.writeInt(1);
            paramAncsNotificationParcelable.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            zznF.transact(27, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
            paramzzar = null;
            break;
            label82: localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzar;
      }

      public void zza(zzar paramzzar, RemoveListenerRequest paramRemoveListenerRequest)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
          if (paramzzar != null)
          {
            paramzzar = paramzzar.asBinder();
            localParcel1.writeStrongBinder(paramzzar);
            if (paramRemoveListenerRequest == null)
              break label82;
            localParcel1.writeInt(1);
            paramRemoveListenerRequest.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            zznF.transact(17, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
            paramzzar = null;
            break;
            label82: localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzar;
      }

      public void zza(zzar paramzzar, zzaq paramzzaq, String paramString)
        throws RemoteException
      {
        Object localObject = null;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
          if (paramzzar != null);
          for (paramzzar = paramzzar.asBinder(); ; paramzzar = null)
          {
            localParcel1.writeStrongBinder(paramzzar);
            paramzzar = localObject;
            if (paramzzaq != null)
              paramzzar = paramzzaq.asBinder();
            localParcel1.writeStrongBinder(paramzzar);
            localParcel1.writeString(paramString);
            zznF.transact(34, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzar;
      }

      public void zza(zzar paramzzar, String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
          if (paramzzar != null);
          for (paramzzar = paramzzar.asBinder(); ; paramzzar = null)
          {
            localParcel1.writeStrongBinder(paramzzar);
            localParcel1.writeString(paramString);
            zznF.transact(21, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzar;
      }

      public void zza(zzar paramzzar, String paramString, int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
          if (paramzzar != null);
          for (paramzzar = paramzzar.asBinder(); ; paramzzar = null)
          {
            localParcel1.writeStrongBinder(paramzzar);
            localParcel1.writeString(paramString);
            localParcel1.writeInt(paramInt);
            zznF.transact(42, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzar;
      }

      public void zza(zzar paramzzar, String paramString, ParcelFileDescriptor paramParcelFileDescriptor)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
          if (paramzzar != null)
          {
            paramzzar = paramzzar.asBinder();
            localParcel1.writeStrongBinder(paramzzar);
            localParcel1.writeString(paramString);
            if (paramParcelFileDescriptor == null)
              break label95;
            localParcel1.writeInt(1);
            paramParcelFileDescriptor.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            zznF.transact(38, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
            paramzzar = null;
            break;
            label95: localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzar;
      }

      public void zza(zzar paramzzar, String paramString, ParcelFileDescriptor paramParcelFileDescriptor, long paramLong1, long paramLong2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
          if (paramzzar != null)
          {
            paramzzar = paramzzar.asBinder();
            localParcel1.writeStrongBinder(paramzzar);
            localParcel1.writeString(paramString);
            if (paramParcelFileDescriptor == null)
              break label109;
            localParcel1.writeInt(1);
            paramParcelFileDescriptor.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            localParcel1.writeLong(paramLong1);
            localParcel1.writeLong(paramLong2);
            zznF.transact(39, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
            paramzzar = null;
            break;
            label109: localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzar;
      }

      public void zza(zzar paramzzar, String paramString1, String paramString2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
          if (paramzzar != null);
          for (paramzzar = paramzzar.asBinder(); ; paramzzar = null)
          {
            localParcel1.writeStrongBinder(paramzzar);
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            zznF.transact(31, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzar;
      }

      public void zza(zzar paramzzar, String paramString1, String paramString2, byte[] paramArrayOfByte)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
          if (paramzzar != null);
          for (paramzzar = paramzzar.asBinder(); ; paramzzar = null)
          {
            localParcel1.writeStrongBinder(paramzzar);
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            localParcel1.writeByteArray(paramArrayOfByte);
            zznF.transact(12, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzar;
      }

      public void zza(zzar paramzzar, boolean paramBoolean)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
          if (paramzzar != null);
          for (paramzzar = paramzzar.asBinder(); ; paramzzar = null)
          {
            localParcel1.writeStrongBinder(paramzzar);
            if (paramBoolean)
              i = 1;
            localParcel1.writeInt(i);
            zznF.transact(48, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzar;
      }

      public void zzb(zzar paramzzar)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
          if (paramzzar != null);
          for (paramzzar = paramzzar.asBinder(); ; paramzzar = null)
          {
            localParcel1.writeStrongBinder(paramzzar);
            zznF.transact(8, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzar;
      }

      public void zzb(zzar paramzzar, int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
          if (paramzzar != null);
          for (paramzzar = paramzzar.asBinder(); ; paramzzar = null)
          {
            localParcel1.writeStrongBinder(paramzzar);
            localParcel1.writeInt(paramInt);
            zznF.transact(28, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzar;
      }

      public void zzb(zzar paramzzar, Uri paramUri)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
          if (paramzzar != null)
          {
            paramzzar = paramzzar.asBinder();
            localParcel1.writeStrongBinder(paramzzar);
            if (paramUri == null)
              break label82;
            localParcel1.writeInt(1);
            paramUri.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            zznF.transact(9, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
            paramzzar = null;
            break;
            label82: localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzar;
      }

      public void zzb(zzar paramzzar, Uri paramUri, int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
          if (paramzzar != null)
          {
            paramzzar = paramzzar.asBinder();
            localParcel1.writeStrongBinder(paramzzar);
            if (paramUri == null)
              break label95;
            localParcel1.writeInt(1);
            paramUri.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            localParcel1.writeInt(paramInt);
            zznF.transact(41, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
            paramzzar = null;
            break;
            label95: localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzar;
      }

      public void zzb(zzar paramzzar, ConnectionConfiguration paramConnectionConfiguration)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
          if (paramzzar != null)
          {
            paramzzar = paramzzar.asBinder();
            localParcel1.writeStrongBinder(paramzzar);
            if (paramConnectionConfiguration == null)
              break label81;
            localParcel1.writeInt(1);
            paramConnectionConfiguration.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            zznF.transact(2, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
            paramzzar = null;
            break;
            label81: localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzar;
      }

      public void zzb(zzar paramzzar, zzaq paramzzaq, String paramString)
        throws RemoteException
      {
        Object localObject = null;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
          if (paramzzar != null);
          for (paramzzar = paramzzar.asBinder(); ; paramzzar = null)
          {
            localParcel1.writeStrongBinder(paramzzar);
            paramzzar = localObject;
            if (paramzzaq != null)
              paramzzar = paramzzaq.asBinder();
            localParcel1.writeStrongBinder(paramzzar);
            localParcel1.writeString(paramString);
            zznF.transact(35, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzar;
      }

      public void zzb(zzar paramzzar, String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
          if (paramzzar != null);
          for (paramzzar = paramzzar.asBinder(); ; paramzzar = null)
          {
            localParcel1.writeStrongBinder(paramzzar);
            localParcel1.writeString(paramString);
            zznF.transact(23, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzar;
      }

      public void zzb(zzar paramzzar, String paramString, int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
          if (paramzzar != null);
          for (paramzzar = paramzzar.asBinder(); ; paramzzar = null)
          {
            localParcel1.writeStrongBinder(paramzzar);
            localParcel1.writeString(paramString);
            localParcel1.writeInt(paramInt);
            zznF.transact(33, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzar;
      }

      public void zzb(zzar paramzzar, boolean paramBoolean)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
          if (paramzzar != null);
          for (paramzzar = paramzzar.asBinder(); ; paramzzar = null)
          {
            localParcel1.writeStrongBinder(paramzzar);
            if (paramBoolean)
              i = 1;
            localParcel1.writeInt(i);
            zznF.transact(50, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzar;
      }

      public void zzc(zzar paramzzar)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
          if (paramzzar != null);
          for (paramzzar = paramzzar.asBinder(); ; paramzzar = null)
          {
            localParcel1.writeStrongBinder(paramzzar);
            zznF.transact(14, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzar;
      }

      public void zzc(zzar paramzzar, int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
          if (paramzzar != null);
          for (paramzzar = paramzzar.asBinder(); ; paramzzar = null)
          {
            localParcel1.writeStrongBinder(paramzzar);
            localParcel1.writeInt(paramInt);
            zznF.transact(29, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzar;
      }

      public void zzc(zzar paramzzar, Uri paramUri)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
          if (paramzzar != null)
          {
            paramzzar = paramzzar.asBinder();
            localParcel1.writeStrongBinder(paramzzar);
            if (paramUri == null)
              break label82;
            localParcel1.writeInt(1);
            paramUri.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            zznF.transact(11, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
            paramzzar = null;
            break;
            label82: localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzar;
      }

      public void zzc(zzar paramzzar, String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
          if (paramzzar != null);
          for (paramzzar = paramzzar.asBinder(); ; paramzzar = null)
          {
            localParcel1.writeStrongBinder(paramzzar);
            localParcel1.writeString(paramString);
            zznF.transact(24, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzar;
      }

      public void zzd(zzar paramzzar)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
          if (paramzzar != null);
          for (paramzzar = paramzzar.asBinder(); ; paramzzar = null)
          {
            localParcel1.writeStrongBinder(paramzzar);
            zznF.transact(15, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzar;
      }

      public void zzd(zzar paramzzar, String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
          if (paramzzar != null);
          for (paramzzar = paramzzar.asBinder(); ; paramzzar = null)
          {
            localParcel1.writeStrongBinder(paramzzar);
            localParcel1.writeString(paramString);
            zznF.transact(46, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzar;
      }

      public void zze(zzar paramzzar)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
          if (paramzzar != null);
          for (paramzzar = paramzzar.asBinder(); ; paramzzar = null)
          {
            localParcel1.writeStrongBinder(paramzzar);
            zznF.transact(18, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzar;
      }

      public void zze(zzar paramzzar, String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
          if (paramzzar != null);
          for (paramzzar = paramzzar.asBinder(); ; paramzzar = null)
          {
            localParcel1.writeStrongBinder(paramzzar);
            localParcel1.writeString(paramString);
            zznF.transact(47, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzar;
      }

      public void zzf(zzar paramzzar)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
          if (paramzzar != null);
          for (paramzzar = paramzzar.asBinder(); ; paramzzar = null)
          {
            localParcel1.writeStrongBinder(paramzzar);
            zznF.transact(19, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzar;
      }

      public void zzf(zzar paramzzar, String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
          if (paramzzar != null);
          for (paramzzar = paramzzar.asBinder(); ; paramzzar = null)
          {
            localParcel1.writeStrongBinder(paramzzar);
            localParcel1.writeString(paramString);
            zznF.transact(32, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzar;
      }

      public void zzg(zzar paramzzar)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
          if (paramzzar != null);
          for (paramzzar = paramzzar.asBinder(); ; paramzzar = null)
          {
            localParcel1.writeStrongBinder(paramzzar);
            zznF.transact(25, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzar;
      }

      public void zzh(zzar paramzzar)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
          if (paramzzar != null);
          for (paramzzar = paramzzar.asBinder(); ; paramzzar = null)
          {
            localParcel1.writeStrongBinder(paramzzar);
            zznF.transact(26, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzar;
      }

      public void zzi(zzar paramzzar)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
          if (paramzzar != null);
          for (paramzzar = paramzzar.asBinder(); ; paramzzar = null)
          {
            localParcel1.writeStrongBinder(paramzzar);
            zznF.transact(30, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzar;
      }

      public void zzj(zzar paramzzar)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
          if (paramzzar != null);
          for (paramzzar = paramzzar.asBinder(); ; paramzzar = null)
          {
            localParcel1.writeStrongBinder(paramzzar);
            zznF.transact(37, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzar;
      }

      public void zzk(zzar paramzzar)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
          if (paramzzar != null);
          for (paramzzar = paramzzar.asBinder(); ; paramzzar = null)
          {
            localParcel1.writeStrongBinder(paramzzar);
            zznF.transact(49, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzar;
      }

      public void zzl(zzar paramzzar)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
          if (paramzzar != null);
          for (paramzzar = paramzzar.asBinder(); ; paramzzar = null)
          {
            localParcel1.writeStrongBinder(paramzzar);
            zznF.transact(51, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzar;
      }

      public void zzm(zzar paramzzar)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
          if (paramzzar != null);
          for (paramzzar = paramzzar.asBinder(); ; paramzzar = null)
          {
            localParcel1.writeStrongBinder(paramzzar);
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
        throw paramzzar;
      }

      public void zzn(zzar paramzzar)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
          if (paramzzar != null);
          for (paramzzar = paramzzar.asBinder(); ; paramzzar = null)
          {
            localParcel1.writeStrongBinder(paramzzar);
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
        throw paramzzar;
      }

      public void zzo(zzar paramzzar)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
          if (paramzzar != null);
          for (paramzzar = paramzzar.asBinder(); ; paramzzar = null)
          {
            localParcel1.writeStrongBinder(paramzzar);
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
        throw paramzzar;
      }
    }
  }
}