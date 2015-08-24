package com.google.android.gms.internal;

import android.accounts.Account;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.appdatasearch.DocumentContents.Builder;
import com.google.android.gms.appdatasearch.DocumentSection;
import com.google.android.gms.appdatasearch.RegisterSectionInfo.Builder;
import com.google.android.gms.appdatasearch.UsageInfo;
import com.google.android.gms.appdatasearch.UsageInfo.Builder;
import com.google.android.gms.appindexing.Action;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class zziz
{
  private static DocumentSection zza(String paramString, zzqc.zzc paramzzc)
  {
    paramString = new RegisterSectionInfo.Builder(paramString).noIndex(true).schemaOrgProperty(paramString).format("blob").build();
    return new DocumentSection(zzadx.zzf(paramzzc), paramString);
  }

  public static UsageInfo zza(Action paramAction, long paramLong, String paramString, int paramInt)
  {
    boolean bool = false;
    Bundle localBundle = new Bundle();
    localBundle.putAll(paramAction.zzkE());
    Object localObject = localBundle.getBundle("object");
    int i;
    if (((Bundle)localObject).containsKey("id"))
    {
      paramAction = Uri.parse(((Bundle)localObject).getString("id"));
      String str1 = ((Bundle)localObject).getString("name");
      String str2 = ((Bundle)localObject).getString("type");
      localObject = zzja.zza(paramString, Uri.parse(((Bundle)localObject).getString("url")));
      paramAction = UsageInfo.makeDocumentContents((Intent)localObject, str1, paramAction, str2, null);
      if (localBundle.containsKey(".private:ssbContext"))
      {
        paramAction.addDocumentSection(DocumentSection.makeSsbContextSection(localBundle.getByteArray(".private:ssbContext")));
        localBundle.remove(".private:ssbContext");
      }
      if (localBundle.containsKey(".private:accountName"))
      {
        paramAction.account(new Account(localBundle.getString(".private:accountName"), "com.google"));
        localBundle.remove(".private:accountName");
      }
      if ((!localBundle.containsKey(".private:isContextOnly")) || (!localBundle.getBoolean(".private:isContextOnly")))
        break label290;
      i = 4;
      localBundle.remove(".private:isContextOnly");
    }
    while (true)
    {
      if (localBundle.containsKey(".private:isDeviceOnly"))
      {
        bool = localBundle.getBoolean(".private:isDeviceOnly", false);
        localBundle.remove(".private:isDeviceOnly");
      }
      paramAction.addDocumentSection(zza(".private:action", zzf(localBundle)));
      return new UsageInfo.Builder().setDocumentId(UsageInfo.makeDocumentIdFromIntent(paramString, (Intent)localObject)).setTimestampMs(paramLong).setUsageType(i).setDocumentContents(paramAction.build()).setIsDeviceOnly(bool).setEventStatus(paramInt).build();
      paramAction = null;
      break;
      label290: i = 0;
    }
  }

  static zzqc.zzc zzf(Bundle paramBundle)
  {
    zzqc.zzc localzzc = new zzqc.zzc();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramBundle.keySet().iterator();
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramBundle.get(str);
      zzqc.zzb localzzb = new zzqc.zzb();
      localzzb.name = str;
      localzzb.zzaPF = new zzqc.zzd();
      if ((localObject instanceof String))
        localzzb.zzaPF.zzamQ = ((String)localObject);
      while (true)
      {
        localArrayList.add(localzzb);
        break;
        if ((localObject instanceof Bundle))
          localzzb.zzaPF.zzaPK = zzf((Bundle)localObject);
        else
          Log.e("AppDataSearchClient", "Unsupported value: " + localObject);
      }
    }
    if (paramBundle.containsKey("type"))
      localzzc.type = paramBundle.getString("type");
    localzzc.zzaPG = ((zzqc.zzb[])localArrayList.toArray(new zzqc.zzb[localArrayList.size()]));
    return localzzc;
  }
}