package com.google.android.keep.util;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.keep.model.A;
import com.google.android.keep.model.Note;

public class t
{
  public static String a(Context paramContext, Note paramNote, A paramA)
  {
    if (!e(paramNote))
    {
      if (paramNote.ii())
        return paramContext.getResources().getString(2131231265);
      if (paramNote.ip())
        return paramContext.getResources().getString(2131231266);
      paramA = paramA.c(paramNote);
      if (paramA != null)
        return x.c(paramContext, paramA);
    }
    return paramNote.getDescription();
  }

  public static boolean e(Note paramNote)
  {
    return (!TextUtils.isEmpty(paramNote.getTitle())) || (!TextUtils.isEmpty(paramNote.getDescription())) || (paramNote.il() > 0);
  }
}