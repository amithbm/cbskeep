package com.google.android.keep.task;

import android.content.ContentResolver;
import android.content.Context;
import android.os.AsyncTask;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.reminders.Reminders;
import com.google.android.gms.reminders.RemindersApi;
import com.google.android.gms.reminders.model.Task;
import com.google.android.gms.reminders.model.Task.Builder;
import com.google.android.gms.reminders.model.TaskId;
import com.google.android.keep.L;
import com.google.android.keep.N;
import com.google.android.keep.provider.i.c;
import com.google.android.keep.util.r;

public class f extends AsyncTask<Void, Void, Void>
{
  private final com.google.android.keep.model.j fr;
  private final Context mContext;
  private final String op;

  public f(Context paramContext, com.google.android.keep.model.j paramj, String paramString)
  {
    mContext = paramContext.getApplicationContext();
    fr = paramj;
    op = paramString;
  }

  protected Void doInBackground(Void[] paramArrayOfVoid)
  {
    if ((mContext == null) || (op == null) || (fr == null));
    do
    {
      return null;
      mContext.getContentResolver().delete(i.c.CONTENT_URI, "reminder_id=?", new String[] { op });
      paramArrayOfVoid = com.google.android.keep.util.j.j(mContext, fr.getName()).build();
    }
    while (!com.google.android.keep.util.j.f(paramArrayOfVoid));
    try
    {
      Task localTask = L.c(paramArrayOfVoid, op);
      if (localTask == null)
        return null;
      localTask = N.i(localTask).build();
      if (!((Status)com.google.android.keep.util.j.b(Reminders.RemindersApi.updateReminder(paramArrayOfVoid, localTask))).isSuccess())
        r.e("Keep", "Error unarchive reminder " + localTask.getTaskId().getClientAssignedId(), new Object[0]);
      return null;
    }
    finally
    {
      com.google.android.keep.util.j.e(paramArrayOfVoid);
    }
  }
}