package com.google.android.gms.reminders;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzv;
import com.google.android.gms.reminders.model.TaskId;
import java.util.ArrayList;
import java.util.List;

public class LoadRemindersOptions
  implements SafeParcelable
{
  public static final Parcelable.Creator<LoadRemindersOptions> CREATOR = new zzc();
  public static final LoadRemindersOptions DEFAULT_OPTION = new Builder().build();
  private final List<String> mRecurrenceIds;
  public final int mVersionCode;
  private final int zzbcq;
  private final List<Long> zzblD;
  private final List<String> zzblE;
  private final List<Integer> zzblF;
  private final Long zzblG;
  private final Long zzblH;
  private final Long zzblI;
  private final Long zzblJ;
  private final boolean zzblK;
  private final int zzblL;
  private final boolean zzblM;
  private final boolean zzblN;
  private final int zzblO;

  LoadRemindersOptions(int paramInt1, List<Long> paramList, List<String> paramList1, List<Integer> paramList2, Long paramLong1, Long paramLong2, Long paramLong3, Long paramLong4, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, boolean paramBoolean3, int paramInt3, int paramInt4, List<String> paramList3)
  {
    mVersionCode = paramInt1;
    zzblD = paramList;
    zzblE = paramList1;
    zzblF = paramList2;
    zzblG = paramLong1;
    zzblH = paramLong2;
    zzblI = paramLong3;
    zzblJ = paramLong4;
    zzblK = paramBoolean1;
    zzblL = paramInt2;
    zzblM = paramBoolean2;
    zzblN = paramBoolean3;
    zzblO = paramInt3;
    zzbcq = paramInt4;
    mRecurrenceIds = paramList3;
  }

  private LoadRemindersOptions(List<Long> paramList, List<String> paramList1, List<Integer> paramList2, Long paramLong1, Long paramLong2, Long paramLong3, Long paramLong4, boolean paramBoolean1, int paramInt1, boolean paramBoolean2, boolean paramBoolean3, int paramInt2, int paramInt3, List<String> paramList3)
  {
    this(3, paramList, paramList1, paramList2, paramLong1, paramLong2, paramLong3, paramLong4, paramBoolean1, paramInt1, paramBoolean2, paramBoolean3, paramInt2, paramInt3, paramList3);
  }

  public int describeContents()
  {
    return 0;
  }

  public List<String> getClientAssignedIds()
  {
    return zzblE;
  }

  public int getCollapseMode()
  {
    return zzblL;
  }

  public Long getDueDateAfter()
  {
    return zzblG;
  }

  public Long getDueDateBefore()
  {
    return zzblH;
  }

  public Long getExcludeDueDateAfter()
  {
    return zzblI;
  }

  public Long getExcludeDueDateBefore()
  {
    return zzblJ;
  }

  public boolean getExcludeExceptions()
  {
    return zzblM;
  }

  public boolean getIncludeArchived()
  {
    return zzblK;
  }

  public boolean getIncludeRecurrencesOnly()
  {
    return zzblN;
  }

  public int getLoadReminderType()
  {
    return zzblO;
  }

  public List<String> getRecurrenceIds()
  {
    return mRecurrenceIds;
  }

  public List<Long> getServerAssignedIds()
  {
    return zzblD;
  }

  public int getSortOrder()
  {
    return zzbcq;
  }

  public List<Integer> getTaskListIds()
  {
    return zzblF;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }

  public static class Builder
  {
    public List<String> mRecurrenceIds = null;
    private int zzbcq = 0;
    private List<Integer> zzblF;
    private Long zzblG = null;
    private Long zzblH = null;
    private Long zzblI = null;
    private Long zzblJ = null;
    private boolean zzblK = false;
    private int zzblL = 0;
    private boolean zzblM = false;
    private boolean zzblN = false;
    private int zzblO = -1;
    private TaskId[] zzblP;

    public Builder addTaskListId(int paramInt)
    {
      if (zzblF == null)
        zzblF = new ArrayList();
      zzblF.add(Integer.valueOf(paramInt));
      return this;
    }

    public LoadRemindersOptions build()
    {
      if (zzblP == null)
        return new LoadRemindersOptions(null, null, zzblF, zzblG, zzblH, zzblI, zzblJ, zzblK, zzblL, zzblM, zzblN, zzblO, zzbcq, mRecurrenceIds, null);
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      TaskId[] arrayOfTaskId = zzblP;
      int j = arrayOfTaskId.length;
      int i = 0;
      while (i < j)
      {
        localArrayList2.add(arrayOfTaskId[i].getClientAssignedId());
        i += 1;
      }
      return new LoadRemindersOptions(localArrayList1, localArrayList2, zzblF, zzblG, zzblH, zzblI, zzblJ, zzblK, zzblL, zzblM, zzblN, zzblO, zzbcq, mRecurrenceIds, null);
    }

    public Builder setCollapseMode(int paramInt)
    {
      if ((paramInt >= 0) && (paramInt <= 3));
      for (boolean bool = true; ; bool = false)
      {
        zzv.zzS(bool);
        zzblL = paramInt;
        return this;
      }
    }

    public Builder setDueDateAfter(Long paramLong)
    {
      zzblG = paramLong;
      return this;
    }

    public Builder setDueDateBefore(Long paramLong)
    {
      zzblH = paramLong;
      return this;
    }

    public Builder setIncludeArchived(boolean paramBoolean)
    {
      zzblK = paramBoolean;
      return this;
    }

    public Builder setLoadReminderType(int[] paramArrayOfInt)
    {
      zzv.zzb(paramArrayOfInt, " The types should not be null");
      boolean bool;
      int i;
      label32: int k;
      if (paramArrayOfInt.length != 0)
      {
        bool = true;
        zzv.zzb(bool, "The types should not be empty");
        zzblO = 0;
        int j = paramArrayOfInt.length;
        i = 0;
        if (i >= j)
          break label139;
        k = paramArrayOfInt[i];
        if ((k != -1) && (k != 0) && (k != 1) && (k != 2))
          break label117;
        bool = true;
        label68: zzv.zzb(bool, "Invalid load reminder type:" + k);
        if (k != -1)
          break label123;
      }
      label117: label123: for (zzblO = -1; ; zzblO |= 1 << k)
      {
        i += 1;
        break label32;
        bool = false;
        break;
        bool = false;
        break label68;
      }
      label139: return this;
    }

    public Builder setRecurrenceIds(List<String> paramList)
    {
      mRecurrenceIds = paramList;
      return this;
    }

    public Builder setTaskIds(TaskId[] paramArrayOfTaskId)
    {
      zzblP = paramArrayOfTaskId;
      int j = paramArrayOfTaskId.length;
      int i = 0;
      if (i < j)
      {
        TaskId localTaskId = paramArrayOfTaskId[i];
        zzv.zzb(localTaskId, "Cannot pass in null taskId");
        if (!TextUtils.isEmpty(localTaskId.getClientAssignedId()));
        for (boolean bool = true; ; bool = false)
        {
          zzv.zzb(bool, "Cannot pass in empty client assigned id");
          i += 1;
          break;
        }
      }
      return this;
    }
  }
}