package com.google.android.keep.homescreenwidget;

import android.appwidget.AppWidgetManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Binder;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService.RemoteViewsFactory;
import com.google.android.keep.L;
import com.google.android.keep.activities.KeepApplication;
import com.google.android.keep.model.BaseReminder;
import com.google.android.keep.model.ColorMap;
import com.google.android.keep.model.ColorMap.ColorPair;
import com.google.android.keep.model.ImageBlob;
import com.google.android.keep.model.Location;
import com.google.android.keep.model.LocationReminder;
import com.google.android.keep.model.Note;
import com.google.android.keep.model.TimeReminder;
import com.google.android.keep.model.TimeReminder.TimePeriod;
import com.google.android.keep.model.TreeEntity.TreeEntityType;
import com.google.android.keep.model.TreeEntitySettings;
import com.google.android.keep.model.j;
import com.google.android.keep.model.m;
import com.google.android.keep.provider.i.f;
import com.google.android.keep.util.KeepTime;
import com.google.android.keep.util.a;
import com.google.android.keep.util.r;
import com.google.android.keep.util.t;
import com.google.android.keep.util.x;
import com.google.common.collect.Lists;
import java.util.List;

class b
  implements RemoteViewsService.RemoteViewsFactory
{
  private static Integer hO = null;
  private static final Object ro = new Object();
  private static Integer rp = null;
  private static Integer rq = null;
  private static final int[] rr = { 2131493063, 2131493065, 2131493067 };
  private final j dx;
  private com.google.android.keep.model.A fi;
  private final Context mContext;
  private final int rs;
  private String rt;
  private final AppWidgetManager ru;
  private final int rv;
  private final int rw;
  private List<Note> rx = Lists.newArrayList();
  private final int ry;

  public b(Context paramContext, Intent paramIntent)
  {
    mContext = paramContext;
    ru = AppWidgetManager.getInstance(paramContext);
    rv = paramIntent.getExtras().getInt("appWidgetId");
    dx = com.google.android.keep.util.A.f(mContext, rv);
    rs = com.google.android.keep.util.A.g(mContext, rv);
    if (rs == 3)
      rt = com.google.android.keep.util.A.h(mContext, rv);
    rp = Integer.valueOf(mContext.getResources().getColor(2131296382));
    hO = Integer.valueOf(mContext.getResources().getColor(2131296375));
    rq = Integer.valueOf(mContext.getResources().getColor(2131296377));
    paramIntent = new Point();
    ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getSize(paramIntent);
    ry = Math.max(paramIntent.x, paramIntent.y);
    rw = paramContext.getResources().getInteger(2131361810);
    fi = new com.google.android.keep.model.A();
  }

  private void a(RemoteViews paramRemoteViews, int paramInt, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramRemoteViews.setTextViewText(paramInt, paramString);
      paramRemoteViews.setViewVisibility(paramInt, 0);
      return;
    }
    paramRemoteViews.setViewVisibility(paramInt, 8);
  }

  private void a(RemoteViews paramRemoteViews, Note paramNote, int paramInt)
  {
    int m = 1;
    int k = 0;
    int j;
    if ((TextUtils.isEmpty(paramNote.getTitle())) && (!paramNote.ii()) && (fi.c(paramNote) == null) && (paramInt != ColorMap.gO().getValue()))
    {
      i = 1;
      j = i;
      if (paramNote.ir() == TreeEntity.TreeEntityType.zP)
      {
        if (paramNote.im() != null)
          break label112;
        j = m;
        label72: j = i & j;
      }
      if (j == 0)
        break label118;
    }
    label112: label118: for (int i = k; ; i = 8)
    {
      paramRemoteViews.setViewVisibility(2131493101, i);
      paramRemoteViews.setInt(2131493101, "setBackgroundColor", paramInt);
      return;
      i = 0;
      break;
      j = 0;
      break label72;
    }
  }

  private void a(RemoteViews paramRemoteViews, Note paramNote, BaseReminder paramBaseReminder, boolean paramBoolean)
  {
    boolean bool1 = paramNote.ii();
    boolean bool2 = paramNote.ip();
    if ((paramBaseReminder == null) && (!bool1) && (!bool2))
    {
      paramRemoteViews.setViewVisibility(2131493265, 8);
      return;
    }
    int i;
    if ((paramBaseReminder != null) && (!paramBaseReminder.gK()))
      i = 1;
    int j;
    while (i != 0)
      switch (paramBaseReminder.getType())
      {
      default:
        throw new IllegalStateException("Invalid reminder type: " + paramBaseReminder.getType());
        i = 0;
        break;
      case 0:
        paramBaseReminder = (TimeReminder)paramBaseReminder;
        if (paramBaseReminder.getRecurrence() == null)
          break label277;
        j = 2130837695;
        paramRemoteViews.setInt(2131493270, "setImageResource", j);
        if (paramBaseReminder.getRecurrence() == null)
          break label285;
        paramRemoteViews.setTextViewText(2131493271, x.b(mContext, paramBaseReminder));
      case 1:
      }
    label168: if ((i != 0) || (bool1) || (bool2))
    {
      if (paramBoolean)
      {
        j = 8;
        label192: paramRemoteViews.setViewVisibility(2131493266, j);
        paramRemoteViews.setViewVisibility(2131493265, 0);
        if (!bool1)
          break label394;
        j = 0;
        label216: paramRemoteViews.setViewVisibility(2131493268, j);
        if (!bool2)
          break label401;
        j = 0;
        label233: paramRemoteViews.setViewVisibility(2131493269, j);
        if (i == 0)
          break label408;
        j = 0;
        label250: paramRemoteViews.setViewVisibility(2131493270, j);
        if (i == 0)
          break label415;
      }
      for (i = 0; ; i = 8)
      {
        paramRemoteViews.setViewVisibility(2131493271, i);
        return;
        j = 2130837696;
        break;
        if (paramBaseReminder.jq())
        {
          paramRemoteViews.setTextViewText(2131493271, mContext.getString(2131231225));
          break label168;
        }
        paramNote = new KeepTime(paramBaseReminder.jp());
        paramBaseReminder = TimeReminder.TimePeriod.bm(paramBaseReminder.jo());
        paramRemoteViews.setTextViewText(2131493271, com.google.android.keep.util.g.a(mContext, paramNote, paramBaseReminder));
        break label168;
        paramRemoteViews.setInt(2131493270, "setImageResource", 2130837693);
        paramRemoteViews.setTextViewText(2131493271, ((LocationReminder)paramBaseReminder).hZ().r(mContext));
        break label168;
        j = 0;
        break label192;
        j = 8;
        break label216;
        j = 8;
        break label233;
        j = 8;
        break label250;
      }
    }
    label277: label285: label415: paramRemoteViews.setViewVisibility(2131493265, 8);
    label394: label401: label408: return;
  }

  private void a(RemoteViews paramRemoteViews, Note paramNote, m[] paramArrayOfm)
  {
    if (paramArrayOfm == null);
    int k;
    label113: 
    do
    {
      return;
      int i;
      if (paramArrayOfm.length > 10)
      {
        i = 1;
        paramNote = paramNote.iA();
        if ((!paramNote.jz()) || (paramNote.ei()))
          break label113;
      }
      boolean bool;
      for (int j = 1; ; j = 0)
      {
        m = 0;
        k = i;
        i = m;
        while (true)
        {
          if ((i >= paramArrayOfm.length) || (i >= 10))
            break label220;
          paramNote = paramArrayOfm[i];
          m = k;
          if (paramNote != null)
          {
            bool = paramNote.hz();
            if ((!bool) || (j == 0))
              break;
            m = 1;
          }
          i += 1;
          k = m;
        }
        i = 0;
        break;
      }
      RemoteViews localRemoteViews;
      if ((i == paramArrayOfm.length - 1) && (k == 0))
      {
        m = 2130968778;
        localRemoteViews = new RemoteViews(mContext.getPackageName(), m);
        a(localRemoteViews, paramNote.getText(), bool);
        if (!bool)
          break label212;
      }
      for (int m = 2130837669; ; m = 2130837671)
      {
        localRemoteViews.setImageViewResource(2131492998, m);
        paramRemoteViews.addView(2131493406, localRemoteViews);
        m = k;
        break;
        m = 2130968777;
        break label138;
      }
    }
    while (k == 0);
    label138: label212: label220: paramRemoteViews.addView(2131493406, new RemoteViews(mContext.getPackageName(), 2130968774));
  }

  private void a(RemoteViews paramRemoteViews, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      RemoteViews localRemoteViews = new RemoteViews(mContext.getPackageName(), 2130968779);
      localRemoteViews.setTextViewText(2131492986, new SpannableString(paramString));
      paramRemoteViews.addView(2131493406, localRemoteViews);
    }
  }

  private void a(RemoteViews paramRemoteViews, String paramString, boolean paramBoolean)
  {
    paramRemoteViews.setTextViewText(2131493075, paramString);
    if (paramBoolean)
    {
      paramRemoteViews.setInt(2131493075, "setPaintFlags", 16);
      paramRemoteViews.setTextColor(2131493075, rp.intValue());
    }
  }

  private void a(RemoteViews paramRemoteViews, long[] paramArrayOfLong, int paramInt1, int paramInt2)
  {
    long l = Binder.clearCallingIdentity();
    ContentResolver localContentResolver = mContext.getContentResolver();
    int i = 0;
    while (true)
    {
      int k;
      try
      {
        if (i >= rr.length)
          break label182;
        if (i >= paramInt1)
        {
          paramRemoteViews.setViewVisibility(rr[i], 8);
        }
        else
        {
          k = paramInt2 / paramInt1 + 1;
          if (paramInt1 == 1)
          {
            j = (int)(0.66F * k);
            Bitmap localBitmap3 = com.google.android.keep.provider.g.a(localContentResolver, ImageBlob.s(paramArrayOfLong[i]), k, j);
            Bitmap localBitmap1 = localBitmap3;
            Bitmap localBitmap2 = localBitmap1;
            if (localBitmap3 != null)
              if (localBitmap3.getWidth() >= k)
              {
                localBitmap2 = localBitmap1;
                if (localBitmap3.getHeight() >= j);
              }
              else
              {
                localBitmap2 = com.google.android.keep.provider.g.a(localBitmap3, k, j);
                localBitmap3.recycle();
              }
            paramRemoteViews.setImageViewBitmap(rr[i], localBitmap2);
            paramRemoteViews.setViewVisibility(rr[i], 0);
          }
        }
      }
      finally
      {
        Binder.restoreCallingIdentity(l);
      }
      int j = k;
      continue;
      label182: Binder.restoreCallingIdentity(l);
      return;
      i += 1;
    }
  }

  public int getCount()
  {
    synchronized (ro)
    {
      int i = rx.size();
      return i;
    }
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public RemoteViews getLoadingView()
  {
    return null;
  }

  public RemoteViews getViewAt(int paramInt)
  {
    Object localObject5 = ro;
    if (paramInt >= 0);
    Object localObject3;
    try
    {
      if (paramInt >= rx.size())
      {
        r.e("Keep", "Invalid position:" + paramInt + " size:" + rx.size(), new Object[0]);
        return null;
      }
      if (paramInt == 25)
      {
        RemoteViews localRemoteViews = new RemoteViews(mContext.getPackageName(), 2130968787);
        localObject3 = new Intent();
        ((Intent)localObject3).setAction("com.google.android.keep.intent.action.WIDGET_VIEW_MORE");
        ((Intent)localObject3).putExtra("authAccount", dx.getName());
        localRemoteViews.setOnClickFillInIntent(2131493412, (Intent)localObject3);
        return localRemoteViews;
      }
    }
    finally
    {
    }
    int i;
    Note localNote;
    BaseReminder localBaseReminder;
    Object localObject2;
    String str;
    boolean bool;
    label324: label356: Object localObject4;
    if (KeepApplication.ai())
    {
      i = (int)TypedValue.applyDimension(1, ru.getAppWidgetOptions(rv).getInt("appWidgetMaxWidth"), mContext.getResources().getDisplayMetrics());
      int j = i;
      if (i <= 0)
        j = Math.min((int)(0.8F * ry), 400);
      localNote = (Note)rx.get(paramInt);
      localBaseReminder = fi.c(localNote);
      localObject2 = localNote.ir();
      i = localNote.il() % rw;
      paramInt = i;
      if (i == 0)
      {
        paramInt = i;
        if (localNote.il() > 0)
          paramInt = rw;
      }
      str = localNote.getTitle();
      int k = localNote.iz().getValue();
      bool = localNote.ij();
      if (TextUtils.isEmpty(str))
        break label1031;
      i = 1;
      switch (1.rz[localObject2.ordinal()])
      {
      case 1:
        throw new IllegalStateException("Invalid type " + localObject2);
        localObject4 = "com.google.android.keep.intent.action.WIDGET_VIEW_NOTE";
        localObject2 = mContext.getPackageName();
        if (bool)
        {
          localObject2 = new RemoteViews((String)localObject2, 2130968781);
          a((RemoteViews)localObject2, localNote.ik(), paramInt, j);
          a((RemoteViews)localObject2, localNote, k);
          bool = t.e(localNote);
          if (!bool)
            break label693;
          ((RemoteViews)localObject2).setViewVisibility(2131493406, 0);
          ((RemoteViews)localObject2).setTextColor(2131493075, hO.intValue());
        }
        while (true)
        {
          ((RemoteViews)localObject2).setInt(2131493074, "setBackgroundColor", k);
          a((RemoteViews)localObject2, 2131492986, str);
          a((RemoteViews)localObject2, 2131493075, t.a(mContext, localNote, fi));
          if (bool)
            break label1036;
          bool = true;
          a((RemoteViews)localObject2, localNote, localBaseReminder, bool);
          localObject3 = localObject2;
          localObject2 = localObject4;
          bool = localNote.in();
          if (!bool)
            break label1010;
          ((RemoteViews)localObject3).setViewVisibility(2131493114, 0);
          ((RemoteViews)localObject3).setInt(2131493409, "setText", 2131231287);
          localObject4 = new Intent();
          ((Intent)localObject4).setAction((String)localObject2);
          ((Intent)localObject4).putExtra("treeEntityId", localNote.getId());
          ((Intent)localObject4).putExtra("com.google.android.keep.intent.extra.HAS_CONFLICT", bool);
          ((Intent)localObject4).setFlags(268468224);
          ((RemoteViews)localObject3).setOnClickFillInIntent(2131493116, (Intent)localObject4);
          if (KeepApplication.as())
            ((RemoteViews)localObject3).setContentDescription(2131493116, a.a(mContext, localNote, null, null));
          return localObject3;
          localObject2 = new RemoteViews((String)localObject2, 2130968782);
          break;
          ((RemoteViews)localObject2).setViewVisibility(2131493406, 8);
          ((RemoteViews)localObject2).setTextColor(2131493075, rq.intValue());
        }
      case 2:
        label529: label549: label584: localObject4 = "com.google.android.keep.intent.action.WIDGET_VIEW_LIST";
        label693: localObject3 = new RemoteViews(mContext.getPackageName(), 2130968775);
        if (bool)
        {
          ((RemoteViews)localObject3).setViewVisibility(2131493405, 0);
          a((RemoteViews)localObject3, localNote.ik(), paramInt, j);
          a((RemoteViews)localObject3, localNote, k);
          label781: ((RemoteViews)localObject3).setInt(2131493074, "setBackgroundColor", k);
          localObject2 = localNote.im();
          if ((localObject2 == null) || (localObject2.length <= 0))
            break label1056;
          paramInt = 1;
          label813: if ((i != 0) || (paramInt != 0))
            break label962;
          ((RemoteViews)localObject3).setViewVisibility(2131493406, 8);
          localObject2 = null;
          if (!localNote.ii())
            break label943;
          localObject2 = mContext.getResources().getString(2131231265);
          label857: if (TextUtils.isEmpty((CharSequence)localObject2))
            break label1042;
          ((RemoteViews)localObject3).setViewVisibility(2131493075, 0);
          ((RemoteViews)localObject3).setTextColor(2131493075, rq.intValue());
          a((RemoteViews)localObject3, 2131493075, (String)localObject2);
        }
        break;
      }
    }
    while (true)
    {
      a((RemoteViews)localObject3, localNote, localBaseReminder, bool);
      localObject2 = localObject4;
      break label549;
      ((RemoteViews)localObject3).setViewVisibility(2131493405, 8);
      ((RemoteViews)localObject3).setViewVisibility(2131493101, 8);
      break label781;
      label943: if (localBaseReminder == null)
        break label857;
      localObject2 = x.c(mContext, localBaseReminder);
      break label857;
      label962: ((RemoteViews)localObject3).setViewVisibility(2131493406, 0);
      ((RemoteViews)localObject3).setViewVisibility(2131493075, 8);
      ((RemoteViews)localObject3).removeAllViews(2131493406);
      a((RemoteViews)localObject3, str);
      a((RemoteViews)localObject3, localNote, (m[])localObject2);
      break label1042;
      label1010: ((RemoteViews)localObject3).setViewVisibility(2131493114, 8);
      break label584;
      break label356;
      i = -1;
      break;
      label1031: i = 0;
      break label324;
      label1036: bool = false;
      break label529;
      label1042: if ((paramInt == 0) && (i == 0))
      {
        bool = true;
        continue;
        label1056: paramInt = 0;
        break label813;
      }
      bool = false;
    }
  }

  public int getViewTypeCount()
  {
    return 4;
  }

  public boolean hasStableIds()
  {
    return true;
  }

  public void onCreate()
  {
    long l;
    Cursor localCursor1;
    Object localObject4;
    synchronized (ro)
    {
      if (dx == null)
      {
        rx.clear();
        return;
      }
      l = Binder.clearCallingIdentity();
      localCursor1 = null;
      localObject4 = localCursor1;
    }
    while (true)
    {
      try
      {
        if (rt != null)
        {
          localObject4 = localCursor1;
          localCursor1 = mContext.getContentResolver().query(i.f.Cm, Note.COLUMNS, "tree_entity._id IN ( SELECT note_label.tree_entity_id FROM note_label WHERE note_label.label_id =? AND note_label.is_deleted = 0) AND is_trashed=0", new String[] { rt }, "tree_entity.is_archived ASC, tree_entity.order_in_parent DESC,tree_entity.user_edited_timestamp DESC");
          localObject4 = localCursor1;
          rx = Note.q(localCursor1);
          if (localCursor1 != null)
            localCursor1.close();
          Binder.restoreCallingIdentity(l);
          return;
          localObject1 = finally;
          throw localObject1;
        }
        localObject4 = localObject1;
        if (rs == 2)
        {
          localObject4 = localObject1;
          Cursor localCursor3 = mContext.getContentResolver().query(i.f.c(i.f.Cm, dx.getId()), Note.COLUMNS, "is_trashed=0", null, null);
          Object localObject2 = localCursor3;
          if (localCursor3 == null)
            continue;
          localObject4 = localCursor3;
          localObject2 = L.c(mContext, localCursor3, fi);
          localObject4 = localObject2;
          localCursor3.close();
          continue;
        }
      }
      finally
      {
        if (localObject4 != null)
          ((Cursor)localObject4).close();
        Binder.restoreCallingIdentity(l);
      }
      localObject4 = localObject3;
      Cursor localCursor2 = mContext.getContentResolver().query(i.f.c(i.f.Ci, dx.getId()), Note.COLUMNS, null, null, " LIMIT 26");
    }
  }

  public void onDataSetChanged()
  {
    long l = Binder.clearCallingIdentity();
    try
    {
      if (dx != null)
        fi.d(mContext, dx);
      Binder.restoreCallingIdentity(l);
      onCreate();
      return;
    }
    finally
    {
      Binder.restoreCallingIdentity(l);
    }
  }

  public void onDestroy()
  {
    synchronized (ro)
    {
      rx.clear();
      fi.onDestroy();
      return;
    }
  }
}