package com.google.android.keep.util;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import com.google.android.keep.activities.KeepApplication;
import com.google.android.keep.model.Label;
import com.google.android.keep.model.ListItem;
import com.google.android.keep.model.Note;
import com.google.android.keep.model.Sharee;
import com.google.android.keep.model.TreeEntity.TreeEntityType;
import com.google.android.keep.model.TreeEntityModel;
import com.google.android.keep.model.m;
import com.google.android.keep.model.n;
import java.util.Iterator;
import java.util.List;

public class a
{
  public static boolean G(Context paramContext)
  {
    paramContext = (AccessibilityManager)paramContext.getSystemService("accessibility");
    if (paramContext == null);
    while ((!paramContext.isEnabled()) || (!paramContext.isTouchExplorationEnabled()))
      return false;
    return true;
  }

  public static String a(Context paramContext, Note paramNote, List<Sharee> paramList, List<Label> paramList1)
  {
    TreeEntity.TreeEntityType localTreeEntityType = paramNote.ir();
    if ((localTreeEntityType != TreeEntity.TreeEntityType.zP) && (localTreeEntityType != TreeEntity.TreeEntityType.zO))
      throw new IllegalStateException("Invalid type " + localTreeEntityType);
    paramContext = paramContext.getResources();
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramNote.ii())
    {
      localStringBuilder.append(paramContext.getString(2131231253)).append(":");
      a(localStringBuilder, paramNote.getTitle());
      if (localTreeEntityType != TreeEntity.TreeEntityType.zP)
        break label160;
      a(paramContext, localStringBuilder, paramNote.im());
    }
    while (true)
    {
      a(localStringBuilder, paramList);
      b(localStringBuilder, paramList1);
      return localStringBuilder.toString();
      if (!paramNote.ij())
        break;
      localStringBuilder.append(paramContext.getString(2131231254)).append(":");
      break;
      label160: if (localTreeEntityType == TreeEntity.TreeEntityType.zO)
        b(localStringBuilder, paramNote.getDescription());
    }
  }

  public static String a(Context paramContext, TreeEntityModel paramTreeEntityModel, n paramn, boolean paramBoolean)
  {
    TreeEntity.TreeEntityType localTreeEntityType = paramTreeEntityModel.ir();
    if ((localTreeEntityType != TreeEntity.TreeEntityType.zP) && (localTreeEntityType != TreeEntity.TreeEntityType.zO))
      throw new IllegalStateException("Invalid type " + localTreeEntityType);
    paramContext = paramContext.getResources();
    StringBuilder localStringBuilder = new StringBuilder();
    a(localStringBuilder, paramTreeEntityModel.getTitle());
    if (localTreeEntityType == TreeEntity.TreeEntityType.zP)
      a(paramContext, localStringBuilder, paramn.hC(), paramBoolean);
    while (localTreeEntityType != TreeEntity.TreeEntityType.zO)
      return localStringBuilder.toString();
    if (paramBoolean);
    for (paramContext = ((ListItem)paramn.gE()).hs(); ; paramContext = ((ListItem)paramn.gE()).getText())
    {
      b(localStringBuilder, paramContext);
      break;
    }
  }

  public static void a(Context paramContext, View paramView)
  {
    if ((paramView != null) && (G(paramContext)))
      paramView.postDelayed(new Runnable()
      {
        public void run()
        {
          val$view.requestFocus();
        }
      }
      , 500L);
  }

  private static void a(Resources paramResources, StringBuilder paramStringBuilder, List<ListItem> paramList, boolean paramBoolean)
  {
    if ((paramList != null) && (paramList.size() > 0));
    for (int i = 1; i == 0; i = 0)
      return;
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      Object localObject = (ListItem)localIterator.next();
      if (paramBoolean)
      {
        paramList = ((ListItem)localObject).hs();
        label77: if (!((ListItem)localObject).isChecked())
          break label129;
      }
      label129: for (localObject = paramResources.getString(2131231163); ; localObject = paramResources.getString(2131231164))
      {
        localStringBuilder.append(String.format("%s, %s;", new Object[] { paramList, localObject }));
        break;
        paramList = ((ListItem)localObject).getText();
        break label77;
      }
    }
    paramStringBuilder.append(localStringBuilder.toString()).append(";");
  }

  private static void a(Resources paramResources, StringBuilder paramStringBuilder, m[] paramArrayOfm)
  {
    if ((paramArrayOfm != null) && (paramArrayOfm.length > 0));
    for (int i = 1; i == 0; i = 0)
      return;
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramArrayOfm.length;
    i = 0;
    if (i < j)
    {
      Object localObject = paramArrayOfm[i];
      String str = ((m)localObject).getText();
      if (((m)localObject).hz());
      for (localObject = paramResources.getString(2131231163); ; localObject = paramResources.getString(2131231164))
      {
        localStringBuilder.append(String.format("%s, %s;", new Object[] { str, localObject }));
        i += 1;
        break;
      }
    }
    paramStringBuilder.append(localStringBuilder.toString()).append(";");
  }

  public static void a(View paramView, CharSequence paramCharSequence)
  {
    if ((KeepApplication.ag()) && (paramView != null))
      paramView.announceForAccessibility(paramCharSequence);
  }

  private static void a(StringBuilder paramStringBuilder, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
      paramStringBuilder.append(paramString).append(";");
  }

  private static void a(StringBuilder paramStringBuilder, List<Sharee> paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
        paramStringBuilder.append(((Sharee)paramList.next()).getDisplayName()).append(";");
    }
  }

  public static void b(View paramView, final CharSequence paramCharSequence)
  {
    if ((KeepApplication.ag()) && (paramView != null))
      paramView.postDelayed(new Runnable()
      {
        public void run()
        {
          val$view.announceForAccessibility(paramCharSequence);
        }
      }
      , 500L);
  }

  private static void b(StringBuilder paramStringBuilder, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
      paramStringBuilder.append(paramString).append(";");
  }

  private static void b(StringBuilder paramStringBuilder, List<Label> paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
        paramStringBuilder.append(((Label)paramList.next()).getName()).append(";");
    }
  }

  public static void g(View paramView, int paramInt)
  {
    if ((KeepApplication.ah()) && (paramView != null))
      paramView.setImportantForAccessibility(paramInt);
  }
}