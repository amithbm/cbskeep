package com.google.android.gms.drive.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza.zzb;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFile.InitializeRealtimeDocumentListener;
import com.google.android.gms.drive.DriveFile.RealtimeLoadResult;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.realtime.RealtimeConfiguration;
import com.google.android.gms.drive.realtime.RealtimeDocument;
import com.google.android.gms.drive.realtime.internal.zzag;
import com.google.android.gms.drive.realtime.internal.zzaj;
import com.google.android.gms.drive.realtime.internal.zzt;
import com.google.android.gms.drive.realtime.internal.zzv.zza;
import java.util.ArrayList;
import java.util.List;

public class zzu extends zzz
  implements DriveFile
{
  public zzu(DriveId paramDriveId)
  {
    super(paramDriveId);
  }

  public PendingResult<DriveFile.RealtimeLoadResult> loadRealtimeDocument(GoogleApiClient paramGoogleApiClient, final DriveFile.InitializeRealtimeDocumentListener paramInitializeRealtimeDocumentListener, RealtimeConfiguration paramRealtimeConfiguration)
  {
    if ((paramRealtimeConfiguration != null) && (paramRealtimeConfiguration.isUseTestMode()));
    for (final boolean bool = true; ; bool = false)
    {
      final ArrayList localArrayList = new ArrayList();
      if (paramRealtimeConfiguration != null)
        localArrayList.addAll(paramRealtimeConfiguration.getCustomTypes());
      return paramGoogleApiClient.zzb(new zzd(paramGoogleApiClient)
      {
        protected void zza(zzs paramAnonymouszzs)
          throws RemoteException
        {
          LoadRealtimeRequest localLoadRealtimeRequest = new LoadRealtimeRequest(zzasr, bool, localArrayList, false, null);
          paramAnonymouszzs.zzsS().zza(localLoadRealtimeRequest, new zzu.zzb(this, paramInitializeRealtimeDocumentListener, localArrayList, paramAnonymouszzs.getLooper()));
        }
      });
    }
  }

  static class zzb extends zzd
  {
    private final Handler mHandler;
    private final zza.zzb<DriveFile.RealtimeLoadResult> zzPu;
    private final DriveFile.InitializeRealtimeDocumentListener zzauN;
    private final List<String> zzauO;

    public zzb(zza.zzb<DriveFile.RealtimeLoadResult> paramzzb, DriveFile.InitializeRealtimeDocumentListener paramInitializeRealtimeDocumentListener, List<String> paramList, Looper paramLooper)
    {
      zzPu = paramzzb;
      zzauN = paramInitializeRealtimeDocumentListener;
      zzauO = paramList;
      mHandler = new Handler(paramLooper);
    }

    public void zzQ(Status paramStatus)
      throws RemoteException
    {
      zzPu.zzq(new zzu.zzc(paramStatus, null));
    }

    public void zza(final OnLoadRealtimeResponse paramOnLoadRealtimeResponse, final zzt paramzzt)
      throws RemoteException
    {
      mHandler.post(new Runnable()
      {
        public void run()
        {
          try
          {
            final com.google.android.gms.drive.realtime.internal.zzak localzzak = new com.google.android.gms.drive.realtime.internal.zzak(paramzzt, zzu.zzb.zza(zzu.zzb.this));
            final zzag localzzag = (zzag)localzzak.getModel();
            localzzag.zzo(zzu.zzb.zzb(zzu.zzb.this));
            paramzzt.zzb(new zzaj(paramzzt, localzzag, zzu.zzb.zza(zzu.zzb.this)));
            if (!paramOnLoadRealtimeResponse.isInitialized())
            {
              localzzag.zzb(true, null);
              paramzzt.zza(new zzv.zza()
              {
                public void onSuccess()
                {
                  zzu.zzb.zzc(zzu.zzb.this).onInitialize(localzzak.getModel());
                  localzzag.zztL();
                  zzu.zzb.zzd(zzu.zzb.this).zzq(new zzu.zzc(Status.zzaii, localzzak));
                }

                public void zzQ(Status paramAnonymous2Status)
                {
                }
              });
              return;
            }
            zzu.zzb.zzd(zzu.zzb.this).zzq(new zzu.zzc(Status.zzaii, localzzak));
            return;
          }
          catch (RemoteException localRemoteException)
          {
            zzu.zzb.zzd(zzu.zzb.this).zzq(new zzu.zzc(Status.zzaik, null));
          }
        }
      });
    }
  }

  static class zzc
    implements DriveFile.RealtimeLoadResult
  {
    private final Status zzOQ;
    private final RealtimeDocument zzauV;

    public zzc(Status paramStatus, RealtimeDocument paramRealtimeDocument)
    {
      zzOQ = paramStatus;
      zzauV = paramRealtimeDocument;
    }

    public RealtimeDocument getRealtimeDocument()
    {
      return zzauV;
    }

    public Status getStatus()
    {
      return zzOQ;
    }
  }

  static abstract class zzd extends zzr<DriveFile.RealtimeLoadResult>
  {
    zzd(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }

    public DriveFile.RealtimeLoadResult zzY(Status paramStatus)
    {
      return new zzu.zzc(paramStatus, null);
    }
  }
}