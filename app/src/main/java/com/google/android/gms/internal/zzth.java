package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.reminders.AccountState;
import com.google.android.gms.reminders.CreateReminderOptionsInternal;
import com.google.android.gms.reminders.LoadRemindersOptions;
import com.google.android.gms.reminders.UpdateRecurrenceOptions;
import com.google.android.gms.reminders.model.CustomizedSnoozePresetEntity;
import com.google.android.gms.reminders.model.TaskEntity;
import com.google.android.gms.reminders.model.TaskIdEntity;
import java.util.List;

public abstract interface zzth extends IInterface
{
  public abstract void zzBY()
    throws RemoteException;

  public abstract void zza(zztf paramzztf)
    throws RemoteException;

  public abstract void zza(zztf paramzztf, AccountState paramAccountState)
    throws RemoteException;

  public abstract void zza(zztf paramzztf, LoadRemindersOptions paramLoadRemindersOptions)
    throws RemoteException;

  public abstract void zza(zztf paramzztf, CustomizedSnoozePresetEntity paramCustomizedSnoozePresetEntity)
    throws RemoteException;

  public abstract void zza(zztf paramzztf, TaskEntity paramTaskEntity)
    throws RemoteException;

  public abstract void zza(zztf paramzztf, TaskEntity paramTaskEntity, CreateReminderOptionsInternal paramCreateReminderOptionsInternal)
    throws RemoteException;

  public abstract void zza(zztf paramzztf, TaskIdEntity paramTaskIdEntity)
    throws RemoteException;

  public abstract void zza(zztf paramzztf, String paramString, UpdateRecurrenceOptions paramUpdateRecurrenceOptions)
    throws RemoteException;

  public abstract void zza(zztf paramzztf, String paramString, TaskEntity paramTaskEntity, UpdateRecurrenceOptions paramUpdateRecurrenceOptions)
    throws RemoteException;

  public abstract void zza(zztf paramzztf, List<TaskEntity> paramList)
    throws RemoteException;

  public abstract void zzb(zztf paramzztf)
    throws RemoteException;

  public abstract void zzb(zztf paramzztf, TaskEntity paramTaskEntity)
    throws RemoteException;

  public abstract void zzb(zztf paramzztf, TaskIdEntity paramTaskIdEntity)
    throws RemoteException;

  public abstract void zzb(zztf paramzztf, String paramString, TaskEntity paramTaskEntity, UpdateRecurrenceOptions paramUpdateRecurrenceOptions)
    throws RemoteException;

  public abstract void zzc(zztf paramzztf)
    throws RemoteException;

  public abstract void zzc(zztf paramzztf, TaskEntity paramTaskEntity)
    throws RemoteException;

  public abstract void zzc(zztf paramzztf, String paramString, TaskEntity paramTaskEntity, UpdateRecurrenceOptions paramUpdateRecurrenceOptions)
    throws RemoteException;

  public abstract void zzd(zztf paramzztf)
    throws RemoteException;

  public abstract void zzd(zztf paramzztf, TaskEntity paramTaskEntity)
    throws RemoteException;

  public static abstract class zza extends Binder
    implements zzth
  {
    public static zzth zzfW(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.reminders.internal.IRemindersService");
      if ((localIInterface != null) && ((localIInterface instanceof zzth)))
        return (zzth)localIInterface;
      return new zza(paramIBinder);
    }

    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      Object localObject1;
      Object localObject2;
      String str;
      switch (paramInt1)
      {
      default:
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902:
        paramParcel2.writeString("com.google.android.gms.reminders.internal.IRemindersService");
        return true;
      case 1:
        paramParcel1.enforceInterface("com.google.android.gms.reminders.internal.IRemindersService");
        localObject1 = zztf.zza.zzfV(paramParcel1.readStrongBinder());
        if (paramParcel1.readInt() != 0);
        for (paramParcel1 = (LoadRemindersOptions)LoadRemindersOptions.CREATOR.createFromParcel(paramParcel1); ; paramParcel1 = null)
        {
          zza((zztf)localObject1, paramParcel1);
          paramParcel2.writeNoException();
          return true;
        }
      case 2:
        paramParcel1.enforceInterface("com.google.android.gms.reminders.internal.IRemindersService");
        zza(zztf.zza.zzfV(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 3:
        paramParcel1.enforceInterface("com.google.android.gms.reminders.internal.IRemindersService");
        localObject1 = zztf.zza.zzfV(paramParcel1.readStrongBinder());
        if (paramParcel1.readInt() != 0);
        for (paramParcel1 = (TaskEntity)TaskEntity.CREATOR.createFromParcel(paramParcel1); ; paramParcel1 = null)
        {
          zza((zztf)localObject1, paramParcel1);
          paramParcel2.writeNoException();
          return true;
        }
      case 4:
        paramParcel1.enforceInterface("com.google.android.gms.reminders.internal.IRemindersService");
        localObject1 = zztf.zza.zzfV(paramParcel1.readStrongBinder());
        if (paramParcel1.readInt() != 0);
        for (paramParcel1 = (TaskEntity)TaskEntity.CREATOR.createFromParcel(paramParcel1); ; paramParcel1 = null)
        {
          zzb((zztf)localObject1, paramParcel1);
          paramParcel2.writeNoException();
          return true;
        }
      case 5:
        paramParcel1.enforceInterface("com.google.android.gms.reminders.internal.IRemindersService");
        localObject1 = zztf.zza.zzfV(paramParcel1.readStrongBinder());
        if (paramParcel1.readInt() != 0);
        for (paramParcel1 = (TaskIdEntity)TaskIdEntity.CREATOR.createFromParcel(paramParcel1); ; paramParcel1 = null)
        {
          zza((zztf)localObject1, paramParcel1);
          paramParcel2.writeNoException();
          return true;
        }
      case 6:
        paramParcel1.enforceInterface("com.google.android.gms.reminders.internal.IRemindersService");
        localObject1 = zztf.zza.zzfV(paramParcel1.readStrongBinder());
        if (paramParcel1.readInt() != 0);
        for (paramParcel1 = (TaskIdEntity)TaskIdEntity.CREATOR.createFromParcel(paramParcel1); ; paramParcel1 = null)
        {
          zzb((zztf)localObject1, paramParcel1);
          paramParcel2.writeNoException();
          return true;
        }
      case 7:
        paramParcel1.enforceInterface("com.google.android.gms.reminders.internal.IRemindersService");
        zzb(zztf.zza.zzfV(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 8:
        paramParcel1.enforceInterface("com.google.android.gms.reminders.internal.IRemindersService");
        localObject1 = zztf.zza.zzfV(paramParcel1.readStrongBinder());
        if (paramParcel1.readInt() != 0);
        for (paramParcel1 = (TaskEntity)TaskEntity.CREATOR.createFromParcel(paramParcel1); ; paramParcel1 = null)
        {
          zzc((zztf)localObject1, paramParcel1);
          paramParcel2.writeNoException();
          return true;
        }
      case 9:
        paramParcel1.enforceInterface("com.google.android.gms.reminders.internal.IRemindersService");
        localObject2 = zztf.zza.zzfV(paramParcel1.readStrongBinder());
        str = paramParcel1.readString();
        if (paramParcel1.readInt() != 0)
        {
          localObject1 = (TaskEntity)TaskEntity.CREATOR.createFromParcel(paramParcel1);
          if (paramParcel1.readInt() == 0)
            break label647;
        }
        for (paramParcel1 = (UpdateRecurrenceOptions)UpdateRecurrenceOptions.CREATOR.createFromParcel(paramParcel1); ; paramParcel1 = null)
        {
          zza((zztf)localObject2, str, (TaskEntity)localObject1, paramParcel1);
          paramParcel2.writeNoException();
          return true;
          localObject1 = null;
          break;
        }
      case 10:
        paramParcel1.enforceInterface("com.google.android.gms.reminders.internal.IRemindersService");
        localObject1 = zztf.zza.zzfV(paramParcel1.readStrongBinder());
        localObject2 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0);
        for (paramParcel1 = (UpdateRecurrenceOptions)UpdateRecurrenceOptions.CREATOR.createFromParcel(paramParcel1); ; paramParcel1 = null)
        {
          zza((zztf)localObject1, (String)localObject2, paramParcel1);
          paramParcel2.writeNoException();
          return true;
        }
      case 11:
        paramParcel1.enforceInterface("com.google.android.gms.reminders.internal.IRemindersService");
        localObject2 = zztf.zza.zzfV(paramParcel1.readStrongBinder());
        str = paramParcel1.readString();
        if (paramParcel1.readInt() != 0)
        {
          localObject1 = (TaskEntity)TaskEntity.CREATOR.createFromParcel(paramParcel1);
          if (paramParcel1.readInt() == 0)
            break label798;
        }
        for (paramParcel1 = (UpdateRecurrenceOptions)UpdateRecurrenceOptions.CREATOR.createFromParcel(paramParcel1); ; paramParcel1 = null)
        {
          zzb((zztf)localObject2, str, (TaskEntity)localObject1, paramParcel1);
          paramParcel2.writeNoException();
          return true;
          localObject1 = null;
          break;
        }
      case 12:
        paramParcel1.enforceInterface("com.google.android.gms.reminders.internal.IRemindersService");
        localObject1 = zztf.zza.zzfV(paramParcel1.readStrongBinder());
        if (paramParcel1.readInt() != 0);
        for (paramParcel1 = (TaskEntity)TaskEntity.CREATOR.createFromParcel(paramParcel1); ; paramParcel1 = null)
        {
          zzd((zztf)localObject1, paramParcel1);
          paramParcel2.writeNoException();
          return true;
        }
      case 13:
        paramParcel1.enforceInterface("com.google.android.gms.reminders.internal.IRemindersService");
        localObject2 = zztf.zza.zzfV(paramParcel1.readStrongBinder());
        str = paramParcel1.readString();
        if (paramParcel1.readInt() != 0)
        {
          localObject1 = (TaskEntity)TaskEntity.CREATOR.createFromParcel(paramParcel1);
          if (paramParcel1.readInt() == 0)
            break label941;
        }
        for (paramParcel1 = (UpdateRecurrenceOptions)UpdateRecurrenceOptions.CREATOR.createFromParcel(paramParcel1); ; paramParcel1 = null)
        {
          zzc((zztf)localObject2, str, (TaskEntity)localObject1, paramParcel1);
          paramParcel2.writeNoException();
          return true;
          localObject1 = null;
          break;
        }
      case 14:
        paramParcel1.enforceInterface("com.google.android.gms.reminders.internal.IRemindersService");
        zzBY();
        paramParcel2.writeNoException();
        return true;
      case 15:
        paramParcel1.enforceInterface("com.google.android.gms.reminders.internal.IRemindersService");
        zza(zztf.zza.zzfV(paramParcel1.readStrongBinder()), paramParcel1.createTypedArrayList(TaskEntity.CREATOR));
        paramParcel2.writeNoException();
        return true;
      case 16:
        paramParcel1.enforceInterface("com.google.android.gms.reminders.internal.IRemindersService");
        localObject2 = zztf.zza.zzfV(paramParcel1.readStrongBinder());
        if (paramParcel1.readInt() != 0)
        {
          localObject1 = (TaskEntity)TaskEntity.CREATOR.createFromParcel(paramParcel1);
          if (paramParcel1.readInt() == 0)
            break label1069;
        }
        for (paramParcel1 = (CreateReminderOptionsInternal)CreateReminderOptionsInternal.CREATOR.createFromParcel(paramParcel1); ; paramParcel1 = null)
        {
          zza((zztf)localObject2, (TaskEntity)localObject1, paramParcel1);
          paramParcel2.writeNoException();
          return true;
          localObject1 = null;
          break;
        }
      case 17:
        paramParcel1.enforceInterface("com.google.android.gms.reminders.internal.IRemindersService");
        zzc(zztf.zza.zzfV(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 18:
        paramParcel1.enforceInterface("com.google.android.gms.reminders.internal.IRemindersService");
        localObject1 = zztf.zza.zzfV(paramParcel1.readStrongBinder());
        if (paramParcel1.readInt() != 0);
        for (paramParcel1 = (CustomizedSnoozePresetEntity)CustomizedSnoozePresetEntity.CREATOR.createFromParcel(paramParcel1); ; paramParcel1 = null)
        {
          zza((zztf)localObject1, paramParcel1);
          paramParcel2.writeNoException();
          return true;
        }
      case 19:
        label647: label798: label941: paramParcel1.enforceInterface("com.google.android.gms.reminders.internal.IRemindersService");
        label1069: localObject1 = zztf.zza.zzfV(paramParcel1.readStrongBinder());
        if (paramParcel1.readInt() != 0);
        for (paramParcel1 = (AccountState)AccountState.CREATOR.createFromParcel(paramParcel1); ; paramParcel1 = null)
        {
          zza((zztf)localObject1, paramParcel1);
          paramParcel2.writeNoException();
          return true;
        }
      case 20:
      }
      paramParcel1.enforceInterface("com.google.android.gms.reminders.internal.IRemindersService");
      zzd(zztf.zza.zzfV(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    }

    private static class zza
      implements zzth
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

      public void zzBY()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.reminders.internal.IRemindersService");
          zznF.transact(14, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void zza(zztf paramzztf)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.reminders.internal.IRemindersService");
          if (paramzztf != null);
          for (paramzztf = paramzztf.asBinder(); ; paramzztf = null)
          {
            localParcel1.writeStrongBinder(paramzztf);
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
        throw paramzztf;
      }

      public void zza(zztf paramzztf, AccountState paramAccountState)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.reminders.internal.IRemindersService");
          if (paramzztf != null)
          {
            paramzztf = paramzztf.asBinder();
            localParcel1.writeStrongBinder(paramzztf);
            if (paramAccountState == null)
              break label82;
            localParcel1.writeInt(1);
            paramAccountState.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            zznF.transact(19, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
            paramzztf = null;
            break;
            label82: localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzztf;
      }

      public void zza(zztf paramzztf, LoadRemindersOptions paramLoadRemindersOptions)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.reminders.internal.IRemindersService");
          if (paramzztf != null)
          {
            paramzztf = paramzztf.asBinder();
            localParcel1.writeStrongBinder(paramzztf);
            if (paramLoadRemindersOptions == null)
              break label81;
            localParcel1.writeInt(1);
            paramLoadRemindersOptions.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            zznF.transact(1, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
            paramzztf = null;
            break;
            label81: localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzztf;
      }

      public void zza(zztf paramzztf, CustomizedSnoozePresetEntity paramCustomizedSnoozePresetEntity)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.reminders.internal.IRemindersService");
          if (paramzztf != null)
          {
            paramzztf = paramzztf.asBinder();
            localParcel1.writeStrongBinder(paramzztf);
            if (paramCustomizedSnoozePresetEntity == null)
              break label82;
            localParcel1.writeInt(1);
            paramCustomizedSnoozePresetEntity.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            zznF.transact(18, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
            paramzztf = null;
            break;
            label82: localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzztf;
      }

      public void zza(zztf paramzztf, TaskEntity paramTaskEntity)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.reminders.internal.IRemindersService");
          if (paramzztf != null)
          {
            paramzztf = paramzztf.asBinder();
            localParcel1.writeStrongBinder(paramzztf);
            if (paramTaskEntity == null)
              break label81;
            localParcel1.writeInt(1);
            paramTaskEntity.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            zznF.transact(3, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
            paramzztf = null;
            break;
            label81: localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzztf;
      }

      public void zza(zztf paramzztf, TaskEntity paramTaskEntity, CreateReminderOptionsInternal paramCreateReminderOptionsInternal)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.reminders.internal.IRemindersService");
            if (paramzztf != null)
            {
              paramzztf = paramzztf.asBinder();
              localParcel1.writeStrongBinder(paramzztf);
              if (paramTaskEntity != null)
              {
                localParcel1.writeInt(1);
                paramTaskEntity.writeToParcel(localParcel1, 0);
                if (paramCreateReminderOptionsInternal == null)
                  break label128;
                localParcel1.writeInt(1);
                paramCreateReminderOptionsInternal.writeToParcel(localParcel1, 0);
                zznF.transact(16, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              paramzztf = null;
              continue;
            }
            localParcel1.writeInt(0);
            continue;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
          label128: localParcel1.writeInt(0);
        }
      }

      public void zza(zztf paramzztf, TaskIdEntity paramTaskIdEntity)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.reminders.internal.IRemindersService");
          if (paramzztf != null)
          {
            paramzztf = paramzztf.asBinder();
            localParcel1.writeStrongBinder(paramzztf);
            if (paramTaskIdEntity == null)
              break label81;
            localParcel1.writeInt(1);
            paramTaskIdEntity.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            zznF.transact(5, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
            paramzztf = null;
            break;
            label81: localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzztf;
      }

      public void zza(zztf paramzztf, String paramString, UpdateRecurrenceOptions paramUpdateRecurrenceOptions)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.reminders.internal.IRemindersService");
          if (paramzztf != null)
          {
            paramzztf = paramzztf.asBinder();
            localParcel1.writeStrongBinder(paramzztf);
            localParcel1.writeString(paramString);
            if (paramUpdateRecurrenceOptions == null)
              break label95;
            localParcel1.writeInt(1);
            paramUpdateRecurrenceOptions.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            zznF.transact(10, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
            paramzztf = null;
            break;
            label95: localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzztf;
      }

      public void zza(zztf paramzztf, String paramString, TaskEntity paramTaskEntity, UpdateRecurrenceOptions paramUpdateRecurrenceOptions)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.reminders.internal.IRemindersService");
            if (paramzztf != null)
            {
              paramzztf = paramzztf.asBinder();
              localParcel1.writeStrongBinder(paramzztf);
              localParcel1.writeString(paramString);
              if (paramTaskEntity != null)
              {
                localParcel1.writeInt(1);
                paramTaskEntity.writeToParcel(localParcel1, 0);
                if (paramUpdateRecurrenceOptions == null)
                  break label136;
                localParcel1.writeInt(1);
                paramUpdateRecurrenceOptions.writeToParcel(localParcel1, 0);
                zznF.transact(9, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              paramzztf = null;
              continue;
            }
            localParcel1.writeInt(0);
            continue;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
          label136: localParcel1.writeInt(0);
        }
      }

      public void zza(zztf paramzztf, List<TaskEntity> paramList)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.reminders.internal.IRemindersService");
          if (paramzztf != null);
          for (paramzztf = paramzztf.asBinder(); ; paramzztf = null)
          {
            localParcel1.writeStrongBinder(paramzztf);
            localParcel1.writeTypedList(paramList);
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
        throw paramzztf;
      }

      public void zzb(zztf paramzztf)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.reminders.internal.IRemindersService");
          if (paramzztf != null);
          for (paramzztf = paramzztf.asBinder(); ; paramzztf = null)
          {
            localParcel1.writeStrongBinder(paramzztf);
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
        throw paramzztf;
      }

      public void zzb(zztf paramzztf, TaskEntity paramTaskEntity)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.reminders.internal.IRemindersService");
          if (paramzztf != null)
          {
            paramzztf = paramzztf.asBinder();
            localParcel1.writeStrongBinder(paramzztf);
            if (paramTaskEntity == null)
              break label81;
            localParcel1.writeInt(1);
            paramTaskEntity.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            zznF.transact(4, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
            paramzztf = null;
            break;
            label81: localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzztf;
      }

      public void zzb(zztf paramzztf, TaskIdEntity paramTaskIdEntity)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.reminders.internal.IRemindersService");
          if (paramzztf != null)
          {
            paramzztf = paramzztf.asBinder();
            localParcel1.writeStrongBinder(paramzztf);
            if (paramTaskIdEntity == null)
              break label82;
            localParcel1.writeInt(1);
            paramTaskIdEntity.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            zznF.transact(6, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
            paramzztf = null;
            break;
            label82: localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzztf;
      }

      public void zzb(zztf paramzztf, String paramString, TaskEntity paramTaskEntity, UpdateRecurrenceOptions paramUpdateRecurrenceOptions)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.reminders.internal.IRemindersService");
            if (paramzztf != null)
            {
              paramzztf = paramzztf.asBinder();
              localParcel1.writeStrongBinder(paramzztf);
              localParcel1.writeString(paramString);
              if (paramTaskEntity != null)
              {
                localParcel1.writeInt(1);
                paramTaskEntity.writeToParcel(localParcel1, 0);
                if (paramUpdateRecurrenceOptions == null)
                  break label136;
                localParcel1.writeInt(1);
                paramUpdateRecurrenceOptions.writeToParcel(localParcel1, 0);
                zznF.transact(11, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              paramzztf = null;
              continue;
            }
            localParcel1.writeInt(0);
            continue;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
          label136: localParcel1.writeInt(0);
        }
      }

      public void zzc(zztf paramzztf)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.reminders.internal.IRemindersService");
          if (paramzztf != null);
          for (paramzztf = paramzztf.asBinder(); ; paramzztf = null)
          {
            localParcel1.writeStrongBinder(paramzztf);
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
        throw paramzztf;
      }

      public void zzc(zztf paramzztf, TaskEntity paramTaskEntity)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.reminders.internal.IRemindersService");
          if (paramzztf != null)
          {
            paramzztf = paramzztf.asBinder();
            localParcel1.writeStrongBinder(paramzztf);
            if (paramTaskEntity == null)
              break label82;
            localParcel1.writeInt(1);
            paramTaskEntity.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            zznF.transact(8, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
            paramzztf = null;
            break;
            label82: localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzztf;
      }

      public void zzc(zztf paramzztf, String paramString, TaskEntity paramTaskEntity, UpdateRecurrenceOptions paramUpdateRecurrenceOptions)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.reminders.internal.IRemindersService");
            if (paramzztf != null)
            {
              paramzztf = paramzztf.asBinder();
              localParcel1.writeStrongBinder(paramzztf);
              localParcel1.writeString(paramString);
              if (paramTaskEntity != null)
              {
                localParcel1.writeInt(1);
                paramTaskEntity.writeToParcel(localParcel1, 0);
                if (paramUpdateRecurrenceOptions == null)
                  break label136;
                localParcel1.writeInt(1);
                paramUpdateRecurrenceOptions.writeToParcel(localParcel1, 0);
                zznF.transact(13, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              paramzztf = null;
              continue;
            }
            localParcel1.writeInt(0);
            continue;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
          label136: localParcel1.writeInt(0);
        }
      }

      public void zzd(zztf paramzztf)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.reminders.internal.IRemindersService");
          if (paramzztf != null);
          for (paramzztf = paramzztf.asBinder(); ; paramzztf = null)
          {
            localParcel1.writeStrongBinder(paramzztf);
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
        throw paramzztf;
      }

      public void zzd(zztf paramzztf, TaskEntity paramTaskEntity)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.reminders.internal.IRemindersService");
          if (paramzztf != null)
          {
            paramzztf = paramzztf.asBinder();
            localParcel1.writeStrongBinder(paramzztf);
            if (paramTaskEntity == null)
              break label82;
            localParcel1.writeInt(1);
            paramTaskEntity.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            zznF.transact(12, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
            paramzztf = null;
            break;
            label82: localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzztf;
      }
    }
  }
}