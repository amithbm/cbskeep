package com.google.protobuf.nano.android;

import android.os.Parcel;
import android.util.Log;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;

final class ParcelingUtil
{
  static <T extends MessageNano> T createFromParcel(Parcel paramParcel)
  {
    String str = paramParcel.readString();
    byte[] arrayOfByte = paramParcel.createByteArray();
    Parcel localParcel2 = null;
    Parcel localParcel3 = null;
    Parcel localParcel4 = null;
    Parcel localParcel1 = null;
    try
    {
      paramParcel = (MessageNano)Class.forName(str).newInstance();
      localParcel1 = paramParcel;
      localParcel2 = paramParcel;
      localParcel3 = paramParcel;
      localParcel4 = paramParcel;
      MessageNano.mergeFrom(paramParcel, arrayOfByte);
      return paramParcel;
    }
    catch (ClassNotFoundException paramParcel)
    {
      Log.e("ParcelingUtil", "Exception trying to create proto from parcel", paramParcel);
      return localParcel1;
    }
    catch (IllegalAccessException paramParcel)
    {
      Log.e("ParcelingUtil", "Exception trying to create proto from parcel", paramParcel);
      return localParcel2;
    }
    catch (InstantiationException paramParcel)
    {
      Log.e("ParcelingUtil", "Exception trying to create proto from parcel", paramParcel);
      return localParcel3;
    }
    catch (InvalidProtocolBufferNanoException paramParcel)
    {
      Log.e("ParcelingUtil", "Exception trying to create proto from parcel", paramParcel);
    }
    return localParcel4;
  }
}