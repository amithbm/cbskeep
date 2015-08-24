package com.google.android.gms.people.accountswitcherview;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.ParcelFileDescriptor;
import android.support.v4.app.ActivityManagerCompat;
import android.util.Log;
import android.widget.ImageView;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.people.PeopleClientUtil;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

public class OwnersImageManager
{
  public static volatile Executor IMAGE_LOAD_TASK_EXECUTOR = null;
  private static boolean sIsLowMemoryDevice;
  public final GoogleApiClient mClient;
  private boolean mClosed;
  public final Context mContext;
  private final ConcurrentHashMap<String, Bitmap> mImages = new ConcurrentHashMap();
  private final LinkedList<OwnerImageRequest> mPendingRequests = new LinkedList();
  private float mRatioHeight;
  private float mRatioWidth;
  private OwnerImageRequest mRunningRequest;
  private boolean mUseCircularAvatar;

  static
  {
    initializeExecutor();
  }

  public OwnersImageManager(Context paramContext, GoogleApiClient paramGoogleApiClient, boolean paramBoolean)
  {
    mContext = paramContext;
    mClient = paramGoogleApiClient;
    mUseCircularAvatar = paramBoolean;
    paramGoogleApiClient = paramContext.getResources();
    mRatioWidth = paramGoogleApiClient.getInteger(R.integer.cover_photo_ratio_width);
    mRatioHeight = paramGoogleApiClient.getInteger(R.integer.cover_photo_ratio_height);
    sIsLowMemoryDevice = ActivityManagerCompat.isLowRamDevice((ActivityManager)paramContext.getSystemService("activity"));
  }

  public static int calculateInSampleSize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i;
    if (sIsLowMemoryDevice)
      i = 2;
    int j;
    do
    {
      return i;
      j = 1;
      i = 1;
    }
    while ((paramInt1 <= paramInt4) && (paramInt2 <= paramInt3));
    int k = paramInt1 / 2;
    paramInt2 /= 2;
    paramInt1 = j;
    while (true)
    {
      i = paramInt1;
      if (k / paramInt1 < paramInt4)
        break;
      i = paramInt1;
      if (paramInt2 / paramInt1 < paramInt3)
        break;
      paramInt1 *= 2;
    }
  }

  public static Bitmap centerCrop(Bitmap paramBitmap, int paramInt, float paramFloat)
  {
    return crop(paramBitmap, paramInt, (int)(paramInt * paramFloat), 0.5F, 0.5F);
  }

  private static void closeQuietly(InputStream paramInputStream)
  {
    try
    {
      paramInputStream.close();
      return;
    }
    catch (IOException paramInputStream)
    {
      Log.d("AvatarManager", "Exception closing the cover photo input stream.");
    }
  }

  public static Bitmap crop(Bitmap paramBitmap, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    if ((paramFloat1 < 0.0F) || (paramFloat1 > 1.0F) || (paramFloat2 < 0.0F) || (paramFloat2 > 1.0F))
      throw new IllegalArgumentException("horizontalCenterPercent and verticalCenterPercent must be between 0.0f and 1.0f, inclusive.");
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    if ((paramInt1 == i) && (paramInt2 == j))
      return paramBitmap;
    Matrix localMatrix = new Matrix();
    float f = Math.max(paramInt1 / i, paramInt2 / j);
    localMatrix.setScale(f, f);
    paramInt1 = Math.round(paramInt1 / f);
    paramInt2 = Math.round(paramInt2 / f);
    int k = (int)(i * paramFloat1 - paramInt1 / 2);
    int m = (int)(j * paramFloat2 - paramInt2 / 2);
    return Bitmap.createBitmap(paramBitmap, Math.max(Math.min(k, i - paramInt1), 0), Math.max(Math.min(m, j - paramInt2), 0), paramInt1, paramInt2, localMatrix, true);
  }

  // ERROR //
  public static Bitmap decodeFileDescriptor(ParcelFileDescriptor paramParcelFileDescriptor, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: ifnonnull +8 -> 12
    //   7: aload 5
    //   9: astore_0
    //   10: aload_0
    //   11: areturn
    //   12: new 182	android/graphics/BitmapFactory$Options
    //   15: dup
    //   16: invokespecial 183	android/graphics/BitmapFactory$Options:<init>	()V
    //   19: astore 5
    //   21: aload 5
    //   23: iload_1
    //   24: iload_2
    //   25: iload_3
    //   26: iload 4
    //   28: invokestatic 185	com/google/android/gms/people/accountswitcherview/OwnersImageManager:calculateInSampleSize	(IIII)I
    //   31: putfield 188	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   34: aload 5
    //   36: iconst_0
    //   37: putfield 191	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   40: aload 5
    //   42: iload_1
    //   43: putfield 194	android/graphics/BitmapFactory$Options:outWidth	I
    //   46: aload 5
    //   48: iload_2
    //   49: putfield 197	android/graphics/BitmapFactory$Options:outHeight	I
    //   52: getstatic 100	com/google/android/gms/people/accountswitcherview/OwnersImageManager:sIsLowMemoryDevice	Z
    //   55: ifeq +11 -> 66
    //   58: aload 5
    //   60: getstatic 203	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   63: putfield 206	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   66: aconst_null
    //   67: astore 7
    //   69: new 208	java/io/FileInputStream
    //   72: dup
    //   73: aload_0
    //   74: invokevirtual 214	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   77: invokespecial 217	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   80: astore 6
    //   82: aload 6
    //   84: aconst_null
    //   85: aload 5
    //   87: invokestatic 223	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   90: astore 5
    //   92: aload 5
    //   94: astore_0
    //   95: aload 6
    //   97: ifnull -87 -> 10
    //   100: aload 6
    //   102: invokestatic 225	com/google/android/gms/people/accountswitcherview/OwnersImageManager:closeQuietly	(Ljava/io/InputStream;)V
    //   105: aload 5
    //   107: areturn
    //   108: astore 5
    //   110: aload 7
    //   112: astore_0
    //   113: aload_0
    //   114: ifnull +7 -> 121
    //   117: aload_0
    //   118: invokestatic 225	com/google/android/gms/people/accountswitcherview/OwnersImageManager:closeQuietly	(Ljava/io/InputStream;)V
    //   121: aload 5
    //   123: athrow
    //   124: astore 5
    //   126: aload 6
    //   128: astore_0
    //   129: goto -16 -> 113
    //
    // Exception table:
    //   from	to	target	type
    //   69	82	108	finally
    //   82	92	124	finally
  }

  private void enqueueRequest(ImageView paramImageView, OwnerImageRequest paramOwnerImageRequest)
  {
    removePendingRequest(paramImageView);
    if (!mClient.isConnected())
    {
      Log.d("AvatarManager", "Client not connected.");
      return;
    }
    paramImageView.setTag(paramOwnerImageRequest);
    mPendingRequests.add(paramOwnerImageRequest);
    processNextRequestIfIdle();
  }

  @SuppressLint({"NewApi"})
  private void executeLoader(PfdLoader paramPfdLoader)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      paramPfdLoader.executeOnExecutor(IMAGE_LOAD_TASK_EXECUTOR, new Void[0]);
      return;
    }
    paramPfdLoader.execute((Void[])null);
  }

  @SuppressLint({"NewApi"})
  private static void initializeExecutor()
  {
    if (Build.VERSION.SDK_INT >= 11)
      IMAGE_LOAD_TASK_EXECUTOR = AsyncTask.THREAD_POOL_EXECUTOR;
  }

  private void processNextRequestIfIdle()
  {
    if (mPendingRequests.isEmpty());
    while ((mRunningRequest != null) && (!mRunningRequest.canceled))
      return;
    mRunningRequest = ((OwnerImageRequest)mPendingRequests.remove());
    mRunningRequest.load();
  }

  public void close()
  {
    if (mRunningRequest != null)
      mRunningRequest.canceled = true;
    mPendingRequests.clear();
    mClosed = true;
  }

  public void loadImageRequest(OwnerImageRequest paramOwnerImageRequest)
  {
    if (mImages.containsKey(paramOwnerImageRequest.accountName))
    {
      paramOwnerImageRequest.view.setImageBitmap((Bitmap)mImages.get(paramOwnerImageRequest.accountName));
      removePendingRequest(paramOwnerImageRequest.view);
      return;
    }
    enqueueRequest(paramOwnerImageRequest.view, paramOwnerImageRequest);
  }

  // ERROR //
  public void onImageLoaded(Status paramStatus, ParcelFileDescriptor paramParcelFileDescriptor, int paramInt1, int paramInt2, int paramInt3, OwnerImageRequest paramOwnerImageRequest)
  {
    // Byte code:
    //   0: aload_2
    //   1: astore 8
    //   3: aload_0
    //   4: getfield 285	com/google/android/gms/people/accountswitcherview/OwnersImageManager:mRunningRequest	Lcom/google/android/gms/people/accountswitcherview/OwnersImageManager$OwnerImageRequest;
    //   7: aload 6
    //   9: if_acmpeq +34 -> 43
    //   12: ldc 127
    //   14: ldc_w 327
    //   17: invokestatic 330	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   20: pop
    //   21: aload_0
    //   22: getfield 300	com/google/android/gms/people/accountswitcherview/OwnersImageManager:mClosed	Z
    //   25: ifne +7 -> 32
    //   28: aload_0
    //   29: invokespecial 252	com/google/android/gms/people/accountswitcherview/OwnersImageManager:processNextRequestIfIdle	()V
    //   32: aload 8
    //   34: ifnull +8 -> 42
    //   37: aload 8
    //   39: invokevirtual 331	android/os/ParcelFileDescriptor:close	()V
    //   42: return
    //   43: aload_0
    //   44: aconst_null
    //   45: putfield 285	com/google/android/gms/people/accountswitcherview/OwnersImageManager:mRunningRequest	Lcom/google/android/gms/people/accountswitcherview/OwnersImageManager$OwnerImageRequest;
    //   48: aload_0
    //   49: getfield 300	com/google/android/gms/people/accountswitcherview/OwnersImageManager:mClosed	Z
    //   52: istore 7
    //   54: iload 7
    //   56: ifeq +27 -> 83
    //   59: aload_0
    //   60: getfield 300	com/google/android/gms/people/accountswitcherview/OwnersImageManager:mClosed	Z
    //   63: ifne +7 -> 70
    //   66: aload_0
    //   67: invokespecial 252	com/google/android/gms/people/accountswitcherview/OwnersImageManager:processNextRequestIfIdle	()V
    //   70: aload 8
    //   72: ifnull -30 -> 42
    //   75: aload 8
    //   77: invokevirtual 331	android/os/ParcelFileDescriptor:close	()V
    //   80: return
    //   81: astore_1
    //   82: return
    //   83: aload 6
    //   85: getfield 313	com/google/android/gms/people/accountswitcherview/OwnersImageManager$OwnerImageRequest:view	Landroid/widget/ImageView;
    //   88: invokevirtual 334	android/widget/ImageView:getTag	()Ljava/lang/Object;
    //   91: aload 6
    //   93: if_acmpne +15 -> 108
    //   96: aload 6
    //   98: getfield 288	com/google/android/gms/people/accountswitcherview/OwnersImageManager$OwnerImageRequest:canceled	Z
    //   101: istore 7
    //   103: iload 7
    //   105: ifeq +27 -> 132
    //   108: aload_0
    //   109: getfield 300	com/google/android/gms/people/accountswitcherview/OwnersImageManager:mClosed	Z
    //   112: ifne +7 -> 119
    //   115: aload_0
    //   116: invokespecial 252	com/google/android/gms/people/accountswitcherview/OwnersImageManager:processNextRequestIfIdle	()V
    //   119: aload 8
    //   121: ifnull -79 -> 42
    //   124: aload 8
    //   126: invokevirtual 331	android/os/ParcelFileDescriptor:close	()V
    //   129: return
    //   130: astore_1
    //   131: return
    //   132: aload_1
    //   133: invokevirtual 339	com/google/android/gms/common/api/Status:isSuccess	()Z
    //   136: ifeq +7 -> 143
    //   139: aload_2
    //   140: ifnonnull +39 -> 179
    //   143: ldc 127
    //   145: new 341	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 342	java/lang/StringBuilder:<init>	()V
    //   152: ldc_w 344
    //   155: invokevirtual 348	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: aload_1
    //   159: invokevirtual 351	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   162: ldc_w 353
    //   165: invokevirtual 348	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: aload_2
    //   169: invokevirtual 351	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   172: invokevirtual 357	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokestatic 135	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   178: pop
    //   179: aload 8
    //   181: astore_1
    //   182: aload_2
    //   183: ifnull +25 -> 208
    //   186: aload_0
    //   187: new 9	com/google/android/gms/people/accountswitcherview/OwnersImageManager$PfdLoader
    //   190: dup
    //   191: aload_0
    //   192: aload 6
    //   194: aload_2
    //   195: iload_3
    //   196: iload 4
    //   198: iload 5
    //   200: invokespecial 360	com/google/android/gms/people/accountswitcherview/OwnersImageManager$PfdLoader:<init>	(Lcom/google/android/gms/people/accountswitcherview/OwnersImageManager;Lcom/google/android/gms/people/accountswitcherview/OwnersImageManager$OwnerImageRequest;Landroid/os/ParcelFileDescriptor;III)V
    //   203: invokespecial 362	com/google/android/gms/people/accountswitcherview/OwnersImageManager:executeLoader	(Lcom/google/android/gms/people/accountswitcherview/OwnersImageManager$PfdLoader;)V
    //   206: aconst_null
    //   207: astore_1
    //   208: aload_0
    //   209: getfield 300	com/google/android/gms/people/accountswitcherview/OwnersImageManager:mClosed	Z
    //   212: ifne +7 -> 219
    //   215: aload_0
    //   216: invokespecial 252	com/google/android/gms/people/accountswitcherview/OwnersImageManager:processNextRequestIfIdle	()V
    //   219: aload_1
    //   220: ifnull -178 -> 42
    //   223: aload_1
    //   224: invokevirtual 331	android/os/ParcelFileDescriptor:close	()V
    //   227: return
    //   228: astore_1
    //   229: return
    //   230: astore_1
    //   231: aload_0
    //   232: getfield 300	com/google/android/gms/people/accountswitcherview/OwnersImageManager:mClosed	Z
    //   235: ifne +7 -> 242
    //   238: aload_0
    //   239: invokespecial 252	com/google/android/gms/people/accountswitcherview/OwnersImageManager:processNextRequestIfIdle	()V
    //   242: aload 8
    //   244: ifnull +8 -> 252
    //   247: aload 8
    //   249: invokevirtual 331	android/os/ParcelFileDescriptor:close	()V
    //   252: aload_1
    //   253: athrow
    //   254: astore_1
    //   255: return
    //   256: astore_2
    //   257: goto -5 -> 252
    //
    // Exception table:
    //   from	to	target	type
    //   75	80	81	java/io/IOException
    //   124	129	130	java/io/IOException
    //   223	227	228	java/io/IOException
    //   3	21	230	finally
    //   43	54	230	finally
    //   83	103	230	finally
    //   132	139	230	finally
    //   143	179	230	finally
    //   186	206	230	finally
    //   37	42	254	java/io/IOException
    //   247	252	256	java/io/IOException
  }

  public void onImageLoaded(Status paramStatus, ParcelFileDescriptor paramParcelFileDescriptor, OwnerImageRequest paramOwnerImageRequest, int paramInt)
  {
    onImageLoaded(paramStatus, paramParcelFileDescriptor, -1, -1, paramInt, paramOwnerImageRequest);
  }

  public void removePendingRequest(ImageView paramImageView)
  {
    paramImageView.setTag(null);
    int i = 0;
    while (i < mPendingRequests.size())
      if (((OwnerImageRequest)mPendingRequests.get(i)).view == paramImageView)
        mPendingRequests.remove(i);
      else
        i += 1;
    if ((mRunningRequest != null) && (mRunningRequest.view == paramImageView))
    {
      mRunningRequest.canceled = true;
      processNextRequestIfIdle();
    }
  }

  protected void setImageBitmap(OwnerImageRequest paramOwnerImageRequest, Bitmap paramBitmap)
  {
    if (paramBitmap != null)
      paramOwnerImageRequest.view.setImageBitmap(paramBitmap);
  }

  protected abstract class OwnerImageRequest
  {
    public String accountName;
    public boolean canceled;
    public ImageView view;

    protected OwnerImageRequest()
    {
    }

    public abstract void load();
  }

  private class PfdLoader extends AsyncTask<Void, Void, Bitmap>
  {
    final ParcelFileDescriptor mPfd;
    final int mRawHeight;
    final int mRawWidth;
    final OwnersImageManager.OwnerImageRequest mRequest;
    final int mTargetWidth;

    PfdLoader(OwnersImageManager.OwnerImageRequest paramParcelFileDescriptor, ParcelFileDescriptor paramInt1, int paramInt2, int paramInt3, int arg6)
    {
      mRequest = paramParcelFileDescriptor;
      mPfd = paramInt1;
      mRawWidth = paramInt2;
      mRawHeight = paramInt3;
      int i;
      mTargetWidth = i;
    }

    protected Bitmap doInBackground(Void[] paramArrayOfVoid)
    {
      try
      {
        if (mUseCircularAvatar)
        {
          paramArrayOfVoid = PeopleClientUtil.decodeFileDescriptor(mPfd);
          if (paramArrayOfVoid == null)
            paramArrayOfVoid = null;
        }
        while (true)
        {
          if (paramArrayOfVoid != null)
            mImages.put(mRequest.accountName, paramArrayOfVoid);
          if (mPfd != null);
          try
          {
            mPfd.close();
            return paramArrayOfVoid;
            paramArrayOfVoid = ImageUtils.frameBitmapInCircle(paramArrayOfVoid);
            continue;
            paramArrayOfVoid = OwnersImageManager.decodeFileDescriptor(mPfd, mRawWidth, mRawHeight, mTargetWidth, (int)(mRawWidth * mRatioHeight / mRatioWidth));
            if (paramArrayOfVoid == null)
              paramArrayOfVoid = null;
            else
              paramArrayOfVoid = OwnersImageManager.centerCrop(paramArrayOfVoid, mRawWidth, mRatioHeight / mRatioWidth);
          }
          catch (IOException localIOException1)
          {
            Log.d("OwnersImageManager", localIOException1.getMessage());
            return paramArrayOfVoid;
          }
        }
      }
      finally
      {
        if (mPfd == null);
      }
      try
      {
        mPfd.close();
        throw paramArrayOfVoid;
      }
      catch (IOException localIOException2)
      {
        while (true)
          Log.d("OwnersImageManager", localIOException2.getMessage());
      }
    }

    protected void onPostExecute(Bitmap paramBitmap)
    {
      if (mRequest.view.getTag() != mRequest)
        return;
      setImageBitmap(mRequest, paramBitmap);
    }
  }
}