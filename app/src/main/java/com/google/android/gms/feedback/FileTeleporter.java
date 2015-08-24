package com.google.android.gms.feedback;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;

public class FileTeleporter
  implements SafeParcelable
{
  public static final Parcelable.Creator<FileTeleporter> CREATOR = new zzc();
  final int mVersionCode;
  ParcelFileDescriptor zzDy;
  final String zzaBw;
  final String zzaBx;
  private byte[] zzaBy;
  private File zzaiV;

  FileTeleporter(int paramInt, ParcelFileDescriptor paramParcelFileDescriptor, String paramString1, String paramString2)
  {
    mVersionCode = paramInt;
    zzDy = paramParcelFileDescriptor;
    zzaBw = paramString1;
    zzaBx = paramString2;
  }

  private void zza(Closeable paramCloseable)
  {
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable)
    {
      Log.w("FileTeleporter", "Could not close stream", paramCloseable);
    }
  }

  // ERROR //
  private java.io.FileOutputStream zzpf()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 65	com/google/android/gms/feedback/FileTeleporter:zzaiV	Ljava/io/File;
    //   4: ifnonnull +13 -> 17
    //   7: new 67	java/lang/IllegalStateException
    //   10: dup
    //   11: ldc 69
    //   13: invokespecial 72	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   16: athrow
    //   17: ldc 74
    //   19: ldc 76
    //   21: aload_0
    //   22: getfield 65	com/google/android/gms/feedback/FileTeleporter:zzaiV	Ljava/io/File;
    //   25: invokestatic 82	java/io/File:createTempFile	(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)Ljava/io/File;
    //   28: astore_1
    //   29: new 84	java/io/FileOutputStream
    //   32: dup
    //   33: aload_1
    //   34: invokespecial 87	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   37: astore_2
    //   38: aload_0
    //   39: aload_1
    //   40: ldc 88
    //   42: invokestatic 94	android/os/ParcelFileDescriptor:open	(Ljava/io/File;I)Landroid/os/ParcelFileDescriptor;
    //   45: putfield 36	com/google/android/gms/feedback/FileTeleporter:zzDy	Landroid/os/ParcelFileDescriptor;
    //   48: aload_1
    //   49: invokevirtual 98	java/io/File:delete	()Z
    //   52: pop
    //   53: aload_2
    //   54: areturn
    //   55: astore_1
    //   56: new 67	java/lang/IllegalStateException
    //   59: dup
    //   60: ldc 100
    //   62: aload_1
    //   63: invokespecial 103	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   66: athrow
    //   67: astore_1
    //   68: new 67	java/lang/IllegalStateException
    //   71: dup
    //   72: ldc 105
    //   74: invokespecial 72	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   77: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   17	29	55	java/io/IOException
    //   29	48	67	java/io/FileNotFoundException
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    DataOutputStream localDataOutputStream;
    if (zzDy == null)
      localDataOutputStream = new DataOutputStream(zzpf());
    try
    {
      localDataOutputStream.writeInt(zzaBy.length);
      localDataOutputStream.writeUTF(zzaBw);
      localDataOutputStream.writeUTF(zzaBx);
      localDataOutputStream.write(zzaBy);
      zza(localDataOutputStream);
      zzc.zza(this, paramParcel, paramInt);
      return;
    }
    catch (IOException paramParcel)
    {
      throw new IllegalStateException("Could not write into unlinked file", paramParcel);
    }
    finally
    {
      zza(localDataOutputStream);
    }
    throw paramParcel;
  }
}