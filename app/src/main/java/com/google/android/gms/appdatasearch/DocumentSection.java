package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzv;

public class DocumentSection
  implements SafeParcelable
{
  public static final zzg CREATOR = new zzg();
  public static final int INVALID_GLOBAL_SEARCH_SECTION_ID = Integer.parseInt("-1");
  private static final RegisterSectionInfo zzML = new RegisterSectionInfo.Builder("SsbContext").noIndex(true).format("blob").build();
  public final byte[] blobContent;
  public final String content;
  public final int globalSearchSectionType;
  final int mVersionCode;
  final RegisterSectionInfo zzMM;

  DocumentSection(int paramInt1, String paramString, RegisterSectionInfo paramRegisterSectionInfo, int paramInt2, byte[] paramArrayOfByte)
  {
    if ((paramInt2 == INVALID_GLOBAL_SEARCH_SECTION_ID) || (GlobalSearchSections.getSectionName(paramInt2) != null));
    for (boolean bool = true; ; bool = false)
    {
      zzv.zzb(bool, "Invalid section type " + paramInt2);
      mVersionCode = paramInt1;
      content = paramString;
      zzMM = paramRegisterSectionInfo;
      globalSearchSectionType = paramInt2;
      blobContent = paramArrayOfByte;
      paramString = validate();
      if (paramString == null)
        break;
      throw new IllegalArgumentException(paramString);
    }
  }

  public DocumentSection(String paramString, RegisterSectionInfo paramRegisterSectionInfo)
  {
    this(1, paramString, paramRegisterSectionInfo, INVALID_GLOBAL_SEARCH_SECTION_ID, null);
  }

  public DocumentSection(String paramString1, RegisterSectionInfo paramRegisterSectionInfo, String paramString2)
  {
    this(1, paramString1, paramRegisterSectionInfo, GlobalSearchSections.getSectionId(paramString2), null);
  }

  public DocumentSection(byte[] paramArrayOfByte, RegisterSectionInfo paramRegisterSectionInfo)
  {
    this(1, null, paramRegisterSectionInfo, INVALID_GLOBAL_SEARCH_SECTION_ID, paramArrayOfByte);
  }

  public static DocumentSection makeSsbContextSection(byte[] paramArrayOfByte)
  {
    return new DocumentSection(paramArrayOfByte, zzML);
  }

  public int describeContents()
  {
    zzg localzzg = CREATOR;
    return 0;
  }

  public String validate()
  {
    if ((globalSearchSectionType != INVALID_GLOBAL_SEARCH_SECTION_ID) && (GlobalSearchSections.getSectionName(globalSearchSectionType) == null))
      return "Invalid section type " + globalSearchSectionType;
    if ((content != null) && (blobContent != null))
      return "Both content and blobContent set";
    return null;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzg localzzg = CREATOR;
    zzg.zza(this, paramParcel, paramInt);
  }
}