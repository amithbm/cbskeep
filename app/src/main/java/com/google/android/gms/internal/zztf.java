package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zze;
import com.google.android.gms.reminders.AccountState;

public abstract interface zztf extends IInterface
{
  public abstract void onReminderCreated(String paramString1, String paramString2)
    throws RemoteException;

  public abstract void zzBX()
    throws RemoteException;

  public abstract void zza(DataHolder paramDataHolder, Status paramStatus)
    throws RemoteException;

  public abstract void zza(AccountState paramAccountState, Status paramStatus)
    throws RemoteException;

  public abstract void zza(boolean paramBoolean, Status paramStatus)
    throws RemoteException;

  public abstract void zzai(DataHolder paramDataHolder)
    throws RemoteException;

  public abstract void zzaj(DataHolder paramDataHolder)
    throws RemoteException;

  public abstract void zzb(Status paramStatus)
    throws RemoteException;

  public static abstract class zza extends Binder
    implements zztf
  {
    public zza()
    {
      attachInterface(this, "com.google.android.gms.reminders.internal.IRemindersCallbacks");
    }

    public static zztf zzfV(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.reminders.internal.IRemindersCallbacks");
      if ((localIInterface != null) && ((localIInterface instanceof zztf)))
        return (zztf)localIInterface;
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
        paramParcel2.writeString("com.google.android.gms.reminders.internal.IRemindersCallbacks");
        return true;
      case 1:
        paramParcel1.enforceInterface("com.google.android.gms.reminders.internal.IRemindersCallbacks");
        if (paramParcel1.readInt() != 0)
        {
          localObject1 = DataHolder.CREATOR.zzcH(paramParcel1);
          if (paramParcel1.readInt() == 0)
            break label167;
        }
        for (paramParcel1 = (Status)Status.CREATOR.createFromParcel(paramParcel1); ; paramParcel1 = null)
        {
          zza((DataHolder)localObject1, paramParcel1);
          paramParcel2.writeNoException();
          return true;
          localObject1 = null;
          break;
        }
      case 2:
        paramParcel1.enforceInterface("com.google.android.gms.reminders.internal.IRemindersCallbacks");
        if (paramParcel1.readInt() != 0);
        for (paramParcel1 = (Status)Status.CREATOR.createFromParcel(paramParcel1); ; paramParcel1 = null)
        {
          zzb(paramParcel1);
          paramParcel2.writeNoException();
          return true;
        }
      case 3:
        paramParcel1.enforceInterface("com.google.android.gms.reminders.internal.IRemindersCallbacks");
        zzBX();
        paramParcel2.writeNoException();
        return true;
      case 4:
        paramParcel1.enforceInterface("com.google.android.gms.reminders.internal.IRemindersCallbacks");
        if (paramParcel1.readInt() != 0)
          localObject1 = DataHolder.CREATOR.zzcH(paramParcel1);
        zzai((DataHolder)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 5:
        paramParcel1.enforceInterface("com.google.android.gms.reminders.internal.IRemindersCallbacks");
        boolean bool;
        if (paramParcel1.readInt() != 0)
        {
          bool = true;
          if (paramParcel1.readInt() == 0)
            break label319;
        }
        for (paramParcel1 = (Status)Status.CREATOR.createFromParcel(paramParcel1); ; paramParcel1 = null)
        {
          zza(bool, paramParcel1);
          paramParcel2.writeNoException();
          return true;
          bool = false;
          break;
        }
      case 6:
        paramParcel1.enforceInterface("com.google.android.gms.reminders.internal.IRemindersCallbacks");
        onReminderCreated(paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 7:
        label167: label319: paramParcel1.enforceInterface("com.google.android.gms.reminders.internal.IRemindersCallbacks");
        if (paramParcel1.readInt() != 0)
        {
          localObject1 = (AccountState)AccountState.CREATOR.createFromParcel(paramParcel1);
          if (paramParcel1.readInt() == 0)
            break label414;
        }
        label414: for (paramParcel1 = (Status)Status.CREATOR.createFromParcel(paramParcel1); ; paramParcel1 = null)
        {
          zza((AccountState)localObject1, paramParcel1);
          paramParcel2.writeNoException();
          return true;
          localObject1 = null;
          break;
        }
      case 8:
      }
      paramParcel1.enforceInterface("com.google.android.gms.reminders.internal.IRemindersCallbacks");
      localObject1 = localObject2;
      if (paramParcel1.readInt() != 0)
        localObject1 = DataHolder.CREATOR.zzcH(paramParcel1);
      zzaj((DataHolder)localObject1);
      paramParcel2.writeNoException();
      return true;
    }

    private static class zza
      implements zztf
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

      public void onReminderCreated(String paramString1, String paramString2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.reminders.internal.IRemindersCallbacks");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          zznF.transact(6, localParcel1, localParcel2, 0);
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

      public void zzBX()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.reminders.internal.IRemindersCallbacks");
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

      public void zza(DataHolder paramDataHolder, Status paramStatus)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.reminders.internal.IRemindersCallbacks");
            if (paramDataHolder != null)
            {
              localParcel1.writeInt(1);
              paramDataHolder.writeToParcel(localParcel1, 0);
              if (paramStatus != null)
              {
                localParcel1.writeInt(1);
                paramStatus.writeToParcel(localParcel1, 0);
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
          localParcel1.writeInt(0);
        }
      }

      public void zza(AccountState paramAccountState, Status paramStatus)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.reminders.internal.IRemindersCallbacks");
            if (paramAccountState != null)
            {
              localParcel1.writeInt(1);
              paramAccountState.writeToParcel(localParcel1, 0);
              if (paramStatus != null)
              {
                localParcel1.writeInt(1);
                paramStatus.writeToParcel(localParcel1, 0);
                zznF.transact(7, localParcel1, localParcel2, 0);
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
        }
      }

      public void zza(boolean paramBoolean, Status paramStatus)
        throws RemoteException
      {
        int i = 1;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.reminders.internal.IRemindersCallbacks");
          if (paramBoolean)
          {
            localParcel1.writeInt(i);
            if (paramStatus == null)
              break label83;
            localParcel1.writeInt(1);
            paramStatus.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            zznF.transact(5, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
            i = 0;
            break;
            label83: localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramStatus;
      }

      public void zzai(DataHolder paramDataHolder)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.reminders.internal.IRemindersCallbacks");
          if (paramDataHolder != null)
          {
            localParcel1.writeInt(1);
            paramDataHolder.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            zznF.transact(4, localParcel1, localParcel2, 0);
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
        throw paramDataHolder;
      }

      public void zzaj(DataHolder paramDataHolder)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.reminders.internal.IRemindersCallbacks");
          if (paramDataHolder != null)
          {
            localParcel1.writeInt(1);
            paramDataHolder.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            zznF.transact(8, localParcel1, localParcel2, 0);
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
        throw paramDataHolder;
      }

      public void zzb(Status paramStatus)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.reminders.internal.IRemindersCallbacks");
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
    }
  }
}