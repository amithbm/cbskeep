package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GlobalSearchApplicationInfo
  implements SafeParcelable
{
  public static final zzm CREATOR = new zzm();
  public final String defaultIntentAction;
  public final String defaultIntentActivity;
  public final String defaultIntentData;
  public final int iconId;
  public final int labelId;
  final int mVersionCode;
  final String packageName;
  public final int settingsDescriptionId;

  GlobalSearchApplicationInfo(int paramInt1, String paramString1, int paramInt2, int paramInt3, int paramInt4, String paramString2, String paramString3, String paramString4)
  {
    mVersionCode = paramInt1;
    packageName = paramString1;
    labelId = paramInt2;
    settingsDescriptionId = paramInt3;
    iconId = paramInt4;
    defaultIntentAction = paramString2;
    defaultIntentData = paramString3;
    defaultIntentActivity = paramString4;
  }

  public int describeContents()
  {
    zzm localzzm = CREATOR;
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    do
    {
      return true;
      if (!(paramObject instanceof GlobalSearchApplicationInfo))
        break;
      paramObject = (GlobalSearchApplicationInfo)paramObject;
    }
    while ((TextUtils.equals(packageName, paramObject.packageName)) && (labelId == paramObject.labelId) && (settingsDescriptionId == paramObject.settingsDescriptionId) && (iconId == paramObject.iconId) && (TextUtils.equals(defaultIntentAction, paramObject.defaultIntentAction)) && (TextUtils.equals(defaultIntentData, paramObject.defaultIntentData)) && (TextUtils.equals(defaultIntentActivity, paramObject.defaultIntentActivity)));
    return false;
    return false;
  }

  public String toString()
  {
    return getClass().getSimpleName() + "{" + packageName + ";labelId=" + Integer.toHexString(labelId) + ";settingsDescriptionId=" + Integer.toHexString(settingsDescriptionId) + ";iconId=" + Integer.toHexString(iconId) + ";defaultIntentAction=" + defaultIntentAction + ";defaultIntentData=" + defaultIntentData + ";defaultIntentActivity=" + defaultIntentActivity + "}";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzm localzzm = CREATOR;
    zzm.zza(this, paramParcel, paramInt);
  }
}