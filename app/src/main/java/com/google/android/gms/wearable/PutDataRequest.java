package com.google.android.gms.wearable;

import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzv;
import com.google.android.gms.wearable.internal.DataItemAssetParcelable;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class PutDataRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<PutDataRequest> CREATOR = new zzc();
  private static final Random zzbGy = new SecureRandom();
  private byte[] mData;
  private final Uri mUri;
  final int mVersionCode;
  private final Bundle zzbGz;

  private PutDataRequest(int paramInt, Uri paramUri)
  {
    this(paramInt, paramUri, new Bundle(), null);
  }

  PutDataRequest(int paramInt, Uri paramUri, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    mVersionCode = paramInt;
    mUri = paramUri;
    zzbGz = paramBundle;
    zzbGz.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
    mData = paramArrayOfByte;
  }

  public static PutDataRequest create(String paramString)
  {
    return zzp(zzgc(paramString));
  }

  private static Uri zzgc(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      throw new IllegalArgumentException("An empty path was supplied.");
    if (!paramString.startsWith("/"))
      throw new IllegalArgumentException("A path must start with a single / .");
    if (paramString.startsWith("//"))
      throw new IllegalArgumentException("A path must start with a single / .");
    return new Uri.Builder().scheme("wear").path(paramString).build();
  }

  public static PutDataRequest zzp(Uri paramUri)
  {
    return new PutDataRequest(1, paramUri);
  }

  public int describeContents()
  {
    return 0;
  }

  public Map<String, Asset> getAssets()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = zzbGz.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashMap.put(str, (Asset)zzbGz.getParcelable(str));
    }
    return Collections.unmodifiableMap(localHashMap);
  }

  public byte[] getData()
  {
    return mData;
  }

  public Uri getUri()
  {
    return mUri;
  }

  public PutDataRequest putAsset(String paramString, Asset paramAsset)
  {
    zzv.zzz(paramString);
    zzv.zzz(paramAsset);
    zzbGz.putParcelable(paramString, paramAsset);
    return this;
  }

  public PutDataRequest setData(byte[] paramArrayOfByte)
  {
    mData = paramArrayOfByte;
    return this;
  }

  public String toString()
  {
    return toString(Log.isLoggable("DataMap", 3));
  }

  public String toString(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder("PutDataRequest[");
    Object localObject2 = new StringBuilder().append("dataSz=");
    if (mData == null);
    for (Object localObject1 = "null"; ; localObject1 = Integer.valueOf(mData.length))
    {
      localStringBuilder.append(localObject1);
      localStringBuilder.append(", numAssets=" + zzbGz.size());
      localStringBuilder.append(", uri=" + mUri);
      if (paramBoolean)
        break;
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
    localStringBuilder.append("]\n  assets: ");
    localObject1 = zzbGz.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      localStringBuilder.append("\n    " + (String)localObject2 + ": " + zzbGz.getParcelable((String)localObject2));
    }
    localStringBuilder.append("\n  ]");
    return localStringBuilder.toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }

  public Bundle zzGR()
  {
    return zzbGz;
  }
}