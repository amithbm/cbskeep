package com.google.analytics.tracking.android;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.Command;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.impl.client.DefaultHttpClient;

class PersistentAnalyticsStore
  implements AnalyticsStore
{
  private static final String CREATE_HITS_TABLE = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT NOT NULL, '%s' INTEGER);", new Object[] { "hits2", "hit_id", "hit_time", "hit_url", "hit_string", "hit_app_id" });
  private Clock mClock;
  private final Context mContext;
  private final String mDatabaseName;
  private final AnalyticsDatabaseHelper mDbHelper;
  private volatile Dispatcher mDispatcher;
  private long mLastDeleteStaleHitsTime;
  private final AnalyticsStoreStateListener mListener;

  PersistentAnalyticsStore(AnalyticsStoreStateListener paramAnalyticsStoreStateListener, Context paramContext)
  {
    this(paramAnalyticsStoreStateListener, paramContext, "google_analytics_v2.db");
  }

  PersistentAnalyticsStore(AnalyticsStoreStateListener paramAnalyticsStoreStateListener, Context paramContext, String paramString)
  {
    mContext = paramContext.getApplicationContext();
    mDatabaseName = paramString;
    mListener = paramAnalyticsStoreStateListener;
    mClock = new Clock()
    {
      public long currentTimeMillis()
      {
        return System.currentTimeMillis();
      }
    };
    mDbHelper = new AnalyticsDatabaseHelper(mContext, mDatabaseName);
    mDispatcher = new SimpleNetworkDispatcher(new DefaultHttpClient(), mContext);
    mLastDeleteStaleHitsTime = 0L;
  }

  private void fillVersionParameter(Map<String, String> paramMap, Collection<Command> paramCollection)
  {
    String str = "&_v".substring(1);
    if (paramCollection != null)
    {
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        Command localCommand = (Command)paramCollection.next();
        if ("appendVersion".equals(localCommand.getId()))
          paramMap.put(str, localCommand.getValue());
      }
    }
  }

  static String generateHitString(Map<String, String> paramMap)
  {
    ArrayList localArrayList = new ArrayList(paramMap.size());
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localArrayList.add(HitBuilder.encode((String)localEntry.getKey()) + "=" + HitBuilder.encode((String)localEntry.getValue()));
    }
    return TextUtils.join("&", localArrayList);
  }

  private SQLiteDatabase getWritableDatabase(String paramString)
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = mDbHelper.getWritableDatabase();
      return localSQLiteDatabase;
    }
    catch (SQLiteException localSQLiteException)
    {
      Log.w(paramString);
    }
    return null;
  }

  private void removeOldHitIfFull()
  {
    int i = getNumStoredHits() - 2000 + 1;
    if (i > 0)
    {
      List localList = peekHitIds(i);
      Log.v("Store full, deleting " + localList.size() + " hits to make room.");
      deleteHits((String[])localList.toArray(new String[0]));
    }
  }

  private void writeHitToDatabase(Map<String, String> paramMap, long paramLong, String paramString)
  {
    SQLiteDatabase localSQLiteDatabase = getWritableDatabase("Error opening database for putHit");
    if (localSQLiteDatabase == null)
      return;
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("hit_string", generateHitString(paramMap));
    localContentValues.put("hit_time", Long.valueOf(paramLong));
    long l = 0L;
    paramLong = l;
    if (paramMap.containsKey("AppUID"));
    try
    {
      paramLong = Long.parseLong((String)paramMap.get("AppUID"));
      localContentValues.put("hit_app_id", Long.valueOf(paramLong));
      paramMap = paramString;
      if (paramString == null)
        paramMap = "http://www.google-analytics.com/collect";
      if (paramMap.length() == 0)
      {
        Log.w("Empty path: not sending hit");
        return;
      }
      localContentValues.put("hit_url", paramMap);
      try
      {
        localSQLiteDatabase.insert("hits2", null, localContentValues);
        mListener.reportStoreIsEmpty(false);
        return;
      }
      catch (SQLiteException paramMap)
      {
        Log.w("Error storing hit");
        return;
      }
    }
    catch (NumberFormatException paramMap)
    {
      while (true)
        paramLong = l;
    }
  }

  public void clearHits(long paramLong)
  {
    boolean bool = true;
    Object localObject = getWritableDatabase("Error opening database for clearHits");
    if (localObject != null)
    {
      if (paramLong != 0L)
        break label54;
      ((SQLiteDatabase)localObject).delete("hits2", null, null);
      localObject = mListener;
      if (getNumStoredHits() != 0)
        break label82;
    }
    while (true)
    {
      ((AnalyticsStoreStateListener)localObject).reportStoreIsEmpty(bool);
      return;
      label54: ((SQLiteDatabase)localObject).delete("hits2", "hit_app_id = ?", new String[] { Long.valueOf(paramLong).toString() });
      break;
      label82: bool = false;
    }
  }

  @Deprecated
  void deleteHits(Collection<Hit> paramCollection)
  {
    if ((paramCollection == null) || (paramCollection.isEmpty()))
    {
      Log.w("Empty/Null collection passed to deleteHits.");
      return;
    }
    String[] arrayOfString = new String[paramCollection.size()];
    int i = 0;
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      arrayOfString[i] = String.valueOf(((Hit)paramCollection.next()).getHitId());
      i += 1;
    }
    deleteHits(arrayOfString);
  }

  void deleteHits(String[] paramArrayOfString)
  {
    boolean bool = true;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
      Log.w("Empty hitIds passed to deleteHits.");
    Object localObject;
    do
    {
      return;
      localObject = getWritableDatabase("Error opening database for deleteHits.");
    }
    while (localObject == null);
    String str = String.format("HIT_ID in (%s)", new Object[] { TextUtils.join(",", Collections.nCopies(paramArrayOfString.length, "?")) });
    while (true)
    {
      try
      {
        ((SQLiteDatabase)localObject).delete("hits2", str, paramArrayOfString);
        localObject = mListener;
        if (getNumStoredHits() == 0)
        {
          ((AnalyticsStoreStateListener)localObject).reportStoreIsEmpty(bool);
          return;
        }
      }
      catch (SQLiteException localSQLiteException)
      {
        Log.w("Error deleting hits " + paramArrayOfString);
        return;
      }
      bool = false;
    }
  }

  int deleteStaleHits()
  {
    boolean bool = true;
    long l = mClock.currentTimeMillis();
    if (l <= mLastDeleteStaleHitsTime + 86400000L);
    do
    {
      return 0;
      mLastDeleteStaleHitsTime = l;
      localObject = getWritableDatabase("Error opening database for deleteStaleHits.");
    }
    while (localObject == null);
    int i = ((SQLiteDatabase)localObject).delete("hits2", "HIT_TIME < ?", new String[] { Long.toString(mClock.currentTimeMillis() - 2592000000L) });
    Object localObject = mListener;
    if (getNumStoredHits() == 0);
    while (true)
    {
      ((AnalyticsStoreStateListener)localObject).reportStoreIsEmpty(bool);
      return i;
      bool = false;
    }
  }

  public void dispatch()
  {
    Log.v("Dispatch running...");
    if (!mDispatcher.okToDispatch());
    List localList;
    int i;
    do
    {
      return;
      localList = peekHits(40);
      if (localList.isEmpty())
      {
        Log.v("...nothing to dispatch");
        mListener.reportStoreIsEmpty(true);
        return;
      }
      i = mDispatcher.dispatchHits(localList);
      Log.v("sent " + i + " of " + localList.size() + " hits");
      deleteHits(localList.subList(0, Math.min(i, localList.size())));
    }
    while ((i != localList.size()) || (getNumStoredHits() <= 0));
    GAServiceManager.getInstance().dispatchLocalHits();
  }

  public Dispatcher getDispatcher()
  {
    return mDispatcher;
  }

  int getNumStoredHits()
  {
    int k = 0;
    int i = 0;
    Object localObject5 = getWritableDatabase("Error opening database for getNumStoredHits.");
    if (localObject5 == null)
      return 0;
    Object localObject3 = null;
    Object localObject1 = null;
    try
    {
      localObject5 = ((SQLiteDatabase)localObject5).rawQuery("SELECT COUNT(*) from hits2", null);
      localObject1 = localObject5;
      localObject3 = localObject5;
      if (((Cursor)localObject5).moveToFirst())
      {
        localObject1 = localObject5;
        localObject3 = localObject5;
        long l = ((Cursor)localObject5).getLong(0);
        i = (int)l;
      }
      j = i;
      if (localObject5 != null)
      {
        ((Cursor)localObject5).close();
        j = i;
      }
      return j;
    }
    catch (SQLiteException localSQLiteException)
    {
      while (true)
      {
        localObject4 = localObject1;
        Log.w("Error getting numStoredHits");
        int j = k;
        if (localObject1 != null)
        {
          localObject1.close();
          j = k;
        }
      }
    }
    finally
    {
      Object localObject4;
      if (localObject4 != null)
        localObject4.close();
    }
  }

  List<String> peekHitIds(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramInt <= 0)
      Log.w("Invalid maxHits specified. Skipping");
    while (true)
    {
      return localArrayList;
      SQLiteDatabase localSQLiteDatabase = getWritableDatabase("Error opening database for peekHitIds.");
      if (localSQLiteDatabase == null)
        continue;
      Object localObject3 = null;
      Cursor localCursor2 = null;
      Cursor localCursor1 = localCursor2;
      Object localObject1 = localObject3;
      try
      {
        String str1 = String.format("%s ASC", new Object[] { "hit_id" });
        localCursor1 = localCursor2;
        localObject1 = localObject3;
        String str2 = Integer.toString(paramInt);
        localCursor1 = localCursor2;
        localObject1 = localObject3;
        localCursor2 = localSQLiteDatabase.query("hits2", new String[] { "hit_id" }, null, null, null, null, str1, str2);
        localCursor1 = localCursor2;
        localObject1 = localCursor2;
        if (localCursor2.moveToFirst())
        {
          boolean bool;
          do
          {
            localCursor1 = localCursor2;
            localObject1 = localCursor2;
            localArrayList.add(String.valueOf(localCursor2.getLong(0)));
            localCursor1 = localCursor2;
            localObject1 = localCursor2;
            bool = localCursor2.moveToNext();
          }
          while (bool);
        }
        if (localCursor2 == null)
          continue;
        localCursor2.close();
        return localArrayList;
      }
      catch (SQLiteException localSQLiteException)
      {
        localObject1 = localCursor1;
        Log.w("Error in peekHits fetching hitIds: " + localSQLiteException.getMessage());
        if (localCursor1 == null)
          continue;
        localCursor1.close();
        return localArrayList;
      }
      finally
      {
        if (localObject1 != null)
          ((Cursor)localObject1).close();
      }
    }
  }

  // ERROR //
  public List<Hit> peekHits(int paramInt)
  {
    // Byte code:
    //   0: new 152	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 444	java/util/ArrayList:<init>	()V
    //   7: astore 7
    //   9: aload_0
    //   10: ldc_w 469
    //   13: invokespecial 255	com/google/analytics/tracking/android/PersistentAnalyticsStore:getWritableDatabase	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteDatabase;
    //   16: astore 9
    //   18: aload 9
    //   20: ifnonnull +6 -> 26
    //   23: aload 7
    //   25: areturn
    //   26: aconst_null
    //   27: astore 8
    //   29: aconst_null
    //   30: astore 4
    //   32: aload 4
    //   34: astore 6
    //   36: aload 8
    //   38: astore 5
    //   40: ldc_w 450
    //   43: iconst_1
    //   44: anewarray 4	java/lang/Object
    //   47: dup
    //   48: iconst_0
    //   49: ldc 34
    //   51: aastore
    //   52: invokestatic 48	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   55: astore 10
    //   57: aload 4
    //   59: astore 6
    //   61: aload 8
    //   63: astore 5
    //   65: iload_1
    //   66: invokestatic 454	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   69: astore 11
    //   71: aload 4
    //   73: astore 6
    //   75: aload 8
    //   77: astore 5
    //   79: aload 9
    //   81: ldc 32
    //   83: iconst_2
    //   84: anewarray 44	java/lang/String
    //   87: dup
    //   88: iconst_0
    //   89: ldc 34
    //   91: aastore
    //   92: dup
    //   93: iconst_1
    //   94: ldc 36
    //   96: aastore
    //   97: aconst_null
    //   98: aconst_null
    //   99: aconst_null
    //   100: aconst_null
    //   101: aload 10
    //   103: aload 11
    //   105: invokevirtual 458	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   108: astore 4
    //   110: aload 4
    //   112: astore 6
    //   114: aload 4
    //   116: astore 5
    //   118: new 152	java/util/ArrayList
    //   121: dup
    //   122: invokespecial 444	java/util/ArrayList:<init>	()V
    //   125: astore 8
    //   127: aload 4
    //   129: invokeinterface 434 1 0
    //   134: ifeq +47 -> 181
    //   137: aload 8
    //   139: new 328	com/google/analytics/tracking/android/Hit
    //   142: dup
    //   143: aconst_null
    //   144: aload 4
    //   146: iconst_0
    //   147: invokeinterface 438 2 0
    //   152: aload 4
    //   154: iconst_1
    //   155: invokeinterface 438 2 0
    //   160: invokespecial 472	com/google/analytics/tracking/android/Hit:<init>	(Ljava/lang/String;JJ)V
    //   163: invokeinterface 196 2 0
    //   168: pop
    //   169: aload 4
    //   171: invokeinterface 461 1 0
    //   176: istore_3
    //   177: iload_3
    //   178: ifne -41 -> 137
    //   181: aload 4
    //   183: ifnull +10 -> 193
    //   186: aload 4
    //   188: invokeinterface 441 1 0
    //   193: iconst_0
    //   194: istore_2
    //   195: aload 4
    //   197: astore 6
    //   199: aload 4
    //   201: astore 5
    //   203: ldc_w 450
    //   206: iconst_1
    //   207: anewarray 4	java/lang/Object
    //   210: dup
    //   211: iconst_0
    //   212: ldc 34
    //   214: aastore
    //   215: invokestatic 48	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   218: astore 7
    //   220: aload 4
    //   222: astore 6
    //   224: aload 4
    //   226: astore 5
    //   228: iload_1
    //   229: invokestatic 454	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   232: astore 10
    //   234: aload 4
    //   236: astore 6
    //   238: aload 4
    //   240: astore 5
    //   242: aload 9
    //   244: ldc 32
    //   246: iconst_3
    //   247: anewarray 44	java/lang/String
    //   250: dup
    //   251: iconst_0
    //   252: ldc 34
    //   254: aastore
    //   255: dup
    //   256: iconst_1
    //   257: ldc 40
    //   259: aastore
    //   260: dup
    //   261: iconst_2
    //   262: ldc 38
    //   264: aastore
    //   265: aconst_null
    //   266: aconst_null
    //   267: aconst_null
    //   268: aconst_null
    //   269: aload 7
    //   271: aload 10
    //   273: invokevirtual 458	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   276: astore 4
    //   278: aload 4
    //   280: astore 6
    //   282: aload 4
    //   284: astore 5
    //   286: aload 4
    //   288: invokeinterface 434 1 0
    //   293: ifeq +111 -> 404
    //   296: iload_2
    //   297: istore_1
    //   298: aload 4
    //   300: astore 6
    //   302: aload 4
    //   304: astore 5
    //   306: aload 4
    //   308: checkcast 474	android/database/sqlite/SQLiteCursor
    //   311: invokevirtual 478	android/database/sqlite/SQLiteCursor:getWindow	()Landroid/database/CursorWindow;
    //   314: invokevirtual 483	android/database/CursorWindow:getNumRows	()I
    //   317: ifle +187 -> 504
    //   320: aload 4
    //   322: astore 6
    //   324: aload 4
    //   326: astore 5
    //   328: aload 8
    //   330: iload_1
    //   331: invokeinterface 486 2 0
    //   336: checkcast 328	com/google/analytics/tracking/android/Hit
    //   339: aload 4
    //   341: iconst_1
    //   342: invokeinterface 489 2 0
    //   347: invokevirtual 492	com/google/analytics/tracking/android/Hit:setHitString	(Ljava/lang/String;)V
    //   350: aload 4
    //   352: astore 6
    //   354: aload 4
    //   356: astore 5
    //   358: aload 8
    //   360: iload_1
    //   361: invokeinterface 486 2 0
    //   366: checkcast 328	com/google/analytics/tracking/android/Hit
    //   369: aload 4
    //   371: iconst_2
    //   372: invokeinterface 489 2 0
    //   377: invokevirtual 495	com/google/analytics/tracking/android/Hit:setHitUrl	(Ljava/lang/String;)V
    //   380: iload_1
    //   381: iconst_1
    //   382: iadd
    //   383: istore_1
    //   384: aload 4
    //   386: astore 6
    //   388: aload 4
    //   390: astore 5
    //   392: aload 4
    //   394: invokeinterface 461 1 0
    //   399: istore_3
    //   400: iload_3
    //   401: ifne -103 -> 298
    //   404: aload 4
    //   406: ifnull +10 -> 416
    //   409: aload 4
    //   411: invokeinterface 441 1 0
    //   416: aload 8
    //   418: areturn
    //   419: astore 4
    //   421: aload 7
    //   423: astore 8
    //   425: aload 4
    //   427: astore 7
    //   429: aload 6
    //   431: astore 4
    //   433: aload 4
    //   435: astore 5
    //   437: new 170	java/lang/StringBuilder
    //   440: dup
    //   441: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   444: ldc_w 463
    //   447: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: aload 7
    //   452: invokevirtual 466	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   455: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   461: invokestatic 218	com/google/analytics/tracking/android/Log:w	(Ljava/lang/String;)V
    //   464: aload 4
    //   466: ifnull +10 -> 476
    //   469: aload 4
    //   471: invokeinterface 441 1 0
    //   476: aload 8
    //   478: areturn
    //   479: astore 6
    //   481: aload 5
    //   483: astore 4
    //   485: aload 6
    //   487: astore 5
    //   489: aload 4
    //   491: ifnull +10 -> 501
    //   494: aload 4
    //   496: invokeinterface 441 1 0
    //   501: aload 5
    //   503: athrow
    //   504: aload 4
    //   506: astore 6
    //   508: aload 4
    //   510: astore 5
    //   512: ldc_w 497
    //   515: iconst_1
    //   516: anewarray 4	java/lang/Object
    //   519: dup
    //   520: iconst_0
    //   521: aload 8
    //   523: iload_1
    //   524: invokeinterface 486 2 0
    //   529: checkcast 328	com/google/analytics/tracking/android/Hit
    //   532: invokevirtual 332	com/google/analytics/tracking/android/Hit:getHitId	()J
    //   535: invokestatic 269	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   538: aastore
    //   539: invokestatic 48	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   542: invokestatic 218	com/google/analytics/tracking/android/Log:w	(Ljava/lang/String;)V
    //   545: goto -165 -> 380
    //   548: astore 4
    //   550: aload 6
    //   552: astore 5
    //   554: new 170	java/lang/StringBuilder
    //   557: dup
    //   558: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   561: ldc_w 499
    //   564: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   567: aload 4
    //   569: invokevirtual 466	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   572: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   575: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   578: invokestatic 218	com/google/analytics/tracking/android/Log:w	(Ljava/lang/String;)V
    //   581: aload 6
    //   583: astore 5
    //   585: new 152	java/util/ArrayList
    //   588: dup
    //   589: invokespecial 444	java/util/ArrayList:<init>	()V
    //   592: astore 4
    //   594: iconst_0
    //   595: istore_1
    //   596: aload 6
    //   598: astore 5
    //   600: aload 8
    //   602: invokeinterface 500 1 0
    //   607: astore 7
    //   609: aload 6
    //   611: astore 5
    //   613: aload 7
    //   615: invokeinterface 122 1 0
    //   620: ifeq +42 -> 662
    //   623: aload 6
    //   625: astore 5
    //   627: aload 7
    //   629: invokeinterface 126 1 0
    //   634: checkcast 328	com/google/analytics/tracking/android/Hit
    //   637: astore 8
    //   639: aload 6
    //   641: astore 5
    //   643: aload 8
    //   645: invokevirtual 503	com/google/analytics/tracking/android/Hit:getHitParams	()Ljava/lang/String;
    //   648: invokestatic 506	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   651: istore_3
    //   652: iload_1
    //   653: istore_2
    //   654: iload_3
    //   655: ifeq +24 -> 679
    //   658: iload_1
    //   659: ifeq +18 -> 677
    //   662: aload 6
    //   664: ifnull +10 -> 674
    //   667: aload 6
    //   669: invokeinterface 441 1 0
    //   674: aload 4
    //   676: areturn
    //   677: iconst_1
    //   678: istore_2
    //   679: aload 6
    //   681: astore 5
    //   683: aload 4
    //   685: aload 8
    //   687: invokeinterface 196 2 0
    //   692: pop
    //   693: iload_2
    //   694: istore_1
    //   695: goto -86 -> 609
    //   698: astore 4
    //   700: aload 5
    //   702: ifnull +10 -> 712
    //   705: aload 5
    //   707: invokeinterface 441 1 0
    //   712: aload 4
    //   714: athrow
    //   715: astore 5
    //   717: goto -228 -> 489
    //   720: astore 7
    //   722: goto -289 -> 433
    //
    // Exception table:
    //   from	to	target	type
    //   40	57	419	android/database/sqlite/SQLiteException
    //   65	71	419	android/database/sqlite/SQLiteException
    //   79	110	419	android/database/sqlite/SQLiteException
    //   118	127	419	android/database/sqlite/SQLiteException
    //   40	57	479	finally
    //   65	71	479	finally
    //   79	110	479	finally
    //   118	127	479	finally
    //   437	464	479	finally
    //   203	220	548	android/database/sqlite/SQLiteException
    //   228	234	548	android/database/sqlite/SQLiteException
    //   242	278	548	android/database/sqlite/SQLiteException
    //   286	296	548	android/database/sqlite/SQLiteException
    //   306	320	548	android/database/sqlite/SQLiteException
    //   328	350	548	android/database/sqlite/SQLiteException
    //   358	380	548	android/database/sqlite/SQLiteException
    //   392	400	548	android/database/sqlite/SQLiteException
    //   512	545	548	android/database/sqlite/SQLiteException
    //   203	220	698	finally
    //   228	234	698	finally
    //   242	278	698	finally
    //   286	296	698	finally
    //   306	320	698	finally
    //   328	350	698	finally
    //   358	380	698	finally
    //   392	400	698	finally
    //   512	545	698	finally
    //   554	581	698	finally
    //   585	594	698	finally
    //   600	609	698	finally
    //   613	623	698	finally
    //   627	639	698	finally
    //   643	652	698	finally
    //   683	693	698	finally
    //   127	137	715	finally
    //   137	177	715	finally
    //   127	137	720	android/database/sqlite/SQLiteException
    //   137	177	720	android/database/sqlite/SQLiteException
  }

  public void putHit(Map<String, String> paramMap, long paramLong, String paramString, Collection<Command> paramCollection)
  {
    deleteStaleHits();
    removeOldHitIfFull();
    fillVersionParameter(paramMap, paramCollection);
    writeHitToDatabase(paramMap, paramLong, paramString);
  }

  class AnalyticsDatabaseHelper extends SQLiteOpenHelper
  {
    private boolean mBadDatabase;
    private long mLastDatabaseCheckTime = 0L;

    AnalyticsDatabaseHelper(Context paramString, String arg3)
    {
      super(str, null, 1);
    }

    private boolean tablePresent(String paramString, SQLiteDatabase paramSQLiteDatabase)
    {
      Object localObject = null;
      SQLiteDatabase localSQLiteDatabase = null;
      try
      {
        paramSQLiteDatabase = paramSQLiteDatabase.query("SQLITE_MASTER", new String[] { "name" }, "name=?", new String[] { paramString }, null, null, null);
        localSQLiteDatabase = paramSQLiteDatabase;
        localObject = paramSQLiteDatabase;
        boolean bool = paramSQLiteDatabase.moveToFirst();
        if (paramSQLiteDatabase != null)
          paramSQLiteDatabase.close();
        return bool;
      }
      catch (SQLiteException paramSQLiteDatabase)
      {
        localObject = localSQLiteDatabase;
        Log.w("Error querying for table " + paramString);
        if (localSQLiteDatabase != null)
          localSQLiteDatabase.close();
        return false;
      }
      finally
      {
        if (localObject != null)
          ((Cursor)localObject).close();
      }
      throw paramString;
    }

    private void validateColumnsPresent(SQLiteDatabase paramSQLiteDatabase)
    {
      Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT * FROM hits2 WHERE 0", null);
      HashSet localHashSet = new HashSet();
      try
      {
        String[] arrayOfString = localCursor.getColumnNames();
        i = 0;
        while (i < arrayOfString.length)
        {
          localHashSet.add(arrayOfString[i]);
          i += 1;
        }
        localCursor.close();
        if ((!localHashSet.remove("hit_id")) || (!localHashSet.remove("hit_url")) || (!localHashSet.remove("hit_string")) || (!localHashSet.remove("hit_time")))
          throw new SQLiteException("Database column missing");
      }
      finally
      {
        localCursor.close();
      }
      if (!localHashSet.remove("hit_app_id"));
      for (int i = 1; !localHashSet.isEmpty(); i = 0)
        throw new SQLiteException("Database has extra columns");
      if (i != 0)
        paramSQLiteDatabase.execSQL("ALTER TABLE hits2 ADD COLUMN hit_app_id");
    }

    public SQLiteDatabase getWritableDatabase()
    {
      if ((mBadDatabase) && (mLastDatabaseCheckTime + 3600000L > mClock.currentTimeMillis()))
        throw new SQLiteException("Database creation failed");
      Object localObject1 = null;
      mBadDatabase = true;
      mLastDatabaseCheckTime = mClock.currentTimeMillis();
      try
      {
        Object localObject2 = super.getWritableDatabase();
        localObject1 = localObject2;
        localObject2 = localObject1;
        if (localObject1 == null)
          localObject2 = super.getWritableDatabase();
        mBadDatabase = false;
        return localObject2;
      }
      catch (SQLiteException localSQLiteException)
      {
        while (true)
          mContext.getDatabasePath(mDatabaseName).delete();
      }
    }

    public void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
      FutureApis.setOwnerOnlyReadWrite(paramSQLiteDatabase.getPath());
    }

    public void onOpen(SQLiteDatabase paramSQLiteDatabase)
    {
      Cursor localCursor;
      if (Build.VERSION.SDK_INT < 15)
        localCursor = paramSQLiteDatabase.rawQuery("PRAGMA journal_mode=memory", null);
      try
      {
        localCursor.moveToFirst();
        localCursor.close();
        if (!tablePresent("hits2", paramSQLiteDatabase))
        {
          paramSQLiteDatabase.execSQL(PersistentAnalyticsStore.CREATE_HITS_TABLE);
          return;
        }
      }
      finally
      {
        localCursor.close();
      }
      validateColumnsPresent(paramSQLiteDatabase);
    }

    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
    }
  }
}