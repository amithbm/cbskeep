package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse.FieldConverter;

public class ConverterWrapper
  implements SafeParcelable
{
  public static final zza CREATOR = new zza();
  private final int mVersionCode;
  private final StringToIntConverter zzamM;

  ConverterWrapper(int paramInt, StringToIntConverter paramStringToIntConverter)
  {
    mVersionCode = paramInt;
    zzamM = paramStringToIntConverter;
  }

  private ConverterWrapper(StringToIntConverter paramStringToIntConverter)
  {
    mVersionCode = 1;
    zzamM = paramStringToIntConverter;
  }

  public static ConverterWrapper zza(FastJsonResponse.FieldConverter<?, ?> paramFieldConverter)
  {
    if ((paramFieldConverter instanceof StringToIntConverter))
      return new ConverterWrapper((StringToIntConverter)paramFieldConverter);
    throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
  }

  public int describeContents()
  {
    zza localzza = CREATOR;
    return 0;
  }

  int getVersionCode()
  {
    return mVersionCode;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza localzza = CREATOR;
    zza.zza(this, paramParcel, paramInt);
  }

  StringToIntConverter zzqj()
  {
    return zzamM;
  }

  public FastJsonResponse.FieldConverter<?, ?> zzqk()
  {
    if (zzamM != null)
      return zzamM;
    throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
  }
}