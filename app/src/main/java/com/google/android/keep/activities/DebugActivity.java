package com.google.android.keep.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.FileProvider;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.google.android.keep.util.e;
import com.google.android.keep.util.i;
import com.google.android.keep.util.r;
import java.io.File;

public class DebugActivity extends FragmentActivity
  implements View.OnClickListener
{
  private static String TAG = "Keep";
  private Button db;
  private Button dc;

  private void U()
  {
    r.c(TAG, "Deleting keep.db.zip", new Object[0]);
    V().delete();
  }

  private File V()
  {
    return new File(new File(getFilesDir(), "debug"), "keep.db.zip");
  }

  private void a(File paramFile)
  {
    r.c(TAG, "Drafting email to send " + paramFile.getAbsolutePath(), new Object[0]);
    Intent localIntent = new Intent("android.intent.action.SEND");
    localIntent.putExtra("android.intent.extra.SUBJECT", getString(2131231042));
    localIntent.putExtra("android.intent.extra.TEXT", getString(2131231043));
    localIntent.setType("application/zip");
    localIntent.putExtra("android.intent.extra.STREAM", FileProvider.getUriForFile(this, "com.google.android.keep.debug", paramFile));
    localIntent.setFlags(1);
    startActivityForResult(Intent.createChooser(localIntent, getString(2131231041)), 9);
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 9)
    {
      r.c(TAG, "On activity result:" + paramInt2, new Object[0]);
      db.setEnabled(true);
      dc.setEnabled(true);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
      return;
    case 2131493146:
      db.setEnabled(false);
      dc.setEnabled(false);
      new a(null).execute(new Void[0]);
      return;
    case 2131493147:
    }
    U();
    finish();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (!i.L(this))
    {
      finish();
      return;
    }
    if (!KeepApplication.ae())
    {
      e.b(this, 2131231037);
      finish();
      return;
    }
    setContentView(2130968655);
    db = ((Button)findViewById(2131493146));
    dc = ((Button)findViewById(2131493147));
  }

  protected void onPause()
  {
    super.onPause();
    if (isFinishing())
      U();
  }

  private class a extends AsyncTask<Void, Void, File>
  {
    private a()
    {
    }

    // ERROR //
    protected File a(Void[] paramArrayOfVoid)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 10
      //   3: aconst_null
      //   4: astore 9
      //   6: aconst_null
      //   7: astore_1
      //   8: aconst_null
      //   9: astore 7
      //   11: aconst_null
      //   12: astore 8
      //   14: aload 10
      //   16: astore 5
      //   18: aload_1
      //   19: astore 6
      //   21: new 26	java/io/File
      //   24: dup
      //   25: aload_0
      //   26: getfield 14	com/google/android/keep/activities/DebugActivity$a:dd	Lcom/google/android/keep/activities/DebugActivity;
      //   29: invokevirtual 30	com/google/android/keep/activities/DebugActivity:getFilesDir	()Ljava/io/File;
      //   32: ldc 32
      //   34: invokespecial 35	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   37: astore 11
      //   39: aload 10
      //   41: astore 5
      //   43: aload_1
      //   44: astore 6
      //   46: aload 11
      //   48: invokevirtual 39	java/io/File:mkdirs	()Z
      //   51: ifne +84 -> 135
      //   54: aload 10
      //   56: astore 5
      //   58: aload_1
      //   59: astore 6
      //   61: aload 11
      //   63: invokevirtual 42	java/io/File:isDirectory	()Z
      //   66: istore 4
      //   68: iload 4
      //   70: ifne +65 -> 135
      //   73: iconst_0
      //   74: ifeq +11 -> 85
      //   77: new 44	java/lang/NullPointerException
      //   80: dup
      //   81: invokespecial 45	java/lang/NullPointerException:<init>	()V
      //   84: athrow
      //   85: iconst_0
      //   86: ifeq +11 -> 97
      //   89: new 44	java/lang/NullPointerException
      //   92: dup
      //   93: invokespecial 45	java/lang/NullPointerException:<init>	()V
      //   96: athrow
      //   97: aconst_null
      //   98: areturn
      //   99: astore_1
      //   100: invokestatic 49	com/google/android/keep/activities/DebugActivity:W	()Ljava/lang/String;
      //   103: new 51	java/lang/StringBuilder
      //   106: dup
      //   107: invokespecial 52	java/lang/StringBuilder:<init>	()V
      //   110: ldc 54
      //   112: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   115: aload_1
      //   116: invokevirtual 61	java/io/IOException:toString	()Ljava/lang/String;
      //   119: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   122: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   125: iconst_0
      //   126: anewarray 64	java/lang/Object
      //   129: invokestatic 70	com/google/android/keep/util/r:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
      //   132: pop
      //   133: aconst_null
      //   134: areturn
      //   135: aload 10
      //   137: astore 5
      //   139: aload_1
      //   140: astore 6
      //   142: new 26	java/io/File
      //   145: dup
      //   146: aload 11
      //   148: ldc 72
      //   150: invokespecial 35	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   153: astore 11
      //   155: aload 10
      //   157: astore 5
      //   159: aload_1
      //   160: astore 6
      //   162: aload 11
      //   164: invokevirtual 75	java/io/File:delete	()Z
      //   167: pop
      //   168: aload 10
      //   170: astore 5
      //   172: aload_1
      //   173: astore 6
      //   175: invokestatic 49	com/google/android/keep/activities/DebugActivity:W	()Ljava/lang/String;
      //   178: new 51	java/lang/StringBuilder
      //   181: dup
      //   182: invokespecial 52	java/lang/StringBuilder:<init>	()V
      //   185: ldc 77
      //   187: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   190: aload 11
      //   192: invokevirtual 80	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   195: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   198: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   201: iconst_0
      //   202: anewarray 64	java/lang/Object
      //   205: invokestatic 83	com/google/android/keep/util/r:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
      //   208: pop
      //   209: aload 10
      //   211: astore 5
      //   213: aload_1
      //   214: astore 6
      //   216: aload_0
      //   217: getfield 14	com/google/android/keep/activities/DebugActivity$a:dd	Lcom/google/android/keep/activities/DebugActivity;
      //   220: ldc 85
      //   222: invokevirtual 89	com/google/android/keep/activities/DebugActivity:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
      //   225: astore 12
      //   227: aload 10
      //   229: astore 5
      //   231: aload_1
      //   232: astore 6
      //   234: new 91	java/io/FileInputStream
      //   237: dup
      //   238: aload 12
      //   240: invokespecial 94	java/io/FileInputStream:<init>	(Ljava/io/File;)V
      //   243: astore_1
      //   244: new 96	java/util/zip/ZipOutputStream
      //   247: dup
      //   248: new 98	java/io/FileOutputStream
      //   251: dup
      //   252: aload 11
      //   254: invokespecial 99	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
      //   257: invokespecial 102	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
      //   260: astore 5
      //   262: aload 5
      //   264: new 104	java/util/zip/ZipEntry
      //   267: dup
      //   268: aload 12
      //   270: invokevirtual 107	java/io/File:getName	()Ljava/lang/String;
      //   273: invokespecial 110	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
      //   276: invokevirtual 114	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
      //   279: sipush 4096
      //   282: newarray byte
      //   284: astore 6
      //   286: iconst_0
      //   287: istore_2
      //   288: aload_1
      //   289: aload 6
      //   291: invokevirtual 120	java/io/InputStream:read	([B)I
      //   294: istore_3
      //   295: iload_3
      //   296: ifgt +71 -> 367
      //   299: aload 5
      //   301: invokevirtual 123	java/util/zip/ZipOutputStream:closeEntry	()V
      //   304: invokestatic 49	com/google/android/keep/activities/DebugActivity:W	()Ljava/lang/String;
      //   307: new 51	java/lang/StringBuilder
      //   310: dup
      //   311: invokespecial 52	java/lang/StringBuilder:<init>	()V
      //   314: ldc 125
      //   316: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   319: iload_2
      //   320: invokevirtual 128	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   323: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   326: iconst_0
      //   327: anewarray 64	java/lang/Object
      //   330: invokestatic 83	com/google/android/keep/util/r:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
      //   333: pop
      //   334: aload 5
      //   336: invokevirtual 131	java/util/zip/ZipOutputStream:flush	()V
      //   339: aload 5
      //   341: invokevirtual 134	java/util/zip/ZipOutputStream:close	()V
      //   344: aload_1
      //   345: ifnull +7 -> 352
      //   348: aload_1
      //   349: invokevirtual 135	java/io/InputStream:close	()V
      //   352: iconst_0
      //   353: ifeq +11 -> 364
      //   356: new 44	java/lang/NullPointerException
      //   359: dup
      //   360: invokespecial 45	java/lang/NullPointerException:<init>	()V
      //   363: athrow
      //   364: aload 11
      //   366: areturn
      //   367: aload 5
      //   369: aload 6
      //   371: iconst_0
      //   372: iload_3
      //   373: invokevirtual 139	java/util/zip/ZipOutputStream:write	([BII)V
      //   376: iload_2
      //   377: iload_3
      //   378: iadd
      //   379: istore_2
      //   380: goto -92 -> 288
      //   383: astore_1
      //   384: invokestatic 49	com/google/android/keep/activities/DebugActivity:W	()Ljava/lang/String;
      //   387: new 51	java/lang/StringBuilder
      //   390: dup
      //   391: invokespecial 52	java/lang/StringBuilder:<init>	()V
      //   394: ldc 54
      //   396: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   399: aload_1
      //   400: invokevirtual 61	java/io/IOException:toString	()Ljava/lang/String;
      //   403: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   406: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   409: iconst_0
      //   410: anewarray 64	java/lang/Object
      //   413: invokestatic 70	com/google/android/keep/util/r:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
      //   416: pop
      //   417: goto -53 -> 364
      //   420: astore 7
      //   422: aload 9
      //   424: astore_1
      //   425: aload_1
      //   426: astore 5
      //   428: aload 8
      //   430: astore 6
      //   432: invokestatic 49	com/google/android/keep/activities/DebugActivity:W	()Ljava/lang/String;
      //   435: new 51	java/lang/StringBuilder
      //   438: dup
      //   439: invokespecial 52	java/lang/StringBuilder:<init>	()V
      //   442: ldc 54
      //   444: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   447: aload 7
      //   449: invokevirtual 61	java/io/IOException:toString	()Ljava/lang/String;
      //   452: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   455: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   458: iconst_0
      //   459: anewarray 64	java/lang/Object
      //   462: invokestatic 70	com/google/android/keep/util/r:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
      //   465: pop
      //   466: aload_1
      //   467: ifnull +7 -> 474
      //   470: aload_1
      //   471: invokevirtual 135	java/io/InputStream:close	()V
      //   474: aload 8
      //   476: ifnull +8 -> 484
      //   479: aload 8
      //   481: invokevirtual 134	java/util/zip/ZipOutputStream:close	()V
      //   484: aconst_null
      //   485: areturn
      //   486: astore_1
      //   487: invokestatic 49	com/google/android/keep/activities/DebugActivity:W	()Ljava/lang/String;
      //   490: new 51	java/lang/StringBuilder
      //   493: dup
      //   494: invokespecial 52	java/lang/StringBuilder:<init>	()V
      //   497: ldc 54
      //   499: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   502: aload_1
      //   503: invokevirtual 61	java/io/IOException:toString	()Ljava/lang/String;
      //   506: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   509: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   512: iconst_0
      //   513: anewarray 64	java/lang/Object
      //   516: invokestatic 70	com/google/android/keep/util/r:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
      //   519: pop
      //   520: goto -36 -> 484
      //   523: astore_1
      //   524: aload 5
      //   526: ifnull +8 -> 534
      //   529: aload 5
      //   531: invokevirtual 135	java/io/InputStream:close	()V
      //   534: aload 6
      //   536: ifnull +8 -> 544
      //   539: aload 6
      //   541: invokevirtual 134	java/util/zip/ZipOutputStream:close	()V
      //   544: aload_1
      //   545: athrow
      //   546: astore 5
      //   548: invokestatic 49	com/google/android/keep/activities/DebugActivity:W	()Ljava/lang/String;
      //   551: new 51	java/lang/StringBuilder
      //   554: dup
      //   555: invokespecial 52	java/lang/StringBuilder:<init>	()V
      //   558: ldc 54
      //   560: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   563: aload 5
      //   565: invokevirtual 61	java/io/IOException:toString	()Ljava/lang/String;
      //   568: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   571: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   574: iconst_0
      //   575: anewarray 64	java/lang/Object
      //   578: invokestatic 70	com/google/android/keep/util/r:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
      //   581: pop
      //   582: goto -38 -> 544
      //   585: astore 8
      //   587: aload_1
      //   588: astore 5
      //   590: aload 7
      //   592: astore 6
      //   594: aload 8
      //   596: astore_1
      //   597: goto -73 -> 524
      //   600: astore 7
      //   602: aload 5
      //   604: astore 6
      //   606: aload_1
      //   607: astore 5
      //   609: aload 7
      //   611: astore_1
      //   612: goto -88 -> 524
      //   615: astore 7
      //   617: goto -192 -> 425
      //   620: astore 7
      //   622: aload 5
      //   624: astore 8
      //   626: goto -201 -> 425
      //
      // Exception table:
      //   from	to	target	type
      //   77	85	99	java/io/IOException
      //   89	97	99	java/io/IOException
      //   348	352	383	java/io/IOException
      //   356	364	383	java/io/IOException
      //   21	39	420	java/io/IOException
      //   46	54	420	java/io/IOException
      //   61	68	420	java/io/IOException
      //   142	155	420	java/io/IOException
      //   162	168	420	java/io/IOException
      //   175	209	420	java/io/IOException
      //   216	227	420	java/io/IOException
      //   234	244	420	java/io/IOException
      //   470	474	486	java/io/IOException
      //   479	484	486	java/io/IOException
      //   21	39	523	finally
      //   46	54	523	finally
      //   61	68	523	finally
      //   142	155	523	finally
      //   162	168	523	finally
      //   175	209	523	finally
      //   216	227	523	finally
      //   234	244	523	finally
      //   432	466	523	finally
      //   529	534	546	java/io/IOException
      //   539	544	546	java/io/IOException
      //   244	262	585	finally
      //   262	286	600	finally
      //   288	295	600	finally
      //   299	344	600	finally
      //   367	376	600	finally
      //   244	262	615	java/io/IOException
      //   262	286	620	java/io/IOException
      //   288	295	620	java/io/IOException
      //   299	344	620	java/io/IOException
      //   367	376	620	java/io/IOException
    }

    protected void b(File paramFile)
    {
      if (paramFile != null)
      {
        DebugActivity.a(DebugActivity.this, paramFile);
        return;
      }
      r.e(DebugActivity.W(), "Cannot copy the database", new Object[0]);
    }
  }
}