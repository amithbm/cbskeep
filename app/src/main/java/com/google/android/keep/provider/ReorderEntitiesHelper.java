package com.google.android.keep.provider;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.TextUtils;

public class ReorderEntitiesHelper
{
  public static final long DC = Db * ()Math.pow(10.0D, 6.0D);
  public static final long DD = Db * ()Math.pow(10.0D, 6.0D) * -1L;
  public static final long DE = ()Math.pow(2.0D, 50.0D);
  public static final long DF = ()Math.pow(2.0D, 50.0D) * -1L;
  public static final long Db = ()Math.pow(2.0D, 20.0D);

  public static int a(SQLiteDatabase paramSQLiteDatabase, long paramLong, RebaseType paramRebaseType)
  {
    return a(paramSQLiteDatabase, paramLong, paramRebaseType, null, null, false);
  }

  private static int a(SQLiteDatabase paramSQLiteDatabase, long paramLong, RebaseType paramRebaseType, Long paramLong1, Long paramLong2, boolean paramBoolean)
  {
    Cursor localCursor = a(paramSQLiteDatabase, b.aM("tree_entity"), paramLong);
    if (localCursor == null)
      return 0;
    while (true)
    {
      try
      {
        switch (1.DG[paramRebaseType.ordinal()])
        {
        case 1:
          if (i == -1)
          {
            i = a(paramSQLiteDatabase, localCursor, "tree_entity", paramLong1, paramLong2, paramBoolean);
            return i;
            i = a(paramSQLiteDatabase, localCursor);
          }
          break;
        case 2:
          i = b(paramSQLiteDatabase, localCursor);
          continue;
          return i;
        }
      }
      finally
      {
        localCursor.close();
      }
      int i = -1;
    }
  }

  private static int a(SQLiteDatabase paramSQLiteDatabase, Cursor paramCursor)
  {
    int i;
    if ((paramCursor == null) || (paramCursor.getCount() == 0))
      i = 0;
    int j;
    do
    {
      return i;
      paramCursor.moveToLast();
      long l1 = paramCursor.getLong(1);
      paramCursor.moveToFirst();
      long l2 = paramCursor.getLong(1);
      i = 0;
      j = 0;
      ContentValues localContentValues = new ContentValues();
      Object localObject2;
      Object localObject1;
      if (l2 < DF)
      {
        localObject2 = null;
        paramCursor.moveToPosition(-1);
        do
        {
          localObject1 = localObject2;
          if (!paramCursor.moveToNext())
            break;
        }
        while (paramCursor.getLong(1) <= DD);
        localObject1 = Long.valueOf(paramCursor.getLong(1));
        localObject2 = localObject1;
        if (localObject1 == null)
          return -1;
        while (true)
        {
          i = j;
          if (!paramCursor.moveToPrevious())
            break;
          localObject2 = Long.valueOf(((Long)localObject2).longValue() - Db);
          localContentValues.put("order_in_parent", (Long)localObject2);
          j += a(paramSQLiteDatabase, "tree_entity", paramCursor.getLong(0), ((Long)localObject2).longValue());
        }
      }
      j = i;
      if (l1 > DE)
      {
        localObject2 = null;
        paramCursor.moveToPosition(paramCursor.getCount());
        do
        {
          localObject1 = localObject2;
          if (!paramCursor.moveToPrevious())
            break;
        }
        while (paramCursor.getLong(1) >= DC);
        localObject1 = Long.valueOf(paramCursor.getLong(1));
        localObject2 = localObject1;
        if (localObject1 == null)
          return -1;
        while (true)
        {
          j = i;
          if (!paramCursor.moveToNext())
            break;
          localObject2 = Long.valueOf(((Long)localObject2).longValue() + Db);
          localContentValues.put("order_in_parent", (Long)localObject2);
          i += a(paramSQLiteDatabase, "tree_entity", paramCursor.getLong(0), ((Long)localObject2).longValue());
        }
      }
      i = j;
    }
    while (j > 0);
    return -1;
  }

  private static int a(SQLiteDatabase paramSQLiteDatabase, Cursor paramCursor, String paramString, Long paramLong1, Long paramLong2, boolean paramBoolean)
  {
    int j;
    if (paramCursor == null)
    {
      j = 0;
      return j;
    }
    int i = 0;
    long l = 0L;
    paramCursor.moveToPosition(-1);
    while (true)
    {
      j = i;
      if (!paramCursor.moveToNext())
        break;
      Long localLong = Long.valueOf(paramCursor.getLong(0));
      if ((paramLong1 == null) || (!localLong.equals(paramLong1)))
        if ((paramLong2 != null) && (localLong.equals(paramLong2)))
        {
          if (paramBoolean)
          {
            j = a(paramSQLiteDatabase, paramString, paramLong1.longValue(), l);
            l += Db;
            i = i + j + a(paramSQLiteDatabase, paramString, paramLong2.longValue(), l);
            l += Db;
          }
          else
          {
            j = a(paramSQLiteDatabase, paramString, paramLong2.longValue(), l);
            l += Db;
            i = i + j + a(paramSQLiteDatabase, paramString, paramLong1.longValue(), l);
            l += Db;
          }
        }
        else
        {
          i += a(paramSQLiteDatabase, paramString, localLong.longValue(), l);
          l += Db;
        }
    }
  }

  private static int a(SQLiteDatabase paramSQLiteDatabase, String paramString, long paramLong1, long paramLong2)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("order_in_parent", Long.valueOf(paramLong2));
    localContentValues.put("is_dirty", Integer.valueOf(1));
    return paramSQLiteDatabase.update(paramString, localContentValues, "_id=?", new String[] { String.valueOf(paramLong1) });
  }

  // ERROR //
  private static int a(SQLiteDatabase paramSQLiteDatabase, String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 65	com/google/android/keep/provider/ReorderEntitiesHelper$b:aM	(Ljava/lang/String;)Lcom/google/android/keep/provider/ReorderEntitiesHelper$b;
    //   4: astore 17
    //   6: aload 17
    //   8: invokevirtual 169	com/google/android/keep/provider/ReorderEntitiesHelper$b:ky	()Ljava/lang/String;
    //   11: astore 18
    //   13: new 171	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   20: aload 17
    //   22: invokevirtual 175	com/google/android/keep/provider/ReorderEntitiesHelper$b:kz	()Ljava/lang/String;
    //   25: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc 181
    //   30: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload 17
    //   35: invokevirtual 184	com/google/android/keep/provider/ReorderEntitiesHelper$b:kB	()Ljava/lang/String;
    //   38: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: astore 19
    //   46: aload_0
    //   47: aload_1
    //   48: iconst_2
    //   49: anewarray 155	java/lang/String
    //   52: dup
    //   53: iconst_0
    //   54: aload 18
    //   56: aastore
    //   57: dup
    //   58: iconst_1
    //   59: ldc 189
    //   61: aastore
    //   62: aload 19
    //   64: iconst_1
    //   65: anewarray 155	java/lang/String
    //   68: dup
    //   69: iconst_0
    //   70: lload_2
    //   71: invokestatic 158	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   74: aastore
    //   75: aconst_null
    //   76: aconst_null
    //   77: aconst_null
    //   78: invokevirtual 193	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   81: astore 18
    //   83: aload 18
    //   85: invokeinterface 92 1 0
    //   90: iconst_1
    //   91: if_icmpeq +37 -> 128
    //   94: ldc 195
    //   96: new 171	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   103: ldc 197
    //   105: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: lload_2
    //   109: invokevirtual 200	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   112: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokestatic 206	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   118: pop
    //   119: aload 18
    //   121: invokeinterface 84 1 0
    //   126: iconst_0
    //   127: ireturn
    //   128: aload 18
    //   130: invokeinterface 103 1 0
    //   135: pop
    //   136: aload 18
    //   138: iconst_0
    //   139: invokeinterface 100 2 0
    //   144: lstore 8
    //   146: aload 18
    //   148: iconst_1
    //   149: invokeinterface 100 2 0
    //   154: lstore 10
    //   156: aload 18
    //   158: invokeinterface 84 1 0
    //   163: getstatic 212	com/google/android/keep/provider/i$q:Cw	[Ljava/lang/String;
    //   166: iconst_0
    //   167: aaload
    //   168: astore 18
    //   170: getstatic 212	com/google/android/keep/provider/i$q:Cw	[Ljava/lang/String;
    //   173: iconst_1
    //   174: aaload
    //   175: astore 19
    //   177: new 171	java/lang/StringBuilder
    //   180: dup
    //   181: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   184: aload 17
    //   186: invokevirtual 175	com/google/android/keep/provider/ReorderEntitiesHelper$b:kz	()Ljava/lang/String;
    //   189: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: ldc 181
    //   194: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: ldc 189
    //   199: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: ldc 181
    //   204: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: aload 17
    //   209: invokevirtual 169	com/google/android/keep/provider/ReorderEntitiesHelper$b:ky	()Ljava/lang/String;
    //   212: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: ldc 181
    //   217: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: aload 17
    //   222: invokevirtual 184	com/google/android/keep/provider/ReorderEntitiesHelper$b:kB	()Ljava/lang/String;
    //   225: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: astore 20
    //   233: aload_0
    //   234: aload_1
    //   235: iconst_2
    //   236: anewarray 155	java/lang/String
    //   239: dup
    //   240: iconst_0
    //   241: aload 18
    //   243: aastore
    //   244: dup
    //   245: iconst_1
    //   246: aload 19
    //   248: aastore
    //   249: aload 20
    //   251: iconst_3
    //   252: anewarray 155	java/lang/String
    //   255: dup
    //   256: iconst_0
    //   257: lload 4
    //   259: invokestatic 158	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   262: aastore
    //   263: dup
    //   264: iconst_1
    //   265: lload 10
    //   267: invokestatic 158	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   270: aastore
    //   271: dup
    //   272: iconst_2
    //   273: lload 8
    //   275: invokestatic 158	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   278: aastore
    //   279: aconst_null
    //   280: aconst_null
    //   281: aconst_null
    //   282: invokevirtual 193	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   285: astore 18
    //   287: aload 18
    //   289: invokeinterface 92 1 0
    //   294: iconst_1
    //   295: if_icmpeq +77 -> 372
    //   298: ldc 195
    //   300: new 171	java/lang/StringBuilder
    //   303: dup
    //   304: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   307: ldc 214
    //   309: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: lload_2
    //   313: invokevirtual 200	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   316: ldc 216
    //   318: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: lload 4
    //   323: invokevirtual 200	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   326: ldc 218
    //   328: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: lload 8
    //   333: invokevirtual 200	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   336: ldc 220
    //   338: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: lload 10
    //   343: invokevirtual 200	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   346: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   349: invokestatic 206	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   352: pop
    //   353: aload 18
    //   355: invokeinterface 84 1 0
    //   360: iconst_0
    //   361: ireturn
    //   362: astore_0
    //   363: aload 18
    //   365: invokeinterface 84 1 0
    //   370: aload_0
    //   371: athrow
    //   372: aload 18
    //   374: invokeinterface 103 1 0
    //   379: pop
    //   380: aload 18
    //   382: iconst_0
    //   383: invokeinterface 100 2 0
    //   388: lstore 12
    //   390: aload 18
    //   392: iconst_1
    //   393: invokeinterface 100 2 0
    //   398: lstore 14
    //   400: aload 18
    //   402: invokeinterface 84 1 0
    //   407: aload 17
    //   409: iload 6
    //   411: invokevirtual 224	com/google/android/keep/provider/ReorderEntitiesHelper$b:al	(Z)Ljava/lang/String;
    //   414: astore 18
    //   416: aload 17
    //   418: invokevirtual 227	com/google/android/keep/provider/ReorderEntitiesHelper$b:kA	()Ljava/lang/String;
    //   421: astore 19
    //   423: aload 17
    //   425: invokevirtual 175	com/google/android/keep/provider/ReorderEntitiesHelper$b:kz	()Ljava/lang/String;
    //   428: astore 20
    //   430: iload 6
    //   432: ifne +142 -> 574
    //   435: iconst_1
    //   436: istore 16
    //   438: aload 17
    //   440: iload 16
    //   442: invokevirtual 230	com/google/android/keep/provider/ReorderEntitiesHelper$b:ak	(Z)Ljava/lang/String;
    //   445: astore 17
    //   447: lload 10
    //   449: lload 8
    //   451: lload 12
    //   453: lload 14
    //   455: lload 4
    //   457: invokestatic 233	com/google/android/keep/provider/ReorderEntitiesHelper$b:a	(JJJJJ)[Ljava/lang/String;
    //   460: astore 21
    //   462: aload_0
    //   463: aload_1
    //   464: iconst_2
    //   465: anewarray 155	java/lang/String
    //   468: dup
    //   469: iconst_0
    //   470: aload 19
    //   472: aastore
    //   473: dup
    //   474: iconst_1
    //   475: aload 20
    //   477: aastore
    //   478: aload 17
    //   480: aload 21
    //   482: aconst_null
    //   483: aconst_null
    //   484: aload 18
    //   486: ldc 235
    //   488: invokevirtual 238	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   491: astore 17
    //   493: aload 17
    //   495: invokeinterface 92 1 0
    //   500: ifne +111 -> 611
    //   503: iload 6
    //   505: ifeq +75 -> 580
    //   508: lload 12
    //   510: getstatic 38	com/google/android/keep/provider/ReorderEntitiesHelper:Db	J
    //   513: lsub
    //   514: lstore 4
    //   516: lload 4
    //   518: getstatic 54	com/google/android/keep/provider/ReorderEntitiesHelper:DF	J
    //   521: lcmp
    //   522: ifle +12 -> 534
    //   525: lload 4
    //   527: getstatic 52	com/google/android/keep/provider/ReorderEntitiesHelper:DE	J
    //   530: lcmp
    //   531: iflt +60 -> 591
    //   534: aload_0
    //   535: aload_1
    //   536: lload_2
    //   537: lload 4
    //   539: invokestatic 137	com/google/android/keep/provider/ReorderEntitiesHelper:a	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;JJ)I
    //   542: pop
    //   543: aload_0
    //   544: lload 10
    //   546: getstatic 242	com/google/android/keep/provider/ReorderEntitiesHelper$RebaseType:DI	Lcom/google/android/keep/provider/ReorderEntitiesHelper$RebaseType;
    //   549: invokestatic 244	com/google/android/keep/provider/ReorderEntitiesHelper:a	(Landroid/database/sqlite/SQLiteDatabase;JLcom/google/android/keep/provider/ReorderEntitiesHelper$RebaseType;)I
    //   552: istore 7
    //   554: aload 17
    //   556: invokeinterface 84 1 0
    //   561: iload 7
    //   563: ireturn
    //   564: astore_0
    //   565: aload 18
    //   567: invokeinterface 84 1 0
    //   572: aload_0
    //   573: athrow
    //   574: iconst_0
    //   575: istore 16
    //   577: goto -139 -> 438
    //   580: lload 12
    //   582: getstatic 38	com/google/android/keep/provider/ReorderEntitiesHelper:Db	J
    //   585: ladd
    //   586: lstore 4
    //   588: goto -72 -> 516
    //   591: aload_0
    //   592: aload_1
    //   593: lload_2
    //   594: lload 4
    //   596: invokestatic 137	com/google/android/keep/provider/ReorderEntitiesHelper:a	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;JJ)I
    //   599: istore 7
    //   601: aload 17
    //   603: invokeinterface 84 1 0
    //   608: iload 7
    //   610: ireturn
    //   611: aload 17
    //   613: iconst_0
    //   614: invokeinterface 112 2 0
    //   619: pop
    //   620: aload 17
    //   622: iconst_1
    //   623: invokeinterface 100 2 0
    //   628: lstore 8
    //   630: lload 8
    //   632: lload_2
    //   633: lcmp
    //   634: ifne +12 -> 646
    //   637: aload 17
    //   639: invokeinterface 84 1 0
    //   644: iconst_0
    //   645: ireturn
    //   646: aload 17
    //   648: iconst_0
    //   649: invokeinterface 100 2 0
    //   654: lstore 14
    //   656: iload 6
    //   658: ifeq +37 -> 695
    //   661: lload 12
    //   663: lload 14
    //   665: lsub
    //   666: lstore 8
    //   668: lload 8
    //   670: lconst_0
    //   671: lcmp
    //   672: ifge +33 -> 705
    //   675: new 246	java/lang/IllegalStateException
    //   678: dup
    //   679: ldc 248
    //   681: invokespecial 251	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   684: athrow
    //   685: astore_0
    //   686: aload 17
    //   688: invokeinterface 84 1 0
    //   693: aload_0
    //   694: athrow
    //   695: lload 14
    //   697: lload 12
    //   699: lsub
    //   700: lstore 8
    //   702: goto -34 -> 668
    //   705: aload 17
    //   707: invokeinterface 84 1 0
    //   712: lload 8
    //   714: lconst_1
    //   715: lcmp
    //   716: ifle +19 -> 735
    //   719: aload_0
    //   720: aload_1
    //   721: lload_2
    //   722: lload 12
    //   724: lload 14
    //   726: ladd
    //   727: ldc2_w 252
    //   730: ldiv
    //   731: invokestatic 137	com/google/android/keep/provider/ReorderEntitiesHelper:a	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;JJ)I
    //   734: ireturn
    //   735: aload_0
    //   736: lload 10
    //   738: getstatic 256	com/google/android/keep/provider/ReorderEntitiesHelper$RebaseType:DJ	Lcom/google/android/keep/provider/ReorderEntitiesHelper$RebaseType;
    //   741: lload_2
    //   742: invokestatic 121	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   745: lload 4
    //   747: invokestatic 121	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   750: iload 6
    //   752: invokestatic 59	com/google/android/keep/provider/ReorderEntitiesHelper:a	(Landroid/database/sqlite/SQLiteDatabase;JLcom/google/android/keep/provider/ReorderEntitiesHelper$RebaseType;Ljava/lang/Long;Ljava/lang/Long;Z)I
    //   755: istore 7
    //   757: aload_0
    //   758: aload_1
    //   759: lload_2
    //   760: lload 4
    //   762: iload 6
    //   764: invokestatic 258	com/google/android/keep/provider/ReorderEntitiesHelper:a	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;JJZ)I
    //   767: iload 7
    //   769: iadd
    //   770: ireturn
    //
    // Exception table:
    //   from	to	target	type
    //   83	119	362	finally
    //   128	156	362	finally
    //   287	353	564	finally
    //   372	400	564	finally
    //   493	503	685	finally
    //   508	516	685	finally
    //   516	534	685	finally
    //   534	554	685	finally
    //   580	588	685	finally
    //   591	601	685	finally
    //   611	630	685	finally
    //   646	656	685	finally
    //   675	685	685	finally
  }

  public static int a(SQLiteDatabase paramSQLiteDatabase, String paramString, Uri paramUri, boolean paramBoolean)
  {
    String str = paramUri.getQueryParameter("source");
    paramUri = paramUri.getQueryParameter("target");
    if ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty(paramUri)))
      throw new IllegalStateException("Source id or target id cannot be null.");
    long l1 = Long.parseLong(str);
    long l2 = Long.parseLong(paramUri);
    if (l1 == l2)
      return 0;
    return a(paramSQLiteDatabase, paramString, l1, l2, paramBoolean);
  }

  private static Cursor a(SQLiteDatabase paramSQLiteDatabase, b paramb, long paramLong)
  {
    String str1 = paramb.kz();
    String str2 = "account_id=? AND " + paramb.ky() + "=? AND " + paramb.kB();
    paramb = paramb.al(false);
    return paramSQLiteDatabase.query("tree_entity", new String[] { str1, "order_in_parent" }, str2, new String[] { String.valueOf(paramLong), String.valueOf(0L) }, null, null, paramb);
  }

  public static boolean a(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    paramSQLiteDatabase = paramSQLiteDatabase.query("tree_entity", new String[] { "is_graveyard_off" }, "_id = ?", new String[] { String.valueOf(paramLong) }, null, null, null);
    if (paramSQLiteDatabase == null)
      return false;
    try
    {
      if (paramSQLiteDatabase.moveToFirst())
      {
        int i = paramSQLiteDatabase.getInt(0);
        if (i == 0);
        for (boolean bool = true; ; bool = false)
          return bool;
      }
      return false;
    }
    finally
    {
      paramSQLiteDatabase.close();
    }
  }

  private static int b(SQLiteDatabase paramSQLiteDatabase, Cursor paramCursor)
  {
    if ((paramCursor == null) || (paramCursor.getCount() < 2))
      return -1;
    int i = -2;
    paramCursor.moveToFirst();
    long l1 = paramCursor.getLong(1);
    while (paramCursor.moveToNext())
    {
      l2 = paramCursor.getLong(1);
      if (l2 - l1 < 2L);
      for (int j = 1; ; j = 0)
      {
        k = i;
        if (j == 0)
          break label95;
        if (i == -2)
          break;
        return -1;
      }
      int k = paramCursor.getPosition();
      label95: l1 = l2;
      i = k;
    }
    if (i == -2)
      return -1;
    paramCursor.moveToPosition(i - 1);
    l1 = paramCursor.getLong(1);
    if (i + 1 == paramCursor.getCount())
    {
      l1 += Db;
      if (l1 > DE)
        return -1;
      paramCursor.moveToPosition(i);
      return a(paramSQLiteDatabase, "tree_entity", paramCursor.getLong(0), l1);
    }
    paramCursor.moveToPosition(i + 1);
    long l2 = paramCursor.getLong(1);
    paramCursor.moveToPosition(i);
    return a(paramSQLiteDatabase, "tree_entity", paramCursor.getLong(0), l2 - (l1 - l2) / 2L);
  }

  public static long b(Long paramLong1, Long paramLong2)
  {
    if (paramLong1 == null)
    {
      if (paramLong2 == null)
        return 0L;
      return Math.min(paramLong2.longValue() + Db, DE);
    }
    if (paramLong2 == null)
      return Math.max(paramLong1.longValue() - Db, DF);
    return (paramLong1.longValue() + paramLong2.longValue()) / 2L;
  }

  public static int c(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    paramString = " IN ( SELECT tree_entity._id FROM tree_entity WHERE " + paramString + ")";
    paramString = "list_parent_id" + paramString;
    paramString = paramSQLiteDatabase.query("list_item", new String[] { "_id", "list_parent_id" }, paramString, paramArrayOfString, null, null, "list_parent_id, is_checked ASC, order_in_parent DESC ");
    if (paramString == null)
      return 0;
    paramArrayOfString = new ContentValues();
    int i = 0;
    long l3 = -1L;
    long l1 = 0L;
    boolean bool1 = false;
    try
    {
      while (paramString.moveToNext())
      {
        boolean bool2 = bool1;
        long l4 = l1;
        long l2 = l3;
        if (paramString.getLong(1) != l3)
        {
          l2 = paramString.getLong(1);
          l4 = 0L;
          bool2 = a(paramSQLiteDatabase, l2);
        }
        bool1 = bool2;
        l1 = l4;
        l3 = l2;
        if (bool2)
        {
          paramArrayOfString.put("order_in_parent", Long.valueOf(l4));
          l1 = l4 - Db;
          int j = paramSQLiteDatabase.update("list_item", paramArrayOfString, "_id=?", new String[] { String.valueOf(paramString.getLong(0)) });
          i += j;
          bool1 = bool2;
          l3 = l2;
        }
      }
      return i;
    }
    finally
    {
      paramString.close();
    }
    throw paramSQLiteDatabase;
  }

  public static enum RebaseType
  {
  }

  private static class a extends ReorderEntitiesHelper.b
  {
    static a DH = new a();

    private a()
    {
      super();
    }

    public String ky()
    {
      return "list_parent_id";
    }
  }

  private static abstract class b
  {
    private static final String DM = "((" + i.q.Cw[0] + ">?) OR (" + i.q.Cw[0] + "=? AND " + i.q.Cw[1] + ">=? AND " + "_id" + "!= ?)) ";
    private static final String DN = "((" + i.q.Cw[0] + "<?) OR (" + i.q.Cw[0] + "=? AND " + i.q.Cw[1] + "<=? AND " + "_id" + "!= ?)) ";
    private static final String DO = i.q.Cw[0] + " DESC, " + i.q.Cw[1] + " DESC ";
    private static final String DP = i.q.Cw[0] + " ASC, " + i.q.Cw[1] + " ASC ";

    public static String[] a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
    {
      return new String[] { String.valueOf(paramLong3), String.valueOf(paramLong3), String.valueOf(paramLong4), String.valueOf(paramLong5), String.valueOf(paramLong1), String.valueOf(paramLong2) };
    }

    public static b aM(String paramString)
    {
      if ("tree_entity".equals(paramString))
        return ReorderEntitiesHelper.c.DQ;
      if ("list_item".equals(paramString))
        return ReorderEntitiesHelper.a.DH;
      throw new IllegalArgumentException("Table " + paramString + " is not reorderable");
    }

    public String ak(boolean paramBoolean)
    {
      if (paramBoolean);
      for (String str = DM; ; str = DN)
        return str + " AND " + kB() + " AND " + "account_id" + "=? AND " + ky() + "=?";
    }

    public String al(boolean paramBoolean)
    {
      if (paramBoolean)
        return DO;
      return DP;
    }

    public String kA()
    {
      return "order_in_parent";
    }

    public String kB()
    {
      return "is_deleted=0";
    }

    public abstract String ky();

    public String kz()
    {
      return "_id";
    }
  }

  private static class c extends ReorderEntitiesHelper.b
  {
    static c DQ = new c();

    private c()
    {
      super();
    }

    public String kB()
    {
      return "is_deleted=0 AND is_archived=0";
    }

    public String ky()
    {
      return "parent_id";
    }
  }
}