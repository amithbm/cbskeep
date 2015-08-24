package com.google.android.keep;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.net.Uri;
import android.util.Log;
import android.webkit.MimeTypeMap;
import com.google.android.gallery3d.exif.c;
import com.google.android.keep.util.e;
import java.io.FileNotFoundException;
import java.io.InputStream;

public final class h
{
  private static int a(c paramc)
  {
    paramc = paramc.e(c.v);
    if (paramc != null)
    {
      int j = paramc.intValue();
      int i = j;
      switch (j)
      {
      default:
        i = 1;
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      }
      return i;
    }
    return 1;
  }

  public static Bitmap a(Context paramContext, Uri paramUri, int paramInt)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inMutable = true;
    localOptions.inSampleSize = paramInt;
    return a(paramContext, paramUri, localOptions);
  }

  public static Bitmap a(Context paramContext, Uri paramUri, BitmapFactory.Options paramOptions)
  {
    if ((paramUri == null) || (paramContext == null))
      throw new IllegalArgumentException("bad argument to loadBitmap");
    Object localObject = null;
    Context localContext = null;
    try
    {
      paramContext = paramContext.getContentResolver().openInputStream(paramUri);
      localContext = paramContext;
      localObject = paramContext;
      paramOptions = BitmapFactory.decodeStream(paramContext, null, paramOptions);
      e.e(paramContext);
      return paramOptions;
    }
    catch (FileNotFoundException paramContext)
    {
      localObject = localContext;
      Log.e("ImageLoader", "FileNotFoundException for " + paramUri, paramContext);
      e.e(localContext);
      return null;
    }
    finally
    {
      e.e((InputStream)localObject);
    }
    throw paramContext;
  }

  public static Bitmap a(Uri paramUri, Context paramContext, int paramInt, Rect paramRect, boolean paramBoolean)
  {
    if ((paramInt <= 0) || (paramUri == null) || (paramContext == null))
      throw new IllegalArgumentException("bad argument to getScaledBitmap");
    Rect localRect = d(paramContext, paramUri);
    if (paramRect != null)
      paramRect.set(localRect);
    int k = localRect.width();
    int m = localRect.height();
    if ((k <= 0) || (m <= 0));
    int j;
    do
    {
      return null;
      if (paramBoolean);
      for (int i = Math.min(k, m); ; i = Math.max(k, m))
      {
        j = 1;
        while (i > paramInt)
        {
          i >>>= 1;
          j <<= 1;
        }
      }
    }
    while ((j <= 0) || (Math.min(k, m) / j <= 0));
    return a(paramContext, paramUri, j);
  }

  // ERROR //
  public static int b(Context paramContext, Uri paramUri)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +7 -> 8
    //   4: aload_0
    //   5: ifnonnull +13 -> 18
    //   8: new 44	java/lang/IllegalArgumentException
    //   11: dup
    //   12: ldc 135
    //   14: invokespecial 49	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   17: athrow
    //   18: aconst_null
    //   19: astore 7
    //   21: aconst_null
    //   22: astore 8
    //   24: aconst_null
    //   25: astore 9
    //   27: aconst_null
    //   28: astore 6
    //   30: aload_0
    //   31: invokevirtual 55	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   34: aload_1
    //   35: iconst_1
    //   36: anewarray 137	java/lang/String
    //   39: dup
    //   40: iconst_0
    //   41: ldc 139
    //   43: aastore
    //   44: aconst_null
    //   45: aconst_null
    //   46: aconst_null
    //   47: invokevirtual 143	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   50: astore 5
    //   52: aload 5
    //   54: ifnull +158 -> 212
    //   57: aload 5
    //   59: astore 6
    //   61: aload 5
    //   63: astore 7
    //   65: aload 5
    //   67: astore 8
    //   69: aload 5
    //   71: astore 9
    //   73: aload 5
    //   75: invokeinterface 149 1 0
    //   80: ifeq +132 -> 212
    //   83: aload 5
    //   85: astore 6
    //   87: aload 5
    //   89: astore 7
    //   91: aload 5
    //   93: astore 8
    //   95: aload 5
    //   97: astore 9
    //   99: aload 5
    //   101: iconst_0
    //   102: invokeinterface 153 2 0
    //   107: istore_2
    //   108: iload_2
    //   109: lookupswitch	default:+35->144, 90:+51->160, 180:+87->196, 270:+69->178
    //   145: iconst_2
    //   146: ifnull +10 -> 156
    //   149: aload 5
    //   151: invokeinterface 156 1 0
    //   156: iconst_1
    //   157: istore_2
    //   158: iload_2
    //   159: ireturn
    //   160: bipush 6
    //   162: istore_2
    //   163: aload 5
    //   165: ifnull -7 -> 158
    //   168: aload 5
    //   170: invokeinterface 156 1 0
    //   175: bipush 6
    //   177: ireturn
    //   178: bipush 8
    //   180: istore_2
    //   181: aload 5
    //   183: ifnull -25 -> 158
    //   186: aload 5
    //   188: invokeinterface 156 1 0
    //   193: bipush 8
    //   195: ireturn
    //   196: iconst_3
    //   197: istore_2
    //   198: aload 5
    //   200: ifnull -42 -> 158
    //   203: aload 5
    //   205: invokeinterface 156 1 0
    //   210: iconst_3
    //   211: ireturn
    //   212: aload 5
    //   214: ifnull +10 -> 224
    //   217: aload 5
    //   219: invokeinterface 156 1 0
    //   224: new 8	com/google/android/gallery3d/exif/c
    //   227: dup
    //   228: invokespecial 157	com/google/android/gallery3d/exif/c:<init>	()V
    //   231: astore 10
    //   233: aconst_null
    //   234: astore 7
    //   236: aconst_null
    //   237: astore 9
    //   239: aconst_null
    //   240: astore 8
    //   242: aload 7
    //   244: astore 6
    //   246: aload 9
    //   248: astore 5
    //   250: ldc 159
    //   252: aload_1
    //   253: invokevirtual 164	android/net/Uri:getScheme	()Ljava/lang/String;
    //   256: invokevirtual 168	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   259: ifeq +176 -> 435
    //   262: aload 7
    //   264: astore 6
    //   266: aload 9
    //   268: astore 5
    //   270: ldc 170
    //   272: aload_1
    //   273: invokestatic 174	com/google/android/keep/h:c	(Landroid/net/Uri;)Ljava/lang/String;
    //   276: invokevirtual 168	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   279: istore 4
    //   281: iload 4
    //   283: ifne +96 -> 379
    //   286: iconst_0
    //   287: ifeq +11 -> 298
    //   290: new 176	java/lang/NullPointerException
    //   293: dup
    //   294: invokespecial 177	java/lang/NullPointerException:<init>	()V
    //   297: athrow
    //   298: iconst_1
    //   299: ireturn
    //   300: astore 5
    //   302: aload 6
    //   304: ifnull -80 -> 224
    //   307: aload 6
    //   309: invokeinterface 156 1 0
    //   314: goto -90 -> 224
    //   317: astore 5
    //   319: aload 7
    //   321: ifnull -97 -> 224
    //   324: aload 7
    //   326: invokeinterface 156 1 0
    //   331: goto -107 -> 224
    //   334: astore 5
    //   336: aload 8
    //   338: ifnull -114 -> 224
    //   341: aload 8
    //   343: invokeinterface 156 1 0
    //   348: goto -124 -> 224
    //   351: astore_0
    //   352: aload 9
    //   354: ifnull +10 -> 364
    //   357: aload 9
    //   359: invokeinterface 156 1 0
    //   364: aload_0
    //   365: athrow
    //   366: astore_0
    //   367: ldc 74
    //   369: ldc 179
    //   371: aload_0
    //   372: invokestatic 182	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   375: pop
    //   376: goto -78 -> 298
    //   379: aload 7
    //   381: astore 6
    //   383: aload 9
    //   385: astore 5
    //   387: aload 10
    //   389: aload_1
    //   390: invokevirtual 185	android/net/Uri:getPath	()Ljava/lang/String;
    //   393: invokevirtual 187	com/google/android/gallery3d/exif/c:a	(Ljava/lang/String;)V
    //   396: aload 8
    //   398: astore_0
    //   399: aload_0
    //   400: astore 6
    //   402: aload_0
    //   403: astore 5
    //   405: aload 10
    //   407: invokestatic 189	com/google/android/keep/h:a	(Lcom/google/android/gallery3d/exif/c;)I
    //   410: istore_3
    //   411: iload_3
    //   412: istore_2
    //   413: aload_0
    //   414: ifnull -256 -> 158
    //   417: aload_0
    //   418: invokevirtual 192	java/io/InputStream:close	()V
    //   421: iload_3
    //   422: ireturn
    //   423: astore_0
    //   424: ldc 74
    //   426: ldc 179
    //   428: aload_0
    //   429: invokestatic 182	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   432: pop
    //   433: iload_3
    //   434: ireturn
    //   435: aload 7
    //   437: astore 6
    //   439: aload 9
    //   441: astore 5
    //   443: aload_0
    //   444: invokevirtual 55	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   447: aload_1
    //   448: invokevirtual 61	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   451: astore_0
    //   452: aload_0
    //   453: astore 6
    //   455: aload_0
    //   456: astore 5
    //   458: aload 10
    //   460: aload_0
    //   461: invokevirtual 194	com/google/android/gallery3d/exif/c:a	(Ljava/io/InputStream;)V
    //   464: goto -65 -> 399
    //   467: astore_0
    //   468: aload 6
    //   470: astore 5
    //   472: ldc 74
    //   474: ldc 196
    //   476: aload_0
    //   477: invokestatic 182	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   480: pop
    //   481: aload 6
    //   483: ifnull +8 -> 491
    //   486: aload 6
    //   488: invokevirtual 192	java/io/InputStream:close	()V
    //   491: iconst_1
    //   492: ireturn
    //   493: astore_0
    //   494: ldc 74
    //   496: ldc 179
    //   498: aload_0
    //   499: invokestatic 182	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   502: pop
    //   503: goto -12 -> 491
    //   506: astore_0
    //   507: aload 5
    //   509: ifnull +8 -> 517
    //   512: aload 5
    //   514: invokevirtual 192	java/io/InputStream:close	()V
    //   517: aload_0
    //   518: athrow
    //   519: astore_1
    //   520: ldc 74
    //   522: ldc 179
    //   524: aload_1
    //   525: invokestatic 182	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   528: pop
    //   529: goto -12 -> 517
    //
    // Exception table:
    //   from	to	target	type
    //   30	52	300	android/database/sqlite/SQLiteException
    //   73	83	300	android/database/sqlite/SQLiteException
    //   99	108	300	android/database/sqlite/SQLiteException
    //   30	52	317	java/lang/IllegalArgumentException
    //   73	83	317	java/lang/IllegalArgumentException
    //   99	108	317	java/lang/IllegalArgumentException
    //   30	52	334	java/lang/IllegalStateException
    //   73	83	334	java/lang/IllegalStateException
    //   99	108	334	java/lang/IllegalStateException
    //   30	52	351	finally
    //   73	83	351	finally
    //   99	108	351	finally
    //   290	298	366	java/io/IOException
    //   417	421	423	java/io/IOException
    //   250	262	467	java/io/IOException
    //   270	281	467	java/io/IOException
    //   387	396	467	java/io/IOException
    //   405	411	467	java/io/IOException
    //   443	452	467	java/io/IOException
    //   458	464	467	java/io/IOException
    //   486	491	493	java/io/IOException
    //   250	262	506	finally
    //   270	281	506	finally
    //   387	396	506	finally
    //   405	411	506	finally
    //   443	452	506	finally
    //   458	464	506	finally
    //   472	481	506	finally
    //   512	517	519	java/io/IOException
  }

  public static int c(Context paramContext, Uri paramUri)
  {
    switch (b(paramContext, paramUri))
    {
    case 4:
    case 5:
    case 7:
    default:
      return 0;
    case 6:
      return 90;
    case 3:
      return 180;
    case 8:
    }
    return 270;
  }

  public static String c(Uri paramUri)
  {
    String str = MimeTypeMap.getFileExtensionFromUrl(paramUri.toString());
    paramUri = null;
    if (str != null)
      paramUri = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str);
    return paramUri;
  }

  public static Rect d(Context paramContext, Uri paramUri)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    a(paramContext, paramUri, localOptions);
    return new Rect(0, 0, localOptions.outWidth, localOptions.outHeight);
  }
}