package com.google.android.gms.people.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza.zzb;
import com.google.android.gms.common.api.zzi;
import com.google.android.gms.common.api.zzi.zzb;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.util.IOUtils;
import com.google.android.gms.internal.zzrn;
import com.google.android.gms.people.Autocomplete.AutocompleteOptions;
import com.google.android.gms.people.Autocomplete.AutocompleteResult;
import com.google.android.gms.people.Graph.LoadContactsGaiaIdsResult;
import com.google.android.gms.people.Graph.LoadOwnersResult;
import com.google.android.gms.people.Images.LoadImageOptions;
import com.google.android.gms.people.Images.LoadImageResult;
import com.google.android.gms.people.Images.SetAvatarResult;
import com.google.android.gms.people.Notifications.OnDataChanged;
import com.google.android.gms.people.model.AutocompleteBuffer;
import com.google.android.gms.people.model.AvatarReference;
import com.google.android.gms.people.model.ContactGaiaIdBuffer;
import com.google.android.gms.people.model.OwnerBuffer;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class zzn extends zzj<zzg>
{
  private static volatile Bundle zzbda;
  private static volatile Bundle zzbdb;
  public final Context mContext;
  public final String zzOZ;
  public final String zzbcY;
  private final HashMap<Notifications.OnDataChanged, zzr> zzbcZ = new HashMap();
  private Long zzbdc = null;

  public zzn(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString, zzf paramzzf)
  {
    super(paramContext.getApplicationContext(), paramLooper, 5, paramConnectionCallbacks, paramOnConnectionFailedListener, paramzzf);
    mContext = paramContext;
    zzbcY = paramString;
    zzOZ = paramzzf.zzpA();
  }

  private static PendingIntent zzH(Bundle paramBundle)
  {
    if (paramBundle == null)
      return null;
    return (PendingIntent)paramBundle.getParcelable("pendingIntent");
  }

  private static Status zza(int paramInt, String paramString, Bundle paramBundle)
  {
    return new Status(paramInt, paramString, zzH(paramBundle));
  }

  private zzr zza(GoogleApiClient paramGoogleApiClient, Notifications.OnDataChanged paramOnDataChanged)
  {
    synchronized (zzbcZ)
    {
      if (zzbcZ.containsKey(paramOnDataChanged))
      {
        paramGoogleApiClient = (zzr)zzbcZ.get(paramOnDataChanged);
        return paramGoogleApiClient;
      }
      paramGoogleApiClient = new zzr(paramGoogleApiClient.zzs(paramOnDataChanged));
      zzbcZ.put(paramOnDataChanged, paramGoogleApiClient);
      return paramGoogleApiClient;
    }
  }

  public void disconnect()
  {
    while (true)
    {
      zzr localzzr;
      synchronized (zzbcZ)
      {
        if (!isConnected())
          break;
        Iterator localIterator = zzbcZ.values().iterator();
        if (!localIterator.hasNext())
          break;
        localzzr = (zzr)localIterator.next();
        localzzr.release();
      }
      try
      {
        zzAH().zza(localzzr, false, null, null, 0);
      }
      catch (RemoteException localRemoteException)
      {
        zzo.zzb("PeopleClient", "Failed to unregister listener", localRemoteException);
        continue;
        localObject = finally;
        throw localObject;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        zzo.zzb("PeopleClient", "PeopleService is in unexpected state", localIllegalStateException);
      }
    }
    zzbcZ.clear();
    super.disconnect();
  }

  protected String getServiceDescriptor()
  {
    return "com.google.android.gms.people.internal.IPeopleService";
  }

  protected String getStartServiceAction()
  {
    return "com.google.android.gms.people.service.START";
  }

  protected zzg zzAH()
    throws DeadObjectException
  {
    return (zzg)super.zzpN();
  }

  public void zzG(Bundle paramBundle)
  {
    if (paramBundle == null);
    while (true)
    {
      return;
      try
      {
        zzrn.zzah(paramBundle.getBoolean("use_contactables_api", true));
        zzm.zzbcV.zzF(paramBundle);
        zzbda = paramBundle.getBundle("config.email_type_map");
        zzbdb = paramBundle.getBundle("config.phone_type_map");
      }
      finally
      {
      }
    }
  }

  public ICancelToken zza(zza.zzb<Images.LoadImageResult> paramzzb, AvatarReference paramAvatarReference, Images.LoadImageOptions paramLoadImageOptions)
  {
    zzyb();
    paramzzb = new zzv(paramzzb);
    try
    {
      paramAvatarReference = zzAH().zza(paramzzb, paramAvatarReference, ParcelableLoadImageOptions.zza(paramLoadImageOptions));
      return paramAvatarReference;
    }
    catch (RemoteException paramAvatarReference)
    {
      paramzzb.zza(8, null, null, null);
    }
    return null;
  }

  public ICancelToken zza(zza.zzb<Images.LoadImageResult> paramzzb, String paramString1, String paramString2, int paramInt)
  {
    paramzzb = new zzv(paramzzb);
    try
    {
      paramString1 = zzAH().zzc(paramzzb, paramString1, paramString2, paramInt);
      return paramString1;
    }
    catch (RemoteException paramString1)
    {
      paramzzb.zza(8, null, null, null);
    }
    return null;
  }

  protected void zza(int paramInt1, IBinder paramIBinder, Bundle paramBundle, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramBundle != null))
      zzG(paramBundle.getBundle("post_init_configuration"));
    if (paramBundle == null);
    for (paramBundle = null; ; paramBundle = paramBundle.getBundle("post_init_resolution"))
    {
      super.zza(paramInt1, paramIBinder, paramBundle, paramInt2);
      return;
    }
  }

  public void zza(GoogleApiClient paramGoogleApiClient, Notifications.OnDataChanged paramOnDataChanged, String paramString1, String paramString2, int paramInt)
    throws RemoteException
  {
    zzyb();
    synchronized (zzbcZ)
    {
      paramGoogleApiClient = zza(paramGoogleApiClient, paramOnDataChanged);
      zzAH().zza(paramGoogleApiClient, true, paramString1, paramString2, paramInt);
      return;
    }
  }

  public void zza(zza.zzb<Autocomplete.AutocompleteResult> paramzzb, String paramString, Autocomplete.AutocompleteOptions paramAutocompleteOptions)
  {
    zzyb();
    paramzzb = new zzm(paramzzb);
    try
    {
      zzAH().zza(paramzzb, paramAutocompleteOptions.account, paramAutocompleteOptions.pageId, paramAutocompleteOptions.isDirectorySearch, paramAutocompleteOptions.directoryAccountType, paramString, paramAutocompleteOptions.autocompleteType, paramAutocompleteOptions.searchOptions, paramAutocompleteOptions.numberOfResults, paramAutocompleteOptions.useAndroidContactFallback);
      return;
    }
    catch (RemoteException paramString)
    {
      paramzzb.zza(8, null, null);
    }
  }

  public void zza(zza.zzb<Images.SetAvatarResult> paramzzb, String paramString1, String paramString2, Uri paramUri, boolean paramBoolean)
  {
    zzyb();
    paramzzb = new zzn(paramzzb);
    try
    {
      zzAH().zza(paramzzb, paramString1, paramString2, paramUri, paramBoolean);
      return;
    }
    catch (RemoteException paramString1)
    {
      paramzzb.zza(8, null, null);
    }
  }

  public void zza(zza.zzb<Graph.LoadOwnersResult> paramzzb, boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, int paramInt)
  {
    zzyb();
    paramzzb = new zzu(paramzzb);
    try
    {
      zzAH().zza(paramzzb, paramBoolean1, paramBoolean2, paramString1, paramString2, paramInt);
      return;
    }
    catch (RemoteException paramString1)
    {
      paramzzb.zza(8, null, null);
    }
  }

  public ICancelToken zzb(zza.zzb<Images.LoadImageResult> paramzzb, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    paramzzb = new zzv(paramzzb);
    try
    {
      paramString1 = zzAH().zzb(paramzzb, paramString1, paramString2, paramInt1, paramInt2);
      return paramString1;
    }
    catch (RemoteException paramString1)
    {
      paramzzb.zza(8, null, null, null);
    }
    return null;
  }

  public void zzb(zza.zzb<Graph.LoadContactsGaiaIdsResult> paramzzb, String paramString1, String paramString2, int paramInt)
  {
    zzyb();
    paramzzb = new zzq(paramzzb);
    try
    {
      zzAH().zza(paramzzb, paramString1, paramString2, paramInt);
      return;
    }
    catch (RemoteException paramString1)
    {
      paramzzb.zza(8, null, null);
    }
  }

  protected zzg zzfB(IBinder paramIBinder)
  {
    return zzg.zza.zzfA(paramIBinder);
  }

  protected Bundle zzkG()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("social_client_application_id", zzbcY);
    localBundle.putString("real_client_package_name", zzOZ);
    localBundle.putBoolean("support_new_image_callback", true);
    return localBundle;
  }

  protected void zzyb()
  {
    super.zzpM();
  }

  private static final class zzaa
    implements Images.LoadImageResult
  {
    private final Status zzOQ;
    private final ParcelFileDescriptor zzbds;
    private final boolean zzbdt;
    private final int zzof;
    private final int zzog;

    public zzaa(Status paramStatus, ParcelFileDescriptor paramParcelFileDescriptor, boolean paramBoolean, int paramInt1, int paramInt2)
    {
      zzOQ = paramStatus;
      zzbds = paramParcelFileDescriptor;
      zzbdt = paramBoolean;
      zzof = paramInt1;
      zzog = paramInt2;
    }

    public int getHeight()
    {
      return zzog;
    }

    public ParcelFileDescriptor getParcelFileDescriptor()
    {
      return zzbds;
    }

    public Status getStatus()
    {
      return zzOQ;
    }

    public int getWidth()
    {
      return zzof;
    }

    public void release()
    {
      if (zzbds != null)
        IOUtils.closeQuietly(zzbds);
    }
  }

  private static final class zzb
    implements Autocomplete.AutocompleteResult
  {
    private final Status zzOQ;
    private final AutocompleteBuffer zzbcS;

    public zzb(Status paramStatus, AutocompleteBuffer paramAutocompleteBuffer)
    {
      zzOQ = paramStatus;
      zzbcS = paramAutocompleteBuffer;
    }

    public AutocompleteBuffer getAutocompleteEntries()
    {
      return zzbcS;
    }

    public Status getStatus()
    {
      return zzOQ;
    }

    public void release()
    {
      if (zzbcS != null)
        zzbcS.close();
    }
  }

  private static final class zzd
    implements Graph.LoadContactsGaiaIdsResult
  {
    private final Status zzOQ;
    private final ContactGaiaIdBuffer zzbdf;

    public zzd(Status paramStatus, ContactGaiaIdBuffer paramContactGaiaIdBuffer)
    {
      zzOQ = paramStatus;
      zzbdf = paramContactGaiaIdBuffer;
    }

    public ContactGaiaIdBuffer getContactsGaiaIds()
    {
      return zzbdf;
    }

    public Status getStatus()
    {
      return zzOQ;
    }

    public void release()
    {
      if (zzbdf != null)
        zzbdf.close();
    }
  }

  private static final class zze
    implements zzi.zzb<Notifications.OnDataChanged>
  {
    private final String mAccount;
    private final String zzbcc;
    private final int zzbdg;

    public zze(String paramString1, String paramString2, int paramInt)
    {
      mAccount = paramString1;
      zzbcc = paramString2;
      zzbdg = paramInt;
    }

    public void zza(Notifications.OnDataChanged paramOnDataChanged)
    {
      paramOnDataChanged.onDataChanged(mAccount, zzbcc, zzbdg);
    }

    public void zzoy()
    {
    }
  }

  private static final class zzm extends zza
  {
    private final zza.zzb<Autocomplete.AutocompleteResult> zzaTL;

    public zzm(zza.zzb<Autocomplete.AutocompleteResult> paramzzb)
    {
      zzaTL = paramzzb;
    }

    public void zza(int paramInt, Bundle paramBundle, DataHolder paramDataHolder)
    {
      Object localObject = null;
      if (zzo.zzAM())
        zzo.zzA("PeopleClient", "Autocomplete callback: status=" + paramInt + "\nresolution=" + paramBundle + "\nholder=" + paramDataHolder);
      Status localStatus = zzn.zzb(paramInt, null, paramBundle);
      if (paramDataHolder == null);
      for (paramBundle = localObject; ; paramBundle = new AutocompleteBuffer(paramDataHolder))
      {
        zzaTL.zzq(new zzn.zzb(localStatus, paramBundle));
        return;
      }
    }
  }

  private static final class zzn extends zza
  {
    private final zza.zzb<Images.SetAvatarResult> zzaTL;

    public zzn(zza.zzb<Images.SetAvatarResult> paramzzb)
    {
      zzaTL = paramzzb;
    }

    public void zza(int paramInt, Bundle paramBundle1, Bundle paramBundle2)
    {
      Object localObject = null;
      if (zzo.zzAM())
        zzo.zzA("PeopleClient", "Bundle callback: status=" + paramInt + "\nresolution=" + paramBundle1 + "\nbundle=" + paramBundle2);
      Status localStatus = zzn.zzb(paramInt, null, paramBundle1);
      if (paramBundle2 == null);
      for (paramBundle1 = localObject; ; paramBundle1 = paramBundle2.getString("avatarurl"))
      {
        zzaTL.zzq(new zzn.zzo(localStatus, paramBundle1));
        return;
      }
    }
  }

  private static final class zzo
    implements Images.SetAvatarResult
  {
    private final String zzF;
    private final Status zzOQ;

    public zzo(Status paramStatus, String paramString)
    {
      zzOQ = paramStatus;
      zzF = paramString;
    }

    public Status getStatus()
    {
      return zzOQ;
    }
  }

  private static final class zzq extends zza
  {
    private final zza.zzb<Graph.LoadContactsGaiaIdsResult> zzaTL;

    public zzq(zza.zzb<Graph.LoadContactsGaiaIdsResult> paramzzb)
    {
      zzaTL = paramzzb;
    }

    public void zza(int paramInt, Bundle paramBundle, DataHolder paramDataHolder)
    {
      Object localObject = null;
      if (zzo.zzAM())
        zzo.zzA("PeopleClient", "GaiaId callback: status=" + paramInt + "\nresolution=" + paramBundle + "\nholder=" + paramDataHolder);
      Status localStatus = zzn.zzb(paramInt, null, paramBundle);
      if (paramDataHolder == null);
      for (paramBundle = localObject; ; paramBundle = new ContactGaiaIdBuffer(paramDataHolder))
      {
        zzaTL.zzq(new zzn.zzd(localStatus, paramBundle));
        return;
      }
    }
  }

  private static final class zzr extends zza
  {
    private final zzi<Notifications.OnDataChanged> zzbdo;

    public zzr(zzi<Notifications.OnDataChanged> paramzzi)
    {
      zzbdo = paramzzi;
    }

    public void release()
    {
      zzbdo.clear();
    }

    public void zza(int paramInt, Bundle paramBundle1, Bundle paramBundle2)
    {
      if (zzo.zzAM())
        zzo.zzA("PeopleClient", "Bundle callback: status=" + paramInt + "\nresolution=" + paramBundle1 + "\nbundle=" + paramBundle2);
      if (paramInt != 0)
      {
        zzo.zzC("PeopleClient", "Non-success data changed callback received.");
        return;
      }
      zzbdo.zza(new zzn.zze(paramBundle2.getString("account"), paramBundle2.getString("pagegaiaid"), paramBundle2.getInt("scope")));
    }
  }

  private static final class zzu extends zza
  {
    private final zza.zzb<Graph.LoadOwnersResult> zzaTL;

    public zzu(zza.zzb<Graph.LoadOwnersResult> paramzzb)
    {
      zzaTL = paramzzb;
    }

    public void zza(int paramInt, Bundle paramBundle, DataHolder paramDataHolder)
    {
      Object localObject = null;
      if (zzo.zzAM())
        zzo.zzA("PeopleClient", "Owner callback: status=" + paramInt + "\nresolution=" + paramBundle + "\nholder=" + paramDataHolder);
      Status localStatus = zzn.zzb(paramInt, null, paramBundle);
      if (paramDataHolder == null);
      for (paramBundle = localObject; ; paramBundle = new OwnerBuffer(paramDataHolder))
      {
        zzaTL.zzq(new zzn.zzz(localStatus, paramBundle));
        return;
      }
    }
  }

  private static final class zzv extends zza
  {
    private final zza.zzb<Images.LoadImageResult> zzaTL;

    public zzv(zza.zzb<Images.LoadImageResult> paramzzb)
    {
      zzaTL = paramzzb;
    }

    public void zza(int paramInt, Bundle paramBundle1, ParcelFileDescriptor paramParcelFileDescriptor, Bundle paramBundle2)
    {
      int i = 0;
      if (zzo.zzAM())
        zzo.zzA("PeopleClient", "Avatar callback: status=" + paramInt + " resolution=" + paramBundle1 + " pfd=" + paramParcelFileDescriptor);
      paramBundle1 = zzn.zzb(paramInt, null, paramBundle1);
      boolean bool;
      if (paramBundle2 != null)
      {
        bool = paramBundle2.getBoolean("rewindable");
        paramInt = paramBundle2.getInt("width");
        i = paramBundle2.getInt("height");
      }
      while (true)
      {
        zzaTL.zzq(new zzn.zzaa(paramBundle1, paramParcelFileDescriptor, bool, paramInt, i));
        return;
        paramInt = 0;
        bool = false;
      }
    }
  }

  private static final class zzz
    implements Graph.LoadOwnersResult
  {
    private final Status zzOQ;
    private final OwnerBuffer zzbdr;

    public zzz(Status paramStatus, OwnerBuffer paramOwnerBuffer)
    {
      zzOQ = paramStatus;
      zzbdr = paramOwnerBuffer;
    }

    public OwnerBuffer getOwners()
    {
      return zzbdr;
    }

    public Status getStatus()
    {
      return zzOQ;
    }

    public void release()
    {
      if (zzbdr != null)
        zzbdr.close();
    }
  }
}