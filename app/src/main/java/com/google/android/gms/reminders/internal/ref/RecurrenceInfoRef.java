package com.google.android.gms.reminders.internal.ref;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.reminders.model.Recurrence;
import com.google.android.gms.reminders.model.RecurrenceInfo;
import com.google.android.gms.reminders.model.RecurrenceInfoEntity;

public class RecurrenceInfoRef extends zza
  implements RecurrenceInfo
{
  private boolean zzbmO = false;
  private RecurrenceRef zzbmP;

  public RecurrenceInfoRef(DataHolder paramDataHolder, int paramInt, String paramString)
  {
    super(paramDataHolder, paramInt, paramString);
  }

  public static boolean zza(DataHolder paramDataHolder, int paramInt1, int paramInt2, String paramString)
  {
    return (RecurrenceRef.zza(paramDataHolder, paramInt1, paramInt2, paramString)) && (paramDataHolder.zzj(zzT(paramString, "recurrence_id"), paramInt1, paramInt2)) && (paramDataHolder.zzj(zzT(paramString, "recurrence_master"), paramInt1, paramInt2)) && (paramDataHolder.zzj(zzT(paramString, "recurrence_exceptional"), paramInt1, paramInt2));
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof RecurrenceInfo))
      return false;
    if (this == paramObject)
      return true;
    return RecurrenceInfoEntity.zza(this, (RecurrenceInfo)paramObject);
  }

  public Boolean getExceptional()
  {
    return Boolean.valueOf(getBoolean(zzer("recurrence_exceptional")));
  }

  public Boolean getMaster()
  {
    return Boolean.valueOf(getBoolean(zzer("recurrence_master")));
  }

  public Recurrence getRecurrence()
  {
    if (!zzbmO)
    {
      zzbmO = true;
      if (!RecurrenceRef.zza(mDataHolder, zzaiZ, zzaja, zzbne))
        break label44;
    }
    label44: for (zzbmP = null; ; zzbmP = new RecurrenceRef(mDataHolder, zzaiZ, zzbne))
      return zzbmP;
  }

  public String getRecurrenceId()
  {
    return getString(zzer("recurrence_id"));
  }

  public int hashCode()
  {
    return RecurrenceInfoEntity.zza(this);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    new RecurrenceInfoEntity(this).writeToParcel(paramParcel, paramInt);
  }

  public RecurrenceInfo zzCm()
  {
    return new RecurrenceInfoEntity(this);
  }
}