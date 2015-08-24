package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class ActivityRecognitionResult
  implements SafeParcelable
{
  public static final ActivityRecognitionResultCreator CREATOR = new ActivityRecognitionResultCreator();
  private final int mVersionCode;
  List<DetectedActivity> zzaQP;
  long zzaQQ;
  long zzaQR;
  int zzaQS;

  public ActivityRecognitionResult(int paramInt1, List<DetectedActivity> paramList, long paramLong1, long paramLong2, int paramInt2)
  {
    mVersionCode = paramInt1;
    zzaQP = paramList;
    zzaQQ = paramLong1;
    zzaQR = paramLong2;
    zzaQS = paramInt2;
  }

  public int describeContents()
  {
    return 0;
  }

  public int getVersionCode()
  {
    return mVersionCode;
  }

  public String toString()
  {
    return "ActivityRecognitionResult [probableActivities=" + zzaQP + ", timeMillis=" + zzaQQ + ", elapsedRealtimeMillis=" + zzaQR + "]";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ActivityRecognitionResultCreator.zza(this, paramParcel, paramInt);
  }
}