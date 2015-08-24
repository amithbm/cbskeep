package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class zzaa
  implements DataItem
{
  private byte[] mData;
  private Uri mUri;
  private Map<String, DataItemAsset> zzbHU;

  public zzaa(DataItem paramDataItem)
  {
    mUri = paramDataItem.getUri();
    mData = paramDataItem.getData();
    HashMap localHashMap = new HashMap();
    paramDataItem = paramDataItem.getAssets().entrySet().iterator();
    while (paramDataItem.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramDataItem.next();
      if (localEntry.getKey() != null)
        localHashMap.put(localEntry.getKey(), ((DataItemAsset)localEntry.getValue()).freeze());
    }
    zzbHU = Collections.unmodifiableMap(localHashMap);
  }

  public Map<String, DataItemAsset> getAssets()
  {
    return zzbHU;
  }

  public byte[] getData()
  {
    return mData;
  }

  public Uri getUri()
  {
    return mUri;
  }

  public String toString()
  {
    return toString(Log.isLoggable("DataItem", 3));
  }

  public String toString(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder("DataItemEntity{ ");
    localStringBuilder.append("uri=" + mUri);
    Object localObject2 = new StringBuilder().append(", dataSz=");
    if (mData == null);
    for (Object localObject1 = "null"; ; localObject1 = Integer.valueOf(mData.length))
    {
      localStringBuilder.append(localObject1);
      localStringBuilder.append(", numAssets=" + zzbHU.size());
      if ((!paramBoolean) || (zzbHU.isEmpty()))
        break label251;
      localStringBuilder.append(", assets=[");
      localObject2 = zzbHU.entrySet().iterator();
      for (localObject1 = ""; ((Iterator)localObject2).hasNext(); localObject1 = ", ")
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
        localStringBuilder.append((String)localObject1 + (String)localEntry.getKey() + ": " + ((DataItemAsset)localEntry.getValue()).getId());
      }
    }
    localStringBuilder.append("]");
    label251: localStringBuilder.append(" }");
    return localStringBuilder.toString();
  }

  public DataItem zzGW()
  {
    return this;
  }
}