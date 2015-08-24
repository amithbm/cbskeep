package com.google.android.gms.drive.internal;

import android.content.IntentSender;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.drive.RealtimeDocumentSyncRequest;

public abstract interface zzak extends IInterface
{
  public abstract IntentSender zza(CreateFileIntentSenderRequest paramCreateFileIntentSenderRequest)
    throws RemoteException;

  public abstract IntentSender zza(OpenFileIntentSenderRequest paramOpenFileIntentSenderRequest)
    throws RemoteException;

  public abstract DriveServiceResponse zza(OpenContentsRequest paramOpenContentsRequest, zzal paramzzal)
    throws RemoteException;

  public abstract void zza(RealtimeDocumentSyncRequest paramRealtimeDocumentSyncRequest, zzal paramzzal)
    throws RemoteException;

  public abstract void zza(AddEventListenerRequest paramAddEventListenerRequest, zzam paramzzam, String paramString, zzal paramzzal)
    throws RemoteException;

  public abstract void zza(AddPermissionRequest paramAddPermissionRequest, zzal paramzzal)
    throws RemoteException;

  public abstract void zza(AuthorizeAccessRequest paramAuthorizeAccessRequest, zzal paramzzal)
    throws RemoteException;

  public abstract void zza(CancelPendingActionsRequest paramCancelPendingActionsRequest, zzal paramzzal)
    throws RemoteException;

  public abstract void zza(CheckResourceIdsExistRequest paramCheckResourceIdsExistRequest, zzal paramzzal)
    throws RemoteException;

  public abstract void zza(CloseContentsAndUpdateMetadataRequest paramCloseContentsAndUpdateMetadataRequest, zzal paramzzal)
    throws RemoteException;

  public abstract void zza(CloseContentsRequest paramCloseContentsRequest, zzal paramzzal)
    throws RemoteException;

  public abstract void zza(CreateContentsRequest paramCreateContentsRequest, zzal paramzzal)
    throws RemoteException;

  public abstract void zza(CreateFileRequest paramCreateFileRequest, zzal paramzzal)
    throws RemoteException;

  public abstract void zza(CreateFolderRequest paramCreateFolderRequest, zzal paramzzal)
    throws RemoteException;

  public abstract void zza(DeleteResourceRequest paramDeleteResourceRequest, zzal paramzzal)
    throws RemoteException;

  public abstract void zza(DisconnectRequest paramDisconnectRequest)
    throws RemoteException;

  public abstract void zza(FetchThumbnailRequest paramFetchThumbnailRequest, zzal paramzzal)
    throws RemoteException;

  public abstract void zza(GetChangesRequest paramGetChangesRequest, zzal paramzzal)
    throws RemoteException;

  public abstract void zza(GetDriveIdFromUniqueIdentifierRequest paramGetDriveIdFromUniqueIdentifierRequest, zzal paramzzal)
    throws RemoteException;

  public abstract void zza(GetMetadataRequest paramGetMetadataRequest, zzal paramzzal)
    throws RemoteException;

  public abstract void zza(GetPermissionsRequest paramGetPermissionsRequest, zzal paramzzal)
    throws RemoteException;

  public abstract void zza(ListParentsRequest paramListParentsRequest, zzal paramzzal)
    throws RemoteException;

  public abstract void zza(LoadRealtimeRequest paramLoadRealtimeRequest, zzal paramzzal)
    throws RemoteException;

  public abstract void zza(QueryRequest paramQueryRequest, zzal paramzzal)
    throws RemoteException;

  public abstract void zza(QueryRequest paramQueryRequest, zzam paramzzam, zzal paramzzal)
    throws RemoteException;

  public abstract void zza(RemoveEventListenerRequest paramRemoveEventListenerRequest, zzam paramzzam, String paramString, zzal paramzzal)
    throws RemoteException;

  public abstract void zza(RemovePermissionRequest paramRemovePermissionRequest, zzal paramzzal)
    throws RemoteException;

  public abstract void zza(SetDrivePreferencesRequest paramSetDrivePreferencesRequest, zzal paramzzal)
    throws RemoteException;

  public abstract void zza(SetFileUploadPreferencesRequest paramSetFileUploadPreferencesRequest, zzal paramzzal)
    throws RemoteException;

  public abstract void zza(SetResourceParentsRequest paramSetResourceParentsRequest, zzal paramzzal)
    throws RemoteException;

  public abstract void zza(TrashResourceRequest paramTrashResourceRequest, zzal paramzzal)
    throws RemoteException;

  public abstract void zza(UnsubscribeResourceRequest paramUnsubscribeResourceRequest, zzal paramzzal)
    throws RemoteException;

  public abstract void zza(UntrashResourceRequest paramUntrashResourceRequest, zzal paramzzal)
    throws RemoteException;

  public abstract void zza(UpdateMetadataRequest paramUpdateMetadataRequest, zzal paramzzal)
    throws RemoteException;

  public abstract void zza(UpdatePermissionRequest paramUpdatePermissionRequest, zzal paramzzal)
    throws RemoteException;

  public abstract void zza(zzal paramzzal)
    throws RemoteException;

  public abstract void zza(zzam paramzzam, zzal paramzzal)
    throws RemoteException;

  public abstract void zzb(QueryRequest paramQueryRequest, zzal paramzzal)
    throws RemoteException;

  public abstract void zzb(zzal paramzzal)
    throws RemoteException;

  public abstract void zzc(zzal paramzzal)
    throws RemoteException;

  public abstract void zzd(zzal paramzzal)
    throws RemoteException;

  public abstract void zze(zzal paramzzal)
    throws RemoteException;

  public abstract void zzf(zzal paramzzal)
    throws RemoteException;

  public static abstract class zza extends Binder
    implements zzak
  {
    public static zzak zzct(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.drive.internal.IDriveService");
      if ((localIInterface != null) && ((localIInterface instanceof zzak)))
        return (zzak)localIInterface;
      return new zza(paramIBinder);
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
      Object localObject26 = null;
      Object localObject27 = null;
      Object localObject28 = null;
      Object localObject29 = null;
      Object localObject30 = null;
      Object localObject31 = null;
      Object localObject32 = null;
      Object localObject33 = null;
      Object localObject34 = null;
      Object localObject35 = null;
      Object localObject36 = null;
      Object localObject1 = null;
      switch (paramInt1)
      {
      default:
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902:
        paramParcel2.writeString("com.google.android.gms.drive.internal.IDriveService");
        return true;
      case 1:
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        if (paramParcel1.readInt() != 0)
          localObject1 = (GetMetadataRequest)GetMetadataRequest.CREATOR.createFromParcel(paramParcel1);
        zza((GetMetadataRequest)localObject1, zzal.zza.zzcu(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 2:
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        localObject1 = localObject2;
        if (paramParcel1.readInt() != 0)
          localObject1 = (QueryRequest)QueryRequest.CREATOR.createFromParcel(paramParcel1);
        zza((QueryRequest)localObject1, zzal.zza.zzcu(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 3:
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        localObject1 = localObject3;
        if (paramParcel1.readInt() != 0)
          localObject1 = (UpdateMetadataRequest)UpdateMetadataRequest.CREATOR.createFromParcel(paramParcel1);
        zza((UpdateMetadataRequest)localObject1, zzal.zza.zzcu(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 4:
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        localObject1 = localObject4;
        if (paramParcel1.readInt() != 0)
          localObject1 = (CreateContentsRequest)CreateContentsRequest.CREATOR.createFromParcel(paramParcel1);
        zza((CreateContentsRequest)localObject1, zzal.zza.zzcu(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 5:
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        localObject1 = localObject5;
        if (paramParcel1.readInt() != 0)
          localObject1 = (CreateFileRequest)CreateFileRequest.CREATOR.createFromParcel(paramParcel1);
        zza((CreateFileRequest)localObject1, zzal.zza.zzcu(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 6:
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        localObject1 = localObject6;
        if (paramParcel1.readInt() != 0)
          localObject1 = (CreateFolderRequest)CreateFolderRequest.CREATOR.createFromParcel(paramParcel1);
        zza((CreateFolderRequest)localObject1, zzal.zza.zzcu(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 7:
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        localObject1 = localObject7;
        if (paramParcel1.readInt() != 0)
          localObject1 = (OpenContentsRequest)OpenContentsRequest.CREATOR.createFromParcel(paramParcel1);
        paramParcel1 = zza((OpenContentsRequest)localObject1, zzal.zza.zzcu(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        if (paramParcel1 != null)
        {
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
        }
        while (true)
        {
          return true;
          paramParcel2.writeInt(0);
        }
      case 8:
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        localObject1 = localObject8;
        if (paramParcel1.readInt() != 0)
          localObject1 = (CloseContentsRequest)CloseContentsRequest.CREATOR.createFromParcel(paramParcel1);
        zza((CloseContentsRequest)localObject1, zzal.zza.zzcu(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 9:
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        zza(zzal.zza.zzcu(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 10:
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        localObject1 = localObject9;
        if (paramParcel1.readInt() != 0)
          localObject1 = (OpenFileIntentSenderRequest)OpenFileIntentSenderRequest.CREATOR.createFromParcel(paramParcel1);
        paramParcel1 = zza((OpenFileIntentSenderRequest)localObject1);
        paramParcel2.writeNoException();
        if (paramParcel1 != null)
        {
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
        }
        while (true)
        {
          return true;
          paramParcel2.writeInt(0);
        }
      case 11:
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        localObject1 = localObject10;
        if (paramParcel1.readInt() != 0)
          localObject1 = (CreateFileIntentSenderRequest)CreateFileIntentSenderRequest.CREATOR.createFromParcel(paramParcel1);
        paramParcel1 = zza((CreateFileIntentSenderRequest)localObject1);
        paramParcel2.writeNoException();
        if (paramParcel1 != null)
        {
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
        }
        while (true)
        {
          return true;
          paramParcel2.writeInt(0);
        }
      case 12:
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        localObject1 = localObject11;
        if (paramParcel1.readInt() != 0)
          localObject1 = (AuthorizeAccessRequest)AuthorizeAccessRequest.CREATOR.createFromParcel(paramParcel1);
        zza((AuthorizeAccessRequest)localObject1, zzal.zza.zzcu(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 13:
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        localObject1 = localObject12;
        if (paramParcel1.readInt() != 0)
          localObject1 = (ListParentsRequest)ListParentsRequest.CREATOR.createFromParcel(paramParcel1);
        zza((ListParentsRequest)localObject1, zzal.zza.zzcu(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 14:
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        localObject1 = localObject13;
        if (paramParcel1.readInt() != 0)
          localObject1 = (AddEventListenerRequest)AddEventListenerRequest.CREATOR.createFromParcel(paramParcel1);
        zza((AddEventListenerRequest)localObject1, zzam.zza.zzcv(paramParcel1.readStrongBinder()), paramParcel1.readString(), zzal.zza.zzcu(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 15:
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        localObject1 = localObject14;
        if (paramParcel1.readInt() != 0)
          localObject1 = (RemoveEventListenerRequest)RemoveEventListenerRequest.CREATOR.createFromParcel(paramParcel1);
        zza((RemoveEventListenerRequest)localObject1, zzam.zza.zzcv(paramParcel1.readStrongBinder()), paramParcel1.readString(), zzal.zza.zzcu(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 16:
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        localObject1 = localObject15;
        if (paramParcel1.readInt() != 0)
          localObject1 = (DisconnectRequest)DisconnectRequest.CREATOR.createFromParcel(paramParcel1);
        zza((DisconnectRequest)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 17:
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        localObject1 = localObject16;
        if (paramParcel1.readInt() != 0)
          localObject1 = (TrashResourceRequest)TrashResourceRequest.CREATOR.createFromParcel(paramParcel1);
        zza((TrashResourceRequest)localObject1, zzal.zza.zzcu(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 18:
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        localObject1 = localObject17;
        if (paramParcel1.readInt() != 0)
          localObject1 = (CloseContentsAndUpdateMetadataRequest)CloseContentsAndUpdateMetadataRequest.CREATOR.createFromParcel(paramParcel1);
        zza((CloseContentsAndUpdateMetadataRequest)localObject1, zzal.zza.zzcu(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 19:
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        localObject1 = localObject18;
        if (paramParcel1.readInt() != 0)
          localObject1 = (QueryRequest)QueryRequest.CREATOR.createFromParcel(paramParcel1);
        zzb((QueryRequest)localObject1, zzal.zza.zzcu(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 24:
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        localObject1 = localObject19;
        if (paramParcel1.readInt() != 0)
          localObject1 = (DeleteResourceRequest)DeleteResourceRequest.CREATOR.createFromParcel(paramParcel1);
        zza((DeleteResourceRequest)localObject1, zzal.zza.zzcu(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 27:
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        localObject1 = localObject20;
        if (paramParcel1.readInt() != 0)
          localObject1 = (LoadRealtimeRequest)LoadRealtimeRequest.CREATOR.createFromParcel(paramParcel1);
        zza((LoadRealtimeRequest)localObject1, zzal.zza.zzcu(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 28:
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        localObject1 = localObject21;
        if (paramParcel1.readInt() != 0)
          localObject1 = (SetResourceParentsRequest)SetResourceParentsRequest.CREATOR.createFromParcel(paramParcel1);
        zza((SetResourceParentsRequest)localObject1, zzal.zza.zzcu(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 29:
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        localObject1 = localObject22;
        if (paramParcel1.readInt() != 0)
          localObject1 = (GetDriveIdFromUniqueIdentifierRequest)GetDriveIdFromUniqueIdentifierRequest.CREATOR.createFromParcel(paramParcel1);
        zza((GetDriveIdFromUniqueIdentifierRequest)localObject1, zzal.zza.zzcu(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 30:
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        localObject1 = localObject23;
        if (paramParcel1.readInt() != 0)
          localObject1 = (CheckResourceIdsExistRequest)CheckResourceIdsExistRequest.CREATOR.createFromParcel(paramParcel1);
        zza((CheckResourceIdsExistRequest)localObject1, zzal.zza.zzcu(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 31:
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        zzb(zzal.zza.zzcu(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 32:
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        zzc(zzal.zza.zzcu(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 33:
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        localObject1 = localObject24;
        if (paramParcel1.readInt() != 0)
          localObject1 = (SetDrivePreferencesRequest)SetDrivePreferencesRequest.CREATOR.createFromParcel(paramParcel1);
        zza((SetDrivePreferencesRequest)localObject1, zzal.zza.zzcu(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 34:
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        localObject1 = localObject25;
        if (paramParcel1.readInt() != 0)
          localObject1 = (RealtimeDocumentSyncRequest)RealtimeDocumentSyncRequest.CREATOR.createFromParcel(paramParcel1);
        zza((RealtimeDocumentSyncRequest)localObject1, zzal.zza.zzcu(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 35:
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        zzd(zzal.zza.zzcu(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 36:
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        localObject1 = localObject26;
        if (paramParcel1.readInt() != 0)
          localObject1 = (SetFileUploadPreferencesRequest)SetFileUploadPreferencesRequest.CREATOR.createFromParcel(paramParcel1);
        zza((SetFileUploadPreferencesRequest)localObject1, zzal.zza.zzcu(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 37:
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        localObject1 = localObject27;
        if (paramParcel1.readInt() != 0)
          localObject1 = (CancelPendingActionsRequest)CancelPendingActionsRequest.CREATOR.createFromParcel(paramParcel1);
        zza((CancelPendingActionsRequest)localObject1, zzal.zza.zzcu(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 38:
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        localObject1 = localObject28;
        if (paramParcel1.readInt() != 0)
          localObject1 = (UntrashResourceRequest)UntrashResourceRequest.CREATOR.createFromParcel(paramParcel1);
        zza((UntrashResourceRequest)localObject1, zzal.zza.zzcu(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 41:
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        zze(zzal.zza.zzcu(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 42:
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        localObject1 = localObject29;
        if (paramParcel1.readInt() != 0)
          localObject1 = (FetchThumbnailRequest)FetchThumbnailRequest.CREATOR.createFromParcel(paramParcel1);
        zza((FetchThumbnailRequest)localObject1, zzal.zza.zzcu(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 43:
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        zzf(zzal.zza.zzcu(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 44:
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        localObject1 = localObject30;
        if (paramParcel1.readInt() != 0)
          localObject1 = (GetChangesRequest)GetChangesRequest.CREATOR.createFromParcel(paramParcel1);
        zza((GetChangesRequest)localObject1, zzal.zza.zzcu(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 46:
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        localObject1 = localObject31;
        if (paramParcel1.readInt() != 0)
          localObject1 = (UnsubscribeResourceRequest)UnsubscribeResourceRequest.CREATOR.createFromParcel(paramParcel1);
        zza((UnsubscribeResourceRequest)localObject1, zzal.zza.zzcu(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 47:
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        localObject1 = localObject32;
        if (paramParcel1.readInt() != 0)
          localObject1 = (GetPermissionsRequest)GetPermissionsRequest.CREATOR.createFromParcel(paramParcel1);
        zza((GetPermissionsRequest)localObject1, zzal.zza.zzcu(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 48:
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        localObject1 = localObject33;
        if (paramParcel1.readInt() != 0)
          localObject1 = (AddPermissionRequest)AddPermissionRequest.CREATOR.createFromParcel(paramParcel1);
        zza((AddPermissionRequest)localObject1, zzal.zza.zzcu(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 49:
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        localObject1 = localObject34;
        if (paramParcel1.readInt() != 0)
          localObject1 = (UpdatePermissionRequest)UpdatePermissionRequest.CREATOR.createFromParcel(paramParcel1);
        zza((UpdatePermissionRequest)localObject1, zzal.zza.zzcu(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 50:
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        localObject1 = localObject35;
        if (paramParcel1.readInt() != 0)
          localObject1 = (RemovePermissionRequest)RemovePermissionRequest.CREATOR.createFromParcel(paramParcel1);
        zza((RemovePermissionRequest)localObject1, zzal.zza.zzcu(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 51:
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        localObject1 = localObject36;
        if (paramParcel1.readInt() != 0)
          localObject1 = (QueryRequest)QueryRequest.CREATOR.createFromParcel(paramParcel1);
        zza((QueryRequest)localObject1, zzam.zza.zzcv(paramParcel1.readStrongBinder()), zzal.zza.zzcu(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 52:
      }
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      zza(zzam.zza.zzcv(paramParcel1.readStrongBinder()), zzal.zza.zzcu(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    }

    private static class zza
      implements zzak
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

      public IntentSender zza(CreateFileIntentSenderRequest paramCreateFileIntentSenderRequest)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramCreateFileIntentSenderRequest != null)
            {
              localParcel1.writeInt(1);
              paramCreateFileIntentSenderRequest.writeToParcel(localParcel1, 0);
              zznF.transact(11, localParcel1, localParcel2, 0);
              localParcel2.readException();
              if (localParcel2.readInt() != 0)
              {
                paramCreateFileIntentSenderRequest = (IntentSender)IntentSender.CREATOR.createFromParcel(localParcel2);
                return paramCreateFileIntentSenderRequest;
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
          paramCreateFileIntentSenderRequest = null;
        }
      }

      public IntentSender zza(OpenFileIntentSenderRequest paramOpenFileIntentSenderRequest)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramOpenFileIntentSenderRequest != null)
            {
              localParcel1.writeInt(1);
              paramOpenFileIntentSenderRequest.writeToParcel(localParcel1, 0);
              zznF.transact(10, localParcel1, localParcel2, 0);
              localParcel2.readException();
              if (localParcel2.readInt() != 0)
              {
                paramOpenFileIntentSenderRequest = (IntentSender)IntentSender.CREATOR.createFromParcel(localParcel2);
                return paramOpenFileIntentSenderRequest;
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
          paramOpenFileIntentSenderRequest = null;
        }
      }

      public DriveServiceResponse zza(OpenContentsRequest paramOpenContentsRequest, zzal paramzzal)
        throws RemoteException
      {
        Object localObject = null;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramOpenContentsRequest != null)
            {
              localParcel1.writeInt(1);
              paramOpenContentsRequest.writeToParcel(localParcel1, 0);
              if (paramzzal != null)
              {
                paramOpenContentsRequest = paramzzal.asBinder();
                localParcel1.writeStrongBinder(paramOpenContentsRequest);
                zznF.transact(7, localParcel1, localParcel2, 0);
                localParcel2.readException();
                paramOpenContentsRequest = localObject;
                if (localParcel2.readInt() != 0)
                  paramOpenContentsRequest = (DriveServiceResponse)DriveServiceResponse.CREATOR.createFromParcel(localParcel2);
                return paramOpenContentsRequest;
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
          paramOpenContentsRequest = null;
        }
      }

      public void zza(RealtimeDocumentSyncRequest paramRealtimeDocumentSyncRequest, zzal paramzzal)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramRealtimeDocumentSyncRequest != null)
            {
              localParcel1.writeInt(1);
              paramRealtimeDocumentSyncRequest.writeToParcel(localParcel1, 0);
              if (paramzzal != null)
              {
                paramRealtimeDocumentSyncRequest = paramzzal.asBinder();
                localParcel1.writeStrongBinder(paramRealtimeDocumentSyncRequest);
                zznF.transact(34, localParcel1, localParcel2, 0);
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
          paramRealtimeDocumentSyncRequest = null;
        }
      }

      public void zza(AddEventListenerRequest paramAddEventListenerRequest, zzam paramzzam, String paramString, zzal paramzzal)
        throws RemoteException
      {
        Object localObject = null;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramAddEventListenerRequest != null)
            {
              localParcel1.writeInt(1);
              paramAddEventListenerRequest.writeToParcel(localParcel1, 0);
              if (paramzzam != null)
              {
                paramAddEventListenerRequest = paramzzam.asBinder();
                localParcel1.writeStrongBinder(paramAddEventListenerRequest);
                localParcel1.writeString(paramString);
                paramAddEventListenerRequest = localObject;
                if (paramzzal != null)
                  paramAddEventListenerRequest = paramzzal.asBinder();
                localParcel1.writeStrongBinder(paramAddEventListenerRequest);
                zznF.transact(14, localParcel1, localParcel2, 0);
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
          paramAddEventListenerRequest = null;
        }
      }

      public void zza(AddPermissionRequest paramAddPermissionRequest, zzal paramzzal)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramAddPermissionRequest != null)
            {
              localParcel1.writeInt(1);
              paramAddPermissionRequest.writeToParcel(localParcel1, 0);
              if (paramzzal != null)
              {
                paramAddPermissionRequest = paramzzal.asBinder();
                localParcel1.writeStrongBinder(paramAddPermissionRequest);
                zznF.transact(48, localParcel1, localParcel2, 0);
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
          paramAddPermissionRequest = null;
        }
      }

      public void zza(AuthorizeAccessRequest paramAuthorizeAccessRequest, zzal paramzzal)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramAuthorizeAccessRequest != null)
            {
              localParcel1.writeInt(1);
              paramAuthorizeAccessRequest.writeToParcel(localParcel1, 0);
              if (paramzzal != null)
              {
                paramAuthorizeAccessRequest = paramzzal.asBinder();
                localParcel1.writeStrongBinder(paramAuthorizeAccessRequest);
                zznF.transact(12, localParcel1, localParcel2, 0);
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
          paramAuthorizeAccessRequest = null;
        }
      }

      public void zza(CancelPendingActionsRequest paramCancelPendingActionsRequest, zzal paramzzal)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramCancelPendingActionsRequest != null)
            {
              localParcel1.writeInt(1);
              paramCancelPendingActionsRequest.writeToParcel(localParcel1, 0);
              if (paramzzal != null)
              {
                paramCancelPendingActionsRequest = paramzzal.asBinder();
                localParcel1.writeStrongBinder(paramCancelPendingActionsRequest);
                zznF.transact(37, localParcel1, localParcel2, 0);
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
          paramCancelPendingActionsRequest = null;
        }
      }

      public void zza(CheckResourceIdsExistRequest paramCheckResourceIdsExistRequest, zzal paramzzal)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramCheckResourceIdsExistRequest != null)
            {
              localParcel1.writeInt(1);
              paramCheckResourceIdsExistRequest.writeToParcel(localParcel1, 0);
              if (paramzzal != null)
              {
                paramCheckResourceIdsExistRequest = paramzzal.asBinder();
                localParcel1.writeStrongBinder(paramCheckResourceIdsExistRequest);
                zznF.transact(30, localParcel1, localParcel2, 0);
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
          paramCheckResourceIdsExistRequest = null;
        }
      }

      public void zza(CloseContentsAndUpdateMetadataRequest paramCloseContentsAndUpdateMetadataRequest, zzal paramzzal)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramCloseContentsAndUpdateMetadataRequest != null)
            {
              localParcel1.writeInt(1);
              paramCloseContentsAndUpdateMetadataRequest.writeToParcel(localParcel1, 0);
              if (paramzzal != null)
              {
                paramCloseContentsAndUpdateMetadataRequest = paramzzal.asBinder();
                localParcel1.writeStrongBinder(paramCloseContentsAndUpdateMetadataRequest);
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
          paramCloseContentsAndUpdateMetadataRequest = null;
        }
      }

      public void zza(CloseContentsRequest paramCloseContentsRequest, zzal paramzzal)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramCloseContentsRequest != null)
            {
              localParcel1.writeInt(1);
              paramCloseContentsRequest.writeToParcel(localParcel1, 0);
              if (paramzzal != null)
              {
                paramCloseContentsRequest = paramzzal.asBinder();
                localParcel1.writeStrongBinder(paramCloseContentsRequest);
                zznF.transact(8, localParcel1, localParcel2, 0);
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
          paramCloseContentsRequest = null;
        }
      }

      public void zza(CreateContentsRequest paramCreateContentsRequest, zzal paramzzal)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramCreateContentsRequest != null)
            {
              localParcel1.writeInt(1);
              paramCreateContentsRequest.writeToParcel(localParcel1, 0);
              if (paramzzal != null)
              {
                paramCreateContentsRequest = paramzzal.asBinder();
                localParcel1.writeStrongBinder(paramCreateContentsRequest);
                zznF.transact(4, localParcel1, localParcel2, 0);
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
          paramCreateContentsRequest = null;
        }
      }

      public void zza(CreateFileRequest paramCreateFileRequest, zzal paramzzal)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramCreateFileRequest != null)
            {
              localParcel1.writeInt(1);
              paramCreateFileRequest.writeToParcel(localParcel1, 0);
              if (paramzzal != null)
              {
                paramCreateFileRequest = paramzzal.asBinder();
                localParcel1.writeStrongBinder(paramCreateFileRequest);
                zznF.transact(5, localParcel1, localParcel2, 0);
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
          paramCreateFileRequest = null;
        }
      }

      public void zza(CreateFolderRequest paramCreateFolderRequest, zzal paramzzal)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramCreateFolderRequest != null)
            {
              localParcel1.writeInt(1);
              paramCreateFolderRequest.writeToParcel(localParcel1, 0);
              if (paramzzal != null)
              {
                paramCreateFolderRequest = paramzzal.asBinder();
                localParcel1.writeStrongBinder(paramCreateFolderRequest);
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
          paramCreateFolderRequest = null;
        }
      }

      public void zza(DeleteResourceRequest paramDeleteResourceRequest, zzal paramzzal)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramDeleteResourceRequest != null)
            {
              localParcel1.writeInt(1);
              paramDeleteResourceRequest.writeToParcel(localParcel1, 0);
              if (paramzzal != null)
              {
                paramDeleteResourceRequest = paramzzal.asBinder();
                localParcel1.writeStrongBinder(paramDeleteResourceRequest);
                zznF.transact(24, localParcel1, localParcel2, 0);
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
          paramDeleteResourceRequest = null;
        }
      }

      public void zza(DisconnectRequest paramDisconnectRequest)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
          if (paramDisconnectRequest != null)
          {
            localParcel1.writeInt(1);
            paramDisconnectRequest.writeToParcel(localParcel1, 0);
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
        throw paramDisconnectRequest;
      }

      public void zza(FetchThumbnailRequest paramFetchThumbnailRequest, zzal paramzzal)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramFetchThumbnailRequest != null)
            {
              localParcel1.writeInt(1);
              paramFetchThumbnailRequest.writeToParcel(localParcel1, 0);
              if (paramzzal != null)
              {
                paramFetchThumbnailRequest = paramzzal.asBinder();
                localParcel1.writeStrongBinder(paramFetchThumbnailRequest);
                zznF.transact(42, localParcel1, localParcel2, 0);
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
          paramFetchThumbnailRequest = null;
        }
      }

      public void zza(GetChangesRequest paramGetChangesRequest, zzal paramzzal)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramGetChangesRequest != null)
            {
              localParcel1.writeInt(1);
              paramGetChangesRequest.writeToParcel(localParcel1, 0);
              if (paramzzal != null)
              {
                paramGetChangesRequest = paramzzal.asBinder();
                localParcel1.writeStrongBinder(paramGetChangesRequest);
                zznF.transact(44, localParcel1, localParcel2, 0);
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
          paramGetChangesRequest = null;
        }
      }

      public void zza(GetDriveIdFromUniqueIdentifierRequest paramGetDriveIdFromUniqueIdentifierRequest, zzal paramzzal)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramGetDriveIdFromUniqueIdentifierRequest != null)
            {
              localParcel1.writeInt(1);
              paramGetDriveIdFromUniqueIdentifierRequest.writeToParcel(localParcel1, 0);
              if (paramzzal != null)
              {
                paramGetDriveIdFromUniqueIdentifierRequest = paramzzal.asBinder();
                localParcel1.writeStrongBinder(paramGetDriveIdFromUniqueIdentifierRequest);
                zznF.transact(29, localParcel1, localParcel2, 0);
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
          paramGetDriveIdFromUniqueIdentifierRequest = null;
        }
      }

      public void zza(GetMetadataRequest paramGetMetadataRequest, zzal paramzzal)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramGetMetadataRequest != null)
            {
              localParcel1.writeInt(1);
              paramGetMetadataRequest.writeToParcel(localParcel1, 0);
              if (paramzzal != null)
              {
                paramGetMetadataRequest = paramzzal.asBinder();
                localParcel1.writeStrongBinder(paramGetMetadataRequest);
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
          paramGetMetadataRequest = null;
        }
      }

      public void zza(GetPermissionsRequest paramGetPermissionsRequest, zzal paramzzal)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramGetPermissionsRequest != null)
            {
              localParcel1.writeInt(1);
              paramGetPermissionsRequest.writeToParcel(localParcel1, 0);
              if (paramzzal != null)
              {
                paramGetPermissionsRequest = paramzzal.asBinder();
                localParcel1.writeStrongBinder(paramGetPermissionsRequest);
                zznF.transact(47, localParcel1, localParcel2, 0);
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
          paramGetPermissionsRequest = null;
        }
      }

      public void zza(ListParentsRequest paramListParentsRequest, zzal paramzzal)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramListParentsRequest != null)
            {
              localParcel1.writeInt(1);
              paramListParentsRequest.writeToParcel(localParcel1, 0);
              if (paramzzal != null)
              {
                paramListParentsRequest = paramzzal.asBinder();
                localParcel1.writeStrongBinder(paramListParentsRequest);
                zznF.transact(13, localParcel1, localParcel2, 0);
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
          paramListParentsRequest = null;
        }
      }

      public void zza(LoadRealtimeRequest paramLoadRealtimeRequest, zzal paramzzal)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramLoadRealtimeRequest != null)
            {
              localParcel1.writeInt(1);
              paramLoadRealtimeRequest.writeToParcel(localParcel1, 0);
              if (paramzzal != null)
              {
                paramLoadRealtimeRequest = paramzzal.asBinder();
                localParcel1.writeStrongBinder(paramLoadRealtimeRequest);
                zznF.transact(27, localParcel1, localParcel2, 0);
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
          paramLoadRealtimeRequest = null;
        }
      }

      public void zza(QueryRequest paramQueryRequest, zzal paramzzal)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramQueryRequest != null)
            {
              localParcel1.writeInt(1);
              paramQueryRequest.writeToParcel(localParcel1, 0);
              if (paramzzal != null)
              {
                paramQueryRequest = paramzzal.asBinder();
                localParcel1.writeStrongBinder(paramQueryRequest);
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
          paramQueryRequest = null;
        }
      }

      public void zza(QueryRequest paramQueryRequest, zzam paramzzam, zzal paramzzal)
        throws RemoteException
      {
        Object localObject = null;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramQueryRequest != null)
            {
              localParcel1.writeInt(1);
              paramQueryRequest.writeToParcel(localParcel1, 0);
              if (paramzzam != null)
              {
                paramQueryRequest = paramzzam.asBinder();
                localParcel1.writeStrongBinder(paramQueryRequest);
                paramQueryRequest = localObject;
                if (paramzzal != null)
                  paramQueryRequest = paramzzal.asBinder();
                localParcel1.writeStrongBinder(paramQueryRequest);
                zznF.transact(51, localParcel1, localParcel2, 0);
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
          paramQueryRequest = null;
        }
      }

      public void zza(RemoveEventListenerRequest paramRemoveEventListenerRequest, zzam paramzzam, String paramString, zzal paramzzal)
        throws RemoteException
      {
        Object localObject = null;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramRemoveEventListenerRequest != null)
            {
              localParcel1.writeInt(1);
              paramRemoveEventListenerRequest.writeToParcel(localParcel1, 0);
              if (paramzzam != null)
              {
                paramRemoveEventListenerRequest = paramzzam.asBinder();
                localParcel1.writeStrongBinder(paramRemoveEventListenerRequest);
                localParcel1.writeString(paramString);
                paramRemoveEventListenerRequest = localObject;
                if (paramzzal != null)
                  paramRemoveEventListenerRequest = paramzzal.asBinder();
                localParcel1.writeStrongBinder(paramRemoveEventListenerRequest);
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
          paramRemoveEventListenerRequest = null;
        }
      }

      public void zza(RemovePermissionRequest paramRemovePermissionRequest, zzal paramzzal)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramRemovePermissionRequest != null)
            {
              localParcel1.writeInt(1);
              paramRemovePermissionRequest.writeToParcel(localParcel1, 0);
              if (paramzzal != null)
              {
                paramRemovePermissionRequest = paramzzal.asBinder();
                localParcel1.writeStrongBinder(paramRemovePermissionRequest);
                zznF.transact(50, localParcel1, localParcel2, 0);
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
          paramRemovePermissionRequest = null;
        }
      }

      public void zza(SetDrivePreferencesRequest paramSetDrivePreferencesRequest, zzal paramzzal)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramSetDrivePreferencesRequest != null)
            {
              localParcel1.writeInt(1);
              paramSetDrivePreferencesRequest.writeToParcel(localParcel1, 0);
              if (paramzzal != null)
              {
                paramSetDrivePreferencesRequest = paramzzal.asBinder();
                localParcel1.writeStrongBinder(paramSetDrivePreferencesRequest);
                zznF.transact(33, localParcel1, localParcel2, 0);
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
          paramSetDrivePreferencesRequest = null;
        }
      }

      public void zza(SetFileUploadPreferencesRequest paramSetFileUploadPreferencesRequest, zzal paramzzal)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramSetFileUploadPreferencesRequest != null)
            {
              localParcel1.writeInt(1);
              paramSetFileUploadPreferencesRequest.writeToParcel(localParcel1, 0);
              if (paramzzal != null)
              {
                paramSetFileUploadPreferencesRequest = paramzzal.asBinder();
                localParcel1.writeStrongBinder(paramSetFileUploadPreferencesRequest);
                zznF.transact(36, localParcel1, localParcel2, 0);
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
          paramSetFileUploadPreferencesRequest = null;
        }
      }

      public void zza(SetResourceParentsRequest paramSetResourceParentsRequest, zzal paramzzal)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramSetResourceParentsRequest != null)
            {
              localParcel1.writeInt(1);
              paramSetResourceParentsRequest.writeToParcel(localParcel1, 0);
              if (paramzzal != null)
              {
                paramSetResourceParentsRequest = paramzzal.asBinder();
                localParcel1.writeStrongBinder(paramSetResourceParentsRequest);
                zznF.transact(28, localParcel1, localParcel2, 0);
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
          paramSetResourceParentsRequest = null;
        }
      }

      public void zza(TrashResourceRequest paramTrashResourceRequest, zzal paramzzal)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramTrashResourceRequest != null)
            {
              localParcel1.writeInt(1);
              paramTrashResourceRequest.writeToParcel(localParcel1, 0);
              if (paramzzal != null)
              {
                paramTrashResourceRequest = paramzzal.asBinder();
                localParcel1.writeStrongBinder(paramTrashResourceRequest);
                zznF.transact(17, localParcel1, localParcel2, 0);
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
          paramTrashResourceRequest = null;
        }
      }

      public void zza(UnsubscribeResourceRequest paramUnsubscribeResourceRequest, zzal paramzzal)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramUnsubscribeResourceRequest != null)
            {
              localParcel1.writeInt(1);
              paramUnsubscribeResourceRequest.writeToParcel(localParcel1, 0);
              if (paramzzal != null)
              {
                paramUnsubscribeResourceRequest = paramzzal.asBinder();
                localParcel1.writeStrongBinder(paramUnsubscribeResourceRequest);
                zznF.transact(46, localParcel1, localParcel2, 0);
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
          paramUnsubscribeResourceRequest = null;
        }
      }

      public void zza(UntrashResourceRequest paramUntrashResourceRequest, zzal paramzzal)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramUntrashResourceRequest != null)
            {
              localParcel1.writeInt(1);
              paramUntrashResourceRequest.writeToParcel(localParcel1, 0);
              if (paramzzal != null)
              {
                paramUntrashResourceRequest = paramzzal.asBinder();
                localParcel1.writeStrongBinder(paramUntrashResourceRequest);
                zznF.transact(38, localParcel1, localParcel2, 0);
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
          paramUntrashResourceRequest = null;
        }
      }

      public void zza(UpdateMetadataRequest paramUpdateMetadataRequest, zzal paramzzal)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramUpdateMetadataRequest != null)
            {
              localParcel1.writeInt(1);
              paramUpdateMetadataRequest.writeToParcel(localParcel1, 0);
              if (paramzzal != null)
              {
                paramUpdateMetadataRequest = paramzzal.asBinder();
                localParcel1.writeStrongBinder(paramUpdateMetadataRequest);
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
          paramUpdateMetadataRequest = null;
        }
      }

      public void zza(UpdatePermissionRequest paramUpdatePermissionRequest, zzal paramzzal)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramUpdatePermissionRequest != null)
            {
              localParcel1.writeInt(1);
              paramUpdatePermissionRequest.writeToParcel(localParcel1, 0);
              if (paramzzal != null)
              {
                paramUpdatePermissionRequest = paramzzal.asBinder();
                localParcel1.writeStrongBinder(paramUpdatePermissionRequest);
                zznF.transact(49, localParcel1, localParcel2, 0);
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
          paramUpdatePermissionRequest = null;
        }
      }

      public void zza(zzal paramzzal)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
          if (paramzzal != null);
          for (paramzzal = paramzzal.asBinder(); ; paramzzal = null)
          {
            localParcel1.writeStrongBinder(paramzzal);
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
        throw paramzzal;
      }

      public void zza(zzam paramzzam, zzal paramzzal)
        throws RemoteException
      {
        Object localObject = null;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
          if (paramzzam != null);
          for (paramzzam = paramzzam.asBinder(); ; paramzzam = null)
          {
            localParcel1.writeStrongBinder(paramzzam);
            paramzzam = localObject;
            if (paramzzal != null)
              paramzzam = paramzzal.asBinder();
            localParcel1.writeStrongBinder(paramzzam);
            zznF.transact(52, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzam;
      }

      public void zzb(QueryRequest paramQueryRequest, zzal paramzzal)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramQueryRequest != null)
            {
              localParcel1.writeInt(1);
              paramQueryRequest.writeToParcel(localParcel1, 0);
              if (paramzzal != null)
              {
                paramQueryRequest = paramzzal.asBinder();
                localParcel1.writeStrongBinder(paramQueryRequest);
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
          paramQueryRequest = null;
        }
      }

      public void zzb(zzal paramzzal)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
          if (paramzzal != null);
          for (paramzzal = paramzzal.asBinder(); ; paramzzal = null)
          {
            localParcel1.writeStrongBinder(paramzzal);
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
        throw paramzzal;
      }

      public void zzc(zzal paramzzal)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
          if (paramzzal != null);
          for (paramzzal = paramzzal.asBinder(); ; paramzzal = null)
          {
            localParcel1.writeStrongBinder(paramzzal);
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
        throw paramzzal;
      }

      public void zzd(zzal paramzzal)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
          if (paramzzal != null);
          for (paramzzal = paramzzal.asBinder(); ; paramzzal = null)
          {
            localParcel1.writeStrongBinder(paramzzal);
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
        throw paramzzal;
      }

      public void zze(zzal paramzzal)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
          if (paramzzal != null);
          for (paramzzal = paramzzal.asBinder(); ; paramzzal = null)
          {
            localParcel1.writeStrongBinder(paramzzal);
            zznF.transact(41, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzal;
      }

      public void zzf(zzal paramzzal)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
          if (paramzzal != null);
          for (paramzzal = paramzzal.asBinder(); ; paramzzal = null)
          {
            localParcel1.writeStrongBinder(paramzzal);
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
        throw paramzzal;
      }
    }
  }
}