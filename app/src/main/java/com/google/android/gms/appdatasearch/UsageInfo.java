package com.google.android.gms.appdatasearch;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.appindexing.AppIndexApi.AppIndexingLink;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzadx;
import com.google.android.gms.internal.zzqc.zza;
import com.google.android.gms.internal.zzqc.zza.zza;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.zip.CRC32;

public class UsageInfo
  implements SafeParcelable
{
  public static final zzag CREATOR = new zzag();
  final int mVersionCode;
  public final String query;
  int zzOA;
  final DocumentContents zzOB;
  final boolean zzOC;
  int zzOD;
  int zzOE;
  final DocumentId zzOy;
  final long zzOz;

  UsageInfo(int paramInt1, DocumentId paramDocumentId, long paramLong, int paramInt2, String paramString, DocumentContents paramDocumentContents, boolean paramBoolean, int paramInt3, int paramInt4)
  {
    mVersionCode = paramInt1;
    zzOy = paramDocumentId;
    zzOz = paramLong;
    zzOA = paramInt2;
    query = paramString;
    zzOB = paramDocumentContents;
    zzOC = paramBoolean;
    zzOD = paramInt3;
    zzOE = paramInt4;
  }

  private UsageInfo(DocumentId paramDocumentId, long paramLong, int paramInt1, String paramString, DocumentContents paramDocumentContents, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    this(1, paramDocumentId, paramLong, paramInt1, paramString, paramDocumentContents, paramBoolean, paramInt2, paramInt3);
  }

  public static DocumentContents.Builder makeDocumentContents(Intent paramIntent, String paramString1, Uri paramUri, String paramString2, List<AppIndexApi.AppIndexingLink> paramList)
  {
    DocumentContents.Builder localBuilder = new DocumentContents.Builder();
    localBuilder.addDocumentSection(zzbc(paramString1));
    if (paramUri != null)
      localBuilder.addDocumentSection(zzh(paramUri));
    if (paramList != null)
      localBuilder.addDocumentSection(zzh(paramList));
    paramString1 = paramIntent.getAction();
    if (paramString1 != null)
      localBuilder.addDocumentSection(zzr("intent_action", paramString1));
    paramString1 = paramIntent.getDataString();
    if (paramString1 != null)
      localBuilder.addDocumentSection(zzr("intent_data", paramString1));
    paramString1 = paramIntent.getComponent();
    if (paramString1 != null)
      localBuilder.addDocumentSection(zzr("intent_activity", paramString1.getClassName()));
    paramIntent = paramIntent.getExtras();
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getString("intent_extra_data_key");
      if (paramIntent != null)
        localBuilder.addDocumentSection(zzr("intent_extra_data", paramIntent));
    }
    return localBuilder.schemaOrgType(paramString2).globalSearchEnabled(true);
  }

  public static DocumentId makeDocumentIdFromIntent(String paramString, Intent paramIntent)
  {
    return zzq(paramString, zzg(paramIntent));
  }

  private static DocumentSection zzbc(String paramString)
  {
    return new DocumentSection(paramString, new RegisterSectionInfo.Builder("title").addSemanticLabel(1).indexPrefixes(true).schemaOrgProperty("name").build(), "text1");
  }

  private static String zzg(Intent paramIntent)
  {
    paramIntent = paramIntent.toUri(1);
    CRC32 localCRC32 = new CRC32();
    try
    {
      localCRC32.update(paramIntent.getBytes("UTF-8"));
      return Long.toHexString(localCRC32.getValue());
    }
    catch (UnsupportedEncodingException paramIntent)
    {
    }
    throw new IllegalStateException(paramIntent);
  }

  private static DocumentSection zzh(Uri paramUri)
  {
    return new DocumentSection(paramUri.toString(), new RegisterSectionInfo.Builder("web_url").addSemanticLabel(4).noIndex(true).schemaOrgProperty("url").build());
  }

  private static DocumentSection zzh(List<AppIndexApi.AppIndexingLink> paramList)
  {
    zzqc.zza localzza = new zzqc.zza();
    zzqc.zza.zza[] arrayOfzza = new zzqc.zza.zza[paramList.size()];
    int i = 0;
    while (i < arrayOfzza.length)
    {
      arrayOfzza[i] = new zzqc.zza.zza();
      AppIndexApi.AppIndexingLink localAppIndexingLink = (AppIndexApi.AppIndexingLink)paramList.get(i);
      arrayOfzza[i].zzaPC = localAppIndexingLink.appIndexingUrl.toString();
      arrayOfzza[i].viewId = localAppIndexingLink.viewId;
      if (localAppIndexingLink.webUrl != null)
        arrayOfzza[i].zzaPD = localAppIndexingLink.webUrl.toString();
      i += 1;
    }
    localzza.zzaPA = arrayOfzza;
    return new DocumentSection(zzadx.zzf(localzza), new RegisterSectionInfo.Builder("outlinks").noIndex(true).schemaOrgProperty(".private:outLinks").format("blob").build());
  }

  private static DocumentId zzq(String paramString1, String paramString2)
  {
    return new DocumentId(paramString1, "", paramString2);
  }

  private static DocumentSection zzr(String paramString1, String paramString2)
  {
    return new DocumentSection(paramString2, new RegisterSectionInfo.Builder(paramString1).noIndex(true).build(), paramString1);
  }

  public int describeContents()
  {
    zzag localzzag = CREATOR;
    return 0;
  }

  public String toString()
  {
    return String.format("UsageInfo[documentId=%s, timestamp=%d, usageType=%d, status=%d]", new Object[] { zzOy, Long.valueOf(zzOz), Integer.valueOf(zzOA), Integer.valueOf(zzOE) });
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzag localzzag = CREATOR;
    zzag.zza(this, paramParcel, paramInt);
  }

  public static final class Builder
  {
    private String zzIx;
    private int zzOA = -1;
    private DocumentContents zzOB;
    private boolean zzOC = false;
    private int zzOD = -1;
    private int zzOE = 0;
    private DocumentId zzOy;
    private long zzOz = -1L;

    public UsageInfo build()
    {
      return new UsageInfo(zzOy, zzOz, zzOA, zzIx, zzOB, zzOC, zzOD, zzOE, null);
    }

    public Builder setDocumentContents(DocumentContents paramDocumentContents)
    {
      zzOB = paramDocumentContents;
      return this;
    }

    public Builder setDocumentId(DocumentId paramDocumentId)
    {
      zzOy = paramDocumentId;
      return this;
    }

    public Builder setEventStatus(int paramInt)
    {
      zzOE = paramInt;
      return this;
    }

    public Builder setIsDeviceOnly(boolean paramBoolean)
    {
      zzOC = paramBoolean;
      return this;
    }

    public Builder setTimestampMs(long paramLong)
    {
      zzOz = paramLong;
      return this;
    }

    public Builder setUsageType(int paramInt)
    {
      zzOA = paramInt;
      return this;
    }
  }
}