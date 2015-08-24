package com.google.android.gms.reminders;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class CreateReminderOptionsInternal
  implements SafeParcelable
{
  public static final Parcelable.Creator<CreateReminderOptionsInternal> CREATOR = new zzb();
  public static final CreateReminderOptionsInternal zzblC = new CreateReminderOptionsInternal(null, null, false);
  public final int mVersionCode;
  private final String zzblA;
  private final boolean zzblB;
  private final String zzblz;

  CreateReminderOptionsInternal(int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    mVersionCode = paramInt;
    zzblz = paramString1;
    zzblA = paramString2;
    zzblB = paramBoolean;
  }

  public CreateReminderOptionsInternal(String paramString1, String paramString2, boolean paramBoolean)
  {
    this(1, paramString1, paramString2, paramBoolean);
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }

  public boolean zzBU()
  {
    return zzblB;
  }

  public String zzBV()
  {
    return zzblz;
  }

  public String zzBW()
  {
    return zzblA;
  }
}