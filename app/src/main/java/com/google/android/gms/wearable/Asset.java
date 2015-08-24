package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;

public class Asset
  implements SafeParcelable
{
  public static final Parcelable.Creator<Asset> CREATOR = new zza();
  private byte[] mData;
  final int mVersionCode;
  public Uri uri;
  private String zzbGo;
  public ParcelFileDescriptor zzbGp;

  Asset(int paramInt, byte[] paramArrayOfByte, String paramString, ParcelFileDescriptor paramParcelFileDescriptor, Uri paramUri)
  {
    mVersionCode = paramInt;
    mData = paramArrayOfByte;
    zzbGo = paramString;
    zzbGp = paramParcelFileDescriptor;
    uri = paramUri;
  }

  public static Asset createFromBytes(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
      throw new IllegalArgumentException("Asset data cannot be null");
    return new Asset(1, paramArrayOfByte, null, null, null);
  }

  public static Asset createFromFd(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    if (paramParcelFileDescriptor == null)
      throw new IllegalArgumentException("Asset fd cannot be null");
    return new Asset(1, null, null, paramParcelFileDescriptor, null);
  }

  public static Asset createFromRef(String paramString)
  {
    if (paramString == null)
      throw new IllegalArgumentException("Asset digest cannot be null");
    return new Asset(1, null, paramString, null, null);
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    do
    {
      return true;
      if (!(paramObject instanceof Asset))
        return false;
      paramObject = (Asset)paramObject;
    }
    while ((zzu.equal(mData, paramObject.mData)) && (zzu.equal(zzbGo, paramObject.zzbGo)) && (zzu.equal(zzbGp, paramObject.zzbGp)) && (zzu.equal(uri, paramObject.uri)));
    return false;
  }

  public byte[] getData()
  {
    return mData;
  }

  public String getDigest()
  {
    return zzbGo;
  }

  public ParcelFileDescriptor getFd()
  {
    return zzbGp;
  }

  public Uri getUri()
  {
    return uri;
  }

  public int hashCode()
  {
    return zzu.hashCode(new Object[] { mData, zzbGo, zzbGp, uri });
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Asset[@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    if (zzbGo == null)
      localStringBuilder.append(", nodigest");
    while (true)
    {
      if (mData != null)
      {
        localStringBuilder.append(", size=");
        localStringBuilder.append(mData.length);
      }
      if (zzbGp != null)
      {
        localStringBuilder.append(", fd=");
        localStringBuilder.append(zzbGp);
      }
      if (uri != null)
      {
        localStringBuilder.append(", uri=");
        localStringBuilder.append(uri);
      }
      localStringBuilder.append("]");
      return localStringBuilder.toString();
      localStringBuilder.append(", ");
      localStringBuilder.append(zzbGo);
    }
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt | 0x1);
  }
}