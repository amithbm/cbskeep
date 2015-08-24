package com.google.android.keep.sharing;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.drive.realtime.CollaborativeList;
import com.google.android.gms.drive.realtime.CollaborativeMap;
import com.google.android.gms.drive.realtime.CollaborativeString;
import com.google.android.gms.drive.realtime.CompoundOperation;
import com.google.android.gms.drive.realtime.Model;
import com.google.android.keep.activities.KeepApplication;
import com.google.android.keep.model.ListItem;
import com.google.android.keep.model.TreeEntity.TreeEntityType;
import com.google.android.keep.provider.ReorderEntitiesHelper;
import com.google.android.keep.task.b;
import com.google.android.keep.util.Config;
import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class a
{
  private static final Comparator Eq = new Comparator()
  {
    public int compare(Object paramAnonymousObject1, Object paramAnonymousObject2)
    {
      if ((!(paramAnonymousObject1 instanceof CollaborativeMap)) || (!(paramAnonymousObject2 instanceof CollaborativeMap)))
        throw new IllegalArgumentException("Object is not a CollaborativeListItem");
      long l = a.f((CollaborativeMap)paramAnonymousObject1) - a.f((CollaborativeMap)paramAnonymousObject2);
      if (l == 0L)
        return 0;
      if (l > 0L)
        return -1;
      return 1;
    }
  };

  public static long a(Context paramContext, long paramLong, Model paramModel, List<CollaborativeMap> paramList, boolean paramBoolean)
  {
    long l3;
    if (paramList.size() == 0)
    {
      l3 = 0L;
      return l3;
    }
    long l2;
    if (paramBoolean)
      l2 = f((CollaborativeMap)paramList.get(paramList.size() - 1));
    for (long l1 = ReorderEntitiesHelper.b(Long.valueOf(l2), null); ; l1 = ReorderEntitiesHelper.b(null, Long.valueOf(l2)))
    {
      l3 = l1;
      if (l1 != l2)
        break;
      a(paramContext, paramModel, paramList, paramLong);
      a(paramContext, paramLong, paramModel, paramList, paramBoolean);
      return l1;
      l2 = f((CollaborativeMap)paramList.get(0));
    }
  }

  public static CollaborativeMap a(Context paramContext, Model paramModel, ListItem paramListItem)
  {
    return a(paramContext, paramModel, paramListItem.gu(), paramListItem.getText(), paramListItem.isChecked(), paramListItem.hu().longValue());
  }

  public static CollaborativeMap a(Context paramContext, Model paramModel, String paramString1, String paramString2, boolean paramBoolean, long paramLong)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("keep_uuid", paramString1);
    localHashMap.put("keep_is_checked", Boolean.valueOf(paramBoolean));
    localHashMap.put("keep_sort_value", Long.valueOf(paramLong));
    paramString1 = paramModel.createString();
    paramString1.setText(paramString2);
    localHashMap.put("keep_text", paramString1);
    localHashMap.put("keep_debug_created_by", "ANDROID_" + KeepApplication.c(paramContext));
    localHashMap.put("keep_debug_created_on", new Date().toString());
    paramContext = paramModel.createMap();
    paramContext.putAll(localHashMap);
    return paramContext;
  }

  public static CollaborativeMap a(Model paramModel, String paramString1, String paramString2)
  {
    CollaborativeMap localCollaborativeMap = paramModel.createMap();
    CollaborativeString localCollaborativeString = paramModel.createString();
    localCollaborativeString.setText(paramString2);
    localCollaborativeMap.put("keep_text", localCollaborativeString);
    localCollaborativeMap.put("keep_uuid", paramString1);
    paramModel.getRoot().put("keep_note_body", localCollaborativeMap);
    return localCollaborativeMap;
  }

  public static CollaborativeMap a(Model paramModel, boolean paramBoolean1, boolean paramBoolean2)
  {
    CollaborativeMap localCollaborativeMap = paramModel.createMap();
    localCollaborativeMap.put("keep_checked_list_items_policy", am(paramBoolean1));
    localCollaborativeMap.put("keep_new_list_item_placement", an(paramBoolean2));
    paramModel.getRoot().put("keep_list_settings_v2", localCollaborativeMap);
    return localCollaborativeMap;
  }

  public static CollaborativeString a(Model paramModel, String paramString)
  {
    CollaborativeMap localCollaborativeMap = paramModel.getRoot();
    if (localCollaborativeMap.containsKey(paramString))
      return (CollaborativeString)localCollaborativeMap.get(paramString);
    paramModel = paramModel.createString();
    localCollaborativeMap.put(paramString, paramModel);
    return paramModel;
  }

  public static List<CollaborativeMap> a(CollaborativeList paramCollaborativeList)
  {
    LinkedList localLinkedList = Lists.newLinkedList();
    if (paramCollaborativeList == null)
      return localLinkedList;
    localLinkedList.addAll(paramCollaborativeList);
    Collections.sort(localLinkedList, Eq);
    return localLinkedList;
  }

  public static List<CollaborativeMap> a(CollaborativeList paramCollaborativeList, boolean paramBoolean)
  {
    LinkedList localLinkedList = Lists.newLinkedList();
    if (paramCollaborativeList == null)
      return localLinkedList;
    paramCollaborativeList = paramCollaborativeList.iterator();
    while (paramCollaborativeList.hasNext())
    {
      Object localObject = paramCollaborativeList.next();
      if (((Boolean)((CollaborativeMap)localObject).get("keep_is_checked")).booleanValue() == paramBoolean)
        localLinkedList.add(localObject);
    }
    Collections.sort(localLinkedList, Eq);
    return localLinkedList;
  }

  public static void a(Context paramContext, Model paramModel, final List<CollaborativeMap> paramList, long paramLong)
  {
    int i = paramList.size();
    final String[] arrayOfString = new String[i];
    final long[] arrayOfLong = new long[i];
    paramList = new CompoundOperation()
    {
      public void performCompoundOperation(Model paramAnonymousModel)
      {
        int j = 0;
        int i = 0;
        while (i < Er)
        {
          paramAnonymousModel = (CollaborativeMap)paramList.get(i);
          paramAnonymousModel.put("keep_sort_value", Integer.valueOf(j));
          arrayOfLong[i] = j;
          arrayOfString[i] = ((String)paramAnonymousModel.get("keep_uuid"));
          j = (int)(j - ReorderEntitiesHelper.Db);
          i += 1;
        }
      }
    };
    paramModel.performCompoundOperation(paramList, paramList.getClass().getSimpleName());
    new b(paramContext, paramLong, arrayOfString, arrayOfLong).execute(new Void[0]);
  }

  public static void a(CollaborativeMap paramCollaborativeMap, long paramLong)
  {
    if ((paramCollaborativeMap != null) && (f(paramCollaborativeMap) != paramLong))
      paramCollaborativeMap.put("keep_sort_value", Long.valueOf(paramLong));
  }

  public static void a(CollaborativeMap paramCollaborativeMap, boolean paramBoolean)
  {
    if ((paramCollaborativeMap != null) && (e(paramCollaborativeMap) != paramBoolean))
      paramCollaborativeMap.put("keep_is_checked", Boolean.valueOf(paramBoolean));
  }

  public static void a(CollaborativeString paramCollaborativeString, String paramString)
  {
    if ((paramCollaborativeString != null) && (!TextUtils.equals(paramCollaborativeString.toString(), paramString)))
      paramCollaborativeString.setText(paramString);
  }

  public static void a(Model paramModel, TreeEntity.TreeEntityType paramTreeEntityType)
  {
    paramTreeEntityType = TreeEntity.TreeEntityType.f(paramTreeEntityType);
    if (paramTreeEntityType != paramModel.getRoot().get("keep_note_type"))
      paramModel.getRoot().put("keep_note_type", paramTreeEntityType);
  }

  public static String am(boolean paramBoolean)
  {
    if (paramBoolean)
      return "GRAVEYARD";
    return "DEFAULT";
  }

  public static String an(boolean paramBoolean)
  {
    if (paramBoolean)
      return "TOP";
    return "BOTTOM";
  }

  public static void b(Model paramModel, String paramString)
  {
    paramModel = paramModel.getRoot();
    if (paramModel.containsKey("keep_title"))
      ((CollaborativeString)paramModel.get("keep_title")).setText(paramString);
  }

  public static void b(Model paramModel, String paramString1, String paramString2)
  {
    paramModel = l(paramModel);
    if (paramModel != null)
    {
      ((CollaborativeString)paramModel.get("keep_text")).setText(paramString2);
      paramModel.put("keep_uuid", paramString1);
    }
  }

  public static void b(Model paramModel, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramModel = h(paramModel);
    if (paramModel != null)
    {
      paramModel.put("keep_checked_list_items_policy", am(paramBoolean1));
      paramModel.put("keep_new_list_item_placement", an(paramBoolean2));
    }
  }

  public static boolean b(Model paramModel)
  {
    return Config.nX() < e(paramModel);
  }

  public static CollaborativeString c(CollaborativeMap paramCollaborativeMap)
  {
    return (CollaborativeString)paramCollaborativeMap.get("keep_text");
  }

  public static String c(Model paramModel)
  {
    return (String)paramModel.getRoot().get("keep_uuid");
  }

  public static TreeEntity.TreeEntityType d(Model paramModel)
  {
    paramModel = paramModel.getRoot();
    if (paramModel.containsKey("keep_note_type"));
    for (paramModel = (String)paramModel.get("keep_note_type"); TreeEntity.TreeEntityType.f(TreeEntity.TreeEntityType.zP).equals(paramModel); paramModel = TreeEntity.TreeEntityType.f(TreeEntity.TreeEntityType.zO))
      return TreeEntity.TreeEntityType.zP;
    return TreeEntity.TreeEntityType.zO;
  }

  public static String d(CollaborativeMap paramCollaborativeMap)
  {
    return (String)paramCollaborativeMap.get("keep_uuid");
  }

  public static int e(Model paramModel)
  {
    paramModel = paramModel.getRoot();
    if (paramModel.containsKey("keep_model_version"))
      return ((Number)paramModel.get("keep_model_version")).intValue();
    paramModel.put("keep_model_version", Integer.valueOf(0));
    return 0;
  }

  public static boolean e(CollaborativeMap paramCollaborativeMap)
  {
    return ((Boolean)paramCollaborativeMap.get("keep_is_checked")).booleanValue();
  }

  public static long f(CollaborativeMap paramCollaborativeMap)
  {
    if (paramCollaborativeMap == null)
      throw new IllegalArgumentException("list item cannot be null");
    return ((Number)paramCollaborativeMap.get("keep_sort_value")).longValue();
  }

  public static String f(Model paramModel)
  {
    paramModel = paramModel.getRoot();
    if (paramModel.containsKey("keep_last_modifier_email"))
      return (String)paramModel.get("keep_last_modifier_email");
    return null;
  }

  public static CollaborativeList g(Model paramModel)
  {
    paramModel = paramModel.getRoot();
    if (paramModel.containsKey("keep_list"))
      return (CollaborativeList)paramModel.get("keep_list");
    return null;
  }

  public static CollaborativeMap h(Model paramModel)
  {
    paramModel = paramModel.getRoot();
    if (paramModel.containsKey("keep_list_settings_v2"))
      return (CollaborativeMap)paramModel.get("keep_list_settings_v2");
    return null;
  }

  public static boolean i(Model paramModel)
  {
    paramModel = h(paramModel);
    if (paramModel == null)
      return false;
    return TextUtils.equals("GRAVEYARD", (String)paramModel.get("keep_checked_list_items_policy"));
  }

  public static boolean j(Model paramModel)
  {
    paramModel = h(paramModel);
    if (paramModel == null)
      return false;
    return TextUtils.equals("TOP", (String)paramModel.get("keep_new_list_item_placement"));
  }

  public static CollaborativeList k(Model paramModel)
  {
    CollaborativeList localCollaborativeList = paramModel.createList();
    paramModel.getRoot().put("keep_list", localCollaborativeList);
    return localCollaborativeList;
  }

  public static CollaborativeMap l(Model paramModel)
  {
    paramModel = paramModel.getRoot();
    if (paramModel.containsKey("keep_note_body"))
      return (CollaborativeMap)paramModel.get("keep_note_body");
    return null;
  }

  public static void m(Model paramModel)
  {
    paramModel = paramModel.getRoot();
    if (paramModel.containsKey("keep_note_body"))
      paramModel.remove("keep_note_body");
  }

  public static void n(Model paramModel)
  {
    paramModel = paramModel.getRoot();
    if (paramModel.containsKey("keep_list"))
      paramModel.remove("keep_list");
  }

  public static void o(Model paramModel)
  {
    paramModel = paramModel.getRoot();
    if (paramModel.containsKey("keep_list_settings_v2"))
      paramModel.remove("keep_list_settings_v2");
  }
}