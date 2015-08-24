package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class GestureRequest
  implements SafeParcelable
{
  public static final zzc CREATOR = new zzc();
  private static final List<Integer> zzaRo = Collections.unmodifiableList(Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(8), Integer.valueOf(9), Integer.valueOf(10), Integer.valueOf(11), Integer.valueOf(12), Integer.valueOf(13), Integer.valueOf(14), Integer.valueOf(15), Integer.valueOf(16), Integer.valueOf(17), Integer.valueOf(18), Integer.valueOf(19) }));
  private static final List<Integer> zzaRp = Collections.unmodifiableList(Arrays.asList(new Integer[] { Integer.valueOf(1) }));
  private static final List<Integer> zzaRq = Collections.unmodifiableList(Arrays.asList(new Integer[] { Integer.valueOf(2), Integer.valueOf(4), Integer.valueOf(6), Integer.valueOf(8), Integer.valueOf(10), Integer.valueOf(12), Integer.valueOf(14), Integer.valueOf(16), Integer.valueOf(18), Integer.valueOf(19) }));
  private static final List<Integer> zzaRr = Collections.unmodifiableList(Arrays.asList(new Integer[] { Integer.valueOf(3), Integer.valueOf(5), Integer.valueOf(7), Integer.valueOf(9), Integer.valueOf(11), Integer.valueOf(13), Integer.valueOf(15), Integer.valueOf(17) }));
  private final int mVersionCode;
  private final List<Integer> zzaRs;

  GestureRequest(int paramInt, List<Integer> paramList)
  {
    mVersionCode = paramInt;
    zzaRs = paramList;
  }

  public int describeContents()
  {
    return 0;
  }

  public List<Integer> getGestureTypes()
  {
    return zzaRs;
  }

  public int getVersionCode()
  {
    return mVersionCode;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
}