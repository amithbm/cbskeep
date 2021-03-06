package com.google.android.gms.drive.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.ChangeSequenceNumber;
import com.google.android.gms.drive.realtime.internal.zzt;
import com.google.android.gms.drive.realtime.internal.zzt.zza;

public abstract interface zzal extends IInterface
{
  public abstract void onSuccess()
    throws RemoteException;

  public abstract void zzQ(Status paramStatus)
    throws RemoteException;

  public abstract void zzU(boolean paramBoolean)
    throws RemoteException;

  public abstract void zza(ChangeSequenceNumber paramChangeSequenceNumber)
    throws RemoteException;

  public abstract void zza(GetPermissionsResponse paramGetPermissionsResponse)
    throws RemoteException;

  public abstract void zza(OnChangesResponse paramOnChangesResponse)
    throws RemoteException;

  public abstract void zza(OnContentsResponse paramOnContentsResponse)
    throws RemoteException;

  public abstract void zza(OnDeviceUsagePreferenceResponse paramOnDeviceUsagePreferenceResponse)
    throws RemoteException;

  public abstract void zza(OnDownloadProgressResponse paramOnDownloadProgressResponse)
    throws RemoteException;

  public abstract void zza(OnDriveIdResponse paramOnDriveIdResponse)
    throws RemoteException;

  public abstract void zza(OnDrivePreferencesResponse paramOnDrivePreferencesResponse)
    throws RemoteException;

  public abstract void zza(OnFetchThumbnailResponse paramOnFetchThumbnailResponse)
    throws RemoteException;

  public abstract void zza(OnListEntriesResponse paramOnListEntriesResponse)
    throws RemoteException;

  public abstract void zza(OnListParentsResponse paramOnListParentsResponse)
    throws RemoteException;

  public abstract void zza(OnLoadRealtimeResponse paramOnLoadRealtimeResponse, zzt paramzzt)
    throws RemoteException;

  public abstract void zza(OnMetadataResponse paramOnMetadataResponse)
    throws RemoteException;

  public abstract void zza(OnResourceIdSetResponse paramOnResourceIdSetResponse)
    throws RemoteException;

  public abstract void zza(OnSyncMoreResponse paramOnSyncMoreResponse)
    throws RemoteException;

  public static abstract class zza extends Binder
    implements zzal
  {
    public zza()
    {
      attachInterface(this, "com.google.android.gms.drive.internal.IDriveServiceCallbacks");
    }

    public static zzal zzcu(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      if ((localIInterface != null) && ((localIInterface instanceof zzal)))
        return (zzal)localIInterface;
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
      Object localObject3 = null;
      Object localObject4 = null;
      Object localObject5 = null;
      Object localObject6 = null;
      Object localObject7 = null;
      Object localObject8 = null;
      Object localObject9 = null;
      Object localObject10 = null;
      Object localObject11 = null;
      Object localObject12 = null;
      Object localObject13 = null;
      Object localObject14 = null;
      Object localObject15 = null;
      Object localObject16 = null;
      Object localObject1 = null;
      switch (paramInt1)
      {
      default:
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902:
        paramParcel2.writeString("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
        return true;
      case 1:
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
        if (paramParcel1.readInt() != 0)
          localObject1 = (OnDownloadProgressResponse)OnDownloadProgressResponse.CREATOR.createFromParcel(paramParcel1);
        zza((OnDownloadProgressResponse)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 2:
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
        localObject1 = localObject2;
        if (paramParcel1.readInt() != 0)
          localObject1 = (OnListEntriesResponse)OnListEntriesResponse.CREATOR.createFromParcel(paramParcel1);
        zza((OnListEntriesResponse)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 3:
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
        localObject1 = localObject3;
        if (paramParcel1.readInt() != 0)
          localObject1 = (OnDriveIdResponse)OnDriveIdResponse.CREATOR.createFromParcel(paramParcel1);
        zza((OnDriveIdResponse)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 4:
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
        localObject1 = localObject4;
        if (paramParcel1.readInt() != 0)
          localObject1 = (OnMetadataResponse)OnMetadataResponse.CREATOR.createFromParcel(paramParcel1);
        zza((OnMetadataResponse)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 5:
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
        localObject1 = localObject5;
        if (paramParcel1.readInt() != 0)
          localObject1 = (OnContentsResponse)OnContentsResponse.CREATOR.createFromParcel(paramParcel1);
        zza((OnContentsResponse)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 6:
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
        localObject1 = localObject6;
        if (paramParcel1.readInt() != 0)
          localObject1 = (Status)Status.CREATOR.createFromParcel(paramParcel1);
        zzQ((Status)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 7:
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
        onSuccess();
        paramParcel2.writeNoException();
        return true;
      case 8:
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
        localObject1 = localObject7;
        if (paramParcel1.readInt() != 0)
          localObject1 = (OnListParentsResponse)OnListParentsResponse.CREATOR.createFromParcel(paramParcel1);
        zza((OnListParentsResponse)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 9:
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
        localObject1 = localObject8;
        if (paramParcel1.readInt() != 0)
          localObject1 = (OnSyncMoreResponse)OnSyncMoreResponse.CREATOR.createFromParcel(paramParcel1);
        zza((OnSyncMoreResponse)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 11:
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
        localObject1 = localObject9;
        if (paramParcel1.readInt() != 0)
          localObject1 = (OnLoadRealtimeResponse)OnLoadRealtimeResponse.CREATOR.createFromParcel(paramParcel1);
        zza((OnLoadRealtimeResponse)localObject1, zzt.zza.zzcH(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 12:
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
        localObject1 = localObject10;
        if (paramParcel1.readInt() != 0)
          localObject1 = (OnResourceIdSetResponse)OnResourceIdSetResponse.CREATOR.createFromParcel(paramParcel1);
        zza((OnResourceIdSetResponse)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 13:
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
        localObject1 = localObject11;
        if (paramParcel1.readInt() != 0)
          localObject1 = (OnDrivePreferencesResponse)OnDrivePreferencesResponse.CREATOR.createFromParcel(paramParcel1);
        zza((OnDrivePreferencesResponse)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 14:
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
        localObject1 = localObject12;
        if (paramParcel1.readInt() != 0)
          localObject1 = (OnDeviceUsagePreferenceResponse)OnDeviceUsagePreferenceResponse.CREATOR.createFromParcel(paramParcel1);
        zza((OnDeviceUsagePreferenceResponse)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 15:
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
        if (paramParcel1.readInt() != 0);
        for (boolean bool = true; ; bool = false)
        {
          zzU(bool);
          paramParcel2.writeNoException();
          return true;
        }
      case 16:
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
        localObject1 = localObject13;
        if (paramParcel1.readInt() != 0)
          localObject1 = (OnFetchThumbnailResponse)OnFetchThumbnailResponse.CREATOR.createFromParcel(paramParcel1);
        zza((OnFetchThumbnailResponse)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 17:
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
        localObject1 = localObject14;
        if (paramParcel1.readInt() != 0)
          localObject1 = (ChangeSequenceNumber)ChangeSequenceNumber.CREATOR.createFromParcel(paramParcel1);
        zza((ChangeSequenceNumber)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 18:
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
        localObject1 = localObject15;
        if (paramParcel1.readInt() != 0)
          localObject1 = (OnChangesResponse)OnChangesResponse.CREATOR.createFromParcel(paramParcel1);
        zza((OnChangesResponse)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 20:
      }
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      localObject1 = localObject16;
      if (paramParcel1.readInt() != 0)
        localObject1 = (GetPermissionsResponse)GetPermissionsResponse.CREATOR.createFromParcel(paramParcel1);
      zza((GetPermissionsResponse)localObject1);
      paramParcel2.writeNoException();
      return true;
    }

    private static class zza
      implements zzal
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

      public void onSuccess()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
          zznF.transact(7, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void zzQ(Status paramStatus)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
          if (paramStatus != null)
          {
            localParcel1.writeInt(1);
            paramStatus.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            zznF.transact(6, localParcel1, localParcel2, 0);
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

      public void zzU(boolean paramBoolean)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
          if (paramBoolean)
            i = 1;
          localParcel1.writeInt(i);
          zznF.transact(15, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void zza(ChangeSequenceNumber paramChangeSequenceNumber)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
          if (paramChangeSequenceNumber != null)
          {
            localParcel1.writeInt(1);
            paramChangeSequenceNumber.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            zznF.transact(17, localParcel1, localParcel2, 0);
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
        throw paramChangeSequenceNumber;
      }

      public void zza(GetPermissionsResponse paramGetPermissionsResponse)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
          if (paramGetPermissionsResponse != null)
          {
            localParcel1.writeInt(1);
            paramGetPermissionsResponse.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            zznF.transact(20, localParcel1, localParcel2, 0);
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
        throw paramGetPermissionsResponse;
      }

      public void zza(OnChangesResponse paramOnChangesResponse)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
          if (paramOnChangesResponse != null)
          {
            localParcel1.writeInt(1);
            paramOnChangesResponse.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            zznF.transact(18, localParcel1, localParcel2, 0);
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
        throw paramOnChangesResponse;
      }

      public void zza(OnContentsResponse paramOnContentsResponse)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
          if (paramOnContentsResponse != null)
          {
            localParcel1.writeInt(1);
            paramOnContentsResponse.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            zznF.transact(5, localParcel1, localParcel2, 0);
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
        throw paramOnContentsResponse;
      }

      public void zza(OnDeviceUsagePreferenceResponse paramOnDeviceUsagePreferenceResponse)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
          if (paramOnDeviceUsagePreferenceResponse != null)
          {
            localParcel1.writeInt(1);
            paramOnDeviceUsagePreferenceResponse.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            zznF.transact(14, localParcel1, localParcel2, 0);
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
        throw paramOnDeviceUsagePreferenceResponse;
      }

      public void zza(OnDownloadProgressResponse paramOnDownloadProgressResponse)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
          if (paramOnDownloadProgressResponse != null)
          {
            localParcel1.writeInt(1);
            paramOnDownloadProgressResponse.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            zznF.transact(1, localParcel1, localParcel2, 0);
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
        throw paramOnDownloadProgressResponse;
      }

      public void zza(OnDriveIdResponse paramOnDriveIdResponse)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
          if (paramOnDriveIdResponse != null)
          {
            localParcel1.writeInt(1);
            paramOnDriveIdResponse.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            zznF.transact(3, localParcel1, localParcel2, 0);
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
        throw paramOnDriveIdResponse;
      }

      public void zza(OnDrivePreferencesResponse paramOnDrivePreferencesResponse)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
          if (paramOnDrivePreferencesResponse != null)
          {
            localParcel1.writeInt(1);
            paramOnDrivePreferencesResponse.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            zznF.transact(13, localParcel1, localParcel2, 0);
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
        throw paramOnDrivePreferencesResponse;
      }

      public void zza(OnFetchThumbnailResponse paramOnFetchThumbnailResponse)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
          if (paramOnFetchThumbnailResponse != null)
          {
            localParcel1.writeInt(1);
            paramOnFetchThumbnailResponse.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            zznF.transact(16, localParcel1, localParcel2, 0);
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
        throw paramOnFetchThumbnailResponse;
      }

      public void zza(OnListEntriesResponse paramOnListEntriesResponse)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
          if (paramOnListEntriesResponse != null)
          {
            localParcel1.writeInt(1);
            paramOnListEntriesResponse.writeToParcel(localParcel1, 0);
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
        throw paramOnListEntriesResponse;
      }

      public void zza(OnListParentsResponse paramOnListParentsResponse)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
          if (paramOnListParentsResponse != null)
          {
            localParcel1.writeInt(1);
            paramOnListParentsResponse.writeToParcel(localParcel1, 0);
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
        throw paramOnListParentsResponse;
      }

      public void zza(OnLoadRealtimeResponse paramOnLoadRealtimeResponse, zzt paramzzt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
            if (paramOnLoadRealtimeResponse != null)
            {
              localParcel1.writeInt(1);
              paramOnLoadRealtimeResponse.writeToParcel(localParcel1, 0);
              if (paramzzt != null)
              {
                paramOnLoadRealtimeResponse = paramzzt.asBinder();
                localParcel1.writeStrongBinder(paramOnLoadRealtimeResponse);
                zznF.transact(11, localParcel1, localParcel2, 0);
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
          paramOnLoadRealtimeResponse = null;
        }
      }

      public void zza(OnMetadataResponse paramOnMetadataResponse)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
          if (paramOnMetadataResponse != null)
          {
            localParcel1.writeInt(1);
            paramOnMetadataResponse.writeToParcel(localParcel1, 0);
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
        throw paramOnMetadataResponse;
      }

      public void zza(OnResourceIdSetResponse paramOnResourceIdSetResponse)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
          if (paramOnResourceIdSetResponse != null)
          {
            localParcel1.writeInt(1);
            paramOnResourceIdSetResponse.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            zznF.transact(12, localParcel1, localParcel2, 0);
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
        throw paramOnResourceIdSetResponse;
      }

      public void zza(OnSyncMoreResponse paramOnSyncMoreResponse)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
          if (paramOnSyncMoreResponse != null)
          {
            localParcel1.writeInt(1);
            paramOnSyncMoreResponse.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            zznF.transact(9, localParcel1, localParcel2, 0);
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
        throw paramOnSyncMoreResponse;
      }
    }
  }
}