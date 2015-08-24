package com.google.android.gms.reminders.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;

public class CustomizedSnoozePresetEntity
  implements SafeParcelable, CustomizedSnoozePreset
{
  public static final Parcelable.Creator<CustomizedSnoozePresetEntity> CREATOR = new zzd();
  public final int mVersionCode;
  private final TimeEntity zzbnG;
  private final TimeEntity zzbnH;
  private final TimeEntity zzbnI;

  CustomizedSnoozePresetEntity(int paramInt, TimeEntity paramTimeEntity1, TimeEntity paramTimeEntity2, TimeEntity paramTimeEntity3)
  {
    zzbnG = paramTimeEntity1;
    zzbnH = paramTimeEntity2;
    zzbnI = paramTimeEntity3;
    mVersionCode = paramInt;
  }

  CustomizedSnoozePresetEntity(Time paramTime1, Time paramTime2, Time paramTime3, boolean paramBoolean)
  {
    mVersionCode = 2;
    if (paramBoolean)
    {
      zzbnG = ((TimeEntity)paramTime1);
      zzbnH = ((TimeEntity)paramTime2);
      zzbnI = ((TimeEntity)paramTime3);
      return;
    }
    if (paramTime1 == null)
    {
      paramTime1 = null;
      zzbnG = paramTime1;
      if (paramTime2 != null)
        break label89;
      paramTime1 = null;
      label59: zzbnH = paramTime1;
      if (paramTime3 != null)
        break label101;
    }
    label89: label101: for (paramTime1 = localObject; ; paramTime1 = new TimeEntity(paramTime3))
    {
      zzbnI = paramTime1;
      return;
      paramTime1 = new TimeEntity(paramTime1);
      break;
      paramTime1 = new TimeEntity(paramTime2);
      break label59;
    }
  }

  public static boolean zza(CustomizedSnoozePreset paramCustomizedSnoozePreset1, CustomizedSnoozePreset paramCustomizedSnoozePreset2)
  {
    return (zzu.equal(paramCustomizedSnoozePreset1.getMorningCustomizedTime(), paramCustomizedSnoozePreset2.getMorningCustomizedTime())) && (zzu.equal(paramCustomizedSnoozePreset1.getAfternoonCustomizedTime(), paramCustomizedSnoozePreset2.getAfternoonCustomizedTime())) && (zzu.equal(paramCustomizedSnoozePreset1.getEveningCustomizedTime(), paramCustomizedSnoozePreset2.getEveningCustomizedTime()));
  }

  public static int zzb(CustomizedSnoozePreset paramCustomizedSnoozePreset)
  {
    return zzu.hashCode(new Object[] { paramCustomizedSnoozePreset.getMorningCustomizedTime(), paramCustomizedSnoozePreset.getAfternoonCustomizedTime(), paramCustomizedSnoozePreset.getEveningCustomizedTime() });
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof CustomizedSnoozePreset))
      return false;
    if (this == paramObject)
      return true;
    return zza(this, (CustomizedSnoozePreset)paramObject);
  }

  public Time getAfternoonCustomizedTime()
  {
    return zzbnH;
  }

  public Time getEveningCustomizedTime()
  {
    return zzbnI;
  }

  public Time getMorningCustomizedTime()
  {
    return zzbnG;
  }

  public int hashCode()
  {
    return zzb(this);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzd.zza(this, paramParcel, paramInt);
  }

  public CustomizedSnoozePreset zzCu()
  {
    return this;
  }
}