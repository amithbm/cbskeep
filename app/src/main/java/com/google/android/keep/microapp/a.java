package com.google.android.keep.microapp;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.drive.realtime.CollaborativeList;
import com.google.android.gms.drive.realtime.Model;
import com.google.android.keep.model.j;
import java.util.List;

public class a extends b
{
  private final j fr;
  private final Context mContext;
  private final String tk;
  private final String tl;
  private final boolean tm;

  public a(Context paramContext, j paramj, String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramContext == null) || (paramj == null) || (TextUtils.isEmpty(paramString1)))
      throw new IllegalArgumentException("Invalid arguments");
    mContext = paramContext;
    fr = paramj;
    tk = paramString1;
    tl = paramString2;
    tm = paramBoolean;
  }

  public void a(Model paramModel)
  {
    if (paramModel == null)
      throw new IllegalStateException("Model is null");
    CollaborativeList localCollaborativeList = com.google.android.keep.sharing.a.g(paramModel);
    if ((localCollaborativeList == null) || (com.google.android.keep.sharing.a.b(paramModel)))
      return;
    List localList;
    if (com.google.android.keep.sharing.a.i(paramModel))
    {
      localList = com.google.android.keep.sharing.a.a(localCollaborativeList, false);
      if (com.google.android.keep.sharing.a.j(paramModel))
        break label116;
    }
    label116: for (boolean bool = true; ; bool = false)
    {
      long l = com.google.android.keep.sharing.a.a(mContext, fr.getId(), paramModel, localList, bool);
      localCollaborativeList.add(com.google.android.keep.sharing.a.a(mContext, paramModel, tk, tl, tm, l));
      return;
      localList = com.google.android.keep.sharing.a.a(localCollaborativeList);
      break;
    }
  }
}