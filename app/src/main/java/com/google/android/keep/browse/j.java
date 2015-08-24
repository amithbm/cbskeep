package com.google.android.keep.browse;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.content.CursorLoader;
import com.google.android.keep.model.Note;
import com.google.android.keep.provider.d;
import com.google.android.keep.provider.i.f;

public class j extends CursorLoader
{
  public static final o hm = new o("key_archive");
  private final String hn;

  public j(Context paramContext, long paramLong, String paramString)
  {
    super(paramContext, i.f.c(i.f.Cm, paramLong), Note.COLUMNS, "tree_entity._id IN ( SELECT note_label.tree_entity_id FROM note_label WHERE note_label.label_id =? AND note_label.is_deleted = 0) AND is_trashed=0", new String[] { paramString }, "tree_entity.is_archived ASC, tree_entity.order_in_parent DESC,tree_entity.user_edited_timestamp DESC");
    hn = paramContext.getString(2131231318);
  }

  public final Cursor loadInBackground()
  {
    Cursor localCursor = super.loadInBackground();
    Bundle localBundle = new Bundle();
    int i;
    int k;
    if (localCursor != null)
    {
      i = 0;
      k = 0;
    }
    while (true)
    {
      int j = k;
      if (localCursor.moveToNext())
      {
        if (localCursor.getInt(Note.xU) == 1)
          j = 1;
      }
      else
      {
        if (j != 0)
        {
          localBundle.putString(hm.cC(), hn);
          localBundle.putInt(hm.cD(), i);
        }
        localBundle.putBoolean("hasDataReady", true);
        return new d(localCursor, localBundle);
      }
      i += 1;
    }
  }
}