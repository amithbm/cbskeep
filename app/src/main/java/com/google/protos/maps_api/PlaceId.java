package com.google.protos.maps_api;

import com.google.android.location.proto.support.FeatureIdProto;
import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

public final class PlaceId extends ExtendableMessageNano<PlaceId>
{
  public FeatureIdProto featureId;
  public String subFeatureName;

  public PlaceId()
  {
    clear();
  }

  public static PlaceId parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferNanoException
  {
    return (PlaceId)MessageNano.mergeFrom(new PlaceId(), paramArrayOfByte);
  }

  public PlaceId clear()
  {
    featureId = null;
    subFeatureName = "";
    unknownFieldData = null;
    cachedSize = -1;
    return this;
  }

  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (featureId != null)
      i = j + CodedOutputByteBufferNano.computeMessageSize(1, featureId);
    j = i;
    if (!subFeatureName.equals(""))
      j = i + CodedOutputByteBufferNano.computeStringSize(2, subFeatureName);
    return j;
  }

  public PlaceId mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
    throws IOException
  {
    while (true)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      switch (i)
      {
      default:
        if (storeUnknownField(paramCodedInputByteBufferNano, i))
          continue;
      case 0:
        return this;
      case 10:
        if (featureId == null)
          featureId = new FeatureIdProto();
        paramCodedInputByteBufferNano.readMessage(featureId);
        break;
      case 18:
      }
      subFeatureName = paramCodedInputByteBufferNano.readString();
    }
  }

  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
    throws IOException
  {
    if (featureId != null)
      paramCodedOutputByteBufferNano.writeMessage(1, featureId);
    if (!subFeatureName.equals(""))
      paramCodedOutputByteBufferNano.writeString(2, subFeatureName);
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}