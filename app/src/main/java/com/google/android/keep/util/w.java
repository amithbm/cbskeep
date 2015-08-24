package com.google.android.keep.util;

import android.text.TextUtils;
import com.google.android.gms.reminders.model.RecurrenceInfo;
import com.google.android.gms.reminders.model.Task;
import com.google.android.gms.reminders.model.TaskId;
import com.google.android.gms.reminders.model.TaskId.Builder;
import com.google.android.keep.model.TreeEntity;
import com.google.android.keep.model.z;
import com.google.caribou.tasks.KeepExtension;
import java.util.Random;

public class w
{
  private static final Random PZ = new Random();
  private static final String TAG = w.class.getSimpleName();

  public static String[] a(long paramLong, a parama)
  {
    if (!TextUtils.isEmpty(parama.iF))
      return new String[] { String.valueOf(paramLong), parama.iF };
    return new String[] { String.valueOf(paramLong), parama.uK };
  }

  public static String bD(String paramString)
  {
    return String.format("%s%x", new Object[] { "KEEP/v2/" + paramString + "/" + "R", Integer.valueOf(Math.abs(PZ.nextInt())) });
  }

  public static String bE(String paramString)
  {
    return String.format("%s%x", new Object[] { "KEEP/" + paramString + "/" + "R", Integer.valueOf(Math.abs(PZ.nextInt())) });
  }

  public static a bF(String paramString)
  {
    if (!paramString.startsWith("KEEP"));
    String[] arrayOfString;
    do
    {
      do
      {
        return null;
        arrayOfString = paramString.split("/");
        if (arrayOfString.length > 2)
          break;
        paramString = paramString.split("___");
      }
      while ((paramString.length <= 3) || (!"v3".equals(paramString[1])));
      paramString = paramString[2].replace("__", ".-").replace("_", ".");
      return new w.a.a(null).bI(paramString).os();
      if (arrayOfString.length == 3)
        return new w.a.a(null).bI(arrayOfString[1]).os();
    }
    while (!"v2".equals(arrayOfString[1]));
    return new w.a.a(null).bH(arrayOfString[2]).os();
  }

  public static TaskId bG(String paramString)
  {
    return new TaskId.Builder().setClientAssignedId(paramString).build();
  }

  public static String c(a parama)
  {
    if (!TextUtils.isEmpty(iF))
      return "account_id=? AND " + "server_id" + "=?";
    return "account_id=? AND " + "uuid" + "=?";
  }

  public static String d(TreeEntity paramTreeEntity)
  {
    if (!TextUtils.isEmpty(paramTreeEntity.getServerId()))
      return bD(paramTreeEntity.getServerId());
    return bE(paramTreeEntity.gu());
  }

  public static String e(TreeEntity paramTreeEntity)
  {
    paramTreeEntity = paramTreeEntity.gu().replace(".-", "__").replace(".", "_");
    return String.format("%s%x", new Object[] { "KEEP___v3___" + paramTreeEntity + "___" + "R", Integer.valueOf(Math.abs(PZ.nextInt())) });
  }

  public static String k(Task paramTask)
  {
    if (paramTask.getTaskId() != null)
      return paramTask.getTaskId().getClientAssignedId();
    if (paramTask.getRecurrenceInfo() != null)
      return paramTask.getRecurrenceInfo().getRecurrenceId();
    r.e(TAG, "No valid reminder id", new Object[0]);
    return null;
  }

  public static a l(Task paramTask)
  {
    KeepExtension localKeepExtension = z.b(paramTask);
    if (localKeepExtension != null)
    {
      w.a.a locala = new w.a.a(null);
      if (localKeepExtension.serverNoteId != null)
        locala.bH(localKeepExtension.serverNoteId);
      if (localKeepExtension.clientNoteId != null)
        locala.bI(localKeepExtension.clientNoteId);
      if ((locala.iF != null) || (locala.uK != null))
        return locala.os();
    }
    return bF(k(paramTask));
  }

  public static boolean m(Task paramTask)
  {
    return ((paramTask.getTaskList() != null) && (paramTask.getTaskList().intValue() == 4)) || (paramTask.getTaskId().getClientAssignedId().startsWith("KEEP"));
  }

  public static final class a
  {
    public final String iF;
    public final String uK;

    private a(String paramString1, String paramString2)
    {
      iF = paramString1;
      uK = paramString2;
    }

    public boolean equals(Object paramObject)
    {
      if (this == paramObject);
      do
      {
        return true;
        if (!(paramObject instanceof a))
          return false;
        paramObject = (a)paramObject;
        if (iF != null)
        {
          if (iF.equals(paramObject.iF));
        }
        else
          while (paramObject.iF != null)
            return false;
        if (uK == null)
          break;
      }
      while (uK.equals(paramObject.uK));
      while (true)
      {
        return false;
        if (paramObject.uK == null)
          break;
      }
    }

    public int hashCode()
    {
      int j = 0;
      if (iF != null);
      for (int i = iF.hashCode(); ; i = 0)
      {
        if (uK != null)
          j = uK.hashCode();
        return i * 31 + j;
      }
    }

    private static final class a
    {
      public String iF;
      public String uK;

      public a bH(String paramString)
      {
        iF = paramString;
        return this;
      }

      public a bI(String paramString)
      {
        uK = paramString;
        return this;
      }

      public w.a os()
      {
        return new w.a(iF, uK, null);
      }
    }
  }
}