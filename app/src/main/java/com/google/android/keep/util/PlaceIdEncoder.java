package com.google.android.keep.util;

import android.text.TextUtils;
import android.util.Base64;
import com.google.common.base.Preconditions;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protos.maps_api.PlaceId;
import java.util.Arrays;

public class PlaceIdEncoder
{
  private static boolean a(PlaceId paramPlaceId, byte[] paramArrayOfByte)
  {
    PlaceId localPlaceId = new PlaceId();
    localPlaceId.featureId = featureId;
    if (!TextUtils.isEmpty(subFeatureName))
      localPlaceId.subFeatureName = subFeatureName;
    return Arrays.equals(MessageNano.toByteArray(localPlaceId), paramArrayOfByte);
  }

  public static PlaceId decode(String paramString)
    throws IllegalArgumentException
  {
    Preconditions.checkNotNull(paramString);
    paramString = Base64.decode(paramString, 10);
    PlaceId localPlaceId;
    try
    {
      localPlaceId = PlaceId.parseFrom(paramString);
      if (!a(localPlaceId, paramString))
        throw new IllegalArgumentException("The place id is not normalized");
    }
    catch (InvalidProtocolBufferNanoException paramString)
    {
      throw new IllegalArgumentException("Could not parse place id into a proto", paramString);
    }
    return localPlaceId;
  }

  public static String encode(com.google.android.gms.reminders.model.FeatureIdProto paramFeatureIdProto)
  {
    PlaceId localPlaceId = new PlaceId();
    com.google.android.location.proto.support.FeatureIdProto localFeatureIdProto = new com.google.android.location.proto.support.FeatureIdProto();
    localFeatureIdProto.cellId = paramFeatureIdProto.getCellId().longValue();
    localFeatureIdProto.fprint = paramFeatureIdProto.getFprint().longValue();
    localPlaceId.featureId = localFeatureIdProto;
    return encode(localPlaceId);
  }

  public static String encode(PlaceId paramPlaceId)
  {
    if (featureId != null);
    byte[] arrayOfByte;
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      arrayOfByte = MessageNano.toByteArray(paramPlaceId);
      if (a(paramPlaceId, arrayOfByte))
        break;
      throw new IllegalArgumentException("The place id is not normalized");
    }
    return Base64.encodeToString(arrayOfByte, 11);
  }
}