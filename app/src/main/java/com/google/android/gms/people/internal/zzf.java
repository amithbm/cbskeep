package com.google.android.gms.people.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zze;

public abstract interface zzf extends IInterface
{
  public abstract void zza(int paramInt, Bundle paramBundle1, Bundle paramBundle2)
    throws RemoteException;

  public abstract void zza(int paramInt, Bundle paramBundle, ParcelFileDescriptor paramParcelFileDescriptor)
    throws RemoteException;

  public abstract void zza(int paramInt, Bundle paramBundle1, ParcelFileDescriptor paramParcelFileDescriptor, Bundle paramBundle2)
    throws RemoteException;

  public abstract void zza(int paramInt, Bundle paramBundle, DataHolder paramDataHolder)
    throws RemoteException;

  public abstract void zza(int paramInt, Bundle paramBundle, DataHolder[] paramArrayOfDataHolder)
    throws RemoteException;

  public static abstract class zza extends Binder
    implements zzf
  {
    public zza()
    {
      attachInterface(this, "com.google.android.gms.people.internal.IPeopleCallbacks");
    }

    public static zzf zzfz(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.people.internal.IPeopleCallbacks");
      if ((localIInterface != null) && ((localIInterface instanceof zzf)))
        return (zzf)localIInterface;
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
        paramParcel2.writeString("com.google.android.gms.people.internal.IPeopleCallbacks");
        return true;
      case 1:
        paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleCallbacks");
        paramInt1 = paramParcel1.readInt();
        if (paramParcel1.readInt() != 0)
        {
          paramParcel2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
          if (paramParcel1.readInt() == 0)
            break label147;
        }
        for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1); ; paramParcel1 = null)
        {
          zza(paramInt1, paramParcel2, paramParcel1);
          return true;
          paramParcel2 = null;
          break;
        }
      case 2:
        paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleCallbacks");
        paramInt1 = paramParcel1.readInt();
        if (paramParcel1.readInt() != 0);
        for (paramParcel2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1); ; paramParcel2 = null)
        {
          if (paramParcel1.readInt() != 0)
            localObject1 = DataHolder.CREATOR.zzcH(paramParcel1);
          zza(paramInt1, paramParcel2, (DataHolder)localObject1);
          return true;
        }
      case 3:
        paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleCallbacks");
        paramInt1 = paramParcel1.readInt();
        if (paramParcel1.readInt() != 0)
        {
          paramParcel2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
          if (paramParcel1.readInt() == 0)
            break label279;
        }
        for (paramParcel1 = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.createFromParcel(paramParcel1); ; paramParcel1 = null)
        {
          zza(paramInt1, paramParcel2, paramParcel1);
          return true;
          paramParcel2 = null;
          break;
        }
      case 4:
        label147: label279: paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleCallbacks");
        paramInt1 = paramParcel1.readInt();
        paramParcel2 = localObject2;
        if (paramParcel1.readInt() != 0)
          paramParcel2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        zza(paramInt1, paramParcel2, (DataHolder[])paramParcel1.createTypedArray(DataHolder.CREATOR));
        return true;
      case 5:
      }
      paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleCallbacks");
      paramInt1 = paramParcel1.readInt();
      if (paramParcel1.readInt() != 0)
      {
        paramParcel2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        if (paramParcel1.readInt() == 0)
          break label424;
        localObject1 = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.createFromParcel(paramParcel1);
        label388: if (paramParcel1.readInt() == 0)
          break label430;
      }
      label424: label430: for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1); ; paramParcel1 = null)
      {
        zza(paramInt1, paramParcel2, (ParcelFileDescriptor)localObject1, paramParcel1);
        return true;
        paramParcel2 = null;
        break;
        localObject1 = null;
        break label388;
      }
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

      public void zza(int paramInt, Bundle paramBundle1, Bundle paramBundle2)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleCallbacks");
            localParcel.writeInt(paramInt);
            if (paramBundle1 != null)
            {
              localParcel.writeInt(1);
              paramBundle1.writeToParcel(localParcel, 0);
              if (paramBundle2 != null)
              {
                localParcel.writeInt(1);
                paramBundle2.writeToParcel(localParcel, 0);
                zznF.transact(1, localParcel, null, 1);
              }
            }
            else
            {
              localParcel.writeInt(0);
              continue;
            }
          }
          finally
          {
            localParcel.recycle();
          }
          localParcel.writeInt(0);
        }
      }

      public void zza(int paramInt, Bundle paramBundle, ParcelFileDescriptor paramParcelFileDescriptor)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleCallbacks");
            localParcel.writeInt(paramInt);
            if (paramBundle != null)
            {
              localParcel.writeInt(1);
              paramBundle.writeToParcel(localParcel, 0);
              if (paramParcelFileDescriptor != null)
              {
                localParcel.writeInt(1);
                paramParcelFileDescriptor.writeToParcel(localParcel, 0);
                zznF.transact(3, localParcel, null, 1);
              }
            }
            else
            {
              localParcel.writeInt(0);
              continue;
            }
          }
          finally
          {
            localParcel.recycle();
          }
          localParcel.writeInt(0);
        }
      }

      public void zza(int paramInt, Bundle paramBundle1, ParcelFileDescriptor paramParcelFileDescriptor, Bundle paramBundle2)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleCallbacks");
            localParcel.writeInt(paramInt);
            if (paramBundle1 != null)
            {
              localParcel.writeInt(1);
              paramBundle1.writeToParcel(localParcel, 0);
              if (paramParcelFileDescriptor != null)
              {
                localParcel.writeInt(1);
                paramParcelFileDescriptor.writeToParcel(localParcel, 0);
                if (paramBundle2 == null)
                  break label118;
                localParcel.writeInt(1);
                paramBundle2.writeToParcel(localParcel, 0);
                zznF.transact(5, localParcel, null, 1);
              }
            }
            else
            {
              localParcel.writeInt(0);
              continue;
            }
          }
          finally
          {
            localParcel.recycle();
          }
          localParcel.writeInt(0);
          continue;
          label118: localParcel.writeInt(0);
        }
      }

      public void zza(int paramInt, Bundle paramBundle, DataHolder paramDataHolder)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleCallbacks");
            localParcel.writeInt(paramInt);
            if (paramBundle != null)
            {
              localParcel.writeInt(1);
              paramBundle.writeToParcel(localParcel, 0);
              if (paramDataHolder != null)
              {
                localParcel.writeInt(1);
                paramDataHolder.writeToParcel(localParcel, 0);
                zznF.transact(2, localParcel, null, 1);
              }
            }
            else
            {
              localParcel.writeInt(0);
              continue;
            }
          }
          finally
          {
            localParcel.recycle();
          }
          localParcel.writeInt(0);
        }
      }

      public void zza(int paramInt, Bundle paramBundle, DataHolder[] paramArrayOfDataHolder)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleCallbacks");
          localParcel.writeInt(paramInt);
          if (paramBundle != null)
          {
            localParcel.writeInt(1);
            paramBundle.writeToParcel(localParcel, 0);
          }
          while (true)
          {
            localParcel.writeTypedArray(paramArrayOfDataHolder, 0);
            zznF.transact(4, localParcel, null, 1);
            return;
            localParcel.writeInt(0);
          }
        }
        finally
        {
          localParcel.recycle();
        }
        throw paramBundle;
      }
    }
  }
}