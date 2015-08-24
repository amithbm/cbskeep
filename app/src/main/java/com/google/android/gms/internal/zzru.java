package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.people.Graph;
import com.google.android.gms.people.Graph.LoadContactsGaiaIdsOptions;
import com.google.android.gms.people.Graph.LoadContactsGaiaIdsResult;
import com.google.android.gms.people.Graph.LoadOwnersOptions;
import com.google.android.gms.people.Graph.LoadOwnersResult;
import com.google.android.gms.people.People.zza;
import com.google.android.gms.people.internal.zzl;
import com.google.android.gms.people.internal.zzn;
import com.google.android.gms.people.model.ContactGaiaIdBuffer;
import com.google.android.gms.people.model.OwnerBuffer;

public class zzru
  implements Graph
{
  public PendingResult<Graph.LoadContactsGaiaIdsResult> loadContactsGaiaIds(GoogleApiClient paramGoogleApiClient, final Graph.LoadContactsGaiaIdsOptions paramLoadContactsGaiaIdsOptions)
  {
    if (zzl.isEnabled())
      zzl.zzh("loadContactsGaiaIds", new Object[] { paramLoadContactsGaiaIdsOptions });
    if (paramLoadContactsGaiaIdsOptions != null);
    while (true)
    {
      return paramGoogleApiClient.zza(new People.zza(paramGoogleApiClient)
      {
        protected void zza(zzn paramAnonymouszzn)
          throws RemoteException
        {
          paramAnonymouszzn.zzb(this, paramLoadContactsGaiaIdsOptions.getFilterContactInfo(), paramLoadContactsGaiaIdsOptions.getFilterGaiaId(), paramLoadContactsGaiaIdsOptions.getFilterGaiaEdgeTypes());
        }

        protected Graph.LoadContactsGaiaIdsResult zzbN(final Status paramAnonymousStatus)
        {
          return new Graph.LoadContactsGaiaIdsResult()
          {
            public ContactGaiaIdBuffer getContactsGaiaIds()
            {
              return null;
            }

            public Status getStatus()
            {
              return paramAnonymousStatus;
            }

            public void release()
            {
            }
          };
        }
      });
      paramLoadContactsGaiaIdsOptions = Graph.LoadContactsGaiaIdsOptions.DEFAULT;
    }
  }

  public PendingResult<Graph.LoadOwnersResult> loadOwners(GoogleApiClient paramGoogleApiClient, final Graph.LoadOwnersOptions paramLoadOwnersOptions)
  {
    if (zzl.isEnabled())
      zzl.zzh("loadOwners", new Object[] { paramLoadOwnersOptions });
    if (paramLoadOwnersOptions != null);
    while (true)
    {
      return paramGoogleApiClient.zza(new People.zza(paramGoogleApiClient)
      {
        protected void zza(zzn paramAnonymouszzn)
          throws RemoteException
        {
          paramAnonymouszzn.zza(this, false, paramLoadOwnersOptions.isIncludePlusPages(), null, null, paramLoadOwnersOptions.getSortOrder());
        }

        protected Graph.LoadOwnersResult zzbI(final Status paramAnonymousStatus)
        {
          return new Graph.LoadOwnersResult()
          {
            public OwnerBuffer getOwners()
            {
              return null;
            }

            public Status getStatus()
            {
              return paramAnonymousStatus;
            }

            public void release()
            {
            }
          };
        }
      });
      paramLoadOwnersOptions = Graph.LoadOwnersOptions.DEFAULT;
    }
  }
}