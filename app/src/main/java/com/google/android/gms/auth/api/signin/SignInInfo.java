package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import org.json.JSONException;
import org.json.JSONObject;

public class SignInInfo
  implements SafeParcelable
{
  public static final Parcelable.Creator<SignInInfo> CREATOR = new zzd();
  final int versionCode;
  private String zzPa;
  private String zzQQ;
  private String zzRl;
  private String zzRo;
  private Uri zzRp;

  SignInInfo(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, Uri paramUri)
  {
    versionCode = paramInt;
    zzRo = paramString3;
    zzPa = paramString4;
    zzRp = paramUri;
    zzRl = paramString1;
    zzQQ = paramString2;
  }

  public static SignInInfo create(IdProvider paramIdProvider, String paramString1, String paramString2, String paramString3, Uri paramUri)
  {
    String str = null;
    if (paramIdProvider != null)
      str = paramIdProvider.getProviderId();
    return new SignInInfo(1, str, paramString1, paramString2, paramString3, paramUri);
  }

  public static SignInInfo fromJsonString(String paramString)
  {
    while (true)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        Object localObject1 = localJSONObject.optString("photoUrl", null);
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = Uri.parse((String)localObject1);
          localObject1 = create(IdProvider.fromProviderId(localJSONObject.optString("providerId", null)), localJSONObject.optString("tokenId", null), localJSONObject.getString("email"), localJSONObject.optString("displayName", null), (Uri)localObject1);
          return localObject1;
        }
      }
      catch (JSONException localJSONException)
      {
        Log.w("SignInInfo", "Illegal json string: " + paramString);
        return null;
      }
      Object localObject2 = null;
    }
  }

  private JSONObject zzkR()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("email", getEmail());
      if (getDisplayName() != null)
        localJSONObject.put("displayName", getDisplayName());
      if (getPhotoUrl() != null)
        localJSONObject.put("photoUrl", getPhotoUrl().toString());
      if (getIdProvider() != null)
        localJSONObject.put("providerId", getIdProvider().getProviderId());
      if (getIdToken() != null)
        localJSONObject.put("tokenId", getIdToken());
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      throw new RuntimeException(localJSONException);
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public String getDisplayName()
  {
    return zzPa;
  }

  public String getEmail()
  {
    return zzRo;
  }

  public IdProvider getIdProvider()
  {
    return IdProvider.fromProviderId(zzRl);
  }

  public String getIdToken()
  {
    return zzQQ;
  }

  public Uri getPhotoUrl()
  {
    return zzRp;
  }

  String getProviderId()
  {
    return zzRl;
  }

  public String toJson()
  {
    return zzkR().toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzd.zza(this, paramParcel, paramInt);
  }
}