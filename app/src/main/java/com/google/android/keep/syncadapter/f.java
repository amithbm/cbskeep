package com.google.android.keep.syncadapter;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.keep.provider.i.e;
import com.google.android.keep.util.r;
import org.json.JSONException;
import org.json.JSONObject;

public class f
{
  static int b(Context paramContext, String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      Log.e("KeepSync", "Empty error string or blob ID");
      return 0;
    }
    int i = paramString1.indexOf("{");
    if ((i == -1) || (i == paramString1.length() - 1))
    {
      Log.e("KeepSync", "Opening brace not found in error string or it's at the last position in the string");
      return 0;
    }
    paramString1 = paramString1.substring(i);
    try
    {
      paramString1 = Integer.valueOf(new JSONObject(paramString1).getInt("code"));
      r.a("KeepSync", "Error code from exception: " + paramString1, new Object[0]);
      if ((paramString1 == null) || (paramString1.intValue() / 100 != 4))
        return 0;
    }
    catch (JSONException paramContext)
    {
      Log.e("KeepSync", "JSON Parse exception for error " + paramContext);
      return 0;
    }
    catch (IndexOutOfBoundsException paramContext)
    {
      Log.e("KeepSync", "IndexOutOfBoundsException for error " + paramContext);
      return 0;
    }
    catch (NullPointerException paramContext)
    {
      Log.e("KeepSync", "NullPointerException for error " + paramContext);
      return 0;
    }
    paramString1 = new ContentValues();
    paramString1.put("is_dirty", Integer.valueOf(-1));
    i = paramContext.getContentResolver().update(i.e.BX, paramString1, "uuid=?", new String[] { String.valueOf(paramString2) });
    r.a("KeepSync", "handleMediaError() with rows affected: " + i, new Object[0]);
    return i;
  }

  // ERROR //
  static int f(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 18	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +15 -> 19
    //   7: ldc 20
    //   9: ldc 138
    //   11: invokestatic 28	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   14: pop
    //   15: iconst_0
    //   16: istore_2
    //   17: iload_2
    //   18: ireturn
    //   19: aload_1
    //   20: ldc 30
    //   22: invokevirtual 36	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   25: istore_2
    //   26: iload_2
    //   27: iconst_m1
    //   28: if_icmpeq +13 -> 41
    //   31: iload_2
    //   32: aload_1
    //   33: invokevirtual 40	java/lang/String:length	()I
    //   36: iconst_1
    //   37: isub
    //   38: if_icmpne +13 -> 51
    //   41: ldc 20
    //   43: ldc 42
    //   45: invokestatic 28	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   48: pop
    //   49: iconst_0
    //   50: ireturn
    //   51: aload_1
    //   52: iload_2
    //   53: invokevirtual 46	java/lang/String:substring	(I)Ljava/lang/String;
    //   56: astore_1
    //   57: new 48	org/json/JSONObject
    //   60: dup
    //   61: aload_1
    //   62: invokespecial 52	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   65: ldc 140
    //   67: invokevirtual 144	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   70: astore_1
    //   71: aload_1
    //   72: ifnonnull +13 -> 85
    //   75: ldc 20
    //   77: ldc 146
    //   79: invokestatic 28	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   82: pop
    //   83: iconst_0
    //   84: ireturn
    //   85: aload_1
    //   86: iconst_0
    //   87: invokevirtual 152	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   90: astore_1
    //   91: aload_1
    //   92: ldc 154
    //   94: invokevirtual 158	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   97: astore 6
    //   99: ldc 160
    //   101: aload 6
    //   103: invokestatic 164	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   106: ifne +31 -> 137
    //   109: ldc 20
    //   111: new 65	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   118: ldc 166
    //   120: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: aload 6
    //   125: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokestatic 28	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   134: pop
    //   135: iconst_0
    //   136: ireturn
    //   137: aload_1
    //   138: ldc 168
    //   140: invokevirtual 158	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   143: astore_1
    //   144: aload_1
    //   145: invokestatic 18	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   148: ifeq +13 -> 161
    //   151: ldc 20
    //   153: ldc 170
    //   155: invokestatic 28	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   158: pop
    //   159: iconst_0
    //   160: ireturn
    //   161: aload_1
    //   162: ldc 172
    //   164: invokevirtual 36	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   167: istore_2
    //   168: iload_2
    //   169: iconst_m1
    //   170: if_icmpne +13 -> 183
    //   173: ldc 20
    //   175: ldc 174
    //   177: invokestatic 28	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   180: pop
    //   181: iconst_0
    //   182: ireturn
    //   183: aload_1
    //   184: iconst_0
    //   185: iload_2
    //   186: invokevirtual 177	java/lang/String:substring	(II)Ljava/lang/String;
    //   189: astore_1
    //   190: aload_1
    //   191: invokestatic 18	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   194: ifeq +13 -> 207
    //   197: ldc 20
    //   199: ldc 179
    //   201: invokestatic 28	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   204: pop
    //   205: iconst_0
    //   206: ireturn
    //   207: ldc 20
    //   209: new 65	java/lang/StringBuilder
    //   212: dup
    //   213: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   216: ldc 181
    //   218: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: aload_1
    //   222: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: iconst_0
    //   229: anewarray 4	java/lang/Object
    //   232: invokestatic 87	com/google/android/keep/util/r:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   235: pop
    //   236: new 98	android/content/ContentValues
    //   239: dup
    //   240: invokespecial 99	android/content/ContentValues:<init>	()V
    //   243: astore 6
    //   245: aload 6
    //   247: ldc 101
    //   249: iconst_m1
    //   250: invokestatic 63	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   253: invokevirtual 105	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   256: aload_0
    //   257: invokevirtual 111	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   260: getstatic 184	com/google/android/keep/provider/i$v:BX	Landroid/net/Uri;
    //   263: aload 6
    //   265: ldc 119
    //   267: iconst_1
    //   268: anewarray 32	java/lang/String
    //   271: dup
    //   272: iconst_0
    //   273: aload_1
    //   274: invokestatic 122	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   277: aastore
    //   278: invokevirtual 128	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   281: istore_3
    //   282: ldc 20
    //   284: new 65	java/lang/StringBuilder
    //   287: dup
    //   288: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   291: ldc 186
    //   293: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: iload_3
    //   297: invokevirtual 133	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   300: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: iconst_0
    //   304: anewarray 4	java/lang/Object
    //   307: invokestatic 87	com/google/android/keep/util/r:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   310: pop
    //   311: iload_3
    //   312: ifne +147 -> 459
    //   315: iload_3
    //   316: aload_0
    //   317: invokevirtual 111	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   320: getstatic 189	com/google/android/keep/provider/i$m:BX	Landroid/net/Uri;
    //   323: aload 6
    //   325: ldc 119
    //   327: iconst_1
    //   328: anewarray 32	java/lang/String
    //   331: dup
    //   332: iconst_0
    //   333: aload_1
    //   334: invokestatic 122	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   337: aastore
    //   338: invokevirtual 128	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   341: iadd
    //   342: istore_2
    //   343: ldc 20
    //   345: new 65	java/lang/StringBuilder
    //   348: dup
    //   349: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   352: ldc 191
    //   354: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: iload_2
    //   358: invokevirtual 133	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   361: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   364: iconst_0
    //   365: anewarray 4	java/lang/Object
    //   368: invokestatic 87	com/google/android/keep/util/r:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   371: pop
    //   372: iload_2
    //   373: aload_0
    //   374: invokevirtual 111	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   377: getstatic 117	com/google/android/keep/provider/i$e:BX	Landroid/net/Uri;
    //   380: aload 6
    //   382: ldc 119
    //   384: iconst_1
    //   385: anewarray 32	java/lang/String
    //   388: dup
    //   389: iconst_0
    //   390: aload_1
    //   391: invokestatic 122	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   394: aastore
    //   395: invokevirtual 128	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   398: iadd
    //   399: istore_2
    //   400: ldc 20
    //   402: new 65	java/lang/StringBuilder
    //   405: dup
    //   406: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   409: ldc 193
    //   411: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: iload_2
    //   415: invokevirtual 133	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   418: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   421: iconst_0
    //   422: anewarray 4	java/lang/Object
    //   425: invokestatic 87	com/google/android/keep/util/r:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   428: pop
    //   429: iload_2
    //   430: ireturn
    //   431: astore_0
    //   432: ldc 20
    //   434: new 65	java/lang/StringBuilder
    //   437: dup
    //   438: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   441: ldc 92
    //   443: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: aload_0
    //   447: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   450: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   453: invokestatic 28	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   456: pop
    //   457: iconst_0
    //   458: ireturn
    //   459: iload_3
    //   460: istore_2
    //   461: iload_3
    //   462: ifle -445 -> 17
    //   465: aload_0
    //   466: invokevirtual 111	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   469: astore 7
    //   471: getstatic 196	com/google/android/keep/provider/i$v:CONTENT_URI	Landroid/net/Uri;
    //   474: astore 8
    //   476: aload_1
    //   477: invokestatic 122	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   480: astore 9
    //   482: aload 7
    //   484: aload 8
    //   486: iconst_1
    //   487: anewarray 32	java/lang/String
    //   490: dup
    //   491: iconst_0
    //   492: ldc 198
    //   494: aastore
    //   495: ldc 119
    //   497: iconst_1
    //   498: anewarray 32	java/lang/String
    //   501: dup
    //   502: iconst_0
    //   503: aload 9
    //   505: aastore
    //   506: aconst_null
    //   507: invokevirtual 202	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   510: astore 7
    //   512: aload 7
    //   514: invokeinterface 208 1 0
    //   519: ifeq +166 -> 685
    //   522: aload 7
    //   524: iconst_0
    //   525: invokeinterface 212 2 0
    //   530: lstore 4
    //   532: aload 7
    //   534: invokeinterface 215 1 0
    //   539: iload_3
    //   540: aload_0
    //   541: invokevirtual 111	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   544: getstatic 189	com/google/android/keep/provider/i$m:BX	Landroid/net/Uri;
    //   547: aload 6
    //   549: ldc 217
    //   551: iconst_1
    //   552: anewarray 32	java/lang/String
    //   555: dup
    //   556: iconst_0
    //   557: lload 4
    //   559: invokestatic 220	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   562: aastore
    //   563: invokevirtual 128	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   566: iadd
    //   567: istore_2
    //   568: ldc 20
    //   570: new 65	java/lang/StringBuilder
    //   573: dup
    //   574: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   577: ldc 191
    //   579: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   582: iload_2
    //   583: invokevirtual 133	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   586: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   589: iconst_0
    //   590: anewarray 4	java/lang/Object
    //   593: invokestatic 87	com/google/android/keep/util/r:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   596: pop
    //   597: iload_2
    //   598: aload_0
    //   599: invokevirtual 111	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   602: getstatic 117	com/google/android/keep/provider/i$e:BX	Landroid/net/Uri;
    //   605: aload 6
    //   607: ldc 222
    //   609: iconst_1
    //   610: anewarray 32	java/lang/String
    //   613: dup
    //   614: iconst_0
    //   615: lload 4
    //   617: invokestatic 220	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   620: aastore
    //   621: invokevirtual 128	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   624: iadd
    //   625: istore_2
    //   626: ldc 20
    //   628: new 65	java/lang/StringBuilder
    //   631: dup
    //   632: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   635: ldc 193
    //   637: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   640: iload_2
    //   641: invokevirtual 133	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   644: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   647: iconst_0
    //   648: anewarray 4	java/lang/Object
    //   651: invokestatic 87	com/google/android/keep/util/r:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   654: pop
    //   655: iload_2
    //   656: ireturn
    //   657: astore_0
    //   658: ldc 20
    //   660: new 65	java/lang/StringBuilder
    //   663: dup
    //   664: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   667: ldc 94
    //   669: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   672: aload_0
    //   673: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   676: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   679: invokestatic 28	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   682: pop
    //   683: iconst_0
    //   684: ireturn
    //   685: ldc 20
    //   687: new 65	java/lang/StringBuilder
    //   690: dup
    //   691: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   694: ldc 224
    //   696: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   699: aload_1
    //   700: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   703: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   706: invokestatic 28	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   709: pop
    //   710: aload 7
    //   712: invokeinterface 215 1 0
    //   717: iload_3
    //   718: ireturn
    //   719: astore_0
    //   720: ldc 20
    //   722: new 65	java/lang/StringBuilder
    //   725: dup
    //   726: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   729: ldc 96
    //   731: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   734: aload_0
    //   735: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   738: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   741: invokestatic 28	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   744: pop
    //   745: iconst_0
    //   746: ireturn
    //   747: astore_0
    //   748: aload 7
    //   750: invokeinterface 215 1 0
    //   755: aload_0
    //   756: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   57	71	431	org/json/JSONException
    //   75	83	431	org/json/JSONException
    //   85	135	431	org/json/JSONException
    //   137	159	431	org/json/JSONException
    //   161	168	431	org/json/JSONException
    //   173	181	431	org/json/JSONException
    //   183	205	431	org/json/JSONException
    //   207	311	431	org/json/JSONException
    //   315	429	431	org/json/JSONException
    //   465	512	431	org/json/JSONException
    //   532	655	431	org/json/JSONException
    //   710	717	431	org/json/JSONException
    //   748	757	431	org/json/JSONException
    //   57	71	657	java/lang/IndexOutOfBoundsException
    //   75	83	657	java/lang/IndexOutOfBoundsException
    //   85	135	657	java/lang/IndexOutOfBoundsException
    //   137	159	657	java/lang/IndexOutOfBoundsException
    //   161	168	657	java/lang/IndexOutOfBoundsException
    //   173	181	657	java/lang/IndexOutOfBoundsException
    //   183	205	657	java/lang/IndexOutOfBoundsException
    //   207	311	657	java/lang/IndexOutOfBoundsException
    //   315	429	657	java/lang/IndexOutOfBoundsException
    //   465	512	657	java/lang/IndexOutOfBoundsException
    //   532	655	657	java/lang/IndexOutOfBoundsException
    //   710	717	657	java/lang/IndexOutOfBoundsException
    //   748	757	657	java/lang/IndexOutOfBoundsException
    //   57	71	719	java/lang/NullPointerException
    //   75	83	719	java/lang/NullPointerException
    //   85	135	719	java/lang/NullPointerException
    //   137	159	719	java/lang/NullPointerException
    //   161	168	719	java/lang/NullPointerException
    //   173	181	719	java/lang/NullPointerException
    //   183	205	719	java/lang/NullPointerException
    //   207	311	719	java/lang/NullPointerException
    //   315	429	719	java/lang/NullPointerException
    //   465	512	719	java/lang/NullPointerException
    //   532	655	719	java/lang/NullPointerException
    //   710	717	719	java/lang/NullPointerException
    //   748	757	719	java/lang/NullPointerException
    //   512	532	747	finally
    //   685	710	747	finally
  }
}