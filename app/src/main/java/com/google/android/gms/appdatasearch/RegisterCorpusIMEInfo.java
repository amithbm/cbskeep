package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class RegisterCorpusIMEInfo
  implements SafeParcelable
{
  public static final zzw CREATOR = new zzw();
  final int mVersionCode;
  public final String[] sectionNames;
  public final int sourceClass;
  public final String toAddressesSectionName;
  public final String userInputSectionName;
  public final String[] userInputSectionValues;
  public final String userInputTag;

  RegisterCorpusIMEInfo(int paramInt1, int paramInt2, String[] paramArrayOfString1, String paramString1, String paramString2, String[] paramArrayOfString2, String paramString3)
  {
    mVersionCode = paramInt1;
    sourceClass = paramInt2;
    sectionNames = paramArrayOfString1;
    userInputTag = paramString1;
    userInputSectionName = paramString2;
    userInputSectionValues = paramArrayOfString2;
    toAddressesSectionName = paramString3;
  }

  public int describeContents()
  {
    zzw localzzw = CREATOR;
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzw localzzw = CREATOR;
    zzw.zza(this, paramParcel, paramInt);
  }
}