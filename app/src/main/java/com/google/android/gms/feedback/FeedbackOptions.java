package com.google.android.gms.feedback;

import android.app.ApplicationErrorReport;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;

public class FeedbackOptions
  implements SafeParcelable
{
  public static final Parcelable.Creator<FeedbackOptions> CREATOR = new zzb();
  public String mAccountInUse;
  public ApplicationErrorReport mApplicationErrorReport;
  public BitmapTeleporter mBitmapTeleporter;
  public String mCategoryTag;
  public String mDescription;
  public boolean mExcludePii;
  public ArrayList<FileTeleporter> mFileTeleporters;
  public LogOptions mLogOptions;
  public String mPackageName;
  public Bundle mPsdBundle;
  public ThemeSettings mThemeSettings;
  public final int mVersionCode;

  private FeedbackOptions()
  {
    this(3, null, null, null, new ApplicationErrorReport(), null, null, null, null, true, null, null);
  }

  FeedbackOptions(int paramInt, String paramString1, Bundle paramBundle, String paramString2, ApplicationErrorReport paramApplicationErrorReport, String paramString3, BitmapTeleporter paramBitmapTeleporter, String paramString4, ArrayList<FileTeleporter> paramArrayList, boolean paramBoolean, ThemeSettings paramThemeSettings, LogOptions paramLogOptions)
  {
    mVersionCode = paramInt;
    mAccountInUse = paramString1;
    mPsdBundle = paramBundle;
    mDescription = paramString2;
    mApplicationErrorReport = paramApplicationErrorReport;
    mCategoryTag = paramString3;
    mBitmapTeleporter = paramBitmapTeleporter;
    mPackageName = paramString4;
    mFileTeleporters = paramArrayList;
    mExcludePii = paramBoolean;
    mThemeSettings = paramThemeSettings;
    mLogOptions = paramLogOptions;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
}