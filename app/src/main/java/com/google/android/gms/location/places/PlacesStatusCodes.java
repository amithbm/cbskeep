package com.google.android.gms.location.places;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzv;

public class PlacesStatusCodes extends CommonStatusCodes
{
  public static String getStatusCodeString(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return CommonStatusCodes.getStatusCodeString(paramInt);
    case 9000:
      return "PLACES_API_QUOTA_FAILED";
    case 9001:
      return "PLACES_API_USAGE_LIMIT_EXCEEDED";
    case 9002:
      return "PLACES_API_KEY_INVALID";
    case 9003:
      return "PLACES_API_ACCESS_NOT_CONFIGURED";
    case 9004:
      return "PLACES_API_INVALID_ARGUMENT";
    case 9005:
      return "PLACES_API_RATE_LIMIT_EXCEEDED";
    case 9006:
      return "PLACES_API_DEVICE_RATE_LIMIT_EXCEEDED";
    case 9007:
    }
    return "PLACES_API_KEY_EXPIRED";
  }

  public static Status zzk(int paramInt, String paramString)
  {
    zzv.zzz(paramString);
    return new Status(paramInt, paramString);
  }

  public static Status zzlE(int paramInt)
  {
    return zzk(paramInt, getStatusCodeString(paramInt));
  }
}