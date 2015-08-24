package com.google.android.gms.reminders.internal.ref;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.reminders.model.TaskId;
import com.google.android.gms.reminders.model.TaskIdEntity;

public class TaskIdRef extends zza
  implements TaskId
{
  public TaskIdRef(DataHolder paramDataHolder, int paramInt, String paramString)
  {
    super(paramDataHolder, paramInt, paramString);
  }

  public static boolean zza(DataHolder paramDataHolder, int paramInt1, int paramInt2, String paramString)
  {
    return (paramDataHolder.zzj(zzT(paramString, "server_assigned_id"), paramInt1, paramInt2)) && (paramDataHolder.zzj(zzT(paramString, "client_assigned_id"), paramInt1, paramInt2)) && (paramDataHolder.zzj(zzT(paramString, "client_assigned_thread_id"), paramInt1, paramInt2));
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
    return TaskIdEntity.zza(this, (TaskId)paramObject);
  }

  public String getClientAssignedId()
  {
    return getString(zzer("client_assigned_id"));
  }

  public String getClientAssignedThreadId()
  {
    return getString(zzer("client_assigned_thread_id"));
  }

  public Long getServerAssignedId()
  {
    return getAsLong(zzer("server_assigned_id"));
  }

  public int hashCode()
  {
    return TaskIdEntity.zza(this);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    new TaskIdEntity(this).writeToParcel(paramParcel, paramInt);
  }

  public TaskId zzCp()
  {
    return new TaskIdEntity(this);
  }
}