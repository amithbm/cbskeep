package com.google.android.keep.provider;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.text.TextUtils;
import com.google.android.keep.util.KeepTime;
import com.google.android.keep.util.e;
import com.google.android.keep.util.r;
import com.google.android.keep.util.w;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DatabaseHelper extends SQLiteOpenHelper
{
  private static DatabaseHelper sDatabaseHelper;
  private static final Object sLockObject = new Object();
  private final Context mContext;

  private DatabaseHelper(Context paramContext, String paramString, int paramInt)
  {
    super(paramContext, paramString, null, paramInt);
    mContext = paramContext;
  }

  private void checkUpgradeMethods()
  {
    Method[] arrayOfMethod = getClass().getMethods();
    int j = arrayOfMethod.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = arrayOfMethod[i];
      String str = ((Method)localObject).getName();
      if (str.startsWith("upgradeFrom"))
      {
        int k = Integer.valueOf(str.substring("upgradeFrom".length())).intValue();
        if (k >= 52)
          throw new IllegalStateException(String.format("Found an upgrade method for a version that does not exist. Did you forget to bump DATABASE_VERSION. %d >= %d", new Object[] { Integer.valueOf(k), Integer.valueOf(52) }));
        localObject = ((Method)localObject).getReturnType();
        if ((!localObject.equals(Void.TYPE)) && (!localObject.equals(Integer.TYPE)))
          throw new IllegalStateException(String.format("method %s must return either int or void", new Object[] { str }));
      }
      i += 1;
    }
  }

  private void createIndex(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2)
  {
    String str = paramString1 + "_" + paramString2 + "_" + "index";
    paramSQLiteDatabase.execSQL("DROP INDEX IF EXISTS " + str);
    paramSQLiteDatabase.execSQL("CREATE INDEX " + str + " ON " + paramString1 + " (" + paramString2 + ");");
  }

  private void createIndexOnIsDirty(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("DROP INDEX IF EXISTS tree_entity_is_dirty_index");
    paramSQLiteDatabase.execSQL("CREATE INDEX tree_entity_is_dirty_index ON tree_entity (is_dirty);");
    paramSQLiteDatabase.execSQL("DROP INDEX IF EXISTS list_item_is_dirty_index");
    paramSQLiteDatabase.execSQL("CREATE INDEX list_item_is_dirty_index ON list_item (is_dirty);");
    paramSQLiteDatabase.execSQL("DROP INDEX IF EXISTS blob_node_is_dirty_index");
    paramSQLiteDatabase.execSQL("CREATE INDEX blob_node_is_dirty_index ON blob_node (is_dirty);");
    paramSQLiteDatabase.execSQL("DROP INDEX IF EXISTS sharing_is_dirty_index");
    paramSQLiteDatabase.execSQL("CREATE INDEX sharing_is_dirty_index ON sharing (is_dirty);");
    paramSQLiteDatabase.execSQL("DROP INDEX IF EXISTS label_is_dirty_index");
    paramSQLiteDatabase.execSQL("CREATE INDEX label_is_dirty_index ON label (is_dirty);");
    paramSQLiteDatabase.execSQL("DROP INDEX IF EXISTS note_label_is_dirty_index");
    paramSQLiteDatabase.execSQL("CREATE INDEX note_label_is_dirty_index ON note_label (is_dirty);");
  }

  private void createNoteErrorTable(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    if (paramBoolean)
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS note_error");
    paramSQLiteDatabase.execSQL("CREATE TABLE note_error (_id INTEGER PRIMARY KEY AUTOINCREMENT,tree_entity_id INTEGER NOT NULL,code TEXT NOT NULL,data TEXT,account_id INTEGER NOT NULL,time_created INTEGER NOT NULL,dismissed INTEGER);");
    paramSQLiteDatabase.execSQL("CREATE INDEX error_tree_entity_id_index ON note_error (tree_entity_id);");
    if (paramBoolean)
      paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS note_error_delete_trigger;");
    paramSQLiteDatabase.execSQL("CREATE TRIGGER note_error_delete_trigger AFTER DELETE  ON tree_entity BEGIN  DELETE FROM note_error WHERE tree_entity_id =  OLD._id; END;");
    if (paramBoolean)
      paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS note_error_delete_on_trash_trigger;");
    paramSQLiteDatabase.execSQL("CREATE TRIGGER note_error_delete_on_trash_trigger  AFTER UPDATE OF is_trashed ON tree_entity WHEN  (  NEW.is_trashed = 1 )  BEGIN  DELETE FROM note_error WHERE tree_entity_id =  NEW._id; END;");
  }

  private void createVersionUpdateTriggers(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS tree_entity_update_version_number;");
    paramSQLiteDatabase.execSQL("CREATE TRIGGER tree_entity_update_version_number AFTER UPDATE  ON tree_entity BEGIN  UPDATE tree_entity SET version = OLD. version + 1 WHERE _id = OLD._id; END");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS blob_node_update_version_number;");
    paramSQLiteDatabase.execSQL("CREATE TRIGGER blob_node_update_version_number AFTER UPDATE  ON blob_node BEGIN  UPDATE blob_node SET version = OLD. version + 1 WHERE _id = OLD._id; END");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS list_item_update_version_number;");
    paramSQLiteDatabase.execSQL("CREATE TRIGGER list_item_update_version_number AFTER UPDATE  ON list_item BEGIN  UPDATE list_item SET version = OLD. version + 1 WHERE _id = OLD._id; END");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS label_update_version_number;");
    paramSQLiteDatabase.execSQL("CREATE TRIGGER label_update_version_number AFTER UPDATE  ON label BEGIN  UPDATE label SET version = OLD. version + 1 WHERE _id = OLD._id; END");
  }

  private void dropTables(SQLiteDatabase paramSQLiteDatabase)
  {
    Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT name FROM sqlite_master  WHERE type IN ('table','view') AND name NOT LIKE 'sqlite_%'  UNION ALL  SELECT name FROM sqlite_temp_master  WHERE type IN ('table','view')  ORDER BY 1 ", null);
    if (localCursor == null)
      return;
    try
    {
      if (localCursor.moveToNext())
        paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + localCursor.getString(0));
    }
    finally
    {
      localCursor.close();
    }
  }

  public static DatabaseHelper getInstance(Context paramContext)
  {
    synchronized (sLockObject)
    {
      if (sDatabaseHelper == null)
        sDatabaseHelper = new DatabaseHelper(paramContext, "keep.db", 52);
      paramContext = sDatabaseHelper;
      return paramContext;
    }
  }

  public static DatabaseHelper newInstance(Context paramContext)
  {
    return new DatabaseHelper(paramContext, "keep.db", 52);
  }

  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    r.c("Keep", "Bootstrapping database version: 52", new Object[0]);
    checkUpgradeMethods();
    paramSQLiteDatabase.execSQL("CREATE TABLE account (_id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT NOT NULL,last_sync_version TEXT,UNIQUE (name));");
    paramSQLiteDatabase.execSQL("CREATE TABLE tree_entity (_id INTEGER PRIMARY KEY AUTOINCREMENT,account_id INTEGER NOT NULL,uuid TEXT NOT NULL,server_id TEXT,type INTEGER NOT NULL DEFAULT 0,title TEXT,color_name TEXT,parent_id INTEGER NOT NULL DEFAULT 0,order_in_parent INTEGER NOT NULL DEFAULT 0,is_archived INTEGER NOT NULL DEFAULT 0,is_trashed INTEGER NOT NULL DEFAULT 0,has_read INTEGER NOT NULL DEFAULT 1,is_owner INTEGER NOT NULL DEFAULT 1,sharer_email TEXT,last_modifier_email TEXT,is_brix_document_created INTEGER NOT NULL DEFAULT 0,is_graveyard_off INTEGER NOT NULL DEFAULT 0,is_graveyard_closed INTEGER NOT NULL DEFAULT 0,is_new_list_item_from_top INTEGER NOT NULL DEFAULT 0,time_created INTEGER,time_last_updated INTEGER,user_edited_timestamp INTEGER,last_changes_seen_timestamp INTEGER,shared_timestamp INTEGER,is_dirty INTEGER NOT NULL DEFAULT 0,is_deleted INTEGER NOT NULL DEFAULT 0,version INTEGER NOT NULL DEFAULT 0,realtime_data_server_version TEXT,notification_state INTEGER NOT NULL DEFAULT 2,base_version TEXT,UNIQUE (account_id, uuid));");
    paramSQLiteDatabase.execSQL("CREATE TABLE blob_node (_id INTEGER PRIMARY KEY AUTOINCREMENT,account_id INTEGER NOT NULL,type INTEGER NOT NULL,uuid TEXT NOT NULL,server_id TEXT,tree_entity_id INTEGER NOT NULL,time_created INTEGER,time_last_updated INTEGER,is_dirty INTEGER NOT NULL DEFAULT 0,is_deleted INTEGER NOT NULL DEFAULT 0,version INTEGER NOT NULL DEFAULT 0,base_version TEXT,use_edited INTEGER NOT NULL DEFAULT 0,original_id INTEGER,edited_id INTEGER,UNIQUE (account_id, uuid));");
    paramSQLiteDatabase.execSQL("CREATE TABLE blob (blob_id INTEGER PRIMARY KEY AUTOINCREMENT,blob_account_id INTEGER NOT NULL,blob_type INTEGER NOT NULL,mime_type TEXT NOT NULL,media_id TEXT,file_name TEXT,blob_size INTEGER NOT NULL,data1 TEXT,data2 TEXT,extracted_text TEXT,extraction_status INTEGER NOT NULL DEFAULT 0);");
    paramSQLiteDatabase.execSQL("CREATE TABLE list_item (_id INTEGER PRIMARY KEY AUTOINCREMENT,account_id INTEGER NOT NULL,uuid TEXT NOT NULL,server_id TEXT,text TEXT,list_parent_id INTEGER NOT NULL,order_in_parent INTEGER NOT NULL DEFAULT 0,is_checked INTEGER NOT NULL DEFAULT 0,time_created INTEGER,time_last_updated INTEGER,is_dirty INTEGER NOT NULL DEFAULT 0,is_deleted INTEGER NOT NULL DEFAULT 0,version INTEGER NOT NULL DEFAULT 0,base_version TEXT,realtime_data_server_version TEXT,merge_token TEXT,UNIQUE (account_id, uuid));");
    paramSQLiteDatabase.execSQL("CREATE TABLE list_item_conflict (_id INTEGER PRIMARY KEY AUTOINCREMENT,server_id TEXT,text TEXT,list_parent_id INTEGER NOT NULL,is_checked INTEGER NOT NULL DEFAULT 0,time_last_updated INTEGER NOT NULL,merge_token TEXT);");
    paramSQLiteDatabase.execSQL("CREATE TABLE alert (_id INTEGER PRIMARY KEY AUTOINCREMENT,account_id INTEGER NOT NULL,reminder_id TEXT NOT NULL,alert_time INTEGER,scheduled_time INTEGER NOT NULL,fired_time INTEGER NOT NULL DEFAULT 0,dismissed_time INTEGER NOT NULL DEFAULT 0,state INTEGER NOT NULL,trigger_condition INTEGER);");
    paramSQLiteDatabase.execSQL("CREATE TABLE sharing (_id INTEGER PRIMARY KEY AUTOINCREMENT,tree_entity_id INTEGER NOT NULL,email TEXT,name TEXT,role INTEGER NOT NULL DEFAULT -1,avatar_uri TEXT,is_dirty INTEGER NOT NULL DEFAULT 0,is_deleted INTEGER NOT NULL DEFAULT 0,account_id INTEGER NOT NULL,gaia_id TEXT,UNIQUE (tree_entity_id, email));");
    createNoteErrorTable(paramSQLiteDatabase, false);
    paramSQLiteDatabase.execSQL("CREATE TABLE label (_id INTEGER PRIMARY KEY AUTOINCREMENT, account_id INTEGER NOT NULL, uuid TEXT NOT NULL, name TEXT NOT NULL, last_used_timestamp INTEGER NOT NULL, is_deleted INTEGER NOT NULL DEFAULT 0, is_dirty INTEGER NOT NULL DEFAULT 0, server_version_number INTEGER, version INTEGER NOT NULL DEFAULT 0, deleted_timestamp INTEGER, time_created INTEGER, user_edited_timestamp INTEGER, merged_uuids STRING, time_merged INTEGER, UNIQUE (uuid));");
    paramSQLiteDatabase.execSQL("CREATE TABLE note_label (_id INTEGER PRIMARY KEY AUTOINCREMENT,account_id INTEGER NOT NULL,tree_entity_id INTEGER NOT NULL,label_id TEXT NOT NULL,deleted_timestamp INTEGER,is_deleted INTEGER NOT NULL DEFAULT 0,is_dirty INTEGER NOT NULL DEFAULT 0,UNIQUE (tree_entity_id, label_id));");
    paramSQLiteDatabase.execSQL("CREATE TRIGGER note_label_delete_note_label_after_tree_entity_delete_trigger AFTER DELETE ON tree_entity BEGIN  DELETE FROM note_label WHERE tree_entity_id =  OLD._id; END;");
    paramSQLiteDatabase.execSQL("CREATE TRIGGER note_label_delete_note_label_after_label_delete_trigger AFTER DELETE ON label BEGIN  DELETE FROM note_label WHERE label_id =  OLD.uuid; END;");
    createVersionUpdateTriggers(paramSQLiteDatabase);
    paramSQLiteDatabase.execSQL("CREATE INDEX tree_entity_uuid_index ON tree_entity (uuid);");
    paramSQLiteDatabase.execSQL("CREATE INDEX tree_entity_parent_id_index ON tree_entity (parent_id);");
    paramSQLiteDatabase.execSQL("CREATE INDEX tree_entity_is_trashed_index ON tree_entity (is_trashed);");
    paramSQLiteDatabase.execSQL("CREATE INDEX blob_uuid_index ON blob_node (uuid);");
    paramSQLiteDatabase.execSQL("CREATE INDEX blob_tree_entity_id_index ON blob_node (tree_entity_id);");
    paramSQLiteDatabase.execSQL("CREATE INDEX list_item_uuid_index ON list_item (uuid);");
    paramSQLiteDatabase.execSQL("CREATE INDEX list_item_parent_id_index ON list_item (list_parent_id);");
    paramSQLiteDatabase.execSQL("CREATE INDEX list_item_conflict_parent_id_index ON list_item_conflict (list_parent_id);");
    paramSQLiteDatabase.execSQL("CREATE INDEX list_item_conflict_server_id_index ON list_item_conflict (server_id);");
    paramSQLiteDatabase.execSQL("CREATE INDEX sharing_tree_entity_id_index ON sharing (tree_entity_id);");
    paramSQLiteDatabase.execSQL("CREATE INDEX sharing_email_index ON sharing (email);");
    paramSQLiteDatabase.execSQL("CREATE INDEX label_account_id_index ON label (account_id);");
    paramSQLiteDatabase.execSQL("CREATE INDEX note_label_account_id_index ON note_label (account_id);");
    paramSQLiteDatabase.execSQL("CREATE INDEX note_label_tree_entity_id_index ON note_label (tree_entity_id);");
    paramSQLiteDatabase.execSQL("CREATE INDEX note_label_label_id_index ON note_label (label_id);");
    paramSQLiteDatabase.execSQL("CREATE INDEX alert_reminder_id_index ON alert (reminder_id);");
    createIndexOnIsDirty(paramSQLiteDatabase);
    m.b(paramSQLiteDatabase);
  }

  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    dropTables(paramSQLiteDatabase);
    onCreate(paramSQLiteDatabase);
  }

  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    r.c("Keep", "Upgrading database from version %d to %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    checkUpgradeMethods();
    Object localObject = getClass();
    for (int i = paramInt1; ; i = paramInt1)
    {
      try
      {
        Method localMethod = ((Class)localObject).getMethod("upgradeFrom" + i, new Class[] { SQLiteDatabase.class });
        if (localMethod.getReturnType().equals(Void.TYPE))
          localMethod.invoke(this, new Object[] { paramSQLiteDatabase });
        for (paramInt1 = i + 1; ; paramInt1 = ((Integer)localMethod.invoke(this, new Object[] { paramSQLiteDatabase })).intValue())
        {
          r.c("Keep", "Upgraded database from version %d to %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt1) });
          if (paramInt1 > i)
            break;
          throw new IllegalStateException("UpgradeFrom" + i + "() did not advance");
        }
      }
      catch (InvocationTargetException paramSQLiteDatabase)
      {
        localObject = paramSQLiteDatabase.getCause();
        if (localObject == null)
          throw new IllegalStateException("Invocation failed with null cause.", paramSQLiteDatabase);
        if ((localObject instanceof RuntimeException))
          throw ((RuntimeException)localObject);
        throw new IllegalStateException("Failed to invoke upgrade Method", (Throwable)localObject);
      }
      catch (IllegalAccessException paramSQLiteDatabase)
      {
        throw new IllegalStateException("Failed to invoke upgrade Method", paramSQLiteDatabase);
      }
      catch (NoSuchMethodException paramSQLiteDatabase)
      {
        throw new IllegalStateException("Missing upgrade from version: " + i, paramSQLiteDatabase);
      }
      if (paramInt1 > paramInt2)
        throw new IllegalStateException("UpgradeFrom" + i + "() returned an invalid version: " + paramInt1);
      if (paramInt1 == paramInt2)
        return;
    }
  }

  public void upgradeFrom1(SQLiteDatabase paramSQLiteDatabase)
  {
  }

  public void upgradeFrom10(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("ALTER TABLE alert RENAME TO alert_old");
    paramSQLiteDatabase.execSQL("CREATE TABLE alert (_id INTEGER PRIMARY KEY AUTOINCREMENT,reminder_id INTEGER NOT NULL,reminder_detail TEXT,alert_time INTEGER,scheduled_time INTEGER NOT NULL,fired_time INTEGER NOT NULL DEFAULT 0,dismissed_time INTEGER NOT NULL DEFAULT 0,state INTEGER NOT NULL)");
    paramSQLiteDatabase.execSQL("INSERT INTO alert SELECT _id,reminder_id,reminder_detail,alert_time,scheduled_time,fired_time,dismissed_time,state FROM alert_old");
    paramSQLiteDatabase.execSQL("DROP TABLE alert_old");
  }

  public void upgradeFrom11(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("ALTER TABLE reminder ADD COLUMN reminder_state INTEGER not null DEFAULT 1");
    long l = System.currentTimeMillis();
    paramSQLiteDatabase.execSQL("UPDATE reminder SET reminder_state = 2 WHERE EXISTS (SELECT * FROM alert WHERE reminder._id = alert.reminder_id AND alert.state = 3) OR (reminder.reminder_type = 0 AND reminder.time < " + l + " AND NOT EXISTS (" + "SELECT * FROM " + "alert" + " WHERE " + "reminder" + "." + "_id" + " = " + "alert" + "." + "reminder_id" + "))");
  }

  public void upgradeFrom12(SQLiteDatabase paramSQLiteDatabase)
  {
    Cursor localCursor = paramSQLiteDatabase.query("reminder", new String[] { "_id", "time" }, "reminder_type = 0", null, null, null, null);
    try
    {
      paramSQLiteDatabase.execSQL("ALTER TABLE reminder ADD COLUMN date INTEGER");
      paramSQLiteDatabase.execSQL("ALTER TABLE reminder ADD COLUMN time_of_day INTEGER");
      if ((localCursor != null) && (localCursor.getCount() > 0))
      {
        localCursor.moveToPosition(-1);
        while (localCursor.moveToNext())
        {
          long l1 = localCursor.getLong(0);
          Object localObject = new KeepTime(localCursor.getLong(1));
          long l2 = ((KeepTime)localObject).hour;
          long l3 = ((KeepTime)localObject).minute;
          long l4 = ((KeepTime)localObject).second;
          ((KeepTime)localObject).set(0, 0, 0, ((KeepTime)localObject).monthDay, ((KeepTime)localObject).month, ((KeepTime)localObject).year);
          long l5 = ((KeepTime)localObject).op();
          localObject = new ContentValues();
          ((ContentValues)localObject).put("date", Long.valueOf(l5));
          ((ContentValues)localObject).put("time_of_day", Long.valueOf(l2 * 3600000L + l3 * 60000L + l4 * 1000L));
          paramSQLiteDatabase.update("reminder", (ContentValues)localObject, "_id = " + l1, null);
        }
      }
    }
    finally
    {
      if (localCursor != null)
        localCursor.close();
    }
    if (localCursor != null)
      localCursor.close();
  }

  public void upgradeFrom13(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("ALTER TABLE reminder ADD COLUMN location_address TEXT");
    paramSQLiteDatabase.execSQL("ALTER TABLE reminder ADD COLUMN location_reference TEXT");
  }

  public void upgradeFrom14(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("ALTER TABLE reminder ADD COLUMN server_id TEXT");
  }

  public void upgradeFrom15(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("ALTER TABLE reminder RENAME TO reminder_old");
    paramSQLiteDatabase.execSQL("CREATE TABLE reminder (_id INTEGER PRIMARY KEY AUTOINCREMENT,account_id INTEGER NOT NULL,tree_entity_id INTEGER NOT NULL,reminder_type INTEGER NOT NULL,julian_day INTEGER,time_of_day INTEGER,time_period INTEGER,location_name TEXT,location_type INTEGER,latitude REAL,longitude REAL,radius INTEGER,time_created INTEGER,time_last_updated INTEGER,is_dirty INTEGER NOT NULL DEFAULT 0,is_deleted INTEGER NOT NULL DEFAULT 0,version INTEGER NOT NULL DEFAULT 0,detail TEXT,reminder_state INTEGER not null DEFAULT 1,location_address TEXT,location_reference TEXT,server_id TEXT);");
    paramSQLiteDatabase.execSQL("INSERT INTO reminder (account_id, tree_entity_id, reminder_type, time_of_day, time_period, location_name, location_type, latitude, longitude, radius, time_created, time_last_updated, is_dirty, is_deleted, version, detail, reminder_state, location_address, location_reference, server_id) SELECT account_id, tree_entity_id, reminder_type, time_of_day, time_period, location_name, location_type, latitude, longitude, radius, time_created, time_last_updated, is_dirty, is_deleted, version, detail, reminder_state, location_address, location_reference, server_id FROM reminder_old");
    Cursor localCursor = paramSQLiteDatabase.query("reminder_old", new String[] { "tree_entity_id", "time" }, "reminder_type = 0", null, null, null, null);
    if (localCursor != null)
      try
      {
        if (localCursor.getCount() > 0)
        {
          localCursor.moveToPosition(-1);
          while (localCursor.moveToNext())
          {
            long l1 = localCursor.getLong(0);
            long l2 = localCursor.getLong(1);
            ContentValues localContentValues = new ContentValues();
            e.a(localContentValues, l2);
            paramSQLiteDatabase.update("reminder", localContentValues, "tree_entity_id = " + l1, null);
          }
        }
      }
      finally
      {
        if (localCursor != null)
          localCursor.close();
      }
    if (localCursor != null)
      localCursor.close();
    paramSQLiteDatabase.execSQL("DROP TABLE reminder_old");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS reminder_update_version_number;");
    paramSQLiteDatabase.execSQL("CREATE TRIGGER reminder_update_version_number AFTER UPDATE  ON reminder BEGIN  UPDATE reminder SET version = OLD. version + 1 WHERE _id = OLD._id; END");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS reminder_update_detail");
    paramSQLiteDatabase.execSQL("CREATE TRIGGER reminder_update_detail AFTER UPDATE OF reminder_type,julian_day,time_of_day,location_type,latitude,longitude,radius ON reminder BEGIN   UPDATE reminder SET detail=    CASE NEW.reminder_type      WHEN 0 THEN NEW.julian_day || '_' || New.time_of_day      WHEN 1 THEN        CASE NEW.location_type          WHEN 3            THEN NEW.latitude || '_' || NEW.longitude || '_' || NEW.radius          ELSE NEW.location_type || '_' || NEW.radius        END    END   WHERE _id=NEW._id; END");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS reminder_insert_detail");
    paramSQLiteDatabase.execSQL("CREATE TRIGGER reminder_insert_detail AFTER INSERT ON reminder BEGIN   UPDATE reminder SET detail=    CASE NEW.reminder_type      WHEN 0 THEN NEW.julian_day || '_' || New.time_of_day      WHEN 1 THEN        CASE NEW.location_type          WHEN 3            THEN NEW.latitude || '_' || NEW.longitude || '_' || NEW.radius          ELSE NEW.location_type || '_' || NEW.radius        END    END   WHERE _id=NEW._id; END");
    paramSQLiteDatabase.execSQL("DROP INDEX IF EXISTS reminder_tree_entity_id_index");
    paramSQLiteDatabase.execSQL("CREATE INDEX reminder_tree_entity_id_index ON reminder (tree_entity_id);");
    paramSQLiteDatabase.execSQL("DROP INDEX IF EXISTS reminder_time_composite_index");
    paramSQLiteDatabase.execSQL("CREATE INDEX reminder_time_composite_index ON reminder (reminder_type, julian_day, time_of_day);");
    paramSQLiteDatabase.execSQL("DROP INDEX IF EXISTS reminder_is_dirty_index");
    paramSQLiteDatabase.execSQL("CREATE INDEX reminder_is_dirty_index ON reminder (is_dirty);");
  }

  public void upgradeFrom16(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS reminder_update_detail");
    paramSQLiteDatabase.execSQL("CREATE TRIGGER reminder_update_detail AFTER UPDATE OF reminder_state,reminder_type,julian_day,time_of_day,location_type,latitude,longitude ON reminder BEGIN   UPDATE reminder SET detail=    CASE NEW.reminder_type      WHEN 0 THEN NEW.julian_day || '_' || NEW.time_of_day || '_' || NEW.reminder_state      WHEN 1 THEN        CASE NEW.location_type          WHEN 3            THEN NEW.latitude || '_' || NEW.longitude || '_' || NEW.reminder_state          ELSE NEW.location_type || '_' || NEW.reminder_state        END    END   WHERE _id=NEW._id; END");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS reminder_insert_detail");
    paramSQLiteDatabase.execSQL("CREATE TRIGGER reminder_insert_detail AFTER INSERT ON reminder BEGIN   UPDATE reminder SET detail=    CASE NEW.reminder_type      WHEN 0 THEN NEW.julian_day || '_' || NEW.time_of_day || '_' || NEW.reminder_state      WHEN 1 THEN        CASE NEW.location_type          WHEN 3            THEN NEW.latitude || '_' || NEW.longitude || '_' || NEW.reminder_state          ELSE NEW.location_type || '_' || NEW.reminder_state        END    END   WHERE _id=NEW._id; END");
  }

  public void upgradeFrom17(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("ALTER TABLE blob ADD COLUMN extracted_text TEXT");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS text_search_extracted_text");
    paramSQLiteDatabase.execSQL("CREATE VIRTUAL TABLE text_search_extracted_text USING FTS4 (extracted_text TEXT, blob_parent_id INTEGER NOT NULL)");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS text_search_extracted_text_insert_trigger;");
    paramSQLiteDatabase.execSQL("CREATE TRIGGER text_search_extracted_text_insert_trigger AFTER INSERT  ON blob BEGIN  INSERT INTO text_search_extracted_text ( docid,extracted_text,blob_parent_id )  SELECT blob._id, blob.extracted_text, blob.tree_entity_id FROM blob WHERE blob._id =  NEW._id; END;");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS text_search_extracted_text_update_text_trigger;");
    paramSQLiteDatabase.execSQL("CREATE TRIGGER text_search_extracted_text_update_text_trigger AFTER UPDATE  OF extracted_text ON blob BEGIN  UPDATE text_search_extracted_text SET extracted_text=NEW.extracted_text WHERE docid =  NEW._id; END;");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS text_search_extracted_text_update_blob_parent_id_trigger;");
    paramSQLiteDatabase.execSQL("CREATE TRIGGER text_search_extracted_text_update_blob_parent_id_trigger AFTER UPDATE  OF tree_entity_id ON blob BEGIN  UPDATE text_search_extracted_text SET blob_parent_id=NEW.tree_entity_id WHERE docid =  NEW._id; END;");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS text_search_extracted_text_update_delete_state_trigger;");
    paramSQLiteDatabase.execSQL("CREATE TRIGGER text_search_extracted_text_update_delete_state_trigger AFTER UPDATE  OF is_deleted ON blob BEGIN  UPDATE text_search_extracted_text SET extracted_text= (CASE NEW.is_deleted WHEN 0 THEN  NEW.extracted_text ELSE  NULL END )  WHERE docid =  NEW._id; END");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS text_search_extracted_text_delete_trigger;");
    paramSQLiteDatabase.execSQL("CREATE TRIGGER text_search_extracted_text_delete_trigger AFTER DELETE  ON blob BEGIN  DELETE FROM text_search_extracted_text WHERE docid =  OLD._id; END;");
  }

  public void upgradeFrom18(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("ALTER TABLE tree_entity ADD COLUMN is_trashed INTEGER NOT NULL DEFAULT 0");
    paramSQLiteDatabase.execSQL("CREATE INDEX tree_entity_is_trashed_index ON tree_entity (is_trashed);");
  }

  public void upgradeFrom19(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("ALTER TABLE list_item ADD COLUMN base_version TEXT");
    paramSQLiteDatabase.execSQL("CREATE TABLE list_item_conflict (_id INTEGER PRIMARY KEY AUTOINCREMENT,server_id TEXT,text TEXT,list_parent_id INTEGER NOT NULL,is_checked INTEGER NOT NULL DEFAULT 0,time_last_updated INTEGER NOT NULL,merge_token TEXT);");
    paramSQLiteDatabase.execSQL("CREATE INDEX list_item_conflict_parent_id_index ON list_item_conflict (list_parent_id);");
    paramSQLiteDatabase.execSQL("ALTER TABLE tree_entity ADD COLUMN is_graveyard_off INTEGER NOT NULL DEFAULT 0");
    paramSQLiteDatabase.execSQL("ALTER TABLE tree_entity ADD COLUMN is_graveyard_closed INTEGER NOT NULL DEFAULT 0");
    paramSQLiteDatabase.execSQL("ALTER TABLE tree_entity ADD COLUMN is_new_list_item_from_top INTEGER NOT NULL DEFAULT 0");
    paramSQLiteDatabase.execSQL("DELETE FROM text_search_extracted_text");
    Cursor localCursor = paramSQLiteDatabase.query("blob", new String[] { "_id", "extracted_text", "tree_entity_id" }, null, null, null, null, null);
    try
    {
      localCursor.moveToPosition(-1);
      while (localCursor.moveToNext())
      {
        long l1 = localCursor.getLong(0);
        String str = localCursor.getString(1);
        long l2 = localCursor.getLong(2);
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("docid", Long.valueOf(l1));
        localContentValues.put("extracted_text", str);
        localContentValues.put("blob_parent_id", Long.valueOf(l2));
        paramSQLiteDatabase.insert("text_search_extracted_text", null, localContentValues);
      }
    }
    finally
    {
      localCursor.close();
    }
    localCursor.close();
  }

  public void upgradeFrom2(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE alert (_id INTEGER PRIMARY KEY AUTOINCREMENT,reminder_id INTEGER NOT NULL,alert_time INTEGER,scheduled_time INTEGER NOT NULL,broadcast_received_time INTEGER NOT NULL DEFAULT 0,fired_time INTEGER NOT NULL DEFAULT 0,last_snoozed_time INTEGER NOT NULL DEFAULT 0,dismissed_time INTEGER NOT NULL DEFAULT 0,state INTEGER NOT NULL);");
  }

  public void upgradeFrom20(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("ALTER TABLE list_item ADD COLUMN merge_token TEXT");
  }

  public void upgradeFrom21(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("ALTER TABLE blob ADD COLUMN extraction_status INTEGER NOT NULL DEFAULT 0");
  }

  public void upgradeFrom22(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("ALTER TABLE tree_entity ADD COLUMN base_version TEXT");
    paramSQLiteDatabase.execSQL("ALTER TABLE blob ADD COLUMN base_version TEXT");
  }

  public void upgradeFrom23(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE INDEX list_item_conflict_server_id_index ON list_item_conflict (server_id);");
  }

  public void upgradeFrom24(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("ALTER TABLE tree_entity ADD COLUMN user_edited_timestamp INTEGER");
    paramSQLiteDatabase.execSQL("UPDATE tree_entity SET user_edited_timestamp = time_last_updated");
  }

  public void upgradeFrom25(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("ALTER TABLE tree_entity ADD COLUMN has_read INTEGER NOT NULL DEFAULT 1");
    paramSQLiteDatabase.execSQL("ALTER TABLE tree_entity ADD COLUMN is_owner INTEGER NOT NULL DEFAULT 1");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS sharing");
    paramSQLiteDatabase.execSQL("CREATE TABLE sharing (_id INTEGER PRIMARY KEY AUTOINCREMENT,tree_entity_id INTEGER NOT NULL,email TEXT,name TEXT,role INTEGER NOT NULL DEFAULT -1,avatar_uri TEXT,is_dirty INTEGER NOT NULL DEFAULT 0,is_deleted INTEGER NOT NULL DEFAULT 0,account_id INTEGER NOT NULL,UNIQUE (tree_entity_id, email));");
    paramSQLiteDatabase.execSQL("CREATE INDEX sharing_tree_entity_id_index ON sharing (tree_entity_id);");
    paramSQLiteDatabase.execSQL("CREATE INDEX sharing_email_index ON sharing (email);");
    paramSQLiteDatabase.execSQL("CREATE INDEX sharing_is_dirty_index ON sharing (is_dirty);");
  }

  public void upgradeFrom26(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("ALTER TABLE blob RENAME TO blob_old");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS blob_node");
    paramSQLiteDatabase.execSQL("CREATE TABLE blob_node (_id INTEGER PRIMARY KEY AUTOINCREMENT,account_id INTEGER NOT NULL,type INTEGER NOT NULL,uuid TEXT NOT NULL,server_id TEXT,tree_entity_id INTEGER NOT NULL,time_created INTEGER,time_last_updated INTEGER,is_dirty INTEGER NOT NULL DEFAULT 0,is_deleted INTEGER NOT NULL DEFAULT 0,version INTEGER NOT NULL DEFAULT 0,base_version TEXT,use_edited INTEGER NOT NULL DEFAULT 0,original_id INTEGER,edited_id INTEGER,UNIQUE (account_id, uuid));");
    paramSQLiteDatabase.execSQL("CREATE TABLE blob (blob_id INTEGER PRIMARY KEY AUTOINCREMENT,blob_account_id INTEGER NOT NULL,blob_type INTEGER NOT NULL,mime_type TEXT NOT NULL,media_id TEXT,file_name TEXT,blob_size INTEGER NOT NULL,data1 TEXT,data2 TEXT,extracted_text TEXT,extraction_status INTEGER NOT NULL DEFAULT 0);");
    paramSQLiteDatabase.execSQL("INSERT INTO blob_node (_id,account_id,uuid,server_id,tree_entity_id,time_created,time_last_updated,is_dirty,is_deleted,version,base_version,type,original_id) SELECT _id,account_id,uuid,server_id,tree_entity_id,time_created,time_last_updated,is_dirty,is_deleted,version,base_version, type, _id FROM blob_old");
    paramSQLiteDatabase.execSQL("INSERT INTO blob (blob_id,blob_type,mime_type,media_id,file_name,blob_size,data1,data2,extracted_text,extraction_status, blob_account_id) SELECT _id,type,mime_type,media_id,file_name,blob_size,data1,data2,extracted_text,extraction_status, account_id FROM blob_old");
    paramSQLiteDatabase.execSQL("DROP TABLE blob_old");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS text_search_extracted_text_insert_trigger;");
    paramSQLiteDatabase.execSQL("CREATE TRIGGER text_search_extracted_text_insert_trigger AFTER INSERT  ON blob_node BEGIN  INSERT INTO text_search_extracted_text ( docid,extracted_text,blob_parent_id )  SELECT blob_node._id, blob.extracted_text, blob_node.tree_entity_id FROM blob_node JOIN blob ON CASE use_edited WHEN 1 THEN edited_id = blob_id ELSE original_id = blob_id END WHERE blob_node._id =  NEW._id; END;");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS text_search_extracted_text_update_text_trigger;");
    paramSQLiteDatabase.execSQL("CREATE TRIGGER text_search_extracted_text_update_text_trigger AFTER UPDATE  OF extracted_text ON blob BEGIN  UPDATE text_search_extracted_text SET extracted_text=NEW.extracted_text WHERE docid IN (SELECT _id FROM blob_node WHERE (CASE use_edited WHEN 1 THEN edited_id=NEW.blob_id ELSE original_id=NEW.blob_id END)); END;");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS text_search_extracted_text_update_delete_state_trigger;");
    paramSQLiteDatabase.execSQL("CREATE TRIGGER text_search_extracted_text_update_delete_state_trigger AFTER UPDATE  OF is_deleted ON blob_node BEGIN  UPDATE text_search_extracted_text SET extracted_text= (CASE NEW.is_deleted WHEN 0 THEN  (SELECT extracted_text FROM blob WHERE (CASE NEW.use_edited WHEN 1 THEN NEW.edited_id=blob_id ELSE NEW.original_id=blob_id END)) ELSE NULL END) WHERE docid=NEW._id; END;");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS text_search_extracted_text_delete_trigger;");
    paramSQLiteDatabase.execSQL("CREATE TRIGGER text_search_extracted_text_delete_trigger AFTER DELETE  ON blob_node BEGIN  DELETE FROM text_search_extracted_text WHERE docid =  OLD._id; END;");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS blob_node_update_version_number;");
    paramSQLiteDatabase.execSQL("CREATE TRIGGER blob_node_update_version_number AFTER UPDATE  ON blob_node BEGIN  UPDATE blob_node SET version = OLD. version + 1 WHERE _id = OLD._id; END");
  }

  public void upgradeFrom27(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("ALTER TABLE tree_entity ADD COLUMN notification_state INTEGER NOT NULL DEFAULT 2");
  }

  public void upgradeFrom28(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("ALTER TABLE tree_entity ADD COLUMN sharer_email TEXT");
  }

  public void upgradeFrom29(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("ALTER TABLE tree_entity ADD COLUMN last_changes_seen_timestamp INTEGER");
    paramSQLiteDatabase.execSQL("ALTER TABLE tree_entity ADD COLUMN last_modifier_email TEXT");
  }

  public void upgradeFrom3(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE reminder (_id INTEGER PRIMARY KEY AUTOINCREMENT,account_id INTEGER NOT NULL,tree_entity_id INTEGER NOT NULL,reminder_type INTEGER NOT NULL,time INTEGER,time_period INTEGER,location_id INTEGER,time_created INTEGER,time_last_updated INTEGER,is_dirty INTEGER NOT NULL DEFAULT 0,is_deleted INTEGER NOT NULL DEFAULT 0,version INTEGER NOT NULL DEFAULT 0);");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS reminder_update_version_number;");
    paramSQLiteDatabase.execSQL("CREATE TRIGGER reminder_update_version_number AFTER UPDATE  ON reminder BEGIN  UPDATE reminder SET version = OLD. version + 1 WHERE _id = OLD._id; END");
    paramSQLiteDatabase.execSQL("CREATE INDEX reminder_tree_entity_id_index ON reminder (tree_entity_id);");
    paramSQLiteDatabase.execSQL("DROP INDEX IF EXISTS reminder_is_dirty_index");
    paramSQLiteDatabase.execSQL("CREATE INDEX reminder_is_dirty_index ON reminder (is_dirty);");
  }

  public void upgradeFrom30(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("ALTER TABLE sharing ADD COLUMN invalid_email_address INTEGER NOT NULL DEFAULT 0");
    paramSQLiteDatabase.execSQL("ALTER TABLE sharing ADD COLUMN dismissed_invalid_sharee_overlay INTEGER NOT NULL DEFAULT 0");
  }

  public void upgradeFrom31(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("ALTER TABLE sharing ADD COLUMN gaia_id TEXT");
  }

  public void upgradeFrom32(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("ALTER TABLE tree_entity ADD COLUMN shared_timestamp INTEGER");
  }

  public void upgradeFrom33(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("ALTER TABLE tree_entity ADD COLUMN is_brix_document_created INTEGER NOT NULL DEFAULT 0");
  }

  public void upgradeFrom34(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("ALTER TABLE tree_entity ADD COLUMN realtime_data_server_version TEXT");
    paramSQLiteDatabase.execSQL("ALTER TABLE list_item ADD COLUMN realtime_data_server_version TEXT");
  }

  public void upgradeFrom35(SQLiteDatabase paramSQLiteDatabase)
  {
    Object localObject = new SQLiteQueryBuilder();
    ((SQLiteQueryBuilder)localObject).setTables("list_item INNER JOIN tree_entity ON list_item.list_parent_id=tree_entity._id");
    localObject = ((SQLiteQueryBuilder)localObject).query(paramSQLiteDatabase, new String[] { "list_item._id" }, "tree_entity.account_id=list_item.account_id AND tree_entity.uuid=list_item.uuid", null, null, null, null);
    if (localObject == null)
      return;
    try
    {
      if (((Cursor)localObject).moveToNext())
      {
        long l = ((Cursor)localObject).getLong(0);
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("uuid", KeepProvider.kw());
        paramSQLiteDatabase.update("list_item", localContentValues, "_id=?", new String[] { String.valueOf(l) });
      }
    }
    finally
    {
      ((Cursor)localObject).close();
    }
  }

  public void upgradeFrom36(SQLiteDatabase paramSQLiteDatabase)
  {
  }

  public void upgradeFrom37(SQLiteDatabase paramSQLiteDatabase)
  {
  }

  public void upgradeFrom38(SQLiteDatabase paramSQLiteDatabase)
  {
  }

  public void upgradeFrom39(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("ALTER TABLE sharing RENAME TO sharing_old");
    paramSQLiteDatabase.execSQL("CREATE TABLE sharing (_id INTEGER PRIMARY KEY AUTOINCREMENT,tree_entity_id INTEGER NOT NULL,email TEXT,name TEXT,role INTEGER NOT NULL DEFAULT -1,avatar_uri TEXT,is_dirty INTEGER NOT NULL DEFAULT 0,is_deleted INTEGER NOT NULL DEFAULT 0,account_id INTEGER NOT NULL,gaia_id TEXT,UNIQUE (tree_entity_id, email));");
    paramSQLiteDatabase.execSQL("INSERT INTO sharing (_id,tree_entity_id,email,name,role,avatar_uri,is_dirty,is_deleted,account_id,gaia_id) SELECT _id,tree_entity_id,email,name,role,avatar_uri,is_dirty,is_deleted,account_id,gaia_id FROM sharing_old");
    paramSQLiteDatabase.execSQL("DROP TABLE sharing_old");
  }

  public void upgradeFrom4(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE location (_id INTEGER PRIMARY KEY AUTOINCREMENT,location_name TEXT NOT NULL,location_type INTEGER NOT NULL,latitude INTEGER NOT NULL,longitude INTEGER NOT NULL,radius INTEGER NOT NULL);");
    paramSQLiteDatabase.execSQL("CREATE INDEX reminder_location_id_index ON reminder (location_id);");
  }

  public void upgradeFrom40(SQLiteDatabase paramSQLiteDatabase)
  {
    m.c(paramSQLiteDatabase);
    m.d(paramSQLiteDatabase);
    m.f(paramSQLiteDatabase, "is_deleted=0", null);
  }

  public void upgradeFrom41(SQLiteDatabase paramSQLiteDatabase)
  {
    createNoteErrorTable(paramSQLiteDatabase, true);
  }

  public void upgradeFrom42(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE label (_id INTEGER PRIMARY KEY AUTOINCREMENT,uuid TEXT NOT NULL,name TEXT NOT NULL,account_id INTEGER NOT NULL,last_used_timestamp INTEGER NOT NULL,is_deleted INTEGER NOT NULL DEFAULT 0,is_dirty INTEGER NOT NULL DEFAULT 0,UNIQUE (uuid)UNIQUE (name));");
    paramSQLiteDatabase.execSQL("CREATE TABLE label_entry (_id INTEGER PRIMARY KEY AUTOINCREMENT,tree_entity_id INTEGER NOT NULL,label_id TEXT NOT NULL,account_id INTEGER NOT NULL,is_deleted INTEGER NOT NULL DEFAULT 0,is_dirty INTEGER NOT NULL DEFAULT 0,UNIQUE (tree_entity_id, label_id));");
    paramSQLiteDatabase.execSQL("CREATE TRIGGER label_entry_delete_tree_entity_trigger AFTER DELETE  ON tree_entity BEGIN  DELETE FROM label_entry WHERE tree_entity_id =  OLD._id; END;");
    paramSQLiteDatabase.execSQL("CREATE TRIGGER label_entry_delete_label_trigger AFTER DELETE  ON label BEGIN  DELETE FROM label_entry WHERE label_id =  OLD.uuid; END;");
  }

  public void upgradeFrom43(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS label");
    paramSQLiteDatabase.execSQL("CREATE TABLE label (_id INTEGER PRIMARY KEY AUTOINCREMENT, account_id INTEGER NOT NULL, uuid TEXT NOT NULL, name TEXT NOT NULL, last_used_timestamp INTEGER NOT NULL, is_deleted INTEGER NOT NULL DEFAULT 0, is_dirty INTEGER NOT NULL DEFAULT 0, version INTEGER NOT NULL DEFAULT 0, deleted_timestamp INTEGER, time_created INTEGER, user_edited_timestamp INTEGER, merged_uuids STRING, time_merged INTEGER, UNIQUE (uuid), UNIQUE (name) );");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS label_entry");
    paramSQLiteDatabase.execSQL("CREATE TABLE note_label (_id INTEGER PRIMARY KEY AUTOINCREMENT,account_id INTEGER NOT NULL,tree_entity_id INTEGER NOT NULL,label_id TEXT NOT NULL,deleted_timestamp INTEGER,is_deleted INTEGER NOT NULL DEFAULT 0,is_dirty INTEGER NOT NULL DEFAULT 0,UNIQUE (tree_entity_id, label_id));");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS label_entry_delete_tree_entity_trigger;");
    paramSQLiteDatabase.execSQL("CREATE TRIGGER note_label_delete_note_label_after_tree_entity_delete_trigger AFTER DELETE ON tree_entity BEGIN  DELETE FROM note_label WHERE tree_entity_id =  OLD._id; END;");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS label_entry_delete_label_trigger;");
    paramSQLiteDatabase.execSQL("CREATE TRIGGER note_label_delete_note_label_after_label_delete_trigger AFTER DELETE ON label BEGIN  DELETE FROM note_label WHERE label_id =  OLD.uuid; END;");
    paramSQLiteDatabase.execSQL("CREATE INDEX label_account_id_index ON label (account_id);");
    paramSQLiteDatabase.execSQL("CREATE INDEX note_label_account_id_index ON note_label (account_id);");
    paramSQLiteDatabase.execSQL("CREATE INDEX note_label_tree_entity_id_index ON note_label (tree_entity_id);");
    paramSQLiteDatabase.execSQL("CREATE INDEX note_label_label_id_index ON note_label (label_id);");
  }

  public void upgradeFrom44(SQLiteDatabase paramSQLiteDatabase)
  {
    Cursor localCursor = paramSQLiteDatabase.query("reminder LEFT OUTER JOIN tree_entity ON (reminder.tree_entity_id=tree_entity._id)", new String[] { "reminder._id", "reminder.server_id", "tree_entity.uuid", "tree_entity.server_id" }, null, null, null, null, null);
    if (localCursor == null)
      return;
    while (true)
    {
      try
      {
        if (!localCursor.moveToNext())
          break;
        if (!TextUtils.isEmpty(localCursor.getString(1)))
          continue;
        str = localCursor.getString(2);
        Object localObject = localCursor.getString(3);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          str = w.bD((String)localObject);
          localObject = new ContentValues();
          ((ContentValues)localObject).put("server_id", str);
          paramSQLiteDatabase.update("reminder", (ContentValues)localObject, "_id=?", new String[] { localCursor.getString(0) });
          continue;
        }
      }
      finally
      {
        localCursor.close();
      }
      String str = w.bE(str);
    }
    localCursor.close();
  }

  public void upgradeFrom45(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("ALTER TABLE alert RENAME TO alert_old");
    paramSQLiteDatabase.execSQL("CREATE TABLE alert (_id INTEGER PRIMARY KEY AUTOINCREMENT,reminder_id TEXT NOT NULL,alert_time INTEGER,scheduled_time INTEGER NOT NULL,fired_time INTEGER NOT NULL DEFAULT 0,dismissed_time INTEGER NOT NULL DEFAULT 0,state INTEGER NOT NULL);");
    paramSQLiteDatabase.execSQL("INSERT INTO alert (reminder_id,alert_time,scheduled_time,fired_time,dismissed_time,state) SELECT server_id,alert_time,scheduled_time,fired_time,dismissed_time,state FROM alert_old, reminder WHERE alert_old.reminder_id = reminder._id");
    paramSQLiteDatabase.execSQL("DROP INDEX IF EXISTS alert_reminder_id_index");
    paramSQLiteDatabase.execSQL("CREATE INDEX alert_reminder_id_index ON alert (reminder_id);");
    paramSQLiteDatabase.execSQL("DROP TABLE alert_old");
  }

  public void upgradeFrom46(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS label");
    paramSQLiteDatabase.execSQL("CREATE TABLE label (_id INTEGER PRIMARY KEY AUTOINCREMENT, account_id INTEGER NOT NULL, uuid TEXT NOT NULL, name TEXT NOT NULL, last_used_timestamp INTEGER NOT NULL, is_deleted INTEGER NOT NULL DEFAULT 0, is_dirty INTEGER NOT NULL DEFAULT 0, version INTEGER NOT NULL DEFAULT 0, deleted_timestamp INTEGER, time_created INTEGER, user_edited_timestamp INTEGER, merged_uuids STRING, time_merged INTEGER, UNIQUE (uuid));");
  }

  public void upgradeFrom47(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("ALTER TABLE alert RENAME TO alert_old");
    paramSQLiteDatabase.execSQL("CREATE TABLE alert (_id INTEGER PRIMARY KEY AUTOINCREMENT,account_id INTEGER NOT NULL,reminder_id TEXT NOT NULL,alert_time INTEGER,scheduled_time INTEGER NOT NULL,fired_time INTEGER NOT NULL DEFAULT 0,dismissed_time INTEGER NOT NULL DEFAULT 0,state INTEGER NOT NULL);");
    paramSQLiteDatabase.execSQL("INSERT INTO alert (account_id,reminder_id,alert_time,scheduled_time,fired_time,dismissed_time,state) SELECT account_id,reminder_id,alert_time,scheduled_time,fired_time,dismissed_time,state FROM alert_old, reminder WHERE alert_old.reminder_id = reminder._id");
    createIndex(paramSQLiteDatabase, "alert", "reminder_id");
    createIndex(paramSQLiteDatabase, "alert", "account_id");
    paramSQLiteDatabase.execSQL("DROP TABLE alert_old");
  }

  public void upgradeFrom48(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("ALTER TABLE label RENAME TO label_old");
    paramSQLiteDatabase.execSQL("CREATE TABLE label (_id INTEGER PRIMARY KEY AUTOINCREMENT, account_id INTEGER NOT NULL, uuid TEXT NOT NULL, name TEXT NOT NULL, last_used_timestamp INTEGER NOT NULL, is_deleted INTEGER NOT NULL DEFAULT 0, is_dirty INTEGER NOT NULL DEFAULT 0, server_version_number INTEGER, version INTEGER NOT NULL DEFAULT 0,deleted_timestamp INTEGER, time_created INTEGER, user_edited_timestamp INTEGER, merged_uuids STRING, time_merged INTEGER, UNIQUE (uuid));");
    paramSQLiteDatabase.execSQL("INSERT INTO label (account_id,uuid,name,last_used_timestamp,is_deleted,server_version_number,deleted_timestamp,time_created,user_edited_timestamp,merged_uuids,time_merged) SELECT account_id,uuid,name,last_used_timestamp,is_deleted,version,deleted_timestamp,time_created,user_edited_timestamp,merged_uuids,time_merged FROM label_old");
    paramSQLiteDatabase.execSQL("UPDATE label SET is_dirty = 1");
    paramSQLiteDatabase.execSQL("DROP TABLE label_old");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS note_label_delete_note_label_after_tree_entity_delete_trigger;");
    paramSQLiteDatabase.execSQL("CREATE TRIGGER note_label_delete_note_label_after_tree_entity_delete_trigger AFTER DELETE ON tree_entity BEGIN  DELETE FROM note_label WHERE tree_entity_id =  OLD._id; END;");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS note_label_delete_note_label_after_label_delete_trigger;");
    paramSQLiteDatabase.execSQL("CREATE TRIGGER note_label_delete_note_label_after_label_delete_trigger AFTER DELETE ON label BEGIN  DELETE FROM note_label WHERE label_id =  OLD.uuid; END;");
    createIndex(paramSQLiteDatabase, "label", "account_id");
    createIndex(paramSQLiteDatabase, "note_label", "account_id");
    createIndex(paramSQLiteDatabase, "note_label", "tree_entity_id");
    createIndex(paramSQLiteDatabase, "note_label", "label_id");
  }

  public void upgradeFrom49(SQLiteDatabase paramSQLiteDatabase)
  {
    RemindersDBUpgradeService.y(mContext);
  }

  public void upgradeFrom5(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS alert");
    paramSQLiteDatabase.execSQL("CREATE TABLE alert (_id INTEGER PRIMARY KEY AUTOINCREMENT,reminder_id INTEGER NOT NULL,reminder_time INTEGER,alert_time INTEGER,scheduled_time INTEGER NOT NULL,broadcast_received_time INTEGER NOT NULL DEFAULT 0,fired_time INTEGER NOT NULL DEFAULT 0,last_snoozed_time INTEGER NOT NULL DEFAULT 0,dismissed_time INTEGER NOT NULL DEFAULT 0,state INTEGER NOT NULL);");
    mContext.sendBroadcast(new Intent("com.google.android.keep.intent.action.PROVIDER_CHANGED"));
  }

  public void upgradeFrom50(SQLiteDatabase paramSQLiteDatabase)
  {
    m.g(paramSQLiteDatabase);
  }

  public void upgradeFrom51(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("ALTER TABLE alert ADD COLUMN trigger_condition INTEGER");
  }

  public void upgradeFrom6(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS location");
    paramSQLiteDatabase.execSQL("CREATE TABLE location (_id INTEGER PRIMARY KEY AUTOINCREMENT,location_name TEXT NOT NULL,location_type INTEGER NOT NULL,latitude REAL,longitude REAL,radius INTEGER);");
  }

  public void upgradeFrom7(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE reminder_temp (_id INTEGER PRIMARY KEY AUTOINCREMENT,account_id INTEGER NOT NULL,tree_entity_id INTEGER NOT NULL,reminder_type INTEGER NOT NULL,time INTEGER,time_period INTEGER,location_name TEXT,location_type INTEGER,latitude REAL,longitude REAL,radius INTEGER,time_created INTEGER,time_last_updated INTEGER,is_dirty INTEGER NOT NULL DEFAULT 0,is_deleted INTEGER NOT NULL DEFAULT 0,version INTEGER NOT NULL DEFAULT 0);");
    paramSQLiteDatabase.execSQL("INSERT INTO reminder_temp (account_id, tree_entity_id, reminder_type, time, time_period, time_created, time_last_updated, is_dirty, is_deleted, version) SELECT account_id, tree_entity_id, reminder_type, time, time_period, time_created, time_last_updated, is_dirty, is_deleted, version FROM reminder WHERE reminder_type = 0");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS location");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS reminder");
    paramSQLiteDatabase.execSQL("ALTER TABLE reminder_temp RENAME TO reminder");
    paramSQLiteDatabase.execSQL("CREATE INDEX reminder_tree_entity_id_index ON reminder (tree_entity_id);");
    paramSQLiteDatabase.execSQL("CREATE INDEX reminder_time_composite_index ON reminder (reminder_type, time);");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS reminder_update_version_number;");
    paramSQLiteDatabase.execSQL("CREATE TRIGGER reminder_update_version_number AFTER UPDATE  ON reminder BEGIN  UPDATE reminder SET version = OLD. version + 1 WHERE _id = OLD._id; END");
  }

  public void upgradeFrom8(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("ALTER TABLE alert RENAME TO alert_old");
    paramSQLiteDatabase.execSQL("CREATE TABLE alert (_id INTEGER PRIMARY KEY AUTOINCREMENT,reminder_id INTEGER NOT NULL,reminder_detail TEXT,alert_time INTEGER,scheduled_time INTEGER NOT NULL,broadcast_received_time INTEGER NOT NULL DEFAULT 0,fired_time INTEGER NOT NULL DEFAULT 0,last_snoozed_time INTEGER NOT NULL DEFAULT 0,dismissed_time INTEGER NOT NULL DEFAULT 0,state INTEGER NOT NULL)");
    paramSQLiteDatabase.execSQL("INSERT INTO alert (reminder_id,reminder_detail,alert_time,scheduled_time,broadcast_received_time,fired_time,last_snoozed_time,dismissed_time,state) SELECT reminder_id,alert_time,alert_time,scheduled_time,broadcast_received_time,fired_time,last_snoozed_time,dismissed_time,state FROM alert_old");
    paramSQLiteDatabase.execSQL("DROP TABLE alert_old");
    paramSQLiteDatabase.execSQL("ALTER TABLE reminder ADD COLUMN detail TEXT");
  }

  public void upgradeFrom9(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS reminder_update_detail");
    paramSQLiteDatabase.execSQL("CREATE TRIGGER reminder_update_detail AFTER UPDATE OF reminder_type,time,location_type,latitude,longitude,radius ON reminder BEGIN   UPDATE reminder SET detail=    CASE NEW.reminder_type      WHEN 0 THEN NEW.time      WHEN 1 THEN        CASE NEW.location_type          WHEN 3            THEN NEW.latitude || '_' || NEW.longitude || '_' || NEW.radius          ELSE NEW.location_type || '_' || NEW.radius        END    END   WHERE _id=NEW._id; END");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS reminder_insert_detail");
    paramSQLiteDatabase.execSQL("CREATE TRIGGER reminder_insert_detail AFTER INSERT ON reminder BEGIN   UPDATE reminder SET detail=    CASE NEW.reminder_type      WHEN 0 THEN NEW.time      WHEN 1 THEN        CASE NEW.location_type          WHEN 3            THEN NEW.latitude || '_' || NEW.longitude || '_' || NEW.radius          ELSE NEW.location_type || '_' || NEW.radius        END    END   WHERE _id=NEW._id; END");
  }
}