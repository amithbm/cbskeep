package com.google.android.gms.reminders;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzv;

public class UpdateRecurrenceOptions
  implements SafeParcelable
{
  public static final UpdateRecurrenceOptions ALL_INSTANCES_OPTION = new Builder().build();
  public static final Parcelable.Creator<UpdateRecurrenceOptions> CREATOR = new zze();
  public final int mVersionCode;
  private final boolean zzblM;
  private final int zzblS;
  private final Long zzblT;

  UpdateRecurrenceOptions(int paramInt, Integer paramInteger, Boolean paramBoolean, Long paramLong)
  {
    mVersionCode = paramInt;
    boolean bool1 = bool3;
    if (paramInteger != null)
    {
      bool1 = bool3;
      if (paramInteger.intValue() != 0)
      {
        if (paramInteger.intValue() != 1)
          break label85;
        bool1 = bool3;
      }
    }
    zzv.zzb(bool1, "Invalid update mode");
    if (paramInteger == null)
    {
      paramInt = 0;
      label59: zzblS = paramInt;
      if (paramBoolean != null)
        break label99;
    }
    label85: label99: for (bool1 = bool2; ; bool1 = paramBoolean.booleanValue())
    {
      zzblM = bool1;
      zzblT = paramLong;
      return;
      bool1 = false;
      break;
      paramInt = paramInteger.intValue();
      break label59;
    }
  }

  private UpdateRecurrenceOptions(Integer paramInteger, Boolean paramBoolean, Long paramLong)
  {
    this(1, paramInteger, paramBoolean, paramLong);
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean getExcludeExceptions()
  {
    return zzblM;
  }

  public Long getReferenceTimeMillis()
  {
    return zzblT;
  }

  public int getUpdateMode()
  {
    return zzblS;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zze.zza(this, paramParcel, paramInt);
  }

  public static class Builder
  {
    private Long zzblT;
    private Integer zzblU;
    private Boolean zzblV;

    public UpdateRecurrenceOptions build()
    {
      return new UpdateRecurrenceOptions(zzblU, zzblV, zzblT, null);
    }

    public Builder setExcludeExceptions(boolean paramBoolean)
    {
      zzblV = Boolean.valueOf(paramBoolean);
      return this;
    }

    public Builder setUpdateMode(int paramInt)
    {
      boolean bool2 = true;
      boolean bool1 = bool2;
      if (paramInt != 0)
        if (paramInt != 1)
          break label31;
      label31: for (bool1 = bool2; ; bool1 = false)
      {
        zzv.zzb(bool1, "Invalid updateMode");
        zzblU = Integer.valueOf(paramInt);
        return this;
      }
    }
  }
}