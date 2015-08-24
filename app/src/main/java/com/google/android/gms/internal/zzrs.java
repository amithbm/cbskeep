package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzv;
import com.google.android.gms.people.Autocomplete;
import com.google.android.gms.people.Autocomplete.AutocompleteOptions;
import com.google.android.gms.people.Autocomplete.AutocompleteResult;
import com.google.android.gms.people.People.zza;
import com.google.android.gms.people.internal.zzl;
import com.google.android.gms.people.internal.zzn;
import com.google.android.gms.people.model.AutocompleteBuffer;

public class zzrs
  implements Autocomplete
{
  public PendingResult<Autocomplete.AutocompleteResult> loadAutocompleteList(GoogleApiClient paramGoogleApiClient, final String paramString, final Autocomplete.AutocompleteOptions paramAutocompleteOptions)
  {
    zzv.zzz(paramAutocompleteOptions);
    if (zzl.isEnabled())
      zzl.zzh("loadAutocompleteList", new Object[] { paramString, paramAutocompleteOptions });
    return paramGoogleApiClient.zza(new People.zza(paramGoogleApiClient)
    {
      protected void zza(zzn paramAnonymouszzn)
        throws RemoteException
      {
        paramAnonymouszzn.zza(this, paramString, paramAutocompleteOptions);
      }

      protected Autocomplete.AutocompleteResult zzbG(final Status paramAnonymousStatus)
      {
        return new Autocomplete.AutocompleteResult()
        {
          public AutocompleteBuffer getAutocompleteEntries()
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
  }
}