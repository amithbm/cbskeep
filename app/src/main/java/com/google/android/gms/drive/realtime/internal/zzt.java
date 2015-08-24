package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zze;

public abstract interface zzt extends IInterface
{
  public abstract void zza(int paramInt, zzq paramzzq)
    throws RemoteException;

  public abstract void zza(BeginCompoundOperationRequest paramBeginCompoundOperationRequest, zzv paramzzv)
    throws RemoteException;

  public abstract void zza(EndCompoundOperationRequest paramEndCompoundOperationRequest, zzq paramzzq)
    throws RemoteException;

  public abstract void zza(EndCompoundOperationRequest paramEndCompoundOperationRequest, zzv paramzzv)
    throws RemoteException;

  public abstract void zza(ParcelableIndexReference paramParcelableIndexReference, zzu paramzzu)
    throws RemoteException;

  public abstract void zza(zzj paramzzj)
    throws RemoteException;

  public abstract void zza(zzk paramzzk)
    throws RemoteException;

  public abstract void zza(zzl paramzzl)
    throws RemoteException;

  public abstract void zza(zzo paramzzo)
    throws RemoteException;

  public abstract void zza(zzp paramzzp)
    throws RemoteException;

  public abstract void zza(zzq paramzzq)
    throws RemoteException;

  public abstract void zza(zzs paramzzs)
    throws RemoteException;

  public abstract void zza(zzv paramzzv)
    throws RemoteException;

  public abstract void zza(String paramString, int paramInt1, int paramInt2, zzn paramzzn)
    throws RemoteException;

  public abstract void zza(String paramString, int paramInt1, int paramInt2, zzq paramzzq)
    throws RemoteException;

  public abstract void zza(String paramString, int paramInt, DataHolder paramDataHolder, zzn paramzzn)
    throws RemoteException;

  public abstract void zza(String paramString, int paramInt, DataHolder paramDataHolder, zzq paramzzq)
    throws RemoteException;

  public abstract void zza(String paramString, int paramInt, zzu paramzzu)
    throws RemoteException;

  public abstract void zza(String paramString, int paramInt, zzv paramzzv)
    throws RemoteException;

  public abstract void zza(String paramString1, int paramInt1, String paramString2, int paramInt2, zzq paramzzq)
    throws RemoteException;

  public abstract void zza(String paramString1, int paramInt, String paramString2, zzq paramzzq)
    throws RemoteException;

  public abstract void zza(String paramString, DataHolder paramDataHolder, zzq paramzzq)
    throws RemoteException;

  public abstract void zza(String paramString, zzm paramzzm)
    throws RemoteException;

  public abstract void zza(String paramString, zzq paramzzq)
    throws RemoteException;

  public abstract void zza(String paramString, zzr paramzzr)
    throws RemoteException;

  public abstract void zza(String paramString, zzs paramzzs)
    throws RemoteException;

  public abstract void zza(String paramString, zzu paramzzu)
    throws RemoteException;

  public abstract void zza(String paramString, zzv paramzzv)
    throws RemoteException;

  public abstract void zza(String paramString1, String paramString2, DataHolder paramDataHolder, zzq paramzzq)
    throws RemoteException;

  public abstract void zza(String paramString1, String paramString2, zzm paramzzm)
    throws RemoteException;

  public abstract void zza(String paramString1, String paramString2, zzn paramzzn)
    throws RemoteException;

  public abstract void zza(String paramString1, String paramString2, zzq paramzzq)
    throws RemoteException;

  public abstract void zzb(zzj paramzzj)
    throws RemoteException;

  public abstract void zzb(zzq paramzzq)
    throws RemoteException;

  public abstract void zzb(zzs paramzzs)
    throws RemoteException;

  public abstract void zzb(zzv paramzzv)
    throws RemoteException;

  public abstract void zzb(String paramString, zzm paramzzm)
    throws RemoteException;

  public abstract void zzb(String paramString, zzs paramzzs)
    throws RemoteException;

  public abstract void zzb(String paramString, zzu paramzzu)
    throws RemoteException;

  public abstract void zzb(String paramString, zzv paramzzv)
    throws RemoteException;

  public abstract void zzb(String paramString1, String paramString2, zzm paramzzm)
    throws RemoteException;

  public abstract void zzc(zzj paramzzj)
    throws RemoteException;

  public abstract void zzc(String paramString, zzs paramzzs)
    throws RemoteException;

  public abstract void zzd(zzj paramzzj)
    throws RemoteException;

  public abstract void zze(zzj paramzzj)
    throws RemoteException;

  public abstract void zztD()
    throws RemoteException;

  public static abstract class zza extends Binder
    implements zzt
  {
    public static zzt zzcH(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      if ((localIInterface != null) && ((localIInterface instanceof zzt)))
        return (zzt)localIInterface;
      return new zza(paramIBinder);
    }

    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      String str2 = null;
      Object localObject2 = null;
      Object localObject3 = null;
      Object localObject4 = null;
      Object localObject5 = null;
      Object localObject1 = null;
      Object localObject6 = null;
      String str1 = null;
      switch (paramInt1)
      {
      default:
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902:
        paramParcel2.writeString("com.google.android.gms.drive.realtime.internal.IRealtimeService");
        return true;
      case 1:
        paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
        zza(paramParcel1.readString(), zzu.zza.zzcI(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 2:
        paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
        zza(zzj.zza.zzcx(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 3:
        paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
        zza(zzv.zza.zzcJ(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 33:
        paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
        zzb(zzj.zza.zzcx(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 35:
        paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
        zzb(zzv.zza.zzcJ(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 40:
        paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
        zza(zzs.zza.zzcG(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 45:
        paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
        zzc(zzj.zza.zzcx(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 46:
        paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
        zza(paramParcel1.readString(), paramParcel1.readInt(), zzu.zza.zzcI(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 4:
        paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
        zza(paramParcel1.readString(), paramParcel1.readString(), zzm.zza.zzcA(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 5:
        paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
        zza(paramParcel1.readString(), zzs.zza.zzcG(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 6:
        paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
        str2 = paramParcel1.readString();
        localObject1 = str1;
        if (paramParcel1.readInt() != 0)
          localObject1 = DataHolder.CREATOR.zzcH(paramParcel1);
        zza(str2, (DataHolder)localObject1, zzq.zza.zzcE(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 7:
        paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
        zza(paramParcel1.readString(), zzq.zza.zzcE(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 20:
        paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
        zza(paramParcel1.readString(), zzm.zza.zzcA(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 21:
        paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
        zza(paramParcel1.readString(), paramParcel1.readString(), zzn.zza.zzcB(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 8:
        paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
        zzb(paramParcel1.readString(), zzs.zza.zzcG(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 9:
        paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
        zzb(paramParcel1.readString(), zzu.zza.zzcI(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 10:
        paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
        zza(paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readString(), zzq.zza.zzcE(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 11:
        paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
        zza(paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readInt(), zzq.zza.zzcE(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 12:
        paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
        zza(paramParcel1.readString(), paramParcel1.readString(), zzq.zza.zzcE(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 13:
        paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
        zzb(paramParcel1.readString(), zzm.zza.zzcA(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 14:
        paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
        zzc(paramParcel1.readString(), zzs.zza.zzcG(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 15:
        paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
        str1 = paramParcel1.readString();
        paramInt1 = paramParcel1.readInt();
        localObject1 = str2;
        if (paramParcel1.readInt() != 0)
          localObject1 = DataHolder.CREATOR.zzcH(paramParcel1);
        zza(str1, paramInt1, (DataHolder)localObject1, zzq.zza.zzcE(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 16:
        paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
        str1 = paramParcel1.readString();
        paramInt1 = paramParcel1.readInt();
        localObject1 = localObject2;
        if (paramParcel1.readInt() != 0)
          localObject1 = DataHolder.CREATOR.zzcH(paramParcel1);
        zza(str1, paramInt1, (DataHolder)localObject1, zzn.zza.zzcB(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 17:
        paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
        zza(paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readInt(), zzn.zza.zzcB(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 37:
        paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
        zza(paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readInt(), zzq.zza.zzcE(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 18:
        paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
        localObject1 = localObject3;
        if (paramParcel1.readInt() != 0)
          localObject1 = (BeginCompoundOperationRequest)BeginCompoundOperationRequest.CREATOR.createFromParcel(paramParcel1);
        zza((BeginCompoundOperationRequest)localObject1, zzv.zza.zzcJ(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 41:
        paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
        localObject1 = localObject4;
        if (paramParcel1.readInt() != 0)
          localObject1 = (EndCompoundOperationRequest)EndCompoundOperationRequest.CREATOR.createFromParcel(paramParcel1);
        zza((EndCompoundOperationRequest)localObject1, zzq.zza.zzcE(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 22:
        paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
        zza(zzq.zza.zzcE(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 23:
        paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
        zzb(zzq.zza.zzcE(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 24:
        paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
        zzd(zzj.zza.zzcx(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 25:
        paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
        zze(zzj.zza.zzcx(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 26:
        paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
        localObject1 = localObject5;
        if (paramParcel1.readInt() != 0)
          localObject1 = (ParcelableIndexReference)ParcelableIndexReference.CREATOR.createFromParcel(paramParcel1);
        zza((ParcelableIndexReference)localObject1, zzu.zza.zzcI(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 27:
        paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
        zza(paramParcel1.readString(), zzr.zza.zzcF(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 28:
        paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
        zza(paramParcel1.readString(), paramParcel1.readInt(), zzv.zza.zzcJ(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 29:
        paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
        zzb(zzs.zza.zzcG(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 30:
        paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
        zza(paramParcel1.readInt(), zzq.zza.zzcE(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 31:
        paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
        zza(zzl.zza.zzcz(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 32:
        paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
        zza(zzk.zza.zzcy(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 34:
        paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
        zza(zzp.zza.zzcD(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 36:
        paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
        zza(zzo.zza.zzcC(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 38:
        paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
        zza(paramParcel1.readString(), zzv.zza.zzcJ(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 39:
        paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
        zzb(paramParcel1.readString(), zzv.zza.zzcJ(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 42:
        paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
        zzb(paramParcel1.readString(), paramParcel1.readString(), zzm.zza.zzcA(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 43:
        paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
        str1 = paramParcel1.readString();
        str2 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0)
          localObject1 = DataHolder.CREATOR.zzcH(paramParcel1);
        zza(str1, str2, (DataHolder)localObject1, zzq.zza.zzcE(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 44:
        paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
        zztD();
        paramParcel2.writeNoException();
        return true;
      case 19:
      }
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      localObject1 = localObject6;
      if (paramParcel1.readInt() != 0)
        localObject1 = (EndCompoundOperationRequest)EndCompoundOperationRequest.CREATOR.createFromParcel(paramParcel1);
      zza((EndCompoundOperationRequest)localObject1, zzv.zza.zzcJ(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    }

    private static class zza
      implements zzt
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

      public void zza(int paramInt, zzq paramzzq)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
          localParcel1.writeInt(paramInt);
          if (paramzzq != null);
          for (paramzzq = paramzzq.asBinder(); ; paramzzq = null)
          {
            localParcel1.writeStrongBinder(paramzzq);
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
        throw paramzzq;
      }

      public void zza(BeginCompoundOperationRequest paramBeginCompoundOperationRequest, zzv paramzzv)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            if (paramBeginCompoundOperationRequest != null)
            {
              localParcel1.writeInt(1);
              paramBeginCompoundOperationRequest.writeToParcel(localParcel1, 0);
              if (paramzzv != null)
              {
                paramBeginCompoundOperationRequest = paramzzv.asBinder();
                localParcel1.writeStrongBinder(paramBeginCompoundOperationRequest);
                zznF.transact(18, localParcel1, localParcel2, 0);
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
          paramBeginCompoundOperationRequest = null;
        }
      }

      public void zza(EndCompoundOperationRequest paramEndCompoundOperationRequest, zzq paramzzq)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            if (paramEndCompoundOperationRequest != null)
            {
              localParcel1.writeInt(1);
              paramEndCompoundOperationRequest.writeToParcel(localParcel1, 0);
              if (paramzzq != null)
              {
                paramEndCompoundOperationRequest = paramzzq.asBinder();
                localParcel1.writeStrongBinder(paramEndCompoundOperationRequest);
                zznF.transact(41, localParcel1, localParcel2, 0);
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
          paramEndCompoundOperationRequest = null;
        }
      }

      public void zza(EndCompoundOperationRequest paramEndCompoundOperationRequest, zzv paramzzv)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            if (paramEndCompoundOperationRequest != null)
            {
              localParcel1.writeInt(1);
              paramEndCompoundOperationRequest.writeToParcel(localParcel1, 0);
              if (paramzzv != null)
              {
                paramEndCompoundOperationRequest = paramzzv.asBinder();
                localParcel1.writeStrongBinder(paramEndCompoundOperationRequest);
                zznF.transact(19, localParcel1, localParcel2, 0);
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
          paramEndCompoundOperationRequest = null;
        }
      }

      public void zza(ParcelableIndexReference paramParcelableIndexReference, zzu paramzzu)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            if (paramParcelableIndexReference != null)
            {
              localParcel1.writeInt(1);
              paramParcelableIndexReference.writeToParcel(localParcel1, 0);
              if (paramzzu != null)
              {
                paramParcelableIndexReference = paramzzu.asBinder();
                localParcel1.writeStrongBinder(paramParcelableIndexReference);
                zznF.transact(26, localParcel1, localParcel2, 0);
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
          paramParcelableIndexReference = null;
        }
      }

      public void zza(zzj paramzzj)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
          if (paramzzj != null);
          for (paramzzj = paramzzj.asBinder(); ; paramzzj = null)
          {
            localParcel1.writeStrongBinder(paramzzj);
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
        throw paramzzj;
      }

      public void zza(zzk paramzzk)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
          if (paramzzk != null);
          for (paramzzk = paramzzk.asBinder(); ; paramzzk = null)
          {
            localParcel1.writeStrongBinder(paramzzk);
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
        throw paramzzk;
      }

      public void zza(zzl paramzzl)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
          if (paramzzl != null);
          for (paramzzl = paramzzl.asBinder(); ; paramzzl = null)
          {
            localParcel1.writeStrongBinder(paramzzl);
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
        throw paramzzl;
      }

      public void zza(zzo paramzzo)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
          if (paramzzo != null);
          for (paramzzo = paramzzo.asBinder(); ; paramzzo = null)
          {
            localParcel1.writeStrongBinder(paramzzo);
            zznF.transact(36, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzo;
      }

      public void zza(zzp paramzzp)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
          if (paramzzp != null);
          for (paramzzp = paramzzp.asBinder(); ; paramzzp = null)
          {
            localParcel1.writeStrongBinder(paramzzp);
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
        throw paramzzp;
      }

      public void zza(zzq paramzzq)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
          if (paramzzq != null);
          for (paramzzq = paramzzq.asBinder(); ; paramzzq = null)
          {
            localParcel1.writeStrongBinder(paramzzq);
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
        throw paramzzq;
      }

      public void zza(zzs paramzzs)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
          if (paramzzs != null);
          for (paramzzs = paramzzs.asBinder(); ; paramzzs = null)
          {
            localParcel1.writeStrongBinder(paramzzs);
            zznF.transact(40, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzs;
      }

      public void zza(zzv paramzzv)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
          if (paramzzv != null);
          for (paramzzv = paramzzv.asBinder(); ; paramzzv = null)
          {
            localParcel1.writeStrongBinder(paramzzv);
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
        throw paramzzv;
      }

      public void zza(String paramString, int paramInt1, int paramInt2, zzn paramzzn)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
          localParcel1.writeString(paramString);
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          if (paramzzn != null);
          for (paramString = paramzzn.asBinder(); ; paramString = null)
          {
            localParcel1.writeStrongBinder(paramString);
            zznF.transact(17, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramString;
      }

      public void zza(String paramString, int paramInt1, int paramInt2, zzq paramzzq)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
          localParcel1.writeString(paramString);
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          if (paramzzq != null);
          for (paramString = paramzzq.asBinder(); ; paramString = null)
          {
            localParcel1.writeStrongBinder(paramString);
            zznF.transact(11, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramString;
      }

      public void zza(String paramString, int paramInt, DataHolder paramDataHolder, zzn paramzzn)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            localParcel1.writeString(paramString);
            localParcel1.writeInt(paramInt);
            if (paramDataHolder != null)
            {
              localParcel1.writeInt(1);
              paramDataHolder.writeToParcel(localParcel1, 0);
              if (paramzzn != null)
              {
                paramString = paramzzn.asBinder();
                localParcel1.writeStrongBinder(paramString);
                zznF.transact(16, localParcel1, localParcel2, 0);
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
          paramString = null;
        }
      }

      public void zza(String paramString, int paramInt, DataHolder paramDataHolder, zzq paramzzq)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            localParcel1.writeString(paramString);
            localParcel1.writeInt(paramInt);
            if (paramDataHolder != null)
            {
              localParcel1.writeInt(1);
              paramDataHolder.writeToParcel(localParcel1, 0);
              if (paramzzq != null)
              {
                paramString = paramzzq.asBinder();
                localParcel1.writeStrongBinder(paramString);
                zznF.transact(15, localParcel1, localParcel2, 0);
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
          paramString = null;
        }
      }

      public void zza(String paramString, int paramInt, zzu paramzzu)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
          localParcel1.writeString(paramString);
          localParcel1.writeInt(paramInt);
          if (paramzzu != null);
          for (paramString = paramzzu.asBinder(); ; paramString = null)
          {
            localParcel1.writeStrongBinder(paramString);
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
        throw paramString;
      }

      public void zza(String paramString, int paramInt, zzv paramzzv)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
          localParcel1.writeString(paramString);
          localParcel1.writeInt(paramInt);
          if (paramzzv != null);
          for (paramString = paramzzv.asBinder(); ; paramString = null)
          {
            localParcel1.writeStrongBinder(paramString);
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
        throw paramString;
      }

      public void zza(String paramString1, int paramInt1, String paramString2, int paramInt2, zzq paramzzq)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
          localParcel1.writeString(paramString1);
          localParcel1.writeInt(paramInt1);
          localParcel1.writeString(paramString2);
          localParcel1.writeInt(paramInt2);
          if (paramzzq != null);
          for (paramString1 = paramzzq.asBinder(); ; paramString1 = null)
          {
            localParcel1.writeStrongBinder(paramString1);
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
        throw paramString1;
      }

      public void zza(String paramString1, int paramInt, String paramString2, zzq paramzzq)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
          localParcel1.writeString(paramString1);
          localParcel1.writeInt(paramInt);
          localParcel1.writeString(paramString2);
          if (paramzzq != null);
          for (paramString1 = paramzzq.asBinder(); ; paramString1 = null)
          {
            localParcel1.writeStrongBinder(paramString1);
            zznF.transact(10, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramString1;
      }

      public void zza(String paramString, DataHolder paramDataHolder, zzq paramzzq)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            localParcel1.writeString(paramString);
            if (paramDataHolder != null)
            {
              localParcel1.writeInt(1);
              paramDataHolder.writeToParcel(localParcel1, 0);
              if (paramzzq != null)
              {
                paramString = paramzzq.asBinder();
                localParcel1.writeStrongBinder(paramString);
                zznF.transact(6, localParcel1, localParcel2, 0);
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
          paramString = null;
        }
      }

      public void zza(String paramString, zzm paramzzm)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
          localParcel1.writeString(paramString);
          if (paramzzm != null);
          for (paramString = paramzzm.asBinder(); ; paramString = null)
          {
            localParcel1.writeStrongBinder(paramString);
            zznF.transact(20, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramString;
      }

      public void zza(String paramString, zzq paramzzq)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
          localParcel1.writeString(paramString);
          if (paramzzq != null);
          for (paramString = paramzzq.asBinder(); ; paramString = null)
          {
            localParcel1.writeStrongBinder(paramString);
            zznF.transact(7, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramString;
      }

      public void zza(String paramString, zzr paramzzr)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
          localParcel1.writeString(paramString);
          if (paramzzr != null);
          for (paramString = paramzzr.asBinder(); ; paramString = null)
          {
            localParcel1.writeStrongBinder(paramString);
            zznF.transact(27, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramString;
      }

      public void zza(String paramString, zzs paramzzs)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
          localParcel1.writeString(paramString);
          if (paramzzs != null);
          for (paramString = paramzzs.asBinder(); ; paramString = null)
          {
            localParcel1.writeStrongBinder(paramString);
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
        throw paramString;
      }

      public void zza(String paramString, zzu paramzzu)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
          localParcel1.writeString(paramString);
          if (paramzzu != null);
          for (paramString = paramzzu.asBinder(); ; paramString = null)
          {
            localParcel1.writeStrongBinder(paramString);
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
        throw paramString;
      }

      public void zza(String paramString, zzv paramzzv)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
          localParcel1.writeString(paramString);
          if (paramzzv != null);
          for (paramString = paramzzv.asBinder(); ; paramString = null)
          {
            localParcel1.writeStrongBinder(paramString);
            zznF.transact(38, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramString;
      }

      public void zza(String paramString1, String paramString2, DataHolder paramDataHolder, zzq paramzzq)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            if (paramDataHolder != null)
            {
              localParcel1.writeInt(1);
              paramDataHolder.writeToParcel(localParcel1, 0);
              if (paramzzq != null)
              {
                paramString1 = paramzzq.asBinder();
                localParcel1.writeStrongBinder(paramString1);
                zznF.transact(43, localParcel1, localParcel2, 0);
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
          paramString1 = null;
        }
      }

      public void zza(String paramString1, String paramString2, zzm paramzzm)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          if (paramzzm != null);
          for (paramString1 = paramzzm.asBinder(); ; paramString1 = null)
          {
            localParcel1.writeStrongBinder(paramString1);
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
        throw paramString1;
      }

      public void zza(String paramString1, String paramString2, zzn paramzzn)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          if (paramzzn != null);
          for (paramString1 = paramzzn.asBinder(); ; paramString1 = null)
          {
            localParcel1.writeStrongBinder(paramString1);
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
        throw paramString1;
      }

      public void zza(String paramString1, String paramString2, zzq paramzzq)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          if (paramzzq != null);
          for (paramString1 = paramzzq.asBinder(); ; paramString1 = null)
          {
            localParcel1.writeStrongBinder(paramString1);
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
        throw paramString1;
      }

      public void zzb(zzj paramzzj)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
          if (paramzzj != null);
          for (paramzzj = paramzzj.asBinder(); ; paramzzj = null)
          {
            localParcel1.writeStrongBinder(paramzzj);
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
        throw paramzzj;
      }

      public void zzb(zzq paramzzq)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
          if (paramzzq != null);
          for (paramzzq = paramzzq.asBinder(); ; paramzzq = null)
          {
            localParcel1.writeStrongBinder(paramzzq);
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
        throw paramzzq;
      }

      public void zzb(zzs paramzzs)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
          if (paramzzs != null);
          for (paramzzs = paramzzs.asBinder(); ; paramzzs = null)
          {
            localParcel1.writeStrongBinder(paramzzs);
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
        throw paramzzs;
      }

      public void zzb(zzv paramzzv)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
          if (paramzzv != null);
          for (paramzzv = paramzzv.asBinder(); ; paramzzv = null)
          {
            localParcel1.writeStrongBinder(paramzzv);
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
        throw paramzzv;
      }

      public void zzb(String paramString, zzm paramzzm)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
          localParcel1.writeString(paramString);
          if (paramzzm != null);
          for (paramString = paramzzm.asBinder(); ; paramString = null)
          {
            localParcel1.writeStrongBinder(paramString);
            zznF.transact(13, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramString;
      }

      public void zzb(String paramString, zzs paramzzs)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
          localParcel1.writeString(paramString);
          if (paramzzs != null);
          for (paramString = paramzzs.asBinder(); ; paramString = null)
          {
            localParcel1.writeStrongBinder(paramString);
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
        throw paramString;
      }

      public void zzb(String paramString, zzu paramzzu)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
          localParcel1.writeString(paramString);
          if (paramzzu != null);
          for (paramString = paramzzu.asBinder(); ; paramString = null)
          {
            localParcel1.writeStrongBinder(paramString);
            zznF.transact(9, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramString;
      }

      public void zzb(String paramString, zzv paramzzv)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
          localParcel1.writeString(paramString);
          if (paramzzv != null);
          for (paramString = paramzzv.asBinder(); ; paramString = null)
          {
            localParcel1.writeStrongBinder(paramString);
            zznF.transact(39, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramString;
      }

      public void zzb(String paramString1, String paramString2, zzm paramzzm)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          if (paramzzm != null);
          for (paramString1 = paramzzm.asBinder(); ; paramString1 = null)
          {
            localParcel1.writeStrongBinder(paramString1);
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
        throw paramString1;
      }

      public void zzc(zzj paramzzj)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
          if (paramzzj != null);
          for (paramzzj = paramzzj.asBinder(); ; paramzzj = null)
          {
            localParcel1.writeStrongBinder(paramzzj);
            zznF.transact(45, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzj;
      }

      public void zzc(String paramString, zzs paramzzs)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
          localParcel1.writeString(paramString);
          if (paramzzs != null);
          for (paramString = paramzzs.asBinder(); ; paramString = null)
          {
            localParcel1.writeStrongBinder(paramString);
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
        throw paramString;
      }

      public void zzd(zzj paramzzj)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
          if (paramzzj != null);
          for (paramzzj = paramzzj.asBinder(); ; paramzzj = null)
          {
            localParcel1.writeStrongBinder(paramzzj);
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
        throw paramzzj;
      }

      public void zze(zzj paramzzj)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
          if (paramzzj != null);
          for (paramzzj = paramzzj.asBinder(); ; paramzzj = null)
          {
            localParcel1.writeStrongBinder(paramzzj);
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
        throw paramzzj;
      }

      public void zztD()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
          zznF.transact(44, localParcel1, localParcel2, 0);
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