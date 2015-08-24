package com.google.android.gms.drive.events;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.List;
import java.util.Locale;

public final class CompletionEvent
  implements SafeParcelable, ResourceEvent
{
  public static final Parcelable.Creator<CompletionEvent> CREATOR = new zzd();
  final int mVersionCode;
  final String zzQt;
  private boolean zzVz = false;
  final DriveId zzasr;
  final ParcelFileDescriptor zzatg;
  final ParcelFileDescriptor zzath;
  final MetadataBundle zzati;
  final List<String> zzatj;
  final IBinder zzatk;
  private boolean zzatl = false;
  private boolean zzatm = false;
  final int zzxv;

  CompletionEvent(int paramInt1, DriveId paramDriveId, String paramString, ParcelFileDescriptor paramParcelFileDescriptor1, ParcelFileDescriptor paramParcelFileDescriptor2, MetadataBundle paramMetadataBundle, List<String> paramList, int paramInt2, IBinder paramIBinder)
  {
    mVersionCode = paramInt1;
    zzasr = paramDriveId;
    zzQt = paramString;
    zzatg = paramParcelFileDescriptor1;
    zzath = paramParcelFileDescriptor2;
    zzati = paramMetadataBundle;
    zzatj = paramList;
    zzxv = paramInt2;
    zzatk = paramIBinder;
  }

  public int describeContents()
  {
    return 0;
  }

  public String toString()
  {
    if (zzatj == null);
    for (String str = "<null>"; ; str = "'" + TextUtils.join("','", zzatj) + "'")
      return String.format(Locale.US, "CompletionEvent [id=%s, status=%s, trackingTag=%s]", new Object[] { zzasr, Integer.valueOf(zzxv), str });
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzd.zza(this, paramParcel, paramInt | 0x1);
  }
}