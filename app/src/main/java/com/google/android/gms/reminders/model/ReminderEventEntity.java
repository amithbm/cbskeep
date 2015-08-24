package com.google.android.gms.reminders.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ReminderEventEntity
  implements Parcelable, ReminderEvent
{
  public static final Parcelable.Creator<ReminderEventEntity> CREATOR = new Parcelable.Creator()
  {
    public ReminderEventEntity zzkU(Parcel paramAnonymousParcel)
    {
      return new ReminderEventEntity(paramAnonymousParcel, null);
    }

    public ReminderEventEntity[] zzoy(int paramAnonymousInt)
    {
      return new ReminderEventEntity[paramAnonymousInt];
    }
  };
  private final int zzOu;
  private final String zzQt;
  private final Task zzboT;

  private ReminderEventEntity(Parcel paramParcel)
  {
    zzOu = paramParcel.readInt();
    zzboT = ((Task)paramParcel.readParcelable(Task.class.getClassLoader()));
    zzQt = paramParcel.readString();
  }

  public ReminderEventEntity(ReminderEvent paramReminderEvent)
  {
    zzOu = paramReminderEvent.getType();
    zzboT = ((Task)paramReminderEvent.getTask().freeze());
    zzQt = paramReminderEvent.getAccountName();
  }

  public int describeContents()
  {
    return 0;
  }

  public String getAccountName()
  {
    return zzQt;
  }

  public Task getTask()
  {
    return zzboT;
  }

  public int getType()
  {
    return zzOu;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(zzOu);
    paramParcel.writeParcelable(zzboT, paramInt);
    paramParcel.writeString(zzQt);
  }

  public ReminderEvent zzBZ()
  {
    return this;
  }
}