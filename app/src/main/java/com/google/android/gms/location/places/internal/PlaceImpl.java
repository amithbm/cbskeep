package com.google.android.gms.location.places.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.common.internal.zzu.zza;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public final class PlaceImpl
  implements SafeParcelable, Place
{
  public static final zzm CREATOR = new zzm();
  private final String mName;
  private final String mPhoneNumber;
  final int mVersionCode;
  private final String zzLf;
  private final String zzaBP;
  private final LatLng zzaTY;
  private final List<Integer> zzaTZ;
  private final Uri zzaUa;
  private zzq zzaVA;
  private Locale zzaVc;
  private final Bundle zzaVl;

  @Deprecated
  private final PlaceLocalization zzaVm;
  private final float zzaVn;
  private final LatLngBounds zzaVo;
  private final String zzaVp;
  private final boolean zzaVq;
  private final float zzaVr;
  private final int zzaVs;
  private final long zzaVt;
  private final List<Integer> zzaVu;
  private final String zzaVv;
  private final List<String> zzaVw;
  final boolean zzaVx;
  private final Map<Integer, String> zzaVy;
  private final TimeZone zzaVz;

  PlaceImpl(int paramInt1, String paramString1, List<Integer> paramList1, List<Integer> paramList2, Bundle paramBundle, String paramString2, String paramString3, String paramString4, String paramString5, List<String> paramList, LatLng paramLatLng, float paramFloat1, LatLngBounds paramLatLngBounds, String paramString6, Uri paramUri, boolean paramBoolean1, float paramFloat2, int paramInt2, long paramLong, boolean paramBoolean2, PlaceLocalization paramPlaceLocalization)
  {
    mVersionCode = paramInt1;
    zzLf = paramString1;
    zzaTZ = Collections.unmodifiableList(paramList1);
    zzaVu = paramList2;
    if (paramBundle != null)
    {
      zzaVl = paramBundle;
      mName = paramString2;
      zzaBP = paramString3;
      mPhoneNumber = paramString4;
      zzaVv = paramString5;
      if (paramList == null)
        break label182;
      label68: zzaVw = paramList;
      zzaTY = paramLatLng;
      zzaVn = paramFloat1;
      zzaVo = paramLatLngBounds;
      if (paramString6 == null)
        break label190;
    }
    while (true)
    {
      zzaVp = paramString6;
      zzaUa = paramUri;
      zzaVq = paramBoolean1;
      zzaVr = paramFloat2;
      zzaVs = paramInt2;
      zzaVt = paramLong;
      zzaVy = Collections.unmodifiableMap(new HashMap());
      zzaVz = null;
      zzaVc = null;
      zzaVx = paramBoolean2;
      zzaVm = paramPlaceLocalization;
      return;
      paramBundle = new Bundle();
      break;
      label182: paramList = Collections.emptyList();
      break label68;
      label190: paramString6 = "UTC";
    }
  }

  private void zzdB(String paramString)
  {
    if ((zzaVx) && (zzaVA != null))
      zzaVA.log(zzLf, paramString);
  }

  public int describeContents()
  {
    zzm localzzm = CREATOR;
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    do
    {
      return true;
      if (!(paramObject instanceof PlaceImpl))
        return false;
      paramObject = (PlaceImpl)paramObject;
    }
    while ((zzLf.equals(paramObject.zzLf)) && (zzu.equal(zzaVc, paramObject.zzaVc)) && (zzaVt == paramObject.zzaVt));
    return false;
  }

  public String getAddress()
  {
    zzdB("getAddress");
    return zzaBP;
  }

  public Map<Integer, String> getAddressComponents()
  {
    zzdB("getAddressComponents");
    return zzaVy;
  }

  public String getId()
  {
    zzdB("getId");
    return zzLf;
  }

  public LatLng getLatLng()
  {
    zzdB("getLatLng");
    return zzaTY;
  }

  public float getLevelNumber()
  {
    zzdB("getLevelNumber");
    return zzaVn;
  }

  public String getName()
  {
    zzdB("getName");
    return mName;
  }

  public String getPhoneNumber()
  {
    zzdB("getPhoneNumber");
    return mPhoneNumber;
  }

  public List<Integer> getPlaceTypes()
  {
    zzdB("getPlaceTypes");
    return zzaTZ;
  }

  public int getPriceLevel()
  {
    zzdB("getPriceLevel");
    return zzaVs;
  }

  public float getRating()
  {
    zzdB("getRating");
    return zzaVr;
  }

  public LatLngBounds getViewport()
  {
    zzdB("getViewport");
    return zzaVo;
  }

  public Uri getWebsiteUri()
  {
    zzdB("getWebsiteUri");
    return zzaUa;
  }

  public int hashCode()
  {
    return zzu.hashCode(new Object[] { zzLf, zzaVc, Long.valueOf(zzaVt) });
  }

  public boolean isPermanentlyClosed()
  {
    zzdB("isPermanentlyClosed");
    return zzaVq;
  }

  public void setLocale(Locale paramLocale)
  {
    zzaVc = paramLocale;
  }

  public String toString()
  {
    return zzu.zzy(this).zzc("id", zzLf).zzc("placeTypes", zzaTZ).zzc("locale", zzaVc).zzc("name", mName).zzc("address", zzaBP).zzc("phoneNumber", mPhoneNumber).zzc("latlng", zzaTY).zzc("viewport", zzaVo).zzc("websiteUri", zzaUa).zzc("isPermanentlyClosed", Boolean.valueOf(zzaVq)).zzc("priceLevel", Integer.valueOf(zzaVs)).zzc("timestampSecs", Long.valueOf(zzaVt)).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzm localzzm = CREATOR;
    zzm.zza(this, paramParcel, paramInt);
  }

  public void zza(zzq paramzzq)
  {
    zzaVA = paramzzq;
  }

  public List<Integer> zzyX()
  {
    zzdB("getTypesDeprecated");
    return zzaVu;
  }

  public String zzyY()
  {
    zzdB("getRegularOpenHours");
    return zzaVv;
  }

  public List<String> zzyZ()
  {
    zzdB("getAttributions");
    return zzaVw;
  }

  public long zzza()
  {
    return zzaVt;
  }

  public Bundle zzzb()
  {
    return zzaVl;
  }

  public String zzzc()
  {
    return zzaVp;
  }

  @Deprecated
  public PlaceLocalization zzzd()
  {
    zzdB("getLocalization");
    return zzaVm;
  }

  public Place zzze()
  {
    return this;
  }

  public static class zza
  {
    private String mName;
    private String mPhoneNumber;
    private int mVersionCode = 0;
    private String zzLf;
    private String zzaBP;
    private LatLng zzaTY;
    private Uri zzaUa;
    private Bundle zzaVB;
    private List<Integer> zzaVC;
    private float zzaVn;
    private LatLngBounds zzaVo;
    private String zzaVp;
    private boolean zzaVq;
    private float zzaVr;
    private int zzaVs;
    private long zzaVt;
    private String zzaVv;
    private List<String> zzaVw;
    private boolean zzaVx;

    public zza zza(LatLng paramLatLng)
    {
      zzaTY = paramLatLng;
      return this;
    }

    public zza zza(LatLngBounds paramLatLngBounds)
    {
      zzaVo = paramLatLngBounds;
      return this;
    }

    public zza zzad(boolean paramBoolean)
    {
      zzaVq = paramBoolean;
      return this;
    }

    public zza zzae(boolean paramBoolean)
    {
      zzaVx = paramBoolean;
      return this;
    }

    public zza zzdC(String paramString)
    {
      zzLf = paramString;
      return this;
    }

    public zza zzdD(String paramString)
    {
      mName = paramString;
      return this;
    }

    public zza zzdE(String paramString)
    {
      zzaBP = paramString;
      return this;
    }

    public zza zzdF(String paramString)
    {
      mPhoneNumber = paramString;
      return this;
    }

    public zza zzf(float paramFloat)
    {
      zzaVn = paramFloat;
      return this;
    }

    public zza zzg(float paramFloat)
    {
      zzaVr = paramFloat;
      return this;
    }

    public zza zzk(Uri paramUri)
    {
      zzaUa = paramUri;
      return this;
    }

    public zza zzlI(int paramInt)
    {
      zzaVs = paramInt;
      return this;
    }

    public zza zzs(List<Integer> paramList)
    {
      zzaVC = paramList;
      return this;
    }

    public zza zzt(List<String> paramList)
    {
      zzaVw = paramList;
      return this;
    }

    public PlaceImpl zzzf()
    {
      return new PlaceImpl(mVersionCode, zzLf, zzaVC, Collections.emptyList(), zzaVB, mName, zzaBP, mPhoneNumber, zzaVv, zzaVw, zzaTY, zzaVn, zzaVo, zzaVp, zzaUa, zzaVq, zzaVr, zzaVs, zzaVt, zzaVx, PlaceLocalization.zza(mName, zzaBP, mPhoneNumber, zzaVv, zzaVw));
    }
  }
}