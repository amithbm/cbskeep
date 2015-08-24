package com.google.android.keep.util;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.nearby.Nearby;
import com.google.android.gms.people.Autocomplete;
import com.google.android.gms.people.Autocomplete.AutocompleteOptions.Builder;
import com.google.android.gms.people.Autocomplete.AutocompleteResult;
import com.google.android.gms.people.Graph;
import com.google.android.gms.people.Graph.LoadContactsGaiaIdsOptions;
import com.google.android.gms.people.Graph.LoadContactsGaiaIdsResult;
import com.google.android.gms.people.People;
import com.google.android.gms.people.People.PeopleOptions1p;
import com.google.android.gms.people.People.PeopleOptions1p.Builder;
import com.google.android.gms.people.model.AutocompleteBuffer;
import com.google.android.gms.people.model.AutocompleteEntry;
import com.google.android.gms.people.model.ContactGaiaId;
import com.google.android.gms.people.model.ContactGaiaIdBuffer;
import com.google.android.gms.reminders.Reminders;
import java.util.concurrent.TimeUnit;

public class j
{
  public static GoogleApiClient.Builder M(Context paramContext)
  {
    People.PeopleOptions1p localPeopleOptions1p = new People.PeopleOptions1p.Builder().setClientApplicationId(131).build();
    return new GoogleApiClient.Builder(paramContext).addApi(People.API_1P, localPeopleOptions1p);
  }

  public static GoogleApiClient.Builder N(Context paramContext)
  {
    return new GoogleApiClient.Builder(paramContext).addApi(Nearby.SHARING_API);
  }

  public static String a(GoogleApiClient paramGoogleApiClient, String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (paramGoogleApiClient == null) || (!paramGoogleApiClient.isConnected()))
      return null;
    paramString2 = new Autocomplete.AutocompleteOptions.Builder().setAccount(paramString2).setAutocompleteType(1).build();
    paramGoogleApiClient = (Autocomplete.AutocompleteResult)b(People.AutocompleteApi.loadAutocompleteList(paramGoogleApiClient, paramString1, paramString2));
    if (paramGoogleApiClient != null);
    try
    {
      if (paramGoogleApiClient.getAutocompleteEntries() != null)
      {
        int i = paramGoogleApiClient.getAutocompleteEntries().getCount();
        if (i > 0);
      }
      else
      {
        return null;
      }
      paramString1 = paramGoogleApiClient.getAutocompleteEntries().get(0).getPersonDisplayName();
      return paramString1;
    }
    finally
    {
      e.a(paramGoogleApiClient);
    }
    throw paramString1;
  }

  public static <T extends Result> T b(PendingResult<T> paramPendingResult)
  {
    return paramPendingResult.await(5L, TimeUnit.SECONDS);
  }

  public static void d(GoogleApiClient paramGoogleApiClient)
  {
    if ((paramGoogleApiClient != null) && (!paramGoogleApiClient.isConnected()) && (!paramGoogleApiClient.isConnecting()))
      paramGoogleApiClient.connect();
  }

  public static String e(GoogleApiClient paramGoogleApiClient, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramGoogleApiClient == null) || (!paramGoogleApiClient.isConnected()))
      return null;
    paramString = new Graph.LoadContactsGaiaIdsOptions().setFilterContactInfo(paramString);
    paramGoogleApiClient = (Graph.LoadContactsGaiaIdsResult)People.GraphApi.loadContactsGaiaIds(paramGoogleApiClient, paramString).await();
    if (paramGoogleApiClient != null);
    try
    {
      if (paramGoogleApiClient.getContactsGaiaIds() != null)
      {
        int i = paramGoogleApiClient.getContactsGaiaIds().getCount();
        if (i > 0);
      }
      else
      {
        return null;
      }
      paramString = paramGoogleApiClient.getContactsGaiaIds().get(0).getGaiaId();
      return paramString;
    }
    finally
    {
      e.a(paramGoogleApiClient);
    }
    throw paramString;
  }

  public static void e(GoogleApiClient paramGoogleApiClient)
  {
    if ((paramGoogleApiClient != null) && ((paramGoogleApiClient.isConnected()) || (paramGoogleApiClient.isConnecting())))
      paramGoogleApiClient.disconnect();
  }

  public static boolean f(GoogleApiClient paramGoogleApiClient)
  {
    if (paramGoogleApiClient == null)
      return false;
    return paramGoogleApiClient.blockingConnect(5L, TimeUnit.SECONDS).isSuccess();
  }

  public static GoogleApiClient.Builder i(Context paramContext, String paramString)
  {
    return new GoogleApiClient.Builder(paramContext).addApi(Drive.API).addScope(Drive.SCOPE_APPFOLDER).addScope(Drive.SCOPE_FULL).setAccountName(paramString);
  }

  public static GoogleApiClient.Builder j(Context paramContext, String paramString)
  {
    return new GoogleApiClient.Builder(paramContext).addApi(Reminders.API).setAccountName(paramString);
  }

  public static GoogleApiClient.Builder k(Context paramContext, String paramString)
  {
    return new GoogleApiClient.Builder(paramContext).addApi(LocationServices.API).addApi(Places.GEO_DATA_API).setAccountName(paramString);
  }
}