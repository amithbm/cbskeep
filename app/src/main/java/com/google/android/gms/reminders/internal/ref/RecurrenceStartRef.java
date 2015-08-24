package com.google.android.gms.reminders.internal.ref;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.reminders.model.DateTime;
import com.google.android.gms.reminders.model.RecurrenceStart;
import com.google.android.gms.reminders.model.RecurrenceStartEntity;

public class RecurrenceStartRef extends zza
  implements RecurrenceStart
{
  private boolean zzbnc = false;
  private DateTimeRef zzbnd;

  public RecurrenceStartRef(DataHolder paramDataHolder, int paramInt, String paramString)
  {
    super(paramDataHolder, paramInt, paramString);
  }

  public static boolean zza(DataHolder paramDataHolder, int paramInt1, int paramInt2, String paramString)
  {
    return DateTimeRef.zza(paramDataHolder, paramInt1, paramInt2, paramString + "recurrence_start_");
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof RecurrenceStart))
      return false;
    if (this == paramObject)
      return true;
    return RecurrenceStartEntity.zza(this, (RecurrenceStart)paramObject);
  }

  public DateTime getStartDateTime()
  {
    if (!zzbnc)
    {
      zzbnc = true;
      if (!DateTimeRef.zza(mDataHolder, zzaiZ, zzaja, zzbne + "recurrence_start_"))
        break label62;
    }
    label62: for (zzbnd = null; ; zzbnd = new DateTimeRef(mDataHolder, zzaiZ, zzbne + "recurrence_start_"))
      return zzbnd;
  }

  public int hashCode()
  {
    return RecurrenceStartEntity.zza(this);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    new RecurrenceStartEntity(this).writeToParcel(paramParcel, paramInt);
  }

  public RecurrenceStart zzCo()
  {
    return new RecurrenceStartEntity(this);
  }
}