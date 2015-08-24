package com.google.android.keep.microapp;

import android.text.TextUtils;
import com.google.android.gms.drive.realtime.CollaborativeList;
import com.google.android.gms.drive.realtime.CollaborativeMap;
import com.google.android.gms.drive.realtime.Model;
import com.google.android.keep.sharing.a;
import java.util.Iterator;

public class c extends b
{
  private boolean tm;
  private String tn;

  public c(String paramString, boolean paramBoolean)
  {
    tn = paramString;
    tm = paramBoolean;
  }

  public void a(Model paramModel)
  {
    if (paramModel == null)
      throw new IllegalStateException("Model is null");
    if (TextUtils.isEmpty(tn))
      return;
    Object localObject;
    boolean bool;
    do
    {
      do
      {
        do
          localObject = a.g(paramModel);
        while ((localObject == null) || (a.b(paramModel)));
        paramModel = ((CollaborativeList)localObject).iterator();
      }
      while (!paramModel.hasNext());
      localObject = (CollaborativeMap)paramModel.next();
      String str = (String)((CollaborativeMap)localObject).get("keep_uuid");
      if (!TextUtils.equals(tn, str))
        break;
      bool = ((Boolean)((CollaborativeMap)localObject).get("keep_is_checked")).booleanValue();
    }
    while (tm == bool);
    ((CollaborativeMap)localObject).put("keep_is_checked", Boolean.valueOf(tm));
  }
}