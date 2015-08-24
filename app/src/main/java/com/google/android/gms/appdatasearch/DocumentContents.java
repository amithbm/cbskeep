package com.google.android.gms.appdatasearch;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class DocumentContents
  implements SafeParcelable
{
  public static final zzd CREATOR = new zzd();
  public final Account account;
  public final boolean globalSearchEnabled;
  final int mVersionCode;
  public final String schemaOrgType;
  final DocumentSection[] zzMB;

  DocumentContents(int paramInt, DocumentSection[] paramArrayOfDocumentSection, String paramString, boolean paramBoolean, Account paramAccount)
  {
    mVersionCode = paramInt;
    zzMB = paramArrayOfDocumentSection;
    schemaOrgType = paramString;
    globalSearchEnabled = paramBoolean;
    account = paramAccount;
  }

  DocumentContents(String paramString, boolean paramBoolean, Account paramAccount, DocumentSection[] paramArrayOfDocumentSection)
  {
    this(1, paramArrayOfDocumentSection, paramString, paramBoolean, paramAccount);
    paramString = new BitSet(GlobalSearchSections.getSectionsCount());
    int i = 0;
    while (i < paramArrayOfDocumentSection.length)
    {
      int j = paramArrayOfDocumentSection[i].globalSearchSectionType;
      if (j != -1)
      {
        if (paramString.get(j))
          throw new IllegalArgumentException("Duplicate global search section type " + GlobalSearchSections.getSectionName(j));
        paramString.set(j);
      }
      i += 1;
    }
  }

  public int describeContents()
  {
    zzd localzzd = CREATOR;
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzd localzzd = CREATOR;
    zzd.zza(this, paramParcel, paramInt);
  }

  public static class Builder
  {
    private List<DocumentSection> zzMC;
    private String zzMD;
    private boolean zzME;
    private Account zzMF;

    public Builder account(Account paramAccount)
    {
      zzMF = paramAccount;
      return this;
    }

    public Builder addDocumentSection(DocumentSection paramDocumentSection)
    {
      if (zzMC == null)
        zzMC = new ArrayList();
      zzMC.add(paramDocumentSection);
      return this;
    }

    public DocumentContents build()
    {
      String str = zzMD;
      boolean bool = zzME;
      Account localAccount = zzMF;
      if (zzMC != null);
      for (DocumentSection[] arrayOfDocumentSection = (DocumentSection[])zzMC.toArray(new DocumentSection[zzMC.size()]); ; arrayOfDocumentSection = null)
        return new DocumentContents(str, bool, localAccount, arrayOfDocumentSection);
    }

    public Builder globalSearchEnabled(boolean paramBoolean)
    {
      zzME = paramBoolean;
      return this;
    }

    public Builder schemaOrgType(String paramString)
    {
      zzMD = paramString;
      return this;
    }
  }
}