package com.google.android.gms.location.places.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class zzt extends zzw
  implements Place
{
  private final String zzaUw;
  private final zzq zzaVA;
  private boolean zzaVx;

  public zzt(DataHolder paramDataHolder, int paramInt, Context paramContext)
  {
    super(paramDataHolder, paramInt);
    if (paramContext != null);
    for (paramDataHolder = zzq.zzaD(paramContext); ; paramDataHolder = null)
    {
      zzaVA = paramDataHolder;
      zzaVx = zzj("place_is_logging_enabled", false);
      zzaUw = zzJ("place_id", "");
      return;
    }
  }

  private void zzdB(String paramString)
  {
    if ((zzaVx) && (zzaVA != null))
      zzaVA.log(zzaUw, paramString);
  }

  public CharSequence getAddress()
  {
    zzdB("getAddress");
    return zzJ("place_address", "");
  }

  public Map<Integer, String> getAddressComponents()
  {
    zzdB("getAddressComponents");
    return Collections.emptyMap();
  }

  public String getId()
  {
    zzdB("getId");
    return zzaUw;
  }

  public LatLng getLatLng()
  {
    zzdB("getLatLng");
    return (LatLng)zza("place_lat_lng", LatLng.CREATOR);
  }

  public float getLevelNumber()
  {
    zzdB("getLevelNumber");
    return zzb("place_level_number", 0.0F);
  }

  public Locale getLocale()
  {
    zzdB("getLocale");
    String str = zzJ("place_locale", "");
    if (!TextUtils.isEmpty(str))
      return new Locale(str);
    return Locale.getDefault();
  }

  public CharSequence getName()
  {
    zzdB("getName");
    return zzJ("place_name", "");
  }

  public CharSequence getPhoneNumber()
  {
    zzdB("getPhoneNumber");
    return zzJ("place_phone_number", "");
  }

  public List<Integer> getPlaceTypes()
  {
    zzdB("getPlaceTypes");
    return zza("place_types", Collections.emptyList());
  }

  public int getPriceLevel()
  {
    zzdB("getPriceLevel");
    return zzx("place_price_level", -1);
  }

  public float getRating()
  {
    zzdB("getRating");
    return zzb("place_rating", -1.0F);
  }

  public LatLngBounds getViewport()
  {
    zzdB("getViewport");
    return (LatLngBounds)zza("place_viewport", LatLngBounds.CREATOR);
  }

  public Uri getWebsiteUri()
  {
    zzdB("getWebsiteUri");
    String str = zzJ("place_website_uri", null);
    if (str == null)
      return null;
    return Uri.parse(str);
  }

  public boolean isPermanentlyClosed()
  {
    zzdB("isPermanentlyClosed");
    return zzj("place_is_permanently_closed", false);
  }

  public Place zzze()
  {
    Object localObject = new PlaceImpl.zza().zzae(zzaVx);
    zzaVx = false;
    localObject = ((PlaceImpl.zza)localObject).zzdE(getAddress().toString()).zzt(zzb("place_attributions", Collections.emptyList())).zzdC(getId()).zzad(isPermanentlyClosed()).zza(getLatLng()).zzf(getLevelNumber()).zzdD(getName().toString()).zzdF(getPhoneNumber().toString()).zzlI(getPriceLevel()).zzg(getRating()).zzs(getPlaceTypes()).zza(getViewport()).zzk(getWebsiteUri()).zzzf();
    ((PlaceImpl)localObject).setLocale(getLocale());
    ((PlaceImpl)localObject).zza(zzaVA);
    return localObject;
  }
}