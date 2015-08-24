package com.google.android.gms.reminders.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;

public class TaskIdEntity
  implements SafeParcelable, TaskId
{
  public static final Parcelable.Creator<TaskIdEntity> CREATOR = new zzr();
  public final int mVersionCode;
  private final Long zzbpv;
  private final String zzbpw;
  private final String zzbpx;

  TaskIdEntity(int paramInt, Long paramLong, String paramString1, String paramString2)
  {
    zzbpv = paramLong;
    zzbpw = paramString1;
    zzbpx = paramString2;
    mVersionCode = paramInt;
  }

  public TaskIdEntity(TaskId paramTaskId)
  {
    this(paramTaskId.getServerAssignedId(), paramTaskId.getClientAssignedId(), paramTaskId.getClientAssignedThreadId(), false);
  }

  TaskIdEntity(Long paramLong, String paramString1, String paramString2, boolean paramBoolean)
  {
    this(1, paramLong, paramString1, paramString2);
  }

  public static int zza(TaskId paramTaskId)
  {
    return zzu.hashCode(new Object[] { paramTaskId.getServerAssignedId(), paramTaskId.getClientAssignedId(), paramTaskId.getClientAssignedThreadId() });
  }

  public static boolean zza(TaskId paramTaskId1, TaskId paramTaskId2)
  {
    return (zzu.equal(paramTaskId1.getServerAssignedId(), paramTaskId2.getServerAssignedId())) && (zzu.equal(paramTaskId1.getClientAssignedId(), paramTaskId2.getClientAssignedId())) && (zzu.equal(paramTaskId1.getClientAssignedThreadId(), paramTaskId2.getClientAssignedThreadId()));
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof TaskId))
      return false;
    if (this == paramObject)
      return true;
    return zza(this, (TaskId)paramObject);
  }

  public String getClientAssignedId()
  {
    return zzbpw;
  }

  public String getClientAssignedThreadId()
  {
    return zzbpx;
  }

  public Long getServerAssignedId()
  {
    return zzbpv;
  }

  public int hashCode()
  {
    return zza(this);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzr.zza(this, paramParcel, paramInt);
  }

  public TaskId zzCp()
  {
    return this;
  }
}