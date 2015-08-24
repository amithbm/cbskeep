package com.google.android.gms.appdatasearch;

import android.accounts.Account;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class RegisterCorpusInfo
  implements SafeParcelable
{
  public static final zzx CREATOR = new zzx();
  public final Account account;
  public final Uri contentProviderUri;
  public final GlobalSearchCorpusConfig globalSearchConfig;
  public final RegisterCorpusIMEInfo imeConfig;
  final int mVersionCode;
  public final String name;
  public final String schemaOrgType;
  public final RegisterSectionInfo[] sections;
  public final boolean semanticallySearchable;
  public final boolean trimmable;
  public final String version;

  RegisterCorpusInfo(int paramInt, String paramString1, String paramString2, Uri paramUri, RegisterSectionInfo[] paramArrayOfRegisterSectionInfo, GlobalSearchCorpusConfig paramGlobalSearchCorpusConfig, boolean paramBoolean1, Account paramAccount, RegisterCorpusIMEInfo paramRegisterCorpusIMEInfo, String paramString3, boolean paramBoolean2)
  {
    mVersionCode = paramInt;
    name = paramString1;
    version = paramString2;
    contentProviderUri = paramUri;
    sections = paramArrayOfRegisterSectionInfo;
    globalSearchConfig = paramGlobalSearchCorpusConfig;
    trimmable = paramBoolean1;
    account = paramAccount;
    imeConfig = paramRegisterCorpusIMEInfo;
    schemaOrgType = paramString3;
    semanticallySearchable = paramBoolean2;
  }

  public int describeContents()
  {
    zzx localzzx = CREATOR;
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzx localzzx = CREATOR;
    zzx.zza(this, paramParcel, paramInt);
  }
}