package com.google.android.keep.notification;

import com.google.android.gms.reminders.model.Task;
import java.util.List;

public abstract interface d
{
  public abstract void b(long paramLong, Task paramTask);

  public abstract void bA(int paramInt);

  public abstract void bB(int paramInt);

  public abstract void p(List<Task> paramList);

  public abstract void refresh();
}