package com.google.android.gms.location.places.ui;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.common.internal.zzv;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.internal.PlaceImpl;
import com.google.android.gms.location.places.internal.zzq;
import com.google.android.gms.maps.model.LatLngBounds;

public class PlacePicker
{
  public static Place getPlace(Intent paramIntent, Context paramContext)
  {
    zzv.zzb(paramContext, "context must not be null");
    paramIntent = (PlaceImpl)zzc.zza(paramIntent, "selected_place", PlaceImpl.CREATOR);
    paramIntent.zza(zzq.zzaD(paramContext));
    return paramIntent;
  }

  public static class IntentBuilder
  {
    private final Intent mIntent = new Intent("com.google.android.gms.location.places.ui.PICK_PLACE");

    public IntentBuilder()
    {
      mIntent.setPackage("com.google.android.gms");
      mIntent.putExtra("gmscore_client_jar_version", GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }

    public Intent build(Context paramContext)
      throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException
    {
      GoogleApiAvailability.getInstance().zzad(paramContext);
      return mIntent;
    }

    public IntentBuilder hideNearbyPlaces(boolean paramBoolean)
    {
      mIntent.putExtra("hide_nearby_places", paramBoolean);
      return this;
    }

    public void setAccountName(String paramString)
    {
      mIntent.putExtra("account_name", paramString);
    }

    public IntentBuilder setLatLngBounds(LatLngBounds paramLatLngBounds)
    {
      zzv.zzz(paramLatLngBounds);
      zzc.zza(paramLatLngBounds, mIntent, "latlng_bounds");
      return this;
    }

    public IntentBuilder setMode(int paramInt)
    {
      boolean bool2 = true;
      boolean bool1 = bool2;
      if (paramInt != 0)
      {
        bool1 = bool2;
        if (paramInt != 1)
          if (paramInt != 2)
            break label41;
      }
      label41: for (bool1 = bool2; ; bool1 = false)
      {
        zzv.zzb(bool1, "unknown mode");
        mIntent.putExtra("mode", paramInt);
        return this;
      }
    }
  }
}