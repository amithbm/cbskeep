package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zze;
import com.google.android.gms.reminders.model.TaskEntity;

public abstract interface zztg extends IInterface
{
  public abstract void zza(TaskEntity paramTaskEntity)
    throws RemoteException;

  public abstract void zzah(DataHolder paramDataHolder)
    throws RemoteException;

  public abstract void zzai(DataHolder paramDataHolder)
    throws RemoteException;

  public abstract void zzaj(DataHolder paramDataHolder)
    throws RemoteException;

  public static abstract class zza extends Binder
    implements zztg
  {
    public zza()
    {
      attachInterface(this, "com.google.android.gms.reminders.internal.IRemindersListener");
    }

    public IBinder asBinder()
    {
      return this;
    }

    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      Object localObject2 = null;
      Object localObject3 = null;
      Object localObject4 = null;
      Object localObject1 = null;
      switch (paramInt1)
      {
      default:
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902:
        paramParcel2.writeString("com.google.android.gms.reminders.internal.IRemindersListener");
        return true;
      case 1:
        paramParcel1.enforceInterface("com.google.android.gms.reminders.internal.IRemindersListener");
        if (paramParcel1.readInt() != 0)
          localObject1 = (TaskEntity)TaskEntity.CREATOR.createFromParcel(paramParcel1);
        zza((TaskEntity)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 2:
        paramParcel1.enforceInterface("com.google.android.gms.reminders.internal.IRemindersListener");
        localObject1 = localObject2;
        if (paramParcel1.readInt() != 0)
          localObject1 = DataHolder.CREATOR.zzcH(paramParcel1);
        zzai((DataHolder)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 3:
        paramParcel1.enforceInterface("com.google.android.gms.reminders.internal.IRemindersListener");
        localObject1 = localObject3;
        if (paramParcel1.readInt() != 0)
          localObject1 = DataHolder.CREATOR.zzcH(paramParcel1);
        zzah((DataHolder)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 4:
      }
      paramParcel1.enforceInterface("com.google.android.gms.reminders.internal.IRemindersListener");
      localObject1 = localObject4;
      if (paramParcel1.readInt() != 0)
        localObject1 = DataHolder.CREATOR.zzcH(paramParcel1);
      zzaj((DataHolder)localObject1);
      paramParcel2.writeNoException();
      return true;
    }
  }
}