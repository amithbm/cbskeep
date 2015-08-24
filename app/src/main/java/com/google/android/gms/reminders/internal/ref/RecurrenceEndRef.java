package com.google.android.gms.reminders.internal.ref;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.reminders.model.DateTime;
import com.google.android.gms.reminders.model.RecurrenceEnd;
import com.google.android.gms.reminders.model.RecurrenceEndEntity;

public class RecurrenceEndRef extends zza
  implements RecurrenceEnd
{
  private boolean zzbmK = false;
  private DateTimeRef zzbmL;
  private boolean zzbmM = false;
  private DateTimeRef zzbmN;

  public RecurrenceEndRef(DataHolder paramDataHolder, int paramInt, String paramString)
  {
    super(paramDataHolder, paramInt, paramString);
  }

  public static boolean zza(DataHolder paramDataHolder, int paramInt1, int paramInt2, String paramString)
  {
    return (DateTimeRef.zza(paramDataHolder, paramInt1, paramInt2, paramString + "recurrence_end_")) && (paramDataHolder.zzj(zzT(paramString, "recurrence_end_num_occurrences"), paramInt1, paramInt2)) && (paramDataHolder.zzj(zzT(paramString, "recurrence_end_auto_renew"), paramInt1, paramInt2)) && (DateTimeRef.zza(paramDataHolder, paramInt1, paramInt2, paramString + "recurrence_end_auto_renew_until_"));
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof RecurrenceEnd))
      return false;
    if (this == paramObject)
      return true;
    return RecurrenceEndEntity.zza(this, (RecurrenceEnd)paramObject);
  }

  public Boolean getAutoRenew()
  {
    return Boolean.valueOf(getBoolean(zzer("recurrence_end_auto_renew")));
  }

  public DateTime getAutoRenewUntil()
  {
    if (!zzbmM)
    {
      zzbmM = true;
      if (!DateTimeRef.zza(mDataHolder, zzaiZ, zzaja, zzbne + "recurrence_end_auto_renew_until_"))
        break label62;
    }
    label62: for (zzbmN = null; ; zzbmN = new DateTimeRef(mDataHolder, zzaiZ, zzbne + "recurrence_end_auto_renew_until_"))
      return zzbmN;
  }

  public DateTime getEndDateTime()
  {
    if (!zzbmK)
    {
      zzbmK = true;
      if (!DateTimeRef.zza(mDataHolder, zzaiZ, zzaja, zzbne + "recurrence_end_"))
        break label62;
    }
    label62: for (zzbmL = null; ; zzbmL = new DateTimeRef(mDataHolder, zzaiZ, zzbne + "recurrence_end_"))
      return zzbmL;
  }

  public Integer getNumOccurrences()
  {
    return getAsInteger(zzer("recurrence_end_num_occurrences"));
  }

  public int hashCode()
  {
    return RecurrenceEndEntity.zza(this);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    new RecurrenceEndEntity(this).writeToParcel(paramParcel, paramInt);
  }

  public RecurrenceEnd zzCl()
  {
    return new RecurrenceEndEntity(this);
  }
}