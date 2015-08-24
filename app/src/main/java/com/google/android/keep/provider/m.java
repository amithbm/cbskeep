package com.google.android.keep.provider;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class m
{
  private static final Pattern DR = Pattern.compile("\\\"(.*?)\\\"");

  private static List<MatchResult> a(Pattern paramPattern, String paramString)
  {
    ArrayList localArrayList = Lists.newArrayList();
    paramPattern = paramPattern.matcher(paramString);
    for (int i = 0; paramPattern.find(i); i = paramPattern.end())
      localArrayList.add(paramPattern.toMatchResult());
    return localArrayList;
  }

  public static String aN(String paramString)
  {
    return a.aR(paramString);
  }

  public static String[] aO(String paramString)
  {
    if (paramString == null)
      throw new IllegalStateException("Can't perform search query with null query");
    if (TextUtils.isEmpty(paramString))
      return null;
    paramString = aP(paramString);
    return new String[] { paramString, paramString, paramString, paramString, paramString, paramString };
  }

  static String aP(String paramString)
  {
    ArrayList localArrayList = Lists.newArrayList();
    paramString = aQ(paramString).iterator();
    while (paramString.hasNext())
    {
      String str = (String)paramString.next();
      localArrayList.add("\"" + str + "*\"");
    }
    return TextUtils.join(" ", localArrayList);
  }

  static Set<String> aQ(String paramString)
  {
    HashSet localHashSet = Sets.newHashSet();
    Object localObject = Sets.newHashSet();
    Iterator localIterator = a(DR, paramString).iterator();
    while (localIterator.hasNext())
    {
      MatchResult localMatchResult = (MatchResult)localIterator.next();
      String str = localMatchResult.group(1);
      ((Set)localObject).add(localMatchResult.group());
      localHashSet.add(str.trim());
    }
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
      paramString = paramString.replace((String)((Iterator)localObject).next(), " ");
    localObject = paramString;
    if (!TextUtils.isEmpty(paramString))
      localObject = paramString.replace("\"", " ");
    paramString = TextUtils.split((String)localObject, " ");
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      localObject = paramString[i];
      if (!TextUtils.isEmpty((CharSequence)localObject))
        localHashSet.add(localObject);
      i += 1;
    }
    return localHashSet;
  }

  static void b(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS text_search_tree_entities");
    paramSQLiteDatabase.execSQL("CREATE VIRTUAL TABLE text_search_tree_entities USING FTS4 (title TEXT)");
    d(paramSQLiteDatabase, "is_deleted=0", null);
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS text_search_list_items");
    paramSQLiteDatabase.execSQL("CREATE VIRTUAL TABLE text_search_list_items USING FTS4 (text TEXT, list_parent_id INTEGER NOT NULL)");
    e(paramSQLiteDatabase, "is_deleted=0", null);
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS text_search_extracted_text");
    paramSQLiteDatabase.execSQL("CREATE VIRTUAL TABLE text_search_extracted_text USING FTS4 (extracted_text TEXT, blob_parent_id INTEGER NOT NULL)");
    g(paramSQLiteDatabase, "is_deleted=0", null);
    c(paramSQLiteDatabase);
    f(paramSQLiteDatabase, "is_deleted=0", null);
    g(paramSQLiteDatabase);
    e(paramSQLiteDatabase);
    f(paramSQLiteDatabase);
    j(paramSQLiteDatabase);
    d(paramSQLiteDatabase);
  }

  public static void c(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS text_search_sharing");
    paramSQLiteDatabase.execSQL("CREATE VIRTUAL TABLE text_search_sharing USING FTS4 (tree_entity_id INTEGER NOT NULL, email TEXT, name TEXT)");
  }

  public static void d(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS text_search_sharing_insert_trigger;");
    paramSQLiteDatabase.execSQL("CREATE TRIGGER text_search_sharing_insert_trigger AFTER INSERT ON sharing BEGIN  INSERT INTO text_search_sharing ( docid,tree_entity_id,email,name )  SELECT sharing._id, sharing.tree_entity_id, sharing.email, sharing.name FROM sharing WHERE sharing._id =  NEW._id; END;");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS text_search_sharing_update_delete_state_trigger;");
    paramSQLiteDatabase.execSQL("CREATE TRIGGER text_search_sharing_update_delete_state_trigger AFTER UPDATE OF is_deleted ON sharing BEGIN  UPDATE text_search_sharing SET name= (CASE NEW.is_deleted WHEN 0 THEN NEW.name ELSE NULL END), email= (CASE NEW.is_deleted WHEN 0 THEN NEW.email ELSE NULL END)  WHERE docid= NEW._id; END;");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS text_search_sharing_delete_trigger;");
    paramSQLiteDatabase.execSQL("CREATE TRIGGER text_search_sharing_delete_trigger AFTER DELETE ON sharing BEGIN  DELETE FROM text_search_sharing WHERE docid=OLD._id; END;");
  }

  private static void d(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    paramString = paramSQLiteDatabase.query("tree_entity", new String[] { "_id", "title" }, paramString, paramArrayOfString, null, null, null);
    try
    {
      paramString.moveToPosition(-1);
      while (paramString.moveToNext())
      {
        long l = paramString.getLong(0);
        paramArrayOfString = paramString.getString(1);
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("docid", Long.valueOf(l));
        localContentValues.put("title", paramArrayOfString);
        paramSQLiteDatabase.insert("text_search_tree_entities", null, localContentValues);
      }
    }
    finally
    {
      paramString.close();
    }
    paramString.close();
  }

  private static void e(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS text_search_tree_entities_insert_trigger;");
    paramSQLiteDatabase.execSQL("CREATE TRIGGER text_search_tree_entities_insert_trigger AFTER INSERT  ON tree_entity BEGIN  INSERT INTO text_search_tree_entities ( docid,title )  SELECT tree_entity._id, tree_entity.title FROM tree_entity WHERE tree_entity._id =  NEW._id; END;");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS text_search_tree_entities_update_title_trigger;");
    paramSQLiteDatabase.execSQL("CREATE TRIGGER text_search_tree_entities_update_title_trigger AFTER UPDATE  OF title ON tree_entity BEGIN  UPDATE text_search_tree_entities SET title=NEW.title WHERE docid =  NEW._id; END;");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS text_search_tree_entities_update_delete_state_trigger;");
    paramSQLiteDatabase.execSQL("CREATE TRIGGER text_search_tree_entities_update_delete_state_trigger AFTER UPDATE  OF is_deleted ON tree_entity BEGIN  UPDATE text_search_tree_entities SET title= (CASE NEW.is_deleted WHEN 0 THEN  NEW.title ELSE  NULL END )  WHERE docid =  NEW._id; END;");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS text_search_tree_entities_delete_trigger;");
    paramSQLiteDatabase.execSQL("CREATE TRIGGER text_search_tree_entities_delete_trigger AFTER DELETE  ON tree_entity BEGIN  DELETE FROM text_search_tree_entities WHERE docid =  OLD._id; END;");
  }

  private static void e(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    paramString = paramSQLiteDatabase.query("list_item", new String[] { "_id", "text", "list_parent_id" }, paramString, paramArrayOfString, null, null, null);
    try
    {
      paramString.moveToPosition(-1);
      while (paramString.moveToNext())
      {
        long l1 = paramString.getLong(0);
        paramArrayOfString = paramString.getString(1);
        long l2 = paramString.getLong(2);
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("docid", Long.valueOf(l1));
        localContentValues.put("text", paramArrayOfString);
        localContentValues.put("list_parent_id", Long.valueOf(l2));
        paramSQLiteDatabase.insert("text_search_list_items", null, localContentValues);
      }
    }
    finally
    {
      paramString.close();
    }
    paramString.close();
  }

  private static void f(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS text_search_list_items_insert_trigger;");
    paramSQLiteDatabase.execSQL("CREATE TRIGGER text_search_list_items_insert_trigger AFTER INSERT  ON list_item BEGIN  INSERT INTO text_search_list_items ( docid,text,list_parent_id )  SELECT list_item._id, list_item.text, list_item.list_parent_id FROM list_item WHERE list_item._id =  NEW._id; END;");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS text_search_list_items_update_text_trigger;");
    paramSQLiteDatabase.execSQL("CREATE TRIGGER text_search_list_items_update_text_trigger AFTER UPDATE  OF text ON list_item BEGIN  UPDATE text_search_list_items SET text=NEW.text WHERE docid =  NEW._id; END;");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS text_search_list_items_update_list_parent_id_trigger;");
    paramSQLiteDatabase.execSQL("CREATE TRIGGER text_search_list_items_update_list_parent_id_trigger AFTER UPDATE  OF list_parent_id ON list_item BEGIN  UPDATE text_search_list_items SET list_parent_id=NEW.list_parent_id WHERE docid =  NEW._id; END;");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS text_search_list_items_update_delete_state_trigger;");
    paramSQLiteDatabase.execSQL("CREATE TRIGGER text_search_list_items_update_delete_state_trigger AFTER UPDATE  OF is_deleted ON list_item BEGIN  UPDATE text_search_list_items SET text= (CASE NEW.is_deleted WHEN 0 THEN  NEW.text ELSE  NULL END )  WHERE docid =  NEW._id; END;");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS text_search_list_items_delete_trigger;");
    paramSQLiteDatabase.execSQL("CREATE TRIGGER text_search_list_items_delete_trigger AFTER DELETE  ON list_item BEGIN  DELETE FROM text_search_list_items WHERE docid =  OLD._id; END;");
  }

  public static void f(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    paramString = paramSQLiteDatabase.query("sharing", new String[] { "_id", "tree_entity_id", "email", "name" }, paramString, paramArrayOfString, null, null, null);
    if (paramString == null)
      return;
    try
    {
      paramString.moveToPosition(-1);
      while (paramString.moveToNext())
      {
        long l1 = paramString.getLong(0);
        long l2 = paramString.getLong(1);
        paramArrayOfString = paramString.getString(2);
        String str = paramString.getString(3);
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("docid", Long.valueOf(l1));
        localContentValues.put("tree_entity_id", Long.valueOf(l2));
        localContentValues.put("email", paramArrayOfString);
        localContentValues.put("name", str);
        paramSQLiteDatabase.insert("text_search_sharing", null, localContentValues);
      }
    }
    finally
    {
      paramString.close();
    }
    paramString.close();
  }

  public static void g(SQLiteDatabase paramSQLiteDatabase)
  {
    h(paramSQLiteDatabase);
    k(paramSQLiteDatabase);
    i(paramSQLiteDatabase);
  }

  static void g(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    paramString = paramSQLiteDatabase.query("blob_node JOIN blob ON CASE use_edited WHEN 1 THEN edited_id = blob_id ELSE original_id = blob_id END", new String[] { "blob_node._id", "extracted_text", "tree_entity_id" }, paramString, paramArrayOfString, null, null, null);
    try
    {
      paramString.moveToPosition(-1);
      while (paramString.moveToNext())
      {
        long l1 = paramString.getLong(0);
        paramArrayOfString = paramString.getString(1);
        long l2 = paramString.getLong(2);
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("docid", Long.valueOf(l1));
        localContentValues.put("extracted_text", paramArrayOfString);
        localContentValues.put("blob_parent_id", Long.valueOf(l2));
        paramSQLiteDatabase.insert("text_search_extracted_text", null, localContentValues);
      }
    }
    finally
    {
      paramString.close();
    }
    paramString.close();
  }

  private static void h(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS text_search_labels");
    paramSQLiteDatabase.execSQL("CREATE VIRTUAL TABLE text_search_labels USING FTS4 (tree_entity_id INTEGER NOT NULL, name TEXT)");
  }

  private static void i(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS text_search_labels_insert_trigger;");
    paramSQLiteDatabase.execSQL("CREATE TRIGGER text_search_labels_insert_trigger AFTER INSERT  ON note_label BEGIN  INSERT INTO text_search_labels ( docid,name,tree_entity_id )  SELECT note_label._id, label.name, note_label.tree_entity_id FROM note_label LEFT OUTER JOIN label ON (note_label.label_id=label.uuid) WHERE note_label._id =  NEW._id; END;");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS text_search_labels_update_text_trigger;");
    paramSQLiteDatabase.execSQL("CREATE TRIGGER text_search_labels_update_text_trigger AFTER UPDATE  OF name ON label BEGIN  UPDATE text_search_labels SET name=NEW.name WHERE name =  OLD.name; END;");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS text_search_labels_update_note_label_delete_state_trigger;");
    paramSQLiteDatabase.execSQL("CREATE TRIGGER text_search_labels_update_note_label_delete_state_trigger AFTER UPDATE OF is_deleted ON note_label BEGIN  UPDATE text_search_labels SET name= (CASE NEW.is_deleted WHEN 0 THEN  (SELECT name FROM label WHERE label.uuid=NEW.label_id) ELSE NULL END) WHERE docid=NEW._id; END;");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS text_search_labels_update_label_delete_state_trigger;");
    paramSQLiteDatabase.execSQL("CREATE TRIGGER text_search_labels_update_label_delete_state_trigger AFTER UPDATE  OF is_deleted ON label BEGIN  UPDATE text_search_labels SET name= (CASE NEW.is_deleted WHEN 0 THEN  NEW.name ELSE  NULL END )  WHERE name =  NEW.name; END;");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS text_search_labels_delete_trigger;");
    paramSQLiteDatabase.execSQL("CREATE TRIGGER text_search_labels_delete_trigger AFTER DELETE  ON note_label BEGIN  DELETE FROM text_search_labels WHERE docid =  OLD._id; END;");
  }

  private static void j(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS text_search_extracted_text_insert_trigger;");
    paramSQLiteDatabase.execSQL("CREATE TRIGGER text_search_extracted_text_insert_trigger AFTER INSERT  ON blob_node BEGIN  INSERT INTO text_search_extracted_text ( docid,extracted_text,blob_parent_id )  SELECT blob_node._id, blob.extracted_text, blob_node.tree_entity_id FROM blob_node JOIN blob ON CASE use_edited WHEN 1 THEN edited_id = blob_id ELSE original_id = blob_id END WHERE blob_node._id =  NEW._id; END;");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS text_search_extracted_text_update_text_trigger;");
    paramSQLiteDatabase.execSQL("CREATE TRIGGER text_search_extracted_text_update_text_trigger AFTER UPDATE  OF extracted_text ON blob BEGIN  UPDATE text_search_extracted_text SET extracted_text=NEW.extracted_text WHERE docid IN (SELECT _id FROM blob_node WHERE (CASE use_edited WHEN 1 THEN edited_id=NEW.blob_id ELSE original_id=NEW.blob_id END)); END;");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS text_search_extracted_text_update_delete_state_trigger;");
    paramSQLiteDatabase.execSQL("CREATE TRIGGER text_search_extracted_text_update_delete_state_trigger AFTER UPDATE  OF is_deleted ON blob_node BEGIN  UPDATE text_search_extracted_text SET extracted_text= (CASE NEW.is_deleted WHEN 0 THEN  (SELECT extracted_text FROM blob WHERE (CASE NEW.use_edited WHEN 1 THEN NEW.edited_id=blob_id ELSE NEW.original_id=blob_id END)) ELSE NULL END) WHERE docid=NEW._id; END;");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS text_search_extracted_text_delete_trigger;");
    paramSQLiteDatabase.execSQL("CREATE TRIGGER text_search_extracted_text_delete_trigger AFTER DELETE  ON blob_node BEGIN  DELETE FROM text_search_extracted_text WHERE docid =  OLD._id; END;");
  }

  static void k(SQLiteDatabase paramSQLiteDatabase)
  {
    Cursor localCursor = paramSQLiteDatabase.query("note_label LEFT OUTER JOIN label ON (note_label.label_id=label.uuid)", new String[] { "note_label._id", "name", "tree_entity_id" }, "label.is_deleted=0 AND note_label.is_deleted=0", null, null, null, null);
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
        localContentValues.put("name", str);
        localContentValues.put("tree_entity_id", Long.valueOf(l2));
        paramSQLiteDatabase.insert("text_search_labels", null, localContentValues);
      }
    }
    finally
    {
      localCursor.close();
    }
    localCursor.close();
  }

  public static class a
  {
    private static List<String> DS;
    private static List<Integer> DT;
    private static StringBuilder DU;

    public static String aR(String paramString)
    {
      if (TextUtils.isEmpty(paramString));
      for (paramString = ""; ; paramString = "tree_entity._id IN (SELECT text_search_tree_entities.docid FROM text_search_tree_entities WHERE text_search_tree_entities MATCH ?  UNION ALL SELECT list_parent_id FROM text_search_list_items WHERE text_search_list_items.text MATCH ?  UNION ALL SELECT tree_entity_id FROM text_search_sharing WHERE text_search_sharing.name MATCH ?  UNION ALL SELECT tree_entity_id FROM text_search_sharing WHERE text_search_sharing.email MATCH ?  UNION ALL SELECT tree_entity_id FROM text_search_labels WHERE text_search_labels.name MATCH ?  UNION ALL SELECT blob_parent_id FROM text_search_extracted_text WHERE text_search_extracted_text.extracted_text MATCH ?) AND tree_entity.is_trashed=0")
      {
        DU = new StringBuilder(paramString);
        kC();
        kD();
        return DU.toString();
      }
    }

    public static boolean c(Integer paramInteger)
    {
      return (DT != null) && (DT.contains(paramInteger));
    }

    public static void kC()
    {
      if ((DT == null) || (DT.size() == 0));
      int i;
      label38: int j;
      do
      {
        return;
        Iterator localIterator;
        while (!localIterator.hasNext())
        {
          if (DU.length() != 0)
            break;
          i = 1;
          localIterator = DT.iterator();
        }
        j = ((Integer)localIterator.next()).intValue();
      }
      while (j == 4);
      if (i == 0)
        DU.append(" AND ");
      switch (j)
      {
      case 4:
      default:
      case 3:
      case 2:
      case 1:
      case 5:
      }
      while (true)
      {
        i = 0;
        break label38;
        i = 0;
        break;
        DU.append("tree_entity._id IN (SELECT blob_node.tree_entity_id FROM blob_node WHERE blob_node.type=0)");
        continue;
        DU.append("tree_entity._id IN (SELECT blob_node.tree_entity_id FROM blob_node WHERE blob_node.type=1)");
        continue;
        DU.append("tree_entity.type=1");
        continue;
        DU.append("tree_entity._id IN (SELECT DISTINCT sharing.tree_entity_id FROM sharing)");
      }
    }

    private static void kD()
    {
      if ((DS != null) && (!DS.isEmpty()))
      {
        if (DU.length() > 0)
          DU.append(" AND ");
        DU.append("(tree_entity.color_name IN (");
        int k = 0;
        int j = 1;
        int i = 0;
        if (i < DS.size())
        {
          if ((String)DS.get(i) != null)
          {
            if (j == 0)
              DU.append(", ");
            DU.append("\"");
            DU.append((String)DS.get(i));
            DU.append("\"");
            j = 0;
          }
          while (true)
          {
            i += 1;
            break;
            k = 1;
          }
        }
        DU.append(')');
        if (k != 0)
          DU.append(" OR tree_entity.color_name IS NULL");
        DU.append(')');
      }
    }

    public static void q(List<String> paramList)
    {
      DS = paramList;
    }

    public static void r(List<Integer> paramList)
    {
      DT = paramList;
    }
  }
}