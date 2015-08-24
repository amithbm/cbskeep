package com.google.android.gms.location.places;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.common.internal.zzu.zza;
import com.google.android.gms.common.internal.zzv;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;

public class AddPlaceRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<AddPlaceRequest> CREATOR = new zza();
  private final String mName;
  private final String mPhoneNumber;
  final int mVersionCode;
  private final String zzaBP;
  private final LatLng zzaTY;
  private final List<Integer> zzaTZ;
  private final Uri zzaUa;

  AddPlaceRequest(int paramInt, String paramString1, LatLng paramLatLng, String paramString2, List<Integer> paramList, String paramString3, Uri paramUri)
  {
    mVersionCode = paramInt;
    mName = zzv.zzce(paramString1);
    zzaTY = ((LatLng)zzv.zzz(paramLatLng));
    zzaBP = paramString2;
    zzaTZ = new ArrayList(paramList);
    if ((!TextUtils.isEmpty(paramString3)) || (paramUri != null));
    for (boolean bool = true; ; bool = false)
    {
      zzv.zzb(bool, "One of phone number or URI should be provided.");
      mPhoneNumber = paramString3;
      zzaUa = paramUri;
      return;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public String getAddress()
  {
    return zzaBP;
  }

  public LatLng getLatLng()
  {
    return zzaTY;
  }

  public String getName()
  {
    return mName;
  }

  public String getPhoneNumber()
  {
    return mPhoneNumber;
  }

  public List<Integer> getPlaceTypes()
  {
    return zzaTZ;
  }

  public Uri getWebsiteUri()
  {
    return zzaUa;
  }

  public String toString()
  {
    return zzu.zzy(this).zzc("name", mName).zzc("latLng", zzaTY).zzc("address", zzaBP).zzc("placeTypes", zzaTZ).zzc("phoneNumer", mPhoneNumber).zzc("websiteUri", zzaUa).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
}