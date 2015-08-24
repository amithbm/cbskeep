package com.google.android.gms.wearable;

import android.net.Uri;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.internal.zzadi;
import com.google.android.gms.internal.zzadi.zza;
import com.google.android.gms.internal.zzadj;
import com.google.android.gms.internal.zzadw;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataMapItem
{
  private final Uri mUri;
  private final DataMap zzbGw;

  private DataMapItem(DataItem paramDataItem)
  {
    mUri = paramDataItem.getUri();
    zzbGw = zza((DataItem)paramDataItem.freeze());
  }

  public static DataMapItem fromDataItem(DataItem paramDataItem)
  {
    if (paramDataItem == null)
      throw new IllegalStateException("provided dataItem is null");
    return new DataMapItem(paramDataItem);
  }

  private DataMap zza(DataItem paramDataItem)
  {
    if ((paramDataItem.getData() == null) && (paramDataItem.getAssets().size() > 0))
      throw new IllegalArgumentException("Cannot create DataMapItem from a DataItem  that wasn't made with DataMapItem.");
    if (paramDataItem.getData() == null)
      return new DataMap();
    try
    {
      ArrayList localArrayList = new ArrayList();
      int j = paramDataItem.getAssets().size();
      i = 0;
      if (i < j)
      {
        localDataItemAsset = (DataItemAsset)paramDataItem.getAssets().get(Integer.toString(i));
        if (localDataItemAsset == null)
          throw new IllegalStateException("Cannot find DataItemAsset referenced in data at " + i + " for " + paramDataItem);
      }
    }
    catch (zzadw localzzadw)
    {
      while (true)
      {
        int i;
        DataItemAsset localDataItemAsset;
        Log.w("DataItem", "Unable to parse datamap from dataItem. uri=" + paramDataItem.getUri() + ", data=" + Base64.encodeToString(paramDataItem.getData(), 0));
        throw new IllegalStateException("Unable to parse datamap from dataItem.  uri=" + paramDataItem.getUri(), localzzadw);
        localzzadw.add(Asset.createFromRef(localDataItemAsset.getId()));
        i += 1;
      }
      DataMap localDataMap = zzadi.zza(new zzadi.zza(zzadj.zzN(paramDataItem.getData()), localzzadw));
      return localDataMap;
    }
    catch (NullPointerException localNullPointerException)
    {
      label141: break label141;
    }
  }

  public DataMap getDataMap()
  {
    return zzbGw;
  }
}