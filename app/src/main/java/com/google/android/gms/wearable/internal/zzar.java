package com.google.android.gms.wearable.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zze;

public abstract interface zzar extends IInterface
{
  public abstract void zza(AddLocalCapabilityResponse paramAddLocalCapabilityResponse)
    throws RemoteException;

  public abstract void zza(ChannelReceiveFileResponse paramChannelReceiveFileResponse)
    throws RemoteException;

  public abstract void zza(ChannelSendFileResponse paramChannelSendFileResponse)
    throws RemoteException;

  public abstract void zza(CloseChannelResponse paramCloseChannelResponse)
    throws RemoteException;

  public abstract void zza(DeleteDataItemsResponse paramDeleteDataItemsResponse)
    throws RemoteException;

  public abstract void zza(GetAllCapabilitiesResponse paramGetAllCapabilitiesResponse)
    throws RemoteException;

  public abstract void zza(GetCapabilityResponse paramGetCapabilityResponse)
    throws RemoteException;

  public abstract void zza(GetChannelInputStreamResponse paramGetChannelInputStreamResponse)
    throws RemoteException;

  public abstract void zza(GetChannelOutputStreamResponse paramGetChannelOutputStreamResponse)
    throws RemoteException;

  public abstract void zza(GetCloudSyncOptInOutDoneResponse paramGetCloudSyncOptInOutDoneResponse)
    throws RemoteException;

  public abstract void zza(GetCloudSyncSettingResponse paramGetCloudSyncSettingResponse)
    throws RemoteException;

  public abstract void zza(GetConfigResponse paramGetConfigResponse)
    throws RemoteException;

  public abstract void zza(GetConfigsResponse paramGetConfigsResponse)
    throws RemoteException;

  public abstract void zza(GetConnectedNodesResponse paramGetConnectedNodesResponse)
    throws RemoteException;

  public abstract void zza(GetDataItemResponse paramGetDataItemResponse)
    throws RemoteException;

  public abstract void zza(GetFdForAssetResponse paramGetFdForAssetResponse)
    throws RemoteException;

  public abstract void zza(GetLocalNodeResponse paramGetLocalNodeResponse)
    throws RemoteException;

  public abstract void zza(OpenChannelResponse paramOpenChannelResponse)
    throws RemoteException;

  public abstract void zza(PutDataResponse paramPutDataResponse)
    throws RemoteException;

  public abstract void zza(RemoveLocalCapabilityResponse paramRemoveLocalCapabilityResponse)
    throws RemoteException;

  public abstract void zza(SendMessageResponse paramSendMessageResponse)
    throws RemoteException;

  public abstract void zza(StorageInfoResponse paramStorageInfoResponse)
    throws RemoteException;

  public abstract void zzan(DataHolder paramDataHolder)
    throws RemoteException;

  public abstract void zzb(Status paramStatus)
    throws RemoteException;

  public abstract void zzb(CloseChannelResponse paramCloseChannelResponse)
    throws RemoteException;

  public static abstract class zza extends Binder
    implements zzar
  {
    public zza()
    {
      attachInterface(this, "com.google.android.gms.wearable.internal.IWearableCallbacks");
    }

    public static zzar zzhv(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
      if ((localIInterface != null) && ((localIInterface instanceof zzar)))
        return (zzar)localIInterface;
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
      Object localObject17 = null;
      Object localObject18 = null;
      Object localObject19 = null;
      Object localObject20 = null;
      Object localObject21 = null;
      Object localObject22 = null;
      Object localObject23 = null;
      Object localObject24 = null;
      Object localObject25 = null;
      Object localObject1 = null;
      switch (paramInt1)
      {
      default:
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902:
        paramParcel2.writeString("com.google.android.gms.wearable.internal.IWearableCallbacks");
        return true;
      case 2:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
        if (paramParcel1.readInt() != 0)
          localObject1 = (GetConfigResponse)GetConfigResponse.CREATOR.createFromParcel(paramParcel1);
        zza((GetConfigResponse)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 13:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
        localObject1 = localObject2;
        if (paramParcel1.readInt() != 0)
          localObject1 = (GetConfigsResponse)GetConfigsResponse.CREATOR.createFromParcel(paramParcel1);
        zza((GetConfigsResponse)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 28:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
        localObject1 = localObject3;
        if (paramParcel1.readInt() != 0)
          localObject1 = (GetCloudSyncOptInOutDoneResponse)GetCloudSyncOptInOutDoneResponse.CREATOR.createFromParcel(paramParcel1);
        zza((GetCloudSyncOptInOutDoneResponse)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 29:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
        localObject1 = localObject4;
        if (paramParcel1.readInt() != 0)
          localObject1 = (GetCloudSyncSettingResponse)GetCloudSyncSettingResponse.CREATOR.createFromParcel(paramParcel1);
        zza((GetCloudSyncSettingResponse)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 3:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
        localObject1 = localObject5;
        if (paramParcel1.readInt() != 0)
          localObject1 = (PutDataResponse)PutDataResponse.CREATOR.createFromParcel(paramParcel1);
        zza((PutDataResponse)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 4:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
        localObject1 = localObject6;
        if (paramParcel1.readInt() != 0)
          localObject1 = (GetDataItemResponse)GetDataItemResponse.CREATOR.createFromParcel(paramParcel1);
        zza((GetDataItemResponse)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 5:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
        localObject1 = localObject7;
        if (paramParcel1.readInt() != 0)
          localObject1 = DataHolder.CREATOR.zzcH(paramParcel1);
        zzan((DataHolder)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 6:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
        localObject1 = localObject8;
        if (paramParcel1.readInt() != 0)
          localObject1 = (DeleteDataItemsResponse)DeleteDataItemsResponse.CREATOR.createFromParcel(paramParcel1);
        zza((DeleteDataItemsResponse)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 7:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
        localObject1 = localObject9;
        if (paramParcel1.readInt() != 0)
          localObject1 = (SendMessageResponse)SendMessageResponse.CREATOR.createFromParcel(paramParcel1);
        zza((SendMessageResponse)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 8:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
        localObject1 = localObject10;
        if (paramParcel1.readInt() != 0)
          localObject1 = (GetFdForAssetResponse)GetFdForAssetResponse.CREATOR.createFromParcel(paramParcel1);
        zza((GetFdForAssetResponse)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 9:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
        localObject1 = localObject11;
        if (paramParcel1.readInt() != 0)
          localObject1 = (GetLocalNodeResponse)GetLocalNodeResponse.CREATOR.createFromParcel(paramParcel1);
        zza((GetLocalNodeResponse)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 10:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
        localObject1 = localObject12;
        if (paramParcel1.readInt() != 0)
          localObject1 = (GetConnectedNodesResponse)GetConnectedNodesResponse.CREATOR.createFromParcel(paramParcel1);
        zza((GetConnectedNodesResponse)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 14:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
        localObject1 = localObject13;
        if (paramParcel1.readInt() != 0)
          localObject1 = (OpenChannelResponse)OpenChannelResponse.CREATOR.createFromParcel(paramParcel1);
        zza((OpenChannelResponse)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 15:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
        localObject1 = localObject14;
        if (paramParcel1.readInt() != 0)
          localObject1 = (CloseChannelResponse)CloseChannelResponse.CREATOR.createFromParcel(paramParcel1);
        zza((CloseChannelResponse)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 16:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
        localObject1 = localObject15;
        if (paramParcel1.readInt() != 0)
          localObject1 = (CloseChannelResponse)CloseChannelResponse.CREATOR.createFromParcel(paramParcel1);
        zzb((CloseChannelResponse)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 17:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
        localObject1 = localObject16;
        if (paramParcel1.readInt() != 0)
          localObject1 = (GetChannelInputStreamResponse)GetChannelInputStreamResponse.CREATOR.createFromParcel(paramParcel1);
        zza((GetChannelInputStreamResponse)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 18:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
        localObject1 = localObject17;
        if (paramParcel1.readInt() != 0)
          localObject1 = (GetChannelOutputStreamResponse)GetChannelOutputStreamResponse.CREATOR.createFromParcel(paramParcel1);
        zza((GetChannelOutputStreamResponse)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 19:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
        localObject1 = localObject18;
        if (paramParcel1.readInt() != 0)
          localObject1 = (ChannelReceiveFileResponse)ChannelReceiveFileResponse.CREATOR.createFromParcel(paramParcel1);
        zza((ChannelReceiveFileResponse)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 20:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
        localObject1 = localObject19;
        if (paramParcel1.readInt() != 0)
          localObject1 = (ChannelSendFileResponse)ChannelSendFileResponse.CREATOR.createFromParcel(paramParcel1);
        zza((ChannelSendFileResponse)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 11:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
        localObject1 = localObject20;
        if (paramParcel1.readInt() != 0)
          localObject1 = (Status)Status.CREATOR.createFromParcel(paramParcel1);
        zzb((Status)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 12:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
        localObject1 = localObject21;
        if (paramParcel1.readInt() != 0)
          localObject1 = (StorageInfoResponse)StorageInfoResponse.CREATOR.createFromParcel(paramParcel1);
        zza((StorageInfoResponse)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 22:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
        localObject1 = localObject22;
        if (paramParcel1.readInt() != 0)
          localObject1 = (GetCapabilityResponse)GetCapabilityResponse.CREATOR.createFromParcel(paramParcel1);
        zza((GetCapabilityResponse)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 23:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
        localObject1 = localObject23;
        if (paramParcel1.readInt() != 0)
          localObject1 = (GetAllCapabilitiesResponse)GetAllCapabilitiesResponse.CREATOR.createFromParcel(paramParcel1);
        zza((GetAllCapabilitiesResponse)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 26:
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
        localObject1 = localObject24;
        if (paramParcel1.readInt() != 0)
          localObject1 = (AddLocalCapabilityResponse)AddLocalCapabilityResponse.CREATOR.createFromParcel(paramParcel1);
        zza((AddLocalCapabilityResponse)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 27:
      }
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
      localObject1 = localObject25;
      if (paramParcel1.readInt() != 0)
        localObject1 = (RemoveLocalCapabilityResponse)RemoveLocalCapabilityResponse.CREATOR.createFromParcel(paramParcel1);
      zza((RemoveLocalCapabilityResponse)localObject1);
      paramParcel2.writeNoException();
      return true;
    }

    private static class zza
      implements zzar
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

      public void zza(AddLocalCapabilityResponse paramAddLocalCapabilityResponse)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
          if (paramAddLocalCapabilityResponse != null)
          {
            localParcel1.writeInt(1);
            paramAddLocalCapabilityResponse.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            zznF.transact(26, localParcel1, localParcel2, 0);
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
        throw paramAddLocalCapabilityResponse;
      }

      public void zza(ChannelReceiveFileResponse paramChannelReceiveFileResponse)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
          if (paramChannelReceiveFileResponse != null)
          {
            localParcel1.writeInt(1);
            paramChannelReceiveFileResponse.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            zznF.transact(19, localParcel1, localParcel2, 0);
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
        throw paramChannelReceiveFileResponse;
      }

      public void zza(ChannelSendFileResponse paramChannelSendFileResponse)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
          if (paramChannelSendFileResponse != null)
          {
            localParcel1.writeInt(1);
            paramChannelSendFileResponse.writeToParcel(localParcel1, 0);
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
        throw paramChannelSendFileResponse;
      }

      public void zza(CloseChannelResponse paramCloseChannelResponse)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
          if (paramCloseChannelResponse != null)
          {
            localParcel1.writeInt(1);
            paramCloseChannelResponse.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            zznF.transact(15, localParcel1, localParcel2, 0);
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
        throw paramCloseChannelResponse;
      }

      public void zza(DeleteDataItemsResponse paramDeleteDataItemsResponse)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
          if (paramDeleteDataItemsResponse != null)
          {
            localParcel1.writeInt(1);
            paramDeleteDataItemsResponse.writeToParcel(localParcel1, 0);
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
        throw paramDeleteDataItemsResponse;
      }

      public void zza(GetAllCapabilitiesResponse paramGetAllCapabilitiesResponse)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
          if (paramGetAllCapabilitiesResponse != null)
          {
            localParcel1.writeInt(1);
            paramGetAllCapabilitiesResponse.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            zznF.transact(23, localParcel1, localParcel2, 0);
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
        throw paramGetAllCapabilitiesResponse;
      }

      public void zza(GetCapabilityResponse paramGetCapabilityResponse)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
          if (paramGetCapabilityResponse != null)
          {
            localParcel1.writeInt(1);
            paramGetCapabilityResponse.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            zznF.transact(22, localParcel1, localParcel2, 0);
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
        throw paramGetCapabilityResponse;
      }

      public void zza(GetChannelInputStreamResponse paramGetChannelInputStreamResponse)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
          if (paramGetChannelInputStreamResponse != null)
          {
            localParcel1.writeInt(1);
            paramGetChannelInputStreamResponse.writeToParcel(localParcel1, 0);
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
        throw paramGetChannelInputStreamResponse;
      }

      public void zza(GetChannelOutputStreamResponse paramGetChannelOutputStreamResponse)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
          if (paramGetChannelOutputStreamResponse != null)
          {
            localParcel1.writeInt(1);
            paramGetChannelOutputStreamResponse.writeToParcel(localParcel1, 0);
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
        throw paramGetChannelOutputStreamResponse;
      }

      public void zza(GetCloudSyncOptInOutDoneResponse paramGetCloudSyncOptInOutDoneResponse)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
          if (paramGetCloudSyncOptInOutDoneResponse != null)
          {
            localParcel1.writeInt(1);
            paramGetCloudSyncOptInOutDoneResponse.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            zznF.transact(28, localParcel1, localParcel2, 0);
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
        throw paramGetCloudSyncOptInOutDoneResponse;
      }

      public void zza(GetCloudSyncSettingResponse paramGetCloudSyncSettingResponse)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
          if (paramGetCloudSyncSettingResponse != null)
          {
            localParcel1.writeInt(1);
            paramGetCloudSyncSettingResponse.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            zznF.transact(29, localParcel1, localParcel2, 0);
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
        throw paramGetCloudSyncSettingResponse;
      }

      public void zza(GetConfigResponse paramGetConfigResponse)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
          if (paramGetConfigResponse != null)
          {
            localParcel1.writeInt(1);
            paramGetConfigResponse.writeToParcel(localParcel1, 0);
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
        throw paramGetConfigResponse;
      }

      public void zza(GetConfigsResponse paramGetConfigsResponse)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
          if (paramGetConfigsResponse != null)
          {
            localParcel1.writeInt(1);
            paramGetConfigsResponse.writeToParcel(localParcel1, 0);
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
        throw paramGetConfigsResponse;
      }

      public void zza(GetConnectedNodesResponse paramGetConnectedNodesResponse)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
          if (paramGetConnectedNodesResponse != null)
          {
            localParcel1.writeInt(1);
            paramGetConnectedNodesResponse.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            zznF.transact(10, localParcel1, localParcel2, 0);
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
        throw paramGetConnectedNodesResponse;
      }

      public void zza(GetDataItemResponse paramGetDataItemResponse)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
          if (paramGetDataItemResponse != null)
          {
            localParcel1.writeInt(1);
            paramGetDataItemResponse.writeToParcel(localParcel1, 0);
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
        throw paramGetDataItemResponse;
      }

      public void zza(GetFdForAssetResponse paramGetFdForAssetResponse)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
          if (paramGetFdForAssetResponse != null)
          {
            localParcel1.writeInt(1);
            paramGetFdForAssetResponse.writeToParcel(localParcel1, 0);
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
        throw paramGetFdForAssetResponse;
      }

      public void zza(GetLocalNodeResponse paramGetLocalNodeResponse)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
          if (paramGetLocalNodeResponse != null)
          {
            localParcel1.writeInt(1);
            paramGetLocalNodeResponse.writeToParcel(localParcel1, 0);
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
        throw paramGetLocalNodeResponse;
      }

      public void zza(OpenChannelResponse paramOpenChannelResponse)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
          if (paramOpenChannelResponse != null)
          {
            localParcel1.writeInt(1);
            paramOpenChannelResponse.writeToParcel(localParcel1, 0);
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
        throw paramOpenChannelResponse;
      }

      public void zza(PutDataResponse paramPutDataResponse)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
          if (paramPutDataResponse != null)
          {
            localParcel1.writeInt(1);
            paramPutDataResponse.writeToParcel(localParcel1, 0);
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
        throw paramPutDataResponse;
      }

      public void zza(RemoveLocalCapabilityResponse paramRemoveLocalCapabilityResponse)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
          if (paramRemoveLocalCapabilityResponse != null)
          {
            localParcel1.writeInt(1);
            paramRemoveLocalCapabilityResponse.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            zznF.transact(27, localParcel1, localParcel2, 0);
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
        throw paramRemoveLocalCapabilityResponse;
      }

      public void zza(SendMessageResponse paramSendMessageResponse)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
          if (paramSendMessageResponse != null)
          {
            localParcel1.writeInt(1);
            paramSendMessageResponse.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            zznF.transact(7, localParcel1, localParcel2, 0);
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
        throw paramSendMessageResponse;
      }

      public void zza(StorageInfoResponse paramStorageInfoResponse)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
          if (paramStorageInfoResponse != null)
          {
            localParcel1.writeInt(1);
            paramStorageInfoResponse.writeToParcel(localParcel1, 0);
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
        throw paramStorageInfoResponse;
      }

      public void zzan(DataHolder paramDataHolder)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
          if (paramDataHolder != null)
          {
            localParcel1.writeInt(1);
            paramDataHolder.writeToParcel(localParcel1, 0);
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
        throw paramDataHolder;
      }

      public void zzb(Status paramStatus)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
          if (paramStatus != null)
          {
            localParcel1.writeInt(1);
            paramStatus.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            zznF.transact(11, localParcel1, localParcel2, 0);
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

      public void zzb(CloseChannelResponse paramCloseChannelResponse)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
          if (paramCloseChannelResponse != null)
          {
            localParcel1.writeInt(1);
            paramCloseChannelResponse.writeToParcel(localParcel1, 0);
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
        throw paramCloseChannelResponse;
      }
    }
  }
}